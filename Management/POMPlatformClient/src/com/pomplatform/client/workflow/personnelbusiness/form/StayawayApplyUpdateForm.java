package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.employee.datasource.DSSelectEmployee;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridMyMainProjectValue;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridMyProjectValue;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridPreProjectValue;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSStayawayApply;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

public class StayawayApplyUpdateForm extends AbstractWizadPage
{


	private final TextItem personnelBusinessIdItem;
	private final SelectItem processTypeItem;
	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final SelectItem companyIdItem;
	private final TextItem typeItem;
	private final DateTimeItem startDateItem;
//	private final SelectItem startDateDetailItem;
	private final DateTimeItem endDateItem;
//	private final SelectItem endDateDetailItem;
	private final TextItem daysItem;
	private final TextItem reasonItem;
	private final TextAreaItem remarkItem;
	private final TextItem addressItem;
	private final TextItem planItem;
	private final TextItem transportationItem;
	private final TextItem feeItem;
	private final TextItem unitItem;
	private final TextItem contactPersonItem;
	private final DateTimeItem createTimeItem;
	private final TextItem deleteFlagItem;
	private final ComboBoxItem projectSelectItem;
	private final ComboBoxItem preProjectSelectItem;
	private final ComboBoxItem nextAuditorItem;
	private final SelectItem projectTypeItem;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private String projectType1 = "1";//项目外出
	private String projectType2 = "2";//前期项目外出
	private String projectType3 = "3";//非项目外出
	private final TextItem drafterItem;
	private final VLayout mainLayout;

	public StayawayApplyUpdateForm() {

		mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.setBackgroundColor("#fff");
		mainLayout.setLayoutLeftMargin(30);
		mainLayout.setLayoutRightMargin(30);
		mainLayout.setLayoutTopMargin(15);
		
		DSStayawayApply ds = DSStayawayApply.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		drafterItem = new TextItem("drafter", "起草人");
		drafterItem.hide();
		__formItems.add(drafterItem);
		
		personnelBusinessIdItem = new TextItem("personnelBusinessId", "人事业务编码");
		personnelBusinessIdItem.setDisabled(true);
		personnelBusinessIdItem.setRequired(true);
		IsIntegerValidator personnelBusinessIdValidator = new IsIntegerValidator();
		personnelBusinessIdItem.setValidators(personnelBusinessIdValidator);
		personnelBusinessIdItem.hide();
		__formItems.add(personnelBusinessIdItem);
		
		processTypeItem = new SelectItem("processType", "流程类型");
		processTypeItem.setValueMap(KeyValueManager.getValueMap("system_process_types"));
		processTypeItem.hide();
		__formItems.add(processTypeItem);
		
		employeeIdItem = new TextItem("employeeId", "申请人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setDisabled(true);
		employeeIdItem.setWidth("*");
		employeeIdItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(employeeIdItem);
		
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setDisabled(true);
		employeeNoItem.setWidth("*");
		employeeNoItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(employeeNoItem);
		
		departmentIdItem = new TextItem("departmentId", "部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setDisabled(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(departmentIdItem);
		
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.hide();
		__formItems.add(companyIdItem);
		
		typeItem = new TextItem("type", "假期类型");
		typeItem.hide();
		__formItems.add(typeItem);
		
		daysItem = new TextItem("days", "外出小时数");
		daysItem.setWidth("*");
		daysItem.setDisabled(true);
		daysItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(daysItem);
		
		startDateItem = new DateTimeItem("startDate", shouldNotBeNull + "外出日期");
		startDateItem.setUseTextField(true);
		startDateItem.setUseMask(true);
		startDateItem.setWidth("*");
		startDateItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(startDateItem);
		startDateItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				if(null != event.getValue() && null != endDateItem.getValue()){
					countDays((Date)event.getValue(), endDateItem.getValueAsDate(), event);
				}
			}
		});
		
//		startDateDetailItem = new SelectItem("startDateDetail", shouldNotBeNull + "外出时段");
//		startDateDetailItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_73"));
//		startDateDetailItem.setWidth("*");
//		startDateDetailItem.setControlStyle("customInputTextStyle");
//		__formItems.add(startDateDetailItem);
//		startDateDetailItem.addChangeHandler(new ChangeHandler() {
//			@Override
//			public void onChange(ChangeEvent event) {
//				if(null != startDateItem.getValue() && null != endDateItem.getValue()){
//					countDays(startDateItem.getValueAsDate(), endDateItem.getValueAsDate(), event.getValue().toString(), endDateDetailItem.getValueAsString(), event);
//				}
//			}
//		});
		
