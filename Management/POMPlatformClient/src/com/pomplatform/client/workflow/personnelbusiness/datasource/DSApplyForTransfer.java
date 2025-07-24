package com.pomplatform.client.workflow.personnelbusiness.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceLinkField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSApplyForTransfer extends DBDataSource {

	public static DSApplyForTransfer instance = null;

	public static DSApplyForTransfer getInstance() {
		if (instance == null) {
			instance = new DSApplyForTransfer("DSSpersonnelbusinesppor");
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
	private final DataSourceDateTimeField startDateField;
	private final DataSourceIntegerField startDateDetailField;
	private final DataSourceDateTimeField endDateField;
	private final DataSourceIntegerField endDateDetailField;
	private final DataSourceFloatField daysField;
	private final DataSourceTextField reasonField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField addressField;
	private final DataSourceTextField planField;
	private final DataSourceTextField transportationField;
	private final DataSourceFloatField feeField;
	private final DataSourceTextField unitField;
	private final DataSourceTextField contactPersonField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField deleteFlagField;
	private final DataSourceIntegerField nextAuditorField;
	private final DataSourceTextField subTypeField;
	private final DataSourceFloatField hoursField;
	private final DataSourceIntegerField companyProvinceField;
	private final DataSourceIntegerField targetProvinceField;
	private final DataSourceIntegerField numberOfBabyField;
	private final DataSourceLinkField attachmentField;
	private final DataSourceIntegerField attachmentIdField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceBooleanField isCompletedField;
	private final DataSourceTextField subTypeStrField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceBooleanField isRemoteCityField;
	private final DataSourceBooleanField provideAccommodationField;
	private final DataSourceFloatField livingExpensesField;
	private final DataSourceFloatField housingFinanceField;

	public DSApplyForTransfer(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Spersonnelbusinesppor");

		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "人事业务编码");
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setPrimaryKey(true);
		personnelBusinessIdField.setRequired(true);
		personnelBusinessIdField.setHidden(true);

		processTypeField = new DataSourceIntegerField("processType", "类型 12请假  13出差  14打卡  15外出  16加班");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);

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
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		typeField = new DataSourceIntegerField("type", "假期类型");
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setHidden(true);

		startDateField = new DataSourceDateTimeField("startDate", "申请调岗日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		startDateDetailField = new DataSourceIntegerField("startDateDetail", "开始时段");
		startDateDetailField.setLength(11);
		startDateDetailField.setRequired(false);
		startDateDetailField.setHidden(true);
		startDateDetailField.setValueMap(KeyValueManager.getValueMap("system_dictionary_73"));


		endDateField = new DataSourceDateTimeField("endDate", "实际调岗日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

		endDateDetailField = new DataSourceIntegerField("endDateDetail", "结束时段");
		endDateDetailField.setLength(11);
		endDateDetailField.setRequired(false);
		endDateDetailField.setHidden(true);
		endDateDetailField.setValueMap(KeyValueManager.getValueMap("system_dictionary_73"));


		daysField = new DataSourceFloatField("days", "天数");
		daysField.setLength(6);
		daysField.setDecimalPad(2);
		daysField.setFormat("#,##0.00");
		daysField.setRequired(false);
		daysField.setHidden(true);

		reasonField = new DataSourceTextField("reason", "申请缘由");
		reasonField.setLength(1024);
		reasonField.setRequired(false);
		reasonField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		addressField = new DataSourceTextField("address", "地址");
		addressField.setLength(255);
		addressField.setRequired(false);
		addressField.setHidden(true);

		planField = new DataSourceTextField("plan", "计划安排");
		planField.setLength(1024);
		planField.setRequired(false);
		planField.setHidden(true);

		transportationField = new DataSourceTextField("transportation", "交通工具");
		transportationField.setLength(255);
		transportationField.setRequired(false);
		transportationField.setHidden(true);

		feeField = new DataSourceFloatField("fee", "预计费用");
		feeField.setLength(18);
		feeField.setDecimalPad(2);
		feeField.setFormat("#,###,###,###,###,##0.00");
		feeField.setRequired(false);
		feeField.setHidden(true);

		unitField = new DataSourceTextField("unit", "外访单位");
		unitField.setLength(255);
		unitField.setRequired(false);
		unitField.setHidden(true);

		contactPersonField = new DataSourceTextField("contactPerson", "派驻项目甲方名称");
		contactPersonField.setLength(255);
		contactPersonField.setRequired(false);
		contactPersonField.setHidden(true);

		createTimeField = new DataSourceDateTimeField("createTime", "起草时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);

		deleteFlagField = new DataSourceIntegerField("deleteFlag", "删除状态  0未删除    1已删除");
		deleteFlagField.setLength(11);
		deleteFlagField.setRequired(false);
		deleteFlagField.setHidden(true);

		nextAuditorField = new DataSourceIntegerField("nextAuditor", "项目经理");
		nextAuditorField.setLength(11);
		nextAuditorField.setRequired(false);
		nextAuditorField.setHidden(true);
		nextAuditorField.setValueMap(KeyValueManager.getValueMap("employees"));

		subTypeField = new DataSourceTextField("subType", "假期类型明细项");
		subTypeField.setLength(255);
		subTypeField.setRequired(false);
		subTypeField.setHidden(true);

		hoursField = new DataSourceFloatField("hours", "小时");
		hoursField.setLength(3);
		hoursField.setDecimalPad(1);
		hoursField.setFormat("##.0");
		hoursField.setRequired(false);
		hoursField.setHidden(true);

		companyProvinceField = new DataSourceIntegerField("companyProvince", "公司所在省份");
		companyProvinceField.setLength(11);
		companyProvinceField.setRequired(false);
		companyProvinceField.setHidden(true);

		targetProvinceField = new DataSourceIntegerField("targetProvince", "目标省份");
		targetProvinceField.setLength(11);
		targetProvinceField.setRequired(false);
		targetProvinceField.setHidden(true);

		numberOfBabyField = new DataSourceIntegerField("numberOfBaby", "多胞胎假请填写婴儿数量");
		numberOfBabyField.setLength(11);
		numberOfBabyField.setRequired(false);
		numberOfBabyField.setHidden(true);

		attachmentField = new DataSourceLinkField("attachment", "附件");
		attachmentField.setLength(255);
		attachmentField.setRequired(false);
		attachmentField.setHidden(false);
		
		
		attachmentIdField = new DataSourceIntegerField("attachmentId", "附件ID");
		attachmentIdField.setLength(11);
		attachmentIdField.setRequired(false);
		attachmentIdField.setHidden(true);


		attachmentNameField = new DataSourceTextField("attachmentName", "附件名称");
		attachmentNameField.setLength(512);
		attachmentNameField.setRequired(false);
		attachmentNameField.setHidden(false);
		

		isCompletedField = new DataSourceBooleanField("isCompleted", "是否审批通过");
		isCompletedField.setRequired(false);
		isCompletedField.setHidden(true);

		subTypeStrField = new DataSourceTextField("subTypeStr", "假期类型明细项");
		subTypeStrField.setLength(512);
		subTypeStrField.setRequired(false);
		subTypeStrField.setHidden(true);

		projectTypeField = new DataSourceIntegerField("projectType", "项目类型 1项目 2前期项目");
		projectTypeField.setLength(11);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(true);

		projectIdField = new DataSourceIntegerField("projectId", "项目主键");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(255);
		projectNameField.setRequired(false);
		projectNameField.setHidden(true);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(255);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(true);

		parentIdField = new DataSourceIntegerField("parentId", "转调部门");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(false);
		parentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		isRemoteCityField = new DataSourceBooleanField("isRemoteCity", "是否为边远城市");
		isRemoteCityField.setRequired(false);
		isRemoteCityField.setHidden(true);

		provideAccommodationField = new DataSourceBooleanField("provideAccommodation", "是否提供住宿");
		provideAccommodationField.setRequired(false);
		provideAccommodationField.setHidden(true);

		livingExpensesField = new DataSourceFloatField("livingExpenses", "生活费用(元/月)");
		livingExpensesField.setLength(18);
		livingExpensesField.setDecimalPad(2);
		livingExpensesField.setFormat("#,###,###,###,###,##0.00");
		livingExpensesField.setRequired(false);
		livingExpensesField.setHidden(true);

		housingFinanceField = new DataSourceFloatField("housingFinance", "住房费用(元/月)");
		housingFinanceField.setLength(18);
		housingFinanceField.setDecimalPad(2);
		housingFinanceField.setFormat("#,###,###,###,###,##0.00");
		housingFinanceField.setRequired(false);
		housingFinanceField.setHidden(true);

		setFields(personnelBusinessIdField, processTypeField, employeeIdField, employeeNoField, departmentIdField,
				companyIdField, typeField, startDateField, startDateDetailField, endDateField, endDateDetailField,
				daysField, reasonField, addressField, planField, transportationField, feeField, unitField,
				contactPersonField, deleteFlagField, nextAuditorField, subTypeField, hoursField, companyProvinceField,
				targetProvinceField, numberOfBabyField, attachmentNameField, attachmentIdField, attachmentField, isCompletedField, subTypeStrField,
				projectTypeField, projectIdField, projectNameField, projectCodeField, parentIdField, isRemoteCityField,
				provideAccommodationField, livingExpensesField, housingFinanceField, createTimeField, remarkField);
	}

}
