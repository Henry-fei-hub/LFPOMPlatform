package com.pomplatform.client.workflow.form;

import java.util.*;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.smartgwt.client.data.Criteria;
import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;
import java.util.logging.Logger;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.pomplatform.client.workflow.datasource.DSOrderInfoChild;

public class OrderPlacementDetailOrderInfoChild extends AbstractWizadPage
{

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(true);

	public OrderPlacementDetailOrderInfoChild(){


		HLayout orderInfoChild = new HLayout();
		orderInfoChild.setWidth100();
		orderInfoChild.setHeight100();
		grid.setDataSource(DSOrderInfoChild.getInstance());
		grid.setAutoFitFieldWidths(false);
		orderInfoChild.addMember(grid);
		VLayout orderInfoChildControls = new VLayout();
		orderInfoChildControls.setHeight100();
		orderInfoChildControls.setWidth(60);
		orderInfoChildControls.setLayoutTopMargin(30);
		orderInfoChildControls.setLayoutLeftMargin(5);
		orderInfoChildControls.setLayoutRightMargin(5);
		orderInfoChildControls.setMembersMargin(10);
		orderInfoChild.addMember(orderInfoChildControls);
		addMember(orderInfoChild);
		IButton orderInfoChildNewButton = new IButton("新增");
		orderInfoChildNewButton.setIcon("[SKIN]/actions/add.png");
		orderInfoChildNewButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				grid.startEditingNew();
			}
		});
		IButton orderInfoChildRemoveButton = new IButton("删除所有");
		orderInfoChildRemoveButton.setIcon("[SKIN]/actions/remove.png");
		orderInfoChildRemoveButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				grid.setData(new RecordList());
			}
		});
		orderInfoChildControls.addMember(orderInfoChildNewButton);
		orderInfoChildControls.addMember(orderInfoChildRemoveButton);
	}

	@Override
	public void startEdit() {
		Record selected = getRecord();
		int contractId = BaseHelpUtils.getIntValue(selected.getAttribute("contractId"));
		int orderInfoId = BaseHelpUtils.getIntValue(selected.getAttribute("orderInfoId"));
		if (contractId > 0) {
			Map<String, Object> condition = new HashMap<>();
			condition.put("opt_type", "getSubContract");
			condition.put("contractId", contractId);
			condition.put("orderInfoId", orderInfoId);
			condition.put("isLoadAll", true);
			DBDataSource.callOperation("EP_CustomSubContractFlowHandler", "", condition, new DSCallback() {
				@SuppressWarnings("unchecked")
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if (dsResponse.getStatus() >= 0) {
						grid.setData(dsResponse.getData());
					} else {
						ClientUtil.displayErrorMessage(dsResponse);
					}
				}
			});
		}
		if(getPageMode() != PAGE_MODE_UPDATE) return;
//		reloadDetailTableData();
	}

	public void reloadDetailTableData(){
		Map condition = new HashMap();
		condition.put("orderInfoId", getRecord().getAttribute("orderInfoId"));
		DBDataSource.callOperation("ST_OrderInfoChild", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					if(__startLoadedDetail != null) __startLoadedDetail.execute(dsResponse, data, dsRequest);
					grid.setData(dsResponse.getData());
					if(__endLoadedDetail != null) __endLoadedDetail.execute(dsResponse, data, dsRequest);
				}
			}
		});
	}

	@Override
	public boolean checkData() {
		for(ListGridRecord r : grid.getRecords()) {
			__logger.info(MapUtils.convertRecordToMap(grid.getDataSource(), r).toString());
		}
		return true;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("detailOrderInfoChild");
		return res;
	}

	@Override
	public boolean isTheValuesEmpty() {
		ListGridRecord[] rows = grid.getRecords();
		return rows == null || rows.length == 0;
	}

	@Override
	public Map getValuesAsMap() {
		Map param = new HashMap();
		ListGridRecord[] rows = grid.getRecords();
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailOrderInfoChild");
		return param;
	}

	@Override
	public String getName() {
		return "订单下达处理节点";
	}

	public DSCallback getStartLoadedDetail() {
		return this.__startLoadedDetail;
	}

	public void setStartLoadedDetail( DSCallback value ) {
		this.__startLoadedDetail = value;
	}

	public DSCallback getEndLoadedDetail() {
		return this.__endLoadedDetail;
	}

	public void setEndLoadedDetail( DSCallback value ) {
		this.__endLoadedDetail = value;
	}

	public DelicacyListGrid getGrid() {
		return this.grid;
	}

	public void setGrid( DelicacyListGrid value ) {
		this.grid = value;
	}


}

