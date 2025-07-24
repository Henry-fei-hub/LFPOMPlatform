package com.pomplatform.client.contract.panel;

import java.util.ArrayList;
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
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.contractinfo.datasource.DSContractInfo;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class OnContractAttachmentBindPanel extends HLayout implements HasHandlers {

	private Window parentWindow;
	private static Logger __logger = Logger.getLogger("");
	private TextItem employeeNameItem;
	private TextItem employeeNoItem;
	private TextItem departmentIdItem;
	private ComboBoxItem companyIdItem;
	private DoubleItem signingMoneySumItem;
	private TextItem attachmentNameItem;
	private TextAreaItem remarkItem;
	private IButton okBtn;
	private DelicacyListGrid recordGird;
	private DelicacyListGrid resultGird;

	public void initComponents() {
		setWidth100();
		setHeight100();
		setPadding(10);
		setMembersMargin(5);

		VLayout formLayout = new VLayout();
		formLayout.setHeight("98%");
		formLayout.setMembersMargin(5);
		formLayout.setWidth100();
		formLayout.setAlign(Alignment.CENTER);
		addMember(formLayout);

		HLayout messageLayout = new HLayout();
		messageLayout.setWidth100();
		messageLayout.setHeight("40%");
		messageLayout.setAlign(Alignment.CENTER);

		final DynamicForm form = new DynamicForm();
		form.setNumCols(6);
		form.setAlign(Alignment.CENTER);
		form.setPadding(5);
		form.setMargin(5);
		form.setWidth100();
		form.setHeight100();

		employeeNameItem = new TextItem("employeeName", "申请人");
		employeeNameItem.setWidth("*");
		employeeNameItem.setDisabled(true);
		
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setWidth("*");
		employeeNoItem.setDisabled(true);
		
		departmentIdItem = new TextItem("departmentId", "部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setDisabled(true);
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));

		companyIdItem = new ComboBoxItem("companyId","我方签约公司");
		companyIdItem.setWidth("*");
		companyIdItem.setDisabled(true);
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		
		signingMoneySumItem = new DoubleItem("signingMoneySum", "合同金额");
		signingMoneySumItem.setLength(18);
		signingMoneySumItem.setDecimalPad(2);
		signingMoneySumItem.setDisabled(true);
		signingMoneySumItem.setFormat("#,###,###,###,###,##0.00");
		signingMoneySumItem.setWidth("*");
		
		
		attachmentNameItem = new TextItem("attachmentName","文件名称");
		attachmentNameItem.setWidth("*");
		attachmentNameItem.setDisabled(true);
		
        remarkItem = new TextAreaItem("remark", "备注");
        remarkItem.setColSpan(6);
        remarkItem.setRowSpan(3);
        remarkItem.setWidth("*");
		
		form.setItems(employeeNameItem, employeeNoItem,departmentIdItem,companyIdItem,signingMoneySumItem,attachmentNameItem, remarkItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		messageLayout.addMember(form);
		formLayout.addMember(messageLayout);
		
		HLayout gridLayout = new HLayout(10);
		gridLayout.setHeight("55%");
		gridLayout.setWidth100();
		formLayout.addMember(gridLayout);
		
		//定义gird字段信息
		ListGridField[] fields = new ListGridField[5];
		int idx = 0;
		fields[idx] = new ListGridField("contractId");
		fields[idx].setCanEdit(false);
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("contractCode");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("contractName");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("signingMoneySum");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("customerName");
		fields[idx].setCanEdit(false);
		idx ++;
		
		VLayout reLayout = new VLayout();
        reLayout.setHeight100();
        reLayout.setWidth("47%");
        gridLayout.addMember(reLayout);
        
        HLayout searchLayout = new HLayout(10);
        searchLayout.setHeight("20%");
        reLayout.addMember(searchLayout);
        
        DynamicForm searchForm = new DynamicForm();
        searchForm.setWidth("80%");
        
        final TextItem contractCodeItem = new TextItem("contractCode", "合同编号");
        contractCodeItem.setWidth("*");
        
        final TextItem contractNameItem = new TextItem("contractName", "合同名称");
        contractNameItem.setWidth("*");
        
        searchForm.setNumCols(4);
        searchForm.setFields(contractCodeItem,contractNameItem);
        ClientUtil.DynamicFormProcessAccordingToDevice(searchForm);
        searchLayout.addMember(searchForm);
        
        VLayout btnLayout = new VLayout(10);
        btnLayout.setWidth("20%");
        searchLayout.addMember(btnLayout);
        
        IButton searchBtn = new IButton("搜索");
        searchBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				//获取合同编号信息
				String contractCode = BaseHelpUtils.getString(contractCodeItem.getValue());
				String contractName = BaseHelpUtils.getString(contractNameItem.getValue());
				loadContractInfo(contractCode, contractName);
			}
		});
        btnLayout.addMember(searchBtn);
        
        IButton resetBtn = new IButton("重置");
        resetBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				contractCodeItem.clearValue();
				contractNameItem.clearValue();
				loadContractInfo(null, null);
			}
		});
        btnLayout.addMember(resetBtn);
		
		recordGird = new DelicacyListGrid();
		recordGird.setHeight("80%");
		recordGird.setWidth100();
		recordGird.setDataSource(DSContractInfo.getInstance());
		recordGird.setFields(fields);
		recordGird.setAutoFitFieldWidths(false);
		recordGird.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				addSelectedContract();
			}
		});
		reLayout.addMember(recordGird);
		
		TransferImgButton addToButton = new TransferImgButton(TransferImgButton.RIGHT);
		addToButton.setWidth("4%");
		addToButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addSelectedContract();
			}
		});
		gridLayout.addMember(addToButton);

		resultGird = new DelicacyListGrid();
		resultGird.setHeight100();
		resultGird.setWidth("48%");
		resultGird.setDataSource(DSContractInfo.getInstance());
		resultGird.setFields(fields);
		resultGird.setAutoFitFieldWidths(false);
		resultGird.setCanRemoveRecords(true);
		gridLayout.addMember(resultGird);
		
		HLayout sureLayout = new HLayout();
		sureLayout.setWidth100();
		sureLayout.setHeight("5%");
		sureLayout.setMembersMargin(10);
		sureLayout.setAlign(Alignment.RIGHT);

		okBtn = new IButton("确认");
		okBtn.addClickHandler(new ClickHandler() {

			@SuppressWarnings("unchecked")
			@Override
			public void onClick(ClickEvent event) {
				
				//获取备注信息
				final String remark =remarkItem.getValueAsString();
				//获取当前操作人
				Map<Object,Object> params = new HashMap<>();
				params.putAll(getRecord().toMap());
				params.put("remark", remark);
				params.put("operateEmployeeId", ClientUtil.getEmployeeId());
				params.put("optType", "onBindContractAttachment");
				MapUtils.convertRecordToMap(resultGird.getDataSource(), resultGird.getRecords(), params, "contractDatas");
				okBtn.setDisabled(false);
				DBDataSource.callOperation("EP_OnCommonContractProcess",params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							okBtn.setDisabled(true);
							if (getParentWindow() == null) {
								return;
							}
							getParentWindow().destroy();
							DataEditEvent dee = new DataEditEvent();
							fireEvent(dee);
						} else {
							SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
						}
					}
				});
			}
		});
		
		IButton cleanBtn = new IButton("关闭");
		cleanBtn.addClickHandler(new ClickHandler() {

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
		sureLayout.addMember(okBtn);
		sureLayout.addMember(cleanBtn);
		formLayout.addMember(sureLayout);
		
		//加载登录人员相关信息
		loadData();
	}
	
	/**
	 * 加载登录人员相关信息
	 */
	private void loadData(){
		//获取当前登录人Id
		int employeeId = ClientUtil.getEmployeeId();
		//加载该职员信息
		Map<String,Object> params = new HashMap<>();
		params.put("employeeId",employeeId);
		DBDataSource.callOperation("ST_Employee","find",params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record record = dsResponse.getData()[0];
					employeeNameItem.setValue(record.getAttribute("employeeName"));
					employeeNoItem.setValue(record.getAttribute("employeeNo"));
					departmentIdItem.setValue(record.getAttribute("departmentId"));
				} else {
					SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
				}
			}
		});
		if(!BaseHelpUtils.isNullOrEmpty(getRecord())){
			companyIdItem.setValue(getRecord().getAttribute("companyId"));
			signingMoneySumItem.setValue(getRecord().getAttribute("signingMoneySum"));
			attachmentNameItem.setValue(getRecord().getAttribute("attachmentName"));
			setFileId(BaseHelpUtils.getIntValue(getRecord().getAttribute("fileId")));
		}
		//加载所有合同信息
		DBDataSource.callOperation("ST_Contract","find",params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] datas = dsResponse.getData();
					if(!BaseHelpUtils.isNullOrEmpty(datas) && datas.length > 0){
						recordGird.setData(datas);
						contractData = datas;
						//加载该合同文件已绑定的合同信息
						params.put("fileId", getFileId());
						DBDataSource.callOperation("ST_ContractLinkAttachment","find",params, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if (dsResponse.getStatus() >= 0) {
									Record[] d = dsResponse.getData();
									if(!BaseHelpUtils.isNullOrEmpty(d) && d.length > 0){
										RecordList newList = new RecordList();
										for(Record e : d){
											//获取合同Id
											int cId = BaseHelpUtils.getIntValue(e.getAttribute("contractId"));
											for(Record ee : datas){
												if(BaseHelpUtils.getIntValue(ee.getAttribute("contractId")) == cId){
													newList.add(ee);
													break;
												}
											}
										}
										resultGird.setData(newList);
									}
									
								} else {
									SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
								}
							}
						});
					}
					
				} else {
					SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
				}
			}
		});
	}
	
	/**
	 * 加载合同信息
	 * @param contractCode
	 * @param contractName
	 */
	private void loadContractInfo(String contractCode,String contractName){
		Map<String,Object> params = new HashMap<>();
		if(!BaseHelpUtils.isNullOrEmpty(contractCode)){
			params.put("contractCode","%"+contractCode+"%");
		}
		if(!BaseHelpUtils.isNullOrEmpty(contractName)){
			params.put("contractName","%"+contractName+"%");
		}
		//加载合同信息
		DBDataSource.callOperation("ST_Contract","find",params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] resultData = dsResponse.getData();
					recordGird.setData(resultData);
				} else {
					SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
				}
			}
		});
	}
	
	/**
	 * 选择合同
	 */
	private void addSelectedContract() {
		ListGridRecord[] selectedRecords = recordGird.getSelectedRecords();
		RecordList originalList = resultGird.getDataAsRecordList();
		int originalLength = originalList.getLength();
		RecordList newList = new RecordList();
		if (originalLength > 0) {
			newList.addList(originalList.getRange(0, originalLength));
		}
		recordGird.deselectAllRecords();
		for (ListGridRecord selectedRecord : selectedRecords) {
			Map<String,Object> searchMap = new HashMap<>();
			searchMap.put("contractId", selectedRecord.getAttribute("contractId"));
			if (originalLength > 0) {
				int index = originalList.findIndex(searchMap);
				if (index != -1) {
					continue;
				}
			}
			searchMap.put("contractCode", selectedRecord.getAttribute("contractCode"));
			searchMap.put("contractName", selectedRecord.getAttribute("contractName"));
			searchMap.put("signingMoneySum", selectedRecord.getAttribute("signingMoneySum"));
			searchMap.put("customerName", selectedRecord.getAttribute("customerName"));
			newList.add(new Record(searchMap));
		}
		resultGird.setData(newList);
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
	
	private int fileId;

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	
	private Record record;

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}
	
	private Record[] contractData = null;
	
}
