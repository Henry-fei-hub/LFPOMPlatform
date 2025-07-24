package com.pomplatform.client.supplierworkflow.form;

import java.util.*;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.ValidateUtils;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.smartgwt.client.data.Criteria;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
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
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;
import java.util.logging.Logger;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.supplierworkflow.datasource.DSSupplierCooperation;

public class SupplierComeInDetailSupplierCooperation extends AbstractWizadPage
{

	private static final Logger __logger = Logger.getLogger("");
	private final VLayout vLayout;
	private final HLayout buttonLayout;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
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
	private Label TitleView;
	private int status=0; 

	public SupplierComeInDetailSupplierCooperation(){
		vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		vLayout.setMargin(10);
		vLayout.setMembersMargin(12);

		TitleView = new Label();
		TitleView.setContents("<font style=\"color:red;font-size:16px;font-weight:bold;\">为供应商添加收款单位</font>");
		TitleView.setWidth("100%");
		TitleView.setHeight("7%");
		TitleView.setAlign(Alignment.CENTER);
		vLayout.addMember(TitleView);

		enlargeAccountLabel = new Label();
		enlargeAccountLabel.hide();
		enlargeAccountLabel.setHeight(50);
		vLayout.addMember(enlargeAccountLabel);


		bankAccountItem = new TextItem("bankAccount", shouldNotBeNull+"银行账号(<font color='red'>银行账号只能为输入数字与字母,不能输入空格与特殊字符.</font>)");
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
		__formItems.add(bankAccountItem);

		receiveUnitItem = new TextItem("receiveUnit", shouldNotBeNull+"供应商收款方名称");
		receiveUnitItem.setWidth("*");
		receiveUnitItem.setRequired(true);
		__formItems.add(receiveUnitItem);

		receiveUnitAddressItem = new TextItem("receiveUnitAddress", shouldNotBeNull+"供应商收款方地址");
		receiveUnitAddressItem.setWidth("*");
		receiveUnitAddressItem.setRequired(true);
		__formItems.add(receiveUnitAddressItem);


		IsIntegerValidator intValidator = new IsIntegerValidator();
		intValidator.setErrorMessage("请选择下拉数据, 数据可填写只是方便搜索下拉数据");
		bankIdItem = new ComboBoxItem("bankId", shouldNotBeNull+"开户行");
		bankIdItem.setChangeOnKeypress(false);
		bankIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		bankIdItem.setValidators(intValidator);
		//			bankIdItem.setValueMap(KeyValueManager.getValueMap("banks"));
		KeyValueManager.loadValueMap("banks",bankIdItem);
		bankIdItem.addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				bankNameItem.setValue(event.getItem().getDisplayValue());

			}
		});
		bankIdItem.setRequired(true);
		bankIdItem.setWidth("*");
		__formItems.add(bankIdItem);

		bankNameItem = new TextItem("bankName", shouldNotBeNull+"开户行(支行)<font color='red'>填写内容例子:XX银行XX支行</font>");
		bankNameItem.setWidth("*");
		bankNameItem.setRequired(true);
		__formItems.add(bankNameItem);

		bankAddressItem = new TextItem("bankAddress", shouldNotBeNull+"开户行所在详细地址");
		bankAddressItem.setRequired(true);
		bankAddressItem.hide();
		bankAddressItem.setWidth("*");
		__formItems.add(bankAddressItem);

		provinceItem = new SelectItem("province", shouldNotBeNull+"开户行所在省");
		provinceItem.setRequired(true);
		provinceItem.setValueMap(KeyValueManager.getValueMap("provinces"));
		//			provinceItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		//			provinceItem.setChangeOnKeypress(false);
		provinceItem.setWidth("*");
		__formItems.add(provinceItem);
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

		cityItem = new SelectItem("city",shouldNotBeNull+ "开户行所在市");
		cityItem.setRequired(true);
		cityItem.setWidth("*");
		__formItems.add(cityItem);

		accountTypeItem = new SelectItem("accountType",shouldNotBeNull+ "收款方银行类型");
		accountTypeItem.setRequired(true);
		accountTypeItem.setDefaultValue(1);
		accountTypeItem.setWidth("*");
		accountTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_171"));
		__formItems.add(accountTypeItem);
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

		receiveUnitPhoneItem = new TextItem("receiveUnitPhone", shouldNotBeNull+"收款方电话");
		receiveUnitPhoneItem.hide();
		receiveUnitPhoneItem.setWidth("*");
		receiveUnitPhoneItem.setRequired(true);
		__formItems.add(receiveUnitPhoneItem);

		swiftCodeItem = new TextItem("swiftCode", "SWIFT CODE");
		swiftCodeItem.hide();
		swiftCodeItem.setWidth("*");
		swiftCodeItem.setRequired(true);
		__formItems.add(swiftCodeItem);

		countryIdItem = new ComboBoxItem("countryId", "收款人常驻国家（地区）");
		countryIdItem.hide();
		countryIdItem.setRequired(true);
		countryIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		countryIdItem.setChangeOnKeypress(false);
		countryIdItem.setWidth("*");
		countryIdItem.setValueMap(KeyValueManager.getValueMap("countries"));
		__formItems.add(countryIdItem);
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
		__formItems.add(countryCodeItem);
		
		passportItem = new TextItem("passport", "护照");
		passportItem.hide();
		passportItem.setRequired(true);
		passportItem.setWidth("*");
		__formItems.add(passportItem);

		__form.setNumCols(2);
		__form.setItems(receiveUnitItem, receiveUnitAddressItem, bankIdItem, bankNameItem, bankAccountItem, bankAddressItem, provinceItem,
				cityItem, accountTypeItem, receiveUnitPhoneItem, swiftCodeItem, countryIdItem, countryCodeItem,
				passportItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		vLayout.addMember(__form);
		__form.setWidth100();
		__form.setHeight100();


		buttonLayout = new HLayout();
		buttonLayout.setWidth100();
		buttonLayout.setHeight(20);
		buttonLayout.setMargin(8);
		buttonLayout.setMembersMargin(20);
		buttonLayout.setAlign(Alignment.CENTER);

		vLayout.addMember(buttonLayout);

		addMember(vLayout);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) {
			Map condition = new HashMap();
			condition.put("supplierId", BaseHelpUtils.getIntValue(getRecord().getAttribute("supplierId")));
			condition.put("addtionalCondition", "ORDER BY receive_unit_manage_id desc");
			DBDataSource.callOperation("ST_ReceiveUnitManage", "find", condition, new DSCallback(){
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0) {
						Record record=dsResponse.getData()[0];
						__form.editRecord(record);
					}
				}
			});
		}
			
	}


	@Override
	public boolean checkData() {
		if(!__form.validate()) {
			SC.say("请按系统提示修改信息");
			return false;
		}else if(status<=0){
			status=checkReceiveData().getStatus();
		}
		if(status==-2){ 
			SC.ask(checkReceiveData().getErrors().get("errorMsg").toString(), new BooleanCallback() {

				@Override
				public void execute(Boolean value) {
					if (value) {
						status=1;
					}
				}
			});
			return false;
		}else if(status==-1) {
			SC.say(checkReceiveData().getErrors().get("errorMsg").toString());
			return false;
		}else if(status>0) {
			return true;
		}
		return false;
	}

	@Override
	public Map getValuesAsMap() {
		Map<String,Object>  valueMap=__form.getValues();
		Map<String,Map> receiveMap=new HashMap<>();
		receiveMap.put("receiveInfo", valueMap);

		return receiveMap;
	}

	public String enLargeAccount(String value){
		if(!BaseHelpUtils.isNullOrEmpty(value)){
			String prefixhtml = "<font style='font-size: 28;color:black;'>";

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

	public DSResponse checkReceiveData() {
		String bankAccount=BaseHelpUtils.getString(bankAccountItem.getValue());
		String receiveUnit=BaseHelpUtils.getString(receiveUnitItem.getValue());
		Map<String,Object> params = new HashMap<>();
		params.put("operateEmployeeId", ClientUtil.getEmployeeId());
		params.put("bankAccount", bankAccount);
		params.put("receiveUnit", receiveUnit);
		params.put("opt_type", "checkReceiveUnitInfo");
		DSResponse dsr=SyncDataUtil.checkValue("EP_CustomSprocessbilllistppporProcess", "find",params);
		return dsr;
	}

}

