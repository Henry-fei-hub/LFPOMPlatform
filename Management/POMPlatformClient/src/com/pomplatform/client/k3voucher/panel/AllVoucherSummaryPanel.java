package com.pomplatform.client.k3voucher.panel;

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
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.k3voucher.datasource.DSAllVoucherSummary;
import com.pomplatform.client.k3voucher.form.AllVoucherSummarySearchForm;
import com.pomplatform.client.k3voucher.form.AllVoucherSummaryViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class AllVoucherSummaryPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	private CustomAllVoucherDetailPanel detailPanel;
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			AllVoucherSummaryPanel cm = new AllVoucherSummaryPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "AllVoucherSummary";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needControl = false;
		__needPagenation = false;
		resultGrid = new DelicacyListGrid(){
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				if (record.getAttributeAsBoolean("locked")) {  //定稿标绿色
                    return "color:#00B736;";  
                } else {  
                    return super.getCellCSSText(record, rowNum, colNum);  
                }  
			}
		};
		resultGrid.setDataSource(getDataSource());
		resultGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public void initComponents() {
		
		ListGridField[] fields = new ListGridField[4];
		int idx = 0;
		fields[idx] = new ListGridField("voucherType");
		fields[idx++].setWidth(80);
		fields[idx++] = new ListGridField("reimbursementPackageCode");
		fields[idx] = new ListGridField("vestingDate");
		fields[idx++].setWidth(90);
		fields[idx] = new ListGridField("sequenceNumber");
		fields[idx].setWidth(70);
		resultGrid.setFields(fields);
		
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if(null == detailPanel) {
					return;
				}
				Record r = resultGrid.getSelectedRecord();
				detailPanel.setSequenceNumber(r.getAttribute("sequenceNumber"));
				detailPanel.setVestingDate(r.getAttributeAsDate("vestingDate"));
				detailPanel.commonQuery();
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
				detail.setTitle("凭证汇总"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				AllVoucherSummaryViewer detailForm = new AllVoucherSummaryViewer();
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
	public void afterDataReceived(Record[] data) {
		super.afterDataReceived(data);
		if(null != data && data.length > 0 && null != detailPanel) {
			resultGrid.selectRecord(0);
			Record r = data[0];
			detailPanel.setSequenceNumber(r.getAttribute("sequenceNumber"));
			detailPanel.setVestingDate(r.getAttributeAsDate("vestingDate"));
			detailPanel.commonQuery();
		}else {
			Record[] records = new Record[0];
			detailPanel.getResultGrid().setData(records);
			detailPanel.getResultGrid().redraw();
		}
	}
	
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new AllVoucherSummarySearchForm();
	}

	@Override
	public int getSearchFormHeight() {
		return 160;
	}
	
	@Override
	public DataSource getDataSource() {
		return DSAllVoucherSummary.getInstance();
	}

	public DelicacyListGrid getResultGrid() {
		return resultGrid;
	}

	public CustomAllVoucherDetailPanel getDetailPanel() {
		return detailPanel;
	}

	public void setDetailPanel(CustomAllVoucherDetailPanel detailPanel) {
		this.detailPanel = detailPanel;
	}
	
}

