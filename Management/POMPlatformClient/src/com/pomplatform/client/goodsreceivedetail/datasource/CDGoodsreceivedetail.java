package com.pomplatform.client.goodsreceivedetail.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDGoodsreceivedetail extends DataSource
{


	public static CDGoodsreceivedetail instance = null;

	public static CDGoodsreceivedetail getInstance() {
		if(instance == null) {
			instance = new CDGoodsreceivedetail("CDGoodsreceivedetail");
		}
		return instance;
	}

	private final DataSourceIntegerField goodsReceiveDetailIdField;
	private final DataSourceIntegerField goodsReceiveIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceDateTimeField receiveTimeField;

	public CDGoodsreceivedetail(String dataSourceID) {

		setID(dataSourceID);
		goodsReceiveDetailIdField = new DataSourceIntegerField("goodsReceiveDetailId", "主键编码");
		goodsReceiveDetailIdField.setRequired(true);
		goodsReceiveDetailIdField.setLength(11);
		goodsReceiveDetailIdField.setPrimaryKey(true);
		goodsReceiveDetailIdField.setHidden(true);

		goodsReceiveIdField = new DataSourceIntegerField("goodsReceiveId", "主键编码");
		goodsReceiveIdField.setRequired(true);
		goodsReceiveIdField.setLength(11);
		goodsReceiveIdField.setPrimaryKey(true);
		goodsReceiveIdField.setHidden(true);

		employeeIdField = new DataSourceIntegerField("employeeId", "领用人的编码");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
//		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees", employeeIdField);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门编码");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		receiveTimeField = new DataSourceDateTimeField("receiveTime", "领用的时间");
		receiveTimeField.setRequired(false);
		receiveTimeField.setHidden(false);

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


		setFields(goodsReceiveDetailIdField, goodsReceiveIdField, employeeIdField, departmentIdField, receiveTimeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

