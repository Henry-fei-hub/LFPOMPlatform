package com.pomplatform.client.specialdeduction.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSspecialdeductiondetailor extends DataSource
{


	public static CDSspecialdeductiondetailor instance = null;

	public static CDSspecialdeductiondetailor getInstance() {
		if(instance == null) {
			instance = new CDSspecialdeductiondetailor("CDSspecialdeductiondetailor");
		}
		return instance;
	}

	private final DataSourceIntegerField parentIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField specialDeductionTypeIdField;

	public CDSspecialdeductiondetailor(String dataSourceID) {

		setID(dataSourceID);
		parentIdField = new DataSourceIntegerField("parentId", "父id");
		parentIdField.setRequired(true);
		parentIdField.setLength(11);
		parentIdField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "扣除年度");
		yearField.setRequired(false);
		yearField.setLength(11);
		yearField.setHidden(false);

		specialDeductionTypeIdField = new DataSourceIntegerField("specialDeductionTypeId", "专项类型");
		specialDeductionTypeIdField.setRequired(false);
		specialDeductionTypeIdField.setLength(11);
		specialDeductionTypeIdField.setHidden(false);

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


		setFields(parentIdField, yearField, specialDeductionTypeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

