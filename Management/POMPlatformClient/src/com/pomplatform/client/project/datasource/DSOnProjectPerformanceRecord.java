package com.pomplatform.client.project.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnProjectPerformanceRecord extends DBDataSource
{


	public static DSOnProjectPerformanceRecord instance = null;

	public static DSOnProjectPerformanceRecord getInstance() {
		if(instance == null) {
			instance = new DSOnProjectPerformanceRecord("DSOnProjectPerformanceRecord");
		}
		return instance;
	}

	private final DataSourceIntegerField projectManagePerformanceTotalIdField;
	private final DataSourceTextField businessNameField;
	private final DataSourceFloatField performanceMoneyField;
	private final DataSourceDateField recordDateField;
	private final DataSourceDateTimeField recordTimeField;
	private final DataSourceTextField remarkField;

	public DSOnProjectPerformanceRecord(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("ProjectManagePerformanceTotal");


		projectManagePerformanceTotalIdField = new DataSourceIntegerField("projectManagePerformanceTotalId", "主键ID");
		projectManagePerformanceTotalIdField.setLength(11);
		projectManagePerformanceTotalIdField.setRequired(false);
		projectManagePerformanceTotalIdField.setHidden(true);


		businessNameField = new DataSourceTextField("businessName", "业务名称");
		businessNameField.setLength(64);
		businessNameField.setRequired(true);
		businessNameField.setHidden(false);


		performanceMoneyField = new DataSourceFloatField("performanceMoney", "绩效总金额");
		performanceMoneyField.setLength(18);
		performanceMoneyField.setDecimalPad(2);
		performanceMoneyField.setFormat("#,###,###,###,###,##0.00");
		performanceMoneyField.setRequired(true);
		performanceMoneyField.setHidden(false);


		recordDateField = new DataSourceDateField("recordDate", "记录日期");
		recordDateField.setLength(18);
		recordDateField.setRequired(true);
		recordDateField.setHidden(false);


		recordTimeField = new DataSourceDateTimeField("recordTime", "记录时间");
		recordTimeField.setRequired(true);
		recordTimeField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(true);
		remarkField.setHidden(false);



		setFields(projectManagePerformanceTotalIdField, businessNameField, performanceMoneyField, recordDateField, recordTimeField,remarkField);
	}


}

