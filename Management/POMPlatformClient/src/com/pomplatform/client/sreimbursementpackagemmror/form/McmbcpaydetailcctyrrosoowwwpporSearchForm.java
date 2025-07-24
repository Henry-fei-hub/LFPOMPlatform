package com.pomplatform.client.sreimbursementpackagemmror.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.sreimbursementpackagemmror.datasource.CDMcmbcpaydetailcctyrrosoowwwppor;

public class McmbcpaydetailcctyrrosoowwwpporSearchForm extends SearchForm
{


	private final TextItem cmbcPayDetailIdItem;
	private final TextItem typeItem;
	private final TextItem yurrefItem;
	private final TextItem reimbursementPackageSummaryIdItem;
	private final TextItem reimbursementPackageIdItem;
	private final TextItem operatorItem;
	private final SelectItem statusItem;
	private final TextItem objectIdItem;
	private final TextItem objectTypeItem;
	private final TextItem withdrawFlagItem;
	private final TextItem withdrawOriginIdItem;
	private final TextItem withdrawStatusItem;
	private final TextItem payResultItem;
	private final TextItem payStatusItem;

	public McmbcpaydetailcctyrrosoowwwpporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMcmbcpaydetailcctyrrosoowwwppor.getInstance());
		cmbcPayDetailIdItem = new TextItem("cmbcPayDetailId", "主键");
		typeItem = new TextItem("type", "类型 1支付 2代发工资 3代发奖金 4代发其他 5 内部转账");
		yurrefItem = new TextItem("yurref", "业务参考号");
		reimbursementPackageSummaryIdItem = new TextItem("reimbursementPackageSummaryId", "报销打包汇总表编码");
		reimbursementPackageIdItem = new TextItem("reimbursementPackageId", "报销打包表编码");
		operatorItem = new TextItem("operator", "operator");
		statusItem = new SelectItem("status", "状态 1数据录入(等待处理) 2 成功 3失败 4撤销 5退票");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_39"));
		objectIdItem = new TextItem("objectId", "员工或者收款单位主键");
		objectTypeItem = new TextItem("objectType", "1员工  2收款单位");
		withdrawFlagItem = new TextItem("withdrawFlag", "退单标志  1 为正常支付单 2为退单重新支付单");
		withdrawOriginIdItem = new TextItem("withdrawOriginId", "退单来源主键");
		withdrawStatusItem = new TextItem("withdrawStatus", "退单发起状态 1待资料补正 2可提起支付  3已提起支付");
		payResultItem = new TextItem("payResult", "4失败");
		payStatusItem = new TextItem("payStatus", "3支付完成(已返回处理结果)");

		setItems(cmbcPayDetailIdItem, typeItem, yurrefItem, reimbursementPackageSummaryIdItem, reimbursementPackageIdItem, operatorItem, statusItem, objectIdItem, objectTypeItem, withdrawFlagItem, withdrawOriginIdItem, withdrawStatusItem, payResultItem, payStatusItem);

		setNumCols(28);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
