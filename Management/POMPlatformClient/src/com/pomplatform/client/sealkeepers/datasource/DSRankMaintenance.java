package com.pomplatform.client.sealkeepers.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSRankMaintenance extends DBDataSource
{


	public static DSRankMaintenance instance = null;

	public static DSRankMaintenance getInstance() {
		if(instance == null) {
			instance = new DSRankMaintenance("DSRankMaintenance");
		}
		return instance;
	}

	private final DataSourceIntegerField dicTypeIdField;
	private final DataSourceIntegerField dicTypeValueIdField;
	private final DataSourceTextField dicTypeValueField;
	private final DataSourceFloatField coefficientField;

	public DSRankMaintenance(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("RankMaintenance");


		dicTypeIdField = new DataSourceIntegerField("dicTypeId", "列表数据代码");
		dicTypeIdField.setLength(11);
		dicTypeIdField.setRequired(false);
		dicTypeIdField.setHidden(true);


		dicTypeValueIdField = new DataSourceIntegerField("dicTypeValueId", "数据编码");
		dicTypeValueIdField.setLength(11);
		dicTypeValueIdField.setRequired(false);
		dicTypeValueIdField.setHidden(true);


		dicTypeValueField = new DataSourceTextField("dicTypeValue", "职级");
		dicTypeValueField.setLength(200);
		dicTypeValueField.setRequired(false);
		dicTypeValueField.setHidden(false);


		coefficientField = new DataSourceFloatField("coefficient", "职级系数");
		coefficientField.setLength(200);
		coefficientField.setDecimalPad(2);
		coefficientField.setFormat("###,###,###,###,###,###,###,###,###,##0.00");
		coefficientField.setRequired(false);
		coefficientField.setHidden(false);


		setFields(dicTypeIdField, dicTypeValueIdField, dicTypeValueField, coefficientField);
	}


}

