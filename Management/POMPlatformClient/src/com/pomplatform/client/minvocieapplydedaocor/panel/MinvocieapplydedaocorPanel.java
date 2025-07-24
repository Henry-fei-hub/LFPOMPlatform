package com.pomplatform.client.minvocieapplydedaocor.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.smartgwt.client.types.SelectionStyle;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.minvocieapplydedaocor.datasource.DSMinvocieapplydedaocor;
import com.pomplatform.client.minvocieapplydedaocor.form.MinvocieapplydedaocorSearchForm;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.Map;
import java.util.logging.Logger;

public class MinvocieapplydedaocorPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	//invoice_apply_status申请状态  1:已申请 2：已处理 3：已驳回
	private static final int INVOICE_APPLY_STATUS_ONE = 1;
	private static final int INVOICE_APPLY_STATUS_TWO = 2;
	private static final int INVOICE_APPLY_STATUS_THREE = 3;

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			MinvocieapplydedaocorPanel cm = new MinvocieapplydedaocorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Minvocieapplydedaocor";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		resultGrid.setSelectionType(SelectionStyle.SINGLE);
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
		// IButton operation1Button = new IButton("查看详情");
		// controlLayout.addMember(operation1Button);
		// operation1Button.setIcon("[SKIN]/actions/view.png");
		// operation1Button.addClickHandler(new ClickHandler(){
		// @Override
		// public void onClick(ClickEvent event) {
		// showDetail();
		// }
		// });
		IButton addButton = PermissionControl.createPermissionButton("新增申请", ERPPermissionStatic.ADD_APPLY_INVOICES_BTN);
		controlLayout.addMember(addButton);
		addButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				PopupWindow pw = new PopupWindow();
				AddMinvocieapplydedaocorPanel panel = new AddMinvocieapplydedaocorPanel();
				panel.startEdit();
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
						SC.say("提示", "操作成功");
					}
				});
				panel.setParentCanvas(pw);
				panel.setFatherWindow(pw);
				pw.addItem(panel);
				pw.setTitle("申请发票");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});

		IButton updateButton = PermissionControl.createPermissionButton("修改申请", ERPPermissionStatic.UPDATE_APPLY_INVOICES_BTN);
		controlLayout.addMember(updateButton);
		updateButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (resultGrid.anySelected()) {
					
					int invoiceApplyStatus = resultGrid.getSelectedRecord().getAttributeAsInt("invoiceApplyStatus");
					if(INVOICE_APPLY_STATUS_ONE == invoiceApplyStatus){
						PopupWindow pw = new PopupWindow();
						UpdateMinvocieapplydedaocorPanel panel = new UpdateMinvocieapplydedaocorPanel(
								resultGrid.getSelectedRecord(), true);
						// panel.startEdit();
						panel.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
								SC.say("提示", "操作成功");
							}
						});
						panel.setParentCanvas(pw);
						panel.setFatherWindow(pw);
						pw.addItem(panel);
						pw.setTitle("修改申请发票");
						pw.setWidth100();
						pw.setHeight100();
						pw.centerInPage();
						pw.show();
					} else {
						SC.say("该申请已被处理，不可修改");
					}
					
				} else {
					SC.say("请选择一条修改数据");
				}

			}
		});

		IButton detailButton = new IButton("查看详情");
		controlLayout.addMember(detailButton);
		detailButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});

		IButton refuseUseInvoiceBtn = PermissionControl.createPermissionButton("驳回申请", ERPPermissionStatic.REJECT_APPLY_INVOICES_BTN);
		controlLayout.addMember(refuseUseInvoiceBtn);
		refuseUseInvoiceBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (resultGrid.anySelected()) {
					ListGridRecord record = resultGrid.getSelectedRecord();
					
					int invoiceApplyStatus = record.getAttributeAsInt("invoiceApplyStatus");
					if(INVOICE_APPLY_STATUS_ONE == invoiceApplyStatus){
						
						
						PopupWindow pw = new PopupWindow();
						RejectInvoiceApplyPanel panel = new RejectInvoiceApplyPanel(record);
						panel.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
								SC.say("提示", "操作成功");
							}
						});
						panel.setParentCanvas(pw);
						panel.setFatherWindow(pw);
						pw.addItem(panel);
						pw.setTitle("驳回申请发票");
						pw.setWidth("70%");
						pw.setHeight("60%");
						pw.centerInPage();
						pw.show();
					}else{
						SC.say("该条数据已经进行处理, 不可进行驳回操作");
					}
				} else {
					SC.say("请选择一条数据");
				}

			}
		});
		IButton exportBtn = new IButton("导出");
		controlLayout.addMember(exportBtn);
		exportBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_Minvocieapplydedaocor", condition);
				
			}
		});
		commonQuery();
	}

	public void showDetail() {
		if (resultGrid.anySelected()) {
			PopupWindow pw = new PopupWindow();
			UpdateMinvocieapplydedaocorPanel panel = new UpdateMinvocieapplydedaocorPanel(
					resultGrid.getSelectedRecord(), false);
			// panel.startEdit();
			panel.addDataEditedHandler(new DataEditedHandler() {
				@Override
				public void onDataEdited(DataEditEvent event) {
					commonQuery();
					SC.say("提示", "操作成功");
				}
			});
			panel.setParentCanvas(pw);
			panel.setFatherWindow(pw);
			pw.addItem(panel);
			pw.setTitle("修改申请发票");
			pw.setWidth100();
			pw.setHeight100();
			pw.centerInPage();
			pw.show();
		} else {
			SC.say("请选择一条修改数据");
		}
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by invoice_apply_id");
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.VIEW_APPLY_INVOICES_ALL_DATA)){
			criteria.put("applicantId", ClientUtil.getEmployeeId());
		}
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		MinvocieapplydedaocorSearchForm form = new MinvocieapplydedaocorSearchForm();
		if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.VIEW_APPLY_INVOICES_ALL_DATA)){
			form.getField("applicantId").setHidden(false);
		} else {
			form.getField("applicantId").setHidden(true);
		}
		return form;
	}

	@Override
	public DataSource getDataSource() {
		return DSMinvocieapplydedaocor.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 145;
	}
	
}
