package com.pomplatform.client.preprojects.datasource;

import java.util.LinkedHashMap;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceImageField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.widgets.form.fields.TextItem;


public class DSprojectPreInfomations extends DBDataSource
{


	public static DSprojectPreInfomations instance = null;

	public static DSprojectPreInfomations getInstance() {
		if(instance == null) {
			instance = new DSprojectPreInfomations("DSprojectPreInfomations");
		}
		return instance;
	}

	private final DataSourceImageField warnImgField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField customerNameField;
	private final DataSourceTextField businessTypeField;
	private final DataSourceTextField detailAddressField;
	private final DataSourceIntegerField projectLevelField;
	private final DataSourceFloatField contractAmountField;
	private final DataSourceTextField winRateField;
	private final DataSourceTextField projectStatusField;
	private final DataSourceIntegerField applyEmployeeIdField;
	private final DataSourceTextField projectSalesTeamField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField projectBaseOnField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateField registerDateField;
	private final DataSourceTextField projectOriginationField;
	private final DataSourceIntegerField comparisonFormField;
	private final DataSourceTextField contactNameField;
	private final DataSourceTextField contactPhoneField;
	private final DataSourceTextField projectMissionerField;
	private final DataSourceFloatField estimateTheDesignAreasField;
	private final DataSourceFloatField actualDesignAreasField;
	private final DataSourceFloatField projectTotalInvestmentField;
	private final DataSourceFloatField decorateMoneyControlField;
	private final DataSourceIntegerField designTeamField;
	private final DataSourceTextField projectLeaderField;
	private final DataSourceTextField projectManagerField;
	private final DataSourceIntegerField contractStatusField;
	private final DataSourceTextField designStatusField;
	private final DataSourceTextField projectOriginationRemarkField;
	private final DataSourceTextField provinceField;
	private final DataSourceTextField cityField;
	private final DataSourceDateTimeField infoRegisterTimeField;
	private final DataSourceTextField customerAddressField;
	private final DataSourceIntegerField signCompanyField;
	private final DataSourceTextField designQualificationField;
	private final DataSourceDateTimeField projectApprovalTimeField;
	private final DataSourceTextField designCooperationNameField;
	private final DataSourceTextField isHighRiseBuildingField;
	private final DataSourceFloatField totalBuildingAreasField;
	private final DataSourceTextField fireResistanceRatingField;
	private final DataSourceFloatField buildingHeightField;
	private final DataSourceFloatField buildingFloorsField;
	private final DataSourceTextField architecturalDesignUnitsField;
	private final DataSourceTextField contactEmailField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField projectTypeField;
	private final DataSourceIntegerField clientIdField;
	private final DataSourceIntegerField regionField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField closeReasonField;
	private final DataSourceTextField closeRemarkField;
	private final DataSourceTextField gradeField;
	private final DataSourceBooleanField isOriginalField;
	private final DataSourceBooleanField isSubProjectField;
	private final DataSourceFloatField daysField;
	private final DataSourceIntegerField flagField;
	private final DataSourceBooleanField isPubliclyBiddingField;
	private final DataSourceBooleanField haveAgentsField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField ownerTypeIdField;
	private final DataSourceFloatField estimatePriceField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField preProjectIdField; 
	private final DataSourceTextField  specialtyField;
	private final DataSourceTextField  competitionNameField;
	private final DataSourceTextField isOperationDepartmentField;
	private final DataSourceFloatField projectOutputValueField;

