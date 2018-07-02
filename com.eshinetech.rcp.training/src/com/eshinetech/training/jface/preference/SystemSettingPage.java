package com.eshinetech.training.jface.preference;
import java.io.IOException;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * 
 */

/**
 * @author cr.wu
 *
 */
public class SystemSettingPage extends PreferencePage {

	private Text userName;
	private Text password;
	
	public String USER_NAME = "用户登录";
	public String PASS_WARD = "密码输入";
	
	public static String USERDEF = "userDef";
	public static String PWDDEF = "pwdDef";
	
	private IPreferenceStore preferenceStore;
	
	public static final String SYSTEMSETTING_PATH = "f:\\b.properties";
	
	/**
	 * 
	 */
	public SystemSettingPage() {
		
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 */
	public SystemSettingPage(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @param image
	 */
	public SystemSettingPage(String title, ImageDescriptor image) {
		super(title, image);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createContents(Composite parent) {
		// TODO Auto-generated method stub
		preferenceStore  = getPreferenceStore();// new PreferenceStore(SYSTEMSETTING_PATH);
		if(preferenceStore.getString(USERDEF).equals("")){//当不存在这个字段，则要设置默认属�?
			preferenceStore.setValue(USERDEF, USER_NAME);
			preferenceStore.setValue(PWDDEF,PASS_WARD);
			
		}
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		
//		preferenceStore.setValue(USERDEF, USER_NAME);
//		preferenceStore.setValue(PWDDEF,PASS_WARD);
//		try {
//			preferenceStore.save();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		new Label(composite,SWT.LEFT).setText("登录用户�?");
		userName = new Text(composite,SWT.BORDER);
		userName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		userName.setText(preferenceStore.getString(USERDEF));
		
		new Label(composite,SWT.LEFT).setText("登录密码");;
		password = new Text(composite, SWT.BORDER);
		password.setEchoChar('*');
		password.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		password.setText(preferenceStore.getString(PWDDEF));
		
		return composite;
	}

	protected void performDefaults(){
		
		userName.setText(preferenceStore.getString(USERDEF));
		password.setText(preferenceStore.getString(USERDEF));
		
	}
	
	public boolean performOk(){
//		try {
//			preferenceStore.load();
//			if(userName != null)preferenceStore.setValue(USERDEF, userName.getText());
//			if(password != null)preferenceStore.setValue(PWDDEF, password.getText());
//			preferenceStore.save();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		if(userName != null)preferenceStore.setValue(USERDEF, userName.getText());
		if(password != null)preferenceStore.setValue(PWDDEF, password.getText());
		return true;
	}
	
	
}
