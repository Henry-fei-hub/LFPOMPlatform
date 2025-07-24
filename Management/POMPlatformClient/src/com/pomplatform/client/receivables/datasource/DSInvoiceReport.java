package com.pomplatform.client.receivables.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;

public class DSInvoiceReport extends DBDataSource
{


	public static DSInvoiceReport instance = null;

	public static DSInvoiceReport getInstance() {
		if(instance == null) {
			instance = new DSInvoiceReport("DSInvoiceReport");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField projectManagerIdField;
	private final DataSourceFloatField oneField;
	private final DataSourceFloatField twoField;
	private final DataSourceFloatField treeField;
	private final DataSourceFloatField fourField;
	private final DataSourceFloatField fiveField;
	private final DataSourceFloatField sixField;
	private final DataSourceFloatField totalField;

	public DSInvoiceReport(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("InvoiceReport");

		
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));

		projectManagerIdField = new DataSourceIntegerField("projectManagerId", "项目经理");
		projectManagerIdField.setLength(11);
		projectManagerIdField.setRequired(false);
		projectManagerIdField.setHidden(false);
//		KeyValueManager.loadValueMap("employees" , projectManagerIdField);
		projectManagerIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		oneField = new DataSourceFloatField("one", "30天内发票金额");
		oneField.setLength(28);
		oneField.setDecimalPad(2);
		oneField.setFormat("#,###,###,###,###,##0.00");
		oneField.setRequired(true);
		oneField.setHidden(false);


		twoField = new DataSourceFloatField("two", "30-60天发票金额");
		twoField.setLength(28);
		twoField.setDecimalPad(2);
		twoField.setFormat("#,###,###,###,###,##0.00");
		twoField.setRequired(true);
		twoField.setHidden(false);


		treeField = new DataSourceFloatField("tree", "60-90天发票金额");
		treeField.setLength(28);
		treeField.setDecimalPad(2);
		treeField.setFormat("#,###,###,###,###,##0.00");
		treeField.setRequired(true);
		treeField.setHidden(false);


		fourField = new DataSourceFloatField("four", "90-180天发票金额");
		fourField.setLength(28);
		fourField.setDecimalPad(2);
		fourField.setFormat("#,###,###,###,###,##0.00");
		fourField.setRequired(true);
		fourField.setHidden(false);


		fiveField = new DataSourceFloatField("five", "180-365天发票金额");
		fiveField.setLength(28);
		fiveField.setDecimalPad(2);
		fiveField.setFormat("#,###,###,###,###,##0.00");
		fiveField.setRequired(true);
		fiveField.setHidden(false);


		sixField = new DataSourceFloatField("six", "365天以上发票金额");
		sixField.setLength(28);
		sixField.setDecimalPad(2);
		sixField.setFormat("#,###,###,###,###,##0.00");
		sixField.setRequired(true);
		sixField.setHidden(false);


		totalField = new DataSourceFloatField("total", "发票金额总计");
		totalField.setLength(28);
		totalField.setDecimalPad(2);
		totalField.setFormat("#,###,###,###,###,##0.00");
		totalField.setRequired(true);
		totalField.setHidden(false);

		setFields(plateIdField,projectManagerIdField, oneField, twoField, treeField, fourField, fiveField, sixField, totalField);
	}


}

