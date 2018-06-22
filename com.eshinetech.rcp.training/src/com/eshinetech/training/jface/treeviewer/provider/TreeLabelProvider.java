package com.eshinetech.training.jface.treeviewer.provider;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;


public class TreeLabelProvider extends LabelProvider implements ILabelProvider {
	public String getText(Object element) {
		ITreeFace node = (ITreeFace)element;
        return node.getName();
    }
    public Image getImage(Object element) {
        ITreeFace node = (ITreeFace)element;
        return node.getImg();
    }
}
