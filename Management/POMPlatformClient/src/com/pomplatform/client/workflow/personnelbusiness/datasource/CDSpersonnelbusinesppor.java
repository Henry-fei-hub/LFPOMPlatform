package com.pomplatform.client.workflow.personnelbusiness.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSpersonnelbusinesppor extends DataSource
{


	public static CDSpersonnelbusinesppor instance = null;

	public static CDSpersonnelbusinesppor getInstance() {
		if(instance == null) {
			instance = new CDSpersonnelbusinesppor("CDSpersonnelbusinesppor");
		}
		return instance;
	}

	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceIntegerField processTypeField;

	public CDSpersonnelbusinesppor(String dataSourceID) {

		setID(dataSourceID);
		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "人事业务编码");
		personnelBusinessIdField.setRequired(true);
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setPrimaryKey(true);
		personnelBusinessIdField.setHidden(true);

		processTypeField = new DataSourceIntegerField("processType", "类型 12请假  13出差  14打卡  15外出  16加班");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

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


		setFields(personnelBusinessIdField, processTypeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

