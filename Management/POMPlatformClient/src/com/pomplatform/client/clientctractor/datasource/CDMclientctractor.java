package com.pomplatform.client.clientctractor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMclientctractor extends DataSource
{


	public static CDMclientctractor instance = null;

	public static CDMclientctractor getInstance() {
		if(instance == null) {
			instance = new CDMclientctractor("CDMclientctractor");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField clientNameField;
	private final DataSourceTextField clientPhoneField;
	private final DataSourceTextField clientCompanyField;
	private final DataSourceTextField clientJobField;
	private final DataSourceTextField clientWeixinField;
	private final DataSourceTextField clientQqField;
	private final DataSourceTextField clientEmailField;
	private final DataSourceIntegerField clientRoleField;

	public CDMclientctractor(String dataSourceID) {

		setID(dataSourceID);
		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setRequired(true);
		contractIdField.setLength(11);
		contractIdField.setPrimaryKey(true);
		contractIdField.setHidden(false);

		clientNameField = new DataSourceTextField("clientName", "联系人姓名");
		clientNameField.setRequired(false);
		clientNameField.setLength(64);
		clientNameField.setHidden(false);

		clientPhoneField = new DataSourceTextField("clientPhone", "联系人手机");
		clientPhoneField.setRequired(false);
		clientPhoneField.setLength(64);
		clientPhoneField.setHidden(false);

		clientCompanyField = new DataSourceTextField("clientCompany", "单位名称");
		clientCompanyField.setRequired(false);
		clientCompanyField.setLength(64);
		clientCompanyField.setHidden(false);

		clientJobField = new DataSourceTextField("clientJob", "职务");
		clientJobField.setRequired(false);
		clientJobField.setLength(32);
		clientJobField.setHidden(false);

		clientWeixinField = new DataSourceTextField("clientWeixin", "微信");
		clientWeixinField.setRequired(false);
		clientWeixinField.setLength(32);
		clientWeixinField.setHidden(false);

		clientQqField = new DataSourceTextField("clientQq", "QQ");
		clientQqField.setRequired(false);
		clientQqField.setLength(20);
		clientQqField.setHidden(false);

		clientEmailField = new DataSourceTextField("clientEmail", "邮箱");
		clientEmailField.setRequired(false);
		clientEmailField.setLength(64);
		clientEmailField.setHidden(false);

		clientRoleField = new DataSourceIntegerField("clientRole", "0客户    1建筑设计单位联系人");
		clientRoleField.setRequired(false);
		clientRoleField.setLength(11);
		clientRoleField.setHidden(false);

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


		setFields(contractIdField, clientNameField, clientPhoneField, clientCompanyField, clientJobField, clientWeixinField, clientQqField, clientEmailField, clientRoleField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

