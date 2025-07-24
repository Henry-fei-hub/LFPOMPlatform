package com.pomplatform.client.payment.panel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.payment.datasource.DSOnSalaryTotalData;
import com.pomplatform.client.payment.form.OnSalaryTotalDataSearchForm;
import com.pomplatform.client.payment.form.OnSalaryTotalDataViewer;
import com.pomplatform.client.project.form.SettlementPanel;
import com.pomplatform.client.project.panel.StageOfPlanningPanel;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

public class OnSalaryTotalDataPanel extends AbstractSearchPanel
{

	private Window parentWindow;
	private static final Logger __LOGGER = Logger.getLogger("");
	private static boolean canCheck = false;
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnSalaryTotalDataPanel cm = new OnSalaryTotalDataPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnSalaryTotalData";
		}
	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setShowRowNumbers(true);
		resultGrid.setCanEdit(true);
		resultGrid.setShowGridSummary(true);
		canCheck = false;
	}

	@Override
	public void initComponents() {
		resultGrid.setShowRowNumbers(true);
		resultGrid.setShowGridSummary(true);
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});
		
		IButton monthButton = new IButton("月统计");
        controlLayout.addMember(monthButton);
        monthButton.addClickHandler(new ClickHandler() {
            @SuppressWarnings("unchecked")
			@Override
            public void onClick(ClickEvent event) {
            	if(!canCheck){
            		SC.say("提示", "您无权进行操作");
            		return;
            	}
            	Map<String,Object> param = new HashMap<>();
            	Criteria record = searchForm.getValuesAsCriteria();
            	param.putAll(record.getValues());
            	param.put("employeeId", 0);
                param.put("optType", "onSalaryTotalAccount");
                final LoadingWindow loading = new LoadingWindow();
                DBDataSource.callOperation("EP_OnPaymentManageProcess", param, new DSCallback() {
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
        
        IButton monthByOneButton = new IButton("月统计个人");
        controlLayout.addMember(monthByOneButton);
        monthByOneButton.addClickHandler(new ClickHandler() {
        	@SuppressWarnings("unchecked")
        	@Override
        	public void onClick(ClickEvent event) {
        		if(!canCheck){
        			SC.say("提示", "您无权进行操作");
        			return;
        		}
        		Map<String,Object> param = new HashMap<>();
            	param.putAll(searchForm.getValues());
            	int employeeId = BaseHelpUtils.getIntValue(param.get("employeeId"));
            	if(employeeId<=0){
            		SC.say("提示","请选择人员");
            	}else {
            		param.put("optType", "onSalaryTotalAccount");
            		final LoadingWindow loading = new LoadingWindow();
            		DBDataSource.callOperation("EP_OnPaymentManageProcess", param, new DSCallback() {
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
        	}
        });
        
        
		IButton monthButton1 = new IButton("计算月专项扣除");
        controlLayout.addMember(monthButton1);
        monthButton1.addClickHandler(new ClickHandler() {
            @SuppressWarnings("unchecked")
			@Override
            public void onClick(ClickEvent event) {
            	/*if(!canCheck){
            		SC.say("提示", "您无权进行操作");
            		return;
            	}*/
            	Map<String,Object> param = new HashMap<>();
            	Criteria record = searchForm.getValuesAsCriteria();
            	param.putAll(record.getValues());
                param.put("optType", "onSpecialDeductionMonthTotalAccount");
                final LoadingWindow loading = new LoadingWindow();
                DBDataSource.callOperation("EP_OnPaymentManageProcess", param, new DSCallback() {
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
        
        
        IButton monthButton2 = new IButton("计算个人月专项扣除");
        controlLayout.addMember(monthButton2);
        monthButton2.addClickHandler(new ClickHandler() {
        	@SuppressWarnings("unchecked")
        	@Override
        	public void onClick(ClickEvent event) {
        		/*if(!canCheck){
            		SC.say("提示", "您无权进行操作");
            		return;
            	}*/
        		SC.debugger();
        		Map<String,Object> param = new HashMap<>();
        		param.putAll(searchForm.getValues());
        		int employeeId = BaseHelpUtils.getIntValue(param.get("employeeId"));
        		if(employeeId<=0) {
        			SC.say("提示", "请选择人员");
        			return;
        		}else {
        			param.put("optType", "onSpecialDeductionMonthTotalAccount");
        			final LoadingWindow loading = new LoadingWindow();
        			DBDataSource.callOperation("EP_OnPaymentManageProcess", param, new DSCallback() {
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
        	}
        });
        
        IButton sendButton = new IButton("下发");
        controlLayout.addMember(sendButton);
        sendButton.addClickHandler(new ClickHandler() {
			@SuppressWarnings("unchecked")
			@Override
            public void onClick(ClickEvent event) {
				if(!canCheck){
            		SC.say("提示", "您无权进行操作");
            		return;
            	}
            	Map<String,Object> param = new HashMap<>();
            	Criteria record = searchForm.getValuesAsCriteria();
            	param.putAll(record.getValues());
                param.put("optType", "onSalaryTotalSend");
                final LoadingWindow loading = new LoadingWindow();
                DBDataSource.callOperation("EP_OnPaymentManageProcess", param, new DSCallback() {
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
        
        IButton pushButton = new IButton("推送");
        controlLayout.addMember(pushButton);
        pushButton.addClickHandler(new ClickHandler() {
			@SuppressWarnings("unchecked")
			@Override
            public void onClick(ClickEvent event) {
				if(!canCheck){
            		SC.say("提示", "您无权进行操作");
            		return;
            	}
            	Map<String,Object> param = new HashMap<>();
            	Criteria record = searchForm.getValuesAsCriteria();
            	param.putAll(record.getValues());
                param.put("optType", "onSalaryTotalPush");
                final LoadingWindow loading = new LoadingWindow();
                DBDataSource.callOperation("EP_OnPaymentManageProcess", param, new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                    	loading.destroy();
                        if (dsResponse.getStatus() >= 0) {
                            SC.say("推送成功");
                        } else {
                            SC.say((String) dsResponse.getErrors().get("errorMsg"));
                        }
                    }
                    
                });
            }
        });
		
		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Map params = resultGrid.getRecord(event.getRowNum()).toMap();
				params.put("operateEmployeeId",ClientUtil.getEmployeeId());
				params.put("operateTime",new Date());
				DBDataSource.callOperation("ST_SalaryTotal","saveOrUpdate", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						}else {
							commonQuery();
						}
					}
				});
			}
		});

		IButton exportButton = new IButton("导出");
		controlLayout.addMember(exportButton);
		exportButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_OnExportSalaryTotal", condition);
			}
		});
		
//      IButton delButton = PermissionControl.createPermissionButton("删除", ERPPermissionStatic.CHECK_TOTAL_DEL_BUTTON);
		IButton delButton = new IButton("删除");
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
							Map<String,Object> param = resultGrid.getSelectedRecord().toMap();
							DBDataSource.callOperation("ST_SalaryTotal","delete", param, new DSCallback() {
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
        
		IButton summarizeButton = new IButton("汇总");
		controlLayout.addMember(summarizeButton);
		summarizeButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	if(!canCheck){
            		SC.say("提示", "您无权进行操作");
            		return;
            	}else {
                    PopupWindow popupWindow = new PopupWindow("工资汇总表");
                    popupWindow.setWidth("100%");
                    popupWindow.setHeight("100%");
                    popupWindow.centerInPage();
                    OnSalaryTotalDataSummarizePanel panel = new OnSalaryTotalDataSummarizePanel();
//                   panel.initComponents();
                    popupWindow.addItem(panel);
                    panel.setParentWindow(popupWindow);
                    popupWindow.centerInPage();
                    popupWindow.show();
                }

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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("工资总表"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				OnSalaryTotalDataViewer detailForm = new OnSalaryTotalDataViewer();
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
	public void commonQuery() {
		if(!canCheck){
			SC.askforValue("提示","您需输入正确的解锁密码方可查看数据",new ValueCallback() {
				@Override
				public void execute(String value) {
					if(BaseHelpUtils.isNullOrEmpty(value)){
						SC.say("提示","请输入正确的解锁密码");
					}else{
						Map<String,Object> params = new HashMap<>();
						params.put("password",BaseHelpUtils.getString(value));
						params.put("optType","onComparePassword");
						DBDataSource.callOperation("EP_OnPaymentManageProcess","find", params, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if (dsResponse.getStatus() < 0) {
									SC.say("提示","密码匹配错误");
								}else {
									canCheck = true;
									query();
								}
							}
						});
					}
				}
			});
			return;
		}else{
			query();
		}
	}
	
	public void query(){
		Map condition = generateCriteria();
        if (condition == null) {
            return;
        }
        if (searchForm != null) {
            searchButton.setIcon("loading38.gif");
        }
        DBDataSource ds = (DBDataSource) getDataSource();
        String operationName = ds.getActionMode() + ds.getActionName();
        final LoadingWindow loading = new LoadingWindow();
        DBDataSource.callOperation(operationName, "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
            	loading.destroy();
                if (searchForm != null) {
                    searchButton.setIcon("[SKIN]/actions/search.png");
                }
                if (dsResponse.getStatus() >= 0) {
                    resultGrid.setData(dsResponse.getData());
                    afterDataReceived(dsResponse.getData());
                    if (isNeedPagenation() && pager != null) {
                        if (currentPage == 1) {
                            totalPages = dsResponse.getAttributeAsInt("totalPages");
                            pager.getTotalPages().setContents(String.valueOf(totalPages));
                        }
                    }
                } else {
                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
                }
                if (showPagination() && pager != null) {
                    pager.getCurrentPage().setContents(String.valueOf(currentPage));
                }
            }
        });
	}
	
	@Override
	public void afterDataReceived(Record[] data) {
		if(!BaseHelpUtils.isNullOrEmpty(data) && data.length > 0){
			for(Record e : data){
				//获取是否发放
				boolean isSended = e.getAttributeAsBoolean("isSended");
				if(isSended){//如果已发放，则设置为不可用，即不可以进行修改
					e.setAttribute("enabled", false);
				}
			}
		}
	}
	
	@Override
	public Canvas generateHDataCanvas() {
		resultGrid = new DelicacyListGrid() {
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				//获取实付工资
				BigDecimal factSalary = BaseHelpUtils.getBigDecimalValue(record.getAttribute("factSalary"));
				if (factSalary.compareTo(BigDecimal.ZERO) < 0) {
					return "color: red;";
				} else {
					return super.getCellCSSText(record, rowNum, colNum);
				}
			}
		};
		resultGrid.setDataSource(getDataSource());
		resultGrid.setWidth100();
		resultGrid.setHeight100();
		resultGrid.setShowRowNumbers(true);
		resultGrid.setCanEdit(true);
		resultGrid.setShowGridSummary(true);
		return resultGrid;
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		return true;
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new OnSalaryTotalDataSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnSalaryTotalData.getInstance();
	}
	
	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}



}

