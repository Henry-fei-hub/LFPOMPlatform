package com.pomplatform.client.minvoicettorunusecount.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMinvoicettorunusecount extends DBDataSource
{


	public static DSMinvoicettorunusecount instance = null;

	public static DSMinvoicettorunusecount getInstance() {
		if(instance == null) {
			instance = new DSMinvoicettorunusecount("DSMinvoicettorunusecount");
		}
		return instance;
	}

	private final DataSourceIntegerField ticketingCompanyField;
	private final DataSourceTextField allValField;

	public DSMinvoicettorunusecount(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Minvoicettorunusecount");


		ticketingCompanyField = new DataSourceIntegerField("ticketingCompany", "购票公司");
		ticketingCompanyField.setLength(11);
		ticketingCompanyField.setRequired(false);
		ticketingCompanyField.setHidden(false);
		ticketingCompanyField.setValueMap(KeyValueManager.getValueMap("system_dictionary_54"));


		allValField = new DataSourceTextField("allVal", "统计数据");
		allValField.setLength(-1);
		allValField.setRequired(true);
		allValField.setHidden(false);


		setFields(ticketingCompanyField, allValField);
	}


}

