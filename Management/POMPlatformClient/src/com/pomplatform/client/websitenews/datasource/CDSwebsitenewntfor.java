package com.pomplatform.client.websitenews.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSwebsitenewntfor extends DataSource
{


	public static CDSwebsitenewntfor instance = null;

	public static CDSwebsitenewntfor getInstance() {
		if(instance == null) {
			instance = new CDSwebsitenewntfor("CDSwebsitenewntfor");
		}
		return instance;
	}

	private final DataSourceIntegerField newTypeField;
	private final DataSourceTextField titleField;
	private final DataSourceTextField fileUrlField;
	private final DataSourceTextField contentField;
	private final DataSourceIntegerField websiteNewIdField;
	private final DataSourceIntegerField deleteFlagField;

	public CDSwebsitenewntfor(String dataSourceID) {

		setID(dataSourceID);
		newTypeField = new DataSourceIntegerField("newType", "新闻类型  1公告");
		newTypeField.setRequired(false);
		newTypeField.setLength(11);
		newTypeField.setHidden(false);

		titleField = new DataSourceTextField("title", "主题");
		titleField.setRequired(false);
		titleField.setLength(600);
		titleField.setHidden(false);

		fileUrlField = new DataSourceTextField("fileUrl", "文件路径");
		fileUrlField.setRequired(false);
		fileUrlField.setLength(255);
		fileUrlField.setHidden(false);

		contentField = new DataSourceTextField("content", "内容");
		contentField.setRequired(false);
		contentField.setLength(6000);
		contentField.setHidden(false);

		websiteNewIdField = new DataSourceIntegerField("websiteNewId", "主键");
		websiteNewIdField.setRequired(true);
		websiteNewIdField.setLength(11);
		websiteNewIdField.setPrimaryKey(true);
		websiteNewIdField.setHidden(true);

		deleteFlagField = new DataSourceIntegerField("deleteFlag", "删除标志 1 未删除  2已删除");
		deleteFlagField.setRequired(false);
		deleteFlagField.setLength(11);
		deleteFlagField.setHidden(false);

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


		setFields(newTypeField, titleField, fileUrlField, contentField, websiteNewIdField, deleteFlagField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

