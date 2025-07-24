package com.pomplatform.client.sreimbursementpackagemmror.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.sreimbursementpackagemmror.datasource.CDMCmbcPaymentDetailpor;

public class MCmbcPaymentDetailporSearchForm extends SearchForm
{


	private final TextItem dbtaccItem;
	private final TextItem dbtbbkItem;
	private final TextItem crtaccItem;
	private final TextItem crtnamItem;
	private final TextItem typeItem;
	private final TextItem yurrefItem;
	private final TextItem reimbursementPackageSummaryIdItem;
	private final TextItem reimbursementPackageIdItem;
	private final SelectItem statusItem;
	private final TextItem cmbcPaymentIdItem;

	public MCmbcPaymentDetailporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMCmbcPaymentDetailpor.getInstance());
		dbtaccItem = new TextItem("dbtacc", "付方账号");
		dbtbbkItem = new TextItem("dbtbbk", "付方开户地区代码");
		crtaccItem = new TextItem("crtacc", "收方账号");
		crtnamItem = new TextItem("crtnam", "收方账户名");
		typeItem = new TextItem("type", "类型 1支付 2代发工资 3代发奖金 4代发其他 5 内部转账");
		yurrefItem = new TextItem("yurref", "业务参考号");
		reimbursementPackageSummaryIdItem = new TextItem("reimbursementPackageSummaryId", "报销打包汇总表编码");
		reimbursementPackageIdItem = new TextItem("reimbursementPackageId", "报销打包表编码");
		statusItem = new SelectItem("status", "状态 1数据录入(等待处理) 2 成功 3失败 4撤销 5退票");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_39"));
		cmbcPaymentIdItem = new TextItem("cmbcPaymentId", "支付总表编码");

		setItems(dbtaccItem, dbtbbkItem, crtaccItem, crtnamItem, typeItem, yurrefItem, reimbursementPackageSummaryIdItem, reimbursementPackageIdItem, statusItem, cmbcPaymentIdItem);

		setNumCols(20);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
