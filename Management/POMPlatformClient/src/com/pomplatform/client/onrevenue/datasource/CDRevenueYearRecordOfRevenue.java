package com.pomplatform.client.onrevenue.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDRevenueYearRecordOfRevenue extends DataSource
{


	public static CDRevenueYearRecordOfRevenue instance = null;

	public static CDRevenueYearRecordOfRevenue getInstance() {
		if(instance == null) {
			instance = new CDRevenueYearRecordOfRevenue("CDRevenueYearRecordOfRevenue");
		}
		return instance;
	}

	private final DataSourceIntegerField signingCompanyField;
	private final DataSourceBooleanField isFinishField;
	private final DataSourceIntegerField yearRevenueField;
	private final DataSourceIntegerField parentIdField;

	public CDRevenueYearRecordOfRevenue(String dataSourceID) {

		setID(dataSourceID);
		signingCompanyField = new DataSourceIntegerField("signingCompany", "签约公司");
		signingCompanyField.setRequired(false);
		signingCompanyField.setLength(11);
		signingCompanyField.setHidden(false);
		signingCompanyField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		isFinishField = new DataSourceBooleanField("isFinish", "合同是否完成");
		isFinishField.setRequired(false);
		isFinishField.setHidden(false);

		yearRevenueField = new DataSourceIntegerField("yearRevenue", "年度");
		yearRevenueField.setRequired(false);
		yearRevenueField.setLength(11);
		yearRevenueField.setHidden(false);

		parentIdField = new DataSourceIntegerField("parentId", "父级编码");
		parentIdField.setRequired(false);
		parentIdField.setLength(11);
		parentIdField.setHidden(false);

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


		setFields(signingCompanyField, isFinishField, yearRevenueField, parentIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

