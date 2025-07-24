package com.pomplatform.client.aboutprojectquotetemplatesparent.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSAboutProjectQuoteTemplatesParent extends DBDataSource
{


	public static DSAboutProjectQuoteTemplatesParent instance = null;

	public static DSAboutProjectQuoteTemplatesParent getInstance() {
		if(instance == null) {
			instance = new DSAboutProjectQuoteTemplatesParent("DSAboutProjectQuoteTemplatesParent");
		}
		return instance;
	}

	private final DataSourceIntegerField projectQuoteTemplatesParentIdField;
	private final DataSourceTextField parentNameField;
	private final DataSourceIntegerField businessTypeField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField createEmployeeIdField;
	private final DataSourceDateField createDateField;
	private final DataSourceTextField remarkField;

	public DSAboutProjectQuoteTemplatesParent(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("AboutProjectQuoteTemplatesParent");


		projectQuoteTemplatesParentIdField = new DataSourceIntegerField("projectQuoteTemplatesParentId", "主键编码");
		projectQuoteTemplatesParentIdField.setLength(11);
		projectQuoteTemplatesParentIdField.setPrimaryKey(true);
		projectQuoteTemplatesParentIdField.setRequired(true);
		projectQuoteTemplatesParentIdField.setHidden(true);


		parentNameField = new DataSourceTextField("parentName", "模板名称");
		parentNameField.setLength(128);
		parentNameField.setRequired(false);
		parentNameField.setHidden(false);


		businessTypeField = new DataSourceIntegerField("businessType", "业务类别");
		KeyValueManager.loadValueMap("pre_business_type",businessTypeField);
		businessTypeField.setLength(11);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(false);


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		KeyValueManager.loadValueMap("company_records", companyIdField);
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);


		createEmployeeIdField = new DataSourceIntegerField("createEmployeeId", "创建人");
		KeyValueManager.loadValueMap("employees", createEmployeeIdField);
		createEmployeeIdField.setLength(11);
		createEmployeeIdField.setRequired(false);
		createEmployeeIdField.setHidden(false);


		createDateField = new DataSourceDateField("createDate", "创建日期");
		createDateField.setRequired(false);
		createDateField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(2048);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(projectQuoteTemplatesParentIdField, parentNameField, businessTypeField, companyIdField, createEmployeeIdField, createDateField, remarkField);
	}


}

