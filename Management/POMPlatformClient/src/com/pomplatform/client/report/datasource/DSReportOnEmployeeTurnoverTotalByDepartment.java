package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSReportOnEmployeeTurnoverTotalByDepartment extends DBDataSource
{


	public static DSReportOnEmployeeTurnoverTotalByDepartment instance = null;

	public static DSReportOnEmployeeTurnoverTotalByDepartment getInstance() {
		if(instance == null) {
			instance = new DSReportOnEmployeeTurnoverTotalByDepartment("DSReportOnEmployeeTurnoverTotalByDepartment");
		}
		return instance;
	}

	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceFloatField oneNum1Field;
	private final DataSourceFloatField twoNum1Field;
	private final DataSourceFloatField threeNum1Field;
	private final DataSourceFloatField fourNum1Field;
	private final DataSourceFloatField oneNum2Field;
	private final DataSourceFloatField twoNum2Field;
	private final DataSourceFloatField threeNum2Field;
	private final DataSourceFloatField fourNum2Field;
	private final DataSourceFloatField oneNum3Field;
	private final DataSourceFloatField twoNum3Field;
	private final DataSourceFloatField threeNum3Field;
	private final DataSourceFloatField fourNum3Field;
	private final DataSourceFloatField oneNum4Field;
	private final DataSourceFloatField twoNum4Field;
	private final DataSourceFloatField threeNum4Field;
	private final DataSourceFloatField fourNum4Field;
	private final DataSourceFloatField oneNum5Field;
	private final DataSourceFloatField twoNum5Field;
	private final DataSourceFloatField threeNum5Field;
	private final DataSourceFloatField fourNum5Field;
	private final DataSourceFloatField oneNum6Field;
	private final DataSourceFloatField twoNum6Field;
	private final DataSourceFloatField threeNum6Field;
	private final DataSourceFloatField fourNum6Field;
	private final DataSourceFloatField oneNum7Field;
	private final DataSourceFloatField twoNum7Field;
	private final DataSourceFloatField threeNum7Field;
	private final DataSourceFloatField fourNum7Field;
	private final DataSourceFloatField oneNum8Field;
	private final DataSourceFloatField twoNum8Field;
	private final DataSourceFloatField threeNum8Field;
	private final DataSourceFloatField fourNum8Field;
	private final DataSourceFloatField oneNum9Field;
	private final DataSourceFloatField twoNum9Field;
	private final DataSourceFloatField threeNum9Field;
	private final DataSourceFloatField fourNum9Field;
	private final DataSourceFloatField oneNum10Field;
	private final DataSourceFloatField twoNum10Field;
	private final DataSourceFloatField threeNum10Field;
	private final DataSourceFloatField fourNum10Field;
	private final DataSourceFloatField oneNum11Field;
	private final DataSourceFloatField twoNum11Field;
	private final DataSourceFloatField threeNum11Field;
	private final DataSourceFloatField fourNum11Field;
	private final DataSourceFloatField oneNum12Field;
	private final DataSourceFloatField twoNum12Field;
	private final DataSourceFloatField threeNum12Field;
	private final DataSourceFloatField fourNum12Field;

	public DSReportOnEmployeeTurnoverTotalByDepartment(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ReportOnEmployeeTurnoverTotalByDepartment");


		departmentIdField = new DataSourceIntegerField("departmentId", "所属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(true);
		yearField.setHidden(false);



		oneNum1Field = new DataSourceFloatField("oneNum1", "新入职");
		oneNum1Field.setLength(18);
		oneNum1Field.setDecimalPad(0);
		oneNum1Field.setFormat("#,###,###,###,###,##0");
		oneNum1Field.setRequired(true);
		oneNum1Field.setHidden(false);


		twoNum1Field = new DataSourceFloatField("twoNum1", "离职");
		twoNum1Field.setLength(18);
		twoNum1Field.setDecimalPad(0);
		twoNum1Field.setFormat("#,###,###,###,###,##0");
		twoNum1Field.setRequired(true);
		twoNum1Field.setHidden(false);


		threeNum1Field = new DataSourceFloatField("threeNum1", "调出");
		threeNum1Field.setLength(18);
		threeNum1Field.setDecimalPad(0);
		threeNum1Field.setFormat("#,###,###,###,###,##0");
		threeNum1Field.setRequired(true);
		threeNum1Field.setHidden(false);


		fourNum1Field = new DataSourceFloatField("fourNum1", "调入");
		fourNum1Field.setLength(18);
		fourNum1Field.setDecimalPad(0);
		fourNum1Field.setFormat("#,###,###,###,###,##0");
		fourNum1Field.setRequired(true);
		fourNum1Field.setHidden(false);


		oneNum2Field = new DataSourceFloatField("oneNum2", "新入职");
		oneNum2Field.setLength(18);
		oneNum2Field.setDecimalPad(0);
		oneNum2Field.setFormat("#,###,###,###,###,##0");
		oneNum2Field.setRequired(true);
		oneNum2Field.setHidden(false);


		twoNum2Field = new DataSourceFloatField("twoNum2", "离职");
		twoNum2Field.setLength(18);
		twoNum2Field.setDecimalPad(0);
		twoNum2Field.setFormat("#,###,###,###,###,##0");
		twoNum2Field.setRequired(true);
		twoNum2Field.setHidden(false);


		threeNum2Field = new DataSourceFloatField("threeNum2", "调出");
		threeNum2Field.setLength(18);
		threeNum2Field.setDecimalPad(0);
		threeNum2Field.setFormat("#,###,###,###,###,##0");
		threeNum2Field.setRequired(true);
		threeNum2Field.setHidden(false);


		fourNum2Field = new DataSourceFloatField("fourNum2", "调入");
		fourNum2Field.setLength(18);
		fourNum2Field.setDecimalPad(0);
		fourNum2Field.setFormat("#,###,###,###,###,##0");
		fourNum2Field.setRequired(true);
		fourNum2Field.setHidden(false);


		oneNum3Field = new DataSourceFloatField("oneNum3", "新入职");
		oneNum3Field.setLength(18);
		oneNum3Field.setDecimalPad(0);
		oneNum3Field.setFormat("#,###,###,###,###,##0");
		oneNum3Field.setRequired(true);
		oneNum3Field.setHidden(false);


		twoNum3Field = new DataSourceFloatField("twoNum3", "离职");
		twoNum3Field.setLength(18);
		twoNum3Field.setDecimalPad(0);
		twoNum3Field.setFormat("#,###,###,###,###,##0");
		twoNum3Field.setRequired(true);
		twoNum3Field.setHidden(false);


		threeNum3Field = new DataSourceFloatField("threeNum3", "调出");
		threeNum3Field.setLength(18);
		threeNum3Field.setDecimalPad(0);
		threeNum3Field.setFormat("#,###,###,###,###,##0");
		threeNum3Field.setRequired(true);
		threeNum3Field.setHidden(false);


		fourNum3Field = new DataSourceFloatField("fourNum3", "调入");
		fourNum3Field.setLength(18);
		fourNum3Field.setDecimalPad(0);
		fourNum3Field.setFormat("#,###,###,###,###,##0");
		fourNum3Field.setRequired(true);
		fourNum3Field.setHidden(false);


		oneNum4Field = new DataSourceFloatField("oneNum4", "新入职");
		oneNum4Field.setLength(18);
		oneNum4Field.setDecimalPad(0);
		oneNum4Field.setFormat("#,###,###,###,###,##0");
		oneNum4Field.setRequired(true);
		oneNum4Field.setHidden(false);


		twoNum4Field = new DataSourceFloatField("twoNum4", "离职");
		twoNum4Field.setLength(18);
		twoNum4Field.setDecimalPad(0);
		twoNum4Field.setFormat("#,###,###,###,###,##0");
		twoNum4Field.setRequired(true);
		twoNum4Field.setHidden(true);


		threeNum4Field = new DataSourceFloatField("threeNum4", "调出");
		threeNum4Field.setLength(18);
		threeNum4Field.setDecimalPad(0);
		threeNum4Field.setFormat("#,###,###,###,###,##0");
		threeNum4Field.setRequired(true);
		threeNum4Field.setHidden(true);


		fourNum4Field = new DataSourceFloatField("fourNum4", "调入");
		fourNum4Field.setLength(18);
		fourNum4Field.setDecimalPad(0);
		fourNum4Field.setFormat("#,###,###,###,###,##0");
		fourNum4Field.setRequired(true);
		fourNum4Field.setHidden(true);


		oneNum5Field = new DataSourceFloatField("oneNum5", "新入职");
		oneNum5Field.setLength(18);
		oneNum5Field.setDecimalPad(0);
		oneNum5Field.setFormat("#,###,###,###,###,##0");
		oneNum5Field.setRequired(true);
		oneNum5Field.setHidden(true);


		twoNum5Field = new DataSourceFloatField("twoNum5", "离职");
		twoNum5Field.setLength(18);
		twoNum5Field.setDecimalPad(0);
		twoNum5Field.setFormat("#,###,###,###,###,##0");
		twoNum5Field.setRequired(true);
		twoNum5Field.setHidden(true);


		threeNum5Field = new DataSourceFloatField("threeNum5", "调出");
		threeNum5Field.setLength(18);
		threeNum5Field.setDecimalPad(0);
		threeNum5Field.setFormat("#,###,###,###,###,##0");
		threeNum5Field.setRequired(true);
		threeNum5Field.setHidden(true);


		fourNum5Field = new DataSourceFloatField("fourNum5", "调入");
		fourNum5Field.setLength(18);
		fourNum5Field.setDecimalPad(0);
		fourNum5Field.setFormat("#,###,###,###,###,##0");
		fourNum5Field.setRequired(true);
		fourNum5Field.setHidden(true);


		oneNum6Field = new DataSourceFloatField("oneNum6", "新入职");
		oneNum6Field.setLength(18);
		oneNum6Field.setDecimalPad(0);
		oneNum6Field.setFormat("#,###,###,###,###,##0");
		oneNum6Field.setRequired(true);
		oneNum6Field.setHidden(true);


		twoNum6Field = new DataSourceFloatField("twoNum6", "离职");
		twoNum6Field.setLength(18);
		twoNum6Field.setDecimalPad(0);
		twoNum6Field.setFormat("#,###,###,###,###,##0");
		twoNum6Field.setRequired(true);
		twoNum6Field.setHidden(true);


		threeNum6Field = new DataSourceFloatField("threeNum6", "调出");
		threeNum6Field.setLength(18);
		threeNum6Field.setDecimalPad(0);
		threeNum6Field.setFormat("#,###,###,###,###,##0");
		threeNum6Field.setRequired(true);
		threeNum6Field.setHidden(true);


		fourNum6Field = new DataSourceFloatField("fourNum6", "调入");
		fourNum6Field.setLength(18);
		fourNum6Field.setDecimalPad(0);
		fourNum6Field.setFormat("#,###,###,###,###,##0");
		fourNum6Field.setRequired(true);
		fourNum6Field.setHidden(true);


		oneNum7Field = new DataSourceFloatField("oneNum7", "新入职");
		oneNum7Field.setLength(18);
		oneNum7Field.setDecimalPad(0);
		oneNum7Field.setFormat("#,###,###,###,###,##0");
		oneNum7Field.setRequired(true);
		oneNum7Field.setHidden(true);


		twoNum7Field = new DataSourceFloatField("twoNum7", "离职");
		twoNum7Field.setLength(18);
		twoNum7Field.setDecimalPad(0);
		twoNum7Field.setFormat("#,###,###,###,###,##0");
		twoNum7Field.setRequired(true);
		twoNum7Field.setHidden(true);


		threeNum7Field = new DataSourceFloatField("threeNum7", "调出");
		threeNum7Field.setLength(18);
		threeNum7Field.setDecimalPad(0);
		threeNum7Field.setFormat("#,###,###,###,###,##0");
		threeNum7Field.setRequired(true);
		threeNum7Field.setHidden(true);


		fourNum7Field = new DataSourceFloatField("fourNum7", "调入");
		fourNum7Field.setLength(18);
		fourNum7Field.setDecimalPad(0);
		fourNum7Field.setFormat("#,###,###,###,###,##0");
		fourNum7Field.setRequired(true);
		fourNum7Field.setHidden(true);


		oneNum8Field = new DataSourceFloatField("oneNum8", "新入职");
		oneNum8Field.setLength(18);
		oneNum8Field.setDecimalPad(0);
		oneNum8Field.setFormat("#,###,###,###,###,##0");
		oneNum8Field.setRequired(true);
		oneNum8Field.setHidden(true);


		twoNum8Field = new DataSourceFloatField("twoNum8", "离职");
		twoNum8Field.setLength(18);
		twoNum8Field.setDecimalPad(0);
		twoNum8Field.setFormat("#,###,###,###,###,##0");
		twoNum8Field.setRequired(true);
		twoNum8Field.setHidden(true);


		threeNum8Field = new DataSourceFloatField("threeNum8", "调出");
		threeNum8Field.setLength(18);
		threeNum8Field.setDecimalPad(0);
		threeNum8Field.setFormat("#,###,###,###,###,##0");
		threeNum8Field.setRequired(true);
		threeNum8Field.setHidden(true);


		fourNum8Field = new DataSourceFloatField("fourNum8", "调入");
		fourNum8Field.setLength(18);
		fourNum8Field.setDecimalPad(0);
		fourNum8Field.setFormat("#,###,###,###,###,##0");
		fourNum8Field.setRequired(true);
		fourNum8Field.setHidden(true);


		oneNum9Field = new DataSourceFloatField("oneNum9", "新入职");
		oneNum9Field.setLength(18);
		oneNum9Field.setDecimalPad(0);
		oneNum9Field.setFormat("#,###,###,###,###,##0");
		oneNum9Field.setRequired(true);
		oneNum9Field.setHidden(true);


		twoNum9Field = new DataSourceFloatField("twoNum9", "离职");
		twoNum9Field.setLength(18);
		twoNum9Field.setDecimalPad(0);
		twoNum9Field.setFormat("#,###,###,###,###,##0");
		twoNum9Field.setRequired(true);
		twoNum9Field.setHidden(true);


		threeNum9Field = new DataSourceFloatField("threeNum9", "调出");
		threeNum9Field.setLength(18);
		threeNum9Field.setDecimalPad(0);
		threeNum9Field.setFormat("#,###,###,###,###,##0");
		threeNum9Field.setRequired(true);
		threeNum9Field.setHidden(true);


		fourNum9Field = new DataSourceFloatField("fourNum9", "调入");
		fourNum9Field.setLength(18);
		fourNum9Field.setDecimalPad(0);
		fourNum9Field.setFormat("#,###,###,###,###,##0");
		fourNum9Field.setRequired(true);
		fourNum9Field.setHidden(true);


		oneNum10Field = new DataSourceFloatField("oneNum10", "oneNum10");
		oneNum10Field.setLength(18);
		oneNum10Field.setDecimalPad(0);
		oneNum10Field.setFormat("#,###,###,###,###,##0");
		oneNum10Field.setRequired(true);
		oneNum10Field.setHidden(true);


		twoNum10Field = new DataSourceFloatField("twoNum10", "离职");
		twoNum10Field.setLength(18);
		twoNum10Field.setDecimalPad(0);
		twoNum10Field.setFormat("#,###,###,###,###,##0");
		twoNum10Field.setRequired(true);
		twoNum10Field.setHidden(true);


		threeNum10Field = new DataSourceFloatField("threeNum10", "调出");
		threeNum10Field.setLength(18);
		threeNum10Field.setDecimalPad(0);
		threeNum10Field.setFormat("#,###,###,###,###,##0");
		threeNum10Field.setRequired(true);
		threeNum10Field.setHidden(true);


		fourNum10Field = new DataSourceFloatField("fourNum10", "调入");
		fourNum10Field.setLength(18);
		fourNum10Field.setDecimalPad(0);
		fourNum10Field.setFormat("#,###,###,###,###,##0");
		fourNum10Field.setRequired(true);
		fourNum10Field.setHidden(true);


		oneNum11Field = new DataSourceFloatField("oneNum11", "新入职");
		oneNum11Field.setLength(18);
		oneNum11Field.setDecimalPad(0);
		oneNum11Field.setFormat("#,###,###,###,###,##0");
		oneNum11Field.setRequired(true);
		oneNum11Field.setHidden(true);


		twoNum11Field = new DataSourceFloatField("twoNum11", "离职");
		twoNum11Field.setLength(18);
		twoNum11Field.setDecimalPad(0);
		twoNum11Field.setFormat("#,###,###,###,###,##0");
		twoNum11Field.setRequired(true);
		twoNum11Field.setHidden(true);


		threeNum11Field = new DataSourceFloatField("threeNum11", "调出");
		threeNum11Field.setLength(18);
		threeNum11Field.setDecimalPad(0);
		threeNum11Field.setFormat("#,###,###,###,###,##0");
		threeNum11Field.setRequired(true);
		threeNum11Field.setHidden(true);


		fourNum11Field = new DataSourceFloatField("fourNum11", "调入");
		fourNum11Field.setLength(18);
		fourNum11Field.setDecimalPad(0);
		fourNum11Field.setFormat("#,###,###,###,###,##0");
		fourNum11Field.setRequired(true);
		fourNum11Field.setHidden(true);


		oneNum12Field = new DataSourceFloatField("oneNum12", "新入职");
		oneNum12Field.setLength(18);
		oneNum12Field.setDecimalPad(0);
		oneNum12Field.setFormat("#,###,###,###,###,##0");
		oneNum12Field.setRequired(true);
		oneNum12Field.setHidden(true);


		twoNum12Field = new DataSourceFloatField("twoNum12", "离职");
		twoNum12Field.setLength(18);
		twoNum12Field.setDecimalPad(0);
		twoNum12Field.setFormat("#,###,###,###,###,##0");
		twoNum12Field.setRequired(true);
		twoNum12Field.setHidden(true);


		threeNum12Field = new DataSourceFloatField("threeNum12", "调出");
		threeNum12Field.setLength(18);
		threeNum12Field.setDecimalPad(0);
		threeNum12Field.setFormat("#,###,###,###,###,##0");
		threeNum12Field.setRequired(true);
		threeNum12Field.setHidden(true);


		fourNum12Field = new DataSourceFloatField("fourNum12", "调入");
		fourNum12Field.setLength(18);
		fourNum12Field.setDecimalPad(0);
		fourNum12Field.setFormat("#,###,###,###,###,##0");
		fourNum12Field.setRequired(true);
		fourNum12Field.setHidden(true);

		setFields(departmentIdField, yearField, oneNum1Field, twoNum1Field, threeNum1Field, fourNum1Field, oneNum2Field, twoNum2Field, threeNum2Field, fourNum2Field, oneNum3Field, twoNum3Field, threeNum3Field, fourNum3Field, oneNum4Field, twoNum4Field, threeNum4Field, fourNum4Field, oneNum5Field, twoNum5Field, threeNum5Field, fourNum5Field, oneNum6Field, twoNum6Field, threeNum6Field, fourNum6Field, oneNum7Field, twoNum7Field, threeNum7Field, fourNum7Field, oneNum8Field, twoNum8Field, threeNum8Field, fourNum8Field, oneNum9Field, twoNum9Field, threeNum9Field, fourNum9Field, oneNum10Field, twoNum10Field, threeNum10Field, fourNum10Field, oneNum11Field, twoNum11Field, threeNum11Field, fourNum11Field, oneNum12Field, twoNum12Field, threeNum12Field, fourNum12Field);
	}


}

