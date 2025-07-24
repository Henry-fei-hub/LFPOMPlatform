package com.pomplatform.client.plateIntegralAccount.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSCompanyFeeMonthlyDetail extends DBDataSource
{


	public static DSCompanyFeeMonthlyDetail instance = null;

	public static DSCompanyFeeMonthlyDetail getInstance() {
		if(instance == null) {
			instance = new DSCompanyFeeMonthlyDetail("DSCompanyFeeMonthlyDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIntegralAchieveIdField;
	private final DataSourceIntegerField fromPlateIdField;
	private final DataSourceIntegerField toPlateIdField;
	private final DataSourceFloatField sendIntegralField;
	private final DataSourceDateField sendDateField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField remarkField;

	public DSCompanyFeeMonthlyDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("CompanyFeeMonthlyDetail");


		plateIntegralAchieveIdField = new DataSourceIntegerField("plateIntegralAchieveId", "主键");
		plateIntegralAchieveIdField.setLength(11);
		plateIntegralAchieveIdField.setPrimaryKey(true);
		plateIntegralAchieveIdField.setRequired(true);
		plateIntegralAchieveIdField.setHidden(true);


		fromPlateIdField = new DataSourceIntegerField("fromPlateId", "积分提取部门");
		fromPlateIdField.setLength(11);
		fromPlateIdField.setRequired(false);
		fromPlateIdField.setHidden(false);
		fromPlateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));


		toPlateIdField = new DataSourceIntegerField("toPlateId", "积分发放部门");
		toPlateIdField.setLength(11);
		toPlateIdField.setRequired(false);
		toPlateIdField.setHidden(true);
		toPlateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));


		sendIntegralField = new DataSourceFloatField("sendIntegral", "公司费用");
		sendIntegralField.setLength(18);
		sendIntegralField.setDecimalPad(2);
		sendIntegralField.setFormat("#,###,###,###,###,##0.00");
		sendIntegralField.setRequired(false);
		sendIntegralField.setHidden(false);


		sendDateField = new DataSourceDateField("sendDate", "提取日期");
		sendDateField.setRequired(false);
		sendDateField.setHidden(false);


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


		setFields(plateIntegralAchieveIdField, fromPlateIdField, toPlateIdField, sendIntegralField, sendDateField, operateEmployeeIdField, operateTimeField, remarkField);
	}


}

