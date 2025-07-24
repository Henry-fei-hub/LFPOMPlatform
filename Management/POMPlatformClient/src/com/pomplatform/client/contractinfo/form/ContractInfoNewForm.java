package com.pomplatform.client.contractinfo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.contractinfo.datasource.DSContractInfo;

public class ContractInfoNewForm extends AbstractWizadPage {
    
    private final TextItem contractCodeItem;
    private final TextItem contractNameItem;
    private final TextItem customerNameItem;
    private final DateItem startDateItem;
    private final DateItem endDateItem;
    private final SelectItem statusItem;
    private final ComboBoxItem projectCodeItem;
    private final SelectItem contractTypeItem;
    private final TextItem businessTypeItem;
    private final SelectItem flowStatusItem;
    private final SelectItem projectLevelItem;
    private final TextItem totalProjectTimeItem;
    private final TextItem signingMoneySumItem;
    private final TextItem designAreasItem;
    private final TextItem contractPriceItem;
    private final TextItem projectAddressItem;
    private final SelectItem contractFollowerItem;
    private final TextItem remarkItem;
    private final DateItem contractDateItem;
    private final SelectItem signingCompanyNameItem;
    private final DateTimeItem createTimeItem;
    private final DateTimeItem updateTimeItem;

    public ContractInfoNewForm() {
        DSContractInfo ds = DSContractInfo.getInstance();
        __form.setWidth100();
        __form.setHeight100();
        contractCodeItem = new TextItem("contractCode", "合同编号");
        contractCodeItem.setWidth("*");
        __formItems.add(contractCodeItem);
        contractNameItem = new TextItem("contractName", "合同名称");
        contractNameItem.setWidth("*");
        __formItems.add(contractNameItem);
        customerNameItem = new TextItem("customerName", "客户名称");
        customerNameItem.setWidth("*");
        __formItems.add(customerNameItem);
        signingCompanyNameItem = new SelectItem("signingCompanyName", "我方签约公司名称");
        signingCompanyNameItem.setWidth("*");
        signingCompanyNameItem.setValueMap((LinkedHashMap) ds.getField("signingCompanyName").getValueMap());
        __formItems.add(signingCompanyNameItem);
        projectCodeItem = new ComboBoxItem("projectCode", "项目编号");
//        projectCodeItem.setValueMap(KeyValueManager.getValueMap("main_projects"));
        KeyValueManager.loadValueMap("main_projects",projectCodeItem);
        projectCodeItem.setWidth("*");
        projectCodeItem.setChangeOnKeypress(false);
        projectCodeItem.setRequired(true);
        __formItems.add(projectCodeItem);
        contractFollowerItem = new SelectItem("contractFollower", "合同跟进人");
        contractFollowerItem.setDefaultValue(155);
        contractFollowerItem.setWidth("*");
        contractFollowerItem.setValueMap((LinkedHashMap) ds.getField("contractFollower").getValueMap());
        __formItems.add(contractFollowerItem);
        statusItem = new SelectItem("status", "结算状态");
        statusItem.setWidth("*");
        statusItem.setDefaultValue(0);
        statusItem.setValueMap((LinkedHashMap) ds.getField("status").getValueMap());
        __formItems.add(statusItem);
        contractTypeItem = new SelectItem("contractType", "合同类别");
        contractTypeItem.setWidth("*");
        contractTypeItem.setValueMap((LinkedHashMap) ds.getField("contractType").getValueMap());
        __formItems.add(contractTypeItem);
        businessTypeItem = new TextItem("businessType", "业务类别");
        businessTypeItem.setWidth("*");
        businessTypeItem.setDisabled(true);
        __formItems.add(businessTypeItem);
        flowStatusItem = new SelectItem("flowStatus", "审核状态");
        flowStatusItem.setWidth("*");
        flowStatusItem.setValueMap((LinkedHashMap) ds.getField("flowStatus").getValueMap());
        flowStatusItem.setDefaultValue(0);
        __formItems.add(flowStatusItem);
        projectLevelItem = new SelectItem("projectLevel", "项目等级");
        projectLevelItem.setWidth("*");
        projectLevelItem.setValueMap((LinkedHashMap) ds.getField("projectLevel").getValueMap());
        __formItems.add(projectLevelItem);
        contractDateItem = new DateItem("contractDate", "合同签订日期");
        __formItems.add(contractDateItem);
        startDateItem = new DateItem("startDate", "开始日期");
        __formItems.add(startDateItem);
        endDateItem = new DateItem("endDate", "结束日期");
        __formItems.add(endDateItem);
        totalProjectTimeItem = new TextItem("totalProjectTime", "项目总工期");
        totalProjectTimeItem.setWidth("*");
        __formItems.add(totalProjectTimeItem);
        designAreasItem = new TextItem("designAreas", "总设计面积");
        designAreasItem.setWidth("*");
        __formItems.add(designAreasItem);
        contractPriceItem = new TextItem("contractPrice", "合同单价");
        contractPriceItem.setWidth("*");
        __formItems.add(contractPriceItem);
        signingMoneySumItem = new TextItem("signingMoneySum", "签约总金额");
        signingMoneySumItem.setWidth("*");
        __formItems.add(signingMoneySumItem);
        projectAddressItem = new TextItem("projectAddress", "项目地点");
        projectAddressItem.setWidth("*");
        projectAddressItem.setRequired(true);
        IsStringValidator projectAddressValidator = new IsStringValidator();
        LengthRangeValidator projectAddressLengthValidator = new LengthRangeValidator();
        projectAddressLengthValidator.setMax(200);
        projectAddressItem.setValidators(projectAddressValidator, projectAddressLengthValidator);
        __formItems.add(projectAddressItem);
        remarkItem = new TextItem("remark", "备注");
        remarkItem.setWidth("*");
        remarkItem.setRequired(true);
        IsStringValidator remarkValidator = new IsStringValidator();
        LengthRangeValidator remarkLengthValidator = new LengthRangeValidator();
        remarkLengthValidator.setMax(512);
        remarkItem.setValidators(remarkValidator, remarkLengthValidator);
        __formItems.add(remarkItem);
        createTimeItem = new DateTimeItem("createTime", "创建时间");
        createTimeItem.hide();
        __formItems.add(createTimeItem);
        updateTimeItem = new DateTimeItem("updateTime", "修改时间");
        updateTimeItem.hide();
        __formItems.add(updateTimeItem);

        __form.setItems(getFormItemArray());
        __form.setDataSource(ds);
        __form.setNumCols(4);
        ClientUtil.DynamicFormProcessAccordingToDevice(__form);
        addMember(__form);
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
        manager.setDataSource(DSContractInfo.getInstance());
        manager.addMember(__form);
    }

    @Override
    public java.util.Map getValuesAsMap() {
        Map values =  __form.getValues();
        Date date = new Date();
        values.put("createTime", date);
        values.put("updateTime", date);
        return values;
    }

}
