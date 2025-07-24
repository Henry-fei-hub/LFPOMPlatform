package com.pomplatform.client.workflow.companyCommonNormalReimbursement.form;

import java.math.BigDecimal;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
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
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;

public class CompanyNormalReimbursementLinkDepartmentPopupPanel extends VLayout implements HasHandlers {

	private static final Logger logger = Logger.getLogger("");
	private final IntegerItem normalReimbursementLinkDepartmentIdItem;
	private final IntegerItem projectNormalReimbursementIdItem;
	private final PickTreeItem departmentItem;
	private final FloatItem amountItem;
	private final FloatItem leftAmountItem;
	private final DynamicForm form = new DynamicForm();
	private final VLayout vLayout;
	private final IButton saveButton;
	private final IButton cancelButton;
	private final HLayout buttonLayout;
	private Window parentWindow;
	protected final HandlerManager handlerManager = new HandlerManager(this);
	private BigDecimal amount = BigDecimal.ZERO;
	private Tree tree = KeyValueManager.getTree("departments");

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	public CompanyNormalReimbursementLinkDepartmentPopupPanel(boolean update) {

		vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		vLayout.setMargin(10);
		vLayout.setMembersMargin(12);

		normalReimbursementLinkDepartmentIdItem = new IntegerItem("normalReimbursementLinkDepartmentId", "差旅报销关联部门ID");
		normalReimbursementLinkDepartmentIdItem.setHidden(true);

		projectNormalReimbursementIdItem = new IntegerItem("projectNormalReimbursementId", "差旅报销主表ID");
		projectNormalReimbursementIdItem.setHidden(true);

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
				if (null != event.getValue() && null != amount) {
					FormItem item = event.getItem();
					BigDecimal newValue = new BigDecimal(item.getValue().toString())
							.divide(BigDecimal.ONE, 2, BigDecimal.ROUND_DOWN);
					item.setValue(newValue);
					leftAmountItem.setValue(getAmount().subtract(newValue));
				}
			}
		});
		
		leftAmountItem = new FloatItem("leftAmount", "剩余费用");
		leftAmountItem.setWidth("*");
		leftAmountItem.setLength(18);
		leftAmountItem.setDecimalPad(5);
		leftAmountItem.setDisabled(true);
		leftAmountItem.setFormat("#,###,###,###,##0.00");

		form.setNumCols(2);
		form.setItems(normalReimbursementLinkDepartmentIdItem, projectNormalReimbursementIdItem, departmentItem,
				 amountItem, leftAmountItem);

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

		vLayout.addMember(buttonLayout);

		addMember(vLayout);
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
					String departmentId = "1";
					if(paths.length >= 4){
						departmentId = paths[3];
					}else{
						departmentId = paths[paths.length-1];
					}
					record.setAttribute("departmentId", departmentId);
				}else{
					record.setAttribute(key.toString(), map.get(key));
				}
			}
		}
		return record;
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

	/**
	 * 
	 * @param record
	 *            需要编辑的记录
	 * @param departmentId
	 *            报销部门ID
	 * @param amount
	 *            剩余的可供报销分拆的总额
	 * @param update
	 *            本次操作是否是修改操作
	 */
	public void startEdit(Record record, BigDecimal amount, boolean update) {
		if (update) {
			if(null != record.getAttribute("amount") && null != amount){
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
			}
		}
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
		return true;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
}
