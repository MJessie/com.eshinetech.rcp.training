package com.eshinetech.training.jface.dialog.message;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import utils.ShellBack;
import utils.UiUtils;

public class LoginCheckCodeDialog extends Dialog {
	private Text text;
	private Label userLabel;
	private String textStr;
	private String picUrl;
	private Composite checkCode;

	/**
	 * 构造函数
	 */
	public LoginCheckCodeDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("验证码输入");
	}

	public void setUrlUser(String pic , String user){
		userLabel.setText(user);
		picUrl = pic;
	}
	
	public void setPicUrl(String pic) {
		picUrl = pic;
	}

	/**
	 * 在这个方法里构建Dialog中的界面内容
	 */
	protected Control createDialogArea(Composite parent) {
		/*
		 * 不要直接在parent上创建组件，否则容易导致界面布局混乱。 应该象本例再插入一个面板topComp，并在此面板创建及布局
		 */
		Composite topComp = new Composite(parent, SWT.NONE);
		topComp.setSize(220, 500);
		userLabel = new Label(topComp, SWT.PUSH);
		userLabel.setText("                      ");
		// 应用RowLayout面局
		topComp.setLayout(new RowLayout(SWT.V_SCROLL | SWT.CENTER));
		checkCode = new Composite(topComp, SWT.FILL);
		// temp.setSize(150, 80);
		checkCode.setLayoutData(new RowData(150, 40));
		checkCode.setCursor(new Cursor(null,SWT.CURSOR_HAND));
		Image image;
		try {
			image = new Image(Display.getCurrent(), getJPGStream(picUrl));
			checkCode.setBackgroundImage(image);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		checkCode.addMouseListener(new MouseAdapter() {

			public void mouseUp(MouseEvent arg0) {
				try {
					Image image = new Image(Display.getCurrent(), getJPGStream(picUrl));

					checkCode.setBackgroundImage(image);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		// 加入一个文本标签
		new Label(topComp, SWT.NONE).setText("请输入验证码：");
		new Label(topComp,SWT.NONE).setText("");
		new Label(topComp, SWT.NONE).setText("看不清楚？请点击验证码");
		// 加入一个文本框
		text = new Text(topComp, SWT.BORDER);
		text.addKeyListener(new KeyAdapter() {

			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.keyCode == SWT.KEYPAD_CR || arg0.keyCode == 13) {
					buttonPressed(IDialogConstants.OK_ID);
				}
			}
		});
		// 用RowData来设置文本框的长度
		// text.setLayoutData(new RowData(100, -1));
		return topComp;
	}

	/**
	 * 改写这个父类Dialog的方法可以改变窗口的默认式样
	 */
	// protected int getShellStyle() {
	// /*
	// * super.getShellStyle()得到原有的式样 SWT.RESIZE：窗口可以变大小 SWT.MAX：窗口可最大化、最小化
	// */
	// return SWT.RESIZE | SWT.MAX;
	// //return 0;
	// }
	/**
	 * 改写父类创建按钮的方法，使其失效
	 */
	protected Button createButton(Composite parent, int buttonId, String buttonText, boolean defaultButton) {
		return null;
	}

	/**
	 * 改写父类的initializeBounds方法，并利用父类的createButton方法建立按钮
	 */
	protected void initializeBounds() {
		/*
		 * createButton(Composite parent, int id, String label,boolean
		 * defaultButton) 参数parent：取得放置按钮的面板， 参数id：定义按钮的id值 参数label：按钮上的文字
		 * 参数defaultButton：是否为Dialog的默认按钮
		 */
		// super.createButton((Composite) getButtonBar(), APPLY_ID, "应用", true);
		super.createButton((Composite) getButtonBar(), IDialogConstants.OK_ID, "OK", false);
		super.createButton((Composite) getButtonBar(), IDialogConstants.CANCEL_ID, "Cancel", false);
		super.initializeBounds();
	}

	@Override
	protected void buttonPressed(int button_id) {
		if (button_id == IDialogConstants.OK_ID) {
			textStr = text.getText();
		} else {
			textStr = null;
		}
		close();
	}

	public String getTextStr() {
		return textStr;
	}

	public static InputStream getJPGStream(String u) throws Exception {
		URL url = new URL(u);
		// 打开链接
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// 设置请求方式为"GET"
		conn.setRequestMethod("GET");
		// 超时响应时间为5秒
		conn.setConnectTimeout(5 * 1000);
		// 通过输入流获取图片数据
		InputStream inStream = conn.getInputStream();
		return inStream;
	}

	public static void main(String[] args) {
		//"https://pin.aliyun.com/get_img?sessionid=471da3bd2b82d90709ddba7f506a56ca&identity=taobao.login&type=150_40"
		UiUtils.createSwt(new ShellBack() {
			
			@Override
			public void callBack(Shell shell) {
				
				LoginCheckCodeDialog dialog = new LoginCheckCodeDialog(shell);
				dialog.setPicUrl("https://pin.aliyun.com/get_img?sessionid=471da3bd2b82d90709ddba7f506a56ca&identity=taobao.login&type=150_40");
				dialog.open();
				
			}
		});
	}
	
}