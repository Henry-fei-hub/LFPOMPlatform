package com.pomplatform.client.capitaldistribution.form;

import java.util.LinkedHashMap;

import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.capitaldistribution.datasource.CDAllCapitalDistributionInfo;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class AllCapitalDistributionInfoSearchForm extends SearchForm
{


	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final DateItem startHappenDateItem;
	private final DateItem endHappenDateItem;
	private final CheckboxItem lockedItem;
	private final DateItem startDistributeTimeItem;
	private final DateItem endDistributeTimeItem;
	private final SelectItem projectManageIdItem;
	private final SelectItem statusItem;

	public AllCapitalDistributionInfoSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDAllCapitalDistributionInfo.getInstance());
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		
		startHappenDateItem = new DateItem("startHappenDate", "开始回款日期");
		startHappenDateItem.setWidth("*");
		
		endHappenDateItem = new DateItem("endHappenDate", "截止回款日期");
		endHappenDateItem.setWidth("*");
		
		lockedItem = new CheckboxItem("locked", "是否锁定");
		
		startDistributeTimeItem = new DateItem("startDistributeTime", "开始分配日期");
		startDistributeTimeItem.setWidth("*");
		
		endDistributeTimeItem = new DateItem("endDistributeTime", "截止分配日期");
		endDistributeTimeItem.setWidth("*");
		
		projectManageIdItem = new SelectItem("projectManageId", "大项目经理");
		projectManageIdItem.hide();
		
		statusItem = new SelectItem("status", "回款分配状态");
		LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
		map.put(0, "尚未回款分配");
		map.put(1, "已分配金额 > 回款金额");
		map.put(2, "已分配金额 = 回款金额");
		map.put(3, "已分配金额 < 回款金额");
		statusItem.setValueMap(map);
		statusItem.setWidth("*");
		
		setItems(contractCodeItem, startHappenDateItem, startDistributeTimeItem, statusItem, contractNameItem, endHappenDateItem, endDistributeTimeItem, lockedItem, projectManageIdItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
