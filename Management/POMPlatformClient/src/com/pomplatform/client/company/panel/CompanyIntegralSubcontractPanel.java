package com.pomplatform.client.company.panel;

import java.util.Map;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.company.datasource.DSCompanyIntegralSubcontract;
import com.pomplatform.client.company.form.CompanyIntegralSubcontractSearchForm;
import com.pomplatform.client.company.form.CompanyIntegralSubcontractViewer;
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

public class CompanyIntegralSubcontractPanel extends AbstractSearchPanel {

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			CompanyIntegralSubcontractPanel cm = new CompanyIntegralSubcontractPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "CompanyIntegralSubcontract";
		}

	}

	@Override
	public void initComponents() {
		resultGrid.setShowRowNumbers(true);
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
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
		    		double sheetTotalIntegral = 0;
		    		double complaintPercentage = 0;
		    		double complaintIntegral = 0;
		    		double sheetIntegral = 0;
		    		double moneySum = 0;
		    		double commonArea = 0;
		    		double logisticsArea = 0;
		    		double designArea = 0;
		    		for (int i = 0; i < len; i++) {
		    			if ("汇总".equals(recordList[i].getAttribute("subContractCode"))) {// 如果已经存在汇总，则不可再进行汇总
		    				return;
		    			}
		    			sheetTotalIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("sheetTotalIntegral"));
		    			complaintPercentage += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("complaintPercentage"));
		    			complaintIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("complaintIntegral"));
		    			sheetIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("sheetIntegral"));
		    			moneySum += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("moneySum"));
		    			commonArea += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("commonArea"));
		    			logisticsArea += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("logisticsArea"));
		    			designArea += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("designArea"));
		    			records[i] = recordList[i];
		    		}
		    		Record record = new Record();
		    		record.setAttribute("subContractCode", "汇总");
		    		record.setAttribute("sheetTotalIntegral", sheetTotalIntegral);
		    		record.setAttribute("complaintPercentage", complaintPercentage);
		    		record.setAttribute("complaintIntegral", complaintIntegral);
		    		record.setAttribute("sheetIntegral", sheetIntegral);
		    		record.setAttribute("moneySum", moneySum);
		    		record.setAttribute("commonArea", commonArea);
		    		record.setAttribute("logisticsArea", logisticsArea);
		    		record.setAttribute("designArea", designArea);
		    		records[len] = record;
		    		resultGrid.setData(records);
		    		resultGrid.redraw();
		    	}
			}
		});

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
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
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("子订单");
				detail.setWidth100();
				detail.setHeight100();
				CompanyIntegralSubcontractViewer detailForm = new CompanyIntegralSubcontractViewer();
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
		if (null != params && !params.isEmpty()) {
			if (params.containsKey("startDate")) {
				criteria.put("startDate", params.get("startDate"));
			}
			if (params.containsKey("endDate")) {
				criteria.put("endDate", params.get("endDate"));
			}
			if (params.containsKey("businessType")) {
				criteria.put("businessType", params.get("businessType"));
			}
			if (params.containsKey("projectType")) {
				criteria.put("projectType", params.get("projectType"));
			}
			if (params.containsKey("departmentId")) {
				criteria.put("departmentId", params.get("departmentId"));
			}
		}
		return true;
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}
	
	@Override
	public SearchForm generateSearchForm() {
		return new CompanyIntegralSubcontractSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSCompanyIntegralSubcontract.getInstance();
	}

	private Map<String, Object> params;

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

}
