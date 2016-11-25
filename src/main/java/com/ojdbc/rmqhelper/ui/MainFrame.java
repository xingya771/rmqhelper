/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ojdbc.rmqhelper.ui;

import com.ojdbc.rmqhelper.rmq.DefaultConsumer;
import com.ojdbc.rmqhelper.rmq.Helper;
import com.ojdbc.rmqhelper.rmq.MsgBean;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.JTextComponent;
import sun.tools.jar.resources.jar;

/**
 *
 * @author Arthur
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        ipJTF = new javax.swing.JTextField();
        userNameJTF = new javax.swing.JTextField();
        passwdJTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        exchangeNameJTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        routingKeyJTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        msgTable = new javax.swing.JTable();
        beginlistenBT = new javax.swing.JButton();
        exchangeTypeItem = new javax.swing.JComboBox<>();
        textJRB = new javax.swing.JRadioButton();
        bytesJRB = new javax.swing.JRadioButton();
        clearBN = new javax.swing.JButton();
        portJSP = new javax.swing.JSpinner();
        sendContentBt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RMQHelper");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                onClose(evt);
            }
        });

        jLabel1.setText(":");

        ipJTF.setText("127.0.0.1");

        userNameJTF.setText("test");

        passwdJTF.setText("test");

        jLabel2.setText("@");

        jLabel3.setText(":");

        jLabel4.setText("ExchangeName");

        exchangeNameJTF.setText("test");

        jLabel5.setText("RoutingKey");

        routingKeyJTF.setText("#");

        jScrollPane1.setAutoscrolls(true);

        msgTable.setModel(tableModel);
        jScrollPane1.setViewportView(msgTable);

        beginlistenBT.setText("开始侦听");
        beginlistenBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                beginlistenBTMouseReleased(evt);
            }
        });

        exchangeTypeItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "direct", "topic", "fanout" }));

        buttonGroup1.add(textJRB);
        textJRB.setSelected(true);
        textJRB.setText("文本");
        textJRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textJRBActionPerformed(evt);
            }
        });

        buttonGroup1.add(bytesJRB);
        bytesJRB.setText("byte[]");
        bytesJRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bytesJRBActionPerformed(evt);
            }
        });

        clearBN.setText("清空");
        clearBN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                clearBNMouseReleased(evt);
            }
        });

        portJSP.setValue(5672);

        sendContentBt.setText("Send ...");
        sendContentBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                sendContentBtMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(userNameJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(passwdJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ipJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(exchangeNameJTF)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(routingKeyJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(portJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(textJRB)
                                    .addGap(18, 18, 18)
                                    .addComponent(bytesJRB)
                                    .addGap(51, 51, 51)
                                    .addComponent(clearBN)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sendContentBt))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(437, 437, 437)
                                    .addComponent(exchangeTypeItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(beginlistenBT, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ipJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userNameJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwdJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(portJSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(exchangeNameJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(routingKeyJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(beginlistenBT, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exchangeTypeItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textJRB)
                    .addComponent(bytesJRB)
                    .addComponent(clearBN)
                    .addComponent(sendContentBt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void beginlistenBTMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_beginlistenBTMouseReleased
        if (isStop) {
            DefaultConsumer.stop();
            checkFlag = false;
            beginlistenBT.setText("开始侦听");
            isStop = false;
        } else {
            beginListen();
            beginlistenBT.setText("停止侦听");

        }

    }//GEN-LAST:event_beginlistenBTMouseReleased

    private void clearBNMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBNMouseReleased
        msgList.clear();
        msgTable.setModel(new MsgTableModel(msgList));
    }//GEN-LAST:event_clearBNMouseReleased

    private void sendContentBtMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendContentBtMouseReleased
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SendMsg().setVisible(true);
            }
        });
    }//GEN-LAST:event_sendContentBtMouseReleased

    private void onClose(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_onClose
        runFlag = false;

        System.exit(0);
    }//GEN-LAST:event_onClose

    private void textJRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textJRBActionPerformed
        isText = true;
    }//GEN-LAST:event_textJRBActionPerformed

    private void bytesJRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bytesJRBActionPerformed
        isText = false;
    }//GEN-LAST:event_bytesJRBActionPerformed

    private void setKeyMask(JTextComponent jtf) {
        int MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        jtf.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_A, MASK), "select-all");
        jtf.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_C, MASK), "copy");
        jtf.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_X, MASK), "cut");
        jtf.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, MASK), "paste");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame main = new MainFrame();
                main.init();
                main.setVisible(true);

            }
        });
    }

    private void beginListen() {
        isStop = true;
        String ip = ipJTF.getText().trim();
        Object port = portJSP.getValue();
        String userName = userNameJTF.getText().trim();
        String passwd = passwdJTF.getText().trim();
        String exchangeName = exchangeNameJTF.getText();
        String routingKey = routingKeyJTF.getText().trim();

        if (exchangeName == null) {
            exchangeName = "";
        }
        Helper.setIp(ip);
        Helper.setPort((Integer) (port));
        Helper.setExchangeType(exchangeTypeItem.getSelectedItem().toString());

        Helper.setUserName(userName);
        Helper.setPassword(passwd);
        Helper.setExchangeName(exchangeName);
        Helper.setRouterKey(routingKey);
        Executors.newSingleThreadExecutor().execute(() -> {
            DefaultConsumer.init();
        });
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                DefaultConsumer.isStart.await();
            } catch (InterruptedException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (checkFlag) {
                if (!DefaultConsumer.checkConnect()) {
                    checkFlag = false;
                    beginlistenBT.setText("开始侦听");
                    isStop = false;
                }
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void check(String content, String who) {
        if (content != null && !"".equals(content)) {
            javax.swing.JOptionPane.showMessageDialog(null, who + "can not be null!");
        }

    }

    public void init() {

        tableModel.addColumn("seq");
        tableModel.addColumn("Routing Key");
        tableModel.addColumn("Msg");
        setCoWidth();
        Executors.newSingleThreadExecutor().execute(() -> {
            while (runFlag) {
                if (DefaultConsumer.msgQueue.size() == 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    continue;
                }
                MsgBean msg = DefaultConsumer.msgQueue.poll();
                msgList.add(msg);
                tableModel.addRow(new Object[]{msg.getSeq(), msg.getRoutingKey(), msg.getBody()});
                setCoWidth();
            }
        });

        Executors.newSingleThreadExecutor().execute(() -> {
            while (runFlag) {
                if (DefaultConsumer.logQueue.size() == 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    continue;
                }
                String obj = DefaultConsumer.logQueue.poll();
                JOptionPane.showMessageDialog(this, obj);

            }
        });

        setKeyMask(ipJTF);
        setKeyMask(passwdJTF);
        setKeyMask(routingKeyJTF);
        setKeyMask(userNameJTF);
        setKeyMask(exchangeNameJTF);

    }

    private void setCoWidth() {
        msgTable.getColumnModel().getColumn(0).setMaxWidth(100);
        msgTable.getColumnModel().getColumn(1).setPreferredWidth(300);
        msgTable.getColumnModel().getColumn(2).setPreferredWidth(600);

    }

    private List<MsgBean> msgList = new java.util.concurrent.CopyOnWriteArrayList<>();
    private boolean checkFlag = true;
    private boolean runFlag = true;
    private boolean isStop = false;
    public static boolean isText = true;
    DefaultTableModel tableModel = new DefaultTableModel();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton beginlistenBT;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton bytesJRB;
    private javax.swing.JButton clearBN;
    private javax.swing.JTextField exchangeNameJTF;
    private javax.swing.JComboBox<String> exchangeTypeItem;
    private javax.swing.JTextField ipJTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable msgTable;
    private javax.swing.JTextField passwdJTF;
    private javax.swing.JSpinner portJSP;
    private javax.swing.JTextField routingKeyJTF;
    private javax.swing.JButton sendContentBt;
    private javax.swing.JRadioButton textJRB;
    private javax.swing.JTextField userNameJTF;
    // End of variables declaration//GEN-END:variables
}