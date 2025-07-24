package com.pomplatform.client.spaymoneymanagemmcor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.spaymoneymanagemmcor.datasource.CDSpaymoneymanagemmcor;

public class SpaymoneymanagemmcorSearchForm extends SearchForm
{


	private final DateTimeItem minOperateTimeItem;
	private final DateTimeItem maxOperateTimeItem;
	private final TextItem codeItem;
	private final TextItem voucherNoItem;
	private final TextItem employeeIdItem;
	private final IPickTreeItem departmentIdItem;
	private final TextItem operateEmployeeIdItem;
	private final TextItem reasonItem;
	private final TextItem receiveUnitItem;
	private final TextItem bankAccountItem;
	private final TextItem bankNameItem;
	private final TextItem titleNameItem;

	public SpaymoneymanagemmcorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSpaymoneymanagemmcor.getInstance());
		minOperateTimeItem = new DateTimeItem("minOperateTime", "最早操作时间");
		minOperateTimeItem.hide();
		minOperateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minOperateTimeItem);
			}
		});
		maxOperateTimeItem = new DateTimeItem("maxOperateTime", "最晚操作时间");
		maxOperateTimeItem.hide();
		maxOperateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxOperateTimeItem);
			}
		});
		codeItem = new TextItem("code", "报销编号");
		codeItem.setWidth("*");
		
		voucherNoItem = new TextItem("voucherNo", "凭证号");
		voucherNoItem.hide();
		
		employeeIdItem = new TextItem("employeeId", "申请人");
		employeeIdItem.hide();
		
		departmentIdItem = new IPickTreeItem("departmentId", "部门编码");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));

		departmentIdItem.hide();
		
		operateEmployeeIdItem = new TextItem("operateEmployeeId", "操作人");
		operateEmployeeIdItem.hide();
		
		reasonItem = new TextItem("reason", "付款原因");
		reasonItem.setWidth("*");
		
		receiveUnitItem = new TextItem("receiveUnit", "收款单位");
		receiveUnitItem.setWidth("*");
		
		bankAccountItem = new TextItem("bankAccount", "银行账号");
		bankAccountItem.setWidth("*");
		
		bankNameItem = new TextItem("bankName", "开户行");
		bankNameItem.setWidth("*");
		
		titleNameItem = new TextItem("titleName", "主题名称");
		titleNameItem.hide();

		setItems(minOperateTimeItem, maxOperateTimeItem, codeItem, voucherNoItem, employeeIdItem, departmentIdItem, operateEmployeeIdItem, reasonItem, receiveUnitItem, bankAccountItem, bankNameItem, titleNameItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
