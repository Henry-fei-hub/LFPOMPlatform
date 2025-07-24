package com.pomplatform.client.cwd.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDScwdfilingmaintemplatetrcor extends DataSource
{


	public static CDScwdfilingmaintemplatetrcor instance = null;

	public static CDScwdfilingmaintemplatetrcor getInstance() {
		if(instance == null) {
			instance = new CDScwdfilingmaintemplatetrcor("CDScwdfilingmaintemplatetrcor");
		}
		return instance;
	}

	private final DataSourceTextField templateNameField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField cwdFilingMainTemplateIdField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceIntegerField operatorIdField;
	private final DataSourceIntegerField departmentIdField;

	public CDScwdfilingmaintemplatetrcor(String dataSourceID) {

		setID(dataSourceID);
		templateNameField = new DataSourceTextField("templateName", "模板名称");
		templateNameField.setRequired(false);
		templateNameField.setLength(255);
		templateNameField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(255);
		remarkField.setHidden(false);

		cwdFilingMainTemplateIdField = new DataSourceIntegerField("cwdFilingMainTemplateId", "主键");
		cwdFilingMainTemplateIdField.setRequired(true);
		cwdFilingMainTemplateIdField.setLength(11);
		cwdFilingMainTemplateIdField.setPrimaryKey(true);
		cwdFilingMainTemplateIdField.setHidden(true);

		projectTypeField = new DataSourceIntegerField("projectType", "项目类型");
		projectTypeField.setRequired(false);
		projectTypeField.setLength(11);
		projectTypeField.setHidden(false);

		operatorIdField = new DataSourceIntegerField("operatorId", "操作人");
		operatorIdField.setRequired(false);
		operatorIdField.setLength(11);
		operatorIdField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门编码");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

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


		setFields(templateNameField, remarkField, cwdFilingMainTemplateIdField, projectTypeField, operatorIdField, departmentIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

