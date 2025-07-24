package com.pomplatform.client.contractsrecords.panel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.app.datasource.DSMemployee;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.common.SyncDataUtil;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class EditContractsRecordsDetailForm extends HLayout implements HasHandlers{
	private HLayout mainLayout;
	private VLayout leftLayout;
	private VLayout rightLaout;
	private HLayout rightTopLayout;
	private HLayout  rightTopOutlayout;
	private VLayout  rightTopOutButtonlayout;
	private HLayout  buttonLayout;
	private  IButton  okButton;
	private  DateTimeItem registerDateItem;
	private  DateTimeItem trackDateItem;
	private  DynamicForm  searchForms;
	private  DynamicForm  form;
	private  DynamicForm  searchForm;
	private  TextItem registerEmployeeItem;
	private  TextItem customerNameItem;
	private  SelectItem contractStatusItem;
	private  DoubleItem contractAmountItem;
	private TextItem employeeNoItem;
	private TextItem employeeNameItem;
	private IPickTreeItem departmentIdItem ;
	private  TextAreaItem remarkItem;
	private DelicacyListGrid employeeBeforeGird;
	private DelicacyListGrid employeeAfterGird;
	private ComboBoxItem  contractsIdItem;
	private TextItem  contractCodeItem;
	private DateTimeItem contractDateItem;
	private DateTimeItem sendingDateItem;
	private RadioGroupItem trackTypeItem;
	private ComboBoxItem prePojectIdItem;
	private TextItem  infoCodeItem;
	

	private static Logger __logger = Logger.getLogger("");
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	public void initCompnts()  {
		setPadding(10);


		mainLayout=new HLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();

		leftLayout=new VLayout(10);
		leftLayout.setWidth("20%");
		leftLayout.setHeight("100%");
		leftLayout.setAlign(Alignment.LEFT);
		mainLayout.addMember(leftLayout);
		
		trackTypeItem=new RadioGroupItem();
		trackTypeItem.setCanEdit(false);
		trackTypeItem.setWidth("*");
		trackTypeItem.setTitleColSpan(4);
		trackTypeItem.setColSpan(4);
		trackTypeItem.setAlign(Alignment.CENTER);
		trackTypeItem.setVertical(false);
		trackTypeItem.setTitleAlign(Alignment.CENTER);
		trackTypeItem.setShowTitle(false); 
//		KeyValueManager.loadValueMap("system_dictionary_209", trackTypeItem);
		trackTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_209"));
		
		form = new DynamicForm();
		form.setAlign(Alignment.CENTER);
		form.setWidth100();
		form.setMargin(4);
		form.setPadding(5);
		form.setHeight("5%");
		form.setNumCols(4);
		form.setItems(trackTypeItem);
		leftLayout.addMember(form);
		
		prePojectIdItem=new ComboBoxItem("prePojectId",shouldNotBeNull+"前期项目");
		prePojectIdItem.setWidth("*");
		prePojectIdItem.setCanEdit(true);
		prePojectIdItem.hide();
		LinkedHashMap<Integer, String> projectlinkMap=new LinkedHashMap<>();
		Record[] recordp=SyncDataUtil.getValueByTableNames("ST_PreProject", "find", new HashMap<>());
		for (Record record : recordp) {
			projectlinkMap.put(BaseHelpUtils.getIntValue(record.getAttribute("preProjectId")), BaseHelpUtils.getString(record.getAttribute("projectName")));
		}
		prePojectIdItem.setValueMap(projectlinkMap);
		prePojectIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		prePojectIdItem.setRequired(true);
		
		
		

		contractsIdItem=new ComboBoxItem("contractId",shouldNotBeNull+"合同名称");
		contractsIdItem.setWidth("*");
		LinkedHashMap<Integer, String> linkMap=new LinkedHashMap<>();
		Record[] records=SyncDataUtil.getValueByTableNames("ST_Contract", "find", new HashMap<>());
		for (Record record : records) {
			linkMap.put(BaseHelpUtils.getIntValue(record.getAttribute("contractId")), BaseHelpUtils.getString(record.getAttribute("contractName")));
		}
		contractsIdItem.setValueMap(linkMap);
		contractsIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		contractsIdItem.setCanEdit(false);
		contractsIdItem.setDisabled(true);
		contractsIdItem.setRequired(true);


		contractCodeItem=new TextItem("contractCode",shouldNotBeNull+"合同编号");
		contractCodeItem.setWidth("*");
		contractCodeItem.setCanEdit(false);
		contractCodeItem.setDisabled(true);
		contractCodeItem.setRequired(true);
		
		infoCodeItem=new TextItem("infoCode",shouldNotBeNull+"信息编号");
		infoCodeItem.hide();
		infoCodeItem.setCanEdit(true);
		infoCodeItem.setRequired(true);
		infoCodeItem.setWidth("*");

		registerEmployeeItem=new TextItem("registerEmployee",shouldNotBeNull+"登记人");
		registerEmployeeItem.setRequired(true);
		registerEmployeeItem.setDisabled(true);
		registerEmployeeItem.setDefaultValue(ClientUtil.getEmployeeId());
		registerEmployeeItem.setValueMap(KeyValueManager.getValueMap("employees"));
		registerEmployeeItem.setCanEdit(false);
		registerEmployeeItem.setWidth("*");

		customerNameItem=new TextItem("customerName",shouldNotBeNull+"客户名称"); 
		customerNameItem.setRequired(true);
		customerNameItem.setWidth("*");


		contractStatusItem=new SelectItem("contractStatus",shouldNotBeNull+"合同签订状态");
		contractStatusItem.setWidth("*");
		contractStatusItem.setRequired(true);
		contractStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_139"));
		contractStatusItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				int value=BaseHelpUtils.getIntValue(event.getValue());
				if(value==1) {//已寄出
					contractDateItem.clearValue();
					sendingDateItem.show();
					contractDateItem.hide();
				}else if(value==2){//已签订
					sendingDateItem.clearValue();
					contractDateItem.show();
					sendingDateItem.hide();
				}else {
					contractDateItem.clearValue();
					sendingDateItem.clearValue();
					contractDateItem.hide();
					sendingDateItem.hide();
				}
			}
		});

		contractAmountItem=new DoubleItem("contractAmount",shouldNotBeNull+"签约合同金额");
		contractAmountItem.setFormat("#,###,###,###,###,##0.00");
		contractAmountItem.setWidth("*");
		contractAmountItem.setRequired(true);
		
		contractDateItem=new DateTimeItem("contractDate","合同签订日期");
		contractDateItem.hide();
		contractDateItem.setWidth("*");


		sendingDateItem=new DateTimeItem("sendingDate","合同寄出日期");
		sendingDateItem.hide();
		sendingDateItem.setWidth("*");


		registerDateItem = new DateTimeItem("registerDate",shouldNotBeNull+"登记日期");
		registerDateItem.setWidth("*");
		registerDateItem.setDefaultValue(new Date());
		registerDateItem.setRequired(true);
		registerDateItem.setUseTextField(true);
		registerDateItem.setDisabled(true);
		registerDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH_DAY);
		registerDateItem.setCanEdit(false);

		trackDateItem =new DateTimeItem("trackDate",shouldNotBeNull+"跟踪时间");
		trackDateItem.setWidth("*");
		trackDateItem.setDisabled(true);
		trackDateItem.setUseTextField(true);
		trackDateItem.setDefaultValue(new Date());
		trackDateItem.setRequired(true);
		trackDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);

		remarkItem=new TextAreaItem("remark",shouldNotBeNull+"跟踪描述");
		remarkItem.setWidth("*");
		remarkItem.setRequired(true);
		//remarkItem.setColSpan(4);
		remarkItem.setLength(250);

		searchForms = new DynamicForm();
		searchForms.setWidth100();
		//searchForms.setPadding(15);
		searchForms.setMargin(20);
		searchForms.setHeight100();
		searchForms.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(searchForms);
		searchForms.setItems(contractsIdItem,prePojectIdItem,contractCodeItem,infoCodeItem,registerEmployeeItem,registerDateItem,customerNameItem,contractAmountItem,contractStatusItem,contractDateItem,sendingDateItem,trackDateItem,remarkItem);
		leftLayout.addMember(searchForms);

		rightLaout=new VLayout(10);
		rightLaout.setWidth("40%");
		rightLaout.setHeight100();
		rightLaout.setAlign(Alignment.RIGHT);
		mainLayout.addMember(rightLaout);

		rightTopOutlayout=new HLayout();
		rightTopOutlayout.setWidth100();
		rightTopOutlayout.setHeight("5%");
		//rightTopOutlayout.setPadding(10);
		rightLaout.addMember(rightTopOutlayout);

		rightTopOutButtonlayout=new VLayout(20);
		rightTopOutButtonlayout.setPadding(20);
		rightTopOutButtonlayout.setWidth100();
		rightTopOutButtonlayout.setPadding(10);
		rightTopOutButtonlayout.setHeight("30%");

		rightTopLayout=new HLayout(10);
		rightTopLayout.setPadding(10);
		rightTopLayout.setMargin(2);
		rightTopLayout.setWidth100();
		rightTopLayout.setHeight("80%");
		rightLaout.addMember(rightTopLayout);



		employeeNoItem = new TextItem("employeeNo", "职员编号");
		employeeNoItem.setWidth("*");

		employeeNameItem = new TextItem("employeeName", "职员名称");
		employeeNameItem.setWidth("*");

		departmentIdItem = new IPickTreeItem("departmentId", "归属部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));



		searchForm = new DynamicForm();
		searchForm.setNumCols(2);
		searchForm.setPadding(10);
		searchForm.setMargin(1);
		searchForm.setWidth("60%");;
		searchForm.setHeight("10%");
		searchForm.setFields(employeeNoItem,employeeNameItem,departmentIdItem);
		rightTopOutlayout.addMember(searchForm);



		IButton searchBtn = new IButton("搜索");
		searchBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				//获取职员编号信息
				String employeeNo = BaseHelpUtils.getString(employeeNoItem.getValue());
				String employeeName = BaseHelpUtils.getString(employeeNameItem.getValue());
				int departmentId = BaseHelpUtils.getIntValue(departmentIdItem.getValue());
				loadEmployeeData(employeeNo, employeeName, departmentId);
			}
		});
		rightTopOutButtonlayout.addMember(searchBtn);

		IButton resetBtn = new IButton("重置");
		resetBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				employeeNoItem.clearValue();
				employeeNameItem.clearValue();
				departmentIdItem.clearValue();
				loadEmployeeData(null, null, null);
			}
		});
		rightTopOutButtonlayout.addMember(resetBtn);
		rightTopOutlayout.addMember(rightTopOutButtonlayout);

		//人员gird
		ListGridField[] fields = new ListGridField[4];
		int idx = 0;
		fields[idx] = new ListGridField("employeeId","职员Id"); 
		fields[idx].setCanEdit(false);
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("employeeNo","职员编号");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("employeeName","职员名称");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("departmentId","归属部门");
		fields[idx].setCanEdit(false);
		ComboBoxItem departmentIdSelect = new ComboBoxItem();
		departmentIdSelect.setValueMap(KeyValueManager.getValueMap("departments"));
		fields[idx].setEditorProperties(departmentIdSelect);
		idx ++;
		employeeBeforeGird=new DelicacyListGrid();
		employeeBeforeGird.setHeight100();
		employeeBeforeGird.setWidth("47%");
		employeeBeforeGird.setDataSource(DSMemployee.getInstance());
		employeeBeforeGird.setFields(fields);
		employeeBeforeGird.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				addSelectedEmployee();
			}
		});
		rightTopLayout.addMember(employeeBeforeGird);

		TransferImgButton addToButton = new TransferImgButton(TransferImgButton.RIGHT);
		addToButton.setWidth("4%");
		rightTopLayout.addMember(addToButton);
		addToButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addSelectedEmployee();
			}
		});



		employeeAfterGird=new DelicacyListGrid();
		employeeAfterGird.setHeight100();
		employeeAfterGird.setWidth("47%");
		employeeAfterGird.setDataSource(DSMemployee.getInstance());
		employeeAfterGird.setFields(fields);
		employeeAfterGird.setAutoFitFieldWidths(false);
		employeeAfterGird.setCanRemoveRecords(true);
		//employeeAfterGird.setShowRowNumbers(true);
		employeeAfterGird.setHeaderHeight(60);
		employeeAfterGird.setHeaderSpans(new HeaderSpan(shouldNotBeNull+"相关人员", new String[] {"employeeNo","employeeName","departmentId","workAddress"}));
		rightTopLayout.addMember(employeeAfterGird);



		buttonLayout=new HLayout(10);
		buttonLayout.setWidth("98%");
		buttonLayout.setAlign(Alignment.RIGHT);
		buttonLayout.setHeight("20%");



		okButton=new IButton("保存");
		okButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if(!searchForms.validate()){
					SC.say("请按系统提示修改信息");
					return ;
				}else if(employeeAfterGird.getRecords().length == 0){
					SC.say("相关人员不能为空");
					return ;
				}
				Map<String,Object> pargm= searchForms.getValues();
				int trackType=BaseHelpUtils.getIntValue(trackTypeItem.getValue());
				if(trackType<=0) {
					SC.say("提示","跟踪类型不能为空,请刷新页面");
					return ;
				}
				pargm.put("trackType", trackType);
				Record[] Erecords=employeeAfterGird.getRecords();
				List<String> elist=new ArrayList<>();
				List<String> clist=new ArrayList<>();
				for (Record  Erecord: Erecords) {
					elist.add(Erecord.getAttribute("employeeId"));
					clist.add(Erecord.getAttribute("employeeName"));
				}
				pargm.put("relevantEmployees", elist);
				pargm.put("relevantEmployeesName", clist);
				DBDataSource.callOperation("EP_AddContractsRecords",pargm, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							okButton.setDisabled(true);
							SC.say("保存成功");
							getPop().destroy();
							DataEditEvent dee = new DataEditEvent();
							fireEvent(dee);
						} else {
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
			}
		});
		buttonLayout.addMember(okButton);
		rightLaout.addMember(buttonLayout);


		addMember(mainLayout);
		loadData();
	}



	/**
	 * 加载人员数据集
	 */
	private void loadEmployeeData(String employeeNo,String employeeName,Integer departmentId){
		Map<String,Object> params = new HashMap<>();
		params.put("status",0);
		if(!BaseHelpUtils.isNullOrEmpty(employeeNo)){
			params.put("employeeNo","%"+employeeNo+"%");
		}
		if(!BaseHelpUtils.isNullOrEmpty(employeeName)){
			params.put("employeeName","%"+employeeName+"%");
		}
		if(!BaseHelpUtils.isNullOrEmpty(departmentId) && departmentId > 0){
			params.put("departmentId",departmentId);
		}
		//加载职员信息
		DBDataSource.callOperation("ST_Employee","find",params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] resultData = dsResponse.getData();
					employeeBeforeGird.setData(resultData);
				} else {
					SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
				}
			}
		});
	}

	/**
	 * 页面加载加载相关数据集
	 */
	private void loadData(){
		__logger.info("record++++++++++++++++++++++++++++++"+record.toMap());
		int  trackType=BaseHelpUtils.getIntValue(record.getAttribute("trackType"));
		//跟踪类型
		trackTypeItem.setValue(trackType);
		if(trackType==1) {//合同跟踪
			prePojectIdItem.clearValue();
			infoCodeItem.clearValue();
			contractsIdItem.clearValue();
			contractCodeItem.clearValue();
			customerNameItem.clearValue();
			infoCodeItem.setRequired(false);
			prePojectIdItem.setRequired(false);
			contractAmountItem.setRequired(true);
			contractsIdItem.setRequired(true);
			contractCodeItem.setRequired(true);
			contractAmountItem.show();
			prePojectIdItem.hide();
			infoCodeItem.hide();
			contractCodeItem.show();
			contractsIdItem.show();
		}else {//前期项目跟踪
			prePojectIdItem.clearValue();
			contractsIdItem.clearValue();
			infoCodeItem.clearValue();
			contractCodeItem.clearValue();
			contractAmountItem.clearValue();
			customerNameItem.clearValue();
			contractAmountItem.setRequired(false);
			contractsIdItem.setRequired(false);
			contractCodeItem.setRequired(false);
			prePojectIdItem.setRequired(true);
			infoCodeItem.setRequired(true);
			contractAmountItem.hide();
			contractsIdItem.hide();
			contractCodeItem.hide();
			prePojectIdItem.show();
			infoCodeItem.show();
		}
		int preProjectId=BaseHelpUtils.getIntValue(record.getAttribute("preProjectId"));
		if(preProjectId>0) {
			prePojectIdItem.setValue(preProjectId);
		}
		String infoCode=BaseHelpUtils.getString(record.getAttribute("infoCode"));
		if(infoCode.length()>0) {
			infoCodeItem.setValue(infoCode);
		}
		
		registerEmployeeItem.setValue(record.getAttribute("registerEmployee"));
		//获取之前的客户名称        
		customerNameItem.setValue(record.getAttributeAsString("customerName"));
		//获取之前的签约合同金额
		contractAmountItem.setValue(BaseHelpUtils.getBigDecimalValue(record.getAttributeAsString("contractAmount")));
		//获取之前的合同签订状态
		int contractStatus=BaseHelpUtils.getIntValue(record.getAttributeAsInt("contractStatus"));
		if(contractStatus==1) {//已寄出
			contractDateItem.clearValue();
			sendingDateItem.show();
			contractDateItem.hide();
		}else if(contractStatus==2){//已签订
			sendingDateItem.clearValue();
			contractDateItem.show();
			sendingDateItem.hide();
		}else {
			contractDateItem.clearValue();
			sendingDateItem.clearValue();
			contractDateItem.hide();
			sendingDateItem.hide();
		}
		contractStatusItem.setValue(record.getAttributeAsInt("contractStatus"));
		//获取之前的备注
		remarkItem.setValue(record.getAttributeAsString("remark"));
		//获取合同名称
		contractsIdItem.setValue(record.getAttributeAsInt("contractId"));
		//获取合同编号
		contractCodeItem.setValue(record.getAttributeAsString("contractCode"));

		//获取之前的相关人员ID，加载之前的相关人员信息
		String relevantEmployees=BaseHelpUtils.getString(record.getAttribute("relevantEmployees"));
		String[] temps = relevantEmployees.split(",");
		Map<String,Object> eaMap=new HashMap<>();
		RecordList eaRecordlist=new RecordList();
		for (String temp : temps) {
			int relevantEmployeess=BaseHelpUtils.getIntValue(temp.trim());
			eaMap.put("employeeId", relevantEmployeess);
			DBDataSource.callOperation("ST_Employee","find",eaMap, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if (dsResponse.getStatus() >= 0) {
						Record[] records=dsResponse.getData();
						Record earecord=new Record();
						for (Record record : records) {
							earecord.setAttribute("employeeId", record.getAttribute("employeeId"));
							earecord.setAttribute("employeeNo", record.getAttribute("employeeNo"));
							earecord.setAttribute("employeeName", record.getAttribute("employeeName"));
							earecord.setAttribute("departmentId", record.getAttribute("departmentId"));
							earecord.setAttribute("workAddress", record.getAttribute("workAddress"));
						}
						eaRecordlist.add(earecord);
					} else {
						SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
					}
				}
			});
		}
		employeeAfterGird.setData(eaRecordlist);


		//加载该职员信息status
		Map<String,Object> params = new HashMap<>();
		params.put("status", 0);
		DBDataSource.callOperation("ST_Employee","find",params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					employeeBeforeGird.setData(dsResponse.getData());
				} else {
					SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
				}
			}
		});


	}
	//人员
	private void addSelectedEmployee() {
		ListGridRecord[] selectedRecords = employeeBeforeGird.getSelectedRecords();
		RecordList originalList = employeeAfterGird.getDataAsRecordList();
		int originalLength = originalList.getLength();
		RecordList newList = new RecordList();
		if (originalLength > 0) {
			newList.addList(originalList.getRange(0, originalLength));
		}
		employeeBeforeGird.deselectAllRecords();
		for (ListGridRecord selectedRecord : selectedRecords) {
			Map<String,Object> searchMap = new HashMap<>();
			searchMap.put("employeeId", selectedRecord.getAttribute("employeeId"));
			if (originalLength > 0) {
				int index = originalList.findIndex(searchMap);
				if (index != -1) {
					continue;
				}
			}
			searchMap.put("employeeNo", selectedRecord.getAttribute("employeeNo"));
			searchMap.put("employeeName", selectedRecord.getAttribute("employeeName"));
			searchMap.put("departmentId", selectedRecord.getAttribute("departmentId"));
			searchMap.put("workAddress", selectedRecord.getAttribute("workAddress"));
			newList.add(new Record(searchMap));
		}
		employeeAfterGird.setData(newList);
	}



	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

	private Record record;

	private   PopupWindow  pop;


	public PopupWindow getPop() {
		return pop;
	}


	public void setPop(PopupWindow pop) {
		this.pop = pop;
	}

	public Record record() {
		return this.record;
	}

	public   void setRecord(Record record) {
		this.record=record;
	}

	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}
	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}


}
