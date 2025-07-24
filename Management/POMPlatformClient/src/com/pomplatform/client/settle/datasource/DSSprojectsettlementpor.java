package com.pomplatform.client.settle.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.FieldType;

public class DSSprojectsettlementpor extends DBDataSource {

	public static DSSprojectsettlementpor instance = null;

	public static DSSprojectsettlementpor getInstance() {
		if (instance == null) {
			instance = new DSSprojectsettlementpor("DSSprojectsettlementpor");
		}
		return instance;
	}

	private final DataSourceIntegerField settlementIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField remarkField;
	private final DataSourceDateField settlementDateField;
	private final DataSourceFloatField totalAmountField;
	private final DataSourceFloatField totalCostField;
    private final DataSourceFloatField settlementAmountField;
	private final DataSourceFloatField projectAmountField;
	private final DataSourceFloatField leftAmountField;
	private final DataSourceIntegerField settlementStatusField;
	private final DataSourceField detailProjectSettlementDetail;

	public DSSprojectsettlementpor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sprojectsettlementpor");

		settlementIdField = new DataSourceIntegerField("settlementId", "结算代码");
		settlementIdField.setLength(11);
		settlementIdField.setPrimaryKey(true);
		settlementIdField.setRequired(true);
		settlementIdField.setHidden(true);

		projectIdField = new DataSourceIntegerField("projectId", "项目代码");
		projectIdField.setLength(11);
		projectIdField.setRequired(true);
		projectIdField.setHidden(true);

		employeeIdField = new DataSourceIntegerField("employeeId", "结算操作人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		remarkField = new DataSourceTextField("remark", "结算原因");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		settlementDateField = new DataSourceDateField("settlementDate", "结算日期");
		settlementDateField.setRequired(false);
		settlementDateField.setHidden(false);

		totalAmountField = new DataSourceFloatField("totalAmount", "确认积分");
		totalAmountField.setLength(18);
		totalAmountField.setDecimalPad(2);
		totalAmountField.setFormat("#,###,###,###,###,##0.00");
		totalAmountField.setRequired(false);
		totalAmountField.setHidden(false);

		totalCostField = new DataSourceFloatField("totalCost", "项目成本");
		totalCostField.setLength(18);
		totalCostField.setDecimalPad(2);
		totalCostField.setFormat("#,###,###,###,###,##0.00");
		totalCostField.setRequired(false);
		totalCostField.setHidden(false);
                
                settlementAmountField = new DataSourceFloatField("settlementAmount", "结算积分");
		settlementAmountField.setLength(18);
		settlementAmountField.setDecimalPad(2);
		settlementAmountField.setFormat("#,###,###,###,###,##0.00");
		settlementAmountField.setRequired(false);
		settlementAmountField.setHidden(false);

		projectAmountField = new DataSourceFloatField("projectAmount", "项目总积分");
		projectAmountField.setLength(18);
		projectAmountField.setDecimalPad(2);
		projectAmountField.setFormat("#,###,###,###,###,##0.00");
		projectAmountField.setRequired(false);
		projectAmountField.setHidden(true);

		leftAmountField = new DataSourceFloatField("leftAmount", "剩余积分");
		leftAmountField.setLength(18);
		leftAmountField.setDecimalPad(2);
		leftAmountField.setFormat("#,###,###,###,###,##0.00");
		leftAmountField.setRequired(false);
		leftAmountField.setHidden(false);

		settlementStatusField = new DataSourceIntegerField("settlementStatus", "结算状态");
		settlementStatusField.setLength(11);
		settlementStatusField.setRequired(false);
		settlementStatusField.setHidden(false);
		settlementStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_97"));

		detailProjectSettlementDetail = new DataSourceField("detailProjectSettlementDetail", FieldType.ANY);
		detailProjectSettlementDetail.setChildrenProperty(true);
		detailProjectSettlementDetail.setChildTagName("ProjectSettlementDetail");
		detailProjectSettlementDetail.setRequired(false);
		detailProjectSettlementDetail.setHidden(true);

		setFields(settlementIdField, projectIdField, employeeIdField, remarkField, settlementDateField, totalAmountField, totalCostField,settlementAmountField, projectAmountField, leftAmountField, settlementStatusField, detailProjectSettlementDetail);
	}

}
