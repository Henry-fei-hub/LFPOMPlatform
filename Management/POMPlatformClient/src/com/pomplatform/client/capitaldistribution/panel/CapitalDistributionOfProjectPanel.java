package com.pomplatform.client.capitaldistribution.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.capitaldistribution.datasource.DSCapitalDistributionOfProject;
import com.pomplatform.client.capitaldistribution.form.CapitalDistributionOfProjectSearchForm;
import com.pomplatform.client.capitaldistribution.form.CapitalDistributionOfProjectViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;

public class CapitalDistributionOfProjectPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			CapitalDistributionOfProjectPanel cm = new CapitalDistributionOfProjectPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "CapitalDistributionOfProject";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public void initComponents() {
		ListGridField[] fields = new ListGridField[9];
		int idx = 0;
		fields[idx] = new ListGridField("contractCode");
		fields[idx++].setShowGridSummary(false);
		fields[idx] = new ListGridField("contractId");
		fields[idx++].setShowGridSummary(false);
		fields[idx] = new ListGridField("plateId");
		fields[idx++].setShowGridSummary(false);
		fields[idx] = new ListGridField("projectContractCode");
		fields[idx++].setShowGridSummary(false);
		fields[idx] = new ListGridField("projectName");
		fields[idx++].setShowGridSummary(false);
		fields[idx] = new ListGridField("totalAmount");
		fields[idx++].setShowGridSummary(false);
		fields[idx++] = new ListGridField("distributionAmount");
		fields[idx] = new ListGridField("happenDate");
		fields[idx++].setShowGridSummary(false);
		fields[idx] = new ListGridField("remark");
		fields[idx++].setShowGridSummary(false);
		
		resultGrid.setFields(fields);
		resultGrid.setShowGridSummary(false);
		
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
				CapitalDistributionBarChartPanel panel = new CapitalDistributionBarChartPanel();
				panel.initComponents();
				panel.setContractId(resultGrid.getSelectedRecord().getAttribute("contractId"));
				panel.loadData();
				PopupWindow window = new PopupWindow("回款分配");
				window.setWidth100();
				window.setHeight100();
				window.centerInPage();
				window.addMember(panel);
				window.show();
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
		IButton downloadButton = new IButton("导出");
		downloadButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				DBDataSource.downloadFile("DW_CapitalDistributionOfProject", generateCriteria());
			}
		});
		controlLayout.addMember(downloadButton);
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
				detail.setTitle("订单回款分配"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				CapitalDistributionOfProjectViewer detailForm = new CapitalDistributionOfProjectViewer();
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
		List<Map<String,Object>> keyvalues = new ArrayList<>();
		if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.CAPITAL_DISTRIBUTION_CHECK_ALL)
				&& ClientUtil.checkIsHavePermission(ERPPermissionStatic.CAPITAL_DISTRIBUTION_CHECK_PLATE)) {
			criteria.put("loginUser", ClientUtil.getUserId());
			criteria.put("functionCode", ERPPermissionStatic.CAPITAL_DISTRIBUTION_OF_PROJECT);
		}else if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.CAPITAL_DISTRIBUTION_CHECK_ALL)
				&& !ClientUtil.checkIsHavePermission(ERPPermissionStatic.CAPITAL_DISTRIBUTION_CHECK_PLATE)
				&& ClientUtil.checkIsHavePermission(ERPPermissionStatic.CAPITAL_DISTRIBUTION_CHECK_BY_PROJECT_MANAGER)){
			Map<String, Object> kv = new HashMap<>();
			kv.put("key", "a.project_id is not null");
			kv.put("value", "a.project_id is not null and a.project_id in (SELECT project_id from projects where project_manage_id = "+ClientUtil.getUserId()+")");
			keyvalues.add(kv);
		}
        if(!BaseHelpUtils.isNullOrEmpty(keyvalues)){
        	criteria.put("keyValues", keyvalues);
        }
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new CapitalDistributionOfProjectSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSCapitalDistributionOfProject.getInstance();
	}


}

