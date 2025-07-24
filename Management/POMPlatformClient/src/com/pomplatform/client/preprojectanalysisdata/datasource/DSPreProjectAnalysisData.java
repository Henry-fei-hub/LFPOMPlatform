package com.pomplatform.client.preprojectanalysisdata.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSPreProjectAnalysisData extends DBDataSource
{


	public static DSPreProjectAnalysisData instance = null;

	public static DSPreProjectAnalysisData getInstance() {
		if(instance == null) {
			instance = new DSPreProjectAnalysisData("DSPreProjectAnalysisData");
		}
		return instance;
	}

	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField businessTypeField;
	private final DataSourceTextField specialtyField;
	private final DataSourceIntegerField statusField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField regionField;
	private final DataSourceTextField provinceField;
	private final DataSourceTextField cityField;
	private final DataSourceDateTimeField registerDateField;
	private final DataSourceDateTimeField projectApprovalTimeField;
	private final DataSourceIntegerField comparisonFormField;
	private final DataSourceFloatField contractAmountField;
	private final DataSourceTextField closeReasonField;
	private final DataSourceTextField closeRemarkField;
	private final DataSourceTextField competitiveUnitField;
	private final DataSourceIntegerField applyEmployeeIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField designTeamField;
	private final DataSourceIntegerField projectBaseOnField;

	public DSPreProjectAnalysisData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("PreProjectAnalysisData");


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(32);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(false);


		businessTypeField = new DataSourceTextField("businessType", "业务类别");
		businessTypeField.setLength(512);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(false);


		specialtyField = new DataSourceTextField("specialty", "参与专业");
		specialtyField.setLength(512);
		specialtyField.setRequired(false);
		specialtyField.setHidden(false);


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
		
		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		regionField = new DataSourceIntegerField("region", "区域");
		regionField.setLength(11);
		regionField.setValueMap(KeyValueManager.getValueMap("system_dictionary_170"));
		regionField.setRequired(false);
		regionField.setHidden(false);


		provinceField = new DataSourceTextField("province", "项目地址（省）");
		provinceField.setLength(32);
		provinceField.setRequired(false);
		provinceField.setHidden(false);


		cityField = new DataSourceTextField("city", "项目地址（市）");
		cityField.setLength(32);
		cityField.setRequired(false);
		cityField.setHidden(false);


		registerDateField = new DataSourceDateTimeField("registerDate", "登记时间");
		registerDateField.setRequired(true);
		registerDateField.setHidden(false);


		projectApprovalTimeField = new DataSourceDateTimeField("projectApprovalTime", "立项时间");
		projectApprovalTimeField.setRequired(false);
		projectApprovalTimeField.setHidden(false);


		comparisonFormField = new DataSourceIntegerField("comparisonForm", "比选形式");
		comparisonFormField.setLength(11);
		comparisonFormField.setValueMap(KeyValueManager.getValueMap("system_dictionary_168"));
		comparisonFormField.setRequired(false);
		comparisonFormField.setHidden(false);


		contractAmountField = new DataSourceFloatField("contractAmount", "预估合同金额(元)");
		contractAmountField.setLength(18);
		contractAmountField.setDecimalPad(2);
		contractAmountField.setFormat("#,###,###,###,###,##0.00");
		contractAmountField.setRequired(false);
		contractAmountField.setHidden(false);

		closeReasonField = new DataSourceTextField("closeReason", "项目关闭原因");
		closeReasonField.setLength(2048);
		closeReasonField.setValueMap(KeyValueManager.getValueMap("system_dictionary_169"));
		closeReasonField.setRequired(false);
		closeReasonField.setHidden(false);


		closeRemarkField = new DataSourceTextField("closeRemark", "项目关闭备注");
		closeRemarkField.setLength(512);
		closeRemarkField.setRequired(false);
		closeRemarkField.setHidden(false);


		competitiveUnitField = new DataSourceTextField("competitiveUnit", "竞争单位");
		competitiveUnitField.setLength(-1);
		competitiveUnitField.setRequired(true);
		competitiveUnitField.setHidden(false);


		applyEmployeeIdField = new DataSourceIntegerField("applyEmployeeId", "报备人");
		applyEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		applyEmployeeIdField.setLength(11);
		applyEmployeeIdField.setRequired(false);
		applyEmployeeIdField.setHidden(false);


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


		setFields(infoCodeField, businessTypeField, specialtyField, statusField, projectBaseOnField,projectNameField, regionField, provinceField, cityField, registerDateField, projectApprovalTimeField, comparisonFormField, contractAmountField, closeReasonField, closeRemarkField, competitiveUnitField, applyEmployeeIdField, departmentIdField, designTeamField);
	}


}

