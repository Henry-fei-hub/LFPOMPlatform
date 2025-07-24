package com.pomplatform.client.purchase.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnSupplierAppraiseSource extends DBDataSource
{


	public static DSOnSupplierAppraiseSource instance = null;

	public static DSOnSupplierAppraiseSource getInstance() {
		if(instance == null) {
			instance = new DSOnSupplierAppraiseSource("DSOnSupplierAppraiseSource");
		}
		return instance;
	}

	private final DataSourceTextField appraiseTypeField;
	private final DataSourceTextField scoreTypeField;
	private final DataSourceFloatField scoreField;

	public DSOnSupplierAppraiseSource(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadSupplierData");

		appraiseTypeField = new DataSourceTextField("appraiseType", "评分类型");
		appraiseTypeField.setLength(64);
		appraiseTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_190"));
		appraiseTypeField.setCanEdit(false);

		scoreTypeField = new DataSourceTextField("scoreType", "评分级别");
		scoreTypeField.setLength(64);
		scoreTypeField.setValueMap(KeyValueManager.getValueMap("supplier_score_records"));

		scoreField = new DataSourceFloatField("score", "分数");
		scoreField.setLength(6);
		scoreField.setDecimalPad(2);
		scoreField.setFormat("#,###,###,###,###,##0.00");
		scoreField.setCanEdit(false);

		setFields(appraiseTypeField, scoreTypeField, scoreField);
	}


}

