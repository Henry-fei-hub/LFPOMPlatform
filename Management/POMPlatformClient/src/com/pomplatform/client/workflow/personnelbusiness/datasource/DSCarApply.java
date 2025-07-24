package com.pomplatform.client.workflow.personnelbusiness.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSCarApply extends DBDataSource
{


	public static DSCarApply instance = null;

	public static DSCarApply getInstance() {
		if(instance == null) {
			instance = new DSCarApply("DSCarApply");
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
	private final DataSourceField detailCarCostAllocation;

	public DSCarApply(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("CarApply");


		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "人事业务编码");
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setPrimaryKey(true);
		personnelBusinessIdField.setRequired(true);
		personnelBusinessIdField.setHidden(true);


		processTypeField = new DataSourceIntegerField("processType", "类型 13请假  14出差  15打卡  16外出  17加班");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);
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
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		typeField = new DataSourceIntegerField("type", "用车范围");
		typeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_104"));
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setHidden(false);


		startDateField = new DataSourceDateTimeField("startDate", "用车开始时间");
		startDateField.setRequired(false);
		startDateField.setHidden(false);


		startDateDetailField = new DataSourceIntegerField("startDateDetail", "用车类型");
		startDateDetailField.setValueMap(KeyValueManager.getValueMap("system_dictionary_119"));
		startDateDetailField.setLength(11);
		startDateDetailField.setRequired(false);
		startDateDetailField.setHidden(false);


		endDateField = new DataSourceDateTimeField("endDate", "预计结束时间");
		endDateField.setRequired(false);
		endDateField.setHidden(false);


		endDateDetailField = new DataSourceIntegerField("endDateDetail", "目的地所在区域");
		endDateDetailField.setValueMap(KeyValueManager.getValueMap("use_car_to_area"));
		endDateDetailField.setLength(11);
		endDateDetailField.setRequired(false);
		endDateDetailField.setHidden(false);


		daysField = new DataSourceFloatField("days", "天数");
		daysField.setLength(6);
		daysField.setDecimalPad(2);
		daysField.setFormat("#,##0.00");
		daysField.setRequired(false);
		daysField.setHidden(true);


		reasonField = new DataSourceTextField("reason", "用车目的");
		reasonField.setLength(1024);
		reasonField.setRequired(false);
		reasonField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		addressField = new DataSourceTextField("address", "申请用车车型");
		addressField.setValueMap(KeyValueManager.getValueMap("system_dictionary_122"));
		addressField.setLength(255);
		addressField.setRequired(false);
		addressField.setHidden(false);


		planField = new DataSourceTextField("plan", "行程安排");
		planField.setLength(1024);
		planField.setRequired(false);
		planField.setHidden(false);


		transportationField = new DataSourceTextField("transportation", "实际公里数");
		transportationField.setLength(255);
		transportationField.setRequired(false);
		transportationField.setHidden(false);


		feeField = new DataSourceFloatField("fee", "用车费用");
		feeField.setLength(18);
		feeField.setDecimalPad(2);
		feeField.setFormat("#,###,###,###,###,##0.00");
		feeField.setRequired(false);
		feeField.setHidden(false);


		unitField = new DataSourceTextField("unit", "同行人数");
		unitField.setLength(255);
		unitField.setRequired(false);
		unitField.setHidden(false);


		contactPersonField = new DataSourceTextField("contactPerson", "司机");
		contactPersonField.setLength(255);
		contactPersonField.setRequired(false);
		contactPersonField.setHidden(false);
		contactPersonField.setValueMap(KeyValueManager.getValueMap("employees"));
		


		createTimeField = new DataSourceDateTimeField("createTime", "起草时间");
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


		subTypeField = new DataSourceTextField("subType", "内部派车/外部专车");
		subTypeField.setLength(255);
		subTypeField.setRequired(false);
		subTypeField.setHidden(false);
		subTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_105"));
		

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


		targetProvinceField = new DataSourceIntegerField("targetProvince", "车辆信息");
		targetProvinceField.setLength(11);
		targetProvinceField.setRequired(false);
		targetProvinceField.setHidden(false);
		targetProvinceField.setValueMap(KeyValueManager.getValueMap("system_dictionary_106"));


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


		subTypeStrField = new DataSourceTextField("subTypeStr", "修改用车成本的原因");
		subTypeStrField.setLength(512);
		subTypeStrField.setRequired(false);
		subTypeStrField.setHidden(false);


		projectTypeField = new DataSourceIntegerField("projectType", "项目类型 1项目 2前期项目");
		projectTypeField.setLength(11);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(true);
		projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		projectIdField = new DataSourceIntegerField("projectId", "项目主键");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);
		KeyValueManager.loadValueMap("projects",projectIdField);


		projectNameField = new DataSourceTextField("projectName", "出发地");
		projectNameField.setLength(255);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		projectCodeField = new DataSourceTextField("projectCode", "目的地详细地址");
		projectCodeField.setLength(255);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		parentIdField = new DataSourceIntegerField("parentId", "父级编码  用于记录是根据哪一条记录进行延期");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(true);
//		parentIdField.setValueMap(KeyValueManager.getValueMap("contracts_1"));
		KeyValueManager.loadValueMap("contracts_1", parentIdField);

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
		drafterField.setValueMap(KeyValueManager.getValueMap("employees"));


		cardField = new DataSourceTextField("card", "手机号码");
		cardField.setLength(255);
		cardField.setRequired(false);
		cardField.setHidden(false);


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

		detailCarCostAllocation = new DataSourceField("detailCarCostAllocation", FieldType.ANY);
		detailCarCostAllocation.setChildrenProperty(true);
		detailCarCostAllocation.setChildTagName("CarCostAllocation");
		detailCarCostAllocation.setRequired(false);
		detailCarCostAllocation.setHidden(true);
		
		setFields(personnelBusinessIdField, processTypeField, companyIdField, departmentIdField, employeeIdField, employeeNoField, cardField, unitField, startDateField, endDateField, startDateDetailField, typeField, addressField, projectNameField, endDateDetailField, projectCodeField, feeField, reasonField, subTypeField, targetProvinceField, contactPersonField, planField, remarkField	, daysField, transportationField, createTimeField, deleteFlagField, nextAuditorField, hoursField, companyProvinceField, numberOfBabyField, attachmentField, isCompletedField, subTypeStrField, projectTypeField, projectIdField, parentIdField, isRemoteCityField, provideAccommodationField, livingExpensesField, housingFinanceField, drafterField, dutyIdField, equivalentNumberField, linkIdField, detailCarCostAllocation);
	}


}

