package com.ojdbc.rmqhelper.rmq;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.ojdbc.util.StackUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author Arthur
 */
public class DefaultConsumer {

    private static Channel channel;
    private static Connection connection;
    public static ConcurrentLinkedQueue<MsgBean> msgQueue = new ConcurrentLinkedQueue<>();
    public static ConcurrentLinkedQueue<String> logQueue = new ConcurrentLinkedQueue<>();
    public static CountDownLatch isStart = new CountDownLatch(1);
    public static void init() {
        isStart = new CountDownLatch(1);
        connect();
        isStart.countDown();
    }
    
   

    public static void connect() {
        try {
            connection = Helper.getConnectionFactory().newConnection();
            channel = connection.createChannel();
            channel.exchangeDeclare(Helper.getExchangeName(), Helper.getExchangeType());
            String queueName = channel.queueDeclare().getQueue();
            channel.queueBind(queueName, Helper.getExchangeName(), Helper.getRouterKey());
            channel.basicConsume(queueName, true, new MyConsumer());
        } catch (Exception e) {
            logQueue.add(StackUtil.getStackTrace(e));
            e.printStackTrace();
        }
    }

    public static boolean checkConnect() {
        if (connection == null || !connection.isOpen() || channel == null || !channel.isOpen()) {
           return false;
        }else{
            return true;
        }
    }

    public static void stop() {
        try {
            if (channel != null) {
                channel.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (IOException ex) {
            logQueue.add(StackUtil.getStackTrace(ex));

        } catch (TimeoutException ex) {
            logQueue.add(StackUtil.getStackTrace(ex));
        } catch (Exception ex) {
            logQueue.add(StackUtil.getStackTrace(ex));

        }
    }

    public static void handlerMsg(String routingKey,byte[] body) throws IOException {
        msgQueue.add(new MsgBean(routingKey, body));
    }

    private static class MyConsumer implements Consumer {

        @Override
        public void handleConsumeOk(String consumerTag) {

        }

        @Override
        public void handleCancelOk(String consumerTag) {

        }

        @Override
        public void handleCancel(String consumerTag) throws IOException {

        }

        @Override
        public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {
        }

        @Override
        public void handleRecoverOk(String consumerTag) {

        }

        @Override
        public void handleDelivery(String consumerTag, Envelope env, AMQP.BasicProperties properties, byte[] body) throws IOException {
            handlerMsg(env.getRoutingKey(),body);
        }
    }
}
