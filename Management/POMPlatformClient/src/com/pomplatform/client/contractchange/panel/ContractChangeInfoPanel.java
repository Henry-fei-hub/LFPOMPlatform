package com.pomplatform.client.contractchange.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.MapUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.pomplatform.client.contractchange.datasource.DSChangeProjectInfo;
import com.pomplatform.client.contractchange.form.ChangeContractInfoNewForm;
import com.pomplatform.client.contractchange.form.ChangeProjectInfoNewForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;  
  
public class ContractChangeInfoPanel extends DelicacyPanel {
	
	private static Logger __logger = Logger.getLogger("");

	private VLayout main;
	private HLayout top;
	private ToolStrip bottom;
	private HLayout top_left;
	private VLayout top_right;
	private HLayout top_right_top;
	private HLayout top_right_bottom;
	
	private IButton saveButton;
	private IButton cancleButton;
	private IButton submitButton;
	private IButton agreeButton;
	private IButton disagreeButton;
	
	private boolean isEdit = true;
	private String contractId;
	private String contractAmount;
	private Map<String, Record> projectChangeMap = new HashMap<>();
	
	private String flag_1 = "1";//草稿
	private String flag_2 = "2";//驳回
	private String flag_3 = "3";//待审核
	private String flag_4 = "4";//审核通过
	
	protected final HandlerManager handlerManager = new HandlerManager(this);

    @Override
    public void fireEvent(GwtEvent<?> event) {
        handlerManager.fireEvent(event);
    }

