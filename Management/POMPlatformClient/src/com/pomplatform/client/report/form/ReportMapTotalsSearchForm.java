package com.pomplatform.client.report.form;

import java.util.*;

import com.delicacy.client.BaseHelpUtils;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.report.datasource.CDReportMapTotals;

public class ReportMapTotalsSearchForm extends SearchForm
{


	private final TextItem projectNameItem;
	private final TextItem projectCodeItem;
	private final ComboBoxItem employeeIdItem;
	private final SelectItem plateIdItem;

	public ReportMapTotalsSearchForm() {
		final String plateIds = PomPlatformClientUtil.getRolePlateId();
		setWidth100();
		setHeight100();
		setDataSource(CDReportMapTotals.getInstance());
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		projectCodeItem.setValueMap(KeyValueManager.getValueMap(""));
		employeeIdItem = new ComboBoxItem("employeeId", "申请人");
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setWidth("*");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		plateIdItem = new SelectItem("plateId", "部门");
		plateIdItem.setWidth("*");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));

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

		//没有查看所有和查看管理部门的权限，说明只能查看自己的
		if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.REPORT_MAP_QUERY_ALL) && !ClientUtil.checkIsHavePermission(ERPPermissionStatic.REPORT_MAP_QUERY_DEPARTNENT)) {
			employeeIdItem.setDisabled(true);
			plateIdItem.setDisabled(true);
		}


		setItems(projectCodeItem, projectNameItem, employeeIdItem, plateIdItem);

		setNumCols(9);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
