package com.pomplatform.client.project.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSprojectpricechangedrecordcppor extends DataSource
{


	public static CDSprojectpricechangedrecordcppor instance = null;

	public static CDSprojectpricechangedrecordcppor getInstance() {
		if(instance == null) {
			instance = new CDSprojectpricechangedrecordcppor("CDSprojectpricechangedrecordcppor");
		}
		return instance;
	}

	private final DataSourceTextField contractCodeField;
	private final DataSourceIntegerField projectPriceChangedRecordIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField yearField;
	private final DataSourceTextField monthField;
	private final DataSourceDateField recordDateField;
	private final DataSourceDateTimeField recordTimeField;
	private final DataSourceIntegerField subsidiesTypeField;
	private final DataSourceIntegerField operateEmployeeIdField;

	public CDSprojectpricechangedrecordcppor(String dataSourceID) {

		setID(dataSourceID);
		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		projectPriceChangedRecordIdField = new DataSourceIntegerField("projectPriceChangedRecordId", "编码");
		projectPriceChangedRecordIdField.setRequired(true);
		projectPriceChangedRecordIdField.setLength(11);
		projectPriceChangedRecordIdField.setPrimaryKey(true);
		projectPriceChangedRecordIdField.setHidden(true);

		projectIdField = new DataSourceIntegerField("projectId", "项目id");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "板块id");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门id");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

		yearField = new DataSourceTextField("year", "年份");
		yearField.setRequired(false);
		yearField.setLength(64);
		yearField.setHidden(false);

		monthField = new DataSourceTextField("month", "月份");
		monthField.setRequired(false);
		monthField.setLength(64);
		monthField.setHidden(false);

		recordDateField = new DataSourceDateField("recordDate", "操作日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);

		recordTimeField = new DataSourceDateTimeField("recordTime", "操作时间");
		recordTimeField.setRequired(false);
		recordTimeField.setHidden(false);

		subsidiesTypeField = new DataSourceIntegerField("subsidiesType", "补贴类型");
		subsidiesTypeField.setRequired(false);
		subsidiesTypeField.setLength(11);
		subsidiesTypeField.setHidden(false);

		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setHidden(false);

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(contractCodeField, projectPriceChangedRecordIdField, projectIdField, plateIdField, departmentIdField, yearField, monthField, recordDateField, recordTimeField, subsidiesTypeField, operateEmployeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

