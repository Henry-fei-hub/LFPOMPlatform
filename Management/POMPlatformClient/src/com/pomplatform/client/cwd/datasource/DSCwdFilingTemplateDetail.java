package com.pomplatform.client.cwd.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSCwdFilingTemplateDetail extends DBDataSource
{


	public static DSCwdFilingTemplateDetail instance = null;

	public static DSCwdFilingTemplateDetail getInstance() {
		if(instance == null) {
			instance = new DSCwdFilingTemplateDetail("DSCwdFilingTemplateDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField cwdFilingTemplateDetailIdField;
	private final DataSourceTextField fileNameField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceIntegerField cwdFilingTemplateIdField;
	private final DataSourceIntegerField operatorIdField;
	private final DataSourceDateTimeField createTimeField;

	public DSCwdFilingTemplateDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("CwdFilingTemplateDetail");


		cwdFilingTemplateDetailIdField = new DataSourceIntegerField("cwdFilingTemplateDetailId", "");
		cwdFilingTemplateDetailIdField.setLength(11);
		cwdFilingTemplateDetailIdField.setPrimaryKey(true);
		cwdFilingTemplateDetailIdField.setRequired(true);
		cwdFilingTemplateDetailIdField.setHidden(false);


		fileNameField = new DataSourceTextField("fileName", "文档名称");
		fileNameField.setLength(255);
		fileNameField.setRequired(false);
		fileNameField.setHidden(false);


		parentIdField = new DataSourceIntegerField("parentId", "父级id");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setForeignKey(dataSourceID+".cwdFilingTemplateDetailId");
		parentIdField.setRootValue("0");
		parentIdField.setHidden(false);


		cwdFilingTemplateIdField = new DataSourceIntegerField("cwdFilingTemplateId", "模板主键");
		cwdFilingTemplateIdField.setLength(11);
		cwdFilingTemplateIdField.setRequired(false);
		cwdFilingTemplateIdField.setHidden(false);


		operatorIdField = new DataSourceIntegerField("operatorId", "操作人");
		operatorIdField.setLength(11);
		operatorIdField.setRequired(false);
		operatorIdField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		setFields(cwdFilingTemplateDetailIdField, fileNameField, parentIdField, cwdFilingTemplateIdField, operatorIdField, createTimeField);
	}


}

