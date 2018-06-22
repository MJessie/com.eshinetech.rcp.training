package com.eshinetech.training.jface.dialog;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import utils.ShellBack;
import utils.UiUtils;

/**
 * class  desc：
 * @author WuChengRui  
 * @date 2018-6-12  
 */
public class Demo4Dialog extends Dialog{

    public Demo4Dialog(Shell parentShell) {
        super(parentShell);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        //一般不会直接在parent创建子控件，因为parent还包含了buttonBar的面板
//        Composite content = new Composite(parent, SWT.BORDER);
//        content.setLayoutData(new GridData(GridData.FILL_BOTH));
//        content.setLayout(new FillLayout());
//        Button btn = new Button(content, SWT.PUSH);
//        btn.setText("button");
        return parent;
    }

    @Override
    protected void configureShell(Shell newShell) {
        newShell.setSize(500, 400);
        newShell.setText("这是个标题");
        super.configureShell(newShell);
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.jface.dialogs.Dialog#buttonPressed(int)
     */
    @Override
    protected void buttonPressed(int buttonId) {
        
        super.buttonPressed(buttonId);
        if(buttonId == 0){
            System.out.println("ok");
        }
    }

    public static void main(String[] args) {
        UiUtils.createSwt(new ShellBack() {
            
            @Override
            public void callBack(Shell shell) {
                final Button btn = new Button(shell, SWT.PUSH);
                btn.setText("dian ji");
                btn.addSelectionListener(new SelectionListener() {
                    
                    @Override
                    public void widgetSelected(SelectionEvent e) {
//                        new Demo4Dialog(btn.getShell()).open();
                        MessageDialog.openError(null, "title", "desc");
                    }
                    
                    @Override
                    public void widgetDefaultSelected(SelectionEvent e) {
                    }
                });
            }
        });
    }
    
    
}
