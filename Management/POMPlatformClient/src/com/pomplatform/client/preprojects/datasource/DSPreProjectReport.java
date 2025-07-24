package com.pomplatform.client.preprojects.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;

import java.util.LinkedHashMap;

import com.delicacy.client.data.DBDataSource;

public class DSPreProjectReport extends DBDataSource
{


	public static DSPreProjectReport instance = null;

	public static DSPreProjectReport getInstance() {
		if(instance == null) {
			instance = new DSPreProjectReport("DSPreProjectReport");
		}
		return instance;
	}

	private final DataSourceIntegerField mainProjectIdField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField parentCustomerNameField;
	private final DataSourceTextField customerNameField;
	private final DataSourceTextField provinceField;
	private final DataSourceTextField cityField;
	private final DataSourceTextField detailAddressField;
	private final DataSourceTextField projectTypeField;
	private final DataSourceTextField totalBuildingAreasField;
	private final DataSourceTextField projectOriginationField;
	private final DataSourceTextField contactNameField;
	private final DataSourceTextField contactPhoneField;
	private final DataSourceIntegerField customerTypeField;
	private final DataSourceBooleanField isWarehousField;
	private final DataSourceBooleanField isApplyQuoteField;
	private final DataSourceTextField estimateTheDesignAreasField;
	private final DataSourceIntegerField comparisonFormField;
	private final DataSourceIntegerField regionField;
	private final DataSourceTextField gradeField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField projectNameOneField;

	public DSPreProjectReport(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("PreProjectReport");


		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "主键编码");
		mainProjectIdField.setLength(11);
		mainProjectIdField.setPrimaryKey(true);
		mainProjectIdField.setRequired(true);
		mainProjectIdField.setHidden(true);


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(32);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);

		projectNameOneField = new DataSourceTextField("projectNameOne", "修改前项目名称");
		projectNameOneField.setLength(512);
		projectNameOneField.setRequired(false);
		projectNameOneField.setHidden(false);
		
		parentCustomerNameField = new DataSourceTextField("parentCustomerName", "集团名称");
		parentCustomerNameField.setLength(50);
		parentCustomerNameField.setRequired(false);
		parentCustomerNameField.setHidden(false);
		KeyValueManager.loadValueMap("customers_name",parentCustomerNameField);

		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setLength(50);
		customerNameField.setRequired(false);
		customerNameField.setHidden(false);
//		KeyValueManager.loadValueMap("customers_name",customerNameField);


		provinceField = new DataSourceTextField("province", "省份");
		provinceField.setLength(32);
		provinceField.setRequired(false);
		provinceField.setHidden(false);


		cityField = new DataSourceTextField("city", "城市");
		cityField.setLength(32);
		cityField.setRequired(false);
		cityField.setHidden(false);
		
		regionField = new DataSourceIntegerField("region","区域");
		regionField.setLength(11);
		regionField.setValueMap(KeyValueManager.getValueMap("system_dictionary_170"));
		regionField.setHidden(false);

		detailAddressField = new DataSourceTextField("detailAddress", "详细地址");
		detailAddressField.setLength(64);
		detailAddressField.setRequired(false);
		detailAddressField.setHidden(true);


		projectTypeField = new DataSourceTextField("projectType", "项目类别");
		projectTypeField.setLength(128);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(false);
		projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_244"));
//		KeyValueManager.loadValueMap("pre_business_type",projectTypeField);


		totalBuildingAreasField = new DataSourceTextField("totalBuildingAreas", "建筑面积");
		totalBuildingAreasField.setLength(100);
		totalBuildingAreasField.setRequired(false);
		totalBuildingAreasField.setHidden(false);

		estimateTheDesignAreasField = new DataSourceTextField("estimateTheDesignAreas", "计容建筑面积(㎡)");
		estimateTheDesignAreasField.setLength(100);
		estimateTheDesignAreasField.setRequired(false);
		estimateTheDesignAreasField.setHidden(false);

		projectOriginationField = new DataSourceTextField("projectOrigination", "项目来源渠道");
		projectOriginationField.setLength(512);
		projectOriginationField.setRequired(false);
		projectOriginationField.setHidden(false);
		
		comparisonFormField = new DataSourceIntegerField("comparisonForm","比选形式");
		comparisonFormField.setLength(11);
		comparisonFormField.setValueMap(KeyValueManager.getValueMap("system_dictionary_168"));
		comparisonFormField.setHidden(false);
		
		contactNameField = new DataSourceTextField("contactName", "联系人");
		contactNameField.setLength(32);
		contactNameField.setRequired(false);
		contactNameField.setHidden(false);


		contactPhoneField = new DataSourceTextField("contactPhone", "联系人电话");
		contactPhoneField.setLength(64);
		contactPhoneField.setRequired(false);
		contactPhoneField.setHidden(false);


		customerTypeField = new DataSourceIntegerField("customerType", "客户类型");
		customerTypeField.setLength(11);
		customerTypeField.setRequired(false);
		customerTypeField.setHidden(false);
		customerTypeField.setEmptyDisplayValue("无");
		customerTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_151"));

		LinkedHashMap<Boolean, String> booleanMap = new LinkedHashMap<>();
		booleanMap.put(true, "是");
		booleanMap.put(false, "否");
		isWarehousField = new DataSourceBooleanField("isWarehous", "是否入库");
		isWarehousField.setRequired(false);
		isWarehousField.setHidden(false);
		isWarehousField.setEmptyDisplayValue("否");
		isWarehousField.setValueMap(booleanMap);

		isApplyQuoteField = new DataSourceBooleanField("isApplyQuote", "是否已提供战略报价");
		isApplyQuoteField.setRequired(false);
		isApplyQuoteField.setHidden(false);
		isApplyQuoteField.setEmptyDisplayValue("否");
		isApplyQuoteField.setValueMap(booleanMap);
		
		gradeField = new DataSourceTextField("grade","职位");
		gradeField.setLength(64);
		gradeField.setRequired(false);
		gradeField.setHidden(false);
		
		remarkField = new DataSourceTextField("remark","备注");
		remarkField.setLength(256);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		setFields(mainProjectIdField, infoCodeField, projectNameField,parentCustomerNameField, customerNameField, provinceField, cityField,regionField, contactNameField,gradeField, contactPhoneField, projectTypeField, totalBuildingAreasField,estimateTheDesignAreasField, projectOriginationField,comparisonFormField,remarkField, customerTypeField, isWarehousField, isApplyQuoteField,projectNameOneField);
	}


}

