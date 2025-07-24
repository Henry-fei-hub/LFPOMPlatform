package com.pomplatform.client.rmimburseementinvoice.form;

import java.util.Date;

import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.rmimburseementinvoice.datasource.CDMreimbursementinvoiceinformationrsrmmpror;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class MreimbursementinvoiceinformationrsrmmprorSearchForm extends SearchForm {

	private final DateTimeItem minCompleteTimeItem;
	private final DateTimeItem maxCompleteTimeItem;
	private final TextItem packageCodeItem;
	private final TextItem rmiCodeItem;

	public MreimbursementinvoiceinformationrsrmmprorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMreimbursementinvoiceinformationrsrmmpror.getInstance());
		minCompleteTimeItem = new DateTimeItem("minCompleteTime", "最早完成时间");
		minCompleteTimeItem.setWidth("*");
		minCompleteTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minCompleteTimeItem);
			}
		});
		maxCompleteTimeItem = new DateTimeItem("maxCompleteTime", "最晚完成时间");
		maxCompleteTimeItem.setWidth("*");
		maxCompleteTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxCompleteTimeItem);
			}
		});
		packageCodeItem = new TextItem("packageCode", "汇总单号");
		packageCodeItem.setWidth("*");
		
		rmiCodeItem = new TextItem("rmiCode", "报销单号");
		rmiCodeItem.setWidth("*");

		setItems(minCompleteTimeItem, maxCompleteTimeItem, packageCodeItem, rmiCodeItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
