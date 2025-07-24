package com.pomplatform.client.attachmentvoucher.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDAttachmentVoucher extends DataSource
{


	public static CDAttachmentVoucher instance = null;

	public static CDAttachmentVoucher getInstance() {
		if(instance == null) {
			instance = new CDAttachmentVoucher("CDAttachmentVoucher");
		}
		return instance;
	}

	private final DataSourceDateField minVestingDateField;
	private final DataSourceDateField maxVestingDateField;
	private final DataSourceDateTimeField minCreateTimeField;
	private final DataSourceDateTimeField maxCreateTimeField;
	private final DataSourceTextField codeField;
	private final DataSourceTextField nameField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField simplifyRemarkField;
	private final DataSourceIntegerField k3VoucherIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField sequenceNumberField;
	private final DataSourceIntegerField internalSequenceNumberField;
	private final DataSourceIntegerField codeTypeField;
	private final DataSourceIntegerField codeIdField;
	private final DataSourceIntegerField linkIdField;
	private final DataSourceIntegerField voucherTypeField;
	private final DataSourceIntegerField additionalLinkIdField;
	private final DataSourceBooleanField lockedField;
	private final DataSourceFloatField debitSideField;
	private final DataSourceFloatField creditSideField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceIntegerField contractIdField;

	public CDAttachmentVoucher(String dataSourceID) {

		setID(dataSourceID);
		minVestingDateField = new DataSourceDateField("minVestingDate", "最早归属日期");
		minVestingDateField.setRequired(false);
		minVestingDateField.setHidden(false);

		maxVestingDateField = new DataSourceDateField("maxVestingDate", "最晚归属日期");
		maxVestingDateField.setRequired(false);
		maxVestingDateField.setHidden(false);

		minCreateTimeField = new DataSourceDateTimeField("minCreateTime", "最早创建时间");
		minCreateTimeField.setRequired(false);
		minCreateTimeField.setHidden(false);

		maxCreateTimeField = new DataSourceDateTimeField("maxCreateTime", "最晚创建时间");
		maxCreateTimeField.setRequired(false);
		maxCreateTimeField.setHidden(false);

		codeField = new DataSourceTextField("code", "科目代码");
		codeField.setRequired(false);
		codeField.setLength(64);
		codeField.setHidden(false);

		nameField = new DataSourceTextField("name", "科目名称");
		nameField.setRequired(false);
		nameField.setLength(128);
		nameField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(1024);
		remarkField.setHidden(false);

		simplifyRemarkField = new DataSourceTextField("simplifyRemark", "简化备注");
		simplifyRemarkField.setRequired(false);
		simplifyRemarkField.setLength(200);
		simplifyRemarkField.setHidden(false);

		k3VoucherIdField = new DataSourceIntegerField("k3VoucherId", "主键编码");
		k3VoucherIdField.setRequired(true);
		k3VoucherIdField.setLength(11);
		k3VoucherIdField.setPrimaryKey(true);
		k3VoucherIdField.setHidden(true);

		projectIdField = new DataSourceIntegerField("projectId", "项目");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		sequenceNumberField = new DataSourceIntegerField("sequenceNumber", "凭证号");
		sequenceNumberField.setRequired(false);
		sequenceNumberField.setLength(11);
		sequenceNumberField.setHidden(false);

		internalSequenceNumberField = new DataSourceIntegerField("internalSequenceNumber", "凭证内序号");
		internalSequenceNumberField.setRequired(false);
		internalSequenceNumberField.setLength(11);
		internalSequenceNumberField.setHidden(false);

		codeTypeField = new DataSourceIntegerField("codeType", "科目类型");
		codeTypeField.setRequired(false);
		codeTypeField.setLength(11);
		codeTypeField.setHidden(false);

		codeIdField = new DataSourceIntegerField("codeId", "科目编码");
		codeIdField.setRequired(false);
		codeIdField.setLength(11);
		codeIdField.setHidden(false);

		linkIdField = new DataSourceIntegerField("linkId", "关联编码");
		linkIdField.setRequired(false);
		linkIdField.setLength(11);
		linkIdField.setHidden(false);

		voucherTypeField = new DataSourceIntegerField("voucherType", "凭证类型 1报销  2发票  3回款 4收入 5确认函");
		voucherTypeField.setRequired(false);
		voucherTypeField.setLength(11);
		voucherTypeField.setHidden(false);

		additionalLinkIdField = new DataSourceIntegerField("additionalLinkId", "附加的关联编码");
		additionalLinkIdField.setRequired(false);
		additionalLinkIdField.setLength(11);
		additionalLinkIdField.setHidden(false);

		lockedField = new DataSourceBooleanField("locked", "是否锁定");
		lockedField.setRequired(false);
		lockedField.setHidden(false);

		debitSideField = new DataSourceFloatField("debitSide", "借方");
		debitSideField.setRequired(true);
		debitSideField.setLength(18);
		debitSideField.setHidden(false);

		creditSideField = new DataSourceFloatField("creditSide", "贷方");
		creditSideField.setRequired(true);
		creditSideField.setLength(18);
		creditSideField.setHidden(false);

		attachmentNameField = new DataSourceTextField("attachmentName", "附件名称");
		attachmentNameField.setRequired(false);
		attachmentNameField.setLength(128);
		attachmentNameField.setHidden(false);

		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setRequired(false);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);

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


		setFields(minVestingDateField, maxVestingDateField, minCreateTimeField, maxCreateTimeField, codeField, nameField, remarkField, simplifyRemarkField, k3VoucherIdField, projectIdField, companyIdField, sequenceNumberField, internalSequenceNumberField, codeTypeField, codeIdField, linkIdField, voucherTypeField, additionalLinkIdField, lockedField, debitSideField, creditSideField, attachmentNameField, contractIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

