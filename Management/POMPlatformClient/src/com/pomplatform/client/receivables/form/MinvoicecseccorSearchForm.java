package com.pomplatform.client.receivables.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.receivables.datasource.CDMinvoicecseccor;

public class MinvoicecseccorSearchForm extends SearchForm
{


	private final ComboBoxItem projectManagerIdItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;

	public MinvoicecseccorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMinvoicecseccor.getInstance());
		projectManagerIdItem = new ComboBoxItem("projectManagerId", "项目经理");
		projectManagerIdItem.setWidth("*");
		projectManagerIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
	    projectManagerIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
	    
		startDateItem = new DateItem("startDate", "开始时间");
		startDateItem.setWidth("*");
		endDateItem = new DateItem("endDate", "结束时间");
		endDateItem.setWidth("*");
		
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		
		setItems(projectManagerIdItem, startDateItem, endDateItem, contractCodeItem, contractNameItem);

		setNumCols(11);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
