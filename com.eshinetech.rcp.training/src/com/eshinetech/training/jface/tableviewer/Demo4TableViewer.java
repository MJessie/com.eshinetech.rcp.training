package com.eshinetech.training.jface.tableviewer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import utils.ShellBack;
import utils.UiUtils;

/**
 * @author WuChengRui
 * @date 2018-5-14
 * @desc tableviewer的提供者
 */
public class Demo4TableViewer {

    public static void main(String[] args) {
        UiUtils.createSwt(new ShellBack() {

            @Override
            public void callBack(Shell shell) {
                shell.setSize(500, 400);
                // 生成测试数据
                List<SimpleBean> list = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    SimpleBean bean = new SimpleBean();
                    bean.setId("id_" + i);
                    bean.setAirCode("airCode_" + i);
                    bean.setAirStart("airStart_" + i);
                    bean.setAirEnd("airEnd_" + i);
                    list.add(bean);
                }
                // 生成列头
                String[] headers = new String[] { "id列", "airCode列", "airStart列", "airEnd列" };

                // 1.定义一个TableViewer对象. 同时在构造方法中定义其式样. 这里设置成可以多选(SWT.MULTI),
                // 可以整行选择(SWT.FULL_SELECTION)
                TableViewer tableviewer = new TableViewer(shell, SWT.H_SCROLL | SWT.BORDER 
                        | SWT.FULL_SELECTION | SWT.V_SCROLL);
                Table table = tableviewer.getTable();
                table.setHeaderVisible(true);// 设置标头
                table.setLinesVisible(true);// 显示表格线

                // 2.建立TableViewer中的列
                TableLayout tLayout = new TableLayout();// 专用于表格的布局
                tableviewer.getTable().setLayout(tLayout);
                for (int i = 0; i < headers.length; i++) {
                    String header = headers[i];
                    tLayout.addColumnData(new ColumnWeightData(80));// 这个是设置ID列的列宽为80像素
                    new TableColumn(tableviewer.getTable(), SWT.NONE).setText(header);
                }
                // 4.设定内容器,一般都不用修改这个类
                tableviewer.setContentProvider(new CommonTableViewerContentProvider());
                // 5.设定标签器
                tableviewer.setLabelProvider(new SimpleLabelProvider());
                // 6.设置显示列数据
                tableviewer.setInput(list);

            }
        });
    }

}
