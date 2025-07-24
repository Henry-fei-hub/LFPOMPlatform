package com.pomplatform.client.workflow.personnelbusiness.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSCooperateApply extends DBDataSource
{


	public static DSCooperateApply instance = null;

	public static DSCooperateApply getInstance() {
		if(instance == null) {
			instance = new DSCooperateApply("DSOutputDrawing");
		}
		return instance;
	}

	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField typeField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceIntegerField companyProvinceField;
	private final DataSourceIntegerField targetProvinceField;
	private final DataSourceDateField startDateField;
	private final DataSourceIntegerField startDateDetailField;
	private final DataSourceBooleanField isRemoteCityField;
	private final DataSourceTextField subTypeField;
	private final DataSourceTextField subTypeStrField;
	private final DataSourceTextField reasonField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField linkIdField;
	private final DataSourceIntegerField nextAuditorField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField deleteFlagField;
	private final DataSourceIntegerField drafterField;

	public DSCooperateApply(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("FillcheckApply");


		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "人事业务编码");
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setPrimaryKey(true);
		personnelBusinessIdField.setRequired(true);
		personnelBusinessIdField.setHidden(true);


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(false);
		processTypeField.setValueMap(KeyValueManager.getValueMap("system_process_types"));


		employeeIdField = new DataSourceIntegerField("employeeId", "申请人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setLength(32);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(true);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		typeField = new DataSourceIntegerField("type", "出图类型");
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setHidden(false);
		typeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_239"));
		
		
		projectIdField = new DataSourceIntegerField("projectId", "项目ID");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);
		
		
		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(255);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);

		
		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(255);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);
		

		projectTypeField = new DataSourceIntegerField("projectType", "专业");
		projectTypeField.setLength(11);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(false);
		KeyValueManager.loadValueMap("pm_specials", projectTypeField);
		
		
		startDateDetailField = new DataSourceIntegerField("startDateDetail", "版本");
		startDateDetailField.setLength(11);
		startDateDetailField.setRequired(false);
		startDateDetailField.setHidden(false);
		KeyValueManager.loadValueMap("system_dictionary_242", startDateDetailField);
		
		
		startDateField = new DataSourceDateField("startDate", "日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);
		
		
		companyProvinceField = new DataSourceIntegerField("companyProvince", "图纸张数");
		companyProvinceField.setLength(11);
		companyProvinceField.setRequired(false);
		companyProvinceField.setHidden(false);
		
		
		targetProvinceField = new DataSourceIntegerField("targetProvince", "图纸份数");
		targetProvinceField.setLength(11);
		targetProvinceField.setRequired(false);
		targetProvinceField.setHidden(false);
		
		
		isRemoteCityField = new DataSourceBooleanField("isRemoteCity", "是否盖章签名");
		isRemoteCityField.setRequired(false);
		isRemoteCityField.setHidden(false);
		
		
		subTypeField = new DataSourceTextField("subType", "变更编号");
		subTypeField.setLength(255);
		subTypeField.setRequired(false);
		subTypeField.setHidden(false);
		
		
		subTypeStrField = new DataSourceTextField("subTypeStr", "替换原变更号");
		subTypeStrField.setLength(512);
		subTypeStrField.setRequired(false);
		subTypeStrField.setHidden(false);


		reasonField = new DataSourceTextField("reason", "目的");
		reasonField.setLength(1024);
		reasonField.setRequired(false);
		reasonField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "出图备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);
		
		
		linkIdField = new DataSourceIntegerField("linkId", "校对人");
		linkIdField.setLength(11);
		linkIdField.setHidden(false);
		KeyValueManager.loadValueMap("employees", linkIdField);

		
		nextAuditorField = new DataSourceIntegerField("nextAuditor", "审核人");
		nextAuditorField.setLength(11);
		nextAuditorField.setHidden(false);
		nextAuditorField.setValueMap(KeyValueManager.getValueMap("employees"));


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		deleteFlagField = new DataSourceIntegerField("deleteFlag", "删除状态  0未删除    1已删除");
		deleteFlagField.setLength(11);
		deleteFlagField.setRequired(false);
		deleteFlagField.setHidden(true);

		
		drafterField = new DataSourceIntegerField("drafter", "起草人");
		drafterField.setLength(11);
		drafterField.setRequired(false);
		drafterField.setHidden(true);
		

		setFields(personnelBusinessIdField, processTypeField, employeeIdField, employeeNoField, departmentIdField, companyIdField, typeField, projectIdField, projectCodeField, projectNameField, projectTypeField, startDateDetailField, startDateField, companyProvinceField, targetProvinceField, isRemoteCityField, subTypeField, subTypeStrField, reasonField, remarkField, linkIdField, nextAuditorField, createTimeField, deleteFlagField, drafterField);
	}


}

