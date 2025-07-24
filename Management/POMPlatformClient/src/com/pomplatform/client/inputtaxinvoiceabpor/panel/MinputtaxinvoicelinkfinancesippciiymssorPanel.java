package com.pomplatform.client.inputtaxinvoiceabpor.panel;

import java.util.Date;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedHandler;
import java.util.Objects;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.inputtaxinvoiceabpor.datasource.DSMinputtaxinvoicelinkfinancesippciiymssor;
import com.pomplatform.client.inputtaxinvoiceabpor.form.MinputtaxinvoicelinkfinancesippciiymssorSearchForm;
import com.pomplatform.client.inputtaxinvoiceabpor.form.MinputtaxinvoicelinkfinancesippciiymssorViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class MinputtaxinvoicelinkfinancesippciiymssorPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			MinputtaxinvoicelinkfinancesippciiymssorPanel cm = new MinputtaxinvoicelinkfinancesippciiymssorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Minputtaxinvoicelinkfinancesippciiymssor";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public Canvas generateHDataCanvas() {
		resultGrid = new DelicacyListGrid() {
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				if (record.getAttributeAsBoolean("isComplete")) {
					return "color: red;";
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
	public void initComponents() {
		ListGridField[] fields = new ListGridField[10];
		int index = 0;
		fields[index] = new ListGridField("invoiceCode");
		index++;
		fields[index] = new ListGridField("invoiceNumber");
		index++;
		fields[index] = new ListGridField("invoiceDate");
		index++;
		fields[index] = new ListGridField("invoiceAmount");
		index++;
		fields[index] = new ListGridField("taxAmount");
		index++;
		fields[index] = new ListGridField("rcode");
		index++;
		fields[index] = new ListGridField("companyId");
		index++;
		fields[index] = new ListGridField("taxAmountCl");
		index++;
		fields[index] = new ListGridField("isComplete");
		resultGrid.setFields(fields);
		resultGrid.setHeaderHeight(60);
		resultGrid
				.setHeaderSpans(new HeaderSpan[] {
						new HeaderSpan("税务系统",
								new String[] { "invoiceCode", "invoiceNumber", "invoiceDate", "invoiceAmount",
										"taxAmount" }),
						new HeaderSpan("ERP系统",
								new String[] { "companyId", "rcode", "plateId", "taxAmountCl", "isComplete" }) });
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
				detail.setTitle("Minputtaxinvoicelinkfinancesippciiymssor");
				detail.setWidth100();
				detail.setHeight100();
				MinputtaxinvoicelinkfinancesippciiymssorViewer detailForm = new MinputtaxinvoicelinkfinancesippciiymssorViewer();
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
		criteria.put("addtionalCondition", "order by input_tax_invoice_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new MinputtaxinvoicelinkfinancesippciiymssorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSMinputtaxinvoicelinkfinancesippciiymssor.getInstance();
	}

}
