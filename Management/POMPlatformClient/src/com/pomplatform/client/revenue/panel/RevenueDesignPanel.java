package com.pomplatform.client.revenue.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.revenue.datasource.DSRevenueDesign;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class RevenueDesignPanel extends HLayout implements HasHandlers {
	private static Logger __logger = Logger.getLogger("");
	// 定义面板样式
	private final String layoutGroupStyle = "2px solid #555555;border-top-width:22px;border-radius:5px;";
	public final static String BORDER_STYLE = "2px solid #f2f2f2;border-radius:8px;";
	// 定义整个面板的layout,整个面板分头部面板和中心面板
	private VLayout mainLayout;
	private DelicacyListGrid oldGrid;
	private DelicacyListGrid newGrid;
	private DelicacyListGrid breakGrid;
	private HLayout buttonLayout;

	public void initComponents() {
		mainLayout = new VLayout();
		mainLayout.setBackgroundColor("#FFF");
		mainLayout.setBorder("2px solid #e2e2e2;border-radius:5px");
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		addMember(mainLayout);
		
		oldGrid = new DelicacyListGrid();
		ListGridField[] fields = new ListGridField[12];
		int idx = 0;
		fields[idx] = new ListGridField("projectId");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("plateId");
		idx++;
		fields[idx] = new ListGridField("sheetCode");
		idx++;
		fields[idx] = new ListGridField("sheetName");
		idx++;
		fields[idx] = new ListGridField("year");
		idx++;
		fields[idx] = new ListGridField("month");
		idx++;
		fields[idx] = new ListGridField("sheetAmount");
		idx++;
		fields[idx] = new ListGridField("totalPercent");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("totalPercentStr");
		idx++;
		fields[idx] = new ListGridField("totalTaxRevenue");
		idx++;
		fields[idx] = new ListGridField("totalRevenue");
		idx++;
		fields[idx] = new ListGridField("currentRevenue");
		idx++;
		oldGrid.setFields(fields);
		oldGrid.setHeight("30%");
		oldGrid.setAutoFitFieldWidths(false);
		oldGrid.setDataSource(DSRevenueDesign.getInstance());
		oldGrid.setShowGridSummary(false);
		oldGrid.setHeaderHeight(60);
		oldGrid.setHeaderSpans(new HeaderSpan[] { new HeaderSpan("拆分前", new String[] { 
		"projectId", "plateId", "sheetCode", "sheetName","year", "month", "sheetAmount", "totalPercent", "totalPercentStr","totalTaxRevenue", "totalRevenue","currentRevenue" }) });
		mainLayout.addMember(oldGrid);
		
		newGrid = new DelicacyListGrid();
		ListGridField[] newFields = new ListGridField[12];
		int newIdx = 0;
		newFields[newIdx] = new ListGridField("projectId");
		newFields[newIdx].setHidden(true);
		newIdx++;
		newFields[newIdx] = new ListGridField("plateId");
		newIdx++;
		newFields[newIdx] = new ListGridField("sheetCode");
		newIdx++;
		newFields[newIdx] = new ListGridField("sheetName");
		newIdx++;
		newFields[newIdx] = new ListGridField("year");
		newIdx++;
		newFields[newIdx] = new ListGridField("month");
		newIdx++;
		newFields[newIdx] = new ListGridField("sheetAmount");
		newIdx++;
		newFields[newIdx] = new ListGridField("totalPercent");
		newFields[newIdx].setHidden(true);
		newIdx++;
		newFields[newIdx] = new ListGridField("totalPercentStr");
		newIdx++;
		newFields[newIdx] = new ListGridField("totalTaxRevenue");
		newIdx++;
		newFields[newIdx] = new ListGridField("totalRevenue");
		newIdx++;
		newFields[newIdx] = new ListGridField("currentRevenue");
		newIdx++;
		newGrid.setFields(newFields);
		newGrid.setHeight("30%");
		newGrid.setAutoFitFieldWidths(false);
		newGrid.setDataSource(DSRevenueDesign.getInstance());
		newGrid.setShowGridSummary(false);
		newGrid.setHeaderHeight(60);
		newGrid.setHeaderSpans(new HeaderSpan[] { new HeaderSpan("拆分后", new String[] { 
		"projectId", "plateId", "sheetCode", "sheetName","year", "month", "sheetAmount", "totalPercent", "totalPercentStr","totalTaxRevenue", "totalRevenue","currentRevenue" }) });
		mainLayout.addMember(newGrid);
		
		breakGrid = new DelicacyListGrid();
		ListGridField[] breakFields = new ListGridField[10];
		int breakIdx = 0;
		breakFields[breakIdx] = new ListGridField("projectId");
		breakFields[breakIdx].setHidden(true);
		breakIdx++;
		breakFields[breakIdx] = new ListGridField("plateId");
		breakIdx++;
		breakFields[breakIdx] = new ListGridField("sheetCode");
		breakIdx++;
		breakFields[breakIdx] = new ListGridField("sheetName");
		breakIdx++;
		breakFields[breakIdx] = new ListGridField("year");
		breakIdx++;
		breakFields[breakIdx] = new ListGridField("month");
		breakIdx++;
		breakFields[breakIdx] = new ListGridField("sheetAmount");
		breakIdx++;
		breakFields[breakIdx] = new ListGridField("totalPercent");
		breakFields[breakIdx].setHidden(true);
		breakIdx++;
		breakFields[breakIdx] = new ListGridField("totalPercentStr");
		breakIdx++;
		breakFields[breakIdx] = new ListGridField("totalTaxRevenue");
		breakIdx++;
		breakFields[breakIdx] = new ListGridField("totalRevenue");
		breakIdx++;
		breakFields[breakIdx] = new ListGridField("currentRevenue");
		breakIdx++;
		breakGrid.setFields(breakFields);
		breakGrid.setHeight("30%");
		breakGrid.setAutoFitFieldWidths(false);
		breakGrid.setDataSource(DSRevenueDesign.getInstance());
		breakGrid.setShowGridSummary(false);
		breakGrid.setHeaderHeight(60);
		breakGrid.setHeaderSpans(new HeaderSpan[] { new HeaderSpan("拆分订单", new String[] { 
		"projectId", "plateId", "sheetCode", "sheetName","year", "month", "sheetAmount", "totalPercent", "totalPercentStr","totalTaxRevenue", "totalRevenue","currentRevenue" }) });
		mainLayout.addMember(breakGrid);
		
		buttonLayout = new HLayout(10);
		buttonLayout.setHeight("10%");
		buttonLayout.setLayoutTopMargin(30);
		buttonLayout.setLayoutLeftMargin(20);
		IButton saveButton = new IButton("保存");
		IButton cancelButton = new IButton("取消");
		buttonLayout.addMember(saveButton);
		buttonLayout.addMember(cancelButton);
		mainLayout.addMember(buttonLayout);
		
		cancelButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (getParentWindow() == null) {
					return;
				}
				getParentWindow().destroy();
				DataEditEvent dee = new DataEditEvent();
				fireEvent(dee);
			}
		});
		
		saveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				//获取项目ID
				int projectId = BaseHelpUtils.getIntValue(record.getAttribute("projectId"));
				if(projectId == 0){
					SC.say("提示","获取订单失败");
					return;
				}
				Record newRecord = newGrid.getRecords()[0];
				if(BaseHelpUtils.isNullOrEmpty(newRecord)){
					return;
				}
				BigDecimal newSheetAmount = BaseHelpUtils.getBigDecimalValue(newRecord.getAttribute("sheetAmount"));
				if(newSheetAmount.compareTo(BigDecimal.ZERO) == 0){
					SC.say("提示","拆分后的订单金额为0,无需进行拆分");
					return;
				}
				Record breakRecord = breakGrid.getRecords()[0];
				if(BaseHelpUtils.isNullOrEmpty(breakRecord)){
					return;
				}
				BigDecimal breakSheetAmount = BaseHelpUtils.getBigDecimalValue(breakRecord.getAttribute("sheetAmount"));
				if(breakSheetAmount.compareTo(BigDecimal.ZERO) == 0){
					SC.say("提示","拆分的订单金额为0,无需进行拆分");
					return;
				}
				Map<String,Object> params = new HashMap<>();
				params.put("optType","onSheetBreak");
				params.put("projectId",projectId);
				params.put("sheetAmount",newSheetAmount);
				MapUtils.convertRecordToMap(breakGrid.getDataSource(), breakGrid.getRecords(), params, "sheetList");
				DBDataSource.callOperation("EP_OnProjectCommonProcess", params, new DSCallback() {
		            @Override
		            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
		                if (dsResponse.getStatus() >= 0) {
		                    SC.say("操作成功");
		                } else {
		                    Map errors = dsResponse.getErrors();
		                    SC.say("操作失败" + errors);
		                }
		            }
		        });
			}
		});
		
		loadData();
	}
	
	// 加载数据集
	public void loadData() {
		//拆分前订单数据封装
		Record[] oldData = new Record[1];
		oldData[0] = record;
		oldGrid.setData(oldData);
		//获取订单合同金额
		BigDecimal sheetAmount = BaseHelpUtils.getBigDecimalValue(record.getAttribute("sheetAmount"));
		//获取订单的累计营收
		BigDecimal totalTaxRevenue = BaseHelpUtils.getBigDecimalValue(record.getAttribute("totalTaxRevenue"));
		@SuppressWarnings("rawtypes")
		Map map = record.toMap();
		Record newRecord = new Record();
		Record breakRecord = new Record();
		for(Object key : map.keySet()){
			newRecord.setAttribute(key.toString(), map.get(key));
			breakRecord.setAttribute(key.toString(), map.get(key));
		}
		//拆分后订单数据封装
		Record[] newData = new Record[1];
		//设置拆分后订单的合同金额=拆分前订单合同金额-拆分前订单累计营收
		BigDecimal newSheetAmount = sheetAmount.subtract(totalTaxRevenue);
		newRecord.setAttribute("sheetAmount", newSheetAmount);
		newRecord.setAttribute("totalPercent", 0);
		newRecord.setAttribute("totalTaxRevenue", 0);
		newRecord.setAttribute("totalRevenue", 0);
		newRecord.setAttribute("currentRevenue", 0);
		newRecord.setAttribute("totalPercentStr", "0%");
		newData[0] = newRecord;
		newGrid.setData(newData);
		//拆分的订单的数据封装
		Record[] breakData = new Record[1];
		//设置拆分的订单的合同金额=拆分前订单累计营收
		BigDecimal breakSheetAmount = totalTaxRevenue;
		//设置不含税累计营收=含税累计营收/1.06
		BigDecimal totalRevenue = breakSheetAmount.divide(BigDecimal.valueOf(1.06), 2, BigDecimal.ROUND_DOWN);
		//获取订单编号
		String sheetCode = BaseHelpUtils.getString(record.getAttribute("sheetCode"));
		breakRecord.setAttribute("projectId",0);
		breakRecord.setAttribute("sheetCode",sheetCode+"/Z");
		breakRecord.setAttribute("sheetAmount", breakSheetAmount);
		breakRecord.setAttribute("totalTaxRevenue", breakSheetAmount);
		breakRecord.setAttribute("totalRevenue", totalRevenue);
		breakRecord.setAttribute("currentRevenue", totalRevenue);
		breakRecord.setAttribute("totalPercent", 1);
		breakRecord.setAttribute("totalPercentStr", "100%");
		breakData[0] = breakRecord;
		breakGrid.setData(breakData);
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
	
	private Record record;
	private PopupWindow parentWindow;

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}
	
	public PopupWindow getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(PopupWindow pw) {
		this.parentWindow = pw;
	}
}