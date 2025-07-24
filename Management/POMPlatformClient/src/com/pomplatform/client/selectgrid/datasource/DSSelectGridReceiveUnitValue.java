package com.pomplatform.client.selectgrid.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSelectGridReceiveUnitValue extends DBDataSource
{


	public static DSSelectGridReceiveUnitValue instance = null;

	public static DSSelectGridReceiveUnitValue getInstance() {
		if(instance == null) {
			instance = new DSSelectGridReceiveUnitValue("DSSelectGridReceiveUnitValue");
		}
		return instance;
	}

	private final DataSourceIntegerField receiveUnitManageIdField;
	private final DataSourceTextField receiveUnitField;
	private final DataSourceTextField bankAccountField;
	private final DataSourceTextField bankNameField;
	private final DataSourceTextField receiveUnitAddressField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceIntegerField originField;

	public DSSelectGridReceiveUnitValue(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SelectGridReceiveUnitValue");


		receiveUnitManageIdField = new DataSourceIntegerField("receiveUnitManageId", "主键编码");
		receiveUnitManageIdField.setLength(11);
		receiveUnitManageIdField.setPrimaryKey(true);
		receiveUnitManageIdField.setRequired(true);
		receiveUnitManageIdField.setHidden(false);


		receiveUnitField = new DataSourceTextField("receiveUnit", "收款单位");
		receiveUnitField.setLength(128);
		receiveUnitField.setRequired(false);
		receiveUnitField.setHidden(false);


		bankAccountField = new DataSourceTextField("bankAccount", "银行账号");
		bankAccountField.setLength(64);
		bankAccountField.setRequired(false);
		bankAccountField.setHidden(false);


		bankNameField = new DataSourceTextField("bankName", "开户行");
		bankNameField.setLength(128);
		bankNameField.setRequired(false);
		bankNameField.setHidden(false);


		receiveUnitAddressField = new DataSourceTextField("receiveUnitAddress", "收款单位所在地");
		receiveUnitAddressField.setLength(128);
		receiveUnitAddressField.setRequired(false);
		receiveUnitAddressField.setHidden(false);


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(false);


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);


		originField = new DataSourceIntegerField("origin", "来源");
		originField.setLength(11);
		originField.setRequired(false);
		originField.setHidden(false);


		setFields(receiveUnitManageIdField, receiveUnitField, bankAccountField, bankNameField, receiveUnitAddressField, operateEmployeeIdField, operateTimeField, originField);
	}


}

