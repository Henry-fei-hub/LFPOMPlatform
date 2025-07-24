package com.pomplatform.client.capitaldistribution.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.capitaldistribution.datasource.CDCapitalLogDetail;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class CapitalLogDetailSearchForm extends SearchForm
{


	private final TextItem contractNameItem;
	private final TextItem contractCodeItem;
	private final ComboBoxItem operatorItem;
	private final DateItem startTimeItem;
	private final DateItem endTimeItem;

	public CapitalLogDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDCapitalLogDetail.getInstance());
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		
		operatorItem = new ComboBoxItem("operator", "操作者");
		operatorItem.setValueMap(KeyValueManager.getValueMap("employees"));
		operatorItem.setChangeOnKeypress(false);
		operatorItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		operatorItem.setWidth("*");
		
		startTimeItem = new DateItem("startTime", "开始日期");
		startTimeItem.setWidth("*");
		
		endTimeItem = new DateItem("endTime", "结束日期");
		endTimeItem.setWidth("*");

		setItems(contractCodeItem, contractNameItem, operatorItem, startTimeItem, endTimeItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
