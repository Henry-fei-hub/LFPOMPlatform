package com.pomplatform.client.memployeechangeplatedetail.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.memployeechangeplatedetail.datasource.DSMEmployeeChangePlateDetail;

public class MEmployeeChangePlateDetailGroupname1New extends AbstractWizadPage {

//	private final TextItem employeeNoItem;
    private final ComboBoxItem employeeIdItem;
    private final SelectItem yearItem;
    private final SelectItem monthItem;
//    private final SelectItem outPlateIdItem;
    private final SelectItem inPlateIdItem;
    private final TextItem remarkItem;

    public MEmployeeChangePlateDetailGroupname1New() {
        DSMEmployeeChangePlateDetail ds = DSMEmployeeChangePlateDetail.getInstance();
        __form.setWidth100();
        __form.setHeight100();
//		employeeNoItem = new TextItem("employeeNo", "工号");
//		employeeNoItem.setWidth("*");
//		employeeNoItem.setRequired(true);
//		IsStringValidator employeeNoValidator = new IsStringValidator();
//		LengthRangeValidator employeeNoLengthValidator = new LengthRangeValidator();
//		employeeNoLengthValidator.setMax(64);
//		employeeNoItem.setValidators(employeeNoValidator, employeeNoLengthValidator);
//		__formItems.add(employeeNoItem);
        employeeIdItem = new ComboBoxItem("employeeId", "姓名");
        employeeIdItem.setChangeOnKeypress(false);
        employeeIdItem.setWidth("*");
        employeeIdItem.setValueMap((LinkedHashMap) ds.getField("employeeId").getValueMap());
        __formItems.add(employeeIdItem);
        yearItem = new SelectItem("year", "年份");
        yearItem.setWidth("*");
        yearItem.setValueMap((LinkedHashMap) ds.getField("year").getValueMap());
        __formItems.add(yearItem);
        monthItem = new SelectItem("month", "月份");
        monthItem.setWidth("*");
        monthItem.setValueMap((LinkedHashMap) ds.getField("month").getValueMap());
        __formItems.add(monthItem);
//        outPlateIdItem = new SelectItem("outPlateId", "转出业务部门");
//        outPlateIdItem.setWidth("*");
//        outPlateIdItem.setValueMap((LinkedHashMap) ds.getField("outPlateId").getValueMap());
//        __formItems.add(outPlateIdItem);
        inPlateIdItem = new SelectItem("inPlateId", "转入业务部门");
        inPlateIdItem.setWidth("*");
        inPlateIdItem.setValueMap((LinkedHashMap) ds.getField("inPlateId").getValueMap());
        __formItems.add(inPlateIdItem);
        remarkItem = new TextItem("remark", "转岗原因");
        remarkItem.setWidth("*");
        __formItems.add(remarkItem);

        __form.setItems(getFormItemArray());
        __form.setDataSource(ds);
        __form.setNumCols(2);
        ClientUtil.DynamicFormProcessAccordingToDevice(__form);
        setName("职员转岗信息");
        addMember(__form);
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
    public boolean checkData() {
        return true;
    }

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSMEmployeeChangePlateDetail.getInstance());
        manager.addMember(__form);
    }

    @Override
    public java.util.Map getValuesAsMap() {
        Map map = __form.getValues();
        Date date = new Date();
        map.put("createTime", date);
        map.put("updateTime", date);
        return map;
    }

}
