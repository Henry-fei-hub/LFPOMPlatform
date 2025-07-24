package com.pomplatform.client.workflow.personnelbusiness.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSPersonnelBusinessLinkTaxAmount extends DBDataSource
{


	public static DSPersonnelBusinessLinkTaxAmount instance = null;

	public static DSPersonnelBusinessLinkTaxAmount getInstance() {
		if(instance == null) {
			instance = new DSPersonnelBusinessLinkTaxAmount("DSPersonnelBusinessLinkTaxAmount");
		}
		return instance;
	}

	private final DataSourceIntegerField personnelBusinessLinkTaxAmountIdField;
	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceFloatField taxAmountField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceDateTimeField createTimeField;

	public DSPersonnelBusinessLinkTaxAmount(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("PersonnelBusinessLinkTaxAmount");


		personnelBusinessLinkTaxAmountIdField = new DataSourceIntegerField("personnelBusinessLinkTaxAmountId", "主键");
		personnelBusinessLinkTaxAmountIdField.setLength(11);
		personnelBusinessLinkTaxAmountIdField.setPrimaryKey(true);
		personnelBusinessLinkTaxAmountIdField.setRequired(true);
		personnelBusinessLinkTaxAmountIdField.setHidden(false);


		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "流程主键");
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setRequired(false);
		personnelBusinessIdField.setHidden(false);


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		taxAmountField = new DataSourceFloatField("taxAmount", "报税金额");
		taxAmountField.setLength(16);
		taxAmountField.setDecimalPad(2);
		taxAmountField.setFormat("##,###,###,###,##0.00");
		taxAmountField.setRequired(false);
		taxAmountField.setHidden(false);


		operatorField = new DataSourceIntegerField("operator", "操作人");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建日期");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		setFields(personnelBusinessLinkTaxAmountIdField, personnelBusinessIdField, companyIdField, taxAmountField, operatorField, createTimeField);
	}


}

