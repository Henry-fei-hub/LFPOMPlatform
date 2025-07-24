package com.pomplatform.client.contractinfo.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.contractinfo.datasource.CDContractInfo;

public class ContractInfoSearchForm extends SearchForm {
    
    private final SelectItem contractCodeItem;
    private final SelectItem projectCodeItem;
    private final TextItem businessTypeItem;
    
    public ContractInfoSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDContractInfo.getInstance());
        contractCodeItem = new SelectItem("contractCode", "合同名称");
        contractCodeItem.setWidth("*");
//        contractCodeItem.setValueMap(KeyValueManager.getValueMap("contracts"));
        KeyValueManager.loadValueMap("contracts",contractCodeItem);
        projectCodeItem = new SelectItem("projectCode", "项目名称");
        projectCodeItem.setWidth("*");
//        projectCodeItem.setValueMap(KeyValueManager.getValueMap("main_projects"));
        KeyValueManager.loadValueMap("main_projects",projectCodeItem);
        businessTypeItem = new TextItem("businessType", "业务类别");
        businessTypeItem.setWidth("*");
        
        setItems(contractCodeItem, projectCodeItem, businessTypeItem);
        
        setNumCols(6);
        ClientUtil.searchFormProcessAccordingToDevice(this);
    }
    
}
