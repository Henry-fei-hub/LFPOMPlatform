package com.pomplatform.client.purchase.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;

public class SupplierAppraiseDetialViewPanel extends HLayout implements HasHandlers {

	private Window parentWindow;
	public static DelicacyListGrid grid;
	public void initComponents() {
		setWidth("98%");
		setHeight100();
		setPadding(10);
		setMembersMargin(5);
		grid = new DelicacyListGrid();
		grid.setAutoFitFieldWidths(false);
		grid.setShowRowNumbers(true);
		grid.setHeight100();
		grid.setWidth100();
        ListGridField[] ciFields = new ListGridField[3];
        int ciIdx = 0;
        ciFields[ciIdx] = new ListGridField("appraiseType","评价类型");
        ciFields[ciIdx].setValueMap(KeyValueManager.getValueMap("system_dictionary_190"));
        ciFields[ciIdx].setWidth("*");
        ciIdx++;
        ciFields[ciIdx] = new ListGridField("scoreType","类型");
        ciFields[ciIdx].setValueMap(KeyValueManager.getValueMap("supplier_score_records"));
        ciFields[ciIdx].setWidth("*");
        ciIdx++;
		ciFields[ciIdx] = new ListGridField("score","分数");
		ciFields[ciIdx].setWidth("*");
		grid.setFields(ciFields);
		addMember(grid);
	}

	/**
	 * 加载页面时加载该方法
	 * 
	 */
	public void load(int supplierAppraiseId) {
		Map<String,Object> params = new HashMap<>();
		//加载联系人信息
		params.put("supplierAppraiseId",supplierAppraiseId);
		params.put("addtionalCondition","order by supplier_appraise_detail_id desc");
		DBDataSource.callOperation("ST_SupplierAppraiseDetail", "find", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] datas = dsResponse.getData();
					grid.setData(datas);
				}
			}
		});
	}

	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

	@Override	
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

}
