package com.pomplatform.client.k3voucher.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.k3voucher.datasource.CDInsuranceAndHousingFundK3Voucher;

public class InsuranceAndHousingFundK3VoucherSearchForm extends SearchForm
{


	private final SelectItem companyIdItem;
	private final SelectItem yearItem;
	private final SelectItem monthItem;
	private final CheckboxItem lockedItem;
	private final TextItem voucherTypeItem;

	public InsuranceAndHousingFundK3VoucherSearchForm() {
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
		
		lockedItem = new CheckboxItem("locked", "是否定稿");
		
		voucherTypeItem = new TextItem("voucherType", "凭证类型");
		voucherTypeItem.hide();

		setItems(companyIdItem, yearItem, monthItem, lockedItem, voucherTypeItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
