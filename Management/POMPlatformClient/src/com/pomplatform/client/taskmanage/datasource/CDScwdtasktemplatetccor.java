package com.pomplatform.client.taskmanage.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDScwdtasktemplatetccor extends DataSource
{


	public static CDScwdtasktemplatetccor instance = null;

	public static CDScwdtasktemplatetccor getInstance() {
		if(instance == null) {
			instance = new CDScwdtasktemplatetccor("CDScwdtasktemplatetccor");
		}
		return instance;
	}

	private final DataSourceTextField templateNameField;
	private final DataSourceTextField companyNoField;
	private final DataSourceIntegerField cwdTaskTemplateIdField;
	private final DataSourceIntegerField projectAreaField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField numberOfDayField;
	private final DataSourceIntegerField projectLevelField;
	private final DataSourceIntegerField numberOfParticipantField;

	public CDScwdtasktemplatetccor(String dataSourceID) {

		setID(dataSourceID);
		templateNameField = new DataSourceTextField("templateName", "模板名称");
		templateNameField.setRequired(false);
		templateNameField.setLength(255);
		templateNameField.setHidden(false);

		companyNoField = new DataSourceTextField("companyNo", "公司编号");
		companyNoField.setRequired(false);
		companyNoField.setLength(64);
		companyNoField.setHidden(false);

		cwdTaskTemplateIdField = new DataSourceIntegerField("cwdTaskTemplateId", "主键");
		cwdTaskTemplateIdField.setRequired(true);
		cwdTaskTemplateIdField.setLength(11);
		cwdTaskTemplateIdField.setPrimaryKey(true);
		cwdTaskTemplateIdField.setHidden(true);

		projectAreaField = new DataSourceIntegerField("projectArea", "项目面积");
		projectAreaField.setRequired(false);
		projectAreaField.setLength(11);
		projectAreaField.setHidden(false);

		operatorField = new DataSourceIntegerField("operator", "操作人");
		operatorField.setRequired(false);
		operatorField.setLength(11);
		operatorField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		companyIdField = new DataSourceIntegerField("companyId", "归属公司编码");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		numberOfDayField = new DataSourceIntegerField("numberOfDay", "天数(周期)");
		numberOfDayField.setRequired(false);
		numberOfDayField.setLength(11);
		numberOfDayField.setHidden(false);

		projectLevelField = new DataSourceIntegerField("projectLevel", "项目类型(5A写字楼等等)");
		projectLevelField.setRequired(false);
		projectLevelField.setLength(11);
		projectLevelField.setHidden(false);

		numberOfParticipantField = new DataSourceIntegerField("numberOfParticipant", "参与人数");
		numberOfParticipantField.setRequired(false);
		numberOfParticipantField.setLength(11);
		numberOfParticipantField.setHidden(false);

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


		setFields(templateNameField, companyNoField, cwdTaskTemplateIdField, projectAreaField, operatorField, departmentIdField, companyIdField, numberOfDayField, projectLevelField, numberOfParticipantField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

