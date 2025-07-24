package com.pomplatform.client.goodsreceive.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDGoodsreceive extends DataSource
{


	public static CDGoodsreceive instance = null;

	public static CDGoodsreceive getInstance() {
		if(instance == null) {
			instance = new CDGoodsreceive("CDGoodsreceive");
		}
		return instance;
	}

	private final DataSourceIntegerField goodsReceiveIdField;
	private final DataSourceTextField subjectField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField receiveDateField;
	private final DataSourceIntegerField receiveCountField;

	public CDGoodsreceive(String dataSourceID) {

		setID(dataSourceID);
		goodsReceiveIdField = new DataSourceIntegerField("goodsReceiveId", "主键编码");
		goodsReceiveIdField.setRequired(true);
		goodsReceiveIdField.setLength(11);
		goodsReceiveIdField.setPrimaryKey(true);
		goodsReceiveIdField.setHidden(true);

		subjectField = new DataSourceTextField("subject", "主题");
		subjectField.setRequired(false);
		subjectField.setLength(255);
		subjectField.setHidden(false);

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);

		receiveDateField = new DataSourceDateTimeField("receiveDate", "日期");
		receiveDateField.setRequired(false);
		receiveDateField.setHidden(false);

		receiveCountField = new DataSourceIntegerField("receiveCount", "领用数量");
		receiveCountField.setRequired(false);
		receiveCountField.setLength(11);
		receiveCountField.setHidden(false);

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


		setFields(goodsReceiveIdField, subjectField, createTimeField, receiveDateField, receiveCountField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

