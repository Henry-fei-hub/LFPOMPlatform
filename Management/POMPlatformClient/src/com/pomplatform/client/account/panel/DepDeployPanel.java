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
import com.pomplatform.client.account.datasource.DSDepDeployDataSource;
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
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Logger;

public class DepDeployPanel extends HLayout implements HasHandlers {

    private Window parentWindow;
    private static Logger __logger = Logger.getLogger("");
    private SelectItem plateIdItem;
    private DoubleItem achieveIntegralItem;
    private DoubleItem advanceIntegralItem;
    private DateItem advanceDateItem;
    private TextAreaItem remarkItem;
    private DepDeployEmployeePanel employeePanel;
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
        messageLayout.setHeight("30%");
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

        achieveIntegralItem = new DoubleItem("achieveIntegral", "账户余额");
        achieveIntegralItem.setWidth("*");
        achieveIntegralItem.setCanEdit(false);
        achieveIntegralItem.setValue(achieveIntegral);

        advanceIntegralItem = new DoubleItem("advanceIntegral", "调配积分");
        advanceIntegralItem.setWidth("*");
        advanceIntegralItem.setCanEdit(false);
        advanceIntegralItem.setFormat("##,###,###,##0.00");
        
        advanceDateItem = new DateItem("advanceDate","调配日期");
        advanceDateItem.setWidth("*");
        advanceDateItem.setDefaultValue(new Date());
        advanceDateItem.setUseTextField(true);
        advanceDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
        
        remarkItem = new TextAreaItem("remark", "备注");
        remarkItem.setColSpan(8);
        remarkItem.setRowSpan(3);
        remarkItem.setWidth("*");

        form.setItems(plateIdItem,achieveIntegralItem,advanceIntegralItem,advanceDateItem,remarkItem);
        ClientUtil.DynamicFormProcessAccordingToDevice(form);
        messageLayout.addMember(form);
        formLayout.addMember(messageLayout);
        
        HLayout planLayout = new HLayout();
        planLayout.setWidth100();
        planLayout.setHeight("65%");
        
        employeePanel = new DepDeployEmployeePanel();
        employeePanel.setHeight100();
        employeePanel.setWidth("50%");
        planLayout.addMember(employeePanel);
        
        int idx = 0;
        ListGridField[] fields = new ListGridField[5];
        fields[idx] = new ListGridField("employeeId");
        fields[idx].setShowGridSummary(false);
        fields[idx].setHidden(true);
        idx++;
        fields[idx] = new ListGridField("employeeNo");
        idx++;
        fields[idx] = new ListGridField("employeeName");
        idx++;
        fields[idx] = new ListGridField("gender");
        idx++;
        fields[idx] = new ListGridField("departmentId");
        idx++;
        fields[idx] = new ListGridField("advanceIntegral","调配积分");
        TextItem violationChargesText = new TextItem();
        violationChargesText.setFormat("##,###,###,##0.00");
        fields[idx].setEditorProperties(violationChargesText);
        grid.setFields(fields);
        grid.setShowRowNumbers(true);
        grid.setAutoFitFieldWidths(false);
        grid.setShowGridSummary(true);
        grid.setDataSource(DSDepDeployDataSource.getInstance());
        grid.setCanRemoveRecords(true);
        grid.setHeight100();
        grid.setWidth("50%");
        planLayout.addMember(grid);
        grid.addEditCompleteHandler(new EditCompleteHandler() {
            @Override
            public void onEditComplete(EditCompleteEvent editCompleteEvent) {
                ListGridRecord[] records = grid.getRecords();
                if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
                    BigDecimal advanceIntegralTotal = BigDecimal.ZERO;
                    for(ListGridRecord e : records){
                        BigDecimal advanceIntegral = BaseHelpUtils.getBigDecimalValue(e.getAttribute("advanceIntegral"));
                        advanceIntegralTotal = advanceIntegralTotal.add(advanceIntegral);
                    }
                    advanceIntegralItem.setValue(advanceIntegralTotal);
                }
            }
        });
        grid.addRemoveRecordClickHandler(new RemoveRecordClickHandler() {
            @Override
            public void onRemoveRecordClick(RemoveRecordClickEvent removeRecordClickEvent) {
                int rowNum = removeRecordClickEvent.getRowNum();
                Record re = grid.getRecord(rowNum);
                if(!BaseHelpUtils.isNullOrEmpty(re)){
                    BigDecimal advanceIntegral = BaseHelpUtils.getBigDecimalValue(re.getAttribute("advanceIntegral"));
                    BigDecimal advanceIntegralTotal = BaseHelpUtils.getBigDecimalValue(advanceIntegralItem.getValue());
                    advanceIntegralTotal = advanceIntegralTotal.subtract(advanceIntegral);
                    advanceIntegralItem.setValue(advanceIntegralTotal);
                }
            }
        });
        
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
                params.put("optType","onPlateDeploySave");
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
    public void load() {
    	employeePanel.commonQuery();
    }
    
    protected final HandlerManager handlerManager = new HandlerManager(this);
    protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

    public Map<String, Object> getValueAsMap(){
    	Map<String, Object> map = new HashMap<>();
    	int operator = ClientUtil.getEmployeeId();
    	Object advanceDate = advanceDateItem.getValue();
    	BigDecimal advanceIntegral = BaseHelpUtils.getBigDecimalValue(advanceIntegralItem.getValue());
    	BigDecimal achieveIntegral = BaseHelpUtils.getBigDecimalValue(achieveIntegralItem.getValue());
    	Object plateId = plateIdItem.getValue();
    	Object remark = remarkItem.getValue();
    	ListGridRecord[] records = grid.getRecords();
    	if(null == plateId){
    		SC.say("请选择业务部门");
    		return null;
    	}else if(advanceIntegral.compareTo(achieveIntegral) > 0){
            SC.say("调配积分不可大于部门剩余积分");
            return null;
        }else if(null == advanceDate){
    		SC.say("请选择调配日期");
    		return null;
    	}else if(null == records || (null != records && records.length == 0)){
    		SC.say("请添加调配成员数据集");
    		return null;
    	}
    	map.put("plateId", plateId);
        map.put("advanceIntegral", advanceIntegral);
    	map.put("advanceDate", advanceDate);
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
