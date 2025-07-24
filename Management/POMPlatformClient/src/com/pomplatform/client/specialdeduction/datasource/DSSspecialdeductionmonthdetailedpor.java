package com.pomplatform.client.specialdeduction.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSspecialdeductionmonthdetailedpor extends DBDataSource
{


	public static DSSspecialdeductionmonthdetailedpor instance = null;

	public static DSSspecialdeductionmonthdetailedpor getInstance() {
		if(instance == null) {
			instance = new DSSspecialdeductionmonthdetailedpor("DSSspecialdeductionmonthdetailedpor");
		}
		return instance;
	}

	private final DataSourceIntegerField specialDeductionMonthDetailIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceTextField yearField;
	private final DataSourceTextField monthField;
	private final DataSourceFloatField amountField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceTextField specialDeductionTypeIdsField;
	private final DataSourceTextField specialDeductionDetailIdsField;
	private final DataSourceFloatField specialDuduct1Field;
	private final DataSourceFloatField specialDuduct2Field;
	private final DataSourceFloatField specialDuduct3Field;
	private final DataSourceFloatField specialDuduct4Field;
	private final DataSourceFloatField specialDuduct5Field;
	private final DataSourceFloatField specialDuduct6Field;

	public DSSspecialdeductionmonthdetailedpor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sspecialdeductionmonthdetailedpor");


		specialDeductionMonthDetailIdField = new DataSourceIntegerField("specialDeductionMonthDetailId", "主键");
		specialDeductionMonthDetailIdField.setLength(11);
		specialDeductionMonthDetailIdField.setRequired(true);
		specialDeductionMonthDetailIdField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "职员");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "职员编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));

		yearField = new DataSourceTextField("year", "年度");
		yearField.setLength(64);
		yearField.setRequired(false);
		yearField.setHidden(false);


		monthField = new DataSourceTextField("month", "月份");
		monthField.setLength(64);
		monthField.setRequired(false);
		monthField.setHidden(false);


		amountField = new DataSourceFloatField("amount", "专项扣除总金额");
		amountField.setLength(10);
		amountField.setDecimalPad(2);
		amountField.setFormat("##,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		specialDeductionTypeIdsField = new DataSourceTextField("specialDeductionTypeIds", "专项扣除类型ids");
		specialDeductionTypeIdsField.setLength(64);
		specialDeductionTypeIdsField.setRequired(false);
		specialDeductionTypeIdsField.setHidden(true);


		specialDeductionDetailIdsField = new DataSourceTextField("specialDeductionDetailIds", "专项扣除详情ids");
		specialDeductionDetailIdsField.setLength(64);
		specialDeductionDetailIdsField.setRequired(false);
		specialDeductionDetailIdsField.setHidden(true);
		
		specialDuduct1Field = new DataSourceFloatField("specialDuduct1", "子女教育");
		specialDuduct1Field.setLength(18);
		specialDuduct1Field.setDecimalPad(2);
		specialDuduct1Field.setFormat("#,###,###,###,###,##0.00");
		specialDuduct1Field.setRequired(false);
		specialDuduct1Field.setHidden(false);


		specialDuduct2Field = new DataSourceFloatField("specialDuduct2", "继续教育");
		specialDuduct2Field.setLength(18);
		specialDuduct2Field.setDecimalPad(2);
		specialDuduct2Field.setFormat("#,###,###,###,###,##0.00");
		specialDuduct2Field.setRequired(false);
		specialDuduct2Field.setHidden(false);


		specialDuduct3Field = new DataSourceFloatField("specialDuduct3", "住房贷款利息");
		specialDuduct3Field.setLength(18);
		specialDuduct3Field.setDecimalPad(2);
		specialDuduct3Field.setFormat("#,###,###,###,###,##0.00");
		specialDuduct3Field.setRequired(false);
		specialDuduct3Field.setHidden(false);


		specialDuduct4Field = new DataSourceFloatField("specialDuduct4", "住房租金");
		specialDuduct4Field.setLength(18);
		specialDuduct4Field.setDecimalPad(2);
		specialDuduct4Field.setFormat("#,###,###,###,###,##0.00");
		specialDuduct4Field.setRequired(false);
		specialDuduct4Field.setHidden(false);


		specialDuduct5Field = new DataSourceFloatField("specialDuduct5", "赡养老人");
		specialDuduct5Field.setLength(18);
		specialDuduct5Field.setDecimalPad(2);
		specialDuduct5Field.setFormat("#,###,###,###,###,##0.00");
		specialDuduct5Field.setRequired(false);
		specialDuduct5Field.setHidden(false);


		specialDuduct6Field = new DataSourceFloatField("specialDuduct6", "大病医疗");
		specialDuduct6Field.setLength(18);
		specialDuduct6Field.setDecimalPad(2);
		specialDuduct6Field.setFormat("#,###,###,###,###,##0.00");
		specialDuduct6Field.setRequired(false);
		specialDuduct6Field.setHidden(false);



		setFields(specialDeductionMonthDetailIdField, employeeIdField, employeeNoField, departmentIdField, plateIdField, yearField, monthField, specialDuduct1Field, specialDuduct2Field, specialDuduct3Field, specialDuduct4Field, specialDuduct5Field, specialDuduct6Field, amountField, createTimeField, specialDeductionTypeIdsField, specialDeductionDetailIdsField);
	}


}

