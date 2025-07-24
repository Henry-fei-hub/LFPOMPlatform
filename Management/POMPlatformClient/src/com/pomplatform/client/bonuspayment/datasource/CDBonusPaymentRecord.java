package com.pomplatform.client.bonuspayment.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDBonusPaymentRecord extends DataSource
{


	public static CDBonusPaymentRecord instance = null;

	public static CDBonusPaymentRecord getInstance() {
		if(instance == null) {
			instance = new CDBonusPaymentRecord("CDBonusPaymentRecord");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceDateTimeField startDateField;
	private final DataSourceDateTimeField endDateField;
	private final DataSourceIntegerField stateField;

	public CDBonusPaymentRecord(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		startDateField = new DataSourceDateTimeField("startDate", "开始时间");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateTimeField("endDate", "结束时间");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

		stateField = new DataSourceIntegerField("state", "审核状态");
		stateField.setRequired(false);
		stateField.setLength(11);
		stateField.setHidden(false);
		stateField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

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


		setFields(plateIdField, startDateField, endDateField, stateField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

