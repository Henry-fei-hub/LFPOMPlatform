package com.pomplatform.client.supplierworkflow.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.pomplatform.client.supplierworkflow.datasource.DSSupplierWorkflow;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.DateFieldLayout;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DateRangeItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class SupplierWorkflowNewForm extends AbstractWizadPage
{

	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private static Logger __logger = Logger.getLogger("");
	private final TextItem receiveUnitItem;
	private final TextItem supplierContactItem;
	private final TextItem supplierEmailItem;
	private final TextItem supplierPhoneItem;
	private final TextItem bankAccountItem;
	private final TextItem bankNameItem;
	private final ComboBoxItem bankIdItem;
	private final TextItem socialCreditCodeItem;
	private final ComboBoxItem provinceItem;
	private final ComboBoxItem cityItem;
	private final TextItem receiveUnitAddressItem;
	private final TextItem supplierAddressItem;
	private final ComboBoxItem supplierMainBusinessTypeItem;
	private final TextItem supplierScopeSupplyItem;
	private final TextItem businessLicenseItem;
	private final ComboBoxItem agreementTypeItem;
	private final TextItem productionCycleItem;
	private final TextItem logisticsCycleItem;
	private final TextItem supplierBossItem;
	private final DateRangeItem rangeItem;
	private final DateItem agreementSignTimeItem;
	private final TextItem agreementSignAddressItem;
	
	public SupplierWorkflowNewForm() {
		DSSupplierWorkflow ds = DSSupplierWorkflow.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		receiveUnitItem = new TextItem("receiveUnit", shouldNotBeNull+"供应商名称");
		receiveUnitItem.setWidth("*");
		receiveUnitItem.setRequired(true);
		__formItems.add(receiveUnitItem);

		supplierContactItem=new TextItem("supplierContact",shouldNotBeNull+"供应商联系人");
		supplierContactItem.setWidth("*");
		supplierContactItem.setRequired(true);
		__formItems.add(supplierContactItem);

		supplierEmailItem=new TextItem("supplierEmail","联系人邮箱");
		supplierEmailItem.setWidth("*");
		__formItems.add(supplierEmailItem);

		supplierPhoneItem=new TextItem("supplierPhone",shouldNotBeNull+"联系人电话");
		supplierPhoneItem.setWidth("*");
		__formItems.add(supplierPhoneItem);


		bankIdItem = new ComboBoxItem("bankId", "开户行");
		bankIdItem.setChangeOnKeypress(false);
		bankIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
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
		__formItems.add(bankIdItem);

		bankNameItem = new TextItem("bankName", "开户行(支行)<font color='red'>填写内容例子:XX银行XX支行</font>");
		bankNameItem.setWidth("*");
		bankNameItem.setRequired(true);
		__formItems.add(bankNameItem);

		bankAccountItem=new TextItem("bankAccount",shouldNotBeNull+"银行账号(<font color='red'>银行账号只能为输入数字与字母,不能输入空格与特殊字符.</font>)");
		bankAccountItem.setWidth("*");
		bankAccountItem.setRequired(true);
		__formItems.add(bankAccountItem);

		provinceItem = new ComboBoxItem("province", shouldNotBeNull+"开户行所在省");
		provinceItem.setRequired(true);
		provinceItem.setValueMap(KeyValueManager.getValueMap("provinces"));
		provinceItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		provinceItem.setChangeOnKeypress(false);
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
		__formItems.add(provinceItem);

		cityItem = new ComboBoxItem("city", shouldNotBeNull+"开户行所在市");
		cityItem.setRequired(true);
		cityItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		cityItem.setChangeOnKeypress(false);
		cityItem.setWidth("*");
		__formItems.add(cityItem);

		receiveUnitAddressItem=new TextItem("receiveUnitAddress",shouldNotBeNull+"开户行详细地址");
		receiveUnitAddressItem.setWidth("*");
		__formItems.add(receiveUnitAddressItem);


		supplierBossItem=new TextItem("supplierBoss","供应商法定代表人");
		supplierBossItem.setWidth("*");
		__formItems.add(supplierBossItem);



		socialCreditCodeItem=new TextItem("socialCreditCodeItem","社会信用代码");
		socialCreditCodeItem.setWidth("*");
		__formItems.add(socialCreditCodeItem);

		supplierAddressItem=new TextItem("supplierAddress","供应商税务登记地址");
		supplierAddressItem.setWidth("*");
		__formItems.add(supplierAddressItem);



		businessLicenseItem=new TextItem("businessLicense","营业执照号");
		businessLicenseItem.setWidth("*");
		__formItems.add(businessLicenseItem);


		supplierMainBusinessTypeItem=new ComboBoxItem("supplierMainBusinessType",shouldNotBeNull+"供应商主营业务");
		supplierMainBusinessTypeItem.setWidth("*");
		supplierMainBusinessTypeItem.setRequired(true);
		__formItems.add(supplierMainBusinessTypeItem);

		supplierScopeSupplyItem=new TextItem("supplierScopeSupply","供货范围");
		supplierScopeSupplyItem.setWidth("*");
		__formItems.add(supplierScopeSupplyItem);

		agreementTypeItem=new ComboBoxItem("agreementType","协议类别");
		agreementTypeItem.setWidth("*");
		__formItems.add(agreementTypeItem);

		productionCycleItem=new TextItem("productionCycle","生产周期");
		productionCycleItem.setWidth("*");
		__formItems.add(productionCycleItem);

		logisticsCycleItem=new TextItem("logisticsCycle","物流周期");
		logisticsCycleItem.setWidth("*");
		__formItems.add(logisticsCycleItem);

		/*	contractScopeTimeStartItem=new DateItem("contractScopeTimeStart",shouldNotBeNull+"合同开始日期");
		contractScopeTimeStartItem.setUseTextField(true);
		contractScopeTimeStartItem.setWidth("*");
		contractScopeTimeStartItem.setRequired(true);
		__formItems.add(contractScopeTimeStartItem);
		


		/*contractScopeTimeEndItem=new DateItem("contractScopeTimeEnd",shouldNotBeNull+"合同结束日期");
		contractScopeTimeEndItem.setUseTextField(true);
		contractScopeTimeEndItem.setWidth("*");
		contractScopeTimeEndItem.setRequired(true);
		agreement_sign_time
		__formItems.add(contractScopeTimeEndItem);*/

		agreementSignTimeItem=new DateItem("agreementSign","协议签订时间");
		agreementSignTimeItem.setWidth("*");
		agreementSignTimeItem.setUseTextField(true);
		__formItems.add(agreementSignTimeItem);
		
		
		agreementSignAddressItem=new TextItem("agreementSignAddress","协议签订地点");
		agreementSignAddressItem.setWidth("*");
		__formItems.add(agreementSignAddressItem);
		
		

		rangeItem = new DateRangeItem("contractScopeTime",shouldNotBeNull+"合同周期");  
		rangeItem.setWidth("*");  
		rangeItem.setShowTitle(false); 
		rangeItem.setRequired(true);
		rangeItem.setInnerTitleOrientation(TitleOrientation.TOP);
		rangeItem.setFieldLayout(DateFieldLayout.HORIZONTAL);
		rangeItem.setFromTitle(shouldNotBeNull+"合同周期开始时间");
		rangeItem.setToTitle(shouldNotBeNull+"合同周期结束时间");
		rangeItem.setAllowRelativeDates(true); 
		/*  rangeItem.addChangedHandler(new ChangedHandler() {
				@Override
				public void onChanged(ChangedEvent event) {
					Date startDate=((DateRange) event.getValue()).getStartDate();
					Date endDate=((DateRange) event.getValue()).getEndDate();
					String starttime=DateTimeFormat.getFormat("yyyy-MM-dd").format(startDate)+"~";
					String endtime=DateTimeFormat.getFormat("yyyy-MM-dd").format(endDate);
					String time=starttime+endtime;
					__logger.info("time+++++++++++++++++++++++++++++++++++++"+time);
				}
			});*/
		__formItems.add(rangeItem);





		__form.setItems(getFormItemArray());
		//__form.setDataSource(ds);
		__form.setNumCols(6);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
		receiveUnitItem.setColSpan(3);
		supplierContactItem.setColSpan(3);
		provinceItem.setColSpan(3);
		bankAccountItem.setColSpan(3);
		bankNameItem.setColSpan(3);
		bankIdItem.setColSpan(3);
		supplierPhoneItem.setColSpan(3);
		supplierEmailItem.setColSpan(3);
		receiveUnitAddressItem.setColSpan(3);
		cityItem.setColSpan(3);
		

	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
		
		/*DateRange dateRange=new DateRange();
		dateRange.setStartDate(new Date());
		dateRange.setEndDate(new Date());
		rangeItem.setValue(dateRange);
		*/
		
		
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSupplierWorkflow.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map<String,Object>  valueMap=__form.getValues();
		Map<String,Object>  detailMap=new HashMap<>();
		List<Map> list = new ArrayList<>();
		valueMap.put("operateEmployeeId", ClientUtil.getEmployeeId());
		valueMap.put("operateTime", new Date());
		
		
		//封装子表数据集
		Date startTime =rangeItem.getValue().getStartDate();//获取合同开始时间
		Date endTime =rangeItem.getValue().getEndDate();//获取合同结束时间
		//拼接合同周期
		String contractScopeTime=DateTimeFormat.getFormat("yyyy-MM-dd").format(startTime)+"~"+DateTimeFormat.getFormat("yyyy-MM-dd").format(endTime);
		detailMap.put("supplierName", receiveUnitItem.getValue());
		detailMap.put("supplierContact", supplierContactItem.getValue());
		detailMap.put("supplierPhone", supplierPhoneItem.getValue());
		detailMap.put("supplierEmail", supplierEmailItem.getValue());
		detailMap.put("supplierBankProvince", provinceItem.getValue());
		detailMap.put("supplierBankCity", cityItem.getValue());
		detailMap.put("bankId", bankIdItem.getValue());
		detailMap.put("supplierBankName", bankNameItem.getValue());
		detailMap.put("supplierBankAccount", bankAccountItem.getValue());
		detailMap.put("supplierBankAddress", receiveUnitAddressItem.getValue());
		detailMap.put("supplierBoss", supplierBossItem.getValue());
		detailMap.put("socialCreditCode", socialCreditCodeItem.getValue());
		detailMap.put("supplierAddress", supplierAddressItem.getValue());
		detailMap.put("businessLicense", businessLicenseItem.getValue());
		detailMap.put("supplierMainBusinessType", supplierMainBusinessTypeItem.getValue());
		detailMap.put("supplierScopeSupply", supplierScopeSupplyItem.getValue());
		detailMap.put("agreementType", agreementTypeItem.getValue());
		detailMap.put("productionCycle", productionCycleItem.getValue());
		detailMap.put("logisticsCycle", logisticsCycleItem.getValue());
		detailMap.put("agreementSignTime", agreementSignTimeItem.getValue());
		detailMap.put("agreementSignAddress", agreementSignAddressItem.getValue());
		detailMap.put("contractScopeTimeStart", startTime);
		detailMap.put("contractScopeTimeEnd", endTime);
		detailMap.put("contractScopeTime", contractScopeTime);
		detailMap.put("operateEmployeeId", ClientUtil.getEmployeeId());
		detailMap.put("operateTime", new Date());
		list.add(detailMap);
		valueMap.put("detailSupplier", list);//子表数据Map
		
		
		__logger.info("valueMap+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+valueMap);
		__logger.info("detailMap+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+detailMap);
		
		
		
		
		
		return valueMap;
	}


}
