package com.pomplatform.client.project.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSprojectpbpor extends DataSource
{


	public static CDSprojectpbpor instance = null;

	public static CDSprojectpbpor getInstance() {
		if(instance == null) {
			instance = new CDSprojectpbpor("CDSprojectpbpor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectTypeField;
	private final DataSourceIntegerField businessLineField;
	private final DataSourceIntegerField pricingTypeField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField plateIdField;

	public CDSprojectpbpor(String dataSourceID) {

		setID(dataSourceID);
		projectTypeField = new DataSourceIntegerField("projectType", "项目类别");
		projectTypeField.setRequired(false);
		projectTypeField.setLength(11);
		projectTypeField.setHidden(false);

		businessLineField = new DataSourceIntegerField("businessLine", "业务条线");
		businessLineField.setRequired(false);
		businessLineField.setLength(11);
		businessLineField.setHidden(false);

		pricingTypeField = new DataSourceIntegerField("pricingType", "定价类型");
		pricingTypeField.setRequired(false);
		pricingTypeField.setLength(11);
		pricingTypeField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(64);
		projectCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

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


		setFields(projectTypeField, businessLineField, pricingTypeField, contractCodeField, projectCodeField, projectNameField, plateIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

