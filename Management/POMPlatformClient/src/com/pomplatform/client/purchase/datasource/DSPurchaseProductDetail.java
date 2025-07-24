package com.pomplatform.client.purchase.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSPurchaseProductDetail extends DBDataSource {

	public static DSPurchaseProductDetail instance = null;

	public static DSPurchaseProductDetail getInstance() {
		if (instance == null) {
			instance = new DSPurchaseProductDetail("DSPurchaseProductDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField purchaseProductDetailIdField;
	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceIntegerField mainProjectIdField;
	private final DataSourceIntegerField supplierIdField;
	private final DataSourceIntegerField productIdField;
	private final DataSourceIntegerField productNumberField;
	private final DataSourceTextField productUnitField;
	private final DataSourceFloatField productPriceField;
	private final DataSourceFloatField totalPriceField;
	private final DataSourceFloatField taxPointsField;
	private final DataSourceFloatField taxPriceField;
	private final DataSourceFloatField finalPriceField;
	private final DataSourceDateField planArrivalDateField;
	private final DataSourceIntegerField createEmployeeIdField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField purchaseContractIdField;

	public DSPurchaseProductDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("PurchaseProductDetail");

		purchaseProductDetailIdField = new DataSourceIntegerField("purchaseProductDetailId", "主键编码");
		purchaseProductDetailIdField.setLength(11);
		purchaseProductDetailIdField.setPrimaryKey(true);
		purchaseProductDetailIdField.setRequired(true);
		purchaseProductDetailIdField.setHidden(true);

		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "人事业务编码");
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setRequired(false);
		personnelBusinessIdField.setHidden(true);

		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "项目id");
		mainProjectIdField.setLength(11);
		mainProjectIdField.setRequired(false);
		mainProjectIdField.setHidden(true);

		supplierIdField = new DataSourceIntegerField("supplierId", "供应商");
		supplierIdField.setLength(11);
		supplierIdField.setRequired(false);
		supplierIdField.setHidden(false);
		supplierIdField.setValueMap(KeyValueManager.getValueMap("suppliers"));

		productIdField = new DataSourceIntegerField("productId", "产品");
		productIdField.setLength(11);
		productIdField.setRequired(false);
		productIdField.setHidden(false);
		productIdField.setValueMap(KeyValueManager.getValueMap("products"));

		productNumberField = new DataSourceIntegerField("productNumber", "产品数量");
		productNumberField.setLength(11);
		productNumberField.setRequired(false);
		productNumberField.setHidden(false);

		productUnitField = new DataSourceTextField("productUnit", "产品单位");
		productUnitField.setLength(64);
		productUnitField.setRequired(false);
		productUnitField.setHidden(false);

		productPriceField = new DataSourceFloatField("productPrice", "产品单价");
		productPriceField.setLength(18);
		productPriceField.setDecimalPad(2);
		productPriceField.setFormat("#,###,###,###,###,##0.00");
		productPriceField.setRequired(false);
		productPriceField.setHidden(false);

		totalPriceField = new DataSourceFloatField("totalPrice", "产品总价");
		totalPriceField.setLength(18);
		totalPriceField.setDecimalPad(2);
		totalPriceField.setFormat("#,###,###,###,###,##0.00");
		totalPriceField.setRequired(false);
		totalPriceField.setHidden(false);

		taxPointsField = new DataSourceFloatField("taxPoints", "税点");
		taxPointsField.setLength(18);
		taxPointsField.setDecimalPad(2);
		taxPointsField.setFormat("#,###,###,###,###,##0.00");
		taxPointsField.setRequired(false);
		taxPointsField.setHidden(false);

		taxPriceField = new DataSourceFloatField("taxPrice", "税费");
		taxPriceField.setLength(18);
		taxPriceField.setDecimalPad(2);
		taxPriceField.setFormat("#,###,###,###,###,##0.00");
		taxPriceField.setRequired(false);
		taxPriceField.setHidden(false);

		finalPriceField = new DataSourceFloatField("finalPrice", "含税金额");
		finalPriceField.setLength(18);
		finalPriceField.setDecimalPad(2);
		finalPriceField.setFormat("#,###,###,###,###,##0.00");
		finalPriceField.setRequired(false);
		finalPriceField.setHidden(false);

		planArrivalDateField = new DataSourceDateField("planArrivalDate", "计划到货日期");
		planArrivalDateField.setRequired(false);
		planArrivalDateField.setHidden(false);

		createEmployeeIdField = new DataSourceIntegerField("createEmployeeId", "");
		createEmployeeIdField.setLength(11);
		createEmployeeIdField.setRequired(false);
		createEmployeeIdField.setHidden(true);

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		purchaseContractIdField = new DataSourceIntegerField("purchaseContractId", "采购合同表主键");
		purchaseContractIdField.setLength(11);
		purchaseContractIdField.setRequired(false);
		purchaseContractIdField.setHidden(true);

		setFields(purchaseProductDetailIdField, personnelBusinessIdField, mainProjectIdField, supplierIdField,
				productIdField, productNumberField, productUnitField, productPriceField, totalPriceField,
				taxPointsField, taxPriceField, finalPriceField, planArrivalDateField, createEmployeeIdField,
				createTimeField, remarkField, purchaseContractIdField);
	}

}
