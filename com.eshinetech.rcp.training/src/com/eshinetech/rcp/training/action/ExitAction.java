package com.eshinetech.rcp.training.action;
import org.eclipse.jface.action.Action;

import org.eclipse.jface.dialogs.MessageDialog;

import org.eclipse.ui.IWorkbenchWindow;

import com.eshinetech.rcp.training.WorkbenchControler;
import com.eshinetech.rcp.training.WorkbenchUtil;


public class ExitAction extends Action {

  

   public ExitAction(){

       this.setText("退出");

       this.setToolTipText("退出");

       this.setEnabled(true);

   }

   public void run(){

       //做退出处理，首先判断是否为主窗体，如果为主窗体，则所有子窗体全部退出，

       //如果为子窗体，则只单单的退出子窗体，而主窗体则不用退出

       if(WorkbenchUtil.getActiveWorkbenchWindow()==WorkbenchControler.mainUI){

    //所有的窗体都需要退出

           doAllClose(true);

       }else{

           //退出子窗体

           doSClose(true);

       }

   }

   //退出所有窗体

   private boolean doAllClose(boolean flag){


       if(WorkbenchUtil.getActiveWorkbenchWindow()==WorkbenchControler.mainUI)

{

           IWorkbenchWindow[] iWorkbenchWindows =WorkbenchUtil.getWorkbenchWindows();

           if(MessageDialog.openConfirm(null,"提示","确定要退出系统吗？")){

               for(int i=0;i<iWorkbenchWindows.length;i++){

                   iWorkbenchWindows[i].close();

               }

               System.exit(0);

               return true;

           }

       }

       return false;

   }

   //退出当前的窗体

   private boolean doSClose(boolean flag){


       if(MessageDialog.openConfirm(null,"提示","确定要退出系统吗?")){


           WorkbenchUtil.getActiveWorkbenchWindow().close();

           if(WorkbenchUtil.getWorkbenchWindowCount()>=1){

               WorkbenchControler.mainUI.getShell().setMaximized(true);

               WorkbenchControler.mainUI.getShell().setFocus();

               return true;

           }

       }

       //MessageDialog.o

       return false;

   }

}