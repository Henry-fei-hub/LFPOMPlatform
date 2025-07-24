package com.pomplatform.client.salary.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.LoadingWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.salary.datasource.DSSalaryOfWorkYears;
import com.pomplatform.client.salary.form.SalaryOfWorkYearsSearchForm;
import com.pomplatform.client.salary.form.SalaryOfWorkYearsViewer;
import com.pomplatform.client.salary.form.UpdateSalaryOfWorkYearsForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class SalaryOfWorkYearsPanel extends AbstractSearchPanel
{

	private static boolean canCheck = false;
	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			SalaryOfWorkYearsPanel cm = new SalaryOfWorkYearsPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "SalaryOfWorkYears";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setShowGridSummary(true);
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
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		
		IButton updateButton = new IButton("编辑");
		updateButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){
					SC.say("请选择一条数据进行操作");
					return;
				}
				SC.debugger();
				ListGridRecord selected = resultGrid.getSelectedRecord();
				UpdateSalaryOfWorkYearsForm detailForm = new UpdateSalaryOfWorkYearsForm();
                 detailForm.setTitle("编辑工龄工资");
                 detailForm.setRecord(selected);
                 detailForm.setCurrentPage(getCurrentPage());
                 detailForm.initComponents();
                 detailForm.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						// TODO Auto-generated method stub
						commonQuery();
					}
				});
                 detailForm.startEdit();
                 detailForm.setWidth("50%");
                 detailForm.setHeight("50%");
                 detailForm.centerInPage();
                 detailForm.show();
                 setCurrentPage(detailForm.getCurrentPage());
				
/*				Map<String,Object> map = resultGrid.getSelectedRecord().toMap();
				Map <String ,Object> params =new HashMap<>();
				params.put("year", value);
				params.put("month", value);
				params.put("employeeId", value);
				DBDataSource.callOperation("EP_ToCalculateWorkYears", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							commonQuery();
						}
					}
				});*/
			}
		});
		controlLayout.addMember(updateButton);
		
		
		
		IButton downloadButton = new IButton("导出");
		downloadButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				DBDataSource.downloadFile("DW_OnDownLoadWorkMoney", generateCriteria());
			}
		});
		controlLayout.addMember(downloadButton);
		
		IButton calculateButton = new IButton("计算");
		calculateButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map<String,Object> params = generateCriteria();
				if(BaseHelpUtils.isNullOrEmpty(params.get("year"))){
					SC.say("请选择要计算的年份");
					return;
				}
				if(BaseHelpUtils.isNullOrEmpty(params.get("month"))){
					SC.say("请选择要计算的月份");
					return;
				}
				final LoadingWindow loading = new LoadingWindow();
				DBDataSource.callOperation("EP_ToCalculateWorkYears", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						loading.destroy();
						if(dsResponse.getStatus() >= 0){
							commonQuery();
						}
					}
				});
			}
		});
		controlLayout.addMember(calculateButton);
		
		commonQuery();
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
				detail.setTitle("SalaryOfWorkYears"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				SalaryOfWorkYearsViewer detailForm = new SalaryOfWorkYearsViewer();
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
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by employee_id");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new SalaryOfWorkYearsSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSSalaryOfWorkYears.getInstance();
	}
	
	@Override
	public int getSearchFormHeight() {
		return 120;
	}

}

