package com.pomplatform.client.workflow.personnelbusiness.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridEmployeeInDepartment;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridMyMainProjectValue;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridMyProjectValue;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridPreProjectValue;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridProjectValue;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSBusinessTripApply;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;
import com.smartgwt.client.widgets.grid.ListGridField;

public class BusinessTripApplyUpdateForm extends AbstractWizadPage
{


	private final TextItem personnelBusinessIdItem;
	private final SelectItem processTypeItem;
	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final SelectItem companyIdItem;
	private final TextItem typeItem;
	private final DateItem startDateItem;
	private final SelectItem startDateDetailItem;
	private final DateItem endDateItem;
	private final SelectItem endDateDetailItem;
	private final TextItem daysItem;
	private final TextItem reasonItem;
	private final TextAreaItem remarkItem;
	private final TextItem addressItem;
	private final TextAreaItem planItem;
	private final TextItem transportationItem;
	private final TextItem feeItem;
	private final TextItem unitItem;
	private final TextItem contactPersonItem;
	private final DateTimeItem createTimeItem;
	private final TextItem deleteFlagItem;
	private final SelectItem nextAuditorItem;
	private final SelectItem projectTypeItem;
	private final ComboBoxItem projectSelectItem;
	private final ComboBoxItem preProjectSelectItem;
	private Criteria ct = new Criteria();
	private final TextItem drafterItem;
	
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	
	private int processType ;

	public BusinessTripApplyUpdateForm(int processType) {
		this.processType = processType;
		boolean haveProject = processType == 18 ? true : false;
		//项目信息字段
		ListGridField projectIdField = new ListGridField("mainProjectId");
		projectIdField.setWidth(80);
		ListGridField projectCodeField = new ListGridField("projectCode");
		projectCodeField.setWidth(250);
		ListGridField projectNameField = new ListGridField("projectName");
		//前期项目信息字段
		ListGridField preProjectReimbursementNumberIdField = new ListGridField("preProjectReimbursementNumberId");
		ListGridField customNumberField = new ListGridField("infoCode");
		
		
		DSBusinessTripApply ds = DSBusinessTripApply.getInstance();
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
		employeeIdItem.setWidth("*");
		employeeIdItem.setDisabled(true);
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		__formItems.add(employeeIdItem);
		
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setWidth("*");
		employeeNoItem.setDisabled(true);
		__formItems.add(employeeNoItem);
		
		departmentIdItem = new TextItem("departmentId", "部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setDisabled(true);
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		__formItems.add(departmentIdItem);
		
		companyIdItem = new SelectItem("companyId", shouldNotBeNull + "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.setWidth("*");
		__formItems.add(companyIdItem);
		
		typeItem = new TextItem("type", "假期类型");
		typeItem.hide();
		__formItems.add(typeItem);
		
		startDateItem = new DateItem("startDate", shouldNotBeNull + "开始日期");
		startDateItem.setUseTextField(true);
		startDateItem.setUseMask(true);
		startDateItem.setWidth("*");
		__formItems.add(startDateItem);
		startDateItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				if(null != event.getValue() && null != endDateItem.getValue()){
					countDays((Date)event.getValue(), endDateItem.getValueAsDate(), startDateDetailItem.getValueAsString(), endDateDetailItem.getValueAsString(), event);
				}
			}
		});
		
