package com.eshinetech.training.item;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Region;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import utils.ShellBack;
import utils.UiUtils;

/**
 * class desc：
 * 
 * @author WuChengRui
 * @date 2018-6-6
 */
public class Demo4TabFolder {
    public static void main(String[] args) {
        UiUtils.createSwt(new ShellBack() {

            @Override
            public void callBack(Shell shell) {
                // 新建选项卡容器
                CTabFolder tabFolder = new CTabFolder(shell, SWT.BORDER | SWT.Close |SWT.Move);
                // 设置布局
                tabFolder.setLayout(new FillLayout());
                // 设置最大化按钮可见，默认不可见
                tabFolder.setMaximizeVisible(true);
                
                // 设置最小化按钮不可见,默认不可见
                // tabFolder.setMinimizeVisible(false);
                // 设置是否为简单样式，简单样式，item是方形的
//                tabFolder.setSimple(false);
                // 设置item是否可关闭
                tabFolder.setUnselectedCloseVisible(true);
                // 创建一个item
                CTabItem item1 = new CTabItem(tabFolder, SWT.MULTI | SWT.V_SCROLL| SWT.Close |SWT.Move);
                item1.setShowClose(true);
                item1.setText("item1");
                Button btn1 = new Button(tabFolder, SWT.PUSH);
                btn1.setText("aaaa");
                // 控制这个btn
                item1.setControl(btn1);
                // 创建一个item
                CTabItem item2 = new CTabItem(tabFolder, SWT.MULTI | SWT.V_SCROLL|SWT.Move);
                item2.setText("item2");
                Button btn2 = new Button(tabFolder, SWT.PUSH);
                btn2.setText("2222");
                // 控制这个btn
                item2.setControl(btn2);

                // 设置默认选择
                tabFolder.setSelection(0);
            }
        });
    }

}