		endDateItem = new DateTimeItem("endDate", shouldNotBeNull + "预期返回日期");
		endDateItem.setUseTextField(true);
		endDateItem.setUseMask(true);
		endDateItem.setWidth("*");
		endDateItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(endDateItem);
		endDateItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				if(null != startDateItem.getValue() && null != event.getValue()){
					countDays(startDateItem.getValueAsDate(), (Date)event.getValue(), event);
				}
			}
		});
		
//		endDateDetailItem = new SelectItem("endDateDetail", shouldNotBeNull + "预期返回时段");
//		endDateDetailItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_73"));
//		endDateDetailItem.setWidth("*");
//		endDateDetailItem.setControlStyle("customInputTextStyle");
//		__formItems.add(endDateDetailItem);
//		endDateDetailItem.addChangeHandler(new ChangeHandler() {
//			@Override
//			public void onChange(ChangeEvent event) {
//				if(null != startDateItem.getValue() && null != endDateItem.getValue()){
//					countDays(startDateItem.getValueAsDate(), endDateItem.getValueAsDate(), startDateDetailItem.getValueAsString(), event.getValue().toString(), event);
//				}
//			}
//		});
		
		projectTypeItem = new SelectItem("projectType", shouldNotBeNull + "外出类型");
		LinkedHashMap<String, String> projectTypeMap = new LinkedHashMap<>();
		projectTypeMap.put(projectType3, "非项目外出");
		projectTypeMap.put(projectType2, "前期项目外出");
		projectTypeMap.put(projectType1, "项目外出");
		projectTypeItem.setValueMap(projectTypeMap);
		projectTypeItem.setWidth("*");
		projectTypeItem.setControlStyle("customInputTextStyle");
		__formItems.add(projectTypeItem);
		projectTypeItem.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				if(null != event.getValue()){
					if(event.getValue().toString().equals(projectType1)){
						projectSelectItem.show();
						preProjectSelectItem.hide();
						nextAuditorItem.hide();
					}else if(event.getValue().toString().equals(projectType2)){
						projectSelectItem.hide();
						preProjectSelectItem.show();
						nextAuditorItem.show();
					}else{
						projectSelectItem.hide();
						preProjectSelectItem.hide();
						nextAuditorItem.hide();
					}
				}
			}
		});

		//项目信息字段
		ListGridField mainProjectIdField = new ListGridField("mainProjectId");
		ListGridField projectCodeField = new ListGridField("projectCode");
		projectCodeField.setWidth(250);
		ListGridField projectNameField = new ListGridField("projectName");
