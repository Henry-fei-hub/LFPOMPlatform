package com.pomplatform.client.cmbcinfo.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class CDMcmbctransinfolinktattlor extends DataSource {

	public static CDMcmbctransinfolinktattlor instance = null;

	public static CDMcmbctransinfolinktattlor getInstance() {
		if (instance == null) {
			instance = new CDMcmbctransinfolinktattlor("CDMcmbctransinfolinktattlor");
		}
		return instance;
	}

	private final DataSourceTextField bankAccountField;
	private final DataSourceIntegerField companyRecordIdField;
	private final DataSourceTextField naryurField;
	private final DataSourceTextField refnbrField;
	private final DataSourceTextField reqnbrField;
	private final DataSourceTextField busnamField;
	private final DataSourceTextField nusageField;
	private final DataSourceTextField yurrefField;
	private final DataSourceTextField rpynamField;
	private final DataSourceTextField rpyaccField;
	private final DataSourceTextField rpybnkField;
	private final DataSourceTextField rpyadrField;
	private final DataSourceDateTimeField minTransDateField;
	private final DataSourceDateTimeField maxTransDateField;
	private final DataSourceDateField minVltdatField;
	private final DataSourceDateField maxVltdatField;
	private final DataSourceDateTimeField minCreateTimeField;
	private final DataSourceDateTimeField maxCreateTimeField;
	private final DataSourceDateTimeField minUpdateTimeField;
	private final DataSourceDateTimeField maxUpdateTimeField;
	private final DataSourceIntegerField cmbcTransInfoIdField;
	private final DataSourceTextField trscodField;
	private final DataSourceTextField amtcdrField;
	private final DataSourceTextField trsanlField;
	private final DataSourceIntegerField transTypeField;
	private final DataSourceIntegerField linkNumField;
	private final DataSourceBooleanField isLinkField;

	public CDMcmbctransinfolinktattlor(String dataSourceID) {

		setID(dataSourceID);
		bankAccountField = new DataSourceTextField("bankAccount", "银行账号(用来标识该条流水是哪个账号)");
		bankAccountField.setRequired(false);
		bankAccountField.setLength(64);
		bankAccountField.setHidden(false);

		companyRecordIdField = new DataSourceIntegerField("companyRecordId", "主键编码");
		companyRecordIdField.setRequired(true);
		companyRecordIdField.setLength(11);
		companyRecordIdField.setPrimaryKey(true);
		companyRecordIdField.setHidden(true);

		naryurField = new DataSourceTextField("naryur", "摘要");
		naryurField.setRequired(false);
		naryurField.setLength(130);
		naryurField.setHidden(false);

		refnbrField = new DataSourceTextField("refnbr", "流水号");
		refnbrField.setRequired(false);
		refnbrField.setLength(15);
		refnbrField.setHidden(false);

		reqnbrField = new DataSourceTextField("reqnbr", "流程实例号");
		reqnbrField.setRequired(false);
		reqnbrField.setLength(10);
		reqnbrField.setHidden(false);

		busnamField = new DataSourceTextField("busnam", "业务名称");
		busnamField.setRequired(false);
		busnamField.setLength(68);
		busnamField.setHidden(false);

		nusageField = new DataSourceTextField("nusage", "用途");
		nusageField.setRequired(false);
		nusageField.setLength(130);
		nusageField.setHidden(false);

		yurrefField = new DataSourceTextField("yurref", "业务参考号");
		yurrefField.setRequired(false);
		yurrefField.setLength(30);
		yurrefField.setHidden(false);

		rpynamField = new DataSourceTextField("rpynam", "收/付方名称");
		rpynamField.setRequired(false);
		rpynamField.setLength(130);
		rpynamField.setHidden(false);

		rpyaccField = new DataSourceTextField("rpyacc", "收/付方帐号");
		rpyaccField.setRequired(false);
		rpyaccField.setLength(35);
		rpyaccField.setHidden(false);

		rpybnkField = new DataSourceTextField("rpybnk", "收/付方开户行名");
		rpybnkField.setRequired(false);
		rpybnkField.setLength(130);
		rpybnkField.setHidden(false);

		rpyadrField = new DataSourceTextField("rpyadr", "收/付方开户行地址");
		rpyadrField.setRequired(false);
		rpyadrField.setLength(130);
		rpyadrField.setHidden(false);

		minTransDateField = new DataSourceDateTimeField("minTransDate", "最早交易时间");
		minTransDateField.setRequired(false);
		minTransDateField.setHidden(false);

		maxTransDateField = new DataSourceDateTimeField("maxTransDate", "最晚交易时间");
		maxTransDateField.setRequired(false);
		maxTransDateField.setHidden(false);

		minVltdatField = new DataSourceDateField("minVltdat", "最早起息日");
		minVltdatField.setRequired(false);
		minVltdatField.setHidden(false);

		maxVltdatField = new DataSourceDateField("maxVltdat", "最晚起息日");
		maxVltdatField.setRequired(false);
		maxVltdatField.setHidden(false);

		minCreateTimeField = new DataSourceDateTimeField("minCreateTime", "最早创建时间");
		minCreateTimeField.setRequired(false);
		minCreateTimeField.setHidden(false);

		maxCreateTimeField = new DataSourceDateTimeField("maxCreateTime", "最晚创建时间");
		maxCreateTimeField.setRequired(false);
		maxCreateTimeField.setHidden(false);

		minUpdateTimeField = new DataSourceDateTimeField("minUpdateTime", "最早修改时间");
		minUpdateTimeField.setRequired(false);
		minUpdateTimeField.setHidden(false);

		maxUpdateTimeField = new DataSourceDateTimeField("maxUpdateTime", "最晚修改时间");
		maxUpdateTimeField.setRequired(false);
		maxUpdateTimeField.setHidden(false);

		cmbcTransInfoIdField = new DataSourceIntegerField("cmbcTransInfoId", "主键");
		cmbcTransInfoIdField.setRequired(true);
		cmbcTransInfoIdField.setLength(11);
		cmbcTransInfoIdField.setPrimaryKey(true);
		cmbcTransInfoIdField.setHidden(true);

		trscodField = new DataSourceTextField("trscod", "交易类型 cmbc_codes trans_code");
		trscodField.setRequired(false);
		trscodField.setLength(8);
		trscodField.setHidden(false);

		amtcdrField = new DataSourceTextField("amtcdr", "借贷标记 C贷 D借");
		amtcdrField.setRequired(false);
		amtcdrField.setLength(1);
		amtcdrField.setHidden(false);

		trsanlField = new DataSourceTextField("trsanl", "交易分析码");
		trsanlField.setRequired(false);
		trsanlField.setLength(6);
		trsanlField.setHidden(false);

		transTypeField = new DataSourceIntegerField("transType", "ERP收支表示  1收  2支");
		transTypeField.setRequired(false);
		transTypeField.setLength(11);
		transTypeField.setHidden(false);

		linkNumField = new DataSourceIntegerField("linkNum", "数量");
		linkNumField.setRequired(true);
		linkNumField.setLength(11);
		linkNumField.setHidden(false);

		isLinkField = new DataSourceBooleanField("isLink", "是否绑定");
		isLinkField.setRequired(false);
		isLinkField.setHidden(true);

		DataSourceIntegerField currentPageField = new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField = new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);

		setFields(bankAccountField, companyRecordIdField, naryurField, refnbrField, reqnbrField, busnamField,
				nusageField, yurrefField, rpynamField, rpyaccField, rpybnkField, rpyadrField, minTransDateField,
				maxTransDateField, minVltdatField, maxVltdatField, minCreateTimeField, maxCreateTimeField,
				minUpdateTimeField, maxUpdateTimeField, cmbcTransInfoIdField, trscodField, amtcdrField, trsanlField,
				transTypeField, linkNumField, isLinkField, currentPageField, pageLinesField);

		setClientOnly(true);
	}

}
