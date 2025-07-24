package com.pomplatform.client.workflow.personnelbusiness.datasource;

import com.delicacy.client.data.DBDataSource;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridMyProjectValue;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.grid.ListGridField;

public class DSCarCostAllocationProjectEdit extends DBDataSource
{


	public static DSCarCostAllocationProjectEdit instance = null;

	public static DSCarCostAllocationProjectEdit getInstance() {
		if(instance == null) {
			instance = new DSCarCostAllocationProjectEdit("DSCarCostAllocation");
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

	public DSCarCostAllocationProjectEdit(String dataSourceID) {

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


		idField = new DataSourceIntegerField("id", "订单");
		idField.setLength(11);
		idField.setRequired(false);
		idField.setHidden(false);
		
		ListGridField projectIdField = new ListGridField("projectId");
		ListGridField contractCodeField = new ListGridField("contractCode");
		contractCodeField.setWidth(250);
		ListGridField projectNameField = new ListGridField("projectName");
		ListGridField projectManageIdField = new ListGridField("projectManageId");
		projectManageIdField.setWidth(80);
		ComboBoxItem projectSelectItem = new ComboBoxItem();
		projectSelectItem.setWidth("*");
		projectSelectItem.setChangeOnKeypress(false);
		projectSelectItem.setOptionDataSource(DSSelectGridMyProjectValue.getInstance());
		projectSelectItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		projectSelectItem.setValueField(projectIdField.getName());
		projectSelectItem.setDisplayField(projectNameField.getName());
		projectSelectItem.setPickListFields(projectNameField, contractCodeField,projectManageIdField);
		projectSelectItem.setPickListWidth(800);
		
		idField.setEditorProperties(projectSelectItem);

		codeField = new DataSourceTextField("code", "订单编号");
		codeField.setLength(128);
		codeField.setRequired(false);
		codeField.setHidden(false);
		codeField.setCanEdit(false);


		nameField = new DataSourceTextField("name", "订单名称");
		nameField.setLength(256);
		nameField.setRequired(false);
		nameField.setHidden(false);
		nameField.setCanEdit(false);


		costField = new DataSourceFloatField("cost", "总用车费用");
		costField.setLength(18);
		costField.setDecimalPad(2);
		costField.setFormat("#,###,###,###,###,##0.00");
		costField.setRequired(false);
		costField.setHidden(false);
		costField.setCanEdit(false);


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
		costAllocationField.setCanEdit(false);


		setFields(carCostAllocationIdField, typeField, personnelBusinessIdField, idField, codeField, nameField, costField, percentField, costAllocationField);
	}


}

