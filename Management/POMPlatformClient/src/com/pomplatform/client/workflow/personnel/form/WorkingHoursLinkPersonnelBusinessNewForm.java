package com.pomplatform.client.workflow.personnel.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.workflow.personnel.datasource.DSWorkingHoursLinkPersonnelBusiness;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.PickTreeItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;

import java.util.Date;
import java.util.Map;

public class WorkingHoursLinkPersonnelBusinessNewForm extends AbstractWizadPage
{


	private final TextItem processTypeItem;
	private final TextItem personnelBusinessIdItem;
	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;
	private final PickTreeItem departmentIdItem;
	private final TextItem plateDepartmentIdItem;
	private final TextItem companyIdItem;
	private final DateTimeItem startDateItem;
	private final TextAreaItem remarkItem;

	public WorkingHoursLinkPersonnelBusinessNewForm(Boolean canEditor) {
		DSWorkingHoursLinkPersonnelBusiness ds = DSWorkingHoursLinkPersonnelBusiness.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		processTypeItem = new TextItem("processType", "类型 13请假  14出差  15打卡  16外出  17加班");
		processTypeItem.setHidden(true);
		processTypeItem.setDefaultValue(84);
		__formItems.add(processTypeItem);

		personnelBusinessIdItem = new TextItem("personnelBusinessId", "业务表主键");
		personnelBusinessIdItem.setHidden(true);
		__formItems.add(personnelBusinessIdItem);

		employeeIdItem = new TextItem("employeeId", "员工姓名");
		employeeIdItem.setWidth("*");
		employeeIdItem.setHidden(false);
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setCanEdit(false);
		__formItems.add(employeeIdItem);

		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setCanEdit(false);
		employeeNameItem.setWidth("*");
		employeeNameItem.setHidden(false);
//		__formItems.add(employeeNameItem);

		employeeNoItem = new TextItem("employeeNo", "员工工号");
		employeeNoItem.setHidden(false);
		employeeNoItem.setWidth("*");
		employeeNoItem.setCanEdit(false);
		__formItems.add(employeeNoItem);

		companyIdItem = new TextItem("companyId", "归属公司");
		companyIdItem.setCanEdit(false);
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.setWidth("*");
		__formItems.add(companyIdItem);

		startDateItem = new DateTimeItem("startDate", "日期");
		startDateItem.setWidth("*");
		startDateItem.setCanEdit(true);
		startDateItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				if(null != event.getValue()  ){
					Map<String, Object> params = getValuesAsMap();
					params.put("optType", "WorkingHoursDate");
					params.put("startDate", event.getValue());
					DBDataSource.callOperation("EP_MyPersonnelProcessor", params, new DSCallback() {

						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() < 0){
								startDateItem.setValue(new Date());
								SC.say("不能选择今天之后的时间!!");
							}

						}
					});
				}
			}
		});
		__formItems.add(startDateItem);

		departmentIdItem = new PickTreeItem("departmentId", "部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments", "0"));
		departmentIdItem.setCanEdit(false);
		departmentIdItem.setWidth("*");
		__formItems.add(departmentIdItem);

		plateDepartmentIdItem = new TextItem("plateId", "业务部门");
		plateDepartmentIdItem.setHidden(true);
		plateDepartmentIdItem.setWidth("*");
		plateDepartmentIdItem.setCanEdit(false);
		__formItems.add(plateDepartmentIdItem);

		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setColSpan(8);
		remarkItem.setRowSpan(4);
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);

		canEditor(canEditor);
	}

	/**
	 * @author liubin
	 * @description //TODO 判断是否可以修改
	 * @date 12:55 2020/2/25
	 * @param
	 * @return
	 **/
	private void canEditor(Boolean canEditor) {
		if (canEditor) {
			remarkItem.setCanEdit(true);
		} else {
			remarkItem.setCanEdit(false);
		}
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getPageMode()!=AbstractWizadPage.PAGE_MODE_UPDATE) {
			employeeIdItem.setDefaultValue(ClientUtil.getEmployeeId());
			employeeNameItem.setDefaultValue(ClientUtil.getUserName());
			employeeNoItem.setDefaultValue(ClientUtil.getUserNo());
			companyIdItem.setDefaultValue(ClientUtil.getCompanyId());
			startDateItem.setDefaultValue(new Date());
			departmentIdItem.setDefaultValue(ClientUtil.getDepartmentId());
			plateDepartmentIdItem.setDefaultValue(ClientUtil.getPlateId());
		}
		Record record = getRecord();
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSWorkingHoursLinkPersonnelBusiness.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}

	public Record record;

	@Override
	public Record getRecord() {
		return record;
	}

	@Override
	public void setRecord(Record record) {
		this.record = record;
	}
}
