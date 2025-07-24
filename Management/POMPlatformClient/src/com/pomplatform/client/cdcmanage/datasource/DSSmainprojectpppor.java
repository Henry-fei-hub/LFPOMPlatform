package com.pomplatform.client.cdcmanage.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSmainprojectpppor extends DBDataSource {

	public static DSSmainprojectpppor instance = null;

	public static DSSmainprojectpppor getInstance() {
		if (instance == null) {
			instance = new DSSmainprojectpppor("DSSmainprojectpppor");
		}
		return instance;
	}

	private final DataSourceIntegerField mainProjectIdField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField projectEnglishNameField;
	private final DataSourceTextField projectStatusField;
	private final DataSourceTextField designStatusField;
	private final DataSourceIntegerField signCompanyField;
	private final DataSourceTextField projectOriginationField;
	private final DataSourceTextField projectOriginationRemarkField;
	private final DataSourceTextField designCooperationNameField;
	private final DataSourceTextField designCooperationEnglishNameField;
	private final DataSourceIntegerField designTeamField;
	private final DataSourceBooleanField isHighRiseBuildingField;
	private final DataSourceDateTimeField infoRegisterTimeField;
	private final DataSourceDateTimeField projectApprovalTimeField;
	private final DataSourceBooleanField hasContractField;
	private final DataSourceIntegerField projectBaseOnField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField projectModelField;
	private final DataSourceTextField designQualificationField;
	private final DataSourceTextField businessTypeField;
	private final DataSourceTextField fireResistanceRatingField;
	private final DataSourceTextField estimateTheDesignAreasField;
	private final DataSourceTextField projectTotalInvestmentField;
	private final DataSourceTextField actualDesignAreasField;
	private final DataSourceTextField totalBuildingAreasField;
	private final DataSourceTextField buildingHeightField;
	private final DataSourceTextField buildingFloorsField;
	private final DataSourceTextField decorateMoneyControlField;
	private final DataSourceIntegerField projectLevelField;
	private final DataSourceTextField provinceField;
	private final DataSourceTextField cityField;
	private final DataSourceTextField detailAddressField;
	private final DataSourceDateField projectEndTimeField;
	private final DataSourceTextField projectTypeField;
	private final DataSourceTextField customerNameField;
	private final DataSourceTextField customerAddressField;
	private final DataSourceTextField bidProjectField;
	private final DataSourceTextField constructionUnitField;
	private final DataSourceTextField architecturalDesignUnitsField;
	private final DataSourceTextField rateOfBidWinningField;
	private final DataSourceDateTimeField followUpDateField;
	private final DataSourceTextField equityedgeRemarkField;
	private final DataSourceDateTimeField orderSignUpTimeField;
	private final DataSourceTextField designServiceBookField;
	private final DataSourceTextField serviceSuggestBookField;
	private final DataSourceFloatField totalMoneyField;
	private final DataSourceFloatField coveredAreaField;
	private final DataSourceFloatField designAreaField;
	private final DataSourceBooleanField hasFormalContractsField;
	private final DataSourceBooleanField hasOutQuotationsField;
	private final DataSourceTextField specialtyField;
	private final DataSourceTextField projectSalesTeamField;
	private final DataSourceBooleanField hasSplitPriceField;
	private final DataSourceBooleanField hasOrderReleaseField;
	private final DataSourceBooleanField hasDepositField;
	private final DataSourceFloatField hasRateOfPaymentField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceIntegerField serialNumberField;
	private final DataSourceDateTimeField hasFormalContractTimeField;
	private final DataSourceDateTimeField hasOutQuotationTimeField;
	private final DataSourceDateTimeField hasOrderReleaseTimeField;
	private final DataSourceDateTimeField hasSplitPriceTimeField;
	private final DataSourceIntegerField bidTypeField;
	private final DataSourceDateField bidDateField;
	private final DataSourceIntegerField bidClassTypeField;
	private final DataSourceIntegerField bidUnitNumField;
	private final DataSourceTextField ourOrderField;
	private final DataSourceFloatField bigPayAmountField;
	private final DataSourceBooleanField bigIsAchieveAmountField;
	private final DataSourceFloatField bigAdvanceAmountField;
	private final DataSourceIntegerField clientIdField;
	private final DataSourceTextField contactNameField;
	private final DataSourceTextField contactPhoneField;
	private final DataSourceIntegerField applyEmployeeIdField;
	private final DataSourceIntegerField customerContactIdField;
	private final DataSourceIntegerField architecturalDesignUnitIdField;
	private final DataSourceIntegerField architecturalDesignUnitContactIdField;
	private final DataSourceIntegerField regionField;
	private final DataSourceIntegerField comparisonFormField;
	private final DataSourceBooleanField isOriginalField;
	private final DataSourceBooleanField isSubProjectField;
	private final DataSourceIntegerField contractStatusField;
	private final DataSourceBooleanField isPubliclyBiddingField;
	private final DataSourceBooleanField haveAgentsField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceTextField companyNoField;
	private final DataSourceFloatField percentField;
	private final DataSourceIntegerField ownerTypeIdField;
	private final DataSourceFloatField estimatePriceField;
	private final DataSourceIntegerField projectPhaseField;
	private final DataSourceIntegerField projectAttributeField;

	public DSSmainprojectpppor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Smainprojectpppor");

		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "主键编码");
		mainProjectIdField.setLength(11);
		mainProjectIdField.setPrimaryKey(true);
		mainProjectIdField.setRequired(true);
		mainProjectIdField.setHidden(true);
		mainProjectIdField.setRootValue("root");
		mainProjectIdField.setForeignKey("DSSmainprojectpppor.mainProjectId");

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(11);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(64);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);

		projectEnglishNameField = new DataSourceTextField("projectEnglishName", "项目英文名称");
		projectEnglishNameField.setLength(512);
		projectEnglishNameField.setRequired(false);
		projectEnglishNameField.setHidden(true);

		projectStatusField = new DataSourceTextField("projectStatus", "项目状态");
		projectStatusField.setLength(64);
		projectStatusField.setRequired(false);
		projectStatusField.setHidden(true);
		projectStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_4"));

		designStatusField = new DataSourceTextField("designStatus", "设计状态");
		designStatusField.setLength(64);
		designStatusField.setRequired(false);
		designStatusField.setHidden(true);
		designStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_5"));

		signCompanyField = new DataSourceIntegerField("signCompany", "拟签约公司");
		signCompanyField.setLength(11);
		signCompanyField.setRequired(false);
		signCompanyField.setHidden(true);
		signCompanyField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));

		projectOriginationField = new DataSourceTextField("projectOrigination", "项目来源渠道");
		projectOriginationField.setLength(512);
		projectOriginationField.setRequired(false);
		projectOriginationField.setHidden(true);

		projectOriginationRemarkField = new DataSourceTextField("projectOriginationRemark", "项目来源说明");
		projectOriginationRemarkField.setLength(2048);
		projectOriginationRemarkField.setRequired(false);
		projectOriginationRemarkField.setHidden(true);

		designCooperationNameField = new DataSourceTextField("designCooperationName", "设计合作单位");
		designCooperationNameField.setLength(64);
		designCooperationNameField.setRequired(false);
		designCooperationNameField.setHidden(true);

		designCooperationEnglishNameField = new DataSourceTextField("designCooperationEnglishName", "设计合作单位英文名称");
		designCooperationEnglishNameField.setLength(64);
		designCooperationEnglishNameField.setRequired(false);
		designCooperationEnglishNameField.setHidden(true);

		projectSalesTeamField = new DataSourceTextField("projectSalesTeam", "项目营销团队");
		projectSalesTeamField.setLength(32);
		projectSalesTeamField.setRequired(false);
		projectSalesTeamField.setHidden(true);

		designTeamField = new DataSourceIntegerField("designTeam", "主办设计团队");
		designTeamField.setLength(11);
		designTeamField.setRequired(false);
		designTeamField.setHidden(true);
		designTeamField.setValueMap(KeyValueManager.getValueMap("departments"));

		isHighRiseBuildingField = new DataSourceBooleanField("isHighRiseBuilding", "是否高层建筑");
		isHighRiseBuildingField.setRequired(false);
		isHighRiseBuildingField.setHidden(true);

		infoRegisterTimeField = new DataSourceDateTimeField("infoRegisterTime", "信息登记时间");
		infoRegisterTimeField.setRequired(false);
		infoRegisterTimeField.setHidden(true);

		projectApprovalTimeField = new DataSourceDateTimeField("projectApprovalTime", "正式立项时间");
		projectApprovalTimeField.setRequired(false);
		projectApprovalTimeField.setHidden(false);

		hasContractField = new DataSourceBooleanField("hasContract", "是否有合同");
		hasContractField.setRequired(false);
		hasContractField.setHidden(true);

		projectBaseOnField = new DataSourceIntegerField("projectBaseOn", "立项依据0未知、  1投标立项、 2合同立项、  3委托函立项");
		projectBaseOnField.setLength(11);
		projectBaseOnField.setRequired(false);
		projectBaseOnField.setHidden(true);

		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(32);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(true);

		projectModelField = new DataSourceTextField("projectModel", "立项模式");
		projectModelField.setLength(20);
		projectModelField.setRequired(false);
		projectModelField.setHidden(true);

		designQualificationField = new DataSourceTextField("designQualification", "设计资质章");
		designQualificationField.setLength(20);
		designQualificationField.setRequired(false);
		designQualificationField.setHidden(true);

		businessTypeField = new DataSourceTextField("businessType", "业务类别");
		businessTypeField.setLength(64);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(true);

		fireResistanceRatingField = new DataSourceTextField("fireResistanceRating", "耐火等级");
		fireResistanceRatingField.setLength(64);
		fireResistanceRatingField.setRequired(false);
		fireResistanceRatingField.setHidden(true);

		estimateTheDesignAreasField = new DataSourceTextField("estimateTheDesignAreas", "计容建筑面积(㎡)");
		estimateTheDesignAreasField.setLength(100);
		estimateTheDesignAreasField.setRequired(false);
		estimateTheDesignAreasField.setHidden(true);

		projectTotalInvestmentField = new DataSourceTextField("projectTotalInvestment", "项目总投资额");
		projectTotalInvestmentField.setLength(100);
		projectTotalInvestmentField.setRequired(false);
		projectTotalInvestmentField.setHidden(true);

		actualDesignAreasField = new DataSourceTextField("actualDesignAreas", "实际设计面积");
		actualDesignAreasField.setLength(100);
		actualDesignAreasField.setRequired(false);
		actualDesignAreasField.setHidden(true);

		totalBuildingAreasField = new DataSourceTextField("totalBuildingAreas", "建筑总面积");
		totalBuildingAreasField.setLength(100);
		totalBuildingAreasField.setRequired(false);
		totalBuildingAreasField.setHidden(true);

		buildingHeightField = new DataSourceTextField("buildingHeight", "建筑高度");
		buildingHeightField.setLength(100);
		buildingHeightField.setRequired(false);
		buildingHeightField.setHidden(true);

		buildingFloorsField = new DataSourceTextField("buildingFloors", "建筑楼层");
		buildingFloorsField.setLength(100);
		buildingFloorsField.setRequired(false);
		buildingFloorsField.setHidden(true);

		decorateMoneyControlField = new DataSourceTextField("decorateMoneyControl", "装修造价控制");
		decorateMoneyControlField.setLength(100);
		decorateMoneyControlField.setRequired(false);
		decorateMoneyControlField.setHidden(true);

		projectLevelField = new DataSourceIntegerField("projectLevel", "项目等级");
		projectLevelField.setLength(11);
		projectLevelField.setRequired(false);
		projectLevelField.setHidden(true);

		provinceField = new DataSourceTextField("province", "省份");
		provinceField.setLength(32);
		provinceField.setRequired(false);
		provinceField.setHidden(true);

		cityField = new DataSourceTextField("city", "城市");
		cityField.setLength(32);
		cityField.setRequired(false);
		cityField.setHidden(true);

		detailAddressField = new DataSourceTextField("detailAddress", "详细地址");
		detailAddressField.setLength(64);
		detailAddressField.setRequired(false);
		detailAddressField.setHidden(true);

		projectEndTimeField = new DataSourceDateField("projectEndTime", "项目完成时间");
		projectEndTimeField.setRequired(false);
		projectEndTimeField.setHidden(true);

		projectTypeField = new DataSourceTextField("projectType", "项目类别");
		projectTypeField.setLength(128);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(true);

		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setLength(50);
		customerNameField.setRequired(false);
		customerNameField.setHidden(true);

		customerAddressField = new DataSourceTextField("customerAddress", "客户地址");
		customerAddressField.setLength(512);
		customerAddressField.setRequired(false);
		customerAddressField.setHidden(true);

		bidProjectField = new DataSourceTextField("bidProject", "投标项目");
		bidProjectField.setLength(512);
		bidProjectField.setRequired(false);
		bidProjectField.setHidden(true);

		constructionUnitField = new DataSourceTextField("constructionUnit", "建设单位");
		constructionUnitField.setLength(512);
		constructionUnitField.setRequired(false);
		constructionUnitField.setHidden(true);

		architecturalDesignUnitsField = new DataSourceTextField("architecturalDesignUnits", "建筑设计单位");
		architecturalDesignUnitsField.setLength(512);
		architecturalDesignUnitsField.setRequired(false);
		architecturalDesignUnitsField.setHidden(true);

		rateOfBidWinningField = new DataSourceTextField("rateOfBidWinning", "百分比");
		rateOfBidWinningField.setLength(10);
		rateOfBidWinningField.setRequired(false);
		rateOfBidWinningField.setHidden(true);

		followUpDateField = new DataSourceDateTimeField("followUpDate", "跟进日期");
		followUpDateField.setRequired(false);
		followUpDateField.setHidden(true);

		equityedgeRemarkField = new DataSourceTextField("equityedgeRemark", "说明");
		equityedgeRemarkField.setLength(512);
		equityedgeRemarkField.setRequired(false);
		equityedgeRemarkField.setHidden(true);

		orderSignUpTimeField = new DataSourceDateTimeField("orderSignUpTime", "预计签约时间");
		orderSignUpTimeField.setRequired(false);
		orderSignUpTimeField.setHidden(true);

		designServiceBookField = new DataSourceTextField("designServiceBook", "设计服务书");
		designServiceBookField.setLength(512);
		designServiceBookField.setRequired(false);
		designServiceBookField.setHidden(true);

		serviceSuggestBookField = new DataSourceTextField("serviceSuggestBook", "服务建议书");
		serviceSuggestBookField.setLength(512);
		serviceSuggestBookField.setRequired(false);
		serviceSuggestBookField.setHidden(true);

		totalMoneyField = new DataSourceFloatField("totalMoney", "报价总金额");
		totalMoneyField.setLength(16);
		totalMoneyField.setDecimalPad(2);
		totalMoneyField.setFormat("##,###,###,###,##0.00");
		totalMoneyField.setRequired(false);
		totalMoneyField.setHidden(true);

		coveredAreaField = new DataSourceFloatField("coveredArea", "建筑面积");
		coveredAreaField.setLength(16);
		coveredAreaField.setDecimalPad(2);
		coveredAreaField.setFormat("##,###,###,###,##0.00");
		coveredAreaField.setRequired(false);
		coveredAreaField.setHidden(true);

		designAreaField = new DataSourceFloatField("designArea", "设计面积");
		designAreaField.setLength(16);
		designAreaField.setDecimalPad(2);
		designAreaField.setFormat("##,###,###,###,##0.00");
		designAreaField.setRequired(false);
		designAreaField.setHidden(true);

		hasFormalContractsField = new DataSourceBooleanField("hasFormalContracts", "是否有正式合同");
		hasFormalContractsField.setRequired(false);
		hasFormalContractsField.setHidden(true);

		hasOutQuotationsField = new DataSourceBooleanField("hasOutQuotations", "是否有报价单");
		hasOutQuotationsField.setRequired(false);
		hasOutQuotationsField.setHidden(true);

		specialtyField = new DataSourceTextField("specialty", "合同参与专业");
		specialtyField.setLength(128);
		specialtyField.setRequired(false);
		specialtyField.setHidden(true);

		hasSplitPriceField = new DataSourceBooleanField("hasSplitPrice", "是否有拆分价 true 有，反之");
		hasSplitPriceField.setRequired(false);
		hasSplitPriceField.setHidden(true);

		hasOrderReleaseField = new DataSourceBooleanField("hasOrderRelease", "订单下达状态");
		hasOrderReleaseField.setRequired(false);
		hasOrderReleaseField.setHidden(true);

		hasDepositField = new DataSourceBooleanField("hasDeposit", "是否收取 定金");
		hasDepositField.setRequired(false);
		hasDepositField.setHidden(true);

		hasRateOfPaymentField = new DataSourceFloatField("hasRateOfPayment", "回款率");
		hasRateOfPaymentField.setLength(16);
		hasRateOfPaymentField.setDecimalPad(2);
		hasRateOfPaymentField.setFormat("##,###,###,###,##0.00");
		hasRateOfPaymentField.setRequired(false);
		hasRateOfPaymentField.setHidden(true);

		parentIdField = new DataSourceIntegerField("parentId", "父级编码");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(true);

		serialNumberField = new DataSourceIntegerField("serialNumber", "序列号(记录第几个补充协议)");
		serialNumberField.setLength(11);
		serialNumberField.setRequired(false);
		serialNumberField.setHidden(true);

		hasFormalContractTimeField = new DataSourceDateTimeField("hasFormalContractTime", "拥有正式合同的时间");
		hasFormalContractTimeField.setRequired(false);
		hasFormalContractTimeField.setHidden(true);

		hasOutQuotationTimeField = new DataSourceDateTimeField("hasOutQuotationTime", "有报价单的时间");
		hasOutQuotationTimeField.setRequired(false);
		hasOutQuotationTimeField.setHidden(true);

		hasOrderReleaseTimeField = new DataSourceDateTimeField("hasOrderReleaseTime", "订单下达的时间");
		hasOrderReleaseTimeField.setRequired(false);
		hasOrderReleaseTimeField.setHidden(true);

		hasSplitPriceTimeField = new DataSourceDateTimeField("hasSplitPriceTime", "有拆分价的时间");
		hasSplitPriceTimeField.setRequired(false);
		hasSplitPriceTimeField.setHidden(true);

		bidTypeField = new DataSourceIntegerField("bidType", "对应于字典表128)");
		bidTypeField.setLength(11);
		bidTypeField.setRequired(false);
		bidTypeField.setHidden(true);

		bidDateField = new DataSourceDateField("bidDate", "投标日期");
		bidDateField.setRequired(false);
		bidDateField.setHidden(true);

		bidClassTypeField = new DataSourceIntegerField("bidClassType", "对应于字典表129)");
		bidClassTypeField.setLength(11);
		bidClassTypeField.setRequired(false);
		bidClassTypeField.setHidden(true);

		bidUnitNumField = new DataSourceIntegerField("bidUnitNum", "投标单位总数");
		bidUnitNumField.setLength(11);
		bidUnitNumField.setRequired(false);
		bidUnitNumField.setHidden(true);

		ourOrderField = new DataSourceTextField("ourOrder", "我方排名");
		ourOrderField.setLength(64);
		ourOrderField.setRequired(false);
		ourOrderField.setHidden(true);

		bigPayAmountField = new DataSourceFloatField("bigPayAmount", "落标补偿金");
		bigPayAmountField.setLength(18);
		bigPayAmountField.setDecimalPad(2);
		bigPayAmountField.setFormat("#,###,###,###,###,##0.00");
		bigPayAmountField.setRequired(false);
		bigPayAmountField.setHidden(true);

		bigIsAchieveAmountField = new DataSourceBooleanField("bigIsAchieveAmount", "是否收到落标补偿");
		bigIsAchieveAmountField.setRequired(false);
		bigIsAchieveAmountField.setHidden(true);

		bigAdvanceAmountField = new DataSourceFloatField("bigAdvanceAmount", "甲方补偿金额");
		bigAdvanceAmountField.setLength(18);
		bigAdvanceAmountField.setDecimalPad(2);
		bigAdvanceAmountField.setFormat("#,###,###,###,###,##0.00");
		bigAdvanceAmountField.setRequired(false);
		bigAdvanceAmountField.setHidden(true);

		clientIdField = new DataSourceIntegerField("clientId", "客户id");
		clientIdField.setLength(11);
		clientIdField.setRequired(false);
		clientIdField.setHidden(true);

		contactNameField = new DataSourceTextField("contactName", "客户联系人");
		contactNameField.setLength(32);
		contactNameField.setRequired(false);
		contactNameField.setHidden(true);

		contactPhoneField = new DataSourceTextField("contactPhone", "客户联系人电话");
		contactPhoneField.setLength(64);
		contactPhoneField.setRequired(false);
		contactPhoneField.setHidden(true);

		applyEmployeeIdField = new DataSourceIntegerField("applyEmployeeId", "报备人");
		applyEmployeeIdField.setLength(11);
		applyEmployeeIdField.setRequired(false);
		applyEmployeeIdField.setHidden(true);

		customerContactIdField = new DataSourceIntegerField("customerContactId", "联系人id");
		customerContactIdField.setLength(11);
		customerContactIdField.setRequired(false);
		customerContactIdField.setHidden(true);

		architecturalDesignUnitIdField = new DataSourceIntegerField("architecturalDesignUnitId", "建筑设计单位编码");
		architecturalDesignUnitIdField.setLength(11);
		architecturalDesignUnitIdField.setRequired(false);
		architecturalDesignUnitIdField.setHidden(true);

		architecturalDesignUnitContactIdField = new DataSourceIntegerField("architecturalDesignUnitContactId",
				"建筑设计单位联系人");
		architecturalDesignUnitContactIdField.setLength(11);
		architecturalDesignUnitContactIdField.setRequired(false);
		architecturalDesignUnitContactIdField.setHidden(true);

		regionField = new DataSourceIntegerField("region", "区域");
		regionField.setLength(11);
		regionField.setRequired(false);
		regionField.setHidden(true);

		comparisonFormField = new DataSourceIntegerField("comparisonForm", "比选形式");
		comparisonFormField.setLength(11);
		comparisonFormField.setRequired(false);
		comparisonFormField.setHidden(true);

		isOriginalField = new DataSourceBooleanField("isOriginal", "是否原创");
		isOriginalField.setRequired(false);
		isOriginalField.setHidden(true);

		isSubProjectField = new DataSourceBooleanField("isSubProject", "是否建筑院分包项目");
		isSubProjectField.setRequired(false);
		isSubProjectField.setHidden(true);

		contractStatusField = new DataSourceIntegerField("contractStatus", "合同状态");
		contractStatusField.setLength(11);
		contractStatusField.setRequired(false);
		contractStatusField.setHidden(true);

		isPubliclyBiddingField = new DataSourceBooleanField("isPubliclyBidding", "是否公开挂网招标");
		isPubliclyBiddingField.setRequired(false);
		isPubliclyBiddingField.setHidden(true);

		haveAgentsField = new DataSourceBooleanField("haveAgents", "是否有代理商");
		haveAgentsField.setRequired(false);
		haveAgentsField.setHidden(true);

		companyIdField = new DataSourceIntegerField("companyId", "公司编码（默认为JA公司编码）");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(true);

		companyNoField = new DataSourceTextField("companyNo", "公司编码（默认为JA公司编码）");
		companyNoField.setLength(64);
		companyNoField.setRequired(false);
		companyNoField.setHidden(true);

		percentField = new DataSourceFloatField("percent", "项目完成百分比");
		percentField.setLength(18);
		percentField.setDecimalPad(4);
		percentField.setFormat("##,###,###,###,##0.0000");
		percentField.setRequired(false);
		percentField.setHidden(true);

		ownerTypeIdField = new DataSourceIntegerField("ownerTypeId", "业主所属行业类型");
		ownerTypeIdField.setLength(11);
		ownerTypeIdField.setRequired(false);
		ownerTypeIdField.setHidden(true);

		estimatePriceField = new DataSourceFloatField("estimatePrice", "预估价格");
		estimatePriceField.setLength(18);
		estimatePriceField.setDecimalPad(2);
		estimatePriceField.setFormat("#,###,###,###,###,##0.00");
		estimatePriceField.setRequired(false);
		estimatePriceField.setHidden(true);

		projectPhaseField = new DataSourceIntegerField("projectPhase", "项目进行阶段(1新建 2策划 3运行 4完成 5暂停)");
		projectPhaseField.setLength(11);
		projectPhaseField.setRequired(false);
		projectPhaseField.setHidden(true);

		projectAttributeField = new DataSourceIntegerField("projectAttribute", "项目属性 1普通设计项目 2品管项目");
		projectAttributeField.setLength(11);
		projectAttributeField.setRequired(false);
		projectAttributeField.setHidden(true);

		setFields(mainProjectIdField, projectCodeField, projectNameField, projectEnglishNameField, projectStatusField,
				designStatusField, signCompanyField, projectOriginationField, projectOriginationRemarkField,
				designCooperationNameField, designCooperationEnglishNameField, designTeamField, isHighRiseBuildingField,
				infoRegisterTimeField, projectApprovalTimeField, hasContractField, projectBaseOnField, infoCodeField,
				projectModelField, designQualificationField, businessTypeField, fireResistanceRatingField,
				estimateTheDesignAreasField, projectTotalInvestmentField, actualDesignAreasField,
				totalBuildingAreasField, buildingHeightField, buildingFloorsField, decorateMoneyControlField,
				projectLevelField, provinceField, cityField, detailAddressField, projectEndTimeField, projectTypeField,
				customerNameField, customerAddressField, bidProjectField, constructionUnitField,
				architecturalDesignUnitsField, rateOfBidWinningField, followUpDateField, equityedgeRemarkField,
				orderSignUpTimeField, designServiceBookField, serviceSuggestBookField, totalMoneyField,
				coveredAreaField, designAreaField, hasFormalContractsField, hasOutQuotationsField, specialtyField,
				projectSalesTeamField, hasSplitPriceField, hasOrderReleaseField, hasDepositField, hasRateOfPaymentField,
				parentIdField, serialNumberField, hasFormalContractTimeField, hasOutQuotationTimeField,
				hasOrderReleaseTimeField, hasSplitPriceTimeField, bidTypeField, bidDateField, bidClassTypeField,
				bidUnitNumField, ourOrderField, bigPayAmountField, bigIsAchieveAmountField, bigAdvanceAmountField,
				clientIdField, contactNameField, contactPhoneField, applyEmployeeIdField, customerContactIdField,
				architecturalDesignUnitIdField, architecturalDesignUnitContactIdField, regionField, comparisonFormField,
				isOriginalField, isSubProjectField, contractStatusField, isPubliclyBiddingField, haveAgentsField,
				companyIdField, companyNoField, percentField, ownerTypeIdField, estimatePriceField, projectPhaseField,
				projectAttributeField);
	}

}
