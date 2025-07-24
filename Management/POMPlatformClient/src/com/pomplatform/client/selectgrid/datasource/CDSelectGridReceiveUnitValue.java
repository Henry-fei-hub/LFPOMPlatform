package com.pomplatform.client.selectgrid.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSelectGridReceiveUnitValue extends DataSource
{


	public static CDSelectGridReceiveUnitValue instance = null;

	public static CDSelectGridReceiveUnitValue getInstance() {
		if(instance == null) {
			instance = new CDSelectGridReceiveUnitValue("CDSelectGridReceiveUnitValue");
		}
		return instance;
	}

	private final DataSourceIntegerField receiveUnitManageIdField;
	private final DataSourceIntegerField originField;
	private final DataSourceTextField receiveUnitField;
	private final DataSourceTextField bankNameField;
	private final DataSourceTextField receiveUnitAddressField;

	public CDSelectGridReceiveUnitValue(String dataSourceID) {

		setID(dataSourceID);
		receiveUnitManageIdField = new DataSourceIntegerField("receiveUnitManageId", "主键编码");
		receiveUnitManageIdField.setRequired(true);
		receiveUnitManageIdField.setLength(11);
		receiveUnitManageIdField.setPrimaryKey(true);
		receiveUnitManageIdField.setHidden(true);

		originField = new DataSourceIntegerField("origin", "来源");
		originField.setRequired(false);
		originField.setLength(11);
		originField.setHidden(false);

		receiveUnitField = new DataSourceTextField("receiveUnit", "收款单位");
		receiveUnitField.setRequired(false);
		receiveUnitField.setLength(128);
		receiveUnitField.setHidden(false);

		bankNameField = new DataSourceTextField("bankName", "开户行");
		bankNameField.setRequired(false);
		bankNameField.setLength(128);
		bankNameField.setHidden(false);

		receiveUnitAddressField = new DataSourceTextField("receiveUnitAddress", "收款单位所在地");
		receiveUnitAddressField.setRequired(false);
		receiveUnitAddressField.setLength(128);
		receiveUnitAddressField.setHidden(false);

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


		setFields(receiveUnitManageIdField, originField, receiveUnitField, bankNameField, receiveUnitAddressField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

