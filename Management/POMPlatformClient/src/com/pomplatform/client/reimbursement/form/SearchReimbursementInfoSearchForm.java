package com.pomplatform.client.reimbursement.form;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.reimbursement.datasource.CDSearchReimbursementInfo;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class SearchReimbursementInfoSearchForm extends SearchForm
{


	private final DateItem startCreateTimeItem;
	private final DateItem endCreateTimeItem;
	private final DateItem startCompleteTimeItem;
	private final DateItem endCompleteTimeItem;
	private final SelectItem processTypeItem;
	private final TextItem bearFeeCodeItem;
	private final TextItem bearFeeNameItem;
	private final TextItem codeItem;
	private final ComboBoxItem employeeIdItem;
	private final ComboBoxItem plateIdItem;
	private final SelectItem processStatusItem;
	private final TextItem packageCodeItem;
	private final SelectItem currencyItem;
	private final TextItem contractCodeItem;
	private final TextItem remarkItem;
	private final SelectItem companyIdItem;
	private final IPickTreeItem subTypeItem;
	private final TextItem backViewNameItem;
	private final TextItem bdCodeItem;
	
	public SearchReimbursementInfoSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSearchReimbursementInfo.getInstance());
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
		map.put(6, "借款申请");
		map.put(7, "预付款申请");
		map.put(39, "成本调节");
		processTypeItem.setValueMap(map);
		processTypeItem.setWidth("*");
		processTypeItem.setMultiple(true);
		
		bearFeeCodeItem = new TextItem("bearFeeCode", "编号");
		bearFeeCodeItem.setWidth("*");
		
		bearFeeNameItem = new TextItem("bearFeeName", "费用承担主体");
		bearFeeNameItem.setWidth("*");
		
		codeItem = new TextItem("code", "报销编号");
		codeItem.setWidth("*");
		
		employeeIdItem = new ComboBoxItem("employeeId", "申请人");
		employeeIdItem.setWidth("*");
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		KeyValueManager.loadCustomSelect(employeeIdItem, "employees", new HashMap<String, Object>());
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	
		
		processStatusItem = new SelectItem("processStatus", "流程状态");
		processStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_120"));
		processStatusItem.setWidth("*");
		processStatusItem.setMultiple(true);
		
		packageCodeItem = new TextItem("packageCode", "打包汇总编号");
		packageCodeItem.setWidth("*");
		
		currencyItem = new SelectItem("currency", "货币种类");
		currencyItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_40"));
		currencyItem.setWidth("*");
		
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");

		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		companyIdItem.setWidth("*");
		
		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");
		
		subTypeItem = new IPickTreeItem("subType","报销科目");
		subTypeItem.setWidth("*");
		subTypeItem.setCanSelectParentItems(true);
		subTypeItem.setValueField("treeId");
		subTypeItem.setValueTree(KeyValueManager.getTree("subject_types"));
		
		backViewNameItem = new TextItem("backViewName", "节点名称");
		backViewNameItem.setWidth("*");
		
		bdCodeItem = new TextItem("bdCode", "预算编号");
		bdCodeItem.setWidth("*");
		
		setItems(packageCodeItem, codeItem, bdCodeItem, processTypeItem, processStatusItem, plateIdItem, 
				startCreateTimeItem, endCreateTimeItem, startCompleteTimeItem, endCompleteTimeItem, employeeIdItem, 
				bearFeeCodeItem, bearFeeNameItem, contractCodeItem, companyIdItem, remarkItem,subTypeItem, backViewNameItem, currencyItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
