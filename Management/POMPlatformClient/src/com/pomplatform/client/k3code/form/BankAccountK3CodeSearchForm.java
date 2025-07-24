package com.pomplatform.client.k3code.form;

import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.k3code.datasource.CDBankAccountK3Code;
import com.pomplatform.client.k3code.datasource.DSAllCardManage;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;

public class BankAccountK3CodeSearchForm extends SearchForm
{


	private final ComboBoxItem businessIdItem;
	private final TextItem k3CodeItem;

	public BankAccountK3CodeSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDBankAccountK3Code.getInstance());
		
		//银行卡信息字段
		ListGridField cardManageIdField = new ListGridField("cardManageId");
		ListGridField bankAccountField = new ListGridField("bankAccount");
		ListGridField bankAddressField = new ListGridField("bankAddress");
		
		businessIdItem = new ComboBoxItem("businessId", "银行账号");
		businessIdItem.setWidth("*");
		businessIdItem.setChangeOnKeypress(false);
		businessIdItem.setOptionDataSource(DSAllCardManage.getInstance());
		Criteria condition = new Criteria();
		condition.addCriteria("objectType", 2);
		condition.addCriteria("enabled", true);
		businessIdItem.setPickListCriteria(condition);
		businessIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		businessIdItem.setValueField(cardManageIdField.getName());
		businessIdItem.setDisplayField(bankAddressField.getName());
		businessIdItem.setPickListFields(bankAddressField, bankAccountField);
				
		k3CodeItem = new TextItem("k3Code", "K3代码");
		k3CodeItem.setWidth("*");

		setItems(businessIdItem, k3CodeItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
