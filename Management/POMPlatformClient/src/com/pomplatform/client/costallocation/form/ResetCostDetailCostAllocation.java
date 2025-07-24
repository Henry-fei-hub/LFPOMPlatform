package com.pomplatform.client.costallocation.form;

import java.math.BigDecimal;
import java.util.*;
import com.delicacy.client.MapUtils;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.smartgwt.client.data.Criteria;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
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
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;
import java.util.logging.Logger;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.pomplatform.client.costallocation.datasource.DSCostAllocation;
import com.pomplatform.client.workflow.commonNormalReimbursement.form.NormalReimbursementLinkDepartmentPopupPanel;

public class ResetCostDetailCostAllocation extends AbstractWizadPage
{

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(true);
	private BigDecimal totalCost = BigDecimal.ZERO;

	public ResetCostDetailCostAllocation(){


		HLayout costAllocations = new HLayout();
		costAllocations.setWidth100();
		costAllocations.setHeight100();
		grid.setDataSource(DSCostAllocation.getInstance());
		grid.setAutoFitFieldWidths(false);
		grid.setCanEdit(false);
		costAllocations.addMember(grid);
		VLayout costAllocationsControls = new VLayout();
		costAllocationsControls.setHeight100();
		costAllocationsControls.setWidth(60);
		costAllocationsControls.setLayoutTopMargin(30);
		costAllocationsControls.setLayoutLeftMargin(5);
		costAllocationsControls.setLayoutRightMargin(5);
		costAllocationsControls.setMembersMargin(10);
		costAllocations.addMember(costAllocationsControls);
		addMember(costAllocations);
		IButton newButton = new IButton("新增");
		newButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
//				grid.startEditingNew();
				Record[] records = grid.getRecords();
				BigDecimal leftCost = totalCost;
				if(null != records && records.length > 0){
					for(Record record : records){
						if(null != record.getAttribute("cost")){
							leftCost = leftCost.subtract(new BigDecimal(record.getAttribute("cost")));
						}
					}
				}
				if(leftCost.compareTo(BigDecimal.ZERO) > 0){
					PopupWindow window = new PopupWindow();
					window.setWidth("30%");
					window.setHeight("35%");
					window.centerInPage();
					window.setTitle("分摊成本--新增");
					ResetCostPopupPanel panel = new ResetCostPopupPanel(false);
					Record record = new Record();
					record.setAttribute("leftCost", leftCost);
					panel.startEdit(record);
					panel.setParentWindow(window);
					panel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							Record record = event.getData();
							RecordList list = grid.getDataAsRecordList();
							list.add(record);
							grid.setData(list);
							grid.redraw();
						}
					});
					window.addItem(panel);
					window.show();
				}
			}
		});
		IButton updateButton = new IButton("修改");
		updateButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!grid.anySelected()){
					SC.say("请选择一条记录再修改");
				}else{
					Record[] records = grid.getRecords();
					BigDecimal leftCost = totalCost;
					if(null != records && records.length > 0){
						for(Record record : records){
							if(null != record.getAttribute("cost")){
								leftCost = leftCost.subtract(new BigDecimal(record.getAttribute("cost")));
							}
						}
					}
					ListGridRecord selected = grid.getSelectedRecords()[0];
					final int rowNo = grid.getRowNum(selected);
					leftCost = leftCost.add(new BigDecimal(selected.getAttribute("cost")));
					selected.setAttribute("leftCost", leftCost);
					PopupWindow window = new PopupWindow();
					window.setWidth("30%");
					window.setHeight("35%");
					window.centerInPage();
					window.setTitle("分摊成本--修改");
					ResetCostPopupPanel panel = new ResetCostPopupPanel(false);
					panel.startEdit(selected);
					panel.setParentWindow(window);
					panel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							Record record = event.getData();
							RecordList list = grid.getDataAsRecordList();
							RecordList newList = new RecordList();
							int size = list.getLength();
							for (int i = 0; i < size; i++) {
								if (i == rowNo) {
									newList.add(record);
								} else {
									newList.add(list.get(i));
								}
							}
							grid.setData(newList);
							grid.redraw();
						}
					});
					window.addItem(panel);
					window.show();
				}
			}
		});
		IButton deleteButton = new IButton("删除所有");
		deleteButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				grid.setData(new RecordList());
			}
		});
		costAllocationsControls.addMembers(newButton, updateButton, deleteButton);
	}

	@Override
	public void startEdit() {
		if(getPageMode() != PAGE_MODE_UPDATE) return;
		reloadDetailTableData();
	}

	public void reloadDetailTableData(){
		Map condition = new HashMap();
		condition.put("resetCostId", getRecord().getAttribute("resetCostId"));
		DBDataSource.callOperation("ST_CostAllocation", "find", condition, new DSCallback(){
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
		BigDecimal cost = BigDecimal.ZERO;
		Record[] records = grid.getRecords();
		for(Record record : records){
			if(null != record.getAttribute("cost")){
				cost = cost.add(new BigDecimal(record.getAttribute("cost")));
			}
		}
		if(cost.compareTo(totalCost) == 0){
			return true;
		}else{
			SC.say("成本没有全部分摊");
			return false;
		}
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("detailCostAllocation");
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
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailCostAllocation");
		return param;
	}

	@Override
	public String getName() {
		return "";
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

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}


}