	public DSprojectPreInfomations(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("projectPreInfomations");
		LinkedHashMap<String, Object> linkMap=new LinkedHashMap<>();
		linkMap.put("true", "是");
		linkMap.put("false", "否");

		warnImgField = new DataSourceImageField("warnImg", "警示");
		warnImgField.setLength(512);
		warnImgField.setRequired(false);
		warnImgField.setHidden(false);
		warnImgField.setImageHeight(16);
		warnImgField.setImageWidth(16);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(32);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(true);


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
		customerNameField.setValueMap(KeyValueManager.getValueMap("customers_name"));

		businessTypeField = new DataSourceTextField("businessType", "业务类别");
		businessTypeField.setLength(64);
		//businessTypeField.setValueMap(KeyValueManager.getValueMap("pre_business_type_detail"));
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(false);


		detailAddressField = new DataSourceTextField("detailAddress", "项目地址");
		detailAddressField.setLength(512);
		detailAddressField.setRequired(false);
		detailAddressField.setHidden(false);


		projectLevelField = new DataSourceIntegerField("projectLevel", "项目等级");
		projectLevelField.setLength(11);
		projectLevelField.setRequired(false);
		projectLevelField.setHidden(true);
		projectLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));


		contractAmountField = new DataSourceFloatField("contractAmount", "预估合同金额(元)");
		contractAmountField.setLength(18);
		contractAmountField.setDecimalPad(2);
		contractAmountField.setFormat("#,###,###,###,###,##0.00");
		contractAmountField.setRequired(false);
		contractAmountField.setHidden(true);


		winRateField = new DataSourceTextField("winRate", "赢率");
		winRateField.setLength(64);
		winRateField.setRequired(false);
		winRateField.setHidden(true);


		projectStatusField = new DataSourceTextField("projectStatus", "项目状态");
		projectStatusField.setLength(64);
		projectStatusField.setRequired(false);
		projectStatusField.setHidden(false);


		applyEmployeeIdField = new DataSourceIntegerField("applyEmployeeId", "报备人");
		applyEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		applyEmployeeIdField.setLength(11);
		applyEmployeeIdField.setRequired(false);
		applyEmployeeIdField.setHidden(false);


		projectSalesTeamField = new DataSourceTextField("projectSalesTeam", "项目团队");
		projectSalesTeamField.setLength(64);
		projectSalesTeamField.setRequired(false);
		projectSalesTeamField.setHidden(true);


		processStatusField = new DataSourceIntegerField("processStatus", "报备流程状态");
		processStatusField.setLength(11);
		processStatusField.setRequired(false);
		processStatusField.setHidden(false);
		processStatusField.setValueMap(KeyValueManager.getValueMap("process_status"));


		statusField = new DataSourceIntegerField("status", "立项/关闭的流程状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(true);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_161")); 


		projectBaseOnField = new DataSourceIntegerField("projectBaseOn", "立项依据");
		projectBaseOnField.setLength(11);
		projectBaseOnField.setRequired(false);
		projectBaseOnField.setHidden(true);
		projectBaseOnField.setValueMap(KeyValueManager.getValueMap("system_dictionary_28")); 


		createTimeField = new DataSourceDateTimeField("createTime", "登记时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		registerDateField = new DataSourceDateField("registerDate", "台账记录日期");
		registerDateField.setRequired(false);
		registerDateField.setHidden(true);


		projectOriginationField = new DataSourceTextField("projectOrigination", "项目来源渠道");
		projectOriginationField.setLength(512);
		projectOriginationField.setRequired(false);
		projectOriginationField.setHidden(false);


		comparisonFormField = new DataSourceIntegerField("comparisonForm", "比选形式");
		comparisonFormField.setLength(11);
		comparisonFormField.setRequired(false);
		comparisonFormField.setValueMap(KeyValueManager.getValueMap("system_dictionary_168"));
		comparisonFormField.setHidden(false);


		contactNameField = new DataSourceTextField("contactName", "客户联系人");
		contactNameField.setLength(64);
		contactNameField.setRequired(false);
		contactNameField.setHidden(false);


		contactPhoneField = new DataSourceTextField("contactPhone", "客户联系电话");
		contactPhoneField.setLength(128);
		contactPhoneField.setRequired(false);
		contactPhoneField.setHidden(false);


		projectMissionerField = new DataSourceTextField("projectMissioner", "项目秘书");
		projectMissionerField.setLength(128);
		projectMissionerField.setRequired(true);
		projectMissionerField.setHidden(false);


		estimateTheDesignAreasField = new DataSourceFloatField("estimateTheDesignAreas", "计容建筑面积(㎡)");
		estimateTheDesignAreasField.setLength(18);
		estimateTheDesignAreasField.setDecimalPad(2);
		estimateTheDesignAreasField.setFormat("#,###,###,###,###,##0.00");
		estimateTheDesignAreasField.setRequired(false);
		estimateTheDesignAreasField.setHidden(true);


		actualDesignAreasField = new DataSourceFloatField("actualDesignAreas", "实际设计面积m²");
		actualDesignAreasField.setLength(18);
		actualDesignAreasField.setDecimalPad(2);
		actualDesignAreasField.setFormat("#,###,###,###,###,##0.00");
		actualDesignAreasField.setRequired(false);
		actualDesignAreasField.setHidden(true);


		projectTotalInvestmentField = new DataSourceFloatField("projectTotalInvestment", "项目总投资额(元)");
		projectTotalInvestmentField.setLength(18);
		projectTotalInvestmentField.setDecimalPad(2);
		projectTotalInvestmentField.setFormat("#,###,###,###,###,##0.00");
		projectTotalInvestmentField.setRequired(false);
		projectTotalInvestmentField.setHidden(true);


		decorateMoneyControlField = new DataSourceFloatField("decorateMoneyControl", "装修造价控制(元)");
		decorateMoneyControlField.setLength(18);
		decorateMoneyControlField.setDecimalPad(2);
		decorateMoneyControlField.setFormat("#,###,###,###,###,##0.00");
		decorateMoneyControlField.setRequired(false);
		decorateMoneyControlField.setHidden(true);


		designTeamField = new DataSourceIntegerField("designTeam", "主办设计团队");
		designTeamField.setLength(11);
		designTeamField.setValueMap(KeyValueManager.getValueMap("plate_records"));;
		designTeamField.setRequired(false);
		designTeamField.setHidden(true);


		projectLeaderField = new DataSourceTextField("projectLeader", "项目主管领导");
		projectLeaderField.setLength(-1);
		projectLeaderField.setRequired(true);
		projectLeaderField.setHidden(true);


		projectManagerField = new DataSourceTextField("projectManager", "项目经理");
		projectManagerField.setLength(-1);
		projectManagerField.setRequired(true);
		projectManagerField.setHidden(true);


		contractStatusField = new DataSourceIntegerField("contractStatus", "合同状态");
		contractStatusField.setLength(11);
		contractStatusField.setRequired(false);
		contractStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_35"));
		contractStatusField.setHidden(true);


		designStatusField = new DataSourceTextField("designStatus", "设计状态");
		designStatusField.setLength(128);
		designStatusField.setRequired(false);
		designStatusField.setHidden(true);


		projectOriginationRemarkField = new DataSourceTextField("projectOriginationRemark", "项目来源说明");
		projectOriginationRemarkField.setLength(2048);
		projectOriginationRemarkField.setRequired(false);
		projectOriginationRemarkField.setHidden(true);


		provinceField = new DataSourceTextField("province", "项目地址（省）");
		provinceField.setLength(32);
		provinceField.setRequired(false);
		provinceField.setHidden(false);


		cityField = new DataSourceTextField("city", "项目地址（市）");
		cityField.setLength(32);
		cityField.setRequired(false);
		cityField.setHidden(false);


		infoRegisterTimeField = new DataSourceDateTimeField("infoRegisterTime", "项目修改时间");
		infoRegisterTimeField.setRequired(false);
		infoRegisterTimeField.setHidden(true);


		customerAddressField = new DataSourceTextField("customerAddress", "客户地址");
		customerAddressField.setLength(512);
		customerAddressField.setRequired(false);
		customerAddressField.setHidden(true);


		signCompanyField = new DataSourceIntegerField("signCompany", "拟签约公司");
		signCompanyField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		signCompanyField.setLength(11);
		signCompanyField.setRequired(false);
		signCompanyField.setHidden(true);


		designQualificationField = new DataSourceTextField("designQualification", "设计资质章");
		designQualificationField.setLength(128);
		designQualificationField.setRequired(false);
		designQualificationField.setHidden(true);


		projectApprovalTimeField = new DataSourceDateTimeField("projectApprovalTime", "立项时间");
		projectApprovalTimeField.setRequired(false);
		projectApprovalTimeField.setHidden(true);


		designCooperationNameField = new DataSourceTextField("designCooperationName", "设计合作单位");
		designCooperationNameField.setLength(512);
		designCooperationNameField.setRequired(false);
		designCooperationNameField.setHidden(true);


		isHighRiseBuildingField = new DataSourceTextField("isHighRiseBuilding", "是否高层建筑");
		isHighRiseBuildingField.setValueMap(linkMap);
		isHighRiseBuildingField.setRequired(false);
		isHighRiseBuildingField.setHidden(true);


		totalBuildingAreasField = new DataSourceFloatField("totalBuildingAreas", "建筑总面积m²");
		totalBuildingAreasField.setLength(18);
		totalBuildingAreasField.setDecimalPad(2);
		totalBuildingAreasField.setFormat("#,###,###,###,###,##0.00");
		totalBuildingAreasField.setRequired(false);
		totalBuildingAreasField.setHidden(true);


		fireResistanceRatingField = new DataSourceTextField("fireResistanceRating", "耐火等级");
		fireResistanceRatingField.setLength(64);
		fireResistanceRatingField.setRequired(false);
		fireResistanceRatingField.setHidden(true);


		buildingHeightField = new DataSourceFloatField("buildingHeight", "建筑高度");
		buildingHeightField.setLength(18);
		buildingHeightField.setDecimalPad(2);
		buildingHeightField.setFormat("#,###,###,###,###,##0.00");
		buildingHeightField.setRequired(false);
		buildingHeightField.setHidden(true);


		buildingFloorsField = new DataSourceFloatField("buildingFloors", "建筑楼层");
		buildingFloorsField.setLength(18);
		buildingFloorsField.setDecimalPad(2);
		buildingFloorsField.setFormat("#,###,###,###,###,##0.00");
		buildingFloorsField.setRequired(false);
		buildingFloorsField.setHidden(true);


		architecturalDesignUnitsField = new DataSourceTextField("architecturalDesignUnits", "建筑设计单位");
		architecturalDesignUnitsField.setLength(512);
		architecturalDesignUnitsField.setRequired(false);
		architecturalDesignUnitsField.setHidden(true);


		contactEmailField = new DataSourceTextField("contactEmail", "联系人邮箱");
		contactEmailField.setLength(255);
		contactEmailField.setRequired(false);
		contactEmailField.setHidden(true);


		plateIdField = new DataSourceIntegerField("plateId", "板块");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(true);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(true);

		projectTypeField = new DataSourceTextField("projectType", "项目类别");
		projectTypeField.setLength(128);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(false);
		projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_244"));


		clientIdField = new DataSourceIntegerField("clientId", "开发商id");
		clientIdField.setLength(11);
		clientIdField.setRequired(false);
		clientIdField.setHidden(true);


		regionField = new DataSourceIntegerField("region", "区域");
		regionField.setValueMap(KeyValueManager.getValueMap("system_dictionary_170"));
		regionField.setLength(11);
		regionField.setRequired(false);
		regionField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "项目备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(true);


		closeReasonField = new DataSourceTextField("closeReason", "项目关闭原因");
		closeReasonField.setValueMap(KeyValueManager.getValueMap("system_dictionary_169"));
		closeReasonField.setLength(2048);
		closeReasonField.setRequired(false);
		closeReasonField.setHidden(true);


		closeRemarkField = new DataSourceTextField("closeRemark", "项目关闭备注");
		closeRemarkField.setLength(512);
		closeRemarkField.setRequired(false);
		closeRemarkField.setHidden(true);


		gradeField = new DataSourceTextField("grade", "联系人职位");
		gradeField.setLength(64);
		gradeField.setRequired(false);
		gradeField.setHidden(false);


		isOriginalField = new DataSourceBooleanField("isOriginal", "是否原创");
		isOriginalField.setValueMap(linkMap);
		isOriginalField.setRequired(false);
		isOriginalField.setHidden(true);


		isSubProjectField = new DataSourceBooleanField("isSubProject", "是否建筑院分包项目");
		isSubProjectField.setRequired(false);
		isSubProjectField.setHidden(true);


		daysField = new DataSourceFloatField("days", "");
		daysField.setLength(8);
		daysField.setDecimalPad(0);
		daysField.setFormat("##,###,##0");
		daysField.setRequired(true);
		daysField.setHidden(true);


		flagField = new DataSourceIntegerField("flag", "");
		flagField.setLength(11);
		flagField.setRequired(true);
		flagField.setHidden(true);


		isPubliclyBiddingField = new DataSourceBooleanField("isPubliclyBidding", "是否公开挂网招标");
		isPubliclyBiddingField.setRequired(false);
		isPubliclyBiddingField.setHidden(true);


		haveAgentsField = new DataSourceBooleanField("haveAgents", "是否有代理商");
		haveAgentsField.setRequired(false);
		haveAgentsField.setHidden(true);


		departmentIdField = new DataSourceIntegerField("departmentId", "项目营销团队");
		departmentIdField.setLength(11);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(true);

		ownerTypeIdField = new DataSourceIntegerField("ownerTypeId", "业主所属行业类型");
		ownerTypeIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_177")); 
		ownerTypeIdField.setLength(11);
		ownerTypeIdField.setRequired(false);
		ownerTypeIdField.setHidden(true);


		estimatePriceField = new DataSourceFloatField("estimatePrice", "预估价格(元)");
		estimatePriceField.setLength(18);
		estimatePriceField.setDecimalPad(2);
		estimatePriceField.setFormat("#,###,###,###,###,##0.00");
		estimatePriceField.setRequired(false);
		estimatePriceField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "创建人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);


		preProjectIdField = new DataSourceIntegerField("preProjectId", "主键编码");
		preProjectIdField.setLength(11);
		preProjectIdField.setPrimaryKey(true);
		preProjectIdField.setRequired(true);
		preProjectIdField.setHidden(true);
		
		specialtyField = new DataSourceTextField("specialty", "项目参与专业");
		specialtyField.setLength(512);
		specialtyField.setRequired(false);
		specialtyField.setHidden(true);
		
		competitionNameField = new DataSourceTextField("competitionName", "竞争单位");
		competitionNameField.setLength(512);
		competitionNameField.setRequired(false);
		competitionNameField.setHidden(true);
		
		isOperationDepartmentField = new DataSourceTextField("isOperationDepartment", "是否运营组分配项目");
		isOperationDepartmentField.setValueMap(linkMap);
		isOperationDepartmentField.setRequired(false);
		isOperationDepartmentField.setHidden(true);
		
		
		projectOutputValueField = new DataSourceFloatField("projectOutputValue", "项目产值");
		projectOutputValueField.setLength(18);
		projectOutputValueField.setDecimalPad(2);
		projectOutputValueField.setFormat("#,###,###,###,###,##0.00");
		projectOutputValueField.setRequired(false);
		projectOutputValueField.setHidden(true);



		setFields(preProjectIdField, warnImgField, projectCodeField, infoCodeField, projectNameField, customerNameField,projectTypeField, businessTypeField,provinceField, cityField, detailAddressField, projectLevelField, contractAmountField, winRateField, projectStatusField, applyEmployeeIdField, departmentIdField, processStatusField, statusField, projectBaseOnField, createTimeField, registerDateField, projectOriginationField, comparisonFormField, contactNameField, contactPhoneField, projectMissionerField, estimateTheDesignAreasField, actualDesignAreasField, projectTotalInvestmentField, decorateMoneyControlField, designTeamField, projectLeaderField, projectManagerField, contractStatusField, designStatusField, projectOriginationRemarkField, infoRegisterTimeField, customerAddressField, signCompanyField, designQualificationField, projectApprovalTimeField, designCooperationNameField, isHighRiseBuildingField, totalBuildingAreasField, fireResistanceRatingField, buildingHeightField, buildingFloorsField, architecturalDesignUnitsField, contactEmailField, plateIdField, employeeNameField, clientIdField, regionField, remarkField, closeReasonField, closeRemarkField, gradeField, isOriginalField, isSubProjectField, daysField, flagField, isPubliclyBiddingField, haveAgentsField, departmentIdField, ownerTypeIdField, estimatePriceField, employeeIdField,specialtyField,competitionNameField,isOperationDepartmentField,projectOutputValueField);
	}


}

