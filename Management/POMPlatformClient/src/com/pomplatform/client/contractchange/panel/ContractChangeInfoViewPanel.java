package com.pomplatform.client.contractchange.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.pomplatform.client.contractchange.form.ChangeContractInfoNewForm;
import com.pomplatform.client.contractchange.form.ChangeProjectInfoNewForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;  
  
public class ContractChangeInfoViewPanel extends DelicacyPanel {
	
	private static Logger __logger = Logger.getLogger("");

	private VLayout main;
	private HLayout top;
	private HLayout top_left;
	private VLayout top_right;
	private HLayout top_right_top;
	private HLayout top_right_bottom;
	
	private String contractChangeId = "1";
	private String contractId;
	private String contractAmount;
	private Map<String, Record> projectChangeMap = new HashMap<>();
	
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
			ContractChangeInfoViewPanel cm = new ContractChangeInfoViewPanel();
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

	@Override
	public Canvas getViewPanel() {
		main = new VLayout();
		main.setWidth100();
		main.setHeight100();
		
		top = new HLayout();
		top.setWidth100();
		top.setHeight100();
		top.setBorder("1px solid #e4e4e4");
		
		main.addMembers(top);
		
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
		contractParams.put("optType", "getInfoByContractChangeId");
		contractParams.put("contractChangeId", contractChangeId);
		DBDataSource.callOperation("EP_ContractChangeProcess", contractParams, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				Record record = null;
				Map<String, Object> projectParams = new HashMap<>();
				if(dsResponse.getStatus() >= 0){
					Record[] records = dsResponse.getData();
					if(null != records && records.length > 0){
						//获取userData
						Map<String,Object> userData = BaseHelpUtils.getResponseUserData(dsResponse);
						record = records[0];
						if(!BaseHelpUtils.isNullOrEmpty(userData) && userData.size() > 0) {
							//获取合同编号和名称
							String contractName = BaseHelpUtils.getStringValue(userData, "contractName");
							String contractCode = BaseHelpUtils.getStringValue(userData, "contractCode");
							record.setAttribute("contractName", contractName);
							record.setAttribute("contractCode", contractCode);
						}
						projectParams.put("contractChangeId", record.getAttribute("contractChangeId"));
						initDataOfChangeContractInfoPanel(record);
						initDataOfProjectBasicInfoPanel();
						projectParams.put("optType", "queryProjectChangeRecord");
						projectParams.put("contractId", contractId);
						projectParams.put("flag", record.getAttribute("flag"));
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
				}
			}
		});
	}
	
	private void initDataOfChangeContractInfoPanel(Record record){
		if(null == record){
			record = new Record();
			record.setAttribute("contractId", contractId);
			record.setAttribute("contractAmount", record.getAttribute("contractAmount"));
		}
		ChangeContractInfoNewForm panel = new ChangeContractInfoNewForm();
		panel.setRecord(record);
		panel.startEdit();
		FormItem[] items = panel.getFormItemArray();
		for(FormItem obj : items){
			obj.setCanEdit(false);
			obj.setDisabled(false);
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
			FormItem[] items = panel.getFormItemArray();
			for(FormItem obj : items){
				obj.setCanEdit(false);
				obj.setDisabled(false);
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
			record.setAttribute("totalIntegral", projectInfo.getAttribute("totalIntegral"));
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
	
	public String getContractChangeId() {
		return contractChangeId;
	}

	public void setContractChangeId(String contractChangeId) {
		this.contractChangeId = contractChangeId;
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
	
}