package com.pomplatform.client.check.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import java.util.ArrayList;
import java.util.List;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.data.*;
import com.delicacy.client.data.GroupColumn;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.check.datasource.DSCheckInOutEmployee;
import com.pomplatform.client.check.datasource.DSSemployeemonthlycheckymor;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import java.util.HashMap;
import java.util.Map;

public class SemployeemonthlycheckymorViewer extends AbstractDetailViewer {

	private SearchForm __parentSearchForm;
	private final DelicacyListGrid detail = new DelicacyListGrid();

	public SemployeemonthlycheckymorViewer() {
	}

	@Override
	public void initComponents() {
		super.initComponents();
	}

	@Override
	public int getHorizontalPercent() {
		return 37;
	}

	@Override
	public String getName() {
		return "本月考勤汇总";
	}

	@Override
	public int getGroupCount() {
		return 0;
	}

	@Override
	public List<GroupColumn> getGroupColumnNames() {
		List<GroupColumn> gcs = new ArrayList<>();
		return gcs;
	}

	@Override
	public void viewSelectedData(ListGrid grid) {
		super.viewSelectedData(grid);
		ListGridRecord r = grid.getSelectedRecord();
		FormItem yearItem = getParentSearchForm().getItem("year");
		FormItem monthItem = getParentSearchForm().getItem("month");
		int year = ClientUtil.checkAndGetIntValue(yearItem.getValue());
		int month = ClientUtil.checkAndGetIntValue(monthItem.getValue());
		int employeeId = r.getAttributeAsInt("employeeId");
		Map params = new HashMap();
		params.put("employeeId", employeeId);
		params.put("year", year);
		params.put("month", month);
		DBDataSource.callOperation("EP_EmployeeCheckDetail", params, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				detail.setData(dsResponse.getData());
			}
			
		});
		
	}

	@Override
	public DataSource getMainDataSource() {
		return DSSemployeemonthlycheckymor.getInstance();
	}

	@Override
	public int getDetailCount() {
		return 1;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<>();
		detail.setDataSource(DSCheckInOutEmployee.getInstance());
		res.add(detail);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<>();
		res.add("考勤明细");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm(SearchForm value) {
		this.__parentSearchForm = value;
	}

}
