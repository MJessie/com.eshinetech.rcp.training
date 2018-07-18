package com.eshinetech.training.jface.treetable;

import java.util.ArrayList;
import java.util.List;

/**
 * class  desc：
 * @author WuChengRui  
 * @date 2018-7-18  
 */
public class Collage implements ITreeNode {

    private String name;
    private List child = new ArrayList();
    
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

    @Override
    public List getChild() {
        // TODO Auto-generated method stub
        return child;
    }

    @Override
    public void setChild(List child) {
        // TODO Auto-generated method stub
        this.child = child;

    }

}
