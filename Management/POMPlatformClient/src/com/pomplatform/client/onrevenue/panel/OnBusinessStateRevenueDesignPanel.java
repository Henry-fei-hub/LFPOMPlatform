package com.pomplatform.client.onrevenue.panel;

import java.util.logging.Logger;

import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.employeenew.datasource.DSSemployeeNew;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

public class OnBusinessStateRevenueDesignPanel extends AbstractWizadPage {

    private final Logger __logger = Logger.getLogger("");

    public OnBusinessStateRevenueDesignPanel() {
    	final TabSet tabSet = new TabSet();  
        tabSet.setTabBarPosition(Side.TOP);  
        tabSet.setWidth100();  
        tabSet.setHeight100();  
  
        Tab yearRevenueTotalTab = new Tab("累计营收");  
        RevenueYearRecordOfRevenuePanel yearRevenueTotalPanel = new RevenueYearRecordOfRevenuePanel();
        yearRevenueTotalTab.setPane(yearRevenueTotalPanel);
        
        Tab yearRevenueTab = new Tab("每月营收");  
        RevenueYearRecordSubOfRevenuePanel yearRevenuePanel = new RevenueYearRecordSubOfRevenuePanel();
        yearRevenueTab.setPane(yearRevenuePanel);
        
        Tab revenueRecordTab = new Tab("营收记录");  
        RevenueRecordOfOnRevenuePanel revenueRecordPanel = new RevenueRecordOfOnRevenuePanel();
        revenueRecordTab.setPane(revenueRecordPanel);  
  
        tabSet.addTab(yearRevenueTotalTab);  
        tabSet.addTab(yearRevenueTab);  
        tabSet.addTab(revenueRecordTab);  
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
        return "ST_OnRevenue";
    }


}
