package com.pomplatform.client.company.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.DelicacyListGrid;
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
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class CompanyRepaymentPanel extends HLayout implements HasHandlers {

	private Window parentWindow;
	private static Logger __logger = Logger.getLogger("");
	private TextItem plateNameItem;
	private DoubleItem achieveIntegralItem;
	private DoubleItem achieveIntegralLeftItem;
	private DoubleItem plateOfArrearsItem;
	private ComboBoxItem plateIdItem;
	private SpinnerItem sendIntegralItem;
	private DateItem sendDateItem;
	private TextAreaItem remarkItem;
	private IButton okBtn;
	private DoubleItem plateOfArrearsLeftItem;
	public static DelicacyListGrid grid;

	public void initComponents(final int plateId,final String plateName, final BigDecimal achieveIntegral) {
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

		final DynamicForm form = new DynamicForm();
		form.setNumCols(6);
		form.setAlign(Alignment.CENTER);
		form.setPadding(5);
		form.setMargin(5);
		form.setWidth100();
		form.setHeight100();

		plateNameItem = new TextItem("plateName", "还款部门");
		plateNameItem.setWidth("*");
		plateNameItem.setDefaultValue(plateName);
		plateNameItem.setDisabled(true);

		achieveIntegralItem = new DoubleItem("achieveIntegral", "部门价值积分");
		achieveIntegralItem.setDisabled(true);
		achieveIntegralItem.setLength(18);
		achieveIntegralItem.setDecimalPad(2);
		achieveIntegralItem.setFormat("#,###,###,###,###,##0.00");
		achieveIntegralItem.setDefaultValue(achieveIntegral);
		achieveIntegralItem.setWidth("*");
		
		achieveIntegralLeftItem = new DoubleItem("achieveIntegralLeft", "部门剩余积分");
		achieveIntegralLeftItem.setDisabled(true);
		achieveIntegralLeftItem.setLength(18);
		achieveIntegralLeftItem.setDecimalPad(2);
		achieveIntegralLeftItem.setFormat("#,###,###,###,###,##0.00");
		achieveIntegralLeftItem.setDefaultValue(achieveIntegral);
		achieveIntegralLeftItem.setWidth("*");
		
		plateIdItem = new ComboBoxItem("plateId","还款到");
		plateIdItem.setWidth("*");
		plateIdItem.setDefaultValue(0);
		plateIdItem.setDisabled(true);
		LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>();
		linkedMap.put(0, "公司账户");
		plateIdItem.setValueMap(linkedMap);
        
		plateOfArrearsItem = new DoubleItem("plateOfArrearsItem", "部门欠款金额");
		plateOfArrearsItem.setDisabled(true);
		plateOfArrearsItem.setLength(18);
		plateOfArrearsItem.setDecimalPad(2);
		plateOfArrearsItem.setFormat("#,###,###,###,###,##0.00");
		plateOfArrearsItem.setWidth("*");
		plateOfArrearsItem.setDefaultValue(0);
		
		
		plateOfArrearsLeftItem = new DoubleItem("plateOfArrearsLeftItem", "剩余欠款金额");
		plateOfArrearsLeftItem.setDisabled(true);
		plateOfArrearsLeftItem.setLength(18);
		plateOfArrearsLeftItem.setDecimalPad(2);
		plateOfArrearsLeftItem.setFormat("#,###,###,###,###,##0.00");
		plateOfArrearsLeftItem.setWidth("*");
		
		
        sendIntegralItem = new SpinnerItem("sendIntegral", "还款金额"); 
        sendIntegralItem.setMin(0);  
        sendIntegralItem.setStep(500f);  
        sendIntegralItem.setWriteStackedIcons(false);
        sendIntegralItem.setDefaultValue(0);
        sendIntegralItem.setWidth("*");
        sendIntegralItem.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                //获取新输入的积分值
                BigDecimal newValue = BaseHelpUtils.getBigDecimalValue(event.getValue());
                //获取改变前的值
                BigDecimal oldValue = BaseHelpUtils.getBigDecimalValue(event.getOldValue());
                //获取改变后与改变前的差值
                BigDecimal finalValue = newValue.subtract(oldValue);
                //更新部门剩余积分
                achieveIntegralLeftItem.setValue(BaseHelpUtils.getBigDecimalValue(achieveIntegralLeftItem.getValue()).subtract(finalValue));
                //更新剩余欠款金额
                plateOfArrearsLeftItem.setValue(BaseHelpUtils.getBigDecimalValue(plateOfArrearsLeftItem.getValue()).subtract(finalValue));
            }
        });
        
        sendDateItem = new DateItem("sendDate", "还款日期");
        sendDateItem.setDefaultValue(new Date());
        sendDateItem.setWidth("*");
        sendDateItem.setDisabled(true);
        sendDateItem.setUseTextField(true);
        sendDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
        
        remarkItem = new TextAreaItem("remark", "备注");
        remarkItem.setColSpan(6);
        remarkItem.setRowSpan(3);
        remarkItem.setWidth("*");
		
		form.setItems(plateNameItem, achieveIntegralItem,achieveIntegralLeftItem,plateIdItem,plateOfArrearsItem,plateOfArrearsLeftItem,sendIntegralItem,sendDateItem, remarkItem);
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

				SC.ask("提示", "您确认要还款到公司账户上吗?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if (value) {
							//发放积分
							BigDecimal sendIntegral = BaseHelpUtils.getBigDecimalValue(sendIntegralItem.getValue());
							if(sendIntegral.equals(BigDecimal.ZERO)){
								SC.say("提示", "请输入您要提取的积分");
								return;
							}
							//获取发放日期
							Date sendDate = sendDateItem.getValueAsDate();
							//获取备注信息
							final String remark =remarkItem.getValueAsString();
							//获取当前操作人
							int operateEmployeeId = ClientUtil.getEmployeeId();
							
							okBtn.setDisabled(true);
							Map<Object,Object> params = new HashMap<>();
							params.put("plateId", plateId);
							params.put("integral", sendIntegral);
							params.put("flag", "2");
							params.put("recordDate", sendDate);
							params.put("remark", remark);
							params.put("operateEmployeeId", operateEmployeeId);
							params.put("optType", "onCompanyRepayment");
							DBDataSource.callOperation("EP_AccountManageProcess",params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() >= 0) {
										okBtn.setDisabled(false);
										SC.say("提示","操作成功");
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
		
	}

	
	public void load(int plateId, Date date) {
		if (plateId == 0) {
			return;
		}
		Map<String,Object> params = new HashMap<>();
		params.put("plateId", plateId);
		params.put("optType", "onCompanyRepaymentData");
		DBDataSource.callOperation("EP_AccountManageProcess", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					BigDecimal plateOfArrears = new BigDecimal("0");
					for (Record record : records) {
						plateOfArrears = new BigDecimal(record.getAttribute("integral"));
					}
					plateOfArrearsItem.setValue(plateOfArrears);
					plateOfArrearsLeftItem.setValue(plateOfArrears);
					//判断当前部门价值积分是否为负
					if(ClientUtil.checkAndGetDoubleValue(achieveIntegralLeftItem.getValue()) > 0){
						sendIntegralItem.setMax(ClientUtil.checkAndGetDoubleValue(plateOfArrearsLeftItem.getValue()));
					}
					else{
						sendIntegralItem.setMax(ClientUtil.checkAndGetDoubleValue(achieveIntegralLeftItem.getValue()));
					}
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
