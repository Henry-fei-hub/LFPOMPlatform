package com.pomplatform.client.project.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.project.datasource.CDSprojectccpor;

public class SprojectccporSearchForm extends SearchForm {

    private final SelectItem designPhaseItem;
    private final TextItem contractNameItem;
    private final TextItem customerNameItem;
    private final TextItem projectNameItem;
    private final TextItem contractCodeItem;
    private final IPickTreeItem departmentIdItem;
    private final SelectItem projectTypeItem;
    private final TextItem projectCodeItem;
    private final DateItem startDateItem;
    private final DateItem endDateItem;
    private final SelectItem statusItem;
    private final SelectItem projectLevelItem;

    public SprojectccporSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDSprojectccpor.getInstance());

        designPhaseItem = new SelectItem("designPhase", "设计阶段");
        designPhaseItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));
        contractNameItem = new TextItem("contractName", "合同名称");
        contractNameItem.setWidth("*");
        customerNameItem = new TextItem("customerName", "客户名称");
        customerNameItem.setWidth("*");
        projectNameItem = new TextItem("projectName", "项目名称");
        projectNameItem.setWidth("*");
        contractCodeItem = new TextItem("contractCode", "合同编号");
        contractCodeItem.setWidth("*");
        departmentIdItem = new IPickTreeItem("departmentId", "归属部门");
        departmentIdItem.setWidth("*");
//		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
        departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
        projectTypeItem = new SelectItem("projectType", "项目类型");
        projectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
        projectCodeItem = new TextItem("projectCode", "项目编号");
        projectCodeItem.setWidth("*");
        startDateItem = new DateItem("startDate", "项目开始日期");
        startDateItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                Date val = (Date) event.getValue();
                com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
            }
        });
        endDateItem = new DateItem("endDate", "项目结束日期");
        endDateItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                Date val = (Date) event.getValue();
                com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
            }
        });
        statusItem = new SelectItem("status", "项目状态");
        statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_4"));
        projectLevelItem = new SelectItem("projectLevel", "项目等级");
        projectLevelItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));

        setItems(contractCodeItem, contractNameItem, customerNameItem, projectCodeItem, projectNameItem, departmentIdItem, projectTypeItem, designPhaseItem, statusItem, projectLevelItem, startDateItem, endDateItem);

        setNumCols(8);
    }

}
