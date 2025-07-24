package com.pomplatform.client.shift.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LoadingWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.shift.datasource.DSSEmployeeMonthCheck;
import com.pomplatform.client.shift.form.EmployeeMonthCheckSearchForm;
import com.pomplatform.client.shift.form.EmployeeMonthCheckViewer;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class EmployeeMonthCheckPanel extends AbstractSearchPanel {
	private static final Logger __logger = Logger.getLogger("");
    public static class Factory implements PanelFactory {
        
        private String id;
        
        @Override
        public Canvas create() {
            EmployeeMonthCheckPanel cm = new EmployeeMonthCheckPanel();
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
                Map param = record.getValues();
                ClientUtil.departmentParameterProcess(param);
                DBDataSource.downloadFile("DW_OnGetEmployeeMonthCheck", param);
            }
        });
        controlLayout.addMember(downButton);

        IButton downButton1 = PermissionControl.createPermissionButton("导出明细", ERPPermissionStatic.CHECK_TOTAL_EXPORT_BUTTON);
        downButton1.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Criteria record = searchForm.getValuesAsCriteria();
                Map param = record.getValues();
                if (resultGrid.anySelected()) {
                    Record r = resultGrid.getSelectedRecord();
                    //获取职员ID
                    int employeeId = BaseHelpUtils.getIntValue(r.getAttribute("employeeId"));
                    param.put("employeeId", employeeId);
                    param.put("year",r.getAttributeAsInt("year"));
                    param.put("month",r.getAttributeAsInt("month"));
                }

                ClientUtil.departmentParameterProcess(param);
//                List<Map> keyvalues = new ArrayList<>();
//                Map<String, String> kv = new HashMap<>();
//                kv.put("key", "employee_day_checks");
//                kv.put("value", "employee_month_checks");
//                keyvalues.add(kv);
//                param.put("keyValues", keyvalues);
                param.put("recordDate",new Date());
                DBDataSource.downloadFile("DW_ExportAttendanceSummaryDetail", param);
            }
        });
        controlLayout.addMember(downButton1);
        
        IButton downFullTimeButton = PermissionControl.createPermissionButton("全勤导出", ERPPermissionStatic.CHECK_TOTAL_EXPORT_BUTTON);
        downFullTimeButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Criteria record = searchForm.getValuesAsCriteria();
                Map param = record.getValues();
                ClientUtil.departmentParameterProcess(param);
                DBDataSource.downloadFile("DW_OnGetFullTimeEmployeeData", param);
            }
        });
        controlLayout.addMember(downFullTimeButton);
        
        IButton dayButton = PermissionControl.createPermissionButton("日统计", ERPPermissionStatic.CHECK_TOTAL_RECOUNT_BUTTON);
        controlLayout.addMember(dayButton);
        dayButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Map<String,Object> param = new HashMap<>();
                param.put("optType", "onEmployeeDayCheck");
                final LoadingWindow loading = new LoadingWindow();
                DBDataSource.callOperation("EP_OnShiftManageProcess", param, new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                    	loading.destroy();
                        if (dsResponse.getStatus() >= 0) {
                            SC.say("计算成功");
                            commonQuery();
                        } else {
                            SC.say((String) dsResponse.getErrors().get("errorMsg"));
                        }
                    }
                    
                });
            }
        });
        
        IButton monthButton = PermissionControl.createPermissionButton("月统计所有", ERPPermissionStatic.CHECK_TOTAL_RECOUNT_BUTTON);
        controlLayout.addMember(monthButton);
        monthButton.addClickHandler(new ClickHandler() {
            @SuppressWarnings("unchecked")
			@Override
            public void onClick(ClickEvent event) {
            	Map<String,Object> param = new HashMap<>();
            	Criteria record = searchForm.getValuesAsCriteria();
            	param.putAll(record.getValues());
                param.put("optType", "onEmployeeMonthCheck");
                param.put("employeeId",0);
                param.put("operator", ClientUtil.getEmployeeId());
                final LoadingWindow loading = new LoadingWindow();
                DBDataSource.callOperation("EP_OnShiftManageProcess", param, new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                    	loading.destroy();
                    	SC.say("" + dsResponse.getErrors().get("errorMsg"));
//                        if (dsResponse.getStatus() >= 0) {
//                            SC.say("计算成功");
//                            commonQuery();
//                        } else {
//                            SC.say((String) dsResponse.getErrors().get("errorMsg"));
//                        }
                    }
                    
                });
            }
        });
        
        IButton monthOneButton = PermissionControl.createPermissionButton("月统计个人", ERPPermissionStatic.CHECK_TOTAL_RECOUNT_BUTTON);
        controlLayout.addMember(monthOneButton);
        monthOneButton.addClickHandler(new ClickHandler() {
            @SuppressWarnings("unchecked")
			@Override
            public void onClick(ClickEvent event) {
            	if (!resultGrid.anySelected()) {
                    SC.say("请选择一条数据");
                    return;
                }
                Record r = resultGrid.getSelectedRecord();
                //获取职员ID
                int employeeId = BaseHelpUtils.getIntValue(r.getAttribute("employeeId"));
            	Map<String,Object> param = new HashMap<>();
            	Criteria record = searchForm.getValuesAsCriteria();
            	param.putAll(record.getValues());
                param.put("optType", "onEmployeeMonthCheck");
                param.put("employeeId", employeeId);
                param.put("operator", ClientUtil.getEmployeeId());
                final LoadingWindow loading = new LoadingWindow();
                DBDataSource.callOperation("EP_OnShiftManageProcess", param, new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                    	loading.destroy();
                    	SC.say("" + dsResponse.getErrors().get("errorMsg"));
//                        if (dsResponse.getStatus() >= 0) {
//                            SC.say("计算成功");
//                            commonQuery();
//                        } else {
//                            SC.say((String) dsResponse.getErrors().get("errorMsg"));
//                        }
                    }
                    
                });
            }
        });
        
