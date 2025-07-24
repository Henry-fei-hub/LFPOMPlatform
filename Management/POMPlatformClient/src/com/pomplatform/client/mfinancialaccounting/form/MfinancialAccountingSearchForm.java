package com.pomplatform.client.mfinancialaccounting.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.mfinancialaccounting.datasource.CDMfinancialAccounting;

public class MfinancialAccountingSearchForm extends SearchForm
{


	private final TextItem processStatusItem;
	private final SelectItem companyIdItem;
	private final IPickTreeItem departmentIdItem;
	private final TextItem employeeIdItem;
	private final TextItem codeItem;
	private final TextItem voucherNoItem;
	private final DateItem postingDateBeginItem;
	private final DateItem postingDateEndItem;
	private final DateTimeItem completeTimeBeginItem;
	private final DateTimeItem completeTimeEndItem;
	private final DateTimeItem applyTimeBeginItem;
	private final DateTimeItem applyTimeEndItem;
	private final SelectItem processTypeItem;
	private final BooleanItem bePackedItem;

	public MfinancialAccountingSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMfinancialAccounting.getInstance());
		processStatusItem = new TextItem("processStatus", "流程状态");
		processStatusItem.hide();
		
		processTypeItem = new SelectItem("processType", "流程类型");
		processTypeItem.setValueMap(KeyValueManager.getValueMap("system_process_types"));
		processTypeItem.setWidth("*");
		
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.setWidth("*");
		
		departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		departmentIdItem.setWidth("*");
		
		employeeIdItem = new TextItem("employeeId", "起草人");
		employeeIdItem.hide();
		codeItem = new TextItem("code", "报销编号");
		codeItem.setWidth("*");
		
		voucherNoItem = new TextItem("voucherNo", "凭证号");
		voucherNoItem.setWidth("*");
		
		postingDateBeginItem = new DateItem("postingDateBegin", "入账日期开始");
		postingDateBeginItem.setWidth("*");
		postingDateBeginItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, postingDateBeginItem);
			}
		});
		postingDateEndItem = new DateItem("postingDateEnd", "入账日期结束");
		postingDateEndItem.setWidth("*");
		postingDateEndItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, postingDateEndItem);
			}
		});
		completeTimeBeginItem = new DateTimeItem("completeTimeBegin", "完成时间开始");
		completeTimeBeginItem.setWidth("*");
		completeTimeBeginItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, completeTimeBeginItem);
			}
		});
		completeTimeEndItem = new DateTimeItem("completeTimeEnd", "完成时间结束");
		completeTimeEndItem.setWidth("*");
		completeTimeEndItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, completeTimeEndItem);
			}
		});
		applyTimeBeginItem = new DateTimeItem("applyTimeBegin", "申请时间开始");
		applyTimeBeginItem.hide();
		applyTimeBeginItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, applyTimeBeginItem);
			}
		});
		applyTimeEndItem = new DateTimeItem("applyTimeEnd", "申请时间结束");
		applyTimeEndItem.hide();
		applyTimeEndItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, applyTimeEndItem);
			}
		});

		bePackedItem = new BooleanItem("bePacked", "是否被打包");
		bePackedItem.setWidth("*");
		
		setItems(processStatusItem, processTypeItem, companyIdItem, departmentIdItem, employeeIdItem, codeItem, voucherNoItem, postingDateBeginItem, postingDateEndItem, completeTimeBeginItem, completeTimeEndItem, applyTimeBeginItem, applyTimeEndItem, bePackedItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
