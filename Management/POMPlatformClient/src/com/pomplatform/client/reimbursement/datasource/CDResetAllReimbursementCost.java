package com.pomplatform.client.reimbursement.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDResetAllReimbursementCost extends DataSource
{


	public static CDResetAllReimbursementCost instance = null;

	public static CDResetAllReimbursementCost getInstance() {
		if(instance == null) {
			instance = new CDResetAllReimbursementCost("CDResetAllReimbursementCost");
		}
		return instance;
	}

	private final DataSourceDateTimeField startTimeField;
	private final DataSourceDateTimeField endTimeField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField feeTypeField;
	private final DataSourceTextField bearFeeCodeField;
	private final DataSourceTextField bearFeeNameField;
	private final DataSourceTextField codeField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceDateTimeField startCompleteTimeField;
	private final DataSourceDateTimeField endCompleteTimeField;

	public CDResetAllReimbursementCost(String dataSourceID) {

		setID(dataSourceID);
		startTimeField = new DataSourceDateTimeField("startTime", "开始日期");
		startTimeField.setRequired(false);
		startTimeField.setHidden(false);

		endTimeField = new DataSourceDateTimeField("endTime", "截止日期");
		endTimeField.setRequired(false);
		endTimeField.setHidden(false);
		
		startCompleteTimeField = new DataSourceDateTimeField("startCompleteTime", "完成开始日期");
		startCompleteTimeField.setRequired(false);
		startCompleteTimeField.setHidden(false);

		endCompleteTimeField = new DataSourceDateTimeField("endCompleteTime", "完成截止日期");
		endCompleteTimeField.setRequired(false);
		endCompleteTimeField.setHidden(false);

		processTypeField = new DataSourceIntegerField("processType", "报销类型");
		processTypeField.setRequired(true);
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

		bearFeeNameField = new DataSourceTextField("bearFeeName", "名称");
		bearFeeNameField.setRequired(true);
		bearFeeNameField.setLength(128);
		bearFeeNameField.setHidden(false);

		codeField = new DataSourceTextField("code", "报销编号");
		codeField.setRequired(false);
		codeField.setLength(64);
		codeField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "报销人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(true);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

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


		setFields(startTimeField, endTimeField, startCompleteTimeField, endCompleteTimeField, processTypeField, feeTypeField, bearFeeCodeField, bearFeeNameField, codeField, employeeIdField, plateIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

