package com.pomplatform.client.newmainprojectinfo.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSNewMainprojectInfo extends DBDataSource
{


	public static DSNewMainprojectInfo instance = null;

	public static DSNewMainprojectInfo getInstance() {
		if(instance == null) {
			instance = new DSNewMainprojectInfo("DSNewMainprojectInfo");
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
	private final DataSourceTextField addressField;
	private final DataSourceDateField projectEndTimeField;
	private final DataSourceTextField projectSaleManField;
	private final DataSourceTextField projectSaleTeamManagerField;
	private final DataSourceTextField projectManagerField;
	private final DataSourceTextField projectLeaderField;

	public DSNewMainprojectInfo(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("NewMainprojectInfo");


		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "主项目编码");
		mainProjectIdField.setLength(11);
		mainProjectIdField.setRequired(false);
		mainProjectIdField.setHidden(false);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);
//		projectCodeField.setValueMap(KeyValueManager.getValueMap("main_projects"));
		KeyValueManager.loadValueMap("main_projects",projectCodeField);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		projectEnglishNameField = new DataSourceTextField("projectEnglishName", "项目英文名称");
		projectEnglishNameField.setLength(512);
		projectEnglishNameField.setRequired(false);
		projectEnglishNameField.setHidden(false);


		projectStatusField = new DataSourceTextField("projectStatus", "项目状态");
		projectStatusField.setLength(64);
		projectStatusField.setRequired(false);
		projectStatusField.setHidden(false);


		designStatusField = new DataSourceTextField("designStatus", "设计状态");
		designStatusField.setLength(64);
		designStatusField.setRequired(false);
		designStatusField.setHidden(false);
		designStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_29"));


		signCompanyField = new DataSourceIntegerField("signCompany", "拟签约公司");
		signCompanyField.setLength(11);
		signCompanyField.setRequired(false);
		signCompanyField.setHidden(false);
		signCompanyField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		projectOriginationField = new DataSourceTextField("projectOrigination", "项目来源渠道");
		projectOriginationField.setLength(512);
		projectOriginationField.setRequired(false);
		projectOriginationField.setHidden(false);


		projectOriginationRemarkField = new DataSourceTextField("projectOriginationRemark", "项目来源说明");
		projectOriginationRemarkField.setLength(2048);
		projectOriginationRemarkField.setRequired(false);
		projectOriginationRemarkField.setHidden(false);


		designCooperationNameField = new DataSourceTextField("designCooperationName", "设计合作单位");
		designCooperationNameField.setLength(64);
		designCooperationNameField.setRequired(false);
		designCooperationNameField.setHidden(false);


		designCooperationEnglishNameField = new DataSourceTextField("designCooperationEnglishName", "设计合作单位英文名称");
		designCooperationEnglishNameField.setLength(64);
		designCooperationEnglishNameField.setRequired(false);
		designCooperationEnglishNameField.setHidden(false);


		projectSalesTeamField = new DataSourceTextField("projectSalesTeam", "项目营销团队");
		projectSalesTeamField.setLength(32);
		projectSalesTeamField.setRequired(false);
		projectSalesTeamField.setHidden(false);


		designTeamField = new DataSourceIntegerField("designTeam", "主办设计团队");
		designTeamField.setLength(11);
		designTeamField.setRequired(false);
		designTeamField.setHidden(false);
		designTeamField.setValueMap(KeyValueManager.getValueMap("departments"));


		isHighRiseBuildingField = new DataSourceBooleanField("isHighRiseBuilding", "是否高层建筑");
		isHighRiseBuildingField.setRequired(false);
		isHighRiseBuildingField.setHidden(false);


		infoRegisterTimeField = new DataSourceDateTimeField("infoRegisterTime", "信息登记时间");
		infoRegisterTimeField.setRequired(false);
		infoRegisterTimeField.setHidden(false);


		projectApprovalTimeField = new DataSourceDateTimeField("projectApprovalTime", "正式立项时间");
		projectApprovalTimeField.setRequired(false);
		projectApprovalTimeField.setHidden(true);


		hasContractField = new DataSourceBooleanField("hasContract", "是否有合同");
		hasContractField.setRequired(false);
		hasContractField.setHidden(true);


		projectBaseOnField = new DataSourceIntegerField("projectBaseOn", "立项依据");
		projectBaseOnField.setLength(11);
		projectBaseOnField.setRequired(false);
		projectBaseOnField.setHidden(true);
		projectBaseOnField.setValueMap(KeyValueManager.getValueMap("system_dictionary_28"));


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
		projectLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));


		addressField = new DataSourceTextField("address", "详细地址");
		addressField.setLength(512);
		addressField.setRequired(false);
		addressField.setHidden(true);


		projectEndTimeField = new DataSourceDateField("projectEndTime", "项目完成时间");
		projectEndTimeField.setRequired(false);
		projectEndTimeField.setHidden(true);


		projectSaleManField = new DataSourceTextField("projectSaleMan", "项目营销专员");
		projectSaleManField.setLength(40);
		projectSaleManField.setRequired(true);
		projectSaleManField.setHidden(true);


		projectSaleTeamManagerField = new DataSourceTextField("projectSaleTeamManager", "运营董事");
		projectSaleTeamManagerField.setLength(40);
		projectSaleTeamManagerField.setRequired(true);
		projectSaleTeamManagerField.setHidden(true);


		projectManagerField = new DataSourceTextField("projectManager", "项目经理");
		projectManagerField.setLength(40);
		projectManagerField.setRequired(true);
		projectManagerField.setHidden(true);
//		projectManagerField.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees", projectManagerField);


		projectLeaderField = new DataSourceTextField("projectLeader", "项目主管领导");
		projectLeaderField.setLength(40);
		projectLeaderField.setRequired(true);
		projectLeaderField.setHidden(true);
		projectLeaderField.setValueMap(KeyValueManager.getValueMap("employees"));


		setFields(mainProjectIdField, projectCodeField, projectNameField, projectEnglishNameField, projectStatusField, designStatusField, signCompanyField, projectOriginationField, projectOriginationRemarkField, designCooperationNameField, designCooperationEnglishNameField, projectSalesTeamField, designTeamField, isHighRiseBuildingField, infoRegisterTimeField, projectApprovalTimeField, hasContractField, projectBaseOnField, infoCodeField, projectModelField, designQualificationField, businessTypeField, fireResistanceRatingField, estimateTheDesignAreasField, projectTotalInvestmentField, actualDesignAreasField, totalBuildingAreasField, buildingHeightField, buildingFloorsField, decorateMoneyControlField, projectLevelField, addressField, projectEndTimeField, projectSaleManField, projectSaleTeamManagerField, projectManagerField, projectLeaderField);
	}


}

