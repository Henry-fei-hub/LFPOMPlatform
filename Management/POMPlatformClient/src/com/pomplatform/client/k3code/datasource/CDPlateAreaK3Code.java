package com.pomplatform.client.k3code.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class CDPlateAreaK3Code extends DataSource {

	public static CDPlateAreaK3Code instance = null;

	public static CDPlateAreaK3Code getInstance() {
		if (instance == null) {
			instance = new CDPlateAreaK3Code("CDPlateAreaK3Code");
		}
		return instance;
	}

	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField k3CodeField;
	private final DataSourceIntegerField additionalBusinessIdField;

	public CDPlateAreaK3Code(String dataSourceID) {

		setID(dataSourceID);
		businessIdField = new DataSourceIntegerField("businessId", "业务部门");
		businessIdField.setRequired(false);
		businessIdField.setLength(11);
		businessIdField.setHidden(false);

		k3CodeField = new DataSourceTextField("k3Code", "K3代码");
		k3CodeField.setRequired(false);
		k3CodeField.setLength(64);
		k3CodeField.setHidden(false);
		
		additionalBusinessIdField = new DataSourceIntegerField("additionalBusinessId", "区域");
		additionalBusinessIdField.setRequired(false);
		additionalBusinessIdField.setLength(11);
		additionalBusinessIdField.setHidden(false);

		DataSourceIntegerField currentPageField = new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField = new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);

		setFields(businessIdField, additionalBusinessIdField, k3CodeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}

}
