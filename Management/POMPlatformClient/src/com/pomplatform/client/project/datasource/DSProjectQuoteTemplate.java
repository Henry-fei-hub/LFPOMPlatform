package com.pomplatform.client.project.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSProjectQuoteTemplate extends DBDataSource
{


	public static DSProjectQuoteTemplate instance = null;

	public static DSProjectQuoteTemplate getInstance() {
		if(instance == null) {
			instance = new DSProjectQuoteTemplate("DSProjectQuoteTemplate");
		}
		return instance;
	}

	private final DataSourceIntegerField projectQuoteTemplateIdField;
	private final DataSourceIntegerField businessTypeField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceTextField designContentField;
	private final DataSourceFloatField areaPriceField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField areaTypeField;
	private final DataSourceIntegerField projectQuoteTemplatesParentIdField;
	private final DataSourceTextField companyIdField;
	private final DataSourceFloatField taxField;
	private final DataSourceTextField designTypeNameField;
	private final DataSourceIntegerField designStageField;
	private final DataSourceFloatField  areaRangeStartField;
	private final DataSourceFloatField  areaRangeEndField;
	
	

	public DSProjectQuoteTemplate(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("ProjectQuoteTemplate");


		projectQuoteTemplateIdField = new DataSourceIntegerField("projectQuoteTemplateId", "主键编码");
		projectQuoteTemplateIdField.setLength(11);
		projectQuoteTemplateIdField.setPrimaryKey(true);
		projectQuoteTemplateIdField.setRequired(true);
		projectQuoteTemplateIdField.setHidden(false);


		businessTypeField = new DataSourceIntegerField("businessType", "业务类别");
		businessTypeField.setLength(11);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(false);
		//businessTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		KeyValueManager.loadValueMap("pre_business_type",businessTypeField);


		parentIdField = new DataSourceIntegerField("parentId", "父级id");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setForeignKey(dataSourceID+".projectQuoteTemplateId");
		parentIdField.setRootValue("0");
		parentIdField.setHidden(false);
		


		designContentField = new DataSourceTextField("designContent", "设计内容");
		designContentField.setLength(128);
		designContentField.setRequired(false);
		designContentField.setHidden(false);

		
		areaTypeField = new DataSourceIntegerField("areaType", "面积类型");
		KeyValueManager.loadValueMap("system_dictionary_203",areaTypeField);
		areaTypeField.setLength(11);
		areaTypeField.setRequired(false);
		areaTypeField.setHidden(false);

		areaPriceField = new DataSourceFloatField("areaPrice", "面积单价");
		areaPriceField.setLength(18);
		areaPriceField.setDecimalPad(2);
		areaPriceField.setFormat("#,###,###,###,###,##0.00");
		areaPriceField.setRequired(false);
		areaPriceField.setHidden(false);



		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);
		operateTimeField.setCanEdit(false);


		remarkField = new DataSourceTextField("remark", "补充说明");
		remarkField.setLength(2048);
		remarkField.setRequired(false);
		remarkField.setHidden(false);
		
		companyIdField = new DataSourceTextField("companyId", "归属公司");
		KeyValueManager.loadValueMap("company_records", companyIdField);
		companyIdField.setLength(50);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		
		taxField = new DataSourceFloatField("tax", "税率");
		taxField.setLength(18);
		taxField.setDecimalPad(2);
		taxField.setEmptyDisplayValue("6.00");
		taxField.setFormat("#,###,###,###,###,##0.00");
		taxField.setRequired(false);
		taxField.setHidden(false);
		
		designTypeNameField = new DataSourceTextField("designTypeName", "设计类型");
		designTypeNameField.setLength(128);
		designTypeNameField.setRequired(false);
		designTypeNameField.setHidden(false);
		
		projectQuoteTemplatesParentIdField = new DataSourceIntegerField("areaType", "面积类型");
		projectQuoteTemplatesParentIdField.setLength(11);
		projectQuoteTemplatesParentIdField.setRequired(false);
		projectQuoteTemplatesParentIdField.setHidden(true);
		
		/*private final DataSourceIntegerField designStageField;
		private final DataSourceFloatField  areaRangeStart;
		private final DataSourceFloatField  areaRangeEnd;*/

		designStageField = new DataSourceIntegerField("designStage", "设计阶段");
		KeyValueManager.loadValueMap("system_dictionary_7",designStageField);
		designStageField.setLength(11);
		designStageField.setRequired(false);
		designStageField.setHidden(false);
		
		areaRangeStartField = new DataSourceFloatField("areaRangeStart", "面积范围起");
		areaRangeStartField.setLength(24);
		areaRangeStartField.setDecimalPad(2);
		areaRangeStartField.setFormat("#,###,###,###,###,##0.00");
		areaRangeStartField.setRequired(false);
		areaRangeStartField.setHidden(false);
		
		
		areaRangeEndField = new DataSourceFloatField("areaRangeEnd", "面积范围止");
		areaRangeEndField.setLength(18);
		areaRangeEndField.setDecimalPad(2);
		areaRangeEndField.setFormat("#,###,###,###,###,##0.00");
		areaRangeEndField.setRequired(false);
		areaRangeEndField.setHidden(false);

		
		
		


		setFields(projectQuoteTemplateIdField, businessTypeField, parentIdField,designTypeNameField,designContentField, areaTypeField, areaPriceField, operateTimeField, remarkField,companyIdField,taxField,projectQuoteTemplatesParentIdField,designStageField,areaRangeStartField,areaRangeEndField);
	}


}

