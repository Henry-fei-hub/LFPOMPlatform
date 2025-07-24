package com.pomplatform.client.plateproductionvaluecoefficients.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.plateproductionvaluecoefficients.datasource.DSProductionValueCoefficient;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.IsFloatValidator;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;

import java.util.Map;

public class ProductionValueCoefficientNewForm extends AbstractWizadPage {


    private final TextItem productionValueCoefficientTypeIdItem;
    private final TextItem productionMinItem;
    private final TextItem productionMaxItem;
    private final TextItem intervalLinesItem;
    private final TextItem coefficientItem;
    private final SelectItem employeeIdItem;
    private final DateTimeItem operationTimeItem;
    private final DateTimeItem createTimeItem;

    public ProductionValueCoefficientNewForm() {
        DSProductionValueCoefficient ds = DSProductionValueCoefficient.getInstance();
        __form.setWidth100();
        __form.setHeight100();
        productionValueCoefficientTypeIdItem = new TextItem("productionValueCoefficientTypeId", "类型");
        productionValueCoefficientTypeIdItem.setRequired(true);
        IsIntegerValidator productionValueCoefficientTypeIdValidator = new IsIntegerValidator();
        productionValueCoefficientTypeIdItem.setValidators(productionValueCoefficientTypeIdValidator);
        __formItems.add(productionValueCoefficientTypeIdItem);
        productionMinItem = new TextItem("productionMin", "产值最小值");
        productionMinItem.setRequired(true);
        IsFloatValidator productionMinValidator = new IsFloatValidator();
        productionMinItem.setValidators(productionMinValidator);
        __formItems.add(productionMinItem);
        productionMaxItem = new TextItem("productionMax", "产值最大值");
        productionMaxItem.setRequired(true);
        IsFloatValidator productionMaxValidator = new IsFloatValidator();
        productionMaxItem.setValidators(productionMaxValidator);
        __formItems.add(productionMaxItem);
        intervalLinesItem = new TextItem("intervalLines", "区间额度");
        intervalLinesItem.setRequired(true);
        IsFloatValidator intervalLinesValidator = new IsFloatValidator();
        intervalLinesItem.setValidators(intervalLinesValidator);
        __formItems.add(intervalLinesItem);
        coefficientItem = new TextItem("coefficient", "系数");
        coefficientItem.setDecimalPad(5);
        coefficientItem.setFormat("##,##0.00000");
        coefficientItem.setRequired(true);
        IsFloatValidator coefficientValidator = new IsFloatValidator();
        coefficientItem.setValidators(coefficientValidator);
        __formItems.add(coefficientItem);
        employeeIdItem = new SelectItem("employeeId", "操作人id");
        employeeIdItem.setDefaultValue(ClientUtil.getUserId());
        employeeIdItem.setHidden(true);
        __formItems.add(employeeIdItem);
        operationTimeItem = new DateTimeItem("operationTime", "操作时间");
        __formItems.add(operationTimeItem);
        createTimeItem = new DateTimeItem("createTime", "创建时间");
        __formItems.add(createTimeItem);

        __form.setItems(getFormItemArray());
        __form.setDataSource(ds);
        __form.setNumCols(4);
        ClientUtil.DynamicFormProcessAccordingToDevice(__form);
        addMember(__form);
    }

    @Override
    public boolean checkData() {
        return true;
    }

    @Override
    public void startEdit() {
        if (getRecord() != null) __form.editRecord(getRecord());
        else __form.editNewRecord();
    }

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSProductionValueCoefficient.getInstance());
        manager.addMember(__form);
    }

    @Override
    public Map getValuesAsMap() {
        return __form.getValues();
    }


}
