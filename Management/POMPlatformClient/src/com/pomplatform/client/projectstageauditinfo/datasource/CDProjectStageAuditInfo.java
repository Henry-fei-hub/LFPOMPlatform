package com.pomplatform.client.projectstageauditinfo.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDProjectStageAuditInfo extends DataSource
{


	public static CDProjectStageAuditInfo instance = null;

	public static CDProjectStageAuditInfo getInstance() {
		if(instance == null) {
			instance = new CDProjectStageAuditInfo("CDProjectStageAuditInfo");
		}
		return instance;
	}

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
	private final DataSourceIntegerField stageIdField;

	public CDProjectStageAuditInfo(String dataSourceID) {

		setID(dataSourceID);
		processTypeField = new DataSourceIntegerField("processType", "类型 13请假  14出差  15打卡  16外出  17加班");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "申请人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setRequired(false);
		employeeNoField.setLength(32);
		employeeNoField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);

		typeField = new DataSourceIntegerField("type", "假期类型");
		typeField.setRequired(false);
		typeField.setLength(11);
		typeField.setHidden(false);

		startDateField = new DataSourceDateTimeField("startDate", "开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		startDateDetailField = new DataSourceIntegerField("startDateDetail", "0上午   1下午");
		startDateDetailField.setRequired(false);
		startDateDetailField.setLength(11);
		startDateDetailField.setHidden(false);

		endDateField = new DataSourceDateTimeField("endDate", "截止日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

		endDateDetailField = new DataSourceIntegerField("endDateDetail", "0上午   1下午");
		endDateDetailField.setRequired(false);
		endDateDetailField.setLength(11);
		endDateDetailField.setHidden(false);

		daysField = new DataSourceFloatField("days", "天数");
		daysField.setRequired(true);
		daysField.setLength(6);
		daysField.setHidden(false);

		reasonField = new DataSourceTextField("reason", "申请缘由");
		reasonField.setRequired(false);
		reasonField.setLength(1024);
		reasonField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(1024);
		remarkField.setHidden(false);

		addressField = new DataSourceTextField("address", "地址");
		addressField.setRequired(false);
		addressField.setLength(255);
		addressField.setHidden(false);

		planField = new DataSourceTextField("plan", "计划安排");
		planField.setRequired(false);
		planField.setLength(1024);
		planField.setHidden(false);

		transportationField = new DataSourceTextField("transportation", "交通工具");
		transportationField.setRequired(false);
		transportationField.setLength(255);
		transportationField.setHidden(false);

		feeField = new DataSourceFloatField("fee", "预计费用");
		feeField.setRequired(true);
		feeField.setLength(18);
		feeField.setHidden(false);

		unitField = new DataSourceTextField("unit", "外访单位");
		unitField.setRequired(false);
		unitField.setLength(255);
		unitField.setHidden(false);

		contactPersonField = new DataSourceTextField("contactPerson", "联系人");
		contactPersonField.setRequired(false);
		contactPersonField.setLength(255);
		contactPersonField.setHidden(false);

		createTimeField = new DataSourceDateTimeField("createTime", "起草时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);

		deleteFlagField = new DataSourceIntegerField("deleteFlag", "删除状态  0未删除    1已删除");
		deleteFlagField.setRequired(false);
		deleteFlagField.setLength(11);
		deleteFlagField.setHidden(false);

		nextAuditorField = new DataSourceIntegerField("nextAuditor", "自定义的审核人");
		nextAuditorField.setRequired(false);
		nextAuditorField.setLength(11);
		nextAuditorField.setHidden(false);

		subTypeField = new DataSourceTextField("subType", "假期类型明细项");
		subTypeField.setRequired(false);
		subTypeField.setLength(255);
		subTypeField.setHidden(false);

		hoursField = new DataSourceFloatField("hours", "小时");
		hoursField.setRequired(true);
		hoursField.setLength(3);
		hoursField.setHidden(false);

		companyProvinceField = new DataSourceIntegerField("companyProvince", "公司所在省份");
		companyProvinceField.setRequired(false);
		companyProvinceField.setLength(11);
		companyProvinceField.setHidden(false);

		targetProvinceField = new DataSourceIntegerField("targetProvince", "目标省份");
		targetProvinceField.setRequired(false);
		targetProvinceField.setLength(11);
		targetProvinceField.setHidden(false);

		numberOfBabyField = new DataSourceIntegerField("numberOfBaby", "多胞胎假请填写婴儿数量");
		numberOfBabyField.setRequired(false);
		numberOfBabyField.setLength(11);
		numberOfBabyField.setHidden(false);

		attachmentField = new DataSourceTextField("attachment", "附件");
		attachmentField.setRequired(false);
		attachmentField.setLength(255);
		attachmentField.setHidden(false);

		isCompletedField = new DataSourceBooleanField("isCompleted", "是否审批通过");
		isCompletedField.setRequired(false);
		isCompletedField.setHidden(false);

		subTypeStrField = new DataSourceTextField("subTypeStr", "假期类型明细项");
		subTypeStrField.setRequired(false);
		subTypeStrField.setLength(512);
		subTypeStrField.setHidden(false);

		projectTypeField = new DataSourceIntegerField("projectType", "项目类型 1项目 2前期项目");
		projectTypeField.setRequired(false);
		projectTypeField.setLength(11);
		projectTypeField.setHidden(false);

		projectIdField = new DataSourceIntegerField("projectId", "项目主键");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(255);
		projectNameField.setHidden(false);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(255);
		projectCodeField.setHidden(false);

		parentIdField = new DataSourceIntegerField("parentId", "父级编码  用于记录是根据哪一条记录进行延期");
		parentIdField.setRequired(false);
		parentIdField.setLength(11);
		parentIdField.setHidden(false);

		isRemoteCityField = new DataSourceBooleanField("isRemoteCity", "是否为边远城市");
		isRemoteCityField.setRequired(false);
		isRemoteCityField.setHidden(false);

		provideAccommodationField = new DataSourceBooleanField("provideAccommodation", "是否提供住宿");
		provideAccommodationField.setRequired(false);
		provideAccommodationField.setHidden(false);

		livingExpensesField = new DataSourceFloatField("livingExpenses", "生活费用(元/月)");
		livingExpensesField.setRequired(true);
		livingExpensesField.setLength(18);
		livingExpensesField.setHidden(false);

		housingFinanceField = new DataSourceFloatField("housingFinance", "住房费用(元/月)");
		housingFinanceField.setRequired(true);
		housingFinanceField.setLength(18);
		housingFinanceField.setHidden(false);

		drafterField = new DataSourceIntegerField("drafter", "起草人");
		drafterField.setRequired(false);
		drafterField.setLength(11);
		drafterField.setHidden(false);

		cardField = new DataSourceTextField("card", "身份证");
		cardField.setRequired(false);
		cardField.setLength(255);
		cardField.setHidden(false);

		dutyIdField = new DataSourceIntegerField("dutyId", "职务");
		dutyIdField.setRequired(false);
		dutyIdField.setLength(11);
		dutyIdField.setHidden(false);

		equivalentNumberField = new DataSourceTextField("equivalentNumber", "对等号  与  冲账结合实现 借款与冲账与还款");
		equivalentNumberField.setRequired(false);
		equivalentNumberField.setLength(64);
		equivalentNumberField.setHidden(false);

		linkIdField = new DataSourceIntegerField("linkId", "关联表编码");
		linkIdField.setRequired(false);
		linkIdField.setLength(11);
		linkIdField.setHidden(false);

		severanceField = new DataSourceFloatField("severance", "离职补偿金");
		severanceField.setRequired(true);
		severanceField.setLength(18);
		severanceField.setHidden(false);

		salary1Field = new DataSourceTextField("salary1", "薪资1");
		salary1Field.setRequired(false);
		salary1Field.setLength(256);
		salary1Field.setHidden(false);

		salary2Field = new DataSourceTextField("salary2", "薪资2");
		salary2Field.setRequired(false);
		salary2Field.setLength(256);
		salary2Field.setHidden(false);

		originalPayField = new DataSourceTextField("originalPay", "现薪资");
		originalPayField.setRequired(false);
		originalPayField.setLength(256);
		originalPayField.setHidden(false);

		monthPayField = new DataSourceTextField("monthPay", "月薪");
		monthPayField.setRequired(false);
		monthPayField.setLength(256);
		monthPayField.setHidden(false);

		basicProportionStrField = new DataSourceTextField("basicProportionStr", "基本比例（显示用）");
		basicProportionStrField.setRequired(false);
		basicProportionStrField.setLength(256);
		basicProportionStrField.setHidden(false);

		basicProportionField = new DataSourceFloatField("basicProportion", "基本比例（计算用）");
		basicProportionField.setRequired(true);
		basicProportionField.setLength(18);
		basicProportionField.setHidden(false);

		monthBasicPayField = new DataSourceTextField("monthBasicPay", "月基本工资");
		monthBasicPayField.setRequired(false);
		monthBasicPayField.setLength(256);
		monthBasicPayField.setHidden(false);

		monthPerformancePayField = new DataSourceTextField("monthPerformancePay", "月绩效工资");
		monthPerformancePayField.setRequired(false);
		monthPerformancePayField.setLength(256);
		monthPerformancePayField.setHidden(false);

		foremanPayField = new DataSourceTextField("foremanPay", "工龄工资");
		foremanPayField.setRequired(false);
		foremanPayField.setLength(256);
		foremanPayField.setHidden(false);

		otherSubsidyField = new DataSourceTextField("otherSubsidy", "其他补贴");
		otherSubsidyField.setRequired(false);
		otherSubsidyField.setLength(256);
		otherSubsidyField.setHidden(false);

		totalPayField = new DataSourceTextField("totalPay", "全薪");
		totalPayField.setRequired(false);
		totalPayField.setLength(256);
		totalPayField.setHidden(false);

		annualPerformanceField = new DataSourceTextField("annualPerformance", "年度绩效");
		annualPerformanceField.setRequired(false);
		annualPerformanceField.setLength(256);
		annualPerformanceField.setHidden(false);

		costAttributionField = new DataSourceIntegerField("costAttribution", "费用归属(1IT人员,2管理人员,3设计人员,4研发人员,5营销人员)");
		costAttributionField.setRequired(false);
		costAttributionField.setLength(11);
		costAttributionField.setHidden(false);

		certificationTimeField = new DataSourceDateTimeField("certificationTime", "领证时间");
		certificationTimeField.setRequired(false);
		certificationTimeField.setHidden(false);

		projectIdsField = new DataSourceIntegerField("projectIds", "项目编码");
		projectIdsField.setRequired(false);
		projectIdsField.setLength(11);
		projectIdsField.setHidden(false);

		stageIdField = new DataSourceIntegerField("stageId", "阶段id");
		stageIdField.setRequired(false);
		stageIdField.setLength(11);
		stageIdField.setHidden(false);

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


		setFields(processTypeField, employeeIdField, employeeNoField, departmentIdField, companyIdField, typeField, startDateField, startDateDetailField, endDateField, endDateDetailField, daysField, reasonField, remarkField, addressField, planField, transportationField, feeField, unitField, contactPersonField, createTimeField, deleteFlagField, nextAuditorField, subTypeField, hoursField, companyProvinceField, targetProvinceField, numberOfBabyField, attachmentField, isCompletedField, subTypeStrField, projectTypeField, projectIdField, projectNameField, projectCodeField, parentIdField, isRemoteCityField, provideAccommodationField, livingExpensesField, housingFinanceField, drafterField, cardField, dutyIdField, equivalentNumberField, linkIdField, severanceField, salary1Field, salary2Field, originalPayField, monthPayField, basicProportionStrField, basicProportionField, monthBasicPayField, monthPerformancePayField, foremanPayField, otherSubsidyField, totalPayField, annualPerformanceField, costAttributionField, certificationTimeField, projectIdsField, stageIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

