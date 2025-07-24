package com.pomplatform.client.purchase.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.purchase.datasource.CDMppsppsppsoiior;

public class MppsppsppsoiiorSearchForm extends SearchForm
{


	private final TextItem productStorageIdItem;
	private final TextItem personnelBusinessIdItem;
	private final TextItem supplierIdItem;
	private final TextItem purchaseContractIdItem;
	private final TextItem productIdItem;
	private final TextItem storageIdItem;
	private final TextItem operateTypeItem;
	private final TextItem inOutTypeItem;
	private final CheckboxItem isCompleteItem;

	public MppsppsppsoiiorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMppsppsppsoiior.getInstance());
		productStorageIdItem = new TextItem("productStorageId", "主键编码");
		personnelBusinessIdItem = new TextItem("personnelBusinessId", "业务表id");
		supplierIdItem = new TextItem("supplierId", "供应商id");
		purchaseContractIdItem = new TextItem("purchaseContractId", "采购合同id");
		productIdItem = new TextItem("productId", "产品id");
		storageIdItem = new TextItem("storageId", "仓库id");
		operateTypeItem = new TextItem("operateType", "操作类型(对应字典表system_dictionary_210)");
		inOutTypeItem = new TextItem("inOutType", "出入库类型1入库；2出库");
		isCompleteItem = new CheckboxItem("isComplete", "是否完成");

		setItems(productStorageIdItem, personnelBusinessIdItem, supplierIdItem, purchaseContractIdItem, productIdItem, storageIdItem, operateTypeItem, inOutTypeItem, isCompleteItem);

		setNumCols(18);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
