package com.pomplatform.client.contractppspcccfscsiiicpor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMcontractppspcccfscsiiicpor extends DataSource
{


	public static CDMcontractppspcccfscsiiicpor instance = null;

	public static CDMcontractppspcccfscsiiicpor getInstance() {
		if(instance == null) {
			instance = new CDMcontractppspcccfscsiiicpor("CDMcontractppspcccfscsiiicpor");
		}
		return instance;
	}

	private final DataSourceTextField projectNameField;
	private final DataSourceTextField subContractCodeField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceIntegerField flowStatusField;
	private final DataSourceFloatField signingMoneySumField;
	private final DataSourceFloatField contractPriceField;
	private final DataSourceIntegerField statusField;
	private final DataSourceBooleanField isFinishField;
	private final DataSourceBooleanField isSystemAddField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField customerNameField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceIntegerField contractStatusField;

	public CDMcontractppspcccfscsiiicpor(String dataSourceID) {

		setID(dataSourceID);
		projectNameField = new DataSourceTextField("projectName", "订单名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		subContractCodeField = new DataSourceTextField("subContractCode", "订单编号");
		subContractCodeField.setRequired(false);
		subContractCodeField.setLength(64);
		subContractCodeField.setHidden(false);

		projectIdField = new DataSourceIntegerField("projectId", "订单编码");
		projectIdField.setRequired(true);
		projectIdField.setLength(11);
		projectIdField.setPrimaryKey(true);
		projectIdField.setHidden(true);

		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setRequired(true);
		contractIdField.setLength(11);
		contractIdField.setPrimaryKey(true);
		contractIdField.setHidden(true);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		flowStatusField = new DataSourceIntegerField("flowStatus", "流转状态，默认为0表示可以提交到运营管理修改承接部门1表示可以提交到运营管理运营价格2表示可以提交到运营管理运营价格审核3表示审核完成");
		flowStatusField.setRequired(false);
		flowStatusField.setLength(11);
		flowStatusField.setHidden(false);

		signingMoneySumField = new DataSourceFloatField("signingMoneySum", "签约总金额");
		signingMoneySumField.setRequired(true);
		signingMoneySumField.setLength(16);
		signingMoneySumField.setHidden(false);

		contractPriceField = new DataSourceFloatField("contractPrice", "合同单价");
		contractPriceField.setRequired(true);
		contractPriceField.setLength(16);
		contractPriceField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "结算状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		isFinishField = new DataSourceBooleanField("isFinish", "合同是否完成");
		isFinishField.setRequired(false);
		isFinishField.setHidden(false);

		isSystemAddField = new DataSourceBooleanField("isSystemAdd", "是否为erp系统添加  true 为系统添加  false 为数据导入");
		isSystemAddField.setRequired(false);
		isSystemAddField.setHidden(false);

		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setRequired(false);
		infoCodeField.setLength(32);
		infoCodeField.setHidden(false);

		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setRequired(false);
		customerNameField.setLength(512);
		customerNameField.setHidden(false);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(64);
		projectCodeField.setHidden(false);
		
		contractStatusField = new DataSourceIntegerField("contractStatus", "合同状态");
		contractStatusField.setRequired(true);
		contractStatusField.setLength(11);
		contractStatusField.setPrimaryKey(true);
		contractStatusField.setHidden(true);

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


		setFields(projectNameField, subContractCodeField, projectIdField, contractIdField, contractCodeField, contractNameField, flowStatusField, signingMoneySumField, contractPriceField, statusField, isFinishField, isSystemAddField, infoCodeField, customerNameField, projectCodeField, contractStatusField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

