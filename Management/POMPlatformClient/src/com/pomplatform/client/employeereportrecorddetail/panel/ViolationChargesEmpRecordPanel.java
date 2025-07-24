package com.pomplatform.client.employeereportrecorddetail.panel;

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
import com.pomplatform.client.shift.datasource.DSOnLoadEmployeeCheckDetail;
import com.pomplatform.client.shift.datasource.DSOnLoadEmployeeShiftDetailOfShift;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ViolationChargesEmpRecordPanel extends HLayout implements HasHandlers {

	private static Logger __logger = Logger.getLogger("");
    private Window parentWindow;
    public static DelicacyListGrid grid;
    private HLayout searchLayout;
    private HLayout formLayout;
    private HLayout buttonLayout;
    private HLayout gridLayout;
    private VLayout allLayout;
    private DynamicForm searchForm;
    
    private ComboBoxItem employeeIdItem;
    private DateItem startDateItem;
    private DateItem endDateItem;
    
    public void initComponents() {
    	searchForm = new DynamicForm();
    	searchForm.setNumCols(6);
    	searchForm.setAlign(Alignment.CENTER);
    	searchForm.setWidth100();
    	searchForm.setHeight100();
    	
    	employeeIdItem = new ComboBoxItem("employeeId","职员姓名");
    	employeeIdItem.setWidth("*");
    	employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
    	employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
    	
    	startDateItem = new DateItem("startDate","开始日期");
    	startDateItem.setUseTextField(true);
    	startDateItem.setWidth("*");
    	startDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
    	
    	endDateItem = new DateItem("endDate","截止日期");
    	endDateItem.setUseTextField(true);
    	endDateItem.setWidth("*");
    	endDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
    	searchForm.setItems(employeeIdItem,startDateItem,endDateItem);
    	ClientUtil.DynamicFormProcessAccordingToDevice(searchForm);
    	
    	searchLayout = new HLayout(10);
    	searchLayout.setWidth100();
    	searchLayout.setHeight("10%");
    	
    	formLayout = new HLayout(10);
    	formLayout.setWidth("90%");
    	formLayout.setHeight100();
    	formLayout.addMember(searchForm);
    	searchLayout.addMember(formLayout);
    	
    	IButton searchButton = new IButton("搜索");
    	searchButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				loadGridData();
			}
		});
    	
    	buttonLayout = new HLayout(10);
    	buttonLayout.setWidth("10%");
    	buttonLayout.setHeight100();
    	buttonLayout.setLayoutTopMargin(20);
    	buttonLayout.addMember(searchButton);
    	searchLayout.addMember(buttonLayout);
    	
    	grid = new DelicacyListGrid();
        int idx = 0;
        ListGridField[] fields = new ListGridField[6];
        fields[idx] = new ListGridField("employeeId","职员姓名");
        fields[idx].setHidden(false);
        fields[idx].setValueMap(KeyValueManager.getValueMap("employees"));
        idx++;
        fields[idx] = new ListGridField("plateId","业务部门");
        fields[idx].setCanEdit(false);
        fields[idx].setValueMap(KeyValueManager.getValueMap("plate_records"));
        idx++;
        fields[idx] = new ListGridField("violationCharges","积分");
        fields[idx].setCanEdit(false);
        idx++;
        fields[idx] = new ListGridField("violationDate","日期");
        fields[idx].setCanEdit(false);
        fields[idx].setFormat("yyyy-MM-dd");
        idx++;
        fields[idx] = new ListGridField("status","状态");
        fields[idx].setValueMap(KeyValueManager.getValueMap("system_dictionary_118"));
        
        grid.setFields(fields);
        grid.setShowGridSummary(false);
        grid.setAutoFitFieldWidths(false);
        grid.setHeight100();
        grid.setWidth100();
        grid.setShowRowNumbers(true);
        
        gridLayout = new HLayout(10);
        gridLayout.setWidth100();
        gridLayout.setHeight("90%");
        gridLayout.addMember(grid);
        
        allLayout = new VLayout(10);
        allLayout.setWidth100();
        allLayout.setHeight100();
        allLayout.addMember(searchLayout);
        allLayout.addMember(gridLayout);
        
        addMember(allLayout);
    }
    
    public void loadGridData(){
    	Map<String,Object> params = new HashMap<>();
    	params.put("plateId", plateId);
    	params.put("operator", ClientUtil.getEmployeeId());
    	if(!BaseHelpUtils.isNullOrEmpty(employeeIdItem.getValue())){
    		params.put("employeeId", employeeIdItem.getValue());
    	}
    	if(!BaseHelpUtils.isNullOrEmpty(startDateItem.getValue())){
    		params.put("startDate", startDateItem.getValue());
    	}
    	if(!BaseHelpUtils.isNullOrEmpty(endDateItem.getValue())){
    		params.put("endDate", endDateItem.getValue());
    	}
    	DBDataSource.callOperation("NQ_EmployeeViolationCharges", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					grid.setData(dsResponse.getData());
				}
			}
		});

    }
    
    protected final HandlerManager handlerManager = new HandlerManager(this);
    protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();
    private int plateId;
    
    public int getPlateId() {
		return plateId;
	}

	public void setPlateId(int plateId) {
		this.plateId = plateId;
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
