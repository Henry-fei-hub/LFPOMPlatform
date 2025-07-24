package com.pomplatform.client.designer.panel;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.GenericViewWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.designer.form.MprojectemployeeporViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.grid.ListGridField;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author guanxgun
 */
public class DesignerProjectNoDoubleClickPanel extends MprojectemployeeporPanel {

    public DesignerProjectNoDoubleClickPanel(){
        super();
    }
    
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
    
    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            DesignerProjectNoDoubleClickPanel cm = new DesignerProjectNoDoubleClickPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "DesignerProjectPanel";
        }

    }

    @Override
    public void initComponents() {
    	int idx = 0;
		ListGridField[] fields = new ListGridField[9];
		fields[idx] = new ListGridField("projectManageId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setWidth("10%");
		idx++;
		fields[idx] = new ListGridField("projectName");
		fields[idx].setShowGridSummary(false);
		fields[idx].setWidth("15%");
		idx++;
		fields[idx] = new ListGridField("workContent");
		fields[idx].setShowGridSummary(false);
		fields[idx].setWidth("15%");
		idx++;
		fields[idx] = new ListGridField("startDate");
		fields[idx].setShowGridSummary(false);
		fields[idx].setWidth("10%");
		idx++;
		fields[idx] = new ListGridField("endDate");
		fields[idx].setShowGridSummary(false);
		fields[idx].setWidth("10%");
		idx++;
		fields[idx] = new ListGridField("planIntegral");
		fields[idx].setWidth("10%");
		idx++;
		fields[idx] = new ListGridField("realIntegral");
		fields[idx].setWidth("10%");
		idx++;
		fields[idx] = new ListGridField("cost");
		fields[idx].setWidth("10%");
		idx++;
		fields[idx] = new ListGridField("settlement");
		fields[idx].setWidth("10%");
		resultGrid.setShowRowNumbers(true);
		resultGrid.setFields(fields);
		resultGrid.setShowGridSummary(true);
        resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
//                showDetail();
            }
        });
        IButton viewButton = new IButton("刷新");
        viewButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                commonQuery();
            }
        });
        controlLayout.addMember(viewButton);
        IButton oldButton = PermissionControl.createPermissionButton("做过的项目", ERPPermissionStatic.MY_TAKEPARTIN_PROJECT_DONE_BUTTON);
        oldButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                setQueryOldProject(true);
                commonQuery();
                
            }
        });
        controlLayout.addMember(oldButton);

        commonQuery();
    }

    @Override
    public void commonQuery() {
        Map condition = generateCriteria();
        if (condition == null) {
            return;
        }

        DBDataSource ds = (DBDataSource) getDataSource();
        String operationName = ds.getActionMode() + ds.getActionName();
        DBDataSource.callOperation(operationName, condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {

                if (dsResponse.getStatus() >= 0) {
                    resultGrid.setData(dsResponse.getData());

                } else {
                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
                }
                setQueryOldProject(false);
            }
        });
    }

    @Override
    public boolean checkSearchCriteria(Map criteria) {
        if(employeeId > 0){
            criteria.put("employeeId", employeeId);
        }else{
            criteria.put("employeeId", ClientUtil.getUserId());
        }
        criteria.put("status", 1);
        if (isQueryOldProject()) {
            criteria.put("status", 2);
            List<Map> keyvalues = new ArrayList<>();
            Map<String, String> kv = new HashMap<>();
            kv.put("key", "and p.status < 8");
            kv.put("value", "and p.status >= 8");
            keyvalues.add(kv);
            criteria.put("keyValues", keyvalues);
        }
        return true;
    }

    private boolean queryOldProject = false;
    private int employeeId = 0;//如果employeeId，则表示页面跳转传递过来的值

    @Override
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
                detail.setTitle("设计师-我的项目");
                detail.setWidth100();
                detail.setHeight100();
                MprojectemployeeporViewer detailForm = new MprojectemployeeporViewer();
                detailForm.setParentSearchForm(searchForm);
                detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
                detailForm.initComponents();
                detailForm.viewSelectedData(resultGrid);
                detail.setContent(detailForm);
                detail.centerInPage();
                detail.show();
            }
        });
    }
}
