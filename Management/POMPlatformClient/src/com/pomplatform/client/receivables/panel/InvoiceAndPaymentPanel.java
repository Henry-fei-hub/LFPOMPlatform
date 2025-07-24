package com.pomplatform.client.receivables.panel;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.receivables.datasource.DSInvoiceAndPayment;
import com.pomplatform.client.receivables.form.InvoiceAndPaymentSearchForm;
import com.pomplatform.client.receivables.form.InvoiceAndPaymentViewer;
import com.pomplatform.client.receivables.form.PaybackAndInvoiceForm;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class InvoiceAndPaymentPanel extends AbstractSearchPanel
{
	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			InvoiceAndPaymentPanel cm = new InvoiceAndPaymentPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "InvoiceAndPayment";
		}

	}

	@Override
	public void init(){
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
				PopupWindow pWindow = new PopupWindow();
				pWindow.setTitle("回款与发票");
				pWindow.setWidth("80%");
				pWindow.setHeight("80%");
				pWindow.centerInPage();
				PaybackAndInvoiceForm vLaout = new PaybackAndInvoiceForm();
				Record record = resultGrid.getSelectedRecord();
				if (!BaseHelpUtils.isNullOrEmpty(record)) {
					vLaout.initComponents(record.toMap());
				}
				pWindow.addItem(vLaout);
				pWindow.show();
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

		//发票关联回款的按钮
		IButton paybackButton = new IButton("发票对应回款");
		paybackButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				PopupWindow pWindow = new PopupWindow();
				pWindow.setTitle("回款与发票");
				pWindow.setWidth("80%");
				pWindow.setHeight("80%");
				pWindow.centerInPage();
				PaybackAndInvoiceForm vLaout = new PaybackAndInvoiceForm();
				Record record = resultGrid.getSelectedRecord();
				if (!BaseHelpUtils.isNullOrEmpty(record)) {
					vLaout.initComponents(record.toMap());
				}
				pWindow.addItem(vLaout);
				pWindow.show();
			}
		});
		controlLayout.addMember(paybackButton);
		commonQuery();
		//设置行号
		resultGrid.setShowRowNumbers(true);
		//设置为可选的
//		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		resultGrid.setShowGridSummary(true);
//		resultGrid.setCanSelectText(true);
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
				detail.setTitle("发票与回款"); 
				detail.setWidth("80%");
				detail.setHeight("80%");
				InvoiceAndPaymentViewer detailForm = new InvoiceAndPaymentViewer();
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
		int val = BaseHelpUtils.getIntValue(criteria.get("isHasContract"));
		if (val==1) {
			List<Map> keyvalues = new ArrayList<>();
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "C.contract_id =?");
			kv.put("value", "(C.contract_id is null or C.contract_id= ? )");
			keyvalues.add(kv);
			criteria.put("contractId", 0);
			criteria.put("keyValues", keyvalues);
		} else if (val==2) {
			List<Map> keyvalues = new ArrayList<>();
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "C.contract_id =?");
			kv.put("value", "C.contract_id> ?");
			criteria.put("contractId", 0);
			keyvalues.add(kv);
			criteria.put("keyValues", keyvalues);
		}
		criteria.put("addtionalCondition", "order by capital_id");
		return true;
	}



	@Override
	public Canvas generateHDataCanvas() {
		resultGrid = new DelicacyListGrid() {
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				SC.debugger();
				if (null != record.getAttribute("isHavingInvoice") && record.getAttributeAsInt("isHavingInvoice") == 1) {
					return "color: green;";
				} else {
					return super.getCellCSSText(record, rowNum, colNum);
				}
			}
		};
		resultGrid.setDataSource(getDataSource());
		resultGrid.setWidth100();
		resultGrid.setHeight100();
		return resultGrid;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new InvoiceAndPaymentSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSInvoiceAndPayment.getInstance();
	}


}

