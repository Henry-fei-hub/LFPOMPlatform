package com.pomplatform.client.contract.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadAttachmentBindContract extends DBDataSource
{


	public static DSOnLoadAttachmentBindContract instance = null;

	public static DSOnLoadAttachmentBindContract getInstance() {
		if(instance == null) {
			instance = new DSOnLoadAttachmentBindContract("DSOnLoadAttachmentBindContract");
		}
		return instance;
	}

	private final DataSourceIntegerField contractLinkAttachmentIdField;
	private final DataSourceIntegerField contractAttachmentIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField fileIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField customerNameField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceFloatField signingMoneySumField;

	public DSOnLoadAttachmentBindContract(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadAttachmentBindContract");


		contractLinkAttachmentIdField = new DataSourceIntegerField("contractLinkAttachmentId", "主键编码");
		contractLinkAttachmentIdField.setLength(11);
		contractLinkAttachmentIdField.setPrimaryKey(true);
		contractLinkAttachmentIdField.setRequired(true);
		contractLinkAttachmentIdField.setHidden(true);


		contractAttachmentIdField = new DataSourceIntegerField("contractAttachmentId", "合同附件Id");
		contractAttachmentIdField.setLength(11);
		contractAttachmentIdField.setRequired(false);
		contractAttachmentIdField.setHidden(true);


		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);


		fileIdField = new DataSourceIntegerField("fileId", "附件编码");
		fileIdField.setLength(11);
		fileIdField.setRequired(false);
		fileIdField.setHidden(true);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);


		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setLength(512);
		customerNameField.setRequired(false);
		customerNameField.setHidden(false);


		companyIdField = new DataSourceIntegerField("companyId", "我方签约公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(true);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		signingMoneySumField = new DataSourceFloatField("signingMoneySum", "合同金额");
		signingMoneySumField.setLength(16);
		signingMoneySumField.setDecimalPad(2);
		signingMoneySumField.setFormat("##,###,###,###,##0.00");
		signingMoneySumField.setRequired(false);
		signingMoneySumField.setHidden(false);


		setFields(contractLinkAttachmentIdField, contractAttachmentIdField, contractIdField, fileIdField, contractCodeField, contractNameField, customerNameField, companyIdField, signingMoneySumField);
	}


}

