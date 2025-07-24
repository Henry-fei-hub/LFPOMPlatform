package com.pomplatform.client.plateproductionvaluecoefficients.form;

import java.util.*;

import com.pomplatform.client.plateproductionvaluecoefficients.datasource.DSProductionValueCoefficient;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;

public class ProductionValueCoefficientUpdateForm extends AbstractWizadPage {


    private final TextItem productionValueCoefficientIdItem;
    private final TextItem productionValueCoefficientTypeIdItem;
    private final TextItem productionMinItem;
    private final TextItem productionMaxItem;
    private final TextItem intervalLinesItem;
    private final TextItem coefficientItem;
    private final SelectItem employeeIdItem;
    private final DateTimeItem operationTimeItem;
    private final DateTimeItem createTimeItem;

    public ProductionValueCoefficientUpdateForm() {
        DSProductionValueCoefficient ds = DSProductionValueCoefficient.getInstance();
        __form.setWidth100();
        __form.setHeight100();
        productionValueCoefficientIdItem = new TextItem("productionValueCoefficientId", "主键");
        productionValueCoefficientIdItem.setDisabled(true);
        productionValueCoefficientIdItem.setRequired(true);
        IsIntegerValidator productionValueCoefficientIdValidator = new IsIntegerValidator();
        productionValueCoefficientIdItem.setValidators(productionValueCoefficientIdValidator);
        __formItems.add(productionValueCoefficientIdItem);
        productionValueCoefficientTypeIdItem = new TextItem("productionValueCoefficientTypeId", "类型");
        productionValueCoefficientTypeIdItem.setRequired(true);
        IsIntegerValidator productionValueCoefficientTypeIdValidator = new IsIntegerValidator();
        productionValueCoefficientTypeIdItem.setValidators(productionValueCoefficientTypeIdValidator);
        __formItems.add(productionValueCoefficientTypeIdItem);
        productionMinItem = new TextItem("productionMin", "产值最小值");
        productionMinItem.setLength(16);
        productionMinItem.setDecimalPad(2);
        productionMinItem.setFormat("##,###,###,###,##0.00");
        productionMinItem.setRequired(true);
        IsFloatValidator productionMinValidator = new IsFloatValidator();
        productionMinItem.setValidators(productionMinValidator);
        __formItems.add(productionMinItem);
        productionMaxItem = new TextItem("productionMax", "产值最大值");
        productionMaxItem.setLength(16);
        productionMaxItem.setDecimalPad(2);
        productionMaxItem.setFormat("##,###,###,###,##0.00");
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
        coefficientItem.setLength(32);
        coefficientItem.setDecimalPad(5);
        coefficientItem.setFormat("##,##0.00000");
        coefficientItem.setRequired(true);
        IsFloatValidator coefficientValidator = new IsFloatValidator();
        coefficientItem.setValidators(coefficientValidator);
        __formItems.add(coefficientItem);
        employeeIdItem = new SelectItem("employeeId", "操作人id");
        employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
        __formItems.add(employeeIdItem);
        operationTimeItem = new DateTimeItem("operationTime", "操作时间");
        __formItems.add(operationTimeItem);
        createTimeItem = new DateTimeItem("createTime", "创建时间");
        __formItems.add(createTimeItem);

        __form.setItems(getFormItemArray());
        __form.setDataSource(ds);
        __form.setNumCols(4);
        ClientUtil.DynamicFormProcessAccordingToDevice(__form);
        setPageMode(PAGE_MODE_UPDATE);
        addMember(__form);
    }

    @Override
    public void startEdit() {
        if (getRecord() != null) __form.editRecord(getRecord());
    }

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSProductionValueCoefficient.getInstance());
        manager.addMember(__form);
    }

    @Override
    public boolean checkData() {
        return true;
    }

    @Override
    public Map getValuesAsMap() {
        return __form.getValues();
    }


}
