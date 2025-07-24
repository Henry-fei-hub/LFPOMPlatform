package com.pomplatform.client.purchase.form;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
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
import com.pomplatform.client.purchase.datasource.DSPaymentTemplateWithP;
import com.pomplatform.client.purchase.datasource.DSPaymentTemplateDetail;

public class PaymentTemplateWithPViewer extends AbstractDetailViewer
{


	private final DelicacyListGrid paymentTemplateDetailsGrid = new DelicacyListGrid();
	private SearchForm __parentSearchForm;


	public PaymentTemplateWithPViewer() {
	}

	@Override
	public void initComponents() {
		super.initComponents();
		paymentTemplateDetailsGrid.setDataSource(DSPaymentTemplateDetail.getInstance());
		paymentTemplateDetailsGrid.addDoubleClickHandler(new DoubleClickHandler(){
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("付款模板详情表");
				detail.setWidth(700); detail.setHeight(500); 
				PaymentTemplateDetailViewer viewer = new PaymentTemplateDetailViewer();
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
		return "付款模板";
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
		params.put("paymentTemplateId", getBusinessId());
		DBDataSource.callOperation("NQ_PaymentTemplateWithP", "find", new DSCallback() {
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
		condition.put("paymentTemplateId", selected.getAttributeAsString("paymentTemplateId"));
		condition.put("addtionalCondition", "order by order_num");
		DBDataSource.callOperation("ST_PaymentTemplateDetail", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					paymentTemplateDetailsGrid.setData(dsResponse.getData());
				}
			}
		});
	}

	@Override
	public DataSource getMainDataSource() {
		return DSPaymentTemplateWithP.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 1;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(paymentTemplateDetailsGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("付款模板详情表");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}


}

