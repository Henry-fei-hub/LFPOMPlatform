package com.pomplatform.client.scontractreceivabletemplaterrcor.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSScontractreceivabletemplaterrcor extends DBDataSource
{


	public static DSScontractreceivabletemplaterrcor instance = null;

	public static DSScontractreceivabletemplaterrcor getInstance() {
		if(instance == null) {
			instance = new DSScontractreceivabletemplaterrcor("DSScontractreceivabletemplaterrcor");
		}
		return instance;
	}

	private final DataSourceIntegerField contractReceivableTemplateIdField;
	private final DataSourceTextField receivableNameField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField updateTimeField;
	private final DataSourceFloatField receivablePercentageField;

	public DSScontractreceivabletemplaterrcor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Scontractreceivabletemplaterrcor");


		contractReceivableTemplateIdField = new DataSourceIntegerField("contractReceivableTemplateId", "主键");
		contractReceivableTemplateIdField.setLength(11);
		contractReceivableTemplateIdField.setPrimaryKey(true);
		contractReceivableTemplateIdField.setRequired(true);
		contractReceivableTemplateIdField.setHidden(false);


		receivableNameField = new DataSourceTextField("receivableName", "阶段名称");
		receivableNameField.setLength(255);
		receivableNameField.setRequired(false);
		receivableNameField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(255);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		parentIdField = new DataSourceIntegerField("parentId", "收款阶段id的父节点");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(false);
//		parentIdField.setValueMap(KeyValueManager.getValueMap("project_types"));
		KeyValueManager.loadValueMap("project_types", parentIdField);


		operatorField = new DataSourceIntegerField("operator", "操作人");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		updateTimeField = new DataSourceDateTimeField("updateTime", "修改时间");
		updateTimeField.setRequired(false);
		updateTimeField.setHidden(false);
		
		receivablePercentageField = new DataSourceFloatField("receivablePercentage", "收款百分比");
		receivablePercentageField.setLength(18);
		receivablePercentageField.setDecimalPad(2);
		receivablePercentageField.setFormat("#,###,###,###,###,##0.00");
		receivablePercentageField.setRequired(false);
		receivablePercentageField.setHidden(false);


		setFields(contractReceivableTemplateIdField, receivableNameField, remarkField, parentIdField, operatorField, createTimeField, updateTimeField);
	}


}

