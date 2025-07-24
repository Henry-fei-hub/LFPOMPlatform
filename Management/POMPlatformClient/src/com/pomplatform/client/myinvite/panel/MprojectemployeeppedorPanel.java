package com.pomplatform.client.myinvite.panel;

import com.delicacy.client.MapUtils;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.pomplatform.client.myinvite.datasource.DSMprojectemployeeppedor;
import com.pomplatform.client.myinvite.form.MprojectemployeeppedorSearchForm;
import com.pomplatform.client.myinvite.form.MprojectemployeeppedorViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.Cookies;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import java.util.LinkedHashMap;
import java.util.Map;

public class MprojectemployeeppedorPanel extends AbstractSearchPanel {

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            MprojectemployeeppedorPanel cm = new MprojectemployeeppedorPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "Mprojectemployeeppedor";
        }

    }

    @Override
    public boolean checkSearchCriteria(Map criteria) {
        criteria.put("employeeId", Cookies.getCookie(ClientUtil.OPRERATORID_COOKIE));
        return true;
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

        IButton operation2Button = new IButton("同意邀请");
        controlLayout.addMember(operation2Button);
        operation2Button.setIcon("[SKIN]/actions/view.png");
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
                        String projectEmployeeId = selected[0].getAttribute("projectEmployeeId");
                        Map param = new LinkedHashMap();
                        param.put("projectEmployeeId", projectEmployeeId);
                        param.put("status", 1);
                        String message = MapUtils.toJSON(param);
                        //我的邀请同意
                        DBDataSource.callOperation("EP_ProjectInvite", "update", message, new DSCallback() {
                            @Override
                            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                                if (dsResponse.getStatus() >= 0) {
                                    //执行成功后重新执行查询，刷新表格数据
                                    SC.say("operate success");
                                    commonQuery();
                                } else {
                                    Map errors = dsResponse.getErrors();
                                    SC.say("update failure" + errors);
                                }
                            }
                        });
                    }
                });
            }
        });

        IButton operation3Button = new IButton("拒绝邀请");
        controlLayout.addMember(operation3Button);
        operation3Button.setIcon("[SKIN]/actions/view.png");
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
                        String projectEmployeeId = selected[0].getAttribute("projectEmployeeId");
                        Map param = new LinkedHashMap();
                        param.put("projectEmployeeId", projectEmployeeId);
                        param.put("status", -1);
                        String message = MapUtils.toJSON(param);
                        //我的邀请拒绝
                        DBDataSource.callOperation("EP_ProjectInvite", "update", message, new DSCallback() {
                            @Override
                            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                                if (dsResponse.getStatus() >= 0) {
                                    //执行成功后重新执行查询，刷新表格数据
                                    SC.say("operate success");
                                    commonQuery();
                                } else {
                                    Map errors = dsResponse.getErrors();
                                    SC.say("update failure" + errors);
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
                detail.setTitle("我的邀请");
                detail.setWidth("60%");
                detail.setHeight("60%");
                MprojectemployeeppedorViewer detailForm = new MprojectemployeeppedorViewer();
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
        return new MprojectemployeeppedorSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSMprojectemployeeppedor.getInstance();
    }

}
