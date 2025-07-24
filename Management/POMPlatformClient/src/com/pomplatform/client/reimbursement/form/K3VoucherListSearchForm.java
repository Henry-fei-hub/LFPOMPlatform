package com.pomplatform.client.reimbursement.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.reimbursement.datasource.CDK3VoucherList;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class K3VoucherListSearchForm extends SearchForm
{


	private final TextItem reimbursementPackageCodeItem;
	private final CheckboxItem lockedItem;
	private final DateItem endDateItem;
	private final DateItem startDateItem;
	private final CheckboxItem needToChangeItem;
	private final TextItem secondaryCodeItem;
	private final TextItem codeItem;
	private final SelectItem companyIdItem;

	public K3VoucherListSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDK3VoucherList.getInstance());
		reimbursementPackageCodeItem = new TextItem("reimbursementPackageCode", "报销汇总编号");
		reimbursementPackageCodeItem.setWidth("*");
		
		lockedItem = new CheckboxItem("locked", "是否定稿");
		
		endDateItem = new DateItem("endDate", "结束归属日期");
		endDateItem.setWidth("*");
		
		startDateItem = new DateItem("startDate", "开始归属日期");
		startDateItem.setWidth("*");
		
		needToChangeItem = new CheckboxItem("needToChange", "需要调整");
		
		secondaryCodeItem = new TextItem("secondaryCode", "辅助核算代码");
		secondaryCodeItem.setWidth("*");
		
		codeItem = new TextItem("code", "科目代码");
		codeItem.setWidth("*");
		
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setWidth("*");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));

		setItems(reimbursementPackageCodeItem, companyIdItem, codeItem, secondaryCodeItem, startDateItem, endDateItem, needToChangeItem, lockedItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
