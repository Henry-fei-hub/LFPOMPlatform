package com.pomplatform.client.receivables.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.receivables.datasource.DSMcapitalecoosmeor;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.BooleanItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class McapitalecoosmeorGroupname1Update extends AbstractWizadPage {

	private final SelectItem moneyAttributeItem;
	private final ComboBoxItem contractIdItem;
	private final ComboBoxItem contractNameItem;
	private final BooleanItem recordReceiveCapitalItem;
	private final DateItem issueDateItem;
	private final DateItem expireDateItem;

	public McapitalecoosmeorGroupname1Update() {
		DSMcapitalecoosmeor ds = DSMcapitalecoosmeor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		moneyAttributeItem = new SelectItem("moneyAttribute", "款项属性");
		moneyAttributeItem.setWidth("*");
		moneyAttributeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_55"));
		__formItems.add(moneyAttributeItem);
//		int value = BaseHelpUtils.getIntValue(moneyAttributeItem.getValue());
//			if (value == 11){
//				McapitalecoosmeorGroupname2New.uploadButton.show();
//				McapitalecoosmeorGroupname2New.capitalAtttachmentItem.show();
//			}

		contractIdItem = new ComboBoxItem("contractId", "选择合同");
		contractIdItem.setWidth("*");
		contractIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
//		contractIdItem.setValueMap(KeyValueManager.getValueMap("contracts_2"));
		KeyValueManager.loadValueMap("contracts_2",contractIdItem);
		contractIdItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				int id = BaseHelpUtils.getIntValue(event.getValue());

				__form.getItem("contractName").setValue(id);
			}
		});
		__formItems.add(contractIdItem);

		contractNameItem = new ComboBoxItem("contractName", "合同名称");
		contractNameItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		contractNameItem.setWidth("*");
		contractNameItem.setDefaultValue(id);
//		contractNameItem.setValueMap(KeyValueManager.getValueMap("contracts_1"));
		KeyValueManager.loadValueMap("contracts_1", contractNameItem);
		contractNameItem.addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				int id = BaseHelpUtils.getIntValue(event.getValue());
				__form.getItem("contractId").setValue(id);
			}
		});
		__formItems.add(contractNameItem);
		
		recordReceiveCapitalItem = new BooleanItem("recordReceiveCapital", "是否记录统计回款(勾选表示为是)");
		recordReceiveCapitalItem.setWidth("*");
		__formItems.add(recordReceiveCapitalItem);
		
		issueDateItem = new DateItem("issueDate", "出票日期");
		issueDateItem.setWidth("*");
		issueDateItem.setUseMask(true);
		__formItems.add(issueDateItem);
		
		expireDateItem = new DateItem("expireDate", "到期日");
		expireDateItem.setWidth("*");
		expireDateItem.setUseMask(true);
		__formItems.add(expireDateItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		setName("合同信息");
		addMember(__form);
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSMcapitalecoosmeor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if (getRecord() != null)
			__form.editRecord(getRecord());
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}

}
