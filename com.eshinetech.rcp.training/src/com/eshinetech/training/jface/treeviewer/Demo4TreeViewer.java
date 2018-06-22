package com.eshinetech.training.jface.treeviewer;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TreeItem;

import com.eshinetech.training.jface.treeviewer.provider.ITreeFace;
import com.eshinetech.training.jface.treeviewer.provider.TreeContentProvider;
import com.eshinetech.training.jface.treeviewer.provider.TreeLabelProvider;

import utils.ShellBack;
import utils.UiUtils;

/**
 * class  desc：
 * @author WuChengRui  
 * @date 2018-6-21  
 */
public class Demo4TreeViewer {
    public static void main(String[] args) {
        UiUtils.createSwt(new ShellBack() {
            
            @Override
            public void callBack(Shell shell) {
                final TreeViewer treeViewer = new TreeViewer(shell, SWT.BORDER|SWT.H_SCROLL);
//              treeViewer.getTree().setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
//              tree.setBounds(83, 75, 264, 185);
                treeViewer.getTree().addSelectionListener(new SelectionListener() {
                    
                    @Override
                    public void widgetSelected(SelectionEvent e) {
                        TreeItem item = (TreeItem) e.item;
                        
                        System.out.println(((ITreeFace)item.getData()).getId());
                    }
                    
                    @Override
                    public void widgetDefaultSelected(SelectionEvent e) {
                        // TODO Auto-generated method stub
                        
                    }
                });
                
                
                treeViewer.setLabelProvider(new TreeLabelProvider());
                treeViewer.setContentProvider(new TreeContentProvider());
                treeViewer.setInput(BeanFactory.createTree());
                
                
            }
        });
    }
}
