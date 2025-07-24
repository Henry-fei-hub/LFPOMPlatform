package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSReportOnEmployeeBenefitTotal extends DBDataSource
{


	public static DSReportOnEmployeeBenefitTotal instance = null;

	public static DSReportOnEmployeeBenefitTotal getInstance() {
		if(instance == null) {
			instance = new DSReportOnEmployeeBenefitTotal("DSReportOnEmployeeBenefitTotal");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField oneNum1Field;
	private final DataSourceIntegerField twoNum1Field;
	private final DataSourceIntegerField totalNum1Field;
	private final DataSourceIntegerField oneNum2Field;
	private final DataSourceIntegerField twoNum2Field;
	private final DataSourceIntegerField totalNum2Field;
	private final DataSourceIntegerField oneNum3Field;
	private final DataSourceIntegerField twoNum3Field;
	private final DataSourceIntegerField totalNum3Field;
	private final DataSourceIntegerField oneNum4Field;
	private final DataSourceIntegerField twoNum4Field;
	private final DataSourceIntegerField totalNum4Field;
	private final DataSourceIntegerField oneNum5Field;
	private final DataSourceIntegerField twoNum5Field;
	private final DataSourceIntegerField totalNum5Field;
	private final DataSourceIntegerField oneNum6Field;
	private final DataSourceIntegerField twoNum6Field;
	private final DataSourceIntegerField totalNum6Field;
	private final DataSourceIntegerField oneNum7Field;
	private final DataSourceIntegerField twoNum7Field;
	private final DataSourceIntegerField totalNum7Field;
	private final DataSourceIntegerField oneNum8Field;
	private final DataSourceIntegerField twoNum8Field;
	private final DataSourceIntegerField totalNum8Field;
	private final DataSourceIntegerField oneNum9Field;
	private final DataSourceIntegerField twoNum9Field;
	private final DataSourceIntegerField totalNum9Field;
	private final DataSourceIntegerField oneNum10Field;
	private final DataSourceIntegerField twoNum10Field;
	private final DataSourceIntegerField totalNum10Field;
	private final DataSourceIntegerField oneNum11Field;
	private final DataSourceIntegerField twoNum11Field;
	private final DataSourceIntegerField totalNum11Field;
	private final DataSourceIntegerField oneNum12Field;
	private final DataSourceIntegerField twoNum12Field;
	private final DataSourceIntegerField totalNum12Field;

	public DSReportOnEmployeeBenefitTotal(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ReportOnEmployeeBenefitTotal");


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));


		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(true);
		yearField.setHidden(false);


		oneNum1Field = new DataSourceIntegerField("oneNum1", "效益指数1以下");
		oneNum1Field.setLength(8);
		oneNum1Field.setRequired(true);
		oneNum1Field.setHidden(false);


		twoNum1Field = new DataSourceIntegerField("twoNum1", "效益指数1及1以上");
		twoNum1Field.setLength(8);
		twoNum1Field.setRequired(true);
		twoNum1Field.setHidden(false);


		totalNum1Field = new DataSourceIntegerField("totalNum1", "合计");
		totalNum1Field.setLength(8);
		totalNum1Field.setRequired(true);
		totalNum1Field.setHidden(false);


		oneNum2Field = new DataSourceIntegerField("oneNum2", "效益指数1以下");
		oneNum2Field.setLength(8);
		oneNum2Field.setRequired(true);
		oneNum2Field.setHidden(false);


		twoNum2Field = new DataSourceIntegerField("twoNum2", "效益指数1及1以上");
		twoNum2Field.setLength(8);
		twoNum2Field.setRequired(true);
		twoNum2Field.setHidden(false);


		totalNum2Field = new DataSourceIntegerField("totalNum2", "合计");
		totalNum2Field.setLength(8);
		totalNum2Field.setRequired(true);
		totalNum2Field.setHidden(false);


		oneNum3Field = new DataSourceIntegerField("oneNum3", "效益指数1以下");
		oneNum3Field.setLength(8);
		oneNum3Field.setRequired(true);
		oneNum3Field.setHidden(false);


		twoNum3Field = new DataSourceIntegerField("twoNum3", "效益指数1及1以上");
		twoNum3Field.setLength(8);
		twoNum3Field.setRequired(true);
		twoNum3Field.setHidden(false);


		totalNum3Field = new DataSourceIntegerField("totalNum3", "合计");
		totalNum3Field.setLength(8);
		totalNum3Field.setRequired(true);
		totalNum3Field.setHidden(false);


		oneNum4Field = new DataSourceIntegerField("oneNum4", "效益指数1以下");
		oneNum4Field.setLength(8);
		oneNum4Field.setRequired(true);
		oneNum4Field.setHidden(false);


		twoNum4Field = new DataSourceIntegerField("twoNum4", "效益指数1及1以上");
		twoNum4Field.setLength(8);
		twoNum4Field.setRequired(true);
		twoNum4Field.setHidden(false);


		totalNum4Field = new DataSourceIntegerField("totalNum4", "合计");
		totalNum4Field.setLength(8);
		totalNum4Field.setRequired(true);
		totalNum4Field.setHidden(false);


		oneNum5Field = new DataSourceIntegerField("oneNum5", "效益指数1以下");
		oneNum5Field.setLength(8);
		oneNum5Field.setRequired(true);
		oneNum5Field.setHidden(false);


		twoNum5Field = new DataSourceIntegerField("twoNum5", "效益指数1及1以上");
		twoNum5Field.setLength(8);
		twoNum5Field.setRequired(true);
		twoNum5Field.setHidden(false);


		totalNum5Field = new DataSourceIntegerField("totalNum5", "合计");
		totalNum5Field.setLength(8);
		totalNum5Field.setRequired(true);
		totalNum5Field.setHidden(false);


		oneNum6Field = new DataSourceIntegerField("oneNum6", "效益指数1以下");
		oneNum6Field.setLength(8);
		oneNum6Field.setRequired(true);
		oneNum6Field.setHidden(false);


		twoNum6Field = new DataSourceIntegerField("twoNum6", "效益指数1及1以上");
		twoNum6Field.setLength(8);
		twoNum6Field.setRequired(true);
		twoNum6Field.setHidden(false);


		totalNum6Field = new DataSourceIntegerField("totalNum6", "合计");
		totalNum6Field.setLength(8);
		totalNum6Field.setRequired(true);
		totalNum6Field.setHidden(false);


		oneNum7Field = new DataSourceIntegerField("oneNum7", "效益指数1以下");
		oneNum7Field.setLength(8);
		oneNum7Field.setRequired(true);
		oneNum7Field.setHidden(false);


		twoNum7Field = new DataSourceIntegerField("twoNum7", "效益指数1及1以上");
		twoNum7Field.setLength(8);
		twoNum7Field.setRequired(true);
		twoNum7Field.setHidden(false);


		totalNum7Field = new DataSourceIntegerField("totalNum7", "合计");
		totalNum7Field.setLength(8);
		totalNum7Field.setRequired(true);
		totalNum7Field.setHidden(false);


		oneNum8Field = new DataSourceIntegerField("oneNum8", "效益指数1以下");
		oneNum8Field.setLength(8);
		oneNum8Field.setRequired(true);
		oneNum8Field.setHidden(false);


		twoNum8Field = new DataSourceIntegerField("twoNum8", "效益指数1及1以上");
		twoNum8Field.setLength(8);
		twoNum8Field.setRequired(true);
		twoNum8Field.setHidden(false);


		totalNum8Field = new DataSourceIntegerField("totalNum8", "合计");
		totalNum8Field.setLength(8);
		totalNum8Field.setRequired(true);
		totalNum8Field.setHidden(false);


		oneNum9Field = new DataSourceIntegerField("oneNum9", "效益指数1以下");
		oneNum9Field.setLength(8);
		oneNum9Field.setRequired(true);
		oneNum9Field.setHidden(false);


		twoNum9Field = new DataSourceIntegerField("twoNum9", "效益指数1及1以上");
		twoNum9Field.setLength(8);
		twoNum9Field.setRequired(true);
		twoNum9Field.setHidden(false);


		totalNum9Field = new DataSourceIntegerField("totalNum9", "合计");
		totalNum9Field.setLength(8);
		totalNum9Field.setRequired(true);
		totalNum9Field.setHidden(false);


		oneNum10Field = new DataSourceIntegerField("oneNum10", "效益指数1以下");
		oneNum10Field.setLength(8);
		oneNum10Field.setRequired(true);
		oneNum10Field.setHidden(false);


		twoNum10Field = new DataSourceIntegerField("twoNum10", "效益指数1及1以上");
		twoNum10Field.setLength(8);
		twoNum10Field.setRequired(true);
		twoNum10Field.setHidden(false);


		totalNum10Field = new DataSourceIntegerField("totalNum10", "合计");
		totalNum10Field.setLength(8);
		totalNum10Field.setRequired(true);
		totalNum10Field.setHidden(false);


		oneNum11Field = new DataSourceIntegerField("oneNum11", "效益指数1以下");
		oneNum11Field.setLength(8);
		oneNum11Field.setRequired(true);
		oneNum11Field.setHidden(false);


		twoNum11Field = new DataSourceIntegerField("twoNum11", "效益指数1及1以上");
		twoNum11Field.setLength(8);
		twoNum11Field.setRequired(true);
		twoNum11Field.setHidden(false);


		totalNum11Field = new DataSourceIntegerField("totalNum11", "合计");
		totalNum11Field.setLength(8);
		totalNum11Field.setRequired(true);
		totalNum11Field.setHidden(false);


		oneNum12Field = new DataSourceIntegerField("oneNum12", "效益指数1以下");
		oneNum12Field.setLength(8);
		oneNum12Field.setRequired(true);
		oneNum12Field.setHidden(false);


		twoNum12Field = new DataSourceIntegerField("twoNum12", "效益指数1及1以上");
		twoNum12Field.setLength(8);
		twoNum12Field.setRequired(true);
		twoNum12Field.setHidden(false);


		totalNum12Field = new DataSourceIntegerField("totalNum12", "合计");
		totalNum12Field.setLength(8);
		totalNum12Field.setRequired(true);
		totalNum12Field.setHidden(false);


		setFields(plateIdField, yearField, oneNum1Field, twoNum1Field, totalNum1Field, oneNum2Field, twoNum2Field, totalNum2Field, oneNum3Field, twoNum3Field, totalNum3Field, oneNum4Field, twoNum4Field, totalNum4Field, oneNum5Field, twoNum5Field, totalNum5Field, oneNum6Field, twoNum6Field, totalNum6Field, oneNum7Field, twoNum7Field, totalNum7Field, oneNum8Field, twoNum8Field, totalNum8Field, oneNum9Field, twoNum9Field, totalNum9Field, oneNum10Field, twoNum10Field, totalNum10Field, oneNum11Field, twoNum11Field, totalNum11Field, oneNum12Field, twoNum12Field, totalNum12Field);
	}


}

