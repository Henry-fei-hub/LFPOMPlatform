package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSReportOnEmployeeEducationTotalByDepartment extends DBDataSource
{


	public static DSReportOnEmployeeEducationTotalByDepartment instance = null;

	public static DSReportOnEmployeeEducationTotalByDepartment getInstance() {
		if(instance == null) {
			instance = new DSReportOnEmployeeEducationTotalByDepartment("DSReportOnEmployeeEducationTotalByDepartment");
		}
		return instance;
	}

	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceFloatField zeroNum1Field;
	private final DataSourceFloatField oneNum1Field;
	private final DataSourceFloatField twoNum1Field;
	private final DataSourceFloatField threeNum1Field;
	private final DataSourceFloatField fourNum1Field;
	private final DataSourceFloatField fiveNum1Field;
	private final DataSourceFloatField sixNum1Field;
	private final DataSourceFloatField totalNum1Field;
	private final DataSourceFloatField zeroNum2Field;
	private final DataSourceFloatField oneNum2Field;
	private final DataSourceFloatField twoNum2Field;
	private final DataSourceFloatField threeNum2Field;
	private final DataSourceFloatField fourNum2Field;
	private final DataSourceFloatField fiveNum2Field;
	private final DataSourceFloatField sixNum2Field;
	private final DataSourceFloatField totalNum2Field;
	private final DataSourceFloatField zeroNum3Field;
	private final DataSourceFloatField oneNum3Field;
	private final DataSourceFloatField twoNum3Field;
	private final DataSourceFloatField threeNum3Field;
	private final DataSourceFloatField fourNum3Field;
	private final DataSourceFloatField fiveNum3Field;
	private final DataSourceFloatField sixNum3Field;
	private final DataSourceFloatField totalNum3Field;
	private final DataSourceFloatField zeroNum4Field;
	private final DataSourceFloatField oneNum4Field;
	private final DataSourceFloatField twoNum4Field;
	private final DataSourceFloatField threeNum4Field;
	private final DataSourceFloatField fourNum4Field;
	private final DataSourceFloatField fiveNum4Field;
	private final DataSourceFloatField sixNum4Field;
	private final DataSourceFloatField totalNum4Field;
	private final DataSourceFloatField zeroNum5Field;
	private final DataSourceFloatField oneNum5Field;
	private final DataSourceFloatField twoNum5Field;
	private final DataSourceFloatField threeNum5Field;
	private final DataSourceFloatField fourNum5Field;
	private final DataSourceFloatField fiveNum5Field;
	private final DataSourceFloatField sixNum5Field;
	private final DataSourceFloatField totalNum5Field;
	private final DataSourceFloatField zeroNum6Field;
	private final DataSourceFloatField oneNum6Field;
	private final DataSourceFloatField twoNum6Field;
	private final DataSourceFloatField threeNum6Field;
	private final DataSourceFloatField fourNum6Field;
	private final DataSourceFloatField fiveNum6Field;
	private final DataSourceFloatField sixNum6Field;
	private final DataSourceFloatField totalNum6Field;
	private final DataSourceFloatField zeroNum7Field;
	private final DataSourceFloatField oneNum7Field;
	private final DataSourceFloatField twoNum7Field;
	private final DataSourceFloatField threeNum7Field;
	private final DataSourceFloatField fourNum7Field;
	private final DataSourceFloatField fiveNum7Field;
	private final DataSourceFloatField sixNum7Field;
	private final DataSourceFloatField totalNum7Field;
	private final DataSourceFloatField zeroNum8Field;
	private final DataSourceFloatField oneNum8Field;
	private final DataSourceFloatField twoNum8Field;
	private final DataSourceFloatField threeNum8Field;
	private final DataSourceFloatField fourNum8Field;
	private final DataSourceFloatField fiveNum8Field;
	private final DataSourceFloatField sixNum8Field;
	private final DataSourceFloatField totalNum8Field;
	private final DataSourceFloatField zeroNum9Field;
	private final DataSourceFloatField oneNum9Field;
	private final DataSourceFloatField twoNum9Field;
	private final DataSourceFloatField threeNum9Field;
	private final DataSourceFloatField fourNum9Field;
	private final DataSourceFloatField fiveNum9Field;
	private final DataSourceFloatField sixNum9Field;
	private final DataSourceFloatField totalNum9Field;
	private final DataSourceFloatField zeroNum10Field;
	private final DataSourceFloatField oneNum10Field;
	private final DataSourceFloatField twoNum10Field;
	private final DataSourceFloatField threeNum10Field;
	private final DataSourceFloatField fourNum10Field;
	private final DataSourceFloatField fiveNum10Field;
	private final DataSourceFloatField sixNum10Field;
	private final DataSourceFloatField totalNum10Field;
	private final DataSourceFloatField zeroNum11Field;
	private final DataSourceFloatField oneNum11Field;
	private final DataSourceFloatField twoNum11Field;
	private final DataSourceFloatField threeNum11Field;
	private final DataSourceFloatField fourNum11Field;
	private final DataSourceFloatField fiveNum11Field;
	private final DataSourceFloatField sixNum11Field;
	private final DataSourceFloatField totalNum11Field;
	private final DataSourceFloatField zeroNum12Field;
	private final DataSourceFloatField oneNum12Field;
	private final DataSourceFloatField twoNum12Field;
	private final DataSourceFloatField threeNum12Field;
	private final DataSourceFloatField fourNum12Field;
	private final DataSourceFloatField fiveNum12Field;
	private final DataSourceFloatField sixNum12Field;
	private final DataSourceFloatField totalNum12Field;

	public DSReportOnEmployeeEducationTotalByDepartment(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ReportOnEmployeeEducationTotalByDepartment");


		departmentIdField = new DataSourceIntegerField("departmentId", "所属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);



		zeroNum1Field = new DataSourceFloatField("zeroNum1", "博士");
		zeroNum1Field.setLength(18);
		zeroNum1Field.setRequired(true);
		zeroNum1Field.setHidden(false);


		oneNum1Field = new DataSourceFloatField("oneNum1", "硕士");
		oneNum1Field.setLength(18);
		oneNum1Field.setDecimalPad(0);
		oneNum1Field.setRequired(true);
		oneNum1Field.setHidden(false);


		twoNum1Field = new DataSourceFloatField("twoNum1", "本科");
		twoNum1Field.setLength(18);
		twoNum1Field.setDecimalPad(0);
		twoNum1Field.setRequired(true);
		twoNum1Field.setHidden(false);


		threeNum1Field = new DataSourceFloatField("threeNum1", "大专");
		threeNum1Field.setLength(18);
		threeNum1Field.setDecimalPad(0);
		threeNum1Field.setRequired(true);
		threeNum1Field.setHidden(false);


		fourNum1Field = new DataSourceFloatField("fourNum1", "中专");
		fourNum1Field.setLength(18);
		fourNum1Field.setDecimalPad(0);
		fourNum1Field.setRequired(true);
		fourNum1Field.setHidden(false);


		fiveNum1Field = new DataSourceFloatField("fiveNum1", "高中");
		fiveNum1Field.setLength(18);
		fiveNum1Field.setDecimalPad(0);
		fiveNum1Field.setRequired(true);
		fiveNum1Field.setHidden(false);


		sixNum1Field = new DataSourceFloatField("sixNum1", "其他");
		sixNum1Field.setLength(18);
		sixNum1Field.setDecimalPad(0);
		sixNum1Field.setRequired(true);
		sixNum1Field.setHidden(false);


		totalNum1Field = new DataSourceFloatField("totalNum1", "合计");
		totalNum1Field.setLength(18);
		totalNum1Field.setDecimalPad(0);
		totalNum1Field.setRequired(true);
		totalNum1Field.setHidden(false);


		zeroNum2Field = new DataSourceFloatField("zeroNum2", "博士");
		zeroNum2Field.setLength(18);
		zeroNum2Field.setDecimalPad(0);
		zeroNum2Field.setRequired(true);
		zeroNum2Field.setHidden(false);


		oneNum2Field = new DataSourceFloatField("oneNum2", "硕士");
		oneNum2Field.setLength(18);
		oneNum2Field.setDecimalPad(0);
		oneNum2Field.setRequired(true);
		oneNum2Field.setHidden(false);


		twoNum2Field = new DataSourceFloatField("twoNum2", "本科");
		twoNum2Field.setLength(18);
		twoNum2Field.setDecimalPad(0);
		twoNum2Field.setRequired(true);
		twoNum2Field.setHidden(false);


		threeNum2Field = new DataSourceFloatField("threeNum2", "大专");
		threeNum2Field.setLength(18);
		threeNum2Field.setDecimalPad(0);
		threeNum2Field.setRequired(true);
		threeNum2Field.setHidden(false);


		fourNum2Field = new DataSourceFloatField("fourNum2", "中专");
		fourNum2Field.setLength(18);
		fourNum2Field.setDecimalPad(0);
		fourNum2Field.setRequired(true);
		fourNum2Field.setHidden(false);


		fiveNum2Field = new DataSourceFloatField("fiveNum2", "高中");
		fiveNum2Field.setLength(18);
		fiveNum2Field.setDecimalPad(0);
		fiveNum2Field.setRequired(true);
		fiveNum2Field.setHidden(false);


		sixNum2Field = new DataSourceFloatField("sixNum2", "其他");
		sixNum2Field.setLength(18);
		sixNum2Field.setDecimalPad(0);
		sixNum2Field.setRequired(true);
		sixNum2Field.setHidden(false);


		totalNum2Field = new DataSourceFloatField("totalNum2", "合计");
		totalNum2Field.setLength(18);
		totalNum2Field.setDecimalPad(0);
		totalNum2Field.setRequired(true);
		totalNum2Field.setHidden(false);


		zeroNum3Field = new DataSourceFloatField("zeroNum3", "博士");
		zeroNum3Field.setLength(18);
		zeroNum3Field.setDecimalPad(0);
		zeroNum3Field.setRequired(true);
		zeroNum3Field.setHidden(false);


		oneNum3Field = new DataSourceFloatField("oneNum3", "硕士");
		oneNum3Field.setLength(18);
		oneNum3Field.setDecimalPad(0);
		oneNum3Field.setRequired(true);
		oneNum3Field.setHidden(false);


		twoNum3Field = new DataSourceFloatField("twoNum3", "本科");
		twoNum3Field.setLength(18);
		twoNum3Field.setDecimalPad(0);
		twoNum3Field.setRequired(true);
		twoNum3Field.setHidden(false);


		threeNum3Field = new DataSourceFloatField("threeNum3", "大专");
		threeNum3Field.setLength(18);
		threeNum3Field.setDecimalPad(0);
		threeNum3Field.setRequired(true);
		threeNum3Field.setHidden(false);


		fourNum3Field = new DataSourceFloatField("fourNum3", "中专");
		fourNum3Field.setLength(18);
		fourNum3Field.setDecimalPad(0);
		fourNum3Field.setRequired(true);
		fourNum3Field.setHidden(false);


		fiveNum3Field = new DataSourceFloatField("fiveNum3", "高中");
		fiveNum3Field.setLength(18);
		fiveNum3Field.setDecimalPad(0);
		fiveNum3Field.setRequired(true);
		fiveNum3Field.setHidden(false);


		sixNum3Field = new DataSourceFloatField("sixNum3", "其他");
		sixNum3Field.setLength(18);
		sixNum3Field.setDecimalPad(0);
		sixNum3Field.setRequired(true);
		sixNum3Field.setHidden(false);


		totalNum3Field = new DataSourceFloatField("totalNum3", "合计");
		totalNum3Field.setLength(18);
		totalNum3Field.setDecimalPad(0);
		totalNum3Field.setRequired(true);
		totalNum3Field.setHidden(false);


		zeroNum4Field = new DataSourceFloatField("zeroNum4", "博士");
		zeroNum4Field.setLength(18);
		zeroNum4Field.setDecimalPad(0);
		zeroNum4Field.setRequired(true);
		zeroNum4Field.setHidden(false);


		oneNum4Field = new DataSourceFloatField("oneNum4", "硕士");
		oneNum4Field.setLength(18);
		oneNum4Field.setDecimalPad(0);
		oneNum4Field.setRequired(true);
		oneNum4Field.setHidden(false);


		twoNum4Field = new DataSourceFloatField("twoNum4", "本科");
		twoNum4Field.setLength(18);
		twoNum4Field.setDecimalPad(0);
		twoNum4Field.setRequired(true);
		twoNum4Field.setHidden(false);


		threeNum4Field = new DataSourceFloatField("threeNum4", "大专");
		threeNum4Field.setLength(18);
		threeNum4Field.setDecimalPad(0);
		threeNum4Field.setRequired(true);
		threeNum4Field.setHidden(false);


		fourNum4Field = new DataSourceFloatField("fourNum4", "中专");
		fourNum4Field.setLength(18);
		fourNum4Field.setDecimalPad(0);
		fourNum4Field.setRequired(true);
		fourNum4Field.setHidden(false);


		fiveNum4Field = new DataSourceFloatField("fiveNum4", "高中");
		fiveNum4Field.setLength(18);
		fiveNum4Field.setDecimalPad(0);
		fiveNum4Field.setRequired(true);
		fiveNum4Field.setHidden(false);


		sixNum4Field = new DataSourceFloatField("sixNum4", "其他");
		sixNum4Field.setLength(18);
		sixNum4Field.setDecimalPad(0);
		sixNum4Field.setRequired(true);
		sixNum4Field.setHidden(false);


		totalNum4Field = new DataSourceFloatField("totalNum4", "合计");
		totalNum4Field.setLength(18);
		totalNum4Field.setDecimalPad(0);
		totalNum4Field.setRequired(true);
		totalNum4Field.setHidden(false);


		zeroNum5Field = new DataSourceFloatField("zeroNum5", "博士");
		zeroNum5Field.setLength(18);
		zeroNum5Field.setDecimalPad(0);
		zeroNum5Field.setRequired(true);
		zeroNum5Field.setHidden(false);


		oneNum5Field = new DataSourceFloatField("oneNum5", "硕士");
		oneNum5Field.setLength(18);
		oneNum5Field.setDecimalPad(0);
		oneNum5Field.setRequired(true);
		oneNum5Field.setHidden(false);


		twoNum5Field = new DataSourceFloatField("twoNum5", "本科");
		twoNum5Field.setLength(18);
		twoNum5Field.setDecimalPad(0);
		twoNum5Field.setRequired(true);
		twoNum5Field.setHidden(false);


		threeNum5Field = new DataSourceFloatField("threeNum5", "大专");
		threeNum5Field.setLength(18);
		threeNum5Field.setDecimalPad(0);
		threeNum5Field.setRequired(true);
		threeNum5Field.setHidden(false);


		fourNum5Field = new DataSourceFloatField("fourNum5", "中专");
		fourNum5Field.setLength(18);
		fourNum5Field.setDecimalPad(0);
		fourNum5Field.setRequired(true);
		fourNum5Field.setHidden(false);


		fiveNum5Field = new DataSourceFloatField("fiveNum5", "高中");
		fiveNum5Field.setLength(18);
		fiveNum5Field.setDecimalPad(0);
		fiveNum5Field.setRequired(true);
		fiveNum5Field.setHidden(false);


		sixNum5Field = new DataSourceFloatField("sixNum5", "其他");
		sixNum5Field.setLength(18);
		sixNum5Field.setDecimalPad(0);
		sixNum5Field.setRequired(true);
		sixNum5Field.setHidden(false);


		totalNum5Field = new DataSourceFloatField("totalNum5", "合计");
		totalNum5Field.setLength(18);
		totalNum5Field.setDecimalPad(0);
		totalNum5Field.setRequired(true);
		totalNum5Field.setHidden(false);


		zeroNum6Field = new DataSourceFloatField("zeroNum6", "博士");
		zeroNum6Field.setLength(18);
		zeroNum6Field.setDecimalPad(0);
		zeroNum6Field.setRequired(true);
		zeroNum6Field.setHidden(false);


		oneNum6Field = new DataSourceFloatField("oneNum6", "硕士");
		oneNum6Field.setLength(18);
		oneNum6Field.setDecimalPad(0);
		oneNum6Field.setRequired(true);
		oneNum6Field.setHidden(false);


		twoNum6Field = new DataSourceFloatField("twoNum6", "本科");
		twoNum6Field.setLength(18);
		twoNum6Field.setDecimalPad(0);
		twoNum6Field.setRequired(true);
		twoNum6Field.setHidden(false);


		threeNum6Field = new DataSourceFloatField("threeNum6", "大专");
		threeNum6Field.setLength(18);
		threeNum6Field.setDecimalPad(0);
		threeNum6Field.setRequired(true);
		threeNum6Field.setHidden(false);


		fourNum6Field = new DataSourceFloatField("fourNum6", "中专");
		fourNum6Field.setLength(18);
		fourNum6Field.setDecimalPad(0);
		fourNum6Field.setRequired(true);
		fourNum6Field.setHidden(false);


		fiveNum6Field = new DataSourceFloatField("fiveNum6", "高中");
		fiveNum6Field.setLength(18);
		fiveNum6Field.setDecimalPad(0);
		fiveNum6Field.setRequired(true);
		fiveNum6Field.setHidden(false);


		sixNum6Field = new DataSourceFloatField("sixNum6", "其他");
		sixNum6Field.setLength(18);
		sixNum6Field.setDecimalPad(0);
		sixNum6Field.setRequired(true);
		sixNum6Field.setHidden(false);


		totalNum6Field = new DataSourceFloatField("totalNum6", "合计");
		totalNum6Field.setLength(18);
		totalNum6Field.setDecimalPad(0);
		totalNum6Field.setRequired(true);
		totalNum6Field.setHidden(false);


		zeroNum7Field = new DataSourceFloatField("zeroNum7", "博士");
		zeroNum7Field.setLength(18);
		zeroNum7Field.setDecimalPad(0);
		zeroNum7Field.setRequired(true);
		zeroNum7Field.setHidden(false);


		oneNum7Field = new DataSourceFloatField("oneNum7", "硕士");
		oneNum7Field.setLength(18);
		oneNum7Field.setDecimalPad(0);
		oneNum7Field.setRequired(true);
		oneNum7Field.setHidden(false);


		twoNum7Field = new DataSourceFloatField("twoNum7", "本科");
		twoNum7Field.setLength(18);
		twoNum7Field.setDecimalPad(0);
		twoNum7Field.setRequired(true);
		twoNum7Field.setHidden(false);


		threeNum7Field = new DataSourceFloatField("threeNum7", "大专");
		threeNum7Field.setLength(18);
		threeNum7Field.setDecimalPad(0);
		threeNum7Field.setRequired(true);
		threeNum7Field.setHidden(false);


		fourNum7Field = new DataSourceFloatField("fourNum7", "中专");
		fourNum7Field.setLength(18);
		fourNum7Field.setDecimalPad(0);
		fourNum7Field.setRequired(true);
		fourNum7Field.setHidden(false);


		fiveNum7Field = new DataSourceFloatField("fiveNum7", "高中");
		fiveNum7Field.setLength(18);
		fiveNum7Field.setDecimalPad(0);
		fiveNum7Field.setRequired(true);
		fiveNum7Field.setHidden(false);


		sixNum7Field = new DataSourceFloatField("sixNum7", "其他");
		sixNum7Field.setLength(18);
		sixNum7Field.setDecimalPad(0);
		sixNum7Field.setRequired(true);
		sixNum7Field.setHidden(false);


		totalNum7Field = new DataSourceFloatField("totalNum7", "合计");
		totalNum7Field.setLength(18);
		totalNum7Field.setDecimalPad(0);
		totalNum7Field.setRequired(true);
		totalNum7Field.setHidden(false);


		zeroNum8Field = new DataSourceFloatField("zeroNum8", "博士");
		zeroNum8Field.setLength(18);
		zeroNum8Field.setDecimalPad(0);
		zeroNum8Field.setRequired(true);
		zeroNum8Field.setHidden(false);


		oneNum8Field = new DataSourceFloatField("oneNum8", "硕士");
		oneNum8Field.setLength(18);
		oneNum8Field.setDecimalPad(0);
		oneNum8Field.setRequired(true);
		oneNum8Field.setHidden(false);


		twoNum8Field = new DataSourceFloatField("twoNum8", "本科");
		twoNum8Field.setLength(18);
		twoNum8Field.setDecimalPad(0);
		twoNum8Field.setRequired(true);
		twoNum8Field.setHidden(false);


		threeNum8Field = new DataSourceFloatField("threeNum8", "大专");
		threeNum8Field.setLength(18);
		threeNum8Field.setDecimalPad(0);
		threeNum8Field.setRequired(true);
		threeNum8Field.setHidden(false);


		fourNum8Field = new DataSourceFloatField("fourNum8", "中专");
		fourNum8Field.setLength(18);
		fourNum8Field.setDecimalPad(0);
		fourNum8Field.setRequired(true);
		fourNum8Field.setHidden(false);


		fiveNum8Field = new DataSourceFloatField("fiveNum8", "高中");
		fiveNum8Field.setLength(18);
		fiveNum8Field.setDecimalPad(0);
		fiveNum8Field.setRequired(true);
		fiveNum8Field.setHidden(false);


		sixNum8Field = new DataSourceFloatField("sixNum8", "其他");
		sixNum8Field.setLength(18);
		sixNum8Field.setDecimalPad(0);
		sixNum8Field.setRequired(true);
		sixNum8Field.setHidden(false);


		totalNum8Field = new DataSourceFloatField("totalNum8", "合计");
		totalNum8Field.setLength(18);
		totalNum8Field.setDecimalPad(0);
		totalNum8Field.setRequired(true);
		totalNum8Field.setHidden(false);


		zeroNum9Field = new DataSourceFloatField("zeroNum9", "博士");
		zeroNum9Field.setLength(18);
		zeroNum9Field.setDecimalPad(0);
		zeroNum9Field.setRequired(true);
		zeroNum9Field.setHidden(false);


		oneNum9Field = new DataSourceFloatField("oneNum9", "硕士");
		oneNum9Field.setLength(18);
		oneNum9Field.setDecimalPad(0);
		oneNum9Field.setRequired(true);
		oneNum9Field.setHidden(false);


		twoNum9Field = new DataSourceFloatField("twoNum9", "本科");
		twoNum9Field.setLength(18);
		twoNum9Field.setDecimalPad(0);
		twoNum9Field.setRequired(true);
		twoNum9Field.setHidden(false);


		threeNum9Field = new DataSourceFloatField("threeNum9", "大专");
		threeNum9Field.setLength(18);
		threeNum9Field.setDecimalPad(0);
		threeNum9Field.setRequired(true);
		threeNum9Field.setHidden(false);


		fourNum9Field = new DataSourceFloatField("fourNum9", "中专");
		fourNum9Field.setLength(18);
		fourNum9Field.setDecimalPad(0);
		fourNum9Field.setRequired(true);
		fourNum9Field.setHidden(false);


		fiveNum9Field = new DataSourceFloatField("fiveNum9", "高中");
		fiveNum9Field.setLength(18);
		fiveNum9Field.setDecimalPad(0);
		fiveNum9Field.setRequired(true);
		fiveNum9Field.setHidden(false);


		sixNum9Field = new DataSourceFloatField("sixNum9", "其他");
		sixNum9Field.setLength(18);
		sixNum9Field.setDecimalPad(0);
		sixNum9Field.setRequired(true);
		sixNum9Field.setHidden(false);


		totalNum9Field = new DataSourceFloatField("totalNum9", "合计");
		totalNum9Field.setLength(18);
		totalNum9Field.setDecimalPad(0);
		totalNum9Field.setRequired(true);
		totalNum9Field.setHidden(false);


		zeroNum10Field = new DataSourceFloatField("zeroNum10", "博士");
		zeroNum10Field.setLength(18);
		zeroNum10Field.setDecimalPad(0);
		zeroNum10Field.setRequired(true);
		zeroNum10Field.setHidden(false);


		oneNum10Field = new DataSourceFloatField("oneNum10", "硕士");
		oneNum10Field.setLength(18);
		oneNum10Field.setDecimalPad(0);
		oneNum10Field.setRequired(true);
		oneNum10Field.setHidden(false);


		twoNum10Field = new DataSourceFloatField("twoNum10", "本科");
		twoNum10Field.setLength(18);
		twoNum10Field.setDecimalPad(0);
		twoNum10Field.setRequired(true);
		twoNum10Field.setHidden(false);


		threeNum10Field = new DataSourceFloatField("threeNum10", "大专");
		threeNum10Field.setLength(18);
		threeNum10Field.setDecimalPad(0);
		threeNum10Field.setRequired(true);
		threeNum10Field.setHidden(false);


		fourNum10Field = new DataSourceFloatField("fourNum10", "中专");
		fourNum10Field.setLength(18);
		fourNum10Field.setDecimalPad(0);
		fourNum10Field.setRequired(true);
		fourNum10Field.setHidden(false);


		fiveNum10Field = new DataSourceFloatField("fiveNum10", "高中");
		fiveNum10Field.setLength(18);
		fiveNum10Field.setDecimalPad(0);
		fiveNum10Field.setRequired(true);
		fiveNum10Field.setHidden(false);


		sixNum10Field = new DataSourceFloatField("sixNum10", "其他");
		sixNum10Field.setLength(18);
		sixNum10Field.setDecimalPad(0);
		sixNum10Field.setRequired(true);
		sixNum10Field.setHidden(false);


		totalNum10Field = new DataSourceFloatField("totalNum10", "合计");
		totalNum10Field.setLength(18);
		totalNum10Field.setDecimalPad(0);
		totalNum10Field.setRequired(true);
		totalNum10Field.setHidden(false);


		zeroNum11Field = new DataSourceFloatField("zeroNum11", "博士");
		zeroNum11Field.setLength(18);
		zeroNum11Field.setDecimalPad(0);
		zeroNum11Field.setRequired(true);
		zeroNum11Field.setHidden(false);


		oneNum11Field = new DataSourceFloatField("oneNum11", "硕士");
		oneNum11Field.setLength(18);
		oneNum11Field.setDecimalPad(0);
		oneNum11Field.setRequired(true);
		oneNum11Field.setHidden(false);


		twoNum11Field = new DataSourceFloatField("twoNum11", "本科");
		twoNum11Field.setLength(18);
		twoNum11Field.setDecimalPad(0);
		twoNum11Field.setRequired(true);
		twoNum11Field.setHidden(false);


		threeNum11Field = new DataSourceFloatField("threeNum11", "大专");
		threeNum11Field.setLength(18);
		threeNum11Field.setDecimalPad(0);
		threeNum11Field.setRequired(true);
		threeNum11Field.setHidden(false);


		fourNum11Field = new DataSourceFloatField("fourNum11", "中专");
		fourNum11Field.setLength(18);
		fourNum11Field.setDecimalPad(0);
		fourNum11Field.setRequired(true);
		fourNum11Field.setHidden(false);


		fiveNum11Field = new DataSourceFloatField("fiveNum11", "高中");
		fiveNum11Field.setLength(18);
		fiveNum11Field.setDecimalPad(0);
		fiveNum11Field.setRequired(true);
		fiveNum11Field.setHidden(false);


		sixNum11Field = new DataSourceFloatField("sixNum11", "其他");
		sixNum11Field.setLength(18);
		sixNum11Field.setDecimalPad(0);
		sixNum11Field.setRequired(true);
		sixNum11Field.setHidden(false);


		totalNum11Field = new DataSourceFloatField("totalNum11", "合计");
		totalNum11Field.setLength(18);
		totalNum11Field.setDecimalPad(0);
		totalNum11Field.setRequired(true);
		totalNum11Field.setHidden(false);


		zeroNum12Field = new DataSourceFloatField("zeroNum12", "博士");
		zeroNum12Field.setLength(18);
		zeroNum12Field.setDecimalPad(0);
		zeroNum12Field.setRequired(true);
		zeroNum12Field.setHidden(false);


		oneNum12Field = new DataSourceFloatField("oneNum12", "硕士");
		oneNum12Field.setLength(18);
		oneNum12Field.setDecimalPad(0);
		oneNum12Field.setRequired(true);
		oneNum12Field.setHidden(false);


		twoNum12Field = new DataSourceFloatField("twoNum12", "本科");
		twoNum12Field.setLength(18);
		twoNum12Field.setDecimalPad(0);
		twoNum12Field.setRequired(true);
		twoNum12Field.setHidden(false);


		threeNum12Field = new DataSourceFloatField("threeNum12", "大专");
		threeNum12Field.setLength(18);
		threeNum12Field.setDecimalPad(0);
		threeNum12Field.setRequired(true);
		threeNum12Field.setHidden(false);


		fourNum12Field = new DataSourceFloatField("fourNum12", "中专");
		fourNum12Field.setLength(18);
		fourNum12Field.setDecimalPad(0);
		fourNum12Field.setRequired(true);
		fourNum12Field.setHidden(false);


		fiveNum12Field = new DataSourceFloatField("fiveNum12", "高中");
		fiveNum12Field.setLength(18);
		fiveNum12Field.setDecimalPad(0);
		fiveNum12Field.setRequired(true);
		fiveNum12Field.setHidden(false);


		sixNum12Field = new DataSourceFloatField("sixNum12", "其他");
		sixNum12Field.setLength(18);
		sixNum12Field.setDecimalPad(0);
		sixNum12Field.setRequired(true);
		sixNum12Field.setHidden(false);


		totalNum12Field = new DataSourceFloatField("totalNum12", "合计");
		totalNum12Field.setLength(18);
		totalNum12Field.setDecimalPad(0);
		totalNum12Field.setRequired(true);
		totalNum12Field.setHidden(false);


		setFields(departmentIdField, yearField, zeroNum1Field, oneNum1Field, twoNum1Field, threeNum1Field, fourNum1Field, fiveNum1Field, sixNum1Field, totalNum1Field, zeroNum2Field, oneNum2Field, twoNum2Field, threeNum2Field, fourNum2Field, fiveNum2Field, sixNum2Field, totalNum2Field, zeroNum3Field, oneNum3Field, twoNum3Field, threeNum3Field, fourNum3Field, fiveNum3Field, sixNum3Field, totalNum3Field, zeroNum4Field, oneNum4Field, twoNum4Field, threeNum4Field, fourNum4Field, fiveNum4Field, sixNum4Field, totalNum4Field, zeroNum5Field, oneNum5Field, twoNum5Field, threeNum5Field, fourNum5Field, fiveNum5Field, sixNum5Field, totalNum5Field, zeroNum6Field, oneNum6Field, twoNum6Field, threeNum6Field, fourNum6Field, fiveNum6Field, sixNum6Field, totalNum6Field, zeroNum7Field, oneNum7Field, twoNum7Field, threeNum7Field, fourNum7Field, fiveNum7Field, sixNum7Field, totalNum7Field, zeroNum8Field, oneNum8Field, twoNum8Field, threeNum8Field, fourNum8Field, fiveNum8Field, sixNum8Field, totalNum8Field, zeroNum9Field, oneNum9Field, twoNum9Field, threeNum9Field, fourNum9Field, fiveNum9Field, sixNum9Field, totalNum9Field, zeroNum10Field, oneNum10Field, twoNum10Field, threeNum10Field, fourNum10Field, fiveNum10Field, sixNum10Field, totalNum10Field, zeroNum11Field, oneNum11Field, twoNum11Field, threeNum11Field, fourNum11Field, fiveNum11Field, sixNum11Field, totalNum11Field, zeroNum12Field, oneNum12Field, twoNum12Field, threeNum12Field, fourNum12Field, fiveNum12Field, sixNum12Field, totalNum12Field);
	}


}

