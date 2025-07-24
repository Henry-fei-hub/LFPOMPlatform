package com.pomplatform.client.personnel.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadFlowBudgetManagementApplyBuisnessData extends DBDataSource
{


	public static DSOnLoadFlowBudgetManagementApplyBuisnessData instance = null;

	public static DSOnLoadFlowBudgetManagementApplyBuisnessData getInstance() {
		if(instance == null) {
			instance = new DSOnLoadFlowBudgetManagementApplyBuisnessData("DSOnLoadFlowBudgetManagementApplyBuisnessData");
		}
		return instance;
	}

	private final DataSourceTextField processTypeNameField;
	private final DataSourceIntegerField processPooledTaskIdField;
	private final DataSourceIntegerField typeFlagField;
	private final DataSourceIntegerField processInstanceActivityIdField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField businessNameField;
	private final DataSourceIntegerField processActivityIdField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField nodeTypeField;
	private final DataSourceIntegerField activityIdField;
	private final DataSourceIntegerField nextActivityIdField;
	private final DataSourceIntegerField mainActivityIdField;
	private final DataSourceDateTimeField instanceActivityCreateTimeField;
	private final DataSourceDateTimeField instanceActivityStartTimeField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField processCommentField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField activityTypeField;
	private final DataSourceTextField backViewNameField;
	private final DataSourceIntegerField budgetManagementIdField;
	private final DataSourceTextField bdCodeField;
	private final DataSourceIntegerField bdTypeField;
	private final DataSourceFloatField bdTotalAmountField;
	private final DataSourceFloatField bdUseAmountField;
	private final DataSourceFloatField bdRestAmountField;
	private final DataSourceIntegerField bdApplyEmployeeIdField;
	private final DataSourceDateTimeField bdApplyTimeField;
	private final DataSourceDateTimeField bdEstimatecloseTimeField;
	private final DataSourceIntegerField bdStatusField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField bdRemarkField;
	private final DataSourceIntegerField inputTaxInvoiceIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceTextField costBearingField;
	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField typeField;
	private final DataSourceDateTimeField startDateField;
	private final DataSourceIntegerField startDateDetailField;
	private final DataSourceDateTimeField endDateField;
	private final DataSourceIntegerField endDateDetailField;
	private final DataSourceFloatField daysField;
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
	private final DataSourceIntegerField budgetAttachmentIdField;
	private final DataSourceIntegerField stageIdField;
	private final DataSourceIntegerField empStatusField;

	public DSOnLoadFlowBudgetManagementApplyBuisnessData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadFlowBudgetManagementApplyBuisnessData");


		processTypeNameField = new DataSourceTextField("processTypeName", "流程类型名称");
		processTypeNameField.setLength(64);
		processTypeNameField.setRequired(false);
		processTypeNameField.setHidden(true);


		processPooledTaskIdField = new DataSourceIntegerField("processPooledTaskId", "主键编码");
		processPooledTaskIdField.setLength(11);
		processPooledTaskIdField.setPrimaryKey(true);
		processPooledTaskIdField.setRequired(true);
		processPooledTaskIdField.setHidden(true);


		typeFlagField = new DataSourceIntegerField("typeFlag", "");
		typeFlagField.setLength(11);
		typeFlagField.setRequired(true);
		typeFlagField.setHidden(true);


		processInstanceActivityIdField = new DataSourceIntegerField("processInstanceActivityId", "主键编码");
		processInstanceActivityIdField.setLength(11);
		processInstanceActivityIdField.setPrimaryKey(true);
		processInstanceActivityIdField.setRequired(true);
		processInstanceActivityIdField.setHidden(true);


		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);


		businessNameField = new DataSourceTextField("businessName", "业务名称");
		businessNameField.setLength(256);
		businessNameField.setRequired(false);
		businessNameField.setHidden(true);


		processActivityIdField = new DataSourceIntegerField("processActivityId", "活动编码");
		processActivityIdField.setLength(11);
		processActivityIdField.setRequired(false);
		processActivityIdField.setHidden(true);


		processIdField = new DataSourceIntegerField("processId", "流程编码");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(true);


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程实列编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setHidden(true);


		nodeTypeField = new DataSourceIntegerField("nodeType", "附加节点，说明节点是预定义的节点还是动态加的节点， 0 - 正常定义的节点， 1 - 申请人或者审批人加的处理人或者审批人");
		nodeTypeField.setLength(11);
		nodeTypeField.setRequired(false);
		nodeTypeField.setHidden(true);


		activityIdField = new DataSourceIntegerField("activityId", "当前流程实例节点的内部编码");
		activityIdField.setLength(11);
		activityIdField.setRequired(false);
		activityIdField.setHidden(true);


		nextActivityIdField = new DataSourceIntegerField("nextActivityId", "下一个流程节点的编码");
		nextActivityIdField.setLength(11);
		nextActivityIdField.setRequired(false);
		nextActivityIdField.setHidden(true);


		mainActivityIdField = new DataSourceIntegerField("mainActivityId", "如果是知会节点，所依附的主节点");
		mainActivityIdField.setLength(11);
		mainActivityIdField.setRequired(false);
		mainActivityIdField.setHidden(true);


		instanceActivityCreateTimeField = new DataSourceDateTimeField("instanceActivityCreateTime", "流程实例节点创建时间");
		instanceActivityCreateTimeField.setRequired(false);
		instanceActivityCreateTimeField.setHidden(true);


		instanceActivityStartTimeField = new DataSourceDateTimeField("instanceActivityStartTime", "流程实例节点开始处于活动时间");
		instanceActivityStartTimeField.setRequired(false);
		instanceActivityStartTimeField.setHidden(true);


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);


		processCommentField = new DataSourceTextField("processComment", "提交意见");
		processCommentField.setLength(512);
		processCommentField.setRequired(false);
		processCommentField.setHidden(false);


		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_38"));


		activityTypeField = new DataSourceIntegerField("activityType", "节点类型 0 - 开始 1 - 结束 2 - 审批 3 - 处理 4 - 知会");
		activityTypeField.setLength(11);
		activityTypeField.setRequired(false);
		activityTypeField.setHidden(true);


		backViewNameField = new DataSourceTextField("backViewName", "返回数据集");
		backViewNameField.setLength(64);
		backViewNameField.setRequired(false);
		backViewNameField.setHidden(true);


		budgetManagementIdField = new DataSourceIntegerField("budgetManagementId", "预算管理编码");
		budgetManagementIdField.setLength(11);
		budgetManagementIdField.setRequired(false);
		budgetManagementIdField.setHidden(true);


		bdCodeField = new DataSourceTextField("bdCode", "预算编号");
		bdCodeField.setLength(1024);
		bdCodeField.setRequired(false);
		bdCodeField.setHidden(false);


		bdTypeField = new DataSourceIntegerField("bdType", "预算类型");
		bdTypeField.setLength(11);
		bdTypeField.setRequired(false);
		bdTypeField.setHidden(false);
		bdTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_191"));

		bdTotalAmountField = new DataSourceFloatField("bdTotalAmount", "预算总金额");
		bdTotalAmountField.setLength(18);
		bdTotalAmountField.setDecimalPad(2);
		bdTotalAmountField.setFormat("#,###,###,###,###,##0.00");
		bdTotalAmountField.setRequired(false);
		bdTotalAmountField.setHidden(false);


		bdUseAmountField = new DataSourceFloatField("bdUseAmount", "预算已用金额");
		bdUseAmountField.setLength(18);
		bdUseAmountField.setDecimalPad(2);
		bdUseAmountField.setFormat("#,###,###,###,###,##0.00");
		bdUseAmountField.setRequired(false);
		bdUseAmountField.setHidden(false);


		bdRestAmountField = new DataSourceFloatField("bdRestAmount", "预算剩余金额");
		bdRestAmountField.setLength(18);
		bdRestAmountField.setDecimalPad(2);
		bdRestAmountField.setFormat("#,###,###,###,###,##0.00");
		bdRestAmountField.setRequired(false);
		bdRestAmountField.setHidden(false);


		bdApplyEmployeeIdField = new DataSourceIntegerField("bdApplyEmployeeId", "申请人");
		bdApplyEmployeeIdField.setLength(11);
		bdApplyEmployeeIdField.setRequired(false);
		bdApplyEmployeeIdField.setHidden(false);
		bdApplyEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		bdApplyTimeField = new DataSourceDateTimeField("bdApplyTime", "申请时间");
		bdApplyTimeField.setRequired(false);
		bdApplyTimeField.setHidden(false);


		bdEstimatecloseTimeField = new DataSourceDateTimeField("bdEstimatecloseTime", "预期关闭时间");
		bdEstimatecloseTimeField.setRequired(false);
		bdEstimatecloseTimeField.setHidden(false);


		bdStatusField = new DataSourceIntegerField("bdStatus", "预算单状态");
		bdStatusField.setLength(11);
		bdStatusField.setRequired(false);
		bdStatusField.setHidden(false);
		bdStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_195"));


		projectIdField = new DataSourceIntegerField("projectId", "项目名称");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);
		KeyValueManager.loadValueMap("projects",projectIdField);


		bdRemarkField = new DataSourceTextField("bdRemark", "预算备注");
		bdRemarkField.setLength(2048);
		bdRemarkField.setRequired(false);
		bdRemarkField.setHidden(false);


		inputTaxInvoiceIdField = new DataSourceIntegerField("inputTaxInvoiceId", "发票编码");
		inputTaxInvoiceIdField.setLength(11);
		inputTaxInvoiceIdField.setRequired(false);
		inputTaxInvoiceIdField.setHidden(true);


		departmentIdField = new DataSourceIntegerField("departmentId", "承接部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));


		costBearingField = new DataSourceTextField("costBearing", "费用承担");
		costBearingField.setLength(512);
		costBearingField.setRequired(false);
		costBearingField.setHidden(true);


		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "人事业务编码");
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setPrimaryKey(true);
		personnelBusinessIdField.setRequired(true);
		personnelBusinessIdField.setHidden(true);


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);


		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setLength(32);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(true);


		typeField = new DataSourceIntegerField("type", "假期类型");
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setHidden(true);


		startDateField = new DataSourceDateTimeField("startDate", "开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(true);


		startDateDetailField = new DataSourceIntegerField("startDateDetail", "0上午   1下午");
		startDateDetailField.setLength(11);
		startDateDetailField.setRequired(false);
		startDateDetailField.setHidden(true);


		endDateField = new DataSourceDateTimeField("endDate", "截止日期");
		endDateField.setRequired(false);
		endDateField.setHidden(true);


		endDateDetailField = new DataSourceIntegerField("endDateDetail", "0上午   1下午");
		endDateDetailField.setLength(11);
		endDateDetailField.setRequired(false);
		endDateDetailField.setHidden(true);


		daysField = new DataSourceFloatField("days", "天数");
		daysField.setLength(6);
		daysField.setDecimalPad(2);
		daysField.setFormat("#,##0.00");
		daysField.setRequired(false);
		daysField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(true);


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


		contactPersonField = new DataSourceTextField("contactPerson", "联系人");
		contactPersonField.setLength(255);
		contactPersonField.setRequired(false);
		contactPersonField.setHidden(true);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		deleteFlagField = new DataSourceIntegerField("deleteFlag", "删除状态  0未删除    1已删除");
		deleteFlagField.setLength(11);
		deleteFlagField.setRequired(false);
		deleteFlagField.setHidden(true);


		nextAuditorField = new DataSourceIntegerField("nextAuditor", "自定义的审核人");
		nextAuditorField.setLength(11);
		nextAuditorField.setRequired(false);
		nextAuditorField.setHidden(true);


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


		attachmentField = new DataSourceTextField("attachment", "附件");
		attachmentField.setLength(255);
		attachmentField.setRequired(false);
		attachmentField.setHidden(true);


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


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(255);
		projectNameField.setRequired(false);
		projectNameField.setHidden(true);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(255);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(true);


		parentIdField = new DataSourceIntegerField("parentId", "父级编码  用于记录是根据哪一条记录进行延期");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(true);


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


		drafterField = new DataSourceIntegerField("drafter", "起草人");
		drafterField.setLength(11);
		drafterField.setRequired(false);
		drafterField.setHidden(true);


		cardField = new DataSourceTextField("card", "身份证");
		cardField.setLength(255);
		cardField.setRequired(false);
		cardField.setHidden(true);


		dutyIdField = new DataSourceIntegerField("dutyId", "职务");
		dutyIdField.setLength(11);
		dutyIdField.setRequired(false);
		dutyIdField.setHidden(true);


		equivalentNumberField = new DataSourceTextField("equivalentNumber", "对等号  与  冲账结合实现 借款与冲账与还款");
		equivalentNumberField.setLength(64);
		equivalentNumberField.setRequired(false);
		equivalentNumberField.setHidden(true);


		linkIdField = new DataSourceIntegerField("linkId", "关联表编码");
		linkIdField.setLength(11);
		linkIdField.setRequired(false);
		linkIdField.setHidden(true);


		severanceField = new DataSourceFloatField("severance", "离职补偿金");
		severanceField.setLength(18);
		severanceField.setDecimalPad(2);
		severanceField.setFormat("#,###,###,###,###,##0.00");
		severanceField.setRequired(false);
		severanceField.setHidden(true);


		salary1Field = new DataSourceTextField("salary1", "薪资1");
		salary1Field.setLength(256);
		salary1Field.setRequired(false);
		salary1Field.setHidden(true);


		salary2Field = new DataSourceTextField("salary2", "薪资2");
		salary2Field.setLength(256);
		salary2Field.setRequired(false);
		salary2Field.setHidden(true);


		originalPayField = new DataSourceTextField("originalPay", "现薪资");
		originalPayField.setLength(256);
		originalPayField.setRequired(false);
		originalPayField.setHidden(true);


		monthPayField = new DataSourceTextField("monthPay", "月薪");
		monthPayField.setLength(256);
		monthPayField.setRequired(false);
		monthPayField.setHidden(true);


		basicProportionStrField = new DataSourceTextField("basicProportionStr", "基本比例（显示用）");
		basicProportionStrField.setLength(256);
		basicProportionStrField.setRequired(false);
		basicProportionStrField.setHidden(true);


		basicProportionField = new DataSourceFloatField("basicProportion", "基本比例（计算用）");
		basicProportionField.setLength(18);
		basicProportionField.setDecimalPad(2);
		basicProportionField.setFormat("#,###,###,###,###,##0.00");
		basicProportionField.setRequired(false);
		basicProportionField.setHidden(true);


		monthBasicPayField = new DataSourceTextField("monthBasicPay", "月基本工资");
		monthBasicPayField.setLength(256);
		monthBasicPayField.setRequired(false);
		monthBasicPayField.setHidden(true);


		monthPerformancePayField = new DataSourceTextField("monthPerformancePay", "月绩效工资");
		monthPerformancePayField.setLength(256);
		monthPerformancePayField.setRequired(false);
		monthPerformancePayField.setHidden(true);


		foremanPayField = new DataSourceTextField("foremanPay", "工龄工资");
		foremanPayField.setLength(256);
		foremanPayField.setRequired(false);
		foremanPayField.setHidden(true);


		otherSubsidyField = new DataSourceTextField("otherSubsidy", "其他补贴");
		otherSubsidyField.setLength(256);
		otherSubsidyField.setRequired(false);
		otherSubsidyField.setHidden(true);


		totalPayField = new DataSourceTextField("totalPay", "全薪");
		totalPayField.setLength(256);
		totalPayField.setRequired(false);
		totalPayField.setHidden(true);


		annualPerformanceField = new DataSourceTextField("annualPerformance", "年度绩效");
		annualPerformanceField.setLength(256);
		annualPerformanceField.setRequired(false);
		annualPerformanceField.setHidden(true);


		costAttributionField = new DataSourceIntegerField("costAttribution", "费用归属(1IT人员,2管理人员,3设计人员,4研发人员,5营销人员)");
		costAttributionField.setLength(11);
		costAttributionField.setRequired(false);
		costAttributionField.setHidden(true);


		certificationTimeField = new DataSourceDateTimeField("certificationTime", "领证时间");
		certificationTimeField.setRequired(false);
		certificationTimeField.setHidden(true);


		projectIdsField = new DataSourceIntegerField("projectIds", "项目编码");
		projectIdsField.setLength(11);
		projectIdsField.setRequired(false);
		projectIdsField.setHidden(true);


		paymentSequenceIdField = new DataSourceIntegerField("paymentSequenceId", "付款序列编码");
		paymentSequenceIdField.setLength(11);
		paymentSequenceIdField.setRequired(false);
		paymentSequenceIdField.setHidden(true);


		budgetAttachmentIdField = new DataSourceIntegerField("budgetAttachmentId", "预算附件编码");
		budgetAttachmentIdField.setLength(11);
		budgetAttachmentIdField.setRequired(false);
		budgetAttachmentIdField.setHidden(true);


		stageIdField = new DataSourceIntegerField("stageId", "阶段id");
		stageIdField.setLength(11);
		stageIdField.setRequired(false);
		stageIdField.setHidden(true);


		empStatusField = new DataSourceIntegerField("empStatus", "在职状态");
		empStatusField.setLength(11);
		empStatusField.setRequired(true);
		empStatusField.setHidden(true);


		setFields(processPooledTaskIdField, processInstanceActivityIdField, personnelBusinessIdField, processTypeNameField, typeFlagField, businessIdField, businessNameField, processActivityIdField, processIdField, processInstanceIdField, nodeTypeField, activityIdField, nextActivityIdField, mainActivityIdField, instanceActivityCreateTimeField, instanceActivityStartTimeField, statusField, activityTypeField, backViewNameField, budgetManagementIdField, bdCodeField, bdTypeField, bdTotalAmountField, bdUseAmountField, bdRestAmountField, bdApplyEmployeeIdField, departmentIdField, companyIdField, bdApplyTimeField, bdEstimatecloseTimeField, bdStatusField, projectIdField, bdRemarkField, inputTaxInvoiceIdField, costBearingField, processTypeField, employeeNoField, typeField, startDateField, startDateDetailField, endDateField, endDateDetailField, daysField, remarkField, addressField, planField, transportationField, feeField, unitField, contactPersonField, createTimeField, deleteFlagField, nextAuditorField, subTypeField, hoursField, companyProvinceField, targetProvinceField, numberOfBabyField, attachmentField, isCompletedField, subTypeStrField, projectTypeField, projectNameField, projectCodeField, parentIdField, isRemoteCityField, provideAccommodationField, livingExpensesField, housingFinanceField, drafterField, cardField, dutyIdField, equivalentNumberField, linkIdField, severanceField, salary1Field, salary2Field, originalPayField, monthPayField, basicProportionStrField, basicProportionField, monthBasicPayField, monthPerformancePayField, foremanPayField, otherSubsidyField, totalPayField, annualPerformanceField, costAttributionField, certificationTimeField, projectIdsField, paymentSequenceIdField, budgetAttachmentIdField, stageIdField, empStatusField, operateTimeField, processCommentField);
	}


}