		startDateDetailItem = new SelectItem("startDateDetail", shouldNotBeNull + "开始时段");
		startDateDetailItem.setWidth("*");
		startDateDetailItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_73"));
		__formItems.add(startDateDetailItem);
		startDateDetailItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				if(null != startDateItem.getValue() && null != endDateItem.getValue()){
					countDays(startDateItem.getValueAsDate(), endDateItem.getValueAsDate(), event.getValue().toString(), endDateDetailItem.getValueAsString(), event);
				}
			}
		});
		
		endDateItem = new DateItem("endDate", shouldNotBeNull + "结束日期");
		endDateItem.setUseTextField(true);
		endDateItem.setUseMask(true);
		endDateItem.setWidth("*");
		__formItems.add(endDateItem);
		endDateItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				if(null != startDateItem.getValue() && null != event.getValue()){
					countDays(startDateItem.getValueAsDate(), (Date)event.getValue(), startDateDetailItem.getValueAsString(), endDateDetailItem.getValueAsString(), event);
				}
			}
		});
		
		endDateDetailItem = new SelectItem("endDateDetail", shouldNotBeNull + "结束时段");
		endDateDetailItem.setWidth("*");
		endDateDetailItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_73"));
		__formItems.add(endDateDetailItem);
		endDateDetailItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				if(null != startDateItem.getValue() && null != endDateItem.getValue()){
					countDays(startDateItem.getValueAsDate(), endDateItem.getValueAsDate(), startDateDetailItem.getValueAsString(), event.getValue().toString(), event);
				}
			}
		});
		
		daysItem = new TextItem("days", "天数");
		daysItem.setWidth("*");
		daysItem.setDisabled(true);
		__formItems.add(daysItem);
		
		addressItem = new TextItem("address", shouldNotBeNull + "出差地址");
		addressItem.setWidth("*");
		__formItems.add(addressItem);
		
		transportationItem = new TextItem("transportation", shouldNotBeNull + "交通工具");
		transportationItem.setWidth("*");
		__formItems.add(transportationItem);
		
		feeItem = new TextItem("fee", "预计费用（元）");
		feeItem.setWidth("*");
		__formItems.add(feeItem);
		feeItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				if(null == event.getValue()){
					feeItem.setValue(0);
				}else if(!(event.getValue() instanceof Number)){
					event.cancel();
				}else{
					BigDecimal value = new BigDecimal(event.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
					feeItem.setValue(value);
				}
			}
		});
		
		projectTypeItem = new SelectItem("projectType", shouldNotBeNull + "选择出差类型(前期项目出差或项目出差)");
		projectTypeItem.setRequired(true);
		projectTypeItem.setWidth("*");
		projectTypeItem.setDefaultValue("1");
		projectTypeItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event){
					int projectType = BaseHelpUtils.getIntValue(event.getValue());
					if(projectType == 1){
						preProjectSelectItem.hide();
						projectSelectItem.show();
						nextAuditorItem.setDisabled(true);
						nextAuditorItem.clearValue();
						ct = new Criteria();
						nextAuditorItem.setPickListCriteria(ct);
						nextAuditorItem.fetchData();
					} else {
						preProjectSelectItem.show();
						projectSelectItem.hide();
						nextAuditorItem.setDisabled(false);
						nextAuditorItem.clearValue();
						ct.addCriteria("status", 0);
						ct.addCriteria("departmentId", 9);
						nextAuditorItem.setPickListCriteria(ct);
						nextAuditorItem.fetchData();
					}
				}
				
			}
		});
		LinkedHashMap<String, Object> projectTypeMap = new LinkedHashMap<>();
		projectTypeMap.put("1", "项目出差");
		projectTypeMap.put("2", "前期项目出差");
		projectTypeItem.setValueMap(projectTypeMap);
		if(haveProject)__formItems.add(projectTypeItem);
		
		preProjectSelectItem = new ComboBoxItem("preProjectSelect", shouldNotBeNull + "选择前期项目");
		preProjectSelectItem.hide();
		preProjectSelectItem.setRequired(true);
		preProjectSelectItem.setWidth("*");
		preProjectSelectItem.setOptionDataSource(DSSelectGridPreProjectValue.getInstance());
		preProjectSelectItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		preProjectSelectItem.setValueField(preProjectReimbursementNumberIdField.getName());
		preProjectSelectItem.setDisplayField(projectNameField.getName());
		preProjectSelectItem.setPickListFields(preProjectReimbursementNumberIdField, projectNameField, customNumberField);
		if(haveProject)__formItems.add(preProjectSelectItem);
		
		projectSelectItem = new ComboBoxItem("projectSelect", shouldNotBeNull + "选择项目");
		projectSelectItem.setRequired(true);
		projectSelectItem.setWidth("*");
		projectSelectItem.show();
		projectSelectItem.setOptionDataSource(DSSelectGridMyMainProjectValue.getInstance());
		projectSelectItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		projectSelectItem.setValueField(projectIdField.getName());
		projectSelectItem.setDisplayField(projectNameField.getName());
		projectSelectItem.setPickListFields(projectIdField, projectNameField, projectCodeField);
		projectSelectItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					Record selectRecord = projectSelectItem.getSelectedRecord();
					nextAuditorItem.setValue(selectRecord.getAttribute("projectManageId"));
				}
				
			}
		});
		if(haveProject)__formItems.add(projectSelectItem);
		
		
		ListGridField employeeIdField = new ListGridField("employeeId");
		ListGridField employeeNoField = new ListGridField("employeeNo");
		ListGridField employeeNameField = new ListGridField("employeeName");
		nextAuditorItem = new SelectItem("nextAuditor", shouldNotBeNull + "项目经理");
		nextAuditorItem.setRequired(true);
		nextAuditorItem.setWidth("*");
		nextAuditorItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		nextAuditorItem.setValueField("employeeId");
		nextAuditorItem.setDisplayField("employeeName");
		nextAuditorItem.setDisabled(true);
		nextAuditorItem.setOptionDataSource(DSSelectGridEmployeeInDepartment.getInstance());
		nextAuditorItem.setPickListFields(employeeIdField, employeeNoField, employeeNameField);
		if(haveProject)__formItems.add(nextAuditorItem);
		
		reasonItem = new TextItem("reason", shouldNotBeNull + "申请缘由");
		reasonItem.setWidth("*");
		__formItems.add(reasonItem);
		
		planItem = new TextAreaItem("plan", shouldNotBeNull + "行程安排");
		planItem.setColSpan(4);
		planItem.setRowSpan(3);
		planItem.setWidth("*");
		__formItems.add(planItem);
		
		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setColSpan(4);
		remarkItem.setRowSpan(3);
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);
		
		unitItem = new TextItem("unit", "外访单位");
		unitItem.hide();
		__formItems.add(unitItem);
		
		contactPersonItem = new TextItem("contactPerson", "联系人");
		contactPersonItem.hide();
		__formItems.add(contactPersonItem);
		
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
//		nextAuditorItem.setColSpan(4);
		reasonItem.setColSpan(4);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) {
			Record record  = getRecord();
			Criteria ct1 = new Criteria();
			ct1.addCriteria("employeeId", record.getAttribute("employeeId"));
			projectSelectItem.setPickListCriteria(ct1);
			__form.editRecord(record);
			if(record.getAttributeAsInt("projectType") == 1){
				preProjectSelectItem.hide();
				projectSelectItem.show();
				projectSelectItem.setDefaultValue(record.getAttribute("projectId"));
				nextAuditorItem.setDisabled(true);
				nextAuditorItem.setPickListCriteria(ct);
			} else {
				preProjectSelectItem.show();
				projectSelectItem.hide();
				preProjectSelectItem.setDefaultValue(record.getAttribute("projectId"));
				nextAuditorItem.setDisabled(false);
				ct.addCriteria("status", 0);
				ct.addCriteria("departmentId", 9);
				nextAuditorItem.setPickListCriteria(ct);
			}
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSBusinessTripApply.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		if(this.processType == 18){
			if(preProjectSelectItem.isVisible() && null != preProjectSelectItem.getValue() && null != preProjectSelectItem.getDisplayValue()){
				if(preProjectSelectItem.getValue().toString().equals(preProjectSelectItem.getDisplayValue().toString())){
					preProjectSelectItem.clearValue();
				}
			}
		}
		return __form.validate();
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map valueMap = __form.getValues();
		if(this.processType == 18){
			if(BaseHelpUtils.getIntValue(valueMap, "projectType") == 1){
				Record record = projectSelectItem.getSelectedRecord();
				if(null != record){
					valueMap.put("projectId", record.getAttribute("mainProjectId"));
					valueMap.put("projectName", record.getAttribute("projectName"));
					valueMap.put("projectCode", record.getAttribute("projectCode"));
				}
				
			} else {
				Record record = preProjectSelectItem.getSelectedRecord();
				if(null != record){
					valueMap.put("projectId", record.getAttribute("preProjectReimbursementNumberId"));
					valueMap.put("projectName", record.getAttribute("projectName"));
					valueMap.put("projectCode", record.getAttribute("customNumber"));
				}
			}
		}
		return valueMap;
	}

	private void countDays(Date startDate, Date endDate, String startDateDetail, String endDateDetail, ChangeEvent event){
		if(null!=startDate && null != endDate){
			long times = endDate.getTime()-startDate.getTime();
			if((times < 0) || (times == 0 && !startDateDetail.equals("0") && endDateDetail.equals("0"))){
				SC.say("开始日期必须早于截止日期");
				event.cancel();
			}else{
				Map<String, Object> params = getValuesAsMap();
				params.put("optType", "calculateTripDays");
				params.put("startDate", startDate);
				params.put("endDate", endDate);
				params.put("startDateDetail", startDateDetail);
				params.put("endDateDetail", endDateDetail);
				DBDataSource.callOperation("EP_MyPersonnelProcessor", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							Record record = dsResponse.getData()[0];
							daysItem.setValue(record.getAttribute("days"));
						}else{
							ClientUtil.displayErrorMessage(dsResponse);
							event.cancel();
						}
					}
				});
//				double startDays = 1;
//				double endDays = 0.5;
//				if(!startDateDetail.equals("0")){
//					startDays = 0.5;
//				}
//				if(!endDateDetail.equals("0")){
//					endDays = 0;
//				}
//				double days = times / 1000 / 3600 / 24;
//				days += startDays - endDays;
//				daysItem.setValue(days);
			}
		}
	}
}
