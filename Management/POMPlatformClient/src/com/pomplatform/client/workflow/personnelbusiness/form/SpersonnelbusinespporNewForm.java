package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.Date;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridMyMainProjectValue;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSSpersonnelbusinesppor;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.FloatItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

public class SpersonnelbusinespporNewForm extends AbstractWizadPage {

	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final SelectItem companyIdItem;
	private final DateItem startDateItem;
	private final SelectItem startDateDetailItem;
	private final DateItem endDateItem;
	private final SelectItem endDateDetailItem;
	private final TextItem daysItem;
	private final TextAreaItem remarkItem;
	private final TextItem addressItem;
	private final TextItem contactPersonItem;
	private final ComboBoxItem nextAuditorItem;
	private final SelectItem projectIdItem;
//	private final CheckboxItem isRemoteCityItem;
//	private final CheckboxItem provideAccommodationItem;
//	private final FloatItem livingExpensesItem;
//	private final FloatItem housingFinanceItem;
	private final FloatItem feeItem;
	private final TextItem drafterItem;

	private final VLayout mainLayout;

	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";

	public SpersonnelbusinespporNewForm() {
		DSSpersonnelbusinesppor ds = DSSpersonnelbusinesppor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		// 项目信息字段
		ListGridField projectIdField = new ListGridField("mainProjectId");
		projectIdField.setWidth(80);
		ListGridField projectCodeField = new ListGridField("projectCode");
		projectCodeField.setWidth(250);
		ListGridField projectNameField = new ListGridField("projectName");
		
		mainLayout = new VLayout();
		
		drafterItem = new TextItem("drafter", "起草人");
		drafterItem.setDefaultValue(ClientUtil.getUserId());
		drafterItem.hide();
		__formItems.add(drafterItem);
		
		employeeIdItem = new TextItem("employeeId", "申请人");
		employeeIdItem.setRequired(true);
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setDefaultValue(ClientUtil.getUserId());
		employeeIdItem.setWidth("*");
		employeeIdItem.setDisabled(true);
		__formItems.add(employeeIdItem);

		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setRequired(true);
		employeeNoItem.setDefaultValue(ClientUtil.getUserNo());
		employeeNoItem.setWidth("*");
		employeeNoItem.setDisabled(true);
		__formItems.add(employeeNoItem);

		departmentIdItem = new TextItem("departmentId", "部门");
		departmentIdItem.setRequired(true);
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

		startDateItem = new DateItem("startDate", shouldNotBeNull + "驻场开始日期");
		startDateItem.setRequired(true);
		startDateItem.setUseTextField(true);
		startDateItem.setUseMask(true);
		startDateItem.setWidth("*");
		__formItems.add(startDateItem);
		startDateItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				if (null != event.getValue() && null != endDateItem.getValue()) {
					countDays((Date) event.getValue(), endDateItem.getValueAsDate(),
							startDateDetailItem.getValueAsString(), endDateDetailItem.getValueAsString(), event);
				}
			}
		});

		startDateDetailItem = new SelectItem("startDateDetail", shouldNotBeNull + "驻场开始时段");
		startDateDetailItem.setRequired(true);
		startDateDetailItem.setDefaultValue(0);
		startDateDetailItem.setWidth("*");
		startDateDetailItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_73"));
		__formItems.add(startDateDetailItem);
		startDateDetailItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				if (null != startDateItem.getValue() && null != endDateItem.getValue()) {
					countDays(startDateItem.getValueAsDate(), endDateItem.getValueAsDate(), event.getValue().toString(),
							endDateDetailItem.getValueAsString(), event);
				}
			}
		});

		endDateItem = new DateItem("endDate", shouldNotBeNull + "驻场结束日期");
		endDateItem.setRequired(true);
		endDateItem.setUseTextField(true);
		endDateItem.setUseMask(true);
		endDateItem.setWidth("*");
		__formItems.add(endDateItem);
		endDateItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				if (null != startDateItem.getValue() && null != event.getValue()) {
					countDays(startDateItem.getValueAsDate(), (Date) event.getValue(),
							startDateDetailItem.getValueAsString(), endDateDetailItem.getValueAsString(), event);
				}
			}
		});

		endDateDetailItem = new SelectItem("endDateDetail", shouldNotBeNull + "驻场结束时段");
		endDateDetailItem.setRequired(true);
		endDateDetailItem.setDefaultValue(0);
		endDateDetailItem.setWidth("*");
		endDateDetailItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_73"));
		__formItems.add(endDateDetailItem);
		endDateDetailItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				if (null != startDateItem.getValue() && null != endDateItem.getValue()) {
					countDays(startDateItem.getValueAsDate(), endDateItem.getValueAsDate(),
							startDateDetailItem.getValueAsString(), event.getValue().toString(), event);
				}
			}
		});

		daysItem = new TextItem("days", "天数");
		daysItem.setWidth("*");
		daysItem.setDisabled(true);
		__formItems.add(daysItem);

		addressItem = new TextItem("address", shouldNotBeNull + "驻场地址");
		addressItem.setRequired(true);
		addressItem.setWidth("*");
		__formItems.add(addressItem);
		
		
		Criteria ct = new Criteria();
