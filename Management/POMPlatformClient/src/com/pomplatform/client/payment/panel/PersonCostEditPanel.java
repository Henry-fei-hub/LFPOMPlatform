package com.pomplatform.client.payment.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.common.SyncDataUtil;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PersonCostEditPanel  extends HLayout implements HasHandlers{

	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private static Logger __logger = Logger.getLogger("");
	private Window parentWindow;
	private DynamicForm form;
	private DelicacyListGrid  grid;
	private Record record;
	private HLayout mainLayout;
	private IButton addButton;
	private IButton savelButton;
	private IButton delButton;
	private VLayout ButtonLaout;

	public void initComponents() {
		mainLayout=new HLayout(10);
		mainLayout.setWidth("95%");
		mainLayout.setHeight("100%");
		addMember(mainLayout);

		LinkedHashMap<String, Object> linkMap=new LinkedHashMap<>();
		Map<String,Object> map=new HashMap<>();
		map.put("status", 0);
		Record[]  emRecord=SyncDataUtil.getValueByTableNames("ST_Employee", "find", map);
		for (Record record : emRecord) {
			linkMap.put(BaseHelpUtils.getString(record.getAttribute("employeeNo")), BaseHelpUtils.getString(record.getAttribute("employeeNo")));
		}
		grid=new DelicacyListGrid();
		grid.setWidth("100%");
		int a = 0;
		ListGridField[] aFields = new ListGridField[3];
		aFields[a] = new ListGridField("employeeCostId","主键");
		aFields[a].setCanEdit(false);
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("employeeNo","员工编号");
		ComboBoxItem BoxItem = new ComboBoxItem();
		BoxItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		aFields[a].setEditorProperties(BoxItem);
		aFields[a].setValueMap(linkMap);
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setCanEdit(true);
		aFields[a].addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Map<String,Object> map=new HashMap<>();
				map.put("status", 0);
				map.put("employeeNo",BaseHelpUtils.getString(event.getValue()));
				Record  emRecord=SyncDataUtil.getValueByTableName("ST_Employee", "find", map);
				String employeeId=BaseHelpUtils.getString(emRecord.getAttribute("employeeId"));
				event.getForm().getItem("employeeId").setValue(employeeId);
			}
		});
		a++;
		aFields[a] = new ListGridField("employeeId","员工姓名");
		BoxItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		aFields[a].setEditorProperties(BoxItem);
		KeyValueManager.loadValueMap("employees", aFields[a]);
		aFields[a].setCanEdit(true);
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Map<String,Object> map=new HashMap<>();
				map.put("status", 0);
				map.put("employeeId",BaseHelpUtils.getIntValue(event.getValue()));
				Record  emRecord=SyncDataUtil.getValueByTableName("ST_Employee", "find", map);
				String employeeNo=BaseHelpUtils.getString(emRecord.getAttribute("employeeNo"));
				event.getForm().getItem("employeeNo").setValue(employeeNo);
			}
		});
		/*aFields[a].addEditorExitHandler(new EditorExitHandler() {

			@Override
			public void onEditorExit(EditorExitEvent event) {
				Map<String,Object> map=new HashMap<>();
				map.put("status", 0);
				map.put("employeeId",BaseHelpUtils.getIntValue(event.getValue()));
				Record  emRecord=SyncDataUtil.getValueByTableName("ST_Employee", "find", map);
				String employeeNo=BaseHelpUtils.getString(emRecord.getAttribute("employeeNo"));
				event.getForm().getItem("employeeNo").setValue(employeeNo);
			}
		});*/
		grid.setFields(aFields);
		grid.setAutoFitFieldWidths(false);
		grid.setCanRemoveRecords(true);
		grid.setShowGridSummary(true);
		grid.setHeaderHeight(60);
		grid.setHeaderSpans(new HeaderSpan(shouldNotBeNull+"不需要承担成本的人员", new String[] {"employeeCostId","employeeNo","employeeId"}));
		mainLayout.addMember(grid);

		ButtonLaout=new VLayout(20);
		ButtonLaout.setWidth("5%");
		ButtonLaout.setHeight("100%");
		ButtonLaout.setMembersMargin(30);
		ButtonLaout.setMargin(8);
		addMember(ButtonLaout);

		addButton = new IButton("新增");
		addButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				grid.startEditingNew();
			}
		});
		ButtonLaout.addMember(addButton);


		savelButton = new IButton("保存");
		ButtonLaout.addMember(savelButton);
		savelButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Record[] records=grid.getRecords();
				for (Record record : records) {
					DBDataSource.callOperation("ST_EmployeeCostRecord", "saveOrUpdate", record.toMap(), new DSCallback(){
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0) {
							}
						}
					});
				}
				savelButton.setDisabled(true);
				if (getParentWindow() == null) {
					return;
				}
				getParentWindow().destroy();
				DataEditEvent dee = new DataEditEvent();
				fireEvent(dee);
				SC.say("保存成功");
			}
		});


		delButton = new IButton("删除");
		ButtonLaout.addMember(delButton);
		delButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!grid.anySelected()){ SC.say("请选择一条数据"); return;}
                Record record=grid.getSelectedRecord();
				DBDataSource.callOperation("ST_EmployeeCostRecord", "delete", record.toMap(), new DSCallback(){
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
		DBDataSource.callOperation("ST_EmployeeCostRecord", "find", new HashMap<>(), new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					grid.setData(dsResponse.getData());
				}
			}
		});
	}

	public void checkData() {

	}





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
