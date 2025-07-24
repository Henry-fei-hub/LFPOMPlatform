package com.pomplatform.client.workflow.commonNormalReimbursement.form;

import java.math.BigDecimal;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridInvoiceTypeValue;
import com.pomplatform.client.workflow.datasource.DSReimbursementInvoiceInformation;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.FloatItem;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class AddReimbursementInvoicePanel extends VLayout implements HasHandlers {

	private static final Logger LOGGER = Logger.getLogger("");
	private final DynamicForm form = new DynamicForm();
	private final VLayout vLayout;
	private final IButton saveButton;
	private final IButton cancelButton;
	private final HLayout buttonLayout;
	private Window parentWindow;
	protected final HandlerManager handlerManager = new HandlerManager(this);

	private final IntegerItem invoiceTypeItem;
	private final TextItem invoiceNumberItem;
	private final FloatItem totalAmountItem;
	private final FloatItem subtractAmountItem;
	private final FloatItem taxAmountItem;
	private final TextItem subtractRemarkItem;
	private final IntegerItem taxRateItem;
	private final IntegerItem invoiceQuantityItem;

	private final ComboBoxItem invoiceTypeSelectItem;

	private Integer processType;

	public Integer getProcessType() {
		return processType;
	}

	public void setProcessType(Integer processType) {
		this.processType = processType;
	}

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	public AddReimbursementInvoicePanel() {
		ListGridField typeNameField = new ListGridField("typeName");
		ListGridField subtractRemarkField = new ListGridField("subtractRemark");
		ListGridField taxRateField = new ListGridField("taxRate");

		vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		vLayout.setMargin(10);
		vLayout.setPadding(10);
		vLayout.setMembersMargin(12);

		invoiceTypeItem = new IntegerItem("invoiceType", "票类");
		invoiceTypeItem.hide();
		
		IsIntegerValidator intValidator = new IsIntegerValidator();
		intValidator.setErrorMessage("请选择票类");

		invoiceTypeSelectItem = new ComboBoxItem("invoiceTypeSelect", "票类");
		invoiceTypeSelectItem.setChangeOnKeypress(false);
		invoiceTypeSelectItem.setRequired(true);
		invoiceTypeSelectItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		invoiceTypeSelectItem.setWidth("*");
		invoiceTypeSelectItem.setOptionDataSource(DSSelectGridInvoiceTypeValue.getInstance());
		invoiceTypeSelectItem.setValueField("invoiceTypeId");
		invoiceTypeSelectItem.setDisplayField("typeName");
		invoiceTypeSelectItem.setPickListFields(typeNameField, subtractRemarkField, taxRateField);
		invoiceTypeSelectItem.setValidators(intValidator);
		invoiceTypeSelectItem.addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				Record selectRecord = invoiceTypeSelectItem.getSelectedRecord();
				if (null != selectRecord) {
					invoiceTypeItem.setValue(selectRecord.getAttributeAsObject("invoiceTypeId"));
					subtractRemarkItem.setValue(selectRecord.getAttributeAsObject("subtractRemark"));
					taxRateItem.setValue(selectRecord.getAttributeAsObject("taxRate"));
					setTaxAmount();
				}
			}
		});

		subtractRemarkItem = new TextItem("subtractRemark", "扣除");
		subtractRemarkItem.setWidth("*");
		subtractRemarkItem.setRequired(false);
		subtractRemarkItem.setDisabled(true);

		totalAmountItem = new FloatItem("totalAmount", "票面金额(价税合计)");
		totalAmountItem.setWidth("*");
		totalAmountItem.setLength(18);
		totalAmountItem.setDecimalPad(5);
		totalAmountItem.setRequired(true);
		totalAmountItem.setFormat("#,###,###,###,##0.00");
		totalAmountItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				setTaxAmount(event.getValue(), subtractAmountItem.getValue(), taxRateItem.getValue());
			}
		});

		subtractAmountItem = new FloatItem("subtractAmount", "扣除金额");
		subtractAmountItem.setWidth("*");
		subtractAmountItem.setLength(18);
		subtractAmountItem.setDecimalPad(5);
		subtractAmountItem.setFormat("#,###,###,###,##0.00");
		subtractAmountItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				setTaxAmount(totalAmountItem.getValue(), event.getValue(), taxRateItem.getValue());
				
			}
		});

		taxRateItem = new IntegerItem("taxRate", "税率");
		taxRateItem.setWidth("*");
		taxRateItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				setTaxAmount(totalAmountItem.getValue(), subtractAmountItem.getValue(), event.getValue());
			}
		});

		taxAmountItem = new FloatItem("taxAmount", "进项税额&nbsp;<font color='red' style='font-weight: bold;'>请复印有进项税的票据（绿联除外）</font>");
		taxAmountItem.setWidth("*");
		taxAmountItem.setLength(18);
		taxAmountItem.setDecimalPad(5);
		taxAmountItem.setFormat("#,###,###,###,##0.00");

		invoiceNumberItem = new TextItem("invoiceNumber", "发票号码");
		invoiceNumberItem.setWidth("*");
		invoiceNumberItem.setRequired(true);
		
		invoiceQuantityItem = new IntegerItem("invoiceQuantity", "发票数量");
		invoiceQuantityItem.setWidth("*");
		invoiceQuantityItem.setRequired(true);
		invoiceQuantityItem.setDefaultValue(1);

		form.setNumCols(2);
		form.setDataSource(DSReimbursementInvoiceInformation.getInstance());
		form.setItems(invoiceTypeItem, invoiceTypeSelectItem, subtractRemarkItem, totalAmountItem, subtractAmountItem,
				taxRateItem, taxAmountItem, invoiceNumberItem, invoiceQuantityItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		vLayout.addMember(form);
		form.setWidth100();
		form.setHeight100();

		saveButton = new IButton("确定", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (DataValidate()) {
					Record record = getValueAsRecord();
					Map params = record.toMap();
					params.put("optType", "checkInvoiceInformation");
					params.put("type", 1);
					DBDataSource.callOperation("EP_CustomWorkflowBusinessProcessor", params, new DSCallback() {

						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() > 0) {
								if (dsResponse.getStatus() == 1) {
									DataEditEvent dee = new DataEditEvent();
									dee.setData(record);
									fireEvent(dee);
									if (null == getParentWindow()) {
										return;
									}
									getParentWindow().destroy();
								} else if (dsResponse.getStatus() == 2) {
									SC.ask("该发票号已经有录入到系统，是否添加该发票?", new BooleanCallback() {

										@Override
										public void execute(Boolean value) {
											if (null != value && value) {
												DataEditEvent dee = new DataEditEvent();
												dee.setData(record);
												fireEvent(dee);
												if (null == getParentWindow()) {
													return;
												}
												getParentWindow().destroy();
											}

										}
									});
								}
							} else {
								ClientUtil.displayErrorMessage(dsResponse);
							}

						}
					});

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
		buttonLayout.setHeight(20);
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
				record.setAttribute(key.toString(), map.get(key));
			}
		}
		return record;
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

	public void setTaxAmount() {
		setTaxAmount(totalAmountItem.getValue(), subtractAmountItem.getValue(), taxRateItem.getValue());
	}
	
	public void setTaxAmount(Object totalAmount, Object subtractAmount, Object taxRate) {
		if(null == subtractAmount) {
			subtractAmount = BigDecimal.ZERO;
		}
		if (null != totalAmount && null != subtractAmount && null != taxRate) {
			BigDecimal totalAmountDe = new BigDecimal(totalAmount.toString());
			BigDecimal subtractAmountDe = new BigDecimal(subtractAmount.toString());
			BigDecimal de100 = new BigDecimal("100");
			BigDecimal taxRateDe = new BigDecimal(taxRate.toString()).divide(de100);
			BigDecimal finalDe = (((totalAmountDe.subtract(subtractAmountDe))
					.divide(BigDecimal.ONE.add(taxRateDe), 2, BigDecimal.ROUND_HALF_UP))
							.multiply(taxRateDe)).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
			taxAmountItem.setValue(finalDe.toEngineeringString());
		}

	}

	/**
	 * 
	 * @param record
	 *            需要编辑的记录
	 * @param departmentId
	 *            报销部门ID
	 * @param amount
	 * 
	 * @param update
	 *            本次操作是否是修改操作
	 */
	public void startEdit(Record record) {

		form.editRecord(record);
		invoiceTypeSelectItem.setValue(record.getAttributeAsObject("invoiceType"));
	}

	// 数据验证
	public boolean DataValidate() {
		int  invoiceTypeSelect = BaseHelpUtils.getIntValue(invoiceTypeSelectItem.getValue());
		String subtractAmount =BaseHelpUtils.getString(subtractAmountItem.getValue());
		SC.debugger();
		if(invoiceTypeSelect==1){
			if(subtractAmount.equals("0") || BaseHelpUtils.isNullOrEmpty(subtractAmount)){
				SC.say("票类为机票时,扣除金额必填!");
				return false;
			}
		}
		if (form.validate()) {
			return true;
		}
		return false;
	}

}
