package com.pomplatform.client.contract.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSContractAmountAnalyze extends DBDataSource
{


	public static DSContractAmountAnalyze instance = null;

	public static DSContractAmountAnalyze getInstance() {
		if(instance == null) {
			instance = new DSContractAmountAnalyze("DSContractAmountAnalyze");
		}
		return instance;
	}

	private final DataSourceTextField plateIdField;
	private final DataSourceTextField contractYearField;
	private final DataSourceFloatField janAmountField;
	private final DataSourceFloatField febAmountField;
	private final DataSourceFloatField marAmountField;
	private final DataSourceFloatField aprAmountField;
	private final DataSourceFloatField mayAmountField;
	private final DataSourceFloatField junAmountField;
	private final DataSourceFloatField julAmountField;
	private final DataSourceFloatField augAmountField;
	private final DataSourceFloatField septAmountField;
	private final DataSourceFloatField octAmountField;
	private final DataSourceFloatField novAmountField;
	private final DataSourceFloatField decAmountField;
	private final DataSourceFloatField totalAmountField;

	public DSContractAmountAnalyze(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ContractAmountAnalyze");


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		contractYearField = new DataSourceTextField("contractYear", "年份");
		contractYearField.setLength(8);
		contractYearField.setRequired(true);
		contractYearField.setHidden(false);


		janAmountField = new DataSourceFloatField("janAmount", "一月");
		janAmountField.setLength(18);
		janAmountField.setDecimalPad(2);
		janAmountField.setFormat("#,###,###,###,###,##0.00");
		janAmountField.setRequired(true);
		janAmountField.setHidden(false);


		febAmountField = new DataSourceFloatField("febAmount", "二月");
		febAmountField.setLength(18);
		febAmountField.setDecimalPad(2);
		febAmountField.setFormat("#,###,###,###,###,##0.00");
		febAmountField.setRequired(true);
		febAmountField.setHidden(false);


		marAmountField = new DataSourceFloatField("marAmount", "三月");
		marAmountField.setLength(18);
		marAmountField.setDecimalPad(2);
		marAmountField.setFormat("#,###,###,###,###,##0.00");
		marAmountField.setRequired(true);
		marAmountField.setHidden(false);


		aprAmountField = new DataSourceFloatField("aprAmount", "四月");
		aprAmountField.setLength(18);
		aprAmountField.setDecimalPad(2);
		aprAmountField.setFormat("#,###,###,###,###,##0.00");
		aprAmountField.setRequired(true);
		aprAmountField.setHidden(false);


		mayAmountField = new DataSourceFloatField("mayAmount", "五月");
		mayAmountField.setLength(18);
		mayAmountField.setDecimalPad(2);
		mayAmountField.setFormat("#,###,###,###,###,##0.00");
		mayAmountField.setRequired(true);
		mayAmountField.setHidden(false);


		junAmountField = new DataSourceFloatField("junAmount", "六月");
		junAmountField.setLength(18);
		junAmountField.setDecimalPad(2);
		junAmountField.setFormat("#,###,###,###,###,##0.00");
		junAmountField.setRequired(true);
		junAmountField.setHidden(false);


		julAmountField = new DataSourceFloatField("julAmount", "七月");
		julAmountField.setLength(18);
		julAmountField.setDecimalPad(2);
		julAmountField.setFormat("#,###,###,###,###,##0.00");
		julAmountField.setRequired(true);
		julAmountField.setHidden(false);


		augAmountField = new DataSourceFloatField("augAmount", "八月");
		augAmountField.setLength(18);
		augAmountField.setDecimalPad(2);
		augAmountField.setFormat("#,###,###,###,###,##0.00");
		augAmountField.setRequired(true);
		augAmountField.setHidden(false);


		septAmountField = new DataSourceFloatField("septAmount", "九月");
		septAmountField.setLength(18);
		septAmountField.setDecimalPad(2);
		septAmountField.setFormat("#,###,###,###,###,##0.00");
		septAmountField.setRequired(true);
		septAmountField.setHidden(false);


		octAmountField = new DataSourceFloatField("octAmount", "十月");
		octAmountField.setLength(18);
		octAmountField.setDecimalPad(2);
		octAmountField.setFormat("#,###,###,###,###,##0.00");
		octAmountField.setRequired(true);
		octAmountField.setHidden(false);


		novAmountField = new DataSourceFloatField("novAmount", "十一月");
		novAmountField.setLength(18);
		novAmountField.setDecimalPad(2);
		novAmountField.setFormat("#,###,###,###,###,##0.00");
		novAmountField.setRequired(true);
		novAmountField.setHidden(false);


		decAmountField = new DataSourceFloatField("decAmount", "十二月");
		decAmountField.setLength(18);
		decAmountField.setDecimalPad(2);
		decAmountField.setFormat("#,###,###,###,###,##0.00");
		decAmountField.setRequired(true);
		decAmountField.setHidden(false);


		totalAmountField = new DataSourceFloatField("totalAmount", "合计");
		totalAmountField.setLength(18);
		totalAmountField.setDecimalPad(2);
		totalAmountField.setFormat("#,###,###,###,###,##0.00");
		totalAmountField.setRequired(false);
		totalAmountField.setHidden(false);


		setFields(plateIdField, contractYearField, janAmountField, febAmountField, marAmountField, aprAmountField, mayAmountField, junAmountField, julAmountField, augAmountField, septAmountField, octAmountField, novAmountField, decAmountField, totalAmountField);
	}


}

