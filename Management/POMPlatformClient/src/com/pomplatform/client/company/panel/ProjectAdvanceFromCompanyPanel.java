package com.pomplatform.client.company.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.data.RoleDefinition;
import com.pomplatform.client.platereportrecorddetail.panel.ProjectEmployeeAdvancePanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.SpinnerItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ProjectAdvanceFromCompanyPanel extends HLayout implements HasHandlers {

	private Window parentWindow;
	private static Logger __logger = Logger.getLogger("");
	private DoubleItem achieveIntegralItem;
	private DoubleItem achieveIntegralLeftItem;
	private ComboBoxItem projectIdItem;
	private DoubleItem advanceIntegralItem;
	private DoubleItem leftIntegralItem;
	private SpinnerItem advanceItem;
	private DateItem advanceDateItem;
	private TextAreaItem remarkItem;

	public void initComponents(final BigDecimal achieveIntegral) {
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

		achieveIntegralItem = new DoubleItem("achieveIntegral", "公司价值积分");
		achieveIntegralItem.setCanEdit(false);
		achieveIntegralItem.setLength(18);
		achieveIntegralItem.setDecimalPad(2);
		achieveIntegralItem.setFormat("#,###,###,###,###,##0.00");
		achieveIntegralItem.setDefaultValue(achieveIntegral);
		achieveIntegralItem.setWidth("*");
		
		achieveIntegralLeftItem = new DoubleItem("achieveIntegralLeft", "公司剩余积分");
		achieveIntegralLeftItem.setCanEdit(false);
		achieveIntegralLeftItem.setLength(18);
		achieveIntegralLeftItem.setDecimalPad(2);
		achieveIntegralLeftItem.setFormat("#,###,###,###,###,##0.00");
		achieveIntegralLeftItem.setDefaultValue(achieveIntegral);
		achieveIntegralLeftItem.setWidth("*");
		
		advanceDateItem = new DateItem("advanceDate", "补贴日期");
        advanceDateItem.setWidth("*");
        advanceDateItem.setDefaultValue(new Date());
        advanceDateItem.setDisabled(true);
        advanceDateItem.setUseTextField(true);
        advanceDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		
		projectIdItem = new ComboBoxItem("projectId","补贴项目");
		projectIdItem.setWidth("*");
		projectIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		projectIdItem.setChangeOnKeypress(false);
        KeyValueManager.setValueMapFromQuery("NQ_SprojectItem", MapUtils.toJSON(new HashMap<>()), projectIdItem);
        projectIdItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
            	//获取当前选中的项目id
            	int projectId = ClientUtil.checkAndGetIntValue(event.getValue());
            	onLoadData(projectId);
            }
        });
        
        advanceIntegralItem = new DoubleItem("advanceIntegral", "项目补贴总积分");
        advanceIntegralItem.setCanEdit(false);
        advanceIntegralItem.setLength(18);
        advanceIntegralItem.setDecimalPad(2);
        advanceIntegralItem.setFormat("#,###,###,###,###,##0.00");
        advanceIntegralItem.setDefaultValue(0);
        advanceIntegralItem.setWidth("*");
		
        leftIntegralItem = new DoubleItem("leftIntegral", "项目补贴剩余积分");
        leftIntegralItem.setCanEdit(false);
        leftIntegralItem.setLength(18);
        leftIntegralItem.setDecimalPad(2);
        leftIntegralItem.setFormat("#,###,###,###,###,##0.00");
        leftIntegralItem.setDefaultValue(0);
        leftIntegralItem.setWidth("*");
        
        advanceItem = new SpinnerItem("advance", "补贴积分");
        advanceItem.setMin(0);  
        advanceItem.setStep(500f);  
        advanceItem.setWriteStackedIcons(false);
        advanceItem.setDefaultValue(0);
        advanceItem.setMax(achieveIntegral.doubleValue());
        advanceItem.setWidth("*");
        advanceItem.addChangeHandler(new ChangeHandler() {
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
                //更新项目补贴总积分
                advanceIntegralItem.setValue(BaseHelpUtils.getBigDecimalValue(advanceIntegralItem.getValue()).add(finalValue));
                //更新项目补贴剩余积分
                leftIntegralItem.setValue(BaseHelpUtils.getBigDecimalValue(leftIntegralItem.getValue()).add(finalValue));
            }
        });

        remarkItem = new TextAreaItem("remark", "备注");
        remarkItem.setColSpan(6);
        remarkItem.setRowSpan(3);
        remarkItem.setWidth("*");
		
		form.setItems(achieveIntegralItem,achieveIntegralLeftItem,advanceDateItem,projectIdItem,advanceIntegralItem,leftIntegralItem,advanceItem, remarkItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		messageLayout.addMember(form);
		formLayout.addMember(messageLayout);

		HLayout btnLayout = new HLayout();
		btnLayout.setWidth100();
		btnLayout.setHeight("20%");
		btnLayout.setMembersMargin(10);
		btnLayout.setAlign(Alignment.RIGHT);

		IButton okBtn = new IButton("确认补贴");
		okBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				SC.ask("提示", "您确认要进行补贴操作吗?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if (value) {
							//获取当前补贴的项目id
							int projectId = ClientUtil.checkAndGetIntValue(projectIdItem.getValue());
							if(projectId == 0){
								SC.say("提示", "请选择您要补贴的项目");
								return;
							}
							//补贴积分
							BigDecimal advanceIntegral = BaseHelpUtils.getBigDecimalValue(advanceItem.getValue());
							if (advanceIntegral.compareTo(BigDecimal.ZERO) == 0) {
								SC.say("提示", "请输入补贴积分");
								return;
							}
							//获取补贴日期
							Date advanceDate = advanceDateItem.getValueAsDate();
							//获取备注信息
							final String remark =remarkItem.getValueAsString();
							//获取当前操作人
							int operateEmployeeId = ClientUtil.getEmployeeId();
							
							LinkedHashMap<String,Object> params = new LinkedHashMap<>();
							params.put("projectId", projectId);
							params.put("advanceIntegral", advanceIntegral);
							params.put("leftIntegral", advanceIntegral);
							params.put("advanceDate", advanceDate);
							params.put("remark", remark);
							params.put("flag", 2);//公司补贴到项目标识为2
							params.put("operateEmployeeId", operateEmployeeId);
							okBtn.setDisabled(true);
							DBDataSource.callOperation("EP_OnCompanyProjectAdvanceRecordSave",params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() >= 0) {
										SC.say("提示","操作成功");
									} else {
										SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
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
	
	//数据加载
	public void onLoadData(int projectId){
		//根据项目id去检索该项目目前补贴的总积分、剩余积分
    	LinkedHashMap<String,Object> params = new LinkedHashMap<>();
		params.put("projectId", projectId);
		DBDataSource.callOperation("EP_OnGetProjectAdvanceIntegral", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					//获取该项目补贴的总积分
					BigDecimal advanceIntegral = BaseHelpUtils.getBigDecimalValue(dsResponse.getData()[0].getAttribute("advanceIntegral"));
					//获取该项目补贴的剩余积分
					BigDecimal leftIntegral = BaseHelpUtils.getBigDecimalValue(dsResponse.getData()[0].getAttribute("leftIntegral"));
					advanceIntegralItem.setValue(advanceIntegral);
					leftIntegralItem.setValue(leftIntegral);
				} else {
					SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
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
