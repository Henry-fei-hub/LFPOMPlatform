package com.pomplatform.client.goodsreceivedetail.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSGoodsreceivedetail extends DBDataSource
{


	public static DSGoodsreceivedetail instance = null;

	public static DSGoodsreceivedetail getInstance() {
		if(instance == null) {
			instance = new DSGoodsreceivedetail("DSGoodsreceivedetail");
		}
		return instance;
	}

	private final DataSourceIntegerField goodsReceiveDetailIdField;
	private final DataSourceIntegerField goodsReceiveIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNumberField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceDateTimeField receiveTimeField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField isReceiveField;
	private final DataSourceIntegerField receiveCountField;

	public DSGoodsreceivedetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Goodsreceivedetail");


		goodsReceiveDetailIdField = new DataSourceIntegerField("goodsReceiveDetailId", "主键ID");
		goodsReceiveDetailIdField.setLength(11);
		goodsReceiveDetailIdField.setPrimaryKey(true);
		goodsReceiveDetailIdField.setRequired(true);
		goodsReceiveDetailIdField.setHidden(false);

		goodsReceiveIdField = new DataSourceIntegerField("goodsReceiveId", "物品领用ID");
		goodsReceiveIdField.setLength(11);
		goodsReceiveIdField.setPrimaryKey(true);
		goodsReceiveIdField.setRequired(true);
		goodsReceiveIdField.setHidden(false);
		goodsReceiveIdField.setForeignKey("DSGoodsreceive.goodsReceiveId");


		employeeIdField = new DataSourceIntegerField("employeeId", "领用人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
//		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees",employeeIdField);


		employeeNumberField = new DataSourceTextField("employeeNumber", "领用人的工号");
		employeeNumberField.setLength(32);
		employeeNumberField.setRequired(false);
		employeeNumberField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		receiveTimeField = new DataSourceDateTimeField("receiveTime", "领用时间");
		receiveTimeField.setRequired(false);
		receiveTimeField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "领用人姓名");
		employeeNameField.setLength(255);
		employeeNameField.setRequired(false);
		employeeNameField.setHidden(false);


		isReceiveField = new DataSourceIntegerField("isReceive", "是否已经领用");
		isReceiveField.setLength(11);
		isReceiveField.setRequired(false);
		isReceiveField.setHidden(true);


		receiveCountField = new DataSourceIntegerField("receiveCount", "领取数量");
		receiveCountField.setLength(8);
		receiveCountField.setRequired(true);
		receiveCountField.setHidden(false);


		setFields(goodsReceiveDetailIdField, goodsReceiveIdField, employeeIdField, employeeNumberField, employeeNameField, departmentIdField, receiveTimeField,  isReceiveField, receiveCountField);
	}


}

