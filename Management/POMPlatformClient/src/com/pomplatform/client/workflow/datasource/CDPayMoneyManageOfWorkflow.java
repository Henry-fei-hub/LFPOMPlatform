package com.pomplatform.client.workflow.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDPayMoneyManageOfWorkflow extends DataSource
{


	public static CDPayMoneyManageOfWorkflow instance = null;

	public static CDPayMoneyManageOfWorkflow getInstance() {
		if(instance == null) {
			instance = new CDPayMoneyManageOfWorkflow("CDPayMoneyManageOfWorkflow");
		}
		return instance;
	}

	private final DataSourceTextField receiveUnitField;
	private final DataSourceTextField bankAccountField;
	private final DataSourceTextField bankNameField;
	private final DataSourceIntegerField employeeIdField;

	public CDPayMoneyManageOfWorkflow(String dataSourceID) {

		setID(dataSourceID);
		receiveUnitField = new DataSourceTextField("receiveUnit", "收款单位");
		receiveUnitField.setRequired(false);
		receiveUnitField.setLength(128);
		receiveUnitField.setHidden(false);

		bankAccountField = new DataSourceTextField("bankAccount", "银行账号");
		bankAccountField.setRequired(false);
		bankAccountField.setLength(64);
		bankAccountField.setHidden(false);

		bankNameField = new DataSourceTextField("bankName", "开户行");
		bankNameField.setRequired(false);
		bankNameField.setLength(128);
		bankNameField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "申请人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(receiveUnitField, bankAccountField, bankNameField, employeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

