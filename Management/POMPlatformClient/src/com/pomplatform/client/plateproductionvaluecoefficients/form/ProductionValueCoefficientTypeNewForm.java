package com.pomplatform.client.plateproductionvaluecoefficients.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.plateproductionvaluecoefficientstype.datasource.DSProductionValueCoefficientType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.IsStringValidator;
import com.smartgwt.client.widgets.form.validator.LengthRangeValidator;

import java.util.Map;

public class ProductionValueCoefficientTypeNewForm extends AbstractWizadPage {

    private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
    private final TextItem coefficientTypeItem;

    public ProductionValueCoefficientTypeNewForm() {
        DSProductionValueCoefficientType ds = DSProductionValueCoefficientType.getInstance();
        __form.setWidth100();
        __form.setHeight100();
        coefficientTypeItem = new TextItem("coefficientType", shouldNotBeNull + "产值类型");
        coefficientTypeItem.setRequired(true);
        coefficientTypeItem.setWidth("*");
        IsStringValidator coefficientTypeValidator = new IsStringValidator();
        LengthRangeValidator coefficientTypeLengthValidator = new LengthRangeValidator();
        coefficientTypeLengthValidator.setMax(255);
        coefficientTypeItem.setValidators(coefficientTypeValidator, coefficientTypeLengthValidator);
        __formItems.add(coefficientTypeItem);


        __form.setItems(getFormItemArray());
        __form.setDataSource(ds);
        __form.setNumCols(4);
        ClientUtil.DynamicFormProcessAccordingToDevice(__form);
        addMember(__form);
    }

    @Override
    public boolean checkData() {
        if (!__form.validate()) {
            SC.say("请按系统提示，填入信息");
            return false;
        }
        return true;
    }

    @Override
    public void startEdit() {
        if (getRecord() != null) __form.editRecord(getRecord());
        else __form.editNewRecord();
    }

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSProductionValueCoefficientType.getInstance());
        manager.addMember(__form);
    }

    @Override
    public Map getValuesAsMap() {
        return __form.getValues();
    }


}
