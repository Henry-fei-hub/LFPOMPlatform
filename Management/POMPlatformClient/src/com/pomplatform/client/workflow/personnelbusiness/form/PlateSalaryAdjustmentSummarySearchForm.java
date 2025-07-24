package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.Date;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.workflow.personnelbusiness.datasource.CDPlateSalaryAdjustmentSummary;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;

public class PlateSalaryAdjustmentSummarySearchForm extends SearchForm
{


	private final SelectItem yearItem;
	private final SelectItem monthItem;
	private final ComboBoxItem plateIdItem;

	public PlateSalaryAdjustmentSummarySearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDPlateSalaryAdjustmentSummary.getInstance());
		
		Date date = new Date();
		
		yearItem = new SelectItem("year", "年份");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		yearItem.setDefaultValue(date.getYear() + 1900);
		yearItem.setWidth("*");

		monthItem = new SelectItem("month", "月份");
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		monthItem.setDefaultValue(date.getMonth() + 1);
		monthItem.setWidth("*");
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		String plateIds = PomPlatformClientUtil.getRolePlateId();
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
		setItems(yearItem, monthItem, plateIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
