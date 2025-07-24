package com.pomplatform.client.workflow.personnelbusiness.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSReturnOfItems;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReturnOfItemsUpdateForm extends AbstractWizadPage
{

	private Record record;

	@Override
	public Record getRecord() {
		return record;
	}

	@Override
	public void setRecord(Record record) {
		this.record = record;
	}

	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final TextItem companyIdItem;
	private final SelectItem typeItem;
	private final SelectItem nextAuditorItem;
	private final DateTimeItem startDateItem;
	private final TextAreaItem reasonItem;
	private final TextItem drafterItem;

	public ReturnOfItemsUpdateForm(Record record) {

		setRecord(record);

		DSReturnOfItems ds = DSReturnOfItems.getInstance();
		__form.setWidth100();
		__form.setHeight100();

		employeeIdItem = new TextItem("employeeId", "申请人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setDefaultValue(ClientUtil.getUserId());
		employeeIdItem.setWidth("*");
		employeeIdItem.setDisabled(true);
		__formItems.add(employeeIdItem);

		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setWidth("*");
		employeeNoItem.setDefaultValue(ClientUtil.getUserNo());
		employeeNoItem.setDisabled(true);
		__formItems.add(employeeNoItem);

		departmentIdItem = new TextItem("departmentId", "部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setWidth("*");
		departmentIdItem.setDefaultValue(ClientUtil.getDepartmentId());
		departmentIdItem.setDisabled(true);
		__formItems.add(departmentIdItem);

		companyIdItem = new TextItem("companyId", "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.setWidth("*");
		companyIdItem.setDefaultValue(ClientUtil.getCompanyId());
		companyIdItem.setDisabled(true);
		__formItems.add(companyIdItem);

		typeItem = new SelectItem("type", "类型");
		typeItem.setWidth("*");
		typeItem.hide();
		typeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_109"));
		__formItems.add(typeItem);

		nextAuditorItem = new SelectItem("nextAuditor", "物品类型");
		nextAuditorItem.setWidth("*");
		nextAuditorItem.hide();
		nextAuditorItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_247"));
		__formItems.add(nextAuditorItem);

		startDateItem = new DateTimeItem("startDate", "归还时间");
		startDateItem.setWidth("*");
		startDateItem.setCanEdit(false);
		startDateItem.setUseMask(true);
		startDateItem.setDefaultValue(new Date());
		startDateItem.setUseTextField(true);
		__formItems.add(startDateItem);


		reasonItem = new TextAreaItem("reason", "归还备注");
		reasonItem.setWidth("*");
		reasonItem.setColSpan(2);
		reasonItem.setCanEdit(false);
		reasonItem.setRowSpan(4);
		__formItems.add(reasonItem);

		drafterItem = new TextItem("drafter", "起草人");
		drafterItem.setDefaultValue(ClientUtil.getUserId());
		drafterItem.hide();
		__formItems.add(drafterItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		reasonItem.setColSpan(4);
		addMember(__form);

		startEdit();
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		SC.debugger();
		Record record = getRecord();
		int businessId = BaseHelpUtils.getIntValue(record.getAttribute("businessId"));
		Map<String, Object> params = new HashMap<>();
		params.put("personnelBusinessId", businessId);
		DBDataSource.callOperation("ST_PersonnelBusines", "find", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record data = dsResponse.getData()[0];
					__form.setValues(data.toMap());
				}
			}
		});
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSReturnOfItems.getInstance());
		manager.addMember(__form);
	}

	@Override
	public Map getValuesAsMap() {
		return __form.getValues();
	}


}
