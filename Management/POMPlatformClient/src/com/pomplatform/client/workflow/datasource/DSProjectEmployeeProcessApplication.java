package com.pomplatform.client.workflow.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSProjectEmployeeProcessApplication extends DBDataSource
{


	public static DSProjectEmployeeProcessApplication instance = null;

	public static DSProjectEmployeeProcessApplication getInstance() {
		if(instance == null) {
			instance = new DSProjectEmployeeProcessApplication("DSProjectEmployeeProcessApplication");
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
	private final DataSourceTextField attachmentField;
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
	private final DataSourceIntegerField drafterField;
	private final DataSourceTextField cardField;
	private final DataSourceIntegerField dutyIdField;
	private final DataSourceTextField equivalentNumberField;
	private final DataSourceIntegerField linkIdField;
	private final DataSourceFloatField severanceField;
	private final DataSourceTextField salary1Field;
	private final DataSourceTextField salary2Field;
	private final DataSourceTextField originalPayField;
	private final DataSourceTextField monthPayField;
	private final DataSourceTextField basicProportionStrField;
	private final DataSourceFloatField basicProportionField;
	private final DataSourceTextField monthBasicPayField;
	private final DataSourceTextField monthPerformancePayField;
	private final DataSourceTextField foremanPayField;
	private final DataSourceTextField otherSubsidyField;
	private final DataSourceTextField totalPayField;
	private final DataSourceTextField annualPerformanceField;
	private final DataSourceIntegerField costAttributionField;
	private final DataSourceDateTimeField certificationTimeField;
	private final DataSourceIntegerField projectIdsField;
	private final DataSourceIntegerField paymentSequenceIdField;
	private final DataSourceIntegerField budgetManagementIdField;
	private final DataSourceIntegerField budgetAttachmentIdField;
	private final DataSourceIntegerField stageIdField;
	private final DataSourceIntegerField attachmentIdField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceField detailProjectEmployee;

	public DSProjectEmployeeProcessApplication(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ProjectEmployeeProcessApplication");


		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "人事业务编码");
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setPrimaryKey(true);
		personnelBusinessIdField.setRequired(true);
		personnelBusinessIdField.setHidden(true);


		processTypeField = new DataSourceIntegerField("processType", "类型 13请假  14出差  15打卡  16外出  17加班");
		processTypeField.setLength(11);
		processTypeField.setRequired(true);
		processTypeField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "申请人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(true);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setLength(32);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(true);


		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(true);
		departmentIdField.setHidden(true);


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(true);
		companyIdField.setHidden(true);


		typeField = new DataSourceIntegerField("type", "假期类型");
		typeField.setLength(11);
		typeField.setRequired(true);
		typeField.setHidden(true);


		startDateField = new DataSourceDateTimeField("startDate", "开始日期");
		startDateField.setRequired(true);
		startDateField.setHidden(true);


		startDateDetailField = new DataSourceIntegerField("startDateDetail", "0上午   1下午");
		startDateDetailField.setLength(11);
		startDateDetailField.setRequired(true);
		startDateDetailField.setHidden(true);


		endDateField = new DataSourceDateTimeField("endDate", "截止日期");
		endDateField.setRequired(true);
		endDateField.setHidden(true);


		endDateDetailField = new DataSourceIntegerField("endDateDetail", "0上午   1下午");
		endDateDetailField.setLength(11);
		endDateDetailField.setRequired(true);
		endDateDetailField.setHidden(true);


		daysField = new DataSourceFloatField("days", "天数");
		daysField.setLength(6);
		daysField.setDecimalPad(2);
		daysField.setFormat("#,##0.00");
		daysField.setRequired(true);
		daysField.setHidden(true);


		reasonField = new DataSourceTextField("reason", "申请缘由");
		reasonField.setLength(1024);
		reasonField.setRequired(true);
		reasonField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(true);
		remarkField.setHidden(true);


		addressField = new DataSourceTextField("address", "地址");
		addressField.setLength(255);
		addressField.setRequired(true);
		addressField.setHidden(true);


		planField = new DataSourceTextField("plan", "计划安排");
		planField.setLength(1024);
		planField.setRequired(true);
		planField.setHidden(true);


		transportationField = new DataSourceTextField("transportation", "交通工具");
		transportationField.setLength(255);
		transportationField.setRequired(true);
		transportationField.setHidden(true);


		feeField = new DataSourceFloatField("fee", "预计费用");
		feeField.setLength(18);
		feeField.setDecimalPad(2);
		feeField.setFormat("#,###,###,###,###,##0.00");
		feeField.setRequired(true);
		feeField.setHidden(true);


		unitField = new DataSourceTextField("unit", "外访单位");
		unitField.setLength(255);
		unitField.setRequired(true);
		unitField.setHidden(true);


		contactPersonField = new DataSourceTextField("contactPerson", "联系人");
		contactPersonField.setLength(255);
		contactPersonField.setRequired(true);
		contactPersonField.setHidden(true);


		createTimeField = new DataSourceDateTimeField("createTime", "起草时间");
		createTimeField.setRequired(true);
		createTimeField.setHidden(true);


		deleteFlagField = new DataSourceIntegerField("deleteFlag", "删除状态  0未删除    1已删除");
		deleteFlagField.setLength(11);
		deleteFlagField.setRequired(true);
		deleteFlagField.setHidden(true);


		nextAuditorField = new DataSourceIntegerField("nextAuditor", "自定义的审核人");
		nextAuditorField.setLength(11);
		nextAuditorField.setRequired(true);
		nextAuditorField.setHidden(true);


		subTypeField = new DataSourceTextField("subType", "假期类型明细项");
		subTypeField.setLength(255);
		subTypeField.setRequired(true);
		subTypeField.setHidden(true);


		hoursField = new DataSourceFloatField("hours", "小时");
		hoursField.setLength(3);
		hoursField.setDecimalPad(1);
		hoursField.setFormat("##.0");
		hoursField.setRequired(true);
		hoursField.setHidden(true);


		companyProvinceField = new DataSourceIntegerField("companyProvince", "公司所在省份");
		companyProvinceField.setLength(11);
		companyProvinceField.setRequired(true);
		companyProvinceField.setHidden(true);


		targetProvinceField = new DataSourceIntegerField("targetProvince", "目标省份");
		targetProvinceField.setLength(11);
		targetProvinceField.setRequired(true);
		targetProvinceField.setHidden(true);


		numberOfBabyField = new DataSourceIntegerField("numberOfBaby", "多胞胎假请填写婴儿数量");
		numberOfBabyField.setLength(11);
		numberOfBabyField.setRequired(true);
		numberOfBabyField.setHidden(true);


		attachmentField = new DataSourceTextField("attachment", "附件");
		attachmentField.setLength(255);
		attachmentField.setRequired(true);
		attachmentField.setHidden(true);


		isCompletedField = new DataSourceBooleanField("isCompleted", "是否审批通过");
		isCompletedField.setRequired(true);
		isCompletedField.setHidden(true);


		subTypeStrField = new DataSourceTextField("subTypeStr", "假期类型明细项");
		subTypeStrField.setLength(512);
		subTypeStrField.setRequired(true);
		subTypeStrField.setHidden(true);


		projectTypeField = new DataSourceIntegerField("projectType", "项目类型 1项目 2前期项目");
		projectTypeField.setLength(11);
		projectTypeField.setRequired(true);
		projectTypeField.setHidden(true);


		projectIdField = new DataSourceIntegerField("projectId", "项目主键");
		projectIdField.setLength(11);
		projectIdField.setRequired(true);
		projectIdField.setHidden(true);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(255);
		projectNameField.setRequired(true);
		projectNameField.setHidden(true);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(255);
		projectCodeField.setRequired(true);
		projectCodeField.setHidden(true);


		parentIdField = new DataSourceIntegerField("parentId", "父级编码  用于记录是根据哪一条记录进行延期");
		parentIdField.setLength(11);
		parentIdField.setRequired(true);
		parentIdField.setHidden(true);


		isRemoteCityField = new DataSourceBooleanField("isRemoteCity", "是否为边远城市");
		isRemoteCityField.setRequired(true);
		isRemoteCityField.setHidden(true);


		provideAccommodationField = new DataSourceBooleanField("provideAccommodation", "是否提供住宿");
		provideAccommodationField.setRequired(true);
		provideAccommodationField.setHidden(true);


		livingExpensesField = new DataSourceFloatField("livingExpenses", "生活费用(元/月)");
		livingExpensesField.setLength(18);
		livingExpensesField.setDecimalPad(2);
		livingExpensesField.setFormat("#,###,###,###,###,##0.00");
		livingExpensesField.setRequired(true);
		livingExpensesField.setHidden(true);


		housingFinanceField = new DataSourceFloatField("housingFinance", "住房费用(元/月)");
		housingFinanceField.setLength(18);
		housingFinanceField.setDecimalPad(2);
		housingFinanceField.setFormat("#,###,###,###,###,##0.00");
		housingFinanceField.setRequired(true);
		housingFinanceField.setHidden(true);


		drafterField = new DataSourceIntegerField("drafter", "起草人");
		drafterField.setLength(11);
		drafterField.setRequired(true);
		drafterField.setHidden(true);


		cardField = new DataSourceTextField("card", "身份证");
		cardField.setLength(255);
		cardField.setRequired(true);
		cardField.setHidden(true);


		dutyIdField = new DataSourceIntegerField("dutyId", "职务");
		dutyIdField.setLength(11);
		dutyIdField.setRequired(true);
		dutyIdField.setHidden(true);


		equivalentNumberField = new DataSourceTextField("equivalentNumber", "对等号  与  冲账结合实现 借款与冲账与还款");
		equivalentNumberField.setLength(64);
		equivalentNumberField.setRequired(true);
		equivalentNumberField.setHidden(true);


		linkIdField = new DataSourceIntegerField("linkId", "关联表编码");
		linkIdField.setLength(11);
		linkIdField.setRequired(true);
		linkIdField.setHidden(true);


		severanceField = new DataSourceFloatField("severance", "离职补偿金");
		severanceField.setLength(18);
		severanceField.setDecimalPad(2);
		severanceField.setFormat("#,###,###,###,###,##0.00");
		severanceField.setRequired(true);
		severanceField.setHidden(true);


		salary1Field = new DataSourceTextField("salary1", "薪资1");
		salary1Field.setLength(256);
		salary1Field.setRequired(true);
		salary1Field.setHidden(true);


		salary2Field = new DataSourceTextField("salary2", "薪资2");
		salary2Field.setLength(256);
		salary2Field.setRequired(true);
		salary2Field.setHidden(true);


		originalPayField = new DataSourceTextField("originalPay", "现薪资");
		originalPayField.setLength(256);
		originalPayField.setRequired(true);
		originalPayField.setHidden(true);


		monthPayField = new DataSourceTextField("monthPay", "月薪");
		monthPayField.setLength(256);
		monthPayField.setRequired(true);
		monthPayField.setHidden(true);


		basicProportionStrField = new DataSourceTextField("basicProportionStr", "基本比例（显示用）");
		basicProportionStrField.setLength(256);
		basicProportionStrField.setRequired(true);
		basicProportionStrField.setHidden(true);


		basicProportionField = new DataSourceFloatField("basicProportion", "基本比例（计算用）");
		basicProportionField.setLength(18);
		basicProportionField.setDecimalPad(2);
		basicProportionField.setFormat("#,###,###,###,###,##0.00");
		basicProportionField.setRequired(true);
		basicProportionField.setHidden(true);


		monthBasicPayField = new DataSourceTextField("monthBasicPay", "月基本工资");
		monthBasicPayField.setLength(256);
		monthBasicPayField.setRequired(true);
		monthBasicPayField.setHidden(true);


		monthPerformancePayField = new DataSourceTextField("monthPerformancePay", "月绩效工资");
		monthPerformancePayField.setLength(256);
		monthPerformancePayField.setRequired(true);
		monthPerformancePayField.setHidden(true);


		foremanPayField = new DataSourceTextField("foremanPay", "工龄工资");
		foremanPayField.setLength(256);
		foremanPayField.setRequired(true);
		foremanPayField.setHidden(true);


		otherSubsidyField = new DataSourceTextField("otherSubsidy", "其他补贴");
		otherSubsidyField.setLength(256);
		otherSubsidyField.setRequired(true);
		otherSubsidyField.setHidden(true);


		totalPayField = new DataSourceTextField("totalPay", "全薪");
		totalPayField.setLength(256);
		totalPayField.setRequired(true);
		totalPayField.setHidden(true);


		annualPerformanceField = new DataSourceTextField("annualPerformance", "年度绩效");
		annualPerformanceField.setLength(256);
		annualPerformanceField.setRequired(true);
		annualPerformanceField.setHidden(true);


		costAttributionField = new DataSourceIntegerField("costAttribution", "费用归属(1IT人员,2管理人员,3设计人员,4研发人员,5营销人员)");
		costAttributionField.setLength(11);
		costAttributionField.setRequired(true);
		costAttributionField.setHidden(true);


		certificationTimeField = new DataSourceDateTimeField("certificationTime", "领证时间");
		certificationTimeField.setRequired(true);
		certificationTimeField.setHidden(true);


		projectIdsField = new DataSourceIntegerField("projectIds", "项目编码");
		projectIdsField.setLength(11);
		projectIdsField.setRequired(true);
		projectIdsField.setHidden(true);


		paymentSequenceIdField = new DataSourceIntegerField("paymentSequenceId", "付款序列编码");
		paymentSequenceIdField.setLength(11);
		paymentSequenceIdField.setRequired(true);
		paymentSequenceIdField.setHidden(true);


		budgetManagementIdField = new DataSourceIntegerField("budgetManagementId", "预算管理编码");
		budgetManagementIdField.setLength(11);
		budgetManagementIdField.setRequired(true);
		budgetManagementIdField.setHidden(true);


		budgetAttachmentIdField = new DataSourceIntegerField("budgetAttachmentId", "预算附件编码");
		budgetAttachmentIdField.setLength(11);
		budgetAttachmentIdField.setRequired(true);
		budgetAttachmentIdField.setHidden(true);


		stageIdField = new DataSourceIntegerField("stageId", "阶段id");
		stageIdField.setLength(11);
		stageIdField.setRequired(true);
		stageIdField.setHidden(true);


		attachmentIdField = new DataSourceIntegerField("attachmentId", "附件编码");
		attachmentIdField.setLength(11);
		attachmentIdField.setRequired(true);
		attachmentIdField.setHidden(true);


		attachmentNameField = new DataSourceTextField("attachmentName", "附件名称");
		attachmentNameField.setLength(255);
		attachmentNameField.setRequired(true);
		attachmentNameField.setHidden(true);

		detailProjectEmployee = new DataSourceField("detailProjectEmployee", FieldType.ANY);
		detailProjectEmployee.setChildrenProperty(true);
		detailProjectEmployee.setChildTagName("ProjectEmployee");
		detailProjectEmployee.setRequired(true);
		detailProjectEmployee.setHidden(true);

		setFields(personnelBusinessIdField, processTypeField, employeeIdField, employeeNoField, departmentIdField, companyIdField, typeField, startDateField, startDateDetailField, endDateField, endDateDetailField, daysField, reasonField, remarkField, addressField, planField, transportationField, feeField, unitField, contactPersonField, createTimeField, deleteFlagField, nextAuditorField, subTypeField, hoursField, companyProvinceField, targetProvinceField, numberOfBabyField, attachmentField, isCompletedField, subTypeStrField, projectTypeField, projectIdField, projectNameField, projectCodeField, parentIdField, isRemoteCityField, provideAccommodationField, livingExpensesField, housingFinanceField, drafterField, cardField, dutyIdField, equivalentNumberField, linkIdField, severanceField, salary1Field, salary2Field, originalPayField, monthPayField, basicProportionStrField, basicProportionField, monthBasicPayField, monthPerformancePayField, foremanPayField, otherSubsidyField, totalPayField, annualPerformanceField, costAttributionField, certificationTimeField, projectIdsField, paymentSequenceIdField, budgetManagementIdField, budgetAttachmentIdField, stageIdField, attachmentIdField, attachmentNameField, detailProjectEmployee);
	}


}

