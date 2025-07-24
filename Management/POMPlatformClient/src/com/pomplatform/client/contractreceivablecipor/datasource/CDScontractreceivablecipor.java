package com.pomplatform.client.contractreceivablecipor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDScontractreceivablecipor extends DataSource
{


	public static CDScontractreceivablecipor instance = null;

	public static CDScontractreceivablecipor getInstance() {
		if(instance == null) {
			instance = new CDScontractreceivablecipor("CDScontractreceivablecipor");
		}
		return instance;
	}

	private final DataSourceIntegerField contractReceivableIdField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField receivableNameField;
	private final DataSourceBooleanField isConfirmationLetterField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField parentIdField;

	public CDScontractreceivablecipor(String dataSourceID) {

		setID(dataSourceID);
		contractReceivableIdField = new DataSourceIntegerField("contractReceivableId", "合同阶段id");
		contractReceivableIdField.setRequired(true);
		contractReceivableIdField.setLength(11);
		contractReceivableIdField.setPrimaryKey(true);
		contractReceivableIdField.setHidden(true);

		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setRequired(false);
		infoCodeField.setLength(64);
		infoCodeField.setHidden(false);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(64);
		projectCodeField.setHidden(false);

		contractIdField = new DataSourceIntegerField("contractId", "合同主键");
		contractIdField.setRequired(false);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "合同主编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		receivableNameField = new DataSourceTextField("receivableName", "阶段名称");
		receivableNameField.setRequired(false);
		receivableNameField.setLength(128);
		receivableNameField.setHidden(false);

		isConfirmationLetterField = new DataSourceBooleanField("isConfirmationLetter", "是否已经被用做过确认函");
		isConfirmationLetterField.setRequired(false);
		isConfirmationLetterField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "收款阶段备注");
		remarkField.setRequired(false);
		remarkField.setLength(512);
		remarkField.setHidden(false);

		parentIdField = new DataSourceIntegerField("parentId", "收款阶段id的父节点");
		parentIdField.setRequired(false);
		parentIdField.setLength(11);
		parentIdField.setHidden(false);
//		parentIdField.setValueMap(KeyValueManager.getValueMap("project_types"));
		KeyValueManager.loadValueMap("project_types", parentIdField);

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


		setFields(contractReceivableIdField, infoCodeField, projectCodeField, contractIdField, contractCodeField, receivableNameField, isConfirmationLetterField, remarkField, parentIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

