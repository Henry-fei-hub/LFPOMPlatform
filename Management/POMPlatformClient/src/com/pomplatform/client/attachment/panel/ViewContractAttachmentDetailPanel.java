package com.pomplatform.client.attachment.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.attachment.datasource.DSMcontractcacccccaaaraabbifiior;
import com.pomplatform.client.attachment.datasource.DSSattachmentmanageaaaor;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FloatItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ViewContractAttachmentDetailPanel extends VLayout implements HasHandlers{
	
	protected DynamicForm __form = new DynamicForm();
	
	private DelicacyListGrid attachmentGrid;
	
	public final static String BORDER_STYLE = "1px solid gray";
    public final static String BACKGROUND_COLOR = "azure";
    public final static String BUTTON_BACKGROUND_COLOR = "azure";
    public final static String FORM_BORDER_STYLE = "1px solid #808080";
	
	
	public ViewContractAttachmentDetailPanel(){
		setBackgroundColor(BACKGROUND_COLOR);
		HLayout formLayout = new HLayout();
		formLayout.setHeight("50%");
		formLayout.setWidth100();
		List<FormItem> __formItems = new ArrayList<>();
		
		TextItem contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		__formItems.add(contractCodeItem);
		
		TextItem contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		__formItems.add(contractNameItem);
		
		TextItem customerNameItem = new TextItem("customerName", "客户名称");
		customerNameItem.setWidth("*");
		__formItems.add(customerNameItem);
		
		TextItem designAreasItem = new FloatItem("designAreas", "总设计面积");
		designAreasItem.setWidth("*");
		__formItems.add(designAreasItem);
		
		FloatItem signingMoneySumItem = new FloatItem("signingMoneySum", "签约总金额");
		signingMoneySumItem.setWidth("*");
		__formItems.add(signingMoneySumItem);
		
		FloatItem borrowMoneyItem = new FloatItem("borrowMoney", "总回款金额");
		borrowMoneyItem.setWidth("*");
		__formItems.add(borrowMoneyItem);
		
		FloatItem invoiceAmountItem = new FloatItem("invoiceAmount", "开票金额");
		invoiceAmountItem.setWidth("*");
		__formItems.add(invoiceAmountItem);
		
		FloatItem projectAmountItem = new FloatItem("projectAmount", "累积含税营收");
		projectAmountItem.setWidth("*");
		__formItems.add(projectAmountItem);
		
		FloatItem checkAmountItem = new FloatItem("checkAmount", "确认函累计回款");
		checkAmountItem.setWidth("*");
		__formItems.add(checkAmountItem);
		
		__form.setDisabled(true);
		__form.setDataSource(DSMcontractcacccccaaaraabbifiior.getInstance());
		__form.setFields(__formItems.toArray(new FormItem[__formItems.size()]));
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		formLayout.addMember(__form);
		
		HLayout empLayout = new HLayout();
		empLayout.setWidth100();
		
		VLayout gridLayout = new VLayout();
		gridLayout.setWidth("50%");
		gridLayout.setHeight100();
		
		attachmentGrid = new DelicacyListGrid();
		attachmentGrid.setHeaderHeight(60);
		attachmentGrid.setHeaderHoverAlign(Alignment.LEFT);
		attachmentGrid.setHeaderSpans(new HeaderSpan[] {
				new HeaderSpan("该合同下确认函列表", new String[] { "attachmentCode", "attachmentName", "attachmentAddress", "perfessionRemark", 
						"amount", "returnAmount", "paymentSure", "paymentGradeDescription", "serialNumber", "recordDate", "remark", 
						"projectManageId", "departmentId", "superProjectManageId"}) });
		
		attachmentGrid.setDataSource(DSSattachmentmanageaaaor.getInstance());
		attachmentGrid.addDoubleClickHandler(new DoubleClickHandler() {
			
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if(!attachmentGrid.anySelected()){
					SC.say("请选择需要查看的确认函!");
					return;
				}
				Record record = attachmentGrid.getSelectedRecord();
				PopupWindow pw = new PopupWindow();
				UpdateAttachmentPanel panel = new UpdateAttachmentPanel(false);
				panel.initComponents();
				panel.setBusinessId(record.getAttribute("attachmentManageId"));
				panel.setFatherWindow(pw);
				panel.load();
				pw.addItem(panel);
                pw.setTitle("查看确认函");
                pw.setWidth100();
                pw.setHeight100();
                pw.centerInPage();
                pw.show();
			}
		});
		gridLayout.addMember(attachmentGrid);
		
		empLayout.addMember(gridLayout);
		addMember(formLayout);
		addMember(empLayout);
	}
	
	public void loadData(Record record){
		Map<String, Object> params = new HashMap<>();
		Object contractId = record.getAttribute("contractId");
		params.put("contractId", contractId);
		params.put("type", 1);
		DBDataSource.callOperation("NQ_Mcontractcacccccaaaraabbifiior", "find", params,  new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				__form.editRecord(dsResponse.getData()[0]);
			}
		});
		DBDataSource.callOperation("NQ_Sattachmentmanageaaaor", "find", params,  new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				attachmentGrid.setData(dsResponse.getData());
			}
		});
	}
	
	private int attachmentManageId;

	public int getAttachmentManageId() {
		return attachmentManageId;
	}

	public void setAttachmentManageId(int attachmentManageId) {
		this.attachmentManageId = attachmentManageId;
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
	
}
