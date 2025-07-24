package com.pomplatform.client.purchase.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.pomplatform.client.purchase.datasource.DSPurchaseContractWithPp;
import com.pomplatform.client.purchase.datasource.DSPurchasePayment;
import com.pomplatform.client.purchase.datasource.DSPurchaseProductDetail;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.viewer.DetailViewer;

public class PurchaseContractWithPpViewer extends AbstractDetailViewer {

	private final DelicacyListGrid purchasePaymentsGrid = new DelicacyListGrid();
	private final DelicacyListGrid purchaseProductDetailsGrid = new DelicacyListGrid();
	private SearchForm __parentSearchForm;

	public PurchaseContractWithPpViewer() {
	}

	@Override
	public void initComponents() {
		super.initComponents();
		purchasePaymentsGrid.setDataSource(DSPurchasePayment.getInstance());
		purchasePaymentsGrid.setShowGridSummary(true);
		purchasePaymentsGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("采购付款详情表");
				detail.setWidth(700);
				detail.setHeight(500);
				PurchasePaymentViewer viewer = new PurchasePaymentViewer();
				viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
				viewer.initComponents();
				viewer.viewSelectedData((ListGrid) event.getSource());
				detail.setContent(viewer);
				detail.centerInPage();
				detail.show();
			}
		});
		purchaseProductDetailsGrid.setDataSource(DSPurchaseProductDetail.getInstance());
		purchaseProductDetailsGrid.setShowGridSummary(true);
		purchaseProductDetailsGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("采购申请产品详情表");
				detail.setWidth(700);
				detail.setHeight(500);
				PurchaseProductDetailViewer viewer = new PurchaseProductDetailViewer();
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
		return "采购合同";
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
		if (getBusinessId() == null)
			return;
		Map params = new HashMap();
		params.put("purchaseContractId", getBusinessId());
		DBDataSource.callOperation("NQ_PurchaseContractWithPp", "find", new DSCallback() {
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

	public void viewDetailData() {
		Record selected = getRecord();
		Object val;
		java.util.Map condition = null;
		java.util.Map parentSearch = __parentSearchForm == null ? new java.util.HashMap()
				: __parentSearchForm.getValues();
		condition = new java.util.HashMap();
		condition.put("addtionalCondition", "order by payment_date ASC ");
		condition.put("purchaseContractId", selected.getAttributeAsString("purchaseContractId"));
		DBDataSource.callOperation("ST_PurchasePayment", "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					purchasePaymentsGrid.setData(dsResponse.getData());
				}
			}
		});
		condition = new java.util.HashMap();
		condition.put("purchaseContractId", selected.getAttributeAsString("purchaseContractId"));
		DBDataSource.callOperation("ST_PurchaseProductDetail", "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					purchaseProductDetailsGrid.setData(dsResponse.getData());
				}
			}
		});
	}

	@Override
	public DataSource getMainDataSource() {
		return DSPurchaseContractWithPp.getInstance();
	}

	@Override
	public int getDetailCount() {
		return 2;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(purchasePaymentsGrid);
		res.add(purchaseProductDetailsGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("采购付款详情表");
		res.add("采购申请产品详情表");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm(SearchForm value) {
		this.__parentSearchForm = value;
	}

}
