package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSPerCapitaSalaryAnalysis extends DBDataSource
{


	public static DSPerCapitaSalaryAnalysis instance = null;

	public static DSPerCapitaSalaryAnalysis getInstance() {
		if(instance == null) {
			instance = new DSPerCapitaSalaryAnalysis("DSPerCapitaSalaryAnalysis");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceFloatField firstQuarterField;
	private final DataSourceFloatField firstPayIntegralField;
	private final DataSourceFloatField oneField;
	private final DataSourceFloatField oneAverageField;
	private final DataSourceFloatField oneAverageNumField;
	private final DataSourceFloatField secondQuarterField;
	private final DataSourceFloatField secondPayIntegralField;
	private final DataSourceFloatField twoField;
	private final DataSourceFloatField twoAverageField;
	private final DataSourceFloatField twoAverageNumField;
	private final DataSourceFloatField thirdQuarterField;
	private final DataSourceFloatField thirdPayIntegralField;
	private final DataSourceFloatField threeField;
	private final DataSourceFloatField threeAverageField;
	private final DataSourceFloatField threeAverageNumField;
	private final DataSourceFloatField fourthQuarterField;
	private final DataSourceFloatField fourthPayIntegralField;
	private final DataSourceFloatField fourField;
	private final DataSourceFloatField fourAverageField;
	private final DataSourceFloatField fourAverageNumField;
	private final DataSourceFloatField totalQuarterField;
	private final DataSourceFloatField totalPayQuarterField;
	private final DataSourceFloatField fiveField;
	private final DataSourceFloatField fiveAverageField;
	private final DataSourceFloatField fiveAverageNumField;

	public DSPerCapitaSalaryAnalysis(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("PerCapitaSalaryAnalysis");


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


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


		oneField = new DataSourceFloatField("one", "总收入");
		oneField.setLength(18);
		oneField.setDecimalPad(2);
		oneField.setFormat("#,###,###,###,###,##0.00");
		oneField.setRequired(true);
		oneField.setHidden(false);


		oneAverageField = new DataSourceFloatField("oneAverage", "平均人数");
		oneAverageField.setLength(18);
		oneAverageField.setDecimalPad(2);
		oneAverageField.setFormat("#,###,###,###,###,##0.00");
		oneAverageField.setRequired(true);
		oneAverageField.setHidden(false);


		oneAverageNumField = new DataSourceFloatField("oneAverageNum", "人均薪酬");
		oneAverageNumField.setLength(18);
		oneAverageNumField.setDecimalPad(2);
		oneAverageNumField.setFormat("#,###,###,###,###,##0.00");
		oneAverageNumField.setRequired(true);
		oneAverageNumField.setHidden(false);


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


		twoField = new DataSourceFloatField("two", "总薪酬");
		twoField.setLength(18);
		twoField.setDecimalPad(2);
		twoField.setFormat("#,###,###,###,###,##0.00");
		twoField.setRequired(true);
		twoField.setHidden(false);


		twoAverageField = new DataSourceFloatField("twoAverage", "平均人数");
		twoAverageField.setLength(18);
		twoAverageField.setDecimalPad(2);
		twoAverageField.setFormat("#,###,###,###,###,##0.00");
		twoAverageField.setRequired(true);
		twoAverageField.setHidden(false);


		twoAverageNumField = new DataSourceFloatField("twoAverageNum", "人均薪酬");
		twoAverageNumField.setLength(18);
		twoAverageNumField.setDecimalPad(2);
		twoAverageNumField.setFormat("#,###,###,###,###,##0.00");
		twoAverageNumField.setRequired(true);
		twoAverageNumField.setHidden(false);


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


		threeField = new DataSourceFloatField("three", "总收入");
		threeField.setLength(18);
		threeField.setDecimalPad(2);
		threeField.setFormat("#,###,###,###,###,##0.00");
		threeField.setRequired(true);
		threeField.setHidden(false);


		threeAverageField = new DataSourceFloatField("threeAverage", "平均人数");
		threeAverageField.setLength(18);
		threeAverageField.setDecimalPad(2);
		threeAverageField.setFormat("#,###,###,###,###,##0.00");
		threeAverageField.setRequired(true);
		threeAverageField.setHidden(false);


		threeAverageNumField = new DataSourceFloatField("threeAverageNum", "人均薪酬");
		threeAverageNumField.setLength(18);
		threeAverageNumField.setDecimalPad(2);
		threeAverageNumField.setFormat("#,###,###,###,###,##0.00");
		threeAverageNumField.setRequired(true);
		threeAverageNumField.setHidden(false);


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


		fourField = new DataSourceFloatField("four", "总收入");
		fourField.setLength(18);
		fourField.setDecimalPad(2);
		fourField.setFormat("#,###,###,###,###,##0.00");
		fourField.setRequired(true);
		fourField.setHidden(false);


		fourAverageField = new DataSourceFloatField("fourAverage", "平均人数");
		fourAverageField.setLength(18);
		fourAverageField.setDecimalPad(2);
		fourAverageField.setFormat("#,###,###,###,###,##0.00");
		fourAverageField.setRequired(true);
		fourAverageField.setHidden(false);


		fourAverageNumField = new DataSourceFloatField("fourAverageNum", "人均薪酬");
		fourAverageNumField.setLength(18);
		fourAverageNumField.setDecimalPad(2);
		fourAverageNumField.setFormat("#,###,###,###,###,##0.00");
		fourAverageNumField.setRequired(true);
		fourAverageNumField.setHidden(false);

		totalQuarterField = new DataSourceFloatField("totalQuarter", "薪酬");
		totalQuarterField.setLength(18);
		totalQuarterField.setDecimalPad(2);
		totalQuarterField.setFormat("#,###,###,###,###,##0.00");
		totalQuarterField.setRequired(true);
		totalQuarterField.setHidden(false);


		totalPayQuarterField = new DataSourceFloatField("totalPayQuarter", "奖金");
		totalPayQuarterField.setLength(18);
		totalPayQuarterField.setDecimalPad(2);
		totalPayQuarterField.setFormat("#,###,###,###,###,##0.00");
		totalPayQuarterField.setRequired(true);
		totalPayQuarterField.setHidden(false);


		fiveField = new DataSourceFloatField("five", "总收入");
		fiveField.setLength(18);
		fiveField.setDecimalPad(2);
		fiveField.setFormat("#,###,###,###,###,##0.00");
		fiveField.setRequired(true);
		fiveField.setHidden(false);


		fiveAverageField = new DataSourceFloatField("fiveAverage", "人数");
		fiveAverageField.setLength(18);
		fiveAverageField.setDecimalPad(2);
		fiveAverageField.setFormat("#,###,###,###,###,##0.00");
		fiveAverageField.setRequired(true);
		fiveAverageField.setHidden(false);


		fiveAverageNumField = new DataSourceFloatField("fiveAverageNum", "人均薪酬");
		fiveAverageNumField.setLength(18);
		fiveAverageNumField.setDecimalPad(2);
		fiveAverageNumField.setFormat("#,###,###,###,###,##0.00");
		fiveAverageNumField.setRequired(true);
		fiveAverageNumField.setHidden(false);

		setFields(plateIdField, yearField, firstQuarterField, firstPayIntegralField, oneField, oneAverageField, oneAverageNumField, secondQuarterField, secondPayIntegralField, twoField, twoAverageField, twoAverageNumField, thirdQuarterField, thirdPayIntegralField, threeField, threeAverageField, threeAverageNumField, fourthQuarterField, fourthPayIntegralField, fourField, fourAverageField, fourAverageNumField, totalQuarterField, totalPayQuarterField, fiveField, fiveAverageField, fiveAverageNumField);
//		setFields(plateIdField, yearField, firstQuarterField, firstPayIntegralField, oneField, oneAverageField, oneAverageNumField, secondQuarterField, secondPayIntegralField, twoField, twoAverageField, twoAverageNumField, thirdQuarterField, thirdPayIntegralField, threeField, threeAverageField, threeAverageNumField, fourthQuarterField, fourthPayIntegralField, fourField, fourAverageField, fourAverageNumField);
	}


}

