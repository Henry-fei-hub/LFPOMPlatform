package com.pomplatform.client.plateprojectintegraldetail.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMplateProjectIntegralDetail extends DataSource
{


	public static CDMplateProjectIntegralDetail instance = null;

	public static CDMplateProjectIntegralDetail getInstance() {
		if(instance == null) {
			instance = new CDMplateProjectIntegralDetail("CDMplateProjectIntegralDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField subContractCodeField;
	private final DataSourceTextField subContractNameField;

	public CDMplateProjectIntegralDetail(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(64);
		projectCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		subContractCodeField = new DataSourceTextField("subContractCode", "子合同编号");
		subContractCodeField.setRequired(false);
		subContractCodeField.setLength(64);
		subContractCodeField.setHidden(false);

		subContractNameField = new DataSourceTextField("subContractName", "子合同名称");
		subContractNameField.setRequired(false);
		subContractNameField.setLength(64);
		subContractNameField.setHidden(false);

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


		setFields(plateIdField, projectCodeField, projectNameField, subContractCodeField, subContractNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

