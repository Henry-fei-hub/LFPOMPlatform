package com.pomplatform.client.preprojects.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSCloseProjectApply extends DBDataSource
{


	public static DSCloseProjectApply instance = null;

	public static DSCloseProjectApply getInstance() {
		if(instance == null) {
			instance = new DSCloseProjectApply("DSCloseProjectApply");
		}
		return instance;
	}

	private final DataSourceIntegerField preProjectIdField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceIntegerField clientIdField;
	private final DataSourceTextField customerNameField;
	private final DataSourceTextField customerAddressField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField provinceField;
	private final DataSourceTextField cityField;
	private final DataSourceTextField detailAddressField;
	private final DataSourceTextField projectTypeField;
	private final DataSourceFloatField totalBuildingAreasField;
	private final DataSourceTextField projectOriginationField;
	private final DataSourceTextField projectOriginationRemarkField;
	private final DataSourceIntegerField customerContactIdField;
	private final DataSourceTextField contactNameField;
	private final DataSourceTextField contactPhoneField;
	private final DataSourceTextField designStatusField;
	private final DataSourceTextField projectSalesTeamField;
	private final DataSourceIntegerField designTeamField;
	private final DataSourceIntegerField projectLevelField;
	private final DataSourceIntegerField signCompanyField;
	private final DataSourceTextField designQualificationField;
	private final DataSourceIntegerField projectBaseOnField;
	private final DataSourceDateTimeField projectApprovalTimeField;
	private final DataSourceBooleanField isHighRiseBuildingField;
	private final DataSourceTextField designCooperationNameField;
	private final DataSourceTextField architecturalDesignUnitsField;
	private final DataSourceFloatField projectTotalInvestmentField;
	private final DataSourceTextField fireResistanceRatingField;
	private final DataSourceFloatField estimateTheDesignAreasField;
	private final DataSourceFloatField actualDesignAreasField;
	private final DataSourceFloatField buildingHeightField;
	private final DataSourceFloatField buildingFloorsField;
	private final DataSourceFloatField decorateMoneyControlField;
	private final DataSourceTextField specialtyField;
	private final DataSourceTextField businessTypeField;
	private final DataSourceBooleanField hasContractField;
	private final DataSourceIntegerField applyEmployeeIdField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField infoRegisterTimeField;
	private final DataSourceTextField projectStatusField;
	private final DataSourceField detailMainProjectBusinessType;
	private final DataSourceField detailMainProjectSpecialty;
	private final DataSourceField detailMainProjectCompetitionUnit;

	public DSCloseProjectApply(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("CloseProjectApply");


		preProjectIdField = new DataSourceIntegerField("preProjectId", "主键编码");
		preProjectIdField.setLength(11);
		preProjectIdField.setPrimaryKey(true);
		preProjectIdField.setRequired(true);
		preProjectIdField.setHidden(false);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(32);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(32);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(false);


		clientIdField = new DataSourceIntegerField("clientId", "开发商id");
		clientIdField.setLength(11);
		clientIdField.setRequired(false);
		clientIdField.setHidden(false);


		customerNameField = new DataSourceTextField("customerName", "开发商名称");
		customerNameField.setLength(512);
		customerNameField.setRequired(false);
		customerNameField.setHidden(false);


		customerAddressField = new DataSourceTextField("customerAddress", "开发商地址");
		customerAddressField.setLength(512);
		customerAddressField.setRequired(false);
		customerAddressField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		provinceField = new DataSourceTextField("province", "项目地址（省）");
		provinceField.setLength(32);
		provinceField.setRequired(false);
		provinceField.setHidden(false);


		cityField = new DataSourceTextField("city", "项目地址（市）");
		cityField.setLength(32);
		cityField.setRequired(false);
		cityField.setHidden(false);


		detailAddressField = new DataSourceTextField("detailAddress", "详细地址");
		detailAddressField.setLength(512);
		detailAddressField.setRequired(false);
		detailAddressField.setHidden(false);


		projectTypeField = new DataSourceTextField("projectType", "项目类别");
		projectTypeField.setLength(128);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(false);
		projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));


		totalBuildingAreasField = new DataSourceFloatField("totalBuildingAreas", "项目面积");
		totalBuildingAreasField.setLength(18);
		totalBuildingAreasField.setDecimalPad(2);
		totalBuildingAreasField.setFormat("#,###,###,###,###,##0.00");
		totalBuildingAreasField.setRequired(false);
		totalBuildingAreasField.setHidden(false);


		projectOriginationField = new DataSourceTextField("projectOrigination", "项目来源渠道");
		projectOriginationField.setLength(512);
		projectOriginationField.setRequired(false);
		projectOriginationField.setHidden(false);


		projectOriginationRemarkField = new DataSourceTextField("projectOriginationRemark", "项目来源说明");
		projectOriginationRemarkField.setLength(2048);
		projectOriginationRemarkField.setRequired(false);
		projectOriginationRemarkField.setHidden(false);


		customerContactIdField = new DataSourceIntegerField("customerContactId", "联系人id");
		customerContactIdField.setLength(11);
		customerContactIdField.setRequired(false);
		customerContactIdField.setHidden(false);


		contactNameField = new DataSourceTextField("contactName", "联系人");
		contactNameField.setLength(64);
		contactNameField.setRequired(false);
		contactNameField.setHidden(true);


		contactPhoneField = new DataSourceTextField("contactPhone", "联系电话");
		contactPhoneField.setLength(128);
		contactPhoneField.setRequired(false);
		contactPhoneField.setHidden(true);


		designStatusField = new DataSourceTextField("designStatus", "设计状态system_dictionary_155");
		designStatusField.setLength(128);
		designStatusField.setRequired(false);
		designStatusField.setHidden(true);


		projectSalesTeamField = new DataSourceTextField("projectSalesTeam", "项目营销团队plate_str");
		projectSalesTeamField.setLength(64);
		projectSalesTeamField.setRequired(false);
		projectSalesTeamField.setHidden(true);


		designTeamField = new DataSourceIntegerField("designTeam", "主办设计团队plate_records");
		designTeamField.setLength(11);
		designTeamField.setRequired(false);
		designTeamField.setHidden(true);


		projectLevelField = new DataSourceIntegerField("projectLevel", "项目等级system_dictionary_2");
		projectLevelField.setLength(11);
		projectLevelField.setRequired(false);
		projectLevelField.setHidden(true);
		projectLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));


		signCompanyField = new DataSourceIntegerField("signCompany", "拟签约公司company_records");
		signCompanyField.setLength(11);
		signCompanyField.setRequired(false);
		signCompanyField.setHidden(true);
		signCompanyField.setValueMap(KeyValueManager.getValueMap(""));


		designQualificationField = new DataSourceTextField("designQualification", "设计资质章system_dictionary_157");
		designQualificationField.setLength(128);
		designQualificationField.setRequired(false);
		designQualificationField.setHidden(true);


		projectBaseOnField = new DataSourceIntegerField("projectBaseOn", "立项依据system_dictionary_28");
		projectBaseOnField.setLength(11);
		projectBaseOnField.setRequired(false);
		projectBaseOnField.setHidden(true);
		projectBaseOnField.setValueMap(KeyValueManager.getValueMap("system_dictionary_28"));


		projectApprovalTimeField = new DataSourceDateTimeField("projectApprovalTime", "立项时间");
		projectApprovalTimeField.setRequired(false);
		projectApprovalTimeField.setHidden(true);


		isHighRiseBuildingField = new DataSourceBooleanField("isHighRiseBuilding", "是否高层建筑");
		isHighRiseBuildingField.setRequired(false);
		isHighRiseBuildingField.setHidden(true);


		designCooperationNameField = new DataSourceTextField("designCooperationName", "设计合作单位");
		designCooperationNameField.setLength(512);
		designCooperationNameField.setRequired(false);
		designCooperationNameField.setHidden(true);


		architecturalDesignUnitsField = new DataSourceTextField("architecturalDesignUnits", "建筑设计单位");
		architecturalDesignUnitsField.setLength(512);
		architecturalDesignUnitsField.setRequired(false);
		architecturalDesignUnitsField.setHidden(true);


		projectTotalInvestmentField = new DataSourceFloatField("projectTotalInvestment", "项目总投资额");
		projectTotalInvestmentField.setLength(18);
		projectTotalInvestmentField.setDecimalPad(2);
		projectTotalInvestmentField.setFormat("#,###,###,###,###,##0.00");
		projectTotalInvestmentField.setRequired(false);
		projectTotalInvestmentField.setHidden(true);


		fireResistanceRatingField = new DataSourceTextField("fireResistanceRating", "耐火等级");
		fireResistanceRatingField.setLength(64);
		fireResistanceRatingField.setRequired(false);
		fireResistanceRatingField.setHidden(true);


		estimateTheDesignAreasField = new DataSourceFloatField("estimateTheDesignAreas", "计容建筑面积(㎡)");
		estimateTheDesignAreasField.setLength(18);
		estimateTheDesignAreasField.setDecimalPad(2);
		estimateTheDesignAreasField.setFormat("#,###,###,###,###,##0.00");
		estimateTheDesignAreasField.setRequired(false);
		estimateTheDesignAreasField.setHidden(true);


		actualDesignAreasField = new DataSourceFloatField("actualDesignAreas", "实际设计面积");
		actualDesignAreasField.setLength(18);
		actualDesignAreasField.setDecimalPad(2);
		actualDesignAreasField.setFormat("#,###,###,###,###,##0.00");
		actualDesignAreasField.setRequired(false);
		actualDesignAreasField.setHidden(true);


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


		decorateMoneyControlField = new DataSourceFloatField("decorateMoneyControl", "装修造价控制");
		decorateMoneyControlField.setLength(18);
		decorateMoneyControlField.setDecimalPad(2);
		decorateMoneyControlField.setFormat("#,###,###,###,###,##0.00");
		decorateMoneyControlField.setRequired(false);
		decorateMoneyControlField.setHidden(true);


		specialtyField = new DataSourceTextField("specialty", "合同参与专业");
		specialtyField.setLength(512);
		specialtyField.setRequired(false);
		specialtyField.setHidden(true);


		businessTypeField = new DataSourceTextField("businessType", "业务类别");
		businessTypeField.setLength(512);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(true);
		businessTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));


		hasContractField = new DataSourceBooleanField("hasContract", "是否有合同");
		hasContractField.setRequired(false);
		hasContractField.setHidden(true);


		applyEmployeeIdField = new DataSourceIntegerField("applyEmployeeId", "报备人");
		applyEmployeeIdField.setLength(11);
		applyEmployeeIdField.setRequired(false);
		applyEmployeeIdField.setHidden(true);


		createTimeField = new DataSourceDateTimeField("createTime", "报备时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		infoRegisterTimeField = new DataSourceDateTimeField("infoRegisterTime", "修改时间");
		infoRegisterTimeField.setRequired(false);
		infoRegisterTimeField.setHidden(true);


		projectStatusField = new DataSourceTextField("projectStatus", "项目状态system_dictionary_154(1前期跟踪，2已立项，3关闭)");
		projectStatusField.setLength(64);
		projectStatusField.setRequired(false);
		projectStatusField.setHidden(true);

		detailMainProjectBusinessType = new DataSourceField("detailMainProjectBusinessType", FieldType.ANY);
		detailMainProjectBusinessType.setChildrenProperty(true);
		detailMainProjectBusinessType.setChildTagName("MainProjectBusinessType");
		detailMainProjectBusinessType.setRequired(false);
		detailMainProjectBusinessType.setHidden(true);
		detailMainProjectSpecialty = new DataSourceField("detailMainProjectSpecialty", FieldType.ANY);
		detailMainProjectSpecialty.setChildrenProperty(true);
		detailMainProjectSpecialty.setChildTagName("MainProjectSpecialty");
		detailMainProjectSpecialty.setRequired(false);
		detailMainProjectSpecialty.setHidden(true);
		detailMainProjectCompetitionUnit = new DataSourceField("detailMainProjectCompetitionUnit", FieldType.ANY);
		detailMainProjectCompetitionUnit.setChildrenProperty(true);
		detailMainProjectCompetitionUnit.setChildTagName("MainProjectCompetitionUnit");
		detailMainProjectCompetitionUnit.setRequired(false);
		detailMainProjectCompetitionUnit.setHidden(true);

		setFields(preProjectIdField, projectCodeField, infoCodeField, clientIdField, customerNameField, customerAddressField, projectNameField, provinceField, cityField, detailAddressField, projectTypeField, totalBuildingAreasField, projectOriginationField, projectOriginationRemarkField, customerContactIdField, contactNameField, contactPhoneField, designStatusField, projectSalesTeamField, designTeamField, projectLevelField, signCompanyField, designQualificationField, projectBaseOnField, projectApprovalTimeField, isHighRiseBuildingField, designCooperationNameField, architecturalDesignUnitsField, projectTotalInvestmentField, fireResistanceRatingField, estimateTheDesignAreasField, actualDesignAreasField, buildingHeightField, buildingFloorsField, decorateMoneyControlField, specialtyField, businessTypeField, hasContractField, applyEmployeeIdField, createTimeField, infoRegisterTimeField, projectStatusField, detailMainProjectBusinessType, detailMainProjectSpecialty, detailMainProjectCompetitionUnit);
	}


}

