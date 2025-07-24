package com.pomplatform.client.duty.panel;

import com.delicacy.client.MapUtils;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.duty.datasource.DSSemployeeDuty;
import com.pomplatform.client.duty.form.SemployeeDutySearchForm;
import com.pomplatform.client.duty.form.SemployeeDutyViewer;
import com.pomplatform.client.duty.form.NewSemployeeDutyForm;
import com.pomplatform.client.duty.form.UpdateSemployeeDutyForm;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SemployeeDutyPanel extends AbstractSearchPanel {

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            SemployeeDutyPanel cm = new SemployeeDutyPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "SemployeeDuty";
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
        IButton operation2Button = new IButton("新增职位");
        controlLayout.addMember(operation2Button);
        operation2Button.setIcon("[SKIN]/actions/add.png");
        operation2Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download");
                    }

                    @Override
                    public void onSuccess() {
                        NewSemployeeDutyForm detailForm = new NewSemployeeDutyForm();
                        detailForm.setTitle("新增职位");
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
        IButton operation3Button = new IButton("修改职位");
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
                        UpdateSemployeeDutyForm detailForm = new UpdateSemployeeDutyForm();
                        detailForm.setTitle("修改职位");
                        detailForm.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                RecordList list = resultGrid.getDataAsRecordList();
                                Map params = new HashMap();
                                params.put("dutyId", event.getData().getAttribute("dutyId"));
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
        IButton operation4Button = new IButton("移除职位");
        controlLayout.addMember(operation4Button);
        operation4Button.setIcon("[SKIN]/actions/cancel.png");
        operation4Button.addClickHandler(new ClickHandler() {
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
                        SC.confirm("提示", "删除职位并删除其子级职位，您确定删除吗？", new BooleanCallback() {
                            @Override
                            public void execute(Boolean r) {
                                if (r) {
                                    ListGridRecord[] selected = resultGrid.getSelectedRecords();
                                    String dutyId = selected[0].getAttribute("dutyId");
                                    Map param = new LinkedHashMap();
                                    param.put("dutyId", dutyId);
                                    String message = MapUtils.toJSON(param);
                                    //移除职位
                                    DBDataSource.callOperation("EP_DutyDelete", "delete", message, new DSCallback() {
                                        @Override
                                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                                            if (dsResponse.getStatus() >= 0) {
                                                SC.say("delete success");
                                                commonQuery();
                                            } else {
                                                Map errors = dsResponse.getErrors();
                                                SC.say("delete failure" + errors);
                                            }
                                        }
                                    });
                                }
                            }
                        });
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
                detail.setTitle("职位设置");
                detail.setWidth100();
                detail.setHeight100();
                SemployeeDutyViewer detailForm = new SemployeeDutyViewer();
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
        return new SemployeeDutySearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSSemployeeDuty.getInstance();
    }

}
