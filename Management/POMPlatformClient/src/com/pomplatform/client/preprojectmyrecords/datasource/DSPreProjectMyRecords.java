package com.pomplatform.client.preprojectmyrecords.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSPreProjectMyRecords extends DBDataSource
{


	public static DSPreProjectMyRecords instance = null;

	public static DSPreProjectMyRecords getInstance() {
		if(instance == null) {
			instance = new DSPreProjectMyRecords("DSPreProjectMyRecords");
		}
		return instance;
	}

	private final DataSourceIntegerField applyEmployeeIdField;
	private final DataSourceDateTimeField registerDateField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField customerNameField;
	private final DataSourceTextField provinceField;
	private final DataSourceTextField cityField;
	private final DataSourceTextField businessTypeField;
	private final DataSourceIntegerField projectLevelField;
	private final DataSourceTextField winRateField;
	private final DataSourceTextField projectStatusField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField projectBaseOnField;
	private final DataSourceDateTimeField projectApprovalTimeField;
	private final DataSourceFloatField estimateTheDesignAreasField;
	private final DataSourceFloatField actualDesignAreasField;
	private final DataSourceFloatField contractAmountField;
	private final DataSourceDateField trackDateField;
	private final DataSourceTextField projectRecordRemarkField;
	private final DataSourceTextField projectOriginationField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField designTeamField;
	private final DataSourceTextField projectLeaderField;
	private final DataSourceTextField projectManagerField;

	public DSPreProjectMyRecords(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("PreProjectMyRecords");


		applyEmployeeIdField = new DataSourceIntegerField("applyEmployeeId", "报备人");
		applyEmployeeIdField.setLength(11);
		applyEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		applyEmployeeIdField.setRequired(false);
		applyEmployeeIdField.setHidden(false);


		registerDateField = new DataSourceDateTimeField("registerDate", "登记时间");
		registerDateField.setRequired(true);
		registerDateField.setHidden(false);


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(32);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setLength(512);
		customerNameField.setRequired(false);
		customerNameField.setHidden(false);


		provinceField = new DataSourceTextField("province", "项目地址（省）");
		provinceField.setLength(32);
		provinceField.setRequired(false);
		provinceField.setHidden(false);


		cityField = new DataSourceTextField("city", "项目地址（市）");
		cityField.setLength(32);
		cityField.setRequired(false);
		cityField.setHidden(false);


		businessTypeField = new DataSourceTextField("businessType", "业务类别");
		businessTypeField.setLength(512);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(false);


		projectLevelField = new DataSourceIntegerField("projectLevel", "项目等级");
		projectLevelField.setLength(11);
		projectLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));
		projectLevelField.setRequired(false);
		projectLevelField.setHidden(false);


		winRateField = new DataSourceTextField("winRate", "赢率");
		winRateField.setLength(64);
		winRateField.setRequired(false);
		winRateField.setHidden(false);


		projectStatusField = new DataSourceTextField("projectStatus", "项目状态");
		projectStatusField.setLength(64);
		projectStatusField.setRequired(false);
		projectStatusField.setHidden(false);


		processStatusField = new DataSourceIntegerField("processStatus", "报备流程状态");
		processStatusField.setLength(11);
		processStatusField.setValueMap(KeyValueManager.getValueMap("process_status"));
		processStatusField.setRequired(false);
		processStatusField.setHidden(false);


		statusField = new DataSourceIntegerField("status", "立项/关闭的流程状态");
		statusField.setLength(11);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_161"));
		statusField.setRequired(false);
		statusField.setHidden(false);


		projectBaseOnField = new DataSourceIntegerField("projectBaseOn", "立项依据");
		projectBaseOnField.setLength(11);
		projectBaseOnField.setValueMap(KeyValueManager.getValueMap("system_dictionary_28"));
		projectBaseOnField.setRequired(false);
		projectBaseOnField.setHidden(false);


		projectApprovalTimeField = new DataSourceDateTimeField("projectApprovalTime", "立项时间");
		projectApprovalTimeField.setRequired(false);
		projectApprovalTimeField.setHidden(false);


		estimateTheDesignAreasField = new DataSourceFloatField("estimateTheDesignAreas", "计容建筑面积(㎡)");
		estimateTheDesignAreasField.setLength(18);
		estimateTheDesignAreasField.setDecimalPad(2);
		estimateTheDesignAreasField.setFormat("#,###,###,###,###,##0.00");
		estimateTheDesignAreasField.setRequired(false);
		estimateTheDesignAreasField.setHidden(false);


		actualDesignAreasField = new DataSourceFloatField("actualDesignAreas", "实际设计面积");
		actualDesignAreasField.setLength(18);
		actualDesignAreasField.setDecimalPad(2);
		actualDesignAreasField.setFormat("#,###,###,###,###,##0.00");
		actualDesignAreasField.setRequired(false);
		actualDesignAreasField.setHidden(false);


		contractAmountField = new DataSourceFloatField("contractAmount", "预估合同金额");
		contractAmountField.setLength(18);
		contractAmountField.setDecimalPad(2);
		contractAmountField.setFormat("#,###,###,###,###,##0.00");
		contractAmountField.setRequired(false);
		contractAmountField.setHidden(false);


		trackDateField = new DataSourceDateField("trackDate", "跟踪时间");
		trackDateField.setRequired(false);
		trackDateField.setHidden(false);


		projectRecordRemarkField = new DataSourceTextField("projectRecordRemark", "项目跟踪记录");
		projectRecordRemarkField.setLength(-1);
		projectRecordRemarkField.setRequired(true);
		projectRecordRemarkField.setHidden(false);


		projectOriginationField = new DataSourceTextField("projectOrigination", "项目来源渠道");
		projectOriginationField.setLength(512);
		projectOriginationField.setRequired(false);
		projectOriginationField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "项目营销团队");
		departmentIdField.setLength(11);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);


		designTeamField = new DataSourceIntegerField("designTeam", "主办设计团队");
		designTeamField.setLength(11);
		designTeamField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		designTeamField.setRequired(false);
		designTeamField.setHidden(false);


		projectLeaderField = new DataSourceTextField("projectLeader", "项目主管领导");
		projectLeaderField.setLength(-1);
		projectLeaderField.setRequired(true);
		projectLeaderField.setHidden(false);


		projectManagerField = new DataSourceTextField("projectManager", "项目经理");
		projectManagerField.setLength(-1);
		projectManagerField.setRequired(true);
		projectManagerField.setHidden(false);


		setFields(applyEmployeeIdField, registerDateField, infoCodeField, projectNameField, customerNameField, provinceField, cityField, businessTypeField, projectLevelField, winRateField, projectStatusField, processStatusField, statusField, projectBaseOnField, projectApprovalTimeField, estimateTheDesignAreasField, actualDesignAreasField, contractAmountField, trackDateField, projectRecordRemarkField, projectOriginationField, departmentIdField, designTeamField, projectLeaderField, projectManagerField);
	}


}

