package com.ojdbc.rmqhelper.rmq;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.ojdbc.util.StackUtil;
import static com.ojdbc.rmqhelper.rmq.DefaultConsumer.logQueue;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import java.io.IOException;

/**
 *
 * @author Arthur
 */
public class Sender {

    private static Channel channel;
    private static Connection connection;

    public static void init() {

        try {
            connection = Helper.getConnectionFactory().newConnection();
            channel = connection.createChannel();
            if (Helper.getsExchangeName().length()>0) {
                channel.exchangeDeclare(Helper.getsExchangeName(), Helper.getsExchangeType());
                String queueName = channel.queueDeclare().getQueue();
                channel.queueBind(queueName, Helper.getsExchangeName(), Helper.getsRouterKey());
            }
        } catch (Exception e) {
            logQueue.add(StackUtil.getStackTrace(e));

        }
    }

    public static void sendMsg(byte[] msg) {
        if (connection == null || !connection.isOpen() || channel == null || !channel.isOpen()) {
            init();
        }
        try {
            channel.basicPublish(Helper.getsExchangeName(), Helper.getsRouterKey(), null, msg);
        } catch (IOException ex) {
            logQueue.add(StackUtil.getStackTrace(ex));
        }
    }
}
