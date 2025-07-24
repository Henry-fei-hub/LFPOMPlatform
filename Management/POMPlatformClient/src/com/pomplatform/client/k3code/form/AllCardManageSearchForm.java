package com.pomplatform.client.k3code.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.k3code.datasource.CDAllCardManage;

public class AllCardManageSearchForm extends SearchForm
{


	private final TextItem objectTypeItem;
	private final CheckboxItem enabledItem;
	private final TextItem cardManageIdItem;

	public AllCardManageSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDAllCardManage.getInstance());
		objectTypeItem = new TextItem("objectType", "2单位)");
		enabledItem = new CheckboxItem("enabled", "是否启用");
		cardManageIdItem = new TextItem("cardManageId", "主键编码");

		setItems(objectTypeItem, enabledItem, cardManageIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
