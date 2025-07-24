package com.pomplatform.client.equipment.form;

import java.util.*;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.equipment.datasource.CDMequipmenttypeedeeeor;

public class MequipmenttypeedeeeorSearchForm extends SearchForm
{


	private final ComboBoxItem nameItem;
	private final SelectItem typeItem;
	private final CheckboxItem enabledItem;

	public MequipmenttypeedeeeorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMequipmenttypeedeeeor.getInstance());
		nameItem = new ComboBoxItem("name", "物品名称");
		nameItem.setValueMap(KeyValueManager.getValueMap("equipment_types_all"));
		nameItem.setWidth("*");
		typeItem = new SelectItem("type", "物品类型");
		typeItem.setWidth("*");
		typeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_254"));
		enabledItem = new CheckboxItem("enabled", "是否启用");
		enabledItem.setWidth("*");
		setItems(nameItem, typeItem, enabledItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
