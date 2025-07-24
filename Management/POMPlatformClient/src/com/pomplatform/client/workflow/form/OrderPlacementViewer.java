package com.pomplatform.client.workflow.form;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.i18n.client.NumberFormat;
import com.pomplatform.client.contractinfo.panel.CustomContractMainPanel;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.data.*;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.GenericViewWindow;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.workflow.datasource.DSOrderPlacement;
import com.pomplatform.client.workflow.datasource.DSOrderInfoChild;

public class OrderPlacementViewer extends AbstractDetailViewer
{


	private final DelicacyListGrid orderInfoChildGrid = new DelicacyListGrid();
	private SearchForm __parentSearchForm;

	public OrderPlacementViewer() {
	}

	@Override
	public void initComponents() {
		ListGridField[] fields = new ListGridField[14];
		int idx = 0;
		fields[idx] = new ListGridField("subContractId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("parentId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("subContractCode");
		idx++;
		fields[idx] = new ListGridField("projectCode");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("departmentId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		idx++;
		fields[idx] = new ListGridField("moneySum","合同金额");
		idx++;
		fields[idx] = new ListGridField("ht_percentage","合同金额占比");
		fields[idx].setCellFormatter(new CellFormatter() {
			public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
				if (value == null) return null;
				try {
					NumberFormat nf = NumberFormat.getFormat("#,##0.00");
					return nf.format(((Number) value).doubleValue())+"%";
				} catch (Exception e) {
					return value.toString();
				}
			}
		});
		idx++;
		fields[idx] = new ListGridField("createTime");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("sheetTotalIntegral","订单积分");
		idx++;
		fields[idx] = new ListGridField("dd_percentage","订单积分占比");
		fields[idx].setCellFormatter(new CellFormatter() {
			public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
				if (value == null) return null;
				try {
					NumberFormat nf = NumberFormat.getFormat("#,##0.00");
					return nf.format(((Number) value).doubleValue())+"%";
				} catch (Exception e) {
					return value.toString();
				}
			}
		});
		idx++;
		fields[idx] = new ListGridField("jf", "积分/金额比");
		fields[idx].setFormat("##,###,###,###,##0.00");
		fields[idx].setCellFormatter(new CellFormatter() {
			public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
				try {
					if(null != record.getAttribute("moneySum") && null != record.getAttribute("sheetTotalIntegral")){
						NumberFormat nf = NumberFormat.getFormat("#,##0.00");
						return nf.format(record.getAttributeAsDouble("sheetTotalIntegral")/record.getAttributeAsDouble("moneySum") * 100)+"%";
					}else{
						return "0.00%";
					}

				} catch (Exception e) {
					return "0.00%";
				}
			}
		});
		idx++;
		fields[idx] = new ListGridField("subContractName");
		idx++;
		fields[idx] = new ListGridField("projectManageId","专业负责人/管理人员");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("remark","备注");
		super.initComponents();
		orderInfoChildGrid.setDataSource(DSOrderInfoChild.getInstance());
		orderInfoChildGrid.setFields(fields);
		orderInfoChildGrid.addDoubleClickHandler(new DoubleClickHandler(){
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("");
				detail.setWidth(700); detail.setHeight(500); 
				OrderInfoChildViewer viewer = new OrderInfoChildViewer();
				viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
				viewer.initComponents();
				viewer.viewSelectedData((ListGrid)event.getSource());
				detail.setContent(viewer);
				detail.centerInPage();
				detail.show();
			}
		});
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "OrderPlacementOfWorkflow";
	}

	@Override
	public int getGroupCount() {
		return 0;
	}

	@Override
	public List<GroupColumn> getGroupColumnNames() {
		List<GroupColumn> gcs = new ArrayList<GroupColumn>();
		return gcs;
	}

	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map params = new HashMap();
		params.put("orderInfoId", getBusinessId());
		DBDataSource.callOperation("NQ_OrderPlacement", "find", new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					for(DetailViewer v : detailViewers){
						v.setData(dsResponse.getData());
						if(dsResponse.getData().length == 0) continue;
						v.selectRecord(0);
						v.redraw();
					}
					setRecord(dsResponse.getData()[0]);
					viewDetailData();
				}
			}
		});

	}

	@Override
	public void viewSelectedData(ListGrid grid){
		super.viewSelectedData(grid);
		setRecord(grid.getSelectedRecord());
		viewDetailData();
	}

	public void viewDetailData(){
		Record selected = getRecord();
		int contractId = BaseHelpUtils.getIntValue(selected.getAttribute("contractId"));
		int orderInfoId = BaseHelpUtils.getIntValue(selected.getAttribute("orderInfoId"));
		if (contractId > 0) {
			Map<String, Object> condition = new HashMap<>();
			condition.put("opt_type", "getOrderInfoChild");
			condition.put("contractId", contractId);
			condition.put("orderInfoId", orderInfoId);
			condition.put("isLoadAll", true);
			DBDataSource.callOperation("EP_CustomSubContractFlowHandler", "", condition, new DSCallback() {
				@SuppressWarnings("unchecked")
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if (dsResponse.getStatus() >= 0) {
						orderInfoChildGrid.setData(dsResponse.getData());
					} else {
						ClientUtil.displayErrorMessage(dsResponse);
					}
				}
			});
		}
//		Record selected = getRecord();
//		Object val;
//		java.util.Map condition = null;
//		java.util.Map parentSearch = __parentSearchForm == null ? new java.util.HashMap() : __parentSearchForm.getValues();
//		condition = new java.util.HashMap();
//		condition.put("orderInfoId", selected.getAttributeAsString("orderInfoId"));
//		DBDataSource.callOperation("ST_OrderInfoChild", "find", condition, new DSCallback(){
//			@Override
//			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//				if(dsResponse.getStatus() >= 0){
//					orderInfoChildGrid.setData(dsResponse.getData());
//				}
//			}
//		});
	}

	@Override
	public DataSource getMainDataSource() {
		return DSOrderPlacement.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 1;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(orderInfoChildGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("订单下达审批");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}


}

