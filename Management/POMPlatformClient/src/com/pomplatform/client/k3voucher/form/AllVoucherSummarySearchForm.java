package com.pomplatform.client.k3voucher.form;

import java.util.Date;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.k3voucher.datasource.CDAllVoucherSummary;
import com.smartgwt.client.util.DateUtil;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class AllVoucherSummarySearchForm extends SearchForm
{


	private final SelectItem voucherTypeItem;
	private final TextItem voucherYearItem;
	private final TextItem voucherMonthItem;
	private final SelectItem companyIdItem;
	private final TextItem sequenceNumberItem;
	private final TextItem reimbursementPackageCodeItem;

	public AllVoucherSummarySearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDAllVoucherSummary.getInstance());
		
		voucherTypeItem = new SelectItem("voucherType", "凭证类型");
		voucherTypeItem.setWidth("*");
		voucherTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_117"));
		
		Date date = new Date();
		voucherYearItem = new TextItem("voucherYear", "凭证年份");
		voucherYearItem.setWidth("*");
		voucherYearItem.setValue(DateUtil.getDisplayYear(date));
		
		voucherMonthItem = new TextItem("voucherMonth", "凭证月份");
		voucherMonthItem.setWidth("*");
		voucherMonthItem.setValue(DateUtil.getDisplayMonth(date) + 1);
		
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setWidth("*");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));

		sequenceNumberItem = new TextItem("sequenceNumber", "凭证号");
		sequenceNumberItem.setWidth("*");
		
		reimbursementPackageCodeItem = new TextItem("reimbursementPackageCode", "编号");
		reimbursementPackageCodeItem.setWidth("*");
		
		setItems(voucherTypeItem, companyIdItem, voucherYearItem, voucherMonthItem, sequenceNumberItem, reimbursementPackageCodeItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
