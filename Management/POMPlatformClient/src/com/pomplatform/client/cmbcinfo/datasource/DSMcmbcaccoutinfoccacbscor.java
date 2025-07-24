package com.pomplatform.client.cmbcinfo.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSMcmbcaccoutinfoccacbscor extends DBDataSource {

	public static DSMcmbcaccoutinfoccacbscor instance = null;

	public static DSMcmbcaccoutinfoccacbscor getInstance() {
		if (instance == null) {
			instance = new DSMcmbcaccoutinfoccacbscor("DSMcmbcaccoutinfoccacbscor");
		}
		return instance;
	}

	private final DataSourceIntegerField cmbcAccoutInfoIdField;
	private final DataSourceTextField ccynbrField;
	private final DataSourceTextField cCcynbrField;
	private final DataSourceTextField accitmField;
	private final DataSourceTextField bbknbrField;
	private final DataSourceTextField accnbrField;
	private final DataSourceTextField accnamField;
	private final DataSourceFloatField accblvField;
	private final DataSourceFloatField onlblvField;
	private final DataSourceFloatField hldblvField;
	private final DataSourceFloatField avlblvField;
	private final DataSourceFloatField lmtovrField;
	private final DataSourceTextField stscodField;
	private final DataSourceTextField intcodField;
	private final DataSourceTextField cIntratField;
	private final DataSourceFloatField intratField;
	private final DataSourceDateField opndatField;
	private final DataSourceDateField mutdatField;
	private final DataSourceTextField inttypField;
	private final DataSourceTextField dpstxtField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField updateTimeField;
	private final DataSourceIntegerField companyRecordIdField;

	public DSMcmbcaccoutinfoccacbscor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mcmbcaccoutinfoccacbscor");

		cmbcAccoutInfoIdField = new DataSourceIntegerField("cmbcAccoutInfoId", "主键");
		cmbcAccoutInfoIdField.setLength(11);
		cmbcAccoutInfoIdField.setPrimaryKey(true);
		cmbcAccoutInfoIdField.setRequired(true);
		cmbcAccoutInfoIdField.setHidden(true);

		ccynbrField = new DataSourceTextField("ccynbr", "币种(对应cmbc_codes的cmbc_curreny)");
		ccynbrField.setLength(8);
		ccynbrField.setRequired(false);
		ccynbrField.setHidden(true);

		cCcynbrField = new DataSourceTextField("cCcynbr", "币种名称");
		cCcynbrField.setLength(255);
		cCcynbrField.setRequired(false);
		cCcynbrField.setHidden(false);

		accitmField = new DataSourceTextField("accitm", "科目代码");
		accitmField.setLength(255);
		accitmField.setRequired(false);
		accitmField.setHidden(false);

		bbknbrField = new DataSourceTextField("bbknbr", "分行号");
		bbknbrField.setLength(255);
		bbknbrField.setRequired(false);
		bbknbrField.setHidden(true);

		accnbrField = new DataSourceTextField("accnbr", "账号");
		accnbrField.setLength(255);
		accnbrField.setRequired(false);
		accnbrField.setHidden(false);

		accnamField = new DataSourceTextField("accnam", "户名");
		accnamField.setLength(255);
		accnamField.setRequired(false);
		accnamField.setHidden(false);

		accblvField = new DataSourceFloatField("accblv", "上日余额");
		accblvField.setLength(16);
		accblvField.setDecimalPad(2);
		accblvField.setFormat("##,###,###,###,##0.00");
		accblvField.setRequired(false);
		accblvField.setHidden(false);

		onlblvField = new DataSourceFloatField("onlblv", "联机余额");
		onlblvField.setLength(16);
		onlblvField.setDecimalPad(2);
		onlblvField.setFormat("##,###,###,###,##0.00");
		onlblvField.setRequired(false);
		onlblvField.setHidden(false);

		hldblvField = new DataSourceFloatField("hldblv", "冻结余额");
		hldblvField.setLength(16);
		hldblvField.setDecimalPad(2);
		hldblvField.setFormat("##,###,###,###,##0.00");
		hldblvField.setRequired(false);
		hldblvField.setHidden(false);

		avlblvField = new DataSourceFloatField("avlblv", "可用额度");
		avlblvField.setLength(16);
		avlblvField.setDecimalPad(2);
		avlblvField.setFormat("##,###,###,###,##0.00");
		avlblvField.setRequired(false);
		avlblvField.setHidden(false);

		lmtovrField = new DataSourceFloatField("lmtovr", "透支额度");
		lmtovrField.setLength(16);
		lmtovrField.setDecimalPad(2);
		lmtovrField.setFormat("##,###,###,###,##0.00");
		lmtovrField.setRequired(false);
		lmtovrField.setHidden(false);

		stscodField = new DataSourceTextField("stscod", "状态 A活动 B冻结 C关户");
		stscodField.setLength(1);
		stscodField.setRequired(false);
		stscodField.setHidden(true);

		intcodField = new DataSourceTextField("intcod", "利息码 S子公司虚拟余额");
		intcodField.setLength(1);
		intcodField.setRequired(false);
		intcodField.setHidden(true);

		cIntratField = new DataSourceTextField("cIntrat", "年利率");
		cIntratField.setLength(255);
		cIntratField.setRequired(false);
		cIntratField.setHidden(false);

		intratField = new DataSourceFloatField("intrat", "年利率(I)");
		intratField.setLength(11);
		intratField.setDecimalPad(7);
		intratField.setFormat("#,##0.0000000");
		intratField.setRequired(false);
		intratField.setHidden(true);

		opndatField = new DataSourceDateField("opndat", "开户日");
		opndatField.setRequired(false);
		opndatField.setHidden(false);

		mutdatField = new DataSourceDateField("mutdat", "到期日");
		mutdatField.setRequired(false);
		mutdatField.setHidden(true);

		inttypField = new DataSourceTextField("inttyp", "利率类型码 cmbc_codes 利率类型码");
		inttypField.setLength(255);
		inttypField.setRequired(false);
		inttypField.setHidden(true);

		dpstxtField = new DataSourceTextField("dpstxt", "存期");
		dpstxtField.setLength(255);
		dpstxtField.setRequired(false);
		dpstxtField.setHidden(false);

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);

		updateTimeField = new DataSourceDateTimeField("updateTime", "上次更新时间时间");
		updateTimeField.setRequired(false);
		updateTimeField.setHidden(false);

		companyRecordIdField = new DataSourceIntegerField("companyRecordId", "主键编码");
		companyRecordIdField.setLength(11);
		companyRecordIdField.setRequired(true);
		companyRecordIdField.setHidden(true);

		setFields(cmbcAccoutInfoIdField, companyRecordIdField, ccynbrField, cCcynbrField, accitmField, bbknbrField,
				accnbrField, accnamField, accblvField, onlblvField, hldblvField, avlblvField, lmtovrField, stscodField,
				intcodField, cIntratField, intratField, opndatField, mutdatField, inttypField, dpstxtField,
				createTimeField, updateTimeField);
	}

}
