package com.pomplatform.client.aboutinputtaxrecordinfo.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSAboutInputTaxRecordInfo extends DBDataSource
{


	public static DSAboutInputTaxRecordInfo instance = null;

	public static DSAboutInputTaxRecordInfo getInstance() {
		if(instance == null) {
			instance = new DSAboutInputTaxRecordInfo("DSAboutInputTaxRecordInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField inputTaxRecordIdField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceTextField processTypeNameField;
	private final DataSourceTextField codeField;
	private final DataSourceFloatField inputTaxField;
	private final DataSourceTextField invoiceEndNumberField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceDateTimeField overTimeField;

	public DSAboutInputTaxRecordInfo(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("AboutInputTaxRecordInfo");


		inputTaxRecordIdField = new DataSourceIntegerField("inputTaxRecordId", "主键编码");
		inputTaxRecordIdField.setLength(11);
		inputTaxRecordIdField.setPrimaryKey(true);
		inputTaxRecordIdField.setRequired(true);
		inputTaxRecordIdField.setHidden(true);


		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);


		processTypeNameField = new DataSourceTextField("processTypeName", "流程类型");
		processTypeNameField.setLength(64);
		processTypeNameField.setRequired(false);
		processTypeNameField.setHidden(false);


		codeField = new DataSourceTextField("code", "报销编号");
		codeField.setLength(64);
		codeField.setRequired(false);
		codeField.setHidden(false);


		inputTaxField = new DataSourceFloatField("inputTax", "进项税金额");
		inputTaxField.setLength(10);
		inputTaxField.setDecimalPad(2);
		inputTaxField.setFormat("##,###,##0.00");
		inputTaxField.setRequired(false);
		inputTaxField.setHidden(false);


		invoiceEndNumberField = new DataSourceTextField("invoiceEndNumber", "发票号码后四位");
		invoiceEndNumberField.setLength(0);
		invoiceEndNumberField.setRequired(false);
		invoiceEndNumberField.setHidden(false);


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);


		overTimeField = new DataSourceDateTimeField("overTime", "流程结束时间");
		overTimeField.setRequired(false);
		overTimeField.setHidden(false);


		setFields(inputTaxRecordIdField, businessIdField, processTypeField, processTypeNameField, codeField, inputTaxField, invoiceEndNumberField, operateTimeField, overTimeField);
	}


}

