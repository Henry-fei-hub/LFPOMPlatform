package com.pomplatform.client.aboutinputtaxrecordinfo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.aboutinputtaxrecordinfo.datasource.CDAboutInputTaxRecordInfo;
import com.pomplatform.client.stagemodel.panel.SelectEmployeePanel;

public class AboutInputTaxRecordInfoSearchForm extends SearchForm
{


	private final SelectItem processTypeItem;
	private final TextItem codeItem;
	private final TextItem invoiceEndNumberItem;
	private final DateTimeItem operateTimeItem;
	private final DateTimeItem overTimeItem;

	public AboutInputTaxRecordInfoSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDAboutInputTaxRecordInfo.getInstance());
		
		
		LinkedHashMap<Integer, String>  linkmap=new LinkedHashMap<>();
		linkmap.put(2, "项目日常报销");
		linkmap.put(3, "普通日常报销");
		linkmap.put(4, "项目差旅报销");
		linkmap.put(5, "普通差旅报销");
		linkmap.put(8, "前期项目日常报销");
		linkmap.put(9, "前期项目差旅报销");
		
		processTypeItem = new SelectItem("processType", "流程类型");
		processTypeItem.setWidth("*");
		processTypeItem.setValueMap(linkmap);
		
		codeItem = new TextItem("code", "报销编号");
		codeItem.setWidth("*");
		
		
		invoiceEndNumberItem = new TextItem("invoiceEndNumber", "发票号码后四位");
		invoiceEndNumberItem.setWidth("*");
		
		
		operateTimeItem = new DateTimeItem("operateTime", "操作时间");
		operateTimeItem.setWidth("*");
		operateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, operateTimeItem);
			}
		});
		overTimeItem = new DateTimeItem("overTime", "流程结束时间");
		overTimeItem.setWidth("*");
		overTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, overTimeItem);
			}
		});

		setItems(processTypeItem, codeItem, invoiceEndNumberItem, operateTimeItem, overTimeItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
