package com.pomplatform.client.ja.ht.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMainProject extends DBDataSource
{


	public static DSMainProject instance = null;

	public static DSMainProject getInstance() {
		if(instance == null) {
			instance = new DSMainProject("DSMainProject");
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
	private final DataSourceTextField projectSalesTeamField;
	private final DataSourceIntegerField designTeamField;
	private final DataSourceBooleanField isHighRiseBuildingField;
	private final DataSourceDateTimeField infoRegisterTimeField;
	private final DataSourceDateTimeField projectApprovalTimeField;
	private final DataSourceBooleanField hasContractField;
	private final DataSourceBooleanField hasFormalContractsField;
	private final DataSourceBooleanField hasOutQuotationsField;
	private final DataSourceBooleanField hasSplitPriceField;
	private final DataSourceIntegerField projectBaseOnField;
	private final DataSourceIntegerField bidTypeField;
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

	private final DataSourceBooleanField hasOrderReleaseField;
	private final DataSourceBooleanField hasDepositField;
	private final DataSourceFloatField hasRateOfPaymentField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceIntegerField clientIdField;

	private final DataSourceDateTimeField hasFormalContractTimeField;
	private final DataSourceDateTimeField hasOutQuotationTimeField;
	private final DataSourceDateTimeField hasOrderReleaseTimeField;
	private final DataSourceDateTimeField hasSplitPriceTimeField;
	private final DataSourceTextField outsourceField;
	private final DataSourceTextField secretaryField;
	private final DataSourceTextField leaderField;
	private final DataSourceTextField chargePersonField;
	private final DataSourceTextField managerField;

	public DSMainProject(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("MainProject");


		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "主键编码");
		mainProjectIdField.setLength(11);
		mainProjectIdField.setPrimaryKey(true);
		mainProjectIdField.setRequired(true);
		mainProjectIdField.setHidden(true);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
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
		designTeamField.setHidden(false);
		designTeamField.setValueMap(KeyValueManager.getValueMap("plate_records"));

		isHighRiseBuildingField = new DataSourceBooleanField("isHighRiseBuilding", "是否高层建筑");
		isHighRiseBuildingField.setRequired(false);
		isHighRiseBuildingField.setHidden(true);


		infoRegisterTimeField = new DataSourceDateTimeField("infoRegisterTime", "信息登记时间");
		infoRegisterTimeField.setRequired(false);
		infoRegisterTimeField.setHidden(true);


		projectApprovalTimeField = new DataSourceDateTimeField("projectApprovalTime", "正式立项时间");
		projectApprovalTimeField.setRequired(false);
		projectApprovalTimeField.setHidden(false);


		hasContractField = new DataSourceBooleanField("hasContract", "是否有主订单");
		hasContractField.setRequired(false);
		hasContractField.setHidden(true);

		hasFormalContractsField=new DataSourceBooleanField("hasFormalContracts", "合同(合约部)");
		hasFormalContractsField.setRequired(false);
		hasFormalContractsField.setHidden(false);

		hasOutQuotationsField=new DataSourceBooleanField("hasOutQuotations", "报价单(商务部)");
		hasOutQuotationsField.setRequired(false);
		hasOutQuotationsField.setHidden(false);

		projectBaseOnField = new DataSourceIntegerField("projectBaseOn", "立项依据");
		projectBaseOnField.setLength(11);
		projectBaseOnField.setRequired(false);
		projectBaseOnField.setHidden(false);
		projectBaseOnField.setValueMap(KeyValueManager.getValueMap("system_dictionary_28"));

		bidTypeField = new DataSourceIntegerField("bidType", "投标结果");
		bidTypeField.setLength(11);
		bidTypeField.setRequired(false);
		bidTypeField.setHidden(false);
		bidTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_128"));

		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(32);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(false);


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
		businessTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));


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
		customerNameField.setHidden(false);
		customerNameField.setValueMap(KeyValueManager.getValueMap("customers_name"));


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

		parentIdField = new DataSourceIntegerField("parentId", "父级ID");
		parentIdField.setLength(64);
		parentIdField.setRequired(false);
		parentIdField.setHidden(true);

		hasSplitPriceField=new DataSourceBooleanField("hasSplitPrice", "拆分价(合约部)");
		hasSplitPriceField.setHidden(true);

		hasOrderReleaseField=new DataSourceBooleanField("hasOrderRelease", "订单下达(运营中心)");
		hasDepositField=new DataSourceBooleanField("hasDeposit", "定金(商务部)");
		hasRateOfPaymentField = new DataSourceFloatField("hasRateOfPayment", "回款率(财务部)");
		hasRateOfPaymentField.setLength(16);
		hasRateOfPaymentField.setDecimalPad(2);
		hasRateOfPaymentField.setFormat("##,###,###,###,##0.00%");

		hasFormalContractTimeField = new DataSourceDateTimeField("hasFormalContractTime", "合同日期");
		hasFormalContractTimeField.setRequired(false);
		hasFormalContractTimeField.setHidden(false);

		hasOutQuotationTimeField = new DataSourceDateTimeField("hasOutQuotationTime", "报价单日期");
		hasOutQuotationTimeField.setRequired(false);
		hasOutQuotationTimeField.setHidden(false);

		hasOrderReleaseTimeField = new DataSourceDateTimeField("hasOrderReleaseTime", "订单下达日期");
		hasOrderReleaseTimeField.setRequired(false);
		hasOrderReleaseTimeField.setHidden(false);

		hasSplitPriceTimeField = new DataSourceDateTimeField("hasSplitPriceTime", "拆分价日期");
		hasSplitPriceTimeField.setRequired(false);
		hasSplitPriceTimeField.setHidden(true);

		outsourceField = new DataSourceTextField("outsource", "是否有外包");
		outsourceField.setLength(11);
		outsourceField.setRequired(true);
		outsourceField.setHidden(false);


		clientIdField = new DataSourceIntegerField("clientId", "父级ID");
		clientIdField.setLength(64);
		clientIdField.setRequired(false);
		clientIdField.setHidden(true);

		secretaryField = new DataSourceTextField("secretary", "项目秘书");
		secretaryField.setLength(128);
		secretaryField.setRequired(true);
		secretaryField.setHidden(false);
//		secretaryField.setValueMap(KeyValueManager.getValueMap("employees"));


		leaderField = new DataSourceTextField("leader", "项目主管领导");
		leaderField.setLength(128);
		leaderField.setRequired(true);
		leaderField.setHidden(false);
//		leaderField.setValueMap(KeyValueManager.getValueMap("employees"));


		chargePersonField = new DataSourceTextField("chargePerson", "项目负责人");
		chargePersonField.setLength(128);
		chargePersonField.setRequired(true);
		chargePersonField.setHidden(false);

		managerField = new DataSourceTextField("manager", "项目经理");
		managerField.setLength(128);
		managerField.setRequired(true);
		managerField.setHidden(false);
//		managerField.setValueMap(KeyValueManager.getValueMap("employees"));

		setFields(mainProjectIdField, infoCodeField,projectCodeField,projectNameField,businessTypeField,
				projectEnglishNameField, projectStatusField, designStatusField,
				signCompanyField, projectOriginationField, projectOriginationRemarkField,
				designCooperationNameField, designCooperationEnglishNameField, projectSalesTeamField,
				designTeamField, isHighRiseBuildingField, projectApprovalTimeField,
				hasOutQuotationsField,hasOutQuotationTimeField,hasSplitPriceField,hasSplitPriceTimeField,
				hasContractField,hasOrderReleaseField,hasOrderReleaseTimeField,hasFormalContractsField,
				hasFormalContractTimeField,hasDepositField,hasRateOfPaymentField,infoRegisterTimeField,

				projectBaseOnField, bidTypeField,projectModelField, designQualificationField, businessTypeField,
				fireResistanceRatingField, estimateTheDesignAreasField, projectTotalInvestmentField,
				actualDesignAreasField, totalBuildingAreasField, buildingHeightField, buildingFloorsField,
				decorateMoneyControlField, projectLevelField, provinceField, cityField, detailAddressField,
				projectEndTimeField, projectTypeField, customerNameField, customerAddressField, bidProjectField,
				constructionUnitField, architecturalDesignUnitsField, rateOfBidWinningField, followUpDateField,
				equityedgeRemarkField, orderSignUpTimeField, designServiceBookField, serviceSuggestBookField,
				totalMoneyField, coveredAreaField, designAreaField,parentIdField,outsourceField,clientIdField
				,secretaryField,leaderField,chargePersonField,managerField);
	}
}














