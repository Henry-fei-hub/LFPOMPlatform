package com.pomplatform.client.mfinancialaccounting.panel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.mfinancialaccounting.datasource.DSMfinancialAccounting;
import com.pomplatform.client.mfinancialaccounting.form.MfinancialAccountingSearchForm;
import com.pomplatform.client.mfinancialaccounting.form.MfinancialAccountingViewer;
import com.pomplatform.client.sreimbursementpackagemmror.panel.UpdateReimbursementpackagePanel;
import com.pomplatform.client.workflow.panel.ProcessInputTaxAmountPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class MfinancialAccountingPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			MfinancialAccountingPanel cm = new MfinancialAccountingPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "MfinancialAccounting";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		resultGrid.setShowRowNumbers(true);
		resultGrid.setSelectionType(SelectionStyle.SIMPLE);
		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
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
		
		IButton operation1Button = PermissionControl.createPermissionButton("查看详情", ERPPermissionStatic.FA_VIEW);
		controlLayout.addMember(operation1Button);
		operation1Button.setIcon("[SKIN]/actions/view.png");
		operation1Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		
		IButton updateDateBtn = PermissionControl.createPermissionButton("修改入库日期", ERPPermissionStatic.FA_UPDATE_DATE);
		controlLayout.addMember(updateDateBtn);
		updateDateBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (resultGrid.anySelected()) {
					PopupWindow pw = new PopupWindow();
					pw.setWidth100();
					pw.setHeight100();
					UpdateFinancialAccountingPanel panel = new UpdateFinancialAccountingPanel();
					panel.startEdit(resultGrid.getSelectedRecord());
					panel.setParentWindow(pw);
					panel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							Record record = event.getData();
							Map params = record.toMap();
							params.put("records", resultGrid.getSelectedRecords());
							params.put("opt_type", "financialAccountingDate");
							DBDataSource.callOperation("EP_CustomMfinancialAccountingProcess", params,
									new DSCallback() {

										@Override
										public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
											if (dsResponse.getStatus() > 0) {
												ListGridRecord[] selectRecords = resultGrid.getSelectedRecords();
												List<Integer> rowList = new ArrayList<>();
												for (int i = 0; i < selectRecords.length; i++) {
													rowList.add(resultGrid.getRowNum(selectRecords[i]));
												}
												RecordList list = resultGrid.getRecordList();
												RecordList newList = new RecordList();
												for (int i = 0; i < list.getLength(); i++) {
													Record __record = list.get(i);
													if (rowList.contains(i)) {
														__record.setAttribute("voucherNo",
																record.getAttribute("voucherNo"));
														__record.setAttribute("postingDate",
																record.getAttributeAsDate("postingDate"));
													}
													newList.add(__record);
												}
												resultGrid.setData(newList);
												resultGrid.redraw();
												resultGrid.selectRecords(selectRecords);
												;
												SC.say("提示", "操作成功");
											} else {
												ClientUtil.displayErrorMessage(dsResponse);
											}
										}
									});

						}
					});
					panel.setParentCanvas(pw);
					panel.setParentWindow(pw);
					pw.addItem(panel);
					pw.setTitle("修改入库日期");
					pw.setWidth(450);
					pw.setHeight(480);
					pw.centerInPage();
					pw.show();
				} else {
					SC.say("请选择至少一条报销单信息");
				}

			}
		});
		
		IButton exportBtn = PermissionControl.createPermissionButton("导出", ERPPermissionStatic.FA_EXPORT);
		controlLayout.addMember(exportBtn);
		exportBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_MfinancialAccounting", condition);
			}
		});
		
		IButton addInoviceBtn = new IButton("录入进项税发票");
		controlLayout.addMember(addInoviceBtn);
		addInoviceBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					Record selectRecord = resultGrid.getSelectedRecord();
					PopupWindow window = new PopupWindow();
					window.setWidth("90%");
					window.setHeight("90%");
					window.centerInPage();
					window.setTitle("录入进项发票");
					ProcessInputTaxAmountPanel panel = new ProcessInputTaxAmountPanel();
					panel.setProcessType(selectRecord.getAttributeAsInt("processType"));
					panel.setCode(selectRecord.getAttribute("code"));
					panel.setCompanyId(selectRecord.getAttributeAsInt("companyId"));
					panel.setBusinessId(selectRecord.getAttributeAsInt("businessId"));
					panel.startEdit();
					panel.setFatherWindow(window);
					panel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
						}
					});
					window.addItem(panel);
					window.show();
				}else{
					SC.say("请选择一条数据进行查看");
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
				ListGridRecord selected = resultGrid.getSelectedRecord();
				Map params = selected.toMap();
				params.put("opt_type", "getSystemInstanceData");
				DBDataSource.callOperation("EP_CollectionDistribution", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() > 0){
							Record __record = dsResponse.getData()[0];
							ViewProcessWindow Reimbursement = new ViewProcessWindow();
			                Reimbursement.setWidth("80%");
			                Reimbursement.setHeight("80%");
			                Reimbursement.setLayoutMode(0);
			                Reimbursement.setInstanceData(__record);
			                Reimbursement.initComponents();
			                Reimbursement.setTitle(ClientUtil.getProcessTypeName(__record));
			                Reimbursement.show();
						} else {
							ClientUtil.displayErrorMessage(dsResponse);
						}
						
					}
				});
				
//				if (!resultGrid.anySelected()) {
//					SC.say("请选择一条数据");
//					return;
//				}
//				ListGridRecord selectRecord = resultGrid.getSelectedRecord();
//				
//				PopupWindow pw = new PopupWindow();
//				pw.setWidth100();
//				pw.setHeight100();
//				ViewDetailFinancialAccountingPanel panel = new ViewDetailFinancialAccountingPanel(selectRecord);
//				panel.setFatherWindow(pw);
//				panel.startEdit();
//				panel.addDataEditedHandler(new DataEditedHandler() {
//					@Override
//					public void onDataEdited(DataEditEvent event) {
//						commonQuery();
//						SC.say("提示", "操作成功");
//					}
//				});
//				panel.setParentCanvas(pw);
//				pw.addItem(panel);
//				pw.setTitle("报销单详情");
//				pw.setWidth100();
//				pw.setHeight100();
//				pw.centerInPage();
//				pw.show();
			}
		});
	}

	@Override
	public int getSearchFormHeight() {
		return 185;
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by process_instance_id");
		criteria.put("processStatus", 3);
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new MfinancialAccountingSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSMfinancialAccounting.getInstance();
	}

}
