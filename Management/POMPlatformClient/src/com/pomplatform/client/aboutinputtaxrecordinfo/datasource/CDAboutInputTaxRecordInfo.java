package com.pomplatform.client.aboutinputtaxrecordinfo.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDAboutInputTaxRecordInfo extends DataSource
{


	public static CDAboutInputTaxRecordInfo instance = null;

	public static CDAboutInputTaxRecordInfo getInstance() {
		if(instance == null) {
			instance = new CDAboutInputTaxRecordInfo("CDAboutInputTaxRecordInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField processTypeField;
	private final DataSourceTextField codeField;
	private final DataSourceTextField invoiceEndNumberField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceDateTimeField overTimeField;

	public CDAboutInputTaxRecordInfo(String dataSourceID) {

		setID(dataSourceID);
		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		codeField = new DataSourceTextField("code", "报销编号");
		codeField.setRequired(false);
		codeField.setLength(64);
		codeField.setHidden(false);

		invoiceEndNumberField = new DataSourceTextField("invoiceEndNumber", "发票号码后四位");
		invoiceEndNumberField.setRequired(false);
		invoiceEndNumberField.setLength(64);
		invoiceEndNumberField.setHidden(false);

		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);

		overTimeField = new DataSourceDateTimeField("overTime", "流程结束时间");
		overTimeField.setRequired(false);
		overTimeField.setHidden(false);

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(processTypeField, codeField, invoiceEndNumberField, operateTimeField, overTimeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

