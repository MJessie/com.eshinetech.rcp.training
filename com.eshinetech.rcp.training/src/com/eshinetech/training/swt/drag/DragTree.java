/**
 * 
 */
package com.eshinetech.training.swt.drag;

import java.io.File;

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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import utils.ShellBack;
import utils.UiUtils;

/**
 * @author Administrator
 *
 * 2014å¹?8æœ?22æ—?
 */
public class DragTree {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		UiUtils.createSwt(new ShellBack() {
			
			@Override
			public void callBack(Shell shell) {
				DragTree drag = new DragTree();
				drag.shell = shell;
				drag.createContents();
				
			}
		});
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		final Tree tree = CreateFolderTree(shell);
		DragSource dragSource = new DragSource(tree, DND.DROP_MOVE|DND.DROP_COPY);
		dragSource.setTransfer(new Transfer[]{TextTransfer.getInstance()});
		dragSource.addDragListener(new DragSourceListener() {
			
			@Override
			public void dragStart(DragSourceEvent event) {
				if(tree.getSelectionCount() == 0)
					event.doit = false;
				
			}
			
			@Override
			public void dragSetData(DragSourceEvent event) {
				if(TextTransfer.getInstance().isSupportedType(event.dataType)){
					event.data = tree.getSelection()[0].getText(0);
				}
				
			}
			
			@Override
			public void dragFinished(DragSourceEvent event) {
				if(event.detail == DND.DROP_MOVE){
					TreeItem t = tree.getSelection()[0];
					int index = tree.indexOf(t);
					if(index>-1){
						t.dispose();
						tree.deselect(t);
						
					}
				}
				
			}
		});
		
		DropTarget dropTarget = new DropTarget(tree, DND.DROP_MOVE|DND.DROP_DEFAULT|DND.DROP_COPY);
		dropTarget.setTransfer(new Transfer[]{TextTransfer.getInstance()});
		dropTarget.addDropListener(new DropTargetListener() {
			
			@Override
			public void dropAccept(DropTargetEvent event) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drop(DropTargetEvent event) {
				if(event.item == null)return;
				TreeItem eventItem = (TreeItem) event.item;
				if(TextTransfer.getInstance().isSupportedType(event.currentDataType)){
					String s = event.data.toString();
					TreeItem newItem = null;
					if(eventItem.getParentItem() == null){
						newItem = new TreeItem(eventItem.getParent(), SWT.None);
						
					}else{
						newItem = new TreeItem(eventItem.getParentItem(), 0);
						
					}
					newItem.setText(s);
				}
				
			}
			
			@Override
			public void dragOver(DropTargetEvent event) {
				event.feedback = DND.FEEDBACK_EXPAND|DND.FEEDBACK_SELECT;
				
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
	
	private static Tree CreateFolderTree(Composite parent){
		Tree tree = new Tree(parent,SWT.BORDER|SWT.SINGLE);
		File root = new File("D:\\core_work\\git");
		File[] files = root.listFiles();
		for(int i = 0;i<files.length;i++){
			TreeItem item = new TreeItem(tree, SWT.None);
			item.setText(files[i].getName()+"");
			if(files[i].isDirectory()){
				setDirectory(files[i],item);
			}
		}
		return tree;
	}
	
	
	private static void setDirectory(File file,TreeItem parent){
		File[] files = file.listFiles();
		for(int i = 0;i<files.length;i++){
			TreeItem item = new TreeItem(parent, SWT.None);
			item.setText(files[i].getName()+"");
			if(files[i].isDirectory()){
				setDirectory(files[i], item);
			}
		}
		
	}
	

}
