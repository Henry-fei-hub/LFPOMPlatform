package com.pomplatform.client.company.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.SpinnerItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class CompanyLoanPanel extends HLayout implements HasHandlers {

	private Window parentWindow;
	private static Logger __logger = Logger.getLogger("");
	private ComboBoxItem plateIdItem;
	private DoubleItem achieveIntegralItem;
	private DoubleItem achieveIntegralLeftItem;
	private DoubleItem plateOfArrearsItem;
	private DateItem sendDateItem;
	private TextAreaItem remarkItem;
	private IButton okBtn;
	private SpinnerItem integralOfLoanItem;

	public void initComponents(final BigDecimal achieveIntegralValue) {
		SC.debugger();
		setWidth("98%");
		setHeight100();
		setPadding(10);
		setMembersMargin(5);

		VLayout formLayout = new VLayout();
		formLayout.setHeight("98%");
		formLayout.setMembersMargin(5);
		formLayout.setWidth100();
		formLayout.setAlign(Alignment.CENTER);
		addMember(formLayout);

		HLayout messageLayout = new HLayout();
		messageLayout.setWidth100();
		messageLayout.setHeight("80%");
		messageLayout.setAlign(Alignment.CENTER);

		DynamicForm form = new DynamicForm();
		form.setNumCols(6);
		form.setAlign(Alignment.CENTER);
		form.setPadding(5);
		form.setMargin(5);
		form.setWidth100();
		form.setHeight100();


		achieveIntegralItem = new DoubleItem("achieveIntegral", "公司价值积分");
		achieveIntegralItem.setDisabled(true);
		achieveIntegralItem.setLength(18);
		achieveIntegralItem.setDecimalPad(2);
		achieveIntegralItem.setFormat("#,###,###,###,###,##0.00");
		achieveIntegralItem.setWidth("*");
		achieveIntegralItem.setValue(achieveIntegralValue);
		
		achieveIntegralLeftItem = new DoubleItem("achieveIntegralLeft", "公司剩余积分");
		achieveIntegralLeftItem.setDisabled(true);
		achieveIntegralLeftItem.setLength(18);
		achieveIntegralLeftItem.setDecimalPad(2);
		achieveIntegralLeftItem.setFormat("#,###,###,###,###,##0.00");
		achieveIntegralLeftItem.setWidth("*");
		achieveIntegralLeftItem.setValue(achieveIntegralValue);
		
		sendDateItem = new DateItem("date", "借款日期");
        sendDateItem.setDefaultValue(new Date());
        sendDateItem.setWidth("*");
        sendDateItem.setDisabled(true);
        sendDateItem.setUseTextField(true);
        sendDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		
		plateIdItem = new ComboBoxItem("plateName", "借款部门");
		plateIdItem.setWidth("*");
		plateIdItem.setValue(1);//默认为商业事业部
		plateIdItem.setChangeOnKeypress(false);
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		plateIdItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				loadPlateOfArrears();
				integralOfLoanItem.setValue("0");
			}
		});

		
		plateOfArrearsItem = new DoubleItem("plateOfArrearsItem", "部门欠款金额");
		plateOfArrearsItem.setDisabled(true);
		plateOfArrearsItem.setLength(18);
		plateOfArrearsItem.setDecimalPad(2);
		plateOfArrearsItem.setFormat("#,###,###,###,###,##0.00");
		plateOfArrearsItem.setWidth("*");
		
		
		integralOfLoanItem = new SpinnerItem("integralOfLoanItem", "借款积分");
		integralOfLoanItem.setMin(0);  
		integralOfLoanItem.setStep(500f);  
		integralOfLoanItem.setWriteStackedIcons(false);
		integralOfLoanItem.setDefaultValue(0);
		integralOfLoanItem.setWidth("*");
		integralOfLoanItem.setMax(ClientUtil.checkAndGetDoubleValue(achieveIntegralValue));
		integralOfLoanItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				//获取新输入的积分值
                BigDecimal newValue = BaseHelpUtils.getBigDecimalValue(event.getValue());
                //获取改变前的值
                BigDecimal oldValue = BaseHelpUtils.getBigDecimalValue(event.getOldValue());
                //获取改变后与改变前的差值
                BigDecimal finalValue = newValue.subtract(oldValue);
                //更新公司剩余积分
                achieveIntegralLeftItem.setValue(BaseHelpUtils.getBigDecimalValue(achieveIntegralLeftItem.getValue()).subtract(finalValue));
				//更新部门欠款积分
                plateOfArrearsItem.setValue(BaseHelpUtils.getBigDecimalValue(plateOfArrearsItem.getValue()).add(finalValue));
                
			}
        });
		

		remarkItem = new TextAreaItem("remark", "备注");
        remarkItem.setColSpan(6);
        remarkItem.setRowSpan(3);
        remarkItem.setWidth("*");
		
		form.setItems(achieveIntegralItem,achieveIntegralLeftItem,plateOfArrearsItem,plateIdItem,integralOfLoanItem,sendDateItem, remarkItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		messageLayout.addMember(form);
		formLayout.addMember(messageLayout);

		HLayout btnLayout = new HLayout();
		btnLayout.setWidth100();
		btnLayout.setHeight("20%");
		btnLayout.setMembersMargin(10);
		btnLayout.setAlign(Alignment.RIGHT);

		okBtn = new IButton("确认");
		okBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				SC.ask("提示", "您确认要借款给该部门吗?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if (value) {
							//借款积分
							BigDecimal integralOfLoan = BaseHelpUtils.getBigDecimalValue(integralOfLoanItem.getValue());
							if(integralOfLoanItem.equals(BigDecimal.ZERO)){
								SC.say("提示", "请输入您要借款的积分");
								return;
							}
							//获取借款日期
							Date sendDate = sendDateItem.getValueAsDate();
							//获取备注信息
							final String remark =remarkItem.getValueAsString();
							//获取当前操作人
							int operateEmployeeId = ClientUtil.getEmployeeId();
							//获取借款部门的id
							int plateId = ClientUtil.checkAndGetIntValue(plateIdItem.getValue());
							
							okBtn.setDisabled(true);
							Map<Object,Object> params = new HashMap<>();
							params.put("plateId", plateId);
							params.put("integral", integralOfLoan);
							params.put("flag", "1");
							params.put("recordDate", sendDate);
							params.put("remark", remark);
							params.put("operateEmployeeId", operateEmployeeId);
							params.put("optType", "onCompanyLoan");
							DBDataSource.callOperation("EP_AccountManageProcess",params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() >= 0) {
										okBtn.setDisabled(false);
										SC.say("提示","操作成功");
										loadPlateOfArrears();
									} else {
										SC.say("Failure" +dsResponse.getErrors().get("errorMsg"));
									}
								}
							});
						}
					}
				});

			}
		});
		
		IButton cleanBtn = new IButton("关闭");
		cleanBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (getParentWindow() == null) {
					return;
				}
				getParentWindow().destroy();
				DataEditEvent dee = new DataEditEvent();
				fireEvent(dee);
			}
		});
		btnLayout.addMember(okBtn);
		btnLayout.addMember(cleanBtn);
		formLayout.addMember(btnLayout);
		loadPlateOfArrears();
	}

	/**
	 * 加载页面时加载该部门的欠款积分
	 * @param plateId
	 */
	public void loadPlateOfArrears(){
		int plateId = ClientUtil.checkAndGetIntValue(plateIdItem.getValue());
		if (plateId == 0) {
			return;
		}
		Map<Object,Object> params = new HashMap<>();
		params.put("plateId", plateId);
		params.put("optType", "onCompanyRepaymentData");
		DBDataSource.callOperation("EP_AccountManageProcess", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record record = dsResponse.getData()[0];
					//获取该部门的欠款积分
					BigDecimal plateOfArrears = BaseHelpUtils.getBigDecimalValue(record.getAttribute("integral"));
					plateOfArrearsItem.setValue(plateOfArrears);
				}
			}
		});
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

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	

}
