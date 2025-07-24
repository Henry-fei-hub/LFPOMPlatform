package com.pomplatform.client.ja.ht.form;

import java.util.ArrayList;
import java.util.List;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.data.*;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.GenericViewWindow;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.ja.ht.datasource.DSSformalcontractcccor;
import com.pomplatform.client.ja.ht2.datasource.DSOutDesignConsideration;
import com.pomplatform.client.ja.ht2.form.OutDesignConsiderationViewer;

public class SformalcontractcccorViewer extends AbstractDetailViewer
{


	private SearchForm __parentSearchForm;
	private final DelicacyListGrid outDesignConsiderationsGrid = new DelicacyListGrid();

	public SformalcontractcccorViewer() {
	}

	@Override
	public void initComponents() {
		super.initComponents();
		outDesignConsiderationsGrid.setDataSource(DSOutDesignConsideration.getInstance());
		outDesignConsiderationsGrid.addDoubleClickHandler(new DoubleClickHandler(){
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("报价单子项表");
				detail.setWidth(700); detail.setHeight(500); 
				OutDesignConsiderationViewer viewer = new OutDesignConsiderationViewer();
				viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
				viewer.initComponents();
				viewer.viewSelectedData((ListGrid)event.getSource());
				detail.setContent(viewer);
				detail.centerInPage();detail.show();
			}
		});
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "查看正式合同信息详情";
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
	public void viewSelectedData(ListGrid grid){
		super.viewSelectedData(grid);
		Record selected = grid.getSelectedRecord();
		Object val;
		java.util.Map condition = null;
		java.util.Map parentSearch = __parentSearchForm == null ? new java.util.HashMap() : __parentSearchForm.getValues();
		condition = new java.util.HashMap();
		condition.put("infoCode", "-1");
		if(!BaseHelpUtils.isNullOrEmpty(selected.getAttributeAsString("infoCode"))){
			condition.put("infoCode", selected.getAttributeAsString("infoCode"));
		}
		
		DBDataSource.callOperation("ST_OutDesignConsideration", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					outDesignConsiderationsGrid.setData(dsResponse.getData());
				}
			}
		});
	}

	@Override
	public DataSource getMainDataSource() {
		return DSSformalcontractcccor.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 1;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(outDesignConsiderationsGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("报价单子项表");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}


}

