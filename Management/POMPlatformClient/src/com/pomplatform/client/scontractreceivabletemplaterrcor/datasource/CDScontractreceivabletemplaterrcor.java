package com.pomplatform.client.scontractreceivabletemplaterrcor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDScontractreceivabletemplaterrcor extends DataSource
{


	public static CDScontractreceivabletemplaterrcor instance = null;

	public static CDScontractreceivabletemplaterrcor getInstance() {
		if(instance == null) {
			instance = new CDScontractreceivabletemplaterrcor("CDScontractreceivabletemplaterrcor");
		}
		return instance;
	}

	private final DataSourceTextField receivableNameField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField contractReceivableTemplateIdField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceIntegerField operatorField;

	public CDScontractreceivabletemplaterrcor(String dataSourceID) {

		setID(dataSourceID);
		receivableNameField = new DataSourceTextField("receivableName", "阶段名称");
		receivableNameField.setRequired(false);
		receivableNameField.setLength(255);
		receivableNameField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(255);
		remarkField.setHidden(false);

		contractReceivableTemplateIdField = new DataSourceIntegerField("contractReceivableTemplateId", "主键");
		contractReceivableTemplateIdField.setRequired(true);
		contractReceivableTemplateIdField.setLength(11);
		contractReceivableTemplateIdField.setPrimaryKey(true);
		contractReceivableTemplateIdField.setHidden(true);

		parentIdField = new DataSourceIntegerField("parentId", "收款阶段id的父节点");
		parentIdField.setRequired(false);
		parentIdField.setLength(11);
		parentIdField.setHidden(false);
//		parentIdField.setValueMap(KeyValueManager.getValueMap("project_types"));
		KeyValueManager.loadValueMap("project_types", parentIdField);

		operatorField = new DataSourceIntegerField("operator", "操作人");
		operatorField.setRequired(false);
		operatorField.setLength(11);
		operatorField.setHidden(false);

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


		setFields(receivableNameField, remarkField, contractReceivableTemplateIdField, parentIdField, operatorField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

