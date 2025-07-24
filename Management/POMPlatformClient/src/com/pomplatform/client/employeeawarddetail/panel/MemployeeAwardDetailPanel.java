package com.pomplatform.client.employeeawarddetail.panel;

import com.delicacy.client.BaseHelpUtils;
import com.pomplatform.client.common.SyncDataUtil;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.employeeawarddetail.datasource.DSMemployeeAwardDetail;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.managementteamproject.datasource.DSMManagementTeamProject;
import com.pomplatform.client.projectview.form.SprojectViewViewer;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class MemployeeAwardDetailPanel extends AbstractSearchPanel {
    private final Logger __logger = Logger.getLogger("");
    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            MemployeeAwardDetailPanel cm = new MemployeeAwardDetailPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "MemployeeAwardDetail";
        }
    }
    
    private int years;
    private int months;
    private int employeeId;
    
    /**
     * @return the years
     */
    public int getYears() {
        return years;
    }

    /**
     * @param years the years to set
     */
    public void setYears(int years) {
        this.years = years;
    }

    /**
     * @return the months
     */
    public int getMonths() {
        return months;
    }

    /**
     * @param months the months to set
     */
    public void setMonths(int months) {
        this.months = months;
    }

    /**
     * @return the employeeId
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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
                ListGridRecord[] selected = resultGrid.getSelectedRecords();
                int projectId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("projectId"));
                //获取项目名称
                String projectName = SyncDataUtil.getProjectName(projectId);
//                final String projectName = KeyValueManager.getValue("projects",projectId+"");
//                Record record = getProjectName(projectId);
//                final String projectName = BaseHelpUtils.getString(record.getAttribute("projectName"));
                final DelicacyListGrid projectViewGrid = new DelicacyListGrid();
                projectViewGrid.setDataSource(DSMManagementTeamProject.getInstance());
                Map condition = new java.util.HashMap();
                condition.put("projectId", projectId);
                DBDataSource.callOperation("NQ_MManagementTeamProject", "find", condition, new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        if (dsResponse.getStatus() >= 0) {
                            projectViewGrid.setData(dsResponse.getData());
                            projectViewGrid.selectRecord(0);
                            GenericViewWindow detail = new GenericViewWindow();
                            detail.setTitle("项目("+projectName+")的相关信息");
                            detail.setWidth100();
                            detail.setHeight100();
                            SprojectViewViewer detailForm = new SprojectViewViewer();
                            detailForm.setParentSearchForm(searchForm);
                            detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
                            detailForm.initComponents();
                            detailForm.viewSelectedData(projectViewGrid);
                            detail.setContent(detailForm);
                            detail.centerInPage();
                            detail.show();
                        }
                    }
                });
            }
        });
    }
    
    @Override
    public boolean checkSearchCriteria(Map criteria) {
        criteria.put("years", years);
        criteria.put("months", months);
        criteria.put("employeeId", employeeId);
        return true;
    }

    @Override
    public SearchForm generateSearchForm() {
        return null;
//        return new MemployeeAwardDetailSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSMemployeeAwardDetail.getInstance();
    }

    /**
     * 获取项目的名称
     * @param projectId
     * @return
     */
    private Record getProjectName(Integer projectId){
        Record record = new Record();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("projectId",projectId);
        DBDataSource.callOperation("ST_Project", "find", map, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
                if(dsResponse.getStatus() >= 0){
                    Record[] records = dsResponse.getData();
                    if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
                        //获取项目名称
                        String projectName = BaseHelpUtils.getString(records[0].getAttribute("projectName"));
                        record.setAttribute("projectName",projectName);
                    }
                }
            }
        });
        return record;
    }

}
