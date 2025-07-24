package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSDepartmentIncomeReport extends DBDataSource
{


	public static DSDepartmentIncomeReport instance = null;

	public static DSDepartmentIncomeReport getInstance() {
		if(instance == null) {
			instance = new DSDepartmentIncomeReport("DSDepartmentIncomeReport");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIncomeAndExpenditureIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceFloatField yearField;
	private final DataSourceFloatField monthField;
	private final DataSourceFloatField januaryField;
	private final DataSourceFloatField februaryField;
	private final DataSourceFloatField marchField;
	private final DataSourceFloatField aprilField;
	private final DataSourceFloatField mayField;
	private final DataSourceFloatField juneField;
	private final DataSourceFloatField julyField;
	private final DataSourceFloatField aguestField;
	private final DataSourceFloatField septemberField;
	private final DataSourceFloatField octoberField;
	private final DataSourceFloatField novemberField;
	private final DataSourceFloatField decemberField;
	private final DataSourceFloatField totalField;

	public DSDepartmentIncomeReport(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("DepartmentIncomeReport");


		plateIncomeAndExpenditureIdField = new DataSourceIntegerField("plateIncomeAndExpenditureId", "部门收支表");
		plateIncomeAndExpenditureIdField.setLength(11);
		plateIncomeAndExpenditureIdField.setPrimaryKey(true);
		plateIncomeAndExpenditureIdField.setRequired(true);
		plateIncomeAndExpenditureIdField.setHidden(true);


		plateIdField = new DataSourceIntegerField("plateId", "部门名称");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		KeyValueManager.loadValueMap("system_dictionary_1", plateIdField);
		plateIdField.setForeignKey("DSDepartmentIncomeReport.plateId");


		yearField = new DataSourceFloatField("year", "年份");
		yearField.setLength(8);
		yearField.setDecimalPad(0);
		yearField.setFormat("##,###,##0");
		yearField.setRequired(true);
		yearField.setHidden(false);


		monthField = new DataSourceFloatField("month", "月份");
		monthField.setLength(8);
		monthField.setRequired(true);
		monthField.setHidden(true);

		totalField = new DataSourceFloatField("total", "总计");
		totalField.setLength(18);
		totalField.setDecimalPad(2);
		totalField.setFormat("#,###,###,###,###,##0.00");
		totalField.setRequired(true);
		totalField.setHidden(false);

		januaryField = new DataSourceFloatField("january", "一月");
		januaryField.setLength(18);
		januaryField.setDecimalPad(2);
		januaryField.setFormat("#,###,###,###,###,##0.00");
		januaryField.setRequired(true);
		januaryField.setHidden(false);


		februaryField = new DataSourceFloatField("february", "二月");
		februaryField.setLength(18);
		februaryField.setDecimalPad(2);
		februaryField.setFormat("#,###,###,###,###,##0.00");
		februaryField.setRequired(true);
		februaryField.setHidden(false);


		marchField = new DataSourceFloatField("march", "三月");
		marchField.setLength(18);
		marchField.setDecimalPad(2);
		marchField.setFormat("#,###,###,###,###,##0.00");
		marchField.setRequired(true);
		marchField.setHidden(false);


		aprilField = new DataSourceFloatField("april", "四月");
		aprilField.setLength(18);
		aprilField.setDecimalPad(2);
		aprilField.setFormat("#,###,###,###,###,##0.00");
		aprilField.setRequired(true);
		aprilField.setHidden(false);


		mayField = new DataSourceFloatField("may", "五月");
		mayField.setLength(18);
		mayField.setDecimalPad(2);
		mayField.setFormat("#,###,###,###,###,##0.00");
		mayField.setRequired(true);
		mayField.setHidden(false);


		juneField = new DataSourceFloatField("june", "六月");
		juneField.setLength(18);
		juneField.setDecimalPad(2);
		juneField.setFormat("#,###,###,###,###,##0.00");
		juneField.setRequired(true);
		juneField.setHidden(false);


		julyField = new DataSourceFloatField("july", "七月");
		julyField.setLength(18);
		julyField.setDecimalPad(2);
		julyField.setFormat("#,###,###,###,###,##0.00");
		julyField.setRequired(true);
		julyField.setHidden(false);


		aguestField = new DataSourceFloatField("aguest", "八月");
		aguestField.setLength(18);
		aguestField.setDecimalPad(2);
		aguestField.setFormat("#,###,###,###,###,##0.00");
		aguestField.setRequired(true);
		aguestField.setHidden(false);


		septemberField = new DataSourceFloatField("september", "九月");
		septemberField.setLength(18);
		septemberField.setDecimalPad(2);
		septemberField.setFormat("#,###,###,###,###,##0.00");
		septemberField.setRequired(true);
		septemberField.setHidden(false);


		octoberField = new DataSourceFloatField("october", "十月");
		octoberField.setLength(18);
		octoberField.setDecimalPad(2);
		octoberField.setFormat("#,###,###,###,###,##0.00");
		octoberField.setRequired(true);
		octoberField.setHidden(false);


		novemberField = new DataSourceFloatField("november", "十一月");
		novemberField.setLength(18);
		novemberField.setDecimalPad(2);
		novemberField.setFormat("#,###,###,###,###,##0.00");
		novemberField.setRequired(true);
		novemberField.setHidden(false);


		decemberField = new DataSourceFloatField("december", "十二月");
		decemberField.setLength(18);
		decemberField.setDecimalPad(2);
		decemberField.setFormat("#,###,###,###,###,##0.00");
		decemberField.setRequired(true);
		decemberField.setHidden(false);

		setFields(plateIncomeAndExpenditureIdField, plateIdField, yearField, monthField,totalField, januaryField, februaryField, marchField, aprilField, mayField, juneField, julyField, aguestField, septemberField, octoberField, novemberField, decemberField);
	}


}

