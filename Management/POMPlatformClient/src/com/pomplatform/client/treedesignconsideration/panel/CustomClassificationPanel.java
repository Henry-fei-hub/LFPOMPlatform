package com.pomplatform.client.treedesignconsideration.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.ValidateUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.pomplatform.client.treedesignconsideration.datasource.DSContactSplitConfig;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.BooleanItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class CustomClassificationPanel extends AbstractWizadPage {

	private static Logger __LOGGER = Logger.getLogger("");
	public DelicacyListGrid SourceGrid;
	private DynamicForm __infoForm;
	private final ComboBoxItem contractClassiftyItem;
	private BooleanItem isProgrammeItem;
	private BooleanItem isDeepenItem;
	private ComboBoxItem jdDgItem;
	private TextItem splitPriceItem;
	private IButton customSaveBtn;

	public static PopupWindow popupWindow;

	public CustomClassificationPanel(String infoCode, String projectCode, int outQuotationId,
			int outDesignConsiderationId, double selfPrice) {
		CustomClassificationPanel.infoCode = infoCode;
		CustomClassificationPanel.projectCode = projectCode;
		CustomClassificationPanel.outQuotationId = outQuotationId;
		CustomClassificationPanel.outDesignConsiderationId = outDesignConsiderationId;
		CustomClassificationPanel.selfPrice = selfPrice;
		SourceGrid = new DelicacyListGrid();
		SourceGrid.setCanEdit(false);

		HLayout bigLayout = new HLayout();
		bigLayout.setWidth100();
		VLayout SearchSourceLayout = new VLayout();
		SearchSourceLayout.setWidth("93%");
		ListGridField[] fields = new ListGridField[8];
		int idx = 0;
		fields[idx] = new ListGridField("name");
		idx++;
		fields[idx] = new ListGridField("programme");
		idx++;
		fields[idx] = new ListGridField("deepen");
		idx++;
		fields[idx] = new ListGridField("electromechanical");
		idx++;
		fields[idx] = new ListGridField("lighting");
		idx++;
		fields[idx] = new ListGridField("service");
		idx++;
		fields[idx] = new ListGridField("remark");
		SourceGrid.setFields(fields);
		SourceGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		SourceGrid.setDataSource(DSContactSplitConfig.getInstance());
		SourceGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				// 验证数据是否合法
				if (checkData()) {
					final Map params = SourceGrid.getRecord(event.getRowNum()).toMap();
					params.put("opt_type", "updateContractClassifty");
					final int rowNumModified = event.getRowNum();
					DBDataSource.callOperation("EP_CustomContractClassifty", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() < 0) {
								ClientUtil.displayErrorMessage(dsResponse);
							} else {
								int contactSplitConfigId=BaseHelpUtils.getIntValue(__infoForm.getItem("contactSplitConfigId").getValue());
								startEdit(contactSplitConfigId);
							}
						}
					});
				}
			}
		});
		__infoForm = new DynamicForm();
		__infoForm.setWidth("60%");
		__infoForm.setHeight(140);
		__infoForm.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__infoForm);

		contractClassiftyItem = new ComboBoxItem("contactSplitConfigId", "合同分类情况");
		contractClassiftyItem.setWidth("*");
		contractClassiftyItem.setDefaultValue(1);// 默认选中1
		contractClassiftyItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_58"));
		contractClassiftyItem.addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				int contactSplitConfigId = BaseHelpUtils.getIntValue(event.getValue());
				startEdit(contactSplitConfigId);
				//当中了自定义
				if(contactSplitConfigId==7){
					SourceGrid.setCanEdit(true);
					__infoForm.getItem("jdDg").hide();
					__infoForm.getItem("deepen").hide();
					__infoForm.getItem("programme").hide();
				}else{
					__infoForm.getItem("deepen").show();
					__infoForm.getItem("programme").show();
					SourceGrid.setCanEdit(false);
				}
				// 是否显示“机电/灯光” 的下拉选项
				if (contactSplitConfigId == 2 || contactSplitConfigId == 5) {
					__infoForm.getItem("jdDg").show();
				} else {
					__infoForm.getItem("jdDg").hide();
				}
			}
		});
		isProgrammeItem = new BooleanItem("programme", "无方案");
		isProgrammeItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				isDeepenItem.setValue(false);
			}
		});
		isProgrammeItem.setWidth("*");
		isDeepenItem = new BooleanItem("deepen", "无深化");
		isDeepenItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				isProgrammeItem.setValue(false);
			}
		});
		isDeepenItem.setWidth("*");

		jdDgItem = new ComboBoxItem("jdDg", "机电/灯光");
		jdDgItem.setHidden(true);
		jdDgItem.setWidth("*");
		jdDgItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_59"));

		splitPriceItem = new TextItem("splitPrice", "拆分价");
		splitPriceItem.setDisabled(true);
		splitPriceItem.setDefaultValue(selfPrice);
		splitPriceItem.setWidth("*");
		splitPriceItem.setValidators(ValidateUtils.isFloatValidator());

		__infoForm.setFields(contractClassiftyItem, splitPriceItem, isProgrammeItem,isDeepenItem, jdDgItem);

		VLayout btnVLayout = new VLayout(10);
		btnVLayout.setLayoutTopMargin(100);

		// 底部工具栏添加
		ToolStrip btnLayout = new ToolStrip();
		btnLayout.setVPolicy(LayoutPolicy.FILL);
		btnLayout.setPadding(5);
		btnLayout.setHeight(40);
		btnLayout.setWidth100();
		btnLayout.addFill();
		
		customSaveBtn = new IButton("添加自定义拆分比");
		customSaveBtn.hide();
		btnLayout.addMember(customSaveBtn);
		btnLayout.addSpacer(10);
		customSaveBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				SourceGrid.startEditingNew();
				
			}
		});
		
		
		
		IButton saveBtn = new IButton("确认拆分");
		btnLayout.addMember(saveBtn);
		btnLayout.addSpacer(10);
		saveBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (!SourceGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				int contactSplitConfigId = BaseHelpUtils
						.getIntValue(__infoForm.getItem("contactSplitConfigId").getValue());
				boolean programme = BaseHelpUtils.getBoolean(__infoForm.getItem("programme").getValue());
				boolean deepen = BaseHelpUtils.getBoolean(__infoForm.getItem("deepen").getValue());
				int jdDgId = BaseHelpUtils.getIntValue(__infoForm.getItem("jdDg").getValue());
				double splitPrice = BaseHelpUtils.getDoubleValue(__infoForm.getItem("splitPrice").getValue());
				if (contactSplitConfigId == 2 || contactSplitConfigId == 5) {
					if (jdDgId <= 0) {
						SC.say("机电/灯光项必选一项");
						return;
					}
				}
//				if (splitPrice <= 0) {
//					SC.say("拆分价总金额不能小于0");
//					return;
//				}
				final Map checkMap = new HashMap<>();
				checkMap.put("opt_type", "setSplitPrice");
				checkMap.put("infoCode", CustomClassificationPanel.infoCode);
				checkMap.put("projectCode", CustomClassificationPanel.projectCode);
				checkMap.put("employeeId", ClientUtil.getEmployeeId());// 操作人id
				checkMap.put("outDesignConsiderationId", CustomClassificationPanel.outDesignConsiderationId);// 报价单项的id
				checkMap.put("contractSplitConfigId", contactSplitConfigId);// 合同分类情况id
				checkMap.put("electromechanicalAndLighting", jdDgId);// 选择了机电
																		// 还是灯光
																		// id
				checkMap.put("splitPrice", splitPrice);// 拆分价
				checkMap.put("programme", programme);
				checkMap.put("deepen", deepen);
				DBDataSource.callOperation("EP_CustomContractClassifty", checkMap, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {

						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
							return;
						} else {
							popupWindow.destroy();// 销毁父弹出框
							DataEditEvent dee = new DataEditEvent();
							fireEvent(dee);
						}
					}
				});
			}
		});

		IButton cancelBtn = new IButton("取消");
		btnLayout.addMember(cancelBtn);
		btnLayout.addSpacer(10);
		cancelBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				SC.ask("提示", "确认取消?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if (value) {
							popupWindow.destroy();
						}
					}
				});
			}
		});

		SearchSourceLayout.setHeight100();
		SearchSourceLayout.setLayoutTopMargin(10);
		SearchSourceLayout.setLayoutRightMargin(5);
		SearchSourceLayout.setMembersMargin(10);
		SearchSourceLayout.addMember(__infoForm);
		SearchSourceLayout.addMember(SourceGrid);
		SearchSourceLayout.addMember(btnLayout);
		bigLayout.addMember(SearchSourceLayout);
		addMember(bigLayout);
	}

	@Override
	public void startEdit() {
		__LOGGER.info("CustomContractClassifty start load");

		Map<String, Object> condition = new HashMap<>();
		condition.put("opt_type", "getContractClassiftyList");
		condition.put("contractSplitConfigId", 1);// 合同分类情况id
		condition.put("electromechanicalAndLighting", 0);// 选择了机电 还是灯光 id
		DBDataSource.callOperation("EP_CustomContractClassifty", "", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				SourceGrid.setData(dsResponse.getData());
				// 设置默认选中的
				ListGridRecord[] recordList = SourceGrid.getRecords();
				if (recordList != null) {
					int len = recordList.length;
					for (int i = 0; i < len; i++) {
						if (len == 1) {
							SourceGrid.selectRecord(i);
						}
					}
				} else {
					SourceGrid.selectRecord(0);
				}
			}
		});
	}

	public void startEdit(int contractSplitConfigId) {
		__LOGGER.info("CustomContractClassifty start load contractSplitConfigId=" + contractSplitConfigId);

		Map<String, Object> condition = new HashMap<>();
		condition.put("opt_type", "getContractClassiftyList");
		condition.put("contractSplitConfigId", contractSplitConfigId);
		DBDataSource.callOperation("EP_CustomContractClassifty", "", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				SourceGrid.setData(dsResponse.getData());

				// 设置默认选中的
				ListGridRecord[] recordList = SourceGrid.getRecords();
				if (recordList != null) {
					int len = recordList.length;
					for (int i = 0; i < len; i++) {
						if (len == 1) {
							SourceGrid.selectRecord(i);
						}
					}
				} else {
					SourceGrid.selectRecord(0);
				}
			}
		});
	}

	// 效验数据
	@Override
	public boolean checkData() {
		boolean isFlag = true;
		return isFlag;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("customOutTemplate");
		return res;
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	public Map getValuesAsMap() {
		return null;
	}

	public static String infoCode;
	public static String projectCode;
	public static int outQuotationId;
	public static int outDesignConsiderationId;
	public static CustomDesignConsiderationPanel parentPanel;
	private static double selfPrice;
	private ListGrid refreshGrid;
	private ListGrid refreshParentGrid;

	public ListGrid getRefreshGrid() {
		return refreshGrid;
	}

	public void setRefreshGrid(ListGrid refreshGrid) {
		this.refreshGrid = refreshGrid;
	}

	public ListGrid getRefreshParentGrid() {
		return refreshParentGrid;
	}

	public void setRefreshParentGrid(ListGrid refreshParentGrid) {
		this.refreshParentGrid = refreshParentGrid;
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
}
