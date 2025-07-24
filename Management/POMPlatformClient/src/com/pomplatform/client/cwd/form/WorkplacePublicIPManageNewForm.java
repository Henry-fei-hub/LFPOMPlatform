package com.pomplatform.client.cwd.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.cwd.datasource.DSWorkplacePublicIPManage;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class WorkplacePublicIPManageNewForm extends AbstractWizadPage
{


	private final TextItem companyWorkplaceIdItem;
	private final TextItem workplaceNameItem;
	private final TextItem ipAddressItem;
	private final CheckboxItem activeItem;

	public WorkplacePublicIPManageNewForm() {
		DSWorkplacePublicIPManage ds = DSWorkplacePublicIPManage.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		companyWorkplaceIdItem = new TextItem("companyWorkplaceId", "工作场所ID");
		companyWorkplaceIdItem.setWidth("*");
		companyWorkplaceIdItem.hide();
		__formItems.add(companyWorkplaceIdItem);
		
		workplaceNameItem = new TextItem("workplaceName", "工作场所");
		workplaceNameItem.setWidth("*");
		workplaceNameItem.setCanEdit(false);
		__formItems.add(workplaceNameItem);
		
		ipAddressItem = new TextItem("ipAddress", "公网IP地址");
		ipAddressItem.setWidth("*");
		__formItems.add(ipAddressItem);
		
		activeItem = new CheckboxItem("active", "是否有效");
		activeItem.setDefaultValue(true);
		__formItems.add(activeItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSWorkplacePublicIPManage.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
