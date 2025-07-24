package com.pomplatform.client.receivables.panel;

import java.util.*;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class CustomBingContractPanel extends AbstractWizadPage {

	private static Logger __LOGGER = Logger.getLogger("");
	 
	private DynamicForm __infoForm;
	private final ComboBoxItem contractIdItem;
	private final ComboBoxItem contractNameItem;

	public static PopupWindow popupWindow;

	public CustomBingContractPanel(final String ids,final int my_contractId) {
		
		contractIdItem = new ComboBoxItem("contractId", "选择合同");
		contractIdItem.setWidth("*");
//		contractIdItem.setValueMap(KeyValueManager.getValueMap("contracts_2"));
		KeyValueManager.loadValueMap("contracts_2",contractIdItem);
		contractIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		contractIdItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				int id=BaseHelpUtils.getIntValue(event.getValue());
				__infoForm.getItem("contractName").setValue(id);
			}
		});

		contractNameItem = new ComboBoxItem("contractName", "合同名称");
		contractNameItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		contractNameItem.setWidth("*");
//		contractNameItem.setValueMap(KeyValueManager.getValueMap("contracts_1"));
//		KeyValueManager.loadValueMap("contracts_1", contractNameItem);
		KeyValueManager.loadValueMap("contracts_1", contractNameItem);
		contractNameItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				int id=BaseHelpUtils.getIntValue(event.getValue());
				__infoForm.getItem("contractId").setValue(id);
				
			}
		});
		__infoForm = new DynamicForm();
		__infoForm.setFields(contractIdItem, contractNameItem);
		__infoForm.setWidth100();
		__infoForm.setHeight100();
		__infoForm.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__infoForm);
		// 底部工具栏添加
		ToolStrip btnLayout = new ToolStrip();
		btnLayout.setVPolicy(LayoutPolicy.FILL);
		btnLayout.setPadding(5);
		btnLayout.setHeight(40);
		btnLayout.setWidth100();
		btnLayout.addFill();
		IButton saveBtn = new IButton("保存");
		btnLayout.addMember(saveBtn);
		btnLayout.addSpacer(10);
		saveBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				final String contractId=BaseHelpUtils.getString(__infoForm.getItem("contractId").getValue());
				if (BaseHelpUtils.getIntValue(contractId)<=0) {
					SC.say("请选择合同");
					return;
				}
				
				SC.ask("确定绑定该合同", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if(value){
							Map<String,Object> params=new HashMap<>();
							int employeeId =  BaseHelpUtils.getIntValue(ClientUtil.getUserId());
							__LOGGER.info("++++++++++++employeeId+++++++++++++" + employeeId);
							params.put("opt_type", "bingContract");
							params.put("operator", employeeId);
							params.put("ids", ids);
							params.put("contractId", contractId);
							DBDataSource.callOperation("EP_CustomItemCollectionHandler", "", params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() < 0) {
										ClientUtil.displayErrorMessage(dsResponse);
									} else {
										SC.say("绑定成功");
										pw.destroy();
										DataEditEvent dee = new DataEditEvent();
										fireEvent(dee);
									}
								}
							});
						}
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
				SC.ask("提示", "确认取消?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if (value) {
							pw.destroy();
						}
					}
				});
			}
		});
		VLayout topVL=new VLayout();
		topVL.setWidth100();
		topVL.addMember(__infoForm);
		VLayout bottVL=new VLayout();
		bottVL.setWidth100();
		bottVL.setHeight(40);
		bottVL.addMember(btnLayout);
		
		VLayout bigV=new VLayout();
		bigV.setWidth100();
		bigV.setHeight100();
		bigV.addMember(topVL);
		bigV.addMember(bottVL);
		addMember(bigV);
	}

	 
	// 效验数据
	@Override
	public boolean checkData() {
		boolean isFlag = true;
		return isFlag;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("customOutTemplate");
		return res;
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	public Map getValuesAsMap() {
		return null;
	}


	@Override
	public void startEdit() {
		// TODO Auto-generated method stub
		
	}
	
	private PopupWindow pw;

	public PopupWindow getPw() {
		return pw;
	}


	public void setPw(PopupWindow pw) {
		this.pw = pw;
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
