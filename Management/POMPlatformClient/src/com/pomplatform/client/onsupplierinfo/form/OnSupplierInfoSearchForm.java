package com.pomplatform.client.onsupplierinfo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.onsupplierinfo.datasource.CDOnSupplierInfo;

public class OnSupplierInfoSearchForm extends SearchForm
{


	private final TextItem supplierIdItem;
	private final TextItem supplierNameItem;
	private final TextItem supplierContactItem;
	private final TextItem supplierPhoneItem;
	private final TextItem supplierEmailItem;
	private final TextItem supplierTypeItem;
	private final TextItem supplierMainBusinessTypeItem;
	private final TextItem supplierScopeSupplyItem;
	private final TextItem socialCreditCodeItem;
	private final TextItem supplier_provinceItem;
	private final TextItem supplier_cityItem;
	private final TextItem supplierBankAddressItem;
	private final TextItem supplierAddressItem;
	private final TextItem productionCycleItem;
	private final TextItem logisticsCycleItem;
	private final TextItem supplierBossItem;
	private final DateTimeItem contractSigningTimeItem;
	private final TextItem contractScopeTimeItem;
	private final DateTimeItem contractScopeTimeStartItem;
	private final DateTimeItem contractScopeTimeEndItem;
	private final ComboBoxItem operateEmployeeIdItem;
	private final DateTimeItem operateTimeItem;
	private final TextItem supplierOriginItem;
	private final TextItem supplierStatusItem;
	private final TextItem isUseItem;
	private final TextItem receiveUnitManageIdItem;
	private final TextItem agreementTypeItem;
	private final DateTimeItem agreementSignTimeItem;
	private final TextItem agreementSignAddressItem;
	private final TextItem fileIdItem;
	private final TextItem teamSizeItem;
	private final SelectItem areasExpertiseItem;
	private final SelectItem processStatusItem;

	public OnSupplierInfoSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnSupplierInfo.getInstance());
		supplierIdItem = new TextItem("supplierId", "供应商编码");
		supplierNameItem = new TextItem("supplierName", "供应商名称");
		supplierNameItem.setWidth("*"); 
		
		supplierContactItem = new TextItem("supplierContact", "供应商负责人");
		supplierContactItem.setWidth("*");
		
		supplierPhoneItem = new TextItem("supplierPhone", "供应商电话");
		supplierEmailItem = new TextItem("supplierEmail", "供应商邮箱");
		supplierTypeItem = new TextItem("supplierType", "供应商类型");
		supplierMainBusinessTypeItem = new TextItem("supplierMainBusinessType", "供应商主营业务类型");
		supplierScopeSupplyItem = new TextItem("supplierScopeSupply", "供货范围");
		socialCreditCodeItem = new TextItem("socialCreditCode", "社会信用代码");
		supplier_provinceItem = new TextItem("supplier_province", "供应商所在(省)");
		supplier_cityItem = new TextItem("supplier_city", "供应商所在(市)");
		supplierBankAddressItem = new TextItem("supplierBankAddress", "供应商开户行详细地址");
		supplierAddressItem = new TextItem("supplierAddress", "供应商税务登记地址");
		productionCycleItem = new TextItem("productionCycle", "生产周期");
		logisticsCycleItem = new TextItem("logisticsCycle", "物流周期");
		supplierBossItem = new TextItem("supplierBoss", "供应商法定代表人");
		contractSigningTimeItem = new DateTimeItem("contractSigningTime", "合同签订日期");
		contractSigningTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, contractSigningTimeItem);
			}
		});
		contractScopeTimeItem = new TextItem("contractScopeTime", "合同周期");
		contractScopeTimeStartItem = new DateTimeItem("contractScopeTimeStart", "合同周期开始时间");
		contractScopeTimeStartItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, contractScopeTimeStartItem);
			}
		});
		contractScopeTimeEndItem = new DateTimeItem("contractScopeTimeEnd", "合同周期结束时间");
		contractScopeTimeEndItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, contractScopeTimeEndItem);
			}
		});
		operateEmployeeIdItem = new ComboBoxItem("operateEmployeeId", "操作人");
		operateEmployeeIdItem.setWidth("*");
		KeyValueManager.loadValueMap("employees", operateEmployeeIdItem);
		
		operateTimeItem = new DateTimeItem("operateTime", "操作时间");
		operateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, operateTimeItem);
			}
		});
		supplierOriginItem = new TextItem("supplierOrigin", "供应商来源");
		supplierStatusItem = new TextItem("supplierStatus", "供应商状态");
		isUseItem = new TextItem("isUse", "供应商是否有效");
		receiveUnitManageIdItem = new TextItem("receiveUnitManageId", "收款单位主键编码");
		agreementTypeItem = new TextItem("agreementType", "协议类别");
		agreementSignTimeItem = new DateTimeItem("agreementSignTime", "协议签订时间");
		agreementSignTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, agreementSignTimeItem);
			}
		});
		agreementSignAddressItem = new TextItem("agreementSignAddress", "协议签订地点");
		fileIdItem = new TextItem("fileId", "附件编码");
		teamSizeItem = new TextItem("teamSize", "团队规模");
		
		areasExpertiseItem = new SelectItem("areasExpertise", "擅长领域");
		areasExpertiseItem.setWidth("*");
		KeyValueManager.loadValueMap("system_dictionary_213", areasExpertiseItem);
		
		
		processStatusItem = new SelectItem("processStatus", "流程状态");
		processStatusItem.setWidth("*");
		KeyValueManager.loadValueMap("process_status", processStatusItem);
		
		

		//setItems(supplierIdItem, supplierNameItem, supplierContactItem, supplierPhoneItem, supplierEmailItem, supplierTypeItem, supplierMainBusinessTypeItem, supplierScopeSupplyItem, socialCreditCodeItem, supplier_provinceItem, supplier_cityItem, supplierBankAddressItem, supplierAddressItem, productionCycleItem, logisticsCycleItem, supplierBossItem, contractSigningTimeItem, contractScopeTimeItem, contractScopeTimeStartItem, contractScopeTimeEndItem, operateEmployeeIdItem, operateTimeItem, supplierOriginItem, supplierStatusItem, isUseItem, receiveUnitManageIdItem, agreementTypeItem, agreementSignTimeItem, agreementSignAddressItem, fileIdItem, teamSizeItem, areasExpertiseItem);
		setItems(supplierNameItem,supplierContactItem,operateEmployeeIdItem,areasExpertiseItem,processStatusItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
