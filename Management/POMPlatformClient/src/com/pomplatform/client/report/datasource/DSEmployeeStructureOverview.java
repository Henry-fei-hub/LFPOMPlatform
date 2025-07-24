package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

import java.util.HashMap;
import java.util.Map;

public class DSEmployeeStructureOverview extends DBDataSource
{


	public static DSEmployeeStructureOverview instance = null;

	public static DSEmployeeStructureOverview getInstance() {
		if(instance == null) {
			instance = new DSEmployeeStructureOverview("DSEmployeeStructureOverview");
		}
		return instance;
	}

	private final DataSourceIntegerField aField;
	private final DataSourceIntegerField a1Field;
	private final DataSourceFloatField roundField;

	public DSEmployeeStructureOverview(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("EmployeeStructureOverview");


		aField = new DataSourceIntegerField("a", "维度");
		Map<String,Object> map = new HashMap<>();
		map.put("0","总人数");

		map.put("1","男");
		map.put("2","女");

		map.put("3","中共党员");
		map.put("4","团员");
		map.put("5","群众");
		map.put("6","其他");

		map.put("7","0-25岁");
		map.put("8","26-30岁");
		map.put("9","31-40岁");
		map.put("10","51-60岁");
		map.put("11",">60岁");
//		map.put("12","其他岁");

		map.put("13","工龄0-4年");
		map.put("14","工龄5-10年");
		map.put("15","工龄11年以上");
//		map.put("16","其他工龄");

		map.put("17","司龄0-4年");
		map.put("18","司龄5-10年");
		map.put("19","司龄11年以上");
//		map.put("20","其他司龄");

		map.put("20","博士");
		map.put("21","硕士");
		map.put("22","本科");
		map.put("23","大专及其他");
		aField.setValueMap(map);
		aField.setLength(100);
		aField.setRequired(false);
		aField.setHidden(false);


		a1Field = new DataSourceIntegerField("a1", "人数");
		a1Field.setLength(100);
		a1Field.setRequired(false);
		a1Field.setHidden(false);


		roundField = new DataSourceFloatField("round", "比例");
		roundField.setLength(100);
		roundField.setDecimalPad(2);
		roundField.setFormat("##,###,###,###,##0.00");
		roundField.setRequired(false);
		roundField.setHidden(false);


		setFields(aField, a1Field, roundField);
	}


}

