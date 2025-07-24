package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.project.datasource.DSGetProjects;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridMyMainProjectValue;
import com.pomplatform.client.workflow.datasource.DSSelectGridEmployeeValues;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSFillcheckApply;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSOutputDrawing;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.BooleanItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

public class OutputDrawingNewForm extends AbstractWizadPage
{
	private final VLayout mainLayout;
	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final TextItem companyIdItem;
	/**
	 * 出图类型
	 */
	private final SelectItem typeItem;
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
	 * 版本
	 */
	private final SelectItem startDateDetailItem;
	/**
	 * 日期
	 */
	private final DateItem startDateItem;
	/**
	 * 图纸张数
	 */
	private final IntegerItem companyProvinceItem;
	/**
	 * 图纸份数
	 */
	private final IntegerItem targetProvinceItem;
	/**
	 * 是否盖章签名
	 */
	private final BooleanItem isRemoteCityItem;
	/**
	 * 变更编号
	 */
	private final TextItem subTypeItem;
	/**
	 * 替换原变更号
	 */
	private final TextItem subTypeStrItem;
	/**
	 * 校对
	 */
	private final ComboBoxItem linkIdItem;
	/**
	 * 审核
	 */
	private final ComboBoxItem nextAuditorItem;
	/**
	 * 目的
	 */
	private final TextAreaItem reasonItem;
	/**
	 * 出图备注
	 */
	private final TextAreaItem remarkItem;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private static final Logger logger = Logger.getLogger("");
	private final TextItem drafterItem;

	public OutputDrawingNewForm() {
		mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.setBackgroundColor("#f2f2f2");
		mainLayout.setLayoutLeftMargin(30);
		mainLayout.setLayoutRightMargin(30);
		mainLayout.setLayoutTopMargin(15);
		
		IsIntegerValidator integerValidator = new IsIntegerValidator();
		
		DSOutputDrawing ds = DSOutputDrawing.getInstance();
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
//		employeeIdItem.setTextBoxStyle("customInputTextStyle");
		employeeIdItem.setDefaultValue(ClientUtil.getUserId());
		__formItems.add(employeeIdItem);
		
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setDisabled(true);
		employeeNoItem.setWidth("*");
		employeeNoItem.setDefaultValue(ClientUtil.getUserNo());
//		employeeNoItem.setTextBoxStyle("customInputTextStyle");
		employeeNoItem.hide();
		__formItems.add(employeeNoItem);
		
		departmentIdItem = new TextItem("departmentId", shouldNotBeNull + "部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setDisabled(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setDefaultValue(ClientUtil.getDepartmentId());
//		departmentIdItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(departmentIdItem);
		
		companyIdItem = new TextItem("companyId", shouldNotBeNull + "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		companyIdItem.setDisabled(true);
		companyIdItem.setWidth("*");
		companyIdItem.setDefaultValue(ClientUtil.getCompanyId());
//		companyIdItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(companyIdItem);
		
		//项目信息字段
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
        projectIdItem.setPickListFields(projectIdField, projectNameField, projectCodeField);
        projectIdItem.setPickListWidth(600);
//        projectIdItem.setControlStyle("customInputTextStyle");
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
        
        projectCodeItem = new TextItem("projectCode", shouldNotBeNull + "项目编号");
        projectCodeItem.setDisabled(true);
        projectCodeItem.setWidth("*");
//        projectCodeItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(projectCodeItem);
		
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setDisabled(true);
		projectNameItem.setWidth("*");
//		projectNameItem.setTextBoxStyle("customInputTextStyle");
		projectNameItem.hide();
		__formItems.add(projectNameItem);
		
		projectTypeItem = new SelectItem("projectType", shouldNotBeNull + "专业");
		projectTypeItem.setValueMap(KeyValueManager.getValueMap("pm_specials"));
		projectTypeItem.setWidth("*");
//		projectTypeItem.setControlStyle("customInputTextStyle");
		projectTypeItem.setRequired(true);
		__formItems.add(projectTypeItem);
		
		typeItem = new SelectItem("type", shouldNotBeNull + "出图类型");
		typeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_239"));
		typeItem.setWidth("*");
//		typeItem.setControlStyle("customInputTextStyle");
		typeItem.setRequired(true);
		typeItem.setDefaultValue(1);
		typeItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				hideOrShowSpecificItems();
			}
		});
		__formItems.add(typeItem);
		
