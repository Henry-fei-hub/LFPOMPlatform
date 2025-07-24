package com.pomplatform.client.activitympcor.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSactivityMpcor extends DBDataSource
{


	public static DSSactivityMpcor instance = null;

	public static DSSactivityMpcor getInstance() {
		if(instance == null) {
			instance = new DSSactivityMpcor("DSSactivityMpcor");
		}
		return instance;
	}

	private final DataSourceIntegerField activitieIdField;
	private final DataSourceIntegerField mainProjectIdField;
	private final DataSourceIntegerField customerIdField;
	private final DataSourceTextField customerNameField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField meetTypeField;
	private final DataSourceDateTimeField meetTimeField;
	private final DataSourceTextField meetAddressField;
	private final DataSourceTextField meetTitleField;
	private final DataSourceTextField meetTargetField;
	private final DataSourceTextField contactNameField;
	private final DataSourceTextField theirRequireField;
	private final DataSourceTextField theirEmployeesField;
	private final DataSourceTextField ourEmployeesField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField ourDesignerEmployeesField;
	private final DataSourceTextField provinceField;
	private final DataSourceTextField cityField;
	private final DataSourceDateTimeField outTimeStartField;
	private final DataSourceDateTimeField outTimeEndField;

	public DSSactivityMpcor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SactivityMpcor");


		activitieIdField = new DataSourceIntegerField("activitieId", "主键编码");
		activitieIdField.setLength(11);
		activitieIdField.setPrimaryKey(true);
		activitieIdField.setRequired(true);
		activitieIdField.setHidden(true);


		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "项目编码");
		mainProjectIdField.setLength(11);
		mainProjectIdField.setRequired(false);
		mainProjectIdField.setHidden(true);


		customerIdField = new DataSourceIntegerField("customerId", "客户Id");
		customerIdField.setLength(11);
		customerIdField.setRequired(false);
		customerIdField.setHidden(true);


		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setLength(64);
		customerNameField.setRequired(false);
		customerNameField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(64);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		meetTypeField = new DataSourceIntegerField("meetType", "会议类型");
		meetTypeField.setLength(11);
		meetTypeField.setRequired(false);
		meetTypeField.setHidden(false);
		meetTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_150"));


		meetTimeField = new DataSourceDateTimeField("meetTime", "会议时间");
		meetTimeField.setRequired(false);
		meetTimeField.setHidden(false);


		meetAddressField = new DataSourceTextField("meetAddress", "会议详细地址");
		meetAddressField.setLength(128);
		meetAddressField.setRequired(false);
		meetAddressField.setHidden(false);


		meetTitleField = new DataSourceTextField("meetTitle", "会议主题");
		meetTitleField.setLength(128);
		meetTitleField.setRequired(false);
		meetTitleField.setHidden(false);


		meetTargetField = new DataSourceTextField("meetTarget", "会议目标");
		meetTargetField.setLength(512);
		meetTargetField.setRequired(false);
		meetTargetField.setHidden(true);


		contactNameField = new DataSourceTextField("contactName", "联系人");
		contactNameField.setLength(128);
		contactNameField.setRequired(false);
		contactNameField.setHidden(false);


		theirRequireField = new DataSourceTextField("theirRequire", "甲方要求");
		theirRequireField.setLength(512);
		theirRequireField.setRequired(false);
		theirRequireField.setHidden(true);


		theirEmployeesField = new DataSourceTextField("theirEmployees", "甲方出席人员");
		theirEmployeesField.setLength(512);
		theirEmployeesField.setRequired(false);
		theirEmployeesField.setHidden(false);

		ourEmployeesField = new DataSourceTextField("ourEmployees", "我方营销出席人员");
		ourEmployeesField.setLength(512);
		ourEmployeesField.setRequired(false);
		ourEmployeesField.setHidden(false);
         
		ourDesignerEmployeesField = new DataSourceTextField("ourDesignerEmployees", "我方设计出席人员");
		ourDesignerEmployeesField.setLength(512);
		ourDesignerEmployeesField.setRequired(false);
		ourDesignerEmployeesField.setHidden(false);	
		

		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(false);
		operateEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		
		departmentIdField = new DataSourceIntegerField("departmentId", "营销团队");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);
    
		
		provinceField = new DataSourceTextField("province", "会议地址（省）");
		provinceField.setLength(32);
		provinceField.setRequired(false);
		provinceField.setHidden(false);


		cityField = new DataSourceTextField("city", "会议地址（市）");
		cityField.setLength(32);
		cityField.setRequired(false);
		cityField.setHidden(false);
		
		outTimeStartField = new DataSourceDateTimeField("outTimeStart", "外出开始时间");
		outTimeStartField.setRequired(false);
		outTimeStartField.setHidden(false);


		outTimeEndField = new DataSourceDateTimeField("outTimeEnd", "外出结束时间");
		outTimeEndField.setRequired(false);
		outTimeEndField.setHidden(false);

		setFields(activitieIdField, mainProjectIdField, customerIdField, customerNameField, projectNameField,meetTypeField,meetTimeField,outTimeStartField,outTimeEndField,provinceField,cityField,meetAddressField, meetTitleField, meetTargetField, contactNameField, theirRequireField, theirEmployeesField, ourEmployeesField, ourDesignerEmployeesField,operateEmployeeIdField, operateTimeField, departmentIdField,remarkField);
	}


}

