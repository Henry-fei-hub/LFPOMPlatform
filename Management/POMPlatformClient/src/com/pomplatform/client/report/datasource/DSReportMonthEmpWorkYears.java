package com.pomplatform.client.report.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSReportMonthEmpWorkYears extends DBDataSource
{


	public static DSReportMonthEmpWorkYears instance = null;

	public static DSReportMonthEmpWorkYears getInstance() {
		if(instance == null) {
			instance = new DSReportMonthEmpWorkYears("DSReportMonthEmpWorkYears");
		}
		return instance;
	}

	private final DataSourceTextField plateIdField;
	private final DataSourceIntegerField oneInnerField;
	private final DataSourceTextField oneInnerPercentField;
	private final DataSourceIntegerField threeInnerField;
	private final DataSourceTextField threeInnerPercentField;
	private final DataSourceIntegerField fiveInnerField;
	private final DataSourceTextField fiveInnerPercentField;
	private final DataSourceIntegerField tenInnerField;
	private final DataSourceTextField tenInnerPercentField;
	private final DataSourceIntegerField tenAddField;
	private final DataSourceTextField tenAddPercentField;
	private final DataSourceIntegerField totalField;

	public DSReportMonthEmpWorkYears(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ReportYearEmpWorkYears");


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		oneInnerField = new DataSourceIntegerField("oneInner", "1年以下人数");
		oneInnerField.setLength(11);
		oneInnerField.setRequired(true);
		oneInnerField.setHidden(false);


		oneInnerPercentField = new DataSourceTextField("oneInnerPercent", "1年以下占比");
		oneInnerPercentField.setLength(-1);
		oneInnerPercentField.setRequired(true);
		oneInnerPercentField.setHidden(false);


		threeInnerField = new DataSourceIntegerField("threeInner", "1~3年人数");
		threeInnerField.setLength(11);
		threeInnerField.setRequired(true);
		threeInnerField.setHidden(false);


		threeInnerPercentField = new DataSourceTextField("threeInnerPercent", "1~3年占比");
		threeInnerPercentField.setLength(-1);
		threeInnerPercentField.setRequired(true);
		threeInnerPercentField.setHidden(false);


		fiveInnerField = new DataSourceIntegerField("fiveInner", "3~5年人数");
		fiveInnerField.setLength(11);
		fiveInnerField.setRequired(true);
		fiveInnerField.setHidden(false);


		fiveInnerPercentField = new DataSourceTextField("fiveInnerPercent", "3~5年占比");
		fiveInnerPercentField.setLength(-1);
		fiveInnerPercentField.setRequired(true);
		fiveInnerPercentField.setHidden(false);


		tenInnerField = new DataSourceIntegerField("tenInner", "5~10年人数");
		tenInnerField.setLength(11);
		tenInnerField.setRequired(true);
		tenInnerField.setHidden(false);


		tenInnerPercentField = new DataSourceTextField("tenInnerPercent", "5~10年占比");
		tenInnerPercentField.setLength(-1);
		tenInnerPercentField.setRequired(true);
		tenInnerPercentField.setHidden(false);


		tenAddField = new DataSourceIntegerField("tenAdd", "10年及以上人数");
		tenAddField.setLength(11);
		tenAddField.setRequired(true);
		tenAddField.setHidden(false);


		tenAddPercentField = new DataSourceTextField("tenAddPercent", "10年及以上占比");
		tenAddPercentField.setLength(-1);
		tenAddPercentField.setRequired(true);
		tenAddPercentField.setHidden(false);


		totalField = new DataSourceIntegerField("total", "人数合计");
		totalField.setLength(11);
		totalField.setRequired(true);
		totalField.setHidden(false);


		setFields(plateIdField, oneInnerField, oneInnerPercentField, threeInnerField, threeInnerPercentField, fiveInnerField, fiveInnerPercentField, tenInnerField, tenInnerPercentField, tenAddField, tenAddPercentField, totalField);
	}


}

