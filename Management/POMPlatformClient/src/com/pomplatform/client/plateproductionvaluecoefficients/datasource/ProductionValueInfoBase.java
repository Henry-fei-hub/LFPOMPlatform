package com.pomplatform.client.plateproductionvaluecoefficients.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;

/**
 * @author: xiaolong
 * @Date: 2019/9/23 16:26
 */
public class ProductionValueInfoBase extends DBDataSource {

    public static ProductionValueInfoBase instance = null;


    public static ProductionValueInfoBase getInstance() {
        if (instance == null) {
            instance = new ProductionValueInfoBase("ProductionValueInfoBase");
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

    public ProductionValueInfoBase(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_CUSTOM);
        setActionName("ProductionValueCoefficient");


        productionValueCoefficientIdField = new DataSourceIntegerField("productionValueCoefficientId", "主键");
        productionValueCoefficientIdField.setLength(11);
        productionValueCoefficientIdField.setPrimaryKey(true);
        productionValueCoefficientIdField.setRequired(true);
        productionValueCoefficientIdField.setHidden(false);


        productionValueCoefficientTypeIdField = new DataSourceIntegerField("productionValueCoefficientTypeId", "类型");
        productionValueCoefficientTypeIdField.setLength(11);
        productionValueCoefficientTypeIdField.setRequired(false);
        productionValueCoefficientTypeIdField.setHidden(false);
        productionValueCoefficientTypeIdField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));



        productionMinField = new DataSourceFloatField("productionMin", "产值最小值");
        productionMinField.setLength(128);
        productionMinField.setDecimalPad(2);
        productionMinField.setFormat("##,###,###,###,##0.00");
        productionMinField.setRequired(false);
        productionMinField.setHidden(false);


        productionMaxField = new DataSourceFloatField("productionMax", "产值最大值");
        productionMaxField.setLength(128);
        productionMaxField.setDecimalPad(2);
        productionMaxField.setFormat("##,###,###,###,##0.00");
        productionMaxField.setRequired(false);
        productionMaxField.setHidden(false);


        intervalLinesField = new DataSourceFloatField("intervalLines", "区间额度");
        intervalLinesField.setLength(128);
        intervalLinesField.setDecimalPad(2);
        intervalLinesField.setFormat("##,###,###,###,##0.00");
        intervalLinesField.setRequired(false);
        intervalLinesField.setHidden(false);


        coefficientField = new DataSourceFloatField("coefficient", "系数");
        coefficientField.setLength(128);
        coefficientField.setDecimalPad(5);
        coefficientField.setFormat("##,##0.00000");
        coefficientField.setRequired(false);
        coefficientField.setHidden(false);


        employeeIdField = new DataSourceIntegerField("employeeId", "操作人id");
        employeeIdField.setLength(128);
        employeeIdField.setRequired(false);
        employeeIdField.setHidden(false);
        employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


        operationTimeField = new DataSourceDateTimeField("operationTime", "操作时间");
        operationTimeField.setRequired(false);
        operationTimeField.setHidden(false);


        createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
        createTimeField.setRequired(false);
        createTimeField.setHidden(false);


        setFields(productionValueCoefficientIdField, productionValueCoefficientTypeIdField, productionMinField, productionMaxField, intervalLinesField, coefficientField, employeeIdField, operationTimeField, createTimeField);
    }


}
