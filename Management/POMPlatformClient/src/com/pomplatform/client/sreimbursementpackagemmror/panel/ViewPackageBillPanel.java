package com.pomplatform.client.sreimbursementpackagemmror.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.sreimbursementpackagemmror.datasource.DSScmbcpaydetailctyor;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.EditorExitEvent;
import com.smartgwt.client.widgets.grid.events.EditorExitHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ViewPackageBillPanel extends VLayout implements HasHandlers {

	private static final Logger logger = Logger.getLogger("");
	private final DynamicForm form = new DynamicForm();
	private Window parentWindow;
	protected final HandlerManager handlerManager = new HandlerManager(this);
	
	private Integer packageId;
	
	private ListGrid payGrid = new ListGrid();
	
	private ListGrid nbzzGrid = new ListGrid();
	
	private ListGrid dfqtGrid = new ListGrid();
	
	private ListGrid dfgzGrid = new ListGrid();
	
	private ListGrid dfjjGrid = new ListGrid();
	
	public ViewPackageBillPanel() {
		VLayout vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		vLayout.setMargin(10);
		vLayout.setMembersMargin(12);
		
		int index = 0;
		ListGridField [] fields = new ListGridField[12];
		fields[index] = new ListGridField("yurref");
		fields[index].setCanEdit(false);
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("dbtacc");
		fields[index].setCanEdit(false);
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("dbtbbk");
		fields[index].setCanEdit(false);
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("trsamt");
		fields[index].setCanEdit(false);
		index ++;
		fields[index] = new ListGridField("ccynbr");
		fields[index].setCanEdit(false);
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("nusage");
		fields[index].addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				Record record = event.getRecord();
				if(null != event.getNewValue()){
					record.setAttribute("nusage", event.getNewValue());
				}
				updateNusageOrBusnar(record);
				
			}
		});
		fields[index].setCanEdit(true);
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("busnar");
		fields[index].addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				Record record = event.getRecord();
				if(null != event.getNewValue()){
					record.setAttribute("busnar", event.getNewValue());
				}
				updateNusageOrBusnar(record);
				
				
			}
		});
		fields[index].setCanEdit(true);
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("crtacc");
		fields[index].setCanEdit(false);
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("crtnam");
		fields[index].setCanEdit(false);
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("crtbnk");
		fields[index].setCanEdit(false);
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("crtpvc");
		fields[index].setCanEdit(false);
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("crtcty");
		fields[index].setCanEdit(false);
		fields[index].setShowGridSummary(false);
		
		
		HeaderSpan [] payHeaderSpan = new HeaderSpan[] {
				new HeaderSpan("支付数据",
						new String[] { "yurref", "dbtacc", "dbtbbk", "trsamt", "ccynbr", "nusage", "busnar", "crtacc", "crtnam", 
								"crtbnk", "crtpvc", "crtcty" })};
		
		HeaderSpan [] nbzzHeaderSpan = new HeaderSpan[] {
				new HeaderSpan("内部转账数据",
						new String[] { "yurref", "dbtacc", "dbtbbk", "trsamt", "ccynbr", "nusage", "busnar", "crtacc", "crtnam", 
								"crtbnk", "crtpvc", "crtcty" })};
		
		HeaderSpan [] dfqtHeaderSpan = new HeaderSpan[] {
				new HeaderSpan("代发其他(报销)数据",
						new String[] { "yurref", "dbtacc", "dbtbbk", "trsamt", "ccynbr", "nusage", "busnar", "crtacc", "crtnam", 
								"crtbnk", "crtpvc", "crtcty" })};
		
		HeaderSpan [] dfgzHeaderSpan = new HeaderSpan[] {
				new HeaderSpan("代发工资数据",
						new String[] { "yurref", "dbtacc", "dbtbbk", "trsamt", "ccynbr", "nusage", "busnar", "crtacc", "crtnam", 
								"crtbnk", "crtpvc", "crtcty" })};
		
		HeaderSpan [] dfjjHeaderSpan = new HeaderSpan[] {
				new HeaderSpan("代发奖金数据",
						new String[] { "yurref", "dbtacc", "dbtbbk", "trsamt", "ccynbr", "nusage", "busnar", "crtacc", "crtnam", 
								"crtbnk", "crtpvc", "crtcty" })};
		//支付
		VLayout payLayout = new VLayout();
		payGrid.setDataSource(DSScmbcpaydetailctyor.getInstance());
		payGrid.setFields(fields);
		payGrid.setHeaderSpans(payHeaderSpan);
		payGrid.setHeaderHeight(60);
		payGrid.setShowGridSummary(true);
		payLayout.addMember(payGrid);
		
		//内部转账
		VLayout nbzzLayout = new VLayout();
		nbzzGrid.setDataSource(DSScmbcpaydetailctyor.getInstance());
		nbzzGrid.setFields(fields);
		nbzzGrid.setHeaderSpans(nbzzHeaderSpan);
		nbzzGrid.setHeaderHeight(60);
		nbzzGrid.setShowGridSummary(true);
		nbzzLayout.addMember(nbzzGrid);
		
		//代发其他
		VLayout dfqtLayout = new VLayout();
		dfqtGrid.setDataSource(DSScmbcpaydetailctyor.getInstance());
		dfqtGrid.setFields(fields);
		dfqtGrid.setHeaderSpans(dfqtHeaderSpan);
		dfqtGrid.setHeaderHeight(60);
		dfqtGrid.setShowGridSummary(true);
		dfqtLayout.addMember(dfqtGrid);
		
		//代发工资
		VLayout dfgzLayout = new VLayout();
		dfgzGrid.setDataSource(DSScmbcpaydetailctyor.getInstance());
		dfgzGrid.setFields(fields);
		dfgzGrid.setHeaderSpans(dfgzHeaderSpan);
		dfgzGrid.setHeaderHeight(60);
		dfgzGrid.setShowGridSummary(true);
		dfgzLayout.addMember(dfgzGrid);
		
		//代发奖金
		VLayout dfjjLayout = new VLayout();
		dfjjGrid.setDataSource(DSScmbcpaydetailctyor.getInstance());
		dfjjGrid.setFields(fields);
		dfjjGrid.setHeaderSpans(dfjjHeaderSpan);
		dfjjGrid.setHeaderHeight(60);
		dfjjGrid.setShowGridSummary(true);
		dfjjLayout.addMember(dfjjGrid);
		
