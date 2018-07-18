package com.eshinetech.training.jface.treetable;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

/**
 * class desc：
 * 
 * @author WuChengRui
 * @date 2018-7-18
 */
public class TreeViewerLabelProvider implements ILabelProvider {
    public TreeViewerLabelProvider() {

    }

    public Image getImage(Object element) {

        return null;
    }

    public String getText(Object element) {
        if (element instanceof University) {

            return ((University) element).getName();
        }

        if (element instanceof Collage) {

            return ((Collage) element).getName();
        }

        if (element instanceof CustomClass) {

            return ((CustomClass) element).getName();
        }
        return "";
    }

    public void addListener(ILabelProviderListener listener) {

    }

    public void dispose() {

    }

    public boolean isLabelProperty(Object element, String property) {
        return false;
    }

    public void removeListener(ILabelProviderListener listener) {

    }

}