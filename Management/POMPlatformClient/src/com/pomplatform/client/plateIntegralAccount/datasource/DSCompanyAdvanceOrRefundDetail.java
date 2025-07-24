package com.pomplatform.client.plateIntegralAccount.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSCompanyAdvanceOrRefundDetail extends DBDataSource
{


	public static DSCompanyAdvanceOrRefundDetail instance = null;

	public static DSCompanyAdvanceOrRefundDetail getInstance() {
		if(instance == null) {
			instance = new DSCompanyAdvanceOrRefundDetail("DSCompanyAdvanceOrRefundDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField companyIntegralRecordIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceFloatField integralField;
	private final DataSourceDateField recordDateField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField remarkField;

	public DSCompanyAdvanceOrRefundDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("OnAboutCompanyIntegral");


		companyIntegralRecordIdField = new DataSourceIntegerField("companyIntegralRecordId", "主键");
		companyIntegralRecordIdField.setLength(11);
		companyIntegralRecordIdField.setPrimaryKey(true);
		companyIntegralRecordIdField.setRequired(true);
		companyIntegralRecordIdField.setHidden(true);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));


		integralField = new DataSourceFloatField("integral", "积分");
		integralField.setLength(18);
		integralField.setDecimalPad(2);
		integralField.setFormat("#,###,###,###,###,##0.00");
		integralField.setRequired(false);
		integralField.setHidden(false);


		recordDateField = new DataSourceDateField("recordDate", "日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(false);
		operateEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(companyIntegralRecordIdField, plateIdField, integralField, recordDateField, operateEmployeeIdField, operateTimeField, remarkField);
	}


}

