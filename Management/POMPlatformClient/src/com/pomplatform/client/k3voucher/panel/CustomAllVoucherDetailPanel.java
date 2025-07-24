package com.pomplatform.client.k3voucher.panel;

import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.k3code.datasource.DSSk3codetpor;
import com.pomplatform.client.k3voucher.datasource.DSAllVoucherDetail;
import com.pomplatform.client.k3voucher.form.AllVoucherDetailViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

public class CustomAllVoucherDetailPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			CustomAllVoucherDetailPanel cm = new CustomAllVoucherDetailPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "AllVoucherDetail";
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
		resultGrid.setShowRowNumbers(false);
		resultGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public void initComponents() {
		ListGridField k3CodeIdField = new ListGridField("k3CodeId");
		ListGridField k3CodeField = new ListGridField("k3Code");
		ListGridField k3NameField = new ListGridField("k3Name");
		ComboBoxItem codeItem = new ComboBoxItem("code", "科目代码");
        codeItem.setWidth("*");
        codeItem.setChangeOnKeypress(false);
        codeItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
        codeItem.setOptionDataSource(DSSk3codetpor.getInstance());
        codeItem.setValueField(k3CodeIdField.getName());
        codeItem.setDisplayField(k3CodeField.getName());
        codeItem.setPickListFields(k3NameField, k3CodeField);
        codeItem.setPickListWidth(600);
		ListGridField[] fields = new ListGridField[9];
		int idx = 0;
		fields[idx] = new ListGridField("code");
		fields[idx].setEditorProperties(codeItem);
		fields[idx].setShowGridSummary(false);
		fields[idx].setWidth(80);
		idx++;
		fields[idx] = new ListGridField("name");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		fields[idx].setWidth(150);
		idx++;
		fields[idx] = new ListGridField("secondaryCode");
		fields[idx].setEditorProperties(codeItem);
		fields[idx].setShowGridSummary(false);
		fields[idx].setWidth(80);
		idx++;
		fields[idx] = new ListGridField("secondaryName");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		fields[idx].setWidth(150);
		idx++;
		fields[idx] = new ListGridField("simplifyRemark", "凭证摘要");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("debitSide");
		fields[idx].setWidth(100);
		idx++;
		fields[idx] = new ListGridField("creditSide");
		fields[idx].setWidth(100);
		idx++;
		fields[idx] = new ListGridField("selfBankAccount");
		fields[idx].setShowGridSummary(false);
		fields[idx].setWidth(150);
		idx++;
		fields[idx] = new ListGridField("otherBankAccount");
		fields[idx].setShowGridSummary(false);
		fields[idx].setWidth(150);
		resultGrid.setFields(fields);
		resultGrid.setShowGridSummary(true);
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				int rowNum = resultGrid.getRowNum(resultGrid.getSelectedRecord());
				resultGrid.startEditing(rowNum);
			}
		});
		
		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				final Record selected = resultGrid.getRecord(event.getRowNum());
				Map params = selected.toMap();
				Map newData = event.getNewValues();
				if(newData.containsKey("code")) {
					params.put("codeId", newData.get("code"));
				}
				if(newData.containsKey("secondaryCode")) {
					params.put("secondaryCodeId", newData.get("secondaryCode"));
				}
				params.remove("code");
				params.remove("secondaryCode");
				params.put("optType", "updateK3VoucherByDoubleClick");
				DBDataSource.callOperation("EP_K3VoucherProcess", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0) {
							Record record = dsResponse.getData()[0];
							DBDataSource.copyRecord(record, selected);
							resultGrid.redraw();
						}else {
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("凭证详情"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				AllVoucherDetailViewer detailForm = new AllVoucherDetailViewer();
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
		if(!BaseHelpUtils.isNullOrEmpty(sequenceNumber)) {
			criteria.put("sequenceNumber", sequenceNumber);
		}
		if(!BaseHelpUtils.isNullOrEmpty(vestingDate)) {
			criteria.put("vestingDate", vestingDate);
		}
//		criteria.put("addtionalCondition", "order by k3_voucher_id");
		return true;
	}

	@Override
	public void afterDataReceived(Record[] data) {
		super.afterDataReceived(data);
		resultGrid.selectRecord(0);
	}
	
	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSAllVoucherDetail.getInstance();
	}

	private String sequenceNumber;
	private Date vestingDate;

	public String getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	
	public Date getVestingDate() {
		return vestingDate;
	}

	public void setVestingDate(Date vestingDate) {
		this.vestingDate = vestingDate;
	}

	public DelicacyListGrid getResultGrid() {
		return resultGrid;
	}
}

