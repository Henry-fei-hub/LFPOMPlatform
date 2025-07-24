package com.pomplatform.client.attachment.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSattachmentmanageaaaor extends DataSource
{


	public static CDSattachmentmanageaaaor instance = null;

	public static CDSattachmentmanageaaaor getInstance() {
		if(instance == null) {
			instance = new CDSattachmentmanageaaaor("CDSattachmentmanageaaaor");
		}
		return instance;
	}

	private final DataSourceTextField attachmentCodeField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceTextField attachmentAddressField;
	private final DataSourceTextField perfessionRemarkField;
	private final DataSourceIntegerField attachmentManageIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField serialNumberField;

	public CDSattachmentmanageaaaor(String dataSourceID) {

		setID(dataSourceID);
		attachmentCodeField = new DataSourceTextField("attachmentCode", "编号");
		attachmentCodeField.setRequired(false);
		attachmentCodeField.setLength(64);
		attachmentCodeField.setHidden(false);

		attachmentNameField = new DataSourceTextField("attachmentName", "附件名称");
		attachmentNameField.setRequired(false);
		attachmentNameField.setLength(128);
		attachmentNameField.setHidden(false);

		attachmentAddressField = new DataSourceTextField("attachmentAddress", "附件路径");
		attachmentAddressField.setRequired(false);
		attachmentAddressField.setLength(128);
		attachmentAddressField.setHidden(false);

		perfessionRemarkField = new DataSourceTextField("perfessionRemark", "专业备注");
		perfessionRemarkField.setRequired(false);
		perfessionRemarkField.setLength(128);
		perfessionRemarkField.setHidden(false);

		attachmentManageIdField = new DataSourceIntegerField("attachmentManageId", "主键编码");
		attachmentManageIdField.setRequired(true);
		attachmentManageIdField.setLength(11);
		attachmentManageIdField.setHidden(true);

		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setRequired(false);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);

		serialNumberField = new DataSourceIntegerField("serialNumber", "序列号(生成编号的序号)");
		serialNumberField.setRequired(false);
		serialNumberField.setLength(11);
		serialNumberField.setHidden(false);

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


		setFields(attachmentCodeField, attachmentNameField, attachmentAddressField, perfessionRemarkField, attachmentManageIdField, contractIdField, serialNumberField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

