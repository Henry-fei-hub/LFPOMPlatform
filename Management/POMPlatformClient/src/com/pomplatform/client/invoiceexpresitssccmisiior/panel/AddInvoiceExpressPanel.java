package com.pomplatform.client.invoiceexpresitssccmisiior.panel;

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
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

/**
 * 
 * @ClassName: AddInvoiceExpressPanel 
 * @Description:  快递添加面板
 * @author CL
 * @date 2016年11月14日 
 *
 */
public class AddInvoiceExpressPanel extends VLayout {

	public final static String BORDER_STYLE = "1px solid #ABABAB";
	public final static String BACKGROUND_COLOR = "azure";
	public final static String FORM_BORDER_STYLE = "1px solid #ABABAB";

	public final LeftInvoiceExpressFormPanel LeftInvoiceExpressFormPanel;

	public final AddRightInvoiceexpressPanel addRightInvoiceexpressPanel;


	public AddInvoiceExpressPanel() {
		
		addRightInvoiceexpressPanel = new AddRightInvoiceexpressPanel(); //右边发票选择栏
		
		LeftInvoiceExpressFormPanel = new LeftInvoiceExpressFormPanel(addRightInvoiceexpressPanel.SourceGrid);//左侧快递信息栏
		LeftInvoiceExpressFormPanel.setInvoiceGrid(addRightInvoiceexpressPanel.SourceGrid);
		setMargin(5);
		setBackgroundColor(BACKGROUND_COLOR);
		HLayout mainLayout = new HLayout();// 最外层面板
		mainLayout.setBorder(BORDER_STYLE);

		// 添加右边 合同阶段选择面板 && 左右移动按钮 与选择的发票
		VLayout rightMainLayout = new VLayout();// 右边主面板
		rightMainLayout.setWidth("82%");


		
		// 底部工具栏添加
		ToolStrip btnLayout = new ToolStrip();
		btnLayout.setVPolicy(LayoutPolicy.FILL);
		btnLayout.setPadding(5);
		btnLayout.setHeight(40);
		btnLayout.setWidth100();
		btnLayout.addFill();
		IButton saveBtn = new IButton("保存");
		saveBtn.setIcon("[SKIN]/actions/save.png");
		btnLayout.addMember(saveBtn);
		btnLayout.addSpacer(10);
		saveBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
					if(addRightInvoiceexpressPanel.SourceGrid.anySelected()){
						LeftInvoiceExpressFormPanel.findNamedItem("remark").setRequired(false);
					}else{
						LeftInvoiceExpressFormPanel.findNamedItem("remark").setRequired(true);
					}
					if(LeftInvoiceExpressFormPanel.checkData()){
						
//						if(addRightInvoiceexpressPanel.SourceGrid.anySelected()){
						String msg = addRightInvoiceexpressPanel.SourceGrid.anySelected() ? "确认添加?" : "没有选择发票，确认添加？";
							SC.ask("提示", msg, new BooleanCallback() {
								
								@Override
								public void execute(Boolean value) {
									if(value){
										ListGridRecord [] records = addRightInvoiceexpressPanel.SourceGrid.getSelectedRecords();
										String ids = "";
										for (int i = 0; i < records.length; i++) {
											if(i != 0){
												ids += ",";
											}
											ids += records[i].getAttribute("invoiceId");
										}
										
										Map<String, Object> params = new HashMap<>();
										params.put("ids", ids);
										params.put("params", LeftInvoiceExpressFormPanel.getValuesAsMap());
										params.put("opt_type", "addInvoiceExpress");
										params.put("operator", ClientUtil.getEmployeeId());
										params.put("signStatus", 1);
										DBDataSource.callOperation("EP_CustomerMinvoiceexpresitssccmisiiorHandler", "addInvoiceExpress", params, new DSCallback() {
											
											@Override
											public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
												if(dsResponse.getStatus() > 0){
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
							});;
//						}else{
//							SC.say("请选择需要寄送的发票！");
//						}
						
					}else{
						SC.say("请按要求填写好快递资料！");
					}
				}
		});
		
		IButton sendBtn = new IButton("寄出");
		sendBtn.setIcon("[SKIN]/actions/save.png");
		btnLayout.addMember(sendBtn);
		btnLayout.addSpacer(10);
		sendBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
					if(addRightInvoiceexpressPanel.SourceGrid.anySelected()){
						LeftInvoiceExpressFormPanel.findNamedItem("remark").setRequired(false);
					}else{
						LeftInvoiceExpressFormPanel.findNamedItem("remark").setRequired(true);
					}
					if(LeftInvoiceExpressFormPanel.checkData()){
//						if(addRightInvoiceexpressPanel.SourceGrid.anySelected()){
						String msg = addRightInvoiceexpressPanel.SourceGrid.anySelected() ? "确认寄出?" : "没有选择发票，确认寄出？";
							SC.ask("提示", msg, new BooleanCallback() {
								
								@Override
								public void execute(Boolean value) {
									if(value){
										ListGridRecord [] records = addRightInvoiceexpressPanel.SourceGrid.getSelectedRecords();
										String ids = "";
										for (int i = 0; i < records.length; i++) {
											if(i != 0){
												ids += ",";
											}
											ids += records[i].getAttribute("invoiceId");
										}
										
										Map<String, Object> params = new HashMap<>();
										params.put("ids", ids);
										params.put("params", LeftInvoiceExpressFormPanel.getValuesAsMap());
										params.put("opt_type", "addInvoiceExpress");
										params.put("signStatus", 2);
										params.put("operator", ClientUtil.getEmployeeId());
										DBDataSource.callOperation("EP_CustomerMinvoiceexpresitssccmisiiorHandler", "addInvoiceExpress", params, new DSCallback() {
											
											@Override
											public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
												if(dsResponse.getStatus() > 0){
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
							});;
//						}else{
//							SC.say("请选择需要寄送的发票！");
//						}
						
					}else{
						SC.say("请按要求填写好快递资料！");
					}
				}
		});

		IButton cancelBtn = new IButton("取消");
		cancelBtn.setIcon("[SKIN]/actions/close.png");
		btnLayout.addMember(cancelBtn);
		btnLayout.addSpacer(10);
		cancelBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				SC.ask("提示", "确认取消?取消后所有进行的操作都会被还原！！！", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if (value) {
							getFatherWindow().destroy();
						}
					}
				});
			}
		});

		// 面板布局添加
		rightMainLayout.setPadding(5);
		
		rightMainLayout.addMember(addRightInvoiceexpressPanel);
		mainLayout.addMember(LeftInvoiceExpressFormPanel);
		mainLayout.addMember(rightMainLayout);

		addMember(mainLayout);
		addMember(btnLayout);
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
}
