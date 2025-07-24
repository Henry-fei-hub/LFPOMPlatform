package com.pomplatform.client.workflow.personnelbusiness.form;

import java.math.BigDecimal;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridReceiveUnitValue;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSPurchaseApply;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;

public class PurchaseApplyUpdateForm extends AbstractWizadPage
{


	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final SelectItem companyIdItem;
	private final DoubleItem feeItem;
	private final ComboBoxItem subTypeItem;
	private final TextAreaItem reasonItem;
	private final TextItem drafterItem;
	private final CheckboxItem isRemoteCityItem;
	private final SelectItem nextAuditorItem;

	private PurchaseDetailPersonnelBusinessLinkEquipment detail;

	public PurchaseDetailPersonnelBusinessLinkEquipment getDetail() {
		return detail;
	}

	public void setDetail(PurchaseDetailPersonnelBusinessLinkEquipment detail) {
		this.detail = detail;
	}

	public PurchaseApplyUpdateForm() {
		DSPurchaseApply ds = DSPurchaseApply.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		employeeIdItem = new TextItem("employeeId", "申请人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setWidth("*");
		employeeIdItem.setDisabled(true);
		__formItems.add(employeeIdItem);
		
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setWidth("*");
		employeeNoItem.setDisabled(true);
		__formItems.add(employeeNoItem);
		
		departmentIdItem = new TextItem("departmentId", "部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setWidth("*");
		departmentIdItem.setDisabled(true);
		__formItems.add(departmentIdItem);
		
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.setWidth("*");
		__formItems.add(companyIdItem);
		
		feeItem = new DoubleItem("fee", "预计采购费用(元)");
		feeItem.setWidth("*");
		feeItem.setLength(18);
		feeItem.setDecimalPad(2);
		feeItem.setFormat("#,###,###,###,###,##0.00");
		feeItem.setDisabled(true);
		__formItems.add(feeItem);
		feeItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					BigDecimal number = new BigDecimal(event.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
					feeItem.setValue(number);
				}else{
					feeItem.setValue(0);
				}
			}
		});
		
		ListGridField receiveUnitField = new ListGridField("receiveUnit");
		ListGridField bankAccountField = new ListGridField("bankAccount");
		ListGridField bankNameField = new ListGridField("bankName");
		subTypeItem= new ComboBoxItem("subType", "收款方");
		subTypeItem.setChangeOnKeypress(false);
		subTypeItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		subTypeItem.setWidth("*");
		subTypeItem.setValueField("receiveUnitManageId");
		subTypeItem.setDisplayField("receiveUnit");
		subTypeItem.setPickListFields(receiveUnitField, bankNameField, bankAccountField);
		subTypeItem.setOptionDataSource(DSSelectGridReceiveUnitValue.getInstance());
		subTypeItem.setPickListWidth(800);
		__formItems.add(subTypeItem);

		nextAuditorItem = new SelectItem("nextAuditor", "采购类型");
		nextAuditorItem.setWidth("*");
		nextAuditorItem.setDisabled(true);
		nextAuditorItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_252"));
		__formItems.add(nextAuditorItem);
		
		isRemoteCityItem = new CheckboxItem("isRemoteCity", "需要走预付款流程请打勾");
		__formItems.add(isRemoteCityItem);
		
		reasonItem = new TextAreaItem("reason", "申请缘由");
		reasonItem.setWidth("*");
		reasonItem.setColSpan(2);
		reasonItem.setRowSpan(4);
		__formItems.add(reasonItem);
		
		drafterItem = new TextItem("drafter", "起草人");
		drafterItem.hide();
		__formItems.add(drafterItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		reasonItem.setColSpan(4);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		int type = BaseHelpUtils.getIntValue(nextAuditorItem.getValue());
		detail.reload(type);
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSPurchaseApply.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		if(null == employeeIdItem.getValue()){
			SC.say("请重新登录之后再重试");
			return false;
		}
		if(null == feeItem.getValue()){
			SC.say("请填写预计采购费用");
			return false;
		}
		if(null == reasonItem.getValue()){
			SC.say("请填写申请缘由");
			return false;
		}
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map map = __form.getValues();
		map.put("isRemoteCity", isRemoteCityItem.getValue());
		return map;
	}


}
