package com.pomplatform.client.purchase.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.purchase.datasource.CDGetPurchaseProductAndSumData;

public class GetPurchaseProductAndSumDataSearchForm extends SearchForm
{


	private final TextItem purchaseProductDetailIdItem;
	private final TextItem personnelBusinessIdItem;
	private final TextItem mainProjectIdItem;
	private final TextItem supplierIdItem;
	private final TextItem productIdItem;
	private final TextItem purchaseContractIdItem;

	public GetPurchaseProductAndSumDataSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDGetPurchaseProductAndSumData.getInstance());
		purchaseProductDetailIdItem = new TextItem("purchaseProductDetailId", "主键编码");
		personnelBusinessIdItem = new TextItem("personnelBusinessId", "人事业务编码");
		mainProjectIdItem = new TextItem("mainProjectId", "项目id");
		supplierIdItem = new TextItem("supplierId", "供应商id");
		productIdItem = new TextItem("productId", "产品id");
		purchaseContractIdItem = new TextItem("purchaseContractId", "采购合同表主键");

		setItems(purchaseProductDetailIdItem, personnelBusinessIdItem, mainProjectIdItem, supplierIdItem, productIdItem, purchaseContractIdItem);

		setNumCols(12);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
