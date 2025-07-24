package com.pomplatform.client.financialstatements.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDScapitalipcor extends DataSource
{


	public static CDScapitalipcor instance = null;

	public static CDScapitalipcor getInstance() {
		if(instance == null) {
			instance = new CDScapitalipcor("CDScapitalipcor");
		}
		return instance;
	}

	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceIntegerField capitalIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField moneyAttributeField;
	private final DataSourceIntegerField selfNameField;
	private final DataSourceIntegerField capitalTypeField;
	private final DataSourceIntegerField processStatusField;

	public CDScapitalipcor(String dataSourceID) {

		setID(dataSourceID);
		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setRequired(false);
		infoCodeField.setLength(64);
		infoCodeField.setHidden(false);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(64);
		projectCodeField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "合同主编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		capitalIdField = new DataSourceIntegerField("capitalId", "资金表id");
		capitalIdField.setRequired(true);
		capitalIdField.setLength(11);
		capitalIdField.setPrimaryKey(true);
		capitalIdField.setHidden(true);

		contractIdField = new DataSourceIntegerField("contractId", "合同id");
		contractIdField.setRequired(false);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);

		moneyAttributeField = new DataSourceIntegerField("moneyAttribute", "款项属性");
		moneyAttributeField.setRequired(false);
		moneyAttributeField.setLength(11);
		moneyAttributeField.setHidden(false);

		selfNameField = new DataSourceIntegerField("selfName", "内部公司(收款方)");
		selfNameField.setRequired(false);
		selfNameField.setLength(11);
		selfNameField.setHidden(false);

		capitalTypeField = new DataSourceIntegerField("capitalType", "资金类型  1 流入  2 流出");
		capitalTypeField.setRequired(false);
		capitalTypeField.setLength(11);
		capitalTypeField.setHidden(false);

		processStatusField = new DataSourceIntegerField("processStatus", "流程状态 0 未处于流程  1审批中 2审批完成");
		processStatusField.setRequired(false);
		processStatusField.setLength(11);
		processStatusField.setHidden(false);

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


		setFields(infoCodeField, projectCodeField, contractCodeField, capitalIdField, contractIdField, moneyAttributeField, selfNameField, capitalTypeField, processStatusField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

