package com.pomplatform.client.mainprojectinfo.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSBidPaySheetProject extends DBDataSource
{


	public static DSBidPaySheetProject instance = null;

	public static DSBidPaySheetProject getInstance() {
		if(instance == null) {
			instance = new DSBidPaySheetProject("DSBidPaySheetProject");
		}
		return instance;
	}

	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField linkIdField;
	private final DataSourceIntegerField dutyIdField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField planField;
	private final DataSourceDateField startDateField;
	private final DataSourceIntegerField startDateDetailField;
	private final DataSourceIntegerField endDateDetailField;
	private final DataSourceTextField reasonField;
	private final DataSourceTextField addressField;
	private final DataSourceIntegerField attachmentIdField;
	private final DataSourceLinkField attachmentNameField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectIdField;
	private final DataSourceTextField transportationField;
	private final DataSourceFloatField livingExpensesField;
	private final DataSourceFloatField housingFinanceField;
	private final DataSourceBooleanField provideAccommodationField;
	private final DataSourceFloatField severanceField;
	private final DataSourceIntegerField companyProvinceField;
	private final DataSourceTextField unitField;

	public DSBidPaySheetProject(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("BidPaySheetProject");


		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "人事业务编码");
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setPrimaryKey(false);
		personnelBusinessIdField.setRequired(false);
		personnelBusinessIdField.setHidden(true);


		processTypeField = new DataSourceIntegerField("processType", "类型 ");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);



		employeeIdField = new DataSourceIntegerField("employeeId", "申请人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "合同编号");
		employeeNoField.setLength(32);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(true);


		startDateField = new DataSourceDateField("startDate", "投标日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);


		startDateDetailField = new DataSourceIntegerField("startDateDetail", "投标类型");
		startDateDetailField.setLength(11);
		startDateDetailField.setRequired(false);
		startDateDetailField.setHidden(false);
		startDateDetailField.setValueMap(KeyValueManager.getValueMap("system_dictionary_129"));


		endDateDetailField = new DataSourceIntegerField("endDateDetail", "投标单位总数");
		endDateDetailField.setLength(11);
		endDateDetailField.setRequired(false);
		endDateDetailField.setHidden(false);


		reasonField = new DataSourceTextField("reason", "落标原因详情");
		reasonField.setLength(1024);
		reasonField.setRequired(false);
		reasonField.setHidden(false);



		addressField = new DataSourceTextField("address", "我方排名");
		addressField.setLength(255);
		addressField.setRequired(false);
		addressField.setHidden(false);


		planField = new DataSourceTextField("plan", "合同名称");
		planField.setLength(1024);
		planField.setRequired(false);
		planField.setHidden(true);


		projectIdField = new DataSourceTextField("projectId", "项目主键");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(255);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);
		
		companyProvinceField = new DataSourceIntegerField("companyProvince", "主办设计团队");
		companyProvinceField.setLength(255);
		companyProvinceField.setRequired(false);
		companyProvinceField.setHidden(false);
		companyProvinceField.setValueMap(KeyValueManager.getValueMap("plate_records"));

		
		unitField = new DataSourceTextField("unit", "信息编号");
		unitField.setLength(255);
		unitField.setRequired(false);
		unitField.setHidden(false);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(255);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);
		
		transportationField = new DataSourceTextField("transportation", "客户名称");
		transportationField.setLength(255);
		transportationField.setRequired(false);
		transportationField.setHidden(false);

		provideAccommodationField = new DataSourceBooleanField("provideAccommodation", "是否收到落标补偿");
		provideAccommodationField.setRequired(false);
		provideAccommodationField.setHidden(true);


		livingExpensesField = new DataSourceFloatField("livingExpenses", "投标金额(元)");
		livingExpensesField.setLength(18);
		livingExpensesField.setDecimalPad(2);
		livingExpensesField.setFormat("#,###,###,###,###,##0.00");
		livingExpensesField.setRequired(false);
		livingExpensesField.setHidden(false);


		housingFinanceField = new DataSourceFloatField("housingFinance", "落标补偿金");
		housingFinanceField.setLength(18);
		housingFinanceField.setDecimalPad(2);
		housingFinanceField.setFormat("#,###,###,###,###,##0.00");
		housingFinanceField.setRequired(false);
		housingFinanceField.setHidden(true);


		dutyIdField = new DataSourceIntegerField("dutyId", "mainProjectId");
		dutyIdField.setLength(11);
		dutyIdField.setRequired(false);
		dutyIdField.setHidden(true);


		linkIdField = new DataSourceIntegerField("linkId", "contractId");
		linkIdField.setLength(11);
		linkIdField.setRequired(false);
		linkIdField.setHidden(true);
		
		

		projectTypeField = new DataSourceIntegerField("projectType", "关闭原因");
		projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_169"));
		projectTypeField.setLength(11);
		projectTypeField.setRequired(false);


		severanceField = new DataSourceFloatField("severance", "甲方补偿金额");
		severanceField.setLength(18);
		severanceField.setDecimalPad(2);
		severanceField.setFormat("#,###,###,###,###,##0.00");
		severanceField.setRequired(false);
		severanceField.setHidden(false);


		attachmentIdField = new DataSourceIntegerField("attachmentId", "附件编码");
		attachmentIdField.setLength(11);
		attachmentIdField.setRequired(false);
		attachmentIdField.setHidden(true);


		attachmentNameField = new DataSourceLinkField("attachmentName", "附件名称");
		attachmentNameField.setLength(255);
		attachmentNameField.setRequired(false);
		attachmentNameField.setHidden(false);


		setFields(personnelBusinessIdField, processTypeField,employeeIdField, employeeNoField,planField ,projectIdField,linkIdField,dutyIdField,unitField,projectCodeField,projectNameField,companyProvinceField,transportationField,livingExpensesField,startDateField, startDateDetailField ,endDateDetailField,addressField,housingFinanceField,provideAccommodationField, severanceField,projectTypeField, reasonField ,    attachmentIdField, attachmentNameField);
	}


}

