package com.pomplatform.client.specialdeduction.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSspecialdeductionrecordsssor extends DataSource
{


	public static CDSspecialdeductionrecordsssor instance = null;

	public static CDSspecialdeductionrecordsssor getInstance() {
		if(instance == null) {
			instance = new CDSspecialdeductionrecordsssor("CDSspecialdeductionrecordsssor");
		}
		return instance;
	}

	private final DataSourceIntegerField employeIdField;
	private final DataSourceIntegerField deparmentIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceBooleanField isEnableField;

	public CDSspecialdeductionrecordsssor(String dataSourceID) {

		setID(dataSourceID);
		employeIdField = new DataSourceIntegerField("employeId", "纳税人id");
		employeIdField.setRequired(true);
		employeIdField.setLength(11);
		employeIdField.setHidden(false);

		deparmentIdField = new DataSourceIntegerField("deparmentId", "部门");
		deparmentIdField.setRequired(false);
		deparmentIdField.setLength(11);
		deparmentIdField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);

		isEnableField = new DataSourceBooleanField("isEnable", "是否可用");
		isEnableField.setRequired(false);
		isEnableField.setHidden(false);

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


		setFields(employeIdField, deparmentIdField, plateIdField, companyIdField, isEnableField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

