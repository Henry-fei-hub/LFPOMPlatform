package com.pomplatform.client.employee.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.employee.datasource.CDEmployeeInfoOfNoSalaryAdjustment;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.PickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;

public class EmployeeInfoOfNoSalaryAdjustmentSearchForm extends SearchForm
{


	private final ComboBoxItem plateIdItem;
	private final TextItem employeeNameItem;
	private final DateItem startTimeItem;
	private final DateItem endTimeItem;
	private final PickTreeItem departmentItem;

	public EmployeeInfoOfNoSalaryAdjustmentSearchForm() {
		final String plateIds = PomPlatformClientUtil.getRolePlateId();
		setWidth100();
		setHeight100();
		setDataSource(CDEmployeeInfoOfNoSalaryAdjustment.getInstance());
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	
		if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.SALARY_ADJUSTMENT_APPLY_ALL)
				&& ClientUtil.checkIsHavePermission(ERPPermissionStatic.SALARY_ADJUSTMENT_APPLY_PLATE)) {
			String[] plateIdArr = plateIds.split(",");
			plateIdItem.addChangeHandler(new ChangeHandler() {
				
				@Override
				public void onChange(ChangeEvent event) {
					if(!BaseHelpUtils.isNullOrEmpty(event.getValue())){
						String value = BaseHelpUtils.getString(event.getValue());
						if(!BaseHelpUtils.isNullOrEmpty(plateIds)){
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
		
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		
		startTimeItem = new DateItem("startTime", "开始日期");
		startTimeItem.hide();
		startTimeItem.setWidth("*");
		
		endTimeItem = new DateItem("endTime", "截止日期");
		endTimeItem.hide();
		endTimeItem.setWidth("*");

		departmentItem = new PickTreeItem("departmentId", "归属部门");
		departmentItem.setWidth("*");
		departmentItem.setValueTree(KeyValueManager.getTree("departments"));
		departmentItem.setCanSelectParentItems(true);
		departmentItem.setValueField("treeId");
		
		setItems(plateIdItem, employeeNameItem, startTimeItem, endTimeItem, departmentItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
