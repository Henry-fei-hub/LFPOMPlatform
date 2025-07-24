package com.pomplatform.client.revenue.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSaleIntegralRecord extends DBDataSource
{


	public static DSSaleIntegralRecord instance = null;

	public static DSSaleIntegralRecord getInstance() {
		if(instance == null) {
			instance = new DSSaleIntegralRecord("DSSaleIntegralRecord");
		}
		return instance;
	}

	private final DataSourceTextField businessNameField;
	private final DataSourceFloatField currentRevenueField;
	private final DataSourceFloatField percentField;
	private final DataSourceFloatField saleIntegralField;

	public DSSaleIntegralRecord(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("IntegralReturnOfPlate");


		businessNameField = new DataSourceTextField("businessName", "类型名称");
		businessNameField.setLength(11);
		businessNameField.setPrimaryKey(true);
		businessNameField.setRequired(true);
		businessNameField.setCanEdit(false);

		currentRevenueField = new DataSourceFloatField("currentRevenue", "营收金额");
		currentRevenueField.setLength(18);
		currentRevenueField.setDecimalPad(2);
		currentRevenueField.setFormat("#,###,###,###,###,##0.00");
		currentRevenueField.setRequired(true);
		currentRevenueField.setHidden(false);
		currentRevenueField.setCanEdit(false);
		
		percentField = new DataSourceFloatField("percent", "营收提点");
		percentField.setLength(18);
		percentField.setDecimalPad(4);
		percentField.setFormat("#,###,###,###,###,##0.0000");
		percentField.setRequired(true);
		percentField.setHidden(false);

		saleIntegralField = new DataSourceFloatField("saleIntegral", "销售积分");
		saleIntegralField.setLength(18);
		saleIntegralField.setDecimalPad(2);
		saleIntegralField.setFormat("#,###,###,###,###,##0.00");
		saleIntegralField.setRequired(true);
		saleIntegralField.setHidden(false);
		saleIntegralField.setCanEdit(false);

		setFields(businessNameField, currentRevenueField, percentField, saleIntegralField);
	}


}

