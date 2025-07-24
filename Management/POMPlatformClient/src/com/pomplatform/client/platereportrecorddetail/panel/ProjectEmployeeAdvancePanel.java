package com.pomplatform.client.platereportrecorddetail.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import com.pomplatform.client.data.RoleDefinition;
import com.pomplatform.client.platereportrecorddetail.datasource.DSProjectEmployeeAdvanceSource;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
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
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ProjectEmployeeAdvancePanel extends HLayout implements HasHandlers {

	private Window parentWindow;
	private static Logger __logger = Logger.getLogger("");
	private ComboBoxItem projectIdItem;
	private DoubleItem advanceIntegralItem;
	private DoubleItem leftIntegralItem;
	private DoubleItem leftFinalIntegralItem;
	private DateItem advanceDateItem;
	private TextAreaItem remarkItem;
	private DelicacyListGrid grid;

	/**
	 * 
	 * @param flag：标示字段：1：事业部负责人操作；2：专业负责人操作
	 * @param plateId:业务部门
	 * @param projectId：补贴项目
	 * @param advanceIntegral：项目补贴总积分
	 * @param leftIntegral：项目补贴剩余积分
	 */
	public void initComponents(final int flag,final int plateId,final int projectId,final BigDecimal advanceIntegral,final BigDecimal leftIntegral) {
		grid = new DelicacyListGrid();
		grid.setShowRowNumbers(true);
		grid.setAutoFitFieldWidths(false);
		grid.setCanEdit(false);
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

		projectIdItem = new ComboBoxItem("projectId","补贴项目");
		projectIdItem.setWidth("*");
		projectIdItem.setDefaultValue(projectId);
		projectIdItem.setChangeOnKeypress(false);
		if(flag == 1){
			projectIdItem.setCanEdit(false);
//			KeyValueManager.loadValueMap("projects",projectIdItem);
			KeyValueManager.loadValueMap("projects", projectIdItem);
		}else{
			//获取当前操作人的id
			int operateEmployeeId = ClientUtil.getEmployeeId();
			RoleDefinition.setProjectAdvanceValueMap(projectIdItem, plateId,operateEmployeeId);
		}
        projectIdItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
            	//获取当前选中的项目id
            	final int projectId = ClientUtil.checkAndGetIntValue(event.getValue());
            	//根据项目id去检索该项目目前补贴的总积分、剩余积分
            	LinkedHashMap<String,Object> params = new LinkedHashMap<>();
				params.put("projectId", projectId);
				params.put("plateId", plateId);
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
							leftFinalIntegralItem.setValue(leftIntegral);
							load(projectId);
						} else {
							SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
						}
					}
				});
            }
        });
        
        advanceIntegralItem = new DoubleItem("advanceIntegral", "项目补贴总积分");
        advanceIntegralItem.setCanEdit(false);
        advanceIntegralItem.setLength(18);
        advanceIntegralItem.setDecimalPad(2);
        advanceIntegralItem.setFormat("#,###,###,###,###,##0.00");
        advanceIntegralItem.setDefaultValue(advanceIntegral);
        advanceIntegralItem.setWidth("*");
		
        leftIntegralItem = new DoubleItem("leftIntegral", "可补贴积分");
        leftIntegralItem.setCanEdit(false);
        leftIntegralItem.setLength(18);
        leftIntegralItem.setDecimalPad(2);
        leftIntegralItem.setFormat("#,###,###,###,###,##0.00");
        leftIntegralItem.setDefaultValue(leftIntegral);
        leftIntegralItem.setWidth("*");
        
        leftFinalIntegralItem = new DoubleItem("leftFinalIntegral", "剩余积分");
        leftFinalIntegralItem.setCanEdit(false);
        leftFinalIntegralItem.setLength(18);
        leftFinalIntegralItem.setDecimalPad(2);
        leftFinalIntegralItem.setFormat("#,###,###,###,###,##0.00");
        leftFinalIntegralItem.setDefaultValue(leftIntegral);
        leftFinalIntegralItem.setWidth("*");
        

        advanceDateItem = new DateItem("advanceDate", "补贴日期");
        advanceDateItem.setWidth("*");
        advanceDateItem.setDefaultValue(new Date());
        advanceDateItem.setDisabled(true);
        advanceDateItem.setUseTextField(true);
        advanceDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
        
        remarkItem = new TextAreaItem("remark", "备注");
        remarkItem.setColSpan(6);
        remarkItem.setRowSpan(3);
        remarkItem.setWidth("*");
		
		form.setItems(projectIdItem,advanceIntegralItem,leftIntegralItem,leftFinalIntegralItem,advanceDateItem, remarkItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		messageLayout.addMember(form);
		formLayout.addMember(messageLayout);
		
		grid.setDataSource(DSProjectEmployeeAdvanceSource.getInstance());
		grid.setHeight("60%");
		grid.setWidth100();
		formLayout.addMember(grid);
		grid.addCellClickHandler(new CellClickHandler() {
			@Override
			public void onCellClick(CellClickEvent event) {
				Record record = event.getRecord();
				SC.askforValue("提示","请输入本次确认的积分",new ValueCallback() {
					@Override
					public void execute(String value) {
						if(BaseHelpUtils.isNullOrEmpty(value)){
							return;
						}
						//获取改变前的数据
						BigDecimal oldValue = BaseHelpUtils.getBigDecimalValue(record.getAttribute("advanceIntegral"));
						//获取新输入的数据
						BigDecimal newValue = BaseHelpUtils.getBigDecimalValue(value);
						//设置改变后的最终值
						BigDecimal finalValue = newValue.subtract(oldValue);
						//获取剩余积分
						BigDecimal leftAmount = BaseHelpUtils.getBigDecimalValue(leftFinalIntegralItem.getValue());
						if(newValue.compareTo(BigDecimal.ZERO) < 0){
							SC.say("提示","不可分配负积分");
							return;
						}
						//判断剩余积分是否够分配，如果不够分配则提示不可分配过多积分
						if(leftAmount.compareTo(finalValue) < 0){//说明不够分配
							SC.say("提示","当前确认积分分配过多,已超出剩余可分配的积分,当前最多可分配积分("+leftAmount+")");
							return;
						}
						leftFinalIntegralItem.setValue(leftAmount.subtract(finalValue));
						record.setAttribute("advanceIntegral",newValue);
						grid.updateData(record);
					}
				});
				
			}
		});

		HLayout btnLayout = new HLayout();
		btnLayout.setWidth100();
		btnLayout.setHeight("5%");
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
							final int projectId = ClientUtil.checkAndGetIntValue(projectIdItem.getValue());
							if(projectId == 0){
								SC.say("提示", "请选择您要补贴的项目");
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
							params.put("advanceDate", advanceDate);
							params.put("remark", remark);
							params.put("operateEmployeeId", operateEmployeeId);
							MapUtils.convertRecordToMap(grid.getDataSource(), grid.getRecords(), params,
									"projectEmployeeAdvance");
							okBtn.setDisabled(true);
							DBDataSource.callOperation("EP_OnProjectEmployeeAdvanceSave",params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									okBtn.setDisabled(false);
									if (dsResponse.getStatus() >= 0) {
										SC.say("提示","操作成功");
										//补贴成功后从新去加载成员列表数据
										load(projectId);
										leftIntegralItem.setValue(leftFinalIntegralItem.getValue());
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
	
	/**
	 * 加载页面时加载该方法
	 * 
	 * @param plateId
	 */
	public void load(int projectId) {
		if (projectId == 0) {
			return;
		}
		Map<String,Object> params = new HashMap<>();
		params.put("projectId", projectId);
		DBDataSource.callOperation("EP_OnGetProjectEmployeeAdvanceRecord", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					grid.setData(records);
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
