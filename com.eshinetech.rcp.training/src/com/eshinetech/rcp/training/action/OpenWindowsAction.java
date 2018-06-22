package com.eshinetech.rcp.training.action;
import org.eclipse.jface.action.Action;

import org.eclipse.ui.IWorkbenchWindow;

import org.eclipse.ui.PlatformUI;

import org.eclipse.ui.WorkbenchException;

import com.eshinetech.rcp.training.WorkbenchControler;

 

public class OpenWindowsAction extends Action {

   IWorkbenchWindow window;

   int flag = -1;

   public OpenWindowsAction(int flag){

       this.flag = flag;

       String name="";

       switch(flag){

       case WorkbenchControler.main:

           name = "公共资源管理";

           break;

       case WorkbenchControler.child_1:

           name = "数据网资源管理";

           break;

       case WorkbenchControler.child_2:

           name = "交换网资源管理";

           break;

       }

       this.setText(name);

       this.setToolTipText(name);

       this.setEnabled(true);

   }

  

   public void run(){

       WorkbenchControler.flag = flag;// 将目前打开的窗体菜单对应的标示值传递到控制器中

       IWorkbenchWindow window = null;

       try {

           switch (WorkbenchControler.flag) {

           case WorkbenchControler.main:

               if (WorkbenchControler.mainUI == null|| WorkbenchControler.mainUI.getShell() == null) {

                   WorkbenchControler.mainUI =PlatformUI.getWorkbench().openWorkbenchWindow(null);

               }

               window=WorkbenchControler.mainUI;

               window.getShell().setText("网络资源管理系统——公共系统管理");

           break;

           case WorkbenchControler.child_1:

               if (WorkbenchControler.child_1_UI == null|| WorkbenchControler.child_1_UI.getShell() == null) {

                   WorkbenchControler.child_1_UI=PlatformUI.getWorkbench().openWorkbenchWindow(null);

               }

               window=WorkbenchControler.child_1_UI;

               window.getShell().setText("网络资源管理系统——数据系统管理");

           break;

           case WorkbenchControler.child_2:

               if (WorkbenchControler.child_2_UI == null|| WorkbenchControler.child_2_UI.getShell() == null) {

                   WorkbenchControler.child_2_UI =PlatformUI.getWorkbench().openWorkbenchWindow(null);

               }

               window=WorkbenchControler.child_2_UI;

               window.getShell().setText("网络资源管理系统——交换网资源管理");

           break;

           }

           //接下来，可以在这个地方控制不同活动窗体的视图的显示   

       } catch (WorkbenchException e) {

           e.printStackTrace();

       }

   }

}
