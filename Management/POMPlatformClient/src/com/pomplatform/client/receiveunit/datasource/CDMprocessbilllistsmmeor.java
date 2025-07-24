package com.pomplatform.client.receiveunit.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMprocessbilllistsmmeor extends DataSource
{


	public static CDMprocessbilllistsmmeor instance = null;

	public static CDMprocessbilllistsmmeor getInstance() {
		if(instance == null) {
			instance = new CDMprocessbilllistsmmeor("CDMprocessbilllistsmmeor");
		}
		return instance;
	}

	private final DataSourceTextField payeeNameField;
	private final DataSourceDateTimeField minCompleteTimeField;
	private final DataSourceDateTimeField maxCompleteTimeField;
	private final DataSourceIntegerField employeeIdField;

	public CDMprocessbilllistsmmeor(String dataSourceID) {

		setID(dataSourceID);
		payeeNameField = new DataSourceTextField("payeeName", "收款方");
		payeeNameField.setRequired(false);
		payeeNameField.setLength(128);
		payeeNameField.setHidden(false);

		minCompleteTimeField = new DataSourceDateTimeField("minCompleteTime", "最早完成时间");
		minCompleteTimeField.setRequired(false);
		minCompleteTimeField.setHidden(false);

		maxCompleteTimeField = new DataSourceDateTimeField("maxCompleteTime", "最晚完成时间");
		maxCompleteTimeField.setRequired(false);
		maxCompleteTimeField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "创建人");
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


		setFields(payeeNameField, minCompleteTimeField, maxCompleteTimeField, employeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

