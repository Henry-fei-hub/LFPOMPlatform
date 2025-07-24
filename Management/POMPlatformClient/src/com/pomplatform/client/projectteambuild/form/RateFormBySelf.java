package com.pomplatform.client.projectteambuild.form;

import java.math.BigDecimal;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FloatItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/*
 * 自定义税率
 * 
 * */
public class RateFormBySelf extends VLayout implements HasHandlers {

	private static final Logger logger = Logger.getLogger("");
	private final FloatItem leftAmountItem1;
	private final FloatItem leftAmountItem2;
	private final FloatItem taxRateItem;//税率
	private final DynamicForm form = new DynamicForm();
	private final VLayout vLayout;
	private final IButton saveButton;
	private final IButton cancelButton;
	private final HLayout buttonLayout;
	public BigDecimal contractAmout;
	protected final HandlerManager handlerManager = new HandlerManager(this);
	private Window parentWindow;
	public BigDecimal projectAmount;
	
	private Double one =1.0;
	
	public BigDecimal getProjectAmount() {
		return projectAmount;
	}

	public void setProjectAmount(BigDecimal projectAmount) {
		this.projectAmount = projectAmount;
	}

	public BigDecimal getContractAmout() {
		return contractAmout;
	}

	public void setContractAmout(BigDecimal contractAmout) {
		this.contractAmout = contractAmout;
	}

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	public RateFormBySelf() {
		
		vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		
		leftAmountItem1 = new FloatItem("leftAmount1", "订单积分");
		leftAmountItem1.setWidth("*");
		leftAmountItem1.setCanEdit(false);
		leftAmountItem1.setLength(18);
		leftAmountItem1.setDecimalPad(2);
		
		taxRateItem = new FloatItem("taxRate", "税率(%)");
		taxRateItem.setWidth("*");
		taxRateItem.setLength(18);
		taxRateItem.setDecimalPad(2);
		taxRateItem.setDefaultValue(0);
		taxRateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Double taxRate = BaseHelpUtils.getDoubleValue(event.getValue())/100;//税率
				if(taxRate>100||taxRate<0) {
					taxRateItem.setValue(0);
					leftAmountItem1.setValue(0);
					SC.say("提示","税率比例范围0-100");
				}else {
					Double rate = BaseHelpUtils.getDoubleValue(leftAmountItem2.getValue());//订单比例
					Double temp=rate/100;
					if(taxRate>0) {
						temp  =temp/(taxRate+one);
					}
					//获取合同金额计算订单的积分
					BigDecimal contractAmount = getContractAmout();
					BigDecimal projectAmount = contractAmount.multiply(new BigDecimal(temp)).setScale(2, BigDecimal.ROUND_HALF_UP);
					leftAmountItem1.setValue(projectAmount);
				}
			}
		});
		
		leftAmountItem2 = new FloatItem("leftAmount2", "订单比例(%)");
		leftAmountItem2.setWidth("*");
		leftAmountItem2.setLength(18);
		leftAmountItem2.setDecimalPad(3);
		leftAmountItem2.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Double rate = BaseHelpUtils.getDoubleValue(event.getValue());//订单比例
				if(rate>100||rate<0) {
					leftAmountItem2.setValue(0);
					leftAmountItem1.setValue(0);
					SC.say("提示","订单比例范围0-100");
				}else {
					Double taxRate = BaseHelpUtils.getDoubleValue(taxRateItem.getValue())/100;//税率
					Double temp=rate/100;
					if(taxRate>0) {
						temp  =temp/(taxRate+one);
					}
					//获取合同金额计算订单的积分
					BigDecimal contractAmount = getContractAmout();
					BigDecimal projectAmount = contractAmount.multiply(new BigDecimal(temp)).setScale(2, BigDecimal.ROUND_HALF_UP);
					leftAmountItem1.setValue(projectAmount);
				}
				
			}
		});
		

		
//		form.setNumCols(2);
		form.setItems(leftAmountItem1,taxRateItem,leftAmountItem2);

		vLayout.addMember(form);
		
		addMember(vLayout);
		
		saveButton = new IButton("确定", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				DataEditEvent dee = new DataEditEvent();
				dee.setData(getValueAsRecord());
				fireEvent(dee);
				setProjectAmount(BaseHelpUtils.getBigDecimalValue(leftAmountItem1.getValue()));
				getParentWindow().destroy();
			}
		});

		cancelButton = new IButton("取消", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (null == getParentWindow()) {
					return;
				}
				
				getParentWindow().destroy();
			}
		});
		
		buttonLayout = new HLayout();
		buttonLayout.setWidth100();
		buttonLayout.setHeight100();
		buttonLayout.setMargin(8);
		buttonLayout.setMembersMargin(20);
		buttonLayout.setAlign(Alignment.CENTER);
		buttonLayout.addMember(saveButton);
		buttonLayout.addMember(cancelButton);

		vLayout.addMember(buttonLayout);

		
	}
	
	public Record getValueAsRecord() {
		Map map = form.getValues();
		Record record = new Record();
		if (null != map && !map.isEmpty()) {
			for (Object key : map.keySet()) {
				if(key.toString().equals("department") && null != map.get(key)){
					//如果是部门的选择结果，则根据选择结果得到>=第三级部门的结果
					String[] paths = map.get(key).toString().split("/");
					String departmentId = null == paths[paths.length-1] ? "1" : paths[paths.length-1];
					record.setAttribute("departmentId", departmentId);
				}else{
					record.setAttribute(key.toString(), map.get(key));
				}
			}
		}
		return record;
	}
	
	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}
	
	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}
	
	
	public void setHiden() {
		taxRateItem.hide();
	}
	


}
