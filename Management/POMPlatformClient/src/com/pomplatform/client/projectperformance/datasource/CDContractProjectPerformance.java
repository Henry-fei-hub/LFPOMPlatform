package com.pomplatform.client.projectperformance.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDContractProjectPerformance extends DataSource
{


	public static CDContractProjectPerformance instance = null;

	public static CDContractProjectPerformance getInstance() {
		if(instance == null) {
			instance = new CDContractProjectPerformance("CDContractProjectPerformance");
		}
		return instance;
	}

	private final DataSourceTextField contractCodeField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField projectManageIdField;
	private final DataSourceIntegerField plateIdField;

	public CDContractProjectPerformance(String dataSourceID) {

		setID(dataSourceID);
		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);
//		contractCodeField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractCodeField);

		contractIdField = new DataSourceIntegerField("contractId", "合同名称");
		contractIdField.setRequired(true);
		contractIdField.setLength(11);
		contractIdField.setPrimaryKey(true);
		contractIdField.setHidden(true);
//		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractCodeField);

		projectManageIdField = new DataSourceIntegerField("projectManageId", "项目经理");
		projectManageIdField.setRequired(false);
		projectManageIdField.setLength(11);
		projectManageIdField.setHidden(false);
//		projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees",projectManageIdField);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

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


		setFields(contractCodeField, contractIdField, projectManageIdField, plateIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

