package com.pomplatform.client.attachmentvoucher.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.attachmentvoucher.datasource.CDAttachmentVoucher;

public class AttachmentVoucherSearchForm extends SearchForm
{


	private final DateItem minVestingDateItem;
	private final DateItem maxVestingDateItem;
	private final DateTimeItem minCreateTimeItem;
	private final DateTimeItem maxCreateTimeItem;
	private final TextItem codeItem;
	private final TextItem nameItem;
	private final TextItem remarkItem;
	private final TextItem simplifyRemarkItem;
	private final TextItem k3VoucherIdItem;
	private final TextItem projectIdItem;
	private final SelectItem companyIdItem;
	private final TextItem sequenceNumberItem;
	private final TextItem internalSequenceNumberItem;
	private final TextItem codeTypeItem;
	private final TextItem codeIdItem;
	private final TextItem linkIdItem;
	private final TextItem voucherTypeItem;
	private final TextItem additionalLinkIdItem;
	private final CheckboxItem lockedItem;
	private final TextItem debitSideItem;
	private final TextItem creditSideItem;
	private final TextItem attachmentNameItem;
	private final TextItem contractIdItem;

	public AttachmentVoucherSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDAttachmentVoucher.getInstance());
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
		codeItem = new TextItem("code", "科目代码");
		codeItem.setWidth("*");
		nameItem = new TextItem("name", "科目名称");
		nameItem.setWidth("*");
		remarkItem = new TextItem("remark", "备注");
		remarkItem.hide();
		simplifyRemarkItem = new TextItem("simplifyRemark", "简化备注");
		simplifyRemarkItem.hide();
		k3VoucherIdItem = new TextItem("k3VoucherId", "主键编码");
		k3VoucherIdItem.hide();
		projectIdItem = new TextItem("projectId", "项目");
		projectIdItem.hide();
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.hide();
		sequenceNumberItem = new TextItem("sequenceNumber", "凭证号");
		sequenceNumberItem.hide();
		internalSequenceNumberItem = new TextItem("internalSequenceNumber", "凭证内序号");
		internalSequenceNumberItem.hide();
		codeTypeItem = new TextItem("codeType", "科目类型");
		codeTypeItem.hide();
		codeIdItem = new TextItem("codeId", "科目编码");
		codeIdItem.hide();
		linkIdItem = new TextItem("linkId", "关联编码");
		linkIdItem.hide();
		voucherTypeItem = new TextItem("voucherType", "凭证类型 1报销  2发票  3回款 4收入 5确认函");
		voucherTypeItem.hide();
		additionalLinkIdItem = new TextItem("additionalLinkId", "附加的关联编码");
		additionalLinkIdItem.hide();
		lockedItem = new CheckboxItem("locked", "是否锁定");
		lockedItem.setWidth("*");
		debitSideItem = new TextItem("debitSide", "借方");
		debitSideItem.setWidth("*");
		creditSideItem = new TextItem("creditSide", "贷方");
		creditSideItem.setWidth("*");
		attachmentNameItem = new TextItem("attachmentName", "确认函名称");
		attachmentNameItem.setWidth("*");
		contractIdItem = new TextItem("contractId", "合同编码");
		contractIdItem.hide();

		setItems(minVestingDateItem, maxVestingDateItem, minCreateTimeItem, maxCreateTimeItem, codeItem, nameItem, remarkItem, simplifyRemarkItem, k3VoucherIdItem, projectIdItem, companyIdItem, sequenceNumberItem, internalSequenceNumberItem, codeTypeItem, codeIdItem, linkIdItem, voucherTypeItem, additionalLinkIdItem, lockedItem, debitSideItem, creditSideItem, attachmentNameItem, contractIdItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
