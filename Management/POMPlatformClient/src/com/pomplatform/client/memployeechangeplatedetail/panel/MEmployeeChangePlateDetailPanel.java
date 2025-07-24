package com.pomplatform.client.memployeechangeplatedetail.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.memployeechangeplatedetail.datasource.DSMEmployeeChangePlateDetail;
import com.pomplatform.client.memployeechangeplatedetail.form.MEmployeeChangePlateDetailSearchForm;
import com.pomplatform.client.memployeechangeplatedetail.form.MEmployeeChangePlateDetailViewer;
import com.pomplatform.client.memployeechangeplatedetail.form.UpdateMEmployeeChangePlateDetailForm;
import com.pomplatform.client.memployeechangeplatedetail.form.NewMEmployeeChangePlateDetailForm;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.Map;

public class MEmployeeChangePlateDetailPanel extends AbstractSearchPanel {

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            MEmployeeChangePlateDetailPanel cm = new MEmployeeChangePlateDetailPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "MEmployeeChangePlateDetail";
        }

    }

    @Override
    public void initComponents() {
        resultGrid.setShowRowNumbers(true);
        IButton refreshButton = new IButton("刷新");
        controlLayout.addMember(refreshButton);
        refreshButton.setIcon("[SKIN]/actions/refresh.png");
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
        operation1Button.setIcon("[SKIN]/actions/view.png");
        operation1Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                showDetail();
            }
        });
        IButton operation2Button = PermissionControl.createPermissionButton("转岗修改", ERPPermissionStatic.CHANGE_PLATE_UPDATE_BUTTON);
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
                        final ListGridRecord selected1 = resultGrid.getSelectedRecord();
                        UpdateMEmployeeChangePlateDetailForm detailForm = new UpdateMEmployeeChangePlateDetailForm();
                        detailForm.setTitle("转岗修改");
                        detailForm.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
//                                DBDataSource.copyRecord(event.getData(), selected1);
                                commonQuery();
                            }
                        });
                        detailForm.setSearchForm(searchForm);
                        detailForm.setRecord(selected1);
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
        IButton operation3Button = PermissionControl.createPermissionButton("职员转岗", ERPPermissionStatic.CHANGE_PLATE_NEW_BUTTON);
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
                        NewMEmployeeChangePlateDetailForm detailForm = new NewMEmployeeChangePlateDetailForm();
                        detailForm.setTitle("职员转岗");
                        detailForm.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
//                                RecordList list = resultGrid.getDataAsRecordList();
//                                RecordList newList = new RecordList();
//                                newList.addList(list.getRange(0, list.getLength()));
//                                newList.add(event.getData());
//                                resultGrid.setData(newList);
//                                resultGrid.selectSingleRecord(newList.getLength() - 1);
                                commonQuery();
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
        IButton removeButton = PermissionControl.createPermissionButton("删除记录", ERPPermissionStatic.CHANGE_PLATE_DELETE_BUTTON);
        controlLayout.addMember(removeButton);
        removeButton.setIcon("[SKIN]/actions/remove.png");
        removeButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (!resultGrid.anySelected()) {
                    SC.say("Please select a data to remove.");
                }
                final ListGridRecord selected = resultGrid.getSelectedRecord();
                DBDataSource.callOperation("ST_CustomEmployeeChangePlateDetail", "delete", selected.toMap(), new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        if (dsResponse.getStatus() < 0) {
                            ClientUtil.displayErrorMessage(dsResponse);
                        } else {
                            int indexNum = resultGrid.getRowNum(selected);
                            resultGrid.removeData(selected);
                            resultGrid.selectSingleRecord(indexNum);
                        }
                    }
                });
            }
        });

        commonQuery();
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
                detail.setTitle("职员转岗");
                detail.setWidth100();
                detail.setHeight100();
                MEmployeeChangePlateDetailViewer detailForm = new MEmployeeChangePlateDetailViewer();
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
        criteria.put("addtionalCondition", "order by employee_change_plate_detail_id");
        return true;
    }

    @Override
    public SearchForm generateSearchForm() {
        return new MEmployeeChangePlateDetailSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSMEmployeeChangePlateDetail.getInstance();
    }

}
