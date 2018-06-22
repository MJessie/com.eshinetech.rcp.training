package com.eshinetech.rcp.training;

import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	private static final String PERSPECTIVE_ID = "com.eshinetech.rcp.training.perspective"; //$NON-NLS-1$

    public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        return new ApplicationWorkbenchWindowAdvisor(configurer);
    }

	/** 
	 * 默认透视图
	 */
	public String getInitialWindowPerspectiveId() {
		return PERSPECTIVE_ID;
	}
	
	/** (non-Javadoc)
	 * 在初始化完成之后, 打开第一个窗口之前调用, 在这里可以对打开编辑器和视图的初始化参数进行设置。
	 */
	@Override
	public void preStartup() {
	    
	    super.preStartup();
	}
	
	/** (non-Javadoc)
	 * 在所有窗口打开或恢复以后开始事件循环之前调用。 在这里可以进行一些类似自动批处理的工作。
	 */
	@Override
	public void postStartup() {
	    
	    super.postStartup();
	}
	
	/** 
	 * 在事件循环结束以后, 关闭任何一个窗口之前调用
	 */
	@Override
	public boolean preShutdown() {
	    
	    return super.preShutdown();
	}
	
	/** 
	 * 在所有窗口关闭之后, 关闭工作台 ( Workbench ) 之前调用, 可以用来保存当前应用的状态, 清理 initialize 方法创建的内容
	 */
	@Override
	public void postShutdown() {
	    
	    super.postShutdown();
	}
	
	
	
	
	
}
