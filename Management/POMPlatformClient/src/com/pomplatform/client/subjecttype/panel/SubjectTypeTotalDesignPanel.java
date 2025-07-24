package com.pomplatform.client.subjecttype.panel;

import java.util.logging.Logger;

import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.employeenew.datasource.DSSemployeeNew;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

public class SubjectTypeTotalDesignPanel extends AbstractWizadPage {

    private final Logger __logger = Logger.getLogger("");

    public SubjectTypeTotalDesignPanel() {
    	final TabSet tabSet = new TabSet();  
        tabSet.setTabBarPosition(Side.TOP);  
        tabSet.setWidth100();  
        tabSet.setHeight100();  
  
        Tab subjectTypeTab = new Tab("报销科目");  
        SubjectTypePanel subjectTypePanel = new SubjectTypePanel();
        subjectTypeTab.setPane(subjectTypePanel);
        
        Tab subjectTypeLinkDepartmentTab = new Tab("科目关联");  
        SubjectTypeLinkDepartmentPanel subjectTypeLinkDepartmentPanel = new SubjectTypeLinkDepartmentPanel();
        subjectTypeLinkDepartmentTab.setPane(subjectTypeLinkDepartmentPanel);
        
        tabSet.addTab(subjectTypeTab);  
        tabSet.addTab(subjectTypeLinkDepartmentTab);  
        addMember(tabSet);
    }

    @Override
    public void startEdit() {
        if (getRecord() != null) {
        }
    }

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSSemployeeNew.getInstance());
        manager.addMember(__form);
    }

    @Override
    public boolean checkData() {
        return true;
    }

    @Override
    public java.util.Map getValuesAsMap() {
        return __form.getValues();
    }

    public String getActionName() {
        return "ST_SubjectTypeTotal";
    }


}
