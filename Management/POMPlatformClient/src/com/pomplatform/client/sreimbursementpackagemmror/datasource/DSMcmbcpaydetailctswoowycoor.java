package com.pomplatform.client.sreimbursementpackagemmror.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSMcmbcpaydetailctswoowycoor extends DBDataSource {

	public static DSMcmbcpaydetailctswoowycoor instance = null;

	public static DSMcmbcpaydetailctswoowycoor getInstance() {
		if (instance == null) {
			instance = new DSMcmbcpaydetailctswoowycoor("DSMcmbcpaydetailctswoowycoor");
		}
		return instance;
	}

	private final DataSourceIntegerField cmbcPayDetailIdField;
	private final DataSourceIntegerField typeField;
	private final DataSourceTextField yurrefField;
	private final DataSourceDateField eptdatField;
	private final DataSourceTextField dbtaccField;
	private final DataSourceTextField dbtbbkField;
	private final DataSourceFloatField trsamtField;
	private final DataSourceTextField ccynbrField;
	private final DataSourceTextField stlchnField;
	private final DataSourceTextField nusageField;
	private final DataSourceTextField busnarField;
	private final DataSourceTextField crtaccField;
	private final DataSourceTextField crtnamField;
	private final DataSourceTextField brdnbrField;
	private final DataSourceTextField bnkflgField;
	private final DataSourceTextField crtbnkField;
	private final DataSourceTextField ctycodField;
	private final DataSourceTextField crtpvcField;
	private final DataSourceTextField crtctyField;
	private final DataSourceIntegerField provinceField;
	private final DataSourceIntegerField cityField;
	private final DataSourceFloatField totalAmountField;
	private final DataSourceIntegerField totalNumField;
	private final DataSourceTextField crtbbkField;
	private final DataSourceIntegerField reimbursementPackageSummaryIdField;
	private final DataSourceIntegerField reimbursementPackageIdField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceIntegerField statusField;
	private final DataSourceTextField errorMsgField;
	private final DataSourceTextField buscodField;
	private final DataSourceTextField busmodField;
	private final DataSourceTextField eacctyField;
	private final DataSourceTextField trstypField;
	private final DataSourceTextField trstypNameField;
	private final DataSourceIntegerField cmbcPaymentIdField;
	private final DataSourceIntegerField objectIdField;
	private final DataSourceIntegerField objectTypeField;
	private final DataSourceDateTimeField oprdatField;
	private final DataSourceIntegerField withdrawFlagField;
	private final DataSourceIntegerField withdrawOriginIdField;
	private final DataSourceIntegerField withdrawStatusField;
	private final DataSourceTextField oriYurrefField;
	private final DataSourceTextField oriErrorMsgField;

	public DSMcmbcpaydetailctswoowycoor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mcmbcpaydetailctswoowycoor");

		cmbcPayDetailIdField = new DataSourceIntegerField("cmbcPayDetailId", "主键");
		cmbcPayDetailIdField.setLength(11);
		cmbcPayDetailIdField.setPrimaryKey(true);
		cmbcPayDetailIdField.setRequired(true);
		cmbcPayDetailIdField.setHidden(true);

		typeField = new DataSourceIntegerField("type", "支付类型");
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setHidden(false);
		typeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_133"));


		yurrefField = new DataSourceTextField("yurref", "业务参考号");
		yurrefField.setLength(255);
		yurrefField.setRequired(false);
		yurrefField.setHidden(false);

		eptdatField = new DataSourceDateField("eptdat", "期望日");
		eptdatField.setRequired(false);
		eptdatField.setHidden(false);

		dbtaccField = new DataSourceTextField("dbtacc", "付方账号");
		dbtaccField.setLength(255);
		dbtaccField.setRequired(false);
		dbtaccField.setHidden(false);

		dbtbbkField = new DataSourceTextField("dbtbbk", "付方开户地区代码");
		dbtbbkField.setLength(255);
		dbtbbkField.setRequired(false);
		dbtbbkField.setHidden(false);

		trsamtField = new DataSourceFloatField("trsamt", "交易金额");
		trsamtField.setLength(16);
		trsamtField.setDecimalPad(2);
		trsamtField.setFormat("##,###,###,###,##0.00");
		trsamtField.setRequired(false);
		trsamtField.setHidden(false);

		ccynbrField = new DataSourceTextField("ccynbr", "币种代码");
		ccynbrField.setLength(255);
		ccynbrField.setRequired(false);
		ccynbrField.setHidden(false);

		stlchnField = new DataSourceTextField("stlchn", "结算方式代码");
		stlchnField.setLength(255);
		stlchnField.setRequired(false);
		stlchnField.setHidden(false);

		nusageField = new DataSourceTextField("nusage", "用途");
		nusageField.setLength(255);
		nusageField.setRequired(false);
		nusageField.setHidden(false);

		busnarField = new DataSourceTextField("busnar", "业务摘要");
		busnarField.setLength(255);
		busnarField.setRequired(false);
		busnarField.setHidden(false);

		crtaccField = new DataSourceTextField("crtacc", "收方账号");
		crtaccField.setLength(255);
		crtaccField.setRequired(false);
		crtaccField.setHidden(false);

		crtnamField = new DataSourceTextField("crtnam", "收方账户名");
		crtnamField.setLength(255);
		crtnamField.setRequired(false);
		crtnamField.setHidden(false);

		brdnbrField = new DataSourceTextField("brdnbr", "自动支付收款联行号");
		brdnbrField.setLength(255);
		brdnbrField.setRequired(false);
		brdnbrField.setHidden(true);

		bnkflgField = new DataSourceTextField("bnkflg", "系统内外标志");
		bnkflgField.setLength(255);
		bnkflgField.setRequired(false);
		bnkflgField.setHidden(true);

		crtbnkField = new DataSourceTextField("crtbnk", "收方开户行");
		crtbnkField.setLength(255);
		crtbnkField.setRequired(false);
		crtbnkField.setHidden(false);

		ctycodField = new DataSourceTextField("ctycod", "城市代码");
		ctycodField.setLength(255);
		ctycodField.setRequired(false);
		ctycodField.setHidden(true);

		crtpvcField = new DataSourceTextField("crtpvc", "收方省份");
		crtpvcField.setLength(255);
		crtpvcField.setRequired(false);
		crtpvcField.setHidden(false);

		crtctyField = new DataSourceTextField("crtcty", "收方城市");
		crtctyField.setLength(255);
		crtctyField.setRequired(false);
		crtctyField.setHidden(false);

		provinceField = new DataSourceIntegerField("province", "省");
		provinceField.setLength(11);
		provinceField.setRequired(false);
		provinceField.setHidden(true);

		cityField = new DataSourceIntegerField("city", "市");
		cityField.setLength(11);
		cityField.setRequired(false);
		cityField.setHidden(true);

		totalAmountField = new DataSourceFloatField("totalAmount", "总金额");
		totalAmountField.setLength(16);
		totalAmountField.setDecimalPad(2);
		totalAmountField.setFormat("##,###,###,###,##0.00");
		totalAmountField.setRequired(false);
		totalAmountField.setHidden(false);

		totalNumField = new DataSourceIntegerField("totalNum", "总数量");
		totalNumField.setLength(11);
		totalNumField.setRequired(false);
		totalNumField.setHidden(false);

		crtbbkField = new DataSourceTextField("crtbbk", "收方开户地区代码");
		crtbbkField.setLength(255);
		crtbbkField.setRequired(false);
		crtbbkField.setHidden(true);

		reimbursementPackageSummaryIdField = new DataSourceIntegerField("reimbursementPackageSummaryId", "报销打包汇总表编码");
		reimbursementPackageSummaryIdField.setLength(11);
		reimbursementPackageSummaryIdField.setRequired(false);
		reimbursementPackageSummaryIdField.setHidden(true);

		reimbursementPackageIdField = new DataSourceIntegerField("reimbursementPackageId", "报销打包表编码");
		reimbursementPackageIdField.setLength(11);
		reimbursementPackageIdField.setRequired(false);
		reimbursementPackageIdField.setHidden(true);

		createTimeField = new DataSourceDateTimeField("createTime", "create_time");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);

		operatorField = new DataSourceIntegerField("operator", "operator");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(true);

		statusField = new DataSourceIntegerField("status", "支付状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_134"));

		errorMsgField = new DataSourceTextField("errorMsg", "错误信息");
		errorMsgField.setLength(255);
		errorMsgField.setRequired(false);
		errorMsgField.setHidden(false);

		buscodField = new DataSourceTextField("buscod", "业务类别");
		buscodField.setLength(255);
		buscodField.setRequired(false);
		buscodField.setHidden(true);

		busmodField = new DataSourceTextField("busmod", "业务模式");
		busmodField.setLength(255);
		busmodField.setRequired(false);
		busmodField.setHidden(true);

		eacctyField = new DataSourceTextField("eaccty", "他行户口开户地");
		eacctyField.setLength(255);
		eacctyField.setRequired(false);
		eacctyField.setHidden(true);

		trstypField = new DataSourceTextField("trstyp", "交易代码");
		trstypField.setLength(255);
		trstypField.setRequired(false);
		trstypField.setHidden(true);

		trstypNameField = new DataSourceTextField("trstypName", "交易代码名称");
		trstypNameField.setLength(255);
		trstypNameField.setRequired(false);
		trstypNameField.setHidden(true);

		cmbcPaymentIdField = new DataSourceIntegerField("cmbcPaymentId", "支付总表编码");
		cmbcPaymentIdField.setLength(11);
		cmbcPaymentIdField.setRequired(false);
		cmbcPaymentIdField.setHidden(true);

		objectIdField = new DataSourceIntegerField("objectId", "员工或者收款单位主键");
		objectIdField.setLength(11);
		objectIdField.setRequired(false);
		objectIdField.setHidden(true);

		objectTypeField = new DataSourceIntegerField("objectType", "1员工  2收款单位");
		objectTypeField.setLength(11);
		objectTypeField.setRequired(false);
		objectTypeField.setHidden(true);

		oprdatField = new DataSourceDateTimeField("oprdat", "经办日期");
		oprdatField.setRequired(false);
		oprdatField.setHidden(true);

		withdrawFlagField = new DataSourceIntegerField("withdrawFlag", "退单标志  1 为正常支付单 2为退单重新支付单");
		withdrawFlagField.setLength(11);
		withdrawFlagField.setRequired(false);
		withdrawFlagField.setHidden(true);
		withdrawFlagField.setValueMap(KeyValueManager.getValueMap("system_dictionary_138"));

		withdrawOriginIdField = new DataSourceIntegerField("withdrawOriginId", "退单来源主键");
		withdrawOriginIdField.setLength(11);
		withdrawOriginIdField.setRequired(false);
		withdrawOriginIdField.setHidden(true);

		withdrawStatusField = new DataSourceIntegerField("withdrawStatus", "退单发起状态");
		withdrawStatusField.setLength(11);
		withdrawStatusField.setRequired(false);
		withdrawStatusField.setHidden(false);
		withdrawStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_137"));

		oriYurrefField = new DataSourceTextField("oriYurref", "原退单业务参考号");
		oriYurrefField.setLength(255);
		oriYurrefField.setRequired(true);
		oriYurrefField.setHidden(false);

		oriErrorMsgField = new DataSourceTextField("oriErrorMsg", "原退单错误提示信息");
		oriErrorMsgField.setLength(255);
		oriErrorMsgField.setRequired(true);
		oriErrorMsgField.setHidden(false);

		setFields(cmbcPayDetailIdField, typeField, yurrefField, eptdatField, dbtaccField, dbtbbkField, trsamtField,
				ccynbrField, stlchnField, nusageField, busnarField, crtaccField, crtnamField, brdnbrField, bnkflgField,
				crtbnkField, ctycodField, crtpvcField, crtctyField, provinceField, cityField, totalAmountField,
				totalNumField, crtbbkField, reimbursementPackageSummaryIdField, reimbursementPackageIdField,
				createTimeField, operatorField, statusField, errorMsgField, buscodField, busmodField, eacctyField,
				trstypField, trstypNameField, cmbcPaymentIdField, objectIdField, objectTypeField, oprdatField,
				withdrawFlagField, withdrawOriginIdField, withdrawStatusField, oriYurrefField, oriErrorMsgField);
	}

}
