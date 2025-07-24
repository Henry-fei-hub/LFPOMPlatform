package com.pomplatform.client.purchase.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSMppsppsppsoiior extends DBDataSource {

	public static DSMppsppsppsoiior instance = null;

	public static DSMppsppsppsoiior getInstance() {
		if (instance == null) {
			instance = new DSMppsppsppsoiior("DSMppsppsppsoiior");
		}
		return instance;
	}

	private final DataSourceIntegerField productStorageIdField;
	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceIntegerField supplierIdField;
	private final DataSourceIntegerField purchaseContractIdField;
	private final DataSourceIntegerField productIdField;
	private final DataSourceIntegerField storageIdField;
	private final DataSourceIntegerField operateTypeField;
	private final DataSourceIntegerField inOutTypeField;
	private final DataSourceIntegerField productNumberField;
	private final DataSourceFloatField productPriceField;
	private final DataSourceFloatField totalPriceField;
	private final DataSourceFloatField taxPointsField;
	private final DataSourceFloatField taxPriceField;
	private final DataSourceFloatField finalPriceField;
	private final DataSourceIntegerField createEmployeeIdField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceBooleanField isCompleteField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField productModelField;
	private final DataSourceTextField productNameField;
	private final DataSourceTextField productSkinsSizeField;
	private final DataSourceIntegerField categoryIdField;
	private final DataSourceIntegerField productTypeField;
	private final DataSourceTextField productUnitField;
	private final DataSourceTextField productSpecificationField;
	private final DataSourceTextField storageCodeField;
	private final DataSourceTextField storageNameField;
	private final DataSourceIntegerField storageTypeField;

	public DSMppsppsppsoiior(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mppsppsppsoiior");

		productStorageIdField = new DataSourceIntegerField("productStorageId", "主键编码");
		productStorageIdField.setLength(11);
		productStorageIdField.setPrimaryKey(true);
		productStorageIdField.setRequired(true);
		productStorageIdField.setHidden(true);

		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "业务表id");
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setRequired(false);
		personnelBusinessIdField.setHidden(true);

		supplierIdField = new DataSourceIntegerField("supplierId", "供应商id");
		supplierIdField.setLength(11);
		supplierIdField.setRequired(false);
		supplierIdField.setHidden(true);

		purchaseContractIdField = new DataSourceIntegerField("purchaseContractId", "采购合同id");
		purchaseContractIdField.setLength(11);
		purchaseContractIdField.setRequired(false);
		purchaseContractIdField.setHidden(true);

		productIdField = new DataSourceIntegerField("productId", "产品");
		productIdField.setLength(11);
		productIdField.setRequired(false);
		productIdField.setHidden(true);

		storageIdField = new DataSourceIntegerField("storageId", "仓库");
		storageIdField.setLength(11);
		storageIdField.setRequired(false);
		storageIdField.setHidden(true);
		storageIdField.setValueMap(KeyValueManager.getValueMap("storages"));

		operateTypeField = new DataSourceIntegerField("operateType", "操作类型");
		operateTypeField.setLength(11);
		operateTypeField.setRequired(false);
		operateTypeField.setHidden(true);

		inOutTypeField = new DataSourceIntegerField("inOutType", "出入库类型1入库；2出库");
		inOutTypeField.setLength(11);
		inOutTypeField.setRequired(false);
		inOutTypeField.setHidden(true);

		productNumberField = new DataSourceIntegerField("productNumber", "产品数量");
		productNumberField.setLength(11);
		productNumberField.setRequired(false);
		productNumberField.setHidden(false);

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

		finalPriceField = new DataSourceFloatField("finalPrice", "含税总金额");
		finalPriceField.setLength(18);
		finalPriceField.setDecimalPad(2);
		finalPriceField.setFormat("#,###,###,###,###,##0.00");
		finalPriceField.setRequired(false);
		finalPriceField.setHidden(false);

		createEmployeeIdField = new DataSourceIntegerField("createEmployeeId", "创建人");
		createEmployeeIdField.setLength(11);
		createEmployeeIdField.setRequired(false);
		createEmployeeIdField.setHidden(false);

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);

		isCompleteField = new DataSourceBooleanField("isComplete", "是否完成");
		isCompleteField.setRequired(false);
		isCompleteField.setHidden(true);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(true);

		productModelField = new DataSourceTextField("productModel", "产品型号");
		productModelField.setLength(128);
		productModelField.setRequired(false);
		productModelField.setHidden(true);

		productNameField = new DataSourceTextField("productName", "产品名称");
		productNameField.setLength(128);
		productNameField.setRequired(false);
		productNameField.setHidden(true);

		productSkinsSizeField = new DataSourceTextField("productSkinsSize", "产品外观尺寸");
		productSkinsSizeField.setLength(64);
		productSkinsSizeField.setRequired(false);
		productSkinsSizeField.setHidden(true);

		categoryIdField = new DataSourceIntegerField("categoryId", "产品类别id");
		categoryIdField.setLength(11);
		categoryIdField.setRequired(false);
		categoryIdField.setHidden(true);

		productTypeField = new DataSourceIntegerField("productType", "产品类型");
		productTypeField.setLength(11);
		productTypeField.setRequired(false);
		productTypeField.setHidden(true);

		productUnitField = new DataSourceTextField("productUnit", "产品单位");
		productUnitField.setLength(64);
		productUnitField.setRequired(false);
		productUnitField.setHidden(true);

		productSpecificationField = new DataSourceTextField("productSpecification", "产品规格");
		productSpecificationField.setLength(64);
		productSpecificationField.setRequired(false);
		productSpecificationField.setHidden(true);

		storageCodeField = new DataSourceTextField("storageCode", "仓库编号");
		storageCodeField.setLength(64);
		storageCodeField.setRequired(false);
		storageCodeField.setHidden(true);

		storageNameField = new DataSourceTextField("storageName", "仓库名称");
		storageNameField.setLength(64);
		storageNameField.setRequired(false);
		storageNameField.setHidden(true);

		storageTypeField = new DataSourceIntegerField("storageType", "仓库类型(对应字典表system_dictionary_209)");
		storageTypeField.setLength(11);
		storageTypeField.setRequired(false);
		storageTypeField.setHidden(true);
		storageTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_209"));

		setFields(productStorageIdField, personnelBusinessIdField, supplierIdField, purchaseContractIdField,
				productIdField, storageIdField, operateTypeField, inOutTypeField, productNumberField, productPriceField,
				totalPriceField, taxPointsField, taxPriceField, finalPriceField, createEmployeeIdField, createTimeField,
				isCompleteField, remarkField, productModelField, productNameField, productSkinsSizeField,
				categoryIdField, productTypeField, productUnitField, productSpecificationField, storageCodeField,
				storageNameField, storageTypeField);
	}

}
