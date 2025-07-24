package com.pomplatform.client.specialdeduction.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSpecialDeductionRecordsApplyOfWorkflow extends DataSource
{


	public static CDSpecialDeductionRecordsApplyOfWorkflow instance = null;

	public static CDSpecialDeductionRecordsApplyOfWorkflow getInstance() {
		if(instance == null) {
			instance = new CDSpecialDeductionRecordsApplyOfWorkflow("CDSpecialDeductionRecordsApplyOfWorkflow");
		}
		return instance;
	}

	private final DataSourceIntegerField employeIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceBooleanField isEnableField;
	private final DataSourceIntegerField departmentIdField;

	public CDSpecialDeductionRecordsApplyOfWorkflow(String dataSourceID) {

		setID(dataSourceID);
		employeIdField = new DataSourceIntegerField("employeId", "纳税申请人");
		employeIdField.setRequired(true);
		employeIdField.setLength(11);
		employeIdField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

		isEnableField = new DataSourceBooleanField("isEnable", "是否可用");
		isEnableField.setRequired(false);
		isEnableField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setRequired(true);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

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


		setFields(employeIdField, companyIdField, plateIdField, isEnableField, departmentIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

