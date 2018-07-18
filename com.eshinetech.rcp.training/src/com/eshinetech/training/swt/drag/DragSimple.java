/**
 * 
 */
package com.eshinetech.training.swt.drag;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import utils.ShellBack;
import utils.UiUtils;

/**
 * @author Administrator
 *
 * 2014年8月22日
 */
public class DragSimple {

    protected Shell shell;

    /**
     * Launch the application.
     * @param args
     */
    public static void main(String[] args) {
        UiUtils.createSwt(new ShellBack() {
            
            @Override
            public void callBack(Shell shell) {
                DragSimple drag = new DragSimple();
                drag.shell = shell;
                drag.createContents();
                
            }
        });
    }

    /**
     * Open the window.
     */
    public void open() {
        Display display = Display.getDefault();
        createContents();
        shell.open();
        shell.layout();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    /**
     * Create contents of the window.
     */
    protected void createContents() {
        
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        shell.setLayout(layout);
        final Table productList = createProductTable(shell);
        final Table shoppingCart = createCartTable(shell);
        DragSource source = new DragSource(productList, DND.DROP_MOVE|DND.DROP_COPY);
        source.setTransfer(new Transfer[]{TextTransfer.getInstance()});
        source.addDragListener(new DragSourceListener() {
            
            @Override
            public void dragStart(DragSourceEvent event) {
                if(productList.getSelectionCount() ==0){
                    event.doit = false;
                }
                
            }
            /**设置要传播的值*/
            @Override
            public void dragSetData(DragSourceEvent event) {
                if(TextTransfer.getInstance().isSupportedType(event.dataType)){
                    TableItem item = productList.getSelection()[0];
                    event.data = item.getText(0)+","+item.getText(2);
                    
                }
            }
            
            @Override
            public void dragFinished(DragSourceEvent event) {
                // TODO Auto-generated method stub
                
            }
        });
        DropTarget target = new DropTarget(shoppingCart, DND.DROP_COPY|DND.DROP_DEFAULT);
        target.setTransfer(new Transfer[]{TextTransfer.getInstance()});
        target.addDropListener(new DropTargetListener() {
            
            @Override
            public void dropAccept(DropTargetEvent event) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void drop(DropTargetEvent event) {
                TableItem item = (TableItem)event.item;//被碰撞的item,如果要获取drag的item需要用传播的data去找回
                if(item == null){
                    event.detail = DND.DROP_NONE;
                    return;
                }
                if(TextTransfer.getInstance().isSupportedType(event.currentDataType)){
                    String dataInfo = event.data.toString();
                    if(dataInfo == null)return;
                    int index = dataInfo.indexOf(",");
                    String name = dataInfo.substring(0, index);
                    double price = 0.00d;
                    try{
                        price = Double.parseDouble(dataInfo.substring(index + 1));
                        
                    }catch(Exception e){
                        price = 0.00d;
                    }
                    Table parent = item.getParent();
                    TableItem it = null;
                    for(int i = 0;i<parent.getItemCount();i++){//查找在table中是否已经存在了这一个item
                        TableItem temp = parent.getItem(i);
                        if(temp.getText(0).equals(name)){
                            it = temp;
                            break;
                        }
                    }
                    if(it == null){//不存在，则创建
                        it = new TableItem(parent, SWT.None );
                        it.setText(0,name);
                        it.setText(1,"1");
                        it.setText(2,""+price);
                    }else{
                        int number = Integer.parseInt(it.getText(1))+1;
                        double total = number * price;
                        it.setText(1,""+number);
                        it.setText(2,""+total);
                    }
                    TableItem sumiItem = parent.getItem(0);
                    sumiItem.setText(0,"总数");
                    sumiItem.setText(1,Integer.parseInt(sumiItem.getText(1))+1+"");
                    sumiItem.setText(2,Double.parseDouble(sumiItem.getText(2))+price+"");
                }
                
            }
            
            @Override
            public void dragOver(DropTargetEvent event) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void dragOperationChanged(DropTargetEvent event) {
                if(event.detail == DND.DROP_DEFAULT){
                    event.detail = DND.DROP_COPY;
                }
                
            }
            
            @Override
            public void dragLeave(DropTargetEvent event) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void dragEnter(DropTargetEvent event) {
                if(event.detail == DND.DROP_DEFAULT){
                    event.detail = DND.DROP_COPY;
                }
            }
        });
    }

    public static Table createProductTable(Composite parent){
        Table table = new Table(parent,SWT.FULL_SELECTION|SWT.SINGLE);
        String[] heads = {"产品名称","单位","价格"};
        for(int i = 0;i<heads.length;i++){
            TableColumn col = new TableColumn(table, SWT.None);
            col.setText(heads[i]);
            
        }
        TableItem  item1 = new TableItem(table, 0);
        item1.setText(new String[]{"cpu","个","12000"});
        TableItem  item2 = new TableItem(table, 0);
        item2.setText(new String[]{"内存","个","120"});
        TableItem  item3 = new TableItem(table, 0);
        item3.setText(new String[]{"笔记本","个","5500"});
        table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        for(int i = 0;i<heads.length;i++){
            table.getColumns()[i].pack();
        }
        return table;
    }
    
    public static Table createCartTable(Composite parent){
        Table table = new Table(parent, SWT.FULL_SELECTION);
        String[] heads = {"产品","个","总价"};
        for(int i = 0;i<heads.length;i++){
            TableColumn col = new TableColumn(table, SWT.NONE);
            col.setText(heads[i]);
        }
        TableItem item = new TableItem(table, 0);
        item.setText(new String[]{"","0","0"});
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        for(int i = 0;i<heads.length;i++){
            table.getColumns()[i].pack();
        }
        return table;
    }
    
    
}
