package com.pomplatform.client.contract.panel;

import com.delicacy.client.MapUtils;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.contract.datasource.DSScontractccor;
import com.pomplatform.client.contract.form.ScontractccorSearchForm;
import com.pomplatform.client.contract.form.ScontractccorViewer;
import com.pomplatform.client.contract.form.NewScontractccorForm;
import com.pomplatform.client.contract.form.UpdateScontractccorForm;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.smartgwt.client.data.*;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ScontractccorPanel extends AbstractSearchPanel {

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            ScontractccorPanel cm = new ScontractccorPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "Scontractccor";
        }

    }

    @Override
    public void initComponents() {
        commonQuery();
        resultGrid.setShowRowNumbers(true);
        resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                showDetail();
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
//        IButton operation2Button = PermissionControl.createPermissionButton("合同新建", ERPPermissionStatic.PROJECT_CONTRACT_ADD_BUTTON);
//        controlLayout.addMember(operation2Button);
//        operation2Button.setIcon("[SKIN]/actions/add.png");
//        operation2Button.addClickHandler(new ClickHandler() {
//            @Override
//            public void onClick(ClickEvent event) {
//                GWT.runAsync(new RunAsyncCallback() {
//                    @Override
//                    public void onFailure(Throwable reason) {
//                        SC.say("failure to download");
//                    }
//
//                    @Override
//                    public void onSuccess() {
//                        NewScontractccorForm detailForm = new NewScontractccorForm();
//                        detailForm.setTitle("合同新建");
//                        detailForm.addDataEditedHandler(new DataEditedHandler() {
//                            @Override
//                            public void onDataEdited(DataEditEvent event) {
//                                RecordList list = resultGrid.getDataAsRecordList();
//                                RecordList newList = new RecordList();
//                                newList.addList(list.getRange(0, list.getLength()));
//                                newList.add(event.getData());
//                                resultGrid.setData(newList);
//                                resultGrid.selectSingleRecord(newList.getLength() - 1);
//                            }
//                        });
//                        detailForm.setSearchForm(searchForm);
//                        detailForm.initComponents();
//                        detailForm.startEdit();
//                        detailForm.setWidth100();
//                        detailForm.setHeight100();
//                        detailForm.centerInPage();
//                        detailForm.show();
//                    }
//                });
//            }
//        });
//        IButton operation3Button = PermissionControl.createPermissionButton("合同修改", ERPPermissionStatic.PROJECT_CONTRACT_UPDATE_BUTTON);
//        controlLayout.addMember(operation3Button);
//        operation3Button.setIcon("[SKIN]/actions/edit.png");
//        operation3Button.addClickHandler(new ClickHandler() {
//            @Override
//            public void onClick(ClickEvent event) {
//                GWT.runAsync(new RunAsyncCallback() {
//                    @Override
//                    public void onFailure(Throwable reason) {
//                        SC.say("failure to download code");
//                    }
//
//                    @Override
//                    public void onSuccess() {
//                        if (!resultGrid.anySelected()) {
//                            SC.say("请选择一条数据修改");
//                            return;
//                        }
//                        ListGridRecord[] selected = resultGrid.getSelectedRecords();
//                        UpdateScontractccorForm detailForm = new UpdateScontractccorForm();
//                        detailForm.setTitle("合同修改");
//                        detailForm.addDataEditedHandler(new DataEditedHandler() {
//                            @Override
//                            public void onDataEdited(DataEditEvent event) {
//                                RecordList list = resultGrid.getDataAsRecordList();
//                                Map params = new HashMap();
//                                params.put("contractId", event.getData().getAttribute("contractId"));
//                                int index = list.findIndex(params);
//                                if (index != -1) {
//                                    RecordList newList = new RecordList();
//                                    if (index > 0) {
//                                        newList.addList(list.getRange(0, index));
//                                    }
//                                    newList.add(event.getData());
//                                    if (index < list.getLength() - 1) {
//                                        newList.addList(list.getRange(index + 1, list.getLength()));
//                                    }
//                                    resultGrid.setData(newList);
//                                    resultGrid.selectSingleRecord(index);
//                                }
//                            }
//                        });
//                        detailForm.setSearchForm(searchForm);
//                        detailForm.setRecord(selected[0]);
//                        detailForm.setCurrentPage(getCurrentPage());
//                        detailForm.initComponents();
//                        detailForm.startEdit();
//                        detailForm.setWidth100();
//                        detailForm.setHeight100();
//                        detailForm.centerInPage();
//                        detailForm.show();
//                        setCurrentPage(detailForm.getCurrentPage());
//                    }
//                });
//            }
//        });
//
//        IButton operation4Button = PermissionControl.createPermissionButton("合同取消", ERPPermissionStatic.PROJECT_CONTRACT_CANCEL_BUTTON);
//        controlLayout.addMember(operation4Button);
//        operation4Button.setIcon("[SKIN]/actions/cancel.png");
//        operation4Button.addClickHandler(new ClickHandler() {
//            @Override
//            public void onClick(ClickEvent event) {
//                GWT.runAsync(new RunAsyncCallback() {
//                    @Override
//                    public void onFailure(Throwable reason) {
//                        SC.say("failure to download code");
//                    }
//
//                    @Override
//                    public void onSuccess() {
//                        if (!resultGrid.anySelected()) {
//                            SC.say("请选择一条数据修改");
//                            return;
//                        }
//                        SC.confirm("提示", "删除合同并删除其关联项目，您确定删除吗？", new BooleanCallback() {
//                            @Override
//                            public void execute(Boolean r) {
//                                if (r) {
//                                    ListGridRecord[] selected = resultGrid.getSelectedRecords();
//                                    Map map = selected[0].toMap();
//                                    String contractId = selected[0].getAttribute("contractId");
//                                    String contractCode = selected[0].getAttribute("contractCode");
//                                    Map param = new LinkedHashMap();
//                                    param.put("contractId", contractId);
//                                    param.put("contractCode", contractCode);
//                                    String message = MapUtils.toJSON(param);
//                                    //删除方法
//                                    DBDataSource.callOperation("EP_ContractDelete", "delete", message, new DSCallback() {
//                                        @Override
//                                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//                                            if (dsResponse.getStatus() >= 0) {
//                                                //执行成功后重新执行查询，刷新表格数据
//                                                commonQuery();
//                                            } else {
//                                                Map errors = dsResponse.getErrors();
//                                                SC.say("delete failure" + errors);
//                                            }
//                                        }
//                                    });
//                                }
//                            }
//                        });
//                    }
//                });
//            }
//        });
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
                detail.setTitle("项目合同");
                detail.setWidth100();
                detail.setHeight100();
                ScontractccorViewer detailForm = new ScontractccorViewer();
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
    public int getSearchFormHeight() {
        return 63; 
    }
    
    @Override
    public SearchForm generateSearchForm() {
        return new ScontractccorSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSScontractccor.getInstance();
    }

}
