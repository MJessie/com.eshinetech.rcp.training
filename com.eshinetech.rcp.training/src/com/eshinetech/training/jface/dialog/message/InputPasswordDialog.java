/**
 * 
 */
package com.eshinetech.training.jface.dialog.message;


import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import utils.ShellBack;
import utils.UiUtils;

/**
 * @author cr.wu
 *
 */
public class InputPasswordDialog extends TitleAreaDialog {

	private Text userName;
	private Text password;
	private Text confirm;
	public final String DEFAULT_INFO = "������Ҫע����û���������";
	/**
	 * @param parentShell
	 */
	public InputPasswordDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}
	
	protected Control createContents(Composite parent){
		super.createContents(parent);
		this.getShell().setText("�û�ע��Ի���");
		this.setTitle("�û�ע��");
		this.setMessage("������Ҫע����û���������");
		return parent;
	}
	
	protected Control createDialogArea(Composite parent){
		super.createDialogArea(parent);
		Composite composite = new Composite(parent,SWT.NONE);
		composite.setLayout(new GridLayout(2,true));
		new Label(composite, SWT.NONE).setText("�û���");;
		
		userName = new Text(composite,SWT.BORDER);
		userName.addFocusListener (new FocusAdapter() {
			public void focusLost(FocusEvent e){
				checkValid();
			}
		});
		
		new Label(composite,SWT.NONE).setText("password");;
		password = new Text(composite, SWT.BORDER);
		password.setEchoChar('*');
		new Label(composite,SWT.NONE).setText("confirm");;
		confirm = new Text(composite, SWT.BORDER);
		confirm.setEchoChar('*');
		confirm.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e){
				checkValid();
			}
		});
		return parent;
	}
	
	protected void checkValid(){
		if(!password.getText().equals(confirm.getText())){
			setMessage("ȷ�����벻һ�£�����������",IMessageProvider.WARNING);
			
		}else if(userName.getText().equals("")){
			setMessage("�û���Ϊ��",IMessageProvider.ERROR);
			
		}else setMessage(DEFAULT_INFO);
	}
	
	public static void main(String[] args) {
		UiUtils.createSwt(new ShellBack() {
			
			@Override
			public void callBack(Shell shell) {
				new InputPasswordDialog(shell).open();
				
			}
		});
	}
	

}
