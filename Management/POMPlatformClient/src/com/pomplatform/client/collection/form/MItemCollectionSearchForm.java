package com.pomplatform.client.collection.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.collection.datasource.CDMItemCollection;

public class MItemCollectionSearchForm extends SearchForm
{

    private final BooleanItem hasContractParagraphItem;
	private final DateTimeItem minCreateTimeItem;
	private final DateTimeItem maxCreateTimeItem;
	private final SelectItem moneyAttributeItem;
	private final SelectItem selfNameItem;
	private final TextItem otherNameItem;
	private final TextItem otherBankAccountItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;

	public MItemCollectionSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMItemCollection.getInstance());
		hasContractParagraphItem=new BooleanItem("hasContractParagraph", "有回款");
		hasContractParagraphItem.setWidth("*");
		
		minCreateTimeItem = new DateTimeItem("minCreateTime", "最早创建时间");
		minCreateTimeItem.setWidth("*");
		minCreateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minCreateTimeItem);
			}
		});
		maxCreateTimeItem = new DateTimeItem("maxCreateTime", "最晚创建时间");
		maxCreateTimeItem.setWidth("*");
		maxCreateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxCreateTimeItem);
			}
		});
		moneyAttributeItem = new SelectItem("moneyAttribute", "款项属性");
		moneyAttributeItem.setWidth("*");
		moneyAttributeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_55"));
		selfNameItem = new SelectItem("selfName", "内部公司(收款方)");
		selfNameItem.setWidth("*");
		selfNameItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_54"));
		otherNameItem = new TextItem("otherName", "对方名称(付款方)");
		otherNameItem.setWidth("*");
		otherBankAccountItem = new TextItem("otherBankAccount", "银行账号(付款方)");
		otherBankAccountItem.setWidth("*");
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		setItems(hasContractParagraphItem,minCreateTimeItem, maxCreateTimeItem, moneyAttributeItem, selfNameItem, otherNameItem, otherBankAccountItem, contractCodeItem, contractNameItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
