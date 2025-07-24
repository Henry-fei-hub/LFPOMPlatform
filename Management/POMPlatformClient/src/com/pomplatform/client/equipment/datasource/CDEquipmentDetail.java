package com.pomplatform.client.equipment.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDEquipmentDetail extends DataSource
{


	public static CDEquipmentDetail instance = null;

	public static CDEquipmentDetail getInstance() {
		if(instance == null) {
			instance = new CDEquipmentDetail("CDEquipmentDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField nextAuditorField;
	private final DataSourceIntegerField operationTypeField;
	private final DataSourceDateTimeField startDateField;
	private final DataSourceDateTimeField endDateField;

	public CDEquipmentDetail(String dataSourceID) {

		setID(dataSourceID);
		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);

		nextAuditorField = new DataSourceIntegerField("nextAuditor", "物品类型");
		nextAuditorField.setRequired(false);
		nextAuditorField.setLength(11);
		nextAuditorField.setHidden(false);

		operationTypeField = new DataSourceIntegerField("operationType", "操作类型（3新增，4库存调整，0领用，1借用，2归还）");
		operationTypeField.setRequired(false);
		operationTypeField.setLength(5);
		operationTypeField.setHidden(false);

		startDateField = new DataSourceDateTimeField("startDate", "操作时间(开始)");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateTimeField("endDate", "操作时间(结束)");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

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


		setFields(departmentIdField, employeeNameField, nextAuditorField, operationTypeField, startDateField, endDateField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

