package com.pomplatform.client.projectreportrecorddetail.panel;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.PopupWindow;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：刘斌
 */
public class EditDepartmentManagerPanel extends AbstractWizadPage {

    private ComboBoxItem departmentManagerItem;
    public ListGridRecord[] listGridRecords;
    public PopupWindow parenWindow;
    public ProjectReportRecordDetailPanel parentPanel;

    public ProjectReportRecordDetailPanel getParentPanel() {
        return parentPanel;
    }

    public void setParentPanel(ProjectReportRecordDetailPanel parentPanel) {
        this.parentPanel = parentPanel;
    }

    public PopupWindow getParenWindow() {
        return parenWindow;
    }

    public void setParenWindow(PopupWindow parenWindow) {
        this.parenWindow = parenWindow;
    }

    public ListGridRecord[] getListGridRecords() {
        return listGridRecords;
    }

    public void setListGridRecords(ListGridRecord[] listGridRecords) {
        this.listGridRecords = listGridRecords;
    }

    @Override
    public Map getValuesAsMap() {

        Map params = __form.getValues();

        ArrayList<Map<String,Object>> lists = new ArrayList<>();
        ListGridRecord[] listGridRecords = getListGridRecords();
        for (ListGridRecord listGridRecord : listGridRecords) {
            lists.add(listGridRecord.toMap());
        }
        params.put("list", lists);
        return params;
    }

    @Override
    public boolean checkData() {
        Object value = departmentManagerItem.getValue();
        if (null == value) {
            SC.say("请选择部门经理");
            return false;
        }
        return true;
    }

    @Override
    public void startEdit() {

    }

    public void initCompetition() {

        setWidth100();
        setHeight100();

        VLayout mainLayout = new VLayout();
        mainLayout.setWidth100();
        mainLayout.setHeight100();
        addMember(mainLayout);


        departmentManagerItem = new ComboBoxItem("departmentManager", "更换部门经理");
        departmentManagerItem.setWidth("*");
        departmentManagerItem.setValueMap(KeyValueManager.getValueMap("use_employees"));
        __formItems.add(departmentManagerItem);

        __form.setItems(getFormItemArray());
        __form.setNumCols(2);
        ClientUtil.DynamicFormProcessAccordingToDevice(__form);
        setPageMode(PAGE_MODE_UPDATE);
        __form.setCellPadding(10);
        mainLayout.addMember(__form);

        ToolStrip toolStrip = new ToolStrip();
        toolStrip.addFill();
        toolStrip.setMembersMargin(5);
        mainLayout.addMember(toolStrip);

        IButton saveButton = new IButton("确定");
        toolStrip.addMember(saveButton);
        saveButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                SC.ask("提示:", "是否确定更换订单部门经理", new BooleanCallback() {
                    @Override
                    public void execute(Boolean aBoolean) {
                        if (aBoolean) {
                            Map params = getValuesAsMap();
                            params.put("opt_type", "editorDepartmentManager");
                            DBDataSource.callOperation("EP_ProjectCommonProcess", params, new DSCallback() {
                                @Override
                                public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
                                    if (dsResponse.getStatus() >= 0) {
                                        SC.say("提示:", "更新成功");
                                    }
                                    getParenWindow().close();
                                    getParentPanel().commonQuery();
                                }
                            });
                        }
                    }
                });
            }
        });

        IButton cancelButton = new IButton("取消");
        toolStrip.addMember(cancelButton);
        cancelButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                getParenWindow().close();
            }
        });

    }

}
