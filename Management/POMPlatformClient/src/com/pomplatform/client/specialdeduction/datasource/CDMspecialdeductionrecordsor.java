package com.pomplatform.client.specialdeduction.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMspecialdeductionrecordsor extends DataSource
{


	public static CDMspecialdeductionrecordsor instance = null;

	public static CDMspecialdeductionrecordsor getInstance() {
		if(instance == null) {
			instance = new CDMspecialdeductionrecordsor("CDMspecialdeductionrecordsor");
		}
		return instance;
	}

	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField employeIdField;
	private final DataSourceIntegerField documentTypeField;
	private final DataSourceIntegerField spouseSituationField;
	private final DataSourceTextField nameField;
	private final DataSourceIntegerField specialDeductionTypeIdField;
	private final DataSourceIntegerField educationTypeField;
	private final DataSourceIntegerField educationStageField;
	private final DataSourceIntegerField houseBorrowerField;
	private final DataSourceIntegerField houseTypeField;
	private final DataSourceIntegerField houseFirstField;
	private final DataSourceIntegerField loanTypeField;
	private final DataSourceIntegerField singleChildField;
	private final DataSourceIntegerField changeTypeField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField companyIdField;

	public CDMspecialdeductionrecordsor(String dataSourceID) {

		setID(dataSourceID);
		yearField = new DataSourceIntegerField("year", "扣除年度");
		yearField.setRequired(false);
		yearField.setLength(11);
		yearField.setHidden(false);

		employeIdField = new DataSourceIntegerField("employeId", "纳税人id");
		employeIdField.setRequired(true);
		employeIdField.setLength(11);
		employeIdField.setHidden(false);

		documentTypeField = new DataSourceIntegerField("documentType", "身份证件类型");
		documentTypeField.setRequired(true);
		documentTypeField.setLength(11);
		documentTypeField.setHidden(false);

		spouseSituationField = new DataSourceIntegerField("spouseSituation", "配偶情况 （0 无  1有）");
		spouseSituationField.setRequired(false);
		spouseSituationField.setLength(11);
		spouseSituationField.setHidden(false);

		nameField = new DataSourceTextField("name", "姓名");
		nameField.setRequired(false);
		nameField.setLength(64);
		nameField.setHidden(false);

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

		houseBorrowerField = new DataSourceIntegerField("houseBorrower", "是否房屋贷款借款人");
		houseBorrowerField.setRequired(false);
		houseBorrowerField.setLength(11);
		houseBorrowerField.setHidden(false);

		houseTypeField = new DataSourceIntegerField("houseType", "房屋证书类型");
		houseTypeField.setRequired(false);
		houseTypeField.setLength(11);
		houseTypeField.setHidden(false);

		houseFirstField = new DataSourceIntegerField("houseFirst", "是否婚前各自首套贷款且婚后分别扣除50%");
		houseFirstField.setRequired(false);
		houseFirstField.setLength(11);
		houseFirstField.setHidden(false);

		loanTypeField = new DataSourceIntegerField("loanType", "贷款类型 0公积金打开  1商业贷款");
		loanTypeField.setRequired(false);
		loanTypeField.setLength(11);
		loanTypeField.setHidden(false);

		singleChildField = new DataSourceIntegerField("singleChild", "是否独生");
		singleChildField.setRequired(false);
		singleChildField.setLength(11);
		singleChildField.setHidden(false);

		changeTypeField = new DataSourceIntegerField("changeType", "较上次报送信息是否发生变化  0 首次报送 1 无变化 2有变化");
		changeTypeField.setRequired(false);
		changeTypeField.setLength(11);
		changeTypeField.setHidden(false);

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


		setFields(yearField, employeIdField, documentTypeField, spouseSituationField, nameField, specialDeductionTypeIdField, educationTypeField, educationStageField, houseBorrowerField, houseTypeField, houseFirstField, loanTypeField, singleChildField, changeTypeField, processStatusField, plateIdField, companyIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

