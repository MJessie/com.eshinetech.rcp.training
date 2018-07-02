/**
 * 
 */
package com.eshinetech.training.jface.styledtext;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ExtendedModifyEvent;
import org.eclipse.swt.custom.ExtendedModifyListener;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import utils.ShellBack;
import utils.UiUtils;

/**
 * @author Administrator
 *
 * 2014å¹?8æœ?20æ—?
 */
public class Demo4StyledText {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		UiUtils.createSwt(new ShellBack() {
			
			@Override
			public void callBack(Shell shell) {
				final StyledText style = new StyledText(shell, SWT.BORDER|SWT.WRAP|SWT.MULTI);
				style.setText("This is a Style Text.\nYou can set up different style.\n");
				
				StyleRange range1 = new StyleRange();
				range1.start = 5;
				range1.length = 2;
				range1.foreground = shell.getDisplay().getSystemColor(SWT.COLOR_BLUE);
				range1.background = shell.getDisplay().getSystemColor(SWT.COLOR_YELLOW);
				range1.fontStyle = SWT.ITALIC|SWT.BOLD;
				
				StyleRange range2 = new StyleRange();
				range2.start = 10;
				range2.length = 9;
				range2.fontStyle = SWT.NORMAL;
				range2.strikeout = true;
				
				style.setStyleRange(range1);
				style.setStyleRange(range2);
				style.setLineBackground(1, 1, shell.getDisplay().getSystemColor(SWT.COLOR_GRAY));
			
				style.addExtendedModifyListener(new ExtendedModifyListener() {
					
					@Override
					public void modifyText(ExtendedModifyEvent event) {
						int end = event.start + event.length-1;
						
						if(event.start <= end){
							String text = style.getText(event.start,end);
							List ranges = new ArrayList();
							for(int i = 0;i<text.length();i++){
								if("0123456789".indexOf(text.charAt(i))>-1){
									ranges.add(new StyleRange(event.start+i,1,event.display.getSystemColor(SWT.COLOR_RED),null,SWT.BOLD));
								}
							}
							if(!ranges.isEmpty()){
								style.replaceStyleRanges(event.start, event.length,(StyleRange[]) ranges.toArray(new StyleRange[0]));
							}
						}
					}
				});
				
			}
		});
	}


}
