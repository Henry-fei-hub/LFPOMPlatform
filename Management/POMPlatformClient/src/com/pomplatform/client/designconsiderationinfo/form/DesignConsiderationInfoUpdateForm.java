package com.pomplatform.client.designconsiderationinfo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.designconsiderationinfo.datasource.DSDesignConsiderationInfo;

public class DesignConsiderationInfoUpdateForm extends AbstractWizadPage {

    private final TextItem designConsiderationIdItem;
    private final TextItem mainDesignAreaNameItem;
    private final TextItem subDesignAreaNameItem;
    private final SelectItem decorationStatusItem;
    private final TextItem designAreaItem;
    private final TextItem designUnitPriceItem;
    private final TextItem moneySumItem;
    private final TextItem subContractIdItem;

    public DesignConsiderationInfoUpdateForm() {
        DSDesignConsiderationInfo ds = DSDesignConsiderationInfo.getInstance();
        __form.setWidth100();
        __form.setHeight100();
        designConsiderationIdItem = new TextItem("designConsiderationId", "设计要素编码");
        designConsiderationIdItem.setWidth("*");
        designConsiderationIdItem.setDisabled(true);
        designConsiderationIdItem.setRequired(true);
        designConsiderationIdItem.hide();
        IsIntegerValidator designConsiderationIdValidator = new IsIntegerValidator();
        designConsiderationIdItem.setValidators(designConsiderationIdValidator);
        __formItems.add(designConsiderationIdItem);
        mainDesignAreaNameItem = new TextItem("mainDesignAreaName", "主设计区域");
        mainDesignAreaNameItem.setWidth("*");
        __formItems.add(mainDesignAreaNameItem);
        subDesignAreaNameItem = new TextItem("subDesignAreaName", "子设计区域");
        subDesignAreaNameItem.setWidth("*");
        __formItems.add(subDesignAreaNameItem);
        decorationStatusItem = new SelectItem("decorationStatus", "精简装状态");
        decorationStatusItem.setWidth("*");
        decorationStatusItem.setValueMap((LinkedHashMap) ds.getField("decorationStatus").getValueMap());
        __formItems.add(decorationStatusItem);
        designAreaItem = new TextItem("designArea", "设计面积");
        designAreaItem.setWidth("*");
        __formItems.add(designAreaItem);
        designUnitPriceItem = new TextItem("designUnitPrice", "设计单价");
        designUnitPriceItem.setWidth("*");
        __formItems.add(designUnitPriceItem);
        moneySumItem = new TextItem("moneySum", "小计");
        moneySumItem.setWidth("*");
        __formItems.add(moneySumItem);
        subContractIdItem = new TextItem("subContractId", "子合同编码");
        subContractIdItem.setWidth("*");
        subContractIdItem.hide();
        __formItems.add(subContractIdItem);

        __form.setItems(getFormItemArray());
        __form.setDataSource(ds);
        __form.setNumCols(4);
        ClientUtil.DynamicFormProcessAccordingToDevice(__form);
        setPageMode(PAGE_MODE_UPDATE);
        addMember(__form);
    }

    @Override
    public void startEdit() {
        if (getRecord() != null) {
            __form.editRecord(getRecord());
        }
    }

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSDesignConsiderationInfo.getInstance());
        manager.addMember(__form);
    }

    @Override
    public boolean checkData() {
        return true;
    }

    @Override
    public java.util.Map getValuesAsMap() {
        return __form.getValues();
    }

}
