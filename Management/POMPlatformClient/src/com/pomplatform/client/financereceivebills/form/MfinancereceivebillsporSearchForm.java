package com.pomplatform.client.financereceivebills.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.financereceivebills.datasource.CDMfinancereceivebillspor;

public class MfinancereceivebillsporSearchForm extends SearchForm {

	private final TextItem financeReceiveBillIdItem;
	private final SelectItem companyIdItem;
	private final ComboBoxItem applicantItem;
	private final TextItem codeItem;
	private final SelectItem processTypeItem;
	private final TextItem businessIdItem;
	private final TextItem amountItem;
	private final ComboBoxItem sendeeItem;
	private final ComboBoxItem handlePersonItem;
	private final TextItem remarkItem;
	private final TextItem detailRemarkItem;
	private final SelectItem receiveStatusItem;
	private final DateTimeItem minCreateTimeItem;
	private final DateTimeItem maxCreateTimeItem;
	private final DateTimeItem minUpdateTimeItem;
	private final DateTimeItem maxUpdateTimeItem;
	private final SelectItem processStatusItem;

	public MfinancereceivebillsporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMfinancereceivebillspor.getInstance());
		financeReceiveBillIdItem = new TextItem("financeReceiveBillId", "主键");
		financeReceiveBillIdItem.hide();

		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setWidth("*");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));

		applicantItem = new ComboBoxItem("applicant", "申请人");
		applicantItem.setValueMap(KeyValueManager.getValueMap("employees"));
		applicantItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		applicantItem.setChangeOnKeypress(false);
		applicantItem.setWidth("*");

		codeItem = new TextItem("code", "报销编号");
		codeItem.setWidth("*");

		processTypeItem = new SelectItem("processType", "报销类型");
		processTypeItem.setWidth("*");
		processTypeItem.setValueMap(KeyValueManager.getValueMap("system_process_types"));

		businessIdItem = new TextItem("businessId", "业务主键");
		businessIdItem.hide();

		amountItem = new TextItem("amount", "金额");
		amountItem.setWidth("*");

		sendeeItem = new ComboBoxItem("sendee", "接收人");
		sendeeItem.setWidth("*");
		sendeeItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		sendeeItem.setChangeOnKeypress(false);
		sendeeItem.setValueMap(KeyValueManager.getValueMap("employees"));

		handlePersonItem = new ComboBoxItem("handlePerson", "处理人");
		handlePersonItem.setWidth("*");
		handlePersonItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		handlePersonItem.setChangeOnKeypress(false);
		handlePersonItem.setValueMap(KeyValueManager.getValueMap("employees"));

		remarkItem = new TextItem("remark", "备注");
		remarkItem.hide();
		detailRemarkItem = new TextItem("detailRemark", "流程明细");
		detailRemarkItem.hide();

		receiveStatusItem = new SelectItem("receiveStatus", "收单状态");
		receiveStatusItem.setWidth("*");
		receiveStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_130"));

		minCreateTimeItem = new DateTimeItem("minCreateTime", "最早创建日期");
		minCreateTimeItem.setWidth("*");
		minCreateTimeItem.hide();
		minCreateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minCreateTimeItem);
			}
		});
		maxCreateTimeItem = new DateTimeItem("maxCreateTime", "最晚创建日期");
		maxCreateTimeItem.setWidth("*");
		maxCreateTimeItem.hide();
		maxCreateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxCreateTimeItem);
			}
		});
		minUpdateTimeItem = new DateTimeItem("minUpdateTime", "最早修改日期");
		minUpdateTimeItem.setWidth("*");
		minUpdateTimeItem.hide();
		minUpdateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minUpdateTimeItem);
			}
		});
		maxUpdateTimeItem = new DateTimeItem("maxUpdateTime", "最晚修改日期");
		maxUpdateTimeItem.setWidth("*");
		maxUpdateTimeItem.hide();
		maxUpdateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxUpdateTimeItem);
			}
		});
		processStatusItem = new SelectItem("processStatus", "流程状态");
		processStatusItem.setWidth("*");
		processStatusItem.setValue(1);
		processStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_120"));

		setItems(financeReceiveBillIdItem, companyIdItem, applicantItem, codeItem, processTypeItem, businessIdItem,
				amountItem, sendeeItem, handlePersonItem, remarkItem, detailRemarkItem, receiveStatusItem,
				minCreateTimeItem, maxCreateTimeItem, minUpdateTimeItem, maxUpdateTimeItem, processStatusItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
