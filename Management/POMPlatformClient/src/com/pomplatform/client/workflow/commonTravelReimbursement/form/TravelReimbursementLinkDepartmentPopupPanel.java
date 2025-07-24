package com.pomplatform.client.workflow.commonTravelReimbursement.form;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.workflow.panel.ReimbursementInvoiceInformationPanel;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FloatItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.PickTreeItem;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;

public class TravelReimbursementLinkDepartmentPopupPanel extends VLayout implements HasHandlers {

	private static final Logger logger = Logger.getLogger("");
	private final IntegerItem travelReimbursementLinkDepartmentIdItem;
	private final IntegerItem travelReimbursementIdItem;
	private final PickTreeItem departmentItem;
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
	private BigDecimal amount = BigDecimal.ZERO;
	private Tree tree = KeyValueManager.getTree("departments");
	
	private ReimbursementInvoiceInformationPanel addInvoiceInformationPanel = new ReimbursementInvoiceInformationPanel();

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	/**
	 * 
	 * @param update	是否是修改页面  true:修改页面   false:新增页面
	 * @param editInputTax	是否是编辑进项税和成本的页面
	 */
	public TravelReimbursementLinkDepartmentPopupPanel(boolean update, boolean editInputTax) {
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

		travelReimbursementLinkDepartmentIdItem = new IntegerItem("travelReimbursementLinkDepartmentId", "差旅报销关联部门ID");
		travelReimbursementLinkDepartmentIdItem.setHidden(true);

		travelReimbursementIdItem = new IntegerItem("travelReimbursementId", "差旅报销主表ID");
		travelReimbursementIdItem.setHidden(true);

		departmentItem = new PickTreeItem("department", "报销部门");
		departmentItem.setWidth("*");
		departmentItem.setCanSelectParentItems(true);
        departmentItem.setValueTree(KeyValueManager.getTree("departments"));
        departmentItem.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				if(null != event.getValue()){
					if(event.getValue().toString().split("/").length <= 2){
						event.cancel();
					}
				}
			}
		});

		amountItem = new FloatItem("amount", "费用");
		amountItem.setWidth("*");
		amountItem.setLength(18);
		amountItem.setDecimalPad(5);
		amountItem.setFormat("#,###,###,###,##0.00");
		amountItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if (null != event.getValue() && null!= amount) {
					FormItem item = event.getItem();
					BigDecimal newValue = new BigDecimal(item.getValue().toString())
							.divide(BigDecimal.ONE, 2, BigDecimal.ROUND_DOWN);
					item.setValue(newValue);
					leftAmountItem.setValue(amount.subtract(newValue));
					finalAmountItem.setValue(newValue.subtract(new BigDecimal(inputTaxItem.getValueAsString()).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_DOWN)));
				}
			}
		});
		
		leftAmountItem = new FloatItem("leftAmount", "剩余费用");
		leftAmountItem.setWidth("*");
		leftAmountItem.setLength(18);
		leftAmountItem.setDecimalPad(5);
		leftAmountItem.setDisabled(true);
		leftAmountItem.setFormat("#,###,###,###,##0.00");
		
		inputTaxItem = new FloatItem("inputTax", "进项税");
		inputTaxItem.setWidth("*");
		inputTaxItem.setLength(18);
		inputTaxItem.setDecimalPad(5);
		inputTaxItem.setHidden(!editInputTax);
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
					inputTaxItem.setValue(0);
					finalAmountItem.setValue(amountItem.getValue());
				}
			}
		});

		inputTaxRebateItem = new FloatItem("inputTaxRebate","进项税转出");
		inputTaxRebateItem.setWidth("*");
		inputTaxRebateItem.setLength(18);
		inputTaxRebateItem.setDecimalPad(5);
		inputTaxRebateItem.setHidden(!editInputTax);
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
					inputTaxItem.setValue(0);
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
		finalAmountItem.setDisabled(true);
		finalAmountItem.setWidth("*");
		finalAmountItem.setLength(18);
		finalAmountItem.setDecimalPad(5);
		finalAmountItem.setHidden(!editInputTax);
		finalAmountItem.setFormat("#,###,###,###,##0.00");
		finalAmountItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if (null != event.getValue() && null != amountItem.getValue()) {
					FormItem item = event.getItem();
					BigDecimal inputTaxRebate = BaseHelpUtils.getBigDecimalValue(inputTaxRebateItem.getValue());
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
						inputTaxItem.setValue(amount.subtract(newValue).add(inputTaxRebate));
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
		form.setItems(travelReimbursementLinkDepartmentIdItem, travelReimbursementIdItem, departmentItem,
				 amountItem, leftAmountItem, inputTaxItem, inputTaxRebateItem, finalAmountItem, haveElectronicInvoiceItem);

		vLayout.addMember(form);

		saveButton = new IButton("确定", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (DataValidate()) {
					DataEditEvent dee = new DataEditEvent();
					dee.setData(getValueAsRecord());
					fireEvent(dee);
					if (null == getParentWindow()) {
						return;
					}
					getParentWindow().destroy();
				} else {
					return;
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

	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public Record getValueAsRecord() {
		Map map = form.getValues();
		Record record = new Record();
		if (null != map && !map.isEmpty()) {
			for (Object key : map.keySet()) {
				if(key.toString().equals("department") && null != map.get(key)){
					//如果是部门的选择结果，则根据选择结果得到>=第三级部门的结果
					String[] paths = map.get(key).toString().split("/");
					String departmentId = null == paths[paths.length-1] ? "1" : paths[paths.length-1];
					record.setAttribute("departmentId", departmentId);
				}else{
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
	 * @param amount
	 *            剩余的可供报销分拆的总额
	 * @param update
	 *            本次操作是否是修改操作
	 */
	public void startEdit(Record record, BigDecimal amount, boolean update) {
		if (update) {
			if(null != record.getAttribute("amount")){
				this.amount = amount.add(new BigDecimal(record.getAttribute("amount")));
			}
			if(null != record.getAttribute("departmentId")){
				TreeNode[] nodes = tree.getAllNodes();
				String value = record.getAttribute("departmentId");
				for(TreeNode node : nodes){
					if(node.getName().equals(value)){
						record.setAttribute("department", tree.getPath(node));
						break;
					}
				}
			}
			form.editRecord(record);
		} else {
			if (null != amount) {
				this.amount = amount;
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
		if(null == departmentItem.getValue()){
			SC.warn("提示", "请选择一个部门");
			return false;
		}
		if(null == amountItem.getValue()){
			SC.warn("提示", "请填写该部门需要承担的费用");
			return false;
		}
		if(null == amount){
			return false;
		}
		BigDecimal money = new BigDecimal(amountItem.getValueAsString());
		if(money.compareTo(BigDecimal.ZERO) == 0){
			SC.warn("提示", "部门需要承担的费用不能为0");
			return false;
		}
		if(money.compareTo(amount) > 0){
			SC.warn("提示", "部门需要承担的费用不能大于目前的可分拆报销总额："+amount);
			return false;
		}
		//进项税和成本的和
		BigDecimal moneySum = (BaseHelpUtils.getBigDecimalValue(inputTaxItem.getValue()).add(BaseHelpUtils.getBigDecimalValue(finalAmountItem.getValue()))).subtract(BaseHelpUtils.getBigDecimalValue(inputTaxRebateItem.getValue()));
		if(moneySum.compareTo(money) != 0){
			SC.say("进项税和成本之和减去进项税转出金额不等于费用，请重新调整数据");
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
	
}
