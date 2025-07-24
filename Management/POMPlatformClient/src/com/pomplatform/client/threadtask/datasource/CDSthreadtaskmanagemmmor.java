package com.pomplatform.client.threadtask.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSthreadtaskmanagemmmor extends DataSource
{


	public static CDSthreadtaskmanagemmmor instance = null;

	public static CDSthreadtaskmanagemmmor getInstance() {
		if(instance == null) {
			instance = new CDSthreadtaskmanagemmmor("CDSthreadtaskmanagemmmor");
		}
		return instance;
	}

	private final DataSourceDateTimeField minBeginTimeField;
	private final DataSourceDateTimeField maxBeginTimeField;
	private final DataSourceDateTimeField minEndTimeField;
	private final DataSourceDateTimeField maxEndTimeField;
	private final DataSourceDateTimeField minCreateTimeField;
	private final DataSourceDateTimeField maxCreateTimeField;
	private final DataSourceTextField errorMsgField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField threadTaskManageIdField;
	private final DataSourceIntegerField taskTypeField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceIntegerField operationTypeField;

	public CDSthreadtaskmanagemmmor(String dataSourceID) {

		setID(dataSourceID);
		minBeginTimeField = new DataSourceDateTimeField("minBeginTime", "最早开始时间");
		minBeginTimeField.setRequired(false);
		minBeginTimeField.setHidden(false);

		maxBeginTimeField = new DataSourceDateTimeField("maxBeginTime", "最晚开始时间");
		maxBeginTimeField.setRequired(false);
		maxBeginTimeField.setHidden(false);

		minEndTimeField = new DataSourceDateTimeField("minEndTime", "最早结束时间");
		minEndTimeField.setRequired(false);
		minEndTimeField.setHidden(false);

		maxEndTimeField = new DataSourceDateTimeField("maxEndTime", "最晚结束时间");
		maxEndTimeField.setRequired(false);
		maxEndTimeField.setHidden(false);

		minCreateTimeField = new DataSourceDateTimeField("minCreateTime", "最早创建时间");
		minCreateTimeField.setRequired(false);
		minCreateTimeField.setHidden(false);

		maxCreateTimeField = new DataSourceDateTimeField("maxCreateTime", "最晚创建时间");
		maxCreateTimeField.setRequired(false);
		maxCreateTimeField.setHidden(false);

		errorMsgField = new DataSourceTextField("errorMsg", "错误信息");
		errorMsgField.setRequired(false);
		errorMsgField.setLength(255);
		errorMsgField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(255);
		remarkField.setHidden(false);

		threadTaskManageIdField = new DataSourceIntegerField("threadTaskManageId", "任务ID");
		threadTaskManageIdField.setRequired(true);
		threadTaskManageIdField.setLength(11);
		threadTaskManageIdField.setPrimaryKey(true);
		threadTaskManageIdField.setHidden(true);

		taskTypeField = new DataSourceIntegerField("taskType", "任务类型");
		taskTypeField.setRequired(false);
		taskTypeField.setLength(11);
		taskTypeField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "任务状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		operatorField = new DataSourceIntegerField("operator", "操作人");
		operatorField.setRequired(false);
		operatorField.setLength(11);
		operatorField.setHidden(false);

		operationTypeField = new DataSourceIntegerField("operationType", "操作类型");
		operationTypeField.setRequired(false);
		operationTypeField.setLength(11);
		operationTypeField.setHidden(false);

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(minBeginTimeField, maxBeginTimeField, minEndTimeField, maxEndTimeField, minCreateTimeField, maxCreateTimeField, errorMsgField, remarkField, threadTaskManageIdField, taskTypeField, statusField, operatorField, operationTypeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

