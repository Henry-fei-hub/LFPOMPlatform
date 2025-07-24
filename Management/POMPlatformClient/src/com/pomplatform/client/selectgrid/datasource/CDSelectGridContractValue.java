package com.pomplatform.client.selectgrid.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSelectGridContractValue extends DataSource
{


	public static CDSelectGridContractValue instance = null;

	public static CDSelectGridContractValue getInstance() {
		if(instance == null) {
			instance = new CDSelectGridContractValue("CDSelectGridContractValue");
		}
		return instance;
	}

	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField customerNameField;
	private final DataSourceTextField projectTypeField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceTextField businessTypeField;
	private final DataSourceIntegerField flowStatusField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceBooleanField isFinishField;

	public CDSelectGridContractValue(String dataSourceID) {

		setID(dataSourceID);
		contractCodeField = new DataSourceTextField("contractCode", "主订单编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "主订单名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setRequired(false);
		customerNameField.setLength(512);
		customerNameField.setHidden(false);

		projectTypeField = new DataSourceTextField("projectType", "项目类别");
		projectTypeField.setRequired(false);
		projectTypeField.setLength(128);
		projectTypeField.setHidden(false);

		contractIdField = new DataSourceIntegerField("contractId", "主订单编码");
		contractIdField.setRequired(true);
		contractIdField.setLength(11);
		contractIdField.setPrimaryKey(true);
		contractIdField.setHidden(true);

		statusField = new DataSourceIntegerField("status", "结算状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		businessTypeField = new DataSourceTextField("businessType", "业务类别");
		businessTypeField.setRequired(false);
		businessTypeField.setLength(120);
		businessTypeField.setHidden(false);

		flowStatusField = new DataSourceIntegerField("flowStatus", "流转状态，默认为0表示可以提交到运营管理修改承接部门1表示可以提交到运营管理运营价格2表示可以提交到运营管理运营价格审核3表示审核完成");
		flowStatusField.setRequired(false);
		flowStatusField.setLength(11);
		flowStatusField.setHidden(false);

		parentIdField = new DataSourceIntegerField("parentId", "tree结构表示");
		parentIdField.setRequired(false);
		parentIdField.setLength(11);
		parentIdField.setHidden(false);
//		parentIdField.setValueMap(KeyValueManager.getValueMap("project_types"));
		KeyValueManager.loadValueMap("project_types", parentIdField);

		isFinishField = new DataSourceBooleanField("isFinish", "合同是否完成");
		isFinishField.setRequired(false);
		isFinishField.setHidden(false);

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(contractCodeField, contractNameField, customerNameField, projectTypeField, contractIdField, statusField, businessTypeField, flowStatusField, parentIdField, isFinishField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

