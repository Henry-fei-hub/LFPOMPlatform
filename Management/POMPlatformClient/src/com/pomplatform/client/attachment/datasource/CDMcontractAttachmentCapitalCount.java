package com.pomplatform.client.attachment.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMcontractAttachmentCapitalCount extends DataSource
{


	public static CDMcontractAttachmentCapitalCount instance = null;

	public static CDMcontractAttachmentCapitalCount getInstance() {
		if(instance == null) {
			instance = new CDMcontractAttachmentCapitalCount("CDMcontractAttachmentCapitalCount");
		}
		return instance;
	}

	private final DataSourceDateTimeField minHappenDateField;
	private final DataSourceDateTimeField maxHappenDateField;
	private final DataSourceDateField beforeSettlementDateField;
	private final DataSourceDateField afterSettlementDateField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceIntegerField contractStatusField;
	private final DataSourceIntegerField contractTypeField;
	private final DataSourceTextField attachmentAddressField;
	private final DataSourceTextField attachmentCodeField;
	private final DataSourceIntegerField attachmentManageIdField;
	private final DataSourceFloatField returnAmountField;
	private final DataSourceFloatField amountField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceFloatField borrowMoneyField;
	private final DataSourceTextField businessTypeField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceIntegerField flowStatusField;
	private final DataSourceBooleanField isFinishField;
	private final DataSourceBooleanField isSystemAddField;

	public CDMcontractAttachmentCapitalCount(String dataSourceID) {

		setID(dataSourceID);
		minHappenDateField = new DataSourceDateTimeField("minHappenDate", "最早发生日期");
		minHappenDateField.setRequired(false);
		minHappenDateField.setHidden(false);

		maxHappenDateField = new DataSourceDateTimeField("maxHappenDate", "最晚发生日期");
		maxHappenDateField.setRequired(false);
		maxHappenDateField.setHidden(false);

		beforeSettlementDateField = new DataSourceDateField("beforeSettlementDate", "结算日期");
		beforeSettlementDateField.setRequired(false);
		beforeSettlementDateField.setHidden(false);

		afterSettlementDateField = new DataSourceDateField("afterSettlementDate", "结算日期");
		afterSettlementDateField.setRequired(false);
		afterSettlementDateField.setHidden(false);

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

		contractStatusField = new DataSourceIntegerField("contractStatus", "合同状态  0未启动、1待签署、2已签署、3未签搁置、4解除");
		contractStatusField.setRequired(false);
		contractStatusField.setLength(11);
		contractStatusField.setHidden(false);

		contractTypeField = new DataSourceIntegerField("contractType", "合同类别");
		contractTypeField.setRequired(false);
		contractTypeField.setLength(11);
		contractTypeField.setHidden(false);

		attachmentAddressField = new DataSourceTextField("attachmentAddress", "附件路径");
		attachmentAddressField.setRequired(false);
		attachmentAddressField.setLength(128);
		attachmentAddressField.setHidden(false);

		attachmentCodeField = new DataSourceTextField("attachmentCode", "编号");
		attachmentCodeField.setRequired(false);
		attachmentCodeField.setLength(64);
		attachmentCodeField.setHidden(false);

		attachmentManageIdField = new DataSourceIntegerField("attachmentManageId", "主键编码");
		attachmentManageIdField.setRequired(true);
		attachmentManageIdField.setLength(11);
		attachmentManageIdField.setPrimaryKey(true);
		attachmentManageIdField.setHidden(true);

		returnAmountField = new DataSourceFloatField("returnAmount", "回款金额");
		returnAmountField.setRequired(true);
		returnAmountField.setLength(18);
		returnAmountField.setHidden(false);

		amountField = new DataSourceFloatField("amount", "金额");
		amountField.setRequired(true);
		amountField.setLength(18);
		amountField.setHidden(false);

		attachmentNameField = new DataSourceTextField("attachmentName", "附件名称");
		attachmentNameField.setRequired(false);
		attachmentNameField.setLength(128);
		attachmentNameField.setHidden(false);

		borrowMoneyField = new DataSourceFloatField("borrowMoney", "undefined");
		borrowMoneyField.setRequired(true);
		borrowMoneyField.setLength(0);
		borrowMoneyField.setHidden(false);

		businessTypeField = new DataSourceTextField("businessType", "业务类别");
		businessTypeField.setRequired(false);
		businessTypeField.setLength(120);
		businessTypeField.setHidden(false);

		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setRequired(false);
		infoCodeField.setLength(32);
		infoCodeField.setHidden(false);

		flowStatusField = new DataSourceIntegerField("flowStatus", "流转状态，默认为0表示可以提交到运营管理修改承接部门1表示可以提交到运营管理运营价格2表示可以提交到运营管理运营价格审核3表示审核完成");
		flowStatusField.setRequired(false);
		flowStatusField.setLength(11);
		flowStatusField.setHidden(false);

		isFinishField = new DataSourceBooleanField("isFinish", "合同是否完成");
		isFinishField.setRequired(false);
		isFinishField.setHidden(false);

		isSystemAddField = new DataSourceBooleanField("isSystemAdd", "是否为erp系统添加  true 为系统添加  false 为数据导入");
		isSystemAddField.setRequired(false);
		isSystemAddField.setHidden(false);

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


		setFields(minHappenDateField, maxHappenDateField, beforeSettlementDateField, afterSettlementDateField, contractIdField, contractCodeField, contractNameField, contractStatusField, contractTypeField, attachmentAddressField, attachmentCodeField, attachmentManageIdField, returnAmountField, amountField, attachmentNameField, borrowMoneyField, businessTypeField, infoCodeField, flowStatusField, isFinishField, isSystemAddField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

