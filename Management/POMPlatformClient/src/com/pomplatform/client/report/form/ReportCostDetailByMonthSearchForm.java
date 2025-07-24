package com.pomplatform.client.report.form;

import java.util.LinkedHashMap;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.report.datasource.CDReportCostDetailByMonth;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class ReportCostDetailByMonthSearchForm extends SearchForm
{


	private final TextItem yearItem;
	private final TextItem monthItem;
	private final SelectItem processTypeItem;
	private final SelectItem feeTypeItem;
	private final TextItem bearFeeCodeItem;
	private final TextItem bearFeeNameItem;
	private final TextItem codeItem;
	private final SelectItem employeeIdItem;
	private final SelectItem plateIdItem;
	private final SelectItem processStatusItem;

	public ReportCostDetailByMonthSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDReportCostDetailByMonth.getInstance());
		yearItem = new TextItem("year", "年份");
		yearItem.hide();
		
		monthItem = new TextItem("month", "月份");
		monthItem.hide();
		
		processTypeItem = new SelectItem("processType", "流程类型");
		LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
		map.put(3, "普通日常报销");
		map.put(2, "项目日常报销");
		map.put(8, "前期项目日常报销");
		map.put(5, "普通差旅报销");
		map.put(4, "项目差旅报销");
		map.put(9, "前期项目差旅报销");
		map.put(39, "成本调节");
		processTypeItem.setValueMap(map);
		processTypeItem.setWidth("*");
		
		feeTypeItem = new SelectItem("feeType", "费用类型");
		feeTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_121"));
		feeTypeItem.setWidth("*");
		
		bearFeeCodeItem = new TextItem("bearFeeCode", "编号");
		bearFeeCodeItem.setWidth("*");
		
		bearFeeNameItem = new TextItem("bearFeeName", "费用承担主体");
		bearFeeNameItem.setWidth("*");
		
		codeItem = new TextItem("code", "报销编号");
		codeItem.setWidth("*");
		
		employeeIdItem = new SelectItem("employeeId", "申请人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setWidth("*");
		
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		plateIdItem.hide();
		
		processStatusItem = new SelectItem("processStatus", "流程状态");
		processStatusItem.setValueMap((LinkedHashMap)getDataSource().getField("processStatus").getValueMap());
		processStatusItem.setWidth("*");

		setItems(codeItem, employeeIdItem, bearFeeCodeItem, bearFeeNameItem, processTypeItem, feeTypeItem, processStatusItem, yearItem, monthItem, plateIdItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
