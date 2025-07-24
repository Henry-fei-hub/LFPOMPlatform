package com.pomplatform.client.websitenews.datasource;

import java.util.LinkedHashMap;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceLinkField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSwebsitenewntfor extends DBDataSource
{


	public static DSSwebsitenewntfor instance = null;

	public static DSSwebsitenewntfor getInstance() {
		if(instance == null) {
			instance = new DSSwebsitenewntfor("DSSwebsitenewntfor");
		}
		return instance;
	}

	private final DataSourceIntegerField websiteNewIdField;
	private final DataSourceTextField titleField;
	private final DataSourceLinkField fileUrlField;
	private final DataSourceIntegerField attachmentIdField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceTextField contentField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField newTypeField;
	private final DataSourceIntegerField deleteFlagField;
	private final DataSourceIntegerField orderNumField;

	public DSSwebsitenewntfor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Swebsitenewntfor");


		websiteNewIdField = new DataSourceIntegerField("websiteNewId", "主键");
		websiteNewIdField.setLength(11);
		websiteNewIdField.setPrimaryKey(true);
		websiteNewIdField.setRequired(true);
		websiteNewIdField.setHidden(true);


		titleField = new DataSourceTextField("title", "主题");
		titleField.setLength(600);
		titleField.setRequired(false);
		titleField.setHidden(false);


		fileUrlField = new DataSourceLinkField("fileUrl", "文件路径");
		fileUrlField.setLength(255);
		fileUrlField.setRequired(false);
		fileUrlField.setHidden(false);
		
		
		attachmentIdField = new DataSourceIntegerField("attachmentId", "文件ID");
		attachmentIdField.setLength(11);
		attachmentIdField.setRequired(false);
		attachmentIdField.setHidden(true);


		attachmentNameField = new DataSourceTextField("attachmentName", "文件名称");
		attachmentNameField.setLength(512);
		attachmentNameField.setRequired(false);
		attachmentNameField.setHidden(false);


		contentField = new DataSourceTextField("content", "内容");
		contentField.setLength(6000);
		contentField.setRequired(false);
		contentField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		newTypeField = new DataSourceIntegerField("newType", "新闻类型  1公告");
		newTypeField.setLength(11);
		newTypeField.setRequired(false);
		newTypeField.setHidden(true);


		deleteFlagField = new DataSourceIntegerField("deleteFlag", "是否删除");
		deleteFlagField.setLength(11);
		deleteFlagField.setRequired(false);
		deleteFlagField.setHidden(false);
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("1", "未删除");
		map.put("2", "已删除");
		deleteFlagField.setValueMap(map);

		orderNumField = new DataSourceIntegerField("orderNum", "排序标志 值越大越靠前");
		orderNumField.setLength(11);
		orderNumField.setRequired(false);
		orderNumField.setHidden(false);


		setFields(websiteNewIdField, titleField, attachmentNameField, attachmentIdField, fileUrlField, contentField, createTimeField, newTypeField, deleteFlagField, orderNumField);
	}


}

