package com.pomplatform.client.contractreceivablecipor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.contractreceivablecipor.datasource.DSScontractreceivablecipor;

public class ScontractreceivableciporUpdateForm extends AbstractWizadPage
{


	private final TextItem contractReceivableIdItem;
	private final TextItem infoCodeItem;
	private final TextItem projectCodeItem;
	private final TextItem contractIdItem;
	private final TextItem contractCodeItem;
	private final TextItem receivableNameItem;
	private final TextItem receivablePercentageItem;
	private final TextItem receivableSumMoneyItem;
	private final CheckboxItem isConfirmationLetterItem;
	private final TextItem remarkItem;
	private final SelectItem parentIdItem;

	public ScontractreceivableciporUpdateForm() {
		DSScontractreceivablecipor ds = DSScontractreceivablecipor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		contractReceivableIdItem = new TextItem("contractReceivableId", "合同阶段id");
		contractReceivableIdItem.setDisabled(true);
		contractReceivableIdItem.setRequired(true);
		IsIntegerValidator contractReceivableIdValidator = new IsIntegerValidator();
		contractReceivableIdItem.setValidators(contractReceivableIdValidator);
		__formItems.add(contractReceivableIdItem);
		infoCodeItem = new TextItem("infoCode", "信息编号");
		__formItems.add(infoCodeItem);
		projectCodeItem = new TextItem("projectCode", "项目编号");
		__formItems.add(projectCodeItem);
		contractIdItem = new TextItem("contractId", "合同id");
		__formItems.add(contractIdItem);
		contractCodeItem = new TextItem("contractCode", "合同主编号");
		__formItems.add(contractCodeItem);
		receivableNameItem = new TextItem("receivableName", "阶段名称");
		__formItems.add(receivableNameItem);
		receivablePercentageItem = new TextItem("receivablePercentage", "阶段收款率(%)");
		__formItems.add(receivablePercentageItem);
		receivableSumMoneyItem = new TextItem("receivableSumMoney", "收款金额");
		__formItems.add(receivableSumMoneyItem);
		isConfirmationLetterItem = new CheckboxItem("isConfirmationLetter", "是否已经被用做过确认函");
		__formItems.add(isConfirmationLetterItem);
		remarkItem = new TextItem("remark", "收款阶段备注");
		__formItems.add(remarkItem);
		parentIdItem = new SelectItem("parentId", "收款阶段id的父节点");
//		parentIdItem.setValueMap(KeyValueManager.getValueMap("project_types"));
		KeyValueManager.loadValueMap("project_types", parentIdItem);
		__formItems.add(parentIdItem);

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
		manager.setDataSource(DSScontractreceivablecipor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
