package com.pomplatform.client.common;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.employeerescord.panel.EmployeePanel;
import com.pomplatform.client.manageprojectemployee.datasource.DSManageProjectEmployee;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditorExitEvent;
import com.smartgwt.client.widgets.grid.events.EditorExitHandler;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class SetManageProjectIntegralAssign extends HLayout implements HasHandlers {

    private Window parentWindow;
    private static Logger __logger = Logger.getLogger("");
    private TextItem manageProjectNameItem;
    private DoubleItem totalIntegralItem;
    private DoubleItem leftIntegralItem;
    private TextAreaItem remarkItem;
    private DateItem assignDateItem;
    public static DelicacyListGrid grid;

    public void initComponents(final int manageProjectId,String manageProjectName ,final double totalIntegral,final double leftIntegral) {
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
        form.setNumCols(8);
        form.setAlign(Alignment.CENTER);
        form.setWidth("95%");
        form.setHeight100();
        
        manageProjectNameItem = new TextItem("manageProjectName", "项目名称");
        manageProjectNameItem.setWidth("*");
        manageProjectNameItem.setDefaultValue(manageProjectName);
        manageProjectNameItem.setCanEdit(false);

        totalIntegralItem = new DoubleItem("totalIntegral", "项目总积分");
        totalIntegralItem.setCanEdit(false);
        totalIntegralItem.setDefaultValue(totalIntegral);
        totalIntegralItem.setWidth("*");
        
        leftIntegralItem = new DoubleItem("leftIntegral", "剩余积分");
        leftIntegralItem.setCanEdit(false);
        leftIntegralItem.setDefaultValue(leftIntegral);
        leftIntegralItem.setWidth("*");
        
        assignDateItem = new DateItem("assignDate","发放日期");
        assignDateItem.setWidth("*");
        assignDateItem.setDefaultValue(new Date());
        assignDateItem.setShowIcons(false);
        assignDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
        
        remarkItem = new TextAreaItem("remark", "备注");
        remarkItem.setColSpan(8);
        remarkItem.setRowSpan(3);
        remarkItem.setWidth("*");

        form.setItems(manageProjectNameItem,totalIntegralItem,leftIntegralItem,assignDateItem,remarkItem);
        ClientUtil.DynamicFormProcessAccordingToDevice(form);
        messageLayout.addMember(form);
        formLayout.addMember(messageLayout);
        
        HLayout planLayout = new HLayout();
        planLayout.setWidth100();
        planLayout.setHeight("65%");
        
        EmployeePanel employee = new EmployeePanel();
        employee.setFlag(1);
        employee.setHeight100();
        employee.setWidth("50%");
        planLayout.addMember(employee);
        
        grid.setDataSource(DSManageProjectEmployee.getInstance());
        grid.setCanRemoveRecords(true);
        grid.setHeight100();
        grid.setWidth("50%");
        planLayout.addMember(grid);
        grid.addEditorExitHandler(new EditorExitHandler() {
            @Override
            public void onEditorExit(EditorExitEvent event) {
                ListGridRecord newRecord = event.getRecord();
                //获取改变前的发放积分
                double oldAssignIntegral= ClientUtil.checkAndGetDoubleValue(newRecord.getAttribute("assignIntegral"));
                //获取当前输入的发放积分
                double newAssignIntegral = null == event.getNewValue() ? oldAssignIntegral : ClientUtil.checkAndGetDoubleValue(event.getNewValue());
                //获取改变前和改变后的差值
                double finalAssignIntegral = newAssignIntegral - oldAssignIntegral;
                //获取到剩余积分
                double leftIntegralValue = ClientUtil.checkAndGetDoubleValue(leftIntegralItem.getValue());
                if(leftIntegralValue < 0){
                    SC.say("提示","该项目未有可发放的积分");
                    event.cancel();
                    return;
                }
                if(finalAssignIntegral > leftIntegralValue){
                    SC.say("提示","您输入的发放积分过多，请重新分配");
                    event.cancel();
                    return;
                }
                BigDecimal leftIntegralValueBig = new BigDecimal(Double.toString(leftIntegralValue));
        		BigDecimal finalAssignIntegralBig = new BigDecimal(Double.toString(finalAssignIntegral));
                //根据输入的发放积分更新剩余积分
                leftIntegralItem.setValue(leftIntegralValueBig.subtract(finalAssignIntegralBig));
            }
        });
        
        grid.addRemoveRecordClickHandler(new RemoveRecordClickHandler() {
            @Override
            public void onRemoveRecordClick(RemoveRecordClickEvent event) {
                //获取当前移除数据所在行
                int rowNum = event.getRowNum();
                //获取当前行的record数据
                Record record = grid.getRecord(rowNum);
                //检索当前记录是否已有发放的积分，如果有则不可删除
                double assignedIntegral = ClientUtil.checkAndGetDoubleValue(record.getAttribute("assignedIntegral"));
                if(assignedIntegral > 0){
                	SC.say("提示","当前人员已有发放积分,不可移除");
                	event.cancel();
                }
                //获取当前record的发放积分值
                double removeAssignIntegral = ClientUtil.checkAndGetDoubleValue(record.getAttribute("assignIntegral"));
                //获取发放的剩余积分
                double leftIntegralValue = ClientUtil.checkAndGetDoubleValue(leftIntegralItem.getValue());
                leftIntegralItem.setValue(leftIntegralValue+removeAssignIntegral);
            }
        });
        
        formLayout.addMember(planLayout);
        
        HLayout btnLayout = new HLayout();
        btnLayout.setWidth100();
        btnLayout.setHeight("5%");
        btnLayout.setMembersMargin(10);
        btnLayout.setAlign(Alignment.RIGHT);

        IButton okBtn = new IButton("提交");
        okBtn.setIcon("[SKIN]/actions/save.png");
        okBtn.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                ListGridRecord[] records = grid.getRecords();
                double totalAssignIntegral = 0;
                if(records.length==0){
                    SC.say("提示", "请选择需要发放的人员");
                    return;
                }else{
                    for(ListGridRecord record : records){
                    	totalAssignIntegral += ClientUtil.checkAndGetDoubleValue(record.getAttribute("assignIntegral"));
                    }
                }
                
                if(totalAssignIntegral == 0){
                	SC.say("提示", "未给成员设定发放的积分,请为职员分配发放积分");
                    return;
                }
                
                //获取结算日期
                Date assignDate = assignDateItem.getValueAsDate();
                //获取剩余积分
                double leftIntegralValue = ClientUtil.checkAndGetDoubleValue(leftIntegralItem.getValue());
                //获取备注
                String remark = (String) remarkItem.getValue();
                //获取当前操作人的id
                int operateEmployeeId = ClientUtil.getEmployeeId();
                LinkedHashMap params = new LinkedHashMap();
                params.put("operateEmployeeId", operateEmployeeId);
                params.put("manageProjectId", manageProjectId);
                params.put("leftIntegral", leftIntegralValue);
                params.put("assignDate", assignDate);
                params.put("remark", remark);
                MapUtils.convertRecordToMap(grid.getDataSource(), grid.getRecords(), params, "employeeAssign");
                DBDataSource.callOperation("EP_OnManageProjectIntegralAssign", params, new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        if (dsResponse.getStatus() >= 0) {
                        	load(manageProjectId);
//                            SC.say("操作成功");
//                            if (getParentWindow() == null) {
//                                return;
//                            }
//                            getParentWindow().destroy();
//                            DataEditEvent dee = new DataEditEvent();
//                            fireEvent(dee);
                        } else {
                            SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
                        }
                    }
                });
            }
        });
        IButton cleanBtn = new IButton("关闭");
        cleanBtn.setIcon("[SKIN]/actions/close.png");
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
     * @param manageProjectId
     */
    public void load(int manageProjectId) {
        if (manageProjectId == 0) {
            return;
        }
        Map params = new HashMap();
        params.put("manageProjectId", manageProjectId);
        DBDataSource.callOperation("NQ_ManageProjectEmployee", params, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0 ) {
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
