package com.pomplatform.client.purchase.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSPurchaseWarehousingDetail extends DBDataSource {

	public static DSPurchaseWarehousingDetail instance = null;

	public static DSPurchaseWarehousingDetail getInstance() {
		if (instance == null) {
			instance = new DSPurchaseWarehousingDetail("DSPurchaseWarehousingDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField purchaseWarehousingDetailIdField;
	private final DataSourceIntegerField purchaseContractIdField;
	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceIntegerField productIdField;
	private final DataSourceIntegerField productNumberField;
	private final DataSourceTextField productNameField;
	private final DataSourceTextField productModelField;
	private final DataSourceTextField productUnitField;
	private final DataSourceFloatField productPriceField;
	private final DataSourceFloatField totalPriceField;
	private final DataSourceFloatField taxPointsField;
	private final DataSourceFloatField taxPriceField;
	private final DataSourceFloatField finalPriceField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField operatorIdField;
	private final DataSourceBooleanField isCompleteField;

	public DSPurchaseWarehousingDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("PurchaseWarehousingDetail");

		purchaseWarehousingDetailIdField = new DataSourceIntegerField("purchaseWarehousingDetailId", "主键");
		purchaseWarehousingDetailIdField.setLength(11);
		purchaseWarehousingDetailIdField.setPrimaryKey(true);
		purchaseWarehousingDetailIdField.setRequired(true);
		purchaseWarehousingDetailIdField.setHidden(true);

		purchaseContractIdField = new DataSourceIntegerField("purchaseContractId", "采购合同主键");
		purchaseContractIdField.setLength(11);
		purchaseContractIdField.setRequired(false);
		purchaseContractIdField.setHidden(true);

		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "流程表主键");
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setRequired(false);
		personnelBusinessIdField.setHidden(true);

		productIdField = new DataSourceIntegerField("productId", "产品");
		productIdField.setLength(11);
		productIdField.setRequired(false);
		productIdField.setHidden(false);

		productNumberField = new DataSourceIntegerField("productNumber", "今到货数量");
		productNumberField.setLength(11);
		productNumberField.setRequired(false);
		productNumberField.setHidden(false);

		productNameField = new DataSourceTextField("productName", "产品名称");
		productNameField.setLength(128);
		productNameField.setRequired(false);
		productNameField.setHidden(false);

		productModelField = new DataSourceTextField("productModel", "产品型号");
		productModelField.setLength(128);
		productModelField.setRequired(false);
		productModelField.setHidden(false);

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

		taxPointsField = new DataSourceFloatField("taxPoints", "含税点");
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

		finalPriceField = new DataSourceFloatField("finalPrice", "最终金额");
		finalPriceField.setLength(18);
		finalPriceField.setDecimalPad(2);
		finalPriceField.setFormat("#,###,###,###,###,##0.00");
		finalPriceField.setRequired(false);
		finalPriceField.setHidden(false);

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);

		operatorIdField = new DataSourceIntegerField("operatorId", "操作人主键");
		operatorIdField.setLength(11);
		operatorIdField.setRequired(false);
		operatorIdField.setHidden(false);

		isCompleteField = new DataSourceBooleanField("isComplete", "是否通过审批");
		isCompleteField.setRequired(false);
		isCompleteField.setHidden(true);

		setFields(purchaseWarehousingDetailIdField, purchaseContractIdField, personnelBusinessIdField, productIdField,
				productNumberField, productNameField, productModelField, productUnitField, productPriceField,
				totalPriceField, taxPointsField, taxPriceField, finalPriceField, createTimeField, operatorIdField,
				isCompleteField);
	}

}
