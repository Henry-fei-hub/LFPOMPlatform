package com.pomplatform.client.plateIntegralSends.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import java.util.Objects;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.plateIntegralSends.datasource.DSPlateIntegralSends;
import com.pomplatform.client.plateIntegralSends.form.PlateIntegralSendsSearchForm;
import com.pomplatform.client.plateIntegralSends.form.PlateIntegralSendsViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.data.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class PlateIntegralSendsPanel extends HLayout implements HasHandlers
{

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
    
    private SelectItem plateIdItem;
    private DateTimeItem sendDateItem;
    private TextItem sendIntegralItem;
    private TextItem employeeIdItem;
    private TextAreaItem remarkItem;
    private BigDecimal sendIntegral;
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
        
        plateIdItem = new SelectItem("plateId","业务部门");
        plateIdItem.setWidth("*");
        plateIdItem.setCanEdit(true);
        plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
        
        
        sendDateItem = new DateTimeItem("sendDate", "补贴日期");
        sendDateItem.setWidth("*");
        sendDateItem.setValue(new Date());
        sendDateItem.hide();
        
        sendIntegralItem = new TextItem("sendIntegral", "补贴积分");
        sendIntegralItem.setWidth("*");
        sendIntegralItem.setCanEdit(true);
        
        employeeIdItem = new TextItem("employeeId", "操作人员");
        employeeIdItem.setWidth("*");
        employeeIdItem.setCanEdit(false);
        employeeIdItem.setValue(ClientUtil.getEmployeeId());
        employeeIdItem.hide();
        employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
        
        remarkItem = new TextAreaItem("remark", "备注");
        remarkItem.setWidth("*");
        remarkItem.setHeight(100);
        remarkItem.setCanEdit(true);
        
        form = new DynamicForm();
        form.setNumCols(2);
        form.setWidth("90%");
        form.setHeight100();
        form.setItems(plateIdItem,sendDateItem,sendIntegralItem,employeeIdItem,remarkItem);
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
					values.put("optType", "onSavePlateAccountData");
					DBDataSource.callOperation("EP_AccountManageProcess",values, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
								SC.say("保存成功");
								getParentWindow().destroy();
								DataEditEvent dee = new DataEditEvent();
								fireEvent(dee);
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
		if(BaseHelpUtils.isNullOrEmpty(sendDateItem.getValue())) {
			SC.say("补贴日期不能为空");
			return false;
		}
		if(BaseHelpUtils.isNullOrEmpty(sendIntegralItem.getValue())) {
			SC.say("补贴金额不能为空");
			return false;
		}
		if(BaseHelpUtils.isNullOrEmpty(remarkItem.getValue())) {
			SC.say("补贴备注不能为空");
			return false;
		}
		if(BaseHelpUtils.isNullOrEmpty(plateIdItem.getValue())) {
			SC.say("业务部门不能为空");
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

