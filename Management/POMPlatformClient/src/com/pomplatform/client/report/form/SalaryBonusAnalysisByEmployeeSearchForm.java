package com.pomplatform.client.report.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.report.datasource.CDSalaryBonusAnalysisByEmployee;

public class SalaryBonusAnalysisByEmployeeSearchForm extends SearchForm
{


	private final TextItem departmentIdItem;
	private final TextItem employeeIdItem;
	private final TextItem yearItem;
	private final DateItem firstStartItem;
	private final DateItem firstEndItem;
	private final DateItem secondStartItem;
	private final DateItem secondEndItem;
	private final DateItem thirdStartItem;
	private final DateItem thirdEndItem;
	private final DateItem fourthStartItem;
	private final DateItem fourthEndItem;

	public SalaryBonusAnalysisByEmployeeSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSalaryBonusAnalysisByEmployee.getInstance());
		departmentIdItem = new TextItem("departmentId", "归属部门");
		employeeIdItem = new TextItem("employeeId", "员工");
		yearItem = new TextItem("year", "年度");
		firstStartItem = new DateItem("firstStart", "第一季度开始时间");
		firstStartItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, firstStartItem);
			}
		});
		firstEndItem = new DateItem("firstEnd", "第一季结束时间");
		firstEndItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, firstEndItem);
			}
		});
		secondStartItem = new DateItem("secondStart", "第二季开始时间");
		secondStartItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, secondStartItem);
			}
		});
		secondEndItem = new DateItem("secondEnd", "第二季结束时间");
		secondEndItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, secondEndItem);
			}
		});
		thirdStartItem = new DateItem("thirdStart", "第三季开始时间");
		thirdStartItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, thirdStartItem);
			}
		});
		thirdEndItem = new DateItem("thirdEnd", "第三季结束时间");
		thirdEndItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, thirdEndItem);
			}
		});
		fourthStartItem = new DateItem("fourthStart", "第四季开始时间");
		fourthStartItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, fourthStartItem);
			}
		});
		fourthEndItem = new DateItem("fourthEnd", "第四季结束时间");
		fourthEndItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, fourthEndItem);
			}
		});

		setItems(departmentIdItem, employeeIdItem, yearItem, firstStartItem, firstEndItem, secondStartItem, secondEndItem, thirdStartItem, thirdEndItem, fourthStartItem, fourthEndItem);

		setNumCols(22);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
