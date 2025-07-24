package com.pomplatform.client.plateintegraltransferrecord.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.plateintegraltransferrecord.datasource.CDSplateIntegralTransferRecord;

public class SplateIntegralTransferRecordSearchForm extends SearchForm {

    private final ComboBoxItem plateIdItem;

    public SplateIntegralTransferRecordSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDSplateIntegralTransferRecord.getInstance());
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	

        setItems(plateIdItem);

        setNumCols(4);
        ClientUtil.searchFormProcessAccordingToDevice(this);
    }

}
