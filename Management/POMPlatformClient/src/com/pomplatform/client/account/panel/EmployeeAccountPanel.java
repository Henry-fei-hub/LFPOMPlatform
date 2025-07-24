package com.pomplatform.client.account.panel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.pomplatform.client.ERPPermissionStatic;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.Canvas;  
  
public class EmployeeAccountPanel extends DelicacyPanel {

	private static Logger __logger = Logger.getLogger("");

	@SuppressWarnings("deprecation")
	@Override
	public Canvas getViewPanel() {
		// 如果拥有查看所有部门数据，则加载所有数据
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.PERSONAL_ACCOUNT_MANAGEMENT_CHECK_ALL_DATA) || ClientUtil.checkIsHavePermission(ERPPermissionStatic.PERSONAL_ACCOUNT_MANAGEMENT_CHECK_MYPLATE_DATA) ) {
			//查看自己管理的部门的人员信息
			EmployeeAccountAllPanel panel = new EmployeeAccountAllPanel();
			return panel;
		}else{
			//查看自己的信息
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
			return panel;
		}
	}

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			EmployeeAccountPanel cm = new EmployeeAccountPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "PlateAccountPanel";
		}

	}

}