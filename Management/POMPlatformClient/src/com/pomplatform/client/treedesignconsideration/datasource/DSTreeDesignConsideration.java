package com.pomplatform.client.treedesignconsideration.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSTreeDesignConsideration extends DBDataSource
{


	public static DSTreeDesignConsideration instance = null;

	public static DSTreeDesignConsideration getInstance() {
		if(instance == null) {
			instance = new DSTreeDesignConsideration("DSTreeDesignConsideration");
		}
		return instance;
	}

	private final DataSourceIntegerField designConsiderationIdField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceIntegerField businessTypeField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceTextField mainDesignAreaNameField;
	private final DataSourceIntegerField decorationStatusField;
	private final DataSourceFloatField designAreaField;
	private final DataSourceFloatField designUnitPriceField;
	private final DataSourceFloatField moneySumField;
	private final DataSourceIntegerField subContractIdField;
	private final DataSourceIntegerField jobMixField;
	private final DataSourceFloatField serviceAreaField;
	private final DataSourceFloatField withTheAmountField;
	private final DataSourceIntegerField onSiteTimeField;
	private final DataSourceFloatField onSitePriceField;
	private final DataSourceFloatField onSiteTotalMoneyField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField updateTimeField;
	private final DataSourceIntegerField orderNoField;
	private final DataSourceIntegerField disableTypeField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField outQuotationIdField;
	private final DataSourceFloatField interiorPriceField;
	private final DataSourceFloatField interiorMoneySumField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField optionTypeField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField orderNumField;
	private final DataSourceFloatField splitPriceField;
	private final DataSourceIntegerField parentIdField;

	public DSTreeDesignConsideration(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("TreeDesignConsideration");


		designConsiderationIdField = new DataSourceIntegerField("designConsiderationId", "设计要素编码");
		designConsiderationIdField.setLength(11);
		designConsiderationIdField.setPrimaryKey(true);
		designConsiderationIdField.setRequired(true);
		designConsiderationIdField.setHidden(true);


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(32);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(true);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(true);


		businessTypeField = new DataSourceIntegerField("businessType", "业务类型");
		businessTypeField.setLength(11);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(false);
		businessTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));


		projectTypeField = new DataSourceIntegerField("projectType", "项目类型");
		projectTypeField.setLength(11);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(false);
		projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));


		mainDesignAreaNameField = new DataSourceTextField("mainDesignAreaName", "区域");
		mainDesignAreaNameField.setLength(64);
		mainDesignAreaNameField.setRequired(false);
		mainDesignAreaNameField.setHidden(false);


		decorationStatusField = new DataSourceIntegerField("decorationStatus", "精简装状态   0精装    1简装");
		decorationStatusField.setLength(11);
		decorationStatusField.setRequired(false);
		decorationStatusField.setHidden(false);
		decorationStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_30"));


		designAreaField = new DataSourceFloatField("designArea", "设计面积");
		designAreaField.setLength(16);
		designAreaField.setDecimalPad(2);
		designAreaField.setFormat("##,###,###,###,##0.00");
		designAreaField.setRequired(false);
		designAreaField.setHidden(false);


		designUnitPriceField = new DataSourceFloatField("designUnitPrice", "设计单价");
		designUnitPriceField.setLength(16);
		designUnitPriceField.setDecimalPad(2);
		designUnitPriceField.setFormat("##,###,###,###,##0.00");
		designUnitPriceField.setRequired(false);
		designUnitPriceField.setHidden(true);


		moneySumField = new DataSourceFloatField("moneySum", "小计 设计面积总金额");
		moneySumField.setLength(16);
		moneySumField.setDecimalPad(4);
		moneySumField.setFormat("###,###,###,##0.0000");
		moneySumField.setRequired(false);
		moneySumField.setHidden(true);


		subContractIdField = new DataSourceIntegerField("subContractId", "子订单编码");
		subContractIdField.setLength(11);
		subContractIdField.setRequired(false);
		subContractIdField.setHidden(true);


		jobMixField = new DataSourceIntegerField("jobMix", "现场配合");
		jobMixField.setLength(11);
		jobMixField.setRequired(false);
		jobMixField.setHidden(true);


		serviceAreaField = new DataSourceFloatField("serviceArea", "服务面积");
		serviceAreaField.setLength(16);
		serviceAreaField.setDecimalPad(2);
		serviceAreaField.setFormat("##,###,###,###,##0.00");
		serviceAreaField.setRequired(false);
		serviceAreaField.setHidden(true);


		withTheAmountField = new DataSourceFloatField("withTheAmount", "配合金额");
		withTheAmountField.setLength(16);
		withTheAmountField.setDecimalPad(2);
		withTheAmountField.setFormat("##,###,###,###,##0.00");
		withTheAmountField.setRequired(false);
		withTheAmountField.setHidden(true);


		onSiteTimeField = new DataSourceIntegerField("onSiteTime", "驻场时间(月)");
		onSiteTimeField.setLength(11);
		onSiteTimeField.setRequired(false);
		onSiteTimeField.setHidden(true);


		onSitePriceField = new DataSourceFloatField("onSitePrice", "驻场价格(元/月)");
		onSitePriceField.setLength(16);
		onSitePriceField.setDecimalPad(2);
		onSitePriceField.setFormat("##,###,###,###,##0.00");
		onSitePriceField.setRequired(false);
		onSitePriceField.setHidden(true);


		onSiteTotalMoneyField = new DataSourceFloatField("onSiteTotalMoney", "驻场总金额(元)");
		onSiteTotalMoneyField.setLength(16);
		onSiteTotalMoneyField.setDecimalPad(2);
		onSiteTotalMoneyField.setFormat("##,###,###,###,##0.00");
		onSiteTotalMoneyField.setRequired(false);
		onSiteTotalMoneyField.setHidden(true);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		updateTimeField = new DataSourceDateTimeField("updateTime", "修改时间");
		updateTimeField.setRequired(false);
		updateTimeField.setHidden(true);


		orderNoField = new DataSourceIntegerField("orderNo", "标记补充协议字段；除0之外，其他都表示第n个补充协议");
		orderNoField.setLength(11);
		orderNoField.setRequired(false);
		orderNoField.setHidden(true);


		disableTypeField = new DataSourceIntegerField("disableType", "可操作状态 0可操作,1禁止操作");
		disableTypeField.setLength(11);
		disableTypeField.setRequired(false);
		disableTypeField.setHidden(true);

		java.util.Map<String,String> disableTypeValues = new java.util.HashMap<String,String>();
		disableTypeValues.put("可操作", "0");
		disableTypeValues.put("不可操作", "1");
		disableTypeField.setValueMap(disableTypeValues);


		contractIdField = new DataSourceIntegerField("contractId", "主订单id");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);
