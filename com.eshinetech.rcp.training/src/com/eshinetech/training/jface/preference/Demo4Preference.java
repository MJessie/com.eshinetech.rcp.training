/**
 * 
 */
package com.eshinetech.training.jface.preference;

import java.io.IOException;

import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.jface.preference.PreferenceNode;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.swt.widgets.Display;

/**
 * @author cr.wu
 *
 */
public class Demo4Preference {

	/**
	 * 
	 */
	public Demo4Preference() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Display display = new Display();
		PreferenceManager manager = new PreferenceManager();
		PreferenceNode nodeOne = new PreferenceNode("System", "系统设置", null, SystemSettingPage.class.getName());
		manager.addToRoot(nodeOne);
		
		PreferenceDialog dlg = new PreferenceDialog(null, manager);
		//要处理好，有没有这个文件的存在
		PreferenceStore ps = new PreferenceStore(SystemSettingPage.SYSTEMSETTING_PATH);
		try {
			ps.load();
			dlg.setPreferenceStore(ps);
			dlg.open();
			ps.save();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			dlg.setPreferenceStore(ps);
			dlg.open();
			try {
				ps.save();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		//dlg.open();
		display.dispose();
		
	}

}