//		ct.addCriteria("employeeId", ClientUtil.getUserId());
		
		projectIdItem = new SelectItem("projectId", shouldNotBeNull + "选择派驻项目");
		projectIdItem.setRequired(true);
		projectIdItem.setWidth("*");
		projectIdItem.setPickListCriteria(ct);
		projectIdItem.setOptionDataSource(DSSelectGridMyMainProjectValue.getInstance());
		projectIdItem.setChangeOnKeypress(false);
		projectIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		projectIdItem.setValueField(projectIdField.getName());
		projectIdItem.setDisplayField(projectNameField.getName());
		projectIdItem.setPickListFields(projectIdField, projectNameField, projectCodeField);
		projectIdItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					Record selectRecord = projectIdItem.getSelectedRecord();
					String employeeId = selectRecord.getAttribute("projectManageId");
					if(!BaseHelpUtils.isNullOrEmpty(employeeId)){
						nextAuditorItem.setValue(employeeId);
					}else {
						nextAuditorItem.clearValue();
					}
					
				}
				
			}
		});
		__formItems.add(projectIdItem);
		
		nextAuditorItem = new ComboBoxItem("nextAuditor", "项目经理(选择项目后自动带出)");
		nextAuditorItem.setWidth("*");
		nextAuditorItem.setDisabled(true);
		nextAuditorItem.hide();
		nextAuditorItem.setValueMap(KeyValueManager.getValueMap("employees"));
		nextAuditorItem.setChangeOnKeypress(false);
		nextAuditorItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
//		__formItems.add(nextAuditorItem);
		
		contactPersonItem = new TextItem("contactPerson", shouldNotBeNull + "派驻项目甲方名称");
		contactPersonItem.setWidth("*");
		contactPersonItem.setRequired(true);
		__formItems.add(contactPersonItem);
		
//		livingExpensesItem = new FloatItem("livingExpenses", shouldNotBeNull + "生活费用(元/月)");
//		livingExpensesItem.setWidth("*");
//		livingExpensesItem.setRequired(true);
//		__formItems.add(livingExpensesItem);
//		
//		housingFinanceItem = new FloatItem("housingFinance", shouldNotBeNull + "住房费用(元/月)");
//		housingFinanceItem.setWidth("*");
//		housingFinanceItem.setRequired(true);
//		__formItems.add(housingFinanceItem);
		
		feeItem = new FloatItem("fee", "预计费用（元）");
		feeItem.setWidth("*");
		__formItems.add(feeItem);
		
//		isRemoteCityItem = new CheckboxItem("isRemoteCity", "是否为边远城市");
//		isRemoteCityItem.setWidth("*");
//		__formItems.add(isRemoteCityItem);
//		
//		provideAccommodationItem= new CheckboxItem("provideAccommodation", "是否提供住宿");
//		provideAccommodationItem.setWidth("*");
//		__formItems.add(provideAccommodationItem);
		

//		reasonItem = new TextItem("reason", shouldNotBeNull + "申请缘由");
//		reasonItem.setRequired(true);
//		reasonItem.setWidth("*");
//		__formItems.add(reasonItem);
//
//		planItem = new TextAreaItem("plan", shouldNotBeNull + "行程安排");
//		planItem.setRequired(true);
//		planItem.setColSpan(4);
//		planItem.setRowSpan(3);
//		planItem.setWidth("*");
//		__formItems.add(planItem);

		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setColSpan(4);
		remarkItem.setRowSpan(3);
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
//		reasonItem.setColSpan(4);
		mainLayout.addMember(__form);
//		Label label = new Label(
//				"<font style=\"font-weight:bold\">温馨提示：以<font style=\"color:#FF7F27\">开始日期</font>的月份为准，该月份的加班/外出/出差申请须在次月5日前（包括次月5日）提出申请</font>");
//		mainLayout.addMember(label);
		addMember(mainLayout);

	}

	@Override
	public boolean checkData() {
		return __form.validate();
	}

	@Override
	public void startEdit() {
		if (getRecord() != null)
			__form.editRecord(getRecord());
		else
			__form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSpersonnelbusinesppor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map map = __form.getValues();
		if(null != projectIdItem.getValue()){
			Record record = projectIdItem.getSelectedRecord();
			map.put("projectName", record.getAttribute("projectName"));
			map.put("projectCode", record.getAttribute("projectCode"));
		}
		return map;
	}
	
	private void countDays(Date startDate, Date endDate, String startDateDetail, String endDateDetail, ChangeEvent event){
		if(null!=startDate && null != endDate){
			long times = endDate.getTime()-startDate.getTime();
			if((times < 0) || (times == 0 && !startDateDetail.equals("0") && endDateDetail.equals("0"))){
				SC.say("开始日期必须早于截止日期");
				event.cancel();
			}else{
				double startDays = 1;
				double endDays = 0.5;
				if(!startDateDetail.equals("0")){
					startDays = 0.5;
				}
				if(!endDateDetail.equals("0")){
					endDays = 0;
				}
				double days = times / 1000 / 3600 / 24;
				days += startDays - endDays;
				daysItem.setValue(days);
			}
		}
	}

}
