package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSCollectionrevenueanalysis extends DBDataSource
{


	public static DSCollectionrevenueanalysis instance = null;

	public static DSCollectionrevenueanalysis getInstance() {
		if(instance == null) {
			instance = new DSCollectionrevenueanalysis("DSCollectionrevenueanalysis");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField yearField;
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
	private final DataSourceFloatField totalField;
	private final DataSourceFloatField januaryAmountField;
	private final DataSourceFloatField februaryAmountField;
	private final DataSourceFloatField marchAmountField;
	private final DataSourceFloatField aprilAmountField;
	private final DataSourceFloatField mayAmountField;
	private final DataSourceFloatField juneAmountField;
	private final DataSourceFloatField julyAmountField;
	private final DataSourceFloatField augustAmountField;
	private final DataSourceFloatField septemberAmountField;
	private final DataSourceFloatField octoberAmountField;
	private final DataSourceFloatField novemberAmountField;
	private final DataSourceFloatField decemberAmountField;
	private final DataSourceFloatField januaryLeftField;
	private final DataSourceFloatField februaryLeftField;
	private final DataSourceFloatField marchLeftField;
	private final DataSourceFloatField aprilLeftField;
	private final DataSourceFloatField mayLeftField;
	private final DataSourceFloatField juneLeftField;
	private final DataSourceFloatField julyLeftField;
	private final DataSourceFloatField augustLeftField;
	private final DataSourceFloatField septemberLeftField;
	private final DataSourceFloatField octoberLeftField;
	private final DataSourceFloatField novemberLeftField;
	private final DataSourceFloatField decemberLeftField;
	private final DataSourceFloatField totalAmountField;
	private final DataSourceFloatField totalLeftField;
	private final DataSourceTextField str1Field;
	private final DataSourceTextField str2Field;
	private final DataSourceTextField str3Field;
	private final DataSourceTextField str4Field;
	private final DataSourceTextField str5Field;
	private final DataSourceTextField str6Field;
	private final DataSourceTextField str7Field;
	private final DataSourceTextField str8Field;
	private final DataSourceTextField str9Field;
	private final DataSourceTextField str10Field;
	private final DataSourceTextField str11Field;
	private final DataSourceTextField str12Field;
	private final DataSourceTextField strField;

	public DSCollectionrevenueanalysis(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Collectionrevenueanalysis");


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);


		januaryRevenueField = new DataSourceFloatField("januaryRevenue", "1月营收");
		januaryRevenueField.setLength(18);
		januaryRevenueField.setDecimalPad(2);
		januaryRevenueField.setFormat("#,###,###,###,###,##0.00");
		januaryRevenueField.setRequired(false);
		januaryRevenueField.setHidden(false);


		februaryRevenueField = new DataSourceFloatField("februaryRevenue", "2月营收");
		februaryRevenueField.setLength(18);
		februaryRevenueField.setDecimalPad(2);
		februaryRevenueField.setFormat("#,###,###,###,###,##0.00");
		februaryRevenueField.setRequired(false);
		februaryRevenueField.setHidden(false);


		marchRevenueField = new DataSourceFloatField("marchRevenue", "3月营收");
		marchRevenueField.setLength(18);
		marchRevenueField.setDecimalPad(2);
		marchRevenueField.setFormat("#,###,###,###,###,##0.00");
		marchRevenueField.setRequired(false);
		marchRevenueField.setHidden(false);


		aprilRevenueField = new DataSourceFloatField("aprilRevenue", "4月营收");
		aprilRevenueField.setLength(18);
		aprilRevenueField.setDecimalPad(2);
		aprilRevenueField.setFormat("#,###,###,###,###,##0.00");
		aprilRevenueField.setRequired(false);
		aprilRevenueField.setHidden(false);


		mayRevenueField = new DataSourceFloatField("mayRevenue", "5月营收");
		mayRevenueField.setLength(18);
		mayRevenueField.setDecimalPad(2);
		mayRevenueField.setFormat("#,###,###,###,###,##0.00");
		mayRevenueField.setRequired(false);
		mayRevenueField.setHidden(false);


		juneRevenueField = new DataSourceFloatField("juneRevenue", "6月营收");
		juneRevenueField.setLength(18);
		juneRevenueField.setDecimalPad(2);
		juneRevenueField.setFormat("#,###,###,###,###,##0.00");
		juneRevenueField.setRequired(false);
		juneRevenueField.setHidden(false);


		julyRevenueField = new DataSourceFloatField("julyRevenue", "7月营收");
		julyRevenueField.setLength(18);
		julyRevenueField.setDecimalPad(2);
		julyRevenueField.setFormat("#,###,###,###,###,##0.00");
		julyRevenueField.setRequired(false);
		julyRevenueField.setHidden(false);


		augustRevenueField = new DataSourceFloatField("augustRevenue", "8月营收");
		augustRevenueField.setLength(18);
		augustRevenueField.setDecimalPad(2);
		augustRevenueField.setFormat("#,###,###,###,###,##0.00");
		augustRevenueField.setRequired(false);
		augustRevenueField.setHidden(false);


		septemberRevenueField = new DataSourceFloatField("septemberRevenue", "9月营收");
		septemberRevenueField.setLength(18);
		septemberRevenueField.setDecimalPad(2);
		septemberRevenueField.setFormat("#,###,###,###,###,##0.00");
		septemberRevenueField.setRequired(false);
		septemberRevenueField.setHidden(false);


		octoberRevenueField = new DataSourceFloatField("octoberRevenue", "10月营收");
		octoberRevenueField.setLength(18);
		octoberRevenueField.setDecimalPad(2);
		octoberRevenueField.setFormat("#,###,###,###,###,##0.00");
		octoberRevenueField.setRequired(false);
		octoberRevenueField.setHidden(false);


		novemberRevenueField = new DataSourceFloatField("novemberRevenue", "11月营收");
		novemberRevenueField.setLength(18);
		novemberRevenueField.setDecimalPad(2);
		novemberRevenueField.setFormat("#,###,###,###,###,##0.00");
		novemberRevenueField.setRequired(false);
		novemberRevenueField.setHidden(false);


		decemberRevenueField = new DataSourceFloatField("decemberRevenue", "12月营收");
		decemberRevenueField.setLength(18);
		decemberRevenueField.setDecimalPad(2);
		decemberRevenueField.setFormat("#,###,###,###,###,##0.00");
		decemberRevenueField.setRequired(false);
		decemberRevenueField.setHidden(false);


		totalField = new DataSourceFloatField("total", "营收合计");
		totalField.setLength(18);
		totalField.setDecimalPad(2);
		totalField.setFormat("#,###,###,###,###,##0.00");
		totalField.setRequired(true);
		totalField.setHidden(false);


		januaryAmountField = new DataSourceFloatField("januaryAmount", "1月回款");
		januaryAmountField.setLength(18);
		januaryAmountField.setDecimalPad(2);
		januaryAmountField.setFormat("#,###,###,###,###,##0.00");
		januaryAmountField.setRequired(true);
		januaryAmountField.setHidden(false);


		februaryAmountField = new DataSourceFloatField("februaryAmount", "2月回款");
		februaryAmountField.setLength(18);
		februaryAmountField.setDecimalPad(2);
		februaryAmountField.setFormat("#,###,###,###,###,##0.00");
		februaryAmountField.setRequired(true);
		februaryAmountField.setHidden(false);


		marchAmountField = new DataSourceFloatField("marchAmount", "3月回款");
		marchAmountField.setLength(18);
		marchAmountField.setDecimalPad(2);
		marchAmountField.setFormat("#,###,###,###,###,##0.00");
		marchAmountField.setRequired(true);
		marchAmountField.setHidden(false);


		aprilAmountField = new DataSourceFloatField("aprilAmount", "4月回款");
		aprilAmountField.setLength(18);
		aprilAmountField.setDecimalPad(2);
		aprilAmountField.setFormat("#,###,###,###,###,##0.00");
		aprilAmountField.setRequired(true);
		aprilAmountField.setHidden(false);


		mayAmountField = new DataSourceFloatField("mayAmount", "5月回款");
		mayAmountField.setLength(18);
		mayAmountField.setDecimalPad(2);
		mayAmountField.setFormat("#,###,###,###,###,##0.00");
		mayAmountField.setRequired(true);
		mayAmountField.setHidden(false);


		juneAmountField = new DataSourceFloatField("juneAmount", "6月回款");
		juneAmountField.setLength(18);
		juneAmountField.setDecimalPad(2);
		juneAmountField.setFormat("#,###,###,###,###,##0.00");
		juneAmountField.setRequired(true);
		juneAmountField.setHidden(false);


		julyAmountField = new DataSourceFloatField("julyAmount", "7月回款");
		julyAmountField.setLength(18);
		julyAmountField.setDecimalPad(2);
		julyAmountField.setFormat("#,###,###,###,###,##0.00");
		julyAmountField.setRequired(true);
		julyAmountField.setHidden(false);


		augustAmountField = new DataSourceFloatField("augustAmount", "8月回款");
		augustAmountField.setLength(18);
		augustAmountField.setDecimalPad(2);
		augustAmountField.setFormat("#,###,###,###,###,##0.00");
		augustAmountField.setRequired(true);
		augustAmountField.setHidden(false);


		septemberAmountField = new DataSourceFloatField("septemberAmount", "9月回款");
		septemberAmountField.setLength(18);
		septemberAmountField.setDecimalPad(2);
		septemberAmountField.setFormat("#,###,###,###,###,##0.00");
		septemberAmountField.setRequired(true);
		septemberAmountField.setHidden(false);


		octoberAmountField = new DataSourceFloatField("octoberAmount", "10月回款");
		octoberAmountField.setLength(18);
		octoberAmountField.setDecimalPad(2);
		octoberAmountField.setFormat("#,###,###,###,###,##0.00");
		octoberAmountField.setRequired(true);
		octoberAmountField.setHidden(false);


		novemberAmountField = new DataSourceFloatField("novemberAmount", "11月回款");
		novemberAmountField.setLength(18);
		novemberAmountField.setDecimalPad(2);
		novemberAmountField.setFormat("#,###,###,###,###,##0.00");
		novemberAmountField.setRequired(true);
		novemberAmountField.setHidden(false);


		decemberAmountField = new DataSourceFloatField("decemberAmount", "12月回款");
		decemberAmountField.setLength(18);
		decemberAmountField.setDecimalPad(2);
		decemberAmountField.setFormat("#,###,###,###,###,##0.00");
		decemberAmountField.setRequired(true);
		decemberAmountField.setHidden(false);


		januaryLeftField = new DataSourceFloatField("januaryLeft", "1月回款率");
		januaryLeftField.setLength(18);
		januaryLeftField.setDecimalPad(2);
		januaryLeftField.setFormat("#,###,###,###,###,##0.00");
		januaryLeftField.setRequired(true);
		januaryLeftField.setHidden(true);


		februaryLeftField = new DataSourceFloatField("februaryLeft", "2月回款率");
		februaryLeftField.setLength(18);
		februaryLeftField.setDecimalPad(2);
		februaryLeftField.setFormat("#,###,###,###,###,##0.00");
		februaryLeftField.setRequired(true);
		februaryLeftField.setHidden(true);


		marchLeftField = new DataSourceFloatField("marchLeft", "3月回款率");
		marchLeftField.setLength(18);
		marchLeftField.setDecimalPad(2);
		marchLeftField.setFormat("#,###,###,###,###,##0.00");
		marchLeftField.setRequired(true);
		marchLeftField.setHidden(true);


		aprilLeftField = new DataSourceFloatField("aprilLeft", "4月回款率");
		aprilLeftField.setLength(18);
		aprilLeftField.setDecimalPad(2);
		aprilLeftField.setFormat("#,###,###,###,###,##0.00");
		aprilLeftField.setRequired(true);
		aprilLeftField.setHidden(true);


		mayLeftField = new DataSourceFloatField("mayLeft", "5月回款率");
		mayLeftField.setLength(18);
		mayLeftField.setDecimalPad(2);
		mayLeftField.setFormat("#,###,###,###,###,##0.00");
		mayLeftField.setRequired(true);
		mayLeftField.setHidden(true);


		juneLeftField = new DataSourceFloatField("juneLeft", "6月回款率");
		juneLeftField.setLength(18);
		juneLeftField.setDecimalPad(2);
		juneLeftField.setFormat("#,###,###,###,###,##0.00");
		juneLeftField.setRequired(true);
		juneLeftField.setHidden(true);


		julyLeftField = new DataSourceFloatField("julyLeft", "7月回款率");
		julyLeftField.setLength(18);
		julyLeftField.setDecimalPad(2);
		julyLeftField.setFormat("#,###,###,###,###,##0.00");
		julyLeftField.setRequired(true);
		julyLeftField.setHidden(true);


		augustLeftField = new DataSourceFloatField("augustLeft", "8月回款率");
		augustLeftField.setLength(18);
		augustLeftField.setDecimalPad(2);
		augustLeftField.setFormat("#,###,###,###,###,##0.00");
		augustLeftField.setRequired(true);
		augustLeftField.setHidden(true);


		septemberLeftField = new DataSourceFloatField("septemberLeft", "9月回款率");
		septemberLeftField.setLength(18);
		septemberLeftField.setDecimalPad(2);
		septemberLeftField.setFormat("#,###,###,###,###,##0.00");
		septemberLeftField.setRequired(true);
		septemberLeftField.setHidden(true);


		octoberLeftField = new DataSourceFloatField("octoberLeft", "10月回款率");
		octoberLeftField.setLength(18);
		octoberLeftField.setDecimalPad(2);
		octoberLeftField.setFormat("#,###,###,###,###,##0.00");
		octoberLeftField.setRequired(true);
		octoberLeftField.setHidden(true);


		novemberLeftField = new DataSourceFloatField("novemberLeft", "11月回款率");
		novemberLeftField.setLength(18);
		novemberLeftField.setDecimalPad(2);
		novemberLeftField.setFormat("#,###,###,###,###,##0.00");
		novemberLeftField.setRequired(true);
		novemberLeftField.setHidden(true);


		decemberLeftField = new DataSourceFloatField("decemberLeft", "12月回款率");
		decemberLeftField.setLength(18);
		decemberLeftField.setDecimalPad(2);
		decemberLeftField.setFormat("#,###,###,###,###,##0.00");
		decemberLeftField.setRequired(true);
		decemberLeftField.setHidden(true);
		
		totalAmountField = new DataSourceFloatField("totalAmount", "回款合计");
		totalAmountField.setLength(18);
		totalAmountField.setDecimalPad(2);
		totalAmountField.setFormat("#,###,###,###,###,##0.00");
		totalAmountField.setRequired(true);
		totalAmountField.setHidden(false);
		
		
		totalLeftField = new DataSourceFloatField("totalLeft", "回款率");
		totalLeftField.setLength(18);
		totalLeftField.setDecimalPad(2);
		totalLeftField.setFormat("#,###,###,###,###,##0.00");
		totalLeftField.setRequired(true);
		totalLeftField.setHidden(true);
		
		

		str1Field = new DataSourceTextField("str1", "1月回款率");
		str1Field.setLength(18);
		str1Field.setRequired(true);
		str1Field.setHidden(false);


		str2Field = new DataSourceTextField("str2", "2月回款率");
		str2Field.setLength(18);
		str2Field.setRequired(true);
		str2Field.setHidden(false);


		str3Field = new DataSourceTextField("str3", "3月回款率");
		str3Field.setLength(18);
		str3Field.setRequired(true);
		str3Field.setHidden(false);


		str4Field = new DataSourceTextField("str4", "4月回款率");
		str4Field.setLength(18);
		str4Field.setRequired(true);
		str4Field.setHidden(false);


		str5Field = new DataSourceTextField("str5", "5月回款率");
		str5Field.setLength(18);
		str5Field.setRequired(true);
		str5Field.setHidden(false);


		str6Field = new DataSourceTextField("str6", "6月回款率");
		str6Field.setLength(18);
		str6Field.setRequired(true);
		str6Field.setHidden(false);


		str7Field = new DataSourceTextField("str7", "7月回款率");
		str7Field.setLength(18);
		str7Field.setRequired(true);
		str7Field.setHidden(false);


		str8Field = new DataSourceTextField("str8", "8月回款率");
		str8Field.setLength(18);
		str8Field.setRequired(true);
		str8Field.setHidden(false);


		str9Field = new DataSourceTextField("str9", "9月回款率");
		str9Field.setLength(18);
		str9Field.setRequired(true);
		str9Field.setHidden(false);


		str10Field = new DataSourceTextField("str10", "10月回款率");
		str10Field.setLength(18);
		str10Field.setRequired(true);
		str10Field.setHidden(false);


		str11Field = new DataSourceTextField("str11", "11月回款率");
		str11Field.setLength(18);
		str11Field.setRequired(true);
		str11Field.setHidden(false);


		str12Field = new DataSourceTextField("str12", "12月回款率");
		str12Field.setLength(18);
		str12Field.setRequired(true);
		str12Field.setHidden(false);


		strField = new DataSourceTextField("str", "回款率");
		strField.setLength(18);
		strField.setRequired(true);
		strField.setHidden(false);


		setFields(plateIdField, yearField, totalField,totalAmountField, strField, januaryRevenueField, februaryRevenueField, marchRevenueField, aprilRevenueField, mayRevenueField, juneRevenueField, julyRevenueField, augustRevenueField, septemberRevenueField, octoberRevenueField, novemberRevenueField, decemberRevenueField, januaryAmountField, februaryAmountField, marchAmountField, aprilAmountField, mayAmountField, juneAmountField, julyAmountField, augustAmountField, septemberAmountField, octoberAmountField, novemberAmountField, decemberAmountField, januaryLeftField, februaryLeftField, marchLeftField, aprilLeftField, mayLeftField, juneLeftField, julyLeftField, augustLeftField, septemberLeftField, octoberLeftField, novemberLeftField, decemberLeftField,totalLeftField, str1Field, str2Field, str3Field, str4Field, str5Field, str6Field, str7Field, str8Field, str9Field, str10Field, str11Field, str12Field);
	}


}

