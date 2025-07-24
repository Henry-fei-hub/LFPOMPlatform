package com.pomplatform.client.projectattachmentmanage.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDNonconformityAttachmentDetail extends DataSource
{


	public static CDNonconformityAttachmentDetail instance = null;

	public static CDNonconformityAttachmentDetail getInstance() {
		if(instance == null) {
			instance = new CDNonconformityAttachmentDetail("CDNonconformityAttachmentDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;

	public CDNonconformityAttachmentDetail(String dataSourceID) {

		setID(dataSourceID);
		projectIdField = new DataSourceIntegerField("projectId", "项目订单id");
		projectIdField.setRequired(true);
		projectIdField.setLength(11);
		projectIdField.setPrimaryKey(true);
		projectIdField.setHidden(true);

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


		setFields(projectIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

