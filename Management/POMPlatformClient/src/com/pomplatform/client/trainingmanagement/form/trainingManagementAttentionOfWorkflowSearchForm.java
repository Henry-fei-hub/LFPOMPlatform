package com.pomplatform.client.trainingmanagement.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.trainingmanagement.datasource.CDtrainingManagementAttentionOfWorkflow;

public class trainingManagementAttentionOfWorkflowSearchForm extends SearchForm
{


	private final TextItem statusItem;
	private final TextItem employeeIdItem;
	private final TextItem trainingManagementIdItem;
	private final TextItem subjectItem;
	private final TextItem compereTypeItem;
	private final TextItem compereItem;
	private final TextItem departmentIdItem;
	private final TextItem siteItem;
	private final TextItem plateIdItem;
	private final TextItem isSiteItem;
	private final TextItem trainingTypeItem;
	private final TextItem isSendItem;

	public trainingManagementAttentionOfWorkflowSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDtrainingManagementAttentionOfWorkflow.getInstance());
		statusItem = new TextItem("status", "状态");
		employeeIdItem = new TextItem("employeeId", "处理人");
		trainingManagementIdItem = new TextItem("trainingManagementId", "主键编码");
		subjectItem = new TextItem("subject", "主题");
		compereTypeItem = new TextItem("compereType", "主持人类型(1公司内部员工2外部人员)");
		compereItem = new TextItem("compere", "主持人");
		departmentIdItem = new TextItem("departmentId", "部门编码");
		siteItem = new TextItem("site", "培训地点名称");
		plateIdItem = new TextItem("plateId", "业务部门");
		isSiteItem = new TextItem("isSite", "培训地点  0内部 1外部");
		trainingTypeItem = new TextItem("trainingType", "培训类型  0内部 1外部");
		isSendItem = new TextItem("isSend", "是否进行消息推送 0是 1否");

		setItems(statusItem, employeeIdItem, trainingManagementIdItem, subjectItem, compereTypeItem, compereItem, departmentIdItem, siteItem, plateIdItem, isSiteItem, trainingTypeItem, isSendItem);

		setNumCols(24);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
