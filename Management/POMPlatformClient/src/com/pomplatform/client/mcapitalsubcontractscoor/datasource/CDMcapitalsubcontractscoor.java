package com.pomplatform.client.mcapitalsubcontractscoor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMcapitalsubcontractscoor extends DataSource
{


	public static CDMcapitalsubcontractscoor instance = null;

	public static CDMcapitalsubcontractscoor getInstance() {
		if(instance == null) {
			instance = new CDMcapitalsubcontractscoor("CDMcapitalsubcontractscoor");
		}
		return instance;
	}

	private final DataSourceIntegerField capitalIdField;
	private final DataSourceIntegerField operatorIdField;

	public CDMcapitalsubcontractscoor(String dataSourceID) {

		setID(dataSourceID);
		capitalIdField = new DataSourceIntegerField("capitalId", "回款编码");
		capitalIdField.setRequired(false);
		capitalIdField.setLength(11);
		capitalIdField.setHidden(false);

		operatorIdField = new DataSourceIntegerField("operatorId", "操作人");
		operatorIdField.setRequired(false);
		operatorIdField.setLength(11);
		operatorIdField.setHidden(false);

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


		setFields(capitalIdField, operatorIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

