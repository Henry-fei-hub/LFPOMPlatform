package com.pomplatform.client.departmentdirector.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.departmentdirector.datasource.CDMDepartmentDirector;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;

public class MDepartmentDirectorSearchForm extends SearchForm {

    private final TextItem projectIdItem;
    private final SelectItem projectTypeItem;
    private final TextItem projectNameItem;
    private final SelectItem statusItem;
    private final TextItem employeeIdItem;
    private final DateItem startDateItem;
    private final DateItem endDateItem;
    
    public MDepartmentDirectorSearchForm() {
    	final String plateIds = PomPlatformClientUtil.getRolePlateId();
        setWidth100();
        setHeight100();
        setDataSource(CDMDepartmentDirector.getInstance());
        projectIdItem = new TextItem("projectId", "项目编码");
        projectIdItem.setWidth("*");
        projectIdItem.hide();
        projectTypeItem = new SelectItem("projectType", "业务部门");
        projectTypeItem.setWidth("*");
        projectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
        if(!BaseHelpUtils.isNullOrEmpty(plateIds)){
        	String[] idArr = plateIds.split(",");
        	projectTypeItem.setDefaultValue(idArr[0]);
        }
        projectTypeItem.addChangeHandler(new ChangeHandler() {
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
							projectTypeItem.setValue(event.getOldValue());
							SC.warn("提示","您没有查看该部门数据的权限");
						}
					}
				}
			}
        });
        projectNameItem = new TextItem("projectName", "项目名称");
        projectNameItem.setWidth("*");
        statusItem = new SelectItem("status", "项目状态");
        statusItem.setWidth("*");
        statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_4"));
        employeeIdItem = new TextItem("employeeId", "员工编码");
        employeeIdItem.setWidth("*");
        employeeIdItem.hide();

        startDateItem = new DateItem("startDate","开始日期");
		startDateItem.setUseTextField(true);
		startDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		startDateItem.setWidth("*");
		
		endDateItem = new DateItem("endDate","截止日期");
		endDateItem.setUseTextField(true);
		endDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		endDateItem.setWidth("*");
        
        setItems(projectIdItem, projectTypeItem, projectNameItem, statusItem, employeeIdItem,startDateItem,endDateItem);

        setNumCols(6);
    }

}
