package com.pomplatform.client.preprojects.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDprojectPreInfomations extends DataSource
{


	public static CDprojectPreInfomations instance = null;

	public static CDprojectPreInfomations getInstance() {
		if(instance == null) {
			instance = new CDprojectPreInfomations("CDprojectPreInfomations");
		}
		return instance;
	}

	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField customerNameField;
	private final DataSourceTextField businessTypeField;
	private final DataSourceTextField detailAddressField;
	private final DataSourceIntegerField projectLevelField;
	private final DataSourceFloatField contractAmountField;
	private final DataSourceTextField projectStatusField;
	private final DataSourceTextField projectSalesTeamField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField projectBaseOnField;
	private final DataSourceTextField projectOriginationField;
	private final DataSourceTextField contactNameField;
	private final DataSourceTextField projectMissionerField;
	private final DataSourceFloatField estimateTheDesignAreasField;
	private final DataSourceFloatField actualDesignAreasField;
	private final DataSourceFloatField projectTotalInvestmentField;
	private final DataSourceFloatField decorateMoneyControlField;
	private final DataSourceIntegerField designTeamField;
	private final DataSourceIntegerField projectLeaderField;
	private final DataSourceIntegerField projectManagerField;
	private final DataSourceIntegerField contractStatusField;
	private final DataSourceTextField designStatusField;
	private final DataSourceTextField provinceField;
	private final DataSourceTextField cityField;
	private final DataSourceTextField designCooperationNameField;
	private final DataSourceTextField architecturalDesignUnitsField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField applyEmployeeIdField;

	public CDprojectPreInfomations(String dataSourceID) {

		setID(dataSourceID);
		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(32);
		projectCodeField.setHidden(false);

		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setRequired(false);
		infoCodeField.setLength(32);
		infoCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		customerNameField = new DataSourceTextField("customerName", "开发商名称");
		customerNameField.setRequired(false);
		customerNameField.setLength(512);
		customerNameField.setHidden(false);

		businessTypeField = new DataSourceTextField("businessType", "业务类别");
		businessTypeField.setRequired(false);
		businessTypeField.setLength(512);
		businessTypeField.setHidden(false);

		detailAddressField = new DataSourceTextField("detailAddress", "详细地址");
		detailAddressField.setRequired(false);
		detailAddressField.setLength(512);
		detailAddressField.setHidden(false);

		projectLevelField = new DataSourceIntegerField("projectLevel", "项目等级system_dictionary_2");
		projectLevelField.setRequired(false);
		projectLevelField.setLength(11);
		projectLevelField.setHidden(false);

		contractAmountField = new DataSourceFloatField("contractAmount", "预估合同金额");
		contractAmountField.setRequired(true);
		contractAmountField.setLength(64);
		contractAmountField.setHidden(false);

		projectStatusField = new DataSourceTextField("projectStatus", "项目状态system_dictionary_154");
		projectStatusField.setRequired(false);
		projectStatusField.setLength(64);
		projectStatusField.setHidden(false);

		projectSalesTeamField = new DataSourceTextField("projectSalesTeam", "项目营销团队plate_str");
		projectSalesTeamField.setRequired(false);
		projectSalesTeamField.setLength(64);
		projectSalesTeamField.setHidden(false);

		processStatusField = new DataSourceIntegerField("processStatus", "报备流程状态");
		processStatusField.setRequired(true);
		processStatusField.setLength(11);
		processStatusField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "立项/关闭的流程状态(1立项进行中，2已立项，5立项失败，4关闭进行中，5已关闭，6关闭失败)");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

		projectBaseOnField = new DataSourceIntegerField("projectBaseOn", "立项依据system_dictionary_28");
		projectBaseOnField.setRequired(false);
		projectBaseOnField.setLength(11);
		projectBaseOnField.setHidden(false);

		projectOriginationField = new DataSourceTextField("projectOrigination", "项目来源渠道");
		projectOriginationField.setRequired(false);
		projectOriginationField.setLength(512);
		projectOriginationField.setHidden(false);

		contactNameField = new DataSourceTextField("contactName", "联系人");
		contactNameField.setRequired(false);
		contactNameField.setLength(64);
		contactNameField.setHidden(false);

		projectMissionerField = new DataSourceTextField("projectMissioner", "项目营销专员");
		projectMissionerField.setRequired(true);
		projectMissionerField.setLength(0);
		projectMissionerField.setHidden(false);

		estimateTheDesignAreasField = new DataSourceFloatField("estimateTheDesignAreas", "计容建筑面积(㎡)");
		estimateTheDesignAreasField.setRequired(true);
		estimateTheDesignAreasField.setLength(18);
		estimateTheDesignAreasField.setHidden(false);

		actualDesignAreasField = new DataSourceFloatField("actualDesignAreas", "实际设计面积");
		actualDesignAreasField.setRequired(true);
		actualDesignAreasField.setLength(18);
		actualDesignAreasField.setHidden(false);

		projectTotalInvestmentField = new DataSourceFloatField("projectTotalInvestment", "项目总投资额");
		projectTotalInvestmentField.setRequired(true);
		projectTotalInvestmentField.setLength(18);
		projectTotalInvestmentField.setHidden(false);

		decorateMoneyControlField = new DataSourceFloatField("decorateMoneyControl", "装修造价控制");
		decorateMoneyControlField.setRequired(true);
		decorateMoneyControlField.setLength(18);
		decorateMoneyControlField.setHidden(false);

		designTeamField = new DataSourceIntegerField("designTeam", "主办设计团队plate_records");
		designTeamField.setRequired(false);
		designTeamField.setLength(11);
		designTeamField.setHidden(false);

		projectLeaderField = new DataSourceIntegerField("projectLeader", "项目主管领导");
		projectLeaderField.setRequired(true);
		projectLeaderField.setLength(64);
		projectLeaderField.setHidden(false);

		projectManagerField = new DataSourceIntegerField("projectManager", "项目经理");
		projectManagerField.setRequired(true);
		projectManagerField.setLength(64);
		projectManagerField.setHidden(false);

		contractStatusField = new DataSourceIntegerField("contractStatus", "合同状态");
		contractStatusField.setRequired(false);
		contractStatusField.setLength(11);
		contractStatusField.setHidden(false);

		designStatusField = new DataSourceTextField("designStatus", "设计状态system_dictionary_155");
		designStatusField.setRequired(false);
		designStatusField.setLength(128);
		designStatusField.setHidden(false);

		provinceField = new DataSourceTextField("province", "项目地址（省）");
		provinceField.setRequired(false);
		provinceField.setLength(32);
		provinceField.setHidden(false);

		cityField = new DataSourceTextField("city", "项目地址（市）");
		cityField.setRequired(false);
		cityField.setLength(32);
		cityField.setHidden(false);

		designCooperationNameField = new DataSourceTextField("designCooperationName", "设计合作单位");
		designCooperationNameField.setRequired(false);
		designCooperationNameField.setLength(512);
		designCooperationNameField.setHidden(false);

		architecturalDesignUnitsField = new DataSourceTextField("architecturalDesignUnits", "建筑设计单位");
		architecturalDesignUnitsField.setRequired(false);
		architecturalDesignUnitsField.setLength(512);
		architecturalDesignUnitsField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "员工ID");
		employeeIdField.setRequired(true);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		applyEmployeeIdField = new DataSourceIntegerField("applyEmployeeId", "报备人");
		applyEmployeeIdField.setRequired(false);
		applyEmployeeIdField.setLength(11);
		applyEmployeeIdField.setHidden(false);

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


		setFields(departmentIdField, projectCodeField, infoCodeField, projectNameField, customerNameField, businessTypeField, detailAddressField, projectLevelField, contractAmountField, projectStatusField, projectSalesTeamField, processStatusField, statusField, projectBaseOnField, projectOriginationField, contactNameField, projectMissionerField, estimateTheDesignAreasField, actualDesignAreasField, projectTotalInvestmentField, decorateMoneyControlField, designTeamField, projectLeaderField, projectManagerField, contractStatusField, designStatusField, provinceField, cityField, designCooperationNameField, architecturalDesignUnitsField, employeeNameField, employeeIdField, applyEmployeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}
