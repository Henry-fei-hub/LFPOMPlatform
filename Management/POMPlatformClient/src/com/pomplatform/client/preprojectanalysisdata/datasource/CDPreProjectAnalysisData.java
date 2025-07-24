package com.pomplatform.client.preprojectanalysisdata.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDPreProjectAnalysisData extends DataSource
{


	public static CDPreProjectAnalysisData instance = null;

	public static CDPreProjectAnalysisData getInstance() {
		if(instance == null) {
			instance = new CDPreProjectAnalysisData("CDPreProjectAnalysisData");
		}
		return instance;
	}

	private final DataSourceTextField businessTypeField;
	private final DataSourceIntegerField statusField;

	public CDPreProjectAnalysisData(String dataSourceID) {

		setID(dataSourceID);
		businessTypeField = new DataSourceTextField("businessType", "业务类别");
		businessTypeField.setRequired(true);
		businessTypeField.setLength(0);
		businessTypeField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "立项/关闭的流程状态(1立项进行中，2已立项，5立项失败，4关闭进行中，5已关闭，6关闭失败)");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

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


		setFields(businessTypeField, statusField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

