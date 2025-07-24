package com.pomplatform.client.capitaldistribution.panel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.pomplatform.client.capitaldistribution.datasource.DSProjectCapitalDistribution;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.project.datasource.DSGetProjects;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SummaryFunctionType;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class ProjectCapitalDistribution extends VLayout{

	private HLayout gridLayout;
	private DelicacyListGrid grid;
	private VLayout gridButtonLayout;
	
	private DynamicForm form;
	private TextAreaItem remarkItem;
	
	private ToolStrip navLayout;
	
	private Window parent;
	
	private IButton newWindowButton;
	
	private Record[] data; 
	private Record record;
	private String capitalId;

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
		
		grid = new DelicacyListGrid(){
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				//分配超标显示红色
				if (null != record.getAttribute("leftAmount") && new BigDecimal(record.getAttribute("leftAmount")).compareTo(BigDecimal.ZERO) < 0) {
					return "color:#FF0000;";  
                } else {
                	return super.getCellCSSText(record, rowNum, colNum); 
                }
			}
		};
		grid.setShowRowNumbers(true);
		grid.setDataSource(DSProjectCapitalDistribution.getInstance());
		grid.setAutoFitFieldWidths(false);
		grid.setWidth("90%");
		
		ListGridField[] fields = new ListGridField[7];
		int idx = 0;
		fields[idx] = new ListGridField("projectId");
		fields[idx++].setShowGridSummary(false);
		fields[idx] = new ListGridField("plateId");
		fields[idx++].setShowGridSummary(false);
		fields[idx] = new ListGridField("code");
		fields[idx++].setShowGridSummary(false);
		fields[idx++] = new ListGridField("sheetAmount");//订单合同金额
		fields[idx++] = new ListGridField("distributedAmount");//已分配金额
		fields[idx] = new ListGridField("totalAmount");//本次回款总金额
		fields[idx++].setSummaryFunction(SummaryFunctionType.MAX);
		fields[idx++] = new ListGridField("distributionAmount");//本次回款分配的金额
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
					record.setAttribute("createTime", new Date());
					if(map.containsKey("projectId")){
						DBDataSource.callOperation("ST_Project", "find", map, new DSCallback() {
							
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								Record bean = dsResponse.getData()[0];
								record.setAttribute("plateId", bean.getAttribute("plateId"));
								record.setAttribute("code", bean.getAttribute("contractCode"));
								record.setAttribute("sheetAmount", bean.getAttribute("sheetAmount"));
								grid.updateData(record);
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
		
		IButton autoFitButton = new IButton("自动填充");
		autoFitButton.setWidth100();
		autoFitButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!grid.anySelected()){
							SC.say("请选择需要自动填充的记录");
							return;
						}
						ListGridRecord selected = grid.getSelectedRecord();
						int rowNum = grid.getRowNum(selected);
						BigDecimal totalAmount = new BigDecimal(record.getAttribute("totalAmount"));
						Record[] records = grid.getRecords();
						for(int i = 0; i < records.length; i++){
							Record obj = records[i];
							if(rowNum != i && null != obj.getAttribute("distributionAmount")){
								totalAmount = totalAmount.subtract(new BigDecimal(obj.getAttribute("distributionAmount")));
							}
						}
						final BigDecimal distributionAmount = totalAmount;
						Map<String, Object> params = new HashMap<>();
						params.put("optType", "isOkToFit");
						params.put("distributionAmount", distributionAmount);
						params.put("projectId", selected.getAttribute("projectId"));
						params.put("contractId", selected.getAttribute("contractId"));
						DBDataSource.callOperation("EP_CapitalDistributionProcessor", params, new DSCallback() {
							
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if(dsResponse.getStatus() >= 0){
									BigDecimal sheetAmount = BaseHelpUtils.getBigDecimalValue(selected.getAttribute("sheetAmount"));
									sheetAmount = sheetAmount.subtract(BaseHelpUtils.getBigDecimalValue(selected.getAttribute("distributedAmount")));
									if(sheetAmount.compareTo(distributionAmount) >= 0){
										selected.setAttribute("distributionAmount", distributionAmount);
									}else{
										selected.setAttribute("distributionAmount", sheetAmount);
									}
									grid.updateData(selected);
								}
							}
						});
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		
		IButton sumButton = new IButton("合并数据");
		sumButton.setWidth100();
		sumButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!grid.anySelected()){
							SC.say("请选择需要自动填充的记录");
							return;
						}
						ListGridRecord[] selected = grid.getSelectedRecords();
						if(selected.length == 1){
							SC.say("只选中了一条数据，无需合并");
							return;
						}
						BigDecimal sum = BigDecimal.ZERO; 
						LinkedHashMap<Integer, String> projectMap = new LinkedHashMap<>();
						for(ListGridRecord obj : selected){
							if(null != obj.getAttribute("distributionAmount")){
								sum = sum.add(new BigDecimal(obj.getAttribute("distributionAmount")));
							}
							projectMap.put(ClientUtil.checkAndGetIntValue(obj.getAttribute("projectId")), obj.getAttribute("code"));
						}
						PopupWindow window = new PopupWindow("回款分配合并数据");
						window.setWidth("30%");
						window.setHeight("30%");
						SumProjectCapitalDistributionPanel panel = new SumProjectCapitalDistributionPanel();
						panel.setProjectMap(projectMap);
						panel.setDistributionAmount(sum);
						panel.initComponents();
						panel.startEdit();
						panel.setParent(window);
						panel.addDataEditedHandler(new DataEditedHandler() {
							
							@Override
							public void onDataEdited(DataEditEvent event) {
								Record value = event.getData();
								Record newRecord = new Record();
								newRecord = record.copyAttributes(record, "type","contractId","capitalId","totalAmount");
								newRecord.setAttribute("operator", ClientUtil.getUserId());
								newRecord.setAttribute("projectId", value.getAttribute("projectId"));
								newRecord.setAttribute("code", value.getAttribute("code"));
								newRecord.setAttribute("distributionAmount", value.getAttribute("distributionAmount"));
								for(Record obj : selected){
									grid.removeData(obj);
								}
								grid.addData(newRecord);
							}
						});
						window.addItem(panel);
						window.centerInPage();
						window.show();
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		
		IButton autoDistributionButton = new IButton("自动分满");
		autoDistributionButton.setWidth100();
		autoDistributionButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!grid.anySelected()){
							SC.say("请选择需要自动分满的记录");
							return;
						}
						ListGridRecord selected = grid.getSelectedRecords()[0];
						BigDecimal distribution = BaseHelpUtils.getBigDecimalValue(selected.getAttribute("distributionAmount"));
						BigDecimal leftAmount = BaseHelpUtils.getBigDecimalValue(selected.getAttribute("leftAmount"));
						leftAmount = leftAmount.add(distribution);
						if(leftAmount.compareTo(BigDecimal.ZERO) < 0){
							selected.setAttribute("distributionAmount", 0);
							selected.setAttribute("leftAmount", leftAmount);
						}else{
							selected.setAttribute("distributionAmount", leftAmount);
							selected.setAttribute("leftAmount", 0);
						}
						grid.updateData(selected);
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		
		gridButtonLayout = new VLayout();
		gridButtonLayout.setWidth("10%");
		gridButtonLayout.setHeight100();
		gridButtonLayout.setMembersMargin(20);
		gridButtonLayout.setLayoutTopMargin(20);
		gridButtonLayout.setLayoutLeftMargin(20);
		gridButtonLayout.setLayoutRightMargin(20);
		gridButtonLayout.addMembers(createButton, deleteButton, deleteAllButton, autoFitButton, sumButton, autoDistributionButton);
		
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
		
		newWindowButton = new IButton("只分配给部门");
		newWindowButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				getParent().destroy();
				if(null != capitalId){
					PopupWindow window = new PopupWindow("部门回款分配");
					window.setWidth("60%");
					window.setHeight("80%");
					PlateCapitalDistribution panel = new PlateCapitalDistribution();
					panel.setRecord(record);
					panel.initComponents();
					panel.startEdit();
					panel.setParent(window);
					window.addMember(panel);
					window.centerInPage();
					window.show();
				}else{
					SC.say("数据有误");
				}
			}
		});
		
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
		navLayout.addMembers(newWindowButton, sureButton, cancelButton);
		
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

	public Record[] getData() {
		return data;
	}

	public void setData(Record[] record) {
		this.data = record;
		if(null != record && record.length > 0){
			this.record = this.record.copyAttributes(data[0], "type","contractId","capitalId","totalAmount");
			this.record.setAttribute("operator", ClientUtil.getUserId());
		}
	}
	
	public String getCapitalId() {
		return capitalId;
	}

	public void setCapitalId(String capitalId) {
		this.capitalId = capitalId;
	}

	public void startEdit(){
		if(null != data && data.length > 0){
			boolean showNewWindowButton = true;
			for(Record record : data){
				if(null != record.getAttribute("capitalDistributionId")){
					showNewWindowButton = false;
				}
				if(null == record.getAttribute("code") && null != record.getAttribute("projectId")){
					String projectCode = SyncDataUtil.getProjectCode(BaseHelpUtils.getIntValue(record.getAttribute("projectId")));
//					Record record1 = getProjectName(BaseHelpUtils.getIntValue(record.getAttribute("projectId")));
//					String projectCode = BaseHelpUtils.getString(record1.getAttribute("projectCode"));
					record.setAttribute("code", projectCode);
				}
			}
			if(showNewWindowButton){
				newWindowButton.show();
			}else{
				newWindowButton.hide();
			}
		}
		grid.setData(data);
		if(null != data && data.length > 0){
			ListGridField projectIdField = new ListGridField("projectId");
			ListGridField contractCodeField = new ListGridField("contractCode");
			contractCodeField.setWidth(250);
			ListGridField projectNameField = new ListGridField("projectName");
			ListGridField projectManageIdField = new ListGridField("projectManageId");
			projectManageIdField.setWidth(80);
			Criteria c = new Criteria();
			c.addCriteria("contractId", data[0].getAttribute("contractId"));
			ComboBoxItem projectSelectItem = new ComboBoxItem();
			projectSelectItem.setWidth("*");
			projectSelectItem.hide();
			projectSelectItem.setChangeOnKeypress(false);
			projectSelectItem.setOptionDataSource(DSGetProjects.getInstance());
			projectSelectItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
			projectSelectItem.setValueField(projectIdField.getName());
			projectSelectItem.setDisplayField(projectNameField.getName());
			projectSelectItem.setPickListFields(projectNameField, contractCodeField,projectManageIdField);
			projectSelectItem.setPickListCriteria(c);
			projectSelectItem.setPickListWidth(800);
			grid.getField("projectId").setEditorProperties(projectSelectItem);
		}
	}

	public boolean checkData(){
		Record[] records = grid.getRecords();
		if(null != records && records.length > 0){
			Map<String,Integer> idMap = new HashMap<>();
			BigDecimal total = new BigDecimal(records[0].getAttribute("totalAmount"));
			BigDecimal distribution = BigDecimal.ZERO;
			for(Record record : records){
				String id = record.getAttribute("projectId");
				if(null != id && !id.equals("")){
					idMap.put(id, 1);
				}else{
					SC.say("请选择回款分配的订单");
					return false;
				}
				if(null != record.getAttribute("distributionAmount")){
					distribution = distribution.add(new BigDecimal(record.getAttribute("distributionAmount")));
				}
			}
			if(records.length != idMap.keySet().size()){
				SC.say("回款分配的订单中，有订单重复，请仔细检查");
				return false;
			}
			if(total.compareTo(distribution) != 0){
				SC.ask("提示","分配前后的金额不一致，是否继续保持数据", new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						if(value){
							saveData();
						}
					}
				});
				return false;
			}
//			if(null == remarkItem.getValue()){
//				SC.say("备注不能为空");
//				return false;
//			}
		}
		return true;
	}
	
	public void saveData(){
		Map params = new HashMap<>();
		MapUtils.convertRecordToMap(grid.getDataSource(), grid.getRecords(), params,
				"details");
		params.put("remark", remarkItem.getValue());
		params.put("type", 2);
		params.put("capitalId", capitalId);
		params.put("optType", "saveCapitalDistribution");
		params.put("operator", ClientUtil.getUserName());
		params.put("operatorId", ClientUtil.getUserId());
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

	/**
	 * 获取项目的名称
	 * @param projectId
	 * @return
	 */
	private Record getProjectName(Integer projectId){
		Record record = new Record();
		HashMap<Object, Object> map = new HashMap<>();
		map.put("projectId",projectId);
		DBDataSource.callOperation("ST_Project", "find", map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record[] records = dsResponse.getData();
					if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
						//获取项目名称
						String projectName = BaseHelpUtils.getString(records[0].getAttribute("projectName"));
						record.setAttribute("projectName",projectName);
					}
				}
			}
		});
		return record;
	}
}
