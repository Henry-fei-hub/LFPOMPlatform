package com.pomplatform.client.sprojectsettlementdetaileachmonth.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSProjectSettlementDetailEachMonth extends DBDataSource
{


	public static DSSProjectSettlementDetailEachMonth instance = null;

	public static DSSProjectSettlementDetailEachMonth getInstance() {
		if(instance == null) {
			instance = new DSSProjectSettlementDetailEachMonth("DSSProjectSettlementDetailEachMonth");
		}
		return instance;
	}

	private final DataSourceTextField employeeIdField;
	private final DataSourceIntegerField settlementYearField;
	private final DataSourceIntegerField settlementMonthField;
	private final DataSourceFloatField realAmountField;

	public DSSProjectSettlementDetailEachMonth(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SProjectSettlementDetailEachMonth");


		employeeIdField = new DataSourceTextField("employeeId", "姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		settlementYearField = new DataSourceIntegerField("settlementYear", "年份");
		settlementYearField.setLength(11);
		settlementYearField.setRequired(true);
		settlementYearField.setHidden(false);


		settlementMonthField = new DataSourceIntegerField("settlementMonth", "月份");
		settlementMonthField.setLength(11);
		settlementMonthField.setRequired(true);
		settlementMonthField.setHidden(false);


		realAmountField = new DataSourceFloatField("realAmount", "确认积分");
		realAmountField.setLength(18);
		realAmountField.setDecimalPad(2);
		realAmountField.setFormat("#,###,###,###,###,##0.00");
		realAmountField.setRequired(false);
		realAmountField.setHidden(false);


		setFields(employeeIdField, settlementYearField, settlementMonthField, realAmountField);
	}


}

