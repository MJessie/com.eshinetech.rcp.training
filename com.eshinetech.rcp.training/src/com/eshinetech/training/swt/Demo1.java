package com.eshinetech.training.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * class desc：
 * 
 * @author ruien.wu
 * @date 2018-6-1
 */
public class Demo1 {

    public static void main(String[] args) {
        new Demo1();
    }

    /**
     * 
     */
    public Demo1() {
        // 新建一个display
        Display display = Display.getDefault();
        // 新建一个窗体
        Shell shell = new Shell();
        // 设置窗体尺寸
        shell.setSize(300, 400);
        // 设置窗体标题
        shell.setText("hello 讯讯");
        // 创建主要内容
        createContent(shell);
        // 打开窗体
        shell.open();
        // 设置充满式布局
        // shell.setLayout(new FillLayout());
        // 刷新布局，如果没有设置布局，则不需要刷新
        // shell.layout();
        // 以下代码是为了阻塞display释放,
        //和抛出display接收到的事件
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }else{
            }
        }
        System.exit(0);
    }

    /**
     * @param shell
     */
    private static void createContent(Shell shell) {
        // 创建一个button，父容器为shell，样式为SWT.PUSH，此样式效果是凸起
        Button leftButton = new Button(shell, SWT.PUSH);
        // 设置坐标及尺寸
        leftButton.setBounds(0, 0, 100, 100);
        // 设置文本
        leftButton.setText("i am button");
        // 新建一个composite容器，父容器为shell，样式为SWT.BORDER，此样式效果是有边框
        Composite emptyComp = new Composite(shell, SWT.BORDER);
        emptyComp.setBounds(100, 0, 100, 100);

        // 新建一个composite容器，父容器为shell，样式为0，此样式效果没有任何效果
        Composite contentComp = new Composite(shell, SWT.BORDER);
        contentComp.setBounds(100, 100, 200, 100);

        // 新建一个text，父容器为contentComp，
        //样式为SWT.BORDER，此样式效果是有边框,且多行，且自动换行
        Text text = new Text(contentComp, SWT.BORDER | SWT.MULTI | SWT.WRAP);
        text.setText("i am text , i am text");
        // 此处的坐标，是0,0，因为设置坐标的是相对于父控件，
        //也就是contentComp来说的，并不是对于整个应用设置的
        // 所以从0，0开始，也就是父控件的坐标起点
        text.setBounds(0, 0, 200, 100);
    }

}
