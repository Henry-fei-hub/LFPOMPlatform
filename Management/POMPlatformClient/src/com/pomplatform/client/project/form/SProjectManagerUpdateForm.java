package com.pomplatform.client.project.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.project.datasource.DSSprojectccpor;

public class SProjectManagerUpdateForm extends AbstractWizadPage {

    private final TextItem projectIdItem;
    private final SelectItem contractCodeItem;
    private final TextItem contractNameItem;
    private final TextItem customerNameItem;
    private final TextItem workHoursItem;
    private final SelectItem departmentIdItem;
    private final SelectItem designPhaseItem;
    private final SelectItem projectTypeItem;
    private final TextItem projectCodeItem;
    private final TextItem projectNameItem;
    private final DateItem planStartDateItem;
    private final DateItem planEndDateItem;
    private final DateItem startDateItem;
    private final DateItem endDateItem;
    private final SelectItem statusItem;
    private final TextItem projectProgressItem;
    private final SelectItem projectManageIdItem;
    private final TextItem projectManageNameItem;
    private final TextItem projectSizeItem;
    private final TextItem projectIntegralItem;
    private final TextItem projectDescriptionItem;
    private final TextItem budgetItem;
    private final TextItem auditReasonItem;
    private final SelectItem projectLevelItem;
    private final TextItem commonAreaItem;
    private final TextItem logisticsAreaItem;
    private final TextItem percentageItem;

