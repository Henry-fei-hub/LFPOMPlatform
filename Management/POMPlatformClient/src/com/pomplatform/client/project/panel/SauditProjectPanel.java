package com.pomplatform.client.project.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.Cookies;
import com.pomplatform.client.myinvite.panel.MprojectTeamPanel;
import com.pomplatform.client.project.datasource.DSSprojectccpor;
import com.pomplatform.client.project.form.SprojectManagerSearchForm;
import com.pomplatform.client.project.form.SprojectccporViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class SauditProjectPanel extends AbstractSearchPanel {

    private static Logger __LOGGER = Logger.getLogger("");

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            SauditProjectPanel cm = new SauditProjectPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "Sprojectccpor";
        }

    }

    @Override
    public void commonQuery() {
        super.commonQuery(); //To change body of generated methods, choose Tools | Templates.
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

        IButton operation2Button = new IButton("查看队员");
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
                        String projectId = selected[0].getAttribute("projectId");
                        PopupWindow pw = new PopupWindow();
                        MprojectTeamPanel myselfProject = new MprojectTeamPanel();
                        myselfProject.setProjectId(ClientUtil.checkAndGetIntValue(projectId));
                        pw.addItem(myselfProject.getViewPanel());
                        pw.setTitle("项目队员");
                        pw.setWidth100();
                        pw.setHeight100();
                        pw.centerInPage();
                        pw.show();
                        myselfProject.commonQuery();
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
                detail.setTitle("项目信息");
                detail.setWidth100();
                detail.setHeight100();
                SprojectccporViewer detailForm = new SprojectccporViewer();
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
        //获取当前登录板块负责人的部门id，只查看其部门下的项目
        String departmentId = Cookies.getCookie(ClientUtil.OPRERATOR_DEPARTMENTID_COOKIE);
        criteria.put("departmentId", departmentId);
        criteria.put("status", 1);
        return true;
    }

    @Override
    public int getSearchFormHeight() {
        return 50;
    }

    @Override
    public SearchForm generateSearchForm() {
        return new SprojectManagerSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSSprojectccpor.getInstance();
    }

}
