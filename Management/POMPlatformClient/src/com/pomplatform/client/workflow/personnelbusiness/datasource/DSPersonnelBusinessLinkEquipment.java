package com.pomplatform.client.workflow.personnelbusiness.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSPersonnelBusinessLinkEquipment extends DBDataSource
{


	public static DSPersonnelBusinessLinkEquipment instance = null;

	public static DSPersonnelBusinessLinkEquipment getInstance() {
		if(instance == null) {
			instance = new DSPersonnelBusinessLinkEquipment("DSPersonnelBusinessLinkEquipment");
		}
		return instance;
	}

	private final DataSourceIntegerField personnelBusinessLinkEquipmentIdField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField typeField;
	private final DataSourceIntegerField amountField;
	private final DataSourceFloatField priceField;
	private final DataSourceFloatField totalPriceField;
	private final DataSourceTextField remarkField;
	private final DataSourceBooleanField isAllowedField;
	private final DataSourceDateTimeField createTimeField;

	public DSPersonnelBusinessLinkEquipment(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("PersonnelBusinessLinkEquipment");


		personnelBusinessLinkEquipmentIdField = new DataSourceIntegerField("personnelBusinessLinkEquipmentId", "设备采购");
		personnelBusinessLinkEquipmentIdField.setLength(11);
		personnelBusinessLinkEquipmentIdField.setPrimaryKey(true);
		personnelBusinessLinkEquipmentIdField.setRequired(true);
		personnelBusinessLinkEquipmentIdField.setHidden(true);


		parentIdField = new DataSourceIntegerField("parentId", "父级编码");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(true);


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);
		processTypeField.setValueMap(KeyValueManager.getValueMap("system_process_types"));


		typeField = new DataSourceIntegerField("type", "类型");
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setHidden(false);
//		typeField.setValueMap(KeyValueManager.getValueMap("equipment_types"));
		KeyValueManager.loadValueMap("equipment_types",typeField);

		amountField = new DataSourceIntegerField("amount", "数量");
		amountField.setLength(11);
		amountField.setRequired(false);
		amountField.setHidden(false);


		priceField = new DataSourceFloatField("price", "单价（元）");
		priceField.setLength(18);
		priceField.setDecimalPad(2);
		priceField.setFormat("#,###,###,###,###,##0.00");
		priceField.setRequired(false);
		priceField.setHidden(false);
		
		
		totalPriceField = new DataSourceFloatField("totalPrice", "总价（元）");
		totalPriceField.setLength(18);
		totalPriceField.setDecimalPad(2);
		totalPriceField.setFormat("#,###,###,###,###,##0.00");
		totalPriceField.setRequired(false);
		totalPriceField.setHidden(false);
		
		
		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		isAllowedField = new DataSourceBooleanField("isAllowed", "是否允许采购");
		isAllowedField.setRequired(false);
		isAllowedField.setHidden(true);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);




		setFields(personnelBusinessLinkEquipmentIdField, parentIdField, processTypeField, typeField, amountField, priceField, totalPriceField, remarkField, isAllowedField, createTimeField);
	}



}

