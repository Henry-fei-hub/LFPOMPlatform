package com.pomplatform.client.subcontractinfo.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSubContractInfo extends DBDataSource {

	public static DSSubContractInfo instance = null;

	public static DSSubContractInfo getInstance() {
		if (instance == null) {
			instance = new DSSubContractInfo("DSSubContractInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField subContractIdField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceTextField subContractCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceIntegerField businessTypeField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceFloatField commonAreaField;
	private final DataSourceFloatField logisticsAreaField;
	private final DataSourceFloatField moneySumField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceTextField subContractNameField;
	private final DataSourceDateTimeField updateTimeField;
	// private final DataSourceIntegerField projectIdField;
	private final DataSourceFloatField designAreaField;
	private final DataSourceFloatField sheetTotalIntegralField;
	private final DataSourceFloatField complaintPercentageField;
	private final DataSourceFloatField complaintIntegralField;
	private final DataSourceFloatField sheetIntegralField;
	
	private final DataSourceFloatField htPercentageField;
	private final DataSourceFloatField ddPercentageField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField projectManageIdField;
	private final DataSourceBooleanField isHistoryField;
	private final DataSourceFloatField percentageField;

	public DSSubContractInfo(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SubContractInfo");

		subContractIdField = new DataSourceIntegerField("subContractId", "子合同编码");
		subContractIdField.setLength(11);
		subContractIdField.setPrimaryKey(true);
		subContractIdField.setRequired(true);
		subContractIdField.setHidden(true);

		parentIdField = new DataSourceIntegerField("parentId", "订单名称");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(true);
		parentIdField.setForeignKey("DSScontractcccor.contractId");
//		parentIdField.setValueMap(KeyValueManager.getValueMap("contracts_1"));
		KeyValueManager.loadValueMap("contracts_1", parentIdField);

		subContractCodeField = new DataSourceTextField("subContractCode", "订单编号");
		subContractCodeField.setLength(50);
		subContractCodeField.setRequired(false);
		subContractCodeField.setHidden(false);
		subContractCodeField.setCanEdit(false);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(true);

		businessTypeField = new DataSourceIntegerField("businessType", "业务类别");
		businessTypeField.setLength(11);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(true);
		businessTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		
		
		projectTypeField = new DataSourceIntegerField("projectType", "项目类别");
		projectTypeField.setLength(11);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(true);
		projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));

		departmentIdField = new DataSourceIntegerField("departmentId", "承接部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		commonAreaField = new DataSourceFloatField("commonArea", "公区面积");
		commonAreaField.setLength(10);
		commonAreaField.setDecimalPad(2);
		commonAreaField.setFormat("##,###,##0.00");
		commonAreaField.setRequired(false);
		commonAreaField.setHidden(true);

		logisticsAreaField = new DataSourceFloatField("logisticsArea", "后勤面积");
		logisticsAreaField.setLength(10);
		logisticsAreaField.setDecimalPad(2);
		logisticsAreaField.setFormat("##,###,##0.00");
		logisticsAreaField.setRequired(false);
		logisticsAreaField.setHidden(true);

		moneySumField = new DataSourceFloatField("moneySum", "总金额");
		moneySumField.setLength(16);
		moneySumField.setDecimalPad(2);
		moneySumField.setFormat("##,###,###,###,##0.00");
		moneySumField.setRequired(false);
		moneySumField.setHidden(false);

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);

		subContractNameField = new DataSourceTextField("subContractName", "订单名称");
		subContractNameField.setLength(64);
		subContractNameField.setRequired(false);
		subContractNameField.setHidden(false);

		updateTimeField = new DataSourceDateTimeField("updateTime", "修改时间");
		updateTimeField.setRequired(false);
		updateTimeField.setHidden(true);

		// projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		// projectIdField.setLength(11);
		// projectIdField.setPrimaryKey(true);
		// projectIdField.setRequired(true);
		// projectIdField.setHidden(true);

		sheetTotalIntegralField = new DataSourceFloatField("sheetTotalIntegral", "订单总积分");
		sheetTotalIntegralField.setLength(16);
		sheetTotalIntegralField.setDecimalPad(2);
		sheetTotalIntegralField.setFormat("##,###,###,###,##0.00");
		sheetTotalIntegralField.setRequired(false);
		sheetTotalIntegralField.setHidden(false);

		designAreaField = new DataSourceFloatField("designArea", "设计面积");
		designAreaField.setLength(10);
		designAreaField.setDecimalPad(2);
		designAreaField.setFormat("##,###,##0.00");
		designAreaField.setRequired(false);
		designAreaField.setHidden(true);

		complaintPercentageField = new DataSourceFloatField("complaintPercentage", "投诉保证金比例");
		complaintPercentageField.setLength(16);
		complaintPercentageField.setDecimalPad(2);
		complaintPercentageField.setFormat("##,###,###,###,##0.00");
		complaintPercentageField.setRequired(false);
		complaintPercentageField.setHidden(true);

		complaintIntegralField = new DataSourceFloatField("complaintIntegral", "投诉保证金");
		complaintIntegralField.setLength(16);
		complaintIntegralField.setDecimalPad(2);
		complaintIntegralField.setFormat("##,###,###,###,##0.00");
		complaintIntegralField.setRequired(false);
		complaintIntegralField.setHidden(true);
		complaintIntegralField.setCanEdit(false);

		sheetIntegralField = new DataSourceFloatField("sheetIntegral", "订单积分");
		sheetIntegralField.setLength(16);
		sheetIntegralField.setDecimalPad(2);
		sheetIntegralField.setFormat("##,###,###,###,##0.00");
		sheetIntegralField.setRequired(false);
		sheetIntegralField.setHidden(true);
		sheetIntegralField.setCanEdit(false);
		
		htPercentageField = new DataSourceFloatField("ht_percentage", "合同金额占比"); 
		htPercentageField.setFormat("##,###,###,###,##0.00");
		
		ddPercentageField = new DataSourceFloatField("dd_percentage", "订单金额占比"); 
		ddPercentageField.setFormat("##,###,###,###,##0.00");
		
		remarkField=new DataSourceTextField("remark","备注");

		projectManageIdField=new DataSourceIntegerField("projectManageId","专业负责人");
		projectManageIdField.setLength(11);
		projectManageIdField.setRequired(false);
		projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		
		isHistoryField = new DataSourceBooleanField("isHistory", "变更前订单");
		isHistoryField.setLength(11);
		isHistoryField.setHidden(true);
		isHistoryField.setRequired(false);
		
		percentageField = new DataSourceFloatField("percentage", "占比");
		percentageField.setLength(18);
		percentageField.setDecimalPad(2);
		percentageField.setFormat("#,###,###,###,###,##0.00");
		percentageField.setRequired(false);
		percentageField.setHidden(false);
		
		setFields(subContractIdField,subContractCodeField, businessTypeField, projectTypeField,
				departmentIdField, commonAreaField, logisticsAreaField, projectCodeField, parentIdField,
				createTimeField, updateTimeField, designAreaField, moneySumField,
				htPercentageField,ddPercentageField, sheetTotalIntegralField,
				complaintPercentageField, complaintIntegralField, sheetIntegralField,remarkField, subContractNameField,
				projectManageIdField, isHistoryField,percentageField);
	}

}
