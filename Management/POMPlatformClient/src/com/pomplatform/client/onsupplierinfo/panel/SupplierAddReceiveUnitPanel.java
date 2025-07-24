package com.pomplatform.client.onsupplierinfo.panel;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.ValidateUtils;
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
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.BlurEvent;
import com.smartgwt.client.widgets.form.fields.events.BlurHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.fields.events.FocusEvent;
import com.smartgwt.client.widgets.form.fields.events.FocusHandler;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class SupplierAddReceiveUnitPanel extends VLayout implements HasHandlers {

	private static final Logger _logger = Logger.getLogger("");
	private final DynamicForm form = new DynamicForm();
	private final VLayout vLayout;
	private final IButton saveButton;
	private final IButton cancelButton;
	private final HLayout buttonLayout;
	private Window parentWindow;
	protected final HandlerManager handlerManager = new HandlerManager(this);

	private final TextItem receiveUnitItem;
	private final TextItem bankAccountItem;
	private final TextItem bankNameItem;
	private final TextItem receiveUnitAddressItem;
	private final SelectItem provinceItem;// 省
	private final SelectItem cityItem;// 市
	private final TextItem bankAddressItem;
	private final TextItem receiveUnitPhoneItem;
	private final TextItem swiftCodeItem;
	private final ComboBoxItem countryIdItem;
	private final TextItem countryCodeItem;
	private final TextItem passportItem;
	private final ComboBoxItem bankIdItem;
	private final SelectItem accountTypeItem;
	private final Label enlargeAccountLabel;

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	public String enLargeAccount(String value){
		if(!BaseHelpUtils.isNullOrEmpty(value)){
			String prefixhtml = "<font style='font-size: 28;color:blue;'>";
			
			StringBuilder sbContent = new StringBuilder();
			
			int length = value.length();
			for (int i = 0; i < length; i = i + 4) {
				sbContent.append(value.substring(i, i + 4));
				if((i + 4) < length){
					sbContent.append("<font color='gray'>-</font>");
				}
			}
			
			String content = sbContent.toString();
			
			String suffixHtml = "</font>";
			return prefixhtml + content + suffixHtml;
		}
		return "";
	}
	
	public SupplierAddReceiveUnitPanel() {

		vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		vLayout.setMargin(10);
		vLayout.setMembersMargin(12);
		
		enlargeAccountLabel = new Label();
		enlargeAccountLabel.hide();
		enlargeAccountLabel.setHeight(50);
		vLayout.addMember(enlargeAccountLabel);
		

		bankAccountItem = new TextItem("bankAccount", "银行账号(<font color='red'>银行账号只能为输入数字与字母,不能输入空格与特殊字符.</font>)");
		bankAccountItem.setLength(30);
		bankAccountItem.setValidators(ValidateUtils.bankAccountValidator());
		bankAccountItem.setWidth("*");
		bankAccountItem.addFocusHandler(new FocusHandler() {
			
			@Override
			public void onFocus(FocusEvent event) {
				String value = BaseHelpUtils.getString(event.getItem().getValue());
				enlargeAccountLabel.setContents(enLargeAccount(value));
				enlargeAccountLabel.show();
				
			}
		});
		bankAccountItem.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				String value = BaseHelpUtils.getString(event.getValue());
				enlargeAccountLabel.setContents(enLargeAccount(value));
				enlargeAccountLabel.show();
				
			}
		});
		bankAccountItem.addBlurHandler(new BlurHandler() {
			
			@Override
			public void onBlur(BlurEvent event) {
				enlargeAccountLabel.hide();
				
			}
		});
		bankAccountItem.setRequired(true);

		receiveUnitItem = new TextItem("receiveUnit", "供应商收款方名称");
		receiveUnitItem.setWidth("*");
		receiveUnitItem.setRequired(true);

		receiveUnitAddressItem = new TextItem("receiveUnitAddress", "供应商收款单位地址");
		receiveUnitAddressItem.setWidth("*");
		receiveUnitAddressItem.setRequired(true);

		
		IsIntegerValidator intValidator = new IsIntegerValidator();
		intValidator.setErrorMessage("请选择下拉数据, 数据可填写只是方便搜索下拉数据");
		bankIdItem = new ComboBoxItem("bankId", "开户行");
		bankIdItem.setChangeOnKeypress(false);
		bankIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		bankIdItem.setValidators(intValidator);
