package com.pomplatform.client.shift.panel;

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
import com.delicacy.client.ui.LoadingWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.pomplatform.client.shift.datasource.DSOnLoadEmployeeShiftDetailOfShift;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class EmployeeShiftPanel extends HLayout implements HasHandlers {

	private static Logger __logger = Logger.getLogger("");
    private Window parentWindow;
    private DynamicForm form;
    private SelectItem shiftManageIdItem;
    private DateItem startDateItem;
    private DateItem endDateItem;
    private OnLoadEmployeeShiftDetailOfShiftPanel employeePanel;
    public static DelicacyListGrid grid;

    public void initComponents() {
    	employeePanel = new OnLoadEmployeeShiftDetailOfShiftPanel();
        grid = new DelicacyListGrid(true);
        grid.setAutoFitFieldWidths(false);
        setWidth100();
        setHeight100();
        setPadding(10);
        setMembersMargin(5);
        setBackgroundColor("#e2e2e2");

        VLayout totalLayout = new VLayout();
        totalLayout.setHeight100();
        totalLayout.setMembersMargin(5);
        totalLayout.setWidth("98%");
        totalLayout.setAlign(Alignment.CENTER);
        addMember(totalLayout);

        HLayout formLayout = new HLayout();
        formLayout.setWidth100();
        formLayout.setHeight("10%");
        formLayout.setAlign(Alignment.CENTER);

        form = new DynamicForm();
        form.setNumCols(7);
        form.setAlign(Alignment.CENTER);
        form.setWidth("95%");
        form.setHeight100();
        
        shiftManageIdItem = new SelectItem("shiftManageId", "选择班次");
        shiftManageIdItem.setWidth("*");
//        shiftManageIdItem.setValueMap(KeyValueManager.getValueMap("shift_manages"));
        KeyValueManager.loadValueMap("shift_manages",shiftManageIdItem);
        shiftManageIdItem.addChangeHandler(new ChangeHandler() {
        	@Override
        	public void onChange(ChangeEvent event) {
        		if (!BaseHelpUtils.isNullOrEmpty(event.getValue())) {
        			int shiftManageId = BaseHelpUtils.getIntValue(event.getValue());
        			Map<String,Object> params = new HashMap<>();
        			params.put("shiftManageId",shiftManageId);
        			DBDataSource.callOperation("ST_ShiftManage","find", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() < 0) {
								ClientUtil.displayErrorMessage(dsResponse);
							} else {
								Record record = dsResponse.getData()[0];
								Date startDateValue = record==null?new Date():record.getAttributeAsDate("startDate");
								Date endDateValue = record==null?new Date():record.getAttributeAsDate("endDate");
								setStartDate(startDateValue);
								setEndDate(endDateValue);
								setShiftManageId(shiftManageId);
								form.editNewRecord(record);
								employeePanel.setStartDate(startDateValue);
								employeePanel.setEndDate(endDateValue);
								employeePanel.setShiftManageId(shiftManageId);
							}
						}
					});
        		}
        	}
        });
        
        startDateItem = new DateItem("startDate","开始日期");
        startDateItem.setWidth("*");
        startDateItem.setUseTextField(true);
        startDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
        startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				DateTimeFormat df = DateTimeFormat.getFormat("yyyy-MM-dd");
				String startDateStr = df.format(startDate);
				String endDateStr = df.format(endDate);
				//限制改变的日期不可超过该班次的开始日期和结束日期
				Date startDateValue = (Date)event.getValue();
				//获取已设置的结束日期，当前操作的开始日期不可大于结束日期
				Date endDateValue = endDateItem.getValueAsDate();
				if(startDateValue.before(startDate)){
					SC.say("提示","当前设置日期不可超过该班次的有效开始日期("+startDateStr+")");
					startDateItem.setValue(startDate);
				}else if(startDateValue.after(endDate)){
					SC.say("提示","当前设置日期不可超过该班次的有效结束日期("+endDateStr+")");
					startDateItem.setValue(startDate);
				}else if(startDateValue.after(endDateValue)){
					SC.say("提示","当前设置开始日期不能晚于当前设置的结束日期");
					startDateItem.setValue(startDate);
				}else{
					employeePanel.setStartDate(startDateValue);
				}
				
			}
		});
        
        endDateItem = new DateItem("endDate","结束日期");
        endDateItem.setWidth("*");
        endDateItem.setUseTextField(true);
        endDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
        endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				DateTimeFormat df = DateTimeFormat.getFormat("yyyy-MM-dd");
				String startDateStr = df.format(startDate);
				String endDateStr = df.format(endDate);
				//限制改变的日期不可超过该班次的开始日期和结束日期
				Date endDateValue = (Date)event.getValue();
				//获取已设置的开始日期，当前操作的结束日期不可早于开始日期
				Date startDateValue = startDateItem.getValueAsDate();
				if(endDateValue.before(startDate)){
					SC.say("提示","当前设置日期不可超过该班次的有效开始日期("+startDateStr+")");
					endDateItem.setValue(endDate);
				}else if(endDateValue.after(endDate)){
					SC.say("提示","当前设置日期不可超过该班次的有效结束日期("+endDateStr+")");
					endDateItem.setValue(endDate);
				}else if(endDateValue.before(startDateValue)){
					SC.say("提示","当前设置结束日期不能早于当前设置的开始日期");
					endDateItem.setValue(endDate);
				}else{
					employeePanel.setEndDate(endDateValue);
				}
			}
		});
        
        form.setItems(shiftManageIdItem,startDateItem,endDateItem);
        ClientUtil.DynamicFormProcessAccordingToDevice(form);
        formLayout.addMember(form);
        totalLayout.addMember(formLayout);
        
        HLayout planLayout = new HLayout();
        planLayout.setWidth100();
        planLayout.setHeight("85%");
        planLayout.setBorder("1px solid #f2f2f2;border-top-width:5px;border-radius:5px;");
        
        employeePanel.setHeight100();
        employeePanel.setWidth("50%");
        planLayout.addMember(employeePanel);
        
        int idx = 0;
        ListGridField[] fields = new ListGridField[8];
        fields[idx] = new ListGridField("employeeId");
        fields[idx].setHidden(true);
        idx++;
        fields[idx] = new ListGridField("employeeNo");
        fields[idx].setCanEdit(false);
        idx++;
        fields[idx] = new ListGridField("employeeName");
        fields[idx].setCanEdit(false);
        idx++;
        fields[idx] = new ListGridField("gender");
        fields[idx].setCanEdit(false);
        idx++;
        fields[idx] = new ListGridField("departmentId");
        fields[idx].setCanEdit(false);
        idx++;
        fields[idx] = new ListGridField("isShift");
        fields[idx].setCanEdit(false);
        idx++;
        fields[idx] = new ListGridField("startDate","开始日期");
        fields[idx].setCanEdit(false);
        idx++;
        fields[idx] = new ListGridField("endDate","结束日期");
        fields[idx].setCanEdit(false);
        
        grid.setFields(fields);
        grid.setShowGridSummary(false);
        grid.setDataSource(DSOnLoadEmployeeShiftDetailOfShift.getInstance());
        grid.setCanRemoveRecords(true);
        grid.setHeight100();
        grid.setWidth("50%");
        planLayout.addMember(grid);
        
        totalLayout.addMember(planLayout);
        
        HLayout btnLayout = new HLayout();
        btnLayout.setWidth100();
        btnLayout.setHeight("5%");
        btnLayout.setMembersMargin(10);
        btnLayout.setLayoutTopMargin(10);
        btnLayout.setAlign(Alignment.RIGHT);

        IButton submitButton = new IButton("提交");
        submitButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	if(BaseHelpUtils.isNullOrEmpty(shiftManageId)) {
           		 	SC.say("班次不能为空");
           		 	return;
            	}
            	if(BaseHelpUtils.isNullOrEmpty(startDateItem.getValue())) {
            		 SC.say("开始时间不能为空");
            		 return;
            	}
            	if(BaseHelpUtils.isNullOrEmpty(endDateItem.getValue())) {
            		 SC.say("结束时间不能为空");
            		 return;
            	}         
            	
            	Map<String, Object> params = new HashMap<>();
            	params.put("optType","onSaveEmployeeShift");
            	params.put("shiftManageId",shiftManageId);
            	params.put("startDate",startDateItem.getValue());
            	params.put("endDate",endDateItem.getValue());
            	params.put("operateEmployeeId",ClientUtil.getEmployeeId());
            	MapUtils.convertRecordToMap(grid.getDataSource(), grid.getRecords(), params, "shiftEmployees");
            	submitButton.setDisabled(true);
            	final LoadingWindow loading = new LoadingWindow();
            	if(null != params){
            		DBDataSource.callOperation("EP_OnShiftManageProcess", params, new DSCallback() {
                        @Override
                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        	loading.destroy();
                        	submitButton.setDisabled(false);
//                            if (dsResponse.getStatus() >= 0) {
//                                SC.say("保存成功");
//                                if (getParentWindow() == null) {
//                                    return;
//                                }
//                                getParentWindow().destroy();
//                                DataEditEvent dee = new DataEditEvent();
//                                fireEvent(dee);
//                            } else {
                        	 SC.say(dsResponse.getErrors().get("errorMsg").toString());
//                            }
                        }
                    });
            	}
            }
        });
        
        IButton resetButton = new IButton("重置");
        resetButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				grid.setData(new RecordList());
				grid.redraw();
			}
		});
        
        IButton closeButton = new IButton("关闭");
        closeButton.addClickHandler(new ClickHandler() {
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
        btnLayout.addMember(submitButton);
        btnLayout.addMember(resetButton);
        btnLayout.addMember(closeButton);
        totalLayout.addMember(btnLayout);
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
    
    private Date startDate;
    private Date endDate;
    private Integer shiftManageId;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getShiftManageId() {
		return shiftManageId;
	}

	public void setShiftManageId(Integer shiftManageId) {
		this.shiftManageId = shiftManageId;
	}

	
    
}
