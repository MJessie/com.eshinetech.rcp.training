package com.eshinetech.training.jface.treeviewer.provider;

import java.util.List;

import org.eclipse.swt.graphics.Image;

public interface ITreeFace {
	public String getName();
    public void setName(String name);
    public void setChildren(List Children);
    public List getChildren();
    public int getId();
    public Image getImg();
}
