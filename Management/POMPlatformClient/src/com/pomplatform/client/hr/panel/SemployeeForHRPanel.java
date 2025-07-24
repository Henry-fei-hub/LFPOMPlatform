package com.pomplatform.client.hr.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.hr.datasource.DSSemployeeForHR;
import com.pomplatform.client.hr.form.SemployeeForHRSearchForm;
import com.pomplatform.client.hr.form.SemployeeForHRViewer;
import com.pomplatform.client.hr.form.UpdateSemployeeForHRForm;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;

public class SemployeeForHRPanel extends AbstractSearchPanel {

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            SemployeeForHRPanel cm = new SemployeeForHRPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "SemployeeForHR";
        }

    }

    @Override
    public void initComponents() {
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
        IButton operation2Button = new IButton("职员新增");
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
                        UpdateSemployeeForHRForm detailForm = new UpdateSemployeeForHRForm();
                        detailForm.setTitle("职员新增");
                        detailForm.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                RecordList list = resultGrid.getDataAsRecordList();
                                Map params = new HashMap();
                                params.put("employeeId", event.getData().getAttribute("employeeId"));
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
        IButton operation3Button = new IButton("职员修改");
        controlLayout.addMember(operation3Button);
        operation3Button.setIcon("[SKIN]/actions/edit.png");
        operation3Button.addClickHandler(new ClickHandler() {
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
                        UpdateSemployeeForHRForm detailForm = new UpdateSemployeeForHRForm();
                        detailForm.setTitle("职员修改");
                        detailForm.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                RecordList list = resultGrid.getDataAsRecordList();
                                Map params = new HashMap();
                                params.put("employeeId", event.getData().getAttribute("employeeId"));
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
                detail.setTitle("职员管理");
                detail.setWidth100();
                detail.setHeight100();
                SemployeeForHRViewer detailForm = new SemployeeForHRViewer();
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
        return new SemployeeForHRSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSSemployeeForHR.getInstance();
    }

}
