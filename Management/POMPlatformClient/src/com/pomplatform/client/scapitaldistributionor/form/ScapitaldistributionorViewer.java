package com.pomplatform.client.scapitaldistributionor.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.pomplatform.client.scapitaldistributionor.datasource.DSCapitalDistributionLinkDepartment;
import com.pomplatform.client.scapitaldistributionor.datasource.DSCapitalDistributionLinkSubContract;
import com.pomplatform.client.scapitaldistributionor.datasource.DSScapitaldistributionor;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.viewer.DetailViewer;

public class ScapitaldistributionorViewer extends AbstractDetailViewer {

	private final DelicacyListGrid capitalDistributionLinkDepartmentsGrid = new DelicacyListGrid();
	private final DelicacyListGrid capitalDistributionLinkSubContractsGrid = new DelicacyListGrid();
	private SearchForm __parentSearchForm;

	public ScapitaldistributionorViewer() {
	}

	@Override
	public void initComponents() {
		super.initComponents();
		capitalDistributionLinkDepartmentsGrid.setDataSource(DSCapitalDistributionLinkDepartment.getInstance());
		capitalDistributionLinkDepartmentsGrid.setShowGridSummary(true);
		capitalDistributionLinkDepartmentsGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("");
				detail.setWidth(700);
				detail.setHeight(500);
				CapitalDistributionLinkDepartmentViewer viewer = new CapitalDistributionLinkDepartmentViewer();
				viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
				viewer.initComponents();
				viewer.viewSelectedData((ListGrid) event.getSource());
				detail.setContent(viewer);
				detail.centerInPage();
				detail.show();
			}
		});
		capitalDistributionLinkSubContractsGrid.setDataSource(DSCapitalDistributionLinkSubContract.getInstance());
		ListGridField subContractIdField = new ListGridField("subContractId");
		subContractIdField.setShowGridSummary(false);
		ListGridField moneyField = new ListGridField("money");
		ListGridField codeField = new ListGridField("code", "编号");
		codeField.setShowGridSummary(false);
//		codeField.setValueMap(KeyValueManager.getValueMap("project_contract_codes"));
		KeyValueManager.loadValueMap("project_contract_codes", codeField);
		capitalDistributionLinkSubContractsGrid.setFields(subContractIdField, codeField, moneyField);
		capitalDistributionLinkSubContractsGrid.setShowGridSummary(true);
		capitalDistributionLinkSubContractsGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("");
				detail.setWidth(700);
				detail.setHeight(500);
				CapitalDistributionLinkSubContractViewer viewer = new CapitalDistributionLinkSubContractViewer();
				viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
				viewer.initComponents();
				viewer.viewSelectedData((ListGrid) event.getSource());
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
		return "Scapitaldistributionor";
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void load() {
		if (getBusinessId() == null)
			return;
		Map params = new HashMap();
		params.put("capitalDistributionId", getBusinessId());
		DBDataSource.callOperation("NQ_Scapitaldistributionor", "find", new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					for (DetailViewer v : detailViewers) {
						v.setData(dsResponse.getData());
						if (dsResponse.getData().length == 0)
							continue;
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
	public void viewSelectedData(ListGrid grid) {
		super.viewSelectedData(grid);
		setRecord(grid.getSelectedRecord());
		viewDetailData();
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public void viewDetailData() {
		Record selected = getRecord();
		Object val;
		java.util.Map condition = null;
		java.util.Map parentSearch = __parentSearchForm == null ? new java.util.HashMap()
				: __parentSearchForm.getValues();
		condition = new java.util.HashMap();
		condition.put("capitalDistributionId", selected.getAttributeAsString("capitalDistributionId"));
		DBDataSource.callOperation("ST_CapitalDistributionLinkDepartment", "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					capitalDistributionLinkDepartmentsGrid.setData(dsResponse.getData());
				}
			}
		});
		condition = new java.util.HashMap();
		condition.put("capitalDistributionId", selected.getAttributeAsString("capitalDistributionId"));
		DBDataSource.callOperation("ST_CapitalDistributionLinkSubContract", "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record [] record = dsResponse.getData();
					for (Record record2 : record) {
						record2.setAttribute("code", record2.getAttribute("subContractId"));
					}
					capitalDistributionLinkSubContractsGrid.setData(record);
				}
			}
		});
	}

	@Override
	public DataSource getMainDataSource() {
		return DSScapitaldistributionor.getInstance();
	}

	@Override
	public int getDetailCount() {
		return 2;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(capitalDistributionLinkDepartmentsGrid);
		res.add(capitalDistributionLinkSubContractsGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("分配给部门");
		res.add("分配给订单");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm(SearchForm value) {
		this.__parentSearchForm = value;
	}

}
