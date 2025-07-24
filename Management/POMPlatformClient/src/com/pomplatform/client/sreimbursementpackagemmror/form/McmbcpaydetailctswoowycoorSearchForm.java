package com.pomplatform.client.sreimbursementpackagemmror.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.sreimbursementpackagemmror.datasource.CDMcmbcpaydetailctswoowycoor;

public class McmbcpaydetailctswoowycoorSearchForm extends SearchForm
{


	private final TextItem cmbcPaymentIdItem;
	private final TextItem typeItem;
	private final SelectItem statusItem;
	private final TextItem withdrawFlagItem;
	private final TextItem objectIdItem;
	private final TextItem objectTypeItem;
	private final TextItem withdrawStatusItem;
	private final TextItem yurrefItem;
	private final TextItem cmbcPayDetailIdItem;
	private final TextItem oriYurrefItem;

	public McmbcpaydetailctswoowycoorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMcmbcpaydetailctswoowycoor.getInstance());
		cmbcPaymentIdItem = new TextItem("cmbcPaymentId", "支付总表编码");
		typeItem = new TextItem("type", "类型 1支付 2代发工资 3代发奖金 4代发其他 5 内部转账");
		statusItem = new SelectItem("status", "状态 1数据录入(等待处理) 2 成功 3失败 4撤销 5退票");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_39"));
		withdrawFlagItem = new TextItem("withdrawFlag", "退单标志  1 为正常支付单 2为退单重新支付单");
		objectIdItem = new TextItem("objectId", "员工或者收款单位主键");
		objectTypeItem = new TextItem("objectType", "1员工  2收款单位");
		withdrawStatusItem = new TextItem("withdrawStatus", "退单发起状态 1待资料补正 2可提起支付  3已提起支付");
		yurrefItem = new TextItem("yurref", "业务参考号");
		cmbcPayDetailIdItem = new TextItem("cmbcPayDetailId", "主键");
		oriYurrefItem = new TextItem("oriYurref", "退单原始业务参考号");

		setItems(cmbcPaymentIdItem, typeItem, statusItem, withdrawFlagItem, objectIdItem, objectTypeItem, withdrawStatusItem, yurrefItem, cmbcPayDetailIdItem, oriYurrefItem);

		setNumCols(20);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
