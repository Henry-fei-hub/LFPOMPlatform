package com.pomplatform.client.cwd.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.cwd.datasource.CDCompanyWorkplaceAndServerManage;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class CompanyWorkplaceAndServerManageSearchForm extends SearchForm
{


	private final TextItem workplaceNameItem;
	private final ComboBoxItem companyIdItem;
	private final ComboBoxItem countryIdItem;
	private final ComboBoxItem provinceIdItem;
	private final ComboBoxItem cityIdItem;
	private final CheckboxItem activeItem;

	public CompanyWorkplaceAndServerManageSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDCompanyWorkplaceAndServerManage.getInstance());
		
		workplaceNameItem = new TextItem("workplaceName", "工作场所名称");
		workplaceNameItem.setWidth("*");
		
		companyIdItem = new ComboBoxItem("companyId", "公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("companies"));
		companyIdItem.setChangeOnKeypress(false);
		companyIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		companyIdItem.setWidth("*");
		
		countryIdItem = new ComboBoxItem("countryId", "国家");
		countryIdItem.setValueMap(KeyValueManager.getValueMap("countries"));
		countryIdItem.setChangeOnKeypress(false);
		countryIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		countryIdItem.setWidth("*");
		
		provinceIdItem = new ComboBoxItem("provinceId", "省份");
		provinceIdItem.setValueMap(KeyValueManager.getValueMap("states"));
		provinceIdItem.setChangeOnKeypress(false);
		provinceIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		provinceIdItem.setWidth("*");
		
		cityIdItem = new ComboBoxItem("cityId", "城市");
		cityIdItem.setValueMap(KeyValueManager.getValueMap("cities"));
		cityIdItem.setChangeOnKeypress(false);
		cityIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		cityIdItem.setWidth("*");
		
		activeItem = new CheckboxItem("active", "是否有效");

		setItems(companyIdItem, workplaceNameItem, activeItem, countryIdItem, provinceIdItem, cityIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
