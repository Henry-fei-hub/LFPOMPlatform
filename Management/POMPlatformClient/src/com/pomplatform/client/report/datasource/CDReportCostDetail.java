package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDReportCostDetail extends DataSource
{


	public static CDReportCostDetail instance = null;

	public static CDReportCostDetail getInstance() {
		if(instance == null) {
			instance = new CDReportCostDetail("CDReportCostDetail");
		}
		return instance;
	}

	private final DataSourceDateTimeField startCreateTimeField;
	private final DataSourceDateTimeField endCreateTimeField;
	private final DataSourceDateTimeField startCompleteTimeField;
	private final DataSourceDateTimeField endCompleteTimeField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField feeTypeField;
	private final DataSourceTextField bearFeeCodeField;
	private final DataSourceTextField bearFeeNameField;
	private final DataSourceTextField codeField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField processStatusField;

	public CDReportCostDetail(String dataSourceID) {

		setID(dataSourceID);
		startCreateTimeField = new DataSourceDateTimeField("startCreateTime", "申请开始日期");
		startCreateTimeField.setRequired(false);
		startCreateTimeField.setHidden(false);

		endCreateTimeField = new DataSourceDateTimeField("endCreateTime", "申请结束日期");
		endCreateTimeField.setRequired(false);
		endCreateTimeField.setHidden(false);

		startCompleteTimeField = new DataSourceDateTimeField("startCompleteTime", "完成开始日期");
		startCompleteTimeField.setRequired(false);
		startCompleteTimeField.setHidden(false);

		endCompleteTimeField = new DataSourceDateTimeField("endCompleteTime", "完成结束日期");
		endCompleteTimeField.setRequired(false);
		endCompleteTimeField.setHidden(false);

		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);
		processTypeField.setValueMap(KeyValueManager.getValueMap("system_process_types"));

		feeTypeField = new DataSourceIntegerField("feeType", "费用类型");
		feeTypeField.setRequired(false);
		feeTypeField.setLength(11);
		feeTypeField.setHidden(false);

		bearFeeCodeField = new DataSourceTextField("bearFeeCode", "编号");
		bearFeeCodeField.setRequired(true);
		bearFeeCodeField.setLength(128);
		bearFeeCodeField.setHidden(false);

		bearFeeNameField = new DataSourceTextField("bearFeeName", "费用承担主体");
		bearFeeNameField.setRequired(true);
		bearFeeNameField.setLength(128);
		bearFeeNameField.setHidden(false);

		codeField = new DataSourceTextField("code", "报销编号");
		codeField.setRequired(false);
		codeField.setLength(64);
		codeField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "申请人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		processStatusField = new DataSourceIntegerField("processStatus", "流程状态");
		processStatusField.setRequired(true);
		processStatusField.setLength(11);
		processStatusField.setHidden(false);
		processStatusField.setValueMap(new java.util.HashMap());

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


		setFields(startCreateTimeField, endCreateTimeField, startCompleteTimeField, endCompleteTimeField, processTypeField, feeTypeField, bearFeeCodeField, bearFeeNameField, codeField, employeeIdField, plateIdField, processStatusField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

