package com.pomplatform.client.trainingmanagementdetailor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.trainingmanagementdetailor.datasource.CDStrainingmanagementdetailor;

public class StrainingmanagementdetailorSearchForm extends SearchForm
{


	private final TextItem trainingManagementDetailIdItem;
	private final TextItem trainingManagementIdItem;
	private final TextItem signOutFlagItem;
	private final SelectItem employeeIdItem;
	private final TextItem employeeNumberItem;
	private final PickTreeItem departmentIdItem;
	private final TextItem trainingContentItem;
	private final TextItem trainingMethodItem;
	private final TextItem trainingFrequencyItem;
	private final TextItem trainingPeriodItem;
	private final TextItem spareTimeTrainingItem;
	private final TextItem courseEvaluationItem;
	private final TextItem guidingFunctionItem;

	public StrainingmanagementdetailorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDStrainingmanagementdetailor.getInstance());
		trainingManagementDetailIdItem = new TextItem("trainingManagementDetailId", "主键ID");
		trainingManagementIdItem = new TextItem("trainingManagementId", "培训管理ID");
		signOutFlagItem = new TextItem("signOutFlag", "是否签退(1签退2没有签退)");
		employeeIdItem = new SelectItem("employeeId", "签到人ID");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeNumberItem = new TextItem("employeeNumber", "签到人工号");
		departmentIdItem = new PickTreeItem("departmentId", "部门编码");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments", ""));
		trainingContentItem = new TextItem("trainingContent", "培训内容得分");
		trainingMethodItem = new TextItem("trainingMethod", "培训方式得分");
		trainingFrequencyItem = new TextItem("trainingFrequency", "培训频率选择(1每月2每季3半年4每年)");
		trainingPeriodItem = new TextItem("trainingPeriod", "培训时长(1半个小时21到2个小时33到4个小时4一天)");
		spareTimeTrainingItem = new TextItem("spareTimeTraining", "是否接受业余时间培训(1是2否3看课程)");
		courseEvaluationItem = new TextItem("courseEvaluation", "课程评价");
		guidingFunctionItem = new TextItem("guidingFunction", "指导作用");

		setItems(trainingManagementDetailIdItem, trainingManagementIdItem, signOutFlagItem, employeeIdItem, employeeNumberItem, departmentIdItem, trainingContentItem, trainingMethodItem, trainingFrequencyItem, trainingPeriodItem, spareTimeTrainingItem, courseEvaluationItem, guidingFunctionItem);

		setNumCols(26);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
