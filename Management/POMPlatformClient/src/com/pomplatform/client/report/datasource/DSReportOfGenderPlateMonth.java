package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSReportOfGenderPlateMonth extends DBDataSource
{


	public static DSReportOfGenderPlateMonth instance = null;

	public static DSReportOfGenderPlateMonth getInstance() {
		if(instance == null) {
			instance = new DSReportOfGenderPlateMonth("DSReportOfGenderPlateMonth");
		}
		return instance;
	}

	private final DataSourceTextField plateIdField;
	private final DataSourceTextField maleProportionField;
	private final DataSourceTextField femaleProportionField;
	private final DataSourceIntegerField maleField;
	private final DataSourceFloatField malePerField;
	private final DataSourceIntegerField femaleField;
	private final DataSourceFloatField femalePerField;
	private final DataSourceIntegerField totalField;

	public DSReportOfGenderPlateMonth(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ReportOfGenderPlateMonth");


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));


		maleProportionField = new DataSourceTextField("maleProportionStr", "男性理想比例");
		maleProportionField.setLength(32);
		maleProportionField.setRequired(false);
		maleProportionField.setHidden(false);


		femaleProportionField = new DataSourceTextField("femaleProportionStr", "女性理想比例");
		femaleProportionField.setLength(32);
		femaleProportionField.setRequired(false);
		femaleProportionField.setHidden(false);


		maleField = new DataSourceIntegerField("male", "男");
		maleField.setLength(11);
		maleField.setRequired(true);
		maleField.setHidden(false);


		malePerField = new DataSourceFloatField("malePer", "男性比例(%)");
		malePerField.setLength(18);
		malePerField.setDecimalPad(2);
		malePerField.setFormat("#,###,###,###,###,##0.00");
		malePerField.setRequired(true);
		malePerField.setHidden(false);


		femaleField = new DataSourceIntegerField("female", "女");
		femaleField.setLength(11);
		femaleField.setRequired(true);
		femaleField.setHidden(false);


		femalePerField = new DataSourceFloatField("femalePer", "女性比例(%)");
		femalePerField.setLength(18);
		femalePerField.setDecimalPad(2);
		femalePerField.setFormat("#,###,###,###,###,##0.00");
		femalePerField.setRequired(true);
		femalePerField.setHidden(false);


		totalField = new DataSourceIntegerField("total", "合计");
		totalField.setLength(11);
		totalField.setRequired(true);
		totalField.setHidden(false);


		setFields(plateIdField, maleProportionField, femaleProportionField, maleField, malePerField, femaleField, femalePerField, totalField);
	}


}

