package com.pomplatform.client.purchase.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDPaymentTemplateWithP extends DataSource
{


	public static CDPaymentTemplateWithP instance = null;

	public static CDPaymentTemplateWithP getInstance() {
		if(instance == null) {
			instance = new CDPaymentTemplateWithP("CDPaymentTemplateWithP");
		}
		return instance;
	}

	private final DataSourceIntegerField operatorIdField;
	private final DataSourceIntegerField minPaymentCycleField;
	private final DataSourceIntegerField maxPaymentCycleField;
	private final DataSourceTextField templateNameField;
	private final DataSourceTextField remarkField;

	public CDPaymentTemplateWithP(String dataSourceID) {

		setID(dataSourceID);
		operatorIdField = new DataSourceIntegerField("operatorId", "操作人");
		operatorIdField.setRequired(false);
		operatorIdField.setLength(11);
		operatorIdField.setHidden(false);

		minPaymentCycleField = new DataSourceIntegerField("minPaymentCycle", "最小支付周期(天)");
		minPaymentCycleField.setRequired(false);
		minPaymentCycleField.setLength(11);
		minPaymentCycleField.setHidden(false);

		maxPaymentCycleField = new DataSourceIntegerField("maxPaymentCycle", "最大支付周期(天)");
		maxPaymentCycleField.setRequired(false);
		maxPaymentCycleField.setLength(11);
		maxPaymentCycleField.setHidden(false);

		templateNameField = new DataSourceTextField("templateName", "模板名称");
		templateNameField.setRequired(false);
		templateNameField.setLength(255);
		templateNameField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(255);
		remarkField.setHidden(false);

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


		setFields(operatorIdField, minPaymentCycleField, maxPaymentCycleField, templateNameField, remarkField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

