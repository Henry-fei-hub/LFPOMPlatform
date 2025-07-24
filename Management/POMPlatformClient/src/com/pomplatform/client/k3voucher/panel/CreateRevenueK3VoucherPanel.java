package com.pomplatform.client.k3voucher.panel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.revenuevoucher.panel.MprojectcrymorAreaPanel;
import com.pomplatform.client.revenuevoucher.panel.MprojectcrymorBusinessTypePanel;
import com.pomplatform.client.revenuevoucher.panel.MprojectcrymorPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.DateUtil;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class CreateRevenueK3VoucherPanel extends AbstractWizadPage implements HasHandlers{
	
	
	private static final Logger __LOGGER = Logger.getLogger("");

	private final SelectItem yearItem;
	private final SelectItem monthItem;
	private final ComboBoxItem companyItem;
	
	public CreateRevenueK3VoucherPanel(){
		VLayout mainLayout = new VLayout();
		
		HLayout allH =new HLayout();
		allH.setWidth100();
		allH.setHeight100();
		allH.setMargin(5);
		
		VLayout leftLayout = new VLayout();//左边的表单
		leftLayout.setWidth("70%");
		leftLayout.setHeight100();
		
		yearItem = new SelectItem("year", "年份");
		yearItem.setDefaultValue(DateUtil.getDisplayYear(new Date()));
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		yearItem.setWidth("*");
		__formItems.add(yearItem);
		
		monthItem = new SelectItem("month", "月份");
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		monthItem.setWidth("*");
		__formItems.add(monthItem);
		
		companyItem = new ComboBoxItem("company", "公司");
		companyItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyItem.setWidth("*");
		companyItem.setChangeOnKeypress(false);
		companyItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		__formItems.add(companyItem);
		
		__form.setItems(getFormItemArray());
		__form.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		__form.setHeight100();
		__form.setWidth100();
		
		ToolStrip btnLayout = new ToolStrip();
		btnLayout.setVPolicy(LayoutPolicy.FILL);
		btnLayout.setPadding(5);
		btnLayout.setHeight(40);
		btnLayout.setWidth100();
		btnLayout.addFill();
		
		IButton saveBtn = new IButton("确定");
		btnLayout.addMember(saveBtn);
		btnLayout.addSpacer(10);
		saveBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(checkData()){
							Map params = __form.getValues();
							if(null != params.get("month")){
								params.put("optType", "createReceivablesK3Voucher");
							}else{
								//月份为空，则生成年度的营收凭证
								params.put("optType", "createReceivablesK3VoucherByYear");
							}
							DBDataSource.callOperation("EP_AllK3VoucherProcessor", params, new DSCallback() {
								
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() >= 0) {
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
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		
		IButton cancelBtn = new IButton("取消");
		btnLayout.addMember(cancelBtn);
		btnLayout.addSpacer(10);
		cancelBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
					getFatherWindow().destroy();
			}
		});
		
		leftLayout.addMember(__form);
		VLayout rightLayout = new VLayout();
		rightLayout.setHeight100();
		rightLayout.setWidth("30%");
		rightLayout.setLayoutLeftMargin(20);
		rightLayout.setMembersMargin(10);
		
		IButton updateContactBtn = new IButton("该月缺合同");
		updateContactBtn.setWidth(130);
		rightLayout.addMember(updateContactBtn);
		updateContactBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(null == yearItem.getValue() || null == monthItem.getValue()){
							SC.say("请选择年份和月份");
							return;
						}
						PopupWindow pw = new PopupWindow("绑定合同");
						MprojectcrymorPanel panel=new MprojectcrymorPanel();
						panel.setYear(BaseHelpUtils.getIntValue(yearItem.getValue()));
						panel.setMonth(BaseHelpUtils.getIntValue(monthItem.getValue()));
						panel.commonQuery();
						panel.setPw(pw);
						pw.addItem(panel);
						pw.centerInPage();
						pw.show();
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		
		IButton updateBusinessTypeBtn = new IButton("该月缺业务类别");
		updateBusinessTypeBtn.setWidth(130);
		rightLayout.addMember(updateBusinessTypeBtn);
		updateBusinessTypeBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(null == yearItem.getValue() || null == monthItem.getValue()){
							SC.say("请选择年份和月份");
							return;
						}
						PopupWindow pw = new PopupWindow("修改业务类别");
						MprojectcrymorBusinessTypePanel panel=new MprojectcrymorBusinessTypePanel();
						panel.setYear(BaseHelpUtils.getIntValue(yearItem.getValue()));
						panel.setMonth(BaseHelpUtils.getIntValue(monthItem.getValue()));
						panel.commonQuery();
						panel.setPw(pw);
						pw.addItem(panel);
						pw.centerInPage();
						pw.show();
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		
		IButton updateAreaBtn = new IButton("该月缺区域");
		updateAreaBtn.setWidth(130);
		rightLayout.addMember(updateAreaBtn);
		updateAreaBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(null == yearItem.getValue() || null == monthItem.getValue()){
							SC.say("请选择年份和月份");
							return;
						}
						PopupWindow pw = new PopupWindow("修改区域");
						MprojectcrymorAreaPanel panel=new MprojectcrymorAreaPanel();
						panel.setYear(BaseHelpUtils.getIntValue(yearItem.getValue()));
						panel.setMonth(BaseHelpUtils.getIntValue(monthItem.getValue()));
						panel.commonQuery();
						panel.setPw(pw);
						pw.addItem(panel);
						pw.centerInPage();
						pw.show();
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		
		IButton updateAllBusinessTypeBtn = new IButton("该月所有营收订单");
		updateAllBusinessTypeBtn.setWidth(130);
		rightLayout.addMember(updateAllBusinessTypeBtn);
		updateAllBusinessTypeBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(null == yearItem.getValue() || null == monthItem.getValue()){
							SC.say("请选择年份和月份");
							return;
						}
						PopupWindow pw = new PopupWindow("修改业务类别");
						MprojectcrymorBusinessTypePanel panel=new MprojectcrymorBusinessTypePanel();
						panel.setYear(BaseHelpUtils.getIntValue(yearItem.getValue()));
						panel.setMonth(BaseHelpUtils.getIntValue(monthItem.getValue()));
						panel.commonQuery();
						panel.setPw(pw);
						pw.addItem(panel);
						pw.centerInPage();
						pw.show();
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		
		IButton updateAllAreaBtn = new IButton("该月所有合同区域");
		updateAllAreaBtn.setWidth(130);
		rightLayout.addMember(updateAllAreaBtn);
		updateAllAreaBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(null == yearItem.getValue() || null == monthItem.getValue()){
							SC.say("请选择年份和月份");
							return;
						}
						PopupWindow pw = new PopupWindow("修改区域");
						MprojectcrymorAreaPanel panel=new MprojectcrymorAreaPanel();
						panel.setYear(BaseHelpUtils.getIntValue(yearItem.getValue()));
						panel.setMonth(BaseHelpUtils.getIntValue(monthItem.getValue()));
						panel.commonQuery();
						panel.setPw(pw);
						pw.addItem(panel);
						pw.centerInPage();
						pw.show();
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		
		allH.addMember(leftLayout);
		allH.addMember(rightLayout);
		mainLayout.addMember(allH);
		mainLayout.addMember(btnLayout);
		addMember(mainLayout);
	}

	@Override
	public Map getValuesAsMap() {
		return null;
	}

	@Override
	public boolean checkData() {
		if(null == yearItem.getValue()){
			SC.say("请选择年份");
			return false;
		}
		if(null == monthItem.getValue()) {
			SC.say("请选择月份");
			return false;
		}
		if(null == companyItem.getValue()) {
			SC.say("请选择 公司");
			return false;
		}
		return true;
	}

	private Window parentWindow;

	public Window getFatherWindow() {
		return parentWindow;
	}

	public void setFatherWindow(Window fatherWindow) {
		this.parentWindow = fatherWindow;
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

	@Override
	public void startEdit() {
		if(null != getRecord()){
			__form.editRecord(getRecord());
		}
	}
    
}
