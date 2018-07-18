package com.eshinetech.training.jface.treetable;

import java.util.List;

/**
 * class  desc：
 * @author WuChengRui  
 * @date 2018-7-18  
 */
public interface ITreeNode {

    public String getName() ;
    public void setName(String name);
    public abstract List getChild() ;
    public abstract void setChild(List child);
}
