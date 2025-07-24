package com.pomplatform.client.revenue.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DScontractSaveAnalyze extends DBDataSource
{


	public static DScontractSaveAnalyze instance = null;

	public static DScontractSaveAnalyze getInstance() {
		if(instance == null) {
			instance = new DScontractSaveAnalyze("DScontractSaveAnalyze");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceFloatField januaryContractSaveField;
	private final DataSourceFloatField februaryContractSaveField;
	private final DataSourceFloatField marchContractSaveField;
	private final DataSourceFloatField aprilContractSaveField;
	private final DataSourceFloatField mayContractSaveField;
	private final DataSourceFloatField juneContractSaveField;
	private final DataSourceFloatField julyContractSaveField;
	private final DataSourceFloatField augustContractSaveField;
	private final DataSourceFloatField septemberContractSaveField;
	private final DataSourceFloatField octoberContractSaveField;
	private final DataSourceFloatField novemberContractSaveField;
	private final DataSourceFloatField decemberContractSaveField;
	private final DataSourceFloatField totalField;

	public DScontractSaveAnalyze(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("contractSaveAnalyze");


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);


		januaryContractSaveField = new DataSourceFloatField("januaryContractSave", "一月");
		januaryContractSaveField.setLength(18);
		januaryContractSaveField.setDecimalPad(2);
		januaryContractSaveField.setFormat("#,###,###,###,###,##0.00");
		januaryContractSaveField.setRequired(true);
		januaryContractSaveField.setHidden(false);


		februaryContractSaveField = new DataSourceFloatField("februaryContractSave", "二月");
		februaryContractSaveField.setLength(18);
		februaryContractSaveField.setDecimalPad(2);
		februaryContractSaveField.setFormat("#,###,###,###,###,##0.00");
		februaryContractSaveField.setRequired(true);
		februaryContractSaveField.setHidden(false);


		marchContractSaveField = new DataSourceFloatField("marchContractSave", "三月");
		marchContractSaveField.setLength(18);
		marchContractSaveField.setDecimalPad(2);
		marchContractSaveField.setFormat("#,###,###,###,###,##0.00");
		marchContractSaveField.setRequired(true);
		marchContractSaveField.setHidden(false);


		aprilContractSaveField = new DataSourceFloatField("aprilContractSave", "四月");
		aprilContractSaveField.setLength(18);
		aprilContractSaveField.setDecimalPad(2);
		aprilContractSaveField.setFormat("#,###,###,###,###,##0.00");
		aprilContractSaveField.setRequired(true);
		aprilContractSaveField.setHidden(false);


		mayContractSaveField = new DataSourceFloatField("mayContractSave", "五月");
		mayContractSaveField.setLength(18);
		mayContractSaveField.setDecimalPad(2);
		mayContractSaveField.setFormat("#,###,###,###,###,##0.00");
		mayContractSaveField.setRequired(true);
		mayContractSaveField.setHidden(false);


		juneContractSaveField = new DataSourceFloatField("juneContractSave", "六月");
		juneContractSaveField.setLength(18);
		juneContractSaveField.setDecimalPad(2);
		juneContractSaveField.setFormat("#,###,###,###,###,##0.00");
		juneContractSaveField.setRequired(true);
		juneContractSaveField.setHidden(false);


		julyContractSaveField = new DataSourceFloatField("julyContractSave", "七月");
		julyContractSaveField.setLength(18);
		julyContractSaveField.setDecimalPad(2);
		julyContractSaveField.setFormat("#,###,###,###,###,##0.00");
		julyContractSaveField.setRequired(true);
		julyContractSaveField.setHidden(false);


		augustContractSaveField = new DataSourceFloatField("augustContractSave", "八月");
		augustContractSaveField.setLength(18);
		augustContractSaveField.setDecimalPad(2);
		augustContractSaveField.setFormat("#,###,###,###,###,##0.00");
		augustContractSaveField.setRequired(true);
		augustContractSaveField.setHidden(false);


		septemberContractSaveField = new DataSourceFloatField("septemberContractSave", "九月");
		septemberContractSaveField.setLength(18);
		septemberContractSaveField.setDecimalPad(2);
		septemberContractSaveField.setFormat("#,###,###,###,###,##0.00");
		septemberContractSaveField.setRequired(true);
		septemberContractSaveField.setHidden(false);


		octoberContractSaveField = new DataSourceFloatField("octoberContractSave", "十月");
		octoberContractSaveField.setLength(18);
		octoberContractSaveField.setDecimalPad(2);
		octoberContractSaveField.setFormat("#,###,###,###,###,##0.00");
		octoberContractSaveField.setRequired(true);
		octoberContractSaveField.setHidden(false);


		novemberContractSaveField = new DataSourceFloatField("novemberContractSave", "十一月");
		novemberContractSaveField.setLength(18);
		novemberContractSaveField.setDecimalPad(2);
		novemberContractSaveField.setFormat("#,###,###,###,###,##0.00");
		novemberContractSaveField.setRequired(true);
		novemberContractSaveField.setHidden(false);


		decemberContractSaveField = new DataSourceFloatField("decemberContractSave", "十二月");
		decemberContractSaveField.setLength(18);
		decemberContractSaveField.setDecimalPad(2);
		decemberContractSaveField.setFormat("#,###,###,###,###,##0.00");
		decemberContractSaveField.setRequired(true);
		decemberContractSaveField.setHidden(false);
		
		totalField = new DataSourceFloatField("total", "合计");
		totalField.setLength(18);
		totalField.setDecimalPad(2);
		totalField.setFormat("#,###,###,###,###,##0.00");
		totalField.setRequired(true);
		totalField.setHidden(false);


		setFields(plateIdField, yearField, januaryContractSaveField, februaryContractSaveField, marchContractSaveField, aprilContractSaveField, mayContractSaveField, juneContractSaveField, julyContractSaveField, augustContractSaveField, septemberContractSaveField, octoberContractSaveField, novemberContractSaveField, decemberContractSaveField,totalField);
	}


}

