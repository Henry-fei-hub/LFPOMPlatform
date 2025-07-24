package com.pomplatform.client.equipment.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.equipment.datasource.DSMequipmenttypeedeeeor;

public class MequipmenttypeedeeeorUpdateForm extends AbstractWizadPage
{


	private final TextItem equipmentTypeIdItem;
	private final TextItem nameItem;
	private final CheckboxItem enabledItem;
	private final TextItem priceItem;
	private final SelectItem typeItem;
	private final TextItem countItem;


	public MequipmenttypeedeeeorUpdateForm() {
		DSMequipmenttypeedeeeor ds = DSMequipmenttypeedeeeor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		equipmentTypeIdItem = new TextItem("equipmentTypeId", "设备类型");
		equipmentTypeIdItem.setDisabled(true);
		equipmentTypeIdItem.setRequired(true);
		equipmentTypeIdItem.setHidden(true);
		IsIntegerValidator equipmentTypeIdValidator = new IsIntegerValidator();
		equipmentTypeIdItem.setValidators(equipmentTypeIdValidator);
		__formItems.add(equipmentTypeIdItem);
		nameItem = new TextItem("name", "名称");
		nameItem.setDisabled(true);
		nameItem.setWidth("*");
		__formItems.add(nameItem);
		enabledItem = new CheckboxItem("enabled", "是否启用");
		enabledItem.setDisabled(true);
		enabledItem.hide();
		__formItems.add(enabledItem);

		priceItem = new TextItem("price", "单价");
		priceItem.setDisabled(true);
		priceItem.setWidth("*");
		__formItems.add(priceItem);

		typeItem = new SelectItem("type", "物品类型");
		typeItem.setDisabled(true);
		typeItem.setWidth("*");
		typeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_254"));
		__formItems.add(typeItem);

		countItem = new TextItem("count", "库存数量(负数减少，正数增加)");
		countItem.setValue(0);
		countItem.setWidth("*");
		__formItems.add(countItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSMequipmenttypeedeeeor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public Map getValuesAsMap() {
		return __form.getValues();
	}


	public void setModifyMode(){
		priceItem.setDisabled(false);
		nameItem.setDisabled(false);
		typeItem.setDisabled(true);
		countItem.setDisabled(true);

	}


}
