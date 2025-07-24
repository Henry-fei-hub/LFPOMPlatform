package com.pomplatform.client.trainingmanagement.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDTrainingManagementWithT extends DataSource
{


	public static CDTrainingManagementWithT instance = null;

	public static CDTrainingManagementWithT getInstance() {
		if(instance == null) {
			instance = new CDTrainingManagementWithT("CDTrainingManagementWithT");
		}
		return instance;
	}

	private final DataSourceTextField subjectField;
	private final DataSourceIntegerField trainingManagementIdField;
	private final DataSourceIntegerField compereTypeField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField createPersonIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField isSiteField;
	private final DataSourceIntegerField trainingTypeField;
	private final DataSourceIntegerField isSendField;

	public CDTrainingManagementWithT(String dataSourceID) {

		setID(dataSourceID);
		subjectField = new DataSourceTextField("subject", "主题");
		subjectField.setRequired(false);
		subjectField.setLength(255);
		subjectField.setHidden(false);

		trainingManagementIdField = new DataSourceIntegerField("trainingManagementId", "主键编码");
		trainingManagementIdField.setRequired(true);
		trainingManagementIdField.setLength(11);
		trainingManagementIdField.setHidden(true);

		compereTypeField = new DataSourceIntegerField("compereType", "主持人类型(1公司内部员工2外部人员)");
		compereTypeField.setRequired(false);
		compereTypeField.setLength(11);
		compereTypeField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门编码");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

		createPersonIdField = new DataSourceIntegerField("createPersonId", "创建人编码");
		createPersonIdField.setRequired(false);
		createPersonIdField.setLength(11);
		createPersonIdField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "1(未开始)2(进行中)3(已结束)");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

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


		setFields(subjectField, trainingManagementIdField, compereTypeField, employeeIdField, departmentIdField, createPersonIdField, statusField, plateIdField, isSiteField, trainingTypeField, isSendField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

