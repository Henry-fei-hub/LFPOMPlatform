package com.pomplatform.client.workflow.reimbursement.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.workflow.reimbursement.datasource.DSReimbursementWithR;

public class ReimbursementWithRGroupname1Update extends AbstractWizadPage {

    private final TextItem subjectItem;
    private final TextAreaItem remarkItem;
    private final TextItem amountItem;

    public ReimbursementWithRGroupname1Update() {
        DSReimbursementWithR ds = DSReimbursementWithR.getInstance();
        __form.setWidth100();
        __form.setHeight100();
        subjectItem = new TextItem("subject", "报销事由");
        subjectItem.setWidth("*");
        __formItems.add(subjectItem);
        amountItem = new TextItem("amount", "报销总金额");
        amountItem.setDisabled(true);
        __formItems.add(amountItem);
        remarkItem = new TextAreaItem("remark", "报销详细说明");
        remarkItem.setWidth("*");
        remarkItem.setColSpan(2);
        remarkItem.setRowSpan(3);
        __formItems.add(remarkItem);

        __form.setItems(getFormItemArray());
        __form.setDataSource(ds);
        __form.setNumCols(2);
        ClientUtil.DynamicFormProcessAccordingToDevice(__form);
        setPageMode(PAGE_MODE_UPDATE);
        setName("基本信息");
        addMember(__form);
    }

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSReimbursementWithR.getInstance());
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
        return __form.getValues();
    }

}
