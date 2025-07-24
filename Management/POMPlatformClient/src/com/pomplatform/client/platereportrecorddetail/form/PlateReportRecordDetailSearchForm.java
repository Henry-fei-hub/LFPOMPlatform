package com.pomplatform.client.platereportrecorddetail.form;

import java.util.Date;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.platereportrecorddetail.datasource.CDPlateReportRecordDetail;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class PlateReportRecordDetailSearchForm extends SearchForm {

	private final SelectItem plateIdItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;

	public PlateReportRecordDetailSearchForm() {
		final String plateIds = PomPlatformClientUtil.getRolePlateId();
		setWidth100();
		setHeight100();
		setDataSource(CDPlateReportRecordDetail.getInstance());
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_ALL_DATA)
				&& ClientUtil.checkIsHavePermission(ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_MYPLATE_DATA)) {
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
		startDateItem = new DateItem("startDate", "开始时间");
		startDateItem.setWidth("*");
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
			}
		});
		endDateItem = new DateItem("endDate", "截止时间");
		endDateItem.setWidth("*");
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
			}
		});

		setItems(plateIdItem, startDateItem, endDateItem);

		setNumCols(7);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
