package com.pomplatform.client.employeeaward.panel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.account.panel.EmployeeAccountDesignPanel;
import com.pomplatform.client.company.datasource.DSCompanyReportIntegralDataSource;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

public class OnEmployeeIntegralBusinessDesignPanel extends AbstractWizadPage {
    private final Logger logger = Logger.getLogger("");
  	
    
    public OnEmployeeIntegralBusinessDesignPanel() {
    	HLayout mainLayout = new HLayout(10);
    	mainLayout.setWidth100();
    	mainLayout.setHeight100();
    	
    	TabSet topTabSet = new TabSet();  
        topTabSet.setTabBarPosition(Side.TOP); 
  
        Tab tTab1 = new Tab("个人积分详情");  
        EmployeeAccountDesignPanel panel = new EmployeeAccountDesignPanel();
		int employeeId = ClientUtil.getEmployeeId();
		//加载个人实时余额和年度个人效益指数
		Map<Object, Object> param = new HashMap<>();
		param.put("optType", "onLoadLeftIntegralAndBenefits");
		param.put("employeeId", employeeId);
		DBDataSource.callOperation("EP_AccountManageProcess", param, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				BigDecimal leftIntegral = BigDecimal.ZERO;
				BigDecimal benefits = BigDecimal.ZERO;
				if (dsResponse.getStatus() >= 0) {
					Record record = dsResponse.getData()[0];
					if(!BaseHelpUtils.isNullOrEmpty(record)){
						leftIntegral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("leftIntegral"));
						benefits = BaseHelpUtils.getBigDecimalValue(record.getAttribute("benefits"));
					}
				}
				panel.setEmployeeId(employeeId);
				panel.setStartDate(new Date("2016-01-01"));
				panel.setEndDate(new Date());
				panel.setLeftIntegral(leftIntegral);
				panel.setBenefits(benefits);
				panel.initComponents();
			}
		});
        tTab1.setPane(panel);  
  
        Tab tTab2 = new Tab("积分待确认"); 
        OnEmployeeIntegralBusinessPanel holidayPanel = new OnEmployeeIntegralBusinessPanel();
        tTab2.setPane(holidayPanel);  
  
        topTabSet.addTab(tTab1);  
        topTabSet.addTab(tTab2);  
  
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
