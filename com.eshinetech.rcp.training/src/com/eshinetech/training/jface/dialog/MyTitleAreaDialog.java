package com.eshinetech.training.jface.dialog;

/**
 * class  desc：
 * @author WuChengRui  
 * @date 2018-6-20  
 */
import org.eclipse.jface.dialogs.DialogTray;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import utils.ImageFoctory;
import utils.ShellBack;
import utils.UiUtils;

//http://www.blogjava.net/charles/archive/2009/04/29/268255.html
public class MyTitleAreaDialog extends TitleAreaDialog {

    /**
     * Create the dialog
     * 
     * @param parentShell
     */
    public MyTitleAreaDialog(Shell parentShell) {
        super(parentShell);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.dialogs.TitleAreaDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
     */
    protected Control createDialogArea(Composite parent) {
        Composite area = (Composite) super.createDialogArea(parent);
        Composite container = new Composite(area, SWT.NONE);
        container.setLayoutData(new GridData(GridData.FILL_BOTH));

        // TitleArea中的Title
        setTitle("My TitleAreaDialog");

        // TitleArea中的Message
        setMessage("This is a simple TitleAreaDialog example.");

        // TitleArea中的Image
        setTitleImage(ImageFoctory.getImgByRoot( "icons/alt_launcher.ico"));
        
        final Button openTrayButton = new Button(container, SWT.NONE);
        openTrayButton.setText("Open Tray");

        final Button closeTrayButton = new Button(container, SWT.NONE);
        closeTrayButton.setText("Close Tray");
        closeTrayButton.setEnabled(false);

        openTrayButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(final SelectionEvent e) {
                // this method is from TrayDialog
                openTray(new MyDialogTray());
                openTrayButton.setEnabled(false);
                closeTrayButton.setEnabled(true);
            }
        });

        closeTrayButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(final SelectionEvent e) {
                // this method is from TrayDialog
                closeTray();
                openTrayButton.setEnabled(true);
                closeTrayButton.setEnabled(false);
            }
        });
        container.setLayout(new GridLayout(2,false));
        return area;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
     */
    protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.dialogs.TitleAreaDialog#getInitialSize()
     */
    protected Point getInitialSize() {
        return new Point(500, 375);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.dialogs.TrayDialog#createButtonBar(org.eclipse.swt.widgets.Composite)
     */
    protected Control createButtonBar(Composite parent) {
        Composite composite = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 0;
        layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
        layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
        layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
        layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);

        composite.setLayout(layout);
        composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        if (isHelpAvailable()) {
            createHelpControl(composite);
        }

        createButton(composite, MyConstants.IMPORT_BUTTON_ID, "Import", false).addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                MessageDialog.openInformation(getShell(), "Information",
                    "\"Import\" button has not been implemented.");
            }
        });

        createButton(composite, MyConstants.EXPORT_BUTTON_ID, "Export", false).addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                MessageDialog.openInformation(getShell(), "Information",
                "\"Export\" button has not been implemented.");
            }
        });

        createButton(composite, MyConstants.OTHER_BUTTON_ID, "Other", false).addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                MessageDialog.openInformation(getShell(), "Information",
                "\"Other\" button has not been implemented.");
            }
        });

        Label filler = new Label(composite, SWT.NONE);
        filler.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));
        layout.numColumns++;

        super.createButtonsForButtonBar(composite);

        return composite;
    }
    /* (non-Javadoc)
     * @see org.eclipse.jface.dialogs.TrayDialog#isHelpAvailable()
     */
    @Override
    public boolean isHelpAvailable() {
        return true;
    }
    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
     */
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);

        // Dialog Title
        newShell.setText("Test TitleAreaDialog Title");

        // Dialog Icon
        newShell.setImage(ImageFoctory.getImgByRoot("icons/alt_launcher.ico"));
    }
    
    public class MyDialogTray extends DialogTray {

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.dialogs.DialogTray#createContents(org.eclipse.swt.widgets.Composite)
         */
        protected Control createContents(Composite parent) {
            Composite container = new Composite(parent, SWT.NONE);
            final GridLayout gridLayout = new GridLayout();
            gridLayout.numColumns = 2;
            container.setLayout(gridLayout);

            final Label label = new Label(container, SWT.NONE);
            label.setText("Name:");

            final Text text = new Text(container, SWT.BORDER);
            text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

            return container;
        }

    }
    
    public static void main(String[] args) {
        UiUtils.createSwt(new ShellBack() {
            
            @Override
            public void callBack(final Shell shell) {
                Button btn = new Button(shell, SWT.PUSH);
                btn.addSelectionListener(new SelectionListener() {
                    
                    @Override
                    public void widgetSelected(SelectionEvent e) {
                        new MyTitleAreaDialog(shell).open();
                    }
                    
                    @Override
                    public void widgetDefaultSelected(SelectionEvent e) {
                    }
                });
            }
        });
    }
    

}
