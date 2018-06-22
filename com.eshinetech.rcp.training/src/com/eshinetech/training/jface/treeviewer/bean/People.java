package com.eshinetech.training.jface.treeviewer.bean;

import java.util.List;

import org.eclipse.swt.graphics.Image;

import utils.ImageFoctory;

import com.eshinetech.training.jface.treeviewer.provider.ITreeFace;

public class People implements ITreeFace {
	private int id;
    private String name;
    public People(){
    }
    public People(int id, String name){
        this.name = name;
        this.id = id;
    }
    public List getChildren() {
        return null;
    }
    public void setChildren(List children) {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + "]";
	}
    @Override
    public Image getImg() {
        
        return null;
    }
    
    
}
