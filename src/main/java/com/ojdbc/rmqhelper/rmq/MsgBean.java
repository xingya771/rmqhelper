package com.ojdbc.rmqhelper.rmq;

import com.ojdbc.rmqhelper.ui.MainFrame;
import java.io.UnsupportedEncodingException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Arthur
 */
public class MsgBean {

    private String routingKey;
    private byte[] body;

    public MsgBean(String routingKey, byte[] body) {
        this.routingKey = routingKey;
        this.body = body;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public String getBody() {
        if (MainFrame.isText) {
            try {
                return new String(body, "UTF-8");
            } catch (UnsupportedEncodingException ex) {
            }
        } else {
            StringBuffer sb = new StringBuffer();
            for (byte b : body) {
                sb.append(b).append(",");
            }
            return sb.substring(0, sb.length() - 1);
        }
        return "";
    }

    public void setBody(byte[] body) {
        this.body = body;
    }


}
