package com.pomplatform.client.workflow.projectNormalReimbursement.form;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.workflow.panel.ReimbursementInvoiceInformationPanel;
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
import com.smartgwt.client.widgets.form.fields.FloatItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class NormalReimbursementLinkProjectPopupPanel extends VLayout implements HasHandlers {

	private static final Logger logger = Logger.getLogger("");
	private final SelectItem mainItemIdItem;
	private final SelectItem subItemIdItem;
	private final TextAreaItem remarkItem;
	private final IntegerItem normalReimbursementLinkProjectIdItem;
	private final IntegerItem projectNormalReimbursementIdItem;
	private final ComboBoxItem projectItem;
	private final TextItem contractCodeItem;
	private final TextItem plateIdItem;
	private final FloatItem amountItem;
	private final FloatItem leftAmountItem;
	private final FloatItem inputTaxItem;
	private final FloatItem inputTaxRebateItem;
	private final RadioGroupItem haveElectronicInvoiceItem; // 是否有电子发票
	private final FloatItem finalAmountItem;
	private final DynamicForm form = new DynamicForm();
	private final VLayout vLayout;
	private final VLayout rightLayout;
	private final IButton saveButton;
	private final IButton cancelButton;
	private final HLayout buttonLayout;
	private Window parentWindow;
	protected final HandlerManager handlerManager = new HandlerManager(this);
	private final LinkedHashMap<Integer, String> projectMap = new LinkedHashMap<>();
	private final Map selectedProject = new HashMap();
	private BigDecimal amount = BigDecimal.ZERO;
	private LinkedHashMap<String,String> mainItemMap = new LinkedHashMap<>();
	private LinkedHashMap<String,String> subItemMap = new LinkedHashMap<>();

	private ReimbursementInvoiceInformationPanel addInvoiceInformationPanel = new ReimbursementInvoiceInformationPanel();
	
	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	public NormalReimbursementLinkProjectPopupPanel(boolean update, LinkedHashMap<Integer, String> allProjectMap, boolean editInputTax,LinkedHashMap<String,String> mainItemMap, final LinkedHashMap<String,String> subItemMap) {
		this.mainItemMap = mainItemMap;
		this.subItemMap = subItemMap;
		IsIntegerValidator intValidate = new IsIntegerValidator();
		intValidate.setErrorMessage("数据有误，请从下拉列表中选取正确数据");
		
		HLayout mainLayout = new HLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.setMembersMargin(10);

		rightLayout = new VLayout();
		rightLayout.setWidth("50%");
		rightLayout.setHeight100();
		rightLayout.hide();
		
		vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		vLayout.setMargin(10);
		vLayout.setMembersMargin(12);

		normalReimbursementLinkProjectIdItem = new IntegerItem("normalReimbursementLinkProjectId", "日常报销关联项目ID");
		normalReimbursementLinkProjectIdItem.setHidden(true);

		projectNormalReimbursementIdItem = new IntegerItem("projectNormalReimbursementId", "日常报销主表ID");
		projectNormalReimbursementIdItem.setHidden(true);
		
		mainItemIdItem = new SelectItem("mainItemId", "报销科目");
		mainItemIdItem.setRequired(true);
		mainItemIdItem.setChangeOnKeypress(false);
		mainItemIdItem.setValueMap(mainItemMap);
		mainItemIdItem.setWidth("*");
		mainItemIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		mainItemIdItem.setValidateOnExit(true);
		mainItemIdItem.setValidators(intValidate);

		subItemIdItem = new SelectItem("subItemId", "报销选项");
		subItemIdItem.setChangeOnKeypress(false);
		subItemIdItem.setWidth("*");
		subItemIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		subItemIdItem.setValidateOnExit(true);
		subItemIdItem.setValidators(intValidate);
		
		
		remarkItem = new TextAreaItem("remark", "摘要");
		remarkItem.setColSpan(3);
		remarkItem.setRowSpan(3);
		remarkItem.setRequired(true);
		remarkItem.setWidth("*");
		
		mainItemIdItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				subItemIdItem.clearValue();
				if (null != event.getValue()) {
					LinkedHashMap<String,String> tempMap = new LinkedHashMap<>();
					String parent = event.getValue().toString();
					for(String str : subItemMap.keySet()){
						String[] arr = str.split("-");
						if(arr[1].equals(parent)){
							tempMap.put(arr[0], subItemMap.get(str));
						}
					}
					subItemIdItem.setValueMap(tempMap);
				}
				inputTaxItem.setCanEdit(true);
				int value = BaseHelpUtils.getIntValue(event.getItem().getValue());
				if (value == 1 || value == 43){
					inputTaxItem.setCanEdit(false);
				}
			}
		});
		
		projectItem = new ComboBoxItem("project", "项目");
		projectItem.setChangeOnKeypress(false);
		projectItem.setWidth("*");
		projectItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		projectItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				int id = BaseHelpUtils.getIntValue(event.getValue());
				if(id > 0){
					String value = projectItem.getDisplayValue();
					if(!BaseHelpUtils.isNullOrEmpty(value)) {
						String[] arr = value.split("--");
						if(arr.length >= 1 && null != arr[0]){
							contractCodeItem.setValue(arr[0]);
						}
					}
				}
			}
		});