//        IButton lockButton = new IButton("解锁");
        IButton lockButton = PermissionControl.createPermissionButton("解锁", ERPPermissionStatic.CHECK_TOTAL_UNLOCK_BUTTON);
        controlLayout.addMember(lockButton);
        lockButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
                    SC.say("请选择一条数据");
                    return;
                }
				Record r = resultGrid.getSelectedRecord();
                //获取职员ID
                int employeeId = BaseHelpUtils.getIntValue(r.getAttribute("employeeId"));
				Map<String,Object> map = new HashMap<>();
				map.put("year", searchForm.getItem("year").getValue());
				map.put("month", searchForm.getItem("month").getValue());
				map.put("employeeId", employeeId);
				map.put("optType", "unlockCheckData");
				DBDataSource.callOperation("EP_OnShiftManageProcess", map, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							SC.say("解锁成功");
							commonQuery();
						}
					}
				});
			}
		});
        
        IButton delButton = PermissionControl.createPermissionButton("删除", ERPPermissionStatic.CHECK_TOTAL_DEL_BUTTON);
        controlLayout.addMember(delButton);
        delButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
                    SC.say("请选择一条数据");
                    return;
                }
				 SC.ask("提示","你确认要进行删除吗?",new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						// TODO Auto-generated method stub
						if(value){
							
							if(resultGrid.getSelectedRecord().getAttributeAsBoolean("isLocked") == Boolean.TRUE) {
								SC.say("提示", "该数据已锁定,不能删除");
								return;
							}
							Map<String,Object> param = resultGrid.getSelectedRecord().toMap();
							param.put("optType", "delEmployeeMonthCheck");
							DBDataSource.callOperation("EP_OnProjectWithStageCommon", param, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if(dsResponse.getStatus() >= 0){
										SC.say("删除成功");
										commonQuery();
									}else {
										SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
									}
								}
							});
						}
					}
				 });
			}
		});
        
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
                Record record = resultGrid.getSelectedRecord();
                GenericViewWindow detail = new GenericViewWindow();
                detail.setTitle("考勤详情");
                detail.setWidth100();
                detail.setHeight100();
                EmployeeMonthCheckViewer detailForm = new EmployeeMonthCheckViewer();
                detailForm.setParentSearchForm(searchForm);
                detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
                detailForm.setEmployeeId(record.getAttributeAsInt("employeeId"));
                detailForm.setYear(record.getAttributeAsInt("year"));
                detailForm.setMonth(record.getAttributeAsInt("month"));
                detailForm.initComponents();
                detailForm.viewSelectedData(resultGrid);
                detailForm.loadDetailGridData();
                detail.setContent(detailForm);
                detail.addCloseClickHandler(new CloseClickHandler() {
					
					@Override
					public void onCloseClick(CloseClickEvent event) {
						commonQuery();
					}
				});
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
            if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.CHECK_TOTAL_PLATE_SHOW_DATA)){//没有查看自己板块的权利，只有查看自己的权利  （板块管理员查看）
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
        return new EmployeeMonthCheckSearchForm();
    }
    
    @Override
    public DataSource getDataSource() {
        return DSSEmployeeMonthCheck.getInstance();
    }

    @Override
    public int getSearchFormHeight() {
        return 63;
    }
    
    @Override
	public Canvas generateHDataCanvas() {
		resultGrid = new DelicacyListGrid() {  
            @Override  
            protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
            	//如果数据已加锁，则字体颜色显示为灰色
        		 if (record.getAttributeAsBoolean("isLocked") == Boolean.TRUE) { 
        			 return "color: lightgray;";
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
    
}
