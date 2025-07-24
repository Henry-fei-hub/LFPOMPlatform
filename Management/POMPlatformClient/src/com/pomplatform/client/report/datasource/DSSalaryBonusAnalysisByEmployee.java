package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSalaryBonusAnalysisByEmployee extends DBDataSource
{


	public static DSSalaryBonusAnalysisByEmployee instance = null;

	public static DSSalaryBonusAnalysisByEmployee getInstance() {
		if(instance == null) {
			instance = new DSSalaryBonusAnalysisByEmployee("DSSalaryBonusAnalysisByEmployee");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceFloatField firstQuarterField;
	private final DataSourceFloatField firstPayIntegralField;
	private final DataSourceFloatField oneField;
	private final DataSourceFloatField secondQuarterField;
	private final DataSourceFloatField secondPayIntegralField;
	private final DataSourceFloatField twoField;
	private final DataSourceFloatField thirdQuarterField;
	private final DataSourceFloatField thirdPayIntegralField;
	private final DataSourceFloatField threeField;
	private final DataSourceFloatField fourthQuarterField;
	private final DataSourceFloatField fourthPayIntegralField;
	private final DataSourceFloatField fourField;

	public DSSalaryBonusAnalysisByEmployee(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SalaryBonusAnalysisByEmployee");


		employeeIdField = new DataSourceIntegerField("employeeId", "员工姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);


		firstQuarterField = new DataSourceFloatField("firstQuarter", "季度薪酬");
		firstQuarterField.setLength(18);
		firstQuarterField.setDecimalPad(2);
		firstQuarterField.setFormat("#,###,###,###,###,##0.00");
		firstQuarterField.setRequired(true);
		firstQuarterField.setHidden(false);


		firstPayIntegralField = new DataSourceFloatField("firstPayIntegral", "季度奖金");
		firstPayIntegralField.setLength(18);
		firstPayIntegralField.setDecimalPad(2);
		firstPayIntegralField.setFormat("#,###,###,###,###,##0.00");
		firstPayIntegralField.setRequired(true);
		firstPayIntegralField.setHidden(false);


		oneField = new DataSourceFloatField("one", "固浮比例");
		oneField.setLength(18);
		oneField.setDecimalPad(2);
		oneField.setFormat("#,###,###,###,###,##0.00");
		oneField.setRequired(true);
		oneField.setHidden(false);


		secondQuarterField = new DataSourceFloatField("secondQuarter", "季度薪酬");
		secondQuarterField.setLength(18);
		secondQuarterField.setDecimalPad(2);
		secondQuarterField.setFormat("#,###,###,###,###,##0.00");
		secondQuarterField.setRequired(true);
		secondQuarterField.setHidden(false);


		secondPayIntegralField = new DataSourceFloatField("secondPayIntegral", "季度奖金");
		secondPayIntegralField.setLength(18);
		secondPayIntegralField.setDecimalPad(2);
		secondPayIntegralField.setFormat("#,###,###,###,###,##0.00");
		secondPayIntegralField.setRequired(true);
		secondPayIntegralField.setHidden(false);


		twoField = new DataSourceFloatField("two", "固浮比例");
		twoField.setLength(18);
		twoField.setDecimalPad(2);
		twoField.setFormat("#,###,###,###,###,##0.00");
		twoField.setRequired(true);
		twoField.setHidden(false);


		thirdQuarterField = new DataSourceFloatField("thirdQuarter", "季度薪酬");
		thirdQuarterField.setLength(18);
		thirdQuarterField.setDecimalPad(2);
		thirdQuarterField.setFormat("#,###,###,###,###,##0.00");
		thirdQuarterField.setRequired(true);
		thirdQuarterField.setHidden(false);


		thirdPayIntegralField = new DataSourceFloatField("thirdPayIntegral", "季度奖金");
		thirdPayIntegralField.setLength(18);
		thirdPayIntegralField.setDecimalPad(2);
		thirdPayIntegralField.setFormat("#,###,###,###,###,##0.00");
		thirdPayIntegralField.setRequired(true);
		thirdPayIntegralField.setHidden(false);


		threeField = new DataSourceFloatField("three", "固浮比例");
		threeField.setLength(18);
		threeField.setDecimalPad(2);
		threeField.setFormat("#,###,###,###,###,##0.00");
		threeField.setRequired(true);
		threeField.setHidden(false);


		fourthQuarterField = new DataSourceFloatField("fourthQuarter", "季度薪酬");
		fourthQuarterField.setLength(18);
		fourthQuarterField.setDecimalPad(2);
		fourthQuarterField.setFormat("#,###,###,###,###,##0.00");
		fourthQuarterField.setRequired(true);
		fourthQuarterField.setHidden(false);


		fourthPayIntegralField = new DataSourceFloatField("fourthPayIntegral", "季度奖金");
		fourthPayIntegralField.setLength(18);
		fourthPayIntegralField.setDecimalPad(2);
		fourthPayIntegralField.setFormat("#,###,###,###,###,##0.00");
		fourthPayIntegralField.setRequired(true);
		fourthPayIntegralField.setHidden(false);


		fourField = new DataSourceFloatField("four", "固浮比例");
		fourField.setLength(18);
		fourField.setDecimalPad(2);
		fourField.setFormat("#,###,###,###,###,##0.00");
		fourField.setRequired(true);
		fourField.setHidden(false);


		setFields(employeeIdField, yearField, firstQuarterField, firstPayIntegralField, oneField, secondQuarterField, secondPayIntegralField, twoField, thirdQuarterField, thirdPayIntegralField, threeField, fourthQuarterField, fourthPayIntegralField, fourField);
	}


}

