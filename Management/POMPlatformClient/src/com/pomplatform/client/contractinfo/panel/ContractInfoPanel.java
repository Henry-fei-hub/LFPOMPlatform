package com.pomplatform.client.contractinfo.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.app.panel.EmpDepartmentRolePanel;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.contractinfo.datasource.DSContractInfo;
import com.pomplatform.client.contractinfo.form.ContractInfoSearchForm;
import com.pomplatform.client.contractinfo.form.ContractInfoViewer;
import com.pomplatform.client.contractinfo.form.UpdateContractInfoForm;
import com.pomplatform.client.contractinfo.form.NewContractInfoForm;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.subcontractinfo.panel.SubContractInfoPanel;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;

public class ContractInfoPanel extends AbstractSearchPanel {

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            ContractInfoPanel cm = new ContractInfoPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "ContractInfo";
        }

    }

    @Override
    public void initComponents() {
        resultGrid.setShowRowNumbers(true);
        commonQuery();
        resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
//                ListGridRecord[] selected = resultGrid.getSelectedRecords();
//                String contractId = selected[0].getAttribute("contractId");
//                PopupWindow pw = new PopupWindow("子合同");
//                SubContractInfoPanel panel = new SubContractInfoPanel();
//                panel.setContractId(ClientUtil.checkAndGetIntValue(contractId));
//                pw.addItem(panel.getViewPanel());
//                pw.setWidth100();
//                pw.setHeight100();
//                pw.centerInPage();
//                pw.show();
//                panel.commonQuery();
                ListGridRecord[] selected = resultGrid.getSelectedRecords();
                ListGridRecord record = resultGrid.getSelectedRecord();
                int contractIdField = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("contractId"));
                String contractName = selected[0].getAttribute("contractName");
                PopupWindow pw = new PopupWindow();
                CustomContractMainPanel panel = new CustomContractMainPanel(contractIdField, record, 0, true);
                pw.addItem(panel);
                panel.setParentCanvas(pw);;
                pw.setTitle("合同(" + contractName + ")管理");
                pw.setWidth100();
                pw.setHeight100();
                pw.centerInPage();
                pw.show();
            }
        });
        IButton operation1Button = new IButton("查看详情");
        controlLayout.addMember(operation1Button);
        operation1Button.setIcon("[SKIN]/actions/view.png");
        operation1Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                showDetail();
            }
        });
        IButton operation2Button = PermissionControl.createPermissionButton("修改合同", ERPPermissionStatic.UPDATE_CONTRACT_INFO_BTN);
        controlLayout.addMember(operation2Button);
        operation2Button.setIcon("[SKIN]/actions/edit.png");
        operation2Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                        if (!resultGrid.anySelected()) {
                            SC.say("请选择一条数据修改");
                            return;
                        }
                        ListGridRecord[] selected = resultGrid.getSelectedRecords();
                        UpdateContractInfoForm detailForm = new UpdateContractInfoForm();
                        detailForm.setTitle("修改合同");
                        detailForm.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                RecordList list = resultGrid.getDataAsRecordList();
                                Map params = new HashMap();
                                params.put("contractId", event.getData().getAttribute("contractId"));
                                int index = list.findIndex(params);
                                if (index != -1) {
                                    RecordList newList = new RecordList();
                                    if (index > 0) {
                                        newList.addList(list.getRange(0, index));
                                    }
                                    newList.add(event.getData());
                                    if (index < list.getLength() - 1) {
                                        newList.addList(list.getRange(index + 1, list.getLength()));
                                    }
                                    resultGrid.setData(newList);
                                    resultGrid.selectSingleRecord(index);
                                }
                            }
                        });
                        detailForm.setSearchForm(searchForm);
                        detailForm.setRecord(selected[0]);
                        detailForm.setCurrentPage(getCurrentPage());
                        detailForm.initComponents();
                        detailForm.startEdit();
                        detailForm.setWidth100();
                        detailForm.setHeight100();
                        detailForm.centerInPage();
                        detailForm.show();
                        setCurrentPage(detailForm.getCurrentPage());
                    }
                });
            }
        });
        IButton operation3Button = PermissionControl.createPermissionButton("新建合同", ERPPermissionStatic.CONTRACT_INFO_ADD_CONTRACTS_BUTTON);
        controlLayout.addMember(operation3Button);
        operation3Button.setIcon("[SKIN]/actions/add.png");
        operation3Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download");
                    }

                    @Override
                    public void onSuccess() {
                        NewContractInfoForm detailForm = new NewContractInfoForm();
                        detailForm.setTitle("新建合同");
                        detailForm.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                RecordList list = resultGrid.getDataAsRecordList();
                                RecordList newList = new RecordList();
                                newList.addList(list.getRange(0, list.getLength()));
                                newList.add(event.getData());
                                resultGrid.setData(newList);
                                resultGrid.selectSingleRecord(newList.getLength() - 1);
                            }
                        });
                        detailForm.setSearchForm(searchForm);
                        detailForm.initComponents();
                        detailForm.startEdit();
                        detailForm.setWidth100();
                        detailForm.setHeight100();
                        detailForm.centerInPage();
                        detailForm.show();
                    }
                });
            }
        });
        
        IButton operation4Button = PermissionControl.createPermissionButton("合同设置", ERPPermissionStatic.CONTRACT_INFO_ADD_CONTRACTS_BUTTON);
        controlLayout.addMember(operation4Button);
//        operation4Button.setIcon("[SKIN]/actions/add.png");
        operation4Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download");
                    }

                    @Override
                    public void onSuccess() {
                    	if (!resultGrid.anySelected()) {
                            SC.say("请选择一条数据修改");
                            return;
                        }
                        ListGridRecord[] selected = resultGrid.getSelectedRecords();
                        ListGridRecord record = resultGrid.getSelectedRecord();
                        int contractIdField = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("contractId"));
                        String contractName = selected[0].getAttribute("contractName");
                        PopupWindow pw = new PopupWindow();
                        CustomContractMainPanel panel = new CustomContractMainPanel(contractIdField, record, 0, true);
                        pw.addItem(panel);
                        panel.setParentCanvas(pw);;
                        pw.setTitle("合同(" + contractName + ")管理");
                        pw.setWidth100();
                        pw.setHeight100();
                        pw.centerInPage();
                        pw.show();
                    }
                });
            }
        });
    }

    public void showDetail() {
        GWT.runAsync(new RunAsyncCallback() {
            @Override
            public void onFailure(Throwable reason) {
                SC.say("failure to download code");
            }

            @Override
            public void onSuccess() {
                if (!resultGrid.anySelected()) {
                    SC.say("请选择一条数据");
                    return;
                }
                GenericViewWindow detail = new GenericViewWindow();
                detail.setTitle("主合同详情");
                detail.setWidth100();
                detail.setHeight100();
                ContractInfoViewer detailForm = new ContractInfoViewer();
                detailForm.setParentSearchForm(searchForm);
                detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
                detailForm.initComponents();
                detailForm.viewSelectedData(resultGrid);
                detail.setContent(detailForm);
                detail.centerInPage();
                detail.show();
            }
        });
    }

    @Override
    public SearchForm generateSearchForm() {
        return new ContractInfoSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSContractInfo.getInstance();
    }

    @Override
    public int getSearchFormHeight() {
        return 63;
    }

}
