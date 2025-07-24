package com.pomplatform.client.onrevenue.panel;

import java.util.LinkedHashMap;
import java.util.Map;

import com.delicacy.client.MapUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.onrevenue.datasource.DSRevenueRecordOfOnRevenue;
import com.pomplatform.client.onrevenue.form.RevenueRecordOfOnRevenueSearchForm;
import com.pomplatform.client.onrevenue.form.RevenueRecordOfOnRevenueViewer;
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

public class RevenueRecordOfOnRevenuePanel extends AbstractSearchPanel
{


	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			RevenueRecordOfOnRevenuePanel cm = new RevenueRecordOfOnRevenuePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "RevenueRecordOfOnRevenue";
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
				DBDataSource.downloadFile("DW_RevenueRecordOfOnRevenue", condition);
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
					double revenueMoney = 0;// 营收金额
					double invoiceAmount = 0;// 发票金额
					double borrowMoney = 0;// 回款金额
					for (int i = 0; i < len; i++) {
						if ("汇总".equals(recordList[i].getAttribute("name"))) {// 如果已经存在汇总，则不可再进行汇总
							return;
						}
						money += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("money"));
						revenueMoney += ClientUtil
								.checkAndGetDoubleValue(recordList[i].getAttribute("revenueMoney"));
						invoiceAmount += ClientUtil
								.checkAndGetDoubleValue(recordList[i].getAttribute("invoiceAmount"));
						borrowMoney += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("borrowMoney"));
						records[i] = recordList[i];
					}
					Record record = new Record();
					record.setAttribute("name", "汇总");
					record.setAttribute("money", money);
					record.setAttribute("revenueMoney", revenueMoney);
					record.setAttribute("invoiceAmount", invoiceAmount);
					record.setAttribute("borrowMoney", borrowMoney);
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
				detail.setTitle("营收记录"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				RevenueRecordOfOnRevenueViewer detailForm = new RevenueRecordOfOnRevenueViewer();
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
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by revenue_record_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new RevenueRecordOfOnRevenueSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSRevenueRecordOfOnRevenue.getInstance();
	}


}