//		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractIdField);


		outQuotationIdField = new DataSourceIntegerField("outQuotationId", "报价单id");
		outQuotationIdField.setLength(11);
		outQuotationIdField.setRequired(false);
		outQuotationIdField.setHidden(true);


		interiorPriceField = new DataSourceFloatField("interiorPrice", "内部设计单价");
		interiorPriceField.setLength(16);
		interiorPriceField.setDecimalPad(2);
		interiorPriceField.setFormat("##,###,###,###,##0.00");
		interiorPriceField.setRequired(false);
		interiorPriceField.setHidden(true);


		interiorMoneySumField = new DataSourceFloatField("interiorMoneySum", "内部设计面积总金额");
		interiorMoneySumField.setLength(16);
		interiorMoneySumField.setDecimalPad(4);
		interiorMoneySumField.setFormat("###,###,###,##0.0000");
		interiorMoneySumField.setRequired(false);
		interiorMoneySumField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		optionTypeField = new DataSourceIntegerField("optionType", "子项and专项");
		optionTypeField.setLength(11);
		optionTypeField.setRequired(false);
		optionTypeField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "操作人(人员id)");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		orderNumField = new DataSourceIntegerField("orderNum", "报价单子项的序号编码记录(用来表示顺序)");
		orderNumField.setLength(11);
		orderNumField.setRequired(false);
		orderNumField.setHidden(true);


		splitPriceField = new DataSourceFloatField("splitPrice", "拆分价总金额");
		splitPriceField.setLength(16);
		splitPriceField.setDecimalPad(2);
		splitPriceField.setFormat("##,###,###,###,##0.00");
		splitPriceField.setRequired(false);
		splitPriceField.setHidden(false);


		parentIdField = new DataSourceIntegerField("parentId", "父节点，第一级为0");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setForeignKey(dataSourceID+".designConsiderationId");
		parentIdField.setRootValue("");
		parentIdField.setHidden(true);
//		parentIdField.setValueMap(KeyValueManager.getValueMap("project_types"));
		KeyValueManager.loadValueMap("project_types", parentIdField);


		setFields(designConsiderationIdField, infoCodeField, projectCodeField, businessTypeField, projectTypeField, mainDesignAreaNameField, decorationStatusField, designAreaField, designUnitPriceField, moneySumField, subContractIdField, jobMixField, serviceAreaField, withTheAmountField, onSiteTimeField, onSitePriceField, onSiteTotalMoneyField, createTimeField, updateTimeField, orderNoField, disableTypeField, contractIdField, outQuotationIdField, interiorPriceField, interiorMoneySumField, remarkField, optionTypeField, employeeIdField, orderNumField, splitPriceField, parentIdField);
	}


}

