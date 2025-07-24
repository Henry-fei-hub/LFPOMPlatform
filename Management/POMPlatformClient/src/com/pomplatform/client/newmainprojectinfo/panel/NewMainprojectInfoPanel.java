package com.pomplatform.client.newmainprojectinfo.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.mainprojectinfo.panel.MmainprojectclientccmorPanel;
import com.pomplatform.client.newcontract.form.NewNewContractForm;
import com.pomplatform.client.newmainprojectinfo.datasource.DSNewMainprojectInfo;
import com.pomplatform.client.newmainprojectinfo.form.NewMainprojectInfoSearchForm;
import com.pomplatform.client.newmainprojectinfo.form.NewMainprojectInfoViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class NewMainprojectInfoPanel extends AbstractSearchPanel {

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			NewMainprojectInfoPanel cm = new NewMainprojectInfoPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "NewMainprojectInfo";
		}

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
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		IButton operation3Button = PermissionControl.createPermissionButton("查看联系人",
				ERPPermissionStatic.PROJECT_INFO_VIEW_LINKMAN_BUTTON);
		controlLayout.addMember(operation3Button);
		operation3Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] selected = resultGrid.getSelectedRecords();
				String mainProjectId = selected[0].getAttribute("mainProjectId");
				PopupWindow pw = new PopupWindow("联系人");
				MmainprojectclientccmorPanel panel = new MmainprojectclientccmorPanel();
				panel.setMainProjectId(ClientUtil.checkAndGetIntValue(mainProjectId));
				pw.addItem(panel.getViewPanel());
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
				panel.commonQuery();
			}
		});
		Logger logger = Logger.getLogger("");
		IButton operation4Button = PermissionControl.createPermissionButton("创建主合同",
				ERPPermissionStatic.PROJECT_INFO_ADD_CONTRACTS_BUTTON);
		controlLayout.addMember(operation4Button);
		operation4Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}

					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("请选择一条数据创建主订单");
							return;
						}
						final ListGridRecord[] selected = resultGrid.getSelectedRecords();
						String message = "{\"projectCode\":\"" + selected[0].getAttribute("projectCode") + "\"}";
						DBDataSource.callOperation("EP_HasDesignConsiderationHistory", message, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if (dsResponse.getStatus() < 0) {
									SC.say("该项目尚未拥有报价单，暂无法创建主合同");
									return;
								}else{
									Map<String, Object> map = new HashMap<>();
									map.put("projectCode", selected[0].getAttribute("projectCode"));
									map.put("projectName", selected[0].getAttribute("projectName"));
									map.put("signCompany", selected[0].getAttribute("signCompany"));
									map.put("totalMoney", selected[0].getAttribute("totalMoney"));
									map.put("coveredArea", selected[0].getAttribute("coveredArea"));
									map.put("designArea", selected[0].getAttribute("designArea"));
									map.put("customerName", selected[0].getAttribute("customerName"));
									map.put("projectLevel", selected[0].getAttribute("projectLevel"));
									map.put("address", selected[0].getAttribute("address"));
									map.put("serviceSuggestBook", selected[0].getAttribute("serviceSuggestBook"));
									NewNewContractForm contractForm = new NewNewContractForm();
									contractForm.setTitle("创建主合同");
									contractForm.setMap(map);
									contractForm.initComponents();
									contractForm.startEdit();
									contractForm.setWidth100();
									contractForm.setHeight100();
									contractForm.centerInPage();
									contractForm.show();
								}
							}
						});
					}
				});
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
				detail.setTitle("项目信息");
				detail.setWidth100();
				detail.setHeight100();
				NewMainprojectInfoViewer detailForm = new NewMainprojectInfoViewer();
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
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new NewMainprojectInfoSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSNewMainprojectInfo.getInstance();
	}

}
