package com.pomplatform.client.workflow.personnelbusiness.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.selectgridemployeevalue.datasource.DSSelectGridEmployeeValue;
import com.pomplatform.client.shift.panel.AttendanceRecordPanel;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSFillcheckApply;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

import java.util.Date;
import java.util.Map;

public class FillcheckApplyUpdateForm extends AbstractWizadPage
{

	private final VLayout mainLayout;
	private final TextItem personnelBusinessIdItem;
	private final SelectItem processTypeItem;
	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final SelectItem companyIdItem;
	private final SelectItem typeItem;
	private final DateItem startDateItem;
	private final TextItem startDateDetailItem;
	private final DateItem endDateItem;
	private final TextItem endDateDetailItem;
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
	private final ComboBoxItem nextAuditorItem;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private final TextItem drafterItem;
	private boolean canApply = true;
	private String errorMsg;

	public FillcheckApplyUpdateForm() {
		mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight("80%");
		mainLayout.setBackgroundColor("#fff");
		mainLayout.setLayoutLeftMargin(40);
		mainLayout.setLayoutRightMargin(30);
		mainLayout.setLayoutTopMargin(15);


		DSFillcheckApply ds = DSFillcheckApply.getInstance();
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
		
		startDateItem = new DateItem("startDate", shouldNotBeNull + "漏打卡日期");
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);
		startDateItem.setUseMask(true);
		startDateItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(startDateItem);
		
		ListGridField eNoField = new ListGridField("employeeNo");
		ListGridField eNameField = new ListGridField("employeeName");
		ListGridField departmentIdField = new ListGridField("departmentId");
		Criteria c = new Criteria();
		c.addCriteria("status", 0);
		
		nextAuditorItem = new ComboBoxItem("nextAuditor", shouldNotBeNull + "证明人");
		nextAuditorItem.setWidth("*");
		nextAuditorItem.setChangeOnKeypress(false);
		nextAuditorItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		nextAuditorItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
		nextAuditorItem.setOptionCriteria(c);
		nextAuditorItem.setValueField("employeeId");
		nextAuditorItem.setDisplayField("employeeName");
		nextAuditorItem.setPickListFields(eNoField, eNameField, departmentIdField);
		nextAuditorItem.setControlStyle("customInputTextStyle");
		__formItems.add(nextAuditorItem);
		
		typeItem = new SelectItem("type", shouldNotBeNull + "签到签退");
		typeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_74"));
		typeItem.setWidth("*");
		typeItem.setControlStyle("customInputTextStyle");
		__formItems.add(typeItem);
		
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
		
		startDateDetailItem = new TextItem("startDateDetail", "0上午   1下午");
		startDateDetailItem.hide();
		__formItems.add(startDateDetailItem);
		
		endDateItem = new DateItem("endDate", "截止日期");
		endDateItem.hide();
		__formItems.add(endDateItem);
		
		endDateDetailItem = new TextItem("endDateDetail", "0上午   1下午");
		endDateDetailItem.hide();
		__formItems.add(endDateDetailItem);
		
		daysItem = new TextItem("days", "天数");
		daysItem.hide();
		__formItems.add(daysItem);
		
		addressItem = new TextItem("address", "地址");
		addressItem.hide();
		__formItems.add(addressItem);
		
		planItem = new TextItem("plan", "计划安排");
		planItem.hide();
		__formItems.add(planItem);
		
		transportationItem = new TextItem("transportation", "交通工具");
		transportationItem.hide();
		__formItems.add(transportationItem);
		
		feeItem = new TextItem("fee", "预计费用");
		feeItem.hide();
		__formItems.add(feeItem);
		
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
		
		__form.setCellPadding(10);
		mainLayout.addMember(__form);
		
		addMember(mainLayout);

		IButton viewButton = new IButton("查看考勤");
		viewButton.setBaseStyle("customButton");
		viewButton.setWidth(100);
		viewButton.setHeight(30);
		viewButton.setLeft(0);
		viewButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(null != employeeIdItem.getValue() && null!=startDateItem.getValue()){
					PopupWindow window = new PopupWindow(KeyValueManager.getValue("employees", employeeIdItem.getValueAsString())+"今天的考勤明细");
					Map<String, Object> params = getValuesAsMap();
					params.put("optType", "FillcheckApplyWorkStartDate");
					Date date = startDateItem.getValueAsDate();
					params.put("startDate",date);
					DBDataSource.callOperation("EP_MyPersonnelProcessor", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							SC.debugger();
							if(dsResponse.getStatus() >= 0){
								Record record = dsResponse.getData()[0];
								Date startDate = record.getAttributeAsDate("checkInTime");
								Date endDate = record.getAttributeAsDate("checkOutTime");
								canApply = true;
								AttendanceRecordPanel panel = new AttendanceRecordPanel();
								panel.setEmployeeId(employeeIdItem.getValueAsString());
								panel.setStartDate(startDate);
								panel.setEndDate(endDate);
								panel.commonQuery();
								window.addMember(panel);
								window.setWidth100();
								window.setHeight100();
								window.centerInPage();
								window.show();
							}else{
								errorMsg = dsResponse.getErrors().get("errorMsg").toString();
								SC.say(errorMsg);
								canApply = false;
								event.cancel();
							}

						}
					});
				}else{
					SC.say("数据不全，无法查看考勤信息");
				}
			}
		});
		mainLayout.addMember(viewButton);

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
		if(getRecord() != null) __form.editRecord(getRecord());
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSFillcheckApply.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		if(nextAuditorItem.getValue().toString().equals(employeeIdItem.getValue().toString())){
			SC.say("证明人不能选择自己");
			return false;
		}
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
