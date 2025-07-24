package com.pomplatform.client.costallocation.form;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.*;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.project.datasource.DSGetProjects;
import com.smartgwt.client.data.*;
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
import com.smartgwt.client.widgets.form.fields.PickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.Tree;

public class ResetCostPopupPanel extends VLayout implements HasHandlers {

	private static final Logger logger = Logger.getLogger("");
	private final SelectItem typeItem;
	private final ComboBoxItem projectItem;
	private final PickTreeItem departmentItem;
	private final FloatItem leftCostItem;
	private final FloatItem costItem;
	private final DynamicForm form = new DynamicForm();
	private final VLayout vLayout;
	private final IButton saveButton;
	private final IButton cancelButton;
	private final HLayout buttonLayout;
	private Window parentWindow;
	protected final HandlerManager handlerManager = new HandlerManager(this);
	private BigDecimal leftCost = BigDecimal.ZERO;
	private Tree tree = KeyValueManager.getTree("departments");

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	public ResetCostPopupPanel(boolean update) {

		vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		vLayout.setMargin(10);
		vLayout.setMembersMargin(12);

		typeItem = new SelectItem("type", "成本类型");
		LinkedHashMap<Integer, String> typeMap = new LinkedHashMap<>();
		typeMap.put(1, "项目成本");
		typeMap.put(3, "部门成本");
		typeItem.setWidth("*");
		typeItem.setValueMap(typeMap);
		typeItem.setHidden(false);
		typeItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(ClientUtil.checkAndGetIntValue(event.getValue()) == ClientStaticUtils.DEPARTMENT_COST){
					projectItem.clearValue();
					projectItem.hide();
					departmentItem.show();
				}else{
					departmentItem.clearValue();
					departmentItem.hide();
					projectItem.show();
				}
			}
		});

		Criteria c = new Criteria();
		c.addCriteria("projectFlag", 1);
		
		projectItem = new ComboBoxItem("project", "项目");
		projectItem.setWidth("*");
		projectItem.setChangeOnKeypress(false);
		projectItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		//项目信息字段
		ListGridField projectIdField = new ListGridField("projectId");
		ListGridField contractCodeField = new ListGridField("contractCode");
		contractCodeField.setWidth(250);
		ListGridField projectNameField = new ListGridField("projectName");
		ListGridField projectManageIdField = new ListGridField("projectManageId");
		projectManageIdField.setWidth(80);
		projectItem.setOptionDataSource(DSGetProjects.getInstance());
		projectItem.setValueField(projectIdField.getName());
		projectItem.setDisplayField(projectNameField.getName());
		projectItem.setPickListFields(projectNameField, contractCodeField,projectManageIdField);
		projectItem.setPickListCriteria(c);
		projectItem.setPickListWidth(800);
		projectItem.hide();

		departmentItem = new PickTreeItem("department", "部门");
		departmentItem.setWidth("*");
		departmentItem.setCanSelectParentItems(true);
        departmentItem.setValueTree(KeyValueManager.getTree("departments"));
        departmentItem.setValueField("treeId");
        departmentItem.hide();

		leftCostItem = new FloatItem("leftCost", "可分摊成本");
		leftCostItem.setWidth("*");
		leftCostItem.setLength(15);
		leftCostItem.setDecimalPad(2);
		leftCostItem.setCanEdit(false);
		leftCostItem.setFormat("#,###,###,###,##0.00");
		leftCostItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if (null != event.getValue() && null != leftCost) {
					FormItem item = event.getItem();
					BigDecimal newValue = new BigDecimal(item.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
					item.setValue(newValue);
				}
			}
		});
		
		costItem = new FloatItem("cost", "分摊成本");
		costItem.setWidth("*");
		costItem.setLength(15);
		costItem.setDecimalPad(2);
		costItem.setFormat("#,###,###,###,##0.00");
		costItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if (null != event.getValue()) {
					FormItem item = event.getItem();
					BigDecimal newValue = new BigDecimal(item.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
					if (newValue.compareTo(leftCost) > 0) {
						item.setValue(leftCost);
					}else if(newValue.compareTo(BigDecimal.ZERO) < 0){
						item.setValue(0);
					}else {
						item.setValue(newValue);
					}
				}else{
					costItem.setValue(0);
				}
			}
		});

		form.setNumCols(2);
		form.setItems(typeItem, projectItem, departmentItem, leftCostItem, costItem);

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
		Record record = new Record();
		record.setAttribute("type", typeItem.getValue());
		if(record.getAttributeAsInt("type") == ClientStaticUtils.DEPARTMENT_COST){
			record.setAttribute("id", departmentItem.getValue());
			record.setAttribute("name", departmentItem.getDisplayValue());
		}else{
			record.setAttribute("id", projectItem.getValue());
			//修改下拉值的加载方式
//			if (!ClientUtil.isNullOrZero(record.getAttribute("id"))) {
//				HashMap<Object, Object> map = new HashMap<>();
//				map.put("projectId",record.getAttribute("id"));
//				DBDataSource.callOperation("ST_Project", "find", map, new DSCallback() {
//					@Override
//					public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
//						if(dsResponse.getStatus() >= 0){
//							Record[] records = dsResponse.getData();
//							if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
//								//获取项目编号
//								String projectCode = BaseHelpUtils.getString(records[0].getAttribute("projectCode"));
//								String projectName = BaseHelpUtils.getString(records[0].getAttribute("projectName"));
//								record.setAttribute("code",projectCode);
//								record.setAttribute("name",projectName);
//							}
//						}
//					}
//				});
//			}

			String projectName = SyncDataUtil.getProjectName(BaseHelpUtils.getIntValue(record.getAttribute("id")));
			String projectCode = SyncDataUtil.getContractCode(BaseHelpUtils.getIntValue(record.getAttribute("id")));
			record.setAttribute("code",projectCode);
			record.setAttribute("name",projectName);
			//原本的下拉值的加载方式
//			record.setAttribute("code", KeyValueManager.getValue("project_code", record.getAttribute("id")));
//			record.setAttribute("name", KeyValueManager.getValue("projects", record.getAttribute("id")));
		}
		record.setAttribute("cost", costItem.getValue());
		return record;
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

	/**
	 * 
	 * @param record
	 *            需要编辑的记录
	 */
	public void startEdit(Record record) {
		this.leftCost = new BigDecimal(record.getAttribute("leftCost"));
		form.editRecord(record);
		if(null != record.getAttribute("type")){
			if(ClientUtil.checkAndGetIntValue(record.getAttribute("type")) == ClientStaticUtils.DEPARTMENT_COST){
				departmentItem.show();
				departmentItem.setValue(ClientUtil.checkAndGetIntValue(record.getAttribute("id")));
				projectItem.hide();
			}else{
				departmentItem.hide();
				projectItem.show();
				projectItem.setValue(ClientUtil.checkAndGetIntValue(record.getAttribute("id")));
			}
		}
	}

	// 数据验证
	public boolean DataValidate() {
		if(null == typeItem.getValue()){
			SC.warn("提示", "请选择成本类型");
			return false;
		}
		if(ClientUtil.checkAndGetIntValue(typeItem.getValue()) == ClientStaticUtils.DEPARTMENT_COST){
			if(null == departmentItem.getValue()){
				SC.warn("提示", "请选择分摊成本的部门");
				return false;
			}
		}else{
			if(null == projectItem.getValue()){
				SC.warn("提示", "请选择分摊成本的项目");
			}
		}
		if(null == costItem.getValue()){
			SC.warn("提示", "请填写分摊成本");
			return false;
		}
		BigDecimal money = new BigDecimal(costItem.getValueAsString());
		if(money.compareTo(BigDecimal.ZERO) <= 0){
			SC.warn("提示", "分摊成本必须大于0");
			return false;
		}
		if(money.compareTo(leftCost) > 0){
			SC.warn("提示", "分摊成本不能大于目前的可分摊成本："+leftCost);
			return false;
		}
		return true;
	}

	public BigDecimal getLeftCost() {
		return leftCost;
	}

	public void setLeftCost(BigDecimal value) {
		this.leftCost = value;
	}
	
}
