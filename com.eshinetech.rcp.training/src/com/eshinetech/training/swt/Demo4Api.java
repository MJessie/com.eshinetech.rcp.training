package com.eshinetech.training.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


/**
 * class  desc：
 * @author ruien.wu  
 * @date 2018-6-4  
 */
public class Demo4Api {

    public static void main(String[] args) {
        new Demo4Api().createSwt();
    }
    /**
     * 创建一个swt程序
     * @param inBack
     */
    public  void createSwt() {
        //新建一个display
        Display display = Display.getDefault();
        //新建一个窗体
        Shell shell = new Shell();
        //设置窗体尺寸
        shell.setSize(300, 400);
        //设置窗体标题
        shell.setText("hello 讯讯");
        //设置背景颜色，为黑色
        shell.setBackground(new Color(null, 0, 0, 0));
        //设置一个缓存数据，类似于内置一个hashMap
        shell.setData("key", "value");
        //设置悬浮提示
        shell.setToolTipText("this is tip");
        //设置是否可点击
        shell.setEnabled(true);
        //设置可显示
        shell.setVisible(true);
        //作为子控件时，设置布局数据
        shell.setLayoutData(new GridData());
        //设置布局
        shell.setLayout(new GridLayout());
        //设置充满式布局
        shell.setLayout(new FillLayout());
        //设置文字风格
        shell.setFont(new Font(null, "微软雅黑", 12, SWT.BOLD));
        //设置菜单
        shell.setMenu(new Menu(shell));
        createContent(shell);
        //打开窗体
        shell.open();
        //刷新布局，如果没有设置布局，则不需要刷新
        shell.layout();
        //以下代码是为了阻塞display释放
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        System.exit(0);
    }
    /**
     * @param shell
     */
    private  void createContent(Shell shell) {
        
        Button pushBtn = new Button(shell,  SWT.PUSH  );
        Button checkBtn = new Button(shell,  SWT.CHECK  );
        Text text = new Text(shell,SWT.MULTI | SWT.WRAP | SWT.BORDER | SWT.READ_ONLY | SWT.VERTICAL);
        
        
        
    }
    
}