//		if(update && null != allProjectMap && !allProjectMap.isEmpty()){
//			projectItem.setValueMap(allProjectMap);
//			projectItem.addChangedHandler(new ChangedHandler() {
//				@Override
//				public void onChanged(ChangedEvent event) {
//					if(null != projectItem.getValue()){
//						String value = allProjectMap.get(ClientUtil.checkAndGetIntValue(projectItem.getValue()));
//						String[] arr = value.split("--");
//						if(arr.length >= 1 && null != arr[0]){
//							contractCodeItem.setValue(arr[0]);
//						}
////						if(arr.length >= 3 && null != arr[2]){
////							plateIdItem.setValue(arr[2]);
////						}
//					}
//				}
//			});
//		}else{
//			projectItem.addChangedHandler(new ChangedHandler() {
//				@Override
//				public void onChanged(ChangedEvent event) {
//					if(null != projectItem.getValue() && null != projectMap && !projectMap.isEmpty()){
//						String value = projectMap.get(ClientUtil.checkAndGetIntValue(projectItem.getValue()));
//						String[] arr = value.split("--");
//						if(arr.length >= 1 && null != arr[0]){
//							contractCodeItem.setValue(arr[0]);
//						}
////						if(arr.length >= 3 && null != arr[2]){
////							plateIdItem.setValue(arr[2]);
////						}
//					}
//				}
//			});
//		}

		contractCodeItem = new TextItem("contractCode", "项目编号");
		contractCodeItem.setWidth("*");
		contractCodeItem.setDisabled(true);

		plateIdItem = new TextItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setHidden(true);
		plateIdItem.setDisabled(true);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		amountItem = new FloatItem("amount", "费用");
		amountItem.setWidth("*");
		amountItem.setLength(18);
		amountItem.setDecimalPad(5);
		amountItem.setFormat("#,###,###,###,##0.00");
		amountItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if (null != event.getValue() && null != BigDecimal.ZERO) {
					FormItem item = event.getItem();
					BigDecimal newValue = new BigDecimal(item.getValue().toString())
							.divide(BigDecimal.ONE, 2, BigDecimal.ROUND_DOWN);
					item.setValue(newValue);
//					leftAmountItem.setValue(amount.subtract(newValue));
					finalAmountItem.setValue(newValue.subtract(new BigDecimal(inputTaxItem.getValueAsString()).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_DOWN)));
				}
			}
		});
		
		leftAmountItem = new FloatItem("leftAmount", "剩余费用");
		leftAmountItem.setWidth("*");
		leftAmountItem.setLength(18);
		leftAmountItem.setDecimalPad(5);
		leftAmountItem.setDisabled(true);
		leftAmountItem.setHidden(true);
		leftAmountItem.setFormat("#,###,###,###,##0.00");
		
		inputTaxItem = new FloatItem("inputTax", "进项税");
		inputTaxItem.setWidth("*");
		inputTaxItem.setLength(18);
		inputTaxItem.setDecimalPad(5);
		inputTaxItem.setHidden(!editInputTax);
		inputTaxItem.setDefaultValue(0.00);
		inputTaxItem.setFormat("#,###,###,###,##0.00");
		inputTaxItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				showAddReimbursementInvoiceInformation(haveElectronicInvoiceItem.getValue(), event.getValue());
				if (null != event.getValue() && null != amountItem.getValue()) {
					FormItem item = event.getItem();
					BigDecimal inputTaxRebate = BaseHelpUtils.getBigDecimalValue(inputTaxRebateItem.getValue());
					BigDecimal newValue = new BigDecimal(item.getValue().toString())
							.divide(BigDecimal.ONE, 2, BigDecimal.ROUND_DOWN);
					BigDecimal amount = new BigDecimal(amountItem.getValue().toString())
							.divide(BigDecimal.ONE, 2, BigDecimal.ROUND_DOWN);
					//进项税不得大于总金额，如果进项税大于总金额，则将进项税和成本都重置为0
					if (newValue.compareTo(amount) > 0 || newValue.compareTo(BigDecimal.ZERO) < 0) {
						item.setValue(0);
						finalAmountItem.setValue(amountItem.getValue());
					} else {
						item.setValue(newValue);
						finalAmountItem.setValue(amount.subtract(newValue).add(inputTaxRebate));
					}
				}else{
//					inputTaxItem.setValue(0);
					finalAmountItem.setValue(amountItem.getValue());
				}
			}
		});


		inputTaxRebateItem = new FloatItem("inputTaxRebate","进项税转出");
		inputTaxRebateItem.setWidth("*");
		inputTaxRebateItem.setLength(18);
		inputTaxRebateItem.setDecimalPad(5);
		inputTaxRebateItem.setHidden(!editInputTax);
		inputTaxRebateItem.setDefaultValue(0.00);
		inputTaxRebateItem.setFormat("#,###,###,###,##0.00");
		inputTaxRebateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if (null != event.getValue() && null != amountItem.getValue()) {
					FormItem item = event.getItem();
					BigDecimal inputTax = BaseHelpUtils.getBigDecimalValue(inputTaxItem.getValue());
					BigDecimal newValue = new BigDecimal(item.getValue().toString())
							.divide(BigDecimal.ONE, 2, BigDecimal.ROUND_DOWN);
					BigDecimal amount = new BigDecimal(amountItem.getValue().toString())
							.divide(BigDecimal.ONE, 2, BigDecimal.ROUND_DOWN);
					//进项税不得大于总金额，如果进项税大于总金额，则将进项税和成本都重置为0
					if (newValue.compareTo(amount) > 0 || newValue.compareTo(BigDecimal.ZERO) < 0) {
						item.setValue(0);
						finalAmountItem.setValue(amountItem.getValue());
					} else {
						item.setValue(newValue);
						finalAmountItem.setValue(amount.add(newValue).subtract(inputTax));
					}
				}else{
//					inputTaxItem.setValue(0);
					finalAmountItem.setValue(amountItem.getValue());
				}
			}
		});
		int departmentId = BaseHelpUtils.getIntValue(ClientUtil.getDepartmentId());
		if (departmentId == 10){
			inputTaxRebateItem.setCanEdit(true);
		}else{
			inputTaxRebateItem.setCanEdit(false);
		}

		finalAmountItem = new FloatItem("finalAmount", "成本");
		finalAmountItem.setWidth("*");
		finalAmountItem.setDisabled(true);
		finalAmountItem.setLength(18);
		finalAmountItem.setDecimalPad(5);
		finalAmountItem.setHidden(!editInputTax);
		finalAmountItem.setFormat("#,###,###,###,##0.00");
		finalAmountItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if (null != event.getValue() && null != amountItem.getValue()) {
					FormItem item = event.getItem();
					BigDecimal newValue = new BigDecimal(item.getValue().toString())
							.divide(BigDecimal.ONE, 2, BigDecimal.ROUND_DOWN);
					BigDecimal amount = new BigDecimal(amountItem.getValue().toString())
							.divide(BigDecimal.ONE, 2, BigDecimal.ROUND_DOWN);
					//成本不得大于总金额，如果成本大于总金额，则将进项税和成本都重置为0
					if (newValue.compareTo(amount) > 0 || newValue.compareTo(BigDecimal.ZERO) < 0) {
						item.setValue(0);
						inputTaxItem.setValue(amountItem.getValue());
					} else {
						item.setValue(newValue);
						inputTaxItem.setValue(amount.subtract(newValue));
					}
				}else{
					inputTaxItem.setValue(amountItem.getValue());
					finalAmountItem.setValue(0);
				}
			}
		});

		Map<Integer, String> haveEI = new HashMap<>();
		haveEI.put(1, "无");
		haveEI.put(2, "有");
		haveElectronicInvoiceItem = new RadioGroupItem("haveElectronicInvoice", "是否有电子发票");
		haveElectronicInvoiceItem.setVertical(false);
		haveElectronicInvoiceItem.setDefaultValue(1);
		haveElectronicInvoiceItem.setValueMap(haveEI);
		haveElectronicInvoiceItem.addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				showAddReimbursementInvoiceInformation(event.getValue(), inputTaxItem.getValue());
			}
		});
		
		form.setNumCols(2);
		form.setItems(mainItemIdItem, subItemIdItem, normalReimbursementLinkProjectIdItem, projectNormalReimbursementIdItem, projectItem, contractCodeItem,
				plateIdItem, amountItem, leftAmountItem, inputTaxItem,inputTaxRebateItem, finalAmountItem, haveElectronicInvoiceItem, remarkItem);

		vLayout.addMember(form);

		saveButton = new IButton("确定", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!BaseHelpUtils.isNullOrEmpty(projectItem.getValue())){
//					Map<String,Object> param = new HashMap<>();
//					param.put("projectId", projectItem.getValue());
//					DBDataSource.callOperation("ST_Project", "find", param, new DSCallback() {
//						@Override
//						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//							if(dsResponse.getStatus() >= 0){
//								Record record = dsResponse.getData()[0];
//								BigDecimal projectIntegral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("projectIntegral"));
//								BigDecimal amount = BaseHelpUtils.getBigDecimalValue(amountItem.getValue());
//								if(projectIntegral.compareTo(amount) < 0){
//									SC.say("该项目最多可报销"+projectIntegral+"元");
//									return;
//								}
					//获取项目id
					//SC.debugger();
					/*if(BaseHelpUtils.isNullOrEmpty(bdrecord)&&bdrecord==null){
					int projectId=BaseHelpUtils.getIntValue(projectItem.getValue());
					if(projectId <= 0) {
						Record record = getValueAsRecord();
						setEvent(record);
						return;
					}
					if(projectId>0) {
						Map<String,Object> map=new HashMap<>();
						map.put("projectId", projectId);
						DBDataSource.callOperation("ST_BudgetManagement","find",map,new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								int status = BaseHelpUtils.getIntValue(dsResponse.getStatus());
								if(status < 0) {//说明返回数据集失败
									SC.say("提示","操作失败");
									return;
								}
								int length = 0;
								if(!BaseHelpUtils.isNullOrEmpty(dsResponse.getData())) {
									length=BaseHelpUtils.getIntValue(dsResponse.getData().length);
								}
								if(length>0) {
									SC.ask("此项目有绑定预算单，是否绑定？",new BooleanCallback() {
										@Override
										public void execute(Boolean value) {
											if(value) {
												Record[] record = dsResponse.getData();
												final PopupWindow popupWindow = new PopupWindow("选择绑定的付款序列");
												popupWindow.setWidth("70%");
												popupWindow.setHeight("70%");
												popupWindow.centerInPage();
												NrPaymentSequenceinfoPanel nrpaySeqPanel = new NrPaymentSequenceinfoPanel();
												nrpaySeqPanel.setRecord(record);
												nrpaySeqPanel.initComponents();
												nrpaySeqPanel.lodaDate();
												popupWindow.addItem(nrpaySeqPanel);
												nrpaySeqPanel.addDataEditedHandler(new DataEditedHandler(){
													@SuppressWarnings("unchecked")
													@Override
													public void onDataEdited(DataEditEvent event) {
														Map<String,Object> param = new HashMap<>();
														Record record=event.getData();
														if(!BaseHelpUtils.isNullOrEmpty(record)) {
															param.putAll(record.toMap());
														}
														Record da = getValueAsRecord();
														if(!BaseHelpUtils.isNullOrEmpty(da)) {
															param.putAll(da.toMap());
														}
														Record newData = new Record();
														for(String key : param.keySet()) {
															newData.setAttribute(key,param.get(key));
														}
														setEvent(newData);
													}
												});
												popupWindow.addCloseClickHandler(new CloseClickHandler() {
													@Override
													public void onCloseClick(CloseClickEvent event) {
														popupWindow.destroy();
													}
												});
												nrpaySeqPanel.setParentWindow(popupWindow);
												popupWindow.centerInPage();
												popupWindow.show();
											}else {
												Record record = getValueAsRecord();
												setEvent(record);
											}
										}
									});
								}else {
									Record record = getValueAsRecord();
									setEvent(record);
								}
							}
						});
						
					}
					}else {
						Record record = getValueAsRecord();
						setEvent(record);
					}*/
					
//							}
//						}
//					});
					Record record = getValueAsRecord();
					setEvent(record);
				}
			}
		});
		
		cancelButton = new IButton("取消", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (null == getParentWindow()) {
					return;
				}
				getParentWindow().destroy();
			}
		});
		buttonLayout = new HLayout();
		buttonLayout.setWidth100();
		buttonLayout.setHeight100();
		buttonLayout.setMargin(8);
		buttonLayout.setMembersMargin(20);
		buttonLayout.setAlign(Alignment.CENTER);
		buttonLayout.addMember(saveButton);
		buttonLayout.addMember(cancelButton);

		rightLayout.addMember(addInvoiceInformationPanel);

		vLayout.addMember(buttonLayout);
		mainLayout.addMember(vLayout);
		mainLayout.addMember(rightLayout);
		addMember(mainLayout);
	}
	
	public void setEvent(Record data) {
		if (DataValidate()) {
			DataEditEvent dee = new DataEditEvent();
			dee.setData(data);
			fireEvent(dee);
			if (null == getParentWindow()) {
				return;
			}
			getParentWindow().destroy();
		} else {
			return;
		}
	}

	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public Record getValueAsRecord() {
		Map map = form.getValues();
		Record record = new Record();
		if (null != map && !map.isEmpty()) {
			for (Object key : map.keySet()) {
				if (key.toString().equals("project")) {
					record.setAttribute("projectId", map.get(key));
				} else {
					record.setAttribute(key.toString(), map.get(key));
				}
			}
		}
		Record[] invoiceList = addInvoiceInformationPanel.getValues();
		record.setAttribute("invoiceList", invoiceList);
		return record;
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

	/**
	 * 
	 * @param record
	 *            需要编辑的记录
	 * @param employeeId
	 *            报销人ID
	 * @param amount
	 *            剩余的可供报销分拆的总额
	 * @param update
	 *            本次操作是否是修改操作
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void startEdit(Record record, int employeeId, BigDecimal amount, final Map selectedProject, boolean update) {
		this.selectedProject.putAll(selectedProject);
		Map<String, Object> map = new HashMap<>();
		map.put("employeeId", employeeId);
		map.put("optType", "getMainProjectName");
		DBDataSource.callOperation("EP_GetUserInfoById", map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Map map = BaseHelpUtils.getResponseUserData(dsResponse);
					if(!BaseHelpUtils.isNullOrEmpty(map)) {
						projectMap.putAll(map);
					}
					projectItem.setValueMap(projectMap);
				}
			}
		});
		if(record!=null) {
			loadBudgetDate(record);
		}
		// 新建则加载与用户相关联的项目信息，如果是修改，则将选中的项目信息加载到页面
		if (update) {
			form.editRecord(record);
			if (null != record.getAttribute("projectId")) {
				projectItem.setDefaultValue(record.getAttribute("projectId"));
			}
			if(null != record.getAttribute("amount")){
				this.amount = amount.add(new BigDecimal(record.getAttribute("amount")));
			}
			if(null != mainItemIdItem.getValue()){
				LinkedHashMap<String,String> tempMap = new LinkedHashMap<>();
				String parent = mainItemIdItem.getValue().toString();
				for(String str : subItemMap.keySet()){
					String[] arr = str.split("-");
					if(arr[1].equals(parent)){
						tempMap.put(arr[0], subItemMap.get(str));
					}
				}
				subItemIdItem.setValueMap(tempMap);
			}
		} else {
			this.amount = amount;
			if (null != amount) {
				amountItem.setDefaultValue(amount);
				leftAmountItem.setDefaultValue(BigDecimal.ZERO);
				inputTaxItem.setDefaultValue(BigDecimal.ZERO);
				finalAmountItem.setDefaultValue(amount);
			}
		}
		
	}

	public void showAddReimbursementInvoiceInformation(Object haveElectronicInvoice, Object inputTaxValue) {
		if ((null != inputTaxValue && BaseHelpUtils.getDoubleValue(inputTaxValue) > 0)
				|| (null != haveElectronicInvoice && BaseHelpUtils.getIntValue(haveElectronicInvoice) == 2)) {
			if (!rightLayout.isVisible()) {
				getParentWindow().setWidth("80%");
				getParentWindow().centerInPage();
				vLayout.setWidth("40%");
				rightLayout.show();
			}
		} else {
			if (rightLayout.isVisible()) {
				getParentWindow().setWidth(550);
				getParentWindow().centerInPage();
				vLayout.setWidth100();
				rightLayout.hide();
			}
		}
	}
	
	public void initInvoiceRecords(Record record, Record [] invoiceList) {
		if(null == invoiceList) {
			invoiceList = new Record[0];
		}
		String haveElectronicInvoice = record.getAttribute("haveElectronicInvoice");
		String inputTax = record.getAttribute("inputTax");
		showAddReimbursementInvoiceInformation(haveElectronicInvoice, inputTax);
		addInvoiceInformationPanel.setValues(invoiceList);
	}
	
	// 数据验证
	public boolean DataValidate() {
		if(null == mainItemIdItem.getValue()){
			SC.warn("提示", "请选择报销科目");
			return false;
		}
		if(null == projectItem.getValue()){
			SC.warn("提示", "请选择一个项目");
			return false;
		}
		if(null == remarkItem.getValue()){
			SC.warn("提示", "请输入备注");
			return false;
		}
//		if(null != selectedProject && !selectedProject.isEmpty() && selectedProject.containsKey(projectItem.getValue())){
//			SC.warn("提示", "请不要重复选择同一个项目");
//			return false;
//		}
		if(null == amountItem.getValue()){
			SC.warn("提示", "请填写该项目需要承担的费用");
			return false;
		}
//		if(null == amount){
//			return false;
//		}
		BigDecimal money = new BigDecimal(amountItem.getValueAsString());
		if(money.compareTo(BigDecimal.ZERO) == 0){
			SC.warn("提示", "项目需要承担的费用不能为0");
			return false;
		}
//		if(money.compareTo(amount) > 0){
//			SC.warn("提示", "项目需要承担的费用不能大于目前的可分拆报销总额："+amount);
//			return false;
//		}
		//进项税和成本的和
		BigDecimal moneySum = (BaseHelpUtils.getBigDecimalValue(inputTaxItem.getValue()).add(BaseHelpUtils.getBigDecimalValue(finalAmountItem.getValue()))).subtract(BaseHelpUtils.getBigDecimalValue(inputTaxRebateItem.getValue()));
		if(moneySum.compareTo(money) != 0){
			SC.say("进项税和成本之和减去进项税转出不等于费用，请重新调整数据");
			return false;
		}

		BigDecimal inputTax = BaseHelpUtils.getBigDecimalValue(inputTaxItem.getValue());
		BigDecimal inputTaxRebate = BaseHelpUtils.getBigDecimalValue(inputTaxRebateItem.getValue());
		if (inputTax.compareTo(inputTaxRebate) == -1){
			SC.say("进项税转出金额不能大于进项税金额，请重新调整数据");
			return false;
		}
		BigDecimal checkInputTaxAmount = BigDecimal.ZERO;
		Record [] records = addInvoiceInformationPanel.getValues();
		for (Record record : records) {
			checkInputTaxAmount = checkInputTaxAmount.add(BaseHelpUtils.getBigDecimalValue(record.getAttribute("taxAmount")));
		}
		if(inputTax.compareTo(checkInputTaxAmount) != 0) {
			SC.say("左右进项税不对等，请核查数据，保证左方填写的进项税与右方列表的进项税额汇总数相等");
			return false;
		}
		String haveElectronicInvoice = haveElectronicInvoiceItem.getValueAsString();
		if(null != haveElectronicInvoice && haveElectronicInvoice.equals("2")) {
			if(null == records || records.length == 0) {
				SC.say("请在右方面板添加电子发票");
				return false;
			}
		}
		return true;
	}
	
	/*private Record bdrecord;

	public Record getBdrecord() {
		return bdrecord;
	}

	public void setBdrecord(Record bdrecord) {
		this.bdrecord = bdrecord;
	}*/
	
	
	public void loadBudgetDate(Record record) {
		//获取付款金额
		BigDecimal  payAmount=BaseHelpUtils.getBigDecimalValue(record.getAttribute("payAmount"));
		//获取冲账金额
		BigDecimal  reverseAmount=BaseHelpUtils.getBigDecimalValue(record.getAttribute("reverseAmount"));
		//费用
		BigDecimal  amount=BigDecimal.ZERO;
		amount=payAmount.add(reverseAmount);
		amountItem.setValue(amount);
		finalAmountItem.setValue(amount);
		//获取项目ID
//		int projectIds=BaseHelpUtils.getIntValue(record.getAttribute("projectId"));
//		String projectId=BaseHelpUtils.getString(projectIds);
//		String value = KeyValueManager.getValue("projects", projectId);
		//修改下拉值的加载方式
//		String value = SyncDataUtil.getProjectName(BaseHelpUtils.getIntValue(projectId));
//		Record record1 = getProjectName(BaseHelpUtils.getIntValue(projectId));
//		String value = BaseHelpUtils.getString(record1.getAttribute("projectName"));
//		Map<String, Object> map = new HashMap<>();
//		map.put("projectName", value);
//		DBDataSource.callOperation("EP_GetProjectByProjectName", map, new DSCallback() {
//			@Override
//			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//				if (dsResponse.getStatus() >= 0) {
//					Record[] record = dsResponse.getData();
//					projectMap.clear();
//						for (Record obj : record) {
//						projectMap.put(obj.getAttributeAsInt("projectId"), obj.getAttribute("projectName"));
//					}
//					projectItem.setValueMap(projectMap);
//					projectItem.setValue(projectIds);
//					String value = projectMap.get(ClientUtil.checkAndGetIntValue(projectItem.getValue()));
//					String[] arr = value.split("--");
//					if(arr.length >= 1 && null != arr[0]){
//						contractCodeItem.setValue(arr[0]);
//					}
//					if(arr.length >= 3 && null != arr[2]){
//						plateIdItem.setValue(arr[2]);
//					}
//				}
//			}
//		});
		
		
	}

	/**
	 * 获取项目的名称
	 * @param projectId
	 * @return
	 */
	private Record getProjectName(Integer projectId){
		Record record = new Record();
		HashMap<Object, Object> map = new HashMap<>();
		map.put("projectId",projectId);
		DBDataSource.callOperation("ST_Project", "find", map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record[] records = dsResponse.getData();
					if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
						//获取项目名称
						String projectName = BaseHelpUtils.getString(records[0].getAttribute("projectName"));
						record.setAttribute("projectName",projectName);
					}
				}
			}
		});
		return record;
	}
	
}
