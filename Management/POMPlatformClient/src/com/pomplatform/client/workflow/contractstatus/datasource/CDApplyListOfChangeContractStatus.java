package com.pomplatform.client.workflow.contractstatus.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class CDApplyListOfChangeContractStatus extends DataSource
{


	public static CDApplyListOfChangeContractStatus instance = null;

	public static CDApplyListOfChangeContractStatus getInstance() {
		if(instance == null) {
			instance = new CDApplyListOfChangeContractStatus("CDApplyListOfChangeContractStatus");
		}
		return instance;
	}

	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceIntegerField deleteFlagField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceTextField contentField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;

	public CDApplyListOfChangeContractStatus(String dataSourceID) {

		setID(dataSourceID);
		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		processStatusField = new DataSourceIntegerField("processStatus", "流程状态");
		processStatusField.setRequired(false);
		processStatusField.setLength(11);
		processStatusField.setHidden(false);

		deleteFlagField = new DataSourceIntegerField("deleteFlag", "删除状态");
		deleteFlagField.setRequired(false);
		deleteFlagField.setLength(11);
		deleteFlagField.setHidden(false);

		operatorField = new DataSourceIntegerField("operator", "操作人");
		operatorField.setRequired(false);
		operatorField.setLength(11);
		operatorField.setHidden(false);

		contentField = new DataSourceTextField("content", "日志");
		contentField.setRequired(false);
		contentField.setLength(1024);
		contentField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

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


		setFields(processTypeField, processStatusField, deleteFlagField, operatorField, contentField, contractCodeField, contractNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

