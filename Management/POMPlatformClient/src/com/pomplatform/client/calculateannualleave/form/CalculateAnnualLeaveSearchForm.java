package com.pomplatform.client.calculateannualleave.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.calculateannualleave.datasource.CDCalculateAnnualLeave;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.PickTreeItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class CalculateAnnualLeaveSearchForm extends SearchForm
{


	private final TextItem employeeNameItem;
	private final TextItem employeeNoItem;
	private final PickTreeItem departmentIdItem;
//	private final TextItem currentRemainingAmountAnnualItem;
//	private final TextItem currentRemainingAmountWealfareItem;
//	private final TextItem lastRemainingAmountAnnualItem;
//	private final TextItem lastRemainingAmountWealfareItem;

	public CalculateAnnualLeaveSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDCalculateAnnualLeave.getInstance());
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");

		departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));

//		currentRemainingAmountAnnualItem = new TextItem("currentRemainingAmountAnnual", "当前的年假");
//		currentRemainingAmountAnnualItem.setWidth("*");
//
//		currentRemainingAmountWealfareItem = new TextItem("currentRemainingAmountWealfare", "当前的带薪病假");
//		currentRemainingAmountWealfareItem.setWidth("*");
//
//		lastRemainingAmountAnnualItem = new TextItem("lastRemainingAmountAnnual", "上一年的年假");
//		lastRemainingAmountAnnualItem.setWidth("*");

//		lastRemainingAmountWealfareItem = new TextItem("lastRemainingAmountWealfare", "上一年的企业福利假");
//		lastRemainingAmountWealfareItem.setWidth("*");

		setItems(employeeNameItem,employeeNoItem, departmentIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
