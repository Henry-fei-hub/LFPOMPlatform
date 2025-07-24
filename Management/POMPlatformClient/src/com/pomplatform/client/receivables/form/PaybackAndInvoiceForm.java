package com.pomplatform.client.receivables.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.receivables.datasource.DSCapitalAndInvoiceTwo;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Logger;

public class PaybackAndInvoiceForm extends VLayout{
	private static final Logger __logger = Logger.getLogger("");
	private LinkedHashMap<String,String> keyMap = new LinkedHashMap<>();

	private final DelicacyListGrid invoiceGrid = new DelicacyListGrid() {
		@Override
		protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
			//获取本次确认积分
			int isCapital = BaseHelpUtils.getIntValue(record.getAttribute("isCapital"));
			if (isCapital == 2) {
				return "color: blue;";
			}
			else if (isCapital == 1){
				return "color: green;";
			}
			else if (isCapital == 3){
				return "color: red;";
			}
			else {
				return super.getCellCSSText(record, rowNum, colNum);
			}
		}
	};//发票grid
	private final DelicacyListGrid paybackGrid = new DelicacyListGrid();//回款grid

	private final DynamicForm searchForm = new DynamicForm();
	private final IButton searchButton = new IButton("搜索");
	private final IButton fillingButton = new IButton("匹配数据");
	private final IButton saveButton = new IButton("保存数据");
//	private final IButton markButton = new IButton("回款标记");

	private VLayout mainLayout; //主面板
	private HLayout tupperLayerLayout; //顶层面板

	private VLayout searchLayout;//搜索输入框的面板
	private VLayout buttonLayout;//搜索按钮的面板

	private HLayout LowerLevelLayout;//底层面板

	private VLayout invoiceLayout;//发票的面板
	private VLayout paybacklayout;//回款的面板
	private VLayout operatingLayout;//右边的操作栏

	private ComboBoxItem contractCodeItem;
	private TextItem contractNameItem;

	private ListGridField invoiceIdField;//发票的主键
	private ListGridField invoiceCodeField;//发票代码
	private ListGridField invoiceNumberField;//发票号码
	private ListGridField customerNameField;//客户名称
	private ListGridField reimbursementField;//开票金额
	private ListGridField invoiceTimeField;//开票时间
	private ListGridField invoiceCapitalField;//发票的回款时间
	private ListGridField isCompleteField;//是否完成

	private ListGridField capitalIdField;//回款的主键
	private ListGridField capitalTimeField;//回款时间
	private ListGridField capitalAmountField;//回款金额
	private ListGridField operatorField;//操作人
	private ListGridField palteIdField;//业务部门
	private ListGridField isHavingInvoiceField;//是否对应发票


	public void initComponents(Map<String, Object> params){
		setWidth100();
		setHeight100();
		//主面板
		mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		addMember(mainLayout);
		//顶层面板
		tupperLayerLayout = new HLayout();
		tupperLayerLayout.setLayoutTopMargin(20);
		tupperLayerLayout.setWidth("100%");
		tupperLayerLayout.setHeight("10%");
		mainLayout.addMember(tupperLayerLayout);
		//底层面板
		LowerLevelLayout = new HLayout();
		LowerLevelLayout.setWidth100();
		LowerLevelLayout.setHeight("90%");
		mainLayout.addMember(LowerLevelLayout);
		//搜索输入的面板
		searchLayout = new VLayout();
		searchLayout.setWidth("90%");
		tupperLayerLayout.addMember(searchLayout);
		//搜索按钮的面板
		buttonLayout = new VLayout();
		buttonLayout.setWidth("10%");
		tupperLayerLayout.addMember(buttonLayout);

		contractCodeItem = new ComboBoxItem("contractCode","合同编号");
		contractCodeItem.setWidth("*");
		contractCodeItem.setValue(BaseHelpUtils.getString(params.get("contractCode")));
		contractCodeItem.setCanEdit(true);
		contractCodeItem.setHidden(false);
		contractCodeItem.setChangeOnKeypress(false);
		contractCodeItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		contractCodeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent changedEvent) {
				String result = BaseHelpUtils.getString(changedEvent.getValue());
				String contractName = keyMap.get(result);
				String[] split = contractName.split("-");
				contractNameItem.setValue(split[1]);
			}
		});

		contractNameItem = new TextItem("contractName","合同名称");
		contractNameItem.setWidth("*");
		contractNameItem.setValue(params.get("contractName"));
		contractNameItem.setCanEdit(true);
		contractNameItem.setHidden(false);

		searchForm.setItems(contractCodeItem,contractNameItem);
		searchForm.setNumCols(4);
		searchLayout.addMember(searchForm);
		buttonLayout.addMember(searchButton);

		invoiceIdField = new ListGridField("invoiceId", "主键");
		invoiceIdField.setHidden(true);

		invoiceCodeField = new ListGridField("invoiceCode", "发票代码");
		invoiceCodeField.setWidth("*");
		invoiceCodeField.setHidden(false);

		invoiceNumberField = new ListGridField("invoiceNumber", "发票号码");
		invoiceNumberField.setWidth("*");
		invoiceNumberField.setHidden(false);

		customerNameField = new ListGridField("customerId", "客户名称");
		customerNameField.setWidth("*");
		customerNameField.setHidden(false);
		KeyValueManager.loadValueMap("customers", customerNameField);

		reimbursementField = new ListGridField("invoiceAmount","开票金额");
		reimbursementField.setWidth("*");
		reimbursementField.setHidden(false);
		reimbursementField.setShowGridSummary(true);

		invoiceTimeField = new ListGridField("invoiceDate", "开票时间");
		invoiceTimeField.setWidth("*");
		invoiceTimeField.setHidden(false);

		invoiceCapitalField = new ListGridField("capitalAmount" , "发票回款金额");
		invoiceCapitalField.setWidth("*");
		invoiceCapitalField.setHidden(false);
		invoiceCapitalField.setShowGridSummary(true);

		isCompleteField = new ListGridField("isCapital","是否回款");
		isCompleteField.setWidth("*");
		isCompleteField.setHidden(false);
//		isCompleteField.addChangedHandler(new com.smartgwt.client.widgets.grid.events.ChangedHandler() {
//			@Override
//			public void onChanged(com.smartgwt.client.widgets.grid.events.ChangedEvent changedEvent) {
//				int rowNum = changedEvent.getRowNum();
//				int intValue = BaseHelpUtils.getIntValue(changedEvent.getValue());
//				if (intValue == 1){//已经回款
//					SC.debugger();
//					ListGridRecord record = invoiceGrid.getRecord(rowNum);
//					record.setAttribute("capitalAmount",BaseHelpUtils.getBigDecimalValue("invoiceAmount"));
//					invoiceGrid.updateData(record);
//					redraw();
//				}else{
//					ListGridRecord record = invoiceGrid.getRecord(rowNum);
//					record.setAttribute("capitalAmount",0);
//					invoiceGrid.updateData(record);
//					redraw();
//				}
//			}
//		});
//		isCompleteField.setShowGridSummary(false);
//		isCompleteField.setSelectCellTextOnClick(true);


		invoiceGrid.setFields(invoiceIdField,invoiceCodeField,invoiceNumberField,customerNameField,reimbursementField,invoiceTimeField,invoiceCapitalField,isCompleteField);

		capitalIdField = new ListGridField("capitalId", "回款的主键");
		capitalIdField.setHidden(true);

		capitalTimeField = new ListGridField("happenDate", "回款时间");
		capitalTimeField.setWidth("*");
		capitalTimeField.setHidden(false);
		capitalTimeField.setType(ListGridFieldType.DATE);

		capitalAmountField = new ListGridField("borrowMoney","回款金额");
		capitalAmountField.setType(ListGridFieldType.FLOAT);
		capitalAmountField.setFormat("###,###,###,###,###,###,###,###,###,##0.00");
		capitalAmountField.setWidth("*");
		capitalAmountField.setHidden(false);
		capitalAmountField.setShowGridSummary(true);

		operatorField = new ListGridField("operator", "操作人");
		operatorField.setWidth("*");
		operatorField.setHidden(false);

		palteIdField = new ListGridField("plateId", "业务部门");
		palteIdField.setWidth("*");
		palteIdField.setHidden(true);

		isHavingInvoiceField = new ListGridField("isHavingInvoice");
		isHavingInvoiceField.setHidden(true);

		paybackGrid.setFields(capitalIdField,capitalTimeField,capitalAmountField,operatorField,palteIdField,isHavingInvoiceField);
		//发票的面板
		invoiceLayout = new VLayout();
		invoiceLayout.setWidth("47%");
		invoiceLayout.setLayoutLeftMargin(25);
		LowerLevelLayout.addMember(invoiceLayout);
		invoiceLayout.addMember(invoiceGrid);
		//回款的面板
		paybacklayout = new VLayout();
		paybacklayout.setWidth("43%");
		paybacklayout.setLayoutLeftMargin(15);
		LowerLevelLayout.addMember(paybacklayout);
		paybacklayout.addMember(paybackGrid);
		//右边的操作栏
		operatingLayout = new VLayout();
		operatingLayout.setLayoutLeftMargin(10);
		operatingLayout.setWidth("10%");
		LowerLevelLayout.addMember(operatingLayout);

		operatingLayout.addMember(fillingButton);
		operatingLayout.addMember(saveButton);
//		operatingLayout.addMember(markButton);

		//设置行号
		paybackGrid.setShowGridSummary(true);
		paybackGrid.setCanSelectText(true);
		paybackGrid.setAutoFitFieldWidths(false);

		//设置发票的界面
		invoiceGrid.setShowGridSummary(true);
		invoiceGrid.setAutoFitFieldWidths(true);
		invoiceGrid.setDataSource(DSCapitalAndInvoiceTwo.getInstance());

		initGrid();//初始化数据
		initContracts();//初始化下拉数据

		//匹配数据按钮绑定单击事件
		fillingButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				automaticMatching();
			}
		});

		//保存按钮的单机事件
		saveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				HashMap<String, Object> params = new HashMap<>();
				//获取所有的发票的数据
				Record[] invoiceRecords = invoiceGrid.getRecords();
				//获取所有的回款的数据
				Record[] capitalRecords = paybackGrid.getRecords();
				//循环所有的发票保存所需的数据
				List<Map<String, Object>> invoiceList = new ArrayList<>();
				SC.debugger();
				for (Record record : invoiceRecords){
					HashMap<String, Object> invoiceMap = new HashMap<>();
					invoiceMap.put("invoiceId" , BaseHelpUtils.getIntValue(record.getAttribute("invoiceId")));
					invoiceMap.put("capitalAmount",BaseHelpUtils.getBigDecimalValue(record.getAttribute("capitalAmount")));
					invoiceMap.put("isCapital",BaseHelpUtils.getIntValue(record.getAttribute("isCapital")));
					__logger.info("invoiceId =======================" + BaseHelpUtils.getIntValue(record.getAttribute("invoiceId")));
					__logger.info("capitalAmount =======================" + BaseHelpUtils.getBigDecimalValue(record.getAttribute("capitalAmount")));
					__logger.info("isCapital =======================" + BaseHelpUtils.getIntValue(record.getAttribute("isCapital")));
					invoiceList.add(invoiceMap);
				}
				//循环保存回款的数据
				ArrayList<Object> capitalList = new ArrayList<>();
				for (Record record : capitalRecords){
					HashMap<String, Object> capitalMap = new HashMap<>();
					capitalMap.put("capitalId" , BaseHelpUtils.getIntValue(record.getAttribute("capitalId")));
					capitalMap.put("isHavingInvoice",BaseHelpUtils.getIntValue("isHavingInvoice"));
					capitalList.add(capitalMap);
				}

				params.put("optType","saveData");
				params.put("invoiceList",invoiceList);
				params.put("capitalList",capitalList);
				DBDataSource.callOperation("EP_CapitalAndInvoiceProcessor", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0){
							SC.say("数据保存成功!");
						}else{
							SC.say("数据保存失败!");
						}
					}
				});
			}
		});

		//搜索按钮的单机事件
		searchButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				initGrid();
			}
		});

	}

	/**
	 * 初始化差查询的数据
	 */
	public void initGrid(){
		String contractCode = BaseHelpUtils.getString(contractCodeItem.getValue());
		//根据contractCode查询出contractId
		Integer contractId = SyncDataUtil.getContractId(contractCode);

		HashMap<Object, Object> params = new HashMap<>();
		params.put("contractId",contractId);
		//查询回款
		DBDataSource.callOperation("NQ_CapitalAndInvoiceOne", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0){
					Record[] data = dsResponse.getData();
					for (int i=0 ; i<data.length ; i++){
						String operator = data[i].getAttribute("operator");
						String employee_names = KeyValueManager.getValue("employees", operator);
						data[i].setAttribute("operator" , employee_names);
						String palteId = data[i].getAttribute("plateId");
					}
					paybackGrid.setData(dsResponse.getData());
				}else{
					SC.say("回款数据加载失败!");
				}
			}
		});

		//查询发票的数据
		DBDataSource.callOperation("NQ_CapitalAndInvoiceTwo", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0){
					invoiceGrid.setData(dsResponse.getData());
				}else{

					SC.say("发票数据加载失败!");
				}
			}
		});
	}

	/**
	 * 自动匹配所有的数据，查询没有匹配的发票与回款
	 */
	public void automaticMatching(){
		ListGridRecord[] paybackRecords = paybackGrid.getRecords();
		BigDecimal tempPaybackAmount = new BigDecimal(0);
		BigDecimal tempInvoiceAmount = new BigDecimal(0);
		int counts = 0;
		//循环遍历所有的回款
		for (ListGridRecord listGridRecord : paybackRecords){
			//回款的金额
			BigDecimal totalAmount = BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("borrowMoney"));
			tempPaybackAmount = tempPaybackAmount.add(totalAmount);
			__logger.info("总的回款金额为:"+ tempPaybackAmount);
		}
		//查询所有的
		Record[] invoiceRecords = invoiceGrid.getRecords();
		for (Record listGridRecord : invoiceRecords){
			//发票的金额
			BigDecimal invoiceAmount = BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("invoiceAmount"));
			tempInvoiceAmount = tempInvoiceAmount.add(invoiceAmount);
			//比那里累加所有的发票的金额(知道发票的金额大于等于回款的金额)
			int flag = tempInvoiceAmount.compareTo(tempPaybackAmount);
			//发票的金额小于回款的金额（发票的所有的金额都已经回款）
			if (flag == -1){
				listGridRecord.setAttribute("capitalAmount",invoiceAmount);
				listGridRecord.setAttribute("isCapital","1");
				invoiceGrid.updateData(listGridRecord);
				invoiceGrid.redraw();
				__logger.info("invoiceId===="+listGridRecord.getAttribute("invoiceId"));
				//发票的金额等于回款的金额（下一条的发票的是没有回款）
			}else if (flag == 0){
				counts += 1;
				listGridRecord.setAttribute("capitalAmount" , invoiceAmount);
				listGridRecord.setAttribute("isCapital","1");
				invoiceGrid.updateData(listGridRecord);
				invoiceGrid.redraw();
				//发票的金额大于回款的金额（当前的发票只回款了的一部分）
			}else if (flag == 1){
				if (counts == 1){
					counts += 2;
					listGridRecord.setAttribute("capitalAmount" , 0);
					listGridRecord.setAttribute("isCapital","2");
					invoiceGrid.updateData(listGridRecord);
				}
				else if (counts == 0){
					counts += 2;
					BigDecimal subtract = tempPaybackAmount.subtract(tempInvoiceAmount.subtract(invoiceAmount));
					listGridRecord.setAttribute("capitalAmount" , subtract);
					listGridRecord.setAttribute("isCapital","3");
					invoiceGrid.updateData(listGridRecord);
				}
				else{
					listGridRecord.setAttribute("capitalAmount" , 0);
					listGridRecord.setAttribute("isCapital","2");
					invoiceGrid.updateData(listGridRecord);
				}

				invoiceGrid.redraw();
			}

		}
	}

	/**
	 * 加载所有的合同编号
	 */
	public void initContracts(){
		HashMap<Object, Object> params = new HashMap<>();
		SC.debugger();
		DBDataSource.callOperation("ST_Contract", "find",params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
					Record[] records = dsResponse.getData();
					SC.debugger();
					for (Record record : records){
						keyMap.put(record.getAttributeAsString("contractCode"), record.getAttributeAsString("contractCode") +"-"+ record.getAttributeAsString("contractName"));
					}
					contractCodeItem.setValueMap(keyMap);
				}
		});
	}

}
