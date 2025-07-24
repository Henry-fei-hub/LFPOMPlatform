package com.pomplatform.client.employee.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.DBDataSource;

public class DSDictionartManagenment extends DBDataSource
{


	public static DSDictionartManagenment instance = null;

	public static DSDictionartManagenment getInstance() {
		if(instance == null) {
			instance = new DSDictionartManagenment("DSDictionartManagenment");
		}
		return instance;
	}

	private final DataSourceIntegerField dicTypeIdField;
	private final DataSourceTextField dicTypeNameField;
	private final DataSourceIntegerField dictionaryIdField;
	private final DataSourceIntegerField dicTypeValueIdField;
	private final DataSourceTextField dicTypeValueField;
	private final DataSourceIntegerField parentIdField;

	public DSDictionartManagenment(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("DictionartManagementProcessor");

		dictionaryIdField = new DataSourceIntegerField("dictionaryId", "主键ID");
		dictionaryIdField.setPrimaryKey(true);
		dictionaryIdField.setLength(11);
		dictionaryIdField.setRequired(false);
		dictionaryIdField.setHidden(false);

		dicTypeIdField = new DataSourceIntegerField("dicTypeId", "列表数据代码");
		dicTypeIdField.setLength(11);
		dicTypeIdField.setRequired(false);
		dicTypeIdField.setHidden(true);


		dicTypeNameField = new DataSourceTextField("dicTypeName", "列表数据名称");
		dicTypeNameField.setLength(64);
		dicTypeNameField.setRequired(false);
		dicTypeNameField.setHidden(false);

		dicTypeValueIdField = new DataSourceIntegerField("dicTypeValueId", "数据编码");
		dicTypeValueIdField.setLength(64);
		dicTypeValueIdField.setRequired(false);
		dicTypeValueIdField.setHidden(false);

		dicTypeValueField = new DataSourceTextField("dicTypeValue","数据名称");
		dicTypeValueField.setLength(64);
		dicTypeValueField.setRequired(false);
		dicTypeValueField.setRequired(false);
		dicTypeValueField.setHidden(false);

		parentIdField = new DataSourceIntegerField("parentId","上级ID");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(true);
		parentIdField.setForeignKey(dataSourceID+".dictionaryId");
		parentIdField.setRootValue(0);


		setFields(dictionaryIdField,dicTypeIdField, dicTypeNameField,dicTypeValueIdField,dicTypeValueField,parentIdField);
	}


}

