package com.pomplatform.client.contract.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSContractDistributionMonthlyDetail extends DBDataSource
{


	public static DSContractDistributionMonthlyDetail instance = null;

	public static DSContractDistributionMonthlyDetail getInstance() {
		if(instance == null) {
			instance = new DSContractDistributionMonthlyDetail("DSContractDistributionMonthlyDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceDateField recordDateField;
	private final DataSourceFloatField integralField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceDateField updateTimeField;
	private final DataSourceTextField remarkField;

	public DSContractDistributionMonthlyDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ContractDistributionMonthlyDetail");


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);


		recordDateField = new DataSourceDateField("recordDate", "签订日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);


		integralField = new DataSourceFloatField("integral", "金额");
		integralField.setLength(18);
		integralField.setDecimalPad(2);
		integralField.setFormat("#,###,###,###,###,##0.00");
		integralField.setRequired(false);
		integralField.setHidden(false);


		operatorField = new DataSourceIntegerField("operator", "分配人");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(false);
		operatorField.setValueMap(KeyValueManager.getValueMap("employees"));


		updateTimeField = new DataSourceDateField("updateTime", "操作日期");
		updateTimeField.setRequired(false);
		updateTimeField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(plateIdField, contractCodeField, contractNameField, recordDateField, integralField, operatorField, updateTimeField, remarkField);
	}


}

