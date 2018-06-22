package com.eshinetech.rcp.training;

import org.eclipse.ui.IWorkbenchWindow;

/**
 * class  desc：
 * @author WuChengRui  
 * @date 2018-6-21  
 */
public class WorkbenchUtil {

    /**
     * @return
     */
    public static IWorkbenchWindow getActiveWorkbenchWindow() {
        
        return Activator.getDefault().getWorkbench().getActiveWorkbenchWindow();
    }

    /**
     * @return
     */
    public static IWorkbenchWindow[] getWorkbenchWindows() {
        
        return Activator.getDefault().getWorkbench().getWorkbenchWindows();
    }

    /**
     * @return
     */
    public static int getWorkbenchWindowCount() {
        
        return Activator.getDefault().getWorkbench().getWorkbenchWindows().length;
    }
    
    
    

}
