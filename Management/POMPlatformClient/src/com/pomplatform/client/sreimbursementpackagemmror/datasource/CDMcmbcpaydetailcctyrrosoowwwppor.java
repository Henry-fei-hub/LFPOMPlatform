package com.pomplatform.client.sreimbursementpackagemmror.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMcmbcpaydetailcctyrrosoowwwppor extends DataSource
{


	public static CDMcmbcpaydetailcctyrrosoowwwppor instance = null;

	public static CDMcmbcpaydetailcctyrrosoowwwppor getInstance() {
		if(instance == null) {
			instance = new CDMcmbcpaydetailcctyrrosoowwwppor("CDMcmbcpaydetailcctyrrosoowwwppor");
		}
		return instance;
	}

	private final DataSourceIntegerField cmbcPayDetailIdField;
	private final DataSourceIntegerField typeField;
	private final DataSourceTextField yurrefField;
	private final DataSourceIntegerField reimbursementPackageSummaryIdField;
	private final DataSourceIntegerField reimbursementPackageIdField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField objectIdField;
	private final DataSourceIntegerField objectTypeField;
	private final DataSourceIntegerField withdrawFlagField;
	private final DataSourceIntegerField withdrawOriginIdField;
	private final DataSourceIntegerField withdrawStatusField;
	private final DataSourceIntegerField payResultField;
	private final DataSourceIntegerField payStatusField;

	public CDMcmbcpaydetailcctyrrosoowwwppor(String dataSourceID) {

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

		operatorField = new DataSourceIntegerField("operator", "operator");
		operatorField.setRequired(false);
		operatorField.setLength(11);
		operatorField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "状态 1数据录入(等待处理) 2 成功 3失败 4撤销 5退票");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		objectIdField = new DataSourceIntegerField("objectId", "员工或者收款单位主键");
		objectIdField.setRequired(false);
		objectIdField.setLength(11);
		objectIdField.setHidden(false);

		objectTypeField = new DataSourceIntegerField("objectType", "1员工  2收款单位");
		objectTypeField.setRequired(false);
		objectTypeField.setLength(11);
		objectTypeField.setHidden(false);

		withdrawFlagField = new DataSourceIntegerField("withdrawFlag", "退单标志  1 为正常支付单 2为退单重新支付单");
		withdrawFlagField.setRequired(false);
		withdrawFlagField.setLength(11);
		withdrawFlagField.setHidden(false);

		withdrawOriginIdField = new DataSourceIntegerField("withdrawOriginId", "退单来源主键");
		withdrawOriginIdField.setRequired(false);
		withdrawOriginIdField.setLength(11);
		withdrawOriginIdField.setHidden(false);

		withdrawStatusField = new DataSourceIntegerField("withdrawStatus", "退单发起状态 1待资料补正 2可提起支付  3已提起支付");
		withdrawStatusField.setRequired(false);
		withdrawStatusField.setLength(11);
		withdrawStatusField.setHidden(false);

		payResultField = new DataSourceIntegerField("payResult", "4失败");
		payResultField.setRequired(false);
		payResultField.setLength(11);
		payResultField.setHidden(false);

		payStatusField = new DataSourceIntegerField("payStatus", "3支付完成(已返回处理结果)");
		payStatusField.setRequired(false);
		payStatusField.setLength(11);
		payStatusField.setHidden(false);

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


		setFields(cmbcPayDetailIdField, typeField, yurrefField, reimbursementPackageSummaryIdField, reimbursementPackageIdField, operatorField, statusField, objectIdField, objectTypeField, withdrawFlagField, withdrawOriginIdField, withdrawStatusField, payResultField, payStatusField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

