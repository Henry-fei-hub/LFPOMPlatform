package com.pomplatform.client.budgetmanagementworkflow.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.budgetmanagementworkflow.datasource.CDBudgetManagementWorkFlow;

public class BudgetManagementWorkFlowSearchForm extends SearchForm
{


	private final TextItem bdCodeItem;
	private final TextItem bdTypeItem;
	private final TextItem bdTotalAmountItem;
	private final TextItem bdUseAmountItem;
	private final TextItem bdRestAmountItem;
	private final TextItem bdApplyEmployeeIdItem;
	private final DateTimeItem bdApplyTimeItem;
	private final DateTimeItem bdEstimatecloseTimeItem;
	private final TextItem bdStatusItem;
	private final TextItem projectIdItem;
	private final TextItem bdRemarkItem;
	private final TextItem inputTaxInvoiceIdItem;
	private final TextItem departmentIdItem;
	private final TextItem companyIdItem;

	public BudgetManagementWorkFlowSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDBudgetManagementWorkFlow.getInstance());
		bdCodeItem = new TextItem("bdCode", "预算编号");
		bdTypeItem = new TextItem("bdType", "预算类型");
		bdTotalAmountItem = new TextItem("bdTotalAmount", "预算总金额");
		bdUseAmountItem = new TextItem("bdUseAmount", "预算已用金额");
		bdRestAmountItem = new TextItem("bdRestAmount", "预算剩余金额");
		bdApplyEmployeeIdItem = new TextItem("bdApplyEmployeeId", "申请人id");
		bdApplyTimeItem = new DateTimeItem("bdApplyTime", "申请时间");
		bdApplyTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				ClientUtil.searchDateFormat(val, bdApplyTimeItem);
			}
		});
		bdEstimatecloseTimeItem = new DateTimeItem("bdEstimatecloseTime", "预期关闭时间");
		bdEstimatecloseTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				ClientUtil.searchDateFormat(val, bdEstimatecloseTimeItem);
			}
		});
		bdStatusItem = new TextItem("bdStatus", "预算单状态");
		projectIdItem = new TextItem("projectId", "项目编号");
		bdRemarkItem = new TextItem("bdRemark", "预算备注");
		inputTaxInvoiceIdItem = new TextItem("inputTaxInvoiceId", "发票编码");
		departmentIdItem = new TextItem("departmentId", "申请人归属部门");
		companyIdItem = new TextItem("companyId", "申请人归属公司");

		setItems(bdCodeItem, bdTypeItem, bdTotalAmountItem, bdUseAmountItem, bdRestAmountItem, bdApplyEmployeeIdItem, bdApplyTimeItem, bdEstimatecloseTimeItem, bdStatusItem, projectIdItem, bdRemarkItem, inputTaxInvoiceIdItem, departmentIdItem, companyIdItem);

		setNumCols(28);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
