package com.pomplatform.client.projecttransitions.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadProjectTransitionRecord extends DataSource
{


	public static CDOnLoadProjectTransitionRecord instance = null;

	public static CDOnLoadProjectTransitionRecord getInstance() {
		if(instance == null) {
			instance = new CDOnLoadProjectTransitionRecord("CDOnLoadProjectTransitionRecord");
		}
		return instance;
	}

	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField initiateDesignField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceIntegerField statusField;

	public CDOnLoadProjectTransitionRecord(String dataSourceID) {

		setID(dataSourceID);
		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(64);
		projectCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		initiateDesignField = new DataSourceIntegerField("initiateDesign", "方案主创");
		initiateDesignField.setRequired(false);
		initiateDesignField.setLength(11);
		initiateDesignField.setHidden(false);

		operatorField = new DataSourceIntegerField("operator", "操作人id");
		operatorField.setRequired(false);
		operatorField.setLength(11);
		operatorField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "状态   0 操作记录 ，1 待审批   2 已驳回   3 已完成");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

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


		setFields(projectCodeField, projectNameField, initiateDesignField, operatorField, statusField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

