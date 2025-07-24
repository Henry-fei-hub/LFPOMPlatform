package com.pomplatform.client.cmbcinfo.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSMcmbctransinfolinktattlor extends DBDataSource {

	public static DSMcmbctransinfolinktattlor instance = null;

	public static DSMcmbctransinfolinktattlor getInstance() {
		if (instance == null) {
			instance = new DSMcmbctransinfolinktattlor("DSMcmbctransinfolinktattlor");
		}
		return instance;
	}

	private final DataSourceIntegerField cmbcTransInfoIdField;
	private final DataSourceTextField bankAccountField;
	private final DataSourceTextField accnamField;
	private final DataSourceTextField etydatField;
	private final DataSourceTextField etytimField;
	private final DataSourceDateTimeField transDateField;
	private final DataSourceDateField vltdatField;
	private final DataSourceTextField trscodField;
	private final DataSourceTextField naryurField;
	private final DataSourceFloatField trsamtdField;
	private final DataSourceFloatField trsamtcField;
	private final DataSourceTextField amtcdrField;
	private final DataSourceFloatField trsblvField;
	private final DataSourceTextField refnbrField;
	private final DataSourceTextField reqnbrField;
	private final DataSourceTextField busnamField;
	private final DataSourceTextField nusageField;
	private final DataSourceTextField yurrefField;
	private final DataSourceTextField busnarField;
	private final DataSourceTextField otrnarField;
	private final DataSourceTextField cRpybbkField;
	private final DataSourceTextField rpynamField;
	private final DataSourceTextField rpyaccField;
	private final DataSourceTextField rpybbnField;
	private final DataSourceTextField rpybnkField;
	private final DataSourceTextField rpyadrField;
	private final DataSourceTextField cGsbbbkField;
	private final DataSourceTextField gsbaccField;
	private final DataSourceTextField gsbnamField;
	private final DataSourceIntegerField infflgField;
	private final DataSourceTextField athflgField;
	private final DataSourceTextField chknbrField;
	private final DataSourceTextField rsvflgField;
	private final DataSourceTextField narextField;
	private final DataSourceTextField trsanlField;
	private final DataSourceTextField refsubField;
	private final DataSourceTextField frmcodField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField updateTimeField;
	private final DataSourceIntegerField transTypeField;
	private final DataSourceIntegerField companyRecordIdField;
	private final DataSourceIntegerField linkNumField;

	public DSMcmbctransinfolinktattlor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mcmbctransinfolinktattlor");

		cmbcTransInfoIdField = new DataSourceIntegerField("cmbcTransInfoId", "主键");
		cmbcTransInfoIdField.setLength(11);
		cmbcTransInfoIdField.setPrimaryKey(true);
		cmbcTransInfoIdField.setRequired(true);
		cmbcTransInfoIdField.setHidden(true);

		bankAccountField = new DataSourceTextField("bankAccount", "银行账号");
		bankAccountField.setLength(64);
		bankAccountField.setRequired(false);
		bankAccountField.setHidden(false);

		accnamField = new DataSourceTextField("accnam", "归属公司");
		accnamField.setLength(255);
		accnamField.setRequired(false);
		accnamField.setHidden(false);

		etydatField = new DataSourceTextField("etydat", "交易日");
		etydatField.setLength(16);
		etydatField.setRequired(false);
		etydatField.setHidden(true);

		etytimField = new DataSourceTextField("etytim", "交易时间(时分秒181211 时才有准确性)");
		etytimField.setLength(16);
		etytimField.setRequired(false);
		etytimField.setHidden(true);

		transDateField = new DataSourceDateTimeField("transDate", "交易时间");
		transDateField.setRequired(false);
		transDateField.setHidden(false);

		vltdatField = new DataSourceDateField("vltdat", "起息日");
		vltdatField.setRequired(false);
		vltdatField.setHidden(true);

		trscodField = new DataSourceTextField("trscod", "交易类型 cmbc_codes trans_code");
		trscodField.setLength(8);
		trscodField.setRequired(false);
		trscodField.setHidden(true);

		naryurField = new DataSourceTextField("naryur", "摘要");
		naryurField.setLength(130);
		naryurField.setRequired(false);
		naryurField.setHidden(false);

		trsamtdField = new DataSourceFloatField("trsamtd", "借方金额");
		trsamtdField.setLength(16);
		trsamtdField.setDecimalPad(2);
		trsamtdField.setFormat("##,###,###,###,##0.00");
		trsamtdField.setRequired(false);
		trsamtdField.setHidden(true);

		trsamtcField = new DataSourceFloatField("trsamtc", "贷方金额");
		trsamtcField.setLength(16);
		trsamtcField.setDecimalPad(2);
		trsamtcField.setFormat("##,###,###,###,##0.00");
		trsamtcField.setRequired(false);
		trsamtcField.setHidden(false);

		amtcdrField = new DataSourceTextField("amtcdr", "借贷标记 C贷 D借");
		amtcdrField.setLength(1);
		amtcdrField.setRequired(false);
		amtcdrField.setHidden(true);

		trsblvField = new DataSourceFloatField("trsblv", "余额");
		trsblvField.setLength(16);
		trsblvField.setDecimalPad(2);
		trsblvField.setFormat("##,###,###,###,##0.00");
		trsblvField.setRequired(false);
		trsblvField.setHidden(true);

		refnbrField = new DataSourceTextField("refnbr", "流水号");
		refnbrField.setLength(15);
		refnbrField.setRequired(false);
		refnbrField.setHidden(true);

		reqnbrField = new DataSourceTextField("reqnbr", "流程实例号");
		reqnbrField.setLength(10);
		reqnbrField.setRequired(false);
		reqnbrField.setHidden(true);

		busnamField = new DataSourceTextField("busnam", "业务名称");
		busnamField.setLength(68);
		busnamField.setRequired(false);
		busnamField.setHidden(true);

		nusageField = new DataSourceTextField("nusage", "用途");
		nusageField.setLength(130);
		nusageField.setRequired(false);
		nusageField.setHidden(true);

		yurrefField = new DataSourceTextField("yurref", "业务参考号");
		yurrefField.setLength(30);
		yurrefField.setRequired(false);
		yurrefField.setHidden(true);

		busnarField = new DataSourceTextField("busnar", "业务摘要");
		busnarField.setLength(400);
		busnarField.setRequired(false);
		busnarField.setHidden(true);

		otrnarField = new DataSourceTextField("otrnar", "其它摘要");
		otrnarField.setLength(130);
		otrnarField.setRequired(false);
		otrnarField.setHidden(true);

		cRpybbkField = new DataSourceTextField("cRpybbk", "付方开户地区");
		cRpybbkField.setLength(12);
		cRpybbkField.setRequired(false);
		cRpybbkField.setHidden(true);

		rpynamField = new DataSourceTextField("rpynam", "付方名称");
		rpynamField.setLength(130);
		rpynamField.setRequired(false);
		rpynamField.setHidden(false);

		rpyaccField = new DataSourceTextField("rpyacc", "付方帐号");
		rpyaccField.setLength(35);
		rpyaccField.setRequired(false);
		rpyaccField.setHidden(false);

		rpybbnField = new DataSourceTextField("rpybbn", "收/付方开户行行号");
		rpybbnField.setLength(20);
		rpybbnField.setRequired(false);
		rpybbnField.setHidden(true);

		rpybnkField = new DataSourceTextField("rpybnk", "收/付方开户行名");
		rpybnkField.setLength(130);
		rpybnkField.setRequired(false);
		rpybnkField.setHidden(false);

		rpyadrField = new DataSourceTextField("rpyadr", "收/付方开户行地址");
		rpyadrField.setLength(130);
		rpyadrField.setRequired(false);
		rpyadrField.setHidden(false);

		cGsbbbkField = new DataSourceTextField("cGsbbbk", "母/子公司所在地区");
		cGsbbbkField.setLength(64);
		cGsbbbkField.setRequired(false);
		cGsbbbkField.setHidden(true);

		gsbaccField = new DataSourceTextField("gsbacc", "母/子公司帐号");
		gsbaccField.setLength(35);
		gsbaccField.setRequired(false);
		gsbaccField.setHidden(true);

		gsbnamField = new DataSourceTextField("gsbnam", "母/子公司名称");
		gsbnamField.setLength(130);
		gsbnamField.setRequired(false);
		gsbnamField.setHidden(true);

		infflgField = new DataSourceIntegerField("infflg", "1表示收方帐号和子公司；为2表示收方帐号和母公司；为3表示原收方帐号和子公司");
		infflgField.setLength(11);
		infflgField.setRequired(false);
		infflgField.setHidden(true);

		athflgField = new DataSourceTextField("athflg", "有否附件信息标志");
		athflgField.setLength(1);
		athflgField.setRequired(false);
		athflgField.setHidden(true);

		chknbrField = new DataSourceTextField("chknbr", "票据号");
		chknbrField.setLength(20);
		chknbrField.setRequired(false);
		chknbrField.setHidden(true);

		rsvflgField = new DataSourceTextField("rsvflg", "冲账标志 *为冲帐 X为补帐");
		rsvflgField.setLength(1);
		rsvflgField.setRequired(false);
		rsvflgField.setHidden(true);

		narextField = new DataSourceTextField("narext", "扩展摘要");
		narextField.setLength(70);
		narextField.setRequired(false);
		narextField.setHidden(true);

		trsanlField = new DataSourceTextField("trsanl", "交易分析码");
		trsanlField.setLength(6);
		trsanlField.setRequired(false);
		trsanlField.setHidden(true);

		refsubField = new DataSourceTextField("refsub", "商务支付订单号");
		refsubField.setLength(50);
		refsubField.setRequired(false);
		refsubField.setHidden(true);

		frmcodField = new DataSourceTextField("frmcod", "企业识别码");
		frmcodField.setLength(10);
		frmcodField.setRequired(false);
		frmcodField.setHidden(true);

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);

		updateTimeField = new DataSourceDateTimeField("updateTime", "修改时间");
		updateTimeField.setRequired(false);
		updateTimeField.setHidden(true);

		transTypeField = new DataSourceIntegerField("transType", "ERP收支表示  1收  2支");
		transTypeField.setLength(11);
		transTypeField.setRequired(false);
		transTypeField.setHidden(true);

		companyRecordIdField = new DataSourceIntegerField("companyRecordId", "主键编码");
		companyRecordIdField.setLength(11);
		companyRecordIdField.setRequired(true);
		companyRecordIdField.setHidden(true);

		linkNumField = new DataSourceIntegerField("linkNum", "");
		linkNumField.setLength(11);
		linkNumField.setRequired(true);
		linkNumField.setHidden(true);

		setFields(cmbcTransInfoIdField, companyRecordIdField, accnamField, bankAccountField, etydatField, etytimField,
				vltdatField, trscodField, trsamtdField, trsamtcField, amtcdrField, transDateField, 
				trsblvField, refnbrField, reqnbrField, busnamField, nusageField, yurrefField, busnarField, otrnarField,
				cRpybbkField, rpynamField, rpyaccField, rpybbnField, rpybnkField, rpyadrField, cGsbbbkField,
				gsbaccField, gsbnamField, infflgField, athflgField, chknbrField, rsvflgField, narextField, trsanlField,
				refsubField, frmcodField, createTimeField, updateTimeField, transTypeField, linkNumField, naryurField);
	}

}
