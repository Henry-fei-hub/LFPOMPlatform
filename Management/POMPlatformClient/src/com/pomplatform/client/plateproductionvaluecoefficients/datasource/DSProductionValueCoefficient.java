package com.pomplatform.client.plateproductionvaluecoefficients.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSProductionValueCoefficient extends DBDataSource
{
	public static DSProductionValueCoefficient instance = null;

	public static DSProductionValueCoefficient getInstance() {
		if(instance == null) {
			instance = new DSProductionValueCoefficient("DSProductionValueCoefficient");
		}
		return instance;
	}

	private final DataSourceIntegerField productionValueCoefficientIdField;
	private final DataSourceIntegerField productionValueCoefficientTypeIdField;
	private final DataSourceFloatField productionMinField;
	private final DataSourceFloatField productionMaxField;
	private final DataSourceFloatField intervalLinesField;
	private final DataSourceFloatField coefficientField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceDateTimeField operationTimeField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceTextField intervalRangeField;

	public DSProductionValueCoefficient(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("ProductionValueCoefficient");

		productionValueCoefficientIdField = new DataSourceIntegerField("productionValueCoefficientId", "主键");
		productionValueCoefficientIdField.setLength(11);
		productionValueCoefficientIdField.setPrimaryKey(true);
		productionValueCoefficientIdField.setRequired(true);
		productionValueCoefficientIdField.setHidden(true);

		productionValueCoefficientTypeIdField = new DataSourceIntegerField("productionValueCoefficientTypeId", "类型");
		productionValueCoefficientTypeIdField.setLength(11);
		productionValueCoefficientTypeIdField.setRequired(true);
		productionValueCoefficientTypeIdField.setHidden(true);
		productionValueCoefficientTypeIdField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));

		productionMinField = new DataSourceFloatField("productionMin", "产值最小值");
		productionMinField.setLength(16);
		productionMinField.setDecimalPad(2);
		productionMinField.setFormat("##,###,###,###,##0.00");
		productionMinField.setHidden(false);

		productionMaxField = new DataSourceFloatField("productionMax", "产值最大值");
		productionMaxField.setLength(16);
		productionMaxField.setDecimalPad(2);
		productionMaxField.setFormat("##,###,###,###,##0.00");
		productionMaxField.setHidden(false);

		intervalLinesField = new DataSourceFloatField("intervalLines", "区间额度");
		intervalLinesField.setLength(16);
		intervalLinesField.setDecimalPad(2);
		intervalLinesField.setFormat("##,###,###,###,##0.00");
		intervalLinesField.setRequired(true);
		intervalLinesField.setHidden(true);

		coefficientField = new DataSourceFloatField("coefficient", "系数");
		coefficientField.setLength(32);
		coefficientField.setDecimalPad(5);
		coefficientField.setFormat("##,##0.00000");
		coefficientField.setRequired(false);
		coefficientField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "操作人id");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(true);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		operationTimeField = new DataSourceDateTimeField("operationTime", "操作时间");
		operationTimeField.setRequired(false);
		operationTimeField.setHidden(true);

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);

		intervalRangeField = new DataSourceTextField("intervalRange", "区间范围");
		intervalRangeField.setLength(255);
		intervalRangeField.setRequired(false);
		intervalRangeField.setHidden(true);

		setFields(productionValueCoefficientIdField, productionValueCoefficientTypeIdField, productionMinField, productionMaxField, intervalLinesField, coefficientField, employeeIdField, operationTimeField, createTimeField, intervalRangeField);
	}


}

