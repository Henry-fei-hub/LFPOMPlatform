package com.pomplatform.client.receivables.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.receivables.datasource.DSInvoiceReport;
import com.pomplatform.client.receivables.form.InvoiceReportDetailForm;
import com.pomplatform.client.receivables.form.InvoiceReportSearchForm;
import com.pomplatform.client.receivables.form.InvoiceReportViewer;
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

public class InvoiceReportPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			InvoiceReportPanel cm = new InvoiceReportPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "InvoiceReport";
		}

	}

	@Override
	public void init(){
		super.init();
		resultGrid.setAutoFitFieldWidths(false);
		__controlPosition = LayoutConstant.RIGHT;
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
		
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.PROJECT_HK_REPORT_CHECK_ALL)) {
			resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
				@Override
				public void onDoubleClick(DoubleClickEvent event) {
					PopupWindow pWindow = new PopupWindow();
					pWindow.setTitle("项目经理发票详情");
					pWindow.setWidth("90%");
					pWindow.setHeight("80%");
					pWindow.centerInPage();
					InvoiceReportDetailForm vLaout = new InvoiceReportDetailForm();
					Record record = resultGrid.getSelectedRecord();
					if (!BaseHelpUtils.isNullOrEmpty(record)) {
						vLaout.initComponents(record.toMap());
					}
					pWindow.addItem(vLaout);
					pWindow.show();
					InvoiceReportPanel invoiceReportPanel = new InvoiceReportPanel();
					vLaout.setParentPanel(invoiceReportPanel);
				}
			});
		}

		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
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
				detail.setTitle("发票统计报表"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				InvoiceReportViewer detailForm = new InvoiceReportViewer();
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
		//如果没有查看所有数据权限
		if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.PROJECT_HK_REPORT_CHECK_ALL)) {
			//如果有查看管理部门
			if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.PROJECT_HK_REPORT_CHECK_MANAGE)) {
				//获取自己管理部门的部门id数据集
				String plateIds = PomPlatformClientUtil.getRolePlateId();
				if(!BaseHelpUtils.isNullOrEmpty(plateIds)) {
					List<Map> keyvalues = new ArrayList<>();
					Map<String, String> kv = new HashMap<>();
					kv.put("key", "AND e.plate_id =?");
					kv.put("value", "and e.plate_id in("+plateIds+") AND e.plate_id =?");
					keyvalues.add(kv);
					criteria.put("keyValues", keyvalues);
				}else {
					criteria.put("plateId",-1);
				}
			}else {//则只能查看个人管理数据权限
				int projectManagerId = ClientUtil.getEmployeeId();
				criteria.put("projectManagerId", projectManagerId);
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
		return new InvoiceReportSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSInvoiceReport.getInstance();
	}


}

