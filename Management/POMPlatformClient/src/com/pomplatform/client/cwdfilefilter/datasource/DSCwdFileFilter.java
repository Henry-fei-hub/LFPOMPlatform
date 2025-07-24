package com.pomplatform.client.cwdfilefilter.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSCwdFileFilter extends DBDataSource
{


	public static DSCwdFileFilter instance = null;

	public static DSCwdFileFilter getInstance() {
		if(instance == null) {
			instance = new DSCwdFileFilter("DSCwdFileFilter");
		}
		return instance;
	}

	private final DataSourceIntegerField fileFilterIdField;
	private final DataSourceIntegerField typeField;
	private final DataSourceTextField filterFileExtensionField;
	private final DataSourceTextField remarkField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField deleteFlagField;

	public DSCwdFileFilter(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("CwdFileFilter");


		fileFilterIdField = new DataSourceIntegerField("fileFilterId", "主键");
		fileFilterIdField.setLength(11);
		fileFilterIdField.setPrimaryKey(true);
		fileFilterIdField.setRequired(true);
		fileFilterIdField.setHidden(true);


		typeField = new DataSourceIntegerField("type", "类型");
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setHidden(false);
		typeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_190"));


		filterFileExtensionField = new DataSourceTextField("filterFileExtension", "文件后缀名称");
		filterFileExtensionField.setLength(255);
		filterFileExtensionField.setRequired(false);
		filterFileExtensionField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "描述");
		remarkField.setLength(255);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		deleteFlagField = new DataSourceIntegerField("deleteFlag", "删除标志 0未删除  1已删除");
		deleteFlagField.setLength(11);
		deleteFlagField.setRequired(false);
		deleteFlagField.setHidden(true);


		setFields(fileFilterIdField, typeField, filterFileExtensionField, remarkField, createTimeField, deleteFlagField);
	}


}

