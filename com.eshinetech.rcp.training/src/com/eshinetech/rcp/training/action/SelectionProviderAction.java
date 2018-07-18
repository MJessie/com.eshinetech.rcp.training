package com.eshinetech.rcp.training.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

import com.eshinetech.rcp.training.model.Country;

/**
 * class  desc：
 * @author WuChengRui  
 * @date 2018-6-26  
 */
public class SelectionProviderAction extends Action implements ISelectionListener , IWorkbenchAction{

    public final static String ID = "com.eshinetech.rcp.training.action.SelectionProviderAction";
    private IWorkbenchWindow window;
    public SelectionProviderAction(IWorkbenchWindow window){
        super("test action");
        setId(ID);
        setText("测试选择监听器");
        this.window = window;
        window.getSelectionService().addSelectionListener(this);
        
    }
    
    @Override
    public void run() {
        System.out.println("SelectionProviderAction:   run-------");
        
    }

    @Override
    public void dispose() {
    }

    @Override
    public void selectionChanged(IWorkbenchPart part, ISelection income) {
        System.out.println("change -------");
        if( income instanceof IStructuredSelection){
            
            IStructuredSelection selection = (IStructuredSelection) income;
            Country firstElement = (Country) selection.getFirstElement();
            if(firstElement == null){
                return ;
            }
            System.out.println(firstElement);
            if(firstElement.getName().equals("美国")){
                setEnabled(true);
            }else{
                setEnabled(false);
            }
            
        }
    }

    
    
}
