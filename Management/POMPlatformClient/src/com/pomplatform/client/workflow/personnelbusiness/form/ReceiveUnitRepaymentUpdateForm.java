package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridReceiveUnitValue;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSReceiveUnitRepayment;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.FloatItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

public class ReceiveUnitRepaymentUpdateForm extends AbstractWizadPage {

	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final SelectItem companyIdItem;
	private final DateItem startDateItem;
	private final TextAreaItem remarkItem;
	private final ComboBoxItem parentIdItem;
	private final TextItem drafterItem;
	private final SelectItem otherNameItem;
	private final SelectItem otherBankNameItem;
	private final SelectItem otherBankAccountItem;
	private final SelectItem costAttributionItem;
	private final FloatItem feeItem;
	private final SelectItem typeItem;
	private final TextItem planItem;

	private final VLayout mainLayout;

	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";

	public ReceiveUnitRepaymentUpdateForm() {
		ListGridField receiveUnitField = new ListGridField("receiveUnit");
		ListGridField bankAccountField = new ListGridField("bankAccount");
		ListGridField bankNameField = new ListGridField("bankName");
		DSReceiveUnitRepayment ds = DSReceiveUnitRepayment.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		mainLayout = new VLayout();
		
		planItem = new TextItem("plan", "收款单位名称");
		planItem.hide();
		__formItems.add(planItem);
		
		drafterItem = new TextItem("drafter", "起草人");
		drafterItem.setDefaultValue(ClientUtil.getUserId());
		drafterItem.hide();
		__formItems.add(drafterItem);
		
		employeeIdItem = new TextItem("employeeId", "申请人");
		employeeIdItem.setRequired(true);
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setDefaultValue(ClientUtil.getUserId());
		employeeIdItem.setWidth("*");
		employeeIdItem.setDisabled(true);
		__formItems.add(employeeIdItem);

		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setRequired(true);
		employeeNoItem.setDefaultValue(ClientUtil.getUserNo());
		employeeNoItem.setWidth("*");
		employeeNoItem.setDisabled(true);
		__formItems.add(employeeNoItem);

		departmentIdItem = new TextItem("departmentId", "部门");
		departmentIdItem.setRequired(true);
		departmentIdItem.setDefaultValue(ClientUtil.getDepartmentId());
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setWidth("*");
		departmentIdItem.setDisabled(true);
		__formItems.add(departmentIdItem);

		companyIdItem = new SelectItem("companyId", shouldNotBeNull + "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.setDefaultValue(ClientUtil.getCompanyId());
		companyIdItem.setRequired(true);
		companyIdItem.setDisabled(true);
		companyIdItem.setWidth("*");
		__formItems.add(companyIdItem);
		
		otherNameItem = new SelectItem("projectId", "收款方");
		otherNameItem.setWidth("*");
		otherNameItem.setRequired(true);
		otherNameItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		otherNameItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				otherBankNameItem.clearValue();
				otherBankAccountItem.clearValue();
				setSelectBankAddressByCompanyId(BaseHelpUtils.getIntValue(event.getValue()));
				
			}
		});
		__formItems.add(otherNameItem);
		
		startDateItem = new DateItem("startDate", shouldNotBeNull + "实际还款日期");
		startDateItem.setDefaultValue(new Date());
		startDateItem.setRequired(true);
		startDateItem.setUseTextField(true);
		startDateItem.setUseMask(true);
		startDateItem.setWidth("*");
		__formItems.add(startDateItem);
		
		otherBankNameItem = new SelectItem("projectName", "银行名称(收款方)");
		otherBankNameItem.setValueMap(new LinkedHashMap<>());
		otherBankNameItem.setWidth("*");
		otherBankNameItem.setRequired(true);
		otherBankNameItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				otherBankAccountItem.clearValue();
				setSelectBankAccountByCompanyIdAndBankName(BaseHelpUtils.getIntValue(otherNameItem.getValue()), event.getValue().toString());
			}
		});
		__formItems.add(otherBankNameItem);
		
		Criteria cd = new Criteria();
		cd.addCriteria("origin", "0");
		parentIdItem = new ComboBoxItem("parentId", shouldNotBeNull + "付款公司");
		parentIdItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != parentIdItem.getSelectedRecord()){
					planItem.setValue(parentIdItem.getSelectedRecord().getAttribute("receiveUnit"));
				}
				
			}
		});
		parentIdItem.setChangeOnKeypress(false);
		parentIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		parentIdItem.setRequired(true);
		parentIdItem.setWidth("*");
		parentIdItem.setOptionDataSource(DSSelectGridReceiveUnitValue.getInstance());
		parentIdItem.setOptionCriteria(cd);
		parentIdItem.setValueField("receiveUnitManageId");
		parentIdItem.setDisplayField("receiveUnit");
		parentIdItem.setPickListFields(receiveUnitField, bankNameField, bankAccountField);
		__formItems.add(parentIdItem);
		
		otherBankAccountItem = new SelectItem("projectCode", "银行账号(收款方)");
		otherBankAccountItem.setValueMap(new LinkedHashMap<>());
		otherBankAccountItem.setWidth("*");
		otherBankAccountItem.setRequired(true);
		__formItems.add(otherBankAccountItem);
		
		costAttributionItem = new SelectItem("costAttribution", "货币类型");
		costAttributionItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_40"));
		costAttributionItem.setRequired(true);
		costAttributionItem.setWidth("*");
		__formItems.add(costAttributionItem);

		feeItem = new FloatItem("fee", "还款金额");
		feeItem.setWidth("*");
		feeItem.setRequired(true);
		__formItems.add(feeItem);
		
		typeItem = new SelectItem("type", "款项类型");
		typeItem.setWidth("*");
		typeItem.setRequired(true);
		typeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_csutom_55"));
		__formItems.add(typeItem);
		
		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setColSpan(4);
		remarkItem.setRowSpan(3);
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		mainLayout.addMember(__form);
		addMember(mainLayout);

	}

	private void setSelectBankAccountByCompanyIdAndBankName(int __companyId, String bankAddress){
		otherBankAccountItem.setValueMap(new LinkedHashMap<>());
		Map<String, Object> params = new HashMap<>();
		params.put("opt_type", "getBankcardByCmpAndAddress");
		params.put("objectId", __companyId);
		params.put("objectType", 2);
		params.put("bankAddress", bankAddress);
		KeyValueManager.setValueMapFromQuery("EP_CustomSprocessbilllistppporProcess", MapUtils.toJSON(params), otherBankAccountItem);
	}
	
	private void setSelectBankAddressByCompanyId(int __companyId){
		otherBankNameItem.setValueMap(new LinkedHashMap<>());
		Map<String, Object> params = new HashMap<>();
		params.put("opt_type", "getBankAddressByCompany");
		params.put("objectId", __companyId);
		params.put("objectType", 2);
		KeyValueManager.setValueMapFromQuery("EP_CustomSprocessbilllistppporProcess", MapUtils.toJSON(params), otherBankNameItem);
	}
	
	@Override
	public boolean checkData() {
		return __form.validate();
	}

	@Override
	public void startEdit() {
		if (getRecord() != null)
			__form.editRecord(getRecord());
		else
			__form.editNewRecord();
		setSelectBankAddressByCompanyId(BaseHelpUtils.getIntValue(otherNameItem.getValue()));
		setSelectBankAccountByCompanyIdAndBankName(BaseHelpUtils.getIntValue(otherNameItem.getValue()), otherBankNameItem.getValueAsString());
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSReceiveUnitRepayment.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}
	
}
