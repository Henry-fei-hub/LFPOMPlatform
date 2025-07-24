package com.pomplatform.client.preprojects.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMainProjectBusinessType extends DBDataSource
{


	public static DSMainProjectBusinessType instance = null;

	public static DSMainProjectBusinessType getInstance() {
		if(instance == null) {
			instance = new DSMainProjectBusinessType("DSMainProjectBusinessType");
		}
		return instance;
	}

	private final DataSourceIntegerField mainProjectBusinessTypeIdField;
	private final DataSourceIntegerField mainProjectIdField;
	private final DataSourceTextField businessTypeField;
	private final DataSourceFloatField areaField;
	private final DataSourceFloatField outputValueField;

	public DSMainProjectBusinessType(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("MainProjectBusinessType");


		mainProjectBusinessTypeIdField = new DataSourceIntegerField("mainProjectBusinessTypeId", "主键编码");
		mainProjectBusinessTypeIdField.setLength(11);
		mainProjectBusinessTypeIdField.setPrimaryKey(true);
		mainProjectBusinessTypeIdField.setRequired(true);
		mainProjectBusinessTypeIdField.setHidden(true);


		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "前期项目id");
		mainProjectIdField.setLength(11);
		mainProjectIdField.setRequired(false);
		mainProjectIdField.setHidden(true);


		businessTypeField = new DataSourceTextField("businessType", "业务类别");
		businessTypeField.setLength(11);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(false);
		businessTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		
		
		areaField = new DataSourceFloatField("area", "面积");
		areaField.setLength(16);
		areaField.setDecimalPad(2);
		areaField.setFormat("##,###,###,###,##0.00");
		areaField.setRequired(false);
		areaField.setHidden(false);


		outputValueField = new DataSourceFloatField("outputValue", "产值");
		outputValueField.setLength(16);
		outputValueField.setDecimalPad(2);
		outputValueField.setFormat("###,###,###,##0.00");
		outputValueField.setRequired(false);
		outputValueField.setHidden(false);


		setFields(mainProjectBusinessTypeIdField, mainProjectIdField, businessTypeField,areaField,outputValueField);
	}


}

