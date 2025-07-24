package com.pomplatform.client.k3voucher.form;

import java.util.Date;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.k3voucher.datasource.CDInsuranceAndHousingFundK3Voucher;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class SalaryK3VoucherSearchForm extends SearchForm
{


	private final SelectItem companyIdItem;
	private final SelectItem yearItem;
	private final SelectItem monthItem;
	private final CheckboxItem lockedItem;
	private final TextItem voucherTypeItem;
	private final SelectItem projectIdItem;

	public SalaryK3VoucherSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDInsuranceAndHousingFundK3Voucher.getInstance());
		Date date = new Date();
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.setWidth("*");
		
		yearItem = new SelectItem("year", "年份");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		yearItem.setDefaultValue(date.getYear() + 1900);
		yearItem.setWidth("*");
		
		monthItem = new SelectItem("month", "月份");
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		monthItem.setDefaultValue(date.getMonth() + 1);
		monthItem.setWidth("*");
		
		projectIdItem = new SelectItem("projectId", "类型");
		projectIdItem.setWidth("*");
		projectIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_124"));
		
		lockedItem = new CheckboxItem("locked", "是否定稿");
		
		voucherTypeItem = new TextItem("voucherType", "凭证类型");
		voucherTypeItem.hide();

		setItems(companyIdItem, yearItem, monthItem, projectIdItem, lockedItem, voucherTypeItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
