package com.eshinetech.rcp.training.builder;

import org.eclipse.ui.application.ActionBarAdvisor;

import org.eclipse.ui.application.IActionBarConfigurer;

import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import com.eshinetech.rcp.training.ApplicationActionBarAdvisor;
import com.eshinetech.rcp.training.WorkbenchControler;

public final class WorkbenchActionBuilder {

    private IActionBarConfigurer Ibarconfigurer;

    private WorkbenchWindowAdvisor workbenchWindowAdvistor;

    private ActionBarAdvisor actionBarAdvisor;

    public WorkbenchActionBuilder(IActionBarConfigurer Ibarconfigurer) {

        this.Ibarconfigurer = Ibarconfigurer;

    }

    public ActionBarAdvisor makeWinAction() {

        switch (WorkbenchControler.flag) {

        case WorkbenchControler.main:
            actionBarAdvisor = new ApplicationActionBarAdvisor(Ibarconfigurer);
            break;

        case WorkbenchControler.child_1:
            actionBarAdvisor = new ChildApplicationActionBarAdvisor(Ibarconfigurer);
            break;

        case WorkbenchControler.child_2:
            actionBarAdvisor = new SonApplicationActionBarAdvisor(Ibarconfigurer);
            break;
        }

        return actionBarAdvisor;

    }

    public void dispose() {

        workbenchWindowAdvistor.dispose();

    }

}