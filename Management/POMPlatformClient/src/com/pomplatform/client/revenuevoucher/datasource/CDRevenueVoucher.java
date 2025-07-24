package com.pomplatform.client.revenuevoucher.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDRevenueVoucher extends DataSource
{


	public static CDRevenueVoucher instance = null;

	public static CDRevenueVoucher getInstance() {
		if(instance == null) {
			instance = new CDRevenueVoucher("CDRevenueVoucher");
		}
		return instance;
	}

	private final DataSourceDateTimeField minCreateTimeField;
	private final DataSourceDateTimeField maxCreateTimeField;
	private final DataSourceDateTimeField minUpdateTimeField;
	private final DataSourceDateTimeField maxUpdateTimeField;
	private final DataSourceDateField minVestingDateField;
	private final DataSourceDateField maxVestingDateField;
	private final DataSourceTextField codeField;
	private final DataSourceTextField nameField;
	private final DataSourceTextField secondaryCodeField;
	private final DataSourceTextField secondaryNameField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField simplifyRemarkField;
	private final DataSourceIntegerField additionalLinkIdField;
	private final DataSourceIntegerField k3VoucherIdField;
	private final DataSourceIntegerField codeTypeField;
	private final DataSourceIntegerField codeIdField;
	private final DataSourceIntegerField secondaryCodeTypeField;
	private final DataSourceIntegerField secondaryCodeIdField;
	private final DataSourceFloatField debitSideField;
	private final DataSourceFloatField creditSideField;
	private final DataSourceBooleanField lockedField;
	private final DataSourceIntegerField linkIdField;
	private final DataSourceIntegerField voucherTypeField;
	private final DataSourceTextField contractNameField;

	public CDRevenueVoucher(String dataSourceID) {

		setID(dataSourceID);
		minCreateTimeField = new DataSourceDateTimeField("minCreateTime", "最早创建时间");
		minCreateTimeField.setRequired(false);
		minCreateTimeField.setHidden(false);

		maxCreateTimeField = new DataSourceDateTimeField("maxCreateTime", "最晚创建时间");
		maxCreateTimeField.setRequired(false);
		maxCreateTimeField.setHidden(false);

		minUpdateTimeField = new DataSourceDateTimeField("minUpdateTime", "最早修改时间");
		minUpdateTimeField.setRequired(false);
		minUpdateTimeField.setHidden(false);

		maxUpdateTimeField = new DataSourceDateTimeField("maxUpdateTime", "最晚修改时间");
		maxUpdateTimeField.setRequired(false);
		maxUpdateTimeField.setHidden(false);

		minVestingDateField = new DataSourceDateField("minVestingDate", "最早归属日期");
		minVestingDateField.setRequired(false);
		minVestingDateField.setHidden(false);

		maxVestingDateField = new DataSourceDateField("maxVestingDate", "最晚归属日期");
		maxVestingDateField.setRequired(false);
		maxVestingDateField.setHidden(false);

		codeField = new DataSourceTextField("code", "科目代码");
		codeField.setRequired(false);
		codeField.setLength(64);
		codeField.setHidden(false);

		nameField = new DataSourceTextField("name", "科目名称");
		nameField.setRequired(false);
		nameField.setLength(128);
		nameField.setHidden(false);

		secondaryCodeField = new DataSourceTextField("secondaryCode", "辅助核算代码");
		secondaryCodeField.setRequired(false);
		secondaryCodeField.setLength(64);
		secondaryCodeField.setHidden(false);

		secondaryNameField = new DataSourceTextField("secondaryName", "辅助核算名称");
		secondaryNameField.setRequired(false);
		secondaryNameField.setLength(128);
		secondaryNameField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(1024);
		remarkField.setHidden(false);

		simplifyRemarkField = new DataSourceTextField("simplifyRemark", "简化备注");
		simplifyRemarkField.setRequired(false);
		simplifyRemarkField.setLength(200);
		simplifyRemarkField.setHidden(false);

		additionalLinkIdField = new DataSourceIntegerField("additionalLinkId", "附加的关联编码");
		additionalLinkIdField.setRequired(false);
		additionalLinkIdField.setLength(11);
		additionalLinkIdField.setHidden(false);

		k3VoucherIdField = new DataSourceIntegerField("k3VoucherId", "主键编码");
		k3VoucherIdField.setRequired(true);
		k3VoucherIdField.setLength(11);
		k3VoucherIdField.setPrimaryKey(true);
		k3VoucherIdField.setHidden(true);

		codeTypeField = new DataSourceIntegerField("codeType", "科目类型");
		codeTypeField.setRequired(false);
		codeTypeField.setLength(11);
		codeTypeField.setHidden(false);

		codeIdField = new DataSourceIntegerField("codeId", "科目编码");
		codeIdField.setRequired(false);
		codeIdField.setLength(11);
		codeIdField.setHidden(false);

		secondaryCodeTypeField = new DataSourceIntegerField("secondaryCodeType", "辅助核算类型");
		secondaryCodeTypeField.setRequired(false);
		secondaryCodeTypeField.setLength(11);
		secondaryCodeTypeField.setHidden(false);

		secondaryCodeIdField = new DataSourceIntegerField("secondaryCodeId", "辅助核算编码");
		secondaryCodeIdField.setRequired(false);
		secondaryCodeIdField.setLength(11);
		secondaryCodeIdField.setHidden(false);

		debitSideField = new DataSourceFloatField("debitSide", "借方");
		debitSideField.setRequired(true);
		debitSideField.setLength(18);
		debitSideField.setHidden(false);

		creditSideField = new DataSourceFloatField("creditSide", "贷方");
		creditSideField.setRequired(true);
		creditSideField.setLength(18);
		creditSideField.setHidden(false);

		lockedField = new DataSourceBooleanField("locked", "是否锁定");
		lockedField.setRequired(false);
		lockedField.setHidden(false);

		linkIdField = new DataSourceIntegerField("linkId", "关联编码");
		linkIdField.setRequired(false);
		linkIdField.setLength(11);
		linkIdField.setHidden(false);

		voucherTypeField = new DataSourceIntegerField("voucherType", "凭证类型 1报销  2发票  3回款 4收入");
		voucherTypeField.setRequired(false);
		voucherTypeField.setLength(11);
		voucherTypeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "主订单名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

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


		setFields(minCreateTimeField, maxCreateTimeField, minUpdateTimeField, maxUpdateTimeField, minVestingDateField, maxVestingDateField, codeField, nameField, secondaryCodeField, secondaryNameField, remarkField, simplifyRemarkField, additionalLinkIdField, k3VoucherIdField, codeTypeField, codeIdField, secondaryCodeTypeField, secondaryCodeIdField, debitSideField, creditSideField, lockedField, linkIdField, voucherTypeField, contractNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

