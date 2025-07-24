package com.pomplatform.client.project.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.data.RoleDefinition;
import com.pomplatform.client.project.datasource.DSOnDevelopProject;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;
import com.smartgwt.client.widgets.form.validator.IsStringValidator;
import com.smartgwt.client.widgets.form.validator.LengthRangeValidator;

public class OnDevelopProjectUpdateForm extends AbstractWizadPage
{


	private final SelectItem projectIdItem;
	private final TextItem contractCodeItem;
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final SelectItem plateIdItem;
	private final SelectItem projectLevelItem;
	private final SelectItem businessTypeItem;
	private final SelectItem projectTypeItem;
	private final DoubleItem projectIntegralItem;
	private final DateItem startDateItem;
	private final DateTimeItem createTimeItem;
	private final IPickTreeItem departmentIdItem;
	private final ComboBoxItem plateManagerIdItem;
	private final ComboBoxItem departmentManagerIdItem;
	private final ComboBoxItem projectManageIdItem;
	private final TextAreaItem remarkItem;

	public OnDevelopProjectUpdateForm() {
		DSOnDevelopProject ds = DSOnDevelopProject.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		projectIdItem = new SelectItem("projectId", "项目编码");
		projectIdItem.hide();
//		KeyValueManager.loadValueMap("projects",projectIdItem);
		KeyValueManager.loadValueMap("projects", projectIdItem);
		projectIdItem.setDisabled(true);
		projectIdItem.setRequired(true);
		IsIntegerValidator projectIdValidator = new IsIntegerValidator();
		projectIdItem.setValidators(projectIdValidator);
		__formItems.add(projectIdItem);
		contractCodeItem = new TextItem("contractCode", "项目编号");
		contractCodeItem.setDisabled(true);
		contractCodeItem.setWidth("*");
		__formItems.add(contractCodeItem);
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.hide();
		__formItems.add(projectCodeItem);
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		__formItems.add(projectNameItem);
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setDisabled(true);
		plateIdItem.setWidth("*");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		__formItems.add(plateIdItem);
		projectLevelItem = new SelectItem("projectLevel", "项目等级");
		projectLevelItem.setWidth("*");
		projectLevelItem.hide();
		projectLevelItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));
		__formItems.add(projectLevelItem);
		businessTypeItem = new SelectItem("businessType", "业务类别");
		businessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		businessTypeItem.setWidth("*");
		businessTypeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				//获取变化后的值
				int businessType = BaseHelpUtils.getIntValue(event.getValue());
				//获取业务部门
				int plateId = BaseHelpUtils.getIntValue(plateIdItem.getValue());
				//获取项目类型
				int projectType = BaseHelpUtils.getIntValue(projectTypeItem.getValue());
				Map<String,Object> param = new HashMap<>();
				param.put("optType","onLoadProjectCode");
				param.put("plateId", plateId);
				param.put("businessType", businessType);
				param.put("projectType", projectType);
				param.put("projectFlag", getRecord()==null?1:getRecord().getAttribute("projectFlag"));
				param.put("projectCode",getRecord()==null?"":getRecord().getAttribute("contractCode"));
				//加载项目编码
				DBDataSource.callOperation("EP_OnProjectCommonProcess", "load",param, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							Record record = dsResponse.getData()[0];
							//获取编码
							String contractCode = record.getAttribute("projectCode");
							contractCodeItem.setValue(contractCode);
						}
					}
				});
			}
		});
		__formItems.add(businessTypeItem);
		projectTypeItem = new SelectItem("projectType", "项目类别");
		projectTypeItem.setWidth("*");
		projectTypeItem.setDisabled(true);
		projectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
		__formItems.add(projectTypeItem);
		projectIntegralItem = new DoubleItem("projectIntegral", "项目积分");
		projectIntegralItem.setWidth("*");
		__formItems.add(projectIntegralItem);
		startDateItem = new DateItem("startDate", "立项日期");
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);
		startDateItem.setDisabled(true);
		startDateItem.setDefaultValue(new Date());
		__formItems.add(startDateItem);
		createTimeItem = new DateTimeItem("createTime", "操作时间");
		createTimeItem.setWidth("*");
		createTimeItem.setDisabled(true);
		createTimeItem.setDefaultValue(new Date());
		__formItems.add(createTimeItem);
		departmentIdItem = new IPickTreeItem("departmentId", "归属部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		__formItems.add(departmentIdItem);
		plateManagerIdItem = new ComboBoxItem("plateManagerId", "事业部负责人");
		plateManagerIdItem.setWidth("*");
		plateManagerIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		RoleDefinition.setEmployeeItemValueMapByRoleId(plateManagerIdItem, 2);
		__formItems.add(plateManagerIdItem);
		departmentManagerIdItem = new ComboBoxItem("departmentManagerId", "部门经理");
		departmentManagerIdItem.setDisabled(true);
		departmentManagerIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		departmentManagerIdItem.setDefaultValue(ClientUtil.getEmployeeId());
		departmentManagerIdItem.setWidth("*");
		departmentManagerIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		__formItems.add(departmentManagerIdItem);
		projectManageIdItem = new ComboBoxItem("projectManageId", "专业负责人");
		projectManageIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		projectManageIdItem.setWidth("*");
		RoleDefinition.setProjectManagerItemValueMap(projectManageIdItem,0);
		__formItems.add(projectManageIdItem);
		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setWidth("*");
		remarkItem.setRowSpan(3);
		remarkItem.setColSpan(4);
		remarkItem.setRequired(true);
		IsStringValidator remarkValidator = new IsStringValidator();
		LengthRangeValidator remarkLengthValidator = new LengthRangeValidator();
		remarkLengthValidator.setMax(512);
		remarkItem.setValidators(remarkValidator, remarkLengthValidator);
		__formItems.add(remarkItem);

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
		manager.setDataSource(DSOnDevelopProject.getInstance());
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
