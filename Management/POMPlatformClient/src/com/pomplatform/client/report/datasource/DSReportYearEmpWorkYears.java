package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSReportYearEmpWorkYears extends DBDataSource
{


	public static DSReportYearEmpWorkYears instance = null;

	public static DSReportYearEmpWorkYears getInstance() {
		if(instance == null) {
			instance = new DSReportYearEmpWorkYears("DSReportYearEmpWorkYears");
		}
		return instance;
	}

	private final DataSourceTextField plateIdField;
	private final DataSourceIntegerField oneInnerField;
	private final DataSourceTextField oneInnerPercentField;
	private final DataSourceIntegerField threeInnerField;
	private final DataSourceTextField threeInnerPercentField;
	private final DataSourceIntegerField fiveInnerField;
	private final DataSourceTextField fiveInnerPercentField;
	private final DataSourceIntegerField tenInnerField;
	private final DataSourceTextField tenInnerPercentField;
	private final DataSourceIntegerField tenAddField;
	private final DataSourceTextField tenAddPercentField;
	private final DataSourceIntegerField totalField;
	private final DataSourceIntegerField oneInnerTwoField;
	private final DataSourceTextField oneInnerPercentTwoField;
	private final DataSourceIntegerField threeInnerTwoField;
	private final DataSourceTextField threeInnerPercentTwoField;
	private final DataSourceIntegerField fiveInnerTwoField;
	private final DataSourceTextField fiveInnerPercentTwoField;
	private final DataSourceIntegerField tenInnerTwoField;
	private final DataSourceTextField tenInnerPercentTwoField;
	private final DataSourceIntegerField tenAddTwoField;
	private final DataSourceTextField tenAddPercentTwoField;
	private final DataSourceIntegerField totalTwoField;
	private final DataSourceIntegerField oneInnerThreeField;
	private final DataSourceTextField oneInnerPercentThreeField;
	private final DataSourceIntegerField threeInnerThreeField;
	private final DataSourceTextField threeInnerPercentThreeField;
	private final DataSourceIntegerField fiveInnerThreeField;
	private final DataSourceTextField fiveInnerPercentThreeField;
	private final DataSourceIntegerField tenInnerThreeField;
	private final DataSourceTextField tenInnerPercentThreeField;
	private final DataSourceIntegerField tenAddThreeField;
	private final DataSourceTextField tenAddPercentThreeField;
	private final DataSourceIntegerField totalThreeField;
	private final DataSourceIntegerField oneInnerFourField;
	private final DataSourceTextField oneInnerPercentFourField;
	private final DataSourceIntegerField threeInnerFourField;
	private final DataSourceTextField threeInnerPercentFourField;
	private final DataSourceIntegerField fiveInnerFourField;
	private final DataSourceTextField fiveInnerPercentFourField;
	private final DataSourceIntegerField tenInnerFourField;
	private final DataSourceTextField tenInnerPercentFourField;
	private final DataSourceIntegerField tenAddFourField;
	private final DataSourceTextField tenAddPercentFourField;
	private final DataSourceIntegerField totalFourField;
	private final DataSourceIntegerField oneInnerFiveField;
	private final DataSourceTextField oneInnerPercentFiveField;
	private final DataSourceIntegerField threeInnerFiveField;
	private final DataSourceTextField threeInnerPercentFiveField;
	private final DataSourceIntegerField fiveInnerFiveField;
	private final DataSourceTextField fiveInnerPercentFiveField;
	private final DataSourceIntegerField tenInnerFiveField;
	private final DataSourceTextField tenInnerPercentFiveField;
	private final DataSourceIntegerField tenAddFiveField;
	private final DataSourceTextField tenAddPercentFiveField;
	private final DataSourceIntegerField totalFiveField;
	private final DataSourceIntegerField oneInnerSixField;
	private final DataSourceTextField oneInnerPercentSixField;
	private final DataSourceIntegerField threeInnerSixField;
	private final DataSourceTextField threeInnerPercentSixField;
	private final DataSourceIntegerField fiveInnerSixField;
	private final DataSourceTextField fiveInnerPercentSixField;
	private final DataSourceIntegerField tenInnerSixField;
	private final DataSourceTextField tenInnerPercentSixField;
	private final DataSourceIntegerField tenAddSixField;
	private final DataSourceTextField tenAddPercentSixField;
	private final DataSourceIntegerField totalSixField;
	private final DataSourceIntegerField oneInnerSevenField;
	private final DataSourceTextField oneInnerPercentSevenField;
	private final DataSourceIntegerField threeInnerSevenField;
	private final DataSourceTextField threeInnerPercentSevenField;
	private final DataSourceIntegerField fiveInnerSevenField;
	private final DataSourceTextField fiveInnerPercentSevenField;
	private final DataSourceIntegerField tenInnerSevenField;
	private final DataSourceTextField tenInnerPercentSevenField;
	private final DataSourceIntegerField tenAddSevenField;
	private final DataSourceTextField tenAddPercentSevenField;
	private final DataSourceIntegerField totalSevenField;
	private final DataSourceIntegerField oneInnerEightField;
	private final DataSourceTextField oneInnerPercentEightField;
	private final DataSourceIntegerField threeInnerEightField;
	private final DataSourceTextField threeInnerPercentEightField;
	private final DataSourceIntegerField fiveInnerEightField;
	private final DataSourceTextField fiveInnerPercentEightField;
	private final DataSourceIntegerField tenInnerEightField;
	private final DataSourceTextField tenInnerPercentEightField;
	private final DataSourceIntegerField tenAddEightField;
	private final DataSourceTextField tenAddPercentEightField;
	private final DataSourceIntegerField totalEightField;
	private final DataSourceIntegerField oneInnerNineField;
	private final DataSourceTextField oneInnerPercentNineField;
	private final DataSourceIntegerField threeInnerNineField;
	private final DataSourceTextField threeInnerPercentNineField;
	private final DataSourceIntegerField fiveInnerNineField;
	private final DataSourceTextField fiveInnerPercentNineField;
	private final DataSourceIntegerField tenInnerNineField;
	private final DataSourceTextField tenInnerPercentNineField;
	private final DataSourceIntegerField tenAddNineField;
	private final DataSourceTextField tenAddPercentNineField;
	private final DataSourceIntegerField totalNineField;
	private final DataSourceIntegerField oneInnerTenField;
	private final DataSourceTextField oneInnerPercentTenField;
	private final DataSourceIntegerField threeInnerTenField;
	private final DataSourceTextField threeInnerPercentTenField;
	private final DataSourceIntegerField fiveInnerTenField;
	private final DataSourceTextField fiveInnerPercentTenField;
	private final DataSourceIntegerField tenInnerTenField;
	private final DataSourceTextField tenInnerPercentTenField;
	private final DataSourceIntegerField tenAddTenField;
	private final DataSourceTextField tenAddPercentTenField;
	private final DataSourceIntegerField totalTenField;
	private final DataSourceIntegerField oneInnerElevenField;
	private final DataSourceTextField oneInnerPercentElevenField;
	private final DataSourceIntegerField threeInnerElevenField;
	private final DataSourceTextField threeInnerPercentElevenField;
	private final DataSourceIntegerField fiveInnerElevenField;
	private final DataSourceTextField fiveInnerPercentElevenField;
	private final DataSourceIntegerField tenInnerElevenField;
	private final DataSourceTextField tenInnerPercentElevenField;
	private final DataSourceIntegerField tenAddElevenField;
	private final DataSourceTextField tenAddPercentElevenField;
	private final DataSourceIntegerField totalElevenField;
	private final DataSourceIntegerField oneInnerTwelfField;
	private final DataSourceTextField oneInnerPercentTwelfField;
	private final DataSourceIntegerField threeInnerTwelfField;
	private final DataSourceTextField threeInnerPercentTwelfField;
	private final DataSourceIntegerField fiveInnerTwelfField;
	private final DataSourceTextField fiveInnerPercentTwelfField;
	private final DataSourceIntegerField tenInnerTwelfField;
	private final DataSourceTextField tenInnerPercentTwelfField;
	private final DataSourceIntegerField tenAddTwelfField;
	private final DataSourceTextField tenAddPercentTwelfField;
	private final DataSourceIntegerField totalTwelfField;

	public DSReportYearEmpWorkYears(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("OnReportProcess");


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		oneInnerField = new DataSourceIntegerField("oneInner", "1年以下人数");
		oneInnerField.setLength(11);
		oneInnerField.setRequired(true);
		oneInnerField.setHidden(false);


		oneInnerPercentField = new DataSourceTextField("oneInnerPercent", "1年以下占比");
		oneInnerPercentField.setLength(11);
		oneInnerPercentField.setRequired(true);
		oneInnerPercentField.setHidden(false);


		threeInnerField = new DataSourceIntegerField("threeInner", "1~3年人数");
		threeInnerField.setLength(11);
		threeInnerField.setRequired(true);
		threeInnerField.setHidden(false);


		threeInnerPercentField = new DataSourceTextField("threeInnerPercent", "1~3年占比");
		threeInnerPercentField.setLength(11);
		threeInnerPercentField.setRequired(true);
		threeInnerPercentField.setHidden(false);


		fiveInnerField = new DataSourceIntegerField("fiveInner", "3~5年人数");
		fiveInnerField.setLength(11);
		fiveInnerField.setRequired(true);
		fiveInnerField.setHidden(false);


		fiveInnerPercentField = new DataSourceTextField("fiveInnerPercent", "3~5年占比");
		fiveInnerPercentField.setLength(11);
		fiveInnerPercentField.setRequired(true);
		fiveInnerPercentField.setHidden(false);


		tenInnerField = new DataSourceIntegerField("tenInner", "5~10年人数");
		tenInnerField.setLength(11);
		tenInnerField.setRequired(true);
		tenInnerField.setHidden(false);


		tenInnerPercentField = new DataSourceTextField("tenInnerPercent", "5~10年占比");
		tenInnerPercentField.setLength(11);
		tenInnerPercentField.setRequired(true);
		tenInnerPercentField.setHidden(false);


		tenAddField = new DataSourceIntegerField("tenAdd", "10年及以上人数");
		tenAddField.setLength(11);
		tenAddField.setRequired(true);
		tenAddField.setHidden(false);


		tenAddPercentField = new DataSourceTextField("tenAddPercent", "10年及以上占比");
		tenAddPercentField.setLength(11);
		tenAddPercentField.setRequired(true);
		tenAddPercentField.setHidden(false);


		totalField = new DataSourceIntegerField("total", "人数合计");
		totalField.setLength(11);
		totalField.setRequired(true);
		totalField.setHidden(false);


		oneInnerTwoField = new DataSourceIntegerField("oneInnerTwo", "1年以下人数");
		oneInnerTwoField.setLength(11);
		oneInnerTwoField.setRequired(true);
		oneInnerTwoField.setHidden(false);


		oneInnerPercentTwoField = new DataSourceTextField("oneInnerPercentTwo", "1年以下占比");
		oneInnerPercentTwoField.setLength(16);
		oneInnerPercentTwoField.setRequired(true);
		oneInnerPercentTwoField.setHidden(false);


		threeInnerTwoField = new DataSourceIntegerField("threeInnerTwo", "1~3年人数");
		threeInnerTwoField.setLength(11);
		threeInnerTwoField.setRequired(true);
		threeInnerTwoField.setHidden(false);


		threeInnerPercentTwoField = new DataSourceTextField("threeInnerPercentTwo", "1~3年占比");
		threeInnerPercentTwoField.setLength(16);
		threeInnerPercentTwoField.setRequired(true);
		threeInnerPercentTwoField.setHidden(false);


		fiveInnerTwoField = new DataSourceIntegerField("fiveInnerTwo", "3~5年人数");
		fiveInnerTwoField.setLength(11);
		fiveInnerTwoField.setRequired(true);
		fiveInnerTwoField.setHidden(false);


		fiveInnerPercentTwoField = new DataSourceTextField("fiveInnerPercentTwo", "3~5年占比");
		fiveInnerPercentTwoField.setLength(16);
		fiveInnerPercentTwoField.setRequired(true);
		fiveInnerPercentTwoField.setHidden(false);


		tenInnerTwoField = new DataSourceIntegerField("tenInnerTwo", "5~10年人数");
		tenInnerTwoField.setLength(11);
		tenInnerTwoField.setRequired(true);
		tenInnerTwoField.setHidden(false);


		tenInnerPercentTwoField = new DataSourceTextField("tenInnerPercentTwo", "5~10年占比");
		tenInnerPercentTwoField.setLength(16);
		tenInnerPercentTwoField.setRequired(true);
		tenInnerPercentTwoField.setHidden(false);


		tenAddTwoField = new DataSourceIntegerField("tenAddTwo", "10年及以上人数");
		tenAddTwoField.setLength(11);
		tenAddTwoField.setRequired(true);
		tenAddTwoField.setHidden(false);


		tenAddPercentTwoField = new DataSourceTextField("tenAddPercentTwo", "10年及以上占比");
		tenAddPercentTwoField.setLength(16);
		tenAddPercentTwoField.setRequired(true);
		tenAddPercentTwoField.setHidden(false);


		totalTwoField = new DataSourceIntegerField("totalTwo", "人数合计");
		totalTwoField.setLength(11);
		totalTwoField.setRequired(true);
		totalTwoField.setHidden(false);


		oneInnerThreeField = new DataSourceIntegerField("oneInnerThree", "1年以下人数");
		oneInnerThreeField.setLength(11);
		oneInnerThreeField.setRequired(true);
		oneInnerThreeField.setHidden(false);


		oneInnerPercentThreeField = new DataSourceTextField("oneInnerPercentThree", "1年以下占比");
		oneInnerPercentThreeField.setLength(16);
		oneInnerPercentThreeField.setRequired(true);
		oneInnerPercentThreeField.setHidden(false);


		threeInnerThreeField = new DataSourceIntegerField("threeInnerThree", "1~3年人数");
		threeInnerThreeField.setLength(11);
		threeInnerThreeField.setRequired(true);
		threeInnerThreeField.setHidden(false);


		threeInnerPercentThreeField = new DataSourceTextField("threeInnerPercentThree", "1~3年占比");
		threeInnerPercentThreeField.setLength(16);
		threeInnerPercentThreeField.setRequired(true);
		threeInnerPercentThreeField.setHidden(false);


		fiveInnerThreeField = new DataSourceIntegerField("fiveInnerThree", "3~5年人数");
		fiveInnerThreeField.setLength(11);
		fiveInnerThreeField.setRequired(true);
		fiveInnerThreeField.setHidden(false);


		fiveInnerPercentThreeField = new DataSourceTextField("fiveInnerPercentThree", "3~5年占比");
		fiveInnerPercentThreeField.setLength(16);
		fiveInnerPercentThreeField.setRequired(true);
		fiveInnerPercentThreeField.setHidden(false);


		tenInnerThreeField = new DataSourceIntegerField("tenInnerThree", "5~10年人数");
		tenInnerThreeField.setLength(11);
		tenInnerThreeField.setRequired(true);
		tenInnerThreeField.setHidden(false);


		tenInnerPercentThreeField = new DataSourceTextField("tenInnerPercentThree", "5~10年占比");
		tenInnerPercentThreeField.setLength(16);
		tenInnerPercentThreeField.setRequired(true);
		tenInnerPercentThreeField.setHidden(false);


		tenAddThreeField = new DataSourceIntegerField("tenAddThree", "10年及以上人数");
		tenAddThreeField.setLength(11);
		tenAddThreeField.setRequired(true);
		tenAddThreeField.setHidden(false);


		tenAddPercentThreeField = new DataSourceTextField("tenAddPercentThree", "10年及以上占比");
		tenAddPercentThreeField.setLength(16);
		tenAddPercentThreeField.setRequired(true);
		tenAddPercentThreeField.setHidden(false);


		totalThreeField = new DataSourceIntegerField("totalThree", "人数合计");
		totalThreeField.setLength(11);
		totalThreeField.setRequired(true);
		totalThreeField.setHidden(false);


		oneInnerFourField = new DataSourceIntegerField("oneInnerFour", "1年以下人数");
		oneInnerFourField.setLength(11);
		oneInnerFourField.setRequired(true);
		oneInnerFourField.setHidden(false);


		oneInnerPercentFourField = new DataSourceTextField("oneInnerPercentFour", "1年以下占比");
		oneInnerPercentFourField.setLength(16);
		oneInnerPercentFourField.setRequired(true);
		oneInnerPercentFourField.setHidden(false);


		threeInnerFourField = new DataSourceIntegerField("threeInnerFour", "1~3年人数");
		threeInnerFourField.setLength(11);
		threeInnerFourField.setRequired(true);
		threeInnerFourField.setHidden(false);


		threeInnerPercentFourField = new DataSourceTextField("threeInnerPercentFour", "1~3年占比");
		threeInnerPercentFourField.setLength(16);
		threeInnerPercentFourField.setRequired(true);
		threeInnerPercentFourField.setHidden(false);


		fiveInnerFourField = new DataSourceIntegerField("fiveInnerFour", "3~5年人数");
		fiveInnerFourField.setLength(11);
		fiveInnerFourField.setRequired(true);
		fiveInnerFourField.setHidden(false);


		fiveInnerPercentFourField = new DataSourceTextField("fiveInnerPercentFour", "3~5年占比");
		fiveInnerPercentFourField.setLength(16);
		fiveInnerPercentFourField.setRequired(true);
		fiveInnerPercentFourField.setHidden(false);


		tenInnerFourField = new DataSourceIntegerField("tenInnerFour", "5~10年人数");
		tenInnerFourField.setLength(11);
		tenInnerFourField.setRequired(true);
		tenInnerFourField.setHidden(false);


		tenInnerPercentFourField = new DataSourceTextField("tenInnerPercentFour", "5~10年占比");
		tenInnerPercentFourField.setLength(16);
		tenInnerPercentFourField.setRequired(true);
		tenInnerPercentFourField.setHidden(false);


		tenAddFourField = new DataSourceIntegerField("tenAddFour", "10年及以上人数");
		tenAddFourField.setLength(11);
		tenAddFourField.setRequired(true);
		tenAddFourField.setHidden(false);


		tenAddPercentFourField = new DataSourceTextField("tenAddPercentFour", "10年及以上占比");
		tenAddPercentFourField.setLength(16);
		tenAddPercentFourField.setRequired(true);
		tenAddPercentFourField.setHidden(false);


		totalFourField = new DataSourceIntegerField("totalFour", "人数合计");
		totalFourField.setLength(11);
		totalFourField.setRequired(true);
		totalFourField.setHidden(false);


		oneInnerFiveField = new DataSourceIntegerField("oneInnerFive", "1年以下人数");
		oneInnerFiveField.setLength(11);
		oneInnerFiveField.setRequired(true);
		oneInnerFiveField.setHidden(false);


		oneInnerPercentFiveField = new DataSourceTextField("oneInnerPercentFive", "1年以下占比");
		oneInnerPercentFiveField.setLength(16);
		oneInnerPercentFiveField.setRequired(true);
		oneInnerPercentFiveField.setHidden(false);


		threeInnerFiveField = new DataSourceIntegerField("threeInnerFive", "1~3年人数");
		threeInnerFiveField.setLength(11);
		threeInnerFiveField.setRequired(true);
		threeInnerFiveField.setHidden(false);


		threeInnerPercentFiveField = new DataSourceTextField("threeInnerPercentFive", "1~3年占比");
		threeInnerPercentFiveField.setLength(16);
		threeInnerPercentFiveField.setRequired(true);
		threeInnerPercentFiveField.setHidden(false);


		fiveInnerFiveField = new DataSourceIntegerField("fiveInnerFive", "3~5年人数");
		fiveInnerFiveField.setLength(11);
		fiveInnerFiveField.setRequired(true);
		fiveInnerFiveField.setHidden(false);


		fiveInnerPercentFiveField = new DataSourceTextField("fiveInnerPercentFive", "3~5年占比");
		fiveInnerPercentFiveField.setLength(16);
		fiveInnerPercentFiveField.setRequired(true);
		fiveInnerPercentFiveField.setHidden(false);


		tenInnerFiveField = new DataSourceIntegerField("tenInnerFive", "5~10年人数");
		tenInnerFiveField.setLength(11);
		tenInnerFiveField.setRequired(true);
		tenInnerFiveField.setHidden(false);


		tenInnerPercentFiveField = new DataSourceTextField("tenInnerPercentFive", "5~10年占比");
		tenInnerPercentFiveField.setLength(16);
		tenInnerPercentFiveField.setRequired(true);
		tenInnerPercentFiveField.setHidden(false);


		tenAddFiveField = new DataSourceIntegerField("tenAddFive", "10年及以上人数");
		tenAddFiveField.setLength(11);
		tenAddFiveField.setRequired(true);
		tenAddFiveField.setHidden(false);


		tenAddPercentFiveField = new DataSourceTextField("tenAddPercentFive", "10年及以上占比");
		tenAddPercentFiveField.setLength(16);
		tenAddPercentFiveField.setRequired(true);
		tenAddPercentFiveField.setHidden(false);


		totalFiveField = new DataSourceIntegerField("totalFive", "人数合计");
		totalFiveField.setLength(11);
		totalFiveField.setRequired(true);
		totalFiveField.setHidden(false);


		oneInnerSixField = new DataSourceIntegerField("oneInnerSix", "1年以下人数");
		oneInnerSixField.setLength(11);
		oneInnerSixField.setRequired(true);
		oneInnerSixField.setHidden(false);


		oneInnerPercentSixField = new DataSourceTextField("oneInnerPercentSix", "1年以下占比");
		oneInnerPercentSixField.setLength(16);
		oneInnerPercentSixField.setRequired(true);
		oneInnerPercentSixField.setHidden(false);


		threeInnerSixField = new DataSourceIntegerField("threeInnerSix", "1~3年人数");
		threeInnerSixField.setLength(11);
		threeInnerSixField.setRequired(true);
		threeInnerSixField.setHidden(false);


		threeInnerPercentSixField = new DataSourceTextField("threeInnerPercentSix", "1~3年占比");
		threeInnerPercentSixField.setLength(16);
		threeInnerPercentSixField.setRequired(true);
		threeInnerPercentSixField.setHidden(false);


		fiveInnerSixField = new DataSourceIntegerField("fiveInnerSix", "3~5年人数");
		fiveInnerSixField.setLength(11);
		fiveInnerSixField.setRequired(true);
		fiveInnerSixField.setHidden(false);


		fiveInnerPercentSixField = new DataSourceTextField("fiveInnerPercentSix", "3~5年占比");
		fiveInnerPercentSixField.setLength(16);
		fiveInnerPercentSixField.setRequired(true);
		fiveInnerPercentSixField.setHidden(false);


		tenInnerSixField = new DataSourceIntegerField("tenInnerSix", "5~10年人数");
		tenInnerSixField.setLength(11);
		tenInnerSixField.setRequired(true);
		tenInnerSixField.setHidden(false);


		tenInnerPercentSixField = new DataSourceTextField("tenInnerPercentSix", "5~10年占比");
		tenInnerPercentSixField.setLength(16);
		tenInnerPercentSixField.setRequired(true);
		tenInnerPercentSixField.setHidden(false);


		tenAddSixField = new DataSourceIntegerField("tenAddSix", "10年及以上人数");
		tenAddSixField.setLength(11);
		tenAddSixField.setRequired(true);
		tenAddSixField.setHidden(false);


		tenAddPercentSixField = new DataSourceTextField("tenAddPercentSix", "10年及以上占比");
		tenAddPercentSixField.setLength(16);
		tenAddPercentSixField.setRequired(true);
		tenAddPercentSixField.setHidden(false);


		totalSixField = new DataSourceIntegerField("totalSix", "人数合计");
		totalSixField.setLength(11);
		totalSixField.setRequired(true);
		totalSixField.setHidden(false);


		oneInnerSevenField = new DataSourceIntegerField("oneInnerSeven", "1年以下人数");
		oneInnerSevenField.setLength(11);
		oneInnerSevenField.setRequired(true);
		oneInnerSevenField.setHidden(false);


		oneInnerPercentSevenField = new DataSourceTextField("oneInnerPercentSeven", "1年以下占比");
		oneInnerPercentSevenField.setLength(16);
		oneInnerPercentSevenField.setRequired(true);
		oneInnerPercentSevenField.setHidden(false);


		threeInnerSevenField = new DataSourceIntegerField("threeInnerSeven", "1~3年人数");
		threeInnerSevenField.setLength(11);
		threeInnerSevenField.setRequired(true);
		threeInnerSevenField.setHidden(false);


		threeInnerPercentSevenField = new DataSourceTextField("threeInnerPercentSeven", "1~3年占比");
		threeInnerPercentSevenField.setLength(16);
		threeInnerPercentSevenField.setRequired(true);
		threeInnerPercentSevenField.setHidden(false);


		fiveInnerSevenField = new DataSourceIntegerField("fiveInnerSeven", "3~5年人数");
		fiveInnerSevenField.setLength(11);
		fiveInnerSevenField.setRequired(true);
		fiveInnerSevenField.setHidden(false);


		fiveInnerPercentSevenField = new DataSourceTextField("fiveInnerPercentSeven", "3~5年占比");
		fiveInnerPercentSevenField.setLength(16);
		fiveInnerPercentSevenField.setRequired(true);
		fiveInnerPercentSevenField.setHidden(false);


		tenInnerSevenField = new DataSourceIntegerField("tenInnerSeven", "5~10年人数");
		tenInnerSevenField.setLength(11);
		tenInnerSevenField.setRequired(true);
		tenInnerSevenField.setHidden(false);


		tenInnerPercentSevenField = new DataSourceTextField("tenInnerPercentSeven", "5~10年占比");
		tenInnerPercentSevenField.setLength(16);
		tenInnerPercentSevenField.setRequired(true);
		tenInnerPercentSevenField.setHidden(false);


		tenAddSevenField = new DataSourceIntegerField("tenAddSeven", "10年及以上人数");
		tenAddSevenField.setLength(11);
		tenAddSevenField.setRequired(true);
		tenAddSevenField.setHidden(false);


		tenAddPercentSevenField = new DataSourceTextField("tenAddPercentSeven", "10年及以上占比");
		tenAddPercentSevenField.setLength(16);
		tenAddPercentSevenField.setRequired(true);
		tenAddPercentSevenField.setHidden(false);


		totalSevenField = new DataSourceIntegerField("totalSeven", "人数合计");
		totalSevenField.setLength(11);
		totalSevenField.setRequired(true);
		totalSevenField.setHidden(false);


		oneInnerEightField = new DataSourceIntegerField("oneInnerEight", "1年以下人数");
		oneInnerEightField.setLength(11);
		oneInnerEightField.setRequired(true);
		oneInnerEightField.setHidden(false);


		oneInnerPercentEightField = new DataSourceTextField("oneInnerPercentEight", "1年以下占比");
		oneInnerPercentEightField.setLength(16);
		oneInnerPercentEightField.setRequired(true);
		oneInnerPercentEightField.setHidden(false);


		threeInnerEightField = new DataSourceIntegerField("threeInnerEight", "1~3年人数");
		threeInnerEightField.setLength(11);
		threeInnerEightField.setRequired(true);
		threeInnerEightField.setHidden(false);


		threeInnerPercentEightField = new DataSourceTextField("threeInnerPercentEight", "1~3年占比");
		threeInnerPercentEightField.setLength(16);
		threeInnerPercentEightField.setRequired(true);
		threeInnerPercentEightField.setHidden(false);


		fiveInnerEightField = new DataSourceIntegerField("fiveInnerEight", "3~5年人数");
		fiveInnerEightField.setLength(11);
		fiveInnerEightField.setRequired(true);
		fiveInnerEightField.setHidden(false);


		fiveInnerPercentEightField = new DataSourceTextField("fiveInnerPercentEight", "3~5年占比");
		fiveInnerPercentEightField.setLength(16);
		fiveInnerPercentEightField.setRequired(true);
		fiveInnerPercentEightField.setHidden(false);


		tenInnerEightField = new DataSourceIntegerField("tenInnerEight", "5~10年人数");
		tenInnerEightField.setLength(11);
		tenInnerEightField.setRequired(true);
		tenInnerEightField.setHidden(false);


		tenInnerPercentEightField = new DataSourceTextField("tenInnerPercentEight", "5~10年占比");
		tenInnerPercentEightField.setLength(16);
		tenInnerPercentEightField.setRequired(true);
		tenInnerPercentEightField.setHidden(false);


		tenAddEightField = new DataSourceIntegerField("tenAddEight", "10年及以上人数");
		tenAddEightField.setLength(11);
		tenAddEightField.setRequired(true);
		tenAddEightField.setHidden(false);


		tenAddPercentEightField = new DataSourceTextField("tenAddPercentEight", "10年及以上占比");
		tenAddPercentEightField.setLength(16);
		tenAddPercentEightField.setRequired(true);
		tenAddPercentEightField.setHidden(false);


		totalEightField = new DataSourceIntegerField("totalEight", "人数合计");
		totalEightField.setLength(11);
		totalEightField.setRequired(true);
		totalEightField.setHidden(false);


		oneInnerNineField = new DataSourceIntegerField("oneInnerNine", "1年以下人数");
		oneInnerNineField.setLength(11);
		oneInnerNineField.setRequired(true);
		oneInnerNineField.setHidden(false);


		oneInnerPercentNineField = new DataSourceTextField("oneInnerPercentNine", "1年以下占比");
		oneInnerPercentNineField.setLength(16);
		oneInnerPercentNineField.setRequired(true);
		oneInnerPercentNineField.setHidden(false);


		threeInnerNineField = new DataSourceIntegerField("threeInnerNine", "1~3年人数");
		threeInnerNineField.setLength(11);
		threeInnerNineField.setRequired(true);
		threeInnerNineField.setHidden(false);


		threeInnerPercentNineField = new DataSourceTextField("threeInnerPercentNine", "1~3年占比");
		threeInnerPercentNineField.setLength(16);
		threeInnerPercentNineField.setRequired(true);
		threeInnerPercentNineField.setHidden(false);


		fiveInnerNineField = new DataSourceIntegerField("fiveInnerNine", "3~5年人数");
		fiveInnerNineField.setLength(11);
		fiveInnerNineField.setRequired(true);
		fiveInnerNineField.setHidden(false);


		fiveInnerPercentNineField = new DataSourceTextField("fiveInnerPercentNine", "3~5年占比");
		fiveInnerPercentNineField.setLength(16);
		fiveInnerPercentNineField.setRequired(true);
		fiveInnerPercentNineField.setHidden(false);


		tenInnerNineField = new DataSourceIntegerField("tenInnerNine", "5~10年人数");
		tenInnerNineField.setLength(11);
		tenInnerNineField.setRequired(true);
		tenInnerNineField.setHidden(false);


		tenInnerPercentNineField = new DataSourceTextField("tenInnerPercentNine", "5~10年占比");
		tenInnerPercentNineField.setLength(16);
		tenInnerPercentNineField.setRequired(true);
		tenInnerPercentNineField.setHidden(false);


		tenAddNineField = new DataSourceIntegerField("tenAddNine", "10年及以上人数");
		tenAddNineField.setLength(11);
		tenAddNineField.setRequired(true);
		tenAddNineField.setHidden(false);


		tenAddPercentNineField = new DataSourceTextField("tenAddPercentNine", "10年及以上占比");
		tenAddPercentNineField.setLength(16);
		tenAddPercentNineField.setRequired(true);
		tenAddPercentNineField.setHidden(false);


		totalNineField = new DataSourceIntegerField("totalNine", "人数合计");
		totalNineField.setLength(11);
		totalNineField.setRequired(true);
		totalNineField.setHidden(false);


		oneInnerTenField = new DataSourceIntegerField("oneInnerTen", "1年以下人数");
		oneInnerTenField.setLength(11);
		oneInnerTenField.setRequired(true);
		oneInnerTenField.setHidden(false);


		oneInnerPercentTenField = new DataSourceTextField("oneInnerPercentTen", "1年以下占比");
		oneInnerPercentTenField.setLength(16);
		oneInnerPercentTenField.setRequired(true);
		oneInnerPercentTenField.setHidden(false);


		threeInnerTenField = new DataSourceIntegerField("threeInnerTen", "1~3年人数");
		threeInnerTenField.setLength(11);
		threeInnerTenField.setRequired(true);
		threeInnerTenField.setHidden(false);


		threeInnerPercentTenField = new DataSourceTextField("threeInnerPercentTen", "1~3年占比");
		threeInnerPercentTenField.setLength(16);
		threeInnerPercentTenField.setRequired(true);
		threeInnerPercentTenField.setHidden(false);


		fiveInnerTenField = new DataSourceIntegerField("fiveInnerTen", "3~5年人数");
		fiveInnerTenField.setLength(11);
		fiveInnerTenField.setRequired(true);
		fiveInnerTenField.setHidden(false);


		fiveInnerPercentTenField = new DataSourceTextField("fiveInnerPercentTen", "3~5年占比");
		fiveInnerPercentTenField.setLength(16);
		fiveInnerPercentTenField.setRequired(true);
		fiveInnerPercentTenField.setHidden(false);


		tenInnerTenField = new DataSourceIntegerField("tenInnerTen", "5~10年人数");
		tenInnerTenField.setLength(11);
		tenInnerTenField.setRequired(true);
		tenInnerTenField.setHidden(false);


		tenInnerPercentTenField = new DataSourceTextField("tenInnerPercentTen", "5~10年占比");
		tenInnerPercentTenField.setLength(16);
		tenInnerPercentTenField.setRequired(true);
		tenInnerPercentTenField.setHidden(false);


		tenAddTenField = new DataSourceIntegerField("tenAddTen", "10年及以上人数");
		tenAddTenField.setLength(11);
		tenAddTenField.setRequired(true);
		tenAddTenField.setHidden(false);


		tenAddPercentTenField = new DataSourceTextField("tenAddPercentTen", "10年及以上占比");
		tenAddPercentTenField.setLength(16);
		tenAddPercentTenField.setRequired(true);
		tenAddPercentTenField.setHidden(false);


		totalTenField = new DataSourceIntegerField("totalTen", "人数合计");
		totalTenField.setLength(11);
		totalTenField.setRequired(true);
		totalTenField.setHidden(false);


		oneInnerElevenField = new DataSourceIntegerField("oneInnerEleven", "1年以下人数");
		oneInnerElevenField.setLength(11);
		oneInnerElevenField.setRequired(true);
		oneInnerElevenField.setHidden(false);


		oneInnerPercentElevenField = new DataSourceTextField("oneInnerPercentEleven", "1年以下占比");
		oneInnerPercentElevenField.setLength(16);
		oneInnerPercentElevenField.setRequired(true);
		oneInnerPercentElevenField.setHidden(false);


		threeInnerElevenField = new DataSourceIntegerField("threeInnerEleven", "1~3年人数");
		threeInnerElevenField.setLength(11);
		threeInnerElevenField.setRequired(true);
		threeInnerElevenField.setHidden(false);


		threeInnerPercentElevenField = new DataSourceTextField("threeInnerPercentEleven", "1~3年占比");
		threeInnerPercentElevenField.setLength(16);
		threeInnerPercentElevenField.setRequired(true);
		threeInnerPercentElevenField.setHidden(false);


		fiveInnerElevenField = new DataSourceIntegerField("fiveInnerEleven", "3~5年人数");
		fiveInnerElevenField.setLength(11);
		fiveInnerElevenField.setRequired(true);
		fiveInnerElevenField.setHidden(false);


		fiveInnerPercentElevenField = new DataSourceTextField("fiveInnerPercentEleven", "3~5年占比");
		fiveInnerPercentElevenField.setLength(16);
		fiveInnerPercentElevenField.setRequired(true);
		fiveInnerPercentElevenField.setHidden(false);


		tenInnerElevenField = new DataSourceIntegerField("tenInnerEleven", "5~10年人数");
		tenInnerElevenField.setLength(11);
		tenInnerElevenField.setRequired(true);
		tenInnerElevenField.setHidden(false);


		tenInnerPercentElevenField = new DataSourceTextField("tenInnerPercentEleven", "5~10年占比");
		tenInnerPercentElevenField.setLength(16);
		tenInnerPercentElevenField.setRequired(true);
		tenInnerPercentElevenField.setHidden(false);


		tenAddElevenField = new DataSourceIntegerField("tenAddEleven", "10年及以上人数");
		tenAddElevenField.setLength(11);
		tenAddElevenField.setRequired(true);
		tenAddElevenField.setHidden(false);


		tenAddPercentElevenField = new DataSourceTextField("tenAddPercentEleven", "10年及以上占比");
		tenAddPercentElevenField.setLength(16);
		tenAddPercentElevenField.setRequired(true);
		tenAddPercentElevenField.setHidden(false);


		totalElevenField = new DataSourceIntegerField("totalEleven", "人数合计");
		totalElevenField.setLength(11);
		totalElevenField.setRequired(true);
		totalElevenField.setHidden(false);


		oneInnerTwelfField = new DataSourceIntegerField("oneInnerTwelf", "1年以下人数");
		oneInnerTwelfField.setLength(11);
		oneInnerTwelfField.setRequired(true);
		oneInnerTwelfField.setHidden(false);


		oneInnerPercentTwelfField = new DataSourceTextField("oneInnerPercentTwelf", "1年以下占比");
		oneInnerPercentTwelfField.setLength(16);
		oneInnerPercentTwelfField.setRequired(true);
		oneInnerPercentTwelfField.setHidden(false);


		threeInnerTwelfField = new DataSourceIntegerField("threeInnerTwelf", "1~3年人数");
		threeInnerTwelfField.setLength(11);
		threeInnerTwelfField.setRequired(true);
		threeInnerTwelfField.setHidden(false);


		threeInnerPercentTwelfField = new DataSourceTextField("threeInnerPercentTwelf", "1~3年占比");
		threeInnerPercentTwelfField.setLength(16);
		threeInnerPercentTwelfField.setRequired(true);
		threeInnerPercentTwelfField.setHidden(false);


		fiveInnerTwelfField = new DataSourceIntegerField("fiveInnerTwelf", "3~5年人数");
		fiveInnerTwelfField.setLength(11);
		fiveInnerTwelfField.setRequired(true);
		fiveInnerTwelfField.setHidden(false);


		fiveInnerPercentTwelfField = new DataSourceTextField("fiveInnerPercentTwelf", "3~5年占比");
		fiveInnerPercentTwelfField.setLength(16);
		fiveInnerPercentTwelfField.setRequired(true);
		fiveInnerPercentTwelfField.setHidden(false);


		tenInnerTwelfField = new DataSourceIntegerField("tenInnerTwelf", "5~10年人数");
		tenInnerTwelfField.setLength(11);
		tenInnerTwelfField.setRequired(true);
		tenInnerTwelfField.setHidden(false);


		tenInnerPercentTwelfField = new DataSourceTextField("tenInnerPercentTwelf", "5~10年占比");
		tenInnerPercentTwelfField.setLength(16);
		tenInnerPercentTwelfField.setRequired(true);
		tenInnerPercentTwelfField.setHidden(false);


		tenAddTwelfField = new DataSourceIntegerField("tenAddTwelf", "10年及以上人数");
		tenAddTwelfField.setLength(11);
		tenAddTwelfField.setRequired(true);
		tenAddTwelfField.setHidden(false);


		tenAddPercentTwelfField = new DataSourceTextField("tenAddPercentTwelf", "10年及以上占比");
		tenAddPercentTwelfField.setLength(16);
		tenAddPercentTwelfField.setRequired(true);
		tenAddPercentTwelfField.setHidden(false);


		totalTwelfField = new DataSourceIntegerField("totalTwelf", "人数合计");
		totalTwelfField.setLength(11);
		totalTwelfField.setRequired(true);
		totalTwelfField.setHidden(false);


		setFields(plateIdField, oneInnerField, oneInnerPercentField, threeInnerField, threeInnerPercentField, fiveInnerField, fiveInnerPercentField, tenInnerField, tenInnerPercentField, tenAddField, tenAddPercentField, totalField, oneInnerTwoField, oneInnerPercentTwoField, threeInnerTwoField, threeInnerPercentTwoField, fiveInnerTwoField, fiveInnerPercentTwoField, tenInnerTwoField, tenInnerPercentTwoField, tenAddTwoField, tenAddPercentTwoField, totalTwoField, oneInnerThreeField, oneInnerPercentThreeField, threeInnerThreeField, threeInnerPercentThreeField, fiveInnerThreeField, fiveInnerPercentThreeField, tenInnerThreeField, tenInnerPercentThreeField, tenAddThreeField, tenAddPercentThreeField, totalThreeField, oneInnerFourField, oneInnerPercentFourField, threeInnerFourField, threeInnerPercentFourField, fiveInnerFourField, fiveInnerPercentFourField, tenInnerFourField, tenInnerPercentFourField, tenAddFourField, tenAddPercentFourField, totalFourField, oneInnerFiveField, oneInnerPercentFiveField, threeInnerFiveField, threeInnerPercentFiveField, fiveInnerFiveField, fiveInnerPercentFiveField, tenInnerFiveField, tenInnerPercentFiveField, tenAddFiveField, tenAddPercentFiveField, totalFiveField, oneInnerSixField, oneInnerPercentSixField, threeInnerSixField, threeInnerPercentSixField, fiveInnerSixField, fiveInnerPercentSixField, tenInnerSixField, tenInnerPercentSixField, tenAddSixField, tenAddPercentSixField, totalSixField, oneInnerSevenField, oneInnerPercentSevenField, threeInnerSevenField, threeInnerPercentSevenField, fiveInnerSevenField, fiveInnerPercentSevenField, tenInnerSevenField, tenInnerPercentSevenField, tenAddSevenField, tenAddPercentSevenField, totalSevenField, oneInnerEightField, oneInnerPercentEightField, threeInnerEightField, threeInnerPercentEightField, fiveInnerEightField, fiveInnerPercentEightField, tenInnerEightField, tenInnerPercentEightField, tenAddEightField, tenAddPercentEightField, totalEightField, oneInnerNineField, oneInnerPercentNineField, threeInnerNineField, threeInnerPercentNineField, fiveInnerNineField, fiveInnerPercentNineField, tenInnerNineField, tenInnerPercentNineField, tenAddNineField, tenAddPercentNineField, totalNineField, oneInnerTenField, oneInnerPercentTenField, threeInnerTenField, threeInnerPercentTenField, fiveInnerTenField, fiveInnerPercentTenField, tenInnerTenField, tenInnerPercentTenField, tenAddTenField, tenAddPercentTenField, totalTenField, oneInnerElevenField, oneInnerPercentElevenField, threeInnerElevenField, threeInnerPercentElevenField, fiveInnerElevenField, fiveInnerPercentElevenField, tenInnerElevenField, tenInnerPercentElevenField, tenAddElevenField, tenAddPercentElevenField, totalElevenField, oneInnerTwelfField, oneInnerPercentTwelfField, threeInnerTwelfField, threeInnerPercentTwelfField, fiveInnerTwelfField, fiveInnerPercentTwelfField, tenInnerTwelfField, tenInnerPercentTwelfField, tenAddTwelfField, tenAddPercentTwelfField, totalTwelfField);
	}


}

