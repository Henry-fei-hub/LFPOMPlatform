package com.pomplatform.client.specialdeduction.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSspecialdeductiontypessor extends DBDataSource
{


	public static DSSspecialdeductiontypessor instance = null;

	public static DSSspecialdeductiontypessor getInstance() {
		if(instance == null) {
			instance = new DSSspecialdeductiontypessor("DSSspecialdeductiontypessor");
		}
		return instance;
	}

	private final DataSourceIntegerField specialDeductionTypeIdField;
	private final DataSourceTextField specialDeductionTypeNameField;
	private final DataSourceTextField scopeApplicationField;
	private final DataSourceTextField rangeApplicationField;
	private final DataSourceTextField amountDescriptionField;
	private final DataSourceTextField dateDescriptionField;
	private final DataSourceBooleanField isEnableField;
	private final DataSourceTextField remarkField;

	public DSSspecialdeductiontypessor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sspecialdeductiontypessor");


		specialDeductionTypeIdField = new DataSourceIntegerField("specialDeductionTypeId", "id");
		specialDeductionTypeIdField.setLength(11);
		specialDeductionTypeIdField.setPrimaryKey(true);
		specialDeductionTypeIdField.setRequired(true);
		specialDeductionTypeIdField.setHidden(true);


		specialDeductionTypeNameField = new DataSourceTextField("specialDeductionTypeName", "个税专项扣除类型名称");
		specialDeductionTypeNameField.setLength(64);
		specialDeductionTypeNameField.setRequired(true);
		specialDeductionTypeNameField.setHidden(false);


		scopeApplicationField = new DataSourceTextField("scopeApplication", "申请范围说明");
		scopeApplicationField.setLength(512);
		scopeApplicationField.setRequired(false);
		scopeApplicationField.setHidden(false);


		rangeApplicationField = new DataSourceTextField("rangeApplication", "适用范围说明");
		rangeApplicationField.setLength(512);
		rangeApplicationField.setRequired(false);
		rangeApplicationField.setHidden(false);


		amountDescriptionField = new DataSourceTextField("amountDescription", "金额范围说明");
		amountDescriptionField.setLength(512);
		amountDescriptionField.setRequired(false);
		amountDescriptionField.setHidden(false);


		dateDescriptionField = new DataSourceTextField("dateDescription", "时间范围说明");
		dateDescriptionField.setLength(512);
		dateDescriptionField.setRequired(false);
		dateDescriptionField.setHidden(false);


		isEnableField = new DataSourceBooleanField("isEnable", "是否可用");
		isEnableField.setRequired(false);
		isEnableField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(specialDeductionTypeIdField, specialDeductionTypeNameField, scopeApplicationField, rangeApplicationField, amountDescriptionField, dateDescriptionField, isEnableField, remarkField);
	}


}

