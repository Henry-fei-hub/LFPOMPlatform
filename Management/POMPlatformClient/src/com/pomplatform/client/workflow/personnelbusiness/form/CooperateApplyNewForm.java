package com.pomplatform.client.workflow.personnelbusiness.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.project.datasource.DSGetProjects;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridMyMainProjectValue;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSCooperateApply;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.PickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

public class CooperateApplyNewForm extends AbstractWizadPage
{
	private final VLayout mainLayout;
	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final TextItem companyIdItem;
	/**
	 * 项目名称
	 */
	private final ComboBoxItem projectIdItem;
	/**
	 * 项目编号
	 */
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	/**
	 * 专业
	 */
	private final SelectItem projectTypeItem;
	/**
	 * 配合部门
	 */
	private final PickTreeItem typeItem;
	/**
	 * 提交时间
	 */
	private final DateTimeItem startDateItem;
	/**
	 * 产值
	 */
	private final TextItem subTypeItem;
	/**
	 * 配合内容
	 */
	private final TextAreaItem reasonItem;
	/**
	 * 申请内容
	 */
//	private final TextAreaItem remarkItem;
	private final TextItem drafterItem;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";

	public CooperateApplyNewForm() {
		mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.setBackgroundColor("#f2f2f2");
		mainLayout.setLayoutLeftMargin(30);
		mainLayout.setLayoutRightMargin(30);
		mainLayout.setLayoutTopMargin(15);
		
		DSCooperateApply ds = DSCooperateApply.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		drafterItem = new TextItem("drafter", "起草人");
		drafterItem.setDefaultValue(ClientUtil.getUserId());
		drafterItem.hide();
		__formItems.add(drafterItem);
		
		employeeIdItem = new TextItem("employeeId", shouldNotBeNull + "申请人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setDisabled(true);
		employeeIdItem.setWidth("*");
		employeeIdItem.setDefaultValue(ClientUtil.getUserId());
		__formItems.add(employeeIdItem);
		
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setDisabled(true);
		employeeNoItem.setWidth("*");
		employeeNoItem.setDefaultValue(ClientUtil.getUserNo());
		employeeNoItem.hide();
		__formItems.add(employeeNoItem);
		
		departmentIdItem = new TextItem("departmentId", shouldNotBeNull + "部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setDisabled(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setDefaultValue(ClientUtil.getDepartmentId());
		__formItems.add(departmentIdItem);
		
		companyIdItem = new TextItem("companyId", shouldNotBeNull + "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		companyIdItem.setDisabled(true);
		companyIdItem.setWidth("*");
		companyIdItem.setDefaultValue(ClientUtil.getCompanyId());
		__formItems.add(companyIdItem);
		
		projectCodeItem = new TextItem("projectCode", shouldNotBeNull + "项目编号");
		projectCodeItem.setDisabled(true);
		projectCodeItem.setWidth("*");
		__formItems.add(projectCodeItem);
		
		ListGridField projectIdField = new ListGridField("mainProjectId");
		projectIdField.setWidth(80);
		ListGridField projectCodeField = new ListGridField("projectCode");
		projectCodeField.setWidth(250);
		ListGridField projectNameField = new ListGridField("projectName");
		
        projectIdItem = new ComboBoxItem("projectId", shouldNotBeNull + "项目名称");
        projectIdItem.setOptionDataSource(DSSelectGridMyMainProjectValue.getInstance());
        projectIdItem.setChangeOnKeypress(false);
        projectIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
        projectIdItem.setValueField(projectIdField.getName());
        projectIdItem.setDisplayField(projectNameField.getName());
        projectIdItem.setPickListFields(projectCodeField, projectNameField);
        projectIdItem.setPickListWidth(600);
        projectIdItem.setRequired(true);
        projectIdItem.setWidth("*");
        projectIdItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				Record r = projectIdItem.getSelectedRecord();
				if(null != r) {
					projectCodeItem.setValue(r.getAttribute("projectCode"));
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
		
		projectTypeItem = new SelectItem("projectType", shouldNotBeNull + "专业");
		projectTypeItem.setValueMap(KeyValueManager.getValueMap("pm_specials"));
		projectTypeItem.setWidth("*");
		projectTypeItem.setRequired(true);
		__formItems.add(projectTypeItem);
		
		typeItem = new PickTreeItem("type", shouldNotBeNull + "配合部门");
		typeItem.setValueTree(KeyValueManager.getTree("departments"));
		typeItem.setWidth("*");
		typeItem.setRequired(true);
		typeItem.setValueField("treeId");
		typeItem.setCanSelectParentItems(true);
		__formItems.add(typeItem);
		
		subTypeItem = new TextItem("subType", shouldNotBeNull + "产值");
		subTypeItem.setWidth("*");
		subTypeItem.setRequired(true);
		__formItems.add(subTypeItem);
		
		startDateItem = new DateTimeItem("startDate", shouldNotBeNull + "提交时间");
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);
		startDateItem.setUseMask(true);
		startDateItem.setRequired(true);
		__formItems.add(startDateItem);
		
		reasonItem = new TextAreaItem("reason", shouldNotBeNull + "配合内容");
		reasonItem.setColSpan(3);
		reasonItem.setRowSpan(3);
		reasonItem.setWidth("*");
		reasonItem.setRequired(true);
		__formItems.add(reasonItem);
		
//		remarkItem = new TextAreaItem("remark", shouldNotBeNull + "申请内容");
//		remarkItem.setColSpan(3);
//		remarkItem.setRowSpan(3);
//		remarkItem.setRequired(true);
//		remarkItem.setWidth("*");
//		__formItems.add(remarkItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(6);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		__form.setCellPadding(10);
		reasonItem.setColSpan(6);
//		remarkItem.setColSpan(6);
		mainLayout.addMember(__form);

		addMember(mainLayout);
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
		manager.setDataSource(DSCooperateApply.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}

}
