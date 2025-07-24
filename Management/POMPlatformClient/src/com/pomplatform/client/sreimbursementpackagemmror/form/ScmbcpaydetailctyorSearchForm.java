package com.pomplatform.client.sreimbursementpackagemmror.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.sreimbursementpackagemmror.datasource.CDScmbcpaydetailctyor;

public class ScmbcpaydetailctyorSearchForm extends SearchForm
{


	private final TextItem cmbcPayDetailIdItem;
	private final TextItem typeItem;
	private final TextItem yurrefItem;
	private final TextItem reimbursementPackageSummaryIdItem;
	private final TextItem reimbursementPackageIdItem;
	private final SelectItem statusItem;

	public ScmbcpaydetailctyorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDScmbcpaydetailctyor.getInstance());
		cmbcPayDetailIdItem = new TextItem("cmbcPayDetailId", "主键");
		typeItem = new TextItem("type", "类型 1支付 2代发工资 3代发奖金 4代发其他 5 内部转账");
		yurrefItem = new TextItem("yurref", "业务参考号");
		reimbursementPackageSummaryIdItem = new TextItem("reimbursementPackageSummaryId", "报销打包汇总表编码");
		reimbursementPackageIdItem = new TextItem("reimbursementPackageId", "报销打包表编码");
		statusItem = new SelectItem("status", "状态");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_39"));

		setItems(cmbcPayDetailIdItem, typeItem, yurrefItem, reimbursementPackageSummaryIdItem, reimbursementPackageIdItem, statusItem);

		setNumCols(12);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
