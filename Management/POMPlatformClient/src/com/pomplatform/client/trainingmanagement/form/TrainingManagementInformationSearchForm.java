package com.pomplatform.client.trainingmanagement.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.trainingmanagement.datasource.CDTrainingManagementInformation;

public class TrainingManagementInformationSearchForm extends SearchForm
{


	private final TextItem subjectItem;
	private final TextItem trainingManagementIdItem;
	private final TextItem compereTypeItem;
	private final TextItem employeeIdItem;
	private final TextItem departmentIdItem;
	private final TextItem createPersonIdItem;
	private final TextItem statusItem;
	private final TextItem plateIdItem;
	private final TextItem isSiteItem;
	private final TextItem trainingTypeItem;
	private final TextItem isSendItem;

	public TrainingManagementInformationSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDTrainingManagementInformation.getInstance());
		subjectItem = new TextItem("subject", "主题");
		trainingManagementIdItem = new TextItem("trainingManagementId", "主键编码");
		compereTypeItem = new TextItem("compereType", "主持人类型(1公司内部员工2外部人员)");
		employeeIdItem = new TextItem("employeeId", "员工编码");
		departmentIdItem = new TextItem("departmentId", "部门编码");
		createPersonIdItem = new TextItem("createPersonId", "创建人编码");
		statusItem = new TextItem("status", "1(未开始)2(进行中)3(已结束)");
		plateIdItem = new TextItem("plateId", "业务部门");
		isSiteItem = new TextItem("isSite", "培训地点  0内部 1外部");
		trainingTypeItem = new TextItem("trainingType", "培训类型  0内部 1外部");
		isSendItem = new TextItem("isSend", "是否进行消息推送 0是 1否");

		setItems(subjectItem, trainingManagementIdItem, compereTypeItem, employeeIdItem, departmentIdItem, createPersonIdItem, statusItem, plateIdItem, isSiteItem, trainingTypeItem, isSendItem);

		setNumCols(22);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
