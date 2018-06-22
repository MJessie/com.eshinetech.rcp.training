package com.eshinetech.training.jface.treeviewer.bean;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Image;

import utils.ImageFoctory;

import com.eshinetech.training.jface.treeviewer.provider.ITreeFace;

public class Country implements ITreeFace {

	private int id;
    private String name;
    private List children = new ArrayList();
    
    public Country(){
    }
    public Country(String name){
        this.name = name;
    }
    public List getChildren() {
        return children;
    }
    public void setChildren(List children) {
        this.children = children;
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
        return "Country [id=" + id + ", name=" + name + ", children=" + children + "]";
    }
    @Override
    public Image getImg() {
        
        return ImageFoctory.getImgByRoot("icons/alt_window_16.gif");
    }

}
