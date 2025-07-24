package com.pomplatform.client.employeemoneymanagespeemmepemmor.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMcapitaldistributionlinkdepartmentdcor extends DBDataSource
{


	public static DSMcapitaldistributionlinkdepartmentdcor instance = null;

	public static DSMcapitaldistributionlinkdepartmentdcor getInstance() {
		if(instance == null) {
			instance = new DSMcapitaldistributionlinkdepartmentdcor("DSMcapitaldistributionlinkdepartmentdcor");
		}
		return instance;
	}

	private final DataSourceIntegerField capitalDistributionLinkDepartmentIdField;
	private final DataSourceIntegerField capitalDistributionIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceFloatField moneyField;
	private final DataSourceTextField departmentNameField;
	private final DataSourceIntegerField capitalIdField;
	private final DataSourceDateTimeField createTimeField;

	public DSMcapitaldistributionlinkdepartmentdcor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mcapitaldistributionlinkdepartmentdcor");


		capitalDistributionLinkDepartmentIdField = new DataSourceIntegerField("capitalDistributionLinkDepartmentId", "主键");
		capitalDistributionLinkDepartmentIdField.setLength(11);
		capitalDistributionLinkDepartmentIdField.setPrimaryKey(true);
		capitalDistributionLinkDepartmentIdField.setRequired(true);
		capitalDistributionLinkDepartmentIdField.setHidden(false);


		capitalDistributionIdField = new DataSourceIntegerField("capitalDistributionId", "回款分配编码");
		capitalDistributionIdField.setLength(11);
		capitalDistributionIdField.setRequired(false);
		capitalDistributionIdField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "部门编码");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);


		moneyField = new DataSourceFloatField("money", "金额");
		moneyField.setLength(16);
		moneyField.setDecimalPad(2);
		moneyField.setFormat("##,###,###,###,##0.00");
		moneyField.setRequired(false);
		moneyField.setHidden(false);


		departmentNameField = new DataSourceTextField("departmentName", "部门名称");
		departmentNameField.setLength(64);
		departmentNameField.setRequired(true);
		departmentNameField.setHidden(false);


		capitalIdField = new DataSourceIntegerField("capitalId", "收款主键(手动分配回款使用)");
		capitalIdField.setLength(11);
		capitalIdField.setRequired(false);
		capitalIdField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		setFields(capitalDistributionLinkDepartmentIdField, capitalDistributionIdField, departmentIdField, moneyField, departmentNameField, capitalIdField, createTimeField);
	}


}

