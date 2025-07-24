package com.pomplatform.client.sreceiveunitmanagemmror.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.sreceiveunitmanagemmror.datasource.CDSreceiveunitmanagemmror;

public class SreceiveunitmanagemmrorSearchForm extends SearchForm
{


	private final DateTimeItem minOperateTimeItem;
	private final DateTimeItem maxOperateTimeItem;
	private final TextItem receiveUnitItem;
	private final TextItem bankAccountItem;
	private final TextItem bankNameItem;
	private final TextItem receiveUnitAddressItem;
	private final TextItem receiveUnitManageIdItem;
	private final TextItem operateEmployeeIdItem;
	private final TextItem originItem;
	private final SelectItem voucherTypeItem;

	public SreceiveunitmanagemmrorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSreceiveunitmanagemmror.getInstance());
		minOperateTimeItem = new DateTimeItem("minOperateTime", "最早操作时间");
		minOperateTimeItem.hide();
		minOperateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minOperateTimeItem);
			}
		});
		maxOperateTimeItem = new DateTimeItem("maxOperateTime", "最晚操作时间");
		maxOperateTimeItem.hide();
		maxOperateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxOperateTimeItem);
			}
		});
		receiveUnitItem = new TextItem("receiveUnit", "收款单位");
		receiveUnitItem.setWidth("*");
		bankAccountItem = new TextItem("bankAccount", "银行账号");
		bankAccountItem.setWidth("*");
		bankNameItem = new TextItem("bankName", "开户行");
		bankNameItem.setWidth("*");
		receiveUnitAddressItem = new TextItem("receiveUnitAddress", "收款单位所在地");
		receiveUnitAddressItem.setWidth("*");
		receiveUnitManageIdItem = new TextItem("receiveUnitManageId", "主键编码");
		receiveUnitManageIdItem.hide();
		operateEmployeeIdItem = new TextItem("operateEmployeeId", "操作人");
		operateEmployeeIdItem.hide();
		originItem = new TextItem("origin", "来源");
		originItem.hide();
		
		voucherTypeItem = new SelectItem("voucherType", "凭证类型");
		voucherTypeItem.setWidth("*");
		voucherTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_227"));

		setItems(minOperateTimeItem, maxOperateTimeItem, receiveUnitItem, bankAccountItem, bankNameItem, receiveUnitAddressItem, receiveUnitManageIdItem, operateEmployeeIdItem, originItem, voucherTypeItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
