package com.pomplatform.client.specialdeduction.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.data.DBDataSource;

public class DSMspecialdeductionrecordsor extends DBDataSource
{


	public static DSMspecialdeductionrecordsor instance = null;

	public static DSMspecialdeductionrecordsor getInstance() {
		if(instance == null) {
			instance = new DSMspecialdeductionrecordsor("DSMspecialdeductionrecordsor");
		}
		return instance;
	}

	private final DataSourceIntegerField specialDeductionRecordIdField;
	private final DataSourceIntegerField employeIdField;
	private final DataSourceIntegerField deparmentIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField documentTypeField;
	private final DataSourceTextField identificationNumberField;
	private final DataSourceTextField phoneField;
	private final DataSourceTextField taxpayerRegistrationNumberField;
	private final DataSourceTextField addressField;
	private final DataSourceTextField emailField;
	private final DataSourceTextField withholdNameField;
	private final DataSourceTextField withholdRegistrationNumberField;
	private final DataSourceIntegerField spouseSituationField;
	private final DataSourceTextField spouseNameField;
	private final DataSourceIntegerField spouseDocumentTypeField;
	private final DataSourceTextField spouseIdentificationNumberField;
	private final DataSourceBooleanField isEnableField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField specialDeductionDetailIdField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceTextField nameField;
	private final DataSourceIntegerField otherDocumentTypeField;
	private final DataSourceTextField otherIdentificationNumberField;
	private final DataSourceDateField brithdateField;
	private final DataSourceTextField nationalityRegionField;
	private final DataSourceIntegerField schoolingField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceDateField schoolingTerminationDateField;
	private final DataSourceTextField schoolingRegionField;
	private final DataSourceTextField schoolField;
	private final DataSourceIntegerField deductionPercentageField;
	private final DataSourceFloatField amountField;
	private final DataSourceIntegerField numField;
	private final DataSourceIntegerField educationTypeField;
	private final DataSourceIntegerField educationStageField;
	private final DataSourceDateField issueDateField;
	private final DataSourceTextField credentialField;
	private final DataSourceTextField credentialNumberField;
	private final DataSourceTextField issuingAuthorityField;
	private final DataSourceTextField houseAddressField;
	private final DataSourceIntegerField houseBorrowerField;
	private final DataSourceIntegerField houseTypeField;
	private final DataSourceTextField houseNumberField;
	private final DataSourceIntegerField houseFirstField;
	private final DataSourceIntegerField loanTypeField;
	private final DataSourceTextField creditorBankField;
	private final DataSourceTextField creditorContractNumberField;
	private final DataSourceDateField repaymentFirstDateField;
	private final DataSourceIntegerField repaymentField;
	private final DataSourceFloatField houseAmountField;
	private final DataSourceTextField provinceField;
	private final DataSourceTextField cityField;
	private final DataSourceIntegerField leaseTypeField;
	private final DataSourceTextField leaseAddressField;
	private final DataSourceTextField leaseContractNumberField;
	private final DataSourceIntegerField singleChildField;
	private final DataSourceTextField allocationWayField;
	private final DataSourceFloatField allocationAmountField;
	private final DataSourceIntegerField changeTypeField;
	private final DataSourceFloatField hospitalizationTotalCostField;
	private final DataSourceFloatField hospitalizationPersonalCostField;
	private final DataSourceIntegerField relationshipField;
	private final DataSourceTextField fileIdField;
	private final DataSourceLinkField fileUrlField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField specialDeductionTypeIdField;
	private final DataSourceDateTimeField createDateField;
	private final DataSourceTextField alternateField1Field;
	private final DataSourceTextField alternateField2Field;
	private final DataSourceTextField fidField;
	private final DataSourceTextField furlField;
	private final DataSourceIntegerField processStatusField;

	public DSMspecialdeductionrecordsor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mspecialdeductionrecordsor");


		specialDeductionRecordIdField = new DataSourceIntegerField("specialDeductionRecordId", "id");
		specialDeductionRecordIdField.setLength(11);
		specialDeductionRecordIdField.setPrimaryKey(true);
		specialDeductionRecordIdField.setRequired(true);
		specialDeductionRecordIdField.setHidden(true);


