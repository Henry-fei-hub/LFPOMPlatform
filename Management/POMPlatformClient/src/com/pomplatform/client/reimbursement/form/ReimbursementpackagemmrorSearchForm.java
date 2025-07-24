package com.pomplatform.client.reimbursement.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.sreimbursementpackagemmror.datasource.CDSreimbursementpackagemmror;

public class ReimbursementpackagemmrorSearchForm extends SearchForm
{


	private final DateTimeItem minCreateTimeItem;
	private final DateTimeItem maxCreateTimeItem;
	private final TextItem reimbursementPackageIdItem;
	private final SelectItem companyIdItem;
	private final TextItem remarkItem;
	private final TextItem employeeIdItem;
	private final TextItem roleIdItem;
	private final TextItem operatorIdItem;
	private final TextItem codeItem;
	private final TextItem dcodeItem;

	public ReimbursementpackagemmrorSearchForm() {
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

		setItems(codeItem, dcodeItem, minCreateTimeItem, maxCreateTimeItem, reimbursementPackageIdItem, companyIdItem, remarkItem, employeeIdItem, roleIdItem, operatorIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
