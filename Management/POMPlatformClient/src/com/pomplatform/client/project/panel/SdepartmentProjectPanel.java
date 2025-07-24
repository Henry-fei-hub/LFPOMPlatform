package com.pomplatform.client.project.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.PopupWindow;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.project.datasource.DSSprojectccpor;
import com.pomplatform.client.project.form.SprojectccporViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.Cookies;
import com.pomplatform.client.myinvite.panel.MprojectTeamPanel;
import com.pomplatform.client.project.form.SprojectManagerSearchForm;
import com.pomplatform.client.projectlog.panel.SprojectlogppoorPanel;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class SdepartmentProjectPanel extends AbstractSearchPanel {

    private static Logger __LOGGER = Logger.getLogger("");
    //默认检索正在运行的已审核过的项目
    private boolean queryOldProject = false;

    /**
     * @return the queryOldProject
     */
    public boolean isQueryOldProject() {
        return queryOldProject;
    }

    /**
     * @param queryOldProject the queryOldProject to set
     */
    public void setQueryOldProject(boolean queryOldProject) {
        this.queryOldProject = queryOldProject;
    }

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            SdepartmentProjectPanel cm = new SdepartmentProjectPanel();
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
//        operation1Button.setIcon("[SKIN]/actions/view.png");
        operation1Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                showDetail();
            }
        });
        
        IButton operation3Button = new IButton("正在运行项目");
        controlLayout.addMember(operation3Button);
        operation3Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                setQueryOldProject(false);
                commonQuery();
            }
        });

        IButton operation4Button = new IButton("已结束项目");
        controlLayout.addMember(operation4Button);
        operation4Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                setQueryOldProject(true);
                commonQuery();
            }
        });
        
        IButton operation2Button = new IButton("项目成员");
        controlLayout.addMember(operation2Button);
//        operation2Button.setIcon("[SKIN]/actions/edit.png");
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
                        pw.setTitle("项目成员");
                        pw.setWidth100();
                        pw.setHeight100();
                        pw.centerInPage();
                        pw.show();
                        myselfProject.commonQuery();
                    }
                });
            }
        });

        IButton operation5Button = new IButton("项目日志");
        controlLayout.addMember(operation5Button);
        operation5Button.addClickHandler(new ClickHandler() {
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
                        SprojectlogppoorPanel projectLog = new SprojectlogppoorPanel();
                        projectLog.setProjectId(ClientUtil.checkAndGetIntValue(projectId));
                        pw.addItem(projectLog.getViewPanel());
                        pw.setTitle("项目日志");
                        pw.setWidth100();
                        pw.setHeight100();
                        pw.centerInPage();
                        pw.show();
                        projectLog.commonQuery();
                    }
                });
            }
        });

        //默认执行一次查询
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
                detail.setTitle("项目立项");
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
    public int getSearchFormHeight() {
        return 50;
    }

    @Override
    public boolean checkSearchCriteria(Map criteria) {
        //获取当前板块负责人的部门id,只查看自己部门下的项目信息
        String departmentId = Cookies.getCookie(ClientUtil.OPRERATOR_DEPARTMENTID_COOKIE);
        criteria.put("departmentId", departmentId);
        //只检索审核通过的项目
        if (!queryOldProject) {//检索正在运行项目
            List<Map> keyvalues = new ArrayList<>();
            Map<String, String> kv = new HashMap<>();
            kv.put("key", "and p.status >=0");
            kv.put("value", "and p.status >1 and p.status < 8");
            keyvalues.add(kv);
            criteria.put("keyValues", keyvalues);
        } else {
            List<Map> keyvalues = new ArrayList<>();
            Map<String, String> kv = new HashMap<>();
            kv.put("key", "and p.status >=0");
            kv.put("value", "and p.status >8 ");
            keyvalues.add(kv);
            criteria.put("keyValues", keyvalues);
        }
        return true;
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
