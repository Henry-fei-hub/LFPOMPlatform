package com.pomplatform.client.projectemployee.panel;

import com.delicacy.client.MapUtils;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.projectemployee.datasource.DSSprojectemployeepdsor;
import com.pomplatform.client.projectemployee.form.SprojectemployeepdsorViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.projectemployee.form.SprojectEmployeeReleaseSearchForm;
import com.smartgwt.client.data.*;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.LinkedHashMap;
import java.util.Map;

public class SprojectEmployeeReleasePanel extends AbstractSearchPanel {

    /**
     * @return the projectID
     */
    public int getProjectID() {
        return projectID;
    }

    /**
     * @param projectID the projectID to set
     */
    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            SprojectEmployeeReleasePanel cm = new SprojectEmployeeReleasePanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "Sprojectemployeepdsor";
        }

    }

    private int projectID = 0;

    @Override
    public boolean checkSearchCriteria(Map criteria) {
        criteria.put("projectId", getProjectID());
        return true;
    }

    @Override
    public void initComponents() {
        resultGrid.setShowRowNumbers(true);
        resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
//                showDetail();
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
        IButton operation2Button = new IButton("释放");
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
                        
                        SC.askforValue("分配积分", "请输入您分配的积分", new ValueCallback() {  
                            @Override  
                            public void execute(String value) {  
                                if (value != null) { 
                                    ListGridRecord[] selected = resultGrid.getSelectedRecords();
                                    String projectEmployeeId = selected[0].getAttribute("projectEmployeeId");
                                    Map param = new LinkedHashMap();
                                    param.put("projectEmployeeId", projectEmployeeId);
                                    param.put("realIntegral", value);//分配设计师实际所得积分
                                    String message = MapUtils.toJSON(param);
                                    DBDataSource.callOperation("EP_ProjectRealIntegral", "update", message, new DSCallback() {
                                        @Override
                                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                                            if (dsResponse.getStatus() >= 0) {
                                                //执行成功后重新执行查询，刷新表格数据
                                                commonQuery();
                                            } else {
                                                Map errors = dsResponse.getErrors();
                                                SC.say("update failure" + errors);
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
                detail.setTitle("人员释放");
                detail.setWidth("60%");
                detail.setHeight("60%");
                SprojectemployeepdsorViewer detailForm = new SprojectemployeepdsorViewer();
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
        return new SprojectEmployeeReleaseSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSSprojectemployeepdsor.getInstance();
    }
    
    @Override
    public int getSearchFormHeight() {
        return 50;
    }

}
