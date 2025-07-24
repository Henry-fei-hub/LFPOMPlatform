package com.pomplatform.client.project.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnBidSheetProject extends DBDataSource
{


	public static DSOnBidSheetProject instance = null;

	public static DSOnBidSheetProject getInstance() {
		if(instance == null) {
			instance = new DSOnBidSheetProject("DSOnBidSheetProject");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField businessTypeField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField plateManagerIdField;
	private final DataSourceTextField departmentManagerIdField;
	private final DataSourceTextField projectManageIdField;
	private final DataSourceFloatField signingMoneySumField;
	private final DataSourceTextField remarkField;

	public DSOnBidSheetProject(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnBidSheetProject");


		contractIdField = new DataSourceIntegerField("contractId", "合同ID");
		contractIdField.setLength(11);
		contractIdField.setPrimaryKey(true);
		contractIdField.setRequired(true);
		contractIdField.setHidden(true);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);
		
		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);

		projectCodeField = new DataSourceTextField("projectCode", "订单编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(true);


		projectNameField = new DataSourceTextField("projectName", "订单名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		businessTypeField = new DataSourceIntegerField("businessType", "业务类别");
		businessTypeField.setLength(11);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(false);
		businessTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));

		projectTypeField = new DataSourceIntegerField("projectType", "项目类别");
		projectTypeField.setLength(11);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(false);
		projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
		
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		plateManagerIdField = new DataSourceTextField("plateManagerId", "事业部负责人");
		plateManagerIdField.setLength(11);
		plateManagerIdField.setRequired(false);
		plateManagerIdField.setHidden(true);
		plateManagerIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		departmentManagerIdField = new DataSourceTextField("departmentManagerId", "部门经理");
		departmentManagerIdField.setLength(11);
		departmentManagerIdField.setRequired(false);
		departmentManagerIdField.setHidden(false);
		departmentManagerIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		projectManageIdField = new DataSourceTextField("projectManageId", "专业负责人");
		projectManageIdField.setLength(11);
		projectManageIdField.setRequired(false);
		projectManageIdField.setHidden(false);
		projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		
		signingMoneySumField = new DataSourceFloatField("signingMoneySum", "投标金额");
		signingMoneySumField.setLength(18);
		signingMoneySumField.setDecimalPad(2);
		signingMoneySumField.setFormat("#,###,###,###,###,##0.00");
		signingMoneySumField.setRequired(false);
		signingMoneySumField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(true);
		remarkField.setHidden(false);
		
		setFields(contractIdField, contractCodeField, contractNameField,projectCodeField, projectNameField, businessTypeField, projectTypeField, plateIdField,departmentIdField, plateManagerIdField, departmentManagerIdField, projectManageIdField,signingMoneySumField, remarkField);
	}


}

