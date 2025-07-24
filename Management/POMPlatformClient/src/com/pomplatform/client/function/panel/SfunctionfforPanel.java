package com.pomplatform.client.function.panel;

import com.delicacy.client.MapUtils;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.function.datasource.DSSfunctionffor;
import com.pomplatform.client.function.form.SfunctionfforSearchForm;
import com.pomplatform.client.function.form.SfunctionfforViewer;
import com.pomplatform.client.function.form.NewSfunctionfforForm;
import com.pomplatform.client.function.form.UpdateSfunctionfforForm;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SfunctionfforPanel extends AbstractSearchPanel {

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            SfunctionfforPanel cm = new SfunctionfforPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "Sfunctionffor";
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
        operation1Button.hide();
        controlLayout.addMember(operation1Button);
        operation1Button.setIcon("[SKIN]/actions/view.png");
        operation1Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                showDetail();
            }
        });
        IButton operation2Button = new IButton("新建功能");
        controlLayout.addMember(operation2Button);
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
                        NewSfunctionfforForm detailForm = new NewSfunctionfforForm();
                        detailForm.setTitle("新建功能");
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
                        detailForm.setWidth("80%");
                        detailForm.setHeight("70%");
                        detailForm.centerInPage();
                        detailForm.show();
                    }
                });
            }
        });
        IButton operation3Button = new IButton("修改功能");
        controlLayout.addMember(operation3Button);
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
                        UpdateSfunctionfforForm detailForm = new UpdateSfunctionfforForm();
                        detailForm.setTitle("修改功能");
                        detailForm.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                RecordList list = resultGrid.getDataAsRecordList();
                                Map params = new HashMap();
                                params.put("functionId", event.getData().getAttribute("functionId"));
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
                        detailForm.setWidth("80%");
                        detailForm.setHeight("70%");
                        detailForm.centerInPage();
                        detailForm.show();
                        setCurrentPage(detailForm.getCurrentPage());
                    }
                });
            }
        });
        IButton operation4Button = new IButton("删除功能");
        controlLayout.addMember(operation4Button);
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
                        SC.confirm("提示", "您确定要删除该功能吗？", new BooleanCallback() {
                            @Override
                            public void execute(Boolean value) {
                                ListGridRecord[] selected = resultGrid.getSelectedRecords();
                                int functionId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("functionId"));
                                Map param = new LinkedHashMap();
                                param.put("functionId", functionId);
                                String message = MapUtils.toJSON(param);
                                //删除方法
                                DBDataSource.callOperation("EP_FunctionDelete", "delete", message, new DSCallback() {
                                    @Override
                                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                                        if (dsResponse.getStatus() >= 0) {
                                            //执行成功后重新执行查询，刷新表格数据
                                            commonQuery();
                                        } else {
                                            Map errors = dsResponse.getErrors();
                                            SC.say("delete failure" + errors);
                                        }
                                    }
                                });
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
                detail.setTitle("功能管理");
                detail.setWidth("60%");
                detail.setHeight("60%");
                SfunctionfforViewer detailForm = new SfunctionfforViewer();
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
        return new SfunctionfforSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSSfunctionffor.getInstance();
    }

}
