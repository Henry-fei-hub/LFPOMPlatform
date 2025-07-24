package com.pomplatform.client.sreimbursementpackagemmror.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDScmbcpaydetailctyor extends DataSource
{


	public static CDScmbcpaydetailctyor instance = null;

	public static CDScmbcpaydetailctyor getInstance() {
		if(instance == null) {
			instance = new CDScmbcpaydetailctyor("CDScmbcpaydetailctyor");
		}
		return instance;
	}

	private final DataSourceIntegerField cmbcPayDetailIdField;
	private final DataSourceIntegerField typeField;
	private final DataSourceTextField yurrefField;
	private final DataSourceIntegerField reimbursementPackageSummaryIdField;
	private final DataSourceIntegerField reimbursementPackageIdField;
	private final DataSourceIntegerField statusField;

	public CDScmbcpaydetailctyor(String dataSourceID) {

		setID(dataSourceID);
		cmbcPayDetailIdField = new DataSourceIntegerField("cmbcPayDetailId", "主键");
		cmbcPayDetailIdField.setRequired(true);
		cmbcPayDetailIdField.setLength(11);
		cmbcPayDetailIdField.setPrimaryKey(true);
		cmbcPayDetailIdField.setHidden(true);

		typeField = new DataSourceIntegerField("type", "类型 1支付 2代发工资 3代发奖金 4代发其他 5 内部转账");
		typeField.setRequired(false);
		typeField.setLength(11);
		typeField.setHidden(false);

		yurrefField = new DataSourceTextField("yurref", "业务参考号");
		yurrefField.setRequired(false);
		yurrefField.setLength(255);
		yurrefField.setHidden(false);

		reimbursementPackageSummaryIdField = new DataSourceIntegerField("reimbursementPackageSummaryId", "报销打包汇总表编码");
		reimbursementPackageSummaryIdField.setRequired(false);
		reimbursementPackageSummaryIdField.setLength(11);
		reimbursementPackageSummaryIdField.setHidden(false);

		reimbursementPackageIdField = new DataSourceIntegerField("reimbursementPackageId", "报销打包表编码");
		reimbursementPackageIdField.setRequired(false);
		reimbursementPackageIdField.setLength(11);
		reimbursementPackageIdField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

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


		setFields(cmbcPayDetailIdField, typeField, yurrefField, reimbursementPackageSummaryIdField, reimbursementPackageIdField, statusField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

