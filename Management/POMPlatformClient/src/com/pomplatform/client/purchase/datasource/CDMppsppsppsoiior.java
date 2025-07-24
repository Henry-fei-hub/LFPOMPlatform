package com.pomplatform.client.purchase.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMppsppsppsoiior extends DataSource
{


	public static CDMppsppsppsoiior instance = null;

	public static CDMppsppsppsoiior getInstance() {
		if(instance == null) {
			instance = new CDMppsppsppsoiior("CDMppsppsppsoiior");
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
	private final DataSourceBooleanField isCompleteField;

	public CDMppsppsppsoiior(String dataSourceID) {

		setID(dataSourceID);
		productStorageIdField = new DataSourceIntegerField("productStorageId", "主键编码");
		productStorageIdField.setRequired(true);
		productStorageIdField.setLength(11);
		productStorageIdField.setPrimaryKey(true);
		productStorageIdField.setHidden(true);

		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "业务表id");
		personnelBusinessIdField.setRequired(false);
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setHidden(false);

		supplierIdField = new DataSourceIntegerField("supplierId", "供应商id");
		supplierIdField.setRequired(false);
		supplierIdField.setLength(11);
		supplierIdField.setHidden(false);

		purchaseContractIdField = new DataSourceIntegerField("purchaseContractId", "采购合同id");
		purchaseContractIdField.setRequired(false);
		purchaseContractIdField.setLength(11);
		purchaseContractIdField.setHidden(false);

		productIdField = new DataSourceIntegerField("productId", "产品id");
		productIdField.setRequired(false);
		productIdField.setLength(11);
		productIdField.setHidden(false);

		storageIdField = new DataSourceIntegerField("storageId", "仓库id");
		storageIdField.setRequired(false);
		storageIdField.setLength(11);
		storageIdField.setHidden(false);

		operateTypeField = new DataSourceIntegerField("operateType", "操作类型(对应字典表system_dictionary_210)");
		operateTypeField.setRequired(false);
		operateTypeField.setLength(11);
		operateTypeField.setHidden(false);

		inOutTypeField = new DataSourceIntegerField("inOutType", "出入库类型1入库；2出库");
		inOutTypeField.setRequired(false);
		inOutTypeField.setLength(11);
		inOutTypeField.setHidden(false);

		isCompleteField = new DataSourceBooleanField("isComplete", "是否完成");
		isCompleteField.setRequired(false);
		isCompleteField.setHidden(false);

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


		setFields(productStorageIdField, personnelBusinessIdField, supplierIdField, purchaseContractIdField, productIdField, storageIdField, operateTypeField, inOutTypeField, isCompleteField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

