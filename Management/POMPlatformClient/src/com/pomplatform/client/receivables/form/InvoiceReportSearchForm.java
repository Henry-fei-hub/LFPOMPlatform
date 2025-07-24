package com.pomplatform.client.receivables.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.data.RoleDefinition;
import com.pomplatform.client.receivables.datasource.CDInvoiceReport;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;

public class InvoiceReportSearchForm extends SearchForm
{


	private final ComboBoxItem plateIdItem;
	private final ComboBoxItem projectManagerIdItem;

	public InvoiceReportSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDInvoiceReport.getInstance());
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		//如果拥有查查所有部门的权限
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.PROJECT_HK_REPORT_CHECK_ALL)) {
			plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.PROJECT_HK_REPORT_CHECK_MANAGE)){
			String plateIds = PomPlatformClientUtil.getRolePlateId();
			RoleDefinition.setPlateItemValueMap(plateIdItem,plateIds);
		}
		
		projectManagerIdItem = new ComboBoxItem("projectManagerId", "项目经理");
		projectManagerIdItem.setWidth("*");
		KeyValueManager.loadValueMap("employees",projectManagerIdItem);

		setItems(plateIdItem,projectManagerIdItem);

		setNumCols(5);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
