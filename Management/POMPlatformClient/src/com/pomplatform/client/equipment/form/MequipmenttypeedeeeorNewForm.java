package com.pomplatform.client.equipment.form;

import java.util.*;

import com.pomplatform.client.mfinancialaccounting.form.MfinancialAccountingSearchForm;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.equipment.datasource.DSMequipmenttypeedeeeor;

public class MequipmenttypeedeeeorNewForm extends AbstractWizadPage
{


	private final ComboBoxItem nameItem;
	private final TextItem priceItem;
	private final SelectItem typeItem;
	private final DateItem updateTimeItem;
	private final TextItem updatePersonItem;
	private final TextItem countItem;
	private final TextItem equipmentTypeIdItem;


	public MequipmenttypeedeeeorNewForm() {
		DSMequipmenttypeedeeeor ds = DSMequipmenttypeedeeeor.getInstance();
		__form.setWidth100();
		__form.setHeight100();

		equipmentTypeIdItem = new TextItem("equipmentTypeId", "物品id");
		equipmentTypeIdItem.hide();


		/*employeeIdItem = new ComboBoxItem("employeeId", "职员姓名");
//		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees",employeeIdItem);
		employeeIdItem.setWidth("*");
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);*/

		nameItem = new ComboBoxItem("name", "物品名称");
		priceItem = new TextItem("price", "单价");
		typeItem = new SelectItem("type", "物品类型");
		Map map = KeyValueManager.getValueMap("equipment_types_all");
		nameItem.setValueMap(map);
		nameItem.addChangedHandler(new ChangedHandler(){
			@Override
			public void onChanged(ChangedEvent event) {
				if(map.containsKey(event.getValue())){
					equipmentTypeIdItem.setValue(event.getValue());
					priceItem.setValue(KeyValueManager.getValueMap("equipment_price").get(event.getValue()));
					priceItem.setDisabled(true);
					typeItem.setValue(KeyValueManager.getValueMap("equipment_type").get(event.getValue()));
					typeItem.setDisabled(true);

				}/*else if(KeyValueManager.getValueMap("equipment_types_2").containsValue(event.getValue())){
					SC.say("此物品已被禁用！");
					nameItem.setValue("");
				}*/else{
					equipmentTypeIdItem.setValue((String) null);
					priceItem.setDisabled(false);
					typeItem.setDisabled(false);
				}
			}
		});

		__formItems.add(equipmentTypeIdItem);

		nameItem.setWidth("*");
		__formItems.add(nameItem);

		priceItem.setWidth("*");
		__formItems.add(priceItem);

		typeItem.setWidth("*");
		typeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_254"));
		__formItems.add(typeItem);
		updateTimeItem = new DateItem("updateTime", "操作时间");
		updateTimeItem.setValue(new Date());
		updateTimeItem.setHidden(true);
		__formItems.add(updateTimeItem);

		updatePersonItem = new TextItem("updatePerson", "最近操作人");
		//获取当前登录人id存入
		updatePersonItem.setDefaultValue(ClientUtil.getUserId());
		updatePersonItem.setHidden(true);
		__formItems.add(updatePersonItem);

		countItem = new TextItem("count", "数量");
		countItem.setWidth("*");
		__formItems.add(countItem);


		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSMequipmenttypeedeeeor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public Map getValuesAsMap() {
		return __form.getValues();
	}


}
