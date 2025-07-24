package com.pomplatform.client.memployeechangeplatedetail.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.memployeechangeplatedetail.datasource.DSMEmployeeChangePlateDetail;

public class MEmployeeChangePlateDetailUpdateForm extends AbstractWizadPage {

    private final TextItem employeeChangePlateDetailIdItem;
    private final TextItem employeeNoItem;
    private final SelectItem employeeIdItem;
    private final SelectItem yearItem;
    private final SelectItem monthItem;
    private final SelectItem outPlateIdItem;
    private final SelectItem inPlateIdItem;
    private final TextItem remarkItem;
    private final DateTimeItem createTimeItem;
    private final DateTimeItem updateTimeItem;

    public MEmployeeChangePlateDetailUpdateForm() {
        DSMEmployeeChangePlateDetail ds = DSMEmployeeChangePlateDetail.getInstance();
        __form.setWidth100();
        __form.setHeight100();
        employeeChangePlateDetailIdItem = new TextItem("employeeChangePlateDetailId", "编码");
        employeeChangePlateDetailIdItem.setWidth("*");
        employeeChangePlateDetailIdItem.setDisabled(true);
        employeeChangePlateDetailIdItem.setRequired(true);
        IsIntegerValidator employeeChangePlateDetailIdValidator = new IsIntegerValidator();
        employeeChangePlateDetailIdItem.setValidators(employeeChangePlateDetailIdValidator);
        __formItems.add(employeeChangePlateDetailIdItem);
        employeeNoItem = new TextItem("employeeNo", "工号");
        employeeNoItem.setWidth("*");
        employeeNoItem.setRequired(true);
        IsStringValidator employeeNoValidator = new IsStringValidator();
        LengthRangeValidator employeeNoLengthValidator = new LengthRangeValidator();
        employeeNoLengthValidator.setMax(64);
        employeeNoItem.setValidators(employeeNoValidator, employeeNoLengthValidator);
        __formItems.add(employeeNoItem);
        employeeIdItem = new SelectItem("employeeId", "姓名");
        employeeIdItem.setValueMap((LinkedHashMap) ds.getField("employeeId").getValueMap());
        __formItems.add(employeeIdItem);
        yearItem = new SelectItem("year", "年份");
        yearItem.setValueMap((LinkedHashMap) ds.getField("year").getValueMap());
        __formItems.add(yearItem);
        monthItem = new SelectItem("month", "月份");
        monthItem.setValueMap((LinkedHashMap) ds.getField("month").getValueMap());
        __formItems.add(monthItem);
        outPlateIdItem = new SelectItem("outPlateId", "转出业务部门");
        outPlateIdItem.setValueMap((LinkedHashMap) ds.getField("outPlateId").getValueMap());
        __formItems.add(outPlateIdItem);
        inPlateIdItem = new SelectItem("inPlateId", "转入业务部门");
        inPlateIdItem.setValueMap((LinkedHashMap) ds.getField("inPalteId").getValueMap());
        __formItems.add(inPlateIdItem);
        remarkItem = new TextItem("remark", "转岗原因");
        remarkItem.setWidth("*");
        __formItems.add(remarkItem);
        createTimeItem = new DateTimeItem("createTime", "创建时间");
        __formItems.add(createTimeItem);
        updateTimeItem = new DateTimeItem("updateTime", "修改时间");
        __formItems.add(updateTimeItem);

        __form.setItems(getFormItemArray());
        __form.setDataSource(ds);
        __form.setNumCols(4);
        ClientUtil.DynamicFormProcessAccordingToDevice(__form);
        setPageMode(PAGE_MODE_UPDATE);
        addMember(__form);
    }

    @Override
    public void startEdit() {
        if (getRecord() != null) {
            __form.editRecord(getRecord());
        }
    }

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSMEmployeeChangePlateDetail.getInstance());
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

}
