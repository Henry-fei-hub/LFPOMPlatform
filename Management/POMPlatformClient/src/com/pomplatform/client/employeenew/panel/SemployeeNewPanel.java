package com.pomplatform.client.employeenew.panel;

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
import com.pomplatform.client.employeenew.datasource.DSSemployeeNew;
import com.pomplatform.client.employeenew.form.SemployeeNewSearchForm;
import com.pomplatform.client.employeenew.form.SemployeeNewViewer;
import com.pomplatform.client.employeenew.form.UpdateSemployeeNewForm;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.employeenew.form.NewSemployeeNewForm;
import com.smartgwt.client.data.*;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

public class SemployeeNewPanel extends AbstractSearchPanel {
    private final Logger __logger = Logger.getLogger("");
    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            SemployeeNewPanel cm = new SemployeeNewPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "SemployeeNew";
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
        operation1Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                showDetail();
            }
        });
        IButton operation2Button = new IButton("职员新增");
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
                        NewSemployeeNewForm detailForm = new NewSemployeeNewForm();
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
                        detailForm.setCurrentPage(getCurrentPage());
                        detailForm.initComponents();
                        detailForm.startEdit();
                        detailForm.setWidth("100%");
                        detailForm.setHeight("100%");
                        detailForm.centerInPage();
                        detailForm.show();
                        setCurrentPage(detailForm.getCurrentPage());
                    }
                });
            }
        });
        IButton operation3Button = new IButton("职员修改");
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
                        UpdateSemployeeNewForm detailForm = new UpdateSemployeeNewForm();
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
                        detailForm.setWidth("100%");
                        detailForm.setHeight("100%");
                        detailForm.centerInPage();
                        detailForm.show();
                        setCurrentPage(detailForm.getCurrentPage());
                    }
                });
            }
        });
        
        IButton operation4Button = new IButton("职员移除");
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
                        SC.confirm("提示", "您确定要移除该职员吗？", new BooleanCallback() {
                            @Override
                            public void execute(Boolean r) {
                                if (r) {
                                    ListGridRecord[] selected = resultGrid.getSelectedRecords();
                                    String employeeId = selected[0].getAttribute("employeeId");
                                    Map param = new LinkedHashMap();
                                    param.put("employeeId", employeeId);
                                    String message = MapUtils.toJSON(param);
                                    //删除方法
                                    DBDataSource.callOperation("EP_EmployeeDelete", "delete", message, new DSCallback() {
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
                detail.setTitle("职员管理");
                detail.setWidth("100%");
                detail.setHeight("100%");
                SemployeeNewViewer detailForm = new SemployeeNewViewer();
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
        ClientUtil.departmentParameterProcess(criteria);
        return true;
    }
    
    @Override
    public SearchForm generateSearchForm() {
        return new SemployeeNewSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSSemployeeNew.getInstance();
    }

    @Override
    public int getSearchFormHeight() {
        return 126;
    }

}
