package com.pomplatform.client.cmbcinfo.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.pomplatform.client.cmbcinfo.datasource.DSMcapitalbccoccmsssoooblpommmmlor;
import com.pomplatform.client.cmbcinfo.datasource.DSMcmbctransinfolinktattlor;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

/**
 * 
 * @author CL
 *
 */
public class ViewReceiveBindDetailPanel extends VLayout {

	public final static String BORDER_STYLE = "1px solid #ABABAB";
	public final static String BACKGROUND_COLOR = "azure";
	public final static String FORM_BORDER_STYLE = "1px solid #808080";
	public final static String BORDER_STYLE_TITLE = "2px solid #ABABAB;border-radius:8px;";
	
	DelicacyListGrid transInfoGrid ;
	DelicacyListGrid capitalGrid;
	
	private String code;

	public ViewReceiveBindDetailPanel(int linkType) {
		transInfoGrid = new DelicacyListGrid();
		transInfoGrid.setDataSource(DSMcmbctransinfolinktattlor.getInstance());
		if(linkType == 2){
			int index = 0;
			ListGridField [] fields = new ListGridField[10];
			fields[index] = new ListGridField("accnam");
			index ++;
			fields[index] = new ListGridField("bankAccount");
			index ++;
			fields[index] = new ListGridField("trsamtd");
			index ++;
			fields[index] = new ListGridField("transDate");
			index ++;
			fields[index] = new ListGridField("rpynam", "收方名称");
			index ++;
			fields[index] = new ListGridField("rpyacc", "收方账号");
			index ++;
			fields[index] = new ListGridField("rpybnk");
			index ++;
			fields[index] = new ListGridField("rpyadr");
			transInfoGrid.setFields(fields);
		}
		capitalGrid = new DelicacyListGrid();
		capitalGrid.setDataSource(DSMcapitalbccoccmsssoooblpommmmlor.getInstance());
		if(linkType == 2){
			int index = 0;
			ListGridField [] fields = new ListGridField[10];
			fields[index] = new ListGridField("selfName", "内部公司(付款方)");
			index ++;
			fields[index] = new ListGridField("selfBankAccount", "银行账号(付款方)");
			index ++;
			fields[index] = new ListGridField("otherName", "收款方");
			index ++;
			fields[index] = new ListGridField("otherBankName", "银行名称(收款方)");
			index ++;
			fields[index] = new ListGridField("otherBankAccount", "银行账号(收款方)");
			index ++;
			fields[index] = new ListGridField("loanMoney", "贷(减少)");
			index ++;
			fields[index] = new ListGridField("happenDate");
			capitalGrid.setFields(fields);
		
		}
		
		
		setMargin(5);
		setBackgroundColor(BACKGROUND_COLOR);
		VLayout mainLayout = new VLayout();// 最外层面板
		mainLayout.setBorder(BORDER_STYLE);

		VLayout tranInfoLayout = new VLayout(20);
		tranInfoLayout.setIsGroup(true);
		tranInfoLayout.setGroupBorderCSS(BORDER_STYLE_TITLE);
		tranInfoLayout.setGroupLabelBackgroundColor("#555555");
		tranInfoLayout.setGroupTitle("银行资金");
		tranInfoLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
		tranInfoLayout.setHeight("50%");
		tranInfoLayout.setWidth100();
		tranInfoLayout.addMember(transInfoGrid);
		
		VLayout capitalLayout = new VLayout(20);
		capitalLayout.setIsGroup(true);
		capitalLayout.setGroupBorderCSS(BORDER_STYLE_TITLE);
		capitalLayout.setGroupLabelBackgroundColor("#555555");
		capitalLayout.setGroupTitle("账单流水");
		capitalLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
		capitalLayout.setHeight("50%");
		capitalLayout.setWidth100();
		capitalLayout.addMember(capitalGrid);
		
		// 底部工具栏添加
		
		ToolStrip btnLayout = new ToolStrip();
		btnLayout.setVPolicy(LayoutPolicy.FILL);
		btnLayout.setPadding(5);
		btnLayout.setHeight(40);
		btnLayout.setWidth100();
		btnLayout.addFill();

		IButton unbindBtn = new IButton("解绑");
		btnLayout.addMember(unbindBtn);
		btnLayout.addSpacer(10);
		unbindBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				SC.ask("确定解绑?", new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						if(null != value && value){
							Map<String, Object> params = new HashMap<>();
							params.put("opt_type", "receiveUnbind");
							params.put("code", getCode());
							params.put("employeeId", ClientUtil.getEmployeeId());
							DBDataSource.callOperation("EP_BankCapitalCheckProcess", params, new DSCallback() {
								
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if(dsResponse.getStatus() >= 0){
										getFatherWindow().destroy();
										DataEditEvent dee = new DataEditEvent();
										fireEvent(dee);
									}else{
										ClientUtil.displayErrorMessage(dsResponse);
									}
									
								}
							});
						}
						
					}
				});
				
			}
		});
		
		
		IButton cancelBtn = new IButton("关闭");
		btnLayout.addMember(cancelBtn);
		btnLayout.addSpacer(10);
		cancelBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				getFatherWindow().destroy();
			}
		});
//		ToolStripButton cancelButton = new ToolStripButton("关闭");
//        cancelButton.setTop(1);
//        cancelButton.setHeight(32);
//        cancelButton.setIcon("[SKIN]/actions/close.png");
//        cancelButton.setBorder(GenericWizadWindow.BORDER_STYLE);
//        cancelButton.setWidth100();
//        cancelButton.addClickHandler(new ClickHandler() {
//
//            @Override
//            public void onClick(ClickEvent event) {
//            	getFatherWindow().destroy();
//            }
//
//        });

		// 面板布局添加
		mainLayout.addMember(tranInfoLayout);
		mainLayout.addMember(capitalLayout);

		addMember(mainLayout);
		addMember(btnLayout);
	}
	
	public void loadData(int businessId, int businessType, int linkType){
		Map<String, Object> codeParams = new HashMap<>();
		codeParams.put("businessId", businessId);
		codeParams.put("businessType", businessType);
		codeParams.put("linkType", linkType);
		DBDataSource.callOperation("ST_BankCapitalCheckLink", "find", codeParams, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					if(dsResponse.getData().length > 0){
						String code = dsResponse.getData()[0].getAttribute("code");
						setCode(code);
						Map<String, Object> params = new HashMap<>();
						params.put("code", code);
						params.put("linkType", linkType);
						params.put("opt_type", "getTransinfoByCode");
						DBDataSource.callOperation("EP_BankCapitalCheckProcess", params, new DSCallback() {
							
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if(dsResponse.getStatus() >= 0){
									transInfoGrid.setData(dsResponse.getData());
								}
								
							}
						});
						params.put("opt_type", "getCapitalByCode");
						DBDataSource.callOperation("EP_BankCapitalCheckProcess", params, new DSCallback() {
							
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if(dsResponse.getStatus() >= 0){
									capitalGrid.setData(dsResponse.getData());
								}
								
							}
						});
					}
				}
				
			}
		});
		
		
		
	}

	private Window fatherWindow;

	public Window getFatherWindow() {
		return fatherWindow;
	}

	public void setFatherWindow(Window fatherWindow) {
		this.fatherWindow = fatherWindow;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
