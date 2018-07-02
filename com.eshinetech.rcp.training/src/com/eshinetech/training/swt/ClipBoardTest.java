/**
 * 
 */
package com.eshinetech.training.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.events.MenuAdapter;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import utils.ShellBack;
import utils.UiUtils;


/**
 * @author Administrator
 *
 * 2014年8月23日
 */
public class ClipBoardTest {

	protected Shell shell;
	private Clipboard cb;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		UiUtils.createSwt(new ShellBack() {
			
			@Override
			public void callBack(Shell shell) {
				ClipBoardTest test = new ClipBoardTest();
				test.shell = shell;
				test.cb = new Clipboard(shell.getDisplay());
				test.createContents();
				
			}
		});
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		final Text content = new Text(shell,SWT.BORDER|SWT.MULTI|SWT.WRAP);
		Menu menu = new Menu(shell,SWT.POP_UP);
		final MenuItem copyItem = new MenuItem(menu, SWT.PUSH);
		copyItem.setText("复制");
		copyItem.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				String selection = content.getSelectionText();
				if(selection.length() == 0)return;
				Object[] data = new Object[]{selection};
				Transfer[] types = new Transfer[]{TextTransfer.getInstance()};
				cb.setContents(data, types);
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		final MenuItem pasteItem = new MenuItem(menu,SWT.PUSH);
		pasteItem.setText("黏贴");
		pasteItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String string = (String) (cb.getContents(TextTransfer.getInstance()));
				if(string != null){
					content.insert(string);
				}
				
			}
		});

		final MenuItem clearItem = new MenuItem(menu,SWT.PUSH);
		clearItem.setText("清除clipBoard");
		clearItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cb.clearContents();
				
			}
		});
		
		menu.addMenuListener(new MenuAdapter() {
			public void menuShown(MenuEvent e){
				String selection = content.getSelectionText();
				copyItem.setEnabled(selection.length()>0);
				TransferData[] available = cb.getAvailableTypes();
				boolean enabled = false;
				for(int i = 0;i<available.length;i++){
					if(TextTransfer.getInstance().isSupportedType(available[i])){
						enabled = true;
						break;
					}
				}
				pasteItem.setEnabled(enabled);
			}
		});
		
		content.setMenu(menu);
	}

}
