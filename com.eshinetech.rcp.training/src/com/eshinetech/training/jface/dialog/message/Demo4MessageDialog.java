/**
 * 
 */
package com.eshinetech.training.jface.dialog.message;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * @author cr.wu
 *
 */
public class Demo4MessageDialog extends ApplicationWindow {
	public static final String DUMMY_PLUGIN = "plugin id";
	/**
	 * Create the application window.
	 */
	public Demo4MessageDialog() {

		super(null);
	}

	/**
	 * 
	 */
	private void initButton(Composite composite, final Text console) {
		
		createBtn(composite , "信息提示框框" , new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Image image = new Image(Display.getCurrent(), "icons/list.gif");
				MessageDialog d = new MessageDialog(Display.getCurrent().getActiveShell(), "这是一个信息提示对话框标题", image,
						"这是一个信息提示对话框，可以改变按钮的设置", MessageDialog.INFORMATION, new String[] { "查看", "保存", "确认" }, 1);
				int i = d.open();
				console.append("\n点击了   " + i);
			}
		});
		
		createBtn(composite , "openError" , new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openError(Display.getCurrent().getActiveShell(), "openError message title",
						"openError message desc");
				console.append("\nopenError ");
			}
		});

		createBtn(composite , "openConfirm" , new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean b = MessageDialog.openConfirm(Display.getCurrent().getActiveShell(),
						"openConfirm message title", "openConfirm message desc");
				console.append("\n openConfirm " + b);
			}
		});

		createBtn(composite , "openInfo" , new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "openInfo message title",
						"openInfo message desc");
				console.append("\n openInfo ");
			}
		});
		
		createBtn(composite , "openQuestion" , new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean b = MessageDialog.openQuestion(Display.getCurrent().getActiveShell(),
						"openQuestion message title", "openQuestion message desc");
				console.append("\n openQuestion " + b);
			}
		});

		createBtn(composite , "openQuestion" , new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openWarning(Display.getCurrent().getActiveShell(), "openWarning message title",
						"openWarning message desc");
				console.append("\n openQuestion ");
			}
		});
		
		createBtn(composite , "openLogin" , new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				LoginDialog l = new LoginDialog(getShell());
				l.open();
			}
		});

		createBtn(composite , "验证码对话框" , new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				LoginCheckCodeDialog l = new LoginCheckCodeDialog(getShell());
				l.setPicUrl("https://pin.aliyun.com/get_img?sessionid=471da3bd2b82d90709ddba7f506a56ca&identity=taobao.login&type=150_40");
				l.open();
			}
		});

		createBtn(composite , "openBox" , new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				super.widgetSelected(e);
				MessageBox messageBox = new MessageBox(Display.getCurrent().getActiveShell(), SWT.OK | SWT.CANCEL);
				messageBox.setMessage("这是提示Messagebox");
				messageBox.setText("title");
				if (messageBox.open() == SWT.OK) {
					System.out.println("Ok is pressed.");
				} else {
					System.out.println("NO is pressed.");
				}
			}
		});
		
		createBtn(composite , "邮件校验输入框",new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				InputDialog inputDialog = new InputDialog(Display.getCurrent().getActiveShell(), "输入电子邮件", "输入邮箱地址", "448298120@qq.com", new EmailValidator());
				int r = inputDialog.open();
				if(r == Window.OK){
					System.out.println("ok");
					
				}else {System.out.println("no");}
			}
		});
		
		createBtn(composite, "进度条对话框", new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
				IRunnableWithProgress runnable = new IRunnableWithProgress() {
					
					@Override
					public void run(IProgressMonitor monitor)
							throws InvocationTargetException, InterruptedException {
						// TODO Auto-generated method stub
						monitor.beginTask("开始执行任务", 100);
						for(int i = 0;i<10&&!monitor.isCanceled();i++){
							Thread.sleep(500);
							monitor.worked(10);
							monitor.subTask("已经完成了   "+i);
						}
						monitor.done();
						if(monitor.isCanceled()){
							System.err.println("已取消");
						}else{
							System.err.println("已完成");
							
						}
					}
					
				};
				try {
					progressDialog.run(true, true, runnable);
				} catch (InvocationTargetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		createBtn(composite, "多行错误提示框", new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Status[] status = new Status[2];
				status[0] = new Status(IStatus.ERROR,DUMMY_PLUGIN,1,"未找到该类",new ClassNotFoundException());
				status[1] = new Status(IStatus.ERROR,DUMMY_PLUGIN,1,"未找到该类",new FileNotFoundException());
//				Status status = new Status(IStatus.ERROR,dummyPlugin,1,"未找到该类",new ClassNotFoundException());
//				ErrorDialog d = new ErrorDialog(Display.getCurrent().getActiveShell(), "提示错误", "装载错误", status, IStatus.ERROR);
				MultiStatus mu = new MultiStatus(DUMMY_PLUGIN, IStatus.OK, status, "发现一大堆错误",new Exception());
				ErrorDialog d = new ErrorDialog(Display.getCurrent().getActiveShell(), "提示错误", "各种错误", mu, IStatus.ERROR);
				
				d.open();
			}
		});
		
		
	}

	
	private void createBtn(Composite parent , String btnText , SelectionAdapter selectionAdapter){
		Button btn = new Button(parent, SWT.PUSH);
		btn.setText(btnText);
		btn.addSelectionListener(selectionAdapter);
		GridData data = new GridData(SWT.FILL,SWT.FILL,true,false);
		btn.setLayoutData(data);
	}

	/**
	 * Create contents of the application window.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout(5, true);
		composite.setLayout(gridLayout);

		final Text console = new Text(composite, SWT.None | SWT.READ_ONLY | SWT.V_SCROLL);
		GridData data = new GridData(SWT.FILL,SWT.FILL,true,true);
		data.horizontalSpan = 5;
		console.setLayoutData(data);
		
		initButton(composite, console);
		return composite;
	}

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		
		try {
			Demo4MessageDialog window = new Demo4MessageDialog();
			window.setBlockOnOpen(true);
			window.open();
			Display.getCurrent().dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

}
