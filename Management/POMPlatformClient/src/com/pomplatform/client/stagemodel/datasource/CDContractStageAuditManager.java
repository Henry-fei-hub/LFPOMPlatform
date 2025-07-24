package com.pomplatform.client.stagemodel.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDContractStageAuditManager extends DataSource
{


	public static CDContractStageAuditManager instance = null;

	public static CDContractStageAuditManager getInstance() {
		if(instance == null) {
			instance = new CDContractStageAuditManager("CDContractStageAuditManager");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceBooleanField lockedField;
	private final DataSourceTextField auditStatusField;

	public CDContractStageAuditManager(String dataSourceID) {

		setID(dataSourceID);
		employeeIdField = new DataSourceIntegerField("employeeId", "职员");
		employeeIdField.setRequired(true);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		contractIdField = new DataSourceIntegerField("contractId", "合同");
		contractIdField.setRequired(false);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		lockedField = new DataSourceBooleanField("locked", "是否锁定");
		lockedField.setRequired(false);
		lockedField.setHidden(false);
		
		auditStatusField = new DataSourceTextField("auditStatus", "审批状态");
		auditStatusField.setRequired(false);
		auditStatusField.setLength(512);
		auditStatusField.setHidden(false);

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


		setFields(employeeIdField, contractIdField, contractCodeField, contractNameField, auditStatusField, lockedField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

