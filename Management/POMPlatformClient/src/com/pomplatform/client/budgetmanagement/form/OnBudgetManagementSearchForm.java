package com.pomplatform.client.budgetmanagement.form;

import java.util.Date;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.budgetmanagement.datasource.CDOnBudgetManagement;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class OnBudgetManagementSearchForm extends SearchForm
{


	private final TextItem bdCodeItem;
	private final SelectItem bdTypeItem;
	private final TextItem bdTotalAmountItem;
	private final ComboBoxItem bdApplyEmployeeIdItem;
	private final DateTimeItem bdApplyTimeItem;
	private final DateTimeItem bdEstimatecloseTimeItem;
	private final SelectItem bdStatusItem;
	private final ComboBoxItem projectIdItem;
	private final TextItem bdRemarkItem;
	private final SelectItem processStatusItem;
	private final TextItem projectNameItem;

	public OnBudgetManagementSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnBudgetManagement.getInstance());
		
		
		bdCodeItem = new TextItem("bdCode", "预算编号");
		bdCodeItem.setWidth("*");
		
		bdTypeItem = new SelectItem("bdType", "预算类型");
		bdTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_191"));
		bdTypeItem.setWidth("*");
		
		bdTotalAmountItem = new TextItem("bdTotalAmount", "预算总金额");
		bdTotalAmountItem.hide();
		bdTotalAmountItem.setWidth("*");
		
		bdApplyEmployeeIdItem = new ComboBoxItem("bdApplyEmployeeId", "申请人");
		bdApplyEmployeeIdItem.setChangeOnKeypress(false);
		bdApplyEmployeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		bdApplyEmployeeIdItem.setWidth("*");
		
		bdApplyTimeItem = new DateTimeItem("bdApplyTime", "申请时间");
		bdApplyTimeItem.setWidth("*");
		/*bdApplyTimeItem.setUseTextField(true);   
		bdApplyTimeItem.setShowPickerIconOnFocus(true);*/
		bdApplyTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, bdApplyTimeItem);
			}
		});
		bdEstimatecloseTimeItem = new DateTimeItem("bdEstimatecloseTime", "预期关闭时间");
		bdEstimatecloseTimeItem.setWidth("*");
		bdEstimatecloseTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, bdEstimatecloseTimeItem);
			}
		});
		
		bdStatusItem = new SelectItem("bdStatus", "预算单状态");
		bdStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_195"));
		bdStatusItem.setWidth("*");
		
		projectIdItem = new ComboBoxItem("projectId", "项目名称");
//		KeyValueManager.loadValueMap("projects",projectIdItem);
		KeyValueManager.loadValueMap("projects",projectIdItem);
		projectIdItem.setWidth("*");
		
		bdRemarkItem = new TextItem("bdRemark", "预算备注");
		bdRemarkItem.hide();
		bdRemarkItem.setWidth("*");
		
		processStatusItem = new SelectItem("processStatus","流程状态");
		processStatusItem.setWidth("*");
		processStatusItem.setValueMap(KeyValueManager.getValueMap("process_status"));
		
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");

		setItems(bdCodeItem, bdTypeItem, bdTotalAmountItem, bdApplyEmployeeIdItem, bdApplyTimeItem, bdEstimatecloseTimeItem, bdStatusItem, bdRemarkItem, processStatusItem,projectNameItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
