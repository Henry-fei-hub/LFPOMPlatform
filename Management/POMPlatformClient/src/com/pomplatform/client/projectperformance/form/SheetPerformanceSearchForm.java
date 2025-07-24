package com.pomplatform.client.projectperformance.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.data.RoleDefinition;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class SheetPerformanceSearchForm extends SearchForm
{
	private final ComboBoxItem plateIdItem;
	private final TextItem sheetCodeItem;
	private final TextItem sheetNameItem;
	private final ComboBoxItem projectManageIdItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;

	public SheetPerformanceSearchForm() {
		setWidth100();
		setHeight100();
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	
		
		sheetCodeItem = new TextItem("sheetCode", "订单编号");
		sheetCodeItem.setWidth("*");
		
		sheetNameItem = new TextItem("sheetName", "订单名称");
		sheetNameItem.setWidth("*");
		
		projectManageIdItem = new ComboBoxItem("projectManageId", "项目经理");
		RoleDefinition.setProjectManagerItemValueMap(projectManageIdItem,0);
		projectManageIdItem.setWidth("*");
		projectManageIdItem.hide();
		projectManageIdItem.setChangeOnKeypress(false);
		projectManageIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.VIEW_ALL_DATA) && ClientUtil.checkIsHavePermission(ERPPermissionStatic.VIEW_SELF_DATA)){
			//只有查看自己的合同绩效数据
			projectManageIdItem.setValue(ClientUtil.getUserId());
			projectManageIdItem.setDisabled(true);
		}
		startDateItem = new DateItem("startDate", "开始时间");
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);  
		endDateItem = new DateItem("endDate", "截止时间");
		endDateItem.setWidth("*");
		endDateItem.setUseTextField(true); 
		
		setItems(plateIdItem,sheetCodeItem, sheetNameItem, projectManageIdItem, startDateItem, endDateItem);

		setNumCols(11);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
