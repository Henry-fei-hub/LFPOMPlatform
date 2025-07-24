package com.pomplatform.client.k3code.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.k3code.datasource.CDReceiveUnitK3Code;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class ReceiveUnitK3CodeSearchForm extends SearchForm
{


	private final ComboBoxItem businessIdItem;
	private final TextItem bankAccountItem;
	private final TextItem k3CodeItem;
	private final TextItem receiveUnitItem;
	private final DateItem operateStartTimeItem;
	private final DateItem operateEndTimeItem;
	private final DateItem updateStartTimeItem;
	private final DateItem updateEndTimeItem;
	

	public ReceiveUnitK3CodeSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDReceiveUnitK3Code.getInstance());
		
		businessIdItem = new ComboBoxItem("businessId", "收款单位");
		businessIdItem.hide();
		businessIdItem.setWidth("*");
//		businessIdItem.setValueMap(KeyValueManager.getValueMap("receive_unit_manages_company"));
		KeyValueManager.loadValueMap("receive_unit_manages_company",businessIdItem);
		businessIdItem.setChangeOnKeypress(false);
		businessIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		
		receiveUnitItem = new TextItem("receiveUnit", "收款单位");
		receiveUnitItem.setWidth("*");
		
		bankAccountItem = new TextItem("bankAccount", "银行账号");
		bankAccountItem.setWidth("*");
		
		k3CodeItem = new TextItem("k3Code", "K3代码");
		k3CodeItem.setWidth("*");

		operateStartTimeItem = new DateItem("operateStartTime", "创建时间(开始)");
		operateStartTimeItem.setUseTextField(true);
		operateStartTimeItem.setUseMask(true);
		operateStartTimeItem.setWidth("*");
		
		operateEndTimeItem = new DateItem("operateEndTime", "创建时间(截止)");
		operateEndTimeItem.setUseTextField(true);
		operateEndTimeItem.setUseMask(true);
		operateEndTimeItem.setWidth("*");
		
		updateStartTimeItem = new DateItem("updateStartTime", "修改时间(开始)");
		updateStartTimeItem.setUseTextField(true);
		updateStartTimeItem.setUseMask(true);
		updateStartTimeItem.setWidth("*");
		
		updateEndTimeItem = new DateItem("updateEndTime", "修改时间(截止)");
		updateEndTimeItem.setUseTextField(true);
		updateEndTimeItem.setUseMask(true);
		updateEndTimeItem.setWidth("*");
		
		setItems(operateStartTimeItem, operateEndTimeItem, updateStartTimeItem, updateEndTimeItem, receiveUnitItem, bankAccountItem, k3CodeItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
