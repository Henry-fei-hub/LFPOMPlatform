package com.pomplatform.client.contract.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDContractAmountAnalyze extends DataSource
{


	public static CDContractAmountAnalyze instance = null;

	public static CDContractAmountAnalyze getInstance() {
		if(instance == null) {
			instance = new CDContractAmountAnalyze("CDContractAmountAnalyze");
		}
		return instance;
	}

	private final DataSourceIntegerField contractSigningStatusField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField plateIdField;

	public CDContractAmountAnalyze(String dataSourceID) {

		setID(dataSourceID);
		contractSigningStatusField = new DataSourceIntegerField("contractSigningStatus", "合同签订状态");
		contractSigningStatusField.setRequired(false);
		contractSigningStatusField.setLength(11);
		contractSigningStatusField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(true);
		yearField.setLength(11);
		yearField.setHidden(false);
		yearField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

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


		setFields(contractSigningStatusField, yearField, plateIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

