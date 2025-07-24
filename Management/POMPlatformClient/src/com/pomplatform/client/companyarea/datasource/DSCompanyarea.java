package com.pomplatform.client.companyarea.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSCompanyarea extends DBDataSource
{


	public static DSCompanyarea instance = null;

	public static DSCompanyarea getInstance() {
		if(instance == null) {
			instance = new DSCompanyarea("DSCompanyarea");
		}
		return instance;
	}

	private final DataSourceIntegerField companyAreaIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField areaIdField;
	private final DataSourceTextField companyNameField;
	private final DataSourceTextField companyCodeField;
	private final DataSourceBooleanField isEnabledField;
	private final DataSourceTextField companyNoField;
	private final DataSourceTextField companyNameSimpleField;
	private final DataSourceTextField areaNameField;
	private final DataSourceTextField areaNameEnField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceTextField allNameField;
	private final DataSourceIntegerField areaLevelField;
	private final DataSourceIntegerField regionField;

	public DSCompanyarea(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Companyarea");


		companyAreaIdField = new DataSourceIntegerField("companyAreaId", "主键");
		companyAreaIdField.setLength(11);
		companyAreaIdField.setPrimaryKey(true);
		companyAreaIdField.setRequired(true);
		companyAreaIdField.setHidden(true);


		companyIdField = new DataSourceIntegerField("companyId", "公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(true);


		areaIdField = new DataSourceIntegerField("areaId", "区域");
		areaIdField.setLength(11);
		areaIdField.setRequired(false);
		areaIdField.setHidden(true);


		companyNameField = new DataSourceTextField("companyName", "公司名称");
		companyNameField.setLength(64);
		companyNameField.setRequired(false);
		companyNameField.setHidden(false);


		companyCodeField = new DataSourceTextField("companyCode", "公司代码");
		companyCodeField.setLength(32);
		companyCodeField.setRequired(false);
		companyCodeField.setHidden(false);


		isEnabledField = new DataSourceBooleanField("isEnabled", "是否启用");
		isEnabledField.setRequired(false);
		isEnabledField.setHidden(false);


		companyNoField = new DataSourceTextField("companyNo", "公司编号");
		companyNoField.setLength(64);
		companyNoField.setRequired(false);
		companyNoField.setHidden(true);


		companyNameSimpleField = new DataSourceTextField("companyNameSimple", "公司简称");
		companyNameSimpleField.setLength(64);
		companyNameSimpleField.setRequired(false);
		companyNameSimpleField.setHidden(false);


		areaNameField = new DataSourceTextField("areaName", "区域名称");
		areaNameField.setLength(128);
		areaNameField.setRequired(false);
		areaNameField.setHidden(false);


		areaNameEnField = new DataSourceTextField("areaNameEn", "区域英文名称");
		areaNameEnField.setLength(128);
		areaNameEnField.setRequired(false);
		areaNameEnField.setHidden(true);


		parentIdField = new DataSourceIntegerField("parentId", "父级编码");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(true);


		allNameField = new DataSourceTextField("allName", "区域全名");
		allNameField.setLength(64);
		allNameField.setRequired(false);
		allNameField.setHidden(false);


		areaLevelField = new DataSourceIntegerField("areaLevel", "等级(1一线，2二线，3三线)");
		areaLevelField.setLength(11);
		areaLevelField.setRequired(false);
		areaLevelField.setHidden(true);


		regionField = new DataSourceIntegerField("region", "区域");
		regionField.setLength(11);
		regionField.setRequired(false);
		regionField.setHidden(true);


		setFields(companyAreaIdField, companyIdField, areaIdField, companyNameField, companyCodeField, companyNoField, companyNameSimpleField, areaNameField, areaNameEnField, parentIdField, allNameField, areaLevelField, regionField, isEnabledField);
	}


}

