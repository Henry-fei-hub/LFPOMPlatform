package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.selectgridemployeevalue.datasource.DSSelectGridEmployeeValue;
import com.pomplatform.client.shift.panel.AttendanceRecordPanel;
import com.pomplatform.client.workflow.datasource.DSSelectGridEmployeeValues;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSFillcheckApply;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

public class FillcheckApplyNewForm extends AbstractWizadPage
{
	private final VLayout mainLayout;
	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final SelectItem typeItem;
	private final DateItem startDateItem;
	private final TextItem reasonItem;
	private final TextAreaItem remarkItem;
	private final ComboBoxItem nextAuditorItem;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private static final Logger logger = Logger.getLogger("");
	private final TextItem drafterItem;
	private boolean canApply = true;
	private String errorMsg;

	public FillcheckApplyNewForm() {
		mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.setBackgroundColor("#fff");
		mainLayout.setLayoutLeftMargin(30);
		mainLayout.setLayoutRightMargin(30);
		mainLayout.setLayoutTopMargin(15);
		
		DSFillcheckApply ds = DSFillcheckApply.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		drafterItem = new TextItem("drafter", "起草人");
		drafterItem.setDefaultValue(ClientUtil.getUserId());
		drafterItem.hide();
		__formItems.add(drafterItem);
		
		employeeIdItem = new TextItem("employeeId", "申请人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setDisabled(true);
		employeeIdItem.setWidth("*");
		employeeIdItem.setTextBoxStyle("customInputTextStyle");
		employeeIdItem.setDefaultValue(ClientUtil.getUserId());
		__formItems.add(employeeIdItem);
		
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setDisabled(true);
		employeeNoItem.setWidth("*");
		employeeNoItem.setDefaultValue(ClientUtil.getUserNo());
		employeeNoItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(employeeNoItem);
		
		departmentIdItem = new TextItem("departmentId", "部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setDisabled(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setDefaultValue(ClientUtil.getDepartmentId());
		departmentIdItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(departmentIdItem);
		
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
		nextAuditorItem.setOptionDataSource(DSSelectGridEmployeeValues.getInstance());
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

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		__form.setCellPadding(10);
		mainLayout.addMember(__form);


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
					logger.info("=======================" + startDateItem.getValueAsDate());
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
								logger.info("=======================" + startDate);
								logger.info("=======================" + endDate);
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

		Label label = new Label("<font style=\"font-weight:bold;color:#FF7F27;font-size:16px;\">♥ 温馨提示：自漏打卡之日起，<font style='color:red'>7个自然日内</font>可以发起补卡申请，逾期无法申请！</font>");
		mainLayout.addMember(label);
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
	public boolean checkData() {
		if(nextAuditorItem.getValue().toString().equals(employeeIdItem.getValue().toString())){
			SC.say("证明人不能选择自己");
			return false;
		}else{
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
		manager.setDataSource(DSFillcheckApply.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
