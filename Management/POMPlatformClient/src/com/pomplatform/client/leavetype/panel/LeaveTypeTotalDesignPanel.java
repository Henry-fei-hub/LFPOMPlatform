package com.pomplatform.client.leavetype.panel;

import java.util.logging.Logger;

import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.employeenew.datasource.DSSemployeeNew;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

public class LeaveTypeTotalDesignPanel extends AbstractWizadPage {

    private final Logger __logger = Logger.getLogger("");

    public LeaveTypeTotalDesignPanel() {
    	final TabSet tabSet = new TabSet();  
        tabSet.setTabBarPosition(Side.TOP);  
        tabSet.setWidth100();  
        tabSet.setHeight100();  
  
        Tab leaveTypeTab = new Tab("请假类型");  
        LeaveTypePanel leaveTypePanel = new LeaveTypePanel();
        leaveTypeTab.setPane(leaveTypePanel);
        
        Tab leaveTypeLinkProvinceTab = new Tab("详情数据");  
        LeaveTypeLinkAreaPanel leaveTypeLinkProvincePanel = new LeaveTypeLinkAreaPanel();
        leaveTypeLinkProvinceTab.setPane(leaveTypeLinkProvincePanel);
        
        tabSet.addTab(leaveTypeTab);  
        tabSet.addTab(leaveTypeLinkProvinceTab);  
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
