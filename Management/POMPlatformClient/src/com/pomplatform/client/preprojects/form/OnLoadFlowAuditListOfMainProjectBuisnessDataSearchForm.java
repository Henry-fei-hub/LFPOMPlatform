package com.pomplatform.client.preprojects.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.preprojects.datasource.CDOnLoadFlowAuditListOfMainProjectBuisnessData;

public class OnLoadFlowAuditListOfMainProjectBuisnessDataSearchForm extends SearchForm
{


	private final TextItem processStatusItem;
	private final TextItem employeeIdItem;
	private final TextItem statusItem;
	private final TextItem processTypeItem;
	private final TextItem projectNameItem;
	private final TextItem projectTypeItem;
	private final TextItem projectSalesTeamItem;
	private final TextItem customerNameItem;
	private final TextItem provinceItem;
	private final TextItem cityItem;
	private final TextItem projectOriginationItem;
	private final CheckboxItem isOperationDepartmentItem;
	private final TextItem applyEmployeeIdItem;
	private final DateTimeItem createTimeStartItem;
	private final DateTimeItem createTimeEndItem;

	public OnLoadFlowAuditListOfMainProjectBuisnessDataSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadFlowAuditListOfMainProjectBuisnessData.getInstance());
		processStatusItem = new TextItem("processStatus", "流程状态 0 发起中  1");
		employeeIdItem = new TextItem("employeeId", "处理人");
		statusItem = new TextItem("status", "状态");
		processTypeItem = new TextItem("processType", "流程类型");
		projectNameItem = new TextItem("projectName", "项目名称");
		projectTypeItem = new TextItem("projectType", "项目类别");
		projectSalesTeamItem = new TextItem("projectSalesTeam", "项目营销团队");
		customerNameItem = new TextItem("customerName", "客户名称");
		provinceItem = new TextItem("province", "省份");
		cityItem = new TextItem("city", "城市");
		projectOriginationItem = new TextItem("projectOrigination", "项目来源渠道");
		isOperationDepartmentItem = new CheckboxItem("isOperationDepartment", "是否运营组分配项目");
		applyEmployeeIdItem = new TextItem("applyEmployeeId", "报备人");
		createTimeStartItem = new DateTimeItem("createTimeStart", "报备时间");
		createTimeStartItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, createTimeStartItem);
			}
		});
		createTimeEndItem = new DateTimeItem("createTimeEnd", "报备时间");
		createTimeEndItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, createTimeEndItem);
			}
		});

		setItems(processStatusItem, employeeIdItem, statusItem, processTypeItem, projectNameItem, projectTypeItem, projectSalesTeamItem, customerNameItem, provinceItem, cityItem, projectOriginationItem, isOperationDepartmentItem, applyEmployeeIdItem, createTimeStartItem, createTimeEndItem);

		setNumCols(30);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
