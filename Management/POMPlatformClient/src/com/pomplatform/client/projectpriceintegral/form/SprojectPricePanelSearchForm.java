package com.pomplatform.client.projectpriceintegral.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectpriceintegral.datasource.CDSprojectPricePanel;

public class SprojectPricePanelSearchForm extends SearchForm {

    private final TextItem projectUnitPriceIdItem;
    private final SelectItem plateIdItem;
    private final SelectItem areaIdItem;
    private final SelectItem gradeIdItem;
    private final SelectItem squareIdItem;

    public SprojectPricePanelSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDSprojectPricePanel.getInstance());
        projectUnitPriceIdItem = new TextItem("projectUnitPriceId", "项目单价");
        projectUnitPriceIdItem.setWidth("*");
        projectUnitPriceIdItem.hide();
        plateIdItem = new SelectItem("plateId", "板块");
        plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
        plateIdItem.setWidth("*");
        areaIdItem = new SelectItem("areaId", "区域");
        areaIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_13"));
        areaIdItem.setWidth("*");
        gradeIdItem = new SelectItem("gradeId", "项目级别");
        gradeIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));
        gradeIdItem.setWidth("*");
        squareIdItem = new SelectItem("squareId", "面积区间");
        squareIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_14"));
        squareIdItem.setWidth("*");

        setItems(projectUnitPriceIdItem, plateIdItem, areaIdItem, gradeIdItem, squareIdItem);

        setNumCols(4);
    }

}
