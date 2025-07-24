package com.pomplatform.client.stage.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSsystemdictionaryor extends DBDataSource
{


	public static DSSsystemdictionaryor instance = null;

	public static DSSsystemdictionaryor getInstance() {
		if(instance == null) {
			instance = new DSSsystemdictionaryor("DSSsystemdictionaryor");
		}
		return instance;
	}

	private final DataSourceIntegerField dicTypeValueIdField;
	private final DataSourceTextField dicTypeValueField;
	private final DataSourceFloatField percentField;

	public DSSsystemdictionaryor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Ssystemdictionaryor");


		dicTypeValueIdField = new DataSourceIntegerField("dicTypeValueId", "数据编码");
		dicTypeValueIdField.setLength(11);
		dicTypeValueIdField.setRequired(false);
		dicTypeValueIdField.setHidden(false);


		dicTypeValueField = new DataSourceTextField("dicTypeValue", "数据值");
		dicTypeValueField.setLength(64);
		dicTypeValueField.setRequired(false);
		dicTypeValueField.setHidden(false);
		

		percentField = new DataSourceFloatField("percent", "阶段占比(%)");
		percentField.setLength(12);
		percentField.setDecimalPad(2);
		percentField.setFormat("#,###,###,##0.00");
		percentField.setRequired(false);
		percentField.setHidden(false);


		setFields(dicTypeValueIdField, dicTypeValueField,percentField);
	}


}