		employeIdField = new DataSourceIntegerField("employeId", "纳税申请人");
		employeIdField.setLength(11);
		employeIdField.setRequired(true);
		employeIdField.setHidden(false);
		employeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		deparmentIdField = new DataSourceIntegerField("deparmentId", "部门");
		deparmentIdField.setLength(11);
		deparmentIdField.setRequired(false);
		deparmentIdField.setHidden(true);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));

		documentTypeField = new DataSourceIntegerField("documentType", "身份证件类型");
		documentTypeField.setLength(11);
		documentTypeField.setRequired(true);
		documentTypeField.setHidden(false);
		documentTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_222"));

		identificationNumberField = new DataSourceTextField("identificationNumber", "纳税人身份证件号码");
		identificationNumberField.setLength(64);
		identificationNumberField.setRequired(true);
		identificationNumberField.setHidden(false);


		phoneField = new DataSourceTextField("phone", "手机号码");
		phoneField.setLength(32);
		phoneField.setRequired(true);
		phoneField.setHidden(false);


		taxpayerRegistrationNumberField = new DataSourceTextField("taxpayerRegistrationNumber", "纳税人识别号");
		taxpayerRegistrationNumberField.setLength(64);
		taxpayerRegistrationNumberField.setRequired(false);
		taxpayerRegistrationNumberField.setHidden(false);


		addressField = new DataSourceTextField("address", "联系地址");
		addressField.setLength(64);
		addressField.setRequired(false);
		addressField.setHidden(false);


		emailField = new DataSourceTextField("email", "邮箱");
		emailField.setLength(64);
		emailField.setRequired(false);
		emailField.setHidden(false);


		withholdNameField = new DataSourceTextField("withholdName", "扣缴义务人名称");
		withholdNameField.setLength(64);
		withholdNameField.setRequired(false);
		withholdNameField.setHidden(false);


		withholdRegistrationNumberField = new DataSourceTextField("withholdRegistrationNumber", "扣缴义务人纳税人识别号");
		withholdRegistrationNumberField.setLength(64);
		withholdRegistrationNumberField.setRequired(false);
		withholdRegistrationNumberField.setHidden(false);


		spouseSituationField = new DataSourceIntegerField("spouseSituation", "配偶情况");
		spouseSituationField.setLength(11);
		spouseSituationField.setRequired(false);
		spouseSituationField.setHidden(false);
		spouseSituationField.setValueMap(KeyValueManager.getValueMap("system_dictionary_200"));

		spouseNameField = new DataSourceTextField("spouseName", "配偶名称");
		spouseNameField.setLength(64);
		spouseNameField.setRequired(false);
		spouseNameField.setHidden(false);


		spouseDocumentTypeField = new DataSourceIntegerField("spouseDocumentType", "配偶身份证件类型");
		spouseDocumentTypeField.setLength(11);
		spouseDocumentTypeField.setRequired(false);
		spouseDocumentTypeField.setHidden(false);
		spouseDocumentTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_222"));


		spouseIdentificationNumberField = new DataSourceTextField("spouseIdentificationNumber", "配偶身份证件号码");
		spouseIdentificationNumberField.setLength(64);
		spouseIdentificationNumberField.setRequired(false);
		spouseIdentificationNumberField.setHidden(true);


		isEnableField = new DataSourceBooleanField("isEnable", "是否可用");
		isEnableField.setRequired(false);
		isEnableField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(true);
		
		fidField = new DataSourceTextField("fid", "fid");
		fidField.setLength(64);
		fidField.setRequired(true);
		fidField.setHidden(true);


		furlField = new DataSourceTextField("furl", "专项扣除附件url");
		furlField.setLength(64);
		furlField.setRequired(true);
		furlField.setHidden(true);


		specialDeductionDetailIdField = new DataSourceIntegerField("specialDeductionDetailId", "id");
		specialDeductionDetailIdField.setLength(11);
		specialDeductionDetailIdField.setPrimaryKey(true);
		specialDeductionDetailIdField.setRequired(true);
		specialDeductionDetailIdField.setHidden(true);


		parentIdField = new DataSourceIntegerField("parentId", "父id");
		parentIdField.setLength(11);
		parentIdField.setRequired(true);
		parentIdField.setHidden(true);


		nameField = new DataSourceTextField("name", "姓名");
		nameField.setLength(64);
		nameField.setRequired(false);
		nameField.setHidden(false);


		otherDocumentTypeField = new DataSourceIntegerField("otherDocumentType", "身份证件类型");
		otherDocumentTypeField.setLength(11);
		otherDocumentTypeField.setRequired(false);
		otherDocumentTypeField.setHidden(false);
		otherDocumentTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_222"));
		

		otherIdentificationNumberField = new DataSourceTextField("otherIdentificationNumber", "身份证件号码");
		otherIdentificationNumberField.setLength(64);
		otherIdentificationNumberField.setRequired(false);
		otherIdentificationNumberField.setHidden(false);


		brithdateField = new DataSourceDateField("brithdate", "出生日期");
		brithdateField.setRequired(false);
		brithdateField.setHidden(false);


		nationalityRegionField = new DataSourceTextField("nationalityRegion", "国籍");
		nationalityRegionField.setLength(64);
		nationalityRegionField.setRequired(false);
		nationalityRegionField.setHidden(false);


		schoolingField = new DataSourceIntegerField("schooling", "当前受教育阶段");
		schoolingField.setLength(11);
		schoolingField.setRequired(false);
		schoolingField.setHidden(false);
		schoolingField.setValueMap(KeyValueManager.getValueMap("system_dictionary_218"));

		startDateField = new DataSourceDateField("startDate", "起始时间");
		startDateField.setRequired(false);
		startDateField.setHidden(false);


		endDateField = new DataSourceDateField("endDate", "结束时间");
		endDateField.setRequired(false);
		endDateField.setHidden(false);


		schoolingTerminationDateField = new DataSourceDateField("schoolingTerminationDate", "教育终止时间");
		schoolingTerminationDateField.setRequired(false);
		schoolingTerminationDateField.setHidden(false);


		schoolingRegionField = new DataSourceTextField("schoolingRegion", "当前就读国家地区");
		schoolingRegionField.setLength(64);
		schoolingRegionField.setRequired(false);
		schoolingRegionField.setHidden(false);


		schoolField = new DataSourceTextField("school", "当前就读学校");
		schoolField.setLength(64);
		schoolField.setRequired(false);
		schoolField.setHidden(false);


		deductionPercentageField = new DataSourceIntegerField("deductionPercentage", "本人扣除比例");
		deductionPercentageField.setLength(10);
		deductionPercentageField.setDecimalPad(2);
		deductionPercentageField.setFormat("##,###,##0.00");
		deductionPercentageField.setRequired(false);
		deductionPercentageField.setHidden(false);
		deductionPercentageField.setValueMap(KeyValueManager.getValueMap("system_dictionary_224"));

		amountField = new DataSourceFloatField("amount", "每月抵扣金额");
		amountField.setLength(10);
		amountField.setDecimalPad(2);
		amountField.setFormat("##,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);

		numField = new DataSourceIntegerField("num", "个数");
		numField.setLength(11);
		numField.setRequired(false);
		numField.setHidden(true);


		educationTypeField = new DataSourceIntegerField("educationType", "继续教育类型");
		educationTypeField.setLength(11);
		educationTypeField.setRequired(false);
		educationTypeField.setHidden(false);
		educationTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_221"));

		educationStageField = new DataSourceIntegerField("educationStage", "教育阶段");
		educationStageField.setLength(11);
		educationStageField.setRequired(false);
		educationStageField.setHidden(false);
		educationStageField.setValueMap(KeyValueManager.getValueMap("system_dictionary_80"));

		issueDateField = new DataSourceDateField("issueDate", "发证日期");
		issueDateField.setRequired(false);
		issueDateField.setHidden(false);


		credentialField = new DataSourceTextField("credential", "证书名称");
		credentialField.setLength(64);
		credentialField.setRequired(false);
		credentialField.setHidden(false);


		credentialNumberField = new DataSourceTextField("credentialNumber", "证书编号");
		credentialNumberField.setLength(64);
		credentialNumberField.setRequired(false);
		credentialNumberField.setHidden(false);


		issuingAuthorityField = new DataSourceTextField("issuingAuthority", "发证机关");
		issuingAuthorityField.setLength(64);
		issuingAuthorityField.setRequired(false);
		issuingAuthorityField.setHidden(false);


		houseAddressField = new DataSourceTextField("houseAddress", "房屋坐落地址");
		houseAddressField.setLength(64);
		houseAddressField.setRequired(false);
		houseAddressField.setHidden(false);


		houseBorrowerField = new DataSourceIntegerField("houseBorrower", "是否房屋贷款借款人");
		houseBorrowerField.setLength(11);
		houseBorrowerField.setRequired(false);
		houseBorrowerField.setHidden(false);
		houseBorrowerField.setValueMap(KeyValueManager.getValueMap("system_dictionary_200"));


		houseTypeField = new DataSourceIntegerField("houseType", "房屋证书类型");
		houseTypeField.setLength(11);
		houseTypeField.setRequired(false);
		houseTypeField.setHidden(false);
		houseTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_219"));

		houseNumberField = new DataSourceTextField("houseNumber", "房屋证书编号");
		houseNumberField.setLength(64);
		houseNumberField.setRequired(false);
		houseNumberField.setHidden(false);


		houseFirstField = new DataSourceIntegerField("houseFirst", "是否婚前各自首套贷款且婚后分别扣除50%");
		houseFirstField.setLength(11);
		houseFirstField.setRequired(false);
		houseFirstField.setHidden(false);
		houseFirstField.setValueMap(KeyValueManager.getValueMap("system_dictionary_200"));

		
		loanTypeField = new DataSourceIntegerField("loanType", "贷款类型");
		loanTypeField.setLength(11);
		loanTypeField.setRequired(false);
		loanTypeField.setHidden(false);
		Map map =new HashMap<Integer,String>();
		map.put(0, "公积金贷款");
		map.put(1, "商业贷款");
		loanTypeField.setValueMap(map);

		creditorBankField = new DataSourceTextField("creditorBank", "贷款银行");
		creditorBankField.setLength(64);
		creditorBankField.setRequired(false);
		creditorBankField.setHidden(false);


		creditorContractNumberField = new DataSourceTextField("creditorContractNumber", "贷款合同编号");
		creditorContractNumberField.setLength(64);
		creditorContractNumberField.setRequired(false);
		creditorContractNumberField.setHidden(false);


		repaymentFirstDateField = new DataSourceDateField("repaymentFirstDate", "首次还款日期");
		repaymentFirstDateField.setRequired(false);
		repaymentFirstDateField.setHidden(false);


		repaymentField = new DataSourceIntegerField("repayment", "贷款期数（月数）");
		repaymentField.setLength(11);
		repaymentField.setRequired(false);
		repaymentField.setHidden(false);


		houseAmountField = new DataSourceFloatField("houseAmount", "贷款抵扣金额");
		houseAmountField.setLength(10);
		houseAmountField.setDecimalPad(2);
		houseAmountField.setFormat("##,###,##0.00");
		houseAmountField.setRequired(false);
		houseAmountField.setHidden(false);


		provinceField = new DataSourceTextField("province", "省份");
		provinceField.setLength(64);
		provinceField.setRequired(false);
		provinceField.setHidden(false);


		cityField = new DataSourceTextField("city", "城市");
		cityField.setLength(64);
		cityField.setRequired(false);
		cityField.setHidden(false);


		leaseTypeField = new DataSourceIntegerField("leaseType", "租赁类型");
		leaseTypeField.setLength(11);
		leaseTypeField.setRequired(false);
		leaseTypeField.setHidden(false);
		Map map2 =new HashMap<Integer,String>();
		map2.put(0, "个人");
		map2.put(1, "组织");
		leaseTypeField.setValueMap(map2);

		
		leaseAddressField = new DataSourceTextField("leaseAddress", "住房坐落地址");
		leaseAddressField.setLength(64);
		leaseAddressField.setRequired(false);
		leaseAddressField.setHidden(false);


		leaseContractNumberField = new DataSourceTextField("leaseContractNumber", "住房租赁合同编号");
		leaseContractNumberField.setLength(64);
		leaseContractNumberField.setRequired(false);
		leaseContractNumberField.setHidden(false);


		singleChildField = new DataSourceIntegerField("singleChild", "是否独生");
		singleChildField.setLength(11);
		singleChildField.setRequired(false);
		singleChildField.setHidden(false);
		singleChildField.setValueMap(KeyValueManager.getValueMap("system_dictionary_200"));

		allocationWayField = new DataSourceTextField("allocationWay", "分摊方式");
		allocationWayField.setLength(64);
		allocationWayField.setRequired(false);
		allocationWayField.setHidden(false);
		

		allocationAmountField = new DataSourceFloatField("allocationAmount", "本年度月扣除金额");
		allocationAmountField.setLength(10);
		allocationAmountField.setDecimalPad(2);
		allocationAmountField.setFormat("##,###,##0.00");
		allocationAmountField.setRequired(false);
		allocationAmountField.setHidden(false);


		changeTypeField = new DataSourceIntegerField("changeType", "较上次报送信息是否发生变化");
		changeTypeField.setLength(11);
		changeTypeField.setRequired(false);
		changeTypeField.setHidden(false);
		Map map3 =new HashMap<Integer,String>();
		map3.put(0, "首次报送");
		map3.put(1, "无变化");
		map3.put(2, "有变化");
		changeTypeField.setValueMap(map3);

		hospitalizationTotalCostField = new DataSourceFloatField("hospitalizationTotalCost", "医药费用总金额");
		hospitalizationTotalCostField.setLength(10);
		hospitalizationTotalCostField.setDecimalPad(2);
		hospitalizationTotalCostField.setFormat("##,###,##0.00");
		hospitalizationTotalCostField.setRequired(false);
		hospitalizationTotalCostField.setHidden(false);


		hospitalizationPersonalCostField = new DataSourceFloatField("hospitalizationPersonalCost", "个人负担金额");
		hospitalizationPersonalCostField.setLength(10);
		hospitalizationPersonalCostField.setDecimalPad(2);
		hospitalizationPersonalCostField.setFormat("##,###,##0.00");
		hospitalizationPersonalCostField.setRequired(false);
		hospitalizationPersonalCostField.setHidden(false);


		relationshipField = new DataSourceIntegerField("relationship", "与本人关系");
		relationshipField.setLength(11);
		relationshipField.setRequired(false);
		relationshipField.setHidden(false);
		Map map4 =new HashMap<Integer,String>();
		map4.put(0, "父母");
		map4.put(1, "其他");
		relationshipField.setValueMap(map4);

		fileIdField = new DataSourceTextField("fileId", "fileId");
		fileIdField.setLength(11);
		fileIdField.setRequired(false);
		fileIdField.setHidden(true);


		fileUrlField = new DataSourceLinkField("fileUrl", "附件");
		fileUrlField.setLength(11);
		fileUrlField.setRequired(false);
		fileUrlField.setHidden(false);


		yearField = new DataSourceIntegerField("year", "扣除年度");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);


		specialDeductionTypeIdField = new DataSourceIntegerField("specialDeductionTypeId", "专项类型");
		specialDeductionTypeIdField.setLength(11);
		specialDeductionTypeIdField.setRequired(false);
		specialDeductionTypeIdField.setHidden(false);
		specialDeductionTypeIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_223"));
		
		createDateField = new DataSourceDateTimeField("createDate", "创建时间");
		createDateField.setRequired(false);
		createDateField.setHidden(true);


		alternateField1Field = new DataSourceTextField("alternateField1", "备用字段1");
		alternateField1Field.setLength(512);
		alternateField1Field.setRequired(false);
		alternateField1Field.setHidden(true);


		alternateField2Field = new DataSourceTextField("alternateField2", "备用字段2");
		alternateField2Field.setLength(512);
		alternateField2Field.setRequired(false);
		alternateField2Field.setHidden(true);
		
		processStatusField = new DataSourceIntegerField("processStatus", "流程状态 ");
		processStatusField.setLength(11);
		processStatusField.setRequired(false);
		processStatusField.setHidden(false);
		processStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_120"));

		setFields(specialDeductionRecordIdField, specialDeductionDetailIdField, employeIdField, yearField, specialDeductionTypeIdField, deparmentIdField, companyIdField, plateIdField, documentTypeField, identificationNumberField, phoneField, taxpayerRegistrationNumberField, addressField, emailField, withholdNameField, withholdRegistrationNumberField, spouseSituationField, spouseNameField, spouseDocumentTypeField, spouseIdentificationNumberField, isEnableField, remarkField, parentIdField, nameField, otherDocumentTypeField, otherIdentificationNumberField, brithdateField, nationalityRegionField, schoolingField, startDateField, endDateField, schoolingTerminationDateField, schoolingRegionField, schoolField, deductionPercentageField, amountField, numField, educationTypeField, educationStageField, issueDateField, credentialField, credentialNumberField, issuingAuthorityField, houseAddressField, houseBorrowerField, houseTypeField, houseNumberField, houseFirstField, loanTypeField, creditorBankField, creditorContractNumberField, repaymentFirstDateField, repaymentField, houseAmountField, provinceField, cityField, leaseTypeField, leaseAddressField, leaseContractNumberField, singleChildField, allocationWayField, allocationAmountField, changeTypeField, hospitalizationTotalCostField, hospitalizationPersonalCostField, relationshipField, fileIdField, fileUrlField, createDateField, alternateField1Field, alternateField2Field,processStatusField,fidField,furlField);
	}


}

