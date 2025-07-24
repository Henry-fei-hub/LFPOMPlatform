package com.pomplatform.client.capitaldistribution.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSCapitalDistributionOfDepartment extends DBDataSource
{


	public static DSCapitalDistributionOfDepartment instance = null;

	public static DSCapitalDistributionOfDepartment getInstance() {
		if(instance == null) {
			instance = new DSCapitalDistributionOfDepartment("DSCapitalDistributionOfDepartment");
		}
		return instance;
	}

	private final DataSourceIntegerField capitalDistributionIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField typeField;
	private final DataSourceIntegerField capitalIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceFloatField totalAmountField;
	private final DataSourceFloatField distributionAmountField;
	private final DataSourceDateField happenDateField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceFloatField totalDistributionAmountField;
	private final DataSourceFloatField leftAmountField;
	private final DataSourceIntegerField projectManageIdField;

	public DSCapitalDistributionOfDepartment(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("CapitalDistributionOfDepartment");


		capitalDistributionIdField = new DataSourceIntegerField("capitalDistributionId", "回款分配表编码");
		capitalDistributionIdField.setLength(11);
		capitalDistributionIdField.setPrimaryKey(true);
		capitalDistributionIdField.setRequired(true);
		capitalDistributionIdField.setHidden(true);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		contractIdField = new DataSourceIntegerField("contractId", "合同名称");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(false);
//		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts_1"));
		KeyValueManager.loadValueMap("contracts_1", contractIdField);

		typeField = new DataSourceIntegerField("type", " 2订单回款分配");
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setHidden(true);


		capitalIdField = new DataSourceIntegerField("capitalId", "回款编码");
		capitalIdField.setLength(11);
		capitalIdField.setRequired(false);
		capitalIdField.setHidden(true);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));


		totalAmountField = new DataSourceFloatField("totalAmount", "回款金额");
		totalAmountField.setLength(18);
		totalAmountField.setDecimalPad(2);
		totalAmountField.setFormat("#,###,###,###,###,##0.00");
		totalAmountField.setRequired(false);
		totalAmountField.setHidden(false);


		distributionAmountField = new DataSourceFloatField("distributionAmount", "本部门回款分配金额");
		distributionAmountField.setLength(18);
		distributionAmountField.setDecimalPad(2);
		distributionAmountField.setFormat("#,###,###,###,###,##0.00");
		distributionAmountField.setRequired(false);
		distributionAmountField.setHidden(false);
		
		
		totalDistributionAmountField = new DataSourceFloatField("totalDistributionAmount", "已分配金额");
		totalDistributionAmountField.setLength(18);
		totalDistributionAmountField.setDecimalPad(2);
		totalDistributionAmountField.setFormat("#,###,###,###,###,##0.00");
		totalDistributionAmountField.setRequired(false);
		totalDistributionAmountField.setHidden(false);
		
		
		leftAmountField = new DataSourceFloatField("leftAmount", "剩余金额");
		leftAmountField.setLength(18);
		leftAmountField.setDecimalPad(2);
		leftAmountField.setFormat("#,###,###,###,###,##0.00");
		leftAmountField.setRequired(false);
		leftAmountField.setHidden(false);


		happenDateField = new DataSourceDateField("happenDate", "回款日期");
		happenDateField.setRequired(false);
		happenDateField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		projectIdField = new DataSourceIntegerField("projectId", "订单编号");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);
//		projectIdField.setValueMap(KeyValueManager.getValueMap("project_code"));
		KeyValueManager.loadValueMap("project_code", projectIdField);
		
		projectManageIdField = new DataSourceIntegerField("projectManageId","专业负责人");
		projectManageIdField.setLength(11);
		projectManageIdField.setRequired(false);
		projectManageIdField.setHidden(false);
		projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		
		setFields(capitalDistributionIdField, contractCodeField, contractIdField, typeField, capitalIdField, plateIdField, totalAmountField, totalDistributionAmountField, leftAmountField, distributionAmountField, happenDateField, createTimeField, remarkField, projectIdField,projectManageIdField);
	}


}

