package com.pomplatform.client.revenue.form;

import java.util.Date;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.data.RoleDefinition;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class RevenueStatisticalOfRevenueSearchForm extends SearchForm
{


	public final SelectItem yearItem;
	public final SelectItem monthItem;
	private final SelectItem projectIdItem;
	private final SelectItem plateIdItem;
	private final TextItem plateManagerIdItem;
	private final TextItem departmentManagerIdItem;
	private final SelectItem projectManageIdItem;
	private final TextItem sheetNameItem;
	private final TextItem sheetCodeItem;

	@SuppressWarnings("deprecation")
	public RevenueStatisticalOfRevenueSearchForm() {
		setWidth100();
		setHeight100();
		Date d = new Date();
		yearItem = new SelectItem("year", "年份");
		yearItem.setValue(d.getYear()+1900);
		yearItem.setWidth("*");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		monthItem = new SelectItem("month", "月份");
		monthItem.setWidth("*");
		monthItem.setValue(d.getMonth() + 1);
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		projectIdItem = new SelectItem("projectId", "项目ID");
		projectIdItem.hide();
		KeyValueManager.loadValueMap("projects",projectIdItem);
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		//如果拥有查查所有部门的权限
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.REVENUE_STATISTICAL_CHECK_ALL_DATA)) {
			plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.REVENUE_STATISTICAL_CHECK_MYSELF_DATA)){
			String plateIds = PomPlatformClientUtil.getRolePlateId();
			String[] arr = plateIds.split(",");
			if(arr.length > 0){
				plateIdItem.setDefaultValue(arr[0]);
			}
			RoleDefinition.setPlateItemValueMap(plateIdItem,plateIds);
		}
		plateManagerIdItem = new TextItem("plateManagerId", "事业部负责人");
		plateManagerIdItem.hide();
		departmentManagerIdItem = new TextItem("departmentManagerId", "部门经理");
		departmentManagerIdItem.hide();
		projectManageIdItem = new SelectItem("projectManageId", "专业负责人");
		projectManageIdItem.hide();
		projectManageIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		sheetNameItem = new TextItem("sheetName", "订单名称");
		sheetNameItem.setWidth("*");
		sheetCodeItem = new TextItem("sheetCode", "订单编号");
		sheetCodeItem.setWidth("*");

		setItems(plateIdItem, yearItem, monthItem, projectIdItem,plateManagerIdItem, departmentManagerIdItem, projectManageIdItem, sheetNameItem, sheetCodeItem);

		setNumCols(11);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
