package com.pomplatform.client.contract.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.contract.datasource.DSScontractccor;

public class ScontractccorUpdateForm extends AbstractWizadPage {

	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem customerNameItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;

	public ScontractccorUpdateForm() {
		DSScontractccor ds = DSScontractccor.getInstance();
		__form.setWidth100();
		__form.setHeight100();

		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		__formItems.add(contractCodeItem);

		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		__formItems.add(contractNameItem);

		customerNameItem = new TextItem("customerName", "客户名称");
		customerNameItem.setWidth("*");
		__formItems.add(customerNameItem);

		startDateItem = new DateItem("startDate", "项目下达日期");
		__formItems.add(startDateItem);

		endDateItem = new DateItem("endDate", "合同签订日期");
		__formItems.add(endDateItem);

		__form.setItems(getFormItemArray());

		__form.setDataSource(ds);
		__form.setNumCols(4);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if (getRecord() != null) {
			__form.editRecord(getRecord());
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSScontractccor.getInstance());
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
