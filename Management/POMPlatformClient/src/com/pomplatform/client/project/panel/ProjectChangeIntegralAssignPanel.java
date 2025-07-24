package com.pomplatform.client.project.panel;

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
import com.pomplatform.client.project.datasource.DSProjectChangeEmployee;
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
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.events.CellDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.CellDoubleClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ProjectChangeIntegralAssignPanel extends HLayout implements HasHandlers {

	private Window parentWindow;
	private static Logger __logger = Logger.getLogger("");
	private ComboBoxItem projectIdItem;
	private DoubleItem integralItem;
	private DoubleItem leftIntegralItem;
	private ComboBoxItem plateIdItem;
	private DoubleItem plateIntegralItem;
	private DateItem recordDateItem;
	private TextAreaItem remarkItem;
	private DelicacyListGrid grid;

	public void initComponents() {
		grid = new DelicacyListGrid();
		grid.setAutoFitFieldWidths(false);
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

		projectIdItem = new ComboBoxItem("projectId","变更项目");
		projectIdItem.setWidth("*");
		projectIdItem.setChangeOnKeypress(false);
		int projectManageId = ClientUtil.getEmployeeId();
		RoleDefinition.getProjectChangeValueMap(projectIdItem,projectManageId);
        projectIdItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
            	//获取当前选中的项目id
            	final int projectId = ClientUtil.checkAndGetIntValue(event.getValue());
            	//根据项目id去检索该项目目前补贴的总积分、剩余积分
            	LinkedHashMap<String,Object> params = new LinkedHashMap<>();
				params.put("projectId", projectId);
				DBDataSource.callOperation("ST_ProjectContractChange","find", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							//获取该项目的扣减积分
							BigDecimal integral = BaseHelpUtils.getBigDecimalValue(dsResponse.getData()[0].getAttribute("integral"));
							//获取归属业务部门
							int plateId = BaseHelpUtils.getIntValue(dsResponse.getData()[0].getAttribute("plateId"));
							integralItem.setValue(integral);
							leftIntegralItem.setValue(integral);
							plateIdItem.setValue(plateId);
							plateIntegralItem.setValue(0);
							load(projectId);
						} else {
							SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
						}
					}
				});
            }
        });
        
        integralItem = new DoubleItem("integral", "扣减积分");
        integralItem.setCanEdit(false);
        integralItem.setLength(18);
        integralItem.setDecimalPad(2);
        integralItem.setFormat("#,###,###,###,###,##0.00");
        integralItem.setDefaultValue(0);
        integralItem.setWidth("*");
		
        leftIntegralItem = new DoubleItem("leftIntegral", "剩余扣减积分");
        leftIntegralItem.setCanEdit(false);
        leftIntegralItem.setLength(18);
        leftIntegralItem.setDecimalPad(2);
        leftIntegralItem.setFormat("#,###,###,###,###,##0.00");
        leftIntegralItem.setDefaultValue(0);
        leftIntegralItem.setWidth("*");
        
        plateIdItem = new ComboBoxItem("plateId","归属部门");
        plateIdItem.setCanEdit(false);
        plateIdItem.setDefaultValue(0);
        plateIdItem.setWidth("*");
        plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
        
        plateIntegralItem = new DoubleItem("plateIntegral", "部门承担积分");
        plateIntegralItem.setLength(18);
        plateIntegralItem.setDecimalPad(2);
        plateIntegralItem.setFormat("#,###,###,###,###,##0.00");
        plateIntegralItem.setDefaultValue(0);
        plateIntegralItem.setWidth("*");
        plateIntegralItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				//更新剩余积分
				BigDecimal leftIntegral = BaseHelpUtils.getBigDecimalValue(leftIntegralItem.getValue());
				//获取项目ID
				int projectId = BaseHelpUtils.getIntValue(projectIdItem._getValue());
				if(projectId == 0){//说明未选择项目
					SC.say("提示","请选择项目");
					return;
				}
				//获取更改前的值
				BigDecimal oldValue = BaseHelpUtils.getBigDecimalValue(event.getOldValue());
				//获取变更后的值
				BigDecimal newValue = BaseHelpUtils.getBigDecimalValue(event.getValue());
				if(newValue.compareTo(BigDecimal.ZERO) < 0){
					SC.say("提示","不可输入负数积分");
					event.cancel();
				}
				//设置变化的最终值
				BigDecimal finalValue = newValue.subtract(oldValue);
				//判断剩余积分是否够分配
				if(leftIntegral.compareTo(finalValue) < 0){//说明剩余积分不够分配
					SC.say("提示","不可输入过多的积分");
					event.cancel();
				}else{
					leftIntegralItem.setValue(leftIntegral.subtract(finalValue));
				}
			}
		});
        
        recordDateItem = new DateItem("advanceDate", "日期");
        recordDateItem.setWidth("*");
        recordDateItem.setDefaultValue(new Date());
        recordDateItem.setDisabled(true);
        recordDateItem.setUseTextField(true);
        recordDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
        
        remarkItem = new TextAreaItem("remark", "备注");
        remarkItem.setColSpan(6);
        remarkItem.setRowSpan(3);
        remarkItem.setWidth("*");
		
		form.setItems(projectIdItem,integralItem,leftIntegralItem,plateIdItem,plateIntegralItem,recordDateItem, remarkItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		messageLayout.addMember(form);
		formLayout.addMember(messageLayout);
		
		grid.setDataSource(DSProjectChangeEmployee.getInstance());
		grid.setHeight("60%");
		grid.setWidth100();
		formLayout.addMember(grid);
		grid.addCellDoubleClickHandler(new CellDoubleClickHandler() {
			@Override
			public void onCellDoubleClick(CellDoubleClickEvent event) {
				Record record = event.getRecord();
				SC.askforValue("提示","请输入分配积分",new ValueCallback() {
					@Override
					public void execute(String value) {
						//获取改变前的数据
						BigDecimal oldValue = BaseHelpUtils.getBigDecimalValue(record.getAttribute("integral"));
						//获取新输入的数据
						BigDecimal newValue = BaseHelpUtils.getBigDecimalValue(value);
						if(newValue.compareTo(BigDecimal.ZERO) < 0){
							SC.say("提示","不可输入负数积分");
							return;
						}
						//设置改变后的最终值
						BigDecimal finalValue = newValue.subtract(oldValue);
						//获取剩余积分
		                BigDecimal leftIntegral = BaseHelpUtils.getBigDecimalValue(leftIntegralItem.getValue());
						//判断剩余积分是否够分配
						if(leftIntegral.compareTo(finalValue) < 0){//说明剩余积分不够分配
							SC.say("提示","不可输入过多的积分");
						}else{
							leftIntegralItem.setValue(leftIntegral.subtract(finalValue));
							record.setAttribute("integral",newValue);
							grid.updateData(record);
						}
					}
				});
			}
		});

		HLayout btnLayout = new HLayout();
		btnLayout.setWidth100();
		btnLayout.setHeight("5%");
		btnLayout.setMembersMargin(10);
		btnLayout.setAlign(Alignment.RIGHT);
		
		IButton okBtn = new IButton("提交");
		okBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				SC.ask("提示", "您确认要进行提交操作吗?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if (value) {
							//获取当前的项目id
							final int projectId = ClientUtil.checkAndGetIntValue(projectIdItem.getValue());
							if(projectId == 0){
								SC.say("提示", "请选择您要扣减的项目");
								return;
							}
							//获取剩余积分
			                BigDecimal leftIntegral = BaseHelpUtils.getBigDecimalValue(leftIntegralItem.getValue());
			                if(leftIntegral.compareTo(BigDecimal.ZERO) != 0){//说明还有未分配的积分
			                	SC.say("提示","请将剩余积分分配完");
			                	return;
			                }
			                //获取部门分摊积分
			                BigDecimal plateIntegral = BaseHelpUtils.getBigDecimalValue(plateIntegralItem.getValue());
							//获取备注信息
							final String remark =remarkItem.getValueAsString();
							//获取当前操作人
							int operateEmployeeId = ClientUtil.getEmployeeId();
							LinkedHashMap<String,Object> params = new LinkedHashMap<>();
							params.put("projectId", projectId);
							params.put("plateIntegral", plateIntegral);
							params.put("remark", remark);
							params.put("operateEmployeeId", operateEmployeeId);
							params.put("optType", "onProjectContractSave");
							MapUtils.convertRecordToMap(grid.getDataSource(), grid.getRecords(), params,
									"projectChangeEmployeeList");
							DBDataSource.callOperation("EP_OnProjectCommonProcess",params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() >= 0) {
										SC.say("提示","操作成功");
										getParentWindow().destroy();
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
		params.put("status", 0);//只检索在职的
		DBDataSource.callOperation("NQ_OnLoadProjectChangeEmployee", params, new DSCallback() {
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
