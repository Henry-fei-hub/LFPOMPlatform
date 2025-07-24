package com.pomplatform.client.project.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;

import java.util.LinkedHashMap;

import com.delicacy.client.data.DBDataSource;

public class DSMprojecttrcccsyyyseyymmymmor extends DBDataSource
{


	public static DSMprojecttrcccsyyyseyymmymmor instance = null;

	public static DSMprojecttrcccsyyyseyymmymmor getInstance() {
		if(instance == null) {
			instance = new DSMprojecttrcccsyyyseyymmymmor("DSMprojecttrcccsyyyseyymmymmor");
		}
		return instance;
	}

	private final DataSourceIntegerField businessLineField;
	private final DataSourceFloatField sumSheetAmountField;
	private final DataSourceFloatField sumCurrentRevenueField;
	private final DataSourceTextField sumCurrentRevenueProportionField;
	private final DataSourceFloatField targetType1Field;
	private final DataSourceTextField targetStrType1Field;
	private final DataSourceTextField targetType1ProportionField;
	private final DataSourceIntegerField rank1Field;
	private final DataSourceTextField percentageComplete1Field;
	private final DataSourceFloatField sumDistributionAmountField;
	private final DataSourceFloatField targetType2Field;
	private final DataSourceTextField targetStrType2Field;
	private final DataSourceIntegerField rank2Field;
	private final DataSourceTextField percentageComplete2Field;
	private final DataSourceTextField back1Field;
	private final DataSourceTextField back2Field;
	private final DataSourceTextField back3Field;

	public DSMprojecttrcccsyyyseyymmymmor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mprojecttrcccsyyyseyymmymmor");


		businessLineField = new DataSourceIntegerField("businessLine", "业务条线");
		businessLineField.setLength(18);
		businessLineField.setRequired(false);
		businessLineField.setHidden(false);
		LinkedHashMap<String, String> valueMap = KeyValueManager.getValueMap("system_dictionary_205");
		valueMap.put("12", "合计");
		businessLineField.setValueMap(valueMap);


		sumSheetAmountField = new DataSourceFloatField("sumSheetAmount", "完成值");
		sumSheetAmountField.setLength(18);
		sumSheetAmountField.setDecimalPad(2);
		sumSheetAmountField.setFormat("#,###,###,###,###,##0.00");
		sumSheetAmountField.setRequired(true);
		sumSheetAmountField.setHidden(false);


		sumCurrentRevenueField = new DataSourceFloatField("sumCurrentRevenue", "完成值");
		sumCurrentRevenueField.setLength(18);
		sumCurrentRevenueField.setDecimalPad(2);
		sumCurrentRevenueField.setFormat("#,###,###,###,###,##0.00");
		sumCurrentRevenueField.setRequired(true);
		sumCurrentRevenueField.setHidden(false);


		sumCurrentRevenueProportionField = new DataSourceTextField("sumCurrentRevenueProportion", "完成值占比");
		sumCurrentRevenueProportionField.setLength(18);
		sumCurrentRevenueProportionField.setRequired(true);
		sumCurrentRevenueProportionField.setHidden(false);


		targetType1Field = new DataSourceFloatField("targetType1", "指标");
		targetType1Field.setLength(18);
		targetType1Field.setDecimalPad(2);
		targetType1Field.setFormat("##,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,##0.00");
		targetType1Field.setRequired(true);
		targetType1Field.setHidden(false);


		targetStrType1Field = new DataSourceTextField("targetStrType1", "指标");
		targetStrType1Field.setLength(18);
		targetStrType1Field.setRequired(true);
		targetStrType1Field.setHidden(true);


		targetType1ProportionField = new DataSourceTextField("targetType1Proportion", "指标占比");
		targetType1ProportionField.setLength(18);
		targetType1ProportionField.setRequired(true);
		targetType1ProportionField.setHidden(false);


		rank1Field = new DataSourceIntegerField("rank1", "排名");
		rank1Field.setLength(18);
		rank1Field.setRequired(true);
		rank1Field.setHidden(false);


		percentageComplete1Field = new DataSourceTextField("percentageComplete1", "完成率");
		percentageComplete1Field.setLength(18);
		percentageComplete1Field.setRequired(true);
		percentageComplete1Field.setHidden(false);


		sumDistributionAmountField = new DataSourceFloatField("sumDistributionAmount", "完成值");
		sumDistributionAmountField.setLength(18);
		sumDistributionAmountField.setDecimalPad(2);
		sumDistributionAmountField.setFormat("#,###,###,###,###,##0.00");
		sumDistributionAmountField.setRequired(true);
		sumDistributionAmountField.setHidden(false);


		targetType2Field = new DataSourceFloatField("targetType2", "指标");
		targetType2Field.setLength(18);
		targetType2Field.setDecimalPad(2);
		targetType2Field.setFormat("##,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,##0.00");
		targetType2Field.setRequired(true);
		targetType2Field.setHidden(false);


		targetStrType2Field = new DataSourceTextField("targetStrType2", "指标");
		targetStrType2Field.setLength(18);
		targetStrType2Field.setRequired(true);
		targetStrType2Field.setHidden(true);


		rank2Field = new DataSourceIntegerField("rank2", "排名");
		rank2Field.setLength(18);
		rank2Field.setRequired(true);
		rank2Field.setHidden(false);


		percentageComplete2Field = new DataSourceTextField("percentageComplete2", "完成率");
		percentageComplete2Field.setLength(18);
		percentageComplete2Field.setRequired(true);
		percentageComplete2Field.setHidden(false);


		back1Field = new DataSourceTextField("back1", "备用字段1");
		back1Field.setLength(18);
		back1Field.setRequired(true);
		back1Field.setHidden(true);


		back2Field = new DataSourceTextField("back2", "备用字段2");
		back2Field.setLength(18);
		back2Field.setRequired(true);
		back2Field.setHidden(true);


		back3Field = new DataSourceTextField("back3", "备用字段3");
		back3Field.setLength(18);
		back3Field.setRequired(true);
		back3Field.setHidden(true);


		setFields(businessLineField, sumSheetAmountField, sumCurrentRevenueField, sumCurrentRevenueProportionField, targetType1Field, targetStrType1Field, targetType1ProportionField, rank1Field, percentageComplete1Field, sumDistributionAmountField, targetType2Field, targetStrType2Field, rank2Field, percentageComplete2Field, back1Field, back2Field, back3Field);
	}


}

