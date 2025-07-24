package com.pomplatform.client.cwd.form;

import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.cwd.datasource.CDWorkplacePublicIPManage;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class WorkplacePublicIPManageSearchForm extends SearchForm
{


	private final CheckboxItem activeItem;
	private final TextItem companyWorkplaceIdItem;
	private final TextItem ipAddressItem;

	public WorkplacePublicIPManageSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDWorkplacePublicIPManage.getInstance());
		
		activeItem = new CheckboxItem("active", "是否有效");
		activeItem.setDefaultValue(true);
		
		companyWorkplaceIdItem = new TextItem("companyWorkplaceId", "工作场所");
		companyWorkplaceIdItem.hide();
		
		ipAddressItem = new TextItem("ipAddress", "公网IP地址");
		ipAddressItem.setWidth("*");

		setItems(ipAddressItem, companyWorkplaceIdItem, activeItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