    public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
        return handlerManager.addHandler(DataEditEvent.TYPE, handler);
    }
    
	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			ContractChangeInfoPanel cm = new ContractChangeInfoPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "PlateAccountPanel";
		}

	}

	public ContractChangeInfoPanel(){
		this(true);
	}
	
	
	public ContractChangeInfoPanel(boolean isEdit){
		super();
		this.isEdit = isEdit;
		if(isEdit){
			agreeButton.hide();
			disagreeButton.hide();
		}else{
			saveButton.hide();
			cancleButton.hide();
			submitButton.hide();
		}
	}
	
	@Override
	public Canvas getViewPanel() {
		main = new VLayout();
		main.setWidth100();
		main.setHeight100();
		
		top = new HLayout();
		top.setWidth100();
		top.setHeight("95%");
		top.setBorder("1px solid #e4e4e4");
		
		bottom = new ToolStrip();
		bottom.setVPolicy(LayoutPolicy.FILL);
		bottom.setWidth100();
		bottom.setHeight("5%");
		bottom.setMembersMargin(8);
		bottom.setBackgroundColor("#fff");
		bottom.setBorder("1px solid #e4e4e4");
		bottom.addFill();		

		saveButton = new IButton("保存");
		saveButton.setBaseStyle("customButton");
		saveButton.setWidth(80);
		saveButton.setHeight(30);
		saveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ChangeContractInfoNewForm panel = (ChangeContractInfoNewForm) top_left.getMember(0);
				Map<String, Object> params = new HashMap<>();
				params.putAll(panel.getValuesAsMap());
				saveData(params, flag_1, false);
			}
		});
		
		cancleButton = new IButton("取消");
		cancleButton.setBaseStyle("customButton");
		cancleButton.setWidth(80);
		cancleButton.setHeight(30);
		cancleButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				getParentCanvas().destroy();
			}
		});
		
		submitButton = new IButton("提交");
		submitButton.setBaseStyle("customButton");
		submitButton.setWidth(80);
		submitButton.setHeight(30);
		submitButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ChangeContractInfoNewForm panel = (ChangeContractInfoNewForm) top_left.getMember(0);
				Map<String, Object> params = new HashMap<>();
				params.putAll(panel.getValuesAsMap());
				saveData(params, flag_3, true);
			}
		});
		
		bottom.addMembers(saveButton, submitButton, cancleButton);
		//审批页面的按钮
		agreeButton = new IButton("同意");
		agreeButton.setBaseStyle("customButton");
		agreeButton.setWidth(80);
		agreeButton.setHeight(30);
		agreeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ChangeContractInfoNewForm panel = (ChangeContractInfoNewForm) top_left.getMember(0);
				Map<String, Object> params = new HashMap<>();
				params.putAll(panel.getValuesAsMap());
				saveData(params, flag_4, true);
			}
		});
		disagreeButton = new IButton("反对");
		disagreeButton.setBaseStyle("customButton");
		disagreeButton.setWidth(80);
		disagreeButton.setHeight(30);
		disagreeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ChangeContractInfoNewForm panel = (ChangeContractInfoNewForm) top_left.getMember(0);
				Map<String, Object> params = new HashMap<>();
				params.putAll(panel.getValuesAsMap());
				saveData(params, flag_2, true);
			}
		});
		
		bottom.addMembers(agreeButton, disagreeButton);
		
		main.addMembers(top, bottom);
		
		top_left = new HLayout();
		top_left.setWidth("20%");
		top_left.setHeight100();
		top_left.setBackgroundColor("#fff");
		top_left.setBorder("1px solid #e4e4e4");
		
		top_right = new VLayout();
		top_right.setWidth("80%");
		top_right.setHeight100();
		top_right.setBackgroundColor("#fff");
		top_right.setBorder("1px solid #e4e4e4");
		
		top.addMembers(top_left, top_right);
		
		top_right_top = new HLayout();
		top_right_top.setWidth100();
		top_right_top.setHeight("40%");
		top_right_top.setBackgroundColor("#fff");
		top_right_top.setBorder("1px solid #e4e4e4");
		
		top_right_bottom = new HLayout();
		top_right_bottom.setWidth100();
		top_right_bottom.setHeight("60%");
		top_right_bottom.setBackgroundColor("#fff");
		top_right_bottom.setBorder("1px solid #e4e4e4");
		
		top_right.addMembers(top_right_top, top_right_bottom);
		return main;
	}

	/**
	 * 初始化页面面板
	 */
	public void initData(){
		Map<String, Object> contractParams = new HashMap<>();
		contractParams.put("optType", "queryContractChangeRecord");
		contractParams.put("contractId", contractId);
		if(isEdit){
			contractParams.put("flag", flag_1);
		}else{
			contractParams.put("flag", flag_3);
		}
		DBDataSource.callOperation("EP_ContractChangeProcess", contractParams, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				Record record = null;
				Map<String, Object> projectParams = new HashMap<>();
				if(dsResponse.getStatus() >= 0){
					//获取userData
					Map<String,Object> userData = BaseHelpUtils.getResponseUserData(dsResponse);
					Record[] records = dsResponse.getData();
					if(null != records && records.length > 0){
						record = records[0];
						projectParams.put("contractChangeId", record.getAttribute("contractChangeId"));
						if(!BaseHelpUtils.isNullOrEmpty(userData) && userData.size() > 0) {
							//获取合同编号和名称
							String contractName = BaseHelpUtils.getStringValue(userData, "contractName");
							String contractCode = BaseHelpUtils.getStringValue(userData, "contractCode");
							record.setAttribute("contractName", contractName);
							record.setAttribute("contractCode", contractCode);
						}
					}
				}
				initDataOfChangeContractInfoPanel(record);
				initDataOfProjectBasicInfoPanel();
				projectParams.put("optType", "queryProjectChangeRecord");
				projectParams.put("contractId", contractId);
				if(isEdit){
					projectParams.put("flag", flag_1);
				}else{
					projectParams.put("flag", flag_3);
				}
				DBDataSource.callOperation("EP_ContractChangeProcess", projectParams, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							Record[] records = dsResponse.getData();
							for(Record obj : records){
								projectChangeMap.put(obj.getAttribute("projectId"), obj);
							}
						}
						initDataOfChangeProjectInfoPanel();
					}
				});
			}
		});
	}
	
	private void initDataOfChangeContractInfoPanel(Record record){
		if(null == record){
			record = new Record();
			record.setAttribute("contractId", contractId);
			record.setAttribute("contractAmount", contractAmount);
			record.setAttribute("contractChangeAmount", 0);
			record.setAttribute("contractFinalAmount", contractAmount);
		}
		ChangeContractInfoNewForm panel = new ChangeContractInfoNewForm();
		panel.setRecord(record);
		panel.startEdit();
		if(!isEdit){
			FormItem[] items = panel.getFormItemArray();
			for(FormItem obj : items){
				obj.setCanEdit(false);
				obj.setDisabled(false);
			}
		}
		panel.setWidth100();
		panel.setHeight100();
		top_left.addMember(panel);
	}

	private void initDataOfProjectBasicInfoPanel(){
		ProjectBasicInfoPanel panel = new ProjectBasicInfoPanel();
		panel.setContractId(contractId);
		panel.setWidth100();
		panel.setHeight100();
		panel.commonQuery();
		panel.resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if(panel.resultGrid.getSelectedRecord().getAttributeAsBoolean("status")){
					SC.say("该订单已结算完毕，不允许再变更订单数据");
				}else{
					initDataOfChangeProjectInfoPanel();
				}
			}
		});
		top_right_top.addMember(panel);
	}
	
	private void initDataOfChangeProjectInfoPanel(){
		ChangeProjectInfoNewForm panel = null;
		if(null != top_right_bottom.getMembers() && top_right_bottom.getMembers().length > 0){
			panel = (ChangeProjectInfoNewForm) top_right_bottom.getMember(0);
			Map map = panel.getValuesAsMap();
			if(null != map && !map.isEmpty()){
				if(map.containsKey("sheetChangeAmount") || map.containsKey("totalChangeIntegral")){
					projectChangeMap.put(map.get("projectId").toString(), createRecordFromMap(map));
				}
			}
		}else{
			panel = new ChangeProjectInfoNewForm();
			panel.setWidth100();
			panel.setHeight100();
			if(!isEdit){
				FormItem[] items = panel.getFormItemArray();
				for(FormItem obj : items){
					obj.setCanEdit(false);
					obj.setDisabled(false);
				}
			}
		}
		ProjectBasicInfoPanel projectPanel = (ProjectBasicInfoPanel) top_right_top.getMember(0);
		Record projectInfo = projectPanel.resultGrid.getSelectedRecord();
		String projectId = projectInfo.getAttribute("projectId");
		Record record = null;
		if(projectChangeMap.containsKey(projectId)){
			record = projectChangeMap.get(projectId);
		}else{
			record = new Record();
			record.setAttribute("projectId", projectId);
			record.setAttribute("sheetAmount", projectInfo.getAttribute("sheetAmount"));
			record.setAttribute("sheetChangeAmount", 0);
			record.setAttribute("sheetFinalAmount", projectInfo.getAttribute("sheetAmount"));
			record.setAttribute("totalIntegral", projectInfo.getAttribute("totalIntegral"));
			record.setAttribute("totalChangeIntegral", 0);
			record.setAttribute("totalFinalIntegral", projectInfo.getAttribute("totalIntegral"));
			record.setAttribute("commonArea", projectInfo.getAttribute("commonArea"));
			record.setAttribute("logisticsArea", projectInfo.getAttribute("logisticsArea"));
			record.setAttribute("designArea", projectInfo.getAttribute("cadArea"));
		}
		panel.setRecord(record);
		panel.startEdit();
		if(null == top_right_bottom.getMembers() || (null != top_right_bottom.getMembers() && top_right_bottom.getMembers().length == 0)){
			top_right_bottom.addMember(panel);
		}
	}
	
	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getContractAmount() {
		return contractAmount;
	}

	public void setContractAmount(String contractAmount) {
		this.contractAmount = contractAmount;
	}
	
	public Record createRecordFromMap(Map map){
		Record record = new Record();
		if(null != map && !map.isEmpty()){
			for(Object key : map.keySet()){
				record.setAttribute(key.toString(), map.get(key));
			}
		}
		return record;
	}
	
	public void saveData(Map<String, Object> params, String flag, boolean refresh){
		params.put("flag", flag);
		updateEditData();
		if(!projectChangeMap.isEmpty()){
			DSChangeProjectInfo ds = DSChangeProjectInfo.getInstance();
			List<Map> list = new ArrayList<>();
			for(String key : projectChangeMap.keySet()){
				Map tempMap = MapUtils.convertRecordToMap(ds, projectChangeMap.get(key));
				tempMap.put("flag", flag);
				list.add(tempMap);
			}
			params.put("projectChangeList", list);
		}
		params.put("optType", "saveContractAndProjectChange");
		DBDataSource.callOperation("EP_ContractChangeProcess", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					if(refresh){
						fireEvent(new DataEditEvent());
					}
					getParentCanvas().destroy();
				}else{
					SC.say("本次操作失败，请稍后再试");
				}
			}
		});
	}
	
	/**
	 * 把当前正在编辑的订单的变更信息更新到projectChangeMap中
	 */
	public void updateEditData(){
		if(null != top_right_bottom.getMembers() && top_right_bottom.getMembers().length > 0){
			ChangeProjectInfoNewForm panel = (ChangeProjectInfoNewForm) top_right_bottom.getMember(0);
			Map map = panel.getValuesAsMap();
			if(null != map && !map.isEmpty()){
				if(map.containsKey("sheetChangeAmount") || map.containsKey("totalChangeIntegral")){
					projectChangeMap.put(map.get("projectId").toString(), createRecordFromMap(map));
				}
			}
		}
	}
}