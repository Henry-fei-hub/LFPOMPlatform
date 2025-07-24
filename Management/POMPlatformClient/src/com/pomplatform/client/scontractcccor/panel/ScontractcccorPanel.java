package com.pomplatform.client.scontractcccor.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.storage.client.Storage;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.contractinfo.panel.CustomAddSubContractMainTwoPanel;
import com.pomplatform.client.contractinfo.panel.CustomContractMainPanel;
import com.pomplatform.client.data.RoleDefinition;
import com.pomplatform.client.scontractcccor.datasource.DSScontractcccor;
import com.pomplatform.client.scontractcccor.form.ScontractcccorSearchForm;
import com.pomplatform.client.scontractcccor.form.ScontractcccorViewer;
import com.pomplatform.client.subcontractinfo.datasource.DSSubContractInfo;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class ScontractcccorPanel extends AbstractExpansionRelatedPage {

	private static int flowStatus = 0;
	
	//查看详情页 是否只显示不操作
	private static boolean isShow = true;
	private static Map<String,String> map = new HashMap<>();

	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			ScontractcccorPanel cm = new ScontractcccorPanel();
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
		RoleDefinition.getValueMapFromQuery(0, map);
		// 行数据是否可编辑
		resultGrid.setCanEdit(false);
		// resultChildGrid.setCanEdit(false);
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});
		// 根据主合同的流程状态设置查询主合同信息
		String showButtonTitle = "";
		switch (flowStatus) {
		case 0:
			showButtonTitle = "查看详情";
			break;
		case 1:
			showButtonTitle = "承接部门";
			break;
		case 2:
			showButtonTitle = "运营价格";
			break;
		case 3:
			showButtonTitle = "价格审核";
			break;
		default:
			break;
		}
		IButton showButton = PermissionControl.createPermissionButton(showButtonTitle,
				ERPPermissionStatic.CONTRACT_INFO_SELECT_CONTRACTS_BUTTON);
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
				CustomContractMainPanel panel = new CustomContractMainPanel(parentId, selected1, flowStatus, isShow);
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
				pw.setTitle("订单(" + contractName + ")管理");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});

		IButton newChildButton = PermissionControl.createPermissionButton("新增子订单",
				ERPPermissionStatic.CONTRACT_INFO_ADD_CONTRACTS_BUTTON);
		// 只有主合同最开始才有添加子合同选项
		if (flowStatus == 0) {
			controlLayout.addMember(newChildButton);
		}
		newChildButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] selected = resultGrid.getSelectedRecords();
				if (selected.length < 1) {
					SC.say("请选择一条数据");
					return;
				}
				ListGridRecord currentNode = resultGrid.getSelectedRecord();
				if (0 != BaseHelpUtils.getIntValue(currentNode.getAttribute("parentId"))) {
					SC.say("Please select a item as parent.");
					return;
				}


//				int contractId = ClientUtil.checkAndGetIntValue(currentNode.getAttribute("contractId"));
//				String contractName = currentNode.getAttribute("contractName");
//				int flowStatus = currentNode.getAttributeAsInt("flowStatus");
//				PopupWindow pw = new PopupWindow();
//				CustomAddSubContractMainTwoPanel panel = new CustomAddSubContractMainTwoPanel(contractId, currentNode,
//						flowStatus,map);
//				panel.addDataEditedHandler(new DataEditedHandler() {
//					@Override
//					public void onDataEdited(DataEditEvent event) {
//						commonQuery();
//						SC.say("提示", "操作成功");
//					}
//				});
//				pw.addItem(panel);
////				panel.addChildManageContract(contractId);
//				panel.setParentCanvas(pw);
//				panel.setParentWindow(pw);
//				pw.setTitle("订单(" + contractName + ")管理");
//				pw.setWidth100();
//				pw.setHeight100();
//				pw.centerInPage();
//				pw.show();
				//
				//获取流程process_id
				String processId = "";
				Storage sta = Storage.getLocalStorageIfSupported();
				String str = sta.getItem(PomPlatformClientUtil.PROCESS_ID_COOKIE);
				if (!PomPlatformClientUtil.isNullOrEmpty(str)) {
					String[] arr = str.split(",");
					for (String tempStr : arr) {
						String[] tempArr = tempStr.split(":");
						//获取父级ID
						if (tempArr[0].replaceAll("\"", "").equals("Order_Placement")) {
							processId = tempArr[1];
						}
					}
				}

				/** CustomAddSubContractMainTwoStartPanel
				 * 新建流程页面
				 */
				NewProcessWindow window = new NewProcessWindow();
				window.setProcessId(ClientUtil.checkAndGetIntValue(processId));
				window.addDataEditedHandler(new DataEditedHandler(){
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				window.setData(currentNode);
				window.initComponents();
				window.setWidth100();
				window.setHeight100();
				window.show();
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
		criteria.put("flowStatus", flowStatus);
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
