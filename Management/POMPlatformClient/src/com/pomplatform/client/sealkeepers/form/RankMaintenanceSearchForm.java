package com.pomplatform.client.sealkeepers.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.sealkeepers.datasource.CDRankMaintenance;

public class RankMaintenanceSearchForm extends SearchForm
{


	private final ComboBoxItem dicTypeValueIdItem;

	public RankMaintenanceSearchForm() {

		setWidth100();
		setHeight100();
		setDataSource(CDRankMaintenance.getInstance());
		dicTypeValueIdItem = new ComboBoxItem("dicTypeValueId", "数据值");
		dicTypeValueIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_3"));
		dicTypeValueIdItem.setWidth("*");

		setItems(dicTypeValueIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
