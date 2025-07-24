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
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.receivables.datasource.DSMcapitalecoosmeor;
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

public class CustomItemCollectionPanel extends AbstractWizadPage {

	private static Logger __LOGGER = Logger.getLogger("");
	public DelicacyListGrid SourceGrid;
	private DynamicForm __infoForm;
	private TextItem totalItem;

	/**
	 * 
	 * @param contractId
	 * @param isflag
	 * @param typeFlag true 表示显示合同所有的流水账 false 表示没有绑定发票的回款
	 */
	public CustomItemCollectionPanel(final int contractId,final boolean isflag,final boolean typeFlag) {
		CustomItemCollectionPanel.contractId = contractId;
		CustomItemCollectionPanel.isflag=isflag;
		SourceGrid = new DelicacyListGrid();
		SourceGrid.setDataSource(DSMcapitalecoosmeor.getInstance());
		SourceGrid.setCanEdit(false);
		ListGridField[] fields = new ListGridField[8];
		int idx = 0;
		fields[idx] = new ListGridField("capitalId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("contractId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		
		idx++;
		fields[idx] = new ListGridField("contractName");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		
		idx++;
		fields[idx] = new ListGridField("moneyAttribute");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("selfName");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("selfBankName");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("selfBankAccount");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("otherName");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("borrowMoney");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("happenDate");
		idx++;
		fields[idx] = new ListGridField("createDate");
		idx++;
		fields[idx] = new ListGridField("hasInvoices");
		idx++;
		fields[idx] = new ListGridField("hasContractReceivable");
		idx++;
		fields[idx] = new ListGridField("employeeName");
		idx++;
		fields[idx] = new ListGridField("remark");
		SourceGrid.setFields(fields);
		HLayout bigLayout = new HLayout();
		bigLayout.setWidth100();
		VLayout SearchSourceLayout = new VLayout();
		SearchSourceLayout.setWidth100();
 
		SourceGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
		SourceGrid.setShowRowNumbers(true);
		SourceGrid.setShowGridSummary(true);
		__infoForm = new DynamicForm();
		__infoForm.setWidth100();
		__infoForm.setHeight("16%");
		__infoForm.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__infoForm);
		totalItem = new TextItem("合同总回款");
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
		__LOGGER.info("CustomItemCollectionPanel start load contractId=" + contractId);
		if(typeFlag){
			if (BaseHelpUtils.getIntValue(contractId) > 0) {
				Map<String, Object> condition = new HashMap<>();
				condition.put("opt_type", "loadContractAllItemCollection");
				condition.put("contractId", contractId);
				condition.put("isFlag", isflag);
				
				DBDataSource.callOperation("EP_CustomItemCollectionHandler", "", condition, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						SourceGrid.setData(dsResponse.getData());
						// 设置汇总信息
					    totalItem.setValue(dsResponse.getErrors().get("errorMsg"));
					}
				});
			}
		}else{
			if (BaseHelpUtils.getIntValue(contractId) > 0) {
				Map<String, Object> condition = new HashMap<>();
				condition.put("opt_type", "loadContractItemCollection");
				condition.put("contractId", contractId);
				condition.put("isFlag", isflag);
				
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
		res.add("CustomItemCollectionPanel");
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
	private static boolean isflag;
	private static boolean typeFlag;
}
