package com.pomplatform.client.workinghour.form;

import java.math.BigDecimal;
import java.util.*;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.project.datasource.DSGetProjects;
import com.pomplatform.client.workinghour.datasource.DSWorkingHourManage;

public class WorkingHourManageUpdateForm extends AbstractWizadPage
{


	private final TextItem workingHourIdItem;
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
	private final SelectItem plateIdItem;
	private final TextItem companyIdItem;
	private final TextItem workHourItem;
	private final DateItem workDateItem;
	private final TextAreaItem remarkItem;
	private final CheckboxItem isLockItem;

	public WorkingHourManageUpdateForm() {
		DSWorkingHourManage ds = DSWorkingHourManage.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		workingHourIdItem = new TextItem("workingHourId", "我的工时编码");
		workingHourIdItem.setDisabled(true);
		workingHourIdItem.setRequired(true);
		workingHourIdItem.hide();
		IsIntegerValidator workingHourIdValidator = new IsIntegerValidator();
		workingHourIdItem.setValidators(workingHourIdValidator);
		__formItems.add(workingHourIdItem);
		
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		employeeNoItem.setDisabled(true);
		__formItems.add(employeeNoItem);

		employeeIdItem = new TextItem("employeeId", "员工姓名");
		employeeIdItem.setDisabled(true);
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		__formItems.add(employeeIdItem);
		
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		employeeNameItem.hide();
		employeeNameItem.setDisabled(true);
		__formItems.add(employeeNameItem);
		
		departmentIdItem = new SelectItem("departmentId", "归属部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.hide();
		__formItems.add(departmentIdItem);
		
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		plateIdItem.setWidth("*");
		plateIdItem.setDisabled(true);
		__formItems.add(plateIdItem);
		
		companyIdItem = new TextItem("companyId", "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		companyIdItem.setDisabled(true);
		companyIdItem.setWidth("*");
		__formItems.add(companyIdItem);
		
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setDisabled(true);
		projectCodeItem.setWidth("*");
		__formItems.add(projectCodeItem);
		
//		ListGridField projectIdField = new ListGridField("projectId");
//		ListGridField contractCodeField = new ListGridField("contractCode");
//		ListGridField projectNameField = new ListGridField("projectName");
//		ListGridField plateIdField = new ListGridField("plateId");
		
        projectIdItem = new ComboBoxItem("projectId", "项目名称");
//        projectIdItem.setOptionDataSource(DSGetProjects.getInstance());
		projectIdItem.setValueMap(KeyValueManager.getValueMap("main_projects_name"));
//        projectIdItem.setChangeOnKeypress(false);
//        projectIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
//        projectIdItem.setValueField(projectIdField.getName());
//        projectIdItem.setDisplayField(projectNameField.getName());
//        projectIdItem.setPickListFields(contractCodeField, projectNameField, plateIdField);
        projectIdItem.setPickListWidth(600);
        projectIdItem.setRequired(true);
        projectIdItem.setWidth("*");
        projectIdItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				int projectId = BaseHelpUtils.getIntValue(projectIdItem.getValue());
				if(projectId>0) {
					Map<String, Object> map = new HashMap<>();
					map.put("mainProjectId",projectId);
					DBDataSource.callOperation("ST_MainProject", "find", map, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
								Record data = dsResponse.getData()[0];
								projectNameItem.setValue(data.getAttribute("projectName"));
								projectCodeItem.setValue(data.getAttribute("projectCode"));
							}
						}
					});

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
		workDateItem.setDisabled(true);
		workDateItem.setUseMask(true);
		workDateItem.setRequired(true);
		__formItems.add(workDateItem);
		
		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setColSpan(4);
		remarkItem.setRowSpan(3);
		remarkItem.setRequired(true);
		remarkItem.setDisabled(true);
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);
		
		isLockItem = new CheckboxItem("isLock", "是否锁定");
		isLockItem.hide();
		__formItems.add(isLockItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSWorkingHourManage.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
