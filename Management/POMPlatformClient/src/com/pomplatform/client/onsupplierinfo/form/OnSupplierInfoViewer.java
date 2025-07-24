package com.pomplatform.client.onsupplierinfo.form;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.GenericViewWindow;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.onsupplierinfo.datasource.DSOnSupplierInfo;

public class OnSupplierInfoViewer extends AbstractDetailViewer
{


	private SearchForm __parentSearchForm;
	private DelicacyListGrid detailGrid;
	private DelicacyListGrid coopGrid;
	private DelicacyListGrid receiveGrid;


	public OnSupplierInfoViewer() {
		
		detailGrid = new DelicacyListGrid();
		ListGridField[] fields = new ListGridField[5];
		int idx = 0;
		fields[idx] = new ListGridField("supplierDetailId","供应商详情ID");
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("supplierId","供应商ID");
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("projectName","项目名称");
		fields[idx].setAlign(Alignment.CENTER);
		fields[idx].setWidth("35%");
		idx ++;
		fields[idx] = new ListGridField("projectAddress","项目地址");
		fields[idx].setAlign(Alignment.CENTER);
		fields[idx].setWidth("35%");
		idx ++;
		fields[idx] = new ListGridField("supplierDuty","主要负责内容");
		fields[idx].setAlign(Alignment.CENTER);
		fields[idx].setWidth("35%");
		detailGrid.setFields(fields);
		detailGrid.setAutoFitFieldWidths(true);
		detailGrid.setCanEdit(false);
		detailGrid.setSelectionType(SelectionStyle.SINGLE);
		detailGrid.setHeight100();
		detailGrid.setWidth100();
		
		coopGrid= new DelicacyListGrid();
		ListGridField[] field = new ListGridField[5];
		int id = 0;
		field[id] = new ListGridField("supplierCooperationiId");
		field[id].setCanEdit(false);
		field[id].setHidden(true);
		id ++;
		field[id] = new ListGridField("supplierId");
		field[id].setCanEdit(false);
		field[id].setHidden(true);
		id ++;
		field[id] = new ListGridField("projectName","合作的项目名称");
		field[id].setWidth("25%");
		field[id].setAutoFitWidth(false);
		field[id].setAlign(Alignment.CENTER);
		id ++;
		field[id] = new ListGridField("projectLeader","J&A负责人");
		ComboBoxItem employeeItem = new ComboBoxItem();
		employeeItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		field[id].setEditorProperties(employeeItem);
		KeyValueManager.loadValueMap("employees", field[id]);
		field[id].setWidth("20%");
		field[id].setAlign(Alignment.CENTER);
		id ++;
		field[id] = new ListGridField("supplierEvaluate","供应商评价");
		field[id].setAlign(Alignment.CENTER);
		field[id].setWidth("35%");
		coopGrid.setFields(field);
		coopGrid.setAutoFitFieldWidths(true);
		coopGrid.setCanEdit(false);
		coopGrid.setSelectionType(SelectionStyle.SINGLE);
		coopGrid.setHeight100();
		coopGrid.setWidth100();
		
		receiveGrid= new DelicacyListGrid();
		ListGridField[] fieldss = new ListGridField[5];
		int ids = 0;
		fieldss[ids] = new ListGridField("receiveUnitManageId");
		fieldss[ids].setHidden(true);
		ids ++;
		fieldss[ids] = new ListGridField("receiveUnit","收款单位");
		fieldss[ids].setWidth("25%");
		ids ++;
		fieldss[ids] = new ListGridField("bankAccount","银行账号");
		fieldss[ids].setWidth("25%");
		ids ++;
		fieldss[ids] = new ListGridField("bankName","开户行");
		fieldss[ids].setWidth("25%");
		ids ++;
		fieldss[ids] = new ListGridField("receiveUnitAddress","收款单位所在地");
		fieldss[ids].setWidth("25%");
		ids ++;
		fieldss[ids] = new ListGridField("operateEmployeeId","操作人");
		fieldss[ids].setWidth("25%");
		KeyValueManager.loadValueMap("employees", fieldss[ids]);
		ids ++;
		fieldss[ids] = new ListGridField("operateTime","操作时间");
		fieldss[ids].setWidth("25%");
		receiveGrid.setFields(fieldss);
		receiveGrid.setAutoFitFieldWidths(true);
		receiveGrid.setCanEdit(false);
		receiveGrid.setSelectionType(SelectionStyle.SINGLE);
		receiveGrid.setHeight100();
		receiveGrid.setWidth100();
	}

	@Override
	public void initComponents() {
		super.initComponents();
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "供应商基本情况";
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
		params.put("supplierId", getBusinessId());
		DBDataSource.callOperation("NQ_OnSupplierInfo", "find", new DSCallback() {
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
		Record selected = grid.getSelectedRecord();
		int supplierId=BaseHelpUtils.getIntValue(selected.getAttribute("supplierId"));
		Map<String,Object> params = new HashMap<>();
		params.put("supplierId", supplierId);
		DBDataSource.callOperation("ST_SupplierDetail", "find",params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					detailGrid.setData(dsResponse.getData());
				}
			}
		});
		DBDataSource.callOperation("ST_SupplierCooperation","find",params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					coopGrid.setData(dsResponse.getData());
				} else {
					SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
				}
			}
		});
		
		DBDataSource.callOperation("ST_ReceiveUnitManage","find",params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					receiveGrid.setData(dsResponse.getData());
				} else {
					SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
				}
			}
		});
	}

	public void viewDetailData(){
	}

	@Override
	public DataSource getMainDataSource() {
		return DSOnSupplierInfo.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 3;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(detailGrid);
		res.add(coopGrid);
		res.add(receiveGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("供应商详情");
		res.add("与JA合作过的项目");
		res.add("相关的供应商收款单位");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}


}

