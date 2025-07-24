package com.pomplatform.client.account.panel;

import java.math.BigDecimal;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.account.datasource.DSProjectAccountAll;
import com.pomplatform.client.account.form.ProjectAccountAllSearchForm;
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
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class ProjectAccountAllPanel extends AbstractSearchPanel {

	private static final Logger logger = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			ProjectAccountAllPanel cm = new ProjectAccountAllPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "projectAccountAllPanel";
		}

	}
	
	@Override
	public void init() {
		super.init();
		resultGrid.setShowGridSummary(true);
		resultGrid.setShowRowNumbers(true);
		resultGrid.setAutoFitFieldWidths(false);
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
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				ListGridRecord[] selected = resultGrid.getSelectedRecords();
				int contractId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("contractId"));
				String contractName = BaseHelpUtils.getString(selected[0].getAttribute("contractName"));
				BigDecimal leftIntegral = BaseHelpUtils.getBigDecimalValue(selected[0].getAttribute("leftIntegral"));
				// 获取检索栏的开始日期和结束日期
				PopupWindow pw = new PopupWindow();
				AccountDesignPanel panel = new AccountDesignPanel();
				pw.addItem(panel);
				panel.setAccountTypeId(4);
				panel.setAccountId(contractId);
				panel.setLeftIntegral(leftIntegral);
				panel.initComponents();
				pw.setTitle("项目(" + contractName + ")的汇总明细");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});
		
		resultGrid.setHeaderHeight(60);  
		resultGrid.setHeaderSpans(new HeaderSpan[] {
				   new HeaderSpan("基本信息栏", new String[] {"contractCode","contractName"}),
				   new HeaderSpan("分析栏", new String[] {"leftIntegral"}),
				   new HeaderSpan("收入栏", new String[] {"pmPerformanceDeduct"}),
				   new HeaderSpan("支出栏", new String[] {"pmPerformanceAward","projectPerformance"})
			    }); 
		commonQuery();
	}
	
	@Override
	public void afterDataReceived(Record[] data) {
		String cancelSummaryFields = "contractCode,contractName";
		ClientUtil.setCancelGridSummaryFields(resultGrid, cancelSummaryFields);
	}
	
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("optType","onLoadProjectAccountData");
		return true;
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new ProjectAccountAllSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSProjectAccountAll.getInstance();
	}
	
}
