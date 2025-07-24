package com.pomplatform.client.preprojecttravelreimbursement.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.preprojecttravelreimbursement.datasource.CDPreProjectTravelReimbursement;

public class PreProjectTravelReimbursementSearchForm extends SearchForm
{


	private final DateItem minStartDateItem;
	private final DateItem maxStartDateItem;
	private final DateItem minEndDateItem;
	private final DateItem maxEndDateItem;
	private final TextItem codeItem;
	private final TextItem titleItem;
	private final TextItem remarkItem;
	private final SelectItem processInstanceIdItem;
	private final CheckboxItem isProjectItem;
	private final SelectItem deleteFlagItem;

	public PreProjectTravelReimbursementSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDPreProjectTravelReimbursement.getInstance());
		minStartDateItem = new DateItem("minStartDate", "最早出差开始日期");
		minStartDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minStartDateItem);
			}
		});
		maxStartDateItem = new DateItem("maxStartDate", "最晚出差开始日期");
		maxStartDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxStartDateItem);
			}
		});
		minEndDateItem = new DateItem("minEndDate", "最早出差结束日期");
		minEndDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minEndDateItem);
			}
		});
		maxEndDateItem = new DateItem("maxEndDate", "最晚出差结束日期");
		maxEndDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxEndDateItem);
			}
		});
		codeItem = new TextItem("code", "报销编号");
		titleItem = new TextItem("title", "主题");
		remarkItem = new TextItem("remark", "报销事由");
		processInstanceIdItem = new SelectItem("processInstanceId", "流程编码");
		processInstanceIdItem.setValueMap((LinkedHashMap)getDataSource().getField("processInstanceId").getValueMap());
		isProjectItem = new CheckboxItem("isProject", "是否是项目上的报销");
		deleteFlagItem = new SelectItem("deleteFlag", "删除状态");
		deleteFlagItem.setValueMap((LinkedHashMap)getDataSource().getField("deleteFlag").getValueMap());

		setItems(minStartDateItem, maxStartDateItem, minEndDateItem, maxEndDateItem, codeItem, titleItem, remarkItem, processInstanceIdItem, isProjectItem, deleteFlagItem);

		setNumCols(20);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
