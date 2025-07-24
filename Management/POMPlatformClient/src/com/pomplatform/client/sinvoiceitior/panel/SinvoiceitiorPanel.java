package com.pomplatform.client.sinvoiceitior.panel;

import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.sinvoiceitior.datasource.DSSinvoiceitior;
import com.pomplatform.client.sinvoiceitior.form.SinvoiceitiorSearchForm;
import com.pomplatform.client.sinvoiceitior.form.SinvoiceitiorViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class SinvoiceitiorPanel extends AbstractSearchPanel
{


	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			SinvoiceitiorPanel cm = new SinvoiceitiorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Sinvoiceitior";
		}

	}

	@Override
	public void initComponents() {
		int idx = 0;
		ListGridField [] fields = new ListGridField[4];
		fields[idx] = new ListGridField("invoiceType",100);
		idx++ ;
		fields[idx] = new ListGridField("invoiceCode",100);
		idx++ ;
		fields[idx] = new ListGridField("invoiceNumber",100);
		idx++ ;
		fields[idx] = new ListGridField("ticketingCompany",150);
		resultGrid.setFields(fields);
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

		IButton operation1Button = new IButton("查看详情");
//		controlLayout.addMember(operation1Button);
		operation1Button.setIcon("[SKIN]/actions/view.png");
		operation1Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		IButton removeButton = new IButton("删除");
//		controlLayout.addMember(removeButton);
		removeButton.setIcon("[SKIN]/actions/remove.png");
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("Please select a data to remove.");
				}
				final ListGridRecord selected = resultGrid.getSelectedRecord();
				DBDataSource.callOperation("ST_Sinvoiceitior", "delete", selected.toMap(), new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							int indexNum = resultGrid.getRowNum(selected);
							resultGrid.removeData(selected);
							resultGrid.selectSingleRecord(indexNum);
						}
					}
				});
			}
		});
		
		IButton addInvoiceBtn = new IButton("发票入库");
		controlLayout.addMember(addInvoiceBtn);
		addInvoiceBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow pw = new PopupWindow();
				AddSinvoiceitiorPanel panel = new AddSinvoiceitiorPanel();
				panel.addDataEditedHandler(new DataEditedHandler() {
                	@Override
                	public void onDataEdited(DataEditEvent event) {
                		commonQuery();
                		SC.say("提示","发票入库成功");
                	}
                });
				panel.setParentCanvas(pw);
                panel.setFatherWindow(pw);
                pw.addItem(panel);
                pw.setTitle("发票入库");
                pw.setWidth("80%");
                pw.setHeight("80%");
                pw.centerInPage();
                pw.show();
			}
		});
		
		IButton destoryInvoiceBtn = new IButton("空白作废");
		controlLayout.addMember(destoryInvoiceBtn);
		destoryInvoiceBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){
					SC.say("请选择要作废的空白发票!");
					return;
				}
				final ListGridRecord[] records = resultGrid.getSelectedRecords();
				int index = 0;
				String ids = "";
				for (ListGridRecord listGridRecord : records) {
					if(0 == index){
						ids = listGridRecord.getAttributeAsString("invoiceId");
					}else{
						ids = ids +"," + listGridRecord.getAttributeAsString("invoiceId");
					}
					index++;
				}
				if(BaseHelpUtils.isNullOrEmpty(ids)){
					SC.say("数据错误, 请联系开发人员!");
					return;
				}
				PopupWindow pw = new PopupWindow();
				DestoryEmptySinvoiceitiorPanel panel = new DestoryEmptySinvoiceitiorPanel();
				panel.addDataEditedHandler(new DataEditedHandler() {
                	@Override
                	public void onDataEdited(DataEditEvent event) {
                		commonQuery();
                		SC.say("提示","操作成功");
                	}
                });
				panel.setParentCanvas(pw);
                panel.setFatherWindow(pw);
                panel.setInvoiceIds(ids);
                panel.setRemoveCount(index);
                panel.startEdit();
                pw.addItem(panel);
                
                pw.setTitle("发票作废("+ index + "张)");
                pw.setWidth("80%");
                pw.setHeight("80%");
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("Sinvoiceitior"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				SinvoiceitiorViewer detailForm = new SinvoiceitiorViewer();
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
		criteria.put("addtionalCondition", "order by invoice_id");
		criteria.put("sign", 0);//未使用的发票
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new SinvoiceitiorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSSinvoiceitior.getInstance();
	}


}

