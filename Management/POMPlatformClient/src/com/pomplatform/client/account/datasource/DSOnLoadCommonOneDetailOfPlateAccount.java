package com.pomplatform.client.account.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnLoadCommonOneDetailOfPlateAccount extends DBDataSource
{


	public static DSOnLoadCommonOneDetailOfPlateAccount instance = null;

	public static DSOnLoadCommonOneDetailOfPlateAccount getInstance() {
		if(instance == null) {
			instance = new DSOnLoadCommonOneDetailOfPlateAccount("DSOnLoadCommonOneDetailOfPlateAccount");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceFloatField integralField;
	private final DataSourceDateField recordDateField;
	private final DataSourceTextField remarkField;

	public DSOnLoadCommonOneDetailOfPlateAccount(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadCommonOneDetailOfPlateAccount");


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


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


		setFields(plateIdField, integralField, recordDateField, remarkField);
	}


}

