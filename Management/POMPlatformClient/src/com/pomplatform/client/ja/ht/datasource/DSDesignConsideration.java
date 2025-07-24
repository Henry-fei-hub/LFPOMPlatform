package com.pomplatform.client.ja.ht.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSDesignConsideration extends DBDataSource
{


	public static DSDesignConsideration instance = null;

	public static DSDesignConsideration getInstance() {
		if(instance == null) {
			instance = new DSDesignConsideration("DSDesignConsideration");
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
	private final DataSourceTextField remarkField; //备注
	private final DataSourceFloatField interiorPriceField;//内部设计单价
	private final DataSourceFloatField interiorMoneySumField;//内部设计面积总金额
	private final DataSourceIntegerField optionTypeField;//专项,子项类型;专项标示为1,子项标示2
	
	private final DataSourceIntegerField outQuotationIdField;
	private final DataSourceFloatField splitPriceField;//拆分价
    private final DataSourceIntegerField parentIdField;//父节点
    private final DataSourceFloatField outputValueField;//产值
	
	

	public DSDesignConsideration(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("DesignConsideration");


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


		projectTypeField = new DataSourceIntegerField("projectType", "项目类别");
		projectTypeField.setLength(11);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(false);
		projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));


		mainDesignAreaNameField = new DataSourceTextField("mainDesignAreaName", "区域(设计范围)");
		mainDesignAreaNameField.setLength(64);
		mainDesignAreaNameField.setRequired(false);
		mainDesignAreaNameField.setHidden(false);


		decorationStatusField = new DataSourceIntegerField("decorationStatus", "精简装状态");
		decorationStatusField.setLength(11);
		decorationStatusField.setRequired(false);
		decorationStatusField.setHidden(false);
		decorationStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_30"));


		designAreaField = new DataSourceFloatField("designArea", "计容建筑面积(㎡)");
		designAreaField.setLength(16);
		designAreaField.setDecimalPad(2);
//		designAreaField.setFormat("##,###,###,###,###.##");
		designAreaField.setRequired(false);
		designAreaField.setHidden(false);


		designUnitPriceField = new DataSourceFloatField("designUnitPrice", "设计单价(元)");
		designUnitPriceField.setLength(16);
		designUnitPriceField.setDecimalPad(2);
//		designUnitPriceField.setFormat("##,###,###,###,##.##");
		designUnitPriceField.setRequired(false);
		designUnitPriceField.setHidden(false);


		moneySumField = new DataSourceFloatField("moneySum", "总价(设计面积*单价)");
		moneySumField.setLength(16);
		moneySumField.setDecimalPad(2);
//		moneySumField.setFormat("##,###,###,###,###.####");
		moneySumField.setRequired(false);
		moneySumField.setHidden(false);


		subContractIdField = new DataSourceIntegerField("subContractId", "子订单编码");
		subContractIdField.setLength(11);
		subContractIdField.setRequired(false);
		subContractIdField.setHidden(true);


		jobMixField = new DataSourceIntegerField("jobMix", "现场配合(次)");
		jobMixField.setLength(11);
		jobMixField.setRequired(false);
		jobMixField.setHidden(false);


		serviceAreaField = new DataSourceFloatField("serviceArea", "服务面积(㎡)");
		serviceAreaField.setLength(16);
		serviceAreaField.setDecimalPad(2);
//		serviceAreaField.setFormat("##,###,###,###,###.##");
		serviceAreaField.setRequired(false);
		serviceAreaField.setHidden(false);


		withTheAmountField = new DataSourceFloatField("withTheAmount", "配合金额(元)");
		withTheAmountField.setLength(16);
		withTheAmountField.setDecimalPad(2);
		withTheAmountField.setFormat("##,###,###,###,###.##");
		withTheAmountField.setRequired(false);
		withTheAmountField.setHidden(false);


		onSiteTimeField = new DataSourceIntegerField("onSiteTime", "驻场时间(月)");
		onSiteTimeField.setLength(11);
		onSiteTimeField.setRequired(false);
		onSiteTimeField.setHidden(false);


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
		onSiteTotalMoneyField.setHidden(false);


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
		
		remarkField=new DataSourceTextField("remark","备注");
		remarkField.setLength(30);
		
		interiorPriceField=new DataSourceFloatField("interiorPrice", "内部设计单价(元)");
		interiorPriceField.setLength(16);
		interiorPriceField.setDecimalPad(2);
//		interiorPriceField.setFormat("##,###,###,###,###.##");
		interiorPriceField.setRequired(false);
		
		interiorMoneySumField=new DataSourceFloatField("interiorMoneySum", "内部设计面积总金额");
		interiorMoneySumField.setLength(16);
		interiorMoneySumField.setDecimalPad(2);
//		interiorMoneySumField.setFormat("##,###,###,###,###.####");
		interiorMoneySumField.setRequired(false);
		
		optionTypeField = new DataSourceIntegerField("optionType", "类别");
		optionTypeField.setLength(11);
		optionTypeField.setValueMap(KeyValueManager.getValueMap("sys_classifications"));
		
		outQuotationIdField= new DataSourceIntegerField("outQuotationId", "报价单id");
		outQuotationIdField.setLength(11);
		outQuotationIdField.setHidden(true);
		
		splitPriceField=new DataSourceFloatField("splitPrice", "拆分价金额");
		splitPriceField.setLength(16);
		splitPriceField.setDecimalPad(2);
//		splitPriceField.setFormat("##,###,###,###,###.####");
		splitPriceField.setRequired(false);
		
		outputValueField=new DataSourceFloatField("outputValue", "产值");
		outputValueField.setLength(16);
		outputValueField.setDecimalPad(2);
//		outputValueField.setFormat("##,###,###,###,###.####");
		outputValueField.setRequired(false);
		outputValueField.setHidden(false);
		
		
		parentIdField = new DataSourceIntegerField("optionType", "类别");
		parentIdField.setLength(11);
		parentIdField.setValueMap(KeyValueManager.getValueMap("sys_classifications"));
		
		setFields(designConsiderationIdField,remarkField,interiorPriceField,interiorMoneySumField,optionTypeField, infoCodeField, projectCodeField, businessTypeField, projectTypeField, mainDesignAreaNameField, decorationStatusField, designAreaField, designUnitPriceField, moneySumField, subContractIdField, jobMixField, serviceAreaField, withTheAmountField, onSiteTimeField, onSitePriceField, onSiteTotalMoneyField, createTimeField, updateTimeField, orderNoField, outQuotationIdField,splitPriceField,parentIdField,outputValueField);
	}


}


















