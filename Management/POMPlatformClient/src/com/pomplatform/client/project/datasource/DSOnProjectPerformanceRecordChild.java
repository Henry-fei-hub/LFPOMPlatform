package com.pomplatform.client.project.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnProjectPerformanceRecordChild extends DBDataSource
{


	public static DSOnProjectPerformanceRecordChild instance = null;

	public static DSOnProjectPerformanceRecordChild getInstance() {
		if(instance == null) {
			instance = new DSOnProjectPerformanceRecordChild("DSOnProjectPerformanceRecord");
		}
		return instance;
	}

	private final DataSourceIntegerField objectIdField;
	private final DataSourceTextField objectNoField;
	private final DataSourceTextField objectNameField;
	private final DataSourceTextField businessNameField;
	private final DataSourceFloatField performanceMoneyField;
	private final DataSourceDateField recordDateField;
	private final DataSourceDateTimeField recordTimeField;
	private final DataSourceTextField remarkField;

	public DSOnProjectPerformanceRecordChild(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("ProjectManagePerformanceRecord");


		objectIdField = new DataSourceIntegerField("objectId", "对象Id");
		objectIdField.setLength(11);
		objectIdField.setRequired(false);
		objectIdField.setHidden(true);


		objectNoField = new DataSourceTextField("objectNo", "编号");
		objectNoField.setLength(64);
		objectNoField.setRequired(true);
		objectNoField.setHidden(false);


		objectNameField = new DataSourceTextField("objectName", "名称");
		objectNameField.setLength(64);
		objectNameField.setRequired(true);
		objectNameField.setHidden(false);
		
		businessNameField = new DataSourceTextField("businessName", "业务模块名称");
		businessNameField.setLength(64);
		businessNameField.setRequired(true);
		businessNameField.setHidden(false);

		performanceMoneyField = new DataSourceFloatField("performanceMoney", "绩效金额");
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



		setFields(objectIdField, objectNoField, objectNameField, businessNameField,performanceMoneyField, recordDateField, recordTimeField,remarkField);
	}


}

