package com.pomplatform.client.budgetmanagement.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnBudgetManagement extends DataSource
{


	public static CDOnBudgetManagement instance = null;

	public static CDOnBudgetManagement getInstance() {
		if(instance == null) {
			instance = new CDOnBudgetManagement("CDOnBudgetManagement");
		}
		return instance;
	}

	private final DataSourceTextField bdCodeField;
	private final DataSourceIntegerField bdTypeField;
	private final DataSourceFloatField bdTotalAmountField;
	private final DataSourceIntegerField bdApplyEmployeeIdField;
	private final DataSourceDateTimeField bdApplyTimeField;
	private final DataSourceDateTimeField bdEstimatecloseTimeField;
	private final DataSourceIntegerField bdStatusField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField bdRemarkField;
	private final DataSourceIntegerField processStatusField;

	public CDOnBudgetManagement(String dataSourceID) {

		setID(dataSourceID);
		bdCodeField = new DataSourceTextField("bdCode", "预算编号");
		bdCodeField.setRequired(false);
		bdCodeField.setLength(1024);
		bdCodeField.setHidden(false);

		bdTypeField = new DataSourceIntegerField("bdType", "预算类型");
		bdTypeField.setRequired(false);
		bdTypeField.setLength(11);
		bdTypeField.setHidden(false);

		bdTotalAmountField = new DataSourceFloatField("bdTotalAmount", "预算总金额");
		bdTotalAmountField.setRequired(true);
		bdTotalAmountField.setLength(18);
		bdTotalAmountField.setHidden(false);

		bdApplyEmployeeIdField = new DataSourceIntegerField("bdApplyEmployeeId", "申请人id");
		bdApplyEmployeeIdField.setRequired(false);
		bdApplyEmployeeIdField.setLength(11);
		bdApplyEmployeeIdField.setHidden(false);

		bdApplyTimeField = new DataSourceDateTimeField("bdApplyTime", "申请时间");
		bdApplyTimeField.setRequired(false);
		bdApplyTimeField.setHidden(false);

		bdEstimatecloseTimeField = new DataSourceDateTimeField("bdEstimatecloseTime", "预期关闭时间");
		bdEstimatecloseTimeField.setRequired(false);
		bdEstimatecloseTimeField.setHidden(false);

		bdStatusField = new DataSourceIntegerField("bdStatus", "预算单状态");
		bdStatusField.setRequired(false);
		bdStatusField.setLength(11);
		bdStatusField.setHidden(false);

		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);

		bdRemarkField = new DataSourceTextField("bdRemark", "预算备注");
		bdRemarkField.setRequired(false);
		bdRemarkField.setLength(2048);
		bdRemarkField.setHidden(false);

		processStatusField = new DataSourceIntegerField("processStatus", "立项流程状态");
		processStatusField.setRequired(true);
		processStatusField.setLength(11);
		processStatusField.setHidden(false);

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


		setFields(bdCodeField, bdTypeField, bdTotalAmountField, bdApplyEmployeeIdField, bdApplyTimeField, bdEstimatecloseTimeField, bdStatusField, projectIdField, bdRemarkField, processStatusField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

