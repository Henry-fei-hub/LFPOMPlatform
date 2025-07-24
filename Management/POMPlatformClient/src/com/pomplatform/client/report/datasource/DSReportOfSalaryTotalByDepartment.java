package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSReportOfSalaryTotalByDepartment extends DBDataSource
{


	public static DSReportOfSalaryTotalByDepartment instance = null;

	public static DSReportOfSalaryTotalByDepartment getInstance() {
		if(instance == null) {
			instance = new DSReportOfSalaryTotalByDepartment("DSReportOfSalaryTotalByDepartment");
		}
		return instance;
	}

	private final DataSourceTextField departmentIdField;
	private final DataSourceTextField yearField;
	private final DataSourceFloatField januaryField;
	private final DataSourceFloatField februaryField;
	private final DataSourceFloatField marchField;
	private final DataSourceFloatField aprilField;
	private final DataSourceFloatField mayField;
	private final DataSourceFloatField juneField;
	private final DataSourceFloatField julyField;
	private final DataSourceFloatField augustField;
	private final DataSourceFloatField septemberField;
	private final DataSourceFloatField octoberField;
	private final DataSourceFloatField novemberField;
	private final DataSourceFloatField decemberField;
	private final DataSourceFloatField totalField;

	public DSReportOfSalaryTotalByDepartment(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ReportOfSalaryTotalByDepartment");


		departmentIdField = new DataSourceTextField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		yearField = new DataSourceTextField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);


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


		augustField = new DataSourceFloatField("august", "八月");
		augustField.setLength(18);
		augustField.setDecimalPad(2);
		augustField.setFormat("#,###,###,###,###,##0.00");
		augustField.setRequired(true);
		augustField.setHidden(false);


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


		totalField = new DataSourceFloatField("total", "合计");
		totalField.setLength(18);
		totalField.setDecimalPad(2);
		totalField.setFormat("#,###,###,###,###,##0.00");
		totalField.setRequired(true);
		totalField.setHidden(false);


		setFields(departmentIdField, yearField, januaryField, februaryField, marchField, aprilField, mayField, juneField, julyField, augustField, septemberField, octoberField, novemberField, decemberField, totalField);
	}


}

