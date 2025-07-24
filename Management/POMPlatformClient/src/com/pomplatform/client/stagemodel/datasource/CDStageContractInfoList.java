package com.pomplatform.client.stagemodel.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDStageContractInfoList extends DataSource
{


	public static CDStageContractInfoList instance = null;

	public static CDStageContractInfoList getInstance() {
		if(instance == null) {
			instance = new CDStageContractInfoList("CDStageContractInfoList");
		}
		return instance;
	}

	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceIntegerField contractStatusField;

	public CDStageContractInfoList(String dataSourceID) {

		setID(dataSourceID);
		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		contractStatusField = new DataSourceIntegerField("contractStatus", "合同状态");
		contractStatusField.setRequired(false);
		contractStatusField.setLength(11);
		contractStatusField.setHidden(false);
		contractStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

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


		setFields(contractCodeField, contractNameField, contractStatusField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

