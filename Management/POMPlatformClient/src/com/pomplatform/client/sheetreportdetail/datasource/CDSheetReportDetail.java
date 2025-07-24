package com.pomplatform.client.sheetreportdetail.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSheetReportDetail extends DataSource
{


	public static CDSheetReportDetail instance = null;

	public static CDSheetReportDetail getInstance() {
		if(instance == null) {
			instance = new CDSheetReportDetail("CDSheetReportDetail");
		}
		return instance;
	}

	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceIntegerField businessTypeField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField subContractCodeField;
	private final DataSourceTextField subContractNameField;

	public CDSheetReportDetail(String dataSourceID) {

		setID(dataSourceID);
		startDateField = new DataSourceDateField("startDate", "价格审核同意的时间");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateField("endDate", "价格审核同意的时间");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

		businessTypeField = new DataSourceIntegerField("businessType", "业务类型");
		businessTypeField.setRequired(false);
		businessTypeField.setLength(11);
		businessTypeField.setHidden(false);

		projectTypeField = new DataSourceIntegerField("projectType", "项目类型");
		projectTypeField.setRequired(false);
		projectTypeField.setLength(11);
		projectTypeField.setHidden(false);
//		projectTypeField.setValueMap(KeyValueManager.getValueMap("project_types"));
		KeyValueManager.loadValueMap("project_types", projectTypeField);

		departmentIdField = new DataSourceIntegerField("departmentId", "承接部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		subContractCodeField = new DataSourceTextField("subContractCode", "子合同编号");
		subContractCodeField.setRequired(false);
		subContractCodeField.setLength(64);
		subContractCodeField.setHidden(false);

		subContractNameField = new DataSourceTextField("subContractName", "子合同名称  充当了区域");
		subContractNameField.setRequired(false);
		subContractNameField.setLength(64);
		subContractNameField.setHidden(false);

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


		setFields(startDateField, endDateField, businessTypeField, projectTypeField, departmentIdField, subContractCodeField, subContractNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

