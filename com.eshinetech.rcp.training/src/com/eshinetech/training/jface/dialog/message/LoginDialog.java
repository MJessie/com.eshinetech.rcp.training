/**
 * 
 */
package com.eshinetech.training.jface.dialog.message;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * @author cr.wu
 *
 */
public class LoginDialog extends Dialog {

	public static final int LOGIN_ID = 0;
	public static final int LOGOUT_ID = 1;
	public static final String LOGIN_LABEL = "登录";
	public static final String LOGOUT_LABEL = "退出";
	private Text userName;
	private Text password;
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public LoginDialog(Shell parentShell) {
		super(parentShell);
		
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
//		Group group = new Group(container,SWT.NONE);
//		group.setText("登录系统");
//		GridLayout layout = new GridLayout();
//		layout.marginHeight = 20;
//		layout.marginWidth = 20;
//		layout.numColumns = 2;
//		group.setLayout(layout);
//		new Label(group,SWT.NONE).setText("用户名：");
//		userName = new Text(group,SWT.BORDER|SWT.SINGLE);
//		new Label(group,SWT.NONE);
//		password = new Text(group, SWT.BORDER|SWT.SINGLE);
//		password.setEchoChar('*');
		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, LOGIN_ID, LOGIN_LABEL,
				true);
		createButton(parent, LOGOUT_ID, LOGOUT_LABEL, false);
	}
	
	@Override
	protected void buttonPressed(int id){
		if(LOGIN_ID == id){
			System.out.println("登录");
		}else close();
	}
	
	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}
	@Override
	protected void configureShell(Shell newShell){
		super.configureShell(newShell);
		newShell.setText("系统登录");
		newShell.setSize(230, 200);
	}
	
}
