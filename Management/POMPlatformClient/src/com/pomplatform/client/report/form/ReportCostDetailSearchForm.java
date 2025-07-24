package com.pomplatform.client.report.form;

import java.util.LinkedHashMap;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.report.datasource.CDReportCostDetail;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;

public class ReportCostDetailSearchForm extends SearchForm
{


	private final DateItem startCreateTimeItem;
	private final DateItem endCreateTimeItem;
	private final DateItem startCompleteTimeItem;
	private final DateItem endCompleteTimeItem;
	private final SelectItem processTypeItem;
	private final TextItem feeTypeItem;
	private final TextItem bearFeeCodeItem;
	private final TextItem bearFeeNameItem;
	private final TextItem codeItem;
	private final ComboBoxItem employeeIdItem;
	private final SelectItem plateIdItem;
	private final SelectItem processStatusItem;

	public ReportCostDetailSearchForm() {
		final String plateIds = PomPlatformClientUtil.getRolePlateId();
		setWidth100();
		setHeight100();
		setDataSource(CDReportCostDetail.getInstance());
		startCreateTimeItem = new DateItem("startCreateTime", "申请开始日期");
		startCreateTimeItem.setWidth("*");
		
		endCreateTimeItem = new DateItem("endCreateTime", "申请结束日期");
		endCreateTimeItem.setWidth("*");
		
		startCompleteTimeItem = new DateItem("startCompleteTime", "完成开始日期");
		startCompleteTimeItem.setWidth("*");
		
		endCompleteTimeItem = new DateItem("endCompleteTime", "完成结束日期");
		endCompleteTimeItem.setWidth("*");
		
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
		
		feeTypeItem = new TextItem("feeType", "费用类型");
		feeTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_121"));
		feeTypeItem.setWidth("*");
		
		bearFeeCodeItem = new TextItem("bearFeeCode", "编号");
		bearFeeCodeItem.setWidth("*");
		
		bearFeeNameItem = new TextItem("bearFeeName", "费用承担主体");
		bearFeeNameItem.setWidth("*");
		
		codeItem = new TextItem("code", "报销编号");
		codeItem.setWidth("*");
		
		employeeIdItem = new ComboBoxItem("employeeId", "申请人");
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setWidth("*");
		
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.RESET_REIMBURSEMENT_COST_CHECK_ALL)
				&& ClientUtil.checkIsHavePermission(ERPPermissionStatic.RESET_REIMBURSEMENT_COST_CHECK_MYPLATE)) {
			plateIdItem.setDefaultValue(plateIds.split(",")[0]);
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
		
		processStatusItem = new SelectItem("processStatus", "流程状态");
		processStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_120"));
		processStatusItem.setWidth("*");
		
		setItems(processTypeItem, feeTypeItem, processStatusItem, plateIdItem, codeItem, employeeIdItem, bearFeeCodeItem, bearFeeNameItem, startCreateTimeItem, endCreateTimeItem, startCompleteTimeItem, endCompleteTimeItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
