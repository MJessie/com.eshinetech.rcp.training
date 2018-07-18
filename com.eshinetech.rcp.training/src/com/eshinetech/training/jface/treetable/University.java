package com.eshinetech.training.jface.treetable;

import java.util.ArrayList;
import java.util.List;

/**
 * class  desc：
 * @author WuChengRui  
 * @date 2018-7-18  
 */
public class University implements ITreeNode{
    
    public String name;
    public List child = new ArrayList();
    

    public List getChild() {
        return child;
    }

    public void setChild(List child) {
        this.child = child;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return name;
    }

    @Override
    public void setName(String name) {
        // TODO Auto-generated method stub
        this.name = name;
        
    }
}
