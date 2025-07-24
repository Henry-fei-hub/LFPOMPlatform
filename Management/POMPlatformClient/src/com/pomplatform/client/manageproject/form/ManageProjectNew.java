package com.pomplatform.client.manageproject.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
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
import com.smartgwt.client.widgets.form.fields.SpinnerItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ManageProjectNew extends HLayout implements HasHandlers {

    private Window parentWindow;
    private static Logger __logger = Logger.getLogger("");
    private TextItem manageProjectNameItem;
    private ComboBoxItem plateIdItem;
    private TextItem plateAchieveIntegralItem;
    private TextItem totalIntegralItem;
    private SpinnerItem assignIntegralItem;
    private TextAreaItem remarkItem;
    private DateItem projectDateItem;

    public void initComponents(final Integer manageProjectId,final double totalIntegral,String manageProjectName,final double leftIntegral,String remark) {
    	setWidth("98%");
        setHeight100();
        setPadding(10);
        setMembersMargin(5);

        VLayout formLayout = new VLayout();
        formLayout.setHeight100();
        formLayout.setMembersMargin(5);
        formLayout.setWidth100();
        formLayout.setAlign(Alignment.CENTER);
        addMember(formLayout);

        HLayout messageLayout = new HLayout();
        messageLayout.setWidth100();
        messageLayout.setHeight("80%");
        messageLayout.setAlign(Alignment.CENTER);

        final DynamicForm form = new DynamicForm();
        form.setNumCols(4);
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

        plateAchieveIntegralItem = new TextItem("fromIntegral", "积分提取部门(价值积分)");
        plateAchieveIntegralItem.setWidth("*");
        plateAchieveIntegralItem.setDisabled(true);
        plateAchieveIntegralItem.setDefaultValue(0);

        manageProjectNameItem = new TextItem("manageProjectName", "项目名称");
        manageProjectNameItem.setDefaultValue(manageProjectName);
        manageProjectNameItem.setWidth("*");
        
        totalIntegralItem = new TextItem("totalIntegral", "项目总积分");
        totalIntegralItem.setDefaultValue(totalIntegral);
        totalIntegralItem.setCanEdit(false);
        totalIntegralItem.setWidth("*");

        
        projectDateItem = new DateItem("projectDate","提取日期");
        projectDateItem.setWidth("*");
        projectDateItem.setDefaultValue(new Date());
        projectDateItem.setShowIcons(false);
        projectDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
        if(manageProjectId != null && manageProjectId >0){//当项目id>0时，则表示积分追加，则不更新日期
        	projectDateItem.setCanEdit(false);
        }
        
        assignIntegralItem = new SpinnerItem("assignIntegral", "提取积分");
        assignIntegralItem.setMin(0);
        assignIntegralItem.setStep(500f);
        assignIntegralItem.setWriteStackedIcons(false);
        assignIntegralItem.setDefaultValue(0);
        assignIntegralItem.setWidth("*");
        assignIntegralItem.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                //获取积分提取部门ID
                int plateId = ClientUtil.getPlateId();
                if (plateId <= 0) {
                    SC.say("提示", "未获取到当前操作人的部门");
                    assignIntegralItem.setValue(0);
                    return;
                }
                //获取新输入的积分值
                double newValue = ClientUtil.checkAndGetDoubleValue(event.getValue());
                //获取改变前的值
                double oldValue = ClientUtil.checkAndGetDoubleValue(event.getOldValue());
                //获取改变后与改变前的差值
                double finalValue = newValue - oldValue;
                //更新项目总积分
                totalIntegralItem.setValue(ClientUtil.checkAndGetDoubleValue(totalIntegralItem.getValue()) + finalValue);
                //更新部门价值积分
                plateAchieveIntegralItem.setValue(ClientUtil.checkAndGetDoubleValue(plateAchieveIntegralItem.getValue()) - finalValue);
            }
        });

        remarkItem = new TextAreaItem("remark", "备注");
        remarkItem.setDefaultValue(remark);
        remarkItem.setColSpan(4);
        remarkItem.setRowSpan(3);
        remarkItem.setWidth("*");

        form.setItems(plateIdItem, plateAchieveIntegralItem,manageProjectNameItem, totalIntegralItem,projectDateItem,assignIntegralItem,remarkItem);
        ClientUtil.DynamicFormProcessAccordingToDevice(form);
        messageLayout.addMember(form);
        formLayout.addMember(messageLayout);
        HLayout btnLayout = new HLayout();
        btnLayout.setWidth100();
        btnLayout.setHeight(70);
        btnLayout.setMembersMargin(10);
        btnLayout.setAlign(Alignment.CENTER);

        IButton okBtn = new IButton("提交");
        okBtn.setIcon("[SKIN]/actions/save.png");
        okBtn.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                if (!form.validate()) {
                    return;
                }
                //获取项目名称
                String manageProjectName = (String)manageProjectNameItem.getValue();
                //获取积分提取部门ID
                int plateId = ClientUtil.getPlateId();
                if (plateId <= 0) {
                    SC.say("提示", "未获取到当前操作人的部门");
                    assignIntegralItem.setValue(0);
                    totalIntegralItem.setValue(totalIntegral);
                    return;
                }
                //获取提取积分
                double assignIntegral = ClientUtil.checkAndGetDoubleValue(assignIntegralItem.getValue());
                if (assignIntegral <= 0) {
                    SC.say("提示", "请输入您要提取的积分");
                    return;
                }
                
                //获取项目总
                double totalIntegralValue = ClientUtil.checkAndGetDoubleValue(totalIntegralItem.getValue());
                Date projectDate;
                if(manageProjectId != null && manageProjectId >0){//当项目id>0时，则表示积分追加，则不更新日期
                	projectDate = null;
                }else{
                	//获取提取日期
                	projectDate = projectDateItem.getValueAsDate();
                }
                //获取备注
                String remark = (String) remarkItem.getValue();
                LinkedHashMap map = new LinkedHashMap();
                map.put("manageProjectId", manageProjectId);
                map.put("manageProjectName", manageProjectName);
                map.put("plateId", plateId);
                map.put("totalIntegral", totalIntegralValue);
                map.put("leftIntegral", leftIntegral+assignIntegral);
                map.put("projectDate", projectDate);
                map.put("remark", remark);
                DBDataSource.callOperation("EP_OnSaveOrUpdateManageProject", map, new DSCallback() {
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
				DataEditEvent dee = new DataEditEvent();
				fireEvent(dee);
            }
        });
        btnLayout.addMember(okBtn);
        btnLayout.addMember(cleanBtn);
        formLayout.addMember(btnLayout);
        //加载页面是加载数据，获取当前操作人的部门的可结算的预留积分
        int plateId = ClientUtil.getPlateId();
        getReserveInteralByProjectId(plateId);
    }

    /**
     * 根据选择下拉的获取业务部门可结算的预留积分
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
                    //获取该业务部门的价值积分
                    double achieveIntegral = ClientUtil.checkAndGetDoubleValue(result.getAttribute("achieveIntegral"));
                    plateAchieveIntegralItem.setValue(achieveIntegral);
                    //根据目标部门的价值积分，设置可转移的最大积分为该目标部门的价值积分
//                    assignIntegralItem.setMax(achieveIntegral);
                } else {
                    SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
                }
            }
        });
    }
    ;
    
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
