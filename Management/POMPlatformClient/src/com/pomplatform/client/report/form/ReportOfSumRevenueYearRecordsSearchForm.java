package com.pomplatform.client.report.form;

import java.util.Date;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.data.RoleDefinition;
import com.pomplatform.client.report.datasource.CDReportOfSumRevenueYearRecords;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;

public class ReportOfSumRevenueYearRecordsSearchForm extends SearchForm
{


	private final ComboBoxItem plateIdItem;
	private final SelectItem yearItem;

	public ReportOfSumRevenueYearRecordsSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDReportOfSumRevenueYearRecords.getInstance());
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		//如果拥有查查所有部门的权限
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.REPORT_OF_SUM_REVENUE_CHECK_ALL)) {
			plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.REPORT_OF_SUM_REVENUE_CHECK_MANAGE_PLATE)){
			String plateIds = PomPlatformClientUtil.getRolePlateId();
			RoleDefinition.setPlateItemValueMap(plateIdItem,plateIds);
		}
		
		yearItem = new SelectItem("year", "年份");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		yearItem.setWidth("*");
		Date currentDate = new Date();
		yearItem.setDefaultValue(currentDate.getYear()+1900);
		
		setItems(plateIdItem, yearItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
