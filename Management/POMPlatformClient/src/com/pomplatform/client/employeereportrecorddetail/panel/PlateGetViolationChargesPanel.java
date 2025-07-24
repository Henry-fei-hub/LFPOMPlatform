package com.pomplatform.client.employeereportrecorddetail.panel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.employeerescord.datasource.DSPlateGetViolationCharges;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
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
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PlateGetViolationChargesPanel extends HLayout implements HasHandlers {

    private Window parentWindow;
    private static Logger __logger = Logger.getLogger("");
    private SelectItem plateIdItem;
    private DateItem violationDateItem;
    private TextAreaItem remarkItem;
    private EmployeeMonthlyAchieveIntegralPanel employeePanel;
    public static DelicacyListGrid grid;

    public void initComponents(final int plateId) {
    	
        grid = new DelicacyListGrid(true);
        setWidth("98%");
        setHeight100();
        setPadding(10);
        setMembersMargin(5);

        VLayout formLayout = new VLayout();
        formLayout.setHeight100();
        formLayout.setMembersMargin(5);
        formLayout.setWidth("98%");
        formLayout.setAlign(Alignment.CENTER);
        addMember(formLayout);

        HLayout messageLayout = new HLayout();
        messageLayout.setWidth100();
        messageLayout.setHeight("30%");
        messageLayout.setAlign(Alignment.CENTER);

        final DynamicForm form = new DynamicForm();
        form.setNumCols(4);
        form.setAlign(Alignment.CENTER);
        form.setWidth("95%");
        form.setHeight100();
        
        plateIdItem = new SelectItem("plateId", "业务部门");
        plateIdItem.setWidth("*");
        plateIdItem.setDefaultValue(plateId);
        plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
        plateIdItem.setCanEdit(false);
        
        violationDateItem = new DateItem("violationDate","操作日期");
        violationDateItem.setWidth("*");
        violationDateItem.setDefaultValue(new Date());
        violationDateItem.setDisabled(true);
        violationDateItem.setUseTextField(true);
        violationDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
        
        remarkItem = new TextAreaItem("remark", "备注");
        remarkItem.setColSpan(4);
        remarkItem.setRowSpan(3);
        remarkItem.setWidth("*");

        form.setItems(plateIdItem,violationDateItem,remarkItem);
        ClientUtil.DynamicFormProcessAccordingToDevice(form);
        messageLayout.addMember(form);
        formLayout.addMember(messageLayout);
        
        HLayout planLayout = new HLayout();
        planLayout.setWidth100();
        planLayout.setHeight("65%");
        
        employeePanel = new EmployeeMonthlyAchieveIntegralPanel();
        employeePanel.setHeight100();
        employeePanel.setWidth("50%");
        planLayout.addMember(employeePanel);
        
        int idx = 0;
        ListGridField[] fields = new ListGridField[3];
        fields[idx] = new ListGridField("plateId");
        fields[idx].setShowGridSummary(false);
        idx++;
        fields[idx] = new ListGridField("employeeId");
        fields[idx].setShowGridSummary(false);
        idx++;
        fields[idx] = new ListGridField("violationCharges");
        TextItem violationChargesText = new TextItem();
        violationChargesText.setFormat("##,###,###,##0.00000");
        fields[idx].setEditorProperties(violationChargesText);
        
        grid.setFields(fields);
        grid.setShowRowNumbers(true);
        grid.setAutoFitFieldWidths(false);
        grid.setShowGridSummary(true);
        grid.setDataSource(DSPlateGetViolationCharges.getInstance());
        grid.setCanRemoveRecords(true);
        grid.setHeight100();
        grid.setWidth("50%");
        planLayout.addMember(grid);
        
        formLayout.addMember(planLayout);
        
        HLayout btnLayout = new HLayout();
        btnLayout.setWidth100();
        btnLayout.setHeight("5%");
        btnLayout.setMembersMargin(10);
        btnLayout.setAlign(Alignment.RIGHT);

        IButton recordButton = new IButton("记录");
        recordButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow window = new PopupWindow();
				ViolationChargesEmpRecordPanel panel = new ViolationChargesEmpRecordPanel();
				window.setWidth("80%");
				window.setHeight("80%");
				window.addItem(panel);
				panel.initComponents();
				panel.setPlateId(plateId);
				panel.loadGridData();
				window.setTitle("记录");
				window.centerInPage();
				window.show();
			}
		});
        
        
        IButton submitButton = new IButton("提交");
        submitButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	Map<String, Object> params = getValueAsMap();
            	if(null != params){
            		final LoadingWindow loading = new LoadingWindow();
            		DBDataSource.callOperation("EP_PlateGetViolationChargesProcessor", params, new DSCallback() {
                        @Override
                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        	loading.destroy();
                            if (dsResponse.getStatus() >= 0) {
                                SC.say("操作成功");
                                if (getParentWindow() == null) {
                                    return;
                                }
                                getParentWindow().destroy();
                                DataEditEvent dee = new DataEditEvent();
                                fireEvent(dee);
                            } else {
                                SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
                            }
                        }
                    });
            	}
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
        btnLayout.addMember(recordButton);
        btnLayout.addMember(submitButton);
        btnLayout.addMember(closeButton);
        formLayout.addMember(btnLayout);
    }
    
    /**
     * 加载页面时加载该方法
     * @param manageProjectId
     */
    public void load(int plateId) {
    	employeePanel.setPlateId(plateId);
    	employeePanel.commonQuery();
    }
    
    protected final HandlerManager handlerManager = new HandlerManager(this);
    protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

    public Map<String, Object> getValueAsMap(){
    	Map<String, Object> map = new HashMap<>();
    	int operator = ClientUtil.getEmployeeId();
    	Object violationDate = violationDateItem.getValue();
    	Object plateId = plateIdItem.getValue();
    	Object remark = remarkItem.getValue();
    	ListGridRecord[] records = grid.getRecords();
    	if(null == plateId){
    		SC.say("请选择业务部门");
    		return null;
    	}else if(null == violationDate){
    		SC.say("请选择违规日期");
    		return null;
    	}else if(null == remark){
    		SC.say("请填写上备注");
    		return null;
    	}else if(null == records || (null != records && records.length == 0)){
    		SC.say("请填写职员违规金清单信息");
    		return null;
    	}
    	map.put("plateId", plateId);
    	map.put("violationDate", violationDate);
    	map.put("remark", remark);
    	map.put("operator", operator);
    	MapUtils.convertRecordToMap(grid.getDataSource(), grid.getRecords(), map,
				"violationList");
    	return map;
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
