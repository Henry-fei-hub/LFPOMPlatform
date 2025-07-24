package com.pomplatform.client.payment.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.DownloadFileByUrl;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.UploadEmployeeDayPayment;
import com.pomplatform.client.employeesalary.panel.PasswordPanel;
import com.pomplatform.client.payment.datasource.DSOnLoadEmployeePayment;
import com.pomplatform.client.payment.form.OnLoadEmployeePaymentSearchForm;
import com.pomplatform.client.payment.form.OnLoadEmployeePaymentViewer;
import com.smartgwt.client.data.*;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
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

public class OnLoadEmployeePaymentPanel extends AbstractSearchPanel
{

	private static final Logger __LOGGER = Logger.getLogger("");
	private static boolean canCheck = false;
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnLoadEmployeePaymentPanel cm = new OnLoadEmployeePaymentPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnLoadEmployeePayment";
		}

	}

	@Override
	public void init(){
		super.init();
		resultGrid.setShowRowNumbers(true);
		resultGrid.setShowGridSummary(true);
		resultGrid.setAutoFitFieldWidths(false);
		__controlPosition = LayoutConstant.RIGHT;
		canCheck = false;
	}

	@Override
	public void initComponents() {
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		IButton viewDayButton = new IButton("日薪详情");
		viewDayButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@Override
					public void onSuccess() {
						if(!canCheck){
		            		SC.say("提示", "您无权进行操作");
		            		return;
		            	}
						if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
						ListGridRecord[] selected = resultGrid.getSelectedRecords();
						int employeeId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("employeeId"));
						String employeeName = BaseHelpUtils.getString(selected[0].getAttribute("employeeName"));
						PopupWindow pw = new PopupWindow();
						DayPaymentDesignPanel panel = new DayPaymentDesignPanel();
						pw.addItem(panel);
						panel.setEmployeeId(employeeId);
						panel.startEdit();
						pw.setTitle("职员(" + employeeName + ")的薪酬明细");
						pw.setWidth100();
						pw.setHeight100();
						pw.centerInPage();
						pw.show();
					}
				});
			}
		});
		controlLayout.addMember(viewDayButton);
		
		IButton viewMonthButton = new IButton("月薪详情");
		viewMonthButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@Override
					public void onSuccess() {
						if(!canCheck){
		            		SC.say("提示", "您无权进行操作");
		            		return;
		            	}
						if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
						ListGridRecord[] selected = resultGrid.getSelectedRecords();
						int employeeId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("employeeId"));
						String employeeName = BaseHelpUtils.getString(selected[0].getAttribute("employeeName"));
						PopupWindow pw = new PopupWindow();
						MonthPaymentDesignPanel panel = new MonthPaymentDesignPanel();
						pw.addItem(panel);
						panel.setEmployeeId(employeeId);
						panel.startEdit();
						pw.setTitle("职员(" + employeeName + ")的薪酬明细");
						pw.setWidth100();
						pw.setHeight100();
						pw.centerInPage();
						pw.show();
					}
				});
			}
		});
		controlLayout.addMember(viewMonthButton);
		
		IButton dayTotalButton = new IButton("日薪汇总");
		dayTotalButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@Override
					public void onSuccess() {
						if(!canCheck){
		            		SC.say("提示", "您无权进行操作");
		            		return;
		            	}
						PopupWindow pw = new PopupWindow();
						DayPaymentTotalPanel panel = new DayPaymentTotalPanel();
						pw.addItem(panel);
						pw.setTitle("日薪汇总总表");
						panel.commonQuery();
						pw.setWidth100();
						pw.setHeight100();
						pw.centerInPage();
						pw.show();
					}
				});
			}
		});
		controlLayout.addMember(dayTotalButton);
		
		IButton importButton = new IButton("导入");
		controlLayout.addMember(importButton);
		importButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@Override
					public void onSuccess() {
						UploadEmployeeDayPayment uploadXls = new UploadEmployeeDayPayment();
						uploadXls.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						uploadXls.show();
					}
					
				});
			}
		});

		IButton downloadTemplate = new IButton("下载模板");
		controlLayout.addMember(downloadTemplate);
		downloadTemplate.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				DownloadFileByUrl.download("/files/salaryImportTemplate.xlsx");
			}
		});
		
		IButton costEditbut = PermissionControl.createPermissionButton("人工成本调节", ERPPermissionStatic.DAY_PAYMENT_MANAGE_COST);
		controlLayout.addMember(costEditbut);
		costEditbut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow pw = new PopupWindow();
				PersonCostEditPanel panel = new    PersonCostEditPanel();                         
				pw.addItem(panel);
				pw.setTitle("人工成本调节");
				pw.setWidth("50%");
				pw.setHeight("50%");
				panel.initComponents();
				panel.lodaData();
				panel.addDataEditedHandler(new DataEditedHandler(){
					@Override
					public void onDataEdited(DataEditEvent event) {
					}
				});
				pw.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						pw.destroy();
					}
				});
				panel.setParentWindow(pw);
				pw.centerInPage();
				pw.show();
			}
		});
		
		IButton ExportButton =PermissionControl.createPermissionButton("导出", ERPPermissionStatic.DAY_PAYMENT_EXPORT_COST);
		controlLayout.addMember(ExportButton);
		ExportButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(!canCheck){
					SC.askforValue("提示","您需输入正确的解锁密码即可导出报表",new ValueCallback() {
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
											Map condition = generateCriteria();
											DBDataSource.downloadFile("DW_OnLoadEmployeePayment", condition);
										}
									}
								});
							}
						}
					});
					return;
				}else {
					Map condition = generateCriteria();
					DBDataSource.downloadFile("DW_OnLoadEmployeePayment", condition);
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
				detail.setTitle("日薪管理详情"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				OnLoadEmployeePaymentViewer detailForm = new OnLoadEmployeePaymentViewer();
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

			PopupWindow pWindow = new PopupWindow();
			pWindow.setTitle("您需输入正确的解锁密码方可查看数据");
			pWindow.setWidth("20%");
			pWindow.setHeight("13%");
			pWindow.centerInPage();
			PasswordPanel panel = new PasswordPanel();
			panel.setParentWindow(pWindow);
			panel.addDataEditedHandler(new DataEditedHandler() {
				@Override
				public void onDataEdited(DataEditEvent event) {
					Record record1 = event.getData();
					String value = BaseHelpUtils.getString(record1.getAttribute("password"));
					if(BaseHelpUtils.isNullOrEmpty(value)){
						SC.say("提示","请输入正确的解锁密码");
					}else{
						Map<String,Object> params = new HashMap<>();
						params.put("password",value);
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
			pWindow.addItem(panel);
			pWindow.show();

//			SC.askforValue("提示","您需输入正确的解锁密码方可查看数据",new ValueCallback() {
//				@Override
//				public void execute(String value) {
//					if(BaseHelpUtils.isNullOrEmpty(value)){
//						SC.say("提示","请输入正确的解锁密码");
//					}else{
//						Map<String,Object> params = new HashMap<>();
//						params.put("password",BaseHelpUtils.getString(value));
//						params.put("optType","onComparePassword");
//						DBDataSource.callOperation("EP_OnPaymentManageProcess","find", params, new DSCallback() {
//							@Override
//							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//								if (dsResponse.getStatus() < 0) {
//									SC.say("提示","密码匹配错误");
//								}else {
//									canCheck = true;
//									query();
//								}
//							}
//						});
//					}
//				}
//			});
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
	public int getSearchFormHeight() {
		return 60;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		//只加载可用的数据
		criteria.put("enabled", Boolean.TRUE);
		return true;
	}
	
	@Override
	public SearchForm generateSearchForm() {
		return new OnLoadEmployeePaymentSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnLoadEmployeePayment.getInstance();
	}


}
