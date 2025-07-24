package com.pomplatform.client.purchase.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDPurchaseContractWithPp extends DataSource
{


	public static CDPurchaseContractWithPp instance = null;

	public static CDPurchaseContractWithPp getInstance() {
		if(instance == null) {
			instance = new CDPurchaseContractWithPp("CDPurchaseContractWithPp");
		}
		return instance;
	}

	private final DataSourceDateField minContractDateField;
	private final DataSourceDateField maxContractDateField;
	private final DataSourceIntegerField purchaseContractIdField;
	private final DataSourceIntegerField supplierIdField;
	private final DataSourceIntegerField purchasePersonField;
	private final DataSourceIntegerField mainProjectIdField;
	private final DataSourceTextField afterSaleRequirementsField;
	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField qualityAssuranceField;
	private final DataSourceTextField termOfPaymentField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField supplierNameField;
	private final DataSourceTextField majorContactPersonField;

	public CDPurchaseContractWithPp(String dataSourceID) {

		setID(dataSourceID);
		minContractDateField = new DataSourceDateField("minContractDate", "最早合同签订日期");
		minContractDateField.setRequired(false);
		minContractDateField.setHidden(false);

		maxContractDateField = new DataSourceDateField("maxContractDate", "最晚合同签订日期");
		maxContractDateField.setRequired(false);
		maxContractDateField.setHidden(false);

		purchaseContractIdField = new DataSourceIntegerField("purchaseContractId", "主键");
		purchaseContractIdField.setRequired(true);
		purchaseContractIdField.setLength(11);
		purchaseContractIdField.setPrimaryKey(true);
		purchaseContractIdField.setHidden(true);

		supplierIdField = new DataSourceIntegerField("supplierId", "供应商编码");
		supplierIdField.setRequired(false);
		supplierIdField.setLength(11);
		supplierIdField.setHidden(false);

		purchasePersonField = new DataSourceIntegerField("purchasePerson", "订购人");
		purchasePersonField.setRequired(false);
		purchasePersonField.setLength(11);
		purchasePersonField.setHidden(false);

		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "项目");
		mainProjectIdField.setRequired(false);
		mainProjectIdField.setLength(11);
		mainProjectIdField.setHidden(false);

		afterSaleRequirementsField = new DataSourceTextField("afterSaleRequirements", "售后要求");
		afterSaleRequirementsField.setRequired(false);
		afterSaleRequirementsField.setLength(512);
		afterSaleRequirementsField.setHidden(false);

		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "流程业务表主键");
		personnelBusinessIdField.setRequired(false);
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(255);
		contractNameField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(255);
		contractCodeField.setHidden(false);

		qualityAssuranceField = new DataSourceTextField("qualityAssurance", "质保");
		qualityAssuranceField.setRequired(false);
		qualityAssuranceField.setLength(255);
		qualityAssuranceField.setHidden(false);

		termOfPaymentField = new DataSourceTextField("termOfPayment", "付款条件");
		termOfPaymentField.setRequired(false);
		termOfPaymentField.setLength(1024);
		termOfPaymentField.setHidden(false);

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


		setFields(minContractDateField, maxContractDateField, purchaseContractIdField, supplierIdField, purchasePersonField, mainProjectIdField, afterSaleRequirementsField, personnelBusinessIdField, contractNameField, contractCodeField, qualityAssuranceField, termOfPaymentField, projectNameField, projectCodeField, supplierNameField, majorContactPersonField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

