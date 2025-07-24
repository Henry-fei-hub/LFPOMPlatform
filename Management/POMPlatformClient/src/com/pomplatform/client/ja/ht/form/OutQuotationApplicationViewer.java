package com.pomplatform.client.ja.ht.form;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.events.ChangedHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.Alignment;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.GenericViewWindow;
import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.ja.ht.datasource.DSOutQuotationApplication;
import com.pomplatform.client.preprojects.datasource.DSMainProjectBusinessType;
import com.pomplatform.client.ja.ht.datasource.DSOutDesignConsideration;
import com.pomplatform.client.ja.ht.datasource.DSOutDesignConsideration2;

public class OutQuotationApplicationViewer extends AbstractDetailViewer
{


	private final DelicacyListGrid outDesignConsiderationsGrid = new DelicacyListGrid();
	private final DelicacyListGrid mainProjectBusinessTypeGrid = new DelicacyListGrid();
	private SearchForm __parentSearchForm;


	public OutQuotationApplicationViewer() {
	}

	@Override
	public void initComponents() {
		super.initComponents();
		ListGridField[] fields = new ListGridField[8];
		int idx = 0;
		fields[idx] = new ListGridField("outDesignConsiderationId");
		fields[idx].setCanEdit(false);
//		KeyValueManager.loadValueMap("out_design_considerations",fields[idx]);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("infoCode");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("projectCode");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("mainDesignAreaName");
		fields[idx].setHidden(false);
		idx++;
//		fields[idx] = new ListGridField("businessType","业务类型");
//		fields[idx].setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
//		KeyValueManager.loadValueMap("production_value_coefficient_type",fields[idx]);
//		idx++;
		//设计面积
		fields[idx] = new ListGridField("designArea","面积");
		fields[idx].setWidth("*");
		idx++;
		//单价
		fields[idx] = new ListGridField("designUnitPrice","单 价");
		fields[idx].setWidth("*");
		idx++;
		//总价
		fields[idx] = new ListGridField("moneySum","总 价");
		fields[idx].setWidth("*");
		outDesignConsiderationsGrid.setAutoFitFieldWidths(false);
		outDesignConsiderationsGrid.setDataSource(DSOutDesignConsideration2.getInstance());
		outDesignConsiderationsGrid.setFields(fields);
//		outDesignConsiderationsGrid.addDoubleClickHandler(new DoubleClickHandler(){
//			@Override
//			public void onDoubleClick(DoubleClickEvent event) {
//				GenericViewWindow detail = new GenericViewWindow();
//				detail.setTitle("合同报价单表");
//				detail.setWidth(700); detail.setHeight(500); 
//				OutDesignConsiderationViewer viewer = new OutDesignConsiderationViewer();
//				viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
//				viewer.initComponents();
//				viewer.viewSelectedData((ListGrid)event.getSource());
//				detail.setContent(viewer);
//				detail.centerInPage();detail.show();
//			}
//		});
		ListGridField[] aFields = new ListGridField[2];
		int a = 0;
		aFields[a] = new ListGridField("mainProjectBusinessTypeId");
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("businessType","业务类别");
		aFields[a].setCanEdit(false);
		aFields[a].setWidth("*");
		KeyValueManager.loadValueMap("production_value_coefficient_type",aFields[a]);
		a++;
		aFields[a] = new ListGridField("area", "面积");
		aFields[a].setWidth("*");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("outputValue", "产值");
		aFields[a].setWidth("*");
		aFields[a].setCanEdit(false);
		mainProjectBusinessTypeGrid.setDataSource(DSMainProjectBusinessType.getInstance());
		mainProjectBusinessTypeGrid.setFields(aFields);
		mainProjectBusinessTypeGrid.setAutoFitFieldWidths(false);
//		mainProjectBusinessTypeGrid.addDoubleClickHandler(new DoubleClickHandler(){
//			@Override
//			public void onDoubleClick(DoubleClickEvent event) {
//				GenericViewWindow detail = new GenericViewWindow();
//				detail.setTitle("产值单表");
//				detail.setWidth(700); detail.setHeight(500); 
//				OutDesignConsiderationViewer viewer = new OutDesignConsiderationViewer();
//				viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
//				viewer.initComponents();
//				viewer.viewSelectedData((ListGrid)event.getSource());
//				detail.setContent(viewer);
//				detail.centerInPage();detail.show();
//			}
//		});
	}

	@Override
	public int getHorizontalPercent() {
		return 50;
	}

	@Override
	public String getName() {
		return "OutQuotationApplication";
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
		params.put("outQuotationId", getBusinessId());
		DBDataSource.callOperation("NQ_OutQuotationApplication", "find", new DSCallback() {
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
		Object val;
		java.util.Map condition = null;
		java.util.Map parentSearch = __parentSearchForm == null ? new java.util.HashMap() : __parentSearchForm.getValues();
		condition = new java.util.HashMap();
		condition.put("outQuotationId", selected.getAttributeAsString("outQuotationId"));
		DBDataSource.callOperation("ST_OutDesignConsideration", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					outDesignConsiderationsGrid.setData(dsResponse.getData());
				}
			}
		});
		
		DBDataSource.callOperation("ST_MainProjectBusinessType", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					mainProjectBusinessTypeGrid.setData(dsResponse.getData());
				}
			}
		});
	}

	@Override
	public DataSource getMainDataSource() {
		return DSOutQuotationApplication.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 2;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(outDesignConsiderationsGrid);
		res.add(mainProjectBusinessTypeGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("合同报价单表");
		res.add("产值单表");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}


}

