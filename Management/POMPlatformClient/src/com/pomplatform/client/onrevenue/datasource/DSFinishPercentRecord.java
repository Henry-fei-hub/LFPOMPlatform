package com.pomplatform.client.onrevenue.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSFinishPercentRecord extends DBDataSource
{


	public static DSFinishPercentRecord instance = null;

	public static DSFinishPercentRecord getInstance() {
		if(instance == null) {
			instance = new DSFinishPercentRecord("DSFinishPercentRecord");
		}
		return instance;
	}

	private final DataSourceTextField sheetCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField finishPercentField;

	public DSFinishPercentRecord(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("FinishPercentRecord");

		sheetCodeField = new DataSourceTextField("sheetCode", "订单编号");
		sheetCodeField.setLength(64);
		sheetCodeField.setRequired(true);
		sheetCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "订单名称");
		projectNameField.setLength(64);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);
		
		finishPercentField = new DataSourceTextField("finishPercent", "订单完工比");
		finishPercentField.setLength(64);
		finishPercentField.setRequired(false);
		finishPercentField.setHidden(false);

		setFields(sheetCodeField, projectNameField, finishPercentField);
	}


}

