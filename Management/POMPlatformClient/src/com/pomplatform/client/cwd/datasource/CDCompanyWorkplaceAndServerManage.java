package com.pomplatform.client.cwd.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDCompanyWorkplaceAndServerManage extends DataSource
{


	public static CDCompanyWorkplaceAndServerManage instance = null;

	public static CDCompanyWorkplaceAndServerManage getInstance() {
		if(instance == null) {
			instance = new CDCompanyWorkplaceAndServerManage("CDCompanyWorkplaceAndServerManage");
		}
		return instance;
	}

	private final DataSourceTextField workplaceNameField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField countryIdField;
	private final DataSourceIntegerField provinceIdField;
	private final DataSourceIntegerField cityIdField;
	private final DataSourceBooleanField activeField;

	public CDCompanyWorkplaceAndServerManage(String dataSourceID) {

		setID(dataSourceID);
		workplaceNameField = new DataSourceTextField("workplaceName", "工作场所名称");
		workplaceNameField.setRequired(false);
		workplaceNameField.setLength(512);
		workplaceNameField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		countryIdField = new DataSourceIntegerField("countryId", "国家");
		countryIdField.setRequired(false);
		countryIdField.setLength(11);
		countryIdField.setHidden(false);

		provinceIdField = new DataSourceIntegerField("provinceId", "省份");
		provinceIdField.setRequired(false);
		provinceIdField.setLength(11);
		provinceIdField.setHidden(false);
		provinceIdField.setValueMap(KeyValueManager.getValueMap("provinces"));

		cityIdField = new DataSourceIntegerField("cityId", "城市");
		cityIdField.setRequired(false);
		cityIdField.setLength(11);
		cityIdField.setHidden(false);

		activeField = new DataSourceBooleanField("active", "是否有效");
		activeField.setRequired(false);
		activeField.setHidden(false);

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(workplaceNameField, companyIdField, countryIdField, provinceIdField, cityIdField, activeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

