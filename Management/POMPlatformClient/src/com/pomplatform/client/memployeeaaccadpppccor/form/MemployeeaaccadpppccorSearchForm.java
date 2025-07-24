package com.pomplatform.client.memployeeaaccadpppccor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.memployeeaaccadpppccor.datasource.CDMemployeeaaccadpppccor;
import com.pomplatform.client.selectgridemployeevalue.datasource.DSSelectGridEmployeeValue;

public class MemployeeaaccadpppccorSearchForm extends SearchForm {

	private final TextItem contractIdItem;
	private final TextItem attachmentNameItem;
	private final TextItem deleteFlagItem;
	private final ComboBoxItem projectManageIdItem;
	private final TextItem contractNameItem;
	private final TextItem contractCodeItem;
	private final BooleanItem isEqualsItem;

	public MemployeeaaccadpppccorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMemployeeaaccadpppccor.getInstance());
		contractIdItem = new TextItem("contractId", "合同编码");
		contractIdItem.hide();
		attachmentNameItem = new TextItem("attachmentName", "附件名称");
		attachmentNameItem.hide();
		deleteFlagItem = new TextItem("deleteFlag", "0/1 是/否删除");
		deleteFlagItem.hide();
		
		
		ListGridField employeeNoField = new ListGridField("employeeNo");
		ListGridField employeeNameField = new ListGridField("employeeName");
		ListGridField departmentIdField = new ListGridField("departmentId");
		Criteria cd = new Criteria();
		cd.addCriteria("status", "0");
		projectManageIdItem = new ComboBoxItem("projectManageId", "项目负责人");
		projectManageIdItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
		projectManageIdItem.setOptionCriteria(cd);
		projectManageIdItem.setValueField("employeeId");
		projectManageIdItem.setDisplayField("employeeName");
		projectManageIdItem.setPickListFields(employeeNoField, employeeNameField, departmentIdField);
		projectManageIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		projectManageIdItem.setChangeOnKeypress(false);
		projectManageIdItem.setWidth("*");
		
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		isEqualsItem = new BooleanItem("isEquals", "是否完全收款");

		setItems(contractIdItem, attachmentNameItem, deleteFlagItem, projectManageIdItem, contractNameItem,
				contractCodeItem, isEqualsItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
