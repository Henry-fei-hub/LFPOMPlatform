package com.pomplatform.client.rmimburseementinvoice.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSMreimbursementinvoiceinformationrsrmmpror extends DBDataSource {

	public static DSMreimbursementinvoiceinformationrsrmmpror instance = null;

	public static DSMreimbursementinvoiceinformationrsrmmpror getInstance() {
		if (instance == null) {
			instance = new DSMreimbursementinvoiceinformationrsrmmpror("DSMreimbursementinvoiceinformationrsrmmpror");
		}
		return instance;
	}

	private final DataSourceTextField packageCodeField;
	private final DataSourceTextField rmiCodeField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceIntegerField aircraftQuantityField;
	private final DataSourceFloatField aircraftTotalAmountField;
	private final DataSourceFloatField aircraftTaxAmountField;
	private final DataSourceIntegerField railQuantityField;
	private final DataSourceFloatField railTotalAmountField;
	private final DataSourceFloatField railTaxAmountField;
	private final DataSourceIntegerField ptQuantityField;
	private final DataSourceFloatField ptTotalAmountField;
	private final DataSourceFloatField ptTaxAmountField;
	private final DataSourceIntegerField normalQuantityField;
	private final DataSourceFloatField normalTotalAmountField;
	private final DataSourceFloatField normalTaxAmountField;
	private final DataSourceIntegerField giQuantityField;
	private final DataSourceFloatField giTotalAmountField;
	private final DataSourceFloatField giTaxAmountField;

	public DSMreimbursementinvoiceinformationrsrmmpror(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mreimbursementinvoiceinformationrsrmmpror");

		packageCodeField = new DataSourceTextField("packageCode", "汇总单号");
		packageCodeField.setLength(255);
		packageCodeField.setRequired(true);
		packageCodeField.setHidden(false);

		rmiCodeField = new DataSourceTextField("rmiCode", "报销单号");
		rmiCodeField.setLength(64);
		rmiCodeField.setRequired(true);
		rmiCodeField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));

		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);

		businessIdField = new DataSourceIntegerField("businessId", "流程业务主键");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);

		aircraftQuantityField = new DataSourceIntegerField("aircraftQuantity", "机票数量");
		aircraftQuantityField.setLength(8);
		aircraftQuantityField.setRequired(true);
		aircraftQuantityField.setHidden(false);

		aircraftTotalAmountField = new DataSourceFloatField("aircraftTotalAmount", "机票金额");
		aircraftTotalAmountField.setLength(18);
		aircraftTotalAmountField.setDecimalPad(2);
		aircraftTotalAmountField.setFormat("#,###,###,###,###,##0.00");
		aircraftTotalAmountField.setRequired(true);
		aircraftTotalAmountField.setHidden(false);

		aircraftTaxAmountField = new DataSourceFloatField("aircraftTaxAmount", "机票税额");
		aircraftTaxAmountField.setLength(18);
		aircraftTaxAmountField.setDecimalPad(2);
		aircraftTaxAmountField.setFormat("#,###,###,###,###,##0.00");
		aircraftTaxAmountField.setRequired(true);
		aircraftTaxAmountField.setHidden(false);

		railQuantityField = new DataSourceIntegerField("railQuantity", "高铁数量");
		railQuantityField.setLength(8);
		railQuantityField.setRequired(true);
		railQuantityField.setHidden(false);

		railTotalAmountField = new DataSourceFloatField("railTotalAmount", "高铁金额");
		railTotalAmountField.setLength(18);
		railTotalAmountField.setDecimalPad(2);
		railTotalAmountField.setFormat("#,###,###,###,###,##0.00");
		railTotalAmountField.setRequired(true);
		railTotalAmountField.setHidden(false);

		railTaxAmountField = new DataSourceFloatField("railTaxAmount", "高铁税额");
		railTaxAmountField.setLength(18);
		railTaxAmountField.setDecimalPad(2);
		railTaxAmountField.setFormat("#,###,###,###,###,##0.00");
		railTaxAmountField.setRequired(true);
		railTaxAmountField.setHidden(false);

		ptQuantityField = new DataSourceIntegerField("ptQuantity", "客运水运数量");
		ptQuantityField.setLength(8);
		ptQuantityField.setRequired(true);
		ptQuantityField.setHidden(false);

		ptTotalAmountField = new DataSourceFloatField("ptTotalAmount", "客运水运金额");
		ptTotalAmountField.setLength(18);
		ptTotalAmountField.setDecimalPad(2);
		ptTotalAmountField.setFormat("#,###,###,###,###,##0.00");
		ptTotalAmountField.setRequired(true);
		ptTotalAmountField.setHidden(false);

		ptTaxAmountField = new DataSourceFloatField("ptTaxAmount", "客运水运税额");
		ptTaxAmountField.setLength(18);
		ptTaxAmountField.setDecimalPad(2);
		ptTaxAmountField.setFormat("#,###,###,###,###,##0.00");
		ptTaxAmountField.setRequired(true);
		ptTaxAmountField.setHidden(false);

		normalQuantityField = new DataSourceIntegerField("normalQuantity", "普通电子发票数量");
		normalQuantityField.setLength(8);
		normalQuantityField.setRequired(true);
		normalQuantityField.setHidden(false);

		normalTotalAmountField = new DataSourceFloatField("normalTotalAmount", "普通电子发票金额");
		normalTotalAmountField.setLength(18);
		normalTotalAmountField.setDecimalPad(2);
		normalTotalAmountField.setFormat("#,###,###,###,###,##0.00");
		normalTotalAmountField.setRequired(true);
		normalTotalAmountField.setHidden(false);

		normalTaxAmountField = new DataSourceFloatField("normalTaxAmount", "普通电子发票税额");
		normalTaxAmountField.setLength(18);
		normalTaxAmountField.setDecimalPad(2);
		normalTaxAmountField.setFormat("#,###,###,###,###,##0.00");
		normalTaxAmountField.setRequired(true);
		normalTaxAmountField.setHidden(false);

		giQuantityField = new DataSourceIntegerField("giQuantity", "绿联数量");
		giQuantityField.setLength(8);
		giQuantityField.setRequired(true);
		giQuantityField.setHidden(false);

		giTotalAmountField = new DataSourceFloatField("giTotalAmount", "绿联金额");
		giTotalAmountField.setLength(18);
		giTotalAmountField.setDecimalPad(2);
		giTotalAmountField.setFormat("#,###,###,###,###,##0.00");
		giTotalAmountField.setRequired(true);
		giTotalAmountField.setHidden(true);

		giTaxAmountField = new DataSourceFloatField("giTaxAmount", "绿联税额");
		giTaxAmountField.setLength(18);
		giTaxAmountField.setDecimalPad(2);
		giTaxAmountField.setFormat("#,###,###,###,###,##0.00");
		giTaxAmountField.setRequired(true);
		giTaxAmountField.setHidden(false);

		setFields(packageCodeField, rmiCodeField, companyIdField, processTypeField, businessIdField,
				aircraftQuantityField, aircraftTotalAmountField, aircraftTaxAmountField, railQuantityField,
				railTotalAmountField, railTaxAmountField, ptQuantityField, ptTotalAmountField, ptTaxAmountField,
				normalQuantityField, normalTotalAmountField, normalTaxAmountField, giQuantityField, giTotalAmountField,
				giTaxAmountField);
	}

}
