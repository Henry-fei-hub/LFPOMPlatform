package com.pomplatform.client.aboutprojectquotetemplatesparent.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDAboutProjectQuoteTemplatesParent extends DataSource
{


	public static CDAboutProjectQuoteTemplatesParent instance = null;

	public static CDAboutProjectQuoteTemplatesParent getInstance() {
		if(instance == null) {
			instance = new CDAboutProjectQuoteTemplatesParent("CDAboutProjectQuoteTemplatesParent");
		}
		return instance;
	}

	private final DataSourceTextField parentNameField;
	private final DataSourceIntegerField businessTypeField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField createEmployeeIdField;
	private final DataSourceDateField createDateStartField;
	private final DataSourceDateField createDateEndField;
	private final DataSourceTextField remarkField;

	public CDAboutProjectQuoteTemplatesParent(String dataSourceID) {

		setID(dataSourceID);
		parentNameField = new DataSourceTextField("parentName", "模板名称");
		parentNameField.setRequired(false);
		parentNameField.setLength(128);
		parentNameField.setHidden(false);

		businessTypeField = new DataSourceIntegerField("businessType", "业务类别id");
		businessTypeField.setRequired(false);
		businessTypeField.setLength(11);
		businessTypeField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "公司id");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);

		createEmployeeIdField = new DataSourceIntegerField("createEmployeeId", "创建人");
		createEmployeeIdField.setRequired(false);
		createEmployeeIdField.setLength(11);
		createEmployeeIdField.setHidden(false);

		createDateStartField = new DataSourceDateField("createDateStart", "创建日期开始");
		createDateStartField.setRequired(false);
		createDateStartField.setHidden(false);

		createDateEndField = new DataSourceDateField("createDateEnd", "创建日期结束");
		createDateEndField.setRequired(false);
		createDateEndField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(2048);
		remarkField.setHidden(false);

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


		setFields(parentNameField, businessTypeField, companyIdField, createEmployeeIdField, createDateStartField, createDateEndField, remarkField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

