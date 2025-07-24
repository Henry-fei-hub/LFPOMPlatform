package com.pomplatform.client.revenue.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSPlateRateOfRevenue extends DBDataSource
{


	public static DSPlateRateOfRevenue instance = null;

	public static DSPlateRateOfRevenue getInstance() {
		if(instance == null) {
			instance = new DSPlateRateOfRevenue("DSPlateRateOfRevenue");
		}
		return instance;
	}

	private final DataSourceIntegerField plateRateRecordIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceFloatField modifyRatePercentField;
	private final DataSourceFloatField ratePercentField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField remarkField;

	public DSPlateRateOfRevenue(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("PlateRateRecord");


		plateRateRecordIdField = new DataSourceIntegerField("plateRateRecordId", "主键编码");
		plateRateRecordIdField.setLength(11);
		plateRateRecordIdField.setPrimaryKey(true);
		plateRateRecordIdField.setRequired(true);
		plateRateRecordIdField.setHidden(true);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		modifyRatePercentField = new DataSourceFloatField("modifyRatePercent", "税率");
		modifyRatePercentField.setLength(18);
		modifyRatePercentField.setDecimalPad(4);
		modifyRatePercentField.setFormat("##,###,###,###,##0.0000");
		modifyRatePercentField.setRequired(false);
		modifyRatePercentField.setHidden(false);


		ratePercentField = new DataSourceFloatField("ratePercent", "税率百分比");
		ratePercentField.setLength(18);
		ratePercentField.setDecimalPad(4);
		ratePercentField.setFormat("##,###,###,###,##0.0000");
		ratePercentField.setRequired(false);
		ratePercentField.setHidden(true);


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(false);
		operateEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(plateRateRecordIdField, plateIdField, modifyRatePercentField, ratePercentField, operateEmployeeIdField, operateTimeField, remarkField);
	}


}

