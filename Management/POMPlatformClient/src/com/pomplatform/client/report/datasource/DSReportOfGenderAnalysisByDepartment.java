package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSReportOfGenderAnalysisByDepartment extends DBDataSource
{


	public static DSReportOfGenderAnalysisByDepartment instance = null;

	public static DSReportOfGenderAnalysisByDepartment getInstance() {
		if(instance == null) {
			instance = new DSReportOfGenderAnalysisByDepartment("DSReportOfGenderAnalysisByDepartment");
		}
		return instance;
	}


	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField genderProportionIdField;
	private final DataSourceTextField plateIdField;
	private final DataSourceTextField maleProportionField;
	private final DataSourceTextField femaleProportionField;
	private final DataSourceIntegerField maleJanuaryField;
	private final DataSourceTextField maleJanuaryPerField;
	private final DataSourceIntegerField femaleJanuaryField;
	private final DataSourceTextField femaleJanuaryPerField;
	private final DataSourceIntegerField januaryTotalField;
	private final DataSourceIntegerField maleFebruaryField;
	private final DataSourceTextField maleFebruaryPerField;
	private final DataSourceIntegerField femaleFebruaryField;
	private final DataSourceTextField femaleFebruaryPerField;
	private final DataSourceIntegerField februaryTotalField;
	private final DataSourceIntegerField maleMarchField;
	private final DataSourceTextField maleMarchPerField;
	private final DataSourceIntegerField femaleMarchField;
	private final DataSourceTextField femaleMarchPerField;
	private final DataSourceIntegerField marchTotalField;
	private final DataSourceIntegerField maleAprilField;
	private final DataSourceTextField maleAprilPerField;
	private final DataSourceIntegerField femaleAprilField;
	private final DataSourceTextField femaleAprilPerField;
	private final DataSourceIntegerField aprilTotalField;
	private final DataSourceIntegerField maleMayField;
	private final DataSourceTextField maleMayPerField;
	private final DataSourceIntegerField femaleMayField;
	private final DataSourceTextField femaleMayPerField;
	private final DataSourceIntegerField mayTotalField;
	private final DataSourceIntegerField maleJuneField;
	private final DataSourceTextField maleJunePerField;
	private final DataSourceIntegerField femaleJuneField;
	private final DataSourceTextField femaleJunePerField;
	private final DataSourceIntegerField juneTotalField;
	private final DataSourceIntegerField maleJulyField;
	private final DataSourceTextField maleJulyPerField;
	private final DataSourceIntegerField femaleJulyField;
	private final DataSourceTextField femaleJulyPerField;
	private final DataSourceIntegerField julyTotalField;
	private final DataSourceIntegerField maleAugustField;
	private final DataSourceTextField maleAugustPerField;
	private final DataSourceIntegerField femaleAugustField;
	private final DataSourceTextField femaleAugustPerField;
	private final DataSourceIntegerField augustTotalField;
	private final DataSourceIntegerField maleSeptemberField;
	private final DataSourceTextField maleSeptemberPerField;
	private final DataSourceIntegerField femaleSeptemberField;
	private final DataSourceTextField femaleSeptemberPerField;
	private final DataSourceIntegerField septemberTotalField;
	private final DataSourceIntegerField maleOctoberField;
	private final DataSourceTextField maleOctoberPerField;
	private final DataSourceIntegerField femaleOctoberField;
	private final DataSourceTextField femaleOctoberPerField;
	private final DataSourceIntegerField octoberTotalField;
	private final DataSourceIntegerField maleNovemberField;
	private final DataSourceTextField maleNovemberPerField;
	private final DataSourceIntegerField femaleNovemberField;
	private final DataSourceTextField femaleNovemberPerField;
	private final DataSourceIntegerField novemberTotalField;
	private final DataSourceIntegerField maleDecemberField;
	private final DataSourceTextField maleDecemberPerField;
	private final DataSourceIntegerField femaleDecemberField;
	private final DataSourceTextField femaleDecemberPerField;
	private final DataSourceIntegerField decemberTotalField;

	public DSReportOfGenderAnalysisByDepartment(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ReportOfGenderAnalysisByDepartment");
		
		genderProportionIdField = new DataSourceTextField("plateId", "业务部门");
		genderProportionIdField.setLength(11);
		genderProportionIdField.setRequired(false);
		genderProportionIdField.setHidden(true);
		
		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(true);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));
		plateIdField.setCanEdit(true);


		maleProportionField = new DataSourceTextField("maleProportionStr", "男性理想比例");
		maleProportionField.setLength(32);
		maleProportionField.setRequired(false);
		maleProportionField.setHidden(false);


		femaleProportionField = new DataSourceTextField("femaleProportionStr", "女性理想比例");
		femaleProportionField.setLength(32);
		femaleProportionField.setRequired(false);
		femaleProportionField.setHidden(false);


		maleJanuaryField = new DataSourceIntegerField("maleJanuary", "男");
		maleJanuaryField.setLength(18);
		maleJanuaryField.setRequired(true);
		maleJanuaryField.setHidden(false);
		maleJanuaryField.setCanEdit(false);


		maleJanuaryPerField = new DataSourceTextField("maleJanuaryPer", "男性占比(%)");
		maleJanuaryPerField.setLength(18);
		maleJanuaryPerField.setDecimalPad(2);
		maleJanuaryPerField.setFormat("#,###,###,###,###,##0.00");
		maleJanuaryPerField.setRequired(true);
		maleJanuaryPerField.setHidden(false);
		maleJanuaryPerField.setCanEdit(false);


		femaleJanuaryField = new DataSourceIntegerField("femaleJanuary", "女");
		femaleJanuaryField.setLength(18);
		femaleJanuaryField.setRequired(true);
		femaleJanuaryField.setHidden(false);
		femaleJanuaryField.setCanEdit(false);
		

		femaleJanuaryPerField = new DataSourceTextField("femaleJanuaryPer", "女性占比(%)");
		femaleJanuaryPerField.setLength(18);
		femaleJanuaryPerField.setDecimalPad(2);
		femaleJanuaryPerField.setFormat("#,###,###,###,###,##0.00");
		femaleJanuaryPerField.setRequired(true);
		femaleJanuaryPerField.setHidden(false);
		femaleJanuaryPerField.setCanEdit(false);


		januaryTotalField = new DataSourceIntegerField("januaryTotal", "合计");
		januaryTotalField.setLength(18);
		januaryTotalField.setRequired(true);
		januaryTotalField.setHidden(false);
		januaryTotalField.setCanEdit(false);


		maleFebruaryField = new DataSourceIntegerField("maleFebruary", "男");
		maleFebruaryField.setLength(18);
		maleFebruaryField.setRequired(true);
		maleFebruaryField.setHidden(false);
		maleFebruaryField.setCanEdit(false);
		

		maleFebruaryPerField = new DataSourceTextField("maleFebruaryPer", "男性占比(%)");
		maleFebruaryPerField.setLength(18);
		maleFebruaryPerField.setDecimalPad(2);
		maleFebruaryPerField.setFormat("#,###,###,###,###,##0.00");
		maleFebruaryPerField.setRequired(true);
		maleFebruaryPerField.setHidden(false);
		maleFebruaryPerField.setCanEdit(false);


		femaleFebruaryField = new DataSourceIntegerField("femaleFebruary", "女");
		femaleFebruaryField.setLength(18);
		femaleFebruaryField.setRequired(true);
		femaleFebruaryField.setHidden(false);
		femaleFebruaryField.setCanEdit(false);


		femaleFebruaryPerField = new DataSourceTextField("femaleFebruaryPer", "女性占比(%)");
		femaleFebruaryPerField.setLength(18);
		femaleFebruaryPerField.setDecimalPad(2);
		femaleFebruaryPerField.setFormat("#,###,###,###,###,##0.00");
		femaleFebruaryPerField.setRequired(true);
		femaleFebruaryPerField.setHidden(false);
		femaleFebruaryPerField.setCanEdit(false);


		februaryTotalField = new DataSourceIntegerField("februaryTotal", "合计");
		februaryTotalField.setLength(18);
		februaryTotalField.setRequired(true);
		februaryTotalField.setHidden(false);
		februaryTotalField.setCanEdit(false);


		maleMarchField = new DataSourceIntegerField("maleMarch", "男");
		maleMarchField.setLength(18);
		maleMarchField.setRequired(true);
		maleMarchField.setHidden(false);
		maleMarchField.setCanEdit(false);


		maleMarchPerField = new DataSourceTextField("maleMarchPer", "男性占比(%)");
		maleMarchPerField.setLength(18);
		maleMarchPerField.setDecimalPad(2);
		maleMarchPerField.setFormat("#,###,###,###,###,##0.00");
		maleMarchPerField.setRequired(true);
		maleMarchPerField.setHidden(false);
		maleMarchPerField.setCanEdit(false);


		femaleMarchField = new DataSourceIntegerField("femaleMarch", "女");
		femaleMarchField.setLength(18);
		femaleMarchField.setRequired(true);
		femaleMarchField.setHidden(false);
		femaleMarchField.setCanEdit(false);


		femaleMarchPerField = new DataSourceTextField("femaleMarchPer", "女性占比(%)");
		femaleMarchPerField.setLength(18);
		femaleMarchPerField.setDecimalPad(2);
		femaleMarchPerField.setFormat("#,###,###,###,###,##0.00");
		femaleMarchPerField.setRequired(true);
		femaleMarchPerField.setHidden(false);
		femaleMarchPerField.setCanEdit(false);


		marchTotalField = new DataSourceIntegerField("marchTotal", "合计");
		marchTotalField.setLength(18);
		marchTotalField.setRequired(true);
		marchTotalField.setHidden(false);
		marchTotalField.setCanEdit(false);


		maleAprilField = new DataSourceIntegerField("maleApril", "男");
		maleAprilField.setLength(18);
		maleAprilField.setRequired(true);
		maleAprilField.setHidden(false);
		maleAprilField.setCanEdit(false);


		maleAprilPerField = new DataSourceTextField("maleAprilPer", "男性占比(%)");
		maleAprilPerField.setLength(18);
		maleAprilPerField.setDecimalPad(2);
		maleAprilPerField.setFormat("#,###,###,###,###,##0.00");
		maleAprilPerField.setRequired(true);
		maleAprilPerField.setHidden(false);
		maleAprilPerField.setCanEdit(false);


		femaleAprilField = new DataSourceIntegerField("femaleApril", "女");
		femaleAprilField.setLength(18);
		femaleAprilField.setRequired(true);
		femaleAprilField.setHidden(false);
		femaleAprilField.setCanEdit(false);


		femaleAprilPerField = new DataSourceTextField("femaleAprilPer", "女性占比(%)");
		femaleAprilPerField.setLength(18);
		femaleAprilPerField.setDecimalPad(2);
		femaleAprilPerField.setFormat("#,###,###,###,###,##0.00");
		femaleAprilPerField.setRequired(true);
		femaleAprilPerField.setHidden(false);
		femaleAprilPerField.setCanEdit(false);


		aprilTotalField = new DataSourceIntegerField("aprilTotal", "合计");
		aprilTotalField.setLength(18);
		aprilTotalField.setRequired(true);
		aprilTotalField.setHidden(false);
		aprilTotalField.setCanEdit(false);


		maleMayField = new DataSourceIntegerField("maleMay", "男");
		maleMayField.setLength(18);
		maleMayField.setRequired(true);
		maleMayField.setHidden(false);
		maleMayField.setCanEdit(false);


		maleMayPerField = new DataSourceTextField("maleMayPer", "男性占比(%)");
		maleMayPerField.setLength(18);
		maleMayPerField.setDecimalPad(2);
		maleMayPerField.setFormat("#,###,###,###,###,##0.00");
		maleMayPerField.setRequired(true);
		maleMayPerField.setHidden(false);
		maleMayPerField.setCanEdit(false);


		femaleMayField = new DataSourceIntegerField("femaleMay", "女");
		femaleMayField.setLength(18);
		femaleMayField.setRequired(true);
		femaleMayField.setHidden(false);
		femaleMayField.setCanEdit(false);


		femaleMayPerField = new DataSourceTextField("femaleMayPer", "女性占比(%)");
		femaleMayPerField.setLength(18);
		femaleMayPerField.setDecimalPad(2);
		femaleMayPerField.setFormat("#,###,###,###,###,##0.00");
		femaleMayPerField.setRequired(true);
		femaleMayPerField.setHidden(false);
		femaleMayPerField.setCanEdit(false);


		mayTotalField = new DataSourceIntegerField("mayTotal", "合计");
		mayTotalField.setLength(18);
		mayTotalField.setRequired(true);
		mayTotalField.setHidden(false);
		mayTotalField.setCanEdit(false);


		maleJuneField = new DataSourceIntegerField("maleJune", "男");
		maleJuneField.setLength(18);
		maleJuneField.setRequired(true);
		maleJuneField.setHidden(false);
		maleJuneField.setCanEdit(false);


		maleJunePerField = new DataSourceTextField("maleJunePer", "男性占比(%)");
		maleJunePerField.setLength(18);
		maleJunePerField.setDecimalPad(2);
		maleJunePerField.setFormat("#,###,###,###,###,##0.00");
		maleJunePerField.setRequired(true);
		maleJunePerField.setHidden(false);
		maleJunePerField.setCanEdit(false);


		femaleJuneField = new DataSourceIntegerField("femaleJune", "女");
		femaleJuneField.setLength(18);
		femaleJuneField.setRequired(true);
		femaleJuneField.setHidden(false);
		femaleJuneField.setCanEdit(false);
		

		femaleJunePerField = new DataSourceTextField("femaleJunePer", "女性占比(%)");
		femaleJunePerField.setLength(18);
		femaleJunePerField.setDecimalPad(2);
		femaleJunePerField.setFormat("#,###,###,###,###,##0.00");
		femaleJunePerField.setRequired(true);
		femaleJunePerField.setHidden(false);
		femaleJunePerField.setCanEdit(false);
		

		juneTotalField = new DataSourceIntegerField("juneTotal", "合计");
		juneTotalField.setLength(18);
		juneTotalField.setRequired(true);
		juneTotalField.setHidden(false);
		juneTotalField.setCanEdit(false);


		maleJulyField = new DataSourceIntegerField("maleJuly", "男");
		maleJulyField.setLength(18);
		maleJulyField.setRequired(true);
		maleJulyField.setHidden(false);
		maleJulyField.setCanEdit(false);


		maleJulyPerField = new DataSourceTextField("maleJulyPer", "男性占比(%)");
		maleJulyPerField.setLength(18);
		maleJulyPerField.setDecimalPad(2);
		maleJulyPerField.setFormat("#,###,###,###,###,##0.00");
		maleJulyPerField.setRequired(true);
		maleJulyPerField.setHidden(false);
		maleJulyPerField.setCanEdit(false);


		femaleJulyField = new DataSourceIntegerField("femaleJuly", "女");
		femaleJulyField.setLength(18);
		femaleJulyField.setRequired(true);
		femaleJulyField.setHidden(false);
		femaleJulyField.setCanEdit(false);


		femaleJulyPerField = new DataSourceTextField("femaleJulyPer", "女性占比(%)");
		femaleJulyPerField.setLength(18);
		femaleJulyPerField.setDecimalPad(2);
		femaleJulyPerField.setFormat("#,###,###,###,###,##0.00");
		femaleJulyPerField.setRequired(true);
		femaleJulyPerField.setHidden(false);
		femaleJulyPerField.setCanEdit(false);


		julyTotalField = new DataSourceIntegerField("julyTotal", "合计");
		julyTotalField.setLength(18);
		julyTotalField.setRequired(true);
		julyTotalField.setHidden(false);
		julyTotalField.setCanEdit(false);


		maleAugustField = new DataSourceIntegerField("maleAugust", "男");
		maleAugustField.setLength(18);
		maleAugustField.setRequired(true);
		maleAugustField.setHidden(false);
		maleAugustField.setCanEdit(false);


		maleAugustPerField = new DataSourceTextField("maleAugustPer", "男性占比(%)");
		maleAugustPerField.setLength(18);
		maleAugustPerField.setDecimalPad(2);
		maleAugustPerField.setFormat("#,###,###,###,###,##0.00");
		maleAugustPerField.setRequired(true);
		maleAugustPerField.setHidden(false);
		maleAugustPerField.setCanEdit(false);


		femaleAugustField = new DataSourceIntegerField("femaleAugust", "女");
		femaleAugustField.setLength(18);
		femaleAugustField.setRequired(true);
		femaleAugustField.setHidden(false);
		femaleAugustField.setCanEdit(false);


		femaleAugustPerField = new DataSourceTextField("femaleAugustPer", "女性占比(%)");
		femaleAugustPerField.setLength(18);
		femaleAugustPerField.setDecimalPad(2);
		femaleAugustPerField.setFormat("#,###,###,###,###,##0.00");
		femaleAugustPerField.setRequired(true);
		femaleAugustPerField.setHidden(false);
		femaleAugustPerField.setCanEdit(false);


		augustTotalField = new DataSourceIntegerField("augustTotal", "合计");
		augustTotalField.setLength(18);
		augustTotalField.setRequired(true);
		augustTotalField.setHidden(false);
		augustTotalField.setCanEdit(false);


		maleSeptemberField = new DataSourceIntegerField("maleSeptember", "男");
		maleSeptemberField.setLength(18);
		maleSeptemberField.setRequired(true);
		maleSeptemberField.setHidden(false);
		maleSeptemberField.setCanEdit(false);
		

		maleSeptemberPerField = new DataSourceTextField("maleSeptemberPer", "男性占比(%)");
		maleSeptemberPerField.setLength(18);
		maleSeptemberPerField.setDecimalPad(2);
		maleSeptemberPerField.setFormat("#,###,###,###,###,##0.00");
		maleSeptemberPerField.setRequired(true);
		maleSeptemberPerField.setHidden(false);
		maleSeptemberPerField.setCanEdit(false);


		femaleSeptemberField = new DataSourceIntegerField("femaleSeptember", "女");
		femaleSeptemberField.setLength(18);
		femaleSeptemberField.setRequired(true);
		femaleSeptemberField.setHidden(false);
		femaleSeptemberField.setCanEdit(false);


		femaleSeptemberPerField = new DataSourceTextField("femaleSeptemberPer", "女性占比(%)");
		femaleSeptemberPerField.setLength(18);
		femaleSeptemberPerField.setDecimalPad(2);
		femaleSeptemberPerField.setFormat("#,###,###,###,###,##0.00");
		femaleSeptemberPerField.setRequired(true);
		femaleSeptemberPerField.setHidden(false);
		femaleSeptemberPerField.setCanEdit(false);


		septemberTotalField = new DataSourceIntegerField("septemberTotal", "合计");
		septemberTotalField.setLength(18);
		septemberTotalField.setRequired(true);
		septemberTotalField.setHidden(false);
		septemberTotalField.setCanEdit(false);


		maleOctoberField = new DataSourceIntegerField("maleOctober", "男");
		maleOctoberField.setLength(18);
		maleOctoberField.setRequired(true);
		maleOctoberField.setHidden(false);
		maleOctoberField.setCanEdit(false);


		maleOctoberPerField = new DataSourceTextField("maleOctoberPer", "男性占比(%)");
		maleOctoberPerField.setLength(18);
		maleOctoberPerField.setDecimalPad(2);
		maleOctoberPerField.setFormat("#,###,###,###,###,##0.00");
		maleOctoberPerField.setRequired(true);
		maleOctoberPerField.setHidden(false);
		maleOctoberPerField.setCanEdit(false);


		femaleOctoberField = new DataSourceIntegerField("femaleOctober", "女");
		femaleOctoberField.setLength(18);
		femaleOctoberField.setRequired(true);
		femaleOctoberField.setHidden(false);
		femaleOctoberField.setCanEdit(false);


		femaleOctoberPerField = new DataSourceTextField("femaleOctoberPer", "女性占比(%)");
		femaleOctoberPerField.setLength(18);
		femaleOctoberPerField.setDecimalPad(2);
		femaleOctoberPerField.setFormat("#,###,###,###,###,##0.00");
		femaleOctoberPerField.setRequired(true);
		femaleOctoberPerField.setHidden(false);
		femaleOctoberPerField.setCanEdit(false);


		octoberTotalField = new DataSourceIntegerField("octoberTotal", "合计");
		octoberTotalField.setLength(18);
		octoberTotalField.setRequired(true);
		octoberTotalField.setHidden(false);
		octoberTotalField.setCanEdit(false);


		maleNovemberField = new DataSourceIntegerField("maleNovember", "男");
		maleNovemberField.setLength(18);
		maleNovemberField.setRequired(true);
		maleNovemberField.setHidden(false);
		maleNovemberField.setCanEdit(false);


		maleNovemberPerField = new DataSourceTextField("maleNovemberPer", "男性占比(%)");
		maleNovemberPerField.setLength(18);
		maleNovemberPerField.setDecimalPad(2);
		maleNovemberPerField.setFormat("#,###,###,###,###,##0.00");
		maleNovemberPerField.setRequired(true);
		maleNovemberPerField.setHidden(false);
		maleNovemberPerField.setCanEdit(false);
		

		femaleNovemberField = new DataSourceIntegerField("femaleNovember", "女");
		femaleNovemberField.setLength(18);
		femaleNovemberField.setRequired(true);
		femaleNovemberField.setHidden(false);
		femaleNovemberField.setCanEdit(false);


		femaleNovemberPerField = new DataSourceTextField("femaleNovemberPer", "女性占比(%)");
		femaleNovemberPerField.setLength(18);
		femaleNovemberPerField.setDecimalPad(2);
		femaleNovemberPerField.setFormat("#,###,###,###,###,##0.00");
		femaleNovemberPerField.setRequired(true);
		femaleNovemberPerField.setHidden(false);
		femaleNovemberPerField.setCanEdit(false);


		novemberTotalField = new DataSourceIntegerField("novemberTotal", "合计");
		novemberTotalField.setLength(18);
		novemberTotalField.setRequired(true);
		novemberTotalField.setHidden(false);
		novemberTotalField.setCanEdit(false);


		maleDecemberField = new DataSourceIntegerField("maleDecember", "男");
		maleDecemberField.setLength(18);
		maleDecemberField.setRequired(true);
		maleDecemberField.setHidden(false);
		maleDecemberField.setCanEdit(false);


		maleDecemberPerField = new DataSourceTextField("maleDecemberPer", "男性占比(%)");
		maleDecemberPerField.setLength(18);
		maleDecemberPerField.setDecimalPad(2);
		maleDecemberPerField.setFormat("#,###,###,###,###,##0.00");
		maleDecemberPerField.setRequired(true);
		maleDecemberPerField.setHidden(false);
		maleDecemberPerField.setCanEdit(false);


		femaleDecemberField = new DataSourceIntegerField("femaleDecember", "女");
		femaleDecemberField.setLength(18);
		femaleDecemberField.setRequired(true);
		femaleDecemberField.setHidden(false);
		femaleDecemberField.setCanEdit(false);

		femaleDecemberPerField = new DataSourceTextField("femaleDecemberPer", "女性占比(%)");
		femaleDecemberPerField.setLength(18);
		femaleDecemberPerField.setDecimalPad(2);
		femaleDecemberPerField.setFormat("#,###,###,###,###,##0.00");
		femaleDecemberPerField.setRequired(true);
		femaleDecemberPerField.setHidden(false);
		femaleDecemberPerField.setCanEdit(false);

		decemberTotalField = new DataSourceIntegerField("decemberTotal", "合计");
		decemberTotalField.setLength(18);
		decemberTotalField.setRequired(true);
		decemberTotalField.setHidden(false);
		decemberTotalField.setCanEdit(false);

		setFields(plateIdField,departmentIdField, maleProportionField, femaleProportionField, maleJanuaryField, maleJanuaryPerField, femaleJanuaryField, femaleJanuaryPerField, januaryTotalField, maleFebruaryField, maleFebruaryPerField, femaleFebruaryField, femaleFebruaryPerField, februaryTotalField, maleMarchField, maleMarchPerField, femaleMarchField, femaleMarchPerField, marchTotalField, maleAprilField, maleAprilPerField, femaleAprilField, femaleAprilPerField, aprilTotalField, maleMayField, maleMayPerField, femaleMayField, femaleMayPerField, mayTotalField, maleJuneField, maleJunePerField, femaleJuneField, femaleJunePerField, juneTotalField, maleJulyField, maleJulyPerField, femaleJulyField, femaleJulyPerField, julyTotalField, maleAugustField, maleAugustPerField, femaleAugustField, femaleAugustPerField, augustTotalField, maleSeptemberField, maleSeptemberPerField, femaleSeptemberField, femaleSeptemberPerField, septemberTotalField, maleOctoberField, maleOctoberPerField, femaleOctoberField, femaleOctoberPerField, octoberTotalField, maleNovemberField, maleNovemberPerField, femaleNovemberField, femaleNovemberPerField, novemberTotalField, maleDecemberField, maleDecemberPerField, femaleDecemberField, femaleDecemberPerField, decemberTotalField);
	}


}

