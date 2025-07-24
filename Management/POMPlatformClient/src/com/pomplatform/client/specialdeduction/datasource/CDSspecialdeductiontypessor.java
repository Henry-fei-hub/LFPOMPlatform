package com.pomplatform.client.specialdeduction.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSspecialdeductiontypessor extends DataSource
{


	public static CDSspecialdeductiontypessor instance = null;

	public static CDSspecialdeductiontypessor getInstance() {
		if(instance == null) {
			instance = new CDSspecialdeductiontypessor("CDSspecialdeductiontypessor");
		}
		return instance;
	}

	private final DataSourceTextField specialDeductionTypeNameField;
	private final DataSourceIntegerField specialDeductionTypeIdField;

	public CDSspecialdeductiontypessor(String dataSourceID) {

		setID(dataSourceID);
		specialDeductionTypeNameField = new DataSourceTextField("specialDeductionTypeName", "个税专项扣除类型名称");
		specialDeductionTypeNameField.setRequired(true);
		specialDeductionTypeNameField.setLength(64);
		specialDeductionTypeNameField.setHidden(false);

		specialDeductionTypeIdField = new DataSourceIntegerField("specialDeductionTypeId", "id");
		specialDeductionTypeIdField.setRequired(true);
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


		setFields(specialDeductionTypeNameField, specialDeductionTypeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

