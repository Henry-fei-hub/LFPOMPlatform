package com.pomplatform.client.selectgrid.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSelectGridPreProjectValue extends DBDataSource
{


	public static DSSelectGridPreProjectValue instance = null;

	public static DSSelectGridPreProjectValue getInstance() {
		if(instance == null) {
			instance = new DSSelectGridPreProjectValue("DSSelectGridPreProjectValue");
		}
		return instance;
	}

	private final DataSourceIntegerField preProjectReimbursementNumberIdField;
	private final DataSourceTextField customNumberField;
	private final DataSourceIntegerField projectManagerField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField preProjectTypeField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField preBusinessTypeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField infoCodeField;

	public DSSelectGridPreProjectValue(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SelectGridPreProjectValue");


		preProjectReimbursementNumberIdField = new DataSourceIntegerField("preProjectReimbursementNumberId", "主键编码");
		preProjectReimbursementNumberIdField.setLength(11);
		preProjectReimbursementNumberIdField.setPrimaryKey(true);
		preProjectReimbursementNumberIdField.setRequired(true);
		preProjectReimbursementNumberIdField.setHidden(false);


		customNumberField = new DataSourceTextField("customNumber", "前期项目信息编号");
		customNumberField.setLength(32);
		customNumberField.setRequired(false);
		customNumberField.setHidden(false);


		projectManagerField = new DataSourceIntegerField("projectManager", "项目经理(用来指定这个项目的项目经理)");
		projectManagerField.setLength(11);
		projectManagerField.setRequired(false);
		projectManagerField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(true);
		remarkField.setHidden(false);


		preProjectTypeField = new DataSourceIntegerField("preProjectType", "项目类别");
		preProjectTypeField.setLength(11);
		preProjectTypeField.setRequired(false);
		preProjectTypeField.setHidden(false);


		plateIdField = new DataSourceIntegerField("plateId", "板块");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);


		preBusinessTypeField = new DataSourceIntegerField("preBusinessType", "业务类别");
		preBusinessTypeField.setLength(11);
		preBusinessTypeField.setRequired(false);
		preBusinessTypeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(32);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(false);


		setFields(preProjectReimbursementNumberIdField, customNumberField, projectManagerField, createTimeField, remarkField, preProjectTypeField, plateIdField, preBusinessTypeField, projectNameField, projectCodeField, infoCodeField);
	}


}

