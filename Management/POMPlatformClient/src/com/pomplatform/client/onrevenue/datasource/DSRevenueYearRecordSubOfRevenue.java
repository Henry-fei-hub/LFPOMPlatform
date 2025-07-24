package com.pomplatform.client.onrevenue.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSRevenueYearRecordSubOfRevenue extends DBDataSource
{


	public static DSRevenueYearRecordSubOfRevenue instance = null;

	public static DSRevenueYearRecordSubOfRevenue getInstance() {
		if(instance == null) {
			instance = new DSRevenueYearRecordSubOfRevenue("DSRevenueYearRecordSubOfRevenue");
		}
		return instance;
	}

	private final DataSourceIntegerField revenueYearRecordIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField codeField;
	private final DataSourceTextField nameField;
	private final DataSourceFloatField moneyField;
	private final DataSourceFloatField januaryRevenueField;
	private final DataSourceFloatField februaryRevenueField;
	private final DataSourceFloatField marchRevenueField;
	private final DataSourceFloatField aprilRevenueField;
	private final DataSourceFloatField mayRevenueField;
	private final DataSourceFloatField juneRevenueField;
	private final DataSourceFloatField julyRevenueField;
	private final DataSourceFloatField augustRevenueField;
	private final DataSourceFloatField septemberRevenueField;
	private final DataSourceFloatField octoberRevenueField;
	private final DataSourceFloatField novemberRevenueField;
	private final DataSourceFloatField decemberRevenueField;
	private final DataSourceFloatField totalRevenueField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceIntegerField yearRevenueField;
	private final DataSourceIntegerField flagField;
	private final DataSourceIntegerField signingCompanyField;
	private final DataSourceBooleanField isFinishField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;

	public DSRevenueYearRecordSubOfRevenue(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("RevenueYearRecordSubOfRevenue");


		revenueYearRecordIdField = new DataSourceIntegerField("revenueYearRecordId", "主键编码");
		revenueYearRecordIdField.setLength(11);
		revenueYearRecordIdField.setPrimaryKey(true);
		revenueYearRecordIdField.setRequired(true);
		revenueYearRecordIdField.setHidden(true);


		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);
		contractIdField.setRootValue("root");
		contractIdField.setForeignKey("DSRevenueYearRecordSubOfRevenue.contractId");


		codeField = new DataSourceTextField("code", "编号");
		codeField.setLength(64);
		codeField.setRequired(true);
		codeField.setHidden(false);


		nameField = new DataSourceTextField("name", "名称");
		nameField.setLength(512);
		nameField.setRequired(false);
		nameField.setHidden(false);


		moneyField = new DataSourceFloatField("money", "金额");
		moneyField.setLength(18);
		moneyField.setDecimalPad(5);
		moneyField.setFormat("#,###,###,###,##0.00");
		moneyField.setRequired(false);
		moneyField.setHidden(false);


		januaryRevenueField = new DataSourceFloatField("januaryRevenue", "1月");
		januaryRevenueField.setLength(18);
		januaryRevenueField.setDecimalPad(5);
		januaryRevenueField.setFormat("#,###,###,###,##0.00");
		januaryRevenueField.setRequired(false);
		januaryRevenueField.setHidden(false);


		februaryRevenueField = new DataSourceFloatField("februaryRevenue", "2月");
		februaryRevenueField.setLength(18);
		februaryRevenueField.setDecimalPad(5);
		februaryRevenueField.setFormat("#,###,###,###,##0.00");
		februaryRevenueField.setRequired(false);
		februaryRevenueField.setHidden(false);


		marchRevenueField = new DataSourceFloatField("marchRevenue", "3月");
		marchRevenueField.setLength(18);
		marchRevenueField.setDecimalPad(5);
		marchRevenueField.setFormat("#,###,###,###,##0.00");
		marchRevenueField.setRequired(false);
		marchRevenueField.setHidden(false);


		aprilRevenueField = new DataSourceFloatField("aprilRevenue", "4月");
		aprilRevenueField.setLength(18);
		aprilRevenueField.setDecimalPad(5);
		aprilRevenueField.setFormat("#,###,###,###,##0.00");
		aprilRevenueField.setRequired(false);
		aprilRevenueField.setHidden(false);


		mayRevenueField = new DataSourceFloatField("mayRevenue", "5月");
		mayRevenueField.setLength(18);
		mayRevenueField.setDecimalPad(5);
		mayRevenueField.setFormat("#,###,###,###,##0.00");
		mayRevenueField.setRequired(false);
		mayRevenueField.setHidden(false);


		juneRevenueField = new DataSourceFloatField("juneRevenue", "6月");
		juneRevenueField.setLength(18);
		juneRevenueField.setDecimalPad(5);
		juneRevenueField.setFormat("#,###,###,###,##0.00");
		juneRevenueField.setRequired(false);
		juneRevenueField.setHidden(false);


		julyRevenueField = new DataSourceFloatField("julyRevenue", "7月");
		julyRevenueField.setLength(18);
		julyRevenueField.setDecimalPad(5);
		julyRevenueField.setFormat("#,###,###,###,##0.00");
		julyRevenueField.setRequired(false);
		julyRevenueField.setHidden(false);


		augustRevenueField = new DataSourceFloatField("augustRevenue", "8月");
		augustRevenueField.setLength(18);
		augustRevenueField.setDecimalPad(5);
		augustRevenueField.setFormat("#,###,###,###,##0.00");
		augustRevenueField.setRequired(false);
		augustRevenueField.setHidden(false);


		septemberRevenueField = new DataSourceFloatField("septemberRevenue", "9月");
		septemberRevenueField.setLength(18);
		septemberRevenueField.setDecimalPad(5);
		septemberRevenueField.setFormat("#,###,###,###,##0.00");
		septemberRevenueField.setRequired(false);
		septemberRevenueField.setHidden(false);


		octoberRevenueField = new DataSourceFloatField("octoberRevenue", "10月");
		octoberRevenueField.setLength(18);
		octoberRevenueField.setDecimalPad(5);
		octoberRevenueField.setFormat("#,###,###,###,##0.00");
		octoberRevenueField.setRequired(false);
		octoberRevenueField.setHidden(false);


		novemberRevenueField = new DataSourceFloatField("novemberRevenue", "11月");
		novemberRevenueField.setLength(18);
		novemberRevenueField.setDecimalPad(5);
		novemberRevenueField.setFormat("#,###,###,###,##0.00");
		novemberRevenueField.setRequired(false);
		novemberRevenueField.setHidden(false);


		decemberRevenueField = new DataSourceFloatField("decemberRevenue", "12月");
		decemberRevenueField.setLength(18);
		decemberRevenueField.setDecimalPad(5);
		decemberRevenueField.setFormat("#,###,###,###,##0.00");
		decemberRevenueField.setRequired(false);
		decemberRevenueField.setHidden(false);


		totalRevenueField = new DataSourceFloatField("totalRevenue", "合计");
		totalRevenueField.setLength(18);
		totalRevenueField.setDecimalPad(5);
		totalRevenueField.setFormat("#,###,###,###,##0.00");
		totalRevenueField.setRequired(false);
		totalRevenueField.setHidden(false);


		parentIdField = new DataSourceIntegerField("parentId", "父级编码");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(true);


		yearRevenueField = new DataSourceIntegerField("yearRevenue", "年度");
		yearRevenueField.setLength(11);
		yearRevenueField.setRequired(false);
		yearRevenueField.setHidden(false);


		flagField = new DataSourceIntegerField("flag", "2营收");
		flagField.setLength(11);
		flagField.setRequired(false);
		flagField.setHidden(true);
		flagField.setValueMap(KeyValueManager.getValueMap("system_dictionary_34"));


		signingCompanyField = new DataSourceIntegerField("signingCompany", "签约公司");
		signingCompanyField.setLength(11);
		signingCompanyField.setRequired(false);
		signingCompanyField.setHidden(true);
		signingCompanyField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		isFinishField = new DataSourceBooleanField("isFinish", "合同是否完成");
		isFinishField.setRequired(false);
		isFinishField.setHidden(true);


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(true);


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(true);


		setFields(revenueYearRecordIdField, contractIdField, codeField, nameField, moneyField, januaryRevenueField, februaryRevenueField, marchRevenueField, aprilRevenueField, mayRevenueField, juneRevenueField, julyRevenueField, augustRevenueField, septemberRevenueField, octoberRevenueField, novemberRevenueField, decemberRevenueField, totalRevenueField, parentIdField, yearRevenueField, flagField, signingCompanyField, isFinishField, operateEmployeeIdField, operateTimeField);
	}


}

