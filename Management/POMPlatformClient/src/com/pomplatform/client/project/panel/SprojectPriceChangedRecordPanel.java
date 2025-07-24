package com.pomplatform.client.project.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.NewProcessWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.user.client.Cookies;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.platereportrecorddetail.datasource.DSProjectLinkAttachmentSource;
import com.pomplatform.client.platereportrecorddetail.panel.ProjectEmployeeAdvancePanel;
import com.pomplatform.client.project.datasource.DSSprojectccpor;
import com.pomplatform.client.project.datasource.DSSprojectstagetemplatepor;
import com.pomplatform.client.project.form.NewSprojectccporForm;
import com.pomplatform.client.project.form.ProjectPerformanceSettlementPanel;
import com.pomplatform.client.project.form.SettlementPanel;
import com.pomplatform.client.project.form.SprojectManagerSearchForm;
import com.pomplatform.client.project.form.UpdateProjectManagerForm;
import com.pomplatform.client.projectStageStorage.datasource.DSSprojectstagestorageor;
import com.pomplatform.client.projectStageStorage.datasource.DSSprojectstagestorageor2;
import com.pomplatform.client.projectteambuild.form.UpdateSprojectteambuildForm;
import com.pomplatform.client.projectview.form.SprojectViewViewer;
import com.pomplatform.client.stage.datasource.DSSsystemdictionaryor;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class SprojectPriceChangedRecordPanel extends HLayout implements HasHandlers {

	private Window parentWindow;
    private int plateId;
    private String projectType;
    private String businessType;
    private String projectName;
    private String contractCode;
	private int projectId;
	
    private  DelicacyListGrid grid = new DelicacyListGrid();
    private  DelicacyListGrid SourceGrid = new DelicacyListGrid();
    private  DynamicForm form;
    private  DynamicForm form2;
    private  DynamicForm form3;
    
    private TextItem projectIdItem;
    private TextItem projectNameItem;
    private TextItem contractCodeItem;
    private TextItem plateIdItem;
    private SelectItem subsidiesTypeItem;
    private DateTimeItem recordDateItem;
    private DateTimeItem recordTimeItem;
    private TextItem moneyItem;
    private TextItem operateEmployeeIdItem;
    private TextAreaItem remarkItem;
    
    private BigDecimal moneyIntegral;
    private IButton okButton;
    private IButton closeButton;

	public void initComponents() {
		SC.debugger();
		
        VLayout rightLayout = new VLayout(5);
        rightLayout.setWidth("50%");
        rightLayout.setHeight100(); 
        
        HLayout infoLayout = new HLayout(5);
        infoLayout.setWidth("100%");
        infoLayout.setHeight("100%");
        infoLayout.setLayoutTopMargin(30);
        infoLayout.setLayoutLeftMargin(5);
        infoLayout.setLayoutRightMargin(5);
        infoLayout.setMembersMargin(10);
        
        projectIdItem = new TextItem("projectId","订单id");
        projectIdItem.setWidth("*");
        projectIdItem.setValue(projectId);
        projectIdItem.setCanEdit(false);
        projectIdItem.hide();
//        projectIdItem.setValueMap(KeyValueManager.getValueMap("projects"));
        
        contractCodeItem = new TextItem("contractCode","订单编号");
        contractCodeItem.setWidth("*");
        contractCodeItem.setValue(contractCode);
        contractCodeItem.setCanEdit(false);
        
        projectNameItem = new TextItem("projectName","订单名称");
        projectNameItem.setWidth("*");
        projectNameItem.setValue(projectName);
        projectNameItem.setCanEdit(false);
        
        plateIdItem = new TextItem("plateId","业务部门");
        plateIdItem.setWidth("*");
//        projectIntegralItem.setRowSpan(2);
        plateIdItem.setValue(plateId);
        plateIdItem.setCanEdit(false);
        plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
        
        
        subsidiesTypeItem = new SelectItem("subsidiesType","补贴类型");
        subsidiesTypeItem.setWidth("*");
//        projectIntegralLeftItem.setRowSpan(2);
        subsidiesTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_208"));
        
        recordDateItem = new DateTimeItem("recordDate", "补贴日期");
        recordDateItem.setWidth("*");
        
        recordTimeItem = new DateTimeItem("recordTime", "操作日期");
        recordTimeItem.setWidth("*");
        recordTimeItem.hide();
        recordTimeItem.setValue(new Date());
        
        moneyItem = new TextItem("money", "补贴金额");
        moneyItem.setWidth("*");
        
        operateEmployeeIdItem = new TextItem("operateEmployeeId", "操作人员");
        operateEmployeeIdItem.setWidth("*");
        operateEmployeeIdItem.setCanEdit(false);
        operateEmployeeIdItem.setValue(ClientUtil.getEmployeeId());
        operateEmployeeIdItem.hide();
        operateEmployeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
        
        remarkItem = new TextAreaItem("remark", "备注");
        remarkItem.setWidth("*");
        remarkItem.setHeight(100);
        
        form = new DynamicForm();
        form.setNumCols(2);
        form.setWidth("90%");
        form.setHeight100();
        form.setItems(contractCodeItem,projectIdItem,projectNameItem,plateIdItem,subsidiesTypeItem,recordDateItem,recordTimeItem,moneyItem,operateEmployeeIdItem,remarkItem);
        infoLayout.addMember(form);
        rightLayout.addMember(infoLayout);
        
        HLayout btnLayout = new HLayout(10);
		btnLayout.setWidth100();
		btnLayout.setHeight("5%");
		btnLayout.setMembersMargin(10);
		btnLayout.setAlign(Alignment.RIGHT);
        okButton =new IButton("提交");
        okButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				boolean checkDate = checkDate();
				if(checkDate) {
					SC.debugger();
					Map<String,Object> values = form.getValues();
					DBDataSource.callOperation("ST_ProjectPriceChangedRecord", "save", values, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
								Map<String,Object> values = new HashMap<>();
								values.put("projectId", projectId);
								values.put("isHasPrice", true);
								DBDataSource.callOperation("ST_Project", "update", values, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if (dsResponse.getStatus() >= 0) {
											SC.say("保存成功");
											getParentWindow().destroy();
											DataEditEvent dee = new DataEditEvent();
											fireEvent(dee);
										}else {
											
										}
									}
								});
							}
						}
					});
				}
			}
		});
        closeButton=new IButton("关闭");
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
        btnLayout.addMember(okButton);
        btnLayout.addMember(closeButton);
        rightLayout.addMember(btnLayout);
        
        addMember(rightLayout);
	}



	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

	private boolean checkDate() {
		if(BaseHelpUtils.isNullOrEmpty(projectId)||BaseHelpUtils.isNullOrEmpty(plateId)||BaseHelpUtils.isNullOrEmpty(contractCode)||BaseHelpUtils.isNullOrEmpty(projectName)) {
			SC.say("请按照要求填写信息");
			return false;
		}
		if(BaseHelpUtils.isNullOrEmpty(subsidiesTypeItem.getValue())) {
			SC.say("补贴类型不能为空");
			return false;
		}
		if(BaseHelpUtils.isNullOrEmpty(recordDateItem.getValue())) {
			SC.say("补贴日期不能为空");
			return false;
		}
		if(BaseHelpUtils.isNullOrEmpty(moneyItem.getValue())) {
			SC.say("补贴金额不能为空");
			return false;
		}
		if(BaseHelpUtils.isNullOrEmpty(remarkItem.getValue())) {
			SC.say("补贴备注不能为空");
			return false;
		}
		return true;
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

	public int getPlateId() {
		return plateId;
	}

	public void setPlateId(int plateId) {
		this.plateId = plateId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}




}
