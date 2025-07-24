package com.pomplatform.client.memployeeaaccadpppccor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMemployeeaaccadpppccor extends DataSource
{


	public static CDMemployeeaaccadpppccor instance = null;

	public static CDMemployeeaaccadpppccor getInstance() {
		if(instance == null) {
			instance = new CDMemployeeaaccadpppccor("CDMemployeeaaccadpppccor");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceIntegerField deleteFlagField;
	private final DataSourceIntegerField projectManageIdField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceBooleanField isEqualsField;

	public CDMemployeeaaccadpppccor(String dataSourceID) {

		setID(dataSourceID);
		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setRequired(false);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);

		attachmentNameField = new DataSourceTextField("attachmentName", "附件名称");
		attachmentNameField.setRequired(false);
		attachmentNameField.setLength(128);
		attachmentNameField.setHidden(false);

		deleteFlagField = new DataSourceIntegerField("deleteFlag", "0/1 是/否删除");
		deleteFlagField.setRequired(false);
		deleteFlagField.setLength(11);
		deleteFlagField.setHidden(false);

		projectManageIdField = new DataSourceIntegerField("projectManageId", "项目负责人");
		projectManageIdField.setRequired(false);
		projectManageIdField.setLength(11);
		projectManageIdField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "主订单名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "主订单编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);
		
		isEqualsField = new DataSourceBooleanField("isEquals", "");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(11);
		contractCodeField.setHidden(false);

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


		setFields(contractIdField, attachmentNameField, deleteFlagField, projectManageIdField, contractNameField, contractCodeField, isEqualsField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

