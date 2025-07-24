package com.pomplatform.client.projectpriceintegral.form;

import com.delicacy.client.data.KeyValueManager;
import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.projectpriceintegral.datasource.DSSprojectPricePanel;

public class SprojectPricePanelUpdateForm extends AbstractWizadPage {

    private final TextItem projectUnitPriceIdItem;
    private final SelectItem plateIdItem;
    private final SelectItem areaIdItem;
    private final SelectItem gradeIdItem;
    private final SelectItem squareIdItem;
    private final TextItem minSquareItem;
    private final TextItem maxSquareItem;
    private final TextItem unitPriceItem;

    public SprojectPricePanelUpdateForm() {
        __form = new DynamicForm();
        DSSprojectPricePanel ds = DSSprojectPricePanel.getInstance();
        __form.setWidth100();
        __form.setHeight100();
        projectUnitPriceIdItem = new TextItem("projectUnitPriceId", "项目单价");
        projectUnitPriceIdItem.setWidth("*");
        projectUnitPriceIdItem.setDisabled(true);
        projectUnitPriceIdItem.setRequired(true);
        projectUnitPriceIdItem.hide();
        IsIntegerValidator projectUnitPriceIdValidator = new IsIntegerValidator();
        projectUnitPriceIdItem.setValidators(projectUnitPriceIdValidator);
        plateIdItem = new SelectItem("plateId", "板块");
        plateIdItem.setWidth("*");
        plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
        areaIdItem = new SelectItem("areaId", "区域");
        areaIdItem.setWidth("*");
        areaIdItem.setValueMap((LinkedHashMap) ds.getField("areaId").getValueMap());
        gradeIdItem = new SelectItem("gradeId", "项目级别");
        gradeIdItem.setWidth("*");
        gradeIdItem.setValueMap((LinkedHashMap) ds.getField("gradeId").getValueMap());
        squareIdItem = new SelectItem("squareId", "面积区间");
        squareIdItem.setWidth("*");
        squareIdItem.setValueMap((LinkedHashMap) ds.getField("squareId").getValueMap());
        minSquareItem = new TextItem("minSquare", "最小面积");
        minSquareItem.setWidth("*");
        maxSquareItem = new TextItem("maxSquare", "最大面积");
        maxSquareItem.setWidth("*");
        unitPriceItem = new TextItem("unitPrice", "单价");
        unitPriceItem.setWidth("*");

        __form.setItems(projectUnitPriceIdItem, plateIdItem, areaIdItem, gradeIdItem, squareIdItem, minSquareItem, maxSquareItem, unitPriceItem);

        __form.setDataSource(ds);
        __form.setNumCols(4);
        setPageMode(PAGE_MODE_UPDATE);
        addMember(__form);
    }

    @Override
    public Map<String, FormItem> getItems() {
        Map<String, FormItem> res = new HashMap<>();
        res.put("projectUnitPriceId", projectUnitPriceIdItem);
        res.put("plateId", plateIdItem);
        res.put("areaId", areaIdItem);
        res.put("gradeId", gradeIdItem);
        res.put("squareId", squareIdItem);
        res.put("minSquare", minSquareItem);
        res.put("maxSquare", maxSquareItem);
        res.put("unitPrice", unitPriceItem);
        return res;
    }

    @Override
    public void startEdit() {
        if (getRecord() != null) {
            __form.editRecord(getRecord());
        }
    }

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSSprojectPricePanel.getInstance());
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

    private final DynamicForm __form;

}
