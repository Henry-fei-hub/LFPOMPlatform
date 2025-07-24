package com.pomplatform.client.scapitaldistributionor.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;

public class DSCapitalDistributionLinkDepartment extends DBDataSource {

	public static DSCapitalDistributionLinkDepartment instance = null;

	public static DSCapitalDistributionLinkDepartment getInstance() {
		if (instance == null) {
			instance = new DSCapitalDistributionLinkDepartment("DSCapitalDistributionLinkDepartment");
		}
		return instance;
	}

	private final DataSourceIntegerField capitalDistributionLinkDepartmentIdField;
	private final DataSourceIntegerField capitalDistributionIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceFloatField moneyField;

	public DSCapitalDistributionLinkDepartment(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("CapitalDistributionLinkDepartment");

		capitalDistributionLinkDepartmentIdField = new DataSourceIntegerField("capitalDistributionLinkDepartmentId",
				"主键");
		capitalDistributionLinkDepartmentIdField.setLength(11);
		capitalDistributionLinkDepartmentIdField.setPrimaryKey(true);
		capitalDistributionLinkDepartmentIdField.setRequired(true);
		capitalDistributionLinkDepartmentIdField.setHidden(true);

		capitalDistributionIdField = new DataSourceIntegerField("capitalDistributionId", "回款分配编码");
		capitalDistributionIdField.setLength(11);
		capitalDistributionIdField.setRequired(false);
		capitalDistributionIdField.setHidden(true);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门编码");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(true);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		moneyField = new DataSourceFloatField("money", "金额");
		moneyField.setLength(16);
		moneyField.setDecimalPad(2);
		moneyField.setFormat("##,###,###,###,##0.00");
		moneyField.setRequired(true);
		moneyField.setHidden(false);

		setFields(capitalDistributionLinkDepartmentIdField, capitalDistributionIdField, departmentIdField, moneyField);
	}

}
