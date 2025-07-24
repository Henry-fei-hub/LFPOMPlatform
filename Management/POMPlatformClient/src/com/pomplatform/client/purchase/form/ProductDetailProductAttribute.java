package com.pomplatform.client.purchase.form;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.purchase.datasource.DSProductAttribute;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ProductDetailProductAttribute extends AbstractWizadPage {

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(true);

	public ProductDetailProductAttribute() {

		HLayout productAttributes = new HLayout();
		productAttributes.setWidth100();
		productAttributes.setHeight100();
		grid.setDataSource(DSProductAttribute.getInstance());
		grid.setAutoFitFieldWidths(false);
		productAttributes.addMember(grid);
		VLayout productAttributesControls = new VLayout();
		productAttributesControls.setHeight100();
		productAttributesControls.setWidth(60);
		productAttributesControls.setLayoutTopMargin(30);
		productAttributesControls.setLayoutLeftMargin(5);
		productAttributesControls.setLayoutRightMargin(5);
		productAttributesControls.setMembersMargin(10);
		productAttributes.addMember(productAttributesControls);
		addMember(productAttributes);
		IButton productAttributesNewButton = new IButton("新增");
		productAttributesNewButton.setIcon("[SKIN]/actions/add.png");
		productAttributesNewButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Record record = new Record();
				record.setAttribute("createEmployeeId", ClientUtil.getEmployeeId());
				grid.startEditingNew(record);
			}
		});
		IButton productAttributesRemoveButton = new IButton("删除所有");
		productAttributesRemoveButton.setIcon("[SKIN]/actions/remove.png");
		productAttributesRemoveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				grid.setData(new RecordList());
			}
		});
		productAttributesControls.addMember(productAttributesNewButton);
		productAttributesControls.addMember(productAttributesRemoveButton);
	}

	@Override
	public void startEdit() {
		if (getPageMode() != PAGE_MODE_UPDATE)
			return;
		reloadDetailTableData();
	}

	public void reloadDetailTableData() {
		Map condition = new HashMap();
		condition.put("productId", getRecord().getAttribute("productId"));
		DBDataSource.callOperation("ST_ProductAttribute", "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					if (__startLoadedDetail != null)
						__startLoadedDetail.execute(dsResponse, data, dsRequest);
					grid.setData(dsResponse.getData());
					if (__endLoadedDetail != null)
						__endLoadedDetail.execute(dsResponse, data, dsRequest);
				}
			}
		});
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("detailProductAttribute");
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
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailProductAttribute");
		return param;
	}

	@Override
	public String getName() {
		return "产品属性表";
	}

	public DSCallback getStartLoadedDetail() {
		return this.__startLoadedDetail;
	}

	public void setStartLoadedDetail(DSCallback value) {
		this.__startLoadedDetail = value;
	}

	public DSCallback getEndLoadedDetail() {
		return this.__endLoadedDetail;
	}

	public void setEndLoadedDetail(DSCallback value) {
		this.__endLoadedDetail = value;
	}

	public DelicacyListGrid getGrid() {
		return this.grid;
	}

	public void setGrid(DelicacyListGrid value) {
		this.grid = value;
	}

}
