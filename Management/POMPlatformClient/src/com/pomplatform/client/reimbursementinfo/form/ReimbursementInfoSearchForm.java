package com.pomplatform.client.reimbursementinfo.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.reimbursementpackage.datasource.CDNewReimbursementPackage;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class ReimbursementInfoSearchForm extends SearchForm
{


	private final ComboBoxItem employeeIdItem;
	private final TextItem codeItem;

	public ReimbursementInfoSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDNewReimbursementPackage.getInstance());
		
		employeeIdItem = new ComboBoxItem("drafterId", "起草人");
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setWidth("*");
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.CHECK_ALL_REIMBURSEMENT_INFO)){
			employeeIdItem.setDefaultValue(ClientUtil.getUserId());
			employeeIdItem.setDisabled(true);
		}
		
		codeItem = new TextItem("code", "编号");
		codeItem.setWidth("*");

		setItems(employeeIdItem, codeItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
