package com.eshinetech.training.jface.treetable;

import java.util.ArrayList;
import java.util.List;

/**
 * class  desc：
 * @author WuChengRui  
 * @date 2018-7-18  
 */
public class DataFactory {
    
    public static List getList(){
        
        
        University  ui = new University();
        ui.setName("南京航空航天大学");
        
        Collage  infoCollage = new Collage();
        infoCollage.setName("信息科学与技术学院");
        
        Collage  compuCollage = new Collage();
        compuCollage.setName("计算机科学与技术学院");
        
        ui.getChild().add(infoCollage);
        ui.getChild().add(compuCollage);
        
        CustomClass class201 = new CustomClass();
        class201.setName("201班");
        
        CustomClass class301 = new CustomClass();
        class301.setName("301班");
        
        CustomClass class401 = new CustomClass();
        class401.setName("401班");
        
        CustomClass class501 = new CustomClass();
        class501.setName("501班");
        
        infoCollage.getChild().add(class201);
        infoCollage.getChild().add(class301);
        
        compuCollage.getChild().add(class401);
        compuCollage.getChild().add(class501);
        
        List unverList = new ArrayList();
        unverList.add(ui);
        
        return unverList;
    }

}
