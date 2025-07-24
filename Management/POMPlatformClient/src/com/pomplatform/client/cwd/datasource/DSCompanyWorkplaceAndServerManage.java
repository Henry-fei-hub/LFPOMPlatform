package com.pomplatform.client.cwd.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSCompanyWorkplaceAndServerManage extends DBDataSource
{


	public static DSCompanyWorkplaceAndServerManage instance = null;

	public static DSCompanyWorkplaceAndServerManage getInstance() {
		if(instance == null) {
			instance = new DSCompanyWorkplaceAndServerManage("DSCompanyWorkplaceAndServerManage");
		}
		return instance;
	}

	private final DataSourceIntegerField companyWorkplaceIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceTextField workplaceNameField;
	private final DataSourceIntegerField countryIdField;
	private final DataSourceIntegerField provinceIdField;
	private final DataSourceIntegerField cityIdField;
	private final DataSourceTextField workplaceDirField;
	private final DataSourceIntegerField workplaceTypeField;
	private final DataSourceBooleanField hasInitField;
	private final DataSourceBooleanField activeField;
	private final DataSourceField detailCompanyWorkplaceServer;

	public DSCompanyWorkplaceAndServerManage(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("CompanyWorkplaceAndServerManage");


		companyWorkplaceIdField = new DataSourceIntegerField("companyWorkplaceId", "工作场所编码");
		companyWorkplaceIdField.setLength(11);
		companyWorkplaceIdField.setPrimaryKey(true);
		companyWorkplaceIdField.setRequired(true);
		companyWorkplaceIdField.setHidden(true);


		companyIdField = new DataSourceIntegerField("companyId", "公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("companies"));


		workplaceNameField = new DataSourceTextField("workplaceName", "工作场所名称");
		workplaceNameField.setLength(512);
		workplaceNameField.setRequired(false);
		workplaceNameField.setHidden(false);


		countryIdField = new DataSourceIntegerField("countryId", "国家");
		countryIdField.setLength(11);
		countryIdField.setRequired(false);
		countryIdField.setHidden(true);
		countryIdField.setValueMap(KeyValueManager.getValueMap("countries"));


		provinceIdField = new DataSourceIntegerField("provinceId", "省份");
		provinceIdField.setLength(11);
		provinceIdField.setRequired(false);
		provinceIdField.setHidden(true);
		provinceIdField.setValueMap(KeyValueManager.getValueMap("states"));


		cityIdField = new DataSourceIntegerField("cityId", "城市");
		cityIdField.setLength(11);
		cityIdField.setRequired(false);
		cityIdField.setHidden(true);
		cityIdField.setValueMap(KeyValueManager.getValueMap("cities"));
		

		workplaceDirField = new DataSourceTextField("workplaceDir", "工作目录");
		workplaceDirField.setLength(512);
		workplaceDirField.setRequired(false);
		workplaceDirField.setHidden(false);


		workplaceTypeField = new DataSourceIntegerField("workplaceType", "工作场所类型");
		workplaceTypeField.setLength(11);
		workplaceTypeField.setRequired(false);
		workplaceTypeField.setHidden(false);
		workplaceTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_186"));


		hasInitField = new DataSourceBooleanField("hasInit", "是否初始化完成");
		hasInitField.setRequired(false);
		hasInitField.setHidden(false);


		activeField = new DataSourceBooleanField("active", "是否有效");
		activeField.setRequired(false);
		activeField.setHidden(false);

		detailCompanyWorkplaceServer = new DataSourceField("detailCompanyWorkplaceServer", FieldType.ANY);
		detailCompanyWorkplaceServer.setChildrenProperty(true);
		detailCompanyWorkplaceServer.setChildTagName("CompanyWorkplaceServer");
		detailCompanyWorkplaceServer.setRequired(false);
		detailCompanyWorkplaceServer.setHidden(true);

		setFields(companyWorkplaceIdField, companyIdField, workplaceNameField, countryIdField, provinceIdField, cityIdField, workplaceDirField, workplaceTypeField, hasInitField, activeField, detailCompanyWorkplaceServer);
	}


}

