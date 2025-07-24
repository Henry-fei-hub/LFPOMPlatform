package com.pomplatform.client.costallocation.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSCostAllocationApply extends DBDataSource
{


	public static DSCostAllocationApply instance = null;

	public static DSCostAllocationApply getInstance() {
		if(instance == null) {
			instance = new DSCostAllocationApply("DSCostAllocationApply");
		}
		return instance;
	}

	private final DataSourceIntegerField resetCostIdField;
	private final DataSourceIntegerField idField;
	private final DataSourceTextField codeField;
	private final DataSourceTextField nameField;
	private final DataSourceFloatField costField;
	private final DataSourceIntegerField linkIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField drafterField;
	private final DataSourceTextField reasonField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField deleteFlagField;
	private final DataSourceField detailCostAllocation;
	private final DataSourceIntegerField costTypeField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField currencyField;
	private final DataSourceFloatField exchangeRateField;
	
	public DSCostAllocationApply(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("CostAllocationApply");


		resetCostIdField = new DataSourceIntegerField("resetCostId", "成本重新归集表编码");
		resetCostIdField.setLength(11);
		resetCostIdField.setPrimaryKey(true);
		resetCostIdField.setRequired(true);
		resetCostIdField.setHidden(true);


		idField = new DataSourceIntegerField("id", "id");
		idField.setLength(11);
		idField.setRequired(false);
		idField.setHidden(true);


		codeField = new DataSourceTextField("code", "编号");
		codeField.setLength(256);
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


		linkIdField = new DataSourceIntegerField("linkId", "原报销单的成本分摊表编码");
		linkIdField.setLength(11);
		linkIdField.setRequired(false);
		linkIdField.setHidden(true);


		processTypeField = new DataSourceIntegerField("processType", "原报销单的流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);
		processTypeField.setValueMap(KeyValueManager.getValueMap("system_process_types"));


		businessIdField = new DataSourceIntegerField("businessId", "原报销单的业务表编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);
		businessIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		processIdField = new DataSourceIntegerField("processId", "原报销单的流程编码");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(true);


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "原报销单的流程实例编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setHidden(true);


		drafterField = new DataSourceIntegerField("drafter", "起草人");
		drafterField.setLength(11);
		drafterField.setRequired(false);
		drafterField.setHidden(false);
		drafterField.setValueMap(KeyValueManager.getValueMap("employees"));


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		deleteFlagField = new DataSourceIntegerField("deleteFlag", "删除标识位");
		deleteFlagField.setLength(11);
		deleteFlagField.setRequired(false);
		deleteFlagField.setHidden(true);

		detailCostAllocation = new DataSourceField("detailCostAllocation", FieldType.ANY);
		detailCostAllocation.setChildrenProperty(true);
		detailCostAllocation.setChildTagName("CostAllocation");
		detailCostAllocation.setRequired(false);
		detailCostAllocation.setHidden(true);

		reasonField = new DataSourceTextField("reason", "申请缘由");
		reasonField.setLength(1024);
		reasonField.setRequired(false);
		reasonField.setHidden(false);
		
		costTypeField = new DataSourceIntegerField("costType", "原成本类型");
		costTypeField.setLength(11);
		costTypeField.setRequired(false);
		costTypeField.setHidden(false);
		costTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_121"));
		
		plateIdField = new DataSourceIntegerField("plateId", "原承担费用的业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));
		
		currencyField = new DataSourceIntegerField("currency", "货币种类");
		currencyField.setLength(11);
		currencyField.setRequired(false);
		currencyField.setHidden(false);
		currencyField.setValueMap(KeyValueManager.getValueMap("system_dictionary_40"));
		
		exchangeRateField = new DataSourceFloatField("exchangeRate", "汇率");
		exchangeRateField.setLength(18);
		exchangeRateField.setDecimalPad(4);
		exchangeRateField.setFormat("##,###,###,###,##0.0000");
		exchangeRateField.setRequired(false);
		exchangeRateField.setHidden(false);
		
		setFields(resetCostIdField, idField, drafterField, costTypeField, plateIdField, codeField, nameField, costField, currencyField, exchangeRateField, linkIdField, processTypeField, businessIdField, processIdField, processInstanceIdField, drafterField, createTimeField, deleteFlagField, detailCostAllocation, reasonField);
	}


}

