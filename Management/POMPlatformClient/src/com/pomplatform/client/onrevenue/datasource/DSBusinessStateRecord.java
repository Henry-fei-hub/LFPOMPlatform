package com.pomplatform.client.onrevenue.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSBusinessStateRecord extends DBDataSource
{


	public static DSBusinessStateRecord instance = null;

	public static DSBusinessStateRecord getInstance() {
		if(instance == null) {
			instance = new DSBusinessStateRecord("DSBusinessStateRecord");
		}
		return instance;
	}

	private final DataSourceIntegerField businessStateRecordIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField businessCodeField;
	private final DataSourceTextField businessNameField;
	private final DataSourceFloatField beforeContractTotalField;
	private final DataSourceFloatField businessIntegralField;
	private final DataSourceIntegerField accountWeightRecordIdField;
	private final DataSourceIntegerField signingCompanyField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField contractCodeField;

	public DSBusinessStateRecord(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("BusinessStateRecord");


		businessStateRecordIdField = new DataSourceIntegerField("businessStateRecordId", "主键编码");
		businessStateRecordIdField.setLength(11);
		businessStateRecordIdField.setPrimaryKey(true);
		businessStateRecordIdField.setRequired(true);
		businessStateRecordIdField.setHidden(true);


		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);


		businessCodeField = new DataSourceTextField("businessCode", "业态编号");
		businessCodeField.setLength(64);
		businessCodeField.setRequired(true);
		businessCodeField.setHidden(false);
		
		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(true);
		contractCodeField.setHidden(true);


		businessNameField = new DataSourceTextField("businessName", "业态名称");
		businessNameField.setLength(512);
		businessNameField.setRequired(false);
		businessNameField.setHidden(false);


		beforeContractTotalField = new DataSourceFloatField("beforeContractTotal", "修改前合同总价");
		beforeContractTotalField.setLength(18);
		beforeContractTotalField.setDecimalPad(5);
		beforeContractTotalField.setFormat("#,###,###,###,##0.00000");
		beforeContractTotalField.setRequired(false);
		beforeContractTotalField.setHidden(true);


		businessIntegralField = new DataSourceFloatField("businessIntegral", "总金额");
		businessIntegralField.setLength(18);
		businessIntegralField.setDecimalPad(5);
		businessIntegralField.setFormat("#,###,###,###,##0.00000");
		businessIntegralField.setRequired(false);
		businessIntegralField.setHidden(false);


		accountWeightRecordIdField = new DataSourceIntegerField("accountWeightRecordId", "业态类型");
		accountWeightRecordIdField.setLength(11);
		accountWeightRecordIdField.setRequired(false);
		accountWeightRecordIdField.setHidden(true);


		signingCompanyField = new DataSourceIntegerField("signingCompany", "签约公司");
		signingCompanyField.setLength(11);
		signingCompanyField.setRequired(false);
		signingCompanyField.setHidden(false);
		signingCompanyField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(true);


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(true);


		setFields(businessStateRecordIdField, contractIdField, businessCodeField, businessNameField, beforeContractTotalField, businessIntegralField, accountWeightRecordIdField, signingCompanyField, operateEmployeeIdField, operateTimeField);
	}


}

