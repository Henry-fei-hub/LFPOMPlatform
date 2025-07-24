package com.pomplatform.client.contract.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDNewContractDistribution extends DataSource
{


	public static CDNewContractDistribution instance = null;

	public static CDNewContractDistribution getInstance() {
		if(instance == null) {
			instance = new CDNewContractDistribution("CDNewContractDistribution");
		}
		return instance;
	}

	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceIntegerField selectYearField;
	private final DataSourceIntegerField selectMonthField;
	private final DataSourceTextField businessTypeField;
	private final DataSourceIntegerField contractSigningStatusField;

	public CDNewContractDistribution(String dataSourceID) {

		setID(dataSourceID);
		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		selectYearField = new DataSourceIntegerField("selectYear", "年份");
		selectYearField.setRequired(true);
		selectYearField.setLength(11);
		selectYearField.setHidden(false);

		selectMonthField = new DataSourceIntegerField("selectMonth", "月份");
		selectMonthField.setRequired(true);
		selectMonthField.setLength(11);
		selectMonthField.setHidden(false);

		businessTypeField = new DataSourceTextField("businessType", "业务类别");
		businessTypeField.setRequired(false);
		businessTypeField.setLength(32);
		businessTypeField.setHidden(false);

		contractSigningStatusField = new DataSourceIntegerField("contractSigningStatus", "合同签订状态  1已寄出  2已签订");
		contractSigningStatusField.setRequired(false);
		contractSigningStatusField.setLength(11);
		contractSigningStatusField.setHidden(false);

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


		setFields(contractCodeField, contractNameField, selectYearField, selectMonthField, businessTypeField, contractSigningStatusField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

