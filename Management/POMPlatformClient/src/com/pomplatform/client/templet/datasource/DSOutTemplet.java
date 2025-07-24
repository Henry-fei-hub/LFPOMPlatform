package com.pomplatform.client.templet.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOutTemplet extends DBDataSource
{


	public static DSOutTemplet instance = null;

	public static DSOutTemplet getInstance() {
		if(instance == null) {
			instance = new DSOutTemplet("DSOutTemplet");
		}
		return instance;
	}

	private final DataSourceIntegerField outTempletIdField;
	private final DataSourceIntegerField businessTypeField;
	private final DataSourceTextField newCreateQuotationNameField;
	private final DataSourceTextField templetNameField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField defaultTempletField;
	private final DataSourceIntegerField disableTypeField;

	public DSOutTemplet(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OutTemplet");


		outTempletIdField = new DataSourceIntegerField("outTempletId", "模板的 编码");
		outTempletIdField.setLength(11);
		outTempletIdField.setPrimaryKey(true);
		outTempletIdField.setRequired(true);
		outTempletIdField.setHidden(true);


		businessTypeField = new DataSourceIntegerField("businessType", "业务类别");
		businessTypeField.setLength(11);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(false);
		businessTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));


		templetNameField = new DataSourceTextField("templetName", "模板");
		templetNameField.setLength(11);
		templetNameField.setRequired(false);
		templetNameField.setHidden(false);
		
		newCreateQuotationNameField = new DataSourceTextField("newCreateQuotationName", "报价单标题");
		newCreateQuotationNameField.setLength(11);
		newCreateQuotationNameField.setRequired(false);
		newCreateQuotationNameField.setHidden(false);

		createTimeField = new DataSourceDateTimeField("createTime", "模板创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		defaultTempletField = new DataSourceIntegerField("defaultTemplet", "默认模板");
		defaultTempletField.setLength(11);
		defaultTempletField.setRequired(false);
		defaultTempletField.setHidden(true);


		disableTypeField = new DataSourceIntegerField("disableType", "可操作状态 0可操作,1禁止操作");
		disableTypeField.setLength(11);
		disableTypeField.setRequired(false);
		disableTypeField.setHidden(true);

		java.util.Map<String,String> disableTypeValues = new java.util.HashMap<String,String>();
		disableTypeValues.put("可操作", "0");
		disableTypeValues.put("不可操作", "1");
		disableTypeField.setValueMap(disableTypeValues);


		setFields(outTempletIdField, businessTypeField,newCreateQuotationNameField, templetNameField, createTimeField, defaultTempletField, disableTypeField);
	}


}

