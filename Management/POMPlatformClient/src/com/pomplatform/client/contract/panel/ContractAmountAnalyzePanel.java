package com.pomplatform.client.contract.panel;

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
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.contract.datasource.DSContractAmountAnalyze;
import com.pomplatform.client.contract.form.ContractAmountAnalyzeSearchForm;
import com.pomplatform.client.contract.form.ContractAmountAnalyzeViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.events.CellDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.CellDoubleClickHandler;

public class ContractAmountAnalyzePanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ContractAmountAnalyzePanel cm = new ContractAmountAnalyzePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ContractAmountAnalyze";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setShowGridSummary(true);
		__needPagenation = false;
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

//		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
//			@Override
//			public void onDoubleClick(DoubleClickEvent event) {
//				showDetail();
//			}
//		});
		
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		
		IButton downloadButton = new IButton("导出");
		downloadButton.addClickHandler(new ClickHandler(){
			@SuppressWarnings("rawtypes")
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_ContractAmountAnalyze", condition);
			}
		});
		controlLayout.addMember(downloadButton);
		
		commonQuery();
		
		resultGrid.addCellDoubleClickHandler(new CellDoubleClickHandler() {
			
			@Override
			public void onCellDoubleClick(CellDoubleClickEvent event) {
				int month = event.getColNum() - 2;
				Record record = event.getRecord();
				String contractYear = record.getAttribute("contractYear");
				String plateId = record.getAttribute("plateId");
				if(BaseHelpUtils.isNullOrEmpty(contractYear) || BaseHelpUtils.isNullOrEmpty(plateId)) {
					SC.say("参数不全");
					return;
				}
				PopupWindow window = new PopupWindow("签约合同报表明细");
				window.setWidth100();
				window.setHeight100();
				ContractAmountAnalyzeDetailPanel panel = new ContractAmountAnalyzeDetailPanel();
				panel.setPlateId(plateId);
				panel.setYear(contractYear);
				if(month >= 1 && month <= 12) {
					panel.setMonth(month);
				}
				panel.commonQuery();
				window.addItem(panel);
				window.centerInPage();
				window.show();
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
				detail.setTitle("合同金额报表"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ContractAmountAnalyzeViewer detailForm = new ContractAmountAnalyzeViewer();
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
		criteria.put("contractSigningStatus", ClientStaticUtils.CONTRACT_SIGNING_STATUS_2);//只查询已签订的合同
		//如果没有查看所有数据权限
		if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.CONTRACT_AMOUNT_ANALYZE_CHECK_ALLDATA)) {
			if(BaseHelpUtils.isNullOrEmpty(criteria.get("plateId"))) {
				//获取自己管理部门的部门id数据集
				String plateIds = PomPlatformClientUtil.getRolePlateId();
				if(!BaseHelpUtils.isNullOrEmpty(plateIds)) {
					List<Map> keyvalues = new ArrayList<>();
					Map<String, String> kv = new HashMap<>();
					kv.put("key", "and b.plate_id = ?");
					kv.put("value", "and b.plate_id in("+plateIds+") and b.plate_id = ?");
					keyvalues.add(kv);
					criteria.put("keyValues", keyvalues);
				}else {
					criteria.put("plateId",-1);
				}
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
		return new ContractAmountAnalyzeSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSContractAmountAnalyze.getInstance();
	}


}

