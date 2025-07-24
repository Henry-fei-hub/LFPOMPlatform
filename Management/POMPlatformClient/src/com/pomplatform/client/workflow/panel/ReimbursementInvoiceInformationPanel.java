package com.pomplatform.client.workflow.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.workflow.commonNormalReimbursement.form.AddReimbursementInvoicePanel;
import com.pomplatform.client.workflow.datasource.DSReimbursementInvoiceInformation;
import com.pomplatform.client.workflow.form.ReimbursementInvoiceInformationViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class ReimbursementInvoiceInformationPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			ReimbursementInvoiceInformationPanel cm = new ReimbursementInvoiceInformationPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ReimbursementInvoiceInformation";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needPagenation = false;
	}

	@Override
	public void initComponents() {
		ListGridField [] fields = new ListGridField[8];
		int index = 0;
		fields[index] = new ListGridField("invoiceType");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("subtractRemark");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("totalAmount");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("subtractAmount");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("taxRate");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("taxAmount");
		fields[index].setShowGridSummary(true);
		index ++;
		fields[index] = new ListGridField("invoiceNumber");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("invoiceQuantity");
		fields[index].setShowGridSummary(false);
		
		resultGrid.setShowGridSummary(true);
		resultGrid.setFields(fields);
		resultGrid.setHeaderHeight(60);
		resultGrid.setHeaderSpans(new HeaderSpan[] { new HeaderSpan( "发票信息(进项税与电子发票)",
				new String[] { "invoiceType", "subtractRemark", "totalAmount", "subtractAmount", "taxRate", "taxAmount",
						"invoiceNumber", "invoiceQuantity"}) });
		
		
//		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
//			@Override
//			public void onDoubleClick(DoubleClickEvent event) {
//				showDetail();
//			}
//		});
//		IButton operation1Button = new IButton("查看详情");
//		controlLayout.addMember(operation1Button);
//		operation1Button.setIcon("[SKIN]/actions/view.png");
//		operation1Button.addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent event) {
//				showDetail();
//			}
//		});
		IButton operation3Button = new IButton("新建");
		controlLayout.addMember(operation3Button);
		operation3Button.setIcon("[SKIN]/actions/add.png");
		operation3Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}

					@Override
					public void onSuccess() {
						PopupWindow window = new PopupWindow();
						window.setWidth("30%");
						window.setHeight("80%");
						window.centerInPage();
						window.setTitle("新增发票信息");
						AddReimbursementInvoicePanel panel = new AddReimbursementInvoicePanel();
						panel.setParentWindow(window);
						panel.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								Record record = event.getData();
								RecordList list = resultGrid.getDataAsRecordList();
								list.add(record);
								resultGrid.setData(list);
								resultGrid.redraw();
							}
						});
						window.addItem(panel);
						window.show();
					}
				});
			}
		});
		
		IButton operation2Button = new IButton("修改");
		controlLayout.addMember(operation2Button);
		operation2Button.setIcon("[SKIN]/actions/edit.png");
		operation2Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}

					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("请选择一条数据修改");
							return;
						}
						final ListGridRecord selected1 = resultGrid.getSelectedRecord();
						PopupWindow window = new PopupWindow();
						window.setWidth("30%");
						window.setHeight("80%");
						window.centerInPage();
						window.setTitle("修改发票信息");
						AddReimbursementInvoicePanel panel = new AddReimbursementInvoicePanel();
						panel.startEdit(selected1);
						panel.setParentWindow(window);
						panel.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								DBDataSource.copyRecord(event.getData(), selected1);
								resultGrid.recalculateGridSummary();
								resultGrid.redraw();
							}
						});
						window.addItem(panel);
						window.show();
					}
				});
			}
		});
		
		IButton removeButton = new IButton("删除");
		controlLayout.addMember(removeButton);
		removeButton.setIcon("[SKIN]/actions/remove.png");
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据进行删除");
				}
				ListGridRecord selected = resultGrid.getSelectedRecord();
				int indexNum = resultGrid.getRowNum(selected);
				resultGrid.removeData(selected);
				resultGrid.selectSingleRecord(indexNum);
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
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("报销发票信息表");
				detail.setWidth100();
				detail.setHeight100();
				ReimbursementInvoiceInformationViewer detailForm = new ReimbursementInvoiceInformationViewer();
				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
				detailForm.initComponents();
				detailForm.viewSelectedData(resultGrid);
				detail.setContent(detailForm);
				detail.centerInPage();
				detail.show();
			}
		});
	}

	public void setValues(Record [] records) {
		resultGrid.setData(records);
	}
	
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by reimbursement_invoice_information_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSReimbursementInvoiceInformation.getInstance();
	}

	public Record[] getValues(){
		return resultGrid.getRecords();
	}
	
}
