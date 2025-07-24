package com.pomplatform.client.customer.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnLoadCompetitionUnitsData extends DBDataSource
{


	public static DSOnLoadCompetitionUnitsData instance = null;

	public static DSOnLoadCompetitionUnitsData getInstance() {
		if(instance == null) {
			instance = new DSOnLoadCompetitionUnitsData("DSOnLoadCompetitionUnitsData");
		}
		return instance;
	}

	private final DataSourceIntegerField competitionUnitIdField;
	private final DataSourceTextField plateTypeNameField;
	private final DataSourceTextField areaNameField;
	private final DataSourceTextField nameField;
	private final DataSourceTextField addressField;
	private final DataSourceTextField companyProvinceField;
	private final DataSourceTextField companyCityField;
	private final DataSourceTextField businessPlateField;
	private final DataSourceTextField professionalPlateField;
	private final DataSourceTextField webSiteField;
	private final DataSourceTextField companyStockCodeField;
	private final DataSourceIntegerField companyEmployeeNumField;
	private final DataSourceDateField companySetupField;
	private final DataSourceTextField companyNatureField;
	private final DataSourceTextField companyQualificationField;
	private final DataSourceTextField companyOrganizationalField;
	private final DataSourceTextField companyBriefField;
	private final DataSourceTextField companyParentNameField;
	private final DataSourceTextField companyParentAddressField;
	private final DataSourceTextField companyChildNameField;
	private final DataSourceTextField mainWorkCustomerField;
	private final DataSourceTextField mianAchievementField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField projectVolumeField;
	private final DataSourceDateField designDateField;
	private final DataSourceTextField designHighlightField;
	private final DataSourceTextField designFeeStandardField;
	private final DataSourceTextField coreStrengthField;
	private final DataSourceTextField weaknessesField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceTextField remarkField;

	public DSOnLoadCompetitionUnitsData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("CompetitionUnit");


		competitionUnitIdField = new DataSourceIntegerField("competitionUnitId", "主键编码");
		competitionUnitIdField.setLength(11);
		competitionUnitIdField.setPrimaryKey(true);
		competitionUnitIdField.setRequired(true);
		competitionUnitIdField.setHidden(true);

		plateTypeNameField = new DataSourceTextField("plateTypeName", "英文名称");
		plateTypeNameField.setLength(128);
		plateTypeNameField.setRequired(false);
		plateTypeNameField.setHidden(false);
		
		areaNameField = new DataSourceTextField("areaName", "区域");
		areaNameField.setLength(128);
		areaNameField.setRequired(false);
		areaNameField.setHidden(false);

		nameField = new DataSourceTextField("name", "名称");
		nameField.setLength(128);
		nameField.setRequired(false);
		nameField.setHidden(false);


		addressField = new DataSourceTextField("address", "地址");
		addressField.setLength(128);
		addressField.setRequired(false);
		addressField.setHidden(false);

		companyProvinceField = new DataSourceTextField("companyProvince", "省份");
		companyProvinceField.setLength(64);
		companyProvinceField.setRequired(false);
		companyProvinceField.setHidden(false);


		companyCityField = new DataSourceTextField("companyCity", "城市");
		companyCityField.setLength(64);
		companyCityField.setRequired(false);
		companyCityField.setHidden(false);


		businessPlateField = new DataSourceTextField("businessPlate", "业态板块");
		businessPlateField.setLength(64);
		businessPlateField.setRequired(false);
		businessPlateField.setHidden(false);
		
		professionalPlateField = new DataSourceTextField("professionalPlate", "专业板块");
		professionalPlateField.setLength(64);
		professionalPlateField.setRequired(false);
		professionalPlateField.setHidden(false);


		webSiteField = new DataSourceTextField("webSite", "网站");
		webSiteField.setLength(64);
		webSiteField.setRequired(false);
		webSiteField.setHidden(true);


		companyStockCodeField = new DataSourceTextField("companyStockCode", "股票代码");
		companyStockCodeField.setLength(64);
		companyStockCodeField.setRequired(false);
		companyStockCodeField.setHidden(true);


		companyEmployeeNumField = new DataSourceIntegerField("companyEmployeeNum", "公司人数");
		companyEmployeeNumField.setLength(11);
		companyEmployeeNumField.setRequired(false);
		companyEmployeeNumField.setHidden(true);


		companySetupField = new DataSourceDateField("companySetup", "公司成立日期");
		companySetupField.setRequired(false);
		companySetupField.setHidden(true);


		companyNatureField = new DataSourceTextField("companyNature", "企业性质");
		companyNatureField.setLength(64);
		companyNatureField.setRequired(false);
		companyNatureField.setHidden(true);


		companyQualificationField = new DataSourceTextField("companyQualification", "企业资质");
		companyQualificationField.setLength(64);
		companyQualificationField.setRequired(false);
		companyQualificationField.setHidden(true);


		companyOrganizationalField = new DataSourceTextField("companyOrganizational", "组织架构");
		companyOrganizationalField.setLength(512);
		companyOrganizationalField.setRequired(false);
		companyOrganizationalField.setHidden(true);


		companyBriefField = new DataSourceTextField("companyBrief", "公司简介");
		companyBriefField.setLength(10240);
		companyBriefField.setRequired(false);
		companyBriefField.setHidden(true);


		companyParentNameField = new DataSourceTextField("companyParentName", "客户集团公司名称");
		companyParentNameField.setLength(64);
		companyParentNameField.setRequired(false);
		companyParentNameField.setHidden(true);


		companyParentAddressField = new DataSourceTextField("companyParentAddress", "客户集团公司地址");
		companyParentAddressField.setLength(64);
		companyParentAddressField.setRequired(false);
		companyParentAddressField.setHidden(true);


		companyChildNameField = new DataSourceTextField("companyChildName", "分支机构");
		companyChildNameField.setLength(64);
		companyChildNameField.setRequired(false);
		companyChildNameField.setHidden(true);
		
		mainWorkCustomerField = new DataSourceTextField("mainWorkCustomer", "主要合作客户");
		mainWorkCustomerField.setLength(64);
		mainWorkCustomerField.setRequired(false);
		mainWorkCustomerField.setHidden(true);

		mianAchievementField = new DataSourceTextField("mianAchievement", "主要合作业绩");
		mianAchievementField.setLength(64);
		mianAchievementField.setRequired(false);
		mianAchievementField.setHidden(true);
		
		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(64);
		projectNameField.setRequired(false);
		projectNameField.setHidden(true);
		
		projectVolumeField = new DataSourceTextField("projectVolume", "项目体量");
		projectVolumeField.setLength(64);
		projectVolumeField.setRequired(false);
		projectVolumeField.setHidden(true);
		
		designDateField = new DataSourceDateField("designDate", "设计日期");
		designDateField.setRequired(false);
		designDateField.setHidden(true);
		
		designHighlightField = new DataSourceTextField("designHighlight", "设计亮点");
		designHighlightField.setLength(64);
		designHighlightField.setRequired(false);
		designHighlightField.setHidden(true);
		
		designFeeStandardField = new DataSourceTextField("designFeeStandard", "设计取费标准");
		designFeeStandardField.setLength(64);
		designFeeStandardField.setRequired(false);
		designFeeStandardField.setHidden(true);

		coreStrengthField = new DataSourceTextField("coreStrength", "核心优势");
		coreStrengthField.setLength(64);
		coreStrengthField.setRequired(false);
		coreStrengthField.setHidden(true);
		
		weaknessesField = new DataSourceTextField("weaknesses", "劣势");
		weaknessesField.setLength(64);
		weaknessesField.setRequired(false);
		weaknessesField.setHidden(true);

		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(true);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(true);


		setFields(competitionUnitIdField,plateTypeNameField,areaNameField,nameField, addressField, companyProvinceField, companyCityField, businessPlateField,professionalPlateField, webSiteField, companyStockCodeField, companyEmployeeNumField, companySetupField, companyNatureField, companyQualificationField, companyOrganizationalField, companyBriefField, companyParentNameField, companyParentAddressField, companyChildNameField
		,mainWorkCustomerField,mianAchievementField,projectNameField,projectVolumeField,designDateField,designHighlightField,designFeeStandardField
		,coreStrengthField,weaknessesField, operateEmployeeIdField, createTimeField, remarkField);
	}


}

