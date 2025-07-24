package com.pomplatform.client.workflow.personnelbusiness.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSCarCostAllocationPreProject extends DBDataSource
{


	public static DSCarCostAllocationPreProject instance = null;

	public static DSCarCostAllocationPreProject getInstance() {
		if(instance == null) {
			instance = new DSCarCostAllocationPreProject("DSCarCostAllocation");
		}
		return instance;
	}

	private final DataSourceIntegerField carCostAllocationIdField;
	private final DataSourceIntegerField typeField;
	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceIntegerField idField;
	private final DataSourceTextField codeField;
	private final DataSourceTextField nameField;
	private final DataSourceFloatField costField;
	private final DataSourceFloatField percentField;
	private final DataSourceFloatField costAllocationField;

	public DSCarCostAllocationPreProject(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("CarCostAllocation");


		carCostAllocationIdField = new DataSourceIntegerField("carCostAllocationId", "用车费用分摊表编码");
		carCostAllocationIdField.setLength(11);
		carCostAllocationIdField.setPrimaryKey(true);
		carCostAllocationIdField.setRequired(true);
		carCostAllocationIdField.setHidden(true);


		typeField = new DataSourceIntegerField("type", "  3部门用车");
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setHidden(true);


		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "个人事务表编码");
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setRequired(false);
		personnelBusinessIdField.setHidden(true);


		idField = new DataSourceIntegerField("id", "部门或者项目编码");
		idField.setLength(11);
		idField.setRequired(false);
		idField.setHidden(true);
		

		codeField = new DataSourceTextField("code", "前期项目编号");
		codeField.setLength(128);
		codeField.setRequired(false);
		codeField.setHidden(false);


		nameField = new DataSourceTextField("name", "前期项目名称");
		nameField.setLength(256);
		nameField.setRequired(false);
		nameField.setHidden(false);


		costField = new DataSourceFloatField("cost", "总用车费用");
		costField.setLength(18);
		costField.setDecimalPad(2);
		costField.setFormat("#,###,###,###,###,##0.00");
		costField.setRequired(false);
		costField.setHidden(false);


		percentField = new DataSourceFloatField("percent", "成本分摊比例（%）");
		percentField.setLength(18);
		percentField.setDecimalPad(2);
		percentField.setFormat("#,###,###,###,###,##0.00");
		percentField.setRequired(false);
		percentField.setHidden(false);


		costAllocationField = new DataSourceFloatField("costAllocation", "成本分摊");
		costAllocationField.setLength(18);
		costAllocationField.setDecimalPad(2);
		costAllocationField.setFormat("#,###,###,###,###,##0.00");
		costAllocationField.setRequired(false);
		costAllocationField.setHidden(false);


		setFields(carCostAllocationIdField, typeField, personnelBusinessIdField, idField, codeField, nameField, costField, percentField, costAllocationField);
	}


}

