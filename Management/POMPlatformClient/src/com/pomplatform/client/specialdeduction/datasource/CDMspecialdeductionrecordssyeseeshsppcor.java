package com.pomplatform.client.specialdeduction.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMspecialdeductionrecordssyeseeshsppcor extends DataSource
{


	public static CDMspecialdeductionrecordssyeseeshsppcor instance = null;

	public static CDMspecialdeductionrecordssyeseeshsppcor getInstance() {
		if(instance == null) {
			instance = new CDMspecialdeductionrecordssyeseeshsppcor("CDMspecialdeductionrecordssyeseeshsppcor");
		}
		return instance;
	}

	private final DataSourceTextField yearField;
	private final DataSourceIntegerField employeIdField;
	private final DataSourceIntegerField specialDeductionTypeIdField;
	private final DataSourceIntegerField educationTypeField;
	private final DataSourceIntegerField educationStageField;
	private final DataSourceIntegerField singleChildField;
	private final DataSourceIntegerField houseFirstField;
	private final DataSourceIntegerField schoolingField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField companyIdField;

	public CDMspecialdeductionrecordssyeseeshsppcor(String dataSourceID) {

		setID(dataSourceID);
		yearField = new DataSourceTextField("year", "扣除年度");
		yearField.setRequired(false);
		yearField.setLength(64);
		yearField.setHidden(false);

		employeIdField = new DataSourceIntegerField("employeId", "纳税申请人");
		employeIdField.setRequired(true);
		employeIdField.setLength(11);
		employeIdField.setHidden(false);

		specialDeductionTypeIdField = new DataSourceIntegerField("specialDeductionTypeId", "专项类型");
		specialDeductionTypeIdField.setRequired(false);
		specialDeductionTypeIdField.setLength(11);
		specialDeductionTypeIdField.setHidden(false);

		educationTypeField = new DataSourceIntegerField("educationType", "继续教育类型");
		educationTypeField.setRequired(false);
		educationTypeField.setLength(11);
		educationTypeField.setHidden(false);

		educationStageField = new DataSourceIntegerField("educationStage", "教育阶段");
		educationStageField.setRequired(false);
		educationStageField.setLength(11);
		educationStageField.setHidden(false);

		singleChildField = new DataSourceIntegerField("singleChild", "是否独生");
		singleChildField.setRequired(false);
		singleChildField.setLength(11);
		singleChildField.setHidden(false);

		houseFirstField = new DataSourceIntegerField("houseFirst", "是否婚前各自首套贷款且婚后分别扣除50%");
		houseFirstField.setRequired(false);
		houseFirstField.setLength(11);
		houseFirstField.setHidden(false);

		schoolingField = new DataSourceIntegerField("schooling", "当前受教育阶段");
		schoolingField.setRequired(false);
		schoolingField.setLength(11);
		schoolingField.setHidden(false);

		processStatusField = new DataSourceIntegerField("processStatus", "流程状态 0 发起中  1");
		processStatusField.setRequired(false);
		processStatusField.setLength(11);
		processStatusField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);

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


		setFields(yearField, employeIdField, specialDeductionTypeIdField, educationTypeField, educationStageField, singleChildField, houseFirstField, schoolingField, processStatusField, plateIdField, companyIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

