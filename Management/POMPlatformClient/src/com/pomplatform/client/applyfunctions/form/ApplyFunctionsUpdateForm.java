package com.pomplatform.client.applyfunctions.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.applyfunctions.datasource.DSApplyFunctions;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.layout.HLayout;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ApplyFunctionsUpdateForm extends AbstractWizadPage
{


	private  TextItem employeeIdItem;
	private  TextItem employeeNoItem;
	private  TextItem departmentIdItem;
	private  TextItem companyIdItem;
	private  DateItem startDateItem;
	private  DateItem endDateItem;
	private  TextItem daysItem;
	private  TextAreaItem reasonItem;
	private  DynamicForm  searchForm;
	private  SelectItem parentIdItem;
	private CheckboxItem  isForeverItem;  
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private static Logger __logger = Logger.getLogger("");
	private  HLayout  mainLayout;
	private  HLayout  rightLayout;
	private  HLayout  leftLayout;
	private String processName;
	FuntionDetailPanel panel=new FuntionDetailPanel();
	GiveFunctionPanel  givepanel=new GiveFunctionPanel();

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}
	

	public ApplyFunctionsUpdateForm() {
		mainLayout=new HLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		addMember(mainLayout);
		
		leftLayout=new HLayout();
		leftLayout.setHeight100();
		leftLayout.setWidth("30%");
		mainLayout.addMember(leftLayout);
		
		rightLayout=new HLayout();
		rightLayout.setHeight100();
		rightLayout.setWidth("70%");
		mainLayout.addMember(rightLayout);
		
		rightLayout.addMember(panel);
		rightLayout.addMember(givepanel);
		
		
		DSApplyFunctions ds = DSApplyFunctions.getInstance();
		employeeIdItem = new TextItem("employeeId", "申请人");
		employeeIdItem.setWidth("*");
		employeeIdItem.setDisabled(true);
		employeeIdItem.setTextBoxStyle("customInputTextStyle");
		KeyValueManager.loadValueMap("employees", employeeIdItem);
		employeeIdItem.setCanEdit(false);
		
		
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setWidth("*");
		employeeNoItem.setDisabled(true);
		employeeNoItem.setTextBoxStyle("customInputTextStyle");
		employeeNoItem.setCanEdit(false);
		
		
		departmentIdItem = new TextItem("departmentId", "部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setDisabled(true);
		departmentIdItem.setTextBoxStyle("customInputTextStyle");
		KeyValueManager.loadValueMap("departments", departmentIdItem);
		departmentIdItem.setCanEdit(false);
		
		
		companyIdItem = new TextItem("companyId", "归属公司");
		companyIdItem.setWidth("*");
		companyIdItem.setDisabled(true);
		companyIdItem.setTextBoxStyle("customInputTextStyle");
		KeyValueManager.loadValueMap("company_records", companyIdItem);
		companyIdItem.setCanEdit(false);
		
		startDateItem = new DateItem("startDate", "开始日期");
		startDateItem.setWidth("*");
		startDateItem.setDisabled(true);
		startDateItem.setUseTextField(true);
		startDateItem.setDefaultValue(new Date());
		startDateItem.setUseMask(true);
		startDateItem.setTextBoxStyle("customInputTextStyle");
		startDateItem.setCanEdit(false);
		
		
		endDateItem = new DateItem("endDate", shouldNotBeNull+"结束时间");
		endDateItem.setWidth("*");
		endDateItem.setUseTextField(true);
		endDateItem.setUseMask(true);
		endDateItem.setDisabled(true);
		endDateItem.setTextBoxStyle("customInputTextStyle");
		endDateItem.setRequired(true);
		endDateItem.setCanEdit(false);
		
		
		daysItem = new TextItem("days", shouldNotBeNull+"天数");
		daysItem.setWidth("*");
		daysItem.setDisabled(true);
		daysItem.setRequired(true);
		daysItem.setTextBoxStyle("customInputTextStyle");
		daysItem.setStartRow(false);
		daysItem.setCanEdit(false);
		
		
		LinkedHashMap<Integer,String> linkMap=new LinkedHashMap<>();
		linkMap.put(1, "Erp权限");
		linkMap.put(2, "cwd权限");
		
		
		parentIdItem=new SelectItem("parentId","权限类型");
		parentIdItem.setWidth("*");
		parentIdItem.setRequired(true);
		parentIdItem.setValueMap(linkMap);
		parentIdItem.setDisabled(true);
		parentIdItem.setTextBoxStyle("customInputTextStyle");
		parentIdItem.setCanEdit(false);
		
		
		isForeverItem=new CheckboxItem("isForever","是否永久有效");
		isForeverItem.setWidth("*");
		isForeverItem.setCanEdit(true);
		
		reasonItem = new TextAreaItem("reason", shouldNotBeNull+"申请权限模块描述");
		reasonItem.setWidth("*");
		reasonItem.setRequired(true);
		reasonItem.setCanEdit(false);

		searchForm=new DynamicForm();
		searchForm.setNumCols(4);
		searchForm.setPadding(3);
		searchForm.setMargin(5);
		searchForm.setWidth("100%");;
		searchForm.setHeight("100%");
		searchForm.setFields(employeeIdItem,employeeNoItem,departmentIdItem,companyIdItem,startDateItem,endDateItem,daysItem,parentIdItem,isForeverItem,reasonItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(searchForm);
		reasonItem.setColSpan(4);
		leftLayout.addMember(searchForm);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) searchForm.editRecord(getRecord());
		
		panel.setEmployeeId(BaseHelpUtils.getIntValue(employeeIdItem.getValue()));
		panel.startEdit();
		
		givepanel.setEmployeeId(BaseHelpUtils.getIntValue(employeeIdItem.getValue()));
		givepanel.setPersonnelBusinessId(BaseHelpUtils.getIntValue(getRecord().getAttribute("personnelBusinessId")));
		givepanel.startEdit();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSApplyFunctions.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		if(!searchForm.validate()) {
			SC.say("请按系统提示，填入信息");
			return false;
		}
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map map=searchForm.getValues();
		Map maps=givepanel.getValuesAsMap();
		map.putAll(maps);
		return map;
	}


}
