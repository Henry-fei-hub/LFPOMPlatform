package com.pomplatform.client.sprocessbilllistpppor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSprocessbilllistpppor extends DataSource
{


	public static CDSprocessbilllistpppor instance = null;

	public static CDSprocessbilllistpppor getInstance() {
		if(instance == null) {
			instance = new CDSprocessbilllistpppor("CDSprocessbilllistpppor");
		}
		return instance;
	}

	private final DataSourceIntegerField processBillListIdField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceIntegerField payForField;
	private final DataSourceIntegerField employeeOrCompanyIdField;

	public CDSprocessbilllistpppor(String dataSourceID) {

		setID(dataSourceID);
		processBillListIdField = new DataSourceIntegerField("processBillListId", "主键");
		processBillListIdField.setRequired(true);
		processBillListIdField.setLength(11);
		processBillListIdField.setPrimaryKey(true);
		processBillListIdField.setHidden(true);

		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程实例编码");
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setLength(11);
		processInstanceIdField.setHidden(false);

		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		businessIdField = new DataSourceIntegerField("businessId", "业务Id");
		businessIdField.setRequired(false);
		businessIdField.setLength(11);
		businessIdField.setHidden(false);

		payForField = new DataSourceIntegerField("payFor", "1 员工  2收款单位");
		payForField.setRequired(false);
		payForField.setLength(11);
		payForField.setHidden(false);

		employeeOrCompanyIdField = new DataSourceIntegerField("employeeOrCompanyId", "员工或者收款单位Id");
		employeeOrCompanyIdField.setRequired(false);
		employeeOrCompanyIdField.setLength(11);
		employeeOrCompanyIdField.setHidden(false);

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


		setFields(processBillListIdField, processInstanceIdField, processTypeField, businessIdField, payForField, employeeOrCompanyIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

