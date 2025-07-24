package com.pomplatform.client.k3voucher.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.k3voucher.datasource.CDGenerateCapitalVoucher;

public class GenerateCapitalVoucherSearchForm extends SearchForm
{


	private final ComboBoxItem moneyAttributeItem;
	private final TextItem yearItem;
	private final TextItem monthItem;
//	private final CheckboxItem haveVoucherItem;
	private final ComboBoxItem selfNameItem;

	public GenerateCapitalVoucherSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDGenerateCapitalVoucher.getInstance());
		
		moneyAttributeItem = new ComboBoxItem("moneyAttribute", "款项属性");
		moneyAttributeItem.setChangeOnKeypress(false);
		moneyAttributeItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		moneyAttributeItem.setWidth("*");
		moneyAttributeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_55"));
		
		yearItem = new TextItem("year", "发生年份");
		yearItem.setWidth("*");
		
		monthItem = new TextItem("month", "发生月份");
		monthItem.setWidth("*");
		
//		haveVoucherItem = new CheckboxItem("haveVoucher", "是否有凭证");
		selfNameItem = new ComboBoxItem("selfName", "内部公司(收款方)");
		selfNameItem.setChangeOnKeypress(false);
		selfNameItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		selfNameItem.setWidth("*");
		selfNameItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));

		setItems(moneyAttributeItem, selfNameItem, yearItem, monthItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
