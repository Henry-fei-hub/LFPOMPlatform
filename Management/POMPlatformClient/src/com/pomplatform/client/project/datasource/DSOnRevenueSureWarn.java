package com.pomplatform.client.project.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceImageField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnRevenueSureWarn extends DBDataSource
{


	public static DSOnRevenueSureWarn instance = null;

	public static DSOnRevenueSureWarn getInstance() {
		if(instance == null) {
			instance = new DSOnRevenueSureWarn("DSOnRevenueSureWarn");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField projectNumField;
	private final DataSourceFloatField sureIntegralField;
	private final DataSourceDateField sureDateField;
	private final DataSourceDateTimeField weekDateField;
	private final DataSourceIntegerField warnFlagField;
	private final DataSourceImageField warnImgField;

	public DSOnRevenueSureWarn(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnRevenueSureWarn");


		employeeIdField = new DataSourceIntegerField("employeeId", "结算操作人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		projectNumField = new DataSourceIntegerField("projectNum", "管理项目数");
		projectNumField.setLength(11);
		projectNumField.setRequired(true);
		projectNumField.setHidden(false);


		sureIntegralField = new DataSourceFloatField("sureIntegral", "本周累计确认积分");
		sureIntegralField.setLength(18);
		sureIntegralField.setDecimalPad(2);
		sureIntegralField.setFormat("#,###,###,###,###,##0.00");
		sureIntegralField.setRequired(true);
		sureIntegralField.setHidden(false);


		sureDateField = new DataSourceDateField("sureDate", "本周最晚确认日期");
		sureDateField.setLength(18);
		sureDateField.setRequired(true);
		sureDateField.setHidden(false);


		weekDateField = new DataSourceDateTimeField("weekDate", "每周一");
		weekDateField.setRequired(true);
		weekDateField.setHidden(true);


		warnFlagField = new DataSourceIntegerField("warnFlag", "报价标示");
		warnFlagField.setLength(11);
		warnFlagField.setRequired(true);
		warnFlagField.setHidden(true);


		warnImgField = new DataSourceImageField("warnImg", "警示");
		warnImgField.setLength(11);
		warnImgField.setImageHeight(16);
		warnImgField.setImageWidth(16);
		warnImgField.setRequired(true);
		warnImgField.setHidden(false);


		setFields(warnImgField,employeeIdField, employeeNoField, employeeNameField, plateIdField, projectNumField, sureIntegralField, sureDateField, weekDateField, warnFlagField);
	}


}

