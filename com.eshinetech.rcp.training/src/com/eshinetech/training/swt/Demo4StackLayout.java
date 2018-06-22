package com.eshinetech.training.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;

import utils.ShellBack;
import utils.UiUtils;

/**
 * class  desc：
 * @author WuChengRui  
 * @date 2018-6-21  
 */
public class Demo4StackLayout {
    public static void main(String[] args) {
        UiUtils.createSwt(new ShellBack() {
            
            @Override
            public void callBack(final Shell shell) {
                final Button btn = new Button(shell, SWT.PUSH);
                btn.setText("btn");
                
                final Button btn2 = new Button(shell, SWT.CHECK);
                btn2.setText("btn2");
                
                final StackLayout sl = new StackLayout();
                shell.setLayout(sl);
                sl.topControl = btn;

                //点击按钮切换
                btn.addSelectionListener(new SelectionAdapter() {
                    
                    @Override
                    public void widgetSelected(SelectionEvent e) {
                        sl.topControl = btn2;
                        shell.layout();
                    }
                });
                
                btn2.addSelectionListener(new SelectionAdapter() {
                    
                    @Override
                    public void widgetSelected(SelectionEvent e) {
                        sl.topControl = btn;
                        shell.layout();
                    }
                });
            }
        });
    }

}
