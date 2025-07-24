package com.pomplatform.client.sreimbursementpackagemmror.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMcmbcpaydetailctswoowycoor extends DataSource
{


	public static CDMcmbcpaydetailctswoowycoor instance = null;

	public static CDMcmbcpaydetailctswoowycoor getInstance() {
		if(instance == null) {
			instance = new CDMcmbcpaydetailctswoowycoor("CDMcmbcpaydetailctswoowycoor");
		}
		return instance;
	}

	private final DataSourceIntegerField cmbcPaymentIdField;
	private final DataSourceIntegerField typeField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField withdrawFlagField;
	private final DataSourceIntegerField objectIdField;
	private final DataSourceIntegerField objectTypeField;
	private final DataSourceIntegerField withdrawStatusField;
	private final DataSourceTextField yurrefField;
	private final DataSourceIntegerField cmbcPayDetailIdField;
	private final DataSourceTextField oriYurrefField;

	public CDMcmbcpaydetailctswoowycoor(String dataSourceID) {

		setID(dataSourceID);
		cmbcPaymentIdField = new DataSourceIntegerField("cmbcPaymentId", "支付总表编码");
		cmbcPaymentIdField.setRequired(false);
		cmbcPaymentIdField.setLength(11);
		cmbcPaymentIdField.setHidden(false);

		typeField = new DataSourceIntegerField("type", "类型 1支付 2代发工资 3代发奖金 4代发其他 5 内部转账");
		typeField.setRequired(false);
		typeField.setLength(11);
		typeField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "状态 1数据录入(等待处理) 2 成功 3失败 4撤销 5退票");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		withdrawFlagField = new DataSourceIntegerField("withdrawFlag", "退单标志  1 为正常支付单 2为退单重新支付单");
		withdrawFlagField.setRequired(false);
		withdrawFlagField.setLength(11);
		withdrawFlagField.setHidden(false);

		objectIdField = new DataSourceIntegerField("objectId", "员工或者收款单位主键");
		objectIdField.setRequired(false);
		objectIdField.setLength(11);
		objectIdField.setHidden(false);

		objectTypeField = new DataSourceIntegerField("objectType", "1员工  2收款单位");
		objectTypeField.setRequired(false);
		objectTypeField.setLength(11);
		objectTypeField.setHidden(false);

		withdrawStatusField = new DataSourceIntegerField("withdrawStatus", "退单发起状态 1待资料补正 2可提起支付  3已提起支付");
		withdrawStatusField.setRequired(false);
		withdrawStatusField.setLength(11);
		withdrawStatusField.setHidden(false);

		yurrefField = new DataSourceTextField("yurref", "业务参考号");
		yurrefField.setRequired(false);
		yurrefField.setLength(255);
		yurrefField.setHidden(false);

		cmbcPayDetailIdField = new DataSourceIntegerField("cmbcPayDetailId", "主键");
		cmbcPayDetailIdField.setRequired(true);
		cmbcPayDetailIdField.setLength(11);
		cmbcPayDetailIdField.setPrimaryKey(true);
		cmbcPayDetailIdField.setHidden(true);

		oriYurrefField = new DataSourceTextField("oriYurref", "退单原始业务参考号");
		oriYurrefField.setRequired(false);
		oriYurrefField.setLength(255);
		oriYurrefField.setHidden(false);

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


		setFields(cmbcPaymentIdField, typeField, statusField, withdrawFlagField, objectIdField, objectTypeField, withdrawStatusField, yurrefField, cmbcPayDetailIdField, oriYurrefField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

