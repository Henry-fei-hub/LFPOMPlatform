package com.pomplatform.client.common;

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
import com.pomplatform.client.employeerescord.panel.EmployeePanel;
import com.pomplatform.client.settlement.datasource.DSMemployeeIntegral;
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
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditorExitEvent;
import com.smartgwt.client.widgets.grid.events.EditorExitHandler;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Logger;

public class SetPlateIntegralAssign extends HLayout implements HasHandlers {

    private Window parentWindow;
    private static Logger __logger = Logger.getLogger("");
    private ComboBoxItem plateIdItem;
    private TextItem reserveIntegralItem;
    private TextAreaItem remarkItem;
    private DateItem assignDateItem;
    public static DelicacyListGrid grid;

    public void initComponents() {
        grid = new DelicacyListGrid(true);
        setWidth100();
        setHeight100();
        setPadding(10);
        setMembersMargin(5);

        VLayout formLayout = new VLayout();
        formLayout.setHeight100();
        formLayout.setMembersMargin(5);
        formLayout.setWidth("100%");
        formLayout.setAlign(Alignment.CENTER);
        addMember(formLayout);

        HLayout messageLayout = new HLayout();
        messageLayout.setWidth100();
        messageLayout.setHeight("25%");
        messageLayout.setAlign(Alignment.CENTER);

        final DynamicForm form = new DynamicForm();
        form.setNumCols(6);
        form.setAlign(Alignment.CENTER);
        form.setWidth100();
        form.setHeight100();
        
        plateIdItem = new ComboBoxItem("plateId", "积分提取部门");
        plateIdItem.setWidth("*");
        plateIdItem.setCanEdit(false);
        //设置默认为当前操作人的业务部门
        plateIdItem.setDefaultValue(ClientUtil.getPlateId());
        plateIdItem.setChangeOnKeypress(false);
        plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

        reserveIntegralItem = new TextItem("reserveIntegral", "价值积分");
        reserveIntegralItem.setCanEdit(false);
        reserveIntegralItem.setDefaultValue(0);
        reserveIntegralItem.setWidth("*");
        
        assignDateItem = new DateItem("assignDate","发放日期");
        assignDateItem.setWidth("*");
        assignDateItem.setDefaultValue(new Date());
        assignDateItem.setShowIcons(false);
        assignDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
        
        remarkItem = new TextAreaItem("remark", "备注");
        remarkItem.setColSpan(6);
        remarkItem.setRowSpan(3);
        remarkItem.setWidth("*");

        form.setItems(plateIdItem,reserveIntegralItem,assignDateItem,remarkItem);
        ClientUtil.DynamicFormProcessAccordingToDevice(form);
        messageLayout.addMember(form);
        formLayout.addMember(messageLayout);
        
        HLayout planLayout = new HLayout();
        planLayout.setWidth100();
        planLayout.setHeight("70%");
        
        EmployeePanel employee = new EmployeePanel();
        employee.setHeight100();
        employee.setWidth("50%");
        planLayout.addMember(employee);
        
        grid.setDataSource(DSMemployeeIntegral.getInstance());
        grid.setCanRemoveRecords(true);
        grid.setHeight100();
        grid.setWidth("50%");
        planLayout.addMember(grid);
        grid.addEditorExitHandler(new EditorExitHandler() {
            @Override
            public void onEditorExit(EditorExitEvent event) {
                ListGridRecord newRecord = event.getRecord();
                //获取改变前的发放积分
                double oldAssignIntegral= ClientUtil.checkAndGetDoubleValue(newRecord.getAttribute("realIntegral"));
                //获取当前输入的发放积分
                double newAssignIntegral = ClientUtil.checkAndGetDoubleValue(event.getNewValue());
                //获取改变前和改变后的差值
                double finalAssignIntegral = newAssignIntegral - oldAssignIntegral;
                //获取到价值积分
                double reserveIntegral = ClientUtil.checkAndGetDoubleValue(reserveIntegralItem.getValue());
                if(reserveIntegral <= 0){
                    SC.say("提示","该部门目前没有可发放的价值积分");
                    return;
                }
                if(finalAssignIntegral > reserveIntegral){
                    SC.say("提示","您输入的发放积分过多，请重新分配");
                    return;
                }
                //根据输入的发放积分更新价值积分的值
                reserveIntegralItem.setValue(reserveIntegral-finalAssignIntegral);
            }
        });
        
        grid.addRemoveRecordClickHandler(new RemoveRecordClickHandler() {
            @Override
            public void onRemoveRecordClick(RemoveRecordClickEvent event) {
                //获取当前移除数据所在行
                int rowNum = event.getRowNum();
                //获取当前行的record数据
                Record record = grid.getRecord(rowNum);
                //获取当前record的发放积分值
                double removeReserveIntegral = ClientUtil.checkAndGetDoubleValue(record.getAttribute("realIntegral"));
                //获取发放的总价值积分
                double reserveIntegral = ClientUtil.checkAndGetDoubleValue(reserveIntegralItem.getValue());
                reserveIntegralItem.setValue(reserveIntegral+removeReserveIntegral);
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
                //获取提取积分的部门
                int plateId = ClientUtil.getPlateId();
                if(plateId <= 0){
                    SC.say("提示", "未获取到当前操作人的部门");
                    return;
                }
                ListGridRecord[] records = grid.getRecords();
                if(records.length==0){
                    SC.say("提示", "请选择需要发放的人员");
                    return;
                }else{
                    for(ListGridRecord record : records){
                        if(ClientUtil.checkAndGetDoubleValue(record.getAttribute("realIntegral")) == 0){
                            SC.say("提示", "有职员未设定发放的积分,请为职员分配发放积分");
                            return;
                        }
                    }
                }
                
                //获取当前板块负责人的ID
                int plateEmployeeId = ClientUtil.getEmployeeId();
                //获取结算日期
                Date assignDate = assignDateItem.getValueAsDate();
                //获取备注
                String remark = (String) remarkItem.getValue();
                LinkedHashMap params = new LinkedHashMap();
                params.put("plateId", plateId);
                params.put("plateEmployeeId", plateEmployeeId);
                params.put("assignDate", assignDate);
                params.put("remark", remark);
                params.put("opt_type", "allEmployeeAssign");
                MapUtils.convertRecordToMap(grid.getDataSource(), grid.getRecords(), params, "employeeAssign");
                DBDataSource.callOperation("EP_OnPlateReserveIntegralAssign", params, new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
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
            }
        });
        btnLayout.addMember(okBtn);
        btnLayout.addMember(cleanBtn);
        formLayout.addMember(btnLayout);
        //加载页面是加载数据，获取当前操作人的部门的价值积分
        int plateId = ClientUtil.getPlateId();
        getReserveInteralByProjectId(plateId);
    }
    
    /**
     * 根据选择下拉的获取业务部门价值积分
     * @param plateId
     */
    protected void getReserveInteralByProjectId(int plateId) {
        LinkedHashMap map = new LinkedHashMap();
        map.put("plateId", plateId);
        DBDataSource.callOperation("EP_OnGetPlateReserveIntegral", map, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    Record result = dsResponse.getData()[0];
                    //获取该业务部门价值积分
                    double achieveIntegral = ClientUtil.checkAndGetDoubleValue(result.getAttribute("achieveIntegral"));
                    reserveIntegralItem.setValue(achieveIntegral);
                    //根据目标部门的价值积分，设置可转移的最大积分为该目标部门的价值积分
//                    assignIntegralItem.setMax(achieveIntegral);
                } else {
                    SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
                }
            }
        });
    };

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
