package com.pomplatform.client.scontractcccor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDScontractcccor extends DataSource
{


	public static CDScontractcccor instance = null;

	public static CDScontractcccor getInstance() {
		if(instance == null) {
			instance = new CDScontractcccor("CDScontractcccor");
		}
		return instance;
	}

	private final DataSourceBooleanField hasSplitPriceField;
	private final DataSourceBooleanField isSystemAddField;
	private final DataSourceIntegerField flowStatusField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceIntegerField statusField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceIntegerField contractTypeField;
	private final DataSourceIntegerField projectLevelField;
	private final DataSourceIntegerField totalProjectTimeField;
	private final DataSourceIntegerField contractFollowerField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField signingCompanyNameField;
	private final DataSourceTextField serialNumberField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceIntegerField contractStatusField;
	private final DataSourceTextField clientContractIdField;
	private final DataSourceBooleanField isFinishField;
	private final DataSourceTextField detailAddressField;
	private final DataSourceTextField customerAddressField;

	public CDScontractcccor(String dataSourceID) {

		setID(dataSourceID);
		hasSplitPriceField = new DataSourceBooleanField("hasSplitPrice", "是否有拆分价 true 有，反之");
		hasSplitPriceField.setRequired(false);
		hasSplitPriceField.setHidden(false);

		isSystemAddField = new DataSourceBooleanField("isSystemAdd", "是否为erp系统添加  true 为系统添加  false 为数据导入");
		isSystemAddField.setRequired(false);
		isSystemAddField.setHidden(false);

		flowStatusField = new DataSourceIntegerField("flowStatus", "流转状态，默认为0表示可以提交到运营管理修改承接部门1表示可以提交到运营管理运营价格2表示可以提交到运营管理运营价格审核3表示审核完成");
		flowStatusField.setRequired(false);
		flowStatusField.setLength(11);
		flowStatusField.setHidden(false);

		contractIdField = new DataSourceIntegerField("contractId", "主订单编码");
		contractIdField.setRequired(true);
		contractIdField.setLength(11);
		contractIdField.setPrimaryKey(true);
		contractIdField.setHidden(true);

		contractCodeField = new DataSourceTextField("contractCode", "主订单编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "主订单名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "结算状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(64);
		projectCodeField.setHidden(false);

		contractTypeField = new DataSourceIntegerField("contractType", "合同类别");
		contractTypeField.setRequired(false);
		contractTypeField.setLength(11);
		contractTypeField.setHidden(false);

		projectLevelField = new DataSourceIntegerField("projectLevel", "项目等级");
		projectLevelField.setRequired(false);
		projectLevelField.setLength(11);
		projectLevelField.setHidden(false);

		totalProjectTimeField = new DataSourceIntegerField("totalProjectTime", "项目总工期");
		totalProjectTimeField.setRequired(false);
		totalProjectTimeField.setLength(11);
		totalProjectTimeField.setHidden(false);

		contractFollowerField = new DataSourceIntegerField("contractFollower", "合同跟进人");
		contractFollowerField.setRequired(false);
		contractFollowerField.setLength(11);
		contractFollowerField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(512);
		remarkField.setHidden(false);

		signingCompanyNameField = new DataSourceIntegerField("signingCompanyName", "我方签约公司名称");
		signingCompanyNameField.setRequired(false);
		signingCompanyNameField.setLength(11);
		signingCompanyNameField.setHidden(false);

		serialNumberField = new DataSourceTextField("serialNumber", "流水号");
		serialNumberField.setRequired(false);
		serialNumberField.setLength(6);
		serialNumberField.setHidden(false);

		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setRequired(false);
		infoCodeField.setLength(32);
		infoCodeField.setHidden(false);

		contractStatusField = new DataSourceIntegerField("contractStatus", "合同状态  0未启动、1待签署、2已签署、3未签搁置、4解除");
		contractStatusField.setRequired(false);
		contractStatusField.setLength(11);
		contractStatusField.setHidden(false);

		clientContractIdField = new DataSourceTextField("clientContractId", "客户合同编号");
		clientContractIdField.setRequired(false);
		clientContractIdField.setLength(64);
		clientContractIdField.setHidden(false);

		isFinishField = new DataSourceBooleanField("isFinish", "合同是否完成");
		isFinishField.setRequired(false);
		isFinishField.setHidden(false);

		detailAddressField = new DataSourceTextField("detailAddress", "详细地址");
		detailAddressField.setRequired(false);
		detailAddressField.setLength(50);
		detailAddressField.setHidden(false);

		customerAddressField = new DataSourceTextField("customerAddress", "客户地址");
		customerAddressField.setRequired(false);
		customerAddressField.setLength(512);
		customerAddressField.setHidden(false);

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


		setFields(hasSplitPriceField, isSystemAddField, flowStatusField, contractIdField, contractCodeField, contractNameField, statusField, projectCodeField, contractTypeField, projectLevelField, totalProjectTimeField, contractFollowerField, remarkField, signingCompanyNameField, serialNumberField, infoCodeField, contractStatusField, clientContractIdField, isFinishField, detailAddressField, customerAddressField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

