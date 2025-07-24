package com.pomplatform.client.workinghour.form;

import java.math.BigDecimal;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.project.datasource.DSGetProjects;
import com.pomplatform.client.workinghour.datasource.DSWorkingHourManage;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;

public class WorkingHourManageNewForm extends AbstractWizadPage
{



	/**
	 * 项目名称
	 */
	private final ComboBoxItem projectIdItem;
	/**
	 * 项目编号
	 */
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;
	private final SelectItem departmentIdItem;
	private final TextItem plateIdItem;
	private final TextItem companyIdItem;
	private final TextItem workHourItem;
	private final DateItem workDateItem;
	private final TextAreaItem remarkItem;

	public WorkingHourManageNewForm() {
		DSWorkingHourManage ds = DSWorkingHourManage.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		employeeIdItem = new TextItem("employeeId", "职员编码");
		employeeIdItem.setDefaultValue(ClientUtil.getUserId());
		employeeIdItem.hide();
		__formItems.add(employeeIdItem);
		
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		employeeNoItem.setDefaultValue(ClientUtil.getUserNo());
		employeeNoItem.setDisabled(true);
		__formItems.add(employeeNoItem);
		
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		employeeNameItem.setDefaultValue(ClientUtil.getUserName());
		employeeNameItem.setDisabled(true);
		__formItems.add(employeeNameItem);
		
		departmentIdItem = new SelectItem("departmentId", "归属部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setDefaultValue(ClientUtil.getDepartmentId());
		departmentIdItem.hide();
		__formItems.add(departmentIdItem);
		
		plateIdItem = new TextItem("plateId", "业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		plateIdItem.setDefaultValue(ClientUtil.getPlateId());
		plateIdItem.setWidth("*");
		plateIdItem.setDisabled(true);
		__formItems.add(plateIdItem);
		
		companyIdItem = new TextItem("companyId", "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		companyIdItem.setDisabled(true);
		companyIdItem.setWidth("*");
		companyIdItem.setDefaultValue(ClientUtil.getCompanyId());
		__formItems.add(companyIdItem);
		
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setDisabled(true);
		projectCodeItem.setWidth("*");
		__formItems.add(projectCodeItem);
		
		ListGridField projectIdField = new ListGridField("projectId");
		ListGridField contractCodeField = new ListGridField("contractCode");
		ListGridField projectNameField = new ListGridField("projectName");
		ListGridField plateIdField = new ListGridField("plateId");
		
        projectIdItem = new ComboBoxItem("projectId", "项目名称");
        projectIdItem.setOptionDataSource(DSGetProjects.getInstance());
        projectIdItem.setChangeOnKeypress(false);
        projectIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
        projectIdItem.setValueField(projectIdField.getName());
        projectIdItem.setDisplayField(projectNameField.getName());
        projectIdItem.setPickListFields(contractCodeField, projectNameField, plateIdField);
        projectIdItem.setPickListWidth(600);
        projectIdItem.setRequired(true);
        projectIdItem.setWidth("*");
        projectIdItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				Record r = projectIdItem.getSelectedRecord();
				if(null != r) {
					projectCodeItem.setValue(r.getAttribute("contractCode"));
					projectNameItem.setValue(r.getAttribute("projectName"));
				}
			}
		});
        __formItems.add(projectIdItem);
		
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setDisabled(true);
		projectNameItem.setWidth("*");
		projectNameItem.hide();
		__formItems.add(projectNameItem);
		
		workHourItem = new TextItem("workHour", "工时");
		workHourItem.setWidth("*");
		workHourItem.setRequired(true);
		workHourItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				BigDecimal value = BaseHelpUtils.getBigDecimalValue(event.getValue());
				workHourItem.setValue(value.setScale(1, BigDecimal.ROUND_HALF_UP));
			}
		});
		__formItems.add(workHourItem);
		
		workDateItem = new DateItem("workDate", "日期");
		workDateItem.setWidth("*");
		workDateItem.setUseTextField(true);
		workDateItem.setUseMask(true);
		workDateItem.setRequired(true);
		__formItems.add(workDateItem);
		
		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setColSpan(4);
		remarkItem.setRowSpan(3);
		remarkItem.setRequired(true);
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		if(!__form.validate()) {
			SC.warn("请按照页面提示完善数据");
			return false;
		}
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSWorkingHourManage.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
