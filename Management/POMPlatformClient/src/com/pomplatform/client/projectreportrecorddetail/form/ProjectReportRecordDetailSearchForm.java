package com.pomplatform.client.projectreportrecorddetail.form;

import java.util.Date;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.projectreportrecorddetail.datasource.CDProjectReportRecordDetail;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class ProjectReportRecordDetailSearchForm extends SearchForm {

	private final DateTimeItem startDateItem;
	private final DateTimeItem endDateItem;
/*	private final DateItem startDateItem;
	private final DateItem endDateItem;*/
	private final SelectItem plateIdItem;
	private final TextItem contractCodeItem;
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final SelectItem projectFlagItem;
	private final SelectItem statusItem;
	private final ComboBoxItem departmentManagerIdItem;

	private final ComboBoxItem projectTypeItem;
	private final TextItem employeeNameTostring5Item;

	public ProjectReportRecordDetailSearchForm() {
		final String plateIds = PomPlatformClientUtil.getRolePlateId();
		setWidth100();
		setHeight100();
		setDataSource(CDProjectReportRecordDetail.getInstance());
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		
		
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.PROJECT_GATHER_MANAGEMENT_CHECK_ALL_DATA)&&ClientUtil.checkIsHavePermission(ERPPermissionStatic.PROJECT_GATHER_MANAGEMENT_CHECK_MYPLATE_DATA)){
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
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		contractCodeItem = new TextItem("contractCode", "订单编号");
		contractCodeItem.setWidth("*");
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.hide();
		projectCodeItem.setWidth("*");
		projectFlagItem = new SelectItem("projectFlag","项目类型标识");
		projectFlagItem.setWidth("*");
		projectFlagItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_71"));
		
		statusItem = new SelectItem("status", "项目状态");
		statusItem.setWidth("*");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_4"));
		
		
		startDateItem = new DateTimeItem("startDate", "开始时间");
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
			}
		});
		endDateItem = new DateTimeItem("endDate", "结束时间");
		endDateItem.setWidth("*");
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
			}
		});

		departmentManagerIdItem = new ComboBoxItem("departmentManagerId", "部门经理");
		departmentManagerIdItem.setWidth("*");
		departmentManagerIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
/*		startDateItem = new DateItem("theStartDate","开始日期");
		startDateItem.setUseTextField(true);
//		startDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		startDateItem.setWidth("*");
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
			}
		});
		
        endDateItem = new DateItem("theEndDate","截止日期");
        endDateItem.setUseTextField(true);
//        endDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
        endDateItem.setWidth("*");
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
			}
		});*/

		projectTypeItem = new ComboBoxItem("projectType", "项目类别");
		projectTypeItem.setWidth("*");
		projectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_244"));

		employeeNameTostring5Item = new TextItem("employeeNameTostring5", "项目负责人");
		employeeNameTostring5Item.setWidth("*");

		setItems(plateIdItem, contractCodeItem, projectCodeItem, projectNameItem, projectFlagItem, statusItem,startDateItem,endDateItem,departmentManagerIdItem,projectTypeItem,employeeNameTostring5Item);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
