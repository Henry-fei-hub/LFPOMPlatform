package com.pomplatform.client.workflow.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.company.datasource.DSCompanyReportIntegralDataSource;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

public class MyTaskDesignPanel extends AbstractWizadPage {
    private final Logger logger = Logger.getLogger("");
  	
    
    public MyTaskDesignPanel() {
    	HLayout mainLayout = new HLayout(10);
    	mainLayout.setWidth100();
    	mainLayout.setHeight100();
    	
    	TabSet topTabSet = new TabSet();  
        topTabSet.setTabBarPosition(Side.TOP); 
  
        Tab tTab1 = new Tab("我的财务", "pieces/16/pawn_blue.png");  
        MyWorkflowPanel panel = new MyWorkflowPanel();
        tTab1.setPane(panel);  
  
        Tab tTab2 = new Tab("我的人事", "pieces/16/pawn_green.png"); 
        MyPersonnelFlowPanel personnelPanel = new MyPersonnelFlowPanel();
        tTab2.setPane(personnelPanel);  
        
        Tab tTab3 = new Tab("我的行政", "pieces/16/pawn_yellow.png"); 
        MyAdministrationPanel administrationPanel = new MyAdministrationPanel();
        tTab3.setPane(administrationPanel);  
  
        topTabSet.addTab(tTab1);  
        topTabSet.addTab(tTab2);
        topTabSet.addTab(tTab3);  
  
        mainLayout.addMember(topTabSet);
        addMember(mainLayout);
    }

    @Override
    public void startEdit() {
    	
    }
    
    
    

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSCompanyReportIntegralDataSource.getInstance());
        manager.addMember(__form);
    }

    @Override
    public boolean checkData() {
        return true;
    }

    @Override
    public java.util.Map getValuesAsMap() {
        Map values = __form.getValues();
        return values;
    }

    public String getActionName() {
        // 需要根据实际业务修改
        return "ST_MyTaskPanel";
    }
    
}
