package com.pomplatform.client.revenuevoucher.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.revenuevoucher.datasource.CDRevenueVoucher;

public class RevenueVoucherSearchForm extends SearchForm
{


	private final DateTimeItem minCreateTimeItem;
	private final DateTimeItem maxCreateTimeItem;
	private final DateTimeItem minUpdateTimeItem;
	private final DateTimeItem maxUpdateTimeItem;
	private final DateItem minVestingDateItem;
	private final DateItem maxVestingDateItem;
	private final TextItem codeItem;
	private final TextItem nameItem;
	private final TextItem secondaryCodeItem;
	private final TextItem secondaryNameItem;
	private final TextItem remarkItem;
	private final TextItem simplifyRemarkItem;
	private final TextItem additionalLinkIdItem;
	private final TextItem k3VoucherIdItem;
	private final TextItem codeTypeItem;
	private final TextItem codeIdItem;
	private final TextItem secondaryCodeTypeItem;
	private final TextItem secondaryCodeIdItem;
	private final TextItem debitSideItem;
	private final TextItem creditSideItem;
	private final CheckboxItem lockedItem;
	private final TextItem linkIdItem;
	private final TextItem voucherTypeItem;
	private final TextItem contractNameItem;

	public RevenueVoucherSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDRevenueVoucher.getInstance());
		minCreateTimeItem = new DateTimeItem("minCreateTime", "最早创建时间");
		minCreateTimeItem.hide();
		minCreateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minCreateTimeItem);
			}
		});
		maxCreateTimeItem = new DateTimeItem("maxCreateTime", "最晚创建时间");
		maxCreateTimeItem.hide();
		maxCreateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxCreateTimeItem);
			}
		});
		minUpdateTimeItem = new DateTimeItem("minUpdateTime", "最早修改时间");
		minUpdateTimeItem.hide();
		minUpdateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minUpdateTimeItem);
			}
		});
		maxUpdateTimeItem = new DateTimeItem("maxUpdateTime", "最晚修改时间");
		maxUpdateTimeItem.hide();
		maxUpdateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxUpdateTimeItem);
			}
		});
		minVestingDateItem = new DateItem("minVestingDate", "最早归属日期");
		minVestingDateItem.setWidth("*");
		minVestingDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minVestingDateItem);
			}
		});
		maxVestingDateItem = new DateItem("maxVestingDate", "最晚归属日期");
		maxVestingDateItem.setWidth("*");
		maxVestingDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxVestingDateItem);
			}
		});
		codeItem = new TextItem("code", "科目代码");
		codeItem.setWidth("*");
		
		nameItem = new TextItem("name", "科目名称");
		nameItem.setWidth("*");
		
		secondaryCodeItem = new TextItem("secondaryCode", "辅助核算代码");
		secondaryCodeItem.setWidth("*");
		secondaryCodeItem.hide();
		
		secondaryNameItem = new TextItem("secondaryName", "辅助核算名称");
		secondaryNameItem.setWidth("*");
		secondaryNameItem.hide();
		
		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");
		
		simplifyRemarkItem = new TextItem("simplifyRemark", "简化备注");
		simplifyRemarkItem.setWidth("*");
		simplifyRemarkItem.hide();
		
		additionalLinkIdItem = new TextItem("additionalLinkId", "区域");
		additionalLinkIdItem.hide();
		k3VoucherIdItem = new TextItem("k3VoucherId", "主键编码");
		k3VoucherIdItem.hide();
		codeTypeItem = new TextItem("codeType", "科目类型");
		codeTypeItem.hide();
		codeIdItem = new TextItem("codeId", "科目编码");
		codeIdItem.hide();
		
		secondaryCodeTypeItem = new TextItem("secondaryCodeType", "辅助核算类型");
		secondaryCodeTypeItem.hide();
		secondaryCodeIdItem = new TextItem("secondaryCodeId", "辅助核算编码");
		secondaryCodeIdItem.hide();
		debitSideItem = new TextItem("debitSide", "借方");
		debitSideItem.setWidth("*");
		creditSideItem = new TextItem("creditSide", "贷方");
		creditSideItem.setWidth("*");
		lockedItem = new CheckboxItem("locked", "是否锁定");
		lockedItem.hide();
		linkIdItem = new TextItem("linkId", "关联编码");
		linkIdItem.hide();
		voucherTypeItem = new TextItem("voucherType", "凭证类型 1报销  2发票  3回款 4收入");
		voucherTypeItem.hide();
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		setItems(minCreateTimeItem, maxCreateTimeItem, minUpdateTimeItem, maxUpdateTimeItem, minVestingDateItem, maxVestingDateItem, codeItem, nameItem, secondaryCodeItem, secondaryNameItem, remarkItem, simplifyRemarkItem, additionalLinkIdItem, k3VoucherIdItem, codeTypeItem, codeIdItem, secondaryCodeTypeItem, secondaryCodeIdItem, debitSideItem, creditSideItem, lockedItem, linkIdItem, voucherTypeItem, contractNameItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
