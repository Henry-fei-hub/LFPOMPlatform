package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDReportCostTotal extends DataSource
{


	public static CDReportCostTotal instance = null;

	public static CDReportCostTotal getInstance() {
		if(instance == null) {
			instance = new CDReportCostTotal("CDReportCostTotal");
		}
		return instance;
	}

	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField feeTypeField;
	private final DataSourceIntegerField plateIdField;

	public CDReportCostTotal(String dataSourceID) {

		setID(dataSourceID);
		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(false);
		yearField.setHidden(false);

		feeTypeField = new DataSourceIntegerField("feeType", "费用类型");
		feeTypeField.setRequired(false);
		feeTypeField.setLength(11);
		feeTypeField.setHidden(false);

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


		setFields(yearField, feeTypeField, plateIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

