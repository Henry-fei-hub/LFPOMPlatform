package com.pomplatform.client.collection.panel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.core.client.GWT;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.ja.ht.datasource.DSOutDesignConsideration;
import com.pomplatform.client.sinvoiceitior.datasource.DSSinvoiceitior;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DropCompleteEvent;
import com.smartgwt.client.widgets.events.DropCompleteHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;

public class CustomInvoicePanel extends AbstractWizadPage {

	private static Logger __LOGGER = Logger.getLogger("");
	public DelicacyListGrid SourceGrid;
	private DynamicForm __infoForm;
	private TextItem totalItem;
	public CustomInvoicePanel(final int contractId) {
		CustomInvoicePanel.contractId = contractId;
		SourceGrid = new DelicacyListGrid();
		SourceGrid.setDataSource(DSSinvoiceitior.getInstance());
		SourceGrid.setCanEdit(false);
		//选中的发票统计回款(正常的发票)
		SourceGrid.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord [] selectRecords = SourceGrid.getSelectedRecords();
				if(selectRecords.length>0){
					//开票金额
					double invoiceAmountSum=0;
					for (ListGridRecord listGridRecord : selectRecords) {
//						int tmpInvoiceType=listGridRecord.getAttributeAsInt("invoiceType");
						invoiceAmountSum += listGridRecord.getAttributeAsDouble("invoiceAmount");
					}
					CustomItemInvoiceMainPanel.customInvoiceTitle.setContents("发票回款 发票总金额="+invoiceAmountSum);
				}
			}
		});
		
		
		
		
		HLayout bigLayout = new HLayout();
		bigLayout.setWidth100();
		VLayout SearchSourceLayout = new VLayout();
		SearchSourceLayout.setWidth("94%");
		ListGridField[] fields = new ListGridField[8];
		int idx = 0;
		fields[idx] = new ListGridField("invoiceId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("invoiceType");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("sign");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("invoiceDate");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("registrationDate","回款日期");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("invoiceCode");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("invoiceNumber");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("invoiceAmount");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("outputTax","回款金额");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("taxRate","回款百分比(%)");
		fields[idx].setShowGridSummary(false);
		idx++;
		 
		SourceGrid.setFields(fields);
		SourceGrid.setShowRowNumbers(true);
		SourceGrid.setShowGridSummary(true);
		__infoForm = new DynamicForm();
		__infoForm.setWidth100();
		__infoForm.setHeight("16%");
		__infoForm.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__infoForm);
		totalItem = new TextItem("发票回款汇总");
		totalItem.setCanEdit(false);
		totalItem.setWidth("*");
		__infoForm.setFields(totalItem);
		SearchSourceLayout.setHeight100();
		SearchSourceLayout.setLayoutTopMargin(10);
		SearchSourceLayout.setLayoutRightMargin(5);
		SearchSourceLayout.setMembersMargin(10);
		SearchSourceLayout.addMember(SourceGrid);
//		SearchSourceLayout.addMember(__infoForm);
		
		bigLayout.addMember(SearchSourceLayout);
		addMember(bigLayout);
	}

	@Override
	public void startEdit() {
		if (BaseHelpUtils.getIntValue(contractId) > 0) {
			Map<String, Object> condition = new HashMap<>();
			condition.put("opt_type", "loadInvoiceList");
			condition.put("contractId", contractId);
			DBDataSource.callOperation("EP_CustomItemCollectionHandler", "", condition, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					SourceGrid.setData(dsResponse.getData());
					// 设置汇总信息
				    totalItem.setValue(dsResponse.getErrors().get("errorMsg"));
				}
			});
		}
	}

	// 效验数据
	@Override
	public boolean checkData() {
		boolean isFlag = true;
		return isFlag;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("CustomInvoicePanel");
		return res;
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	public Map getValuesAsMap() {
		return null;
	}

	private static int contractId;
}
