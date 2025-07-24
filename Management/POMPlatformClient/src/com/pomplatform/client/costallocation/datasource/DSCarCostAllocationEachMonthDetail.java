package com.pomplatform.client.costallocation.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSCarCostAllocationEachMonthDetail extends DBDataSource
{


	public static DSCarCostAllocationEachMonthDetail instance = null;

	public static DSCarCostAllocationEachMonthDetail getInstance() {
		if(instance == null) {
			instance = new DSCarCostAllocationEachMonthDetail("DSCarCostAllocationEachMonthDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField drafterField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceIntegerField startDateDetailField;
	private final DataSourceIntegerField idField;
	private final DataSourceTextField codeField;
	private final DataSourceTextField nameField;
	private final DataSourceDateField completeTimeField;
	private final DataSourceFloatField costAllocationField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField businessIdField;
	
	public DSCarCostAllocationEachMonthDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("CarCostAllocationEachMonthDetail");


		drafterField = new DataSourceIntegerField("drafter", "申请人");
		drafterField.setLength(11);
		drafterField.setRequired(false);
		drafterField.setHidden(false);
		drafterField.setValueMap(KeyValueManager.getValueMap("employees"));


		projectCodeField = new DataSourceTextField("projectCode", "目的地");
		projectCodeField.setLength(255);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);
//		projectCodeField.setValueMap(KeyValueManager.getValueMap("main_projects"));
		KeyValueManager.loadValueMap("main_projects",projectCodeField);

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


		completeTimeField = new DataSourceDateField("completeTime", "出行日期");
		completeTimeField.setRequired(false);
		completeTimeField.setHidden(false);


		costAllocationField = new DataSourceFloatField("costAllocation", "用车成本");
		costAllocationField.setLength(18);
		costAllocationField.setDecimalPad(2);
		costAllocationField.setFormat("#,###,###,###,###,##0.00");
		costAllocationField.setRequired(false);
		costAllocationField.setHidden(false);
		
		
		processIdField = new DataSourceIntegerField("processId", "流程ID");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(true);

		
		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程实例ID");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setHidden(true);

		
		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);
		
		
		businessIdField = new DataSourceIntegerField("businessId", "业务ID");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);


		setFields(drafterField, projectCodeField, startDateDetailField, idField, codeField, nameField, completeTimeField, costAllocationField, processIdField, processInstanceIdField, processTypeField, businessIdField);
	}


}

