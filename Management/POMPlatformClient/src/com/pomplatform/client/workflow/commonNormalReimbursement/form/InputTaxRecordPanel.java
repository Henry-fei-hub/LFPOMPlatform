package com.pomplatform.client.workflow.commonNormalReimbursement.form;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
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
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.ChangeEvent;
import com.smartgwt.client.widgets.grid.events.ChangeHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
public class InputTaxRecordPanel extends HLayout implements HasHandlers {

	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private static Logger __logger = Logger.getLogger("");
	private Window parentWindow;
	private DynamicForm form;
	private DelicacyListGrid  grid;
	private Record[] records;
	private HLayout mainLayout;
	private IButton addButton;
	private IButton savelButton;
	private VLayout ButtonLaout;
	private Record record;
	private String bunessName;
	private int processType;

	public void initComponents() {
		mainLayout=new HLayout(10);
		mainLayout.setWidth("95%");
		mainLayout.setHeight("100%");
		addMember(mainLayout);

		grid = new DelicacyListGrid();
		grid.setWidth("90%");
		grid.setHeight("100%");
		grid.setAlign(Alignment.RIGHT);
		int a = 0;
		ListGridField[] aFields = new ListGridField[2];
		aFields[a] = new ListGridField("inputTaxRecordId","主键id");
		aFields[a].setCanEdit(false);
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("businessId","业务ID");
		aFields[a].setCanEdit(false);
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("processType","流程类型");
		aFields[a].setCanEdit(false);
		aFields[a].setWidth("25%");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("inputTax","进项税金额");
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setWidth("25%");
		aFields[a].setAlign(Alignment.RIGHT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(true);
		aFields[a].setDecimalPad(3);
		aFields[a].addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				BigDecimal value=BaseHelpUtils.getBigDecimalValue(event.getValue());
				value=value.setScale(2, BigDecimal.ROUND_DOWN);
				event.getForm().getField("inputTax").setValue(value);
			}
		});
		a++;
		aFields[a] = new ListGridField("invoiceEndNumber","发票后四位");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(true);
		a++;
		aFields[a] = new ListGridField("operateTime","操作时间");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setWidth("25%");
		aFields[a].setDefaultValue(new Date());
		DateTimeItem  dateItem=new DateTimeItem();
		dateItem.setValue(new Date());
		dateItem.setUseTextField(true);
		aFields[a].setEditorProperties(dateItem);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("overTime","报销结束时间");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(false);
		grid.setFields(aFields);
		grid.setAutoFitFieldWidths(false);
		grid.setCanRemoveRecords(true);
		grid.setShowGridSummary(true);
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
		savelButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(checkData()){
					Map<String,Object> map=new HashMap<>();
					map.put("optType", "SaveIntuxInfo");
					map.put("businessId", BaseHelpUtils.getIntValue(getRecord().getAttribute(bunessName)));
					map.put("code", BaseHelpUtils.getString(getRecord().getAttribute("code")));
					map.put("operateEmployeeId", ClientUtil.getUserId());
					map.put("processType", processType);
					MapUtils.convertRecordToMap(grid,grid.getRecords(),map,"info");
					DBDataSource.callOperation("EP_BudetAboutUpload",map, new DSCallback(){
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0) {
								savelButton.setDisabled(true);
								if (getParentWindow() == null) {
									return;
								}
								getParentWindow().destroy();
								DataEditEvent dee = new DataEditEvent();
								fireEvent(dee);
								SC.say("保存成功");
							}
						}
					});
				}
			}
		});
				ButtonLaout.addMember(savelButton);






	}


	public void lodaData() {
		Map<String,Object> map=new HashMap<>();
		map.put("businessId", BaseHelpUtils.getIntValue(getRecord().getAttribute(bunessName)));
		DBDataSource.callOperation("ST_InputTaxRecord","find",map, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					grid.setData(dsResponse.getData());
				}
			}
		});
	}

	public Boolean checkData() {
		Record[] recorda=getRecords();
		Record[] records=grid.getRecords();
		BigDecimal inputTaxBefore=BigDecimal.ZERO;
		BigDecimal inputTaxNow=BigDecimal.ZERO;
		for (Record reocrd : recorda) {
			inputTaxBefore=inputTaxBefore.add(BaseHelpUtils.getBigDecimalValue(reocrd.getAttribute("inputTax")).setScale(2, BigDecimal.ROUND_DOWN));
			
		}
		for (Record reocrd : records) {
			inputTaxNow=inputTaxNow.add(BaseHelpUtils.getBigDecimalValue(reocrd.getAttribute("inputTax")).setScale(2, BigDecimal.ROUND_DOWN));
		}
		if(grid.getRecords().length==0) {
			SC.say("数据为空，请填写数据");
			return false ;
		}
		if(inputTaxBefore.compareTo(inputTaxNow)!=0) {
			SC.say("保存的进项税总和与进项税实际总和不相等，进项税实际总和为【"+inputTaxBefore+"】，当前进项税总和为【"+inputTaxNow+"】");
			return false;
		}
		return true;
	}





	public Record[] getRecords() {
		return records;
	}


	public void setRecords(Record[] records) {
		this.records = records;
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


	public void setBunessId(int processTypes) {
		switch (processTypes) {
		case 2://项目日常报销
			bunessName="projectNormalReimbursementId";
			processType=processTypes;
			break;
		case 3://普通日常报销
			bunessName="projectNormalReimbursementId";
			processType=processTypes;
			break;
		case 4://项目差旅报销
			bunessName="travelReimbursementId";
			processType=processTypes;
			break;
		case 5://普通差旅报销
			bunessName="travelReimbursementId";
			processType=processTypes;
			break;
		case 8://前期项目日常报销
			bunessName="projectNormalReimbursementId";
			processType=processTypes;
			break;
		case 9://前期项目差旅报销
			bunessName="travelReimbursementId";
			processType=processTypes;
			break;
		}
     
	}

	public DelicacyListGrid getGrid() {
		return grid;
	}


	public void setGrid(DelicacyListGrid grid) {
		this.grid = grid;
	}
	
}
