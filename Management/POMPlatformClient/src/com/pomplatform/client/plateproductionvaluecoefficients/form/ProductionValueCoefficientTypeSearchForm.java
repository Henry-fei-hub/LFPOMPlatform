package com.pomplatform.client.plateproductionvaluecoefficients.form;

import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.plateproductionvaluecoefficients.datasource.DSSproductionvaluecoefficienttypepor;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;

public class ProductionValueCoefficientTypeSearchForm extends SearchForm {

    private final SelectItem productionValueCoefficientTypeIdItem;

    public ProductionValueCoefficientTypeSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(DSSproductionvaluecoefficienttypepor.getInstance());
        productionValueCoefficientTypeIdItem = new SelectItem("productionValueCoefficientTypeId", "类型");
        productionValueCoefficientTypeIdItem.setWidth("*");
        setItems(productionValueCoefficientTypeIdItem);
        setNumCols(4);
        ClientUtil.searchFormProcessAccordingToDevice(this);

    }

}
