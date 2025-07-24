package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSOvertimeApply;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.VLayout;

public class OvertimeApplyNewForm extends AbstractWizadPage
{
	private static final Logger  logger = Logger.getLogger("");
	private final VLayout mainLayout;
	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final DateTimeItem startDateItem;
	private final DateTimeItem endDateItem;
	private final TextItem reasonItem;
	private final TextAreaItem remarkItem;
	private final TextItem numberOfBabyItem;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private final TextItem drafterItem;

	public OvertimeApplyNewForm() {
		mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.setBackgroundColor("#fff");
		mainLayout.setLayoutLeftMargin(30);
		mainLayout.setLayoutRightMargin(30);
		mainLayout.setLayoutTopMargin(15);
		
		DSOvertimeApply ds = DSOvertimeApply.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		drafterItem = new TextItem("drafter", "起草人");
		drafterItem.setDefaultValue(ClientUtil.getUserId());
		drafterItem.hide();
		__formItems.add(drafterItem);
		
		numberOfBabyItem = new TextItem("numberOfBaby", "业务部门");
		numberOfBabyItem.setDefaultValue(ClientUtil.getPlateId());
		numberOfBabyItem.hide();
		__formItems.add(numberOfBabyItem);
		
		employeeIdItem = new TextItem("employeeId", "申请人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setDisabled(true);
		employeeIdItem.setWidth("*");
		employeeIdItem.setDefaultValue(ClientUtil.getUserId());
		employeeIdItem.setTextBoxStyle("customInputTextStyle");
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
		
		startDateItem = new DateTimeItem("startDate", shouldNotBeNull + "开始日期");
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);
		startDateItem.setUseMask(true);
		startDateItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(startDateItem);
		
		
		endDateItem = new DateTimeItem("endDate", shouldNotBeNull + "结束日期");
		endDateItem.setWidth("*");
		endDateItem.setUseTextField(true);
		endDateItem.setUseMask(true);
		endDateItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(endDateItem);
		
		
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
		if(null == startDateItem.getValue()){
			SC.say("请填写开始日期");
			return false;
		}
		if(null == endDateItem.getValue()){
			SC.say("请填写结束日期");
			return false;
		}
		if(null == reasonItem.getValue()){
			SC.say("请填写申请缘由");
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
		manager.setDataSource(DSOvertimeApply.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map map = __form.getValues();
		return map;
	}


}
