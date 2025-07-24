package com.pomplatform.client.customer.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSHolidayBless extends DBDataSource
{

	public static DSHolidayBless instance = null;
	public static DSHolidayBless getInstance() {
		if(instance == null) {
			instance = new DSHolidayBless("DSHolidayBless");
		}
		return instance;
	}

	private final DataSourceIntegerField holidayBlessManageIdField;
	private final DataSourceTextField holidayNameField;
	private final DataSourceDateField holidayDateField;
	private final DataSourceTextField holidayTypeField;
	private final DataSourceTextField sendObjectField;
	private final DataSourceTextField objectTypeField;
	private final DataSourceTextField blessWordsField;
	private final DataSourceDateTimeField operateTimeField;
	public DSHolidayBless(String dataSourceID) {
		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("HolidayBlessManage");

		holidayBlessManageIdField = new DataSourceIntegerField("holidayBlessManageId", "主键编码");
		holidayBlessManageIdField.setLength(11);
		holidayBlessManageIdField.setPrimaryKey(true);
		holidayBlessManageIdField.setRequired(true);
		holidayBlessManageIdField.setHidden(true);

		holidayNameField = new DataSourceTextField("holidayName", "节日名称");
		holidayNameField.setLength(128);
		holidayNameField.setRequired(false);
		holidayNameField.setHidden(false);
		

		holidayDateField = new DataSourceDateField("holidayDate", "节日日期");
		holidayDateField.setLength(64);
		holidayDateField.setRequired(false);
		holidayDateField.setHidden(false);
		
		holidayTypeField = new DataSourceTextField("holidayType", "节日类型");
		holidayTypeField.setLength(64);
		holidayTypeField.setRequired(false);
		holidayTypeField.setHidden(false);
		holidayTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_125"));
		
		sendObjectField = new DataSourceTextField("sendObject", "推送对象");
		sendObjectField.setLength(64);
		sendObjectField.setRequired(false);
		sendObjectField.setHidden(false);
		sendObjectField.setValueMap(KeyValueManager.getValueMap("system_dictionary_126"));
		
		objectTypeField = new DataSourceTextField("objectType", "对象类型");
		objectTypeField.setLength(64);
		objectTypeField.setRequired(false);
		objectTypeField.setHidden(false);
		objectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_75"));
		
		blessWordsField = new DataSourceTextField("blessWords", "祝福语");
		blessWordsField.setLength(12288);
		blessWordsField.setRequired(false);
		blessWordsField.setHidden(false);
		
		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);

		setFields(holidayBlessManageIdField,holidayNameField,holidayDateField,holidayTypeField,sendObjectField,objectTypeField,blessWordsField,operateTimeField);
	}


}

