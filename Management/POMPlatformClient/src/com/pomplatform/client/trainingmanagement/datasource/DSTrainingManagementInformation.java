package com.pomplatform.client.trainingmanagement.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.data.DBDataSource;

public class DSTrainingManagementInformation extends DBDataSource
{


	public static DSTrainingManagementInformation instance = null;

	public static DSTrainingManagementInformation getInstance() {
		if(instance == null) {
			instance = new DSTrainingManagementInformation("DSTrainingManagementInformation");
		}
		return instance;
	}

	private final DataSourceIntegerField trainingManagementIdField;
	private final DataSourceTextField subjectField;
	private final DataSourceDateTimeField startTimeField;
	private final DataSourceDateTimeField endTimeField;
	private final DataSourceIntegerField compereTypeField;
	private final DataSourceTextField compereField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField signInDelayField;
	private final DataSourceIntegerField signOutDelayField;
	private final DataSourceIntegerField courseScoreField;
	private final DataSourceTextField detailField;
	private final DataSourceIntegerField createPersonIdField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField fileManageIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceTextField siteField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField isSiteField;
	private final DataSourceIntegerField trainingTypeField;
	private final DataSourceIntegerField trainingFeeField;
	private final DataSourceIntegerField fileIdField;
	private final DataSourceLinkField fileUrlField;
	private final DataSourceIntegerField isSendField;
	private final DataSourceTextField plateidsField;
	private final DataSourceTextField departmentidsField;

	public DSTrainingManagementInformation(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("TrainingManagementInformation");


		trainingManagementIdField = new DataSourceIntegerField("trainingManagementId", "主键编码");
		trainingManagementIdField.setLength(11);
		trainingManagementIdField.setRequired(true);
		trainingManagementIdField.setHidden(true);


		subjectField = new DataSourceTextField("subject", "主题");
		subjectField.setLength(255);
		subjectField.setRequired(false);
		subjectField.setHidden(false);


		startTimeField = new DataSourceDateTimeField("startTime", "开始时间");
		startTimeField.setRequired(false);
		startTimeField.setHidden(false);


		endTimeField = new DataSourceDateTimeField("endTime", "结束时间");
		endTimeField.setRequired(false);
		endTimeField.setHidden(false);


		compereTypeField = new DataSourceIntegerField("compereType", "主持人类型(1公司内部员工2外部人员)");
		compereTypeField.setLength(11);
		compereTypeField.setRequired(false);
		compereTypeField.setHidden(false);
		compereTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_174"));

		compereField = new DataSourceTextField("compere", "主持人");
		compereField.setLength(32);
		compereField.setRequired(false);
		compereField.setHidden(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "主持人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		departmentIdField = new DataSourceIntegerField("departmentId", "部门编码");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));
		

		signInDelayField = new DataSourceIntegerField("signInDelay", "签到允许延迟时间");
		signInDelayField.setLength(11);
		signInDelayField.setRequired(false);
		signInDelayField.setHidden(false);


		signOutDelayField = new DataSourceIntegerField("signOutDelay", "签退允许延迟时间");
		signOutDelayField.setLength(11);
		signOutDelayField.setRequired(false);
		signOutDelayField.setHidden(false);


		courseScoreField = new DataSourceIntegerField("courseScore", "课程分数");
		courseScoreField.setLength(11);
		courseScoreField.setRequired(false);
		courseScoreField.setHidden(false);


		detailField = new DataSourceTextField("detail", "详情");
		detailField.setLength(255);
		detailField.setRequired(false);
		detailField.setHidden(true);


		createPersonIdField = new DataSourceIntegerField("createPersonId", "申请人");
		createPersonIdField.setLength(11);
		createPersonIdField.setRequired(false);
		createPersonIdField.setHidden(false);
		createPersonIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		fileManageIdField = new DataSourceIntegerField("fileManageId", "文件编码");
		fileManageIdField.setLength(11);
		fileManageIdField.setRequired(false);
		fileManageIdField.setHidden(true);


		statusField = new DataSourceIntegerField("status", "培训状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);


		siteField = new DataSourceTextField("site", "培训地点名称");
		siteField.setLength(32);
		siteField.setRequired(false);
		siteField.setHidden(true);


		plateIdField = new DataSourceIntegerField("plateId", "申请的业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));
		

		isSiteField = new DataSourceIntegerField("isSite", "培训地点");
		isSiteField.setLength(11);
		isSiteField.setRequired(false);
		isSiteField.setHidden(false);
		Map map =new HashMap<Integer, String>();
		map.put(0, "内部");
		map.put(1, "外部");
		isSiteField.setValueMap(map);

		trainingTypeField = new DataSourceIntegerField("trainingType", "培训类型");
		trainingTypeField.setLength(11);
		trainingTypeField.setRequired(false);
		trainingTypeField.setHidden(false);
		trainingTypeField.setValueMap(map);

		trainingFeeField = new DataSourceIntegerField("trainingFee", "外部培训预计费用");
		trainingFeeField.setLength(11);
		trainingFeeField.setRequired(false);
		trainingFeeField.setHidden(true);


		fileIdField = new DataSourceIntegerField("fileId", "fileId");
		fileIdField.setLength(11);
		fileIdField.setRequired(false);
		fileIdField.setHidden(true);


		fileUrlField = new DataSourceLinkField("fileUrl", "课程附件");
		fileUrlField.setLength(128);
		fileUrlField.setRequired(false);
		fileUrlField.setHidden(false);


		isSendField = new DataSourceIntegerField("isSend", "是否进行消息推送");
		isSendField.setLength(11);
		isSendField.setRequired(false);
		isSendField.setHidden(false);
		isSendField.setValueMap(KeyValueManager.getValueMap("system_dictionary_200"));

		plateidsField = new DataSourceTextField("plateids", "需要推送的业务部门ids");
		plateidsField.setLength(128);
		plateidsField.setRequired(false);
		plateidsField.setHidden(true);


		departmentidsField = new DataSourceTextField("departmentids", "需要推送的归属部门ids");
		departmentidsField.setLength(128);
		departmentidsField.setRequired(false);
		departmentidsField.setHidden(true);


		setFields(trainingManagementIdField, subjectField, startTimeField, endTimeField, compereTypeField, compereField, employeeIdField, departmentIdField, signInDelayField, signOutDelayField, courseScoreField, detailField, createPersonIdField, createTimeField, fileManageIdField, statusField, siteField, plateIdField, isSiteField, trainingTypeField, trainingFeeField, fileIdField, fileUrlField, isSendField, plateidsField, departmentidsField);
	}


}

