package com.pomplatform.client.bonuspayment.form;

import java.util.Date;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.bonuspayment.datasource.CDBonusPaymentRecord;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class BonusPaymentRecordSearchForm extends SearchForm {

	private final ComboBoxItem plateIdItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final SelectItem stateItem;

	public BonusPaymentRecordSearchForm() {
		final String plateIds = PomPlatformClientUtil.getRolePlateId();
		setWidth100();
		setHeight100();
		setDataSource(CDBonusPaymentRecord.getInstance());
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setChangeOnKeypress(false);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	
		if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.BONUS_PAYMENT_CHECK_ALL)
				&& ClientUtil.checkIsHavePermission(ERPPermissionStatic.BONUS_PAYMENT_CHECK_MYSELF)) {
			plateIdItem.addChangeHandler(new ChangeHandler() {

				@Override
				public void onChange(ChangeEvent event) {
					if (!BaseHelpUtils.isNullOrEmpty(event.getValue())) {
						String value = BaseHelpUtils.getString(event.getValue());
						if (!BaseHelpUtils.isNullOrEmpty(plateIds)) {
							String[] plateIdArr = plateIds.split(",");
							boolean change = false;// 是否允许本次业务部们搜索条件的变动，默认为否
							for (String str : plateIdArr) {
								if (str.equals(value)) {
									change = true;
									break;
								}
							}
							if (!change) {
								plateIdItem.setValue(event.getOldValue());
								SC.warn("提示", "您没有查看该部门数据的权限");
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
		endDateItem = new DateItem("endDate", "结束时间");
		endDateItem.setWidth("*");
		endDateItem.setValue(new Date());
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
			}
		});
		stateItem = new SelectItem("state", "审核状态");
		stateItem.setWidth("*");
		stateItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_36"));

		setItems(startDateItem, endDateItem, plateIdItem, stateItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
