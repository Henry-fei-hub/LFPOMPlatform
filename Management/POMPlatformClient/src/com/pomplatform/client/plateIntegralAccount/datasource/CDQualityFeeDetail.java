package com.pomplatform.client.plateIntegralAccount.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDQualityFeeDetail extends DataSource
{


	public static CDQualityFeeDetail instance = null;

	public static CDQualityFeeDetail getInstance() {
		if(instance == null) {
			instance = new CDQualityFeeDetail("CDQualityFeeDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField fromPlateIdField;
	private final DataSourceIntegerField toPlateIdField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;

	public CDQualityFeeDetail(String dataSourceID) {

		setID(dataSourceID);
		fromPlateIdField = new DataSourceIntegerField("fromPlateId", "积分提取部门");
		fromPlateIdField.setRequired(false);
		fromPlateIdField.setLength(11);
		fromPlateIdField.setHidden(false);
		fromPlateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));

		toPlateIdField = new DataSourceIntegerField("toPlateId", "积分发放部门");
		toPlateIdField.setRequired(false);
		toPlateIdField.setLength(11);
		toPlateIdField.setHidden(false);
		toPlateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));

		startDateField = new DataSourceDateField("startDate", "开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateField("endDate", "截止日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

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


		setFields(fromPlateIdField, toPlateIdField, startDateField, endDateField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

