package com.pomplatform.client.manageprojectemployee.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDManageProjectEmployee extends DataSource
{


	public static CDManageProjectEmployee instance = null;

	public static CDManageProjectEmployee getInstance() {
		if(instance == null) {
			instance = new CDManageProjectEmployee("CDManageProjectEmployee");
		}
		return instance;
	}

	private final DataSourceIntegerField manageProjectIdField;
	private final DataSourceIntegerField employeeIdField;

	public CDManageProjectEmployee(String dataSourceID) {

		setID(dataSourceID);
		manageProjectIdField = new DataSourceIntegerField("manageProjectId", "管理项目");
		manageProjectIdField.setRequired(false);
		manageProjectIdField.setLength(11);
		manageProjectIdField.setHidden(false);
//		manageProjectIdField.setValueMap(KeyValueManager.getValueMap("manage_projects"));
		KeyValueManager.loadValueMap("manage_projects", manageProjectIdField);
		employeeIdField = new DataSourceIntegerField("employeeId", "发放成员");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

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


		setFields(manageProjectIdField, employeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

