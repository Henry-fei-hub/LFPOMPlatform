package com.pomplatform.client.projectcost.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.projectcost.datasource.DSSprojectcostpcor;

public class SprojectcostpcorUpdateForm extends AbstractWizadPage {

	private final ComboBoxItem employeeIdItem;
	private final TextItem costMoneyItem;
	private final SelectItem costTypeItem;
	private final DateItem costDateItem;

	public SprojectcostpcorUpdateForm() {
		DSSprojectcostpcor ds = DSSprojectcostpcor.getInstance();
		__form.setWidth100();
		__form.setHeight100();

		employeeIdItem = new ComboBoxItem("employeeId", "经办人");
		employeeIdItem.setWidth("*");
                employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setValueMap((LinkedHashMap) ds.getField("employeeId").getValueMap());
		__formItems.add(employeeIdItem);

		costMoneyItem = new TextItem("amount", "金额");
		costMoneyItem.setWidth("*");
		__formItems.add(costMoneyItem);

		costTypeItem = new SelectItem("costType", "费用类型");
		costTypeItem.setWidth("*");
		costTypeItem.setValueMap((LinkedHashMap) ds.getField("costType").getValueMap());
		__formItems.add(costTypeItem);

		costDateItem = new DateItem("costDate", "日期");
		__formItems.add(costDateItem);

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
		manager.setDataSource(DSSprojectcostpcor.getInstance());
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
