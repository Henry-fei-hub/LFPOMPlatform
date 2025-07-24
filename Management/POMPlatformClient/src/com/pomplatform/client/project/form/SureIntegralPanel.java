package com.pomplatform.client.project.form;

import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.stageintegral.form.MprojectStageIntegralTotalUpdateForm;
import com.pomplatform.client.sureintegrl.datasource.DSMprojectEmployeeSureIntegrl;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditorExitEvent;
import com.smartgwt.client.widgets.grid.events.EditorExitHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author guangxun
 */
public class SureIntegralPanel extends Window {
    private final Logger __logger = Logger.getLogger("");
    public SureIntegralPanel() {
    }

    public void initComponents() {
        VLayout global = new VLayout();
        addItem(global);
        global.setWidth100();
        global.setHeight100();
        grid.setDataSource(DSMprojectEmployeeSureIntegrl.getInstance());
        grid.setCanRemoveRecords(false);
        grid.addEditorExitHandler(new EditorExitHandler() {
            @Override
            public void onEditorExit(EditorExitEvent event) {
                ListGridRecord[] records = grid.getRecords();
                if (records == null || records.length == 0) {
                    return;
                }
                ListGridRecord newRecord = event.getRecord();
                //获取改变前的确认积分
                double oldAssignSureIntegral = ClientUtil.checkAndGetDoubleValue(newRecord.getAttribute("assignSureIntegral"));
                //获取当前输入的确认积分
                double newAssignSureIntegral = ClientUtil.checkAndGetDoubleValue(event.getNewValue());
                //获取改变前和改变后的差值
                double finalAssignSureIntegral = newAssignSureIntegral - oldAssignSureIntegral;
                //获取剩余积分
                double stageFinalIntegral = ClientUtil.checkAndGetDoubleValue(projectOverview.stageFinalIntegralItem.getValue());
                if(newAssignSureIntegral == 0){//表示未输入确认积分
                    projectOverview.stageFinalIntegralItem.setValue(stageFinalIntegral-finalAssignSureIntegral);
                    return;
                }
                //获取预分配积分
                double planIntegral = ClientUtil.checkAndGetDoubleValue(newRecord.getAttribute("planIntegral"));
                //获取已确认积分
                double sureIntegral = ClientUtil.checkAndGetDoubleValue(newRecord.getAttribute("sureIntegral"));
                //当输入积分输入过多时，不允许提交
                if(planIntegral < finalAssignSureIntegral+sureIntegral){
                    SC.say("提示", "分配确认积分超出了计划分配的积分,当前最多可输入积分("+(planIntegral-sureIntegral)+")");
                    event.cancel();
                    return;
                }
                //检索当输入的确认积分超出了剩余积分，不允许提交
                double lastIntegral = stageFinalIntegral-finalAssignSureIntegral;
                if(lastIntegral<0){
                    SC.say("提示", "分配确认积分超出了未确认积分,当前最多可输入积分("+(lastIntegral)+")");
                    event.cancel();
                    return;
                }
                projectOverview.stageFinalIntegralItem.setValue(lastIntegral);
            }
        });
        projectOverview.setWidth100();
        projectOverview.setHeight("45%");
        global.addMember(projectOverview);
        global.addMember(grid);
        ToolStrip controlLayout = new ToolStrip();
        global.addMember(controlLayout);
        controlLayout.addFill();
        IButton resertSureIntegral = new IButton("重置确认积分");
        resertSureIntegral.setAutoFit(true);
        resertSureIntegral.setWidth(100);
        controlLayout.addMember(resertSureIntegral);
        controlLayout.addSpacer(10);
        resertSureIntegral.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                SC.ask("提示","您确定要重置确认积分吗?", new BooleanCallback() {
                    @Override
                    public void execute(Boolean value) {
                        if(value){
                            ListGridRecord[] records = grid.getRecords();
                            if (records == null || records.length == 0) {
                                return;
                            }else{
                                for(ListGridRecord record : records){
                                    record.setAttribute("assignSureIntegral", 0);
                                }
                                grid.setData(records);
                                //重置未确认积分
                                projectOverview.stageFinalIntegralItem.setValue(stageFinalIntegral);
                            }
                        }
                    }
                });
            }
        });
        
        IButton settlement = new IButton("确认");
        settlement.setWidth(100);
        controlLayout.addMember(settlement);
        controlLayout.addSpacer(10);
        IButton cancel = new IButton("退出");
        cancel.setWidth(100);
        controlLayout.addMember(cancel);
        cancel.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                destroy();
            }

        });
        settlement.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                SC.ask("提示","您确定要进行确认吗?", new BooleanCallback() {
                    @Override
                    public void execute(Boolean value) {
                        if(value){
                            if (getProjectId() == 0) {
                                SC.say("没有要确认的项目");
                                return;
                            }
                            final Map params = new HashMap();
                            params.put("projectId", projectId);
                            params.putAll(projectOverview.getValuesAsMap());
                            MapUtils.convertRecordToMap(grid.getDataSource(), grid.getRecords(), params, "projectEmployees");
                            //获取未结算的项目成本
                            DBDataSource.callOperation("EP_ProjectSure", params, new DSCallback() {
                                @Override
                                public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                                    if (dsResponse.getStatus() >= 0) {
                                        SC.say("确认成功");
                                        load();
                                    } else {
                                        Map errors = dsResponse.getErrors();
                                        SC.say("确认失败" + errors);
                                    }
                                }
                            });
                        }
                    }
                });
            }
        });
    }

    private void closeWindow() {
        this.destroy();
    }

    public void load() {
        if (projectId == 0) {
            return;
        }
        Map params = new HashMap();
        params.put("projectId", projectId);
        DBDataSource.callOperation("NQ_MprojectStageIntegralTotal", params, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0 && dsResponse.getData().length > 0) {
                    projectOverview.setRecord(dsResponse.getData()[0]);
                    projectOverview.startEdit();
                    setStageFinalIntegral(ClientUtil.checkAndGetDoubleValue(dsResponse.getData()[0].getAttribute("stageFinalIntegral")));
                    
                    Map params = new HashMap();
                    params.put("projectId", projectId);
                    params.put("stageId", ClientUtil.checkAndGetIntValue(dsResponse.getData()[0].getAttribute("stageId")));
                    DBDataSource.callOperation("NQ_MprojectEmployeeSureIntegrl", params, new DSCallback() {
                        @Override
                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                            if (dsResponse.getStatus() >= 0) {
                                grid.setData(dsResponse.getData());
                            }
                        }

                    });
                }
            }

        });
    }

    private final DelicacyListGrid grid = new DelicacyListGrid(true);
    private int projectId = 0;
    private double stageFinalIntegral;
    private final MprojectStageIntegralTotalUpdateForm projectOverview = new MprojectStageIntegralTotalUpdateForm();
    private Window parentWindow;

    /**
     * @return the projectId
     */
    public int getProjectId() {
        return projectId;
    }

    /**
     * @param projectId the projectId to set
     */
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
    
    /**
     * @return the parentWindow
     */
    public Window getParentWindow() {
        return parentWindow;
    }

    /**
     * @return the stageFinalIntegral
     */
    public double getStageFinalIntegral() {
        return stageFinalIntegral;
    }

    /**
     * @param stageFinalIntegral the stageFinalIntegral to set
     */
    public void setStageFinalIntegral(double stageFinalIntegral) {
        this.stageFinalIntegral = stageFinalIntegral;
    }

}
