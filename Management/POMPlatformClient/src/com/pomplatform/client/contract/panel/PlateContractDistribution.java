package com.pomplatform.client.contract.panel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.contract.datasource.DSCustomContractDistribution;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SummaryFunctionType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class PlateContractDistribution extends VLayout{

	private HLayout gridLayout;
	private DelicacyListGrid grid;
	private VLayout gridButtonLayout;
	
//	private DynamicForm form;
//	private TextAreaItem remarkItem;
	
	private ToolStrip navLayout;
	
	private Window parent;
	
	private Record record;

	protected final HandlerManager handlerManager = new HandlerManager(this);
	private static final Logger logger = Logger.getLogger("");
	
	public void initComponents(){
		setWidth100();
		setHeight100();
		
		//初始化最上面的列表数据面板
		gridLayout = new HLayout();
		gridLayout.setWidth100();
		gridLayout.setHeight("90%");
		gridLayout.setBorder("1px solid #ababab");
		
		grid = new DelicacyListGrid();
//		grid = new DelicacyListGrid(){
//			@Override
//			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
//				//分配超标显示红色
//				if (null != record.getAttribute("leftAmount") && new BigDecimal(record.getAttribute("leftAmount")).compareTo(BigDecimal.ZERO) < 0) {
//					return "color:#FF0000;";  
//                } else {
//                	return super.getCellCSSText(record, rowNum, colNum); 
//                }
//			}
//		};
		grid.setShowRowNumbers(true);
		grid.setDataSource(DSCustomContractDistribution.getInstance());
		grid.setAutoFitFieldWidths(false);
		grid.setWidth("90%");
		
		ListGridField[] fields = new ListGridField[7];
		int idx = 0;
		fields[idx] = new ListGridField("contractId2", "合同编号");
//		fields[idx].setValueMap(KeyValueManager.getValueMap("contracts_2"));
		KeyValueManager.loadValueMap("contracts_2", fields[idx]);
		fields[idx++].setShowGridSummary(false);
		fields[idx] = new ListGridField("contractId", "合同名称");
		fields[idx++].setShowGridSummary(false);
		fields[idx] = new ListGridField("signingMoneySum", "签约总金额");
		fields[idx++].setSummaryFunction(SummaryFunctionType.MAX);
		fields[idx] = new ListGridField("actualMoney", "分配金额");
		fields[idx++].setShowGridSummary(false);
		fields[idx] = new ListGridField("businessType");
		fields[idx++].setShowGridSummary(false);
		fields[idx] = new ListGridField("plateId");
		fields[idx++].setShowGridSummary(false);
		fields[idx] = new ListGridField("amount");
		grid.setFields(fields);
		grid.setShowGridSummary(true);
		grid.setCanEdit(true);
		grid.addEditCompleteHandler(new EditCompleteHandler() {
			
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				if(null != event.getNewValues()){
					Map map = event.getNewValues();
					Record record = grid.getRecord(event.getRowNum());
					record.setAttribute("operator", ClientUtil.getUserId());
					if(map.containsKey("actualMoney")){
						getRecord().setAttribute("actualMoney", map.get("actualMoney"));
					}
					if(map.containsKey("plateId") || map.containsKey("actualMoney")){
						Map<String, Object> params = new HashMap<>();
						params.put("optType", "calculateAmount");
						params.put("contractId", record.getAttributeAsObject("contractId"));
						params.put("businessType", record.getAttributeAsObject("businessType"));
						if(map.containsKey("actualMoney")){
							params.put("actualMoney", map.get("actualMoney"));
						}else{
							params.put("actualMoney", record.getAttributeAsObject("actualMoney"));
						}
						if(map.containsKey("plateId")){
							params.put("plateId", map.get("plateId"));
						}else{
							params.put("plateId", record.getAttributeAsObject("plateId"));
						}
						DBDataSource.callOperation("EP_ContractDistributionProcessor", params, new DSCallback() {
							
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if(dsResponse.getStatus() >= 0){
									record.setAttribute("amount", dsResponse.getErrors().get("errorMsg").toString().replace("[", "").replace("]", ""));
									grid.updateData(record);
								}
							}
						});
					}
				}
			}
		});

		IButton createButton = new IButton("新增");
		createButton.setWidth100();
		createButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				int rowNum = grid.getRecords().length;
				Record newRecord = new Record();
				newRecord = record.copyAttributes(record, "contractId","contractId2","businessType","signingMoneySum","actualMoney","operator","contractDate");
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
					grid.removeData(grid.getSelectedRecords()[0]);
				}
			}
		});
		
		IButton deleteAllButton = new IButton("删除所有");
		deleteAllButton.setWidth100();
		deleteAllButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				grid.setData(new Record[0]);
			}
		});
		
		
		gridButtonLayout = new VLayout();
		gridButtonLayout.setWidth("10%");
		gridButtonLayout.setHeight100();
		gridButtonLayout.setMembersMargin(20);
		gridButtonLayout.setLayoutTopMargin(20);
		gridButtonLayout.setLayoutLeftMargin(20);
		gridButtonLayout.setLayoutRightMargin(20);
		gridButtonLayout.addMembers(createButton, deleteButton, deleteAllButton);
		
		gridLayout.addMembers(grid, gridButtonLayout);
		
		addMember(gridLayout);
		
//		form = new DynamicForm();
//		remarkItem = new TextAreaItem("remark", "备注");
//		remarkItem.setColSpan(2);
//		remarkItem.setRowSpan(2);
//		remarkItem.setWidth("*");
//		remarkItem.setTitleOrientation(TitleOrientation.TOP);
//		form.setItems(remarkItem);
//		addMember(form);
		
		
		IButton sureButton = new IButton("确定");
		sureButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				sureButton.setDisabled(true);
				if(checkData()){
					saveData();
				}else{
					sureButton.setDisabled(false);
				}
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

	public Window getParent() {
		return parent;
	}
	public void setParent(Window parent) {
		this.parent = parent;
	}
	
	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}
	
	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	public void startEdit(){
		if(null != record){
			Map<String, Object> params = new HashMap<>();
			params.put("contractId", record.getAttribute("contractId"));
			params.put("deleteFlag", ClientStaticUtils.NO_DELETE);
			DBDataSource.callOperation("ST_ContractDistribution", "find", params, new DSCallback() {
				
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0){
						Record[] records = dsResponse.getData();
						for(Record obj : records){
							obj.setAttribute("contractId2", obj.getAttributeAsObject("contractId"));
							obj.setAttribute("signingMoneySum", record.getAttributeAsObject("signingMoneySum"));
						}
						grid.setData(records);
					}
				}
			});
		}
	}

	public boolean checkData(){
		Record[] records = grid.getRecords();
		if(null != records && records.length > 0){
			Set<Integer> set = new HashSet<>();
			for(Record record : records){
				int plateId = ClientUtil.checkAndGetIntValue(record.getAttributeAsObject("plateId"));
				if(plateId > 0){
					set.add(plateId);
				}else{
					SC.say("营销团队选择有误");
					return false;
				}
			}
			if(set.size() != records.length){
				SC.say("营销团队选择重复");
				return false;
			}
		}
		return true;
	}
	
	public void saveData(){
		Map params = new HashMap<>();
		MapUtils.convertRecordToMap(grid.getDataSource(), grid.getRecords(), params,
				"details");
		params.put("optType", "saveContractDistribution");
		params.put("contractId", record.getAttribute("contractId"));
		params.put("businessType", record.getAttribute("businessType"));
		params.put("operator", ClientUtil.getUserId());
		DBDataSource.callOperation("EP_ContractDistributionProcessor", params, new DSCallback() {
			
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
