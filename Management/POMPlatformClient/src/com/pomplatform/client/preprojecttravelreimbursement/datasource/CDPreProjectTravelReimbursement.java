package com.pomplatform.client.preprojecttravelreimbursement.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDPreProjectTravelReimbursement extends DataSource
{


	public static CDPreProjectTravelReimbursement instance = null;

	public static CDPreProjectTravelReimbursement getInstance() {
		if(instance == null) {
			instance = new CDPreProjectTravelReimbursement("CDPreProjectTravelReimbursement");
		}
		return instance;
	}

	private final DataSourceDateField minStartDateField;
	private final DataSourceDateField maxStartDateField;
	private final DataSourceDateField minEndDateField;
	private final DataSourceDateField maxEndDateField;
	private final DataSourceTextField codeField;
	private final DataSourceTextField titleField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceBooleanField isProjectField;
	private final DataSourceIntegerField deleteFlagField;

	public CDPreProjectTravelReimbursement(String dataSourceID) {

		setID(dataSourceID);
		minStartDateField = new DataSourceDateField("minStartDate", "最早出差开始日期");
		minStartDateField.setRequired(false);
		minStartDateField.setHidden(false);

		maxStartDateField = new DataSourceDateField("maxStartDate", "最晚出差开始日期");
		maxStartDateField.setRequired(false);
		maxStartDateField.setHidden(false);

		minEndDateField = new DataSourceDateField("minEndDate", "最早出差结束日期");
		minEndDateField.setRequired(false);
		minEndDateField.setHidden(false);

		maxEndDateField = new DataSourceDateField("maxEndDate", "最晚出差结束日期");
		maxEndDateField.setRequired(false);
		maxEndDateField.setHidden(false);

		codeField = new DataSourceTextField("code", "报销编号");
		codeField.setRequired(false);
		codeField.setLength(64);
		codeField.setHidden(false);

		titleField = new DataSourceTextField("title", "主题");
		titleField.setRequired(false);
		titleField.setLength(256);
		titleField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "报销事由");
		remarkField.setRequired(false);
		remarkField.setLength(255);
		remarkField.setHidden(false);

		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程编码");
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setLength(11);
		processInstanceIdField.setHidden(false);
		processInstanceIdField.setValueMap(new java.util.HashMap());

		isProjectField = new DataSourceBooleanField("isProject", "是否是项目上的报销");
		isProjectField.setRequired(false);
		isProjectField.setHidden(false);

		deleteFlagField = new DataSourceIntegerField("deleteFlag", "删除状态");
		deleteFlagField.setRequired(false);
		deleteFlagField.setLength(11);
		deleteFlagField.setHidden(false);
		deleteFlagField.setValueMap(new java.util.HashMap());

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


		setFields(minStartDateField, maxStartDateField, minEndDateField, maxEndDateField, codeField, titleField, remarkField, processInstanceIdField, isProjectField, deleteFlagField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

