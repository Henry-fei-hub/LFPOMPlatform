package com.pomplatform.client.project.panel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.pomplatform.client.employeenew.datasource.DSSemployeeNew;
import com.pomplatform.client.selectgridemployeevalue.datasource.DSSelectGridEmployee;
import com.pomplatform.client.selectgridemployeevalue.datasource.DSSelectGridEmployeeValue;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.VLayout;

public class OnProjectPerformanceNodeEmployeeDesignPanel extends AbstractWizadPage {
    private final Logger __logger = Logger.getLogger("");
    private Window parWindow;
    private DelicacyListGrid oneGrid;
    private DelicacyListGrid twoGrid;
    public OnProjectPerformanceNodeEmployeeDesignPanel() {
    	DSSelectGridEmployeeValue employeeRecord = DSSelectGridEmployeeValue.getInstance();
    	ListGridField eNoField = new ListGridField("employeeNo");
        ListGridField eNameField = new ListGridField("employeeName");
        ListGridField departmentIdField = new ListGridField("departmentId");
        DelicacyListGrid employeeGrid = new DelicacyListGrid();
        employeeGrid.setFields(eNoField,eNameField,departmentIdField);
        employeeGrid.setShowFilterEditor(true);
        employeeGrid.setDataSource(employeeRecord);
        employeeGrid.setAutoFetchAsFilter(false);
        employeeGrid.setFilterOnKeypress(false);
        employeeGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
        employeeGrid.setSelectionType(SelectionStyle.SINGLE);//设置能选择一行

        Criteria c = new Criteria();
        c.addCriteria("status", 0);
    	//主板面板
    	VLayout mainLayout = new VLayout(10);
    	mainLayout.setHeight100();
    	mainLayout.setWidth100();
    	addMember(mainLayout);
    	
    	HLayout topLayout = new HLayout();
    	topLayout.setWidth100();
    	topLayout.setHeight("10%");
    	mainLayout.addMember(topLayout);
    	
    	DynamicForm form = new DynamicForm();
    	form.setPadding(30);
    	form.setWidth("40%");
    	form.setNumCols(2);
    	topLayout.addMember(form);
        
        SelectItem employeeIdItem = new SelectItem("employeeId","维护人员");
        employeeIdItem.setWidth("*");
        employeeIdItem.setMultiple(true);
        employeeIdItem.setChangeOnKeypress(false);
        employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
        employeeIdItem.setOptionDataSource(DSSelectGridEmployee.getInstance());
        employeeIdItem.setOptionCriteria(c);
        employeeIdItem.setValueField("employeeId");
        employeeIdItem.setDisplayField("employeeName");
        employeeIdItem.setPickListFields(eNoField, eNameField, departmentIdField);
        employeeIdItem.setPickListProperties(employeeGrid);
        form.setFields(employeeIdItem);
    	
        Label lableOne = new Label();  
        lableOne.setWidth("30%");  
        lableOne.setPadding(10);
        lableOne.setAlign(Alignment.LEFT);  
        lableOne.setValign(VerticalAlignment.CENTER);  
        lableOne.setIcon("icons/16/approved.png");  
        lableOne.setContents("<i><span style='color:blue;font-family:FangSong;font-size:1.2em; text-overflow:ellipsis;font-weight: bold'>点击添加拆分价人员</span></i>");
        topLayout.addMember(lableOne);
        
        lableOne.addClickHandler(new ClickHandler() {
			@SuppressWarnings({ "rawtypes"})
			@Override
			public void onClick(ClickEvent event) {
				//获取下拉列表的值
				Record record = employeeIdItem.getSelectedRecord();
				int employeeId = BaseHelpUtils.getIntValue(record.getAttribute("employeeId"));
				if(employeeId <= 0){
					SC.say("提示","请选择人员");
					return;
				}
				Record[] datas = oneGrid.getRecords();
				if(!BaseHelpUtils.isNullOrEmpty(datas) && datas.length > 0){
					for(Record e : datas){
						int empId = BaseHelpUtils.getIntValue(e.getAttribute("employeeId"));
						if(employeeId == empId){
							return;
						}
					}
				}
				Date date = new Date();
				record.setAttribute("recordTime", date);
				record.setAttribute("businessType", 1);
				record.setAttribute("remark", "拆分价");
				Map params = record.toMap();
				DBDataSource.callOperation("ST_ProjectPerformanceNodeEmployee","save",params, new DSCallback() {
		            @Override
		            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
		                if (dsResponse.getStatus() >= 0) {
		                	getOneData();
		                } else {
							Map errors = dsResponse.getErrors();
		                    SC.say("保存失败",errors.get("errorMsg")+"");
		                }
		            }
		        });
			}
		});
        
