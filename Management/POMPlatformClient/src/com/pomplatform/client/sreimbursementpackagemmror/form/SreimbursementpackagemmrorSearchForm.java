package com.pomplatform.client.sreimbursementpackagemmror.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.sreimbursementpackagemmror.datasource.CDSreimbursementpackagemmror;

public class SreimbursementpackagemmrorSearchForm extends SearchForm {

	private final DateTimeItem minCreateTimeItem;
	private final DateTimeItem maxCreateTimeItem;
	private final TextItem reimbursementPackageIdItem;
	private final SelectItem companyIdItem;
	private final CheckboxItem isCompletedItem;
	private final TextItem remarkItem;
	private final TextItem employeeIdItem;
	private final TextItem roleIdItem;
	private final TextItem operatorIdItem;
	private final TextItem codeItem;
	private final TextItem dcodeItem;
	private final BooleanItem isOnlinePayItem;
	private final SelectItem payStatusItem;
	private final FloatItem amountItem;
	private final FloatItem paymentAmountItem;
	private final FloatItem strikeABalanceAmountItem;

	public SreimbursementpackagemmrorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSreimbursementpackagemmror.getInstance());

		minCreateTimeItem = new DateTimeItem("minCreateTime", "最早打包时间");
		minCreateTimeItem.setWidth("*");
		minCreateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minCreateTimeItem);
			}
		});
		maxCreateTimeItem = new DateTimeItem("maxCreateTime", "最晚打包时间");
		maxCreateTimeItem.setWidth("*");
		maxCreateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxCreateTimeItem);
			}
		});
		reimbursementPackageIdItem = new TextItem("reimbursementPackageId", "报销打包表编码");
		reimbursementPackageIdItem.hide();

		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.setWidth("*");

		isCompletedItem = new CheckboxItem("isCompleted", "是否通过审批");
		isCompletedItem.setWidth("*");
		remarkItem = new TextItem("remark", "备注");
		remarkItem.hide();
		employeeIdItem = new TextItem("employeeId", "可操作人编码");
		employeeIdItem.hide();
		roleIdItem = new TextItem("roleId", "可操作角色编码");
		roleIdItem.hide();
		operatorIdItem = new TextItem("operatorId", "操作人Id");
		operatorIdItem.hide();

		codeItem = new TextItem("code", "汇总单号");
		codeItem.setWidth("*");

		dcodeItem = new TextItem("orderCode", "报销单号");
		dcodeItem.setWidth("*");

		isOnlinePayItem = new BooleanItem("isOnlinePay", "是否线上支付");
		isOnlinePayItem.setWidth("*");
		
		payStatusItem = new SelectItem("payStatus", "支付状态");
		payStatusItem.setWidth("*");
		payStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_132"));
		
		amountItem = new FloatItem("amount", "总金额");
		amountItem.setWidth("*");
		
		paymentAmountItem = new FloatItem("paymentAmount", "付款金额");
		paymentAmountItem.setWidth("*");
		
		strikeABalanceAmountItem = new FloatItem("strikeABalanceAmount", "冲账金额");
		strikeABalanceAmountItem.setWidth("*");
		strikeABalanceAmountItem.hide();
		
		
		setItems(codeItem, dcodeItem, minCreateTimeItem, maxCreateTimeItem, reimbursementPackageIdItem, companyIdItem,
				isCompletedItem, remarkItem, employeeIdItem, roleIdItem, operatorIdItem, isOnlinePayItem, payStatusItem,
				amountItem, paymentAmountItem, strikeABalanceAmountItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
