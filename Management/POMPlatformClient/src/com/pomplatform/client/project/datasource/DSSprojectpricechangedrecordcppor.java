package com.pomplatform.client.project.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSprojectpricechangedrecordcppor extends DBDataSource
{


	public static DSSprojectpricechangedrecordcppor instance = null;

	public static DSSprojectpricechangedrecordcppor getInstance() {
		if(instance == null) {
			instance = new DSSprojectpricechangedrecordcppor("DSSprojectpricechangedrecordcppor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectPriceChangedRecordIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField yearField;
	private final DataSourceTextField monthField;
	private final DataSourceDateField recordDateField;
	private final DataSourceDateTimeField recordTimeField;
	private final DataSourceFloatField moneyField;
	private final DataSourceIntegerField subsidiesTypeField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceTextField remarkField;

	public DSSprojectpricechangedrecordcppor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sprojectpricechangedrecordcppor");


		projectPriceChangedRecordIdField = new DataSourceIntegerField("projectPriceChangedRecordId", "编码");
		projectPriceChangedRecordIdField.setLength(11);
		projectPriceChangedRecordIdField.setPrimaryKey(true);
		projectPriceChangedRecordIdField.setRequired(true);
		projectPriceChangedRecordIdField.setHidden(true);


		projectIdField = new DataSourceIntegerField("projectId", "项目id");
		projectIdField.setLength(11);
		projectIdField.setRequired(false); 
		projectIdField.setHidden(true);
		projectIdField.setForeignKey("DSSprojectpricechangedrecordcppor.projectId");

		contractCodeField = new DataSourceTextField("contractCode", "订单编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));


		departmentIdField = new DataSourceIntegerField("departmentId", "部门id");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(true);


		yearField = new DataSourceTextField("year", "年份");
		yearField.setLength(64);
		yearField.setRequired(false);
		yearField.setHidden(true);


		monthField = new DataSourceTextField("month", "月份");
		monthField.setLength(64);
		monthField.setRequired(false);
		monthField.setHidden(true);

		recordDateField = new DataSourceDateField("recordDate", "补贴日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);

		recordTimeField = new DataSourceDateTimeField("recordTime", "操作时间");
		recordTimeField.setRequired(false);
		recordTimeField.setHidden(false);

		moneyField = new DataSourceFloatField("money", "补贴金额");
		moneyField.setLength(32);
		moneyField.setDecimalPad(2);
		moneyField.setFormat("###,###,###,###,###,###,###,###,###,##0.00");
		moneyField.setRequired(false);
		moneyField.setHidden(false);

		subsidiesTypeField = new DataSourceIntegerField("subsidiesType", "补贴类型");
		subsidiesTypeField.setLength(11);
		subsidiesTypeField.setRequired(false);
		subsidiesTypeField.setHidden(false);
		subsidiesTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_208"));

		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(false);
		operateEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(64);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(projectPriceChangedRecordIdField, projectIdField, contractCodeField, plateIdField, departmentIdField, yearField, monthField,subsidiesTypeField, moneyField, recordDateField,  operateEmployeeIdField, recordTimeField, remarkField);
	}


}

