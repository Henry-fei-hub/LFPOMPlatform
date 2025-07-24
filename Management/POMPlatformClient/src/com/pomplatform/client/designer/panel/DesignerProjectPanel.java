package com.pomplatform.client.designer.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.designer.datasource.DSMDesignProject;
import com.pomplatform.client.designer.form.MprojectemployeeporViewer;
import com.pomplatform.client.managementteamproject.datasource.DSMManagementTeamProject;
import com.pomplatform.client.projectteambuild.form.UpdateSprojectteambuildForm;
import com.pomplatform.client.projectteambuild.form.UpdateSprojectteambuildForm2;
import com.pomplatform.client.projectview.form.SprojectViewNoDoubleClickViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

/**
 *
 * @author guanxgun
 */
public class DesignerProjectPanel extends AbstractSearchPanel {

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            DesignerProjectPanel cm = new DesignerProjectPanel();
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
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setShowRowNumbers(true);
		resultGrid.setShowGridSummary(true);
		resultGrid.setAutoFitFieldWidths(false);
	}

    @Override
    public void initComponents() {
        resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                ListGridRecord[] selected = resultGrid.getSelectedRecords();
                //先判断是不是设计订单
                int projectFlag = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("projectFlag"));
                if(projectFlag!=1) {
                	SC.say("提示","非设计订单不予查看详情");
                	return ;
                }
                int projectId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("projectId"));
                //获取项目名称
//                final String projectName = KeyValueManager.getValue("projects", projectId + "");
                //修下拉数据的方式
                String projectName = SyncDataUtil.getProjectName(projectId);
//                Record record = getProjectName(projectId);
//                String projectName = BaseHelpUtils.getString(record.getAttribute("projectName"));
                final DelicacyListGrid projectViewGrid = new DelicacyListGrid();
                projectViewGrid.setDataSource(DSMManagementTeamProject.getInstance());
                Map<String,Object> condition = new HashMap<>();
                condition.put("projectId", projectId);
                List<Map> keyvalues = new ArrayList<>();
                Map<String, String> kv = new HashMap<>();
                kv.put("key", "p.department_id in (select child_id from department_ids where department_id = ? )");
                kv.put("value", "1 = 1");
                keyvalues.add(kv);
                condition.put("keyValues", keyvalues);
                DBDataSource.callOperation("NQ_MManagementTeamProject", "find", condition, new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        if (dsResponse.getStatus() >= 0) {
                            projectViewGrid.setData(dsResponse.getData());
                            projectViewGrid.selectRecord(0);
                            GenericViewWindow detail = new GenericViewWindow();
                            detail.setTitle("项目(" + projectName + ")的相关信息");
                            detail.setWidth100();
                            detail.setHeight100();
                            SprojectViewNoDoubleClickViewer detailForm = new SprojectViewNoDoubleClickViewer();
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
        IButton viewButton = new IButton("刷新");
        controlLayout.addMember(viewButton);
        viewButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                commonQuery();
            }
        });
        
        IButton agreeButton = new IButton("同意");
//        controlLayout.addMember(agreeButton);
        agreeButton.addClickHandler(new ClickHandler() {
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
                            SC.say("请选择一条数据");
                            return;
                        }
                        Record record = resultGrid.getSelectedRecord();
                        //获取本次确认积分
        				BigDecimal realIntegral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("realIntegral"));
        				if(realIntegral.compareTo(BigDecimal.ZERO) < 0){
        					//获取项目ID
        					int projectId = BaseHelpUtils.getIntValue(record.getAttribute("projectId"));
        					//获取职员ID
        					int employeeId = BaseHelpUtils.getIntValue(record.getAttribute("employeeId"));
        					Map<String,Object> params = new HashMap<>();
        					params.put("projectId", projectId);
        					params.put("employeeId", employeeId);
        					params.put("settlementStatus", 2);//同意
        					params.put("optType", "onDesignerAgreeOrBack");
        					DBDataSource.callOperation("EP_OnProjectCommonProcess", params, new DSCallback() {
        						@Override
        						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
        							if (dsResponse.getStatus() >= 0) {
        								SC.say("提示","操作成功");
        								commonQuery();
        							}else {
        								ClientUtil.displayErrorMessage(dsResponse);
        							}
        						}
        						
        					});
        				}else{
        					SC.say("提示","该订单不处于待确认状态,无需进行操作");
        				}
                    }
                });
            }
        });
        
        IButton backButton = new IButton("驳回");
