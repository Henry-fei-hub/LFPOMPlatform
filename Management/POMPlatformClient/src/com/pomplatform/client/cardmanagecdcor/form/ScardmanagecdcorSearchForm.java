package com.pomplatform.client.cardmanagecdcor.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.cardmanagecdcor.datasource.CDScardmanagecdcor;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class ScardmanagecdcorSearchForm extends SearchForm {

	private final TextItem cardTypeItem;
	private final CheckboxItem defaultCardItem;
	private final TextItem currencyTypeItem;
	private final TextItem cmbcCodeIdItem;
	private final TextItem bankAccountItem;
	private final TextItem bankAddressItem;
	private final TextItem cardManageIdItem;
	private final SelectItem objectIdItem;
	private final TextItem objectTypeItem;
	private final SelectItem bankIdItem;
	private final CheckboxItem truePaymentItem;

	public ScardmanagecdcorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDScardmanagecdcor.getInstance());
		cardTypeItem = new TextItem("cardType", "2报销卡)");
		cardTypeItem.hide();
		defaultCardItem = new CheckboxItem("defaultCard", "是否为默认卡");

		currencyTypeItem = new TextItem("currencyType", "货币类型");
		currencyTypeItem.hide();

		cmbcCodeIdItem = new TextItem("cmbcCodeId", "招商银行分行代码");
		cmbcCodeIdItem.hide();
		bankAccountItem = new TextItem("bankAccount", "银行账号");
		bankAccountItem.setWidth("*");
		bankAddressItem = new TextItem("bankAddress", "开户行所在地");
		bankAddressItem.setWidth("*");
		cardManageIdItem = new TextItem("cardManageId", "主键编码");
		cardManageIdItem.hide();
		objectIdItem = new SelectItem("objectId", "归属公司");
		objectIdItem.setWidth("*");
		objectIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));

		objectTypeItem = new TextItem("objectType", "2单位)");
		objectTypeItem.hide();
		bankIdItem = new SelectItem("bankId", "开户行");
		bankIdItem.setWidth("*");
		bankIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_68"));
		truePaymentItem = new CheckboxItem("truePayment", "真实收付款");
		truePaymentItem.setWidth("*");

		setItems(cardTypeItem, defaultCardItem, currencyTypeItem, cmbcCodeIdItem, bankAccountItem, bankAddressItem,
				cardManageIdItem, objectIdItem, objectTypeItem, bankIdItem, truePaymentItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
