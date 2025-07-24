package com.pomplatform.client.goodsreceive.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSGoodsreceive extends DBDataSource
{


	public static DSGoodsreceive instance = null;

	public static DSGoodsreceive getInstance() {
		if(instance == null) {
			instance = new DSGoodsreceive("DSGoodsreceive");
		}
		return instance;
	}

	private final DataSourceIntegerField goodsReceiveIdField;
	private final DataSourceTextField subjectField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField receiveDateField;
	private final DataSourceIntegerField countField;
	private final DataSourceIntegerField createPersonIdField;
	private final DataSourceIntegerField fileManageIdField;
	private final DataSourceTextField goodsDetailField;
	private final DataSourceIntegerField receivePersonNumberField;
	private final DataSourceIntegerField receiveCountField;

	public DSGoodsreceive(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Goodsreceive");


		goodsReceiveIdField = new DataSourceIntegerField("goodsReceiveId", "主键编码");
		goodsReceiveIdField.setLength(11);
		goodsReceiveIdField.setPrimaryKey(true);
		goodsReceiveIdField.setRequired(true);
		goodsReceiveIdField.setHidden(false);
		goodsReceiveIdField.setRootValue("root");
		goodsReceiveIdField.setForeignKey("DSGoodsreceive.goodsReceiveId");

		subjectField = new DataSourceTextField("subject", "主题");
		subjectField.setLength(255);
		subjectField.setRequired(false);
		subjectField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		receiveDateField = new DataSourceDateTimeField("receiveDate", "领取日期");
		receiveDateField.setRequired(false);
		receiveDateField.setHidden(false);


		countField = new DataSourceIntegerField("count", "物品数量");
		countField.setLength(11);
		countField.setRequired(false);
		countField.setHidden(false);


		createPersonIdField = new DataSourceIntegerField("createPersonId", "创建人");
		createPersonIdField.setLength(11);
		createPersonIdField.setRequired(false);
		createPersonIdField.setHidden(false);
		createPersonIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		fileManageIdField = new DataSourceIntegerField("fileManageId", "文件管理编码");
		fileManageIdField.setLength(11);
		fileManageIdField.setRequired(false);
		fileManageIdField.setHidden(true);


		goodsDetailField = new DataSourceTextField("goodsDetail", "物品详情");
		goodsDetailField.setLength(255);
		goodsDetailField.setRequired(false);
		goodsDetailField.setHidden(false);


		receivePersonNumberField = new DataSourceIntegerField("receivePersonNumber", "领取人数");
		receivePersonNumberField.setLength(8);
		receivePersonNumberField.setRequired(true);
		receivePersonNumberField.setHidden(false);


		receiveCountField = new DataSourceIntegerField("receiveCount", "领取数量");
		receiveCountField.setLength(8);
		receiveCountField.setRequired(true);
		receiveCountField.setHidden(true);


		setFields(goodsReceiveIdField, subjectField, createTimeField, receiveDateField, countField, createPersonIdField, fileManageIdField, goodsDetailField, receivePersonNumberField, receiveCountField);
	}


}

