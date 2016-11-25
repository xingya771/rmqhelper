/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ojdbc.rmqhelper.ui;

import com.ojdbc.rmqhelper.rmq.MsgBean;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Arthur
 */
public class MsgTableModel implements TableModel {

    List<MsgBean> rows = new ArrayList<>();

    public MsgTableModel(List<MsgBean> rows) {
        this.rows = rows;
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "seq";
            case 1:
                return "Routing Key";
            case 2:
                return "msg";
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex > 0) {
            return String.class;
        } else {
            return Long.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex > rows.size() - 1) {
            return null;
        }
        MsgBean bean = rows.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return bean.getSeq();
            case 1:
                return bean.getRoutingKey();
            case 2:
                return bean.getBody();
            default:
                return "";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }

    public List<MsgBean> getRows() {
        return rows;
    }

    public void setRows(List<MsgBean> rows) {
        this.rows = rows;
    }
    
    public void addRow(MsgBean bean){
        this.rows.add(bean);
    }

}
