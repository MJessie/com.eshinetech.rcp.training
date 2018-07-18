package com.eshinetech.training.jface.treetable;

import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * class  desc：
 * @author WuChengRui  
 * @date 2018-7-18  
 */
public class TreeViewerContentProvider implements ITreeContentProvider{
    
    public TreeViewerContentProvider()
    {
        
    }
    
    
    public Object [] getChildren(Object parentElement)
    {
        
        if (parentElement instanceof University){
            
        //  System.out.println(((University) parentElement).getName());
            List childList = ((University) parentElement).getChild();
            return childList.toArray();
        }
        
        if (parentElement instanceof Collage){
            
            System.out.println(((Collage) parentElement).getName());
            List childList = ((Collage) parentElement).getChild();
            return childList.toArray();
        }
        
        return new Object[0];
    }
    
    public Object getParent(Object element)
    {
        return null;
    }
    
    public boolean hasChildren(Object element)
    {
        if (element instanceof University){

            List childList = ((University) element).getChild();
            
            if (childList.size() > 0)
                return true;
            else
                return false;
        }
        
        if (element instanceof Collage){

            List childList = ((Collage) element).getChild();
            
            if (childList.size() > 0)
                return true;
            else
                return false;
        }
        
        return false;
    }
    
    public Object[] getElements(Object inputElement)
    {
        if(inputElement instanceof List)
        {
            List list =(List)inputElement;
            return list.toArray();      
        }
        else
            return new Object[]{inputElement};
    }
    
    public void dispose(){}
    
    public void inputChanged(Viewer viewer,Object oldInput,Object newInput){
        
    }
    
}
