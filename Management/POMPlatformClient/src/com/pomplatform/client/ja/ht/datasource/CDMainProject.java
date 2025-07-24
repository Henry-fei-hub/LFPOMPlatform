package com.pomplatform.client.ja.ht.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMainProject extends DataSource
{


	public static CDMainProject instance = null;

	public static CDMainProject getInstance() {
		if(instance == null) {
			instance = new CDMainProject("CDMainProject");
		}
		return instance;
	}

	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceBooleanField hasContractField;
	private final DataSourceIntegerField projectBaseOnField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceIntegerField designTeamField;
	private final DataSourceIntegerField leaderField;
	private final DataSourceIntegerField secretaryField;
	private final DataSourceIntegerField chargePersonField;

	public CDMainProject(String dataSourceID) {

		setID(dataSourceID);
		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(64);
		projectCodeField.setHidden(false);
		projectCodeField.setValueMap(KeyValueManager.getValueMap(""));

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		hasContractField = new DataSourceBooleanField("hasContract", "是否有主合同");
		hasContractField.setRequired(false);
		hasContractField.setHidden(false);

		projectBaseOnField = new DataSourceIntegerField("projectBaseOn", "立项依据");
		projectBaseOnField.setRequired(false);
		projectBaseOnField.setLength(11);
		projectBaseOnField.setHidden(false);

		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setRequired(false);
		infoCodeField.setLength(32);
		infoCodeField.setHidden(false);

		designTeamField = new DataSourceIntegerField("designTeam", "主办设计团队");
		designTeamField.setRequired(false);
		designTeamField.setLength(11);
		designTeamField.setHidden(false);

		leaderField = new DataSourceIntegerField("leader", "项目主管领导");
		leaderField.setRequired(false);
		leaderField.setLength(11);
		leaderField.setHidden(false);
		leaderField.setValueMap(KeyValueManager.getValueMap(""));

		secretaryField = new DataSourceIntegerField("secretary", "项目秘书");
		secretaryField.setRequired(false);
		secretaryField.setLength(11);
		secretaryField.setHidden(false);
		secretaryField.setValueMap(KeyValueManager.getValueMap(""));

		chargePersonField = new DataSourceIntegerField("chargePerson", "项目负责人");
		chargePersonField.setRequired(false);
		chargePersonField.setLength(11);
		chargePersonField.setHidden(false);
		chargePersonField.setValueMap(KeyValueManager.getValueMap(""));

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


		setFields(projectCodeField, projectNameField, hasContractField, projectBaseOnField, infoCodeField, designTeamField, leaderField, secretaryField, chargePersonField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

