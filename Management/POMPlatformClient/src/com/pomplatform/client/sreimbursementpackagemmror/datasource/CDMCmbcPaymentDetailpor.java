package com.pomplatform.client.sreimbursementpackagemmror.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMCmbcPaymentDetailpor extends DataSource
{


	public static CDMCmbcPaymentDetailpor instance = null;

	public static CDMCmbcPaymentDetailpor getInstance() {
		if(instance == null) {
			instance = new CDMCmbcPaymentDetailpor("CDMCmbcPaymentDetailpor");
		}
		return instance;
	}

	private final DataSourceTextField dbtaccField;
	private final DataSourceTextField dbtbbkField;
	private final DataSourceTextField crtaccField;
	private final DataSourceTextField crtnamField;
	private final DataSourceIntegerField typeField;
	private final DataSourceTextField yurrefField;
	private final DataSourceIntegerField reimbursementPackageSummaryIdField;
	private final DataSourceIntegerField reimbursementPackageIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField cmbcPaymentIdField;

	public CDMCmbcPaymentDetailpor(String dataSourceID) {

		setID(dataSourceID);
		dbtaccField = new DataSourceTextField("dbtacc", "付方账号");
		dbtaccField.setRequired(false);
		dbtaccField.setLength(255);
		dbtaccField.setHidden(false);

		dbtbbkField = new DataSourceTextField("dbtbbk", "付方开户地区代码");
		dbtbbkField.setRequired(false);
		dbtbbkField.setLength(255);
		dbtbbkField.setHidden(false);

		crtaccField = new DataSourceTextField("crtacc", "收方账号");
		crtaccField.setRequired(false);
		crtaccField.setLength(255);
		crtaccField.setHidden(false);

		crtnamField = new DataSourceTextField("crtnam", "收方账户名");
		crtnamField.setRequired(false);
		crtnamField.setLength(255);
		crtnamField.setHidden(false);

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

		statusField = new DataSourceIntegerField("status", "状态 1数据录入(等待处理) 2 成功 3失败 4撤销 5退票");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		cmbcPaymentIdField = new DataSourceIntegerField("cmbcPaymentId", "支付总表编码");
		cmbcPaymentIdField.setRequired(false);
		cmbcPaymentIdField.setLength(11);
		cmbcPaymentIdField.setHidden(false);

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


		setFields(dbtaccField, dbtbbkField, crtaccField, crtnamField, typeField, yurrefField, reimbursementPackageSummaryIdField, reimbursementPackageIdField, statusField, cmbcPaymentIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

