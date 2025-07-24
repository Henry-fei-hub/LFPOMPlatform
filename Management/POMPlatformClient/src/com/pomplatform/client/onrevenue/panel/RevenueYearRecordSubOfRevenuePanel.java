package com.pomplatform.client.onrevenue.panel;

import java.util.LinkedHashMap;
import java.util.Map;

import com.delicacy.client.MapUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractExpansionRelatedPage;
import com.delicacy.client.ui.GenericViewWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.onrevenue.datasource.DSRevenueYearRecordSubOfRevenue;
import com.pomplatform.client.onrevenue.datasource.DSRevenueYearRecordSubOfRevenueChild;
import com.pomplatform.client.onrevenue.form.RevenueYearRecordOfRevenueSearchForm;
import com.pomplatform.client.onrevenue.form.RevenueYearRecordOfRevenueViewer;
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

public class RevenueYearRecordSubOfRevenuePanel extends AbstractExpansionRelatedPage
{


	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			RevenueYearRecordSubOfRevenuePanel cm = new RevenueYearRecordSubOfRevenuePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "RevenueYearRecordOfRevenue";
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

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		
		IButton exportButton = new IButton("导出");
		controlLayout.addMember(exportButton);
		exportButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				ClientUtil.departmentParameterProcess(condition);
				DBDataSource.downloadFile("DW_RevenueYearRecordSubOfRevenue", condition);
			}
		});

		IButton totalButton = new IButton("汇总");
		controlLayout.addMember(totalButton);
		totalButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] recordList = resultGrid.getRecords();
				int len = recordList.length;
				Record[] records = new Record[len + 1];
				if (len > 0) {
					double money = 0;// 金额
					double januaryRevenue = 0;// 一月
					double februaryRevenue = 0;// 二月
					double marchRevenue = 0;// 三月
					double aprilRevenue = 0;// 四月
					double mayRevenue = 0;// 五月
					double juneRevenue = 0;// 六月
					double julyRevenue = 0;// 七月
					double augustRevenue = 0;// 八月
					double septemberRevenue = 0;// 九月
					double octoberRevenue = 0;// 十月
					double novemberRevenue = 0;// 十一月
					double decemberRevenue = 0;// 十二月
					double totalRevenue = 0;// 合计
					for (int i = 0; i < len; i++) {
						if ("汇总".equals(recordList[i].getAttribute("name"))) {// 如果已经存在汇总，则不可再进行汇总
							return;
						}
						money += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("money"));
						januaryRevenue += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("januaryRevenue"));
						februaryRevenue += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("februaryRevenue"));
						marchRevenue += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("marchRevenue"));
						aprilRevenue += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("aprilRevenue"));
						mayRevenue += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("mayRevenue"));
						juneRevenue += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("juneRevenue"));
						julyRevenue += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("julyRevenue"));
						augustRevenue += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("augustRevenue"));
						septemberRevenue += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("septemberRevenue"));
						octoberRevenue += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("octoberRevenue"));
						novemberRevenue += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("novemberRevenue"));
						decemberRevenue += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("decemberRevenue"));
						totalRevenue += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("totalRevenue"));
						records[i] = recordList[i];
					}
					Record record = new Record();
					record.setAttribute("name", "汇总");
					record.setAttribute("money", money);
					record.setAttribute("januaryRevenue", januaryRevenue);
					record.setAttribute("februaryRevenue", februaryRevenue);
					record.setAttribute("marchRevenue", marchRevenue);
					record.setAttribute("aprilRevenue", aprilRevenue);
					record.setAttribute("mayRevenue", mayRevenue);
					record.setAttribute("juneRevenue", juneRevenue);
					record.setAttribute("julyRevenue", julyRevenue);
					record.setAttribute("augustRevenue", augustRevenue);
					record.setAttribute("septemberRevenue", septemberRevenue);
					record.setAttribute("octoberRevenue", octoberRevenue);
					record.setAttribute("novemberRevenue", novemberRevenue);
					record.setAttribute("decemberRevenue", decemberRevenue);
					record.setAttribute("totalRevenue", totalRevenue);
					records[len] = record;
					resultGrid.setData(records);
					resultGrid.redraw();
					resultGrid.setCanEdit(false);
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
				detail.setTitle("年度营收"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				RevenueYearRecordOfRevenueViewer detailForm = new RevenueYearRecordOfRevenueViewer();
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
		criteria.put("parentId",0);
		criteria.put("addtionalCondition", "order by revenue_year_record_id");
		return true;
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new RevenueYearRecordOfRevenueSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSRevenueYearRecordSubOfRevenue.getInstance();
	}

	@Override
	public DataSource getChildDataSource() {
		return DSRevenueYearRecordSubOfRevenueChild.getInstance();
	}


}

