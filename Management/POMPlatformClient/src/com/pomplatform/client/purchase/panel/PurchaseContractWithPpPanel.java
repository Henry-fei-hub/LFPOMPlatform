package com.pomplatform.client.purchase.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.NewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.purchase.datasource.DSPurchaseContractWithPp;
import com.pomplatform.client.purchase.form.PurchaseContractWithPpSearchForm;
import com.pomplatform.client.purchase.form.PurchaseContractWithPpViewer;
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

public class PurchaseContractWithPpPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			PurchaseContractWithPpPanel cm = new PurchaseContractWithPpPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "PurchaseContractWithPp";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
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
		IButton operation1Button = new IButton("查看详情");
		controlLayout.addMember(operation1Button);
		operation1Button.setIcon("[SKIN]/actions/view.png");
		operation1Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});

		IButton purchaseActionBtn = new IButton("采购入库");
		controlLayout.addMember(purchaseActionBtn);
		purchaseActionBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (resultGrid.anySelected()) {
					Record selectRecord = resultGrid.getSelectedRecord();
					NewProcessWindow distribution = new NewProcessWindow();
					distribution.setData(selectRecord);
					distribution.setTitle("采购入库");
					distribution.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							// 操作成功
							commonQuery();
						}
					});
					Map<String, String> processIdMap = PomPlatformClientUtil
							.getUserProcessId(PomPlatformClientUtil.PARENT_PROCESS_TYPE_4);
					Integer value = ClientUtil.checkAndGetIntValue(processIdMap.get("Purchase_warehousing_apply"));
					distribution.setProcessId(value);
					distribution.setLayoutMode(0);
					distribution.initComponents();
					distribution.setTitle(KeyValueManager.getValue("employee_processes", String.valueOf(value)));
					distribution.show();
				} else {
					SC.say("请选择一条数据");
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
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("采购合同");
				detail.setWidth100();
				detail.setHeight100();
				PurchaseContractWithPpViewer detailForm = new PurchaseContractWithPpViewer();
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
		criteria.put("addtionalCondition", "order by purchase_contract_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new PurchaseContractWithPpSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSPurchaseContractWithPp.getInstance();
	}

}
