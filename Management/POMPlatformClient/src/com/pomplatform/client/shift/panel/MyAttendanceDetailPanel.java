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
import com.pomplatform.client.shift.datasource.DSOnLoadEmployeeCheckDetail;
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

public class MyAttendanceDetailPanel extends HLayout implements HasHandlers {

	private static Logger __logger = Logger.getLogger("");
    private Window parentWindow;
    public static DelicacyListGrid grid;

    public void initComponents() {
    	grid = new DelicacyListGrid();
        int idx = 0;
        ListGridField[] fields = new ListGridField[6];
        fields[idx] = new ListGridField("employeeId");
        fields[idx].setHidden(true);
        idx++;
        fields[idx] = new ListGridField("employeeNo","员工编号");
        fields[idx].setCanEdit(false);
        idx++;
        fields[idx] = new ListGridField("employeeName","员工姓名");
        fields[idx].setCanEdit(false);
        idx++;
        fields[idx] = new ListGridField("departmentId","所属部门");
        fields[idx].setCanEdit(false);
        fields[idx].setValueMap(KeyValueManager.getValueMap("departments"));
        idx++;
        fields[idx] = new ListGridField("checkDate","打卡日期");
        fields[idx].setCanEdit(false);
        idx++;
        fields[idx] = new ListGridField("checkTime","打卡时间");
        fields[idx].setCanEdit(false);
        fields[idx].setFormat("HH:mm:ss");
        
        grid.setFields(fields);
        grid.setShowGridSummary(false);
        grid.setAutoFitFieldWidths(false);
        grid.setHeight100();
        grid.setWidth100();
        addMember(grid);
    }
    
    public void loadGridData(Map<String,Object> map){
    	DBDataSource.callOperation("NQ_MyAttendanceDetail", map, new DSCallback() {
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
