package com.pomplatform.client.workflow.personnelbusiness.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSGoodsApply;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class GoodsApplyUpdateForm extends AbstractWizadPage
{


	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final TextItem companyIdItem;
	private final SelectItem typeItem;
	private final SelectItem nextAuditorItem;
	private final DateTimeItem startDateItem;
	private final TextAreaItem reasonItem;
	private final TextItem drafterItem;

	public GoodsApplyUpdateForm() {
		DSGoodsApply ds = DSGoodsApply.getInstance();
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
		
		companyIdItem = new TextItem("companyId", "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.setWidth("*");
		companyIdItem.setDisabled(true);
		__formItems.add(companyIdItem);
		
		typeItem = new SelectItem("type", "类型");
		typeItem.setWidth("*");
		typeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_109"));
		__formItems.add(typeItem);

		nextAuditorItem = new SelectItem("nextAuditor", "物品类型");
		nextAuditorItem.setWidth("*");
		nextAuditorItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_247"));
		__formItems.add(nextAuditorItem);


		startDateItem = new DateTimeItem("startDate", "领用时间");
		startDateItem.setWidth("*");
		startDateItem.setUseMask(true);
		startDateItem.setUseTextField(true);
		__formItems.add(startDateItem);
		
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
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSGoodsApply.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		if(null == employeeIdItem.getValue()){
			SC.say("请重新登录之后再重试");
			return false;
		}
		if(null == typeItem.getValue()){
			SC.say("请选择类型");
			return false;
		}
		if(null == nextAuditorItem.getValue()){
			SC.say("请选择物品类型");
			return false;
		}

		if(null == startDateItem.getValue()){
			SC.say("请填写领用时间");
			return false;
		}
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
