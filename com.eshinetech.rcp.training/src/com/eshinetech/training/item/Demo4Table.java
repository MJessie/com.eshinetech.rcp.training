package com.eshinetech.training.item;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import utils.ShellBack;
import utils.UiUtils;

/**
 * class desc：
 * 
 * @author WuChengRui
 * @date 2018-6-6
 */
public class Demo4Table {

    public static void main(String[] args) {
        UiUtils.createSwt(new ShellBack() {

            @Override
            public void callBack(Shell shell) {
                Table table = new Table(shell, SWT.MULTI | SWT.FULL_SELECTION | SWT.CHECK);
                table.setHeaderVisible(true);// 设置显示表头
                table.setLinesVisible(true);// 设置显示表格线/*
                // 创建表头的字符串数组
                String[] tableHeader = { "姓名", "性别", "电话", "电子邮件" };
                for (int i = 0; i < tableHeader.length; i++) {
                    // 设置列头
                    TableColumn tableColumn = new TableColumn(table, SWT.NONE);
                    tableColumn.setText(tableHeader[i]);
                    // 设置表头可移动，默认为false
                    tableColumn.setMoveable(true);
                    // 如果不调用pack，则要设置宽度
                    tableColumn.pack();
                }
                // 添加1行数据
                TableItem item = new TableItem(table, SWT.NONE);
                item.setText(new String[] { "张三", "男", "123", "" });
                // 设置图标
                item.setImage(new Image(null, "F:\\java_code\\indigo_rcp" +
                		"\\com.eshinetech.training\\icons\\logo.gif"));

                for (int i = 0; i < 5; i++) {
                    item = new TableItem(table, SWT.NONE);
                    item.setText(new String[] { "李四", "男", "4582", "" });
                }
            }
        });
    }

}
