package com.pomplatform.client.trainingmanagement.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDtrainingManagementAttentionOfWorkflow extends DataSource
{


	public static CDtrainingManagementAttentionOfWorkflow instance = null;

	public static CDtrainingManagementAttentionOfWorkflow getInstance() {
		if(instance == null) {
			instance = new CDtrainingManagementAttentionOfWorkflow("CDtrainingManagementAttentionOfWorkflow");
		}
		return instance;
	}

	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField trainingManagementIdField;
	private final DataSourceTextField subjectField;
	private final DataSourceIntegerField compereTypeField;
	private final DataSourceTextField compereField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField siteField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField isSiteField;
	private final DataSourceIntegerField trainingTypeField;
	private final DataSourceIntegerField isSendField;

	public CDtrainingManagementAttentionOfWorkflow(String dataSourceID) {

		setID(dataSourceID);
		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "处理人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		trainingManagementIdField = new DataSourceIntegerField("trainingManagementId", "主键编码");
		trainingManagementIdField.setRequired(true);
		trainingManagementIdField.setLength(11);
		trainingManagementIdField.setPrimaryKey(true);
		trainingManagementIdField.setHidden(true);

		subjectField = new DataSourceTextField("subject", "主题");
		subjectField.setRequired(false);
		subjectField.setLength(255);
		subjectField.setHidden(false);

		compereTypeField = new DataSourceIntegerField("compereType", "主持人类型(1公司内部员工2外部人员)");
		compereTypeField.setRequired(false);
		compereTypeField.setLength(11);
		compereTypeField.setHidden(false);

		compereField = new DataSourceTextField("compere", "主持人");
		compereField.setRequired(false);
		compereField.setLength(32);
		compereField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门编码");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

		siteField = new DataSourceTextField("site", "培训地点名称");
		siteField.setRequired(false);
		siteField.setLength(32);
		siteField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

		isSiteField = new DataSourceIntegerField("isSite", "培训地点  0内部 1外部");
		isSiteField.setRequired(false);
		isSiteField.setLength(11);
		isSiteField.setHidden(false);

		trainingTypeField = new DataSourceIntegerField("trainingType", "培训类型  0内部 1外部");
		trainingTypeField.setRequired(false);
		trainingTypeField.setLength(11);
		trainingTypeField.setHidden(false);

		isSendField = new DataSourceIntegerField("isSend", "是否进行消息推送 0是 1否");
		isSendField.setRequired(false);
		isSendField.setLength(11);
		isSendField.setHidden(false);

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


		setFields(statusField, employeeIdField, trainingManagementIdField, subjectField, compereTypeField, compereField, departmentIdField, siteField, plateIdField, isSiteField, trainingTypeField, isSendField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

