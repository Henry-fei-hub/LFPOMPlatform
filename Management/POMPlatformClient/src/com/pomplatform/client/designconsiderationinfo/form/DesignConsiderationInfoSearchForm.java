package com.pomplatform.client.designconsiderationinfo.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.designconsiderationinfo.datasource.CDDesignConsiderationInfo;

public class DesignConsiderationInfoSearchForm extends SearchForm {

    private final TextItem subContractIdItem;

    public DesignConsiderationInfoSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDDesignConsiderationInfo.getInstance());
        subContractIdItem = new TextItem("subContractId", "子合同编码");
        subContractIdItem.setWidth("*");
        subContractIdItem.hide();

        setItems(subContractIdItem);

        setNumCols(4);
        ClientUtil.searchFormProcessAccordingToDevice(this);
    }

}
