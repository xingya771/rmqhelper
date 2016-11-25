package com.ojdbc.rmqhelper.rmq;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.rabbitmq.client.ConnectionFactory;
import java.io.Serializable;
import java.nio.file.Path;

/**
 *
 * @author Arthur
 */
public class Helper implements Serializable {

    private static final long serialVersionUID = -7459766181402937074L;

    private static String ip;
    private static int port;
    private static String userName;
    private static String password;
    private static String queueName;
    private static String exchangeName;
    private static String exchangeType;
    private static String routerKey;
    private static String sRouterKey;
    public static ConnectionFactory factory;
    private static String sExchangeName;
    private static String sExchangeType;

    public static synchronized ConnectionFactory getConnectionFactory() {
        //Create a connection factory
        if (factory != null) {
            return factory;
        }
        factory = new ConnectionFactory();
        factory.setHost(ip);
        factory.setPort(port);
        factory.setUsername(userName);
        factory.setPassword(password);
        return factory;
    }

    public static String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        Helper.ip = ip;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        Helper.port = port;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        Helper.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Helper.password = password;
    }

    public static String getQueueName() {
        return queueName;
    }

    public static void setQueueName(String queueName) {
        Helper.queueName = queueName;
    }

    public static String getExchangeName() {
        return exchangeName;
    }

    public static void setExchangeName(String exchangeName) {
        Helper.exchangeName = exchangeName;
    }

    public static String getRouterKey() {
        return routerKey;
    }

    public static void setRouterKey(String routerKey) {
        Helper.routerKey = routerKey;
    }

    public static String getExchangeType() {
        return exchangeType;
    }

    public static void setExchangeType(String exchangeType) {
        Helper.exchangeType = exchangeType;
    }

    public static String getsRouterKey() {
        return sRouterKey;
    }

    public static void setsRouterKey(String sRouterKey) {
        Helper.sRouterKey = sRouterKey;
    }

    public static String getsExchangeName() {
        return sExchangeName;
    }

    public static void setsExchangeName(String sExchangeName) {
        Helper.sExchangeName = sExchangeName;
    }

    public static String getsExchangeType() {
        return sExchangeType;
    }

    public static void setsExchangeType(String sExchangeType) {
        Helper.sExchangeType = sExchangeType;
    }
    
}
