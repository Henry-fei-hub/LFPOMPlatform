package com.pomplatform.client.specialdeduction.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.specialdeduction.datasource.CDSspecialdeductionrecordsssor;

public class SspecialdeductionrecordsssorSearchForm extends SearchForm
{


	private final ComboBoxItem employeIdItem;
	private final TextItem deparmentIdItem;
	private final ComboBoxItem plateIdItem;
	private final TextItem companyIdItem;
	private final CheckboxItem isEnableItem;

	public SspecialdeductionrecordsssorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSspecialdeductionrecordsssor.getInstance());
		employeIdItem = new ComboBoxItem("employeId", "纳税人");
		employeIdItem.setWidth("*");
		employeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeIdItem.setChangeOnKeypress(false);
		employeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		deparmentIdItem = new TextItem("deparmentId", "部门");
		deparmentIdItem.setHidden(true);
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));	
		companyIdItem = new TextItem("companyId", "归属公司");
		companyIdItem.hide();
		isEnableItem = new CheckboxItem("isEnable", "是否可用");

		setItems(employeIdItem, deparmentIdItem, plateIdItem, companyIdItem, isEnableItem);

		setNumCols(7);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
