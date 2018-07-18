package com.eshinetech.training.jface.treetable;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * class desc：
 * 
 * @author WuChengRui
 * @date 2018-7-18
 */
public class TableViewLabelProvider implements ITableLabelProvider {

    @Override
    public void addListener(ILabelProviderListener listener) {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isLabelProperty(Object element, String property) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void removeListener(ILabelProviderListener listener) {
        // TODO Auto-generated method stub

    }

    @Override
    public Image getColumnImage(Object element, int columnIndex) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getColumnText(Object element, int columnIndex) {

        if (element instanceof University) {
            switch (columnIndex) {
            case 0:
                return ((University) element).getName();
            default:
                return "";
            }
        }

        if (element instanceof Collage) {
            switch (columnIndex) {
            case 1:
                return ((Collage) element).getName();
            default:
                return "";
            }
        }

        if (element instanceof CustomClass) {
            if (columnIndex == 2)
                return ((CustomClass) element).getName();
            else
                return "";
        }

        return "";

    }
}
