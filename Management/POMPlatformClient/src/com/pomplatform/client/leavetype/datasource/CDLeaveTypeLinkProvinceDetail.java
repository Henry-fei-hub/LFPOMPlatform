package com.pomplatform.client.leavetype.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDLeaveTypeLinkProvinceDetail extends DataSource
{


	public static CDLeaveTypeLinkProvinceDetail instance = null;

	public static CDLeaveTypeLinkProvinceDetail getInstance() {
		if(instance == null) {
			instance = new CDLeaveTypeLinkProvinceDetail("CDLeaveTypeLinkProvinceDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField leaveTypeIdField;

	public CDLeaveTypeLinkProvinceDetail(String dataSourceID) {

		setID(dataSourceID);
		leaveTypeIdField = new DataSourceIntegerField("leaveTypeId", "请假类型编码");
		leaveTypeIdField.setRequired(false);
		leaveTypeIdField.setLength(11);
		leaveTypeIdField.setHidden(false);

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


		setFields(leaveTypeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

