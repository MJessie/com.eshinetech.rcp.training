package com.eshinetech.training.jface.wizard;

import org.eclipse.jface.wizard.Wizard;

/**
 * class  desc：
 * @author WuChengRui  
 * @date 2018-6-22  
 */
public class BookSurveyWizard extends Wizard{  
    public static final String Q1 = "QUESTION_1";  
    public static final String Q2 = "QUESTION_2";  
    public static final String THANKS = "THANKS";  
      
    private QuestionOne one;  
    private QuestionTwo two;  
    private Thanks thanks;  
    public BookSurveyWizard(){  
        one = new QuestionOne();  
        two = new QuestionTwo();  
        thanks = new Thanks();  
          
        this.addPage(one);  
        this.addPage(two);  
        this.addPage(thanks);  
        this.setWindowTitle("读者调查向导");  
    }  
      
    public boolean canFinish(){  
        if(this.getContainer().getCurrentPage() == thanks)  
            return true;  
        else  
            return false;  
    }  
      
    public boolean performFinish(){  
        return true;  
    }  
}
