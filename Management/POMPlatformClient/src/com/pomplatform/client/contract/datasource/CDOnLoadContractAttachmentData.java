package com.pomplatform.client.contract.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadContractAttachmentData extends DataSource
{


	public static CDOnLoadContractAttachmentData instance = null;

	public static CDOnLoadContractAttachmentData getInstance() {
		if(instance == null) {
			instance = new CDOnLoadContractAttachmentData("CDOnLoadContractAttachmentData");
		}
		return instance;
	}

	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceTextField attachmentCodeField;
	private final DataSourceDateTimeField startDateField;
	private final DataSourceDateTimeField endDateField;

	public CDOnLoadContractAttachmentData(String dataSourceID) {

		setID(dataSourceID);
		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		attachmentNameField = new DataSourceTextField("attachmentName", "附件名称");
		attachmentNameField.setRequired(false);
		attachmentNameField.setLength(64);
		attachmentNameField.setHidden(false);

		attachmentCodeField = new DataSourceTextField("attachmentCode", "附件编号");
		attachmentCodeField.setRequired(false);
		attachmentCodeField.setLength(64);
		attachmentCodeField.setHidden(false);

		startDateField = new DataSourceDateTimeField("startDate", "上传开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateTimeField("endDate", "上传结束日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

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


		setFields(contractCodeField, contractNameField, attachmentNameField, attachmentCodeField, startDateField, endDateField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