//		ListGridField projectManageIdField = new ListGridField("projectManageId");
//		projectManageIdField.setWidth(80);
		
		projectSelectItem = new ComboBoxItem("projectId", shouldNotBeNull + "请选择项目");
		projectSelectItem.setWidth("*");
		projectSelectItem.hide();
		projectSelectItem.setChangeOnKeypress(false);
		projectSelectItem.setOptionDataSource(DSSelectGridMyMainProjectValue.getInstance());
		projectSelectItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		projectSelectItem.setValueField(mainProjectIdField.getName());
		projectSelectItem.setDisplayField(projectNameField.getName());
		projectSelectItem.setPickListFields(projectNameField, projectCodeField);
		projectSelectItem.setPickListWidth(800);
		projectSelectItem.setControlStyle("customInputTextStyle");
		__formItems.add(projectSelectItem);
		
		//前期项目信息字段
		ListGridField preProjectReimbursementNumberIdField = new ListGridField("preProjectReimbursementNumberId");
		ListGridField customNumberField = new ListGridField("customNumber");
		preProjectSelectItem = new ComboBoxItem("preProjectSelect", shouldNotBeNull + "请选择前期项目");
		preProjectSelectItem.setControlStyle("customInputTextStyle");
		preProjectSelectItem.hide();
		preProjectSelectItem.setRequired(true);
		preProjectSelectItem.setWidth("*");
		preProjectSelectItem.setChangeOnKeypress(false);
		preProjectSelectItem.setOptionDataSource(DSSelectGridPreProjectValue.getInstance());
		preProjectSelectItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		preProjectSelectItem.setValueField(preProjectReimbursementNumberIdField.getName());
		preProjectSelectItem.setDisplayField(projectNameField.getName());
		preProjectSelectItem.setPickListFields(preProjectReimbursementNumberIdField, projectNameField, customNumberField);
		__formItems.add(preProjectSelectItem);
		
		ListGridField employeeNoField = new ListGridField("employeeNo");
		ListGridField employeeNameField = new ListGridField("employeeName");
		nextAuditorItem = new ComboBoxItem("nextAuditor", shouldNotBeNull + "项目经理");
		nextAuditorItem.setControlStyle("customInputTextStyle");
		nextAuditorItem.setRequired(true);
		nextAuditorItem.setWidth("*");
		nextAuditorItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		nextAuditorItem.setChangeOnKeypress(false);
		nextAuditorItem.setValueField("employeeId");
		nextAuditorItem.setDisplayField("employeeName");
		nextAuditorItem.hide();
		nextAuditorItem.setOptionDataSource(DSSelectEmployee.getInstance());
		nextAuditorItem.setPickListFields(employeeNoField, employeeNameField);
		__formItems.add(nextAuditorItem);

		unitItem = new TextItem("unit", "外访单位");
		unitItem.setWidth("*");
		unitItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(unitItem);
		
		contactPersonItem = new TextItem("contactPerson", "外访联系人");
		contactPersonItem.setWidth("*");
		contactPersonItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(contactPersonItem);
		
		addressItem = new TextItem("address", "外访地址");
		addressItem.setWidth("*");
		addressItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(addressItem);
		
		reasonItem = new TextItem("reason", shouldNotBeNull + "申请缘由");
		reasonItem.setWidth("*");
		reasonItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(reasonItem);
		
		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setColSpan(4);
		remarkItem.setRowSpan(3);
		remarkItem.setWidth("*");
		remarkItem.setTextBoxStyle("customTextAreaStyle");
		__formItems.add(remarkItem);
		
		planItem = new TextItem("plan", "计划安排");
		planItem.hide();
		__formItems.add(planItem);
		
		transportationItem = new TextItem("transportation", "交通工具");
		transportationItem.hide();
		__formItems.add(transportationItem);
		
		feeItem = new TextItem("fee", "预计费用");
		feeItem.hide();
		__formItems.add(feeItem);
		
		createTimeItem = new DateTimeItem("createTime", "起草时间");
		createTimeItem.hide();
		__formItems.add(createTimeItem);
		
		deleteFlagItem = new TextItem("deleteFlag", "删除状态  0未删除    1已删除");
		deleteFlagItem.hide();
		__formItems.add(deleteFlagItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		
		__form.setCellPadding(10);
		
		mainLayout.addMember(__form);
		
		addMember(mainLayout);
		
		FormItem[] items = __form.getFields();
		int width = (mainLayout.getWidth()-30)/23*10;
		int width2 = width * 7 / 10;
		mainLayout.setLayoutLeftMargin(width * 3 / 10 + 10);
		mainLayout.setLayoutRightMargin(0);
		for(FormItem item : items){
			item.setWidth(width2);
		}
	}

	@Override
	public void startEdit() {
		Record record = getRecord();
		if(null != record){
			__form.editRecord(record);
			if(null != record.getAttribute("projectType") && record.getAttribute("projectType").equals(projectType1)){
				projectSelectItem.show();
				preProjectSelectItem.hide();
				nextAuditorItem.hide();
				Criteria c = new Criteria();
//				c.addCriteria("employeeId", record.getAttribute("employeeId"));
				projectSelectItem.setPickListCriteria(c);
			}else if(null != record.getAttribute("projectType") && record.getAttribute("projectType").equals(projectType2)){
				Criteria ct = new Criteria();
				ct.addCriteria("status", 0);
				ct.addCriteria("plateId", record.getAttribute("numberOfBaby"));
				nextAuditorItem.setPickListCriteria(ct);
				projectSelectItem.hide();
				preProjectSelectItem.show();
				preProjectSelectItem.setValue(record.getAttribute("projectId"));
				nextAuditorItem.show();
			}else{
				projectSelectItem.hide();
				preProjectSelectItem.hide();
				nextAuditorItem.hide();
			}
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSStayawayApply.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		if(null == startDateItem.getValue()){
			SC.say("请填写外出日期");
			return false;
		}
		if(null == endDateItem.getValue()){
			SC.say("请填写预期返回日期");
			return false;
		}
		Date start = startDateItem.getValueAsDate();
		Date end = endDateItem.getValueAsDate();
		if(!(start.getYear() == end.getYear() && start.getMonth() == end.getMonth() && start.getDate() == end.getDate())){
			SC.say("外出申请时间范围不能跨天，如需跨天，请提出差申请");
			return false;
		}
		if(null == projectTypeItem.getValue()){
			SC.say("请选择外出类型");
			return false;
		}
		if(projectTypeItem.getValue().toString().equals("1") && null == projectSelectItem.getValue()){
			SC.say("项目外出请选择相关项目");
			return false;
		}
		if(projectTypeItem.getValue().toString().equals("2") && null == preProjectSelectItem.getValue()){
			SC.say("前期项目外出请选择相关项目");
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
		if(null != projectTypeItem.getValue() && projectTypeItem.getValue().toString().equals(projectType1)){
			//项目外出
			Record record = projectSelectItem.getSelectedRecord();
			if(null != record){
				map.put("projectName", record.getAttribute("projectName"));
				map.put("projectCode", record.getAttribute("projectCode"));
			}
		}else if(null != projectTypeItem.getValue() && projectTypeItem.getValue().toString().equals(projectType2)){
			//前期项目外出
			Record record = preProjectSelectItem.getSelectedRecord();
			if(null != record){
				map.put("projectId", record.getAttribute("preProjectReimbursementNumberId"));
				map.put("projectName", record.getAttribute("projectName"));
				map.put("projectCode", record.getAttribute("customNumber"));
			}
		}else{
			map.remove("projectId");
			map.remove("projectName");
			map.remove("projectCode");
		}
		return map;
	}

	private void countDays(Date startDate, Date endDate, ChangeEvent event){
		if(null!=startDate && null != endDate){
			Map<String, Object> params = getValuesAsMap();
			params.put("optType", "calculateDaysAndHours");
			params.put("startDate", startDate);
			params.put("endDate", endDate);
			DBDataSource.callOperation("EP_MyPersonnelProcessor", params, new DSCallback() {
				
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0){
						Record[] records = dsResponse.getData();
						for(Record record : records){
							int day = BaseHelpUtils.getIntValue(record.getAttribute("days"));
							if(day > 1 || (day == 1 && BaseHelpUtils.getIntValue(record.getAttribute("hours")) > 0)) {
								SC.say("外出申请的时间不能超过1天");
								event.cancel();
							}else if(day == 1) {
								daysItem.setValue(7.5);
							}else {
								daysItem.setValue(record.getAttribute("hours"));
							}
						}
					}else{
						ClientUtil.displayErrorMessage(dsResponse);
						event.cancel();
					}
					
				}
			});
		}
	}
	private static final Logger logger = Logger.getLogger("");
}
