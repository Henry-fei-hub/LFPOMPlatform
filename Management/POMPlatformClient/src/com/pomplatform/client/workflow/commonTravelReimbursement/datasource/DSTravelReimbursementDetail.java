package com.pomplatform.client.workflow.commonTravelReimbursement.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSTravelReimbursementDetail extends DBDataSource
{


	public static DSTravelReimbursementDetail instance = null;

	public static DSTravelReimbursementDetail getInstance() {
		if(instance == null) {
			instance = new DSTravelReimbursementDetail("DSTravelReimbursementDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField travelReimbursementDetailIdField;
	private final DataSourceIntegerField travelReimbursementIdField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceTextField startAddressField;
	private final DataSourceTextField arrivingAddressField;
	private final DataSourceIntegerField travelDaysField;
	private final DataSourceFloatField airfareField;
	private final DataSourceFloatField carBoatFeeField;
	private final DataSourceFloatField cityTransportationField;
	private final DataSourceFloatField shippingFeeField;
	private final DataSourceFloatField accommodationFeeField;
	private final DataSourceFloatField drivingFeeField;
	private final DataSourceFloatField travelAllowanceField;
	private final DataSourceFloatField sumField;
	private final DataSourceTextField remarkField;

	public DSTravelReimbursementDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("TravelReimbursementDetail");


		travelReimbursementDetailIdField = new DataSourceIntegerField("travelReimbursementDetailId", "差旅报销明细编码");
		travelReimbursementDetailIdField.setLength(11);
		travelReimbursementDetailIdField.setPrimaryKey(true);
		travelReimbursementDetailIdField.setRequired(true);
		travelReimbursementDetailIdField.setHidden(true);


		travelReimbursementIdField = new DataSourceIntegerField("travelReimbursementId", "差旅主表编码");
		travelReimbursementIdField.setLength(11);
		travelReimbursementIdField.setRequired(false);
		travelReimbursementIdField.setHidden(true);


		startDateField = new DataSourceDateField("startDate", "开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);


		endDateField = new DataSourceDateField("endDate", "结束日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);


		startAddressField = new DataSourceTextField("startAddress", "出发地");
		startAddressField.setLength(255);
		startAddressField.setRequired(false);
		startAddressField.setHidden(false);


		arrivingAddressField = new DataSourceTextField("arrivingAddress", "目的地");
		arrivingAddressField.setLength(255);
		arrivingAddressField.setRequired(false);
		arrivingAddressField.setHidden(false);


		travelDaysField = new DataSourceIntegerField("travelDays", "天数");
		travelDaysField.setLength(11);
		travelDaysField.setRequired(false);
		travelDaysField.setHidden(false);


		airfareField = new DataSourceFloatField("airfare", "机票");
		airfareField.setLength(18);
		airfareField.setDecimalPad(5);
		airfareField.setFormat("#,###,###,###,##0.00");
		airfareField.setRequired(false);
		airfareField.setHidden(false);


		carBoatFeeField = new DataSourceFloatField("carBoatFee", "车船费");
		carBoatFeeField.setLength(18);
		carBoatFeeField.setDecimalPad(5);
		carBoatFeeField.setFormat("#,###,###,###,##0.00");
		carBoatFeeField.setRequired(false);
		carBoatFeeField.setHidden(false);


		cityTransportationField = new DataSourceFloatField("cityTransportation", "市内交通费");
		cityTransportationField.setLength(18);
		cityTransportationField.setDecimalPad(5);
		cityTransportationField.setFormat("#,###,###,###,##0.00");
		cityTransportationField.setRequired(false);
		cityTransportationField.setHidden(false);


		shippingFeeField = new DataSourceFloatField("shippingFee", "托运费");
		shippingFeeField.setLength(18);
		shippingFeeField.setDecimalPad(5);
		shippingFeeField.setFormat("#,###,###,###,##0.00");
		shippingFeeField.setRequired(false);
		shippingFeeField.setHidden(false);


		accommodationFeeField = new DataSourceFloatField("accommodationFee", "住宿费");
		accommodationFeeField.setLength(18);
		accommodationFeeField.setDecimalPad(5);
		accommodationFeeField.setFormat("#,###,###,###,##0.00");
		accommodationFeeField.setRequired(false);
		accommodationFeeField.setHidden(false);


		drivingFeeField = new DataSourceFloatField("drivingFee", "自驾车费");
		drivingFeeField.setLength(18);
		drivingFeeField.setDecimalPad(5);
		drivingFeeField.setFormat("#,###,###,###,##0.00");
		drivingFeeField.setRequired(false);
		drivingFeeField.setHidden(false);


		travelAllowanceField = new DataSourceFloatField("travelAllowance", "出差补助");
		travelAllowanceField.setLength(18);
		travelAllowanceField.setDecimalPad(5);
		travelAllowanceField.setFormat("#,###,###,###,##0.00");
		travelAllowanceField.setRequired(false);
		travelAllowanceField.setHidden(false);


		sumField = new DataSourceFloatField("sum", "小计");
		sumField.setLength(18);
		sumField.setDecimalPad(5);
		sumField.setFormat("#,###,###,###,##0.00");
		sumField.setRequired(false);
		sumField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "摘要");
		remarkField.setLength(255);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(travelReimbursementDetailIdField, travelReimbursementIdField, startDateField, endDateField, startAddressField, arrivingAddressField, travelDaysField, airfareField, carBoatFeeField, cityTransportationField, shippingFeeField, accommodationFeeField, drivingFeeField, travelAllowanceField, sumField, remarkField);
	}


}

