package com.pomplatform.client.projectemployee.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadProjectEmpByProcess extends DataSource
{


	public static CDOnLoadProjectEmpByProcess instance = null;

	public static CDOnLoadProjectEmpByProcess getInstance() {
		if(instance == null) {
			instance = new CDOnLoadProjectEmpByProcess("CDOnLoadProjectEmpByProcess");
		}
		return instance;
	}

	private final DataSourceIntegerField businessIdField;
	private final DataSourceIntegerField processStatusField;

	public CDOnLoadProjectEmpByProcess(String dataSourceID) {

		setID(dataSourceID);
		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setRequired(false);
		businessIdField.setLength(11);
		businessIdField.setHidden(false);

		processStatusField = new DataSourceIntegerField("processStatus", "流程状态 0 发起中  1");
		processStatusField.setRequired(false);
		processStatusField.setLength(11);
		processStatusField.setHidden(false);

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


		setFields(businessIdField, processStatusField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

