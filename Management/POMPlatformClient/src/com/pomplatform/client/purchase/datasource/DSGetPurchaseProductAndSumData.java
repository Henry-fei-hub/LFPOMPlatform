package com.pomplatform.client.purchase.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSGetPurchaseProductAndSumData extends DBDataSource {

	public static DSGetPurchaseProductAndSumData instance = null;

	public static DSGetPurchaseProductAndSumData getInstance() {
		if (instance == null) {
			instance = new DSGetPurchaseProductAndSumData("DSGetPurchaseProductAndSumData");
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
	private final DataSourceTextField productNameField;
	private final DataSourceTextField productModelField;
	private final DataSourceIntegerField categoryIdField;
	private final DataSourceIntegerField productTypeField;
	private final DataSourceTextField productSkinsSizeField;
	private final DataSourceTextField productSpecificationField;
	private final DataSourceIntegerField haveSumField;

	public DSGetPurchaseProductAndSumData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("GetPurchaseProductAndSumData");

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

		supplierIdField = new DataSourceIntegerField("supplierId", "供应商id");
		supplierIdField.setLength(11);
		supplierIdField.setRequired(false);
		supplierIdField.setHidden(true);

		productIdField = new DataSourceIntegerField("productId", "产品id");
		productIdField.setLength(11);
		productIdField.setRequired(false);
		productIdField.setHidden(true);

		productNumberField = new DataSourceIntegerField("productNumber", "采购数量");
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

		planArrivalDateField = new DataSourceDateField("planArrivalDate", "plan_arrival_date");
		planArrivalDateField.setRequired(false);
		planArrivalDateField.setHidden(false);

		createEmployeeIdField = new DataSourceIntegerField("createEmployeeId", "create_employee_id");
		createEmployeeIdField.setLength(11);
		createEmployeeIdField.setRequired(false);
		createEmployeeIdField.setHidden(false);

		createTimeField = new DataSourceDateTimeField("createTime", "create_time");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "remark");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(true);

		purchaseContractIdField = new DataSourceIntegerField("purchaseContractId", "采购合同表主键");
		purchaseContractIdField.setLength(11);
		purchaseContractIdField.setRequired(false);
		purchaseContractIdField.setHidden(true);

		productNameField = new DataSourceTextField("productName", "产品名称");
		productNameField.setLength(128);
		productNameField.setRequired(false);
		productNameField.setHidden(true);

		productModelField = new DataSourceTextField("productModel", "产品型号");
		productModelField.setLength(128);
		productModelField.setRequired(false);
		productModelField.setHidden(true);

		categoryIdField = new DataSourceIntegerField("categoryId", "产品类别id");
		categoryIdField.setLength(11);
		categoryIdField.setRequired(false);
		categoryIdField.setHidden(true);

		productTypeField = new DataSourceIntegerField("productType", "产品类型");
		productTypeField.setLength(11);
		productTypeField.setRequired(false);
		productTypeField.setHidden(true);

		productSkinsSizeField = new DataSourceTextField("productSkinsSize", "产品外观尺寸");
		productSkinsSizeField.setLength(64);
		productSkinsSizeField.setRequired(false);
		productSkinsSizeField.setHidden(true);

		productSpecificationField = new DataSourceTextField("productSpecification", "产品规格");
		productSpecificationField.setLength(64);
		productSpecificationField.setRequired(false);
		productSpecificationField.setHidden(true);

		haveSumField = new DataSourceIntegerField("haveSum", "已到货数量");
		haveSumField.setLength(11);
		haveSumField.setRequired(true);
		haveSumField.setHidden(true);

		setFields(purchaseProductDetailIdField, personnelBusinessIdField, mainProjectIdField, supplierIdField,
				productIdField, productNumberField, productUnitField, productPriceField, totalPriceField,
				taxPointsField, taxPriceField, finalPriceField, planArrivalDateField, createEmployeeIdField,
				createTimeField, remarkField, purchaseContractIdField, productNameField, productModelField,
				categoryIdField, productTypeField, productSkinsSizeField, productSpecificationField, haveSumField);
	}

}
