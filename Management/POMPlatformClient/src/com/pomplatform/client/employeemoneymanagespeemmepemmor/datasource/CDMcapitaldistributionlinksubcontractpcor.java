package com.pomplatform.client.employeemoneymanagespeemmepemmor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMcapitaldistributionlinksubcontractpcor extends DataSource
{


	public static CDMcapitaldistributionlinksubcontractpcor instance = null;

	public static CDMcapitaldistributionlinksubcontractpcor getInstance() {
		if(instance == null) {
			instance = new CDMcapitaldistributionlinksubcontractpcor("CDMcapitaldistributionlinksubcontractpcor");
		}
		return instance;
	}

	private final DataSourceIntegerField capitalIdField;

	public CDMcapitaldistributionlinksubcontractpcor(String dataSourceID) {

		setID(dataSourceID);
		capitalIdField = new DataSourceIntegerField("capitalId", "收款主键(手动分配回款使用)");
		capitalIdField.setRequired(false);
		capitalIdField.setLength(11);
		capitalIdField.setHidden(false);

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


		setFields(capitalIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

