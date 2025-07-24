package com.pomplatform.client.project.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;

import java.util.LinkedHashMap;

import com.delicacy.client.data.DBDataSource;

public class DSStargetrecordbytor extends DBDataSource
{


	public static DSStargetrecordbytor instance = null;

	public static DSStargetrecordbytor getInstance() {
		if(instance == null) {
			instance = new DSStargetrecordbytor("DSStargetrecordbytor");
		}
		return instance;
	}

	private final DataSourceIntegerField targetRecordIdField;
	private final DataSourceIntegerField businessLineField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceFloatField targetField;
	private final DataSourceTextField targetStrField;
	private final DataSourceIntegerField typeField;
	private final DataSourceTextField remarkField;
	private final DataSourceDateField operateDateField;

	public DSStargetrecordbytor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Stargetrecordbytor");


		targetRecordIdField = new DataSourceIntegerField("targetRecordId", "编码");
		targetRecordIdField.setLength(11);
		targetRecordIdField.setPrimaryKey(true);
		targetRecordIdField.setRequired(true);
		targetRecordIdField.setHidden(true);


		businessLineField = new DataSourceIntegerField("businessLine", "业务条线");
		businessLineField.setLength(11);
		businessLineField.setRequired(false);
		businessLineField.setHidden(false);
		businessLineField.setValueMap(KeyValueManager.getValueMap("system_dictionary_205"));

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);


		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(true);


		targetField = new DataSourceFloatField("target", "指标");
		targetField.setLength(64);
		targetField.setDecimalPad(2);
		targetField.setFormat("##,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,##0.00");
		targetField.setRequired(false);
		targetField.setHidden(false);


		targetStrField = new DataSourceTextField("targetStr", "指标（万）");
		targetStrField.setLength(64);
		targetStrField.setRequired(false);
		targetStrField.setHidden(true);


		typeField = new DataSourceIntegerField("type", "指标类型");
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setHidden(false);
		typeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_211"));
		

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		operateDateField = new DataSourceDateField("operateDate", "操作日期");
		operateDateField.setRequired(false);
		operateDateField.setHidden(false);


		setFields(targetRecordIdField, businessLineField, yearField, monthField, targetField, targetStrField, typeField, remarkField, operateDateField);
	}


}

