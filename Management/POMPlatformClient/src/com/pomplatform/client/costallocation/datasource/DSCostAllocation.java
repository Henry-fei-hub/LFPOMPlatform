package com.pomplatform.client.costallocation.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSCostAllocation extends DBDataSource
{


	public static DSCostAllocation instance = null;

	public static DSCostAllocation getInstance() {
		if(instance == null) {
			instance = new DSCostAllocation("DSCostAllocation");
		}
		return instance;
	}

	private final DataSourceIntegerField costAllocationIdField;
	private final DataSourceIntegerField typeField;
	private final DataSourceIntegerField resetCostIdField;
	private final DataSourceIntegerField idField;
	private final DataSourceTextField codeField;
	private final DataSourceTextField nameField;
	private final DataSourceFloatField costField;

	public DSCostAllocation(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("CostAllocation");


		costAllocationIdField = new DataSourceIntegerField("costAllocationId", "报销成本分摊表编码");
		costAllocationIdField.setLength(11);
		costAllocationIdField.setPrimaryKey(true);
		costAllocationIdField.setRequired(true);
		costAllocationIdField.setHidden(true);


		typeField = new DataSourceIntegerField("type", "成本类型");
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setHidden(false);
		typeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_121"));


		resetCostIdField = new DataSourceIntegerField("resetCostId", "（父级）成本重新归集表编码");
		resetCostIdField.setLength(11);
		resetCostIdField.setRequired(false);
		resetCostIdField.setHidden(true);


		idField = new DataSourceIntegerField("id", "部门或者项目编码");
		idField.setLength(11);
		idField.setRequired(false);
		idField.setHidden(true);


		codeField = new DataSourceTextField("code", "编号");
		codeField.setLength(128);
		codeField.setRequired(false);
		codeField.setHidden(false);


		nameField = new DataSourceTextField("name", "费用承担主体");
		nameField.setLength(256);
		nameField.setRequired(false);
		nameField.setHidden(false);


		costField = new DataSourceFloatField("cost", "成本");
		costField.setLength(18);
		costField.setDecimalPad(2);
		costField.setFormat("#,###,###,###,###,##0.00");
		costField.setRequired(false);
		costField.setHidden(false);


		setFields(costAllocationIdField, typeField, resetCostIdField, idField, codeField, nameField, costField);
	}


}

