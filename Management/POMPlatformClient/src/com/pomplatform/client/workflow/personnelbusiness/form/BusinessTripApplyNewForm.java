package com.pomplatform.client.workflow.personnelbusiness.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridMyMainProjectValue;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridPreProjectValue;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSBusinessTripApply;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

public class BusinessTripApplyNewForm extends AbstractWizadPage
{
private static final Logger logger = Logger.getLogger("");

	private final VLayout mainLayout;
	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final SelectItem companyIdItem;
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
	private final ComboBoxItem nextAuditorItem;
	private final SelectItem projectTypeItem;
	private final ComboBoxItem projectSelectItem;
	private final ComboBoxItem preProjectSelectItem;
	private Criteria ct = new Criteria();
	private final TextItem drafterItem;
//	private final ComboBoxItem projectIdItem;
//	private final TextItem projectNameItem;
//	private final TextItem projectCodeItem;
	
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	
	private int processType ;

	public BusinessTripApplyNewForm(int processType) {
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
		
		mainLayout = new VLayout();
		DSBusinessTripApply ds = DSBusinessTripApply.getInstance();
		__form.setWidth100();
		__form.setHeight100();
//		__form.setMargin(5);
		
		drafterItem = new TextItem("drafter", "起草人");
		drafterItem.setDefaultValue(ClientUtil.getUserId());
		drafterItem.hide();
		__formItems.add(drafterItem);
		
		employeeIdItem = new TextItem("employeeId", "申请人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setDefaultValue(ClientUtil.getUserId());
		employeeIdItem.setWidth("*");
		employeeIdItem.setDisabled(true);
		__formItems.add(employeeIdItem);
		
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setDefaultValue(ClientUtil.getUserNo());
		employeeNoItem.setWidth("*");
		employeeNoItem.setDisabled(true);
		__formItems.add(employeeNoItem);
		
		departmentIdItem = new TextItem("departmentId", "部门");
		departmentIdItem.setDefaultValue(ClientUtil.getDepartmentId());
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setWidth("*");
		departmentIdItem.setDisabled(true);
		__formItems.add(departmentIdItem);
		
		companyIdItem = new SelectItem("companyId", shouldNotBeNull + "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.setRequired(true);
		companyIdItem.setWidth("*");
		companyIdItem.setDefaultValue(ClientUtil.getCompanyId());
		__formItems.add(companyIdItem);
		
		startDateItem = new DateItem("startDate", shouldNotBeNull + "开始日期");
		startDateItem.setRequired(true);
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
		startDateDetailItem.setRequired(true);
		startDateDetailItem.setDefaultValue(0);
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
		endDateItem.setRequired(true);
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
		endDateDetailItem.setRequired(true);
		endDateDetailItem.setDefaultValue(0);
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
		addressItem.setRequired(true);
		addressItem.setWidth("*");
		__formItems.add(addressItem);
		
		transportationItem = new TextItem("transportation", shouldNotBeNull + "交通工具");
		transportationItem.setRequired(true);
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
						/*nextAuditorItem.setDisabled(true);
						nextAuditorItem.clearValue();*/
						ct = new Criteria();
						/*nextAuditorItem.setPickListCriteria(ct);
						nextAuditorItem.fetchData();*/
					} else {
						preProjectSelectItem.show();
						projectSelectItem.hide();
						/*nextAuditorItem.setDisabled(false);
						nextAuditorItem.clearValue();*/
						ct.addCriteria("status", 0);
						ct.addCriteria("departmentId", 9);
						/*nextAuditorItem.setPickListCriteria(ct);
						nextAuditorItem.fetchData();*/
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
		
		
		Criteria ct = new Criteria();
//		ct.addCriteria("employeeId", ClientUtil.getUserId());
		projectSelectItem = new ComboBoxItem("projectSelect", shouldNotBeNull + "选择项目");
		projectSelectItem.setPickListCriteria(ct);
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
//					nextAuditorItem.setValue(selectRecord.getAttribute("projectManageId"));
				}
				
			}
		});
		if(haveProject)__formItems.add(projectSelectItem);
		

		nextAuditorItem = new ComboBoxItem("nextAuditor", shouldNotBeNull + "工作接手人");
		nextAuditorItem.setRequired(true);
		nextAuditorItem.setWidth("*");
		nextAuditorItem.setValueMap(KeyValueManager.getValueMap("employees"));
		__formItems.add(nextAuditorItem);


		reasonItem = new TextItem("reason", shouldNotBeNull + "申请缘由");
		reasonItem.setRequired(true);
		reasonItem.setWidth("*");
		__formItems.add(reasonItem);
		
		planItem = new TextAreaItem("plan", shouldNotBeNull + "行程安排");
		planItem.setRequired(true);
		planItem.setColSpan(4);
		planItem.setRowSpan(3);
		planItem.setWidth("*");
		__formItems.add(planItem);
		
		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setColSpan(4);
		remarkItem.setRowSpan(3);
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);
		
		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
//		nextAuditorItem.setColSpan(4);
		reasonItem.setColSpan(4);
		mainLayout.addMember(__form);
//		Label label = new Label("<font style=\"font-weight:bold\">温馨提示：以<font style=\"color:#FF7F27\">开始日期</font>的月份为准，该月份的加班/外出/出差申请须在次月5日前（包括次月5日）提出申请</font>");
//		mainLayout.addMember(label);
		addMember(mainLayout);
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
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSBusinessTripApply.getInstance());
		manager.addMember(__form);
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
