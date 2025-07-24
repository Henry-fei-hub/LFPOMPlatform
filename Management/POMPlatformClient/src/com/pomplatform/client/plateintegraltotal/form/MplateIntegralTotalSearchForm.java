package com.pomplatform.client.plateintegraltotal.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.plateintegraltotal.datasource.CDMplateIntegralTotal;

public class MplateIntegralTotalSearchForm extends SearchForm {

    private final ComboBoxItem plateIdItem;

    public MplateIntegralTotalSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDMplateIntegralTotal.getInstance());
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	

        setItems(plateIdItem);

        setNumCols(2);
        ClientUtil.searchFormProcessAccordingToDevice(this);
    }

}
