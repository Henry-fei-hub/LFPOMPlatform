package com.pomplatform.client.usecarprices.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.usecarprices.datasource.CDGetUseCarPrice;

public class GetUseCarPriceSearchForm extends SearchForm
{


	private final TextItem useCarPriceIdItem;
	private final TextItem priceItem;
	private final SelectItem parentIdItem;
	private final TextItem toAreaItem;
	private final TextItem fromAreaItem;

	public GetUseCarPriceSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDGetUseCarPrice.getInstance());
		useCarPriceIdItem = new TextItem("useCarPriceId", "用车费用价格表编码");
		priceItem = new TextItem("price", "价格");
		parentIdItem = new SelectItem("parentId", "父级编码");
//		parentIdItem.setValueMap(KeyValueManager.getValueMap("contracts_1"));
        KeyValueManager.loadValueMap("contracts_1", parentIdItem);

		toAreaItem = new TextItem("toArea", "目的地");
		fromAreaItem = new TextItem("fromArea", "出发地");

		setItems(useCarPriceIdItem, priceItem, parentIdItem, toAreaItem, fromAreaItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
