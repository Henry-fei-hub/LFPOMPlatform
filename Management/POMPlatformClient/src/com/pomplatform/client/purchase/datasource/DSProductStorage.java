package com.pomplatform.client.purchase.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSProductStorage extends DBDataSource {

	public static DSProductStorage instance = null;

	public static DSProductStorage getInstance() {
		if (instance == null) {
			instance = new DSProductStorage("DSProductStorage");
		}
		return instance;
	}

	private final DataSourceIntegerField productStorageIdField;
	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceIntegerField supplierIdField;
	private final DataSourceIntegerField purchaseContractIdField;
	private final DataSourceIntegerField productIdField;
	private final DataSourceIntegerField storageIdField;
	private final DataSourceIntegerField inOutTypeField;
	private final DataSourceIntegerField operateTypeField;
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

	public DSProductStorage(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("ProductStorage");

		productStorageIdField = new DataSourceIntegerField("productStorageId", "主键编码");
		productStorageIdField.setLength(11);
		productStorageIdField.setPrimaryKey(true);
		productStorageIdField.setRequired(true);
		productStorageIdField.setHidden(false);

		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "业务表id");
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setRequired(false);
		personnelBusinessIdField.setHidden(false);

		supplierIdField = new DataSourceIntegerField("supplierId", "供应商id");
		supplierIdField.setLength(11);
		supplierIdField.setRequired(false);
		supplierIdField.setHidden(false);

		purchaseContractIdField = new DataSourceIntegerField("purchaseContractId", "采购合同id");
		purchaseContractIdField.setLength(11);
		purchaseContractIdField.setRequired(false);
		purchaseContractIdField.setHidden(false);

		productIdField = new DataSourceIntegerField("productId", "产品id");
		productIdField.setLength(11);
		productIdField.setRequired(false);
		productIdField.setHidden(false);

		storageIdField = new DataSourceIntegerField("storageId", "仓库id");
		storageIdField.setLength(11);
		storageIdField.setRequired(false);
		storageIdField.setHidden(false);

		inOutTypeField = new DataSourceIntegerField("inOutType", "出入库类型1入库；2出库");
		inOutTypeField.setLength(11);
		inOutTypeField.setRequired(false);
		inOutTypeField.setHidden(false);

		operateTypeField = new DataSourceIntegerField("operateType", "操作类型(对应字典表system_dictionary_210)");
		operateTypeField.setLength(11);
		operateTypeField.setRequired(false);
		operateTypeField.setHidden(false);

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

		setFields(productStorageIdField, personnelBusinessIdField, supplierIdField, purchaseContractIdField,
				productIdField, storageIdField, inOutTypeField, operateTypeField, productNumberField, productPriceField,
				totalPriceField, taxPointsField, taxPriceField, finalPriceField, createEmployeeIdField, createTimeField,
				isCompleteField, remarkField);
	}

}