//		bankIdItem.setValueMap(KeyValueManager.getValueMap("banks"));
		KeyValueManager.loadValueMap("banks",bankIdItem);
		bankIdItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				bankNameItem.setValue(event.getItem().getDisplayValue());
				
			}
		});
		bankIdItem.setRequired(true);
		bankIdItem.setWidth("*");

		bankNameItem = new TextItem("bankName", "开户行(支行)<font color='red'>填写内容例子:XX银行XX支行</font>");
		bankNameItem.setWidth("*");
		bankNameItem.setRequired(true);
		
		bankAddressItem = new TextItem("bankAddress", "开户行所在详细地址");
		bankAddressItem.setRequired(true);
		bankAddressItem.hide();
		bankAddressItem.setWidth("*");

		provinceItem = new SelectItem("province", "开户行所在省");
		provinceItem.setRequired(true);
		provinceItem.setValueMap(KeyValueManager.getValueMap("provinces"));
//		provinceItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
//		provinceItem.setChangeOnKeypress(false);
		provinceItem.setWidth("*");
		provinceItem.addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				cityItem.clearValue();
				if (null != event.getValue()) {
					Object value = event.getValue();
					Map<String, Object> condition = new HashMap<>();
					condition.put("parentId", value);
					DBDataSource.callOperation("ST_Area", "find", condition, new DSCallback() {

						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
								LinkedHashMap<String, Object> params = new LinkedHashMap<>();
								Record[] records = dsResponse.getData();
								for (int i = 0; i < records.length; i++) {
									params.put(records[i].getAttribute("areaId"), records[i].getAttribute("areaName"));
								}
								cityItem.setValueMap(params);
							}

						}
					});
				} else {
					cityItem.setValueMap(new LinkedHashMap<>());
				}

			}
		});

		cityItem = new SelectItem("city", "开户行所在市");
		cityItem.setRequired(true);
