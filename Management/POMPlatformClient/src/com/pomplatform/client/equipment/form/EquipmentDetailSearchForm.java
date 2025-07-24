package com.pomplatform.client.equipment.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.equipment.datasource.CDEquipmentDetail;

public class EquipmentDetailSearchForm extends SearchForm
{


	private final ComboBoxItem departmentIdItem;
	private final TextItem employeeIdItem;
	private final TextItem equipmentNameItem;
	private final SelectItem nextAuditorItem;
	private final SelectItem operationTypeItem;
	private final DateTimeItem startDateItem;
	private final DateTimeItem endDateItem;

	public EquipmentDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDEquipmentDetail.getInstance());
		departmentIdItem = new ComboBoxItem("departmentId", "部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setWidth("*");
		employeeIdItem = new ComboBoxItem("employeeId", "员工姓名");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setWidth("*");
		equipmentNameItem = new TextItem("equipmentName", "物品名称");
		equipmentNameItem.setWidth("*");
		nextAuditorItem = new SelectItem("nextAuditor", "物品类型");
		nextAuditorItem.setWidth("*");
		nextAuditorItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_252"));
		operationTypeItem = new SelectItem("operationType", "操作类型");
		operationTypeItem.setWidth("*");
		operationTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_255"));
		startDateItem = new DateTimeItem("startDate", "操作时间(开始)");
		startDateItem.setWidth("*");
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				ClientUtil.searchDateFormat(val, startDateItem);
			}
		});
		endDateItem = new DateTimeItem("endDate", "操作时间(结束)");
		endDateItem.setWidth("*");
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				ClientUtil.searchDateFormat(val, endDateItem);
			}
		});

		setItems(departmentIdItem, employeeIdItem,equipmentNameItem, nextAuditorItem, operationTypeItem, startDateItem, endDateItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
