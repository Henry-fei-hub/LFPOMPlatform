package com.pomplatform.client.workflow.commonTravelReimbursement.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.personnel.datasource.DSOnLoadFlowTravelReimbursementsApplyBuisnessData;
import com.delicacy.client.data.DBDataSource;

public class DSTravelReimbursementLinkDepartmentOne extends DBDataSource
{


	public static DSTravelReimbursementLinkDepartmentOne instance = null;

	public static DSTravelReimbursementLinkDepartmentOne getInstance() {
		if(instance == null) {
			instance = new DSTravelReimbursementLinkDepartmentOne("DSTravelReimbursementLinkDepartment");
		}
		return instance;
	}

	private final DataSourceIntegerField travelReimbursementLinkDepartmentIdField;
	private final DataSourceIntegerField travelReimbursementIdField;
	private final DataSourceTextField departmentIdField;
	private final DataSourceFloatField amountField;
	private final DataSourceFloatField inputTaxField;
	private final DataSourceFloatField finalAmountField;

	public DSTravelReimbursementLinkDepartmentOne(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("TravelReimbursementLinkDepartment");


		travelReimbursementLinkDepartmentIdField = new DataSourceIntegerField("travelReimbursementLinkDepartmentId", "主键编码");
		travelReimbursementLinkDepartmentIdField.setLength(11);
		travelReimbursementLinkDepartmentIdField.setPrimaryKey(true);
		travelReimbursementLinkDepartmentIdField.setRequired(true);
		travelReimbursementLinkDepartmentIdField.setHidden(true);


		travelReimbursementIdField = new DataSourceIntegerField("travelReimbursementId", "差旅报销详情编码");
		travelReimbursementIdField.setLength(11);
		travelReimbursementIdField.setRequired(false);
		travelReimbursementIdField.setHidden(true);
		travelReimbursementIdField.setForeignKey("DSOnLoadFlowTravelReimbursementsApplyBuisnessData.businessId");


		departmentIdField = new DataSourceTextField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		amountField = new DataSourceFloatField("amount", "费用");
		amountField.setLength(18);
		amountField.setDecimalPad(5);
		amountField.setFormat("#,###,###,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);
		
		
		inputTaxField = new DataSourceFloatField("inputTax", "进项税");
		inputTaxField.setLength(18);
		inputTaxField.setDecimalPad(5);
		inputTaxField.setFormat("#,###,###,###,##0.00");
		inputTaxField.setRequired(false);
		inputTaxField.setHidden(false);
		
		
		finalAmountField = new DataSourceFloatField("finalAmount", "成本");
		finalAmountField.setLength(18);
		finalAmountField.setDecimalPad(5);
		finalAmountField.setFormat("#,###,###,###,##0.00");
		finalAmountField.setRequired(false);
		finalAmountField.setHidden(false);


		setFields(travelReimbursementLinkDepartmentIdField, travelReimbursementIdField, departmentIdField, amountField, inputTaxField, finalAmountField);
	}


}