        Label lableTwo = new Label();  
        lableTwo.setWidth("30%");  
        lableTwo.setPadding(10);
        lableTwo.setAlign(Alignment.LEFT);  
        lableTwo.setValign(VerticalAlignment.CENTER);  
        lableTwo.setIcon("icons/16/approved.png");  
        lableTwo.setContents("<i><span style='color:blue;font-family:FangSong;font-size:1.2em; text-overflow:ellipsis;font-weight: bold'>点击添加订单下达人员</span></i>");
        topLayout.addMember(lableTwo);
        
        lableTwo.addClickHandler(new ClickHandler() {
			@SuppressWarnings({ "rawtypes"})
			@Override
			public void onClick(ClickEvent event) {
				//获取下拉列表的值
				Record record = employeeIdItem.getSelectedRecord();
				int employeeId = BaseHelpUtils.getIntValue(record.getAttribute("employeeId"));
				if(employeeId <= 0){
					SC.say("提示","请选择人员");
					return;
				}
				Record[] datas = twoGrid.getRecords();
				if(!BaseHelpUtils.isNullOrEmpty(datas) && datas.length > 0){
					for(Record e : datas){
						int empId = BaseHelpUtils.getIntValue(e.getAttribute("employeeId"));
						if(employeeId == empId){
							return;
						}
					}
				}
				Date date = new Date();
				record.setAttribute("recordTime", date);
				record.setAttribute("businessType", 2);
				record.setAttribute("remark", "订单下单");
				Map params = record.toMap();
				DBDataSource.callOperation("ST_ProjectPerformanceNodeEmployee","save",params, new DSCallback() {
		            @Override
		            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
		                if (dsResponse.getStatus() >= 0) {
		                	getTwoData();
		                } else {
							Map errors = dsResponse.getErrors();
		                    SC.say("保存失败",errors.get("errorMsg")+"");
		                }
		            }
		        });
			}
		});
        
        //拆分价面板
        SectionStack stackOne = new SectionStack();  
        stackOne.setHeight("45%");  
        mainLayout.addMember(stackOne);
        
        SectionStackSection sectionOne = new SectionStackSection("拆分价维护成员");  
        sectionOne.setCanCollapse(false);  
        sectionOne.setExpanded(true); 
        
        oneGrid = new DelicacyListGrid();
        oneGrid.setCanRemoveRecords(true);
        oneGrid.setAutoFitFieldWidths(false);
        ListGridField[] fields = new ListGridField[5];
		int fieldIdx = 0;
		fields[fieldIdx] = new ListGridField("projectPerformanceNodeEmployeeId");
		fields[fieldIdx].setHidden(true);
		fieldIdx++;
		fields[fieldIdx] = new ListGridField("employeeId");
		fields[fieldIdx].setHidden(true);
		fieldIdx++;
		fields[fieldIdx] = new ListGridField("employeeNo","员工编号");
		fieldIdx++;
		fields[fieldIdx] = new ListGridField("employeeName","员工姓名");
		fieldIdx++;
		fields[fieldIdx] = new ListGridField("businessType","类型");
		fields[fieldIdx].setHidden(true);
		fieldIdx++;
		oneGrid.setFields(fields);
		sectionOne.setItems(oneGrid);
		oneGrid.addRemoveRecordClickHandler(new RemoveRecordClickHandler() {
			@SuppressWarnings("rawtypes")
			@Override
			public void onRemoveRecordClick(RemoveRecordClickEvent event) {
				int rowNum = event.getRowNum();
				Record r = oneGrid.getRecord(rowNum);
				Map params = r.toMap();
				DBDataSource.callOperation("ST_ProjectPerformanceNodeEmployee","delete",params, new DSCallback() {
					@Override
		            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
		                if (dsResponse.getStatus() >= 0) {
		                	SC.say("提示","删除成功");
		                } else {
							Map errors = dsResponse.getErrors();
		                    SC.say("删除失败",errors.get("errorMsg")+"");
		                }
		            }
		        });
			}
		});
		stackOne.setSections(sectionOne);
		
		//拆分价面板
        SectionStack stackTwo = new SectionStack();  
        stackTwo.setHeight("45%");  
        mainLayout.addMember(stackTwo);
        
        SectionStackSection sectionTwo = new SectionStackSection("订单下达维护成员");  
        sectionTwo.setCanCollapse(false);  
        sectionTwo.setExpanded(true); 
        
        twoGrid = new DelicacyListGrid();
        twoGrid.setCanRemoveRecords(true);
        twoGrid.setAutoFitFieldWidths(false);
        ListGridField[] fieldsTwo = new ListGridField[5];
		int idx = 0;
		fields[fieldIdx] = new ListGridField("projectPerformanceNodeEmployeeId");
		fields[fieldIdx].setHidden(true);
		fieldIdx++;
		fieldsTwo[idx] = new ListGridField("employeeId");
		fieldsTwo[idx].setHidden(true);
		idx++;
		fieldsTwo[idx] = new ListGridField("employeeNo","员工编号");
		idx++;
		fieldsTwo[idx] = new ListGridField("employeeName","员工姓名");
		idx++;
		fieldsTwo[idx] = new ListGridField("businessType","类型");
		fieldsTwo[idx].setHidden(true);
		idx++;
		twoGrid.setFields(fieldsTwo);
		sectionTwo.setItems(twoGrid);
		twoGrid.addRemoveRecordClickHandler(new RemoveRecordClickHandler() {
			@SuppressWarnings("rawtypes")
			@Override
			public void onRemoveRecordClick(RemoveRecordClickEvent event) {
				int rowNum = event.getRowNum();
				Record r = twoGrid.getRecord(rowNum);
				Map params = r.toMap();
				DBDataSource.callOperation("ST_ProjectPerformanceNodeEmployee","delete",params, new DSCallback() {
		            @Override
		            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
		                if (dsResponse.getStatus() >= 0) {
		                	SC.say("提示","删除成功");
		                } else {
							Map errors = dsResponse.getErrors();
		                    SC.say("删除失败",errors.get("errorMsg")+"");
		                }
		            }
		        });
			}
		});
		stackTwo.setSections(sectionTwo);
  
		startEdit();
    }


    @Override
    public void startEdit() {
    	getOneData();
    	getTwoData();
    }
    
    public void getOneData(){
    	Map<String,Object> params = new HashMap<>();
    	params.put("businessType", 1);
    	DBDataSource.callOperation("ST_ProjectPerformanceNodeEmployee","find",params, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                	oneGrid.setData(dsResponse.getData());
                } else {
					Map errors = dsResponse.getErrors();
                    SC.say("加载失败",errors.get("errorMsg")+"");
                }
            }
        });
    }
    
    public void getTwoData(){
    	Map<String,Object> params = new HashMap<>();
    	params.put("businessType", 2);
    	DBDataSource.callOperation("ST_ProjectPerformanceNodeEmployee","find",params, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                	twoGrid.setData(dsResponse.getData());
                } else {
					Map errors = dsResponse.getErrors();
                    SC.say("加载失败",errors.get("errorMsg")+"");
                }
            }
        });
    }
    
    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSSemployeeNew.getInstance());
        manager.addMember(__form);
    }

    @Override
    public boolean checkData() {
		return true;
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

	public Window getParWindow() {
		return parWindow;
	}

	public void setParWindow(Window parentWindow) {
		this.parWindow = parentWindow;
	}

    @SuppressWarnings("rawtypes")
	@Override
    public java.util.Map getValuesAsMap() {
        return null;
    }

    public String getActionName() {
        // 需要根据实际业务修改
        return "ST_ClientRecord";
    }

}
