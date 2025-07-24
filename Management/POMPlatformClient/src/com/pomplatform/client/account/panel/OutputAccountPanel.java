package com.pomplatform.client.account.panel;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.*;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LoadingWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.account.datasource.DSOnLoadEmployeeAccountByBusinessTypeData;
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
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Logger;

public class OutputAccountPanel extends HLayout implements HasHandlers {

    private Window parentWindow;
    private static Logger __logger = Logger.getLogger("");
    private SelectItem plateIdItem;
    private DoubleItem depAccountIntegralItem;
    private DoubleItem empAccountIntegralItem;
    private DateItem startDateItem;
    private DateItem endDateItem;
    private DateItem accountDateItem;
    private BooleanItem isYearFinalAccountItem;
    private TextAreaItem remarkItem;
    public static DelicacyListGrid grid;

    public void initComponents(final int plateId, final BigDecimal achieveIntegral) {
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
        messageLayout.setHeight("35%");
        messageLayout.setAlign(Alignment.CENTER);

        final DynamicForm form = new DynamicForm();
        form.setNumCols(8);
        form.setAlign(Alignment.CENTER);
        form.setWidth("95%");
        form.setHeight100();
        
        plateIdItem = new SelectItem("plateId", "业务部门");
        plateIdItem.setWidth("*");
        plateIdItem.setDefaultValue(plateId);
        plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
        plateIdItem.setCanEdit(false);

        depAccountIntegralItem = new DoubleItem("depAccountIntegral", "产值结算金额");
        depAccountIntegralItem.setWidth("*");
        depAccountIntegralItem.setCanEdit(false);
        depAccountIntegralItem.setValue(achieveIntegral);

        empAccountIntegralItem = new DoubleItem("empAccountIntegral", "成员产值结算总金额");
        empAccountIntegralItem.setWidth("*");
        empAccountIntegralItem.setCanEdit(false);
        empAccountIntegralItem.setFormat("##,###,###,##0.00");
        
        startDateItem = new DateItem("startDate","开始日期");
        startDateItem.setStartRow(true);
        startDateItem.setWidth("*");
        Date currentDate = new Date();
        Date startDate = new Date();
        startDate.setMonth(0);
        startDate.setDate(1);
        //设置为当前年度第一天
        startDateItem.setDefaultValue(startDate);
        startDateItem.setUseTextField(true);
        startDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
        startDateItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent changedEvent) {
                load(plateId);
            }
        });

        endDateItem = new DateItem("endDate","结束日期");
        endDateItem.setWidth("*");
        endDateItem.setDefaultValue(currentDate);
        endDateItem.setUseTextField(true);
        endDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
        endDateItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent changedEvent) {
                load(plateId);
                accountDateItem.setValue(changedEvent.getValue());
            }
        });

        accountDateItem = new DateItem("accountDate","结算日期");
        accountDateItem.setWidth("*");
        accountDateItem.setDefaultValue(currentDate);
        accountDateItem.setUseTextField(true);
        accountDateItem.setCanEdit(false);
        accountDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);

        isYearFinalAccountItem = new BooleanItem("isYearFinalAccount","是否是年度最有一次结算");
        isYearFinalAccountItem.setDefaultValue(Boolean.FALSE);
        isYearFinalAccountItem.setWidth("*");
        
        remarkItem = new TextAreaItem("remark", "备注");
        remarkItem.setColSpan(8);
        remarkItem.setRowSpan(3);
        remarkItem.setWidth("*");

        form.setItems(plateIdItem,depAccountIntegralItem,empAccountIntegralItem,startDateItem,endDateItem,accountDateItem,isYearFinalAccountItem,remarkItem);
        ClientUtil.DynamicFormProcessAccordingToDevice(form);
        messageLayout.addMember(form);
        formLayout.addMember(messageLayout);
        
        HLayout planLayout = new HLayout();
        planLayout.setWidth100();
        planLayout.setHeight("65%");

        grid.setShowRowNumbers(true);
        grid.setAutoFitFieldWidths(false);
        grid.setShowGridSummary(true);
        grid.setDataSource(DSOnLoadEmployeeAccountByBusinessTypeData.getInstance());
        grid.setCanRemoveRecords(false);
        grid.setHeight100();
        grid.setWidth100();
        planLayout.addMember(grid);
        formLayout.addMember(planLayout);
        HLayout btnLayout = new HLayout();
        btnLayout.setWidth100();
        btnLayout.setHeight("5%");
        btnLayout.setMembersMargin(10);
        btnLayout.setAlign(Alignment.RIGHT);

        IButton submitButton = new IButton("提交");
        submitButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	Map<String, Object> params = getValueAsMap();
                params.put("optType","onOutputAccountSave");
            	if(null != params){
            		final LoadingWindow loading = new LoadingWindow();
            		DBDataSource.callOperation("EP_AccountManageProcess", params, new DSCallback() {
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
        btnLayout.addMember(submitButton);
        btnLayout.addMember(closeButton);
        formLayout.addMember(btnLayout);
    }
    
    /**
     * 加载页面时加载该方法
     */
    public void load(int plateId) {
        Object startDate = startDateItem.getValue();
        if(BaseHelpUtils.isNullOrEmpty(startDate)){
            return;
        }
        Object endDate = endDateItem.getValue();
        if(BaseHelpUtils.isNullOrEmpty(endDate)){
            return;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("plateId", plateId);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("optType", "onLoadOutputAccountData");
        DBDataSource.callOperation("EP_AccountManageProcess", map, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    grid.setData(dsResponse.getData());
                    //获取userData
                    Map userData = BaseHelpUtils.getResponseUserData(dsResponse);
                    if(!BaseHelpUtils.isNullOrEmpty(userData)){
                        //获取部门总产值和人员总产值
                        BigDecimal depOutputIntegral = BaseHelpUtils.getBigDecimalValue(userData.get("depOutputIntegral"));
                        depAccountIntegralItem.setValue(depOutputIntegral);
                        BigDecimal empOutputIntegral = BaseHelpUtils.getBigDecimalValue(userData.get("empOutputIntegral"));
                        empAccountIntegralItem.setValue(empOutputIntegral);
                    }
                } else {
                    SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
                }
            }
        });
    }
    
    protected final HandlerManager handlerManager = new HandlerManager(this);
    protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

    public Map<String, Object> getValueAsMap(){
    	Map<String, Object> map = new HashMap<>();
    	int operator = ClientUtil.getEmployeeId();
    	Object startDate = startDateItem.getValue();
        Object endDate = endDateItem.getValue();
    	BigDecimal depAccountIntegral = BaseHelpUtils.getBigDecimalValue(depAccountIntegralItem.getValue());
    	BigDecimal empAccountIntegral = BaseHelpUtils.getBigDecimalValue(empAccountIntegralItem.getValue());
    	Object plateId = plateIdItem.getValue();
    	Object isYearFinalAccount = isYearFinalAccountItem.getValue();
    	Object remark = remarkItem.getValue();
    	ListGridRecord[] records = grid.getRecords();
    	if(null == plateId){
    		SC.say("请选择业务部门");
    		return null;
    	}else if(null == startDate){
    		SC.say("请选择开始日期");
    		return null;
    	}else if(null == endDate){
            SC.say("请选择结束日期");
            return null;
        }
    	map.put("plateId", plateId);
        map.put("depAccountIntegral", depAccountIntegral);
        map.put("empAccountIntegral", empAccountIntegral);
        map.put("startDate", startDate);
    	map.put("endDate", endDate);
        map.put("isYearFinalAccount", isYearFinalAccount);
    	map.put("remark", remark);
    	map.put("operateEmployeeId", operator);
    	MapUtils.convertRecordToMap(grid.getDataSource(), grid.getRecords(), map,
				"detailList");
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