//        controlLayout.addMember(backButton);
        backButton.addClickHandler(new ClickHandler() {
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
                            SC.say("请选择一条数据");
                            return;
                        }
                        Record record = resultGrid.getSelectedRecord();
                        //获取本次确认积分
        				BigDecimal realIntegral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("realIntegral"));
        				if(realIntegral.compareTo(BigDecimal.ZERO) < 0){
        					//获取项目ID
        					int projectId = BaseHelpUtils.getIntValue(record.getAttribute("projectId"));
        					//获取职员ID
        					int employeeId = BaseHelpUtils.getIntValue(record.getAttribute("employeeId"));
        					Map<String,Object> params = new HashMap<>();
        					params.put("projectId", projectId);
        					params.put("employeeId", employeeId);
        					params.put("settlementStatus", 3);//驳回
        					params.put("optType", "onDesignerAgreeOrBack");
        					DBDataSource.callOperation("EP_OnProjectCommonProcess", params, new DSCallback() {
        						@Override
        						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
        							if (dsResponse.getStatus() >= 0) {
        								SC.say("提示","操作成功");
        								commonQuery();
        							}
        						}
        						
        					});
        				}else{
        					SC.say("提示","该订单不处于待确认状态,无需进行操作");
        				}
                    }
                });
            }
        });
        
        IButton planIntegralButton = new IButton("预分配页面");
        controlLayout.addMember(planIntegralButton);
        planIntegralButton.addClickHandler(new ClickHandler() {
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
                            SC.say("请选择一条数据");
                            return;
                        }
                        Record record = resultGrid.getSelectedRecord();
        				int count = BaseHelpUtils.getIntValue(record.getAttribute("count"));
        				if(count>0) {
        					UpdateSprojectteambuildForm2 detailForm = new UpdateSprojectteambuildForm2();
        					detailForm.setTitle("预分配积分待确定");
        					detailForm.setRecord(record);
        					detailForm.setCurrentPage(getCurrentPage());
        					detailForm.initComponents();
        					detailForm.startEdit();
        					detailForm.setWidth100();
        					detailForm.setHeight100();
        					detailForm.centerInPage();
        					detailForm.show();
        					detailForm.setShowMinimizeButton(false);
        					setCurrentPage(detailForm.getCurrentPage());
        				}else {
        					SC.say("提示","该订单不处于待确认状态,无需进行操作");
        				}
                        
                    }
                });
            }
        });
        commonQuery();
    }

    @Override
    public boolean checkSearchCriteria(Map criteria) {
        if(employeeId > 0){
            criteria.put("employeeId", employeeId);
        }else{
            criteria.put("employeeId", ClientUtil.getEmployeeId());
        }
        return true;
    }

    private int employeeId = 0;//如果employeeId，则表示页面跳转传递过来的值

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
    
	@Override
	public Canvas generateHDataCanvas() {
		resultGrid = new DelicacyListGrid() {
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				//获取本次确认积分
				BigDecimal realIntegral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("realIntegral"));
				int count = BaseHelpUtils.getIntValue(record.getAttribute("count"));
				if (realIntegral.compareTo(BigDecimal.ZERO) < 0) {
					return "color: blue;";
				}else if(count>0) {//有待审批的预分配积分
					return "color: red;";
				}else {
					return super.getCellCSSText(record, rowNum, colNum);
				}
			}
		};
		resultGrid.setDataSource(getDataSource());
		resultGrid.setWidth100();
		resultGrid.setHeight100();
		return resultGrid;
	}

	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSMDesignProject.getInstance();
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
