package com.pomplatform.client.payseqaddinfo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.payseqaddinfo.datasource.CDPaySeqAddInfo;

public class PaySeqAddInfoSearchForm extends SearchForm
{


	private final TextItem budgetManagementIdItem;
	private final TextItem budgetAttachmentIdItem;
	private final TextItem payAmountItem;
	private final DateTimeItem payDateItem;
	private final TextItem payStatusItem;
	private final TextItem psRemarkItem;
	private final TextItem yearItem;
	private final TextItem monthItem;
	private final TextItem receiveUnitManageIdItem;
	private final TextItem processBillListIdItem;
	private final TextItem projectIdItem;
	private final TextItem bindStatusItem;
	private final TextItem payTypeItem;
	private final CheckboxItem isLockItem;
	private final TextItem reimbursementAmountItem;
	private final TextItem reverseAmountItem;
	private final DateTimeItem applyPayDateItem;
	private final TextItem returnAmountItem;

	public PaySeqAddInfoSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDPaySeqAddInfo.getInstance());
		budgetManagementIdItem = new TextItem("budgetManagementId", "预算管理id");
		budgetAttachmentIdItem = new TextItem("budgetAttachmentId", "预算附件id");
		payAmountItem = new TextItem("payAmount", "付款金额");
		payDateItem = new DateTimeItem("payDate", "付款日期");
		payDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, payDateItem);
			}
		});
		payStatusItem = new TextItem("payStatus", "付款状态(1未付款,2已付款,3付款申请中)");
		psRemarkItem = new TextItem("psRemark", "付款序列备注");
		yearItem = new TextItem("year", "年");
		monthItem = new TextItem("month", "月");
		receiveUnitManageIdItem = new TextItem("receiveUnitManageId", "收款单位编码");
		processBillListIdItem = new TextItem("processBillListId", "流水编码");
		projectIdItem = new TextItem("projectId", "项目id");
		bindStatusItem = new TextItem("bindStatus", "绑定状态 0.未绑定，1.已绑定");
		payTypeItem = new TextItem("payType", "付款类型");
		isLockItem = new CheckboxItem("isLock", "是否加锁");
		reimbursementAmountItem = new TextItem("reimbursementAmount", "报销金额");
		reverseAmountItem = new TextItem("reverseAmount", "冲账金额");
		applyPayDateItem = new DateTimeItem("applyPayDate", "付款申请日期");
		applyPayDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, applyPayDateItem);
			}
		});
		returnAmountItem = new TextItem("returnAmount", "还款金额");

		setItems(budgetManagementIdItem, budgetAttachmentIdItem, payAmountItem, payDateItem, payStatusItem, psRemarkItem, yearItem, monthItem, receiveUnitManageIdItem, processBillListIdItem, projectIdItem, bindStatusItem, payTypeItem, isLockItem, reimbursementAmountItem, reverseAmountItem, applyPayDateItem, returnAmountItem);

		setNumCols(36);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
