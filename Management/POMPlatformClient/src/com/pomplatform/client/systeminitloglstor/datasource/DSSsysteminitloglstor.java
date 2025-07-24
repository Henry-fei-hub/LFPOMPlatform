package com.pomplatform.client.systeminitloglstor.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;

import java.util.LinkedHashMap;
import java.util.Map;

import com.delicacy.client.data.DBDataSource;

public class DSSsysteminitloglstor extends DBDataSource
{


	public static DSSsysteminitloglstor instance = null;

	public static DSSsysteminitloglstor getInstance() {
		if(instance == null) {
			instance = new DSSsysteminitloglstor("DSSsysteminitloglstor");
		}
		return instance;
	}

	private final DataSourceIntegerField systemInitLogIdField;
	private final DataSourceIntegerField typeField;
	private final DataSourceTextField logMsgField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField flagField;

	public DSSsysteminitloglstor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Ssysteminitloglstor");


		systemInitLogIdField = new DataSourceIntegerField("systemInitLogId", "主键id");
		systemInitLogIdField.setLength(11);
		systemInitLogIdField.setPrimaryKey(true);
		systemInitLogIdField.setRequired(true);
		systemInitLogIdField.setHidden(true);


		typeField = new DataSourceIntegerField("type", "导入类型 ");
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setHidden(false);
		Map<Integer, String> TypeMap= new LinkedHashMap<Integer, String>();
		TypeMap.put(1, "基础数据");
		TypeMap.put(2, "历史数据");
		typeField.setValueMap(TypeMap);
		

		logMsgField = new DataSourceTextField("logMsg", "日志信息");
		logMsgField.setLength(255);
		logMsgField.setRequired(false);
		logMsgField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		flagField = new DataSourceIntegerField("flag", "是否成功");
		flagField.setLength(11);
		flagField.setRequired(false);
		flagField.setHidden(false);
		Map<Integer, String> dateMap= new LinkedHashMap<Integer, String>();
		dateMap.put(1, "成功");
		dateMap.put(2, "失败");
		flagField.setValueMap(dateMap);


		setFields(systemInitLogIdField, typeField, logMsgField, createTimeField, flagField);
	}


}

