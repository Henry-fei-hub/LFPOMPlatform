package com.pomplatform.client.reimbursement.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class CDReimbursementpackagemmror extends DataSource
{


	public static CDReimbursementpackagemmror instance = null;

	public static CDReimbursementpackagemmror getInstance() {
		if(instance == null) {
			instance = new CDReimbursementpackagemmror("CDReimbursementpackagemmror");
		}
		return instance;
	}

	private final DataSourceDateTimeField minCreateTimeField;
	private final DataSourceDateTimeField maxCreateTimeField;
	private final DataSourceIntegerField reimbursementPackageIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceBooleanField isCompletedField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField roleIdField;
	private final DataSourceIntegerField operatorIdField;
	private final DataSourceTextField codeField;
	private final DataSourceTextField dcodeField;

	public CDReimbursementpackagemmror(String dataSourceID) {

		setID(dataSourceID);
		minCreateTimeField = new DataSourceDateTimeField("minCreateTime", "最早创建时间");
		minCreateTimeField.setRequired(false);
		minCreateTimeField.setHidden(false);

		maxCreateTimeField = new DataSourceDateTimeField("maxCreateTime", "最晚创建时间");
		maxCreateTimeField.setRequired(false);
		maxCreateTimeField.setHidden(false);

		reimbursementPackageIdField = new DataSourceIntegerField("reimbursementPackageId", "报销打包表编码");
		reimbursementPackageIdField.setRequired(true);
		reimbursementPackageIdField.setLength(11);
		reimbursementPackageIdField.setPrimaryKey(true);
		reimbursementPackageIdField.setHidden(true);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);

		isCompletedField = new DataSourceBooleanField("isCompleted", "是否通过审批");
		isCompletedField.setRequired(false);
		isCompletedField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(255);
		remarkField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "可操作人编码");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		roleIdField = new DataSourceIntegerField("roleId", "可操作角色编码");
		roleIdField.setRequired(false);
		roleIdField.setLength(11);
		roleIdField.setHidden(false);

		operatorIdField = new DataSourceIntegerField("operatorId", "操作人Id");
		operatorIdField.setRequired(false);
		operatorIdField.setLength(11);
		operatorIdField.setHidden(false);
		
		codeField = new DataSourceTextField("code", "汇总单号");
		codeField.setLength(100);
		codeField.setRequired(false);
		codeField.setHidden(false);
		
		dcodeField = new DataSourceTextField("orderCode", "报销单单号");
		dcodeField.setLength(100);
		dcodeField.setRequired(false);
		dcodeField.setHidden(false);

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


		setFields(minCreateTimeField, maxCreateTimeField, reimbursementPackageIdField, companyIdField, isCompletedField, remarkField, employeeIdField, roleIdField, operatorIdField, codeField, dcodeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

