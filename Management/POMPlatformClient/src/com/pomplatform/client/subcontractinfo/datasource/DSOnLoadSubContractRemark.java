package com.pomplatform.client.subcontractinfo.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadSubContractRemark extends DBDataSource
{


	public static DSOnLoadSubContractRemark instance = null;

	public static DSOnLoadSubContractRemark getInstance() {
		if(instance == null) {
			instance = new DSOnLoadSubContractRemark("DSOnLoadSubContractRemark");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField subContractRemarksField;
	private final DataSourceIntegerField attachmentIdField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceTextField attachmentField;

	public DSOnLoadSubContractRemark(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadSubContractRemark");


		contractIdField = new DataSourceIntegerField("contractId", "主订单编码");
		contractIdField.setLength(11);
		contractIdField.setPrimaryKey(true);
		contractIdField.setRequired(true);
		contractIdField.setHidden(false);


		subContractRemarksField = new DataSourceTextField("subContractRemarks", "subContractRemarks");
		subContractRemarksField.setLength(512);
		subContractRemarksField.setRequired(true);
		subContractRemarksField.setHidden(false);


		attachmentIdField = new DataSourceIntegerField("attachmentId", "attachmentId");
		attachmentIdField.setLength(11);
		attachmentIdField.setRequired(true);
		attachmentIdField.setHidden(false);


		attachmentNameField = new DataSourceTextField("attachmentName", "attachmentName");
		attachmentNameField.setLength(512);
		attachmentNameField.setRequired(true);
		attachmentNameField.setHidden(false);


		attachmentField = new DataSourceTextField("attachment", "attachment");
		attachmentField.setLength(1024);
		attachmentField.setRequired(true);
		attachmentField.setHidden(false);


		setFields(contractIdField, subContractRemarksField, attachmentIdField, attachmentNameField, attachmentField);
	}


}

