package com.pomplatform.client.purchase.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSpurchasepaymentor extends DataSource
{


	public static CDSpurchasepaymentor instance = null;

	public static CDSpurchasepaymentor getInstance() {
		if(instance == null) {
			instance = new CDSpurchasepaymentor("CDSpurchasepaymentor");
		}
		return instance;
	}

	private final DataSourceDateTimeField minCreateTimeField;
	private final DataSourceDateTimeField maxCreateTimeField;
	private final DataSourceIntegerField purchaseContractIdField;
	private final DataSourceIntegerField purchasePaymentStatusField;
	private final DataSourceIntegerField personInChargeField;
	private final DataSourceIntegerField operatorIdField;
	private final DataSourceTextField paymentConditionField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField paymentNameField;
	private final DataSourceDateField minPaymentDateField;
	private final DataSourceDateField maxPaymentDateField;
	private final DataSourceIntegerField purchasePaymentIdField;
	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceIntegerField mainProjectIdField;
	private final DataSourceTextField supplierNameField;
	private final DataSourceIntegerField supplierIdField;
	private final DataSourceTextField majorContactPersonField;

	public CDSpurchasepaymentor(String dataSourceID) {

		setID(dataSourceID);
		minCreateTimeField = new DataSourceDateTimeField("minCreateTime", "最早创建时间");
		minCreateTimeField.setRequired(false);
		minCreateTimeField.setHidden(false);

		maxCreateTimeField = new DataSourceDateTimeField("maxCreateTime", "最晚创建时间");
		maxCreateTimeField.setRequired(false);
		maxCreateTimeField.setHidden(false);

		purchaseContractIdField = new DataSourceIntegerField("purchaseContractId", "采购合同表主键");
		purchaseContractIdField.setRequired(false);
		purchaseContractIdField.setLength(11);
		purchaseContractIdField.setHidden(false);

		purchasePaymentStatusField = new DataSourceIntegerField("purchasePaymentStatus", "流程状态 0新建 3通过审批完成");
		purchasePaymentStatusField.setRequired(false);
		purchasePaymentStatusField.setLength(11);
		purchasePaymentStatusField.setHidden(false);

		personInChargeField = new DataSourceIntegerField("personInCharge", "负责人");
		personInChargeField.setRequired(false);
		personInChargeField.setLength(11);
		personInChargeField.setHidden(false);

		operatorIdField = new DataSourceIntegerField("operatorId", "操作人");
		operatorIdField.setRequired(false);
		operatorIdField.setLength(11);
		operatorIdField.setHidden(false);

		paymentConditionField = new DataSourceTextField("paymentCondition", "付款条件");
		paymentConditionField.setRequired(false);
		paymentConditionField.setLength(1204);
		paymentConditionField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(1024);
		remarkField.setHidden(false);

		paymentNameField = new DataSourceTextField("paymentName", "款项名称(预付款、第一次付款)");
		paymentNameField.setRequired(false);
		paymentNameField.setLength(255);
		paymentNameField.setHidden(false);

		minPaymentDateField = new DataSourceDateField("minPaymentDate", "最早计划付款日期");
		minPaymentDateField.setRequired(false);
		minPaymentDateField.setHidden(false);

		maxPaymentDateField = new DataSourceDateField("maxPaymentDate", "最晚计划付款日期");
		maxPaymentDateField.setRequired(false);
		maxPaymentDateField.setHidden(false);

		purchasePaymentIdField = new DataSourceIntegerField("purchasePaymentId", "主键");
		purchasePaymentIdField.setRequired(true);
		purchasePaymentIdField.setLength(11);
		purchasePaymentIdField.setPrimaryKey(true);
		purchasePaymentIdField.setHidden(true);

		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "流程表主键");
		personnelBusinessIdField.setRequired(false);
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(255);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(255);
		contractNameField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(64);
		projectCodeField.setHidden(false);
		projectCodeField.setValueMap(KeyValueManager.getValueMap(""));

		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "主键编码");
		mainProjectIdField.setRequired(true);
		mainProjectIdField.setLength(11);
		mainProjectIdField.setPrimaryKey(true);
		mainProjectIdField.setHidden(true);

		supplierNameField = new DataSourceTextField("supplierName", "供应商名称");
		supplierNameField.setRequired(false);
		supplierNameField.setLength(128);
		supplierNameField.setHidden(false);

		supplierIdField = new DataSourceIntegerField("supplierId", "主键编码");
		supplierIdField.setRequired(true);
		supplierIdField.setLength(11);
		supplierIdField.setPrimaryKey(true);
		supplierIdField.setHidden(true);

		majorContactPersonField = new DataSourceTextField("majorContactPerson", "主要联系人");
		majorContactPersonField.setRequired(false);
		majorContactPersonField.setLength(128);
		majorContactPersonField.setHidden(false);

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


		setFields(minCreateTimeField, maxCreateTimeField, purchaseContractIdField, purchasePaymentStatusField, personInChargeField, operatorIdField, paymentConditionField, remarkField, paymentNameField, minPaymentDateField, maxPaymentDateField, purchasePaymentIdField, personnelBusinessIdField, contractCodeField, contractNameField, projectNameField, projectCodeField, mainProjectIdField, supplierNameField, supplierIdField, majorContactPersonField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

