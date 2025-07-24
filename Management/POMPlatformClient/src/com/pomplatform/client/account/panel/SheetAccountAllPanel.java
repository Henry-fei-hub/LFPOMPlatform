package com.pomplatform.client.account.panel;

import java.math.BigDecimal;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.account.datasource.DSSheetAccountAll;
import com.pomplatform.client.account.form.SheetAccountAllSearchForm;
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

public class SheetAccountAllPanel extends AbstractSearchPanel {

	private static final Logger logger = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			SheetAccountAllPanel cm = new SheetAccountAllPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "SheetAccountAllPanel";
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
				int projectId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("projectId"));
				String projectName = BaseHelpUtils.getString(selected[0].getAttribute("projectName"));
				BigDecimal leftIntegral = BaseHelpUtils.getBigDecimalValue(selected[0].getAttribute("leftIntegral"));
				// 获取检索栏的开始日期和结束日期
				PopupWindow pw = new PopupWindow();
				AccountDesignPanel panel = new AccountDesignPanel();
				pw.addItem(panel);
				panel.setAccountTypeId(5);
				panel.setAccountId(projectId);
				panel.setLeftIntegral(leftIntegral);
				panel.initComponents();
				pw.setTitle("订单(" + projectName + ")的汇总明细");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});
		
		resultGrid.setHeaderHeight(60);  
		resultGrid.setHeaderSpans(new HeaderSpan[] {
				   new HeaderSpan("基本信息栏", new String[] {"contractCode","projectName"}),
				   new HeaderSpan("分析栏", new String[] {"leftIntegral"}),
				   new HeaderSpan("收入栏", new String[] {"projectPerformanceAward","projectPerformanceAchieve"}),
				   new HeaderSpan("支出栏", new String[] {"projectPerformanceDeduct","projectPerformance"})
			    }); 
		commonQuery();
	}
	
	@Override
	public void afterDataReceived(Record[] data) {
		String cancelSummaryFields = "contractCode,projectName";
		ClientUtil.setCancelGridSummaryFields(resultGrid, cancelSummaryFields);
	}
	
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("optType","onLoadSheetAccountData");
		//如果没有拥有查看所有的权限，则只加载自己管理的订单的数据
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.SHEET_ACCOUNT_CHECK_ALL)){
			int employeeId = ClientUtil.getEmployeeId();
			criteria.put("employeeId", employeeId);
		}
		return true;
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new SheetAccountAllSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSSheetAccountAll.getInstance();
	}
	
}
