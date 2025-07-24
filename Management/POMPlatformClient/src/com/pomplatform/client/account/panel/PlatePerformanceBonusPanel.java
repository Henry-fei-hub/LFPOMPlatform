package com.pomplatform.client.account.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.account.datasource.DSPlatePerformanceBonusSource;
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
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditorExitEvent;
import com.smartgwt.client.widgets.grid.events.EditorExitHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PlatePerformanceBonusPanel extends HLayout implements HasHandlers {

	private Window parentWindow;
	private static Logger __logger = Logger.getLogger("");
	private ComboBoxItem plateIdItem;
	private DoubleItem totalIntegralItem;
	private DoubleItem leftIntegralItem;
	private DoubleItem totalSendIntegralItem;
	private DateItem sendDateItem;
	private TextAreaItem remarkItem;
	private DelicacyListGrid grid;

	public void initComponents() {
		grid = new DelicacyListGrid();
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
		messageLayout.setHeight("35%");
		messageLayout.setAlign(Alignment.CENTER);

		final DynamicForm form = new DynamicForm();
		form.setNumCols(6);
		form.setAlign(Alignment.CENTER);
		form.setWidth("95%");
		form.setHeight100();

		plateIdItem = new ComboBoxItem("plateId","部门");
		plateIdItem.setWidth("*");
		plateIdItem.setDefaultValue(ClientUtil.getPlateId());
		plateIdItem.setChangeOnKeypress(false);
		plateIdItem.setDisabled(false);
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
//		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		plateIdItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				load();
			}
		});
        
        totalIntegralItem = new DoubleItem("totalIntegral", "部门总积分");
        totalIntegralItem.setDisabled(true);
        totalIntegralItem.setLength(18);
        totalIntegralItem.setDecimalPad(2);
        totalIntegralItem.setFormat("#,###,###,###,###,##0.00");
        totalIntegralItem.setWidth("*");
		
        leftIntegralItem = new DoubleItem("leftIntegral", "剩余积分");
        leftIntegralItem.setDisabled(true);
        leftIntegralItem.setLength(18);
        leftIntegralItem.setDecimalPad(2);
        leftIntegralItem.setFormat("#,###,###,###,###,##0.00");
        leftIntegralItem.setWidth("*");
        
        totalSendIntegralItem = new DoubleItem("totalSendIntegra", "发放总积分");
        totalSendIntegralItem.setDisabled(false);
        totalSendIntegralItem.setLength(18);
        totalSendIntegralItem.setDecimalPad(2);
        totalSendIntegralItem.setFormat("#,###,###,###,###,##0.00");
        totalSendIntegralItem.setDefaultValue(0);
        totalSendIntegralItem.setWidth("*");
        

        sendDateItem = new DateItem("sendDate", "发放日期");
        sendDateItem.setDefaultValue(new Date());
        sendDateItem.setWidth("*");
        sendDateItem.setDisabled(true);
        sendDateItem.setUseTextField(true);
        sendDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
        
        remarkItem = new TextAreaItem("remark", "备注");
        remarkItem.setColSpan(6);
        remarkItem.setRowSpan(3);
        remarkItem.setWidth("*");
		
		form.setItems(plateIdItem,totalIntegralItem,leftIntegralItem,totalSendIntegralItem,sendDateItem, remarkItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		messageLayout.addMember(form);
		formLayout.addMember(messageLayout);
		
		grid.setDataSource(DSPlatePerformanceBonusSource.getInstance());
		grid.setHeight("60%");
		grid.setWidth100();
		formLayout.addMember(grid);
		grid.addEditorExitHandler(new EditorExitHandler() {
            @Override
            public void onEditorExit(EditorExitEvent event) {
                ListGridRecord[] records = grid.getRecords();
                if (records == null || records.length == 0) {
                    return;
                }
                ListGridRecord newRecord = event.getRecord();
                //获取改变前的补贴积分
                BigDecimal oldRealIntegral = BaseHelpUtils.getBigDecimalValue(newRecord.getAttribute("sendIntegral"));
                //获取当前输入的补贴积分
                BigDecimal newRealIntegral = BaseHelpUtils.getBigDecimalValue(event.getNewValue());
                //获取改变前和改变后的差值
                BigDecimal finalRealIntegral = newRealIntegral.subtract(oldRealIntegral);
                //获取剩余积分
                BigDecimal leftIntegral = BaseHelpUtils.getBigDecimalValue(leftIntegralItem.getValue());
                //获取总发放积分
                BigDecimal totalSend = BaseHelpUtils.getBigDecimalValue(totalSendIntegralItem.getValue());
                if(newRealIntegral.compareTo(BigDecimal.ZERO) == 0){//表示未输入实际积分
                	leftIntegralItem.setValue(leftIntegral.subtract(finalRealIntegral));
                	totalSendIntegralItem.setValue(totalSend.add(finalRealIntegral));
                	return;
                }
                //检索当输入的发放积分超出了剩余积分，不允许提交
                BigDecimal lastIntegral = leftIntegral.subtract(finalRealIntegral);
                if(lastIntegral.compareTo(BigDecimal.ZERO)<0){
                	SC.say("提示", "输入实际积分超出了剩余积分,当前最多可输入积分("+(leftIntegral)+")");
                	event.cancel();
                	return;
                }
                leftIntegralItem.setValue(lastIntegral);
                totalSendIntegralItem.setValue(totalSend.add(finalRealIntegral));
            }
        });

		HLayout btnLayout = new HLayout();
		btnLayout.setWidth100();
		btnLayout.setHeight("5%");
		btnLayout.setMembersMargin(10);
		btnLayout.setAlign(Alignment.RIGHT);
		
		IButton okBtn = new IButton("确认");
		okBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				SC.ask("提示", "您确认要进行发放操作吗?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if (value) {
							//获取当前发放的部门id
							final int plateId = ClientUtil.checkAndGetIntValue(plateIdItem.getValue());
							if(plateId == 0){
								SC.say("提示", "当前部门不可为空");
								return;
							}
							//获取总发放积分
							BigDecimal totalSendIntegral = BaseHelpUtils.getBigDecimalValue(totalSendIntegralItem.getValue());
							//初始化人员发放的总积分
							BigDecimal empTotalSendIntegral = BigDecimal.ZERO;
							Record[] records = grid.getRecords();
							if(records.length == 0){//说明未设定部门成员
								SC.say("提示","未设定部门成员,不可进行发放");
								return;
							}else{
								for(Record e : records){
									empTotalSendIntegral = empTotalSendIntegral.add(BaseHelpUtils.getBigDecimalValue(e.getAttribute("sendIntegral")));
								}
							}
							if(empTotalSendIntegral.compareTo(BigDecimal.ZERO) == 0 || totalSendIntegral.compareTo(BigDecimal.ZERO) == 0){//说明未对成员进行积分发放
								SC.say("提示","未对部门成员进行积分的发放");
								return;
							}else if(empTotalSendIntegral.compareTo(totalSendIntegral) != 0){//说明发放的积分有问题，需初始化从新分配
								SC.say("提示","发放的积分有问题，需初始化从新分配");
								return;
							}
							//获取补贴日期
							Date sendDate = sendDateItem.getValueAsDate();
							//获取备注信息
							final String remark =remarkItem.getValueAsString();
							//获取当前操作人
							int operateEmployeeId = ClientUtil.getEmployeeId();
							
							Map<Object,Object> params = new HashMap<>();
							params.put("plateId", plateId);
							params.put("sendDate", sendDate);
							params.put("remark", remark);
							params.put("totalSendIntegral", totalSendIntegral);
							params.put("operateEmployeeId", operateEmployeeId);
							params.put("optType", "onSavePlateEmpPerformanceBonus");
							MapUtils.convertRecordToMap(grid.getDataSource(), grid.getRecords(), params,
									"plateEmpPermanceBonus");
							DBDataSource.callOperation("EP_AccountManageProcess",params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() >= 0) {
										SC.say("提示","操作成功");
										//发放成功后从新去加载成员列表数据
										load();
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
		IButton resetBtn = new IButton("重置");
		resetBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				load();
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
		btnLayout.addMember(resetBtn);
		btnLayout.addMember(cleanBtn);
		formLayout.addMember(btnLayout);
		load();
	}
	
	public void load(){
		int plateId = ClientUtil.checkAndGetIntValue(plateIdItem.getValue());
		loadPlateTotalIntegral(plateId);
		loadGridData(plateId);
	}
	
	/**
	 * 加载页面时加载该方法
	 * @param plateId
	 */
	public void loadGridData(int plateId) {
		if (plateId == 0) {
			return;
		}
		grid.cancelEditing();
		Map<Object,Object> params = new HashMap<>();
		params.put("plateId", plateId);
		params.put("optType", "onLoadPlateEmpPerformanceBonusData");
		DBDataSource.callOperation("EP_AccountManageProcess", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					grid.setData(records);
				}
			}
		});
	}
	
	/**
	 * 加载页面时加载该部门的总积分
	 * @param plateId
	 */
	public void loadPlateTotalIntegral(int plateId) {
		if (plateId == 0) {
			return;
		}
		Map<Object,Object> params = new HashMap<>();
		params.put("plateId", plateId);
		params.put("optType", "onLoadPlateAccountTotalIntegral");
		DBDataSource.callOperation("EP_AccountManageProcess", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record record = dsResponse.getData()[0];
					//获取该部门的总积分
					BigDecimal totalIntegral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("integral"));
					totalIntegralItem.setValue(totalIntegral);
					leftIntegralItem.setValue(totalIntegral);
					totalSendIntegralItem.setValue(0);
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
