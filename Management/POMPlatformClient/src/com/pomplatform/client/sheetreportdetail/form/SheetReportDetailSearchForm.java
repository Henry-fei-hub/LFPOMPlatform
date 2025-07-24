package com.pomplatform.client.sheetreportdetail.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.sheetreportdetail.datasource.CDSheetReportDetail;

public class SheetReportDetailSearchForm extends SearchForm
{


	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final TextItem businessTypeItem;
	private final SelectItem projectTypeItem;
	private final SelectItem departmentIdItem;
	private final TextItem subContractCodeItem;
	private final TextItem subContractNameItem;

	public SheetReportDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSheetReportDetail.getInstance());
		startDateItem = new DateItem("startDate", "价格审核同意的时间");
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
			}
		});
		endDateItem = new DateItem("endDate", "价格审核同意的时间");
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
			}
		});
		businessTypeItem = new TextItem("businessType", "业务类型");
		projectTypeItem = new SelectItem("projectType", "项目类型");
//		projectTypeItem.setValueMap(KeyValueManager.getValueMap("project_types"));
		KeyValueManager.loadValueMap("project_types", projectTypeItem);
		departmentIdItem = new SelectItem("departmentId", "承接部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		subContractCodeItem = new TextItem("subContractCode", "子合同编号");
		subContractNameItem = new TextItem("subContractName", "子合同名称  充当了区域");

		setItems(startDateItem, endDateItem, businessTypeItem, projectTypeItem, departmentIdItem, subContractCodeItem, subContractNameItem);

		setNumCols(14);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
