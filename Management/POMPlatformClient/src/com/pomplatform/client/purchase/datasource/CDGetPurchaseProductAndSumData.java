package com.pomplatform.client.purchase.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDGetPurchaseProductAndSumData extends DataSource
{


	public static CDGetPurchaseProductAndSumData instance = null;

	public static CDGetPurchaseProductAndSumData getInstance() {
		if(instance == null) {
			instance = new CDGetPurchaseProductAndSumData("CDGetPurchaseProductAndSumData");
		}
		return instance;
	}

	private final DataSourceIntegerField purchaseProductDetailIdField;
	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceIntegerField mainProjectIdField;
	private final DataSourceIntegerField supplierIdField;
	private final DataSourceIntegerField productIdField;
	private final DataSourceIntegerField purchaseContractIdField;

	public CDGetPurchaseProductAndSumData(String dataSourceID) {

		setID(dataSourceID);
		purchaseProductDetailIdField = new DataSourceIntegerField("purchaseProductDetailId", "主键编码");
		purchaseProductDetailIdField.setRequired(true);
		purchaseProductDetailIdField.setLength(11);
		purchaseProductDetailIdField.setPrimaryKey(true);
		purchaseProductDetailIdField.setHidden(true);

		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "人事业务编码");
		personnelBusinessIdField.setRequired(false);
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setHidden(false);

		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "项目id");
		mainProjectIdField.setRequired(false);
		mainProjectIdField.setLength(11);
		mainProjectIdField.setHidden(false);

		supplierIdField = new DataSourceIntegerField("supplierId", "供应商id");
		supplierIdField.setRequired(false);
		supplierIdField.setLength(11);
		supplierIdField.setHidden(false);

		productIdField = new DataSourceIntegerField("productId", "产品id");
		productIdField.setRequired(false);
		productIdField.setLength(11);
		productIdField.setHidden(false);

		purchaseContractIdField = new DataSourceIntegerField("purchaseContractId", "采购合同表主键");
		purchaseContractIdField.setRequired(false);
		purchaseContractIdField.setLength(11);
		purchaseContractIdField.setHidden(false);

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


		setFields(purchaseProductDetailIdField, personnelBusinessIdField, mainProjectIdField, supplierIdField, productIdField, purchaseContractIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

