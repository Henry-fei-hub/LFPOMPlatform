package com.pomplatform.client.reimbursement.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.MapUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.reimbursement.datasource.DSReimbursementpackagemmror;
import com.pomplatform.client.reimbursement.form.ReimbursementpackagemmrorSearchForm;
import com.pomplatform.client.sreimbursementpackagemmror.panel.UpdateReimbursementpackagePanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class ReimbursementpackagemmrorPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			ReimbursementpackagemmrorPanel cm = new ReimbursementpackagemmrorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Reimbursementpackagemmror";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
//		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
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
				showDetail();
			}
		});
		IButton operation1Button = new IButton("查看详情");
		controlLayout.addMember(operation1Button);
		operation1Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		
		IButton createData = new IButton("生成凭证");
		controlLayout.addMember(createData);
		createData.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				final LoadingWindow loading = new LoadingWindow();
				Map<String, Object> params = new HashMap<>();
				params.put("optType", "createVoucher");
				MapUtils.convertRecordToMap(resultGrid.getDataSource(), resultGrid.getSelectedRecords(), params,
						"packageList");
				DBDataSource.callOperation("EP_K3VoucherProcess", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						loading.destroy();
						if (dsResponse.getStatus() < 0) {
							Record[] records = dsResponse.getData();
							if(null != records && records.length > 0) {
								PopupWindow window = new PopupWindow("错误信息");
								window.setWidth100();
								window.setHeight100();
								window.centerInPage();
								CreateVoucherErrorPanel panel = new CreateVoucherErrorPanel();
								panel.initPanel();
								panel.setRecords(records);
								panel.setDataToGrid();
								window.addItem(panel);
								window.show();
							}else {
								ClientUtil.displayErrorMessage(dsResponse);
							}
						} else {
							SC.say("凭证生成成功");
							commonQuery();
						}
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
				ListGridRecord selectRecord = resultGrid.getSelectedRecord();
				boolean isCompleted = selectRecord.getAttributeAsBoolean("isCompleted");
				
				boolean isTopUpdate = false;//顶部的修改标志
				boolean isBottomUpdate = false;//底部的修改标志
				
				PopupWindow pw = new PopupWindow();
				pw.setWidth100();
				pw.setHeight100();
				int packageId = selectRecord.getAttributeAsInt("reimbursementPackageId");
				UpdateReimbursementpackagePanel panel = new UpdateReimbursementpackagePanel(packageId, isTopUpdate, isBottomUpdate, isCompleted, null);
				panel.setPackageId(packageId);
				panel.setFatherWindow(pw);
				panel.startEdit();
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
						SC.say("提示", "操作成功");
					}
				});
				panel.setParentCanvas(pw);
				pw.addItem(panel);
				pw.setTitle("报销单打包详情");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
				
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		//如果没有查询所有的权限 则加入默认角色去进行查询
//		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.RP_VIEW_ALL_DATA)){
//			criteria.put("roleId", ClientUtil.getRoleId());
//		}
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new ReimbursementpackagemmrorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSReimbursementpackagemmror.getInstance();
	}

}