		startDateDetailItem = new SelectItem("startDateDetail", shouldNotBeNull + "版本");
		startDateDetailItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_242"));
		startDateDetailItem.setWidth("*");
//		dutyIdItem.setControlStyle("customInputTextStyle");
		startDateDetailItem.setRequired(true);
		__formItems.add(startDateDetailItem);
		
		startDateItem = new DateItem("startDate", shouldNotBeNull + "日期");
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);
		startDateItem.setUseMask(true);
//		startDateItem.setTextBoxStyle("customInputTextStyle");
		startDateItem.setRequired(true);
		__formItems.add(startDateItem);
		
		companyProvinceItem = new IntegerItem("companyProvince", shouldNotBeNull + "图纸张数");
		companyProvinceItem.setWidth("*");
//		companyProvinceItem.setTextBoxStyle("customInputTextStyle");
		companyProvinceItem.setRequired(true);
		companyProvinceItem.setValidators(integerValidator);
		__formItems.add(companyProvinceItem);
		
		targetProvinceItem = new IntegerItem("targetProvince", shouldNotBeNull + "图纸份数");
		targetProvinceItem.setWidth("*");
//		targetProvinceItem.setTextBoxStyle("customInputTextStyle");
		targetProvinceItem.setValidators(integerValidator);
		targetProvinceItem.setRequired(true);
		__formItems.add(targetProvinceItem);
		
		isRemoteCityItem = new BooleanItem("isRemoteCity", shouldNotBeNull + "是否盖章签名");
		isRemoteCityItem.setDefaultValue(false);
		__formItems.add(isRemoteCityItem);
		
		subTypeItem = new TextItem("subType", shouldNotBeNull + "变更编号");
		subTypeItem.setWidth("*");
//		subTypeItem.setTextBoxStyle("customInputTextStyle");
		subTypeItem.hide();
		__formItems.add(subTypeItem);
		
		subTypeStrItem = new TextItem("subTypeStr",  "替换原变更号");
		subTypeStrItem.setWidth("*");
//		subTypeStrItem.setTextBoxStyle("customInputTextStyle");
		subTypeStrItem.hide();
		__formItems.add(subTypeStrItem);
		
		
		ListGridField eNoField = new ListGridField("employeeNo");
		ListGridField eNameField = new ListGridField("employeeName");
		ListGridField departmentIdField = new ListGridField("departmentId");
		Criteria c = new Criteria();
		c.addCriteria("status", 0);
		
		linkIdItem = new ComboBoxItem("linkId", shouldNotBeNull + "校对");
		linkIdItem.setWidth("*");
		linkIdItem.setChangeOnKeypress(false);
		linkIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		linkIdItem.setOptionDataSource(DSSelectGridEmployeeValues.getInstance());
		linkIdItem.setOptionCriteria(c);
		linkIdItem.setValueField("employeeId");
		linkIdItem.setDisplayField("employeeName");
		linkIdItem.setPickListFields(eNoField, eNameField, departmentIdField);
//		linkIdItem.setControlStyle("customInputTextStyle");
		linkIdItem.setRequired(true);
		__formItems.add(linkIdItem);
		
		nextAuditorItem = new ComboBoxItem("nextAuditor", shouldNotBeNull + "审核");
		nextAuditorItem.setWidth("*");
		nextAuditorItem.setChangeOnKeypress(false);
		nextAuditorItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		nextAuditorItem.setOptionDataSource(DSSelectGridEmployeeValues.getInstance());
		nextAuditorItem.setOptionCriteria(c);
		nextAuditorItem.setValueField("employeeId");
		nextAuditorItem.setDisplayField("employeeName");
		nextAuditorItem.setPickListFields(eNoField, eNameField, departmentIdField);
