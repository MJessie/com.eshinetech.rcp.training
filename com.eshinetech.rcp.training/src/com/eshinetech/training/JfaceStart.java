package com.eshinetech.training;

/**
 * class  desc：
 * @author WuChengRui  
 * @date 2018-6-7  
 */
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.HelpListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
  
public class JfaceStart extends ApplicationWindow{  
      
    private static JfaceStart app;

    private JfaceStart(){  
        super(null);  
        app = this;  
          
        this.addMenuBar();  
//        this.addToolBar(SWT.FLAT);  
//        this.addStatusLine();  
    }  
      
    public static JfaceStart getApp(){  
        return app;  
    }  
      
    protected void configureShell(Shell shell){  
        super.configureShell(shell);  
        shell.setText("简单写字板");  
        shell.setSize(500, 300);
//        shell.setMaximized(true);  
    }  
      
    protected Control createContents(Composite parent){
        parent.setLayout(new FillLayout());
       new Button(parent,SWT.PUSH  );
        return parent;  
    }  
      
    protected MenuManager createMenuManager(){  
        MenuManager menuBar = new MenuManager();  
          
        MenuManager fileMenu = new MenuManager("文件(&F)");  
        fileMenu.add(new Action("点我啊") {
            /* (non-Javadoc)
             * @see org.eclipse.jface.action.Action#run()
             */
            @Override
            public void run() {
                System.out.println("被点击了");
                super.run();
            }
        });
//        MenuManager editMenu = new MenuManager("编辑(&E)");  
//        MenuManager formatMenu = new MenuManager("格式(&F)");  
//        MenuManager helpMenu = new MenuManager("帮助(&H)");  
          
        menuBar.add(fileMenu);  
//        menuBar.add(editMenu);  
//        menuBar.add(formatMenu);  
//        menuBar.add(helpMenu);  
          
        fileMenu.add(new Separator());  
        fileMenu.add(new Separator());  
        
          
        return menuBar;  
    }  
      
    public static void main(String[] args){  
        JfaceStart main = new JfaceStart();  
        main.setBlockOnOpen(true);  
        main.open();  
        Display.getCurrent().dispose();  
    }  
      
    public StatusLineManager getStatusLineManager(){  
        return null;  
    }  
}  