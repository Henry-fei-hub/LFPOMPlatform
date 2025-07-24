package com.pomplatform.client.attachmentmanagemeeting.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDAttachmentManageMeetingTor extends DataSource
{


	public static CDAttachmentManageMeetingTor instance = null;

	public static CDAttachmentManageMeetingTor getInstance() {
		if(instance == null) {
			instance = new CDAttachmentManageMeetingTor("CDAttachmentManageMeetingTor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectManageIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField mettingStatusField;
	private final DataSourceIntegerField operatorStatusField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField workNumField;

	public CDAttachmentManageMeetingTor(String dataSourceID) {

		setID(dataSourceID);
		projectManageIdField = new DataSourceIntegerField("projectManageId", "项目负责人");
		projectManageIdField.setRequired(false);
		projectManageIdField.setLength(11);
		projectManageIdField.setHidden(false);

		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setRequired(false);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);

		attachmentNameField = new DataSourceTextField("attachmentName", "附件名称");
		attachmentNameField.setRequired(false);
		attachmentNameField.setLength(128);
		attachmentNameField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "主订单名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "主订单编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(1024);
		remarkField.setHidden(false);

		mettingStatusField = new DataSourceIntegerField("mettingStatus", "1新建 2发布 3定稿");
		mettingStatusField.setRequired(false);
		mettingStatusField.setLength(11);
		mettingStatusField.setHidden(false);

		operatorStatusField = new DataSourceIntegerField("operatorStatus", "1 待提交 2已提交  3未答复");
		operatorStatusField.setRequired(false);
		operatorStatusField.setLength(11);
		operatorStatusField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(false);
		yearField.setLength(11);
		yearField.setHidden(false);

		workNumField = new DataSourceIntegerField("workNum", "第几周");
		workNumField.setRequired(false);
		workNumField.setLength(11);
		workNumField.setHidden(false);

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


		setFields(projectManageIdField, contractIdField, attachmentNameField, contractNameField, contractCodeField, remarkField, mettingStatusField, operatorStatusField, yearField, workNumField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

