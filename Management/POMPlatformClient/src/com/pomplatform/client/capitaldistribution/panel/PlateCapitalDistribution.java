package com.pomplatform.client.capitaldistribution.panel;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.print.attribute.standard.MediaSize.ISO;

import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.pomplatform.client.capitaldistribution.datasource.DSPlateCapitalDistribution;
import com.pomplatform.client.common.ClientStaticUtils;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SummaryFunctionType;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class PlateCapitalDistribution extends VLayout{

	private HLayout gridLayout;
	private DelicacyListGrid grid;
	private VLayout gridButtonLayout;
	
	private DynamicForm form;
	private TextAreaItem remarkItem;
	
	private ToolStrip navLayout;
	
	private Window parent;
	
	private Record record;
	private String capitalId;
	
	private String departmentType = "2";
	protected final HandlerManager handlerManager = new HandlerManager(this);

	private static final Logger logger = Logger.getLogger("");
	
	public void initComponents(){
		setWidth100();
		setHeight100();
		
		//初始化最上面的列表数据面板
		gridLayout = new HLayout();
		gridLayout.setWidth100();
		gridLayout.setHeight("85%");
		gridLayout.setBorder("1px solid #ababab");
		
		grid = new DelicacyListGrid();
		grid.setShowRowNumbers(true);
		grid.setDataSource(DSPlateCapitalDistribution.getInstance());
		grid.setAutoFitFieldWidths(false);
		grid.setWidth("85%");
		
		ListGridField[] fields = new ListGridField[3];
		int idx = 0;
		fields[idx] = new ListGridField("plateId");
		fields[idx++].setShowGridSummary(false);
		fields[idx] = new ListGridField("totalAmount");
		fields[idx++].setSummaryFunction(SummaryFunctionType.MAX);
		fields[idx++] = new ListGridField("distributionAmount");
		grid.setFields(fields);
		grid.setShowGridSummary(true);
		grid.setCanEdit(true);
		
		IButton createButton = new IButton("新增");
		createButton.setWidth100();
		createButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				int rowNum = grid.getRecords().length;
				Record newRecord = new Record();
				newRecord = record.copyAttributes(record, "type","contractId","capitalId","totalAmount","operator");
				grid.addData(newRecord);
				grid.startEditing(rowNum);
			}
		});
		
		IButton deleteButton = new IButton("删除");
		deleteButton.setWidth100();
		deleteButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(grid.anySelected()){
					ListGridRecord selected = grid.getSelectedRecords()[0];
					if(selected.getAttribute("type").equals(departmentType)){
						SC.say("订单分配产生的数据，无法删除");
					}else{
						grid.removeData(grid.getSelectedRecords()[0]);
					}
				}
			}
		});
		
		IButton deleteAllButton = new IButton("删除所有");
		deleteAllButton.setWidth100();
		deleteAllButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] records = grid.getRecords();
				boolean isOkToDelete = true;
				for(ListGridRecord record : records){
					if(record.getAttribute("").equals(departmentType)){
						isOkToDelete = false;
						break;
					}
				}
				if(isOkToDelete){
					grid.setData(new Record[0]);
				}else{
					SC.say("包含订单分配产生的数据，无法删除所有数据");
				}
			}
		});
		
		gridButtonLayout = new VLayout();
		gridButtonLayout.setWidth("15%");
		gridButtonLayout.setHeight100();
		gridButtonLayout.setMembersMargin(20);
		gridButtonLayout.setLayoutTopMargin(20);
		gridButtonLayout.setLayoutLeftMargin(20);
		gridButtonLayout.setLayoutRightMargin(20);
		gridButtonLayout.addMembers(createButton, deleteButton, deleteAllButton);
		
		gridLayout.addMembers(grid, gridButtonLayout);
		
		addMember(gridLayout);
		
		form = new DynamicForm();
		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setColSpan(2);
		remarkItem.setRowSpan(2);
		remarkItem.setWidth("*");
		remarkItem.setTitleOrientation(TitleOrientation.TOP);
		form.setItems(remarkItem);
		addMember(form);
		
		IButton sureButton = new IButton("确定");
		sureButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(checkData()){
							Map params = new HashMap<>();
							MapUtils.convertRecordToMap(grid.getDataSource(), grid.getRecords(), params,
									"details");
							params.put("remark", remarkItem.getValue());
							params.put("type", 1);
							params.put("capitalId", capitalId);
							params.put("optType", "saveCapitalDistribution");
							DBDataSource.callOperation("EP_CapitalDistributionProcessor", params, new DSCallback() {
								
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if(dsResponse.getStatus() >= 0){
										DataEditEvent dee = new DataEditEvent();
										dee.setData(new Record());
										fireEvent(dee);
										if(null == getParent()){
											return;
										}
										getParent().destroy();
									}else{
										ClientUtil.displayErrorMessage(dsResponse);
									}
								}
							});
						}
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
				
			}
		});
		
		IButton cancelButton = new IButton("取消");
		cancelButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(null == getParent()){
							return;
						}
						getParent().destroy();
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		
		navLayout = new ToolStrip();
		navLayout.setPadding(5);
		navLayout.setHeight(40);
		navLayout.setWidth100();
		navLayout.addFill();
		navLayout.setBackgroundColor("#f60");
		navLayout.setBorder("none");
		navLayout.setMembersMargin(15);
		navLayout.addMembers(sureButton, cancelButton);
		
		addMember(navLayout);	
	}

	public void startEdit(){
		Map<String, Object> params = new HashMap<>();
		params.put("type", 1);
		params.put("capitalId", record.getAttribute("capitalId"));
		params.put("deleteFlag", ClientStaticUtils.NO_DELETE);
		DBDataSource.callOperation("ST_CapitalDistribution", "find", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				grid.setData(dsResponse.getData());
			}
		});
	}
	
	public boolean checkData(){
		Record[] records = grid.getRecords();
		if(null != records && records.length > 0){
			Map<String,Integer> idMap = new HashMap<>();
			BigDecimal total = new BigDecimal(records[0].getAttribute("totalAmount"));
			BigDecimal distribution = BigDecimal.ZERO;
			for(Record record : records){
				String id = record.getAttribute("plateId");
				if(null != id && !id.equals("")){
					idMap.put(id, 1);
				}else{
					SC.say("请选择回款分配的部门");
					return false;
				}
				if(null != record.getAttribute("distributionAmount")){
					distribution = distribution.add(new BigDecimal(record.getAttribute("distributionAmount")));
				}
			}
			if(records.length != idMap.keySet().size()){
				SC.say("参与回款分配的部门中，有重复的数据，请仔细检查");
				return false;
			}
			if(total.compareTo(distribution) != 0){
				SC.say("分配前后的金额不一致，请重新分配");
				return false;
			}
//			if(null == remarkItem.getValue()){
//				SC.say("备注不能为空");
//				return false;
//			}
		}
		return true;
	}
	
	public Window getParent() {
		return parent;
	}
	public void setParent(Window parent) {
		this.parent = parent;
	}
	
	public String getCapitalId() {
		return capitalId;
	}

	public void setCapitalId(String capitalId) {
		this.capitalId = capitalId;
	}

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
		this.record.setAttribute("type", 1);
		this.record.setAttribute("operator", ClientUtil.getUserId());
		if(null == record.getAttributeAsObject("totalAmount")){
			this.record.setAttribute("totalAmount", record.getAttribute("borrowMoney"));
		}
		setCapitalId(record.getAttribute("capitalId"));
	}
	
	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}
	
	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}
}
