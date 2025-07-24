package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSReportOnEmployeeNumTotalByDepartment extends DBDataSource
{


	public static DSReportOnEmployeeNumTotalByDepartment instance = null;

	public static DSReportOnEmployeeNumTotalByDepartment getInstance() {
		if(instance == null) {
			instance = new DSReportOnEmployeeNumTotalByDepartment("DSReportOnEmployeeNumTotalByDepartment");
		}
		return instance;
	}

//	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField oneBeforNumField;
	private final DataSourceIntegerField oneAfterNumField;
	private final DataSourceFloatField oneAverageNumField;
	private final DataSourceIntegerField twoBeforNumField;
	private final DataSourceIntegerField twoAfterNumField;
	private final DataSourceFloatField twoAverageNumField;
	private final DataSourceIntegerField threeBeforNumField;
	private final DataSourceIntegerField threeAfterNumField;
	private final DataSourceFloatField threeAverageNumField;
	private final DataSourceIntegerField fourBeforNumField;
	private final DataSourceIntegerField fourAfterNumField;
	private final DataSourceFloatField fourAverageNumField;
	private final DataSourceIntegerField fiveBeforNumField;
	private final DataSourceIntegerField fiveAfterNumField;
	private final DataSourceFloatField fiveAverageNumField;
	private final DataSourceIntegerField sixBeforNumField;
	private final DataSourceIntegerField sixAfterNumField;
	private final DataSourceFloatField sixAverageNumField;
	private final DataSourceIntegerField sevenBeforNumField;
	private final DataSourceIntegerField sevenAfterNumField;
	private final DataSourceFloatField sevenAverageNumField;
	private final DataSourceIntegerField eightBeforNumField;
	private final DataSourceIntegerField eightAfterNumField;
	private final DataSourceFloatField eightAverageNumField;
	private final DataSourceIntegerField nineBeforNumField;
	private final DataSourceIntegerField nineAfterNumField;
	private final DataSourceFloatField nineAverageNumField;
	private final DataSourceIntegerField tenBeforNumField;
	private final DataSourceIntegerField tenAfterNumField;
	private final DataSourceFloatField tenAverageNumField;
	private final DataSourceIntegerField elevenBeforNumField;
	private final DataSourceIntegerField elevenAfterNumField;
	private final DataSourceFloatField elevenAverageNumField;
	private final DataSourceIntegerField twelfBeforNumField;
	private final DataSourceIntegerField twelfAfterNumField;
	private final DataSourceFloatField twelfAverageNumField;

	public DSReportOnEmployeeNumTotalByDepartment(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ReportOnEmployeeNumTotalByDepartment");


/*		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(true);*/


		departmentIdField = new DataSourceIntegerField("departmentId", "所属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		KeyValueManager.loadValueMap("departments", departmentIdField);

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);


		oneBeforNumField = new DataSourceIntegerField("oneBeforNum", "月初人数");
		oneBeforNumField.setLength(18);
		oneBeforNumField.setRequired(true);
		oneBeforNumField.setHidden(false);


		oneAfterNumField = new DataSourceIntegerField("oneAfterNum", "月末人数");
		oneAfterNumField.setLength(18);
		oneAfterNumField.setRequired(true);
		oneAfterNumField.setHidden(false);


		oneAverageNumField = new DataSourceFloatField("oneAverageNum", "平均人数");
		oneAverageNumField.setLength(18);
		oneAverageNumField.setDecimalPad(1);
		oneAverageNumField.setFormat("#,###,###,###,###,##0.0");
		oneAverageNumField.setRequired(true);
		oneAverageNumField.setHidden(false);


		twoBeforNumField = new DataSourceIntegerField("twoBeforNum", "月初人数");
		twoBeforNumField.setLength(18);
		twoBeforNumField.setRequired(true);
		twoBeforNumField.setHidden(false);


		twoAfterNumField = new DataSourceIntegerField("twoAfterNum", "月末人数");
		twoAfterNumField.setLength(18);
		twoAfterNumField.setRequired(true);
		twoAfterNumField.setHidden(false);


		twoAverageNumField = new DataSourceFloatField("twoAverageNum", "平均人数");
		twoAverageNumField.setLength(18);
		twoAverageNumField.setDecimalPad(1);
		twoAverageNumField.setFormat("#,###,###,###,###,##0.0");
		twoAverageNumField.setRequired(true);
		twoAverageNumField.setHidden(false);


		threeBeforNumField = new DataSourceIntegerField("threeBeforNum", "月初人数");
		threeBeforNumField.setLength(18);
		threeBeforNumField.setRequired(true);
		threeBeforNumField.setHidden(false);


		threeAfterNumField = new DataSourceIntegerField("threeAfterNum", "月末人数");
		threeAfterNumField.setLength(18);
		threeAfterNumField.setRequired(true);
		threeAfterNumField.setHidden(false);


		threeAverageNumField = new DataSourceFloatField("threeAverageNum", "平均人数");
		threeAverageNumField.setLength(18);
		threeAverageNumField.setDecimalPad(1);
		threeAverageNumField.setFormat("#,###,###,###,###,##0.0");
		threeAverageNumField.setRequired(true);
		threeAverageNumField.setHidden(false);


		fourBeforNumField = new DataSourceIntegerField("fourBeforNum", "月初人数");
		fourBeforNumField.setLength(18);
		fourBeforNumField.setRequired(true);
		fourBeforNumField.setHidden(false);


		fourAfterNumField = new DataSourceIntegerField("fourAfterNum", "月末人数");
		fourAfterNumField.setLength(18);
		fourAfterNumField.setRequired(true);
		fourAfterNumField.setHidden(false);


		fourAverageNumField = new DataSourceFloatField("fourAverageNum", "平均人数");
		fourAverageNumField.setLength(18);
		fourAverageNumField.setDecimalPad(1);
		fourAverageNumField.setFormat("#,###,###,###,###,##0.0");
		fourAverageNumField.setRequired(true);
		fourAverageNumField.setHidden(false);


		fiveBeforNumField = new DataSourceIntegerField("fiveBeforNum", "月初人数");
		fiveBeforNumField.setLength(18);
		fiveBeforNumField.setRequired(true);
		fiveBeforNumField.setHidden(false);


		fiveAfterNumField = new DataSourceIntegerField("fiveAfterNum", "月末人数");
		fiveAfterNumField.setLength(18);
		fiveAfterNumField.setRequired(true);
		fiveAfterNumField.setHidden(false);


		fiveAverageNumField = new DataSourceFloatField("fiveAverageNum", "平均人数");
		fiveAverageNumField.setLength(18);
		fiveAverageNumField.setDecimalPad(1);
		fiveAverageNumField.setFormat("#,###,###,###,###,##0.0");
		fiveAverageNumField.setRequired(true);
		fiveAverageNumField.setHidden(false);


		sixBeforNumField = new DataSourceIntegerField("sixBeforNum", "月初人数");
		sixBeforNumField.setLength(18);
		sixBeforNumField.setRequired(true);
		sixBeforNumField.setHidden(false);


		sixAfterNumField = new DataSourceIntegerField("sixAfterNum", "月末人数");
		sixAfterNumField.setLength(18);
		sixAfterNumField.setRequired(true);
		sixAfterNumField.setHidden(false);


		sixAverageNumField = new DataSourceFloatField("sixAverageNum", "平均人数");
		sixAverageNumField.setLength(18);
		sixAverageNumField.setDecimalPad(1);
		sixAverageNumField.setFormat("#,###,###,###,###,##0.0");
		sixAverageNumField.setRequired(true);
		sixAverageNumField.setHidden(false);


		sevenBeforNumField = new DataSourceIntegerField("sevenBeforNum", "月初人数");
		sevenBeforNumField.setLength(18);
		sevenBeforNumField.setRequired(true);
		sevenBeforNumField.setHidden(false);


		sevenAfterNumField = new DataSourceIntegerField("sevenAfterNum", "月末人数");
		sevenAfterNumField.setLength(18);
		sevenAfterNumField.setRequired(true);
		sevenAfterNumField.setHidden(false);


		sevenAverageNumField = new DataSourceFloatField("sevenAverageNum", "平均人数");
		sevenAverageNumField.setLength(18);
		sevenAverageNumField.setDecimalPad(1);
		sevenAverageNumField.setFormat("#,###,###,###,###,##0.0");
		sevenAverageNumField.setRequired(true);
		sevenAverageNumField.setHidden(false);


		eightBeforNumField = new DataSourceIntegerField("eightBeforNum", "月初人数");
		eightBeforNumField.setLength(18);
		eightBeforNumField.setRequired(true);
		eightBeforNumField.setHidden(false);


		eightAfterNumField = new DataSourceIntegerField("eightAfterNum", "月末人数");
		eightAfterNumField.setLength(18);
		eightAfterNumField.setRequired(true);
		eightAfterNumField.setHidden(false);


		eightAverageNumField = new DataSourceFloatField("eightAverageNum", "平均人数");
		eightAverageNumField.setLength(18);
		eightAverageNumField.setDecimalPad(1);
		eightAverageNumField.setFormat("#,###,###,###,###,##0.0");
		eightAverageNumField.setRequired(true);
		eightAverageNumField.setHidden(false);


		nineBeforNumField = new DataSourceIntegerField("nineBeforNum", "月初人数");
		nineBeforNumField.setLength(18);
		nineBeforNumField.setRequired(true);
		nineBeforNumField.setHidden(false);


		nineAfterNumField = new DataSourceIntegerField("nineAfterNum", "月末人数");
		nineAfterNumField.setLength(18);
		nineAfterNumField.setRequired(true);
		nineAfterNumField.setHidden(false);


		nineAverageNumField = new DataSourceFloatField("nineAverageNum", "平均人数");
		nineAverageNumField.setLength(18);
		nineAverageNumField.setDecimalPad(1);
		nineAverageNumField.setFormat("#,###,###,###,###,##0.0");
		nineAverageNumField.setRequired(true);
		nineAverageNumField.setHidden(false);


		tenBeforNumField = new DataSourceIntegerField("tenBeforNum", "月初人数");
		tenBeforNumField.setLength(18);
		tenBeforNumField.setRequired(true);
		tenBeforNumField.setHidden(false);


		tenAfterNumField = new DataSourceIntegerField("tenAfterNum", "月末人数");
		tenAfterNumField.setLength(18);
		tenAfterNumField.setRequired(true);
		tenAfterNumField.setHidden(false);


		tenAverageNumField = new DataSourceFloatField("tenAverageNum", "平均人数");
		tenAverageNumField.setLength(18);
		tenAverageNumField.setDecimalPad(1);
		tenAverageNumField.setFormat("#,###,###,###,###,##0.0");
		tenAverageNumField.setRequired(true);
		tenAverageNumField.setHidden(false);


		elevenBeforNumField = new DataSourceIntegerField("elevenBeforNum", "月初人数");
		elevenBeforNumField.setLength(18);
		elevenBeforNumField.setRequired(true);
		elevenBeforNumField.setHidden(false);


		elevenAfterNumField = new DataSourceIntegerField("elevenAfterNum", "月末人数");
		elevenAfterNumField.setLength(18);
		elevenAfterNumField.setRequired(true);
		elevenAfterNumField.setHidden(false);


		elevenAverageNumField = new DataSourceFloatField("elevenAverageNum", "平均人数");
		elevenAverageNumField.setLength(18);
		elevenAverageNumField.setDecimalPad(1);
		elevenAverageNumField.setFormat("#,###,###,###,###,##0.0");
		elevenAverageNumField.setRequired(true);
		elevenAverageNumField.setHidden(false);


		twelfBeforNumField = new DataSourceIntegerField("twelfBeforNum", "月初人数");
		twelfBeforNumField.setLength(18);
		twelfBeforNumField.setRequired(true);
		twelfBeforNumField.setHidden(false);


		twelfAfterNumField = new DataSourceIntegerField("twelfAfterNum", "月末人数");
		twelfAfterNumField.setLength(18);
		twelfAfterNumField.setRequired(true);
		twelfAfterNumField.setHidden(false);


		twelfAverageNumField = new DataSourceFloatField("twelfAverageNum", "平均人数");
		twelfAverageNumField.setLength(18);
		twelfAverageNumField.setDecimalPad(1);
		twelfAverageNumField.setFormat("#,###,###,###,###,##0.0");
		twelfAverageNumField.setRequired(true);
		twelfAverageNumField.setHidden(false);


		setFields( departmentIdField, yearField, oneBeforNumField, oneAfterNumField, oneAverageNumField, twoBeforNumField, twoAfterNumField, twoAverageNumField, threeBeforNumField, threeAfterNumField, threeAverageNumField, fourBeforNumField, fourAfterNumField, fourAverageNumField, fiveBeforNumField, fiveAfterNumField, fiveAverageNumField, sixBeforNumField, sixAfterNumField, sixAverageNumField, sevenBeforNumField, sevenAfterNumField, sevenAverageNumField, eightBeforNumField, eightAfterNumField, eightAverageNumField, nineBeforNumField, nineAfterNumField, nineAverageNumField, tenBeforNumField, tenAfterNumField, tenAverageNumField, elevenBeforNumField, elevenAfterNumField, elevenAverageNumField, twelfBeforNumField, twelfAfterNumField, twelfAverageNumField);
	}


}

