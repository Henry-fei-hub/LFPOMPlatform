package com.pomplatform.client.project.form;

import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.data.RoleDefinition;
import com.pomplatform.client.project.datasource.DSSprojectccpor;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import java.util.logging.Logger;

public class SprojectccporNewForm extends AbstractWizadPage {

    private final SelectItem contractCodeItem;
    private final TextItem workHoursItem;
    private final SelectItem projectTypeItem;
    private final SelectItem electromechanicalTypeItem;
    private final SelectItem officeTypeItem;
    private final TextItem projectCodeItem;
    private final TextItem projectNameItem;
    private final DateItem planStartDateItem;
    private final DateItem planEndDateItem;
    private final SelectItem projectManageIdItem;
    private final TextItem oldProjectDiscountItem;
    private final TextAreaItem projectDescriptionItem;
    private final TextItem totalAmountItem;
    private final SelectItem projectLevelItem;
    private final TextItem commonAreaItem;
    private final TextItem logisticsAreaItem;
    private final TextItem percentageItem;
    private static Logger __logger = Logger.getLogger("");

    public SprojectccporNewForm() {

        int plateId = ClientUtil.getPlateId();

        __form = new DynamicForm();
        DSSprojectccpor ds = DSSprojectccpor.getInstance();
        __form.setWidth100();
        __form.setHeight100();
        List<FormItem> items = new ArrayList<>();
        contractCodeItem = new SelectItem("contractCode", "项目合同");
        contractCodeItem.setWidth("*");
        contractCodeItem.setValueMap(KeyValueManager.getValueMap("contracts"));
        items.add(contractCodeItem);
        contractCodeItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                Object val = event.getValue();
                if (ClientUtil.isNullOrEmpty(val)) {
                    return;
                }
                projectCodeItem.setValue(RoleDefinition.generateProjectID(val.toString()));
                LinkedHashMap<String, String> keyValues = KeyValueManager.getValueMap("contracts");
                String contractName = keyValues.get(val.toString());
                String projectNameNew = contractName.replace("合同", "项目");
                if (projectNameNew.equals(contractName)) {
                    projectNameNew = projectNameNew.concat("项目");
                }
                projectNameItem.setValue(projectNameNew);
            }

        });

        projectCodeItem = new TextItem("projectCode", "项目编号");
        projectCodeItem.setWidth("*");
        items.add(projectCodeItem);

        projectNameItem = new TextItem("projectName", "项目名称");
        projectNameItem.setWidth("*");
        items.add(projectNameItem);

        projectTypeItem = new SelectItem("projectType", "项目类型");
        projectTypeItem.setValueMap((LinkedHashMap) ds.getField("projectType").getValueMap());
        if (!(plateId == 5 || plateId == 6)) {
            projectTypeItem.setValue(plateId);
            projectTypeItem.setDefaultValue(plateId);
        }
        items.add(projectTypeItem);

        projectLevelItem = new SelectItem("projectLevel", "项目等级");
        projectLevelItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));
        items.add(projectLevelItem);

        totalAmountItem = new TextItem("totalAmount", "项目总金额");
        if (plateId == 2 || plateId == 4 || plateId == 5 || plateId == 3) {
            items.add(totalAmountItem);
        }

        workHoursItem = new TextItem("workHours", "预估总工时");
        items.add(workHoursItem);

        officeTypeItem = new SelectItem("officeType", "办公类型");
        officeTypeItem.setValueMap((LinkedHashMap) ds.getField("officeType").getValueMap());
        if (plateId == 3) {
            items.add(officeTypeItem);
        }

        electromechanicalTypeItem = new SelectItem("electromechanicalType", "机电类型");
        electromechanicalTypeItem.setValueMap((LinkedHashMap) ds.getField("electromechanicalType").getValueMap());
        if (plateId == 5) {
            items.add(electromechanicalTypeItem);
        }

        planStartDateItem = new DateItem("planStartDate", "计划开始日期");
        planStartDateItem.setUseTextField(true);
        items.add(planStartDateItem);

        planEndDateItem = new DateItem("planEndDate", "计划结束日期");
        planEndDateItem.setUseTextField(true);
        items.add(planEndDateItem);

        projectManageIdItem = new SelectItem("projectManageId", "项目经理");
        setProjectManagerItemValueMap(projectManageIdItem, plateId);
        items.add(projectManageIdItem);

        oldProjectDiscountItem = new TextItem("oldProjectDiscount", "遗留项目折算%");
        oldProjectDiscountItem.setWidth("*");
        oldProjectDiscountItem.setDefaultValue(0);
        items.add(oldProjectDiscountItem);

        commonAreaItem = new TextItem("commonArea", "公区面积");
        commonAreaItem.setWidth("*");
        commonAreaItem.setDefaultValue(0);
        items.add(commonAreaItem);

        logisticsAreaItem = new TextItem("logisticsArea", "后勤面积");
        logisticsAreaItem.setWidth("*");
        logisticsAreaItem.setDefaultValue(0);
        items.add(logisticsAreaItem);

        percentageItem = new TextItem("percentage", "核算比例%");
        percentageItem.setWidth("*");
        percentageItem.setDefaultValue("30");
        items.add(percentageItem);

        projectDescriptionItem = new TextAreaItem("projectDescription", "项目描述");
        projectDescriptionItem.setWidth("*");
        projectDescriptionItem.setColSpan(4);
        projectDescriptionItem.setRowSpan(3);
        items.add(projectDescriptionItem);

        __form.setItems(items.toArray(new FormItem[items.size()]));

        __form.setDataSource(ds);
        __form.setNumCols(4);
        ClientUtil.DynamicFormProcessAccordingToDevice(__form);
        addMember(__form);
    }

    public static void setProjectManagerItemValueMap(FormItem item, int plateId) {
        Map params = new HashMap();
        params.put("plateId", plateId);
        params.put("roleId", RoleDefinition.ROLE_PROJECT_MANAGER);
        KeyValueManager.setValueMapFromQuery("NQ_Semployeepdror", MapUtils.toJSON(params), item);
    }

    @Override
    public boolean checkData() {
        return true;
    }

    @Override
    public void startEdit() {
        if (getRecord() != null) {
            __form.editRecord(getRecord());
        } else {
            __form.editNewRecord();
        }
    }

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSSprojectccpor.getInstance());
        manager.addMember(__form);
    }

    @Override
    public Map<String, FormItem> getItems() {
        Map<String, FormItem> res = new HashMap<>();
        res.put("contractCode", contractCodeItem);
        res.put("workHours", workHoursItem);
        res.put("projectType", projectTypeItem);
        res.put("projectCode", projectCodeItem);
        res.put("projectName", projectNameItem);
        res.put("planStartDate", planStartDateItem);
        res.put("planEndDate", planEndDateItem);
        res.put("projectManageId", projectManageIdItem);
        res.put("projectDescription", projectDescriptionItem);
        res.put("projectLevel", projectLevelItem);
        return res;
    }

    @Override
    public java.util.Map getValuesAsMap() {
        Map values = __form.getValues();
        values.put("startDate", values.get("planStartDate"));
        values.put("endDate", values.get("planEndDate"));
        return values;
    }

    private final DynamicForm __form;

}
