package com.pomplatform.client.subcontractinfo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.subcontractinfo.datasource.DSSubContractInfo;

public class SubContractInfoGroupname1Update extends AbstractWizadPage {

    private final TextItem subContractIdItem;
    private final ComboBoxItem parentIdItem;
    private final TextItem subContractCodeItem;
    private final TextItem projectCodeItem;
    private final SelectItem businessTypeItem;
    private final SelectItem projectTypeItem;
    private final SelectItem departmentIdItem;
    private final TextItem commonAreaItem;
    private final TextItem logisticsAreaItem;
    private final TextItem moneySumItem;
    private final DateTimeItem createTimeItem;
    private final TextItem subContractNameItem;
    private final DateTimeItem updateTimeItem;
    private final TextItem projectIdItem;

    public SubContractInfoGroupname1Update() {
        DSSubContractInfo ds = DSSubContractInfo.getInstance();
        __form.setWidth100();
        __form.setHeight100();
        subContractIdItem = new TextItem("subContractId", "子合同编码");
        subContractIdItem.setWidth("*");
        subContractIdItem.setDisabled(true);
        subContractIdItem.setRequired(true);
        subContractIdItem.hide();
        IsIntegerValidator subContractIdValidator = new IsIntegerValidator();
        subContractIdItem.setValidators(subContractIdValidator);
        __formItems.add(subContractIdItem);
        parentIdItem = new ComboBoxItem("parentId", "主合同");
        parentIdItem.setWidth("*");
        parentIdItem.setValueMap((LinkedHashMap) ds.getField("parentId").getValueMap());
        __formItems.add(parentIdItem);
        subContractCodeItem = new TextItem("subContractCode", "子合同编号");
        subContractCodeItem.setWidth("*");
        subContractCodeItem.setDisabled(true);
        __formItems.add(subContractCodeItem);
        subContractNameItem = new TextItem("subContractName", "子合同名称");
        subContractNameItem.setWidth("*");
        __formItems.add(subContractNameItem);
        projectCodeItem = new TextItem("projectCode", "项目编号");
        projectCodeItem.setWidth("*");
        projectCodeItem.setDisabled(true);
        __formItems.add(projectCodeItem);
        businessTypeItem = new SelectItem("businessType", "业务类别");
        businessTypeItem.setWidth("*");
        businessTypeItem.setValueMap((LinkedHashMap) ds.getField("businessType").getValueMap());
        __formItems.add(businessTypeItem);
        projectTypeItem = new SelectItem("projectType", "项目类别");
        projectTypeItem.setWidth("*");
        projectTypeItem.setValueMap((LinkedHashMap) ds.getField("projectType").getValueMap());
        __formItems.add(projectTypeItem);
        departmentIdItem = new SelectItem("departmentId", "承接部门");
        departmentIdItem.setWidth("*");
        departmentIdItem.setValueMap((LinkedHashMap) ds.getField("departmentId").getValueMap());
        __formItems.add(departmentIdItem);
        commonAreaItem = new TextItem("commonArea", "公区面积");
        commonAreaItem.setWidth("*");
        __formItems.add(commonAreaItem);
        logisticsAreaItem = new TextItem("logisticsArea", "后勤面积");
        logisticsAreaItem.setWidth("*");
        __formItems.add(logisticsAreaItem);
        moneySumItem = new TextItem("moneySum", "小计");
        moneySumItem.setWidth("*");
        __formItems.add(moneySumItem);
        createTimeItem = new DateTimeItem("createTime", "创建时间");
        createTimeItem.setWidth("*");
        __formItems.add(createTimeItem);
        updateTimeItem = new DateTimeItem("updateTime", "修改时间");
        updateTimeItem.setWidth("*");
        __formItems.add(updateTimeItem);
        projectIdItem = new TextItem("projectId", "项目编码");
        projectIdItem.setWidth("*");
        projectIdItem.setDisabled(true);
        projectIdItem.setRequired(true);
        projectIdItem.hide();
        IsIntegerValidator projectIdValidator = new IsIntegerValidator();
        projectIdItem.setValidators(projectIdValidator);
        __formItems.add(projectIdItem);

        __form.setItems(getFormItemArray());
        __form.setDataSource(ds);
        __form.setNumCols(4);
        ClientUtil.DynamicFormProcessAccordingToDevice(__form);
        setPageMode(PAGE_MODE_UPDATE);
        addMember(__form);
    }

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSSubContractInfo.getInstance());
        manager.addMember(__form);
    }

    @Override
    public boolean checkData() {
        return true;
    }

    @Override
    public void startEdit() {
        if (getRecord() != null) {
            __form.editRecord(getRecord());
        }
    }

    @Override
    public java.util.Map getValuesAsMap() {
        Map values = __form.getValues();
        values.put("updateTime", new Date());
        return values;
    }

}
