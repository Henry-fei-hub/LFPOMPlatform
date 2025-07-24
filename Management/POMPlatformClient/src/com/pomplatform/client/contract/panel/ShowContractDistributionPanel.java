package com.pomplatform.client.contract.panel;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.contract.datasource.DSShowContractDistribution;
import com.pomplatform.client.contract.form.ShowContractDistributionSearchForm;
import com.pomplatform.client.contract.form.ShowContractDistributionViewer;
import com.pomplatform.client.contract.form.TeamBuildingForm;
import com.smartgwt.client.data.*;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ShowContractDistributionPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ShowContractDistributionPanel cm = new ShowContractDistributionPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ShowContractDistribution";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		resultGrid.setAutoFitFieldWidths(false);
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
		viewButton.hide();
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		commonQuery();
		//更新提成
		IButton calculateButton = new IButton("更新提成");
		calculateButton.hide();
		controlLayout.addMember(calculateButton);
		calculateButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				Record record = resultGrid.getSelectedRecord();
				SC.debugger();
				Map<String, Object> params = new HashMap<>();
				params.put("optType", "updateRevenue");
				params.put("orderId",record.getAttributeAsString("orderId"));
				DBDataSource.callOperation("EP_NewContractDistributionProcess", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						SC.debugger();
						if (dsResponse.getStatus() > 0) {
							SC.say("更新成功");
						}else{
							SC.say("更新失败");
						}
					}
				});
			}
		});
		//团队策划的	
		IButton teamButton = new IButton("团队策划");
        controlLayout.addMember(teamButton);
		controlLayout.addMember(teamButton);
		teamButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				PopupWindow pWindow = new PopupWindow();
				pWindow.setTitle("团队组建");
				pWindow.setWidth("80%");
				pWindow.setHeight("80%");
				pWindow.centerInPage();
				TeamBuildingForm vLaout = new TeamBuildingForm();
				Record record = resultGrid.getSelectedRecord();
				if (!BaseHelpUtils.isNullOrEmpty(record)) {
					vLaout.initComponents(record.toMap());
				}
				pWindow.addItem(vLaout);
				pWindow.show();
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
				detail.setTitle("ShowContractDistribution"); 
				detail.setWidth100();
				detail.setHeight100(); 
				ShowContractDistributionViewer detailForm = new ShowContractDistributionViewer();
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
	
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.SHOW_CONTRACT_DISTRIBUTION_ALL_DATA)) {
			String plateIds = PomPlatformClientUtil.getRolePlateId();
			if(BaseHelpUtils.isNullOrEmpty(plateIds)){
				criteria.put("plateId", -1);
			}else{
				List<Map> keyvalues = new ArrayList<>();
				Map<String, String> kv = new HashMap<>();
				kv.put("key", "and C.contract_distribution_id");
				kv.put("value", "and cd.plate_id in("+plateIds+") ORDER BY cd.contract_distribution_id");
				keyvalues.add(kv);
				criteria.put("keyValues", keyvalues);
			}
		}
		return true;
	}
	
	@Override
	public void commonQuery() {
		Map condition = generateCriteria();
        if (condition == null) {
            return;
        }
        if (searchForm != null) {
            searchButton.setIcon("loading38.gif");
        }

        //获取时间
        int startYearTime = BaseHelpUtils.getIntValue(condition.get("startYearTime"));
		int startMonthTime = BaseHelpUtils.getIntValue(condition.get("startMonthTime"));
		int endYearTime = BaseHelpUtils.getIntValue(condition.get("endYearTime"));
		int endMonthTime = BaseHelpUtils.getIntValue(condition.get("endMonthTime"));

		//查询条件中有时间表明是查询时间段的营收	
		if(startYearTime != 0 && startMonthTime != 0 && endYearTime != 0 && endMonthTime != 0) {
			condition.put("optType", "calculateIntervalRevenue");
			String plateIds = PomPlatformClientUtil.getRolePlateId();
			condition.put("plateIds", plateIds);
			condition.put("currentPage",currentPage);
			final LoadingWindow loading = new LoadingWindow();
			DBDataSource.callOperation("EP_NewContractDistributionProcess", condition, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					loading.destroy();
					if (searchForm != null) {
						searchButton.setIcon("[SKIN]/actions/search.png");
					}
					if (dsResponse.getStatus() >= 0) {
//						SC.debugger();
//						resultGrid.clear();
						resultGrid.setData(dsResponse.getData());
						afterDataReceived(dsResponse.getData());
						if (isNeedPagenation() && pager != null) {
							if (currentPage == 1) {
								SC.debugger();
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
		}else {//查询条件中没有查询时间走原始的查询
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
						SC.debugger();
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
	}
	
	@Override
	public Canvas generateHDataCanvas() {
		resultGrid = new DelicacyListGrid() {
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				// 获取是否组建团队标识
				int orderStatus = BaseHelpUtils.getIntValue(record.getAttribute("orderStatus"));
				__LOGGER.info("orderStatus==="+orderStatus);
				if (orderStatus == 1) {
					return "color: green;";
				} else {
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
		return new ShowContractDistributionSearchForm();
	}


	@Override
	public DataSource getDataSource() {
		return DSShowContractDistribution.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 175;
	}


}

