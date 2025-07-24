package com.pomplatform.client.invoiceexpresitssccmisiior.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
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
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

/**
 * 
 * @ClassName: UpdateInvoiceExpressPanel 
 * @Description:  修改快递面板
 * @author CL
 * @date 2016年11月16日 
 *
 */
public class UpdateInvoiceExpressPanel extends VLayout  implements HasHandlers{

	public final static String BORDER_STYLE = "1px solid #ABABAB";
	public final static String BACKGROUND_COLOR = "azure";
	public final static String FORM_BORDER_STYLE = "1px solid #ABABAB";

	public final LeftUpdateInvoiceExpressFormPanel leftUpdateInvoiceExpressFormPanel;

	public final UpdateRightInvoiceexpressPanel updateRightInvoiceexpressPanel;
	
	public final UpdateRightExistInvoiceexpressPanel updateRightExistInvoiceexpressPanel;
	
	/**
	 * 
	 * <p>Title: </p> 
	 * <p>Description: record 为快递信息   optionType 1:签收  2:修改 3：查看</p> 
	 * @param record 
	 * @param optionType 
	 */
	public UpdateInvoiceExpressPanel(ListGridRecord record, final int optionType) {
		int contractId = record.getAttributeAsInt("contractId");
		int invoiceExpressId = record.getAttributeAsInt("invoiceExpressId");
		
		updateRightInvoiceexpressPanel = new UpdateRightInvoiceexpressPanel(contractId, optionType); //右边发票选择栏(保存操作面板)
		updateRightInvoiceexpressPanel.startEdit();
		
		leftUpdateInvoiceExpressFormPanel = new LeftUpdateInvoiceExpressFormPanel(record, optionType);//左侧快递信息栏
		
		updateRightExistInvoiceexpressPanel = new UpdateRightExistInvoiceexpressPanel(updateRightInvoiceexpressPanel.SourceGrid, invoiceExpressId, optionType);//右侧快递已存在的发票数据grid
		updateRightExistInvoiceexpressPanel.startEdit();
		
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
		String title = null;
		switch (optionType) {
		case 1:
			title = "确认签收";
			break;
		case 2:
			title = "确认修改";
			break;
		case 3:
			title = "确认";
			break;	
		default:
			title = "确认";
			break;
		}
		IButton saveBtn = new IButton(title);
		saveBtn.setIcon("[SKIN]/actions/save.png");
		btnLayout.addMember(saveBtn);
		btnLayout.addSpacer(10);
		
		if(optionType == 1){//签收操作
			saveBtn.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					if(leftUpdateInvoiceExpressFormPanel.checkData()){
						SC.ask("提示", "确认签收?", new BooleanCallback() {
							
							@Override
							public void execute(Boolean value) {
								if(value){
									Map<String, Object> params = new HashMap<>();
									params.put("opt_type", "signInvoiceExpress");
									params.put("params", leftUpdateInvoiceExpressFormPanel.getValuesAsMap());
									saveHandlerOption(params);
								}
							}
						});
					}else{
						SC.say("请按照要求填写快递信息");
					}
				}
			});
		}else if(optionType == 2){//修改操作
			saveBtn.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					if(updateRightInvoiceexpressPanel.SourceGrid.anySelected() || updateRightExistInvoiceexpressPanel.SourceGrid.getRecords().length > 0){
						leftUpdateInvoiceExpressFormPanel.findNamedItem("remark").setRequired(false);
					}else{
						leftUpdateInvoiceExpressFormPanel.findNamedItem("remark").setRequired(true);
					}
					if(leftUpdateInvoiceExpressFormPanel.checkData()){
						
						String msg = "确认修改?";
						if(!updateRightInvoiceexpressPanel.SourceGrid.anySelected() && updateRightExistInvoiceexpressPanel.SourceGrid.getRecords().length <= 0){
							msg = "该快递下没有可寄送发票,确认修改?";
						}
						
//						//检测是否在该快递还存在发票数据  如不存在 不准许修改
//						if(!updateRightInvoiceexpressPanel.SourceGrid.anySelected() && updateRightExistInvoiceexpressPanel.SourceGrid.getRecords().length <= 0){
//							SC.say("该快递下没有可寄送发票,不可以修改保存!!!请选择发票");
//							return;
//						}
						
						
						SC.ask("提示", msg, new BooleanCallback() {

							@Override
							public void execute(Boolean value) {
								if(value){
									String delIds = "";//在选择发票grid中没有选中的发票主键
									String addIds = "";//在选择发票grid中选中的发票主键
									SC.setEnableJSDebugger(true);
									
									ListGridRecord [] allRecords = updateRightInvoiceexpressPanel.SourceGrid.getRecords();
									ListGridRecord [] slRecords = updateRightInvoiceexpressPanel.SourceGrid.getSelectedRecords();
									for (int i = 0; i < allRecords.length; i++) {//获取没有选择的发票IDs
										boolean flag = true; //为true时为没有选中的发票数据
										int tmpInvoiceId = allRecords[i].getAttributeAsInt("invoiceId");
										
										for (int j = 0; j < slRecords.length; j++) {
											int _tmpInvoiceId = slRecords[j].getAttributeAsInt("invoiceId");
											if(tmpInvoiceId == _tmpInvoiceId){ //如有相等表示为选中的发票数据
												flag =false;
												break;
											}
										}
										if(flag){//为没有选择的发票数据
											if(BaseHelpUtils.isNullOrEmpty(delIds)){
												delIds += tmpInvoiceId;
											}else{
												delIds += "," + tmpInvoiceId;
											}
										}else{//选择了的发票数据
											if(BaseHelpUtils.isNullOrEmpty(addIds)){
												addIds += tmpInvoiceId;
											}else{
												addIds += "," + tmpInvoiceId;
											}
										}
									}
									Map<String, Object> params = new HashMap<>();
									params.put("opt_type", "updateInvoiceExpress");
									params.put("params", leftUpdateInvoiceExpressFormPanel.getValuesAsMap());
									params.put("delIds", delIds);
									params.put("addIds", addIds);
									saveHandlerOption(params);
								}
							}
						});
					}else{
						SC.say("请按照要求填写快递信息");
					}
				}
			});
			
		}else if(optionType == 3){//查看操作
			saveBtn.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					getFatherWindow().destroy();
					
				}
			});
			
		}
		if(optionType != 3){
			IButton cancelBtn = new IButton("取消");
			cancelBtn.setIcon("[SKIN]/actions/close.png");
			btnLayout.addMember(cancelBtn);
			btnLayout.addSpacer(10);
			cancelBtn.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					if(optionType == 2){
						SC.ask("提示", "确认取消?取消后所有进行的操作都会被还原！！！", new BooleanCallback() {
							@Override
							public void execute(Boolean value) {
								if (value) {
									getFatherWindow().destroy();
								}
							}
						});
					}else{
						getFatherWindow().destroy();
					}
					
				}
			});
		}

		// 面板布局添加
		rightMainLayout.setPadding(5);
		rightMainLayout.addMember(updateRightExistInvoiceexpressPanel);
		if(optionType == 2){//操作为修改时添加选择操作面板
			rightMainLayout.addMember(updateRightInvoiceexpressPanel);
		}
		
		mainLayout.addMember(leftUpdateInvoiceExpressFormPanel);
		mainLayout.addMember(rightMainLayout);

		addMember(mainLayout);
		addMember(btnLayout);
	}
	
	/**
	 * 
	 * @Title: saveHandlerOption 
	 * @Description: 寄送 与 修改操作方法
	 * @param @param params    
	 * @return void   
	 * @throws
	 */
	private void saveHandlerOption(Map<String, Object> params){
		DBDataSource.callOperation("EP_CustomerMinvoiceexpresitssccmisiiorHandler", params, new DSCallback() {
			
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
