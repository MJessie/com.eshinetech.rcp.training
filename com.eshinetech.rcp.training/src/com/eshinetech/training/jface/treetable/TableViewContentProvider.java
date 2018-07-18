package com.eshinetech.training.jface.treetable;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * class  desc：
 * @author WuChengRui  
 * @date 2018-7-18  
 */
public class TableViewContentProvider implements ITreeContentProvider{

    
    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Object[] getElements(Object inputElement) {
        // TODO Auto-generated method stub
        if(inputElement instanceof List)
            return ((List)inputElement).toArray();
        else 
            return new Object[]{inputElement};
    }

    @Override
    public Object[] getChildren(Object parentElement) {
        // TODO Auto-generated method stub
        if(parentElement instanceof University){
            List list = new ArrayList();        
            list.addAll(((University) parentElement).getChild());             
            return list.toArray();          
        }
        
        if(parentElement instanceof Collage){
            List list = new ArrayList();        
            list.addAll(((Collage) parentElement).getChild());       
            return list.toArray();
        }
        
        
        return new Object[0];
    }

    @Override
    public Object getParent(Object element) {
        // TODO Auto-generated method stub
        return null;
    }

    
    @Override
    public boolean hasChildren(Object element) {
        
        if(element instanceof University)
        {
            if(((University) element).getChild().size() > 0)
                return true;
            return false;
        }
        
        if(element instanceof Collage){
            
            if (((Collage) element).getChild().size() > 0)
                return true;
            return false;
        }   
        return false;
    }
}
