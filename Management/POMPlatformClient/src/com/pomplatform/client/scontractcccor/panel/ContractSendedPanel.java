package com.pomplatform.client.scontractcccor.panel;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractExpansionRelatedPage;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.contractchange.panel.ContractChangeInfoPanel;
import com.pomplatform.client.contractinfo.panel.CustomContractMainPanel;
import com.pomplatform.client.scontractcccor.datasource.DSScontractcccor;
import com.pomplatform.client.scontractcccor.form.ScontractcccorSearchForm;
import com.pomplatform.client.scontractcccor.form.ScontractcccorViewer;
import com.pomplatform.client.subcontractinfo.datasource.DSSubContractInfo;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class ContractSendedPanel extends AbstractExpansionRelatedPage {


	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			ContractSendedPanel cm = new ContractSendedPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Scontractcccor";
		}

	}

	@Override
	public void initComponents() {
		// 行数据是否可编辑
		resultGrid.setCanEdit(false);
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});
		IButton showButton = new IButton("查看详情");
		controlLayout.addMember(showButton);
		showButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] selected = resultGrid.getSelectedRecords();
				if (selected.length < 1) {
					SC.say("请选择一条数据");
					return;
				}
				final ListGridRecord selected1 = resultGrid.getSelectedRecord();
				int parentId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("parentId"));
				if (0 == parentId) {
					parentId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("contractId"));
				}
				String contractName = selected[0].getAttribute("contractName");
				PopupWindow pw = new PopupWindow();
				CustomContractMainPanel panel = new CustomContractMainPanel(parentId, selected1,0,Boolean.TRUE);
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
						SC.say("提示", "操作成功");
					}
				});
				panel.setParentWindow(pw);
				pw.addItem(panel);
				panel.setParentCanvas(pw);
				;
				pw.setTitle("订单(" + contractName + ")管理");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
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
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("Scontractcccor");
				detail.setWidth100();
				detail.setHeight100();
				ScontractcccorViewer detailForm = new ScontractcccorViewer();
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
		criteria.put("addtionalCondition", "order by contract_id desc");
		criteria.put("flowStatus", 4);
		criteria.put("isSystemAdd", true);
		return true;
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new ScontractcccorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSScontractcccor.getInstance();
	}

	@Override
	public DataSource getChildDataSource() {
		return DSSubContractInfo.getInstance();
	}

}
