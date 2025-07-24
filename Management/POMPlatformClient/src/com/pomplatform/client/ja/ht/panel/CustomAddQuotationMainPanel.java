package com.pomplatform.client.ja.ht.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.pomplatform.client.treedesignconsideration.panel.CustomClassificationPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
/**
 *
 */
public class CustomAddQuotationMainPanel extends VLayout {
	private static Logger __LOGGER = Logger.getLogger("");
	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}
    public static CustomOutAllDesignConsiderationPanel outAllDesignConsiderationPanel;
//    public static CustomDesignConsiderationPanel designConsiderationPanel;
    public static com.pomplatform.client.treedesignconsideration.panel.CustomDesignConsiderationPanel designConsiderationPanel;
    
    public static Label outRedesignConsiderationTitle;
    public static Label designConsiderationTitle;
    
	public CustomAddQuotationMainPanel(String infoCode,String projectCode) {
		CustomAddQuotationMainPanel.infoCode=infoCode;
		CustomAddQuotationMainPanel.projectCode=projectCode;
		CustomAddQuotationMainPanel.outQuotationId=outQuotationId;
		outRedesignConsiderationTitle = new Label("报价单");
		outRedesignConsiderationTitle.setHeight(30);
		outRedesignConsiderationTitle.setAlign(Alignment.CENTER);
		designConsiderationTitle = new Label("拆分价");
		designConsiderationTitle.setHeight(6);
		designConsiderationTitle.setAlign(Alignment.CENTER);
		outAllDesignConsiderationPanel = new CustomOutAllDesignConsiderationPanel(infoCode, projectCode, outQuotationId);
		outAllDesignConsiderationPanel.startEdit();
		
		 
		designConsiderationPanel = new com.pomplatform.client.treedesignconsideration.panel.CustomDesignConsiderationPanel(infoCode,projectCode,outQuotationId);
		designConsiderationPanel.startEdit();
		 
		setHeight100();
		setMembersMargin(5);
		
		
		//最大的box 
		VLayout bigBoxPanel = new VLayout(10);
		bigBoxPanel.setWidth100();
		bigBoxPanel.setHeight100();
		//top box
		HLayout topGridAndBtnVLayout = new HLayout(10);
		topGridAndBtnVLayout.setHeight("50%");
		
		VLayout leftVLayout = new VLayout(10);
		leftVLayout.addMember(outRedesignConsiderationTitle);
		leftVLayout.setWidth100();
		HLayout leftGridBoxPanel = new HLayout(10);
		leftGridBoxPanel.setWidth("94%");
		leftGridBoxPanel.setHeight100();
		
		VLayout leftBtnBoxPanel = new VLayout(10); 
		leftBtnBoxPanel.setWidth("6%");
		leftBtnBoxPanel.setHeight100();
		
		IButton refreshButton1 = new IButton("刷新");
		refreshButton1.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				outAllDesignConsiderationPanel.startEdit();
			}
		});
