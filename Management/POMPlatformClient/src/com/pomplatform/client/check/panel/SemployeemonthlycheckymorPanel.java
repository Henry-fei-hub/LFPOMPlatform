package com.pomplatform.client.check.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.pomplatform.client.check.datasource.DSSemployeemonthlycheckymor;
import com.pomplatform.client.check.form.SemployeemonthlycheckymorSearchForm;
import com.pomplatform.client.check.form.SemployeemonthlycheckymorViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.Map;

public class SemployeemonthlycheckymorPanel extends AbstractSearchPanel {
    
    public static class Factory implements PanelFactory {
        
        private String id;
        
        @Override
        public Canvas create() {
            SemployeemonthlycheckymorPanel cm = new SemployeemonthlycheckymorPanel();
            id = cm.getID();
            return cm;
        }
        
        @Override
        public String getID() {
            return id;
        }
        
        @Override
        public String getDescription() {
            return "Semployeemonthlycheckymor";
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
        IButton viewButton = new IButton("查看详细");
        viewButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                showDetail();
            }
        });
        controlLayout.addMember(viewButton);
        
        IButton downButton = PermissionControl.createPermissionButton("导出", ERPPermissionStatic.CHECK_TOTAL_EXPORT_BUTTON);
        downButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Criteria record = searchForm.getValuesAsCriteria();
                Map pp = record.getValues();
                ClientUtil.departmentParameterProcess(pp);
                DBDataSource.downloadFile("DW_Semployeemonthlycheckymor", pp);
            }
        });
        controlLayout.addMember(downButton);
        
        IButton redoButton = PermissionControl.createPermissionButton("重新计算", ERPPermissionStatic.CHECK_TOTAL_RECOUNT_BUTTON);
        redoButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Criteria record = searchForm.getValuesAsCriteria();
                Map pp = record.getValues();
                ClientUtil.departmentParameterProcess(pp);
                final LoadingWindow loading = new LoadingWindow();
                DBDataSource.callOperation("EP_RecalculateCheckingData", pp, new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                    	loading.destroy();
                        if (dsResponse.getStatus() >= 0) {
//                            SC.say("已经提交计算，请过1-2分钟再查 ...");
                            SC.say("计算成功");
                        } else {
                            SC.say((String) dsResponse.getErrors().get("errorMsg"));
                        }
                    }
                    
                });
            }
        });
        controlLayout.addMember(redoButton);
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
                detail.setTitle("考勤详情");
                detail.setWidth100();
                detail.setHeight100();
                SemployeemonthlycheckymorViewer detailForm = new SemployeemonthlycheckymorViewer();
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
    
    @Override
    public boolean checkSearchCriteria(Map criteria) {
        ClientUtil.departmentParameterProcess(criteria);
        //数据权限控制  查看当前用户的数据  < 查看当前板块 < 查看所有
        if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.CHECK_TOTAL_ALL_SHOW_DATA)){
            if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.CHECK_TOTAL_PLATE_SHOW_DATA)){//只能看自己板块的  （板块管理员查看）
                int plateId = ClientUtil.getPlateId();
                criteria.put("plateId", plateId);
            }else{ 
                if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.CHECK_TOTAL_ONLY_MINE_DATA)){
                    int employeeId = ClientUtil.getEmployeeId();
                    criteria.put("employeeId", employeeId);
                }else{
                    criteria.put("employeeId", -1);
                }
            }
        }
        return true;
    }
    
    @Override
    public SearchForm generateSearchForm() {
        return new SemployeemonthlycheckymorSearchForm();
    }
    
    @Override
    public DataSource getDataSource() {
        return DSSemployeemonthlycheckymor.getInstance();
    }

    @Override
    public int getSearchFormHeight() {
        return 63;
    }
    
}
