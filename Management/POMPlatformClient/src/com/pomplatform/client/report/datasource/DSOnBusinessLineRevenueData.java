package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnBusinessLineRevenueData extends DBDataSource
{


	public static DSOnBusinessLineRevenueData instance = null;

	public static DSOnBusinessLineRevenueData getInstance() {
		if(instance == null) {
			instance = new DSOnBusinessLineRevenueData("DSOnBusinessLineRevenueData");
		}
		return instance;
	}

	private final DataSourceIntegerField parentIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceTextField plateNameField;
	private final DataSourceTextField parentNameField;
	private final DataSourceFloatField currentRevenueOneField;
	private final DataSourceFloatField currentRevenueTwoField;
	private final DataSourceFloatField currentRevenueThreeField;
	private final DataSourceFloatField currentRevenueFourField;
	private final DataSourceFloatField currentRevenueFiveField;
	private final DataSourceFloatField currentRevenueSixField;
	private final DataSourceFloatField currentRevenueSevenField;
	private final DataSourceFloatField currentRevenueEightField;
	private final DataSourceFloatField currentRevenueNineField;
	private final DataSourceFloatField currentRevenueTenField;

	public DSOnBusinessLineRevenueData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnBusinessLineRevenueData");


		parentIdField = new DataSourceIntegerField("parentId", "父级Id");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(true);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门Id");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(true);


		plateNameField = new DataSourceTextField("plateName", "业务部门");
		plateNameField.setLength(64);
		plateNameField.setRequired(false);
		plateNameField.setHidden(false);


		parentNameField = new DataSourceTextField("parentName", "上级部门名称");
		parentNameField.setLength(64);
		parentNameField.setRequired(true);
		parentNameField.setHidden(true);


		currentRevenueOneField = new DataSourceFloatField("currentRevenueOne", "商业");
		currentRevenueOneField.setLength(18);
		currentRevenueOneField.setDecimalPad(2);
		currentRevenueOneField.setFormat("#,###,###,###,###,##0.00");
		currentRevenueOneField.setRequired(true);
		currentRevenueOneField.setHidden(false);


		currentRevenueTwoField = new DataSourceFloatField("currentRevenueTwo", "酒店");
		currentRevenueTwoField.setLength(18);
		currentRevenueTwoField.setDecimalPad(2);
		currentRevenueTwoField.setFormat("#,###,###,###,###,##0.00");
		currentRevenueTwoField.setRequired(true);
		currentRevenueTwoField.setHidden(false);


		currentRevenueThreeField = new DataSourceFloatField("currentRevenueThree", "办公");
		currentRevenueThreeField.setLength(18);
		currentRevenueThreeField.setDecimalPad(2);
		currentRevenueThreeField.setFormat("#,###,###,###,###,##0.00");
		currentRevenueThreeField.setRequired(true);
		currentRevenueThreeField.setHidden(false);


		currentRevenueFourField = new DataSourceFloatField("currentRevenueFour", "轨道交通");
		currentRevenueFourField.setLength(18);
		currentRevenueFourField.setDecimalPad(2);
		currentRevenueFourField.setFormat("#,###,###,###,###,##0.00");
		currentRevenueFourField.setRequired(true);
		currentRevenueFourField.setHidden(false);


		currentRevenueFiveField = new DataSourceFloatField("currentRevenueFive", "医养");
		currentRevenueFiveField.setLength(18);
		currentRevenueFiveField.setDecimalPad(2);
		currentRevenueFiveField.setFormat("#,###,###,###,###,##0.00");
		currentRevenueFiveField.setRequired(true);
		currentRevenueFiveField.setHidden(false);


		currentRevenueSixField = new DataSourceFloatField("currentRevenueSix", "机电");
		currentRevenueSixField.setLength(18);
		currentRevenueSixField.setDecimalPad(2);
		currentRevenueSixField.setFormat("#,###,###,###,###,##0.00");
		currentRevenueSixField.setRequired(true);
		currentRevenueSixField.setHidden(false);


		currentRevenueSevenField = new DataSourceFloatField("currentRevenueSeven", "杰拓设计");
		currentRevenueSevenField.setLength(18);
		currentRevenueSevenField.setDecimalPad(2);
		currentRevenueSevenField.setFormat("#,###,###,###,###,##0.00");
		currentRevenueSevenField.setRequired(true);
		currentRevenueSevenField.setHidden(false);


		currentRevenueEightField = new DataSourceFloatField("currentRevenueEight", "地产");
		currentRevenueEightField.setLength(18);
		currentRevenueEightField.setDecimalPad(2);
		currentRevenueEightField.setFormat("#,###,###,###,###,##0.00");
		currentRevenueEightField.setRequired(true);
		currentRevenueEightField.setHidden(false);


		currentRevenueNineField = new DataSourceFloatField("currentRevenueNine", "采买");
		currentRevenueNineField.setLength(18);
		currentRevenueNineField.setDecimalPad(2);
		currentRevenueNineField.setFormat("#,###,###,###,###,##0.00");
		currentRevenueNineField.setRequired(true);
		currentRevenueNineField.setHidden(true);


		currentRevenueTenField = new DataSourceFloatField("currentRevenueTen", "其他");
		currentRevenueTenField.setLength(18);
		currentRevenueTenField.setDecimalPad(2);
		currentRevenueTenField.setFormat("#,###,###,###,###,##0.00");
		currentRevenueTenField.setRequired(true);
		currentRevenueTenField.setHidden(false);


		setFields(parentIdField, plateIdField, plateNameField, parentNameField, currentRevenueOneField, currentRevenueTwoField, currentRevenueThreeField, currentRevenueFourField, currentRevenueFiveField, currentRevenueSixField, currentRevenueSevenField, currentRevenueEightField, currentRevenueNineField, currentRevenueTenField);
	}


}