//		nextAuditorItem.setControlStyle("customInputTextStyle");
		nextAuditorItem.setRequired(true);
		__formItems.add(nextAuditorItem);
		
		reasonItem = new TextAreaItem("reason", shouldNotBeNull + "目的");
		reasonItem.setColSpan(2);
		reasonItem.setRowSpan(3);
		reasonItem.setWidth("*");
		reasonItem.setRequired(true);
//		reasonItem.setTextBoxStyle("customTextAreaStyle");
		__formItems.add(reasonItem);
		
		remarkItem = new TextAreaItem("remark", "出图备注");
		remarkItem.setColSpan(2);
		remarkItem.setRowSpan(3);
		remarkItem.setWidth("*");
//		remarkItem.setTextBoxStyle("customTextAreaStyle");
		__formItems.add(remarkItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(6);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		__form.setCellPadding(10);
		reasonItem.setColSpan(6);
		remarkItem.setColSpan(6);
		mainLayout.addMember(__form);

		addMember(mainLayout);

//		FormItem[] items = __form.getFields();
//		int width = (mainLayout.getWidth()-30)/23*10;
//		int width2 = width * 7 / 10;
//		mainLayout.setLayoutLeftMargin(width * 3 / 10 + 10);
//		mainLayout.setLayoutRightMargin(0);
//		for(FormItem item : items){
//			item.setWidth(width2);
//		}
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
		manager.setDataSource(DSOutputDrawing.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}

	public void hideOrShowSpecificItems(){
		int type = BaseHelpUtils.getIntValue(typeItem.getValue());
		switch(type) {
		case ClientStaticUtils.OUTPUT_DRAWING_TYPE_1:
			targetProvinceItem.setRequired(true);
			targetProvinceItem.show();
			isRemoteCityItem.show();
			subTypeItem.setRequired(false);
			subTypeItem.hide();
			subTypeItem.clearValue();
			subTypeItem.clearErrors();
			subTypeStrItem.setRequired(false);
			subTypeStrItem.hide();
			subTypeStrItem.clearValue();
			subTypeStrItem.clearErrors();
			reasonItem.setTitle(shouldNotBeNull + "目的");
			remarkItem.show();
			break;
		case ClientStaticUtils.OUTPUT_DRAWING_TYPE_2:
			targetProvinceItem.setRequired(false);
			targetProvinceItem.hide();
			targetProvinceItem.clearValue();
			targetProvinceItem.clearErrors();
			isRemoteCityItem.hide();
			isRemoteCityItem.clearValue();
			subTypeItem.setRequired(false);
			subTypeItem.hide();
			subTypeItem.clearValue();
			subTypeItem.clearErrors();
			subTypeStrItem.setRequired(false);
			subTypeStrItem.hide();
			subTypeStrItem.clearValue();
			subTypeStrItem.clearErrors();
			reasonItem.setTitle(shouldNotBeNull + "目的");
			remarkItem.show();
			break;
		case ClientStaticUtils.OUTPUT_DRAWING_TYPE_3:
			targetProvinceItem.setRequired(true);
			targetProvinceItem.show();
			isRemoteCityItem.show();
			subTypeItem.setRequired(true);
			subTypeItem.show();
			subTypeStrItem.setRequired(false);
			subTypeStrItem.setTitle("替换原变更号");
			subTypeStrItem.show();
			reasonItem.setTitle(shouldNotBeNull + "变更内容描述");
			remarkItem.hide();
			remarkItem.clearValue();
			remarkItem.clearErrors();
			break;
		case ClientStaticUtils.OUTPUT_DRAWING_TYPE_4:
			targetProvinceItem.setRequired(false);
			targetProvinceItem.hide();
			targetProvinceItem.clearValue();
			targetProvinceItem.clearErrors();
			isRemoteCityItem.hide();
			isRemoteCityItem.clearValue();
			subTypeItem.setRequired(true);
			subTypeItem.show();
			subTypeStrItem.setRequired(false);
			subTypeStrItem.setTitle("替换原变更号");
			subTypeStrItem.show();
			reasonItem.setTitle(shouldNotBeNull + "变更内容描述");
			remarkItem.hide();
			remarkItem.clearValue();
			remarkItem.clearErrors();
			break;
		default:
			break;
		}
	}

}
