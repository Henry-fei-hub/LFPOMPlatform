package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSReportOnEmployeeAgeTotalByDepartment extends DBDataSource
{


	public static DSReportOnEmployeeAgeTotalByDepartment instance = null;

	public static DSReportOnEmployeeAgeTotalByDepartment getInstance() {
		if(instance == null) {
			instance = new DSReportOnEmployeeAgeTotalByDepartment("DSReportOnEmployeeAgeTotalByDepartment");
		}
		return instance;
	}

	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceFloatField sixNum1Field;
	private final DataSourceFloatField sevenNum1Field;
	private final DataSourceFloatField eightNum1Field;
	private final DataSourceFloatField nineNum1Field;
	private final DataSourceFloatField zeroNum1Field;
	private final DataSourceFloatField totalNum1Field;
	private final DataSourceFloatField sixNum2Field;
	private final DataSourceFloatField sevenNum2Field;
	private final DataSourceFloatField eightNum2Field;
	private final DataSourceFloatField nineNum2Field;
	private final DataSourceFloatField zeroNum2Field;
	private final DataSourceFloatField totalNum2Field;
	private final DataSourceFloatField sixNum3Field;
	private final DataSourceFloatField sevenNum3Field;
	private final DataSourceFloatField eightNum3Field;
	private final DataSourceFloatField nineNum3Field;
	private final DataSourceFloatField zeroNum3Field;
	private final DataSourceFloatField totalNum3Field;
	private final DataSourceFloatField sixNum4Field;
	private final DataSourceFloatField sevenNum4Field;
	private final DataSourceFloatField eightNum4Field;
	private final DataSourceFloatField nineNum4Field;
	private final DataSourceFloatField zeroNum4Field;
	private final DataSourceFloatField totalNum4Field;
	private final DataSourceFloatField sixNum5Field;
	private final DataSourceFloatField sevenNum5Field;
	private final DataSourceFloatField eightNum5Field;
	private final DataSourceFloatField nineNum5Field;
	private final DataSourceFloatField zeroNum5Field;
	private final DataSourceFloatField totalNum5Field;
	private final DataSourceFloatField sixNum6Field;
	private final DataSourceFloatField sevenNum6Field;
	private final DataSourceFloatField eightNum6Field;
	private final DataSourceFloatField nineNum6Field;
	private final DataSourceFloatField zeroNum6Field;
	private final DataSourceFloatField totalNum6Field;
	private final DataSourceFloatField sixNum7Field;
	private final DataSourceFloatField sevenNum7Field;
	private final DataSourceFloatField eightNum7Field;
	private final DataSourceFloatField nineNum7Field;
	private final DataSourceFloatField zeroNum7Field;
	private final DataSourceFloatField totalNum7Field;
	private final DataSourceFloatField sixNum8Field;
	private final DataSourceFloatField sevenNum8Field;
	private final DataSourceFloatField eightNum8Field;
	private final DataSourceFloatField nineNum8Field;
	private final DataSourceFloatField zeroNum8Field;
	private final DataSourceFloatField totalNum8Field;
	private final DataSourceFloatField sixNum9Field;
	private final DataSourceFloatField sevenNum9Field;
	private final DataSourceFloatField eightNum9Field;
	private final DataSourceFloatField nineNum9Field;
	private final DataSourceFloatField zeroNum9Field;
	private final DataSourceFloatField totalNum9Field;
	private final DataSourceFloatField sixNum10Field;
	private final DataSourceFloatField sevenNum10Field;
	private final DataSourceFloatField eightNum10Field;
	private final DataSourceFloatField nineNum10Field;
	private final DataSourceFloatField zeroNum10Field;
	private final DataSourceFloatField totalNum10Field;
	private final DataSourceFloatField sixNum11Field;
	private final DataSourceFloatField sevenNum11Field;
	private final DataSourceFloatField eightNum11Field;
	private final DataSourceFloatField nineNum11Field;
	private final DataSourceFloatField zeroNum11Field;
	private final DataSourceFloatField totalNum11Field;
	private final DataSourceFloatField sixNum12Field;
	private final DataSourceFloatField sevenNum12Field;
	private final DataSourceFloatField eightNum12Field;
	private final DataSourceFloatField nineNum12Field;
	private final DataSourceFloatField zeroNum12Field;
	private final DataSourceFloatField totalNum12Field;

	public DSReportOnEmployeeAgeTotalByDepartment(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ReportOnEmployeeAgeTotalByDepartment");


		departmentIdField = new DataSourceIntegerField("departmentId", "所属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);

		sixNum1Field = new DataSourceFloatField("sixNum1", "60后");
		sixNum1Field.setLength(18);
		sixNum1Field.setDecimalPad(2);
		sixNum1Field.setFormat("#,###,###,###,###,##0.00");
		sixNum1Field.setRequired(true);
		sixNum1Field.setHidden(false);


		sevenNum1Field = new DataSourceFloatField("sevenNum1", "70后");
		sevenNum1Field.setLength(18);
		sevenNum1Field.setDecimalPad(2);
		sevenNum1Field.setFormat("#,###,###,###,###,##0.00");
		sevenNum1Field.setRequired(true);
		sevenNum1Field.setHidden(false);


		eightNum1Field = new DataSourceFloatField("eightNum1", "80后");
		eightNum1Field.setLength(18);
		eightNum1Field.setDecimalPad(2);
		eightNum1Field.setFormat("#,###,###,###,###,##0.00");
		eightNum1Field.setRequired(true);
		eightNum1Field.setHidden(false);


		nineNum1Field = new DataSourceFloatField("nineNum1", "90后");
		nineNum1Field.setLength(18);
		nineNum1Field.setDecimalPad(2);
		nineNum1Field.setFormat("#,###,###,###,###,##0.00");
		nineNum1Field.setRequired(true);
		nineNum1Field.setHidden(false);


		zeroNum1Field = new DataSourceFloatField("zeroNum1", "00后");
		zeroNum1Field.setLength(18);
		zeroNum1Field.setDecimalPad(2);
		zeroNum1Field.setFormat("#,###,###,###,###,##0.00");
		zeroNum1Field.setRequired(true);
		zeroNum1Field.setHidden(false);


		totalNum1Field = new DataSourceFloatField("totalNum1", "合计");
		totalNum1Field.setLength(18);
		totalNum1Field.setDecimalPad(2);
		totalNum1Field.setFormat("#,###,###,###,###,##0.00");
		totalNum1Field.setRequired(true);
		totalNum1Field.setHidden(false);


		sixNum2Field = new DataSourceFloatField("sixNum2", "60后");
		sixNum2Field.setLength(18);
		sixNum2Field.setDecimalPad(2);
		sixNum2Field.setFormat("#,###,###,###,###,##0.00");
		sixNum2Field.setRequired(true);
		sixNum2Field.setHidden(false);


		sevenNum2Field = new DataSourceFloatField("sevenNum2", "70后");
		sevenNum2Field.setLength(18);
		sevenNum2Field.setDecimalPad(2);
		sevenNum2Field.setFormat("#,###,###,###,###,##0.00");
		sevenNum2Field.setRequired(true);
		sevenNum2Field.setHidden(false);


		eightNum2Field = new DataSourceFloatField("eightNum2", "80后");
		eightNum2Field.setLength(18);
		eightNum2Field.setDecimalPad(2);
		eightNum2Field.setFormat("#,###,###,###,###,##0.00");
		eightNum2Field.setRequired(true);
		eightNum2Field.setHidden(false);


		nineNum2Field = new DataSourceFloatField("nineNum2", "90后");
		nineNum2Field.setLength(18);
		nineNum2Field.setDecimalPad(2);
		nineNum2Field.setFormat("#,###,###,###,###,##0.00");
		nineNum2Field.setRequired(true);
		nineNum2Field.setHidden(false);


		zeroNum2Field = new DataSourceFloatField("zeroNum2", "00后");
		zeroNum2Field.setLength(18);
		zeroNum2Field.setDecimalPad(2);
		zeroNum2Field.setFormat("#,###,###,###,###,##0.00");
		zeroNum2Field.setRequired(true);
		zeroNum2Field.setHidden(false);


		totalNum2Field = new DataSourceFloatField("totalNum2", "合计");
		totalNum2Field.setLength(18);
		totalNum2Field.setDecimalPad(2);
		totalNum2Field.setFormat("#,###,###,###,###,##0.00");
		totalNum2Field.setRequired(true);
		totalNum2Field.setHidden(false);


		sixNum3Field = new DataSourceFloatField("sixNum3", "60后");
		sixNum3Field.setLength(18);
		sixNum3Field.setDecimalPad(2);
		sixNum3Field.setFormat("#,###,###,###,###,##0.00");
		sixNum3Field.setRequired(true);
		sixNum3Field.setHidden(false);


		sevenNum3Field = new DataSourceFloatField("sevenNum3", "70后");
		sevenNum3Field.setLength(18);
		sevenNum3Field.setDecimalPad(2);
		sevenNum3Field.setFormat("#,###,###,###,###,##0.00");
		sevenNum3Field.setRequired(true);
		sevenNum3Field.setHidden(false);


		eightNum3Field = new DataSourceFloatField("eightNum3", "80后");
		eightNum3Field.setLength(18);
		eightNum3Field.setDecimalPad(2);
		eightNum3Field.setFormat("#,###,###,###,###,##0.00");
		eightNum3Field.setRequired(true);
		eightNum3Field.setHidden(false);


		nineNum3Field = new DataSourceFloatField("nineNum3", "90后");
		nineNum3Field.setLength(18);
		nineNum3Field.setDecimalPad(2);
		nineNum3Field.setFormat("#,###,###,###,###,##0.00");
		nineNum3Field.setRequired(true);
		nineNum3Field.setHidden(false);


		zeroNum3Field = new DataSourceFloatField("zeroNum3", "00后");
		zeroNum3Field.setLength(18);
		zeroNum3Field.setDecimalPad(2);
		zeroNum3Field.setFormat("#,###,###,###,###,##0.00");
		zeroNum3Field.setRequired(true);
		zeroNum3Field.setHidden(false);


		totalNum3Field = new DataSourceFloatField("totalNum3", "合计");
		totalNum3Field.setLength(18);
		totalNum3Field.setDecimalPad(2);
		totalNum3Field.setFormat("#,###,###,###,###,##0.00");
		totalNum3Field.setRequired(true);
		totalNum3Field.setHidden(false);


		sixNum4Field = new DataSourceFloatField("sixNum4", "60后");
		sixNum4Field.setLength(18);
		sixNum4Field.setDecimalPad(2);
		sixNum4Field.setFormat("#,###,###,###,###,##0.00");
		sixNum4Field.setRequired(true);
		sixNum4Field.setHidden(false);


		sevenNum4Field = new DataSourceFloatField("sevenNum4", "70后");
		sevenNum4Field.setLength(18);
		sevenNum4Field.setDecimalPad(2);
		sevenNum4Field.setFormat("#,###,###,###,###,##0.00");
		sevenNum4Field.setRequired(true);
		sevenNum4Field.setHidden(false);


		eightNum4Field = new DataSourceFloatField("eightNum4", "80后");
		eightNum4Field.setLength(18);
		eightNum4Field.setDecimalPad(2);
		eightNum4Field.setFormat("#,###,###,###,###,##0.00");
		eightNum4Field.setRequired(true);
		eightNum4Field.setHidden(false);


		nineNum4Field = new DataSourceFloatField("nineNum4", "90后");
		nineNum4Field.setLength(18);
		nineNum4Field.setDecimalPad(2);
		nineNum4Field.setFormat("#,###,###,###,###,##0.00");
		nineNum4Field.setRequired(true);
		nineNum4Field.setHidden(false);


		zeroNum4Field = new DataSourceFloatField("zeroNum4", "00后");
		zeroNum4Field.setLength(18);
		zeroNum4Field.setDecimalPad(2);
		zeroNum4Field.setFormat("#,###,###,###,###,##0.00");
		zeroNum4Field.setRequired(true);
		zeroNum4Field.setHidden(false);


		totalNum4Field = new DataSourceFloatField("totalNum4", "合计");
		totalNum4Field.setLength(18);
		totalNum4Field.setDecimalPad(2);
		totalNum4Field.setFormat("#,###,###,###,###,##0.00");
		totalNum4Field.setRequired(true);
		totalNum4Field.setHidden(false);


		sixNum5Field = new DataSourceFloatField("sixNum5", "60后");
		sixNum5Field.setLength(18);
		sixNum5Field.setDecimalPad(2);
		sixNum5Field.setFormat("#,###,###,###,###,##0.00");
		sixNum5Field.setRequired(true);
		sixNum5Field.setHidden(false);


		sevenNum5Field = new DataSourceFloatField("sevenNum5", "70后");
		sevenNum5Field.setLength(18);
		sevenNum5Field.setDecimalPad(2);
		sevenNum5Field.setFormat("#,###,###,###,###,##0.00");
		sevenNum5Field.setRequired(true);
		sevenNum5Field.setHidden(false);


		eightNum5Field = new DataSourceFloatField("eightNum5", "80后");
		eightNum5Field.setLength(18);
		eightNum5Field.setDecimalPad(2);
		eightNum5Field.setFormat("#,###,###,###,###,##0.00");
		eightNum5Field.setRequired(true);
		eightNum5Field.setHidden(false);


		nineNum5Field = new DataSourceFloatField("nineNum5", "90后");
		nineNum5Field.setLength(18);
		nineNum5Field.setDecimalPad(2);
		nineNum5Field.setFormat("#,###,###,###,###,##0.00");
		nineNum5Field.setRequired(true);
		nineNum5Field.setHidden(false);


		zeroNum5Field = new DataSourceFloatField("zeroNum5", "00后");
		zeroNum5Field.setLength(18);
		zeroNum5Field.setDecimalPad(2);
		zeroNum5Field.setFormat("#,###,###,###,###,##0.00");
		zeroNum5Field.setRequired(true);
		zeroNum5Field.setHidden(false);


		totalNum5Field = new DataSourceFloatField("totalNum5", "合计");
		totalNum5Field.setLength(18);
		totalNum5Field.setDecimalPad(2);
		totalNum5Field.setFormat("#,###,###,###,###,##0.00");
		totalNum5Field.setRequired(true);
		totalNum5Field.setHidden(false);


		sixNum6Field = new DataSourceFloatField("sixNum6", "60后");
		sixNum6Field.setLength(18);
		sixNum6Field.setDecimalPad(2);
		sixNum6Field.setFormat("#,###,###,###,###,##0.00");
		sixNum6Field.setRequired(true);
		sixNum6Field.setHidden(false);


		sevenNum6Field = new DataSourceFloatField("sevenNum6", "70后");
		sevenNum6Field.setLength(18);
		sevenNum6Field.setDecimalPad(2);
		sevenNum6Field.setFormat("#,###,###,###,###,##0.00");
		sevenNum6Field.setRequired(true);
		sevenNum6Field.setHidden(false);


		eightNum6Field = new DataSourceFloatField("eightNum6", "80后");
		eightNum6Field.setLength(18);
		eightNum6Field.setDecimalPad(2);
		eightNum6Field.setFormat("#,###,###,###,###,##0.00");
		eightNum6Field.setRequired(true);
		eightNum6Field.setHidden(false);


		nineNum6Field = new DataSourceFloatField("nineNum6", "90后");
		nineNum6Field.setLength(18);
		nineNum6Field.setDecimalPad(2);
		nineNum6Field.setFormat("#,###,###,###,###,##0.00");
		nineNum6Field.setRequired(true);
		nineNum6Field.setHidden(false);


		zeroNum6Field = new DataSourceFloatField("zeroNum6", "00后");
		zeroNum6Field.setLength(18);
		zeroNum6Field.setDecimalPad(2);
		zeroNum6Field.setFormat("#,###,###,###,###,##0.00");
		zeroNum6Field.setRequired(true);
		zeroNum6Field.setHidden(false);


		totalNum6Field = new DataSourceFloatField("totalNum6", "合计");
		totalNum6Field.setLength(18);
		totalNum6Field.setDecimalPad(2);
		totalNum6Field.setFormat("#,###,###,###,###,##0.00");
		totalNum6Field.setRequired(true);
		totalNum6Field.setHidden(false);


		sixNum7Field = new DataSourceFloatField("sixNum7", "60后");
		sixNum7Field.setLength(18);
		sixNum7Field.setDecimalPad(2);
		sixNum7Field.setFormat("#,###,###,###,###,##0.00");
		sixNum7Field.setRequired(true);
		sixNum7Field.setHidden(false);


		sevenNum7Field = new DataSourceFloatField("sevenNum7", "70后");
		sevenNum7Field.setLength(18);
		sevenNum7Field.setDecimalPad(2);
		sevenNum7Field.setFormat("#,###,###,###,###,##0.00");
		sevenNum7Field.setRequired(true);
		sevenNum7Field.setHidden(false);


		eightNum7Field = new DataSourceFloatField("eightNum7", "80后");
		eightNum7Field.setLength(18);
		eightNum7Field.setDecimalPad(2);
		eightNum7Field.setFormat("#,###,###,###,###,##0.00");
		eightNum7Field.setRequired(true);
		eightNum7Field.setHidden(false);


		nineNum7Field = new DataSourceFloatField("nineNum7", "90后");
		nineNum7Field.setLength(18);
		nineNum7Field.setDecimalPad(2);
		nineNum7Field.setFormat("#,###,###,###,###,##0.00");
		nineNum7Field.setRequired(true);
		nineNum7Field.setHidden(false);


		zeroNum7Field = new DataSourceFloatField("zeroNum7", "00后");
		zeroNum7Field.setLength(18);
		zeroNum7Field.setDecimalPad(2);
		zeroNum7Field.setFormat("#,###,###,###,###,##0.00");
		zeroNum7Field.setRequired(true);
		zeroNum7Field.setHidden(false);


		totalNum7Field = new DataSourceFloatField("totalNum7", "合计");
		totalNum7Field.setLength(18);
		totalNum7Field.setDecimalPad(2);
		totalNum7Field.setFormat("#,###,###,###,###,##0.00");
		totalNum7Field.setRequired(true);
		totalNum7Field.setHidden(false);


		sixNum8Field = new DataSourceFloatField("sixNum8", "60后");
		sixNum8Field.setLength(18);
		sixNum8Field.setDecimalPad(2);
		sixNum8Field.setFormat("#,###,###,###,###,##0.00");
		sixNum8Field.setRequired(true);
		sixNum8Field.setHidden(false);


		sevenNum8Field = new DataSourceFloatField("sevenNum8", "70后");
		sevenNum8Field.setLength(18);
		sevenNum8Field.setDecimalPad(2);
		sevenNum8Field.setFormat("#,###,###,###,###,##0.00");
		sevenNum8Field.setRequired(true);
		sevenNum8Field.setHidden(false);


		eightNum8Field = new DataSourceFloatField("eightNum8", "80后");
		eightNum8Field.setLength(18);
		eightNum8Field.setDecimalPad(2);
		eightNum8Field.setFormat("#,###,###,###,###,##0.00");
		eightNum8Field.setRequired(true);
		eightNum8Field.setHidden(false);


		nineNum8Field = new DataSourceFloatField("nineNum8", "90后");
		nineNum8Field.setLength(18);
		nineNum8Field.setDecimalPad(2);
		nineNum8Field.setFormat("#,###,###,###,###,##0.00");
		nineNum8Field.setRequired(true);
		nineNum8Field.setHidden(false);


		zeroNum8Field = new DataSourceFloatField("zeroNum8", "00后");
		zeroNum8Field.setLength(18);
		zeroNum8Field.setDecimalPad(2);
		zeroNum8Field.setFormat("#,###,###,###,###,##0.00");
		zeroNum8Field.setRequired(true);
		zeroNum8Field.setHidden(false);


		totalNum8Field = new DataSourceFloatField("totalNum8", "合计");
		totalNum8Field.setLength(18);
		totalNum8Field.setDecimalPad(2);
		totalNum8Field.setFormat("#,###,###,###,###,##0.00");
		totalNum8Field.setRequired(true);
		totalNum8Field.setHidden(false);


		sixNum9Field = new DataSourceFloatField("sixNum9", "60后");
		sixNum9Field.setLength(18);
		sixNum9Field.setDecimalPad(2);
		sixNum9Field.setFormat("#,###,###,###,###,##0.00");
		sixNum9Field.setRequired(true);
		sixNum9Field.setHidden(false);


		sevenNum9Field = new DataSourceFloatField("sevenNum9", "70后");
		sevenNum9Field.setLength(18);
		sevenNum9Field.setDecimalPad(2);
		sevenNum9Field.setFormat("#,###,###,###,###,##0.00");
		sevenNum9Field.setRequired(true);
		sevenNum9Field.setHidden(false);


		eightNum9Field = new DataSourceFloatField("eightNum9", "80后");
		eightNum9Field.setLength(18);
		eightNum9Field.setDecimalPad(2);
		eightNum9Field.setFormat("#,###,###,###,###,##0.00");
		eightNum9Field.setRequired(true);
		eightNum9Field.setHidden(false);


		nineNum9Field = new DataSourceFloatField("nineNum9", "90后");
		nineNum9Field.setLength(18);
		nineNum9Field.setDecimalPad(2);
		nineNum9Field.setFormat("#,###,###,###,###,##0.00");
		nineNum9Field.setRequired(true);
		nineNum9Field.setHidden(false);


		zeroNum9Field = new DataSourceFloatField("zeroNum9", "00后");
		zeroNum9Field.setLength(18);
		zeroNum9Field.setDecimalPad(2);
		zeroNum9Field.setFormat("#,###,###,###,###,##0.00");
		zeroNum9Field.setRequired(true);
		zeroNum9Field.setHidden(false);


		totalNum9Field = new DataSourceFloatField("totalNum9", "合计");
		totalNum9Field.setLength(18);
		totalNum9Field.setDecimalPad(2);
		totalNum9Field.setFormat("#,###,###,###,###,##0.00");
		totalNum9Field.setRequired(true);
		totalNum9Field.setHidden(false);


		sixNum10Field = new DataSourceFloatField("sixNum10", "60后");
		sixNum10Field.setLength(18);
		sixNum10Field.setDecimalPad(2);
		sixNum10Field.setFormat("#,###,###,###,###,##0.00");
		sixNum10Field.setRequired(true);
		sixNum10Field.setHidden(false);


		sevenNum10Field = new DataSourceFloatField("sevenNum10", "70后");
		sevenNum10Field.setLength(18);
		sevenNum10Field.setDecimalPad(2);
		sevenNum10Field.setFormat("#,###,###,###,###,##0.00");
		sevenNum10Field.setRequired(true);
		sevenNum10Field.setHidden(false);


		eightNum10Field = new DataSourceFloatField("eightNum10", "80后");
		eightNum10Field.setLength(18);
		eightNum10Field.setDecimalPad(2);
		eightNum10Field.setFormat("#,###,###,###,###,##0.00");
		eightNum10Field.setRequired(true);
		eightNum10Field.setHidden(false);


		nineNum10Field = new DataSourceFloatField("nineNum10", "90后");
		nineNum10Field.setLength(18);
		nineNum10Field.setDecimalPad(2);
		nineNum10Field.setFormat("#,###,###,###,###,##0.00");
		nineNum10Field.setRequired(true);
		nineNum10Field.setHidden(false);


		zeroNum10Field = new DataSourceFloatField("zeroNum10", "00后");
		zeroNum10Field.setLength(18);
		zeroNum10Field.setDecimalPad(2);
		zeroNum10Field.setFormat("#,###,###,###,###,##0.00");
		zeroNum10Field.setRequired(true);
		zeroNum10Field.setHidden(false);


		totalNum10Field = new DataSourceFloatField("totalNum10", "合计");
		totalNum10Field.setLength(18);
		totalNum10Field.setDecimalPad(2);
		totalNum10Field.setFormat("#,###,###,###,###,##0.00");
		totalNum10Field.setRequired(true);
		totalNum10Field.setHidden(false);


		sixNum11Field = new DataSourceFloatField("sixNum11", "160后");
		sixNum11Field.setLength(18);
		sixNum11Field.setDecimalPad(2);
		sixNum11Field.setFormat("#,###,###,###,###,##0.00");
		sixNum11Field.setRequired(true);
		sixNum11Field.setHidden(false);


		sevenNum11Field = new DataSourceFloatField("sevenNum11", "170后");
		sevenNum11Field.setLength(18);
		sevenNum11Field.setDecimalPad(2);
		sevenNum11Field.setFormat("#,###,###,###,###,##0.00");
		sevenNum11Field.setRequired(true);
		sevenNum11Field.setHidden(false);


		eightNum11Field = new DataSourceFloatField("eightNum11", "180后");
		eightNum11Field.setLength(18);
		eightNum11Field.setDecimalPad(2);
		eightNum11Field.setFormat("#,###,###,###,###,##0.00");
		eightNum11Field.setRequired(true);
		eightNum11Field.setHidden(false);


		nineNum11Field = new DataSourceFloatField("nineNum11", "190后");
		nineNum11Field.setLength(18);
		nineNum11Field.setDecimalPad(2);
		nineNum11Field.setFormat("#,###,###,###,###,##0.00");
		nineNum11Field.setRequired(true);
		nineNum11Field.setHidden(false);


		zeroNum11Field = new DataSourceFloatField("zeroNum11", "100后");
		zeroNum11Field.setLength(18);
		zeroNum11Field.setDecimalPad(2);
		zeroNum11Field.setFormat("#,###,###,###,###,##0.00");
		zeroNum11Field.setRequired(true);
		zeroNum11Field.setHidden(false);


		totalNum11Field = new DataSourceFloatField("totalNum11", "1合计");
		totalNum11Field.setLength(18);
		totalNum11Field.setDecimalPad(2);
		totalNum11Field.setFormat("#,###,###,###,###,##0.00");
		totalNum11Field.setRequired(true);
		totalNum11Field.setHidden(false);


		sixNum12Field = new DataSourceFloatField("sixNum12", "160后");
		sixNum12Field.setLength(18);
		sixNum12Field.setDecimalPad(2);
		sixNum12Field.setFormat("#,###,###,###,###,##0.00");
		sixNum12Field.setRequired(true);
		sixNum12Field.setHidden(false);


		sevenNum12Field = new DataSourceFloatField("sevenNum12", "170后");
		sevenNum12Field.setLength(18);
		sevenNum12Field.setDecimalPad(2);
		sevenNum12Field.setFormat("#,###,###,###,###,##0.00");
		sevenNum12Field.setRequired(true);
		sevenNum12Field.setHidden(false);


		eightNum12Field = new DataSourceFloatField("eightNum12", "180后");
		eightNum12Field.setLength(18);
		eightNum12Field.setDecimalPad(2);
		eightNum12Field.setFormat("#,###,###,###,###,##0.00");
		eightNum12Field.setRequired(true);
		eightNum12Field.setHidden(false);


		nineNum12Field = new DataSourceFloatField("nineNum12", "190后");
		nineNum12Field.setLength(18);
		nineNum12Field.setDecimalPad(2);
		nineNum12Field.setFormat("#,###,###,###,###,##0.00");
		nineNum12Field.setRequired(true);
		nineNum12Field.setHidden(false);


		zeroNum12Field = new DataSourceFloatField("zeroNum12", "100后");
		zeroNum12Field.setLength(18);
		zeroNum12Field.setDecimalPad(2);
		zeroNum12Field.setFormat("#,###,###,###,###,##0.00");
		zeroNum12Field.setRequired(true);
		zeroNum12Field.setHidden(false);


		totalNum12Field = new DataSourceFloatField("totalNum12", "1合计");
		totalNum12Field.setLength(18);
		totalNum12Field.setDecimalPad(2);
		totalNum12Field.setFormat("#,###,###,###,###,##0.00");
		totalNum12Field.setRequired(true);
		totalNum12Field.setHidden(false);

		setFields(departmentIdField, yearField, sixNum1Field, sevenNum1Field, eightNum1Field, nineNum1Field, zeroNum1Field, totalNum1Field, sixNum2Field, sevenNum2Field, eightNum2Field, nineNum2Field, zeroNum2Field, totalNum2Field, sixNum3Field, sevenNum3Field, eightNum3Field, nineNum3Field, zeroNum3Field, totalNum3Field, sixNum4Field, sevenNum4Field, eightNum4Field, nineNum4Field, zeroNum4Field, totalNum4Field, sixNum5Field, sevenNum5Field, eightNum5Field, nineNum5Field, zeroNum5Field, totalNum5Field, sixNum6Field, sevenNum6Field, eightNum6Field, nineNum6Field, zeroNum6Field, totalNum6Field, sixNum7Field, sevenNum7Field, eightNum7Field, nineNum7Field, zeroNum7Field, totalNum7Field, sixNum8Field, sevenNum8Field, eightNum8Field, nineNum8Field, zeroNum8Field, totalNum8Field, sixNum9Field, sevenNum9Field, eightNum9Field, nineNum9Field, zeroNum9Field, totalNum9Field, sixNum10Field, sevenNum10Field, eightNum10Field, nineNum10Field, zeroNum10Field, totalNum10Field, sixNum11Field, sevenNum11Field, eightNum11Field, nineNum11Field, zeroNum11Field, totalNum11Field, sixNum12Field, sevenNum12Field, eightNum12Field, nineNum12Field, zeroNum12Field, totalNum12Field);
	}


}

