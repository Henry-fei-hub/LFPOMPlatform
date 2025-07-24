package com.pomplatform.client.purchase.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMpurchaseplanmsommpmosror extends DataSource {

	public static CDMpurchaseplanmsommpmosror instance = null;

	public static CDMpurchaseplanmsommpmosror getInstance() {
		if (instance == null) {
			instance = new CDMpurchaseplanmsommpmosror("CDMpurchaseplanmsommpmosror");
		}
		return instance;
	}

	private final DataSourceIntegerField operatorIdField;
	private final DataSourceDateField minPurchaseDateField;
	private final DataSourceDateField maxPurchaseDateField;
	private final DataSourceIntegerField personInChargeField;
	private final DataSourceIntegerField mainProjectIdField;
	private final DataSourceIntegerField oriPersonnelBusinessIdField;
	private final DataSourceIntegerField supplierIdField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField supplierNameField;
	private final DataSourceIntegerField dealStatusField;

	public CDMpurchaseplanmsommpmosror(String dataSourceID) {

		setID(dataSourceID);
		operatorIdField = new DataSourceIntegerField("operatorId", "操作人(指派人)");
		operatorIdField.setRequired(false);
		operatorIdField.setLength(11);
		operatorIdField.setHidden(false);

		minPurchaseDateField = new DataSourceDateField("minPurchaseDate", "最早采购日期");
		minPurchaseDateField.setRequired(false);
		minPurchaseDateField.setHidden(false);

		maxPurchaseDateField = new DataSourceDateField("maxPurchaseDate", "最晚采购日期");
		maxPurchaseDateField.setRequired(false);
		maxPurchaseDateField.setHidden(false);

		personInChargeField = new DataSourceIntegerField("personInCharge", "负责人");
		personInChargeField.setRequired(false);
		personInChargeField.setLength(11);
		personInChargeField.setHidden(false);

		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "大项目主键");
		mainProjectIdField.setRequired(false);
		mainProjectIdField.setLength(11);
		mainProjectIdField.setHidden(false);

		oriPersonnelBusinessIdField = new DataSourceIntegerField("oriPersonnelBusinessId", "源流程业务主键");
		oriPersonnelBusinessIdField.setRequired(false);
		oriPersonnelBusinessIdField.setLength(11);
		oriPersonnelBusinessIdField.setHidden(false);

		supplierIdField = new DataSourceIntegerField("supplierId", "供应商主键");
		supplierIdField.setRequired(false);
		supplierIdField.setLength(11);
		supplierIdField.setHidden(false);
		
		dealStatusField = new DataSourceIntegerField("dealStatus", "处理状态");
		dealStatusField.setRequired(false);
		dealStatusField.setLength(11);
		dealStatusField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(255);
		remarkField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(64);
		projectCodeField.setHidden(false);
		projectCodeField.setValueMap(KeyValueManager.getValueMap(""));

		supplierNameField = new DataSourceTextField("supplierName", "供应商名称");
		supplierNameField.setRequired(false);
		supplierNameField.setLength(128);
		supplierNameField.setHidden(false);

		DataSourceIntegerField currentPageField = new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField = new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);

		setFields(operatorIdField, minPurchaseDateField, maxPurchaseDateField, personInChargeField, mainProjectIdField,
				oriPersonnelBusinessIdField, supplierIdField, remarkField, projectNameField, dealStatusField, projectCodeField,
				supplierNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}

}