    public SProjectManagerUpdateForm() {
        __form = new DynamicForm();
        DSSprojectccpor ds = DSSprojectccpor.getInstance();
        __form.setWidth100();
        __form.setHeight100();
        projectIdItem = new TextItem("projectId", "项目编码");
        projectIdItem.setWidth("*");
        projectIdItem.setDisabled(true);
        projectIdItem.setRequired(true);
        projectIdItem.hide();
        IsIntegerValidator projectIdValidator = new IsIntegerValidator();
        projectIdItem.setValidators(projectIdValidator);
        contractCodeItem = new SelectItem("contractCode", "项目合同");
        contractCodeItem.setDisabled(true);
        contractCodeItem.setWidth("*");
        contractCodeItem.setValueMap(KeyValueManager.getValueMap("contracts"));
        contractNameItem = new TextItem("contractName", "合同名称");
        contractNameItem.setWidth("*");
        contractNameItem.hide();
        customerNameItem = new TextItem("customerName", "客户名称");
        customerNameItem.setWidth("*");
        customerNameItem.hide();
        workHoursItem = new TextItem("workHours", "项目总工时");
        workHoursItem.setWidth("*");
        departmentIdItem = new SelectItem("departmentId", "归属部门");
        departmentIdItem.setWidth("*");
        departmentIdItem.setValueMap((LinkedHashMap) ds.getField("departmentId").getValueMap());
        departmentIdItem.hide();
        designPhaseItem = new SelectItem("designPhase", "设计阶段");
        designPhaseItem.setWidth("*");
        designPhaseItem.setValueMap((LinkedHashMap) ds.getField("designPhase").getValueMap());
        designPhaseItem.hide();
        projectTypeItem = new SelectItem("projectType", "项目类型");
        projectTypeItem.setWidth("*");
        projectTypeItem.setValueMap((LinkedHashMap) ds.getField("projectType").getValueMap());
        projectTypeItem.setDisabled(true);
        projectCodeItem = new TextItem("projectCode", "项目编号");
        projectCodeItem.setWidth("*");
        projectNameItem = new TextItem("projectName", "项目名称");
        projectNameItem.setWidth("*");
        planStartDateItem = new DateItem("planStartDate", "计划开始日期");
        planEndDateItem = new DateItem("planEndDate", "计划结束日期");
        startDateItem = new DateItem("startDate", "实际开始日期");
        startDateItem.hide();
        endDateItem = new DateItem("endDate", "实际结束日期");
        endDateItem.hide();
        statusItem = new SelectItem("status", "项目状态");
        statusItem.setWidth("*");
        statusItem.setValueMap((LinkedHashMap) ds.getField("status").getValueMap());
        statusItem.hide();
        projectProgressItem = new TextItem("projectProgress", "项目进度");
        projectProgressItem.setWidth("*");
        projectProgressItem.hide();
        projectManageIdItem = new SelectItem("projectManageId", "项目经理");
        projectManageIdItem.setWidth("*");
        projectManageIdItem.setValueMap((LinkedHashMap) ds.getField("projectManageId").getValueMap());
        projectManageIdItem.hide();
        projectManageNameItem = new TextItem("projectManageName", "项目负责人姓名");
        projectManageNameItem.setWidth("*");
        projectManageNameItem.hide();
        projectSizeItem = new TextItem("projectSize", "项目大小");
        projectSizeItem.setWidth("*");
        projectIntegralItem = new TextItem("projectIntegral", "项目积分");
        projectIntegralItem.setWidth("*");
        projectIntegralItem.setDisabled(true);
        projectDescriptionItem = new TextItem("projectDescription", "项目描述");
        projectDescriptionItem.setWidth("*");
        budgetItem = new TextItem("budget", "项目预算");
        budgetItem.setWidth("*");
        budgetItem.hide();
        auditReasonItem = new TextItem("auditReason", "审核意见");
        auditReasonItem.setWidth("*");
        auditReasonItem.hide();
        projectLevelItem = new SelectItem("projectLevel", "项目等级");
        projectLevelItem.setWidth("*");
        projectLevelItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));
        projectLevelItem.setDisabled(true);
        commonAreaItem = new TextItem("commonArea", "公区面积");
        commonAreaItem.setWidth("*");
        commonAreaItem.setDisabled(true);
        logisticsAreaItem = new TextItem("logisticsArea", "后勤面积");
        logisticsAreaItem.setWidth("*");
        logisticsAreaItem.setDisabled(true);
        percentageItem = new TextItem("percentage", "核算比例");
        percentageItem.setWidth("*");
        percentageItem.setDisabled(true);
        __form.setItems(projectIdItem, projectNameItem,contractCodeItem,projectTypeItem,projectLevelItem, projectManageIdItem,workHoursItem,
        commonAreaItem,logisticsAreaItem,projectIntegralItem,budgetItem,projectDescriptionItem, planStartDateItem, planEndDateItem);
        __form.setDataSource(ds);
        __form.setNumCols(4);
        ClientUtil.DynamicFormProcessAccordingToDevice(__form);
        setPageMode(PAGE_MODE_UPDATE);
        addMember(__form);
    }

    @Override
    public Map<String, FormItem> getItems() {
        Map<String, FormItem> res = new HashMap<>();
        res.put("projectId", projectIdItem);
        res.put("contractCode", contractCodeItem);
        res.put("contractName", contractNameItem);
        res.put("customerName", customerNameItem);
        res.put("workHours", workHoursItem);
        res.put("departmentId", departmentIdItem);
        res.put("designPhase", designPhaseItem);
        res.put("projectType", projectTypeItem);
        res.put("projectCode", projectCodeItem);
        res.put("projectName", projectNameItem);
        res.put("planStartDate", planStartDateItem);
        res.put("planEndDate", planEndDateItem);
        res.put("startDate", startDateItem);
        res.put("endDate", endDateItem);
        res.put("status", statusItem);
        res.put("projectProgress", projectProgressItem);
        res.put("projectManageId", projectManageIdItem);
        res.put("projectManageName", projectManageNameItem);
        res.put("projectSize", projectSizeItem);
        res.put("projectIntegral", projectIntegralItem);
        res.put("projectDescription", projectDescriptionItem);
        res.put("budget", budgetItem);
        res.put("auditReason", auditReasonItem);
        res.put("projectLevel", projectLevelItem);
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
        manager.setDataSource(DSSprojectccpor.getInstance());
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
