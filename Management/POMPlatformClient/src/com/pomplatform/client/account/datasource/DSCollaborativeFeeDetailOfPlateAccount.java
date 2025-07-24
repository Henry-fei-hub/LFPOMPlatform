package com.pomplatform.client.account.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSCollaborativeFeeDetailOfPlateAccount extends DBDataSource
{


	public static DSCollaborativeFeeDetailOfPlateAccount instance = null;

	public static DSCollaborativeFeeDetailOfPlateAccount getInstance() {
		if(instance == null) {
			instance = new DSCollaborativeFeeDetailOfPlateAccount("DSCollaborativeFeeDetailOfPlateAccount");
		}
		return instance;
	}

	private final DataSourceIntegerField fromPlateIdField;
	private final DataSourceIntegerField toPlateIdField;
	private final DataSourceFloatField integralField;
	private final DataSourceDateField recordDateField;
	private final DataSourceTextField remarkField;

	public DSCollaborativeFeeDetailOfPlateAccount(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("CollaborativeFeeDetailOfPlateAccount");


		fromPlateIdField = new DataSourceIntegerField("fromPlateId", "积分提取部门");
		fromPlateIdField.setLength(11);
		fromPlateIdField.setRequired(false);
		fromPlateIdField.setHidden(false);
		fromPlateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));


		toPlateIdField = new DataSourceIntegerField("toPlateId", "积分发放部门");
		toPlateIdField.setLength(11);
		toPlateIdField.setRequired(false);
		toPlateIdField.setHidden(false);
		toPlateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));


		integralField = new DataSourceFloatField("integral", "积分");
		integralField.setLength(18);
		integralField.setDecimalPad(2);
		integralField.setFormat("#,###,###,###,###,##0.00");
		integralField.setRequired(false);
		integralField.setHidden(false);


		recordDateField = new DataSourceDateField("recordDate", "日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(fromPlateIdField, toPlateIdField, integralField, recordDateField, remarkField);
	}


}

