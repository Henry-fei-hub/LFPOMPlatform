package com.pomplatform.client.employee.moneyManage.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSEmployeeMoneyHistoryRecord extends DBDataSource
{


	public static DSEmployeeMoneyHistoryRecord instance = null;

	public static DSEmployeeMoneyHistoryRecord getInstance() {
		if(instance == null) {
			instance = new DSEmployeeMoneyHistoryRecord("DSEmployeeMoneyHistoryRecord");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceDateField borrowDateField;
	private final DataSourceTextField titleNameField;
	private final DataSourceFloatField borrowMoneyField;
	private final DataSourceTextField reasonField;

	public DSEmployeeMoneyHistoryRecord(String dataSourceID) {

		super();
		setID(dataSourceID);

		employeeIdField = new DataSourceIntegerField("employeeId", "姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
//		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees",employeeIdField);


		borrowDateField = new DataSourceDateField("borrowDate", "日期");
		borrowDateField.setLength(64);
		borrowDateField.setRequired(false);
		borrowDateField.setHidden(false);


		titleNameField = new DataSourceTextField("titleName", "主题");
		titleNameField.setLength(64);
		titleNameField.setRequired(false);
		titleNameField.setHidden(false);


		borrowMoneyField = new DataSourceFloatField("borrowMoney", "金额");
		borrowMoneyField.setLength(18);
		borrowMoneyField.setDecimalPad(2);
		borrowMoneyField.setFormat("#,###,###,###,###,##0.00");
		borrowMoneyField.setRequired(false);
		borrowMoneyField.setHidden(false);
		
		reasonField = new DataSourceTextField("reason", "具体事由");
		reasonField.setLength(256);
		reasonField.setRequired(false);
		reasonField.setHidden(false);


		setFields(employeeIdField, borrowDateField, titleNameField, borrowMoneyField, reasonField);
	}


}