//		将主报价单的子项转到(初步)拆分价表中去
		IButton addDesigConsiderationListBtn=new IButton("转为拆分价");
		addDesigConsiderationListBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] selected = outAllDesignConsiderationPanel.SourceGrid.getSelectedRecords();
				int count=selected.length;
				if(count!=1){
					SC.say("请选择要一条转移的数据");
					return;
				}
				//判断该条记录是否已经拆分
				int isHas=0;
				double selfPrice=0;
				int outQuotationId=0;
				//类别  2装饰 1配合
			    int category=0;
				//选中的ids
			    int outDesignConsiderationId=0;
			    StringBuilder ids=new StringBuilder();
				for(int i=0;i<selected.length;i++){
					int type=BaseHelpUtils.getIntValue(selected[i].getAttribute("jobMix"));
					if(type==2){
						SC.say("合计项不能操作");
						return;//合计
					}else if(type==3){
						return;//最终报价单
					}
					outDesignConsiderationId=BaseHelpUtils.getIntValue(selected[i].getAttribute("outDesignConsiderationId"));
					if(BaseHelpUtils.isNullOrEmpty(ids.toString())){
						int tempId=BaseHelpUtils.getIntValue(selected[i].getAttribute("outDesignConsiderationId"));
						if(tempId>0){
							ids.append(tempId);
						}
					}else{
						int tempId=BaseHelpUtils.getIntValue(selected[i].getAttribute("outDesignConsiderationId"));
						if(tempId>0){
							ids.append(",");
							ids.append(tempId);
						}
					}
					isHas=BaseHelpUtils.getIntValue(selected[i].getAttribute("isHas"));
					category=BaseHelpUtils.getIntValue(selected[i].getAttribute("optionType"));
					outQuotationId=BaseHelpUtils.getIntValue(selected[i].getAttribute("outQuotationId"));
					selfPrice=BaseHelpUtils.getDoubleValue(selected[i].getAttribute("interiorMoneySum"));
				}
				if(isHas>0){
					SC.say("已经拆分了");
					return;
				}
				
				
				//装饰
				if(category==2){
					// 打开合同分类筛选
					PopupWindow pw = new PopupWindow("合同分类");
					CustomClassificationPanel panel = new CustomClassificationPanel(
							CustomAddQuotationMainPanel.infoCode, 
							CustomAddQuotationMainPanel.projectCode,
							outQuotationId,
							outDesignConsiderationId,
							selfPrice);
					panel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							designConsiderationPanel.startEdit();
							outAllDesignConsiderationPanel.startEdit();
						}
					});
					panel.startEdit();
					
					CustomClassificationPanel.popupWindow = pw;
					pw.addCloseClickHandler(new CloseClickHandler() {
						
						@Override
						public void onCloseClick(CloseClickEvent event) {
							designConsiderationPanel.startEdit();
							outAllDesignConsiderationPanel.startEdit();
						}
					});
					pw.addItem(panel);
					pw.setWidth("61%");
					pw.setHeight("60%");
					pw.centerInPage();
					pw.show();
					
					
					
				}else{
					Map<String, Object> condition = new HashMap<>();
					condition.put("opt_type", "addDesigneConsiderationList");
					condition.put("ids", ""+ids);
					condition.put("infoCode", selected[0].getAttribute("infoCode"));//信息编号
					condition.put("projectCode", selected[0].getAttribute("projectCode"));//项目编号
					condition.put("employeeId",ClientUtil.getEmployeeId());//操作人id
					condition.put("selfPrice",selfPrice);
					DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", condition, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
								designConsiderationPanel.startEdit();
								outAllDesignConsiderationPanel.startEdit();
							}else{
								ClientUtil.displayErrorMessage(dsResponse);
							}
						}
					});
				}
			}
		});
		
		IButton cancelSplitBtn=new IButton("取消拆分价");
		cancelSplitBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!outAllDesignConsiderationPanel.SourceGrid.anySelected()) {
					SC.say("请选择要一条转移的数据");
					return;
				}
				Record record = outAllDesignConsiderationPanel.SourceGrid.getSelectedRecord();
				if(!BaseHelpUtils.isNullOrEmpty(record)) {
					//获取报价单ID
					int outDesignConsiderationId = BaseHelpUtils.getIntValue(record.getAttribute("outDesignConsiderationId"));
					if(outDesignConsiderationId <= 0) {
						SC.say("提示","获取报价单失败");
						return;
					}
					//获取是否拆分
					int isHas=BaseHelpUtils.getIntValue(record.getAttribute("isHas"));
					if(isHas <= 0){
						SC.say("提示","该单未进行拆分无需进行此操作");
						return;
					}
					Map<String, Object> params = new HashMap<>();
					params.put("outDesignConsiderationId",outDesignConsiderationId);
					params.put("opt_type", "deleteDesignConsideration");
					DBDataSource.callOperation("EP_CustomDesigneConsiderationHandler",params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
								designConsiderationPanel.startEdit();
								outAllDesignConsiderationPanel.startEdit();
							}else{
								ClientUtil.displayErrorMessage(dsResponse);
							}
						}
					});
				}
			}
		});
		
		//报价单导出
		IButton exportOutDeCon=new IButton("导出");
		exportOutDeCon.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map<String, Object> condition = new HashMap<>();
				condition.put("infoCode", CustomAddQuotationMainPanel.infoCode);
				DBDataSource.downloadFile("DW_CustomOutDesigneConsiderationHandler", condition);
			}
		});

		
		//报价单子项grid
		leftGridBoxPanel.addMember(outAllDesignConsiderationPanel);
		leftBtnBoxPanel.setMargin(10);
		leftBtnBoxPanel.addMember(refreshButton1);
		leftBtnBoxPanel.addMember(addDesigConsiderationListBtn);
		leftBtnBoxPanel.addMember(cancelSplitBtn);
		leftBtnBoxPanel.addMember(exportOutDeCon);
		
		topGridAndBtnVLayout.addMember(leftGridBoxPanel);
		topGridAndBtnVLayout.addMember(leftBtnBoxPanel);
		leftVLayout.addMember(topGridAndBtnVLayout);
		bigBoxPanel.addMember(leftVLayout);
		
		//bottom box
		HLayout bottomGridAndBtnVLayout = new HLayout(10);
		bottomGridAndBtnVLayout.setHeight("50%");
		VLayout rightGridBoxPanel = new VLayout(10);
		rightGridBoxPanel.setWidth("94%");
		rightGridBoxPanel.setHeight100();
		VLayout rightBtnBoxPanel = new VLayout(10);
		rightBtnBoxPanel.setWidth("6%");
		rightBtnBoxPanel.setHeight100();
		
		 
		IButton refreshButton2 = new IButton("刷新");
		refreshButton2.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				designConsiderationPanel.startEdit();
			}
		});
		
		IButton removeButton = new IButton("删除");
		removeButton.hide();
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] selected = designConsiderationPanel.SourceGrid.getSelectedRecords();
				int count=selected.length;
				if(count==0){
					SC.say("请选择一条要删除的数据");
					return;
				}
				//选中的要删除的ids
			    StringBuilder ids=new StringBuilder();
				for(int i=0;i<selected.length;i++){
					int type=BaseHelpUtils.getIntValue(selected[i].getAttribute("jobMix"));
					if(type==2){
						return;//合计
					}else if(type==3){
						return;//最终报价单
					}
					if(BaseHelpUtils.isNullOrEmpty(ids.toString())){
						int tempId=BaseHelpUtils.getIntValue(selected[i].getAttribute("designConsiderationId"));
						if(tempId>0){
							ids.append(tempId);
						}
					}else{
						int tempId=BaseHelpUtils.getIntValue(selected[i].getAttribute("designConsiderationId"));
						if(tempId>0){
							ids.append(",");
							ids.append(tempId);
						}
					}
				}
				Map<String, Object> condition = new HashMap<>();
				condition.put("opt_type", "deleteDesignConsideration");
				condition.put("ids", ""+ids);
				 
				__LOGGER.info("==============ids="+ids);
				DBDataSource.callOperation("EP_CustomDesigneConsiderationHandler", condition, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							designConsiderationPanel.startEdit();
							outAllDesignConsiderationPanel.startEdit();
						}else{
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
			}
		});
		
		 
		//拆分价导出
		IButton exportDeCon=new IButton("导出");
		exportDeCon.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map<String, Object> condition = new HashMap<>();
				condition.put("infoCode", CustomAddQuotationMainPanel.infoCode);
				DBDataSource.downloadFile("DW_CustomDesigneConsiderationHandler", condition);
			}
		});
		IButton submitBtn = new IButton("提交");
		submitBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				boolean flag = false;
				Record [] records = outAllDesignConsiderationPanel.getSourceGrid().getRecords();
				for (Record record : records) {
					if(!record.getAttribute("newCreateQuotationName").equals("已拆分")){
						flag = true;
						break;
					}
				}
				if(flag){
					SC.say("全部拆分后才能提交");
					return;
				}
				SC.ask("确认提交?", new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						if(value){
							Map<String, Object> condition = new HashMap<>();
							condition.put("opt_type", "submitConsideration");
							condition.put("infoCode", CustomAddQuotationMainPanel.infoCode);
							DBDataSource.callOperation("EP_CustomDesigneConsiderationHandler", condition, new DSCallback() {
								
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if(dsResponse.getStatus() > 0){
										SC.say("提交成功");
										condition.put("businessType",2);
										DBDataSource.callOperation("EP_OutQuotationMSG", condition, new DSCallback() {
											@Override
											public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
												if (dsResponse.getStatus() < 0) {
//													ClientUtil.displayErrorMessage(dsResponse);
												}
											}
										});
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
		
		//拆分价grid
		rightGridBoxPanel.addMember(designConsiderationTitle);
		rightGridBoxPanel.addMember(designConsiderationPanel);
		
		rightBtnBoxPanel.setLayoutTopMargin(30);
		rightBtnBoxPanel.addMember(refreshButton2);
		rightBtnBoxPanel.addMember(removeButton);
		rightBtnBoxPanel.addMember(exportDeCon);
		rightBtnBoxPanel.addMember(submitBtn);
		bottomGridAndBtnVLayout.addMember(rightGridBoxPanel);
		bottomGridAndBtnVLayout.addMember(rightBtnBoxPanel);
		bigBoxPanel.addMember(bottomGridAndBtnVLayout);
		
		
		if (Browser.getIsDesktop()) {
			addMember(bigBoxPanel);
		} else {
			addMember(bigBoxPanel);
		}
    }
	private static String infoCode;
	private static String projectCode;
	private static int outQuotationId;
	private PopupWindow pw;

	public PopupWindow getPw() {
		return pw;
	}
	public void setPw(PopupWindow pw) {
		this.pw = pw;
	}
}
