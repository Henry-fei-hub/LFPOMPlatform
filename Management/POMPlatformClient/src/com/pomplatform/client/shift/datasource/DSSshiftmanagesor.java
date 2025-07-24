package com.pomplatform.client.shift.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSshiftmanagesor extends DBDataSource
{


	public static DSSshiftmanagesor instance = null;

	public static DSSshiftmanagesor getInstance() {
		if(instance == null) {
			instance = new DSSshiftmanagesor("DSSshiftmanagesor");
		}
		return instance;
	}

	private final DataSourceIntegerField shiftManageIdField;
	private final DataSourceTextField shiftNameField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceBooleanField isEnableField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField remarkField;

	public DSSshiftmanagesor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sshiftmanagesor");


		shiftManageIdField = new DataSourceIntegerField("shiftManageId", "主键编码");
		shiftManageIdField.setLength(11);
		shiftManageIdField.setPrimaryKey(true);
		shiftManageIdField.setRequired(true);
		shiftManageIdField.setHidden(true);


		shiftNameField = new DataSourceTextField("shiftName", "班次名称");
		shiftNameField.setLength(64);
		shiftNameField.setRequired(false);
		shiftNameField.setHidden(false);


		startDateField = new DataSourceDateField("startDate", "起用日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);


		endDateField = new DataSourceDateField("endDate", "结束日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);


		isEnableField = new DataSourceBooleanField("isEnable", "是否启用");
		isEnableField.setRequired(false);
		isEnableField.setHidden(false);


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(true);


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(shiftManageIdField, shiftNameField, startDateField, endDateField, isEnableField, operateEmployeeIdField, operateTimeField, remarkField);
	}


}

