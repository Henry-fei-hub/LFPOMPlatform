package com.pomplatform.client.contract.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDContractManage extends DataSource
{


	public static CDContractManage instance = null;

	public static CDContractManage getInstance() {
		if(instance == null) {
			instance = new CDContractManage("CDContractManage");
		}
		return instance;
	}

	private final DataSourceIntegerField signingCompanyNameField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField contractCodeField;

	public CDContractManage(String dataSourceID) {

		setID(dataSourceID);
		signingCompanyNameField = new DataSourceIntegerField("signingCompanyName", "签约公司");
		signingCompanyNameField.setRequired(false);
		signingCompanyNameField.setLength(11);
		signingCompanyNameField.setHidden(false);
		signingCompanyNameField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

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


		setFields(signingCompanyNameField, contractNameField, contractCodeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

