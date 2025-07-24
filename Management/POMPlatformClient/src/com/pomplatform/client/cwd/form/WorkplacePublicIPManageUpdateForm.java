package com.pomplatform.client.cwd.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.cwd.datasource.DSWorkplacePublicIPManage;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;

public class WorkplacePublicIPManageUpdateForm extends AbstractWizadPage
{


	private final TextItem companyWorkplacePublicIpIdItem;
	private final TextItem companyWorkplaceIdItem;
	private final TextItem workplaceNameItem;
	private final TextItem ipAddressItem;
	private final CheckboxItem activeItem;

	public WorkplacePublicIPManageUpdateForm() {
		DSWorkplacePublicIPManage ds = DSWorkplacePublicIPManage.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		companyWorkplacePublicIpIdItem = new TextItem("companyWorkplacePublicIpId", "工作场所编码");
		companyWorkplacePublicIpIdItem.setDisabled(true);
		companyWorkplacePublicIpIdItem.setRequired(true);
		companyWorkplacePublicIpIdItem.hide();
		IsIntegerValidator companyWorkplacePublicIpIdValidator = new IsIntegerValidator();
		companyWorkplacePublicIpIdItem.setValidators(companyWorkplacePublicIpIdValidator);
		__formItems.add(companyWorkplacePublicIpIdItem);
		companyWorkplaceIdItem = new TextItem("companyWorkplaceId", "工作场所ID");
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
		activeItem.setWidth("*");
		__formItems.add(activeItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(2);
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
		manager.setDataSource(DSWorkplacePublicIPManage.getInstance());
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
