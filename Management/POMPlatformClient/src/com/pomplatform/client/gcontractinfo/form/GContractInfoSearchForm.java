package com.pomplatform.client.gcontractinfo.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.gcontractinfo.datasource.CDGContractInfo;

public class GContractInfoSearchForm extends SearchForm {

    private final TextItem contractCodeItem;
    private final TextItem contractNameItem;
    private final TextItem businessTypeItem;

    public GContractInfoSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDGContractInfo.getInstance());
        contractCodeItem = new TextItem("contractCode", "主合同编号");
        contractCodeItem.setWidth("*");
        contractNameItem = new TextItem("contractName", "主合同名称");
        contractNameItem.setWidth("*");
        businessTypeItem = new TextItem("businessType", "业务类别");
        businessTypeItem.setWidth("*");

        setItems(contractCodeItem, contractNameItem, businessTypeItem);

        setNumCols(6);
        ClientUtil.searchFormProcessAccordingToDevice(this);
    }

}
