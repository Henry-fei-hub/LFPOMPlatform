package com.pomplatform.client.k3code.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDAllCardManage extends DataSource
{


	public static CDAllCardManage instance = null;

	public static CDAllCardManage getInstance() {
		if(instance == null) {
			instance = new CDAllCardManage("CDAllCardManage");
		}
		return instance;
	}

	private final DataSourceIntegerField objectTypeField;
	private final DataSourceBooleanField enabledField;
	private final DataSourceIntegerField cardManageIdField;

	public CDAllCardManage(String dataSourceID) {

		setID(dataSourceID);
		objectTypeField = new DataSourceIntegerField("objectType", "2单位)");
		objectTypeField.setRequired(false);
		objectTypeField.setLength(11);
		objectTypeField.setHidden(false);

		enabledField = new DataSourceBooleanField("enabled", "是否启用");
		enabledField.setRequired(false);
		enabledField.setHidden(false);

		cardManageIdField = new DataSourceIntegerField("cardManageId", "主键编码");
		cardManageIdField.setRequired(true);
		cardManageIdField.setLength(11);
		cardManageIdField.setPrimaryKey(true);
		cardManageIdField.setHidden(true);

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


		setFields(objectTypeField, enabledField, cardManageIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

