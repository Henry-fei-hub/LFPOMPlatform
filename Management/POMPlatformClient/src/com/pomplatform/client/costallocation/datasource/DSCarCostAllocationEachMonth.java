package com.pomplatform.client.costallocation.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSCarCostAllocationEachMonth extends DBDataSource
{


	public static DSCarCostAllocationEachMonth instance = null;

	public static DSCarCostAllocationEachMonth getInstance() {
		if(instance == null) {
			instance = new DSCarCostAllocationEachMonth("DSCarCostAllocationEachMonth");
		}
		return instance;
	}

	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceIntegerField startDateDetailField;
	private final DataSourceIntegerField idField;
	private final DataSourceTextField codeField;
	private final DataSourceTextField nameField;
	private final DataSourceFloatField costField;

	public DSCarCostAllocationEachMonth(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("CarCostAllocationEachMonth");


		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(true);
		yearField.setHidden(false);


		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(true);
		monthField.setHidden(false);


		startDateDetailField = new DataSourceIntegerField("startDateDetail", "用车类型");
		startDateDetailField.setLength(11);
		startDateDetailField.setRequired(false);
		startDateDetailField.setHidden(false);
		startDateDetailField.setValueMap(KeyValueManager.getValueMap("system_dictionary_119"));


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


		setFields(yearField, monthField, startDateDetailField, idField, codeField, nameField, costField);
	}


}

