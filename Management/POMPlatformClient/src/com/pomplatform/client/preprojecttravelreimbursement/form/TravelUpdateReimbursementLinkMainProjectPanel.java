package com.pomplatform.client.preprojecttravelreimbursement.form;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
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
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.fields.events.KeyPressEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyPressHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class TravelUpdateReimbursementLinkMainProjectPanel extends VLayout implements HasHandlers {

	private static final Logger logger = Logger.getLogger("");
	private final IntegerItem travelReimbursementLinkMainProjectIdItem;
	private final IntegerItem travelReimbursementIdItem;
	private final ComboBoxItem projectItem;
	private final FloatItem amountItem;
	private final FloatItem leftAmountItem;
	private final DynamicForm form = new DynamicForm();
	private final VLayout vLayout;
	private final IButton saveButton;
	private final IButton cancelButton;
	private final HLayout buttonLayout;
	private Window parentWindow;
	protected final HandlerManager handlerManager = new HandlerManager(this);
	private final LinkedHashMap<Integer, String> projectMap = new LinkedHashMap<>();
	private final Map selectedProject = new HashMap();
	private BigDecimal amount;

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	public TravelUpdateReimbursementLinkMainProjectPanel(boolean update, LinkedHashMap<Integer, String> allProjectMap) {
		
		vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		vLayout.setMargin(10);
		vLayout.setMembersMargin(12);

		travelReimbursementLinkMainProjectIdItem = new IntegerItem("travelReimbursementLinkMainProjectId", "差旅报销关联项目ID");
		travelReimbursementLinkMainProjectIdItem.setHidden(true);

		travelReimbursementIdItem = new IntegerItem("travelReimbursementId", "差旅主表ID");
		travelReimbursementIdItem.setHidden(true);

		projectItem = new ComboBoxItem("mainProjectId", "项目");
		projectItem.setChangeOnKeypress(false);
		projectItem.setWidth("*");
		projectItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		
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
					leftAmountItem.setValue(amount.subtract(newValue));
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
		form.setItems(travelReimbursementLinkMainProjectIdItem, travelReimbursementIdItem, projectItem,
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
				if (key.toString().equals("project")) {
					record.setAttribute("projectId", map.get(key));
				} else {
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
	 * @param editRecord
	 *            需要编辑的记录
	 * @param employeeId
	 *            报销人ID
	 * @param amount
	 *            剩余的可供报销分拆的总额
	 * @param update
	 *            本次操作是否是修改操作
	 */
	public void startEdit(final Record editRecord, int employeeId, BigDecimal amount, final Map selectedProject, boolean update) {
		this.selectedProject.putAll(selectedProject);
		// 新建则加载与用户相关联的项目信息，如果是修改，则将选中的项目信息加载到页面
		if (update) {
			if (null != editRecord.getAttribute("mainProjectId")) {
				projectItem.setDefaultValue(ClientUtil.checkAndGetIntValue(editRecord.getAttribute("mainProjectId")));
			}
			if(null != editRecord.getAttribute("amount")){
				this.amount = amount.add(new BigDecimal(editRecord.getAttribute("amount")));
			}
			form.editRecord(editRecord);
			projectItem.addKeyPressHandler(new KeyPressHandler() {
				@Override
				public void onKeyPress(final KeyPressEvent event) {
					if (event.getKeyName().equals("Enter")) {
						final String value = projectItem.getValueAsString();
						Map<String, Object> map = new HashMap<>();
						map.put("projectName", value);
						DBDataSource.callOperation("EP_GetProjectByProjectName", map, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if (dsResponse.getStatus() >= 0) {
									Record[] record = dsResponse.getData();
									projectMap.clear();
									//假如已分摊费用的项目不为空，则在搜索结果中剔除这些已分摊费用的项目(当前处于编辑状态的项目不剔除)
									if(null != selectedProject && !selectedProject.isEmpty()){
										for (Record obj : record) {
											if(!selectedProject.containsKey(obj.getAttribute("mainProjectId"))||(selectedProject.containsKey(obj.getAttribute("mainProjectId"))&&null!=selectedProject.get(obj.getAttribute("mainProjectId")))){
												projectMap.put(obj.getAttributeAsInt("mainProjectId"), obj.getAttribute("projectName"));
											}
										}
									}else{
										for (Record obj : record) {
											projectMap.put(obj.getAttributeAsInt("mainProjectId"), obj.getAttribute("projectName"));
										}
									}
									projectItem.setValueMap(projectMap);
								} else {
									SC.say("没有找到与关键字：【" + value + "】相匹配的项目");
								}
								event.cancel();
							}
						});
					}

				}
			});
		} else {
			this.amount = amount;
			Map<String, Object> map = new HashMap<>();
			map.put("employeeId", employeeId);
			map.put("optType", "getProjectName");
			DBDataSource.callOperation("EP_GetUserInfoById", map, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if (dsResponse.getStatus() >= 0) {
						Record[] record = dsResponse.getData();
						//假如已分摊费用的项目不为空，则在搜索结果中剔除这些已分摊费用的项目
						if(null != selectedProject && !selectedProject.isEmpty()){
							for (Record obj : record) {
								if(!selectedProject.containsKey(obj.getAttribute("mainProjectId"))){
									projectMap.put(obj.getAttributeAsInt("mainProjectId"), obj.getAttribute("projectName"));
								}
							}
						}else{
							for (Record obj : record) {
								projectMap.put(obj.getAttributeAsInt("mainProjectId"), obj.getAttribute("projectName"));
							}
						}
						projectItem.setValueMap(projectMap);
					}
				}
			});
			if (null != amount) {
				amountItem.setDefaultValue(amount);
				leftAmountItem.setDefaultValue(BigDecimal.ZERO);
			}
		}
	}

	// 数据验证
	public boolean DataValidate() {
		if(null == projectItem.getValue()){
			SC.warn("提示", "请选择一个项目");
			return false;
		}
		if(null != selectedProject && !selectedProject.isEmpty() && selectedProject.containsKey(projectItem.getValue())){
			SC.warn("提示", "请不要重复选择同一个项目");
			return false;
		}
		if(null == amountItem.getValue()){
			SC.warn("提示", "请填写该项目需要承担的费用");
			return false;
		}
		if(null == amount){
			return false;
		}
		BigDecimal money = new BigDecimal(amountItem.getValueAsString());
		if(money.compareTo(BigDecimal.ZERO) == 0){
			SC.warn("提示", "项目需要承担的费用不能为0");
			return false;
		}
		if(money.compareTo(amount) > 0){
			SC.warn("提示", "项目需要承担的费用不能大于目前的可分拆报销总额："+amount);
			return false;
		}
		return true;
	}
	
}
