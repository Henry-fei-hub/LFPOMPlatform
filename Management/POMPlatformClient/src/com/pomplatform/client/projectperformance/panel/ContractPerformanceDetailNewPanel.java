package com.pomplatform.client.projectperformance.panel;

import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.pomplatform.client.contractchange.panel.ContractChangeInfoPanel;
import com.pomplatform.client.projectperformance.form.ContractPerformanceDetailNewForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class ContractPerformanceDetailNewPanel extends DelicacyPanel {
	
	private static Logger __logger = Logger.getLogger("");

	private VLayout main;
	private HLayout top;
	private ToolStrip bottom;
	
	private IButton saveButton;
	private IButton cancleButton;
	private IButton submitButton;
	private IButton viewButton;
	
	private Integer performanceFlag;
	private Record record;
	
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
			return "ContractPerformanceDetailNewPanel";
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
		top.setBackgroundColor("#fff");
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
				saveData(false);
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
				saveData(true);
			}
		});
		
		//审批页面的按钮
		viewButton = new IButton("历史考核明细");
		viewButton.setBaseStyle("customButton");
		viewButton.setWidth(120);
		viewButton.setHeight(30);
		viewButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow window = new PopupWindow();
				if(performanceFlag.equals(1)){
					window.setTitle("绩效扣除记录");
				}else if(performanceFlag.equals(2)){
					window.setTitle("绩效奖励记录");
				}
				window.setWidth100();
				window.setHeight100();
				ProjectPerformanceDetailPanel panel = new ProjectPerformanceDetailPanel();
				panel.setContractId(record.getAttribute("contractId"));
				panel.setEmployeeId(record.getAttribute("projectManageId"));
				panel.setPerformanceFlag(performanceFlag);
				panel.setBusinessType(1);
				panel.reDrawResultGrid();
				panel.commonQuery();
				window.addMember(panel);
				window.centerInPage();
				window.show();
			}
		});
		
		bottom.addMembers(viewButton, submitButton, saveButton, cancleButton);
		
		main.addMembers(top, bottom);
		
		return main;
	}

	/**
	 * 初始化页面面板
	 */
	public void initData(){
		Record record = new Record();
		if(null != this.record){
			//合同ID
			record.setAttribute("contractId", this.record.getAttribute("contractId"));
			//项目管理费
			record.setAttribute("integral", this.record.getAttribute("projectManageIntegral"));
			//项目管理费确认积分
			record.setAttribute("projectManageSureIntegral", null == this.record.getAttribute("projectManageSureIntegral") ? 0 : this.record.getAttribute("projectManageSureIntegral"));
			//已扣积分
			record.setAttribute("deductIntegral", null == this.record.getAttribute("deductIntegral") ? 0 : this.record.getAttribute("deductIntegral"));
			//已奖积分
			record.setAttribute("awardIntegral", null == this.record.getAttribute("awardIntegral") ? 0 : this.record.getAttribute("awardIntegral"));
			//项目经理
			record.setAttribute("employeeId", this.record.getAttribute("projectManageId"));
			//奖励还是惩罚
			record.setAttribute("performanceFlag", performanceFlag);
			//主键
			record.setAttribute("projectPerformanceId", this.record.getAttribute("projectPerformanceId"));
			//比例
			record.setAttribute("percent", this.record.getAttribute("percent"));
			//绩效
			record.setAttribute("performanceIntegral", this.record.getAttribute("performanceIntegral"));
			//日期
			record.setAttribute("recordDate", this.record.getAttributeAsDate("recordDate"));
			//原因
			record.setAttribute("reason", this.record.getAttribute("reason"));
			//备注说明
			record.setAttribute("remark", this.record.getAttribute("remark"));
		}
		ContractPerformanceDetailNewForm panel = new ContractPerformanceDetailNewForm();
		panel.setRecord(record);
		panel.startEdit();
		panel.setWidth100();
		panel.setHeight100();
		top.addMember(panel);
	}
	
	public Integer getPerformanceFlag() {
		return performanceFlag;
	}

	public void setPerformanceFlag(Integer performanceFlag) {
		this.performanceFlag = performanceFlag;
	}

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	public void saveData(boolean isSubmit){
		ContractPerformanceDetailNewForm panel = (ContractPerformanceDetailNewForm) top.getMember(0);
		Map params = panel.getValuesAsMap();
		params.put("isSubmit", isSubmit);
		params.put("operateEmployeeId", ClientUtil.getUserId());
		params.put("operateTime", new Date());
		params.put("optType", "savePerformance");
		DBDataSource.callOperation("EP_ProjectPerformanceProcess", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					if(isSubmit){
						fireEvent(new DataEditEvent());
					}
					getParentCanvas().destroy();
				}else{
					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
	}
	
}

