package com.pomplatform.client.memployeemoneymanageeeedcieftrcvmmor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.memployeemoneymanageeeedcieftrcvmmor.datasource.CDMemployeemoneymanageeeedcieftrcvmmor;

public class MemployeemoneymanageeeedcieftrcvmmorSearchForm extends SearchForm
{


	private final TextItem employeeNoItem;
	private final ComboBoxItem employeeIdItem;
	private final IPickTreeItem departmentIdItem;
	private final TextItem codeItem;
	private final CheckboxItem isCompletedItem;
	private final TextItem employeeNameItem;
	private final TextItem falgItem;
	private final TextItem titleNameItem;
	private final TextItem reasonItem;
	private final SelectItem companyIdItem;
	private final TextItem voucherNoItem;
	private final DateTimeItem minOperateTimeItem;
	private final DateTimeItem maxOperateTimeItem;

	public MemployeemoneymanageeeedcieftrcvmmorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMemployeemoneymanageeeedcieftrcvmmor.getInstance());
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		employeeNoItem.hide();
		
		employeeIdItem = new ComboBoxItem("employeeId", "职员编码");
		employeeIdItem.setWidth("*");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		
		departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		
		codeItem = new TextItem("code", "编号");
		codeItem.setWidth("*");
		
		isCompletedItem = new CheckboxItem("isCompleted", "true是)");
		isCompletedItem.hide();
		
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		employeeNameItem.hide();
		
		falgItem = new TextItem("falg", "2还款)");
		falgItem.hide();
		
		titleNameItem = new TextItem("titleName", "主题名称");
		titleNameItem.hide();
		
		reasonItem = new TextItem("reason", "借款事由");
		reasonItem.setWidth("*");
		
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setWidth("*");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		
		voucherNoItem = new TextItem("voucherNo", "凭证号");
		voucherNoItem.setWidth("*");
		voucherNoItem.hide();
		
		minOperateTimeItem = new DateTimeItem("minOperateTime", "最早操作时间");
		minOperateTimeItem.setWidth("*");
		minOperateTimeItem.hide();
		minOperateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minOperateTimeItem);
			}
		});
		maxOperateTimeItem = new DateTimeItem("maxOperateTime", "最晚操作时间");
		maxOperateTimeItem.setWidth("*");
		maxOperateTimeItem.hide();
		maxOperateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxOperateTimeItem);
			}
		});

		setItems(employeeNoItem, employeeIdItem, departmentIdItem, codeItem, isCompletedItem, employeeNameItem, falgItem, titleNameItem, reasonItem, companyIdItem, voucherNoItem, minOperateTimeItem, maxOperateTimeItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
