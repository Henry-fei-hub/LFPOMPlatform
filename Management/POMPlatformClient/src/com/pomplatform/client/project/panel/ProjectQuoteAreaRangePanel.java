package com.pomplatform.client.project.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ProjectQuoteAreaRangePanel  extends HLayout implements HasHandlers{
	private Window parentWindow;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private static Logger __logger = Logger.getLogger("");
	private DelicacyListGrid grid;
	private  DynamicForm form;
	private HLayout leftLayout;
	private VLayout rightLayout;
	private HLayout mainLayout;
	private IButton addBut;
	private IButton delBut;

	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

	public void initComponents() {
		SC.debugger();

		mainLayout=new HLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		addMember(mainLayout);


		leftLayout=new HLayout();
		leftLayout.setWidth("80%");
		leftLayout.setHeight100();
		mainLayout.addMember(leftLayout);

		rightLayout=new VLayout();
		rightLayout.setMembersMargin(20);
		rightLayout.setHeight100();
		rightLayout.setWidth(120);
		rightLayout.setLayoutTopMargin(30);
		rightLayout.setLayoutLeftMargin(5);
		rightLayout.setLayoutRightMargin(5);
		mainLayout.addMember(rightLayout);

		grid=new DelicacyListGrid();
		grid.setWidth("100%");
		grid.setHeight("100%");
		int a=0;
		ListGridField[] aFields = new ListGridField[3];
		aFields[a] = new ListGridField("projectQuoteAreaRangeId","主键id");
		aFields[a].setCanEdit(true);
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("projectQuoteTemplatesParentId","模板父级主键ID");
		aFields[a].setCanEdit(true);
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("projectQuoteTemplateId","模板ID");
		aFields[a].setCanEdit(true);
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("areaRangeStart","面积范围起(m²)");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(true);
		a++;
		aFields[a] = new ListGridField("areaRangeEnd","面积范围止(m²)");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(true);
		a++;
		aFields[a] = new ListGridField("areaPrice","面积单价(元)");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(true);
		a++;
		aFields[a] = new ListGridField("remark","备注");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(true);
		grid.setFields(aFields);
		grid.setAutoFitFieldWidths(false);
		grid.addEditCompleteHandler(new EditCompleteHandler() {
			@SuppressWarnings("unchecked")
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				int rowNum = event.getRowNum();
				Record records=grid.getRecord(rowNum);
				Map<String,Object> params = new HashMap<>();
				int projectQuoteTemplatesParentId=BaseHelpUtils.getIntValue(record.getAttribute("projectQuoteTemplatesParentId"));
				int projectQuoteTemplateId=BaseHelpUtils.getIntValue(record.getAttribute("projectQuoteTemplateId"));		
				params.put("projectQuoteTemplatesParentId",projectQuoteTemplatesParentId);
				params.put("projectQuoteTemplateId",projectQuoteTemplateId);
				params.putAll(records.toMap());
				DBDataSource.callOperation("ST_projectQuoteAreaRange", "saveOrUpdate", params, new DSCallback(){
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0) {
							lodaData();
						}
					}
				});
			}
		});
		leftLayout.addMember(grid);

		addBut=new IButton("新增");
		rightLayout.addMember(addBut);
		addBut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				grid.startEditingNew();
			}
		});

		delBut=new IButton("删除");
		rightLayout.addMember(delBut);
		delBut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!grid.anySelected()){ SC.say("请选择一条数据"); return;}
				Record records=grid.getSelectedRecord();
				Map<String,Object> params = new HashMap<>();
				int projectQuoteAreaRangeId=BaseHelpUtils.getIntValue(records.getAttribute("projectQuoteAreaRangeId"));
				params.put("projectQuoteAreaRangeId",projectQuoteAreaRangeId);
				DBDataSource.callOperation("ST_projectQuoteAreaRange", "delete", params, new DSCallback(){
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0) {
							SC.say("删除成功");
							lodaData();
						}
					}
				});
				
			}
		});


	}

	public void lodaData() {
		Map<String,Object> params = new HashMap<>();
		int projectQuoteTemplatesParentId=BaseHelpUtils.getIntValue(record.getAttribute("projectQuoteTemplatesParentId"));
		int projectQuoteTemplateId=BaseHelpUtils.getIntValue(record.getAttribute("projectQuoteTemplateId"));		
		params.put("projectQuoteTemplatesParentId",projectQuoteTemplatesParentId);
		params.put("projectQuoteTemplateId",projectQuoteTemplateId);
		DBDataSource.callOperation("ST_projectQuoteAreaRange", "find", params, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					grid.setData(dsResponse.getData());
				}
			}
		});
	}


	private Record record;

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
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