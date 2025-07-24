package com.pomplatform.client.contract.panel;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.contract.datasource.DSContractCommissionDetail;
import com.pomplatform.client.contract.form.ContractCommissionDetailSearchForm;
import com.pomplatform.client.contract.form.ContractCommissionDetailViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ContractCommissionDetailPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ContractCommissionDetailPanel cm = new ContractCommissionDetailPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ContractCommissionDetail";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {

		ListGridField[] fields = new ListGridField[9];
		int idx = 0;
		fields[idx] = new ListGridField("contractCode");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("contractName");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("plateId");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("year");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("month");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("rate");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("amount");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("isOriginal");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("isSubProject");
		fields[idx].setShowGridSummary(false);

		resultGrid.setDataSource(DSContractCommissionDetail.getInstance());
		resultGrid.setFields(fields);
		resultGrid.setCanEdit(false);
		resultGrid.setAutoFitFieldWidths(true);
		resultGrid.setShowGridSummary(true);

		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
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
				detail.setTitle("ContractCommissionDetail"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ContractCommissionDetailViewer detailForm = new ContractCommissionDetailViewer();
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
		if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.SHOW_CONTRACT_DISTRIBUTION_ALL_DATA)){
			String plateIds = PomPlatformClientUtil.getRolePlateId();
			if (BaseHelpUtils.isNullOrEmpty(plateIds)){
				criteria.put("plateId", -1);
			}else {
				List<Map> keyvalues = new ArrayList<>();
				Map<String , String> kv = new HashMap<>();
				kv.put("key" , "cc.plate_id =?");
				kv.put("value" , "cc.plate_id in ("+ plateIds +")");
				keyvalues.add(kv);
				criteria.put("keyValues" , keyvalues);
			}
		}
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ContractCommissionDetailSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSContractCommissionDetail.getInstance();
	}


}

