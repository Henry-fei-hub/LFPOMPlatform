package com.pomplatform.client.revenuecapitalsinfo.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.aboutrevenueamount.datasource.DSAboutRevenueAmount;
import com.pomplatform.client.revenuecapitalsinfo.datasource.DSRevenueCapitalsInfo;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.viewer.DetailViewer;

public class RevenueCapitalsInfoViewer extends AbstractDetailViewer
{

	private static final Logger __LOGGER = Logger.getLogger("");
	private SearchForm __parentSearchForm;
	private DelicacyListGrid grid;


	public RevenueCapitalsInfoViewer() {
	}

	@Override
	public void initComponents() {
		//super.initComponents();
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "RevenueCapitalsInfo";
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
		DBDataSource.callOperation("NQ_RevenueCapitalsInfo", "find", new DSCallback() {
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
		Record record=getRecord();
		grid = new DelicacyListGrid();
		ListGridField[] fieldss = new ListGridField[4];
		int idxs = 0;
		fieldss[idxs] = new ListGridField("contractId");
		fieldss[idxs].setCanEdit(false);
		fieldss[idxs].setHidden(true);
		idxs ++;
		fieldss[idxs] = new ListGridField("contractCode");
		fieldss[idxs].setCanEdit(false);
		idxs ++;
		fieldss[idxs] = new ListGridField("contractName");
		fieldss[idxs].setCanEdit(false);
		idxs ++;
		fieldss[idxs] = new ListGridField("customerName");
		fieldss[idxs].setCanEdit(false);
		idxs ++;
		fieldss[idxs] = new ListGridField("year");
		fieldss[idxs].setCanEdit(false);
		idxs ++;
		fieldss[idxs] = new ListGridField("month");
		fieldss[idxs].setCanEdit(false);
		idxs ++;
		fieldss[idxs] = new ListGridField("capitalAmount");
		fieldss[idxs].setCanEdit(false);
		fieldss[idxs].setAlign(Alignment.RIGHT);
		fieldss[idxs].setType(ListGridFieldType.FLOAT);
		fieldss[idxs].setFormat("##,###,###,###,##0.00");
		idxs ++;
		fieldss[idxs] = new ListGridField("revenueAmount");
		fieldss[idxs].setCanEdit(false);
		fieldss[idxs].setType(ListGridFieldType.FLOAT);
		fieldss[idxs].setFormat("##,###,###,###,##0.00");
		idxs ++;
		fieldss[idxs] = new ListGridField("isTrue");
		fieldss[idxs].setAlign(Alignment.CENTER);
		fieldss[idxs].setWidth("15%");
		fieldss[idxs].setCanEdit(false);
		idxs ++;
		fieldss[idxs] = new ListGridField("operateEmployeeId");
		KeyValueManager.loadValueMap("employees", fieldss[idxs]);
		fieldss[idxs].setCanEdit(false);
		idxs ++;
		fieldss[idxs] = new ListGridField("operateTime");
		fieldss[idxs].setCanEdit(false);
		fieldss[idxs].setAutoFitWidth(true);
		grid.setDataSource(DSAboutRevenueAmount.getInstance());
		grid.setFields(fieldss);
		grid.setAutoFitFieldWidths(false);
		grid.setCanEdit(false);
		grid.setSelectionType(SelectionStyle.SINGLE);
		grid.setHeight100();
		grid.setWidth100();
		addMember(grid);
		int contractId=BaseHelpUtils.getIntValue(record.getAttribute("contractId"));
		Map<String,Object> map=new HashMap<>();
		map.put("contractId", contractId);
		DBDataSource.callOperation("NQ_AboutRevenueAmount",  map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					grid.setData(dsResponse.getData());
				}
			}
		});
	}

	@Override
	public DataSource getMainDataSource() {
		return DSRevenueCapitalsInfo.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 0;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}


}

