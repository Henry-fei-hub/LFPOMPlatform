package com.pomplatform.client.project.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.project.datasource.CDSprojectpricechangedrecordcppor;

public class SprojectpricechangedrecordcpporSearchForm extends SearchForm
{


	private final TextItem contractCodeItem;
	private final TextItem projectPriceChangedRecordIdItem;
	private final TextItem projectIdItem;
	private final TextItem plateIdItem;
	private final TextItem departmentIdItem;
	private final TextItem yearItem;
	private final TextItem monthItem;
	private final DateItem recordDateItem;
	private final DateTimeItem recordTimeItem;
	private final TextItem subsidiesTypeItem;
	private final TextItem operateEmployeeIdItem;

	public SprojectpricechangedrecordcpporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSprojectpricechangedrecordcppor.getInstance());
		contractCodeItem = new TextItem("contractCode", "合同编号");
		projectPriceChangedRecordIdItem = new TextItem("projectPriceChangedRecordId", "编码");
		projectIdItem = new TextItem("projectId", "项目id");
		plateIdItem = new TextItem("plateId", "板块id");
		departmentIdItem = new TextItem("departmentId", "部门id");
		yearItem = new TextItem("year", "年份");
		monthItem = new TextItem("month", "月份");
		recordDateItem = new DateItem("recordDate", "操作日期");
		recordDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, recordDateItem);
			}
		});
		recordTimeItem = new DateTimeItem("recordTime", "操作时间");
		recordTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, recordTimeItem);
			}
		});
		subsidiesTypeItem = new TextItem("subsidiesType", "补贴类型");
		operateEmployeeIdItem = new TextItem("operateEmployeeId", "操作人");

		setItems(contractCodeItem, projectPriceChangedRecordIdItem, projectIdItem, plateIdItem, departmentIdItem, yearItem, monthItem, recordDateItem, recordTimeItem, subsidiesTypeItem, operateEmployeeIdItem);

		setNumCols(22);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
