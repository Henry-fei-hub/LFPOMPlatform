package com.pomplatform.client.workinghour.form;

import java.util.Date;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.workinghour.datasource.CDWorkingHourManage;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class WorkingHourManageSearchForm extends SearchForm
{


	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;
	private final SelectItem departmentIdItem;
	private final ComboBoxItem plateIdItem;
	private final SelectItem companyIdItem;
	private final DateItem startWorkDateItem;
	private final DateItem endWorkDateItem;

	public WorkingHourManageSearchForm() {
		final String plateIds = PomPlatformClientUtil.getRolePlateId();
		setWidth100();
		setHeight100();
		setDataSource(CDWorkingHourManage.getInstance());
		
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		
		employeeIdItem = new TextItem("employeeId", "职员编码");
		employeeIdItem.hide();
		
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		
		departmentIdItem = new SelectItem("departmentId", "归属部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.hide();
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		plateIdItem.setWidth("*");
		plateIdItem.setChangeOnKeypress(false);
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.MY_WORK_HOUR_VIEW_ALL_DATA) && ClientUtil.checkIsHavePermission(ERPPermissionStatic.MY_WORK_HOUR_VIEW_PLATE_DATA)){
			plateIdItem.addChangeHandler(new ChangeHandler() {
				
				@Override
				public void onChange(ChangeEvent event) {
					if(!BaseHelpUtils.isNullOrEmpty(event.getValue())){
						String value = BaseHelpUtils.getString(event.getValue());
						if(!BaseHelpUtils.isNullOrEmpty(plateIds)){
							String[] plateIdArr = plateIds.split(",");
							boolean change = false;//是否允许本次业务部们搜索条件的变动，默认为否
							for(String str : plateIdArr){
								if(str.equals(value)){
									change = true;
									break;
								}
							}
							if(!change){
								plateIdItem.setValue(event.getOldValue());
								SC.warn("提示","您没有查看该部门数据的权限");
							}
						}
					}
				}
			});
		}
		
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setWidth("*");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		
		startWorkDateItem = new DateItem("startWorkDate", "开始日期");
		startWorkDateItem.setWidth("*");
		startWorkDateItem.setUseMask(true);
		startWorkDateItem.setUseTextField(true);
		startWorkDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startWorkDateItem);
			}
		});
		
		endWorkDateItem = new DateItem("endWorkDate", "结束日期");
		endWorkDateItem.setWidth("*");
		endWorkDateItem.setUseMask(true);
		endWorkDateItem.setUseTextField(true);
		endWorkDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endWorkDateItem);
			}
		});

		setItems(projectCodeItem, projectNameItem, employeeIdItem, employeeNoItem, employeeNameItem, departmentIdItem, plateIdItem, companyIdItem, startWorkDateItem, endWorkDateItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
