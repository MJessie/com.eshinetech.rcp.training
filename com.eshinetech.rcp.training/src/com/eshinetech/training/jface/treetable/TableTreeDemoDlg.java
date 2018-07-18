package com.eshinetech.training.jface.treetable;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.TableTreeViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.CellEditor.LayoutData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import utils.ShellBack;
import utils.UiUtils;

/**
 * class  desc：
 * @author WuChengRui  
 * @date 2018-7-18  
 */
public class TableTreeDemoDlg  {


    
    private List  tableTreeViewInputList = new ArrayList();
    private TableTreeViewer tableTreeViewer;
   

    /**
     * Create contents of the dialog.
     */
    private void createContents(Shell shlSwt) {
        
        shlSwt.setLayout(new GridLayout(2,false));
        
        final TreeViewer treeViewer = new TreeViewer(shlSwt, SWT.BORDER);
        Tree treeView = treeViewer.getTree();
        treeViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        
        List dataList = DataFactory.getList();
        tableTreeViewer = new TableTreeViewer(shlSwt, SWT.BORDER | SWT.FULL_SELECTION);
        tableTreeViewer.setContentProvider(new TableViewContentProvider());
        tableTreeViewer.setLabelProvider(new TableViewLabelProvider());
        
        tableTreeViewer.setInput(tableTreeViewInputList);
        
        treeViewer.setContentProvider(new TreeViewerContentProvider());
        treeViewer.setLabelProvider(new TreeViewerLabelProvider());
        treeViewer.setInput(dataList);
        
        treeViewer.getTree().addSelectionListener(new SelectionAdapter(){
            
            public void widgetSelected(SelectionEvent e) {
                
                
                TreeItem[] selected = treeViewer.getTree().getSelection();
                
                Object obj = selected[0].getData();
                
                tableTreeViewInputList.clear();
                tableTreeViewInputList.add(obj);
                
                tableTreeViewer.refresh();  
            }
        }
        );
       
        TableTree tableTreeView = tableTreeViewer.getTableTree();
        tableTreeView.getTable().setLinesVisible(true);
        tableTreeView.getTable().setHeaderVisible(true);
        tableTreeView.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));
        tableTreeView.setBounds(240, 10, 458, 421);
        
        TableColumn tblclmnNewColumn = new TableColumn(tableTreeView.getTable(), SWT.CENTER);
        tblclmnNewColumn.setWidth(90);
        tblclmnNewColumn.setText("University");
        
        TableColumn tblCollage = new TableColumn(tableTreeView.getTable(), SWT.CENTER);
        tblCollage.setWidth(114);
        tblCollage.setText("Collage");
        
        TableColumn tblClass = new TableColumn(tableTreeView.getTable(), SWT.CENTER);
        tblClass.setWidth(112);
        tblClass.setText("Class");
        
        TableColumn tblStuNo = new TableColumn(tableTreeView.getTable(), SWT.CENTER);
        tblStuNo.setText("StuNo");
        tblStuNo.setWidth(138);
    }
    
    public static void main(String[] args) {
        UiUtils.createSwt(new ShellBack() {
            
            @Override
            public void callBack(Shell shell) {
                new TableTreeDemoDlg().createContents(shell);
            }
        });
    }
    
}