package com.pomplatform.client.mcecscreeor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.mcecscreeor.datasource.CDMcecscreeor;

public class McecscreeorSearchForm extends SearchForm
{


	private final DateTimeItem minCreateTimeItem;
	private final DateTimeItem maxCreateTimeItem;
	private final TextItem contractCodeIdItem;
	private final SelectItem signCompanyItem;
	private final TextItem contractCodeItem;
	private final TextItem remarkItem;
	private final TextItem employeeIdItem;
	private final TextItem employeeNameItem;

	public McecscreeorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMcecscreeor.getInstance());
		minCreateTimeItem = new DateTimeItem("minCreateTime", "最早创建时间");
		minCreateTimeItem.setWidth("*");
		minCreateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minCreateTimeItem);
			}
		});
		maxCreateTimeItem = new DateTimeItem("maxCreateTime", "最晚创建时间");
		maxCreateTimeItem.setWidth("*");
		maxCreateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxCreateTimeItem);
			}
		});
		contractCodeIdItem = new TextItem("contractCodeId", "主键");
		contractCodeIdItem.hide();
		signCompanyItem = new SelectItem("signCompany", "签约公司");
		signCompanyItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		signCompanyItem.setWidth("*");
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		remarkItem = new TextItem("remark", "合同名称");
		remarkItem.setWidth("*");
		employeeIdItem = new TextItem("employeeId", "操作人");
		employeeIdItem.hide();
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.hide();

		setItems(minCreateTimeItem, maxCreateTimeItem, contractCodeIdItem, signCompanyItem, contractCodeItem, remarkItem, employeeIdItem, employeeNameItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
