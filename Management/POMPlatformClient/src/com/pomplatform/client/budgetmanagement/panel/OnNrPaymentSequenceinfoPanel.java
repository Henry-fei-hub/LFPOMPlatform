package com.pomplatform.client.budgetmanagement.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.websocket.Base64Utils;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.budgetmanagement.datasource.DSAbountPaymentSequenceinfo;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class OnNrPaymentSequenceinfoPanel extends HLayout implements HasHandlers{
	private Window parentWindow;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private static Logger __logger = Logger.getLogger("");
	private HLayout mainLayout;
	private VLayout rightLayout;
	private IButton  okBut;
	private IButton  quitBut;
	private DelicacyListGrid grid;

	public void initComponents() {
		mainLayout=new HLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		addMember(mainLayout);


		
		grid=new DelicacyListGrid();
		grid.setWidth("100%");
		grid.setAutoFitFieldWidths(false);
		grid.setAlign(Alignment.LEFT);
		int a=0;
		ListGridField[]  aFields=new ListGridField[6];
		aFields[a] = new ListGridField("budgetManagementId","预算管理ID"); 
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(false);
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("attachmentName","附件名称"); 
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(false);
		aFields[a].setHidden(false);
		a++;
		aFields[a] = new ListGridField("fileUrl","文件路径");
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(false);
		aFields[a].setLinkText("预算文件下载/预览");
		aFields[a].setHidden(false);
		a++;
		aFields[a] = new ListGridField("payDate","付款时间");  
		DateTimeItem  dateItem=new DateTimeItem();
		dateItem.setUseTextField(true);
		aFields[a].setEditorProperties(dateItem);
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("payAmount","付款金额");
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(true);
		a++;
		aFields[a] = new ListGridField("reimbursementAmount","报销金额");
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(true);
		a++;
		aFields[a] = new ListGridField("reverseAmount","冲账金额");
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(true);
		a++;
		aFields[a] = new ListGridField("receiveUnitManageId","收款方");
		ComboBoxItem receiveUnitManageIdItem = new ComboBoxItem();
		receiveUnitManageIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		aFields[a].setEditorProperties(receiveUnitManageIdItem);
//		aFields[a].setValueMap(KeyValueManager.getValueMap("receive_unit_manages_company"));
		KeyValueManager.loadValueMap("receive_unit_manages_company",aFields[a]);
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("psRemark","备注");
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(false);
		grid.setFields(aFields);
		grid.setDataSource(DSAbountPaymentSequenceinfo.getInstance());
		grid.setCanRemoveRecords(false);
		grid.setShowGridSummary(true);
		grid.setHeaderHeight(60);
		grid.setHeaderSpans(new HeaderSpan(shouldNotBeNull+"预算付款序列", new String[] {"budgetManagementId","attachmentName","fileUrl","budgetAttachmentId","payDate","payAmount","reimbursementAmount","reverseAmount","receiveUnitManageId","psRemark"}));
		mainLayout.addMember(grid);
       
		/*rightLayout=new VLayout(20);
		rightLayout.setMargin(20);
		rightLayout.setWidth("10%");
		rightLayout.setHeight100();
		mainLayout.addMember(rightLayout);

		okBut=new IButton("绑定");
	    rightLayout.addMember(okBut);
	    okBut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Record[] records=grid.getSelectedRecords();
				for (Record record : records) {
					DataEditEvent dee = new DataEditEvent();
					dee.setData(record);
					fireEvent(dee);
					SC.say("绑定成功！");
					getParentWindow().destroy();
				}
			}
		});
		*/






	}

	public void lodaDate() {
		Map<String,Object> map=new HashMap<>();
		map.put("budgetManagementId", budgetManagementId);
		DBDataSource.callOperation("NQ_AbountPaymentSequenceinfo",map,new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus()>=0){
					grid.setData(dsResponse.getData());
				}
			}
		});






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
	private int budgetManagementId;

	public int getBudgetManagementId() {
		return budgetManagementId;
	}

	public void setBudgetManagementId(int budgetManagementId) {
		this.budgetManagementId = budgetManagementId;
	}
	

}
