package com.pomplatform.client.salaryemployeeevaluationrmmor.panel;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.salaryemployeeevaluationrmmor.datasource.DSSsalaryemployeeperformancemmeor;
import com.pomplatform.client.salaryemployeeevaluationrmmor.form.SsalaryemployeeperformancemmeorSearchForm;
import com.pomplatform.client.salaryemployeeevaluationrmmor.form.SsalaryemployeeperformancemmeorViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

public class SsalaryemployeeperformancemmeorPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	private static boolean canCheck = false;
	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			SsalaryemployeeperformancemmeorPanel cm = new SsalaryemployeeperformancemmeorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Ssalaryemployeeperformancemmeor";
		}

	}

	@Override
	public void init() {
		super.init();
		canCheck = false;
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		ListGridField [] fields = new ListGridField[18];
		int index = 0;
		fields[index] = new ListGridField("employeeNo");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("employeeId");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("plateId");
		fields[index].setShowGridSummary(false);
		fields[index].setCanEdit(true);
		index ++;
		fields[index] = new ListGridField("departmentId");
		fields[index].setShowGridSummary(false);
		fields[index].setCanEdit(true);
		index ++;
		fields[index] = new ListGridField("companyId");
		fields[index].setShowGridSummary(false);
		fields[index].setCanEdit(true);
		index ++;
		fields[index] = new ListGridField("status");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("year");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("month");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("monthPay");
		index ++;
		fields[index] = new ListGridField("basicProportionStr");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("monthBasicPay");
		index ++;
		fields[index] = new ListGridField("monthPerformancePay");
		index ++;
		fields[index] = new ListGridField("shouldDays");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("factDays");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("happenDate");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("grade");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("proportion");
		fields[index].setCanEdit(true);
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("workingCoefficient");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("actualPerformancePay");
		resultGrid.setFields(fields);
		
		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			
			@SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Map params = resultGrid.getRecord(event.getRowNum()).toMap();
//				Record record = event.getNewValuesAsRecord();
				BigDecimal proportion = BaseHelpUtils.getBigDecimalValue(params.get("proportion"));
				BigDecimal workingCoefficient = BaseHelpUtils.getBigDecimalValue(params.get("workingCoefficient"));
				BigDecimal monthPerformancePay = BaseHelpUtils.getBigDecimalValue(params.get("monthPerformancePay"));
				BigDecimal actualPerformancePay = monthPerformancePay.multiply(proportion.multiply(workingCoefficient));
				params.put("salaryEmployeePerformanceId", BaseHelpUtils.getIntValue(params.get("salaryEmployeePerformanceId")));
				params.put("actualPerformancePay", actualPerformancePay);
				params.put("proportion", proportion);
				params.put("monthPay", null);
				params.put("monthBasicPay", null);
				params.put("monthPerformancePay", null);
				
				params.put("departmentId", BaseHelpUtils.getIntValue(params.get("departmentId")));
				params.put("companyId", BaseHelpUtils.getIntValue(params.get("companyId")));
				params.put("plateId", BaseHelpUtils.getIntValue(params.get("plateId")));
				DBDataSource.callOperation("ST_SalaryEmployeePerformance", "saveOrUpdate", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						commonQuery();
					}
				});
				
			}
		});
		
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});
		resultGrid.setShowGridSummary(true);
//		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
//			@Override
//			public void onDoubleClick(DoubleClickEvent event) {
//				showDetail();
//			}
//		});
		IButton operation1Button = new IButton("查看详情");
		controlLayout.addMember(operation1Button);
		operation1Button.setIcon("[SKIN]/actions/view.png");
		operation1Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		IButton countButton = new IButton("计算绩效");
		controlLayout.addMember(countButton);
		countButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow pw = new PopupWindow();
				CountEmployeePerformancePanel panel = new CountEmployeePerformancePanel();
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				panel.setParentCanvas(pw);
				panel.setFatherWindow(pw);
				pw.addItem(panel);
				pw.setTitle("计算绩效");
				pw.setWidth("30%");
				pw.setHeight("30%");
				pw.centerInPage();
				pw.show();
				
			}
		});
		IButton exportButton = new IButton("导出");
		controlLayout.addMember(exportButton);
		exportButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				DBDataSource.downloadFile("DW_Ssalaryemployeeperformancemmeor", generateCriteria());
				
			}
		});
		
		
//		IButton operation2Button = new IButton("修改");
//		controlLayout.addMember(operation2Button);
//		operation2Button.setIcon("[SKIN]/actions/edit.png");
//		operation2Button.addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent event) {
//				GWT.runAsync(new RunAsyncCallback() {
//					@Override
//					public void onFailure(Throwable reason) {
//						SC.say("failure to download code");
//					}
//
//					@Override
//					public void onSuccess() {
//						if (!resultGrid.anySelected()) {
//							SC.say("请选择一条数据修改");
//							return;
//						}
//						final ListGridRecord selected1 = resultGrid.getSelectedRecord();
//						UpdateSsalaryemployeeperformancemmeorForm detailForm = new UpdateSsalaryemployeeperformancemmeorForm();
//						detailForm.setTitle("修改");
//						detailForm.addDataEditedHandler(new DataEditedHandler() {
//							@Override
//							public void onDataEdited(DataEditEvent event) {
//								DBDataSource.copyRecord(event.getData(), selected1);
//							}
//						});
//						detailForm.setSearchForm(searchForm);
//						detailForm.setRecord(selected1);
//						detailForm.setCurrentPage(getCurrentPage());
//						detailForm.initComponents();
//						detailForm.startEdit();
//						detailForm.setWidth100();
//						detailForm.setHeight100();
//						detailForm.centerInPage();
//						detailForm.show();
//						setCurrentPage(detailForm.getCurrentPage());
//					}
//				});
//			}
//		});

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
				detail.setTitle("详情");
				detail.setWidth100();
				detail.setHeight100();
				SsalaryemployeeperformancemmeorViewer detailForm = new SsalaryemployeeperformancemmeorViewer();
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
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by salary_employee_performance_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new SsalaryemployeeperformancemmeorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSSsalaryemployeeperformancemmeor.getInstance();
	}

}
