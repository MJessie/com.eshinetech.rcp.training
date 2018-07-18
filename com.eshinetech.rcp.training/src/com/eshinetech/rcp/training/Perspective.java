package com.eshinetech.rcp.training;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import com.eshinetech.rcp.training.view.SelectionProviderTestView;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
	    String editorArea = layout.getEditorArea();
	    layout.setEditorAreaVisible(false);
	    layout.addView(SelectionProviderTestView.ID, IPageLayout.LEFT  , 0.5f, editorArea);
	    
	    
	}
}
