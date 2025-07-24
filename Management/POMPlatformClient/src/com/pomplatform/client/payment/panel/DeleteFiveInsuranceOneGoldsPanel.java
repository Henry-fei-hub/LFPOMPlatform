package com.pomplatform.client.payment.panel;

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
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class DeleteFiveInsuranceOneGoldsPanel extends VLayout implements HasHandlers {
	private HLayout  butLayout;
	private Window parentWindow;
	private VLayout  mainLayout;
	private  IButton delButton;
	private  IButton quitButton;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private static Logger __logger = Logger.getLogger("");
	private TextItem   yearItem;
	private TextItem   monthItem;
	private DynamicForm form;
	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();


	public DeleteFiveInsuranceOneGoldsPanel() {
		mainLayout=new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		
		
		yearItem=new TextItem("year",shouldNotBeNull+"年份");
		yearItem.setColSpan(2);
		yearItem.setRequired(true);
		yearItem.setWidth("*");


		monthItem=new TextItem("month",shouldNotBeNull+"月份");
		monthItem.setColSpan(2);
		monthItem.setRequired(true);
		monthItem.setWidth("*");

		form=new DynamicForm();
		form.setHeight("70%");
		form.setWidth100();
		form.setTitleOrientation(TitleOrientation.TOP);
		form.setCellPadding(3);
		form.setNumCols(2);
		form.setItems(yearItem,monthItem);
		//ClientUtil.DynamicFormProcessAccordingToDevice(form);
		mainLayout.addMember(form);
		addMember(mainLayout);

		butLayout=new HLayout();
		butLayout.setMembersMargin(30);
		butLayout.setWidth100();
		butLayout.setAlign(Alignment.CENTER);
		butLayout.setHeight("40%");
		addMember(butLayout);

		delButton=new IButton("删除");
		delButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(checkData()==true){
					int year=BaseHelpUtils.getIntValue(yearItem.getValue());
					int month=BaseHelpUtils.getIntValue(monthItem.getValue());
					if(year<0) {
						SC.say("年份不能小于0");
						return;
					}
					if(month<0) {
						SC.say("月份不能小于0");
						return;
					}
					SC.ask("确定要删除"+year+"年"+month+"月的五险一金数据吗？",new BooleanCallback() {
						@Override
						public void execute(Boolean value) {
							if(value) {
								Map<String,Object> map=new HashMap<>();
								map.put("year", year);
								map.put("month", month);
								DBDataSource.callOperation("ST_FiveInsuranceOneGold","delete",map,new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if(dsResponse.getStatus()>=0) {
											delButton.setDisabled(true);
											if (getParentWindow() == null) {
												return;
											}
											getParentWindow().destroy();
											DataEditEvent dee = new DataEditEvent();
											fireEvent(dee);
											SC.say("删除成功");
										}
									}
								});
							}
						}
					});
				}
			}
		});
		butLayout.addMember(delButton);


		quitButton=new IButton("取消");
		quitButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(getParentWindow()!=null) {
					getParentWindow().destroy();
				}
			}
		});
		butLayout.addMember(quitButton);

	}


	public boolean checkData() {
		if(!form.validate()) {
			SC.say("请按照系统提示填写数据");
			return false;
		}
		return  true;
	}

	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

}
