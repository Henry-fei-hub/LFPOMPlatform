package com.pomplatform.client.projectemployee.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.projectemployee.datasource.DSSprojectemployeepdsor;

public class SprojectemployeepdsorNewForm extends AbstractWizadPage
{


	private final TextItem projectIdItem;
	private final SelectItem employeeIdItem;
	private final TextItem workContentItem;
	private final TextItem planIntegralItem;
	private final TextItem realIntegralItem;
	private final TextItem costItem;
	private final TextItem settlementItem;
	private final DateItem planStartDateItem;
	private final DateItem planEndDateItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final SelectItem statusItem;

	public SprojectemployeepdsorNewForm() {
		__form = new DynamicForm();
		DSSprojectemployeepdsor ds = DSSprojectemployeepdsor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		projectIdItem = new TextItem("projectId", "项目编码");
		projectIdItem.setWidth("*");
		employeeIdItem = new SelectItem("employeeId", "员工编码");
		employeeIdItem.setValueMap((LinkedHashMap)ds.getField("employeeId").getValueMap());
		workContentItem = new TextItem("workContent", "工作内容");
		workContentItem.setWidth("*");
		planIntegralItem = new TextItem("planIntegral", "预分配积分");
		planIntegralItem.setWidth("*");
		realIntegralItem = new TextItem("realIntegral", "实际获得积分");
		realIntegralItem.setWidth("*");
		costItem = new TextItem("cost", "费用");
		costItem.setWidth("*");
		settlementItem = new TextItem("settlement", "结算积分");
		settlementItem.setWidth("*");
		planStartDateItem = new DateItem("planStartDate", "计划开始日期");
		planEndDateItem = new DateItem("planEndDate", "计划结束日期");
		startDateItem = new DateItem("startDate", "开始日期");
		endDateItem = new DateItem("endDate", "结束日期");
		statusItem = new SelectItem("status", "状态");
		statusItem.setValueMap((LinkedHashMap)ds.getField("status").getValueMap());

		__form.setItems(projectIdItem, employeeIdItem, workContentItem, planIntegralItem, realIntegralItem, costItem, settlementItem, planStartDateItem, planEndDateItem, startDateItem, endDateItem, statusItem);

		__form.setDataSource(ds);
		__form.setNumCols(4);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSprojectemployeepdsor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public Map<String, FormItem> getItems() {
		Map<String, FormItem> res = new HashMap<String, FormItem>();
		res.put("projectId", projectIdItem);
		res.put("employeeId", employeeIdItem);
		res.put("workContent", workContentItem);
		res.put("planIntegral", planIntegralItem);
		res.put("realIntegral", realIntegralItem);
		res.put("cost", costItem);
		res.put("settlement", settlementItem);
		res.put("planStartDate", planStartDateItem);
		res.put("planEndDate", planEndDateItem);
		res.put("startDate", startDateItem);
		res.put("endDate", endDateItem);
		res.put("status", statusItem);
		return res;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}

	private DynamicForm __form;

}
