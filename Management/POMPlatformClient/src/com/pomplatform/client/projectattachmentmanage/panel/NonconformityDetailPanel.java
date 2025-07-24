package com.pomplatform.client.projectattachmentmanage.panel;

import java.awt.TextComponent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LoadingWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.projectattachmentmanage.datasource.DSNonconformityAttachmentDetail;
import com.pomplatform.client.stage.datasource.DSSsystemdictionaryor;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class NonconformityDetailPanel extends AbstractWizadPage implements HasHandlers{
	
	private final TextItem projectAttachmentIdItem;
	private final TextItem projectIdItem;
	private final TextItem plateIdItem;
	private final TextItem contractCodeItem;
	private final TextItem sheetCodeItem;
	private final TextItem projectNameItem;
	private final TextItem stageIdItem;
	private final TextAreaItem remarkItem;
	private final TextItem operateEmployeeIdItem;
	private  DynamicForm form;
	private  DelicacyListGrid SourceGrid = new DelicacyListGrid();
	
    public final static String BORDER_STYLE = "1px solid gray";
    public final static String BACKGROUND_COLOR = "azure";
    public final static String BUTTON_BACKGROUND_COLOR = "azure";
    public final static String FORM_BORDER_STYLE = "1px solid #808080";
    public boolean check = false;
    private String msg ="";
	private static final Logger __LOGGER = Logger.getLogger("");
	public Map<String, Object> params =new HashMap<>();
	
	public NonconformityDetailPanel(){
//		setBackgroundColor(BACKGROUND_COLOR);
		VLayout mainLayout = new VLayout();
		
		HLayout allH =new HLayout();
		allH.setWidth100();
		allH.setHeight100();
		allH.setMargin(5);
		
		//上级数据(被选中项目订单信息)
		VLayout leftLayout = new VLayout();
		leftLayout.setWidth("25%");
		leftLayout.setHeight100();
		
		//次级数据(被选中项目订单信息下的contract_id 和 projecet_type in(16,33) 的数据)
		HLayout rightLayout =new HLayout();
		rightLayout.setWidth100();
		rightLayout.setHeight100();
		rightLayout.setMargin(5);
        SourceGrid.setAutoFitFieldWidths(false);
        SourceGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
        SourceGrid.setDataSource(DSNonconformityAttachmentDetail.getInstance());
        rightLayout.addMember(SourceGrid);
        
		projectAttachmentIdItem = new TextItem("projectAttachmentId", "主键id");
		projectAttachmentIdItem.setWidth("*");
		projectAttachmentIdItem.setRequired(true);
		projectAttachmentIdItem.setHidden(true);
		__formItems.add(projectAttachmentIdItem);
		
		projectIdItem = new TextItem("projectId", "projectId");
		projectIdItem.setWidth("*");
		projectIdItem.setRequired(true);
		projectIdItem.setHidden(true);
		__formItems.add(projectIdItem);
		
		operateEmployeeIdItem = new TextItem("operateEmployeeId", "操作人");
		operateEmployeeIdItem.setWidth("*");
		operateEmployeeIdItem.setRequired(true);
		operateEmployeeIdItem.setHidden(true);
		__formItems.add(operateEmployeeIdItem);
		
		plateIdItem = new TextItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setRequired(true);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		__formItems.add(plateIdItem);
		
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		contractCodeItem.setRequired(true);
		__formItems.add(contractCodeItem);
		
		sheetCodeItem = new TextItem("sheetCode", "订单编号");
		sheetCodeItem.setWidth("*");
		sheetCodeItem.setRequired(true);
		__formItems.add(sheetCodeItem);
		
		projectNameItem = new TextItem("projectName", "订单名称");
		projectNameItem.setWidth("*");
		projectNameItem.setRequired(true);
		__formItems.add(projectNameItem);
		
		stageIdItem = new TextItem("stageId", "阶段");
		stageIdItem.setWidth("*");
		stageIdItem.setRequired(true);
		stageIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));
		__formItems.add(stageIdItem);
		
		remarkItem = new TextAreaItem("remark", "不合格原因");
		remarkItem.setWidth(730);
        remarkItem.setHeight(65);
		remarkItem.setRequired(true);
		__formItems.add(remarkItem);
		
		__form.setItems(getFormItemArray());
		__form.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		__form.setHeight100();
		__form.setWidth100();
		__form.setBorder(FORM_BORDER_STYLE);
		
		ToolStrip btnLayout = new ToolStrip();
		btnLayout.setVPolicy(LayoutPolicy.FILL);
		btnLayout.setPadding(5);
		btnLayout.setHeight(40);
		btnLayout.setWidth100();
		btnLayout.addFill();
		
		String title = "提交";
		IButton saveBtn = new IButton(title);
		saveBtn.setIcon("[SKIN]/actions/save.png");
		btnLayout.addMember(saveBtn);
		btnLayout.addSpacer(10);
		saveBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				boolean checkData = checkData();
				}
		});
		
		IButton cancelBtn = new IButton("取消");
		cancelBtn.setIcon("[SKIN]/actions/close.png");
		btnLayout.addMember(cancelBtn);
		btnLayout.addSpacer(10);
		cancelBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
					getFatherWindow().destroy();
			}
		});
		
		leftLayout.addMember(__form);
		allH.addMember(leftLayout);
		mainLayout.addMember(allH);
		mainLayout.addMember(rightLayout);
		mainLayout.addMember(btnLayout);
		addMember(mainLayout);
	}

	@Override
	public Map getValuesAsMap() {
		return null;
	}

	@Override
	public boolean checkData() {
		SC.debugger();
		final LoadingWindow loading = new LoadingWindow();
		msg="";
		check=false;
		params.clear();
		String userId = ClientUtil.getUserId();//登录人操作id
		params = __form.getValues();
		params.put("userId", userId);
		ListGridRecord[] selectedRecords = SourceGrid.getSelectedRecords();
		if(!BaseHelpUtils.isNullOrEmpty(selectedRecords)&&selectedRecords.length>0) {
			Map<String,Object> map =new HashMap<>();
			for (int i = 0; i < selectedRecords.length; i++) {
				ListGridRecord listGridRecord =selectedRecords[i];
				Map<String,Object> kv =new HashMap<>();
				kv.put("projectId", listGridRecord.getAttributeAsInt("projectId"));
				kv.put("plateId", listGridRecord.getAttributeAsInt("plateId"));
				kv.put("contractId", listGridRecord.getAttributeAsInt("contractId"));
				kv.put("projectType", listGridRecord.getAttributeAsInt("projectType"));
				kv.put("projectName", listGridRecord.getAttributeAsString("projectName"));
				kv.put("remark", listGridRecord.getAttribute("remark"));
				map.put(i+"", kv);
			}
			if(!BaseHelpUtils.isNullOrEmpty(map)) {
				params.put("length", selectedRecords.length);
				params.put("listGridRecord", map);
			}
		}
		params.put("optType", "checkNonconformityAttachment");
		DBDataSource.callOperation("EP_OnProjectCommonProcess","find", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				SC.debugger();
				if (dsResponse.getStatus() >= 0) {
					msg=BaseHelpUtils.getString(dsResponse.getErrors().get("errorMsg"));
					check=true;
					loading.destroy();
					if(check==true) {
						SC.ask("提示", msg , new BooleanCallback() {
							@Override
							public void execute(Boolean value) {
								if(value){
									params.put("optType", "updateNonconformityAttachment");
									DBDataSource.callOperation("EP_OnProjectCommonProcess","find", params, new DSCallback() {
										@Override
										public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
											if (dsResponse.getStatus() >= 0) {
												getFatherWindow().destroy();
												DataEditEvent dee = new DataEditEvent();
												dee.setData(dsResponse.getData()[0]);
					                            fireEvent(dee);
											}else{
												ClientUtil.displayErrorMessage(dsResponse);
											}
										}
									});
								}
							}
						});
					}
				}else{
					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
	
		return check;
	}
	
	
    //加载次级数据
    void reloadSource(int projectId) {
    	Map<String,Object> params =new HashMap<>();
    	params.put("projectId", projectId);
        DBDataSource.callOperation("NQ_NonconformityAttachmentDetail", "find", params, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                	Record[] records = dsResponse.getData();
                	if(records.length>0) {
                		SourceGrid.setData(records);
                	}
                	SourceGrid.selectAllRecords();
                }
            }
        });
    }

	private Window fatherWindow;

	public Window getFatherWindow() {
		return fatherWindow;
	}

	public void setFatherWindow(Window fatherWindow) {
		this.fatherWindow = fatherWindow;
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

	@Override
	public void startEdit() {
		if(null != getRecord()){
			__form.editRecord(getRecord());
		}
	}
    
}
