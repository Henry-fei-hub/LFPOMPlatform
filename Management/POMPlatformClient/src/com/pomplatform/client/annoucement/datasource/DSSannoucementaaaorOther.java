package com.pomplatform.client.annoucement.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;

import javax.net.ssl.KeyManager;

import com.delicacy.client.data.DBDataSource;

public class DSSannoucementaaaorOther extends DBDataSource
{


	public static DSSannoucementaaaorOther instance = null;

	public static DSSannoucementaaaorOther getInstance() {
		if(instance == null) {
			instance = new DSSannoucementaaaorOther("DSSannoucementaaaor");
		}
		return instance;
	}

	private final DataSourceIntegerField annoucementIdField;
	private final DataSourceIntegerField mainProjectIdField;
	private final DataSourceIntegerField customerIdField;
	private final DataSourceTextField annoucementTitleField;
	private final DataSourceTextField annoucementContentField;
	private final DataSourceDateTimeField annoucementTimeField;
	private final DataSourceTextField annoucementEmployeeIdsField;
	private final DataSourceTextField annoucementEmployeeNamesField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField remarkField;

	public DSSannoucementaaaorOther(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("OtherAnnoucementProcess");


		annoucementIdField = new DataSourceIntegerField("annoucementId", "主键编码");
		annoucementIdField.setLength(11);
		annoucementIdField.setPrimaryKey(true);
		annoucementIdField.setRequired(true);
		annoucementIdField.setHidden(true);


		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "项目编码");
		mainProjectIdField.setLength(11);
		mainProjectIdField.setRequired(false);
		mainProjectIdField.setHidden(true);


		customerIdField = new DataSourceIntegerField("customerId", "客户Id");
		customerIdField.setLength(11);
		customerIdField.setRequired(false);
		customerIdField.setHidden(true);


		annoucementTitleField = new DataSourceTextField("annoucementTitle", "公告主题");
		annoucementTitleField.setLength(128);
		annoucementTitleField.setRequired(false);
		annoucementTitleField.setHidden(false);


		annoucementContentField = new DataSourceTextField("annoucementContent", "公告内容");
		annoucementContentField.setLength(20480);
		annoucementContentField.setRequired(false);
		annoucementContentField.setHidden(false);


		annoucementTimeField = new DataSourceDateTimeField("annoucementTime", "公告时间");
		annoucementTimeField.setRequired(false);
		annoucementTimeField.setHidden(false);


		annoucementEmployeeIdsField = new DataSourceTextField("annoucementEmployeeIds", "公告人员Id集");
		annoucementEmployeeIdsField.setLength(512);
		annoucementEmployeeIdsField.setRequired(false);
		annoucementEmployeeIdsField.setHidden(true);


		annoucementEmployeeNamesField = new DataSourceTextField("annoucementEmployeeNames", "公告人员");
		annoucementEmployeeNamesField.setLength(512);
		annoucementEmployeeNamesField.setRequired(false);
		annoucementEmployeeNamesField.setHidden(false);


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "发起人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(false);
		operateEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(annoucementIdField, mainProjectIdField, customerIdField, annoucementTitleField, annoucementContentField, annoucementEmployeeIdsField, annoucementEmployeeNamesField, operateEmployeeIdField, operateTimeField, remarkField, annoucementTimeField);
	}


}

