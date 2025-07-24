package com.pomplatform.client.workflow.personnel.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDWorkingHoursLinkPersonnelBusiness extends DataSource
{


	public static CDWorkingHoursLinkPersonnelBusiness instance = null;

	public static CDWorkingHoursLinkPersonnelBusiness getInstance() {
		if(instance == null) {
			instance = new CDWorkingHoursLinkPersonnelBusiness("CDWorkingHoursLinkPersonnelBusiness");
		}
		return instance;
	}

	private final DataSourceIntegerField personnelBusinessIdField;

	public CDWorkingHoursLinkPersonnelBusiness(String dataSourceID) {

		setID(dataSourceID);
		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "人事业务编码");
		personnelBusinessIdField.setRequired(true);
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setPrimaryKey(true);
		personnelBusinessIdField.setHidden(true);

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


		setFields(personnelBusinessIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

