package com.pomplatform.client.ja.ht.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValue;

public class DSOutQuotationApplication2 extends DBDataSource
{


	public static DSOutQuotationApplication2 instance = null;

	public static DSOutQuotationApplication2 getInstance() {
		if(instance == null) {
			instance = new DSOutQuotationApplication2("DSOutQuotationApplication");
		}
		return instance;
	}

	private final DataSourceIntegerField outQuotationIdField;
	private final DataSourceTextField quotationNumberField;
	private final DataSourceTextField quotationNameField;
	private final DataSourceFloatField moneySumField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceIntegerField businessTypeField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceTextField quotationFilesField;
	private final DataSourceIntegerField quotationStatusField;
	private final DataSourceIntegerField disableTypeField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceDateTimeField updateTimeField;
	private final DataSourceField detailOutDesignConsideration;

	public DSOutQuotationApplication2(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OutQuotationApplication");


		outQuotationIdField = new DataSourceIntegerField("outQuotationId", "报价单编码");
		outQuotationIdField.setLength(11);
		outQuotationIdField.setPrimaryKey(true);
		outQuotationIdField.setRequired(true);
		outQuotationIdField.setHidden(true);

		quotationNumberField = new DataSourceTextField("quotationNumber", "报价单编号");
		quotationNumberField.setLength(32);
		quotationNumberField.setRequired(false);
		quotationNumberField.setHidden(false);


		quotationNameField = new DataSourceTextField("quotationName", "报价单名称");
		quotationNameField.setLength(512);
		quotationNameField.setRequired(false);
		quotationNameField.setHidden(false);


		moneySumField = new DataSourceFloatField("moneySum", "报价单总金额");
		moneySumField.setLength(16);
		moneySumField.setDecimalPad(2);
		moneySumField.setFormat("##,###,###,###,##0.00");
		moneySumField.setRequired(false);
		moneySumField.setHidden(true);


		createTimeField = new DataSourceDateTimeField("createTime", "起草时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(32);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(false);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(255);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		businessTypeField = new DataSourceIntegerField("businessType", "业务类型");
		businessTypeField.setLength(11);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(true);


		projectTypeField = new DataSourceIntegerField("projectType", "项目类型 1项目 2前期项目");
		projectTypeField.setLength(11);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(true);


		quotationFilesField = new DataSourceTextField("quotationFiles", "报价单(原附件)");
		quotationFilesField.setLength(512);
		quotationFilesField.setRequired(false);
		quotationFilesField.setHidden(true);

		java.util.Map<String,String> quotationStatusValues = new java.util.HashMap<String,String>();
		quotationStatusValues.put("1", "成功");
		quotationStatusValues.put("2", "历史版本");
		quotationStatusValues.put("3", "报价中");
		quotationStatusField = new DataSourceIntegerField("quotationStatus", "报价单的状态");
		quotationStatusField.setLength(11);
		quotationStatusField.setRequired(false);
		quotationStatusField.setHidden(false);
		quotationStatusField.setValueMap(quotationStatusValues);


		disableTypeField = new DataSourceIntegerField("disableType", "可操作状态 0可操作,1禁止操作");
		disableTypeField.setLength(11);
		disableTypeField.setRequired(false);
		disableTypeField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "申请人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		contractIdField = new DataSourceIntegerField("contractId", "contract_id");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);


		updateTimeField = new DataSourceDateTimeField("updateTime", "修改时间");
		updateTimeField.setRequired(false);
		updateTimeField.setHidden(false);

		detailOutDesignConsideration = new DataSourceField("detailOutDesignConsideration", FieldType.ANY);
		detailOutDesignConsideration.setChildrenProperty(true);
		detailOutDesignConsideration.setChildTagName("OutDesignConsideration");
		detailOutDesignConsideration.setRequired(false);
		detailOutDesignConsideration.setHidden(true);

		setFields(outQuotationIdField, quotationNumberField, quotationNameField, moneySumField, createTimeField, infoCodeField, projectCodeField, businessTypeField, projectTypeField, quotationFilesField, quotationStatusField, disableTypeField, employeeIdField, contractIdField, updateTimeField, detailOutDesignConsideration);
	}


}

