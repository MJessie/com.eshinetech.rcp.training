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
	 * ���캯��
	 */
	public LoginCheckCodeDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("��֤������");
	}

	public void setUrlUser(String pic , String user){
		userLabel.setText(user);
		picUrl = pic;
	}
	
	public void setPicUrl(String pic) {
		picUrl = pic;
	}

	/**
	 * ����������ﹹ��Dialog�еĽ�������
	 */
	protected Control createDialogArea(Composite parent) {
		/*
		 * ��Ҫֱ����parent�ϴ���������������׵��½��沼�ֻ��ҡ� Ӧ�������ٲ���һ�����topComp�����ڴ���崴��������
		 */
		Composite topComp = new Composite(parent, SWT.NONE);
		topComp.setSize(220, 500);
		userLabel = new Label(topComp, SWT.PUSH);
		userLabel.setText("                      ");
		// Ӧ��RowLayout���
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
		// ����һ���ı���ǩ
		new Label(topComp, SWT.NONE).setText("��������֤�룺");
		new Label(topComp,SWT.NONE).setText("");
		new Label(topComp, SWT.NONE).setText("���������������֤��");
		// ����һ���ı���
		text = new Text(topComp, SWT.BORDER);
		text.addKeyListener(new KeyAdapter() {

			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.keyCode == SWT.KEYPAD_CR || arg0.keyCode == 13) {
					buttonPressed(IDialogConstants.OK_ID);
				}
			}
		});
		// ��RowData�������ı���ĳ���
		// text.setLayoutData(new RowData(100, -1));
		return topComp;
	}

	/**
	 * ��д�������Dialog�ķ������Ըı䴰�ڵ�Ĭ��ʽ��
	 */
	// protected int getShellStyle() {
	// /*
	// * super.getShellStyle()�õ�ԭ�е�ʽ�� SWT.RESIZE�����ڿ��Ա��С SWT.MAX�����ڿ���󻯡���С��
	// */
	// return SWT.RESIZE | SWT.MAX;
	// //return 0;
	// }
	/**
	 * ��д���ഴ����ť�ķ�����ʹ��ʧЧ
	 */
	protected Button createButton(Composite parent, int buttonId, String buttonText, boolean defaultButton) {
		return null;
	}

	/**
	 * ��д�����initializeBounds�����������ø����createButton����������ť
	 */
	protected void initializeBounds() {
		/*
		 * createButton(Composite parent, int id, String label,boolean
		 * defaultButton) ����parent��ȡ�÷��ð�ť����壬 ����id�����尴ť��idֵ ����label����ť�ϵ�����
		 * ����defaultButton���Ƿ�ΪDialog��Ĭ�ϰ�ť
		 */
		// super.createButton((Composite) getButtonBar(), APPLY_ID, "Ӧ��", true);
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
		// ������
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// ��������ʽΪ"GET"
		conn.setRequestMethod("GET");
		// ��ʱ��Ӧʱ��Ϊ5��
		conn.setConnectTimeout(5 * 1000);
		// ͨ����������ȡͼƬ����
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