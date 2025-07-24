package com.pomplatform.client.poolmanage.panel;

import java.util.ArrayList;
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
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.poolmanage.datasource.DSOnloadPoolEmployeeData;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PoolManagePanel extends HLayout implements HasHandlers {

	private static Logger __logger = Logger.getLogger("");
    private Window parentWindow;
    private DynamicForm form;
    private TextItem poolManageIdItem;
    private TextItem poolNameItem;
    private SelectItem poolTypeItem;
//    private SelectItem regionItem;
//    private SelectItem businessTypeItem;
    private TextAreaItem remarkItem;
    private PoolEmployeesPanel employeePanel;
    public static DelicacyListGrid grid;
    private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";

    public void initComponents() {
    	employeePanel = new PoolEmployeesPanel();
        
        
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
        formLayout.setHeight("25%");
        formLayout.setAlign(Alignment.CENTER);

        form = new DynamicForm();
        form.setNumCols(4);
        form.setAlign(Alignment.CENTER);
        form.setWidth("95%");
        form.setHeight100();
        
        poolManageIdItem = new TextItem("poolManageId","id");
        poolManageIdItem.setWidth("*");
        poolManageIdItem.hide();
        
        poolNameItem = new TextItem("poolName",shouldNotBeNull+"池子名称");
        poolNameItem.setWidth("*");
        
        poolTypeItem = new SelectItem("poolType",shouldNotBeNull+"池子类型");
        poolTypeItem.setWidth("*");
        poolTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_234"));
        
//        regionItem = new SelectItem("region",shouldNotBeNull+"地区");
//        regionItem.setWidth("*");
//        regionItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_170"));
//        
//        businessTypeItem = new SelectItem("businessType", shouldNotBeNull+"业态");
//		businessTypeItem.setWidth("*");
//		businessTypeItem.setValueMap(KeyValueManager.getValueMap("pre_business_type"));
		
		remarkItem = new TextAreaItem("remark","备注");
		remarkItem.setWidth("*");
		remarkItem.setColSpan(4);
		remarkItem.setRowSpan(3);
        
        form.setItems(poolNameItem,poolTypeItem,remarkItem);
        ClientUtil.DynamicFormProcessAccordingToDevice(form);
        formLayout.addMember(form);
        totalLayout.addMember(formLayout);
        
        HLayout planLayout = new HLayout();
        planLayout.setWidth100();
        planLayout.setHeight("75%");
        planLayout.setBorder("1px solid #f2f2f2;border-top-width:5px;border-radius:5px;");
        
        employeePanel.setHeight100();
        employeePanel.setWidth("50%");
        planLayout.addMember(employeePanel);
        
        grid = new DelicacyListGrid(){
			@Override
			protected Canvas createRecordComponent(final ListGridRecord record, Integer colNum) {
				
				String fieldName = this.getFieldName(colNum); 
				if (fieldName.equals("button")) { 
					HLayout recordCanvas = new HLayout(2);  
					recordCanvas.setHeight(18);  
					recordCanvas.setWidth100(); 
					recordCanvas.setMembersMargin(2);
					recordCanvas.setAlign(Alignment.LEFT);
					IButton businessButton = new IButton("设置业态");  
					businessButton.setAlign(Alignment.CENTER);
					recordCanvas.addMember(businessButton); 
					businessButton.addClickHandler(new ClickHandler() {  
						public void onClick(ClickEvent event) {  
							PopupWindow popupWindow = new PopupWindow("业态标签设置");
							popupWindow.setWidth("30%");
							popupWindow.setHeight("40%");
							popupWindow.centerInPage();
							SetBusinessPanel panel = new SetBusinessPanel();
							panel.addDataEditedHandler(new DataEditedHandler() {
								@Override
								public void onDataEdited(DataEditEvent event) {
									Record data = event.getData();
									record.setAttribute("businessIds", data.getAttribute("businessIds"));
									record.setAttribute("businessNames", data.getAttribute("businessNames"));
									grid.updateData(record);
									grid.redraw();
								}
							});
							panel.initComponents();
							panel.setData(record);
							popupWindow.addItem(panel);
							panel.setParentWindow(popupWindow);
							popupWindow.centerInPage();
							popupWindow.show();
						}  
					});  
					
					IButton professionalButton = new IButton("设置专业");  
					professionalButton.setAlign(Alignment.CENTER);  
					recordCanvas.addMember(professionalButton); 
					professionalButton.addClickHandler(new ClickHandler() {  
						public void onClick(ClickEvent event) {
							PopupWindow popupWindow = new PopupWindow("专业标签设置");
							popupWindow.setWidth("30%");
							popupWindow.setHeight("40%");
							popupWindow.centerInPage();
							SetProfessionalPanel panel = new SetProfessionalPanel();
							panel.addDataEditedHandler(new DataEditedHandler() {
								@Override
								public void onDataEdited(DataEditEvent event) {
									Record data = event.getData();
									record.setAttribute("professionalIds", data.getAttribute("professionalIds"));
									record.setAttribute("professionalNames", data.getAttribute("professionalNames"));
									grid.updateData(record);
									grid.redraw();
								}
							});
							panel.initComponents();
							panel.setData(record);
							popupWindow.addItem(panel);
							panel.setParentWindow(popupWindow);
							popupWindow.centerInPage();
							popupWindow.show();
						}  
					});  
					return recordCanvas;
				} else { 
					return null;  
				}  
			}
		};
		
		ListGridField employeeIdField = new ListGridField("employeeId","职员id");
		employeeIdField.setHidden(true);
		
		ListGridField employeeNoField = new ListGridField("employeeNo","员工编号");
		
		ListGridField employeeNameField = new ListGridField("employeeName","员工姓名");
		
		ListGridField genderField = new ListGridField("gender","性别");
		genderField.setHidden(true);
		genderField.setValueMap(KeyValueManager.getValueMap("system_dictionary_12"));
		
		ListGridField departmentIdField = new ListGridField("departmentId","部门");
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));
		
		ListGridField businessNamesField = new ListGridField("businessNames","业态");
		
		ListGridField professionalNamesField = new ListGridField("professionalNames","专业");
		
		ListGridField businessIdsField = new ListGridField("businessIds");
		businessIdsField.setHidden(true);
		
		ListGridField professionalIdsField = new ListGridField("professionalIds");
		professionalIdsField.setHidden(true);
		
		ListGridField buttonField = new ListGridField("button", "身份标签设置");
		
		grid.setShowRowNumbers(true);
		grid.setShowRecordComponents(true);          
		grid.setShowRecordComponentsByCell(true);
		grid.setFields(employeeIdField,employeeNoField,employeeIdField,employeeNameField,genderField,departmentIdField,businessNamesField,professionalNamesField,buttonField);
		grid.setAutoFitFieldWidths(false);
        grid.setShowGridSummary(false);
        grid.setDataSource(DSOnloadPoolEmployeeData.getInstance());
        grid.setCanRemoveRecords(true);
        grid.setHeight100();
        grid.setWidth("50%");
        grid.redraw();
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
            @SuppressWarnings("unchecked")
			@Override
            public void onClick(ClickEvent event) {
            	Map<String, Object> params = new HashMap<>();
            	//获取表单数据集
            	params = form.getValues();
            	if(BaseHelpUtils.isNullOrEmpty(params.get("poolName"))) {
            		SC.say("提示", "池子名称不可为空");
            		return;
            	}
            	if(BaseHelpUtils.isNullOrEmpty(params.get("poolType"))) {
            		SC.say("提示", "池子类型不可为空");
            		return;
            	}
            	params.put("optType","saveOrUpdatePoolManage");
            	MapUtils.convertRecordToMap(grid.getDataSource(), grid.getRecords(), params, "poolEmployeeList");
            	submitButton.setDisabled(true);
            	final LoadingWindow loading = new LoadingWindow();
            	if(null != params){
            		DBDataSource.callOperation("EP_PreProjectProcess", params, new DSCallback() {
                        @Override
                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        	loading.destroy();
                        	submitButton.setDisabled(false);
                            if (dsResponse.getStatus() >= 0) {
                                if (getParentWindow() == null) {
                                    return;
                                }
                                getParentWindow().destroy();
                                DataEditEvent dee = new DataEditEvent();
                                fireEvent(dee);
                            } else {
                            	SC.say(dsResponse.getErrors().get("errorMsg").toString());
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
        totalLayout.addMember(btnLayout);
    }
    
    public void setData(Record record) {
    	if(!BaseHelpUtils.isNullOrEmpty(record)) {
    		form.setValues(record.toMap());
    		//获取住建id
    		int poolManageId = BaseHelpUtils.getIntValue(record.getAttribute("poolManageId"));
    		if(poolManageId > 0) {
    			Map<String,Object> params = new HashMap<>();
    			params.put("poolManageId", poolManageId);
    			DBDataSource.callOperation("NQ_OnloadPoolEmployeeData","find", params, new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        if (dsResponse.getStatus() >= 0) {
                            grid.setData(dsResponse.getData());
                        } 
                    }
                });
    		}
    	}
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
