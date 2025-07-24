package com.pomplatform.client.client.workflow.specialdeduction.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSpecialDeductionInformation extends DataSource
{


	public static CDSpecialDeductionInformation instance = null;

	public static CDSpecialDeductionInformation getInstance() {
		if(instance == null) {
			instance = new CDSpecialDeductionInformation("CDSpecialDeductionInformation");
		}
		return instance;
	}

	private final DataSourceIntegerField employeIdField;
	private final DataSourceIntegerField specialDeductionTypeIdField;
	private final DataSourceTextField yearField;
	private final DataSourceIntegerField schoolingField;
	private final DataSourceIntegerField educationTypeField;
	private final DataSourceIntegerField educationStageField;
	private final DataSourceIntegerField houseFirstField;
	private final DataSourceIntegerField singleChildField;
	private final DataSourceTextField cityField;

	public CDSpecialDeductionInformation(String dataSourceID) {

		setID(dataSourceID);
		employeIdField = new DataSourceIntegerField("employeId", "纳税人id");
		employeIdField.setRequired(true);
		employeIdField.setLength(11);
		employeIdField.setHidden(false);

		specialDeductionTypeIdField = new DataSourceIntegerField("specialDeductionTypeId", "专项类型");
		specialDeductionTypeIdField.setRequired(false);
		specialDeductionTypeIdField.setLength(11);
		specialDeductionTypeIdField.setHidden(false);

		yearField = new DataSourceTextField("year", "扣除年度");
		yearField.setRequired(false);
		yearField.setLength(32);
		yearField.setHidden(false);

		schoolingField = new DataSourceIntegerField("schooling", "当前受教育阶段");
		schoolingField.setRequired(false);
		schoolingField.setLength(11);
		schoolingField.setHidden(false);

		educationTypeField = new DataSourceIntegerField("educationType", "继续教育类型");
		educationTypeField.setRequired(false);
		educationTypeField.setLength(11);
		educationTypeField.setHidden(false);

		educationStageField = new DataSourceIntegerField("educationStage", "教育阶段");
		educationStageField.setRequired(false);
		educationStageField.setLength(11);
		educationStageField.setHidden(false);

		houseFirstField = new DataSourceIntegerField("houseFirst", "是否婚前各自首套贷款且婚后分别扣除50%");
		houseFirstField.setRequired(false);
		houseFirstField.setLength(11);
		houseFirstField.setHidden(false);

		singleChildField = new DataSourceIntegerField("singleChild", "是否独生");
		singleChildField.setRequired(false);
		singleChildField.setLength(11);
		singleChildField.setHidden(false);

		cityField = new DataSourceTextField("city", "租房城市");
		cityField.setRequired(false);
		cityField.setLength(64);
		cityField.setHidden(false);

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(employeIdField, specialDeductionTypeIdField, yearField, schoolingField, educationTypeField, educationStageField, houseFirstField, singleChildField, cityField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

