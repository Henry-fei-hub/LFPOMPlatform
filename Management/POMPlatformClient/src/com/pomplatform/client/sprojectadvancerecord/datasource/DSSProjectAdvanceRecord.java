package com.pomplatform.client.sprojectadvancerecord.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSProjectAdvanceRecord extends DBDataSource
{


	public static DSSProjectAdvanceRecord instance = null;

	public static DSSProjectAdvanceRecord getInstance() {
		if(instance == null) {
			instance = new DSSProjectAdvanceRecord("DSSProjectAdvanceRecord");
		}
		return instance;
	}

	private final DataSourceTextField plateIdField;
	private final DataSourceTextField projectIdField;
	private final DataSourceFloatField advanceIntegralField;
	private final DataSourceFloatField leftIntegralField;
	private final DataSourceDateField advanceDateField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceTextField remarkField;

	public DSSProjectAdvanceRecord(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SProjectAdvanceRecord");


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		projectIdField = new DataSourceTextField("projectId", "补贴项目");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);
		KeyValueManager.loadValueMap("projects",projectIdField);


		advanceIntegralField = new DataSourceFloatField("advanceIntegral", "补贴积分");
		advanceIntegralField.setLength(18);
		advanceIntegralField.setDecimalPad(2);
		advanceIntegralField.setFormat("#,###,###,###,###,##0.00");
		advanceIntegralField.setRequired(false);
		advanceIntegralField.setHidden(false);


		leftIntegralField = new DataSourceFloatField("leftIntegral", "剩余积分");
		leftIntegralField.setLength(18);
		leftIntegralField.setDecimalPad(2);
		leftIntegralField.setFormat("#,###,###,###,###,##0.00");
		leftIntegralField.setRequired(false);
		leftIntegralField.setHidden(false);


		advanceDateField = new DataSourceDateField("advanceDate", "补贴日期");
		advanceDateField.setRequired(false);
		advanceDateField.setHidden(false);


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(false);
		operateEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(plateIdField, projectIdField, advanceIntegralField, leftIntegralField, advanceDateField, operateEmployeeIdField, remarkField);
	}


}

