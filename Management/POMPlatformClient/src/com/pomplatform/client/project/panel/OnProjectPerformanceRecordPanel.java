package com.pomplatform.client.project.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractExpansionRelatedPage;
import com.delicacy.client.ui.LoadingWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.project.datasource.DSOnProjectPerformanceRecord;
import com.pomplatform.client.project.datasource.DSOnProjectPerformanceRecordChild;
import com.pomplatform.client.project.form.OnProjectPerformanceRecordSearchForm;
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
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class OnProjectPerformanceRecordPanel extends AbstractExpansionRelatedPage
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnProjectPerformanceRecordPanel cm = new OnProjectPerformanceRecordPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnProjectPerformanceRecord";
		}

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
		
		IButton backButton = new IButton("绩效回退");
		controlLayout.addMember(backButton);
		backButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("提示","请选择一条记录回退");
							return;
						}
						SC.askforValue("提示","请输入回退的缘由", new ValueCallback() {
							@Override
							public void execute(String value) {
								if(!BaseHelpUtils.isNullOrEmpty(value)){
									Record record = resultGrid.getSelectedRecord();
									int projectManagePerformanceTotalId = BaseHelpUtils.getIntValue(record.getAttribute("projectManagePerformanceTotalId"));
									Map<String,Object> params = new HashMap<>();
									params.put("projectManagePerformanceTotalId", projectManagePerformanceTotalId);
									params.put("optType","onProjectPerformanceBack");
									params.put("remark",value);
									final LoadingWindow loading = new LoadingWindow();
									DBDataSource.callOperation("EP_OnProjectCommonProcess", "find", params, new DSCallback() {
										@Override
										public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
											loading.destroy();
											if (dsResponse.getStatus() >= 0) {
												SC.say("提示","操作成功");
												commonQuery();
											}
										}
									});
								}else{
									SC.say("提示","请输入回退的缘由");
								}
							}
						});
					}
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}
				});
			}
		});

		commonQuery();
	}
	
	@Override
	public void customCommonQuery(ListGridRecord record,ListGrid childGrid) {
		//根据父级plateId去检索子级的数据集
		int projectManagePerformanceTotalId = BaseHelpUtils.getIntValue(record.getAttribute("projectManagePerformanceTotalId"));
		//获取父级查询的开始日期和结束日期
		Map<String,Object> map = new HashMap<>();
		map.put("projectManagePerformanceTotalId", projectManagePerformanceTotalId);
		final LoadingWindow loading = new LoadingWindow();
		DBDataSource.callOperation("ST_ProjectManagePerformanceRecord",map.toString(),"find", new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				loading.destroy();
				if (dsResponse.getStatus() >= 0) {
					childGrid.setData(dsResponse.getData());
				}
			}
		});
	}


	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by project_manage_performance_total_id desc");
		return true;
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new OnProjectPerformanceRecordSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnProjectPerformanceRecord.getInstance();
	}

	@Override
	public DataSource getChildDataSource() {
		return DSOnProjectPerformanceRecordChild.getInstance();
	}


}