//		HLayout mainLayout = new HLayout();
//		
//		VLayout leftLayout = new VLayout();
//		leftLayout.addMember(payGrid);
//		leftLayout.addMember(nbzzGrid);
//		leftLayout.addMember(dfqtGrid);
//		
//		VLayout rightLayout = new VLayout();
//		rightLayout.addMember(dfgzGrid);
//		rightLayout.addMember(dfjjGrid);
		
//		mainLayout.addMember(leftLayout);
//		mainLayout.addMember(rightLayout);
//		vLayout.addMember(mainLayout);
		vLayout.addMember(payGrid);
		vLayout.addMember(nbzzGrid);
		vLayout.addMember(dfqtGrid);
		vLayout.addMember(dfgzGrid);
		vLayout.addMember(dfjjGrid);
		addMember(vLayout);
	}

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	
	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}
	
	public void updateNusageOrBusnar(Record record) {
		Map<String, Object> condition = record.toMap();
		condition.put("opt_type", "updateNusageOrBusnar");
		DBDataSource.callOperation("EP_ReimbursementPackageProcessor", condition, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() < 0){
					logger.info("错误！ " + dsResponse.getErrors().get("errorMsg"));
				}
				
			}
		});
	}
	
	public void startEdit(){
		//类型 1:支付 2:代发工资 3:代发奖金 4:代发其他 5: 内部转账
		Map<String, Object> params = new HashMap<>();
		params.put("reimbursementPackageId", getPackageId());
		DBDataSource.callOperation("ST_CmbcPayDetail", "find", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				Record [] records = dsResponse.getData();
				
				RecordList payList = new RecordList();
				RecordList dfgzList = new RecordList();
				RecordList dfjjList = new RecordList();
				RecordList dfqtList = new RecordList();
				RecordList nbzzList = new RecordList();
				for (Record record : records) {
					switch (record.getAttributeAsInt("type")) {
					case 1:
						payList.add(record);
						break;
					case 2:
						dfgzList.add(record);
						break;
					case 3:
						dfjjList.add(record);
						break;
					case 4:
						dfqtList.add(record);
						break;
					case 5:
						nbzzList.add(record);
						break;
					default:
						break;
					}
				}
				if(payList.getLength() > 0){
					payGrid.setData(payList);
				}else{
					payGrid.hide();
				}
				
				if(dfgzList.getLength() > 0){
					dfgzGrid.setData(dfgzList);
				}else{
					dfgzGrid.hide();
				}
				
				if(dfjjList.getLength() > 0){
					dfjjGrid.setData(dfjjList);
				}else{
					dfjjGrid.hide();
				}
				
				if(dfqtList.getLength() > 0){
					dfqtGrid.setData(dfqtList);
				}else{
					dfqtGrid.hide();
				}
				
				if(nbzzList.getLength() > 0){
					nbzzGrid.setData(nbzzList);
				}else{
					nbzzGrid.hide();
				}
				
			}
		});
	}
}
