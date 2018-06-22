package com.eshinetech.training.jface.wizard;

import org.eclipse.jface.window.ApplicationWindow;  
import org.eclipse.jface.wizard.WizardDialog;  
import org.eclipse.swt.SWT;  
import org.eclipse.swt.events.SelectionAdapter;  
import org.eclipse.swt.events.SelectionEvent;  
import org.eclipse.swt.layout.RowLayout;  
import org.eclipse.swt.widgets.Button;  
import org.eclipse.swt.widgets.Composite;  
import org.eclipse.swt.widgets.Control;  
import org.eclipse.swt.widgets.Display;  
  
  
public class Demo4Wizard extends ApplicationWindow{  
    public Demo4Wizard(){  
        super(null);  
    }  
      
    protected Control createContents(Composite parent){  
        parent.setLayout(new RowLayout(SWT.VERTICAL));  
        Button button  = new Button(parent, SWT.NONE);  
        button.setText("打开简单向导对话框");  
        button.addSelectionListener(new SelectionAdapter(){  
            public void widgetSelected(SelectionEvent e){  
                //建立并打开打开向导对话框，该对话框使用了 BookSurveyWizard 向导  
                WizardDialog dlg = new WizardDialog(Display.getCurrent().getActiveShell(),  
                        new BookSurveyWizard());  
                dlg.open();  
            }  
        });  
        return parent;  
    }  
      
    public static void main(String[] args){  
        Demo4Wizard test = new Demo4Wizard();  
        test.setBlockOnOpen(true);  
        test.open();  
        Display.getCurrent().dispose();  
    }  
} 
