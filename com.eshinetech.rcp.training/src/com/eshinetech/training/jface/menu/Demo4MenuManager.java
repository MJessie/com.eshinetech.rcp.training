package com.eshinetech.training.jface.menu;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;

import utils.ShellBack;
import utils.UiUtils;

/**
 * class desc：
 * 
 * @author WuChengRui
 * @date 2018-6-12
 */
public class Demo4MenuManager {
    
    // 每个MenuManager都可以独立运作，同时又可以组合在一起，成为树状结构
    // menuManager实现了可以成为叶子的IAction接口，
    //同时又为自己添加了发展为枝的接口add(IAction)
    // 这种可以组合成不同的层级关系的设计模式，叫组合模式
    
    
    public Demo4MenuManager(Shell shell) {
        MenuManager createMenuManager = createMenuManager();
        //右键菜单
//        shell.setMenu(createMenuManager.createContextMenu(shell));
        //顶部菜单
        shell.setMenuBar(createMenuManager.createMenuBar((Decorations) shell));
        createMenuManager.updateAll(true);
    }

    protected MenuManager createMenuManager() {
       
        //新建一节点
        MenuManager menuBar = new MenuManager();
        //新建一个fileMenu节点，
        MenuManager fileMenu = new MenuManager("文件(&F)");
        
        MenuManager fileMenu2 = new MenuManager("文件2(&F)");
        //新建一个openAction节点
        Action openAction = new Action("打开") {
            @Override
            public void run() {
                System.out.println("打开被点击了");
                super.run();
            }
        };
        
      //新建一个openAction节点
        Action openAction2 = new Action("打开2") {
            @Override
            public void run() {
                System.out.println("打开被点击了2");
                super.run();
            }
        };
        fileMenu2.add(openAction2);
        //确定层级关系，Menu为最高层的树
        //fileMenu为一个枝节点，因为它有上级同时也有下级
        //openAction 为叶子节点，因为是最顶层的节点
        fileMenu.add(openAction);
        menuBar.add(fileMenu);
        fileMenu.add(fileMenu2);
        
        MenuManager exMenu = new MenuManager("扩展(&F)");
        exMenu.add(new Action("这是扩展") {
            @Override
            public void run() {
                System.out.println("扩展被点击了");
                super.run();
            }
        });
        menuBar.add(exMenu);

        return menuBar;
    }

    public static void main(String[] args) {
        UiUtils.createSwt(new ShellBack() {
            @Override
            public void callBack(Shell shell) {
               new Demo4MenuManager(shell);
            }
        });
    }

}
