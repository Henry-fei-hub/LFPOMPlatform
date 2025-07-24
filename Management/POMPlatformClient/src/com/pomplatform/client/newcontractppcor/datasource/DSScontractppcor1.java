package com.pomplatform.client.newcontractppcor.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSScontractppcor1 extends DBDataSource
{


	public static DSScontractppcor1 instance = null;

	public static DSScontractppcor1 getInstance() {
		if(instance == null) {
			instance = new DSScontractppcor1("DSScontractppcor1");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField customerNameField;
	private final DataSourceIntegerField customerIdField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceIntegerField contractTypeField;
	private final DataSourceIntegerField projectLevelField;
	private final DataSourceFloatField signingMoneySumField;
	private final DataSourceTextField projectAddressField;
	private final DataSourceTextField contractFollowerField;
	private final DataSourceTextField remarkField;
	private final DataSourceDateField contractDateField;
	private final DataSourceIntegerField signingCompanyNameField;
	private final DataSourceTextField businessTypeField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceIntegerField contractStatusField;
	private final DataSourceIntegerField departmentIdField;
	

	public DSScontractppcor1(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Scontractppcor");


		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setLength(11);
		contractIdField.setPrimaryKey(true);
		contractIdField.setRequired(true);
		contractIdField.setHidden(true);
//		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractIdField);

		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(32);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(true);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		contractStatusField = new DataSourceIntegerField("contractStatus", "合同状态");
		contractStatusField.setLength(11);
		contractStatusField.setRequired(false);
		contractStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_35"));


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);


		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setLength(512);
		customerNameField.setRequired(false);
		customerNameField.setHidden(true);
		
		
		customerIdField = new DataSourceIntegerField("customerId", "客户名称");
		customerIdField.setLength(512);
		customerIdField.setRequired(false);
		customerIdField.setHidden(false);
		KeyValueManager.loadValueMap("customers", customerIdField);


		projectLevelField = new DataSourceIntegerField("projectLevel", "项目等级");
		projectLevelField.setLength(11);
		projectLevelField.setRequired(false);
		projectLevelField.setHidden(false);
		projectLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));

		businessTypeField = new DataSourceTextField("businessType", "业务类别");
		businessTypeField.setLength(120);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(false);
		businessTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));


		signingMoneySumField = new DataSourceFloatField("signingMoneySum", "签约总金额");
		signingMoneySumField.setLength(16);
		signingMoneySumField.setDecimalPad(2);
		signingMoneySumField.setFormat("##,###,###,###,##0.00");
		signingMoneySumField.setRequired(false);
		signingMoneySumField.setHidden(false);


		contractTypeField = new DataSourceIntegerField("contractType", "合同类别");
		contractTypeField.setLength(11);
		contractTypeField.setRequired(false);
		contractTypeField.setHidden(false);
		contractTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_27"));


		contractFollowerField = new DataSourceTextField("contractFollower", "合同跟进人");
		contractFollowerField.setLength(11);
		contractFollowerField.setRequired(false);
		contractFollowerField.setHidden(false);


		contractDateField = new DataSourceDateField("contractDate", "合同签订日期");
		contractDateField.setRequired(false);
		contractDateField.setHidden(false);


		signingCompanyNameField = new DataSourceIntegerField("signingCompanyName", "我方签约公司名称");
		signingCompanyNameField.setLength(11);
		signingCompanyNameField.setRequired(false);
		signingCompanyNameField.setHidden(false);
		signingCompanyNameField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		projectAddressField = new DataSourceTextField("projectAddress", "项目地点");
		projectAddressField.setLength(200);
		projectAddressField.setRequired(false);
		projectAddressField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);
        
		departmentIdField = new DataSourceIntegerField("departmentId", "从属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		setFields(contractIdField, contractCodeField, contractNameField, customerNameField, customerIdField, projectCodeField, contractTypeField, projectLevelField, signingMoneySumField, projectAddressField, contractFollowerField, remarkField, contractDateField, signingCompanyNameField, businessTypeField, infoCodeField, contractStatusField,departmentIdField);
	}


}

