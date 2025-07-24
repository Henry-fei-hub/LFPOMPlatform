package com.pomplatform.client.plateprojectintegraldetail.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.plateprojectintegraldetail.datasource.CDMplateProjectIntegralDetail;

public class MplateProjectIntegralDetailSearchForm extends SearchForm {

    private final SelectItem plateIdItem;
    private final TextItem projectCodeItem;
    private final TextItem projectNameItem;
    private final TextItem subContractCodeItem;
    private final TextItem subContractNameItem;

    public MplateProjectIntegralDetailSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDMplateProjectIntegralDetail.getInstance());
        plateIdItem = new SelectItem("plateId", "业务部门");
        plateIdItem.hide();
        plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
        projectCodeItem = new TextItem("projectCode", "项目编号");
        projectCodeItem.setWidth("*");
        projectNameItem = new TextItem("projectName", "项目名称");
        projectNameItem.setWidth("*");
        subContractCodeItem = new TextItem("subContractCode", "子合同编号");
        subContractCodeItem.setWidth("*");
        subContractNameItem = new TextItem("subContractName", "子合同名称");
        subContractNameItem.setWidth("*");

        setItems(plateIdItem, projectCodeItem, projectNameItem, subContractCodeItem, subContractNameItem);

        setNumCols(4);
        ClientUtil.searchFormProcessAccordingToDevice(this);
    }

}
