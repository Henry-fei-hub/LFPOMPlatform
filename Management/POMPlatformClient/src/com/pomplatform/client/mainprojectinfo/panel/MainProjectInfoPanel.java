package com.pomplatform.client.mainprojectinfo.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.PopupWindow;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.mainprojectinfo.datasource.DSMainProjectInfo;
import com.pomplatform.client.mainprojectinfo.form.MainProjectInfoSearchForm;
import com.pomplatform.client.mainprojectinfo.form.MainProjectInfoViewer;
import com.pomplatform.client.mainprojectinfo.form.UpdateMainProjectInfoForm;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.contractinfo.form.NewContractInfoForm;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;

public class MainProjectInfoPanel extends AbstractSearchPanel {

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            MainProjectInfoPanel cm = new MainProjectInfoPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "MainProjectInfo";
        }

    }

    @Override
    public void initComponents() {
        resultGrid.setShowRowNumbers(true);
        commonQuery();
        IButton refreshButton = new IButton("刷新");
        controlLayout.addMember(refreshButton);
        refreshButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                commonQuery();
            }
        });

        resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                showDetail();
            }
        });
        IButton operation1Button = new IButton("查看详情");
        controlLayout.addMember(operation1Button);
        operation1Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                showDetail();
            }
        });

        IButton operation2Button = PermissionControl.createPermissionButton("修改项目", ERPPermissionStatic.PROJECT_INFO_UPDATE_PROJECT_BUTTON);
        controlLayout.addMember(operation2Button);
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
                        UpdateMainProjectInfoForm detailForm = new UpdateMainProjectInfoForm();
                        detailForm.setTitle("修改项目");
                        detailForm.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                RecordList list = resultGrid.getDataAsRecordList();
                                Map params = new HashMap();
                                params.put("mainProjectId", event.getData().getAttribute("mainProjectId"));
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

        IButton operation3Button = PermissionControl.createPermissionButton("查看联系人", ERPPermissionStatic.PROJECT_INFO_VIEW_LINKMAN_BUTTON);
        controlLayout.addMember(operation3Button);
        operation3Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                ListGridRecord[] selected = resultGrid.getSelectedRecords();
                String mainProjectId = selected[0].getAttribute("mainProjectId");
                PopupWindow pw = new PopupWindow("联系人");
                MmainprojectclientccmorPanel panel = new MmainprojectclientccmorPanel();
                panel.setMainProjectId(ClientUtil.checkAndGetIntValue(mainProjectId));
                pw.addItem(panel.getViewPanel());
                pw.setWidth100();
                pw.setHeight100();
                pw.centerInPage();
                pw.show();
                panel.commonQuery();
            }
        });

        IButton operation4Button = PermissionControl.createPermissionButton("新建合同", ERPPermissionStatic.PROJECT_INFO_ADD_CONTRACTS_BUTTON);
        controlLayout.addMember(operation4Button);
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
                            SC.say("请选择一条数据创建合同");
                            return;
                        }
                        NewContractInfoForm detailForm = new NewContractInfoForm();
                        ListGridRecord[] selected = resultGrid.getSelectedRecords();
                        detailForm.setProjectCode(selected[0].getAttribute("projectCode"));
                        detailForm.setTitle("新建合同");
                        detailForm.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
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
                detail.setTitle("项目详情");
                detail.setWidth100();
                detail.setHeight100();
                MainProjectInfoViewer detailForm = new MainProjectInfoViewer();
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
    public boolean checkSearchCriteria(Map criteria) {
        criteria.put("addtionalCondition", "order by main_project_id");
        return true;
    }

    @Override
    public SearchForm generateSearchForm() {
        return new MainProjectInfoSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSMainProjectInfo.getInstance();
    }

    @Override
    public int getSearchFormHeight() {
        return 63;
    }

}