//		cityItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
//		cityItem.setChangeOnKeypress(false);
		cityItem.setWidth("*");

		accountTypeItem = new SelectItem("accountType", "收款方银行类型");
		accountTypeItem.setRequired(true);
		accountTypeItem.setDefaultValue(1);
		accountTypeItem.setWidth("*");
		accountTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_171"));
		accountTypeItem.addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				int accountType = BaseHelpUtils.getIntValue(event.getValue());
				if (accountType == 1) {
					receiveUnitPhoneItem.hide();
					swiftCodeItem.hide();
					countryIdItem.hide();
					countryCodeItem.hide();
					passportItem.hide();
				} else if (accountType == 2) {
					receiveUnitPhoneItem.show();
					swiftCodeItem.show();
					countryIdItem.show();
					countryCodeItem.show();
					passportItem.show();
				}

			}
		});

		receiveUnitPhoneItem = new TextItem("receiveUnitPhone", "收款方电话");
		receiveUnitPhoneItem.hide();
		receiveUnitPhoneItem.setWidth("*");
		receiveUnitPhoneItem.setRequired(true);

		swiftCodeItem = new TextItem("swiftCode", "SWIFT CODE");
		swiftCodeItem.hide();
		swiftCodeItem.setWidth("*");
		swiftCodeItem.setRequired(true);

		countryIdItem = new ComboBoxItem("countryId", "收款人常驻国家（地区）");
		countryIdItem.hide();
		countryIdItem.setRequired(true);
		countryIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		countryIdItem.setChangeOnKeypress(false);
		countryIdItem.setWidth("*");
		countryIdItem.setValueMap(KeyValueManager.getValueMap("countries"));
		countryIdItem.addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				int countryId = BaseHelpUtils.getIntValue(event.getValue());
				Map<String, Object> params = new HashMap<>();
				params.put("countryId", countryId);
				DBDataSource.callOperation("ST_Country", "findUsingKey", params, new DSCallback() {

					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							Record[] records = dsResponse.getData();
							if (records.length > 0) {
								countryCodeItem.setValue(records[0].getAttribute("code"));
							}
						}

					}
				});

			}
		});

		countryCodeItem = new TextItem("countryCode", "收款人常驻国家（地区）代码");
		countryCodeItem.hide();
		countryCodeItem.setRequired(true);
		countryCodeItem.setWidth("*");
		countryCodeItem.disable();

		passportItem = new TextItem("passport", "护照");
		passportItem.hide();
		passportItem.setRequired(true);
		passportItem.setWidth("*");

		form.setNumCols(2);
		form.setItems(receiveUnitItem, receiveUnitAddressItem, bankIdItem, bankNameItem, bankAccountItem, bankAddressItem, provinceItem,
				cityItem, accountTypeItem, receiveUnitPhoneItem, swiftCodeItem, countryIdItem, countryCodeItem,
				passportItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		vLayout.addMember(form);
		form.setWidth100();
		form.setHeight100();

		saveButton = new IButton("确定", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (DataValidate()) {
					Map params = getValueAsRecord().toMap();
					params.put("operateEmployeeId", ClientUtil.getEmployeeId());
					params.put("opt_type", "checkReceiveUnitInfo");
					DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", params, new DSCallback() {

						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() > 0) {
								DataEditEvent dee = new DataEditEvent();
								dee.setData(getValueAsRecord());
								fireEvent(dee);
								if (null == getParentWindow()) {
									return;
								}
								getParentWindow().destroy();
							} else {
								if (dsResponse.getStatus() == -2) {
									SC.ask(dsResponse.getErrors().get("errorMsg").toString(), new BooleanCallback() {

										@Override
										public void execute(Boolean value) {
											if (value) {
												DataEditEvent dee = new DataEditEvent();
												dee.setData(getValueAsRecord());
												fireEvent(dee);
												if (null == getParentWindow()) {
													return;
												}
												getParentWindow().destroy();
											}
										}
									});
								} else {
									ClientUtil.displayErrorMessage(dsResponse);
								}
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
		record.setAttribute("supplierId", BaseHelpUtils.getIntValue(getRecord().getAttribute("supplierId")));
		return record;
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

	// 数据验证
	public boolean DataValidate() {
		if(!form.validate()){
			SC.say("数据有误");
			return false;
		}
		int departmentId = ClientUtil.getDepartmentId();
		if (departmentId == 10){//财务部添加不进行检测
			return true;
		}
		//非财务部检测
		String bankId = BaseHelpUtils.getString(bankIdItem.getDisplayValue());
		String bankName = BaseHelpUtils.getString(bankNameItem.getValue());
		boolean b = bankName.startsWith(bankId);//判断输入的收款单位是否已选择银行开头
		if (bankId != "招商银行"){
			if (b){
				boolean f1 = bankName.endsWith("分行");
				boolean f2 = bankName.endsWith("支行");
				boolean f3 = bankName.endsWith("营业部");
				boolean f4 = bankName.endsWith("分理处");
				if (f1 || f2 || f3 || f4){
					return true;
				}else {
					SC.say("请填写正确的开户支行名称");
					return  false;
				}
			}else{
				SC.say("请填写正确的开户行名称");
				return  false;
			}
		}else{
			return true;
		}
	}

	public void loadData() {
		int supplierId=BaseHelpUtils.getIntValue(getRecord().getAttribute("supplierId"));
		if(supplierId>0) {
			Map<String,Object> condition = new HashMap<>();
			condition.put("supplierId", BaseHelpUtils.getIntValue(getRecord().getAttribute("supplierId")));
			condition.put("addtionalCondition", "ORDER BY receive_unit_manage_id desc");
			DBDataSource.callOperation("ST_ReceiveUnitManage", "find", condition, new DSCallback(){
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0) {
						Record record=dsResponse.getData()[0];
						form.editRecord(record);
					}
				}
			});
		}else {
			SC.say("找不到绑定的供应商收款单位");
		}
	}
	
	private  Record record;

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}
	
	
}
