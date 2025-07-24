package com.pomplatform.client.account.form;

import java.util.Date;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.data.RoleDefinition;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;

public class PlateAccountAllSearchForm extends SearchForm {

	private final ComboBoxItem plateIdItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;

	@SuppressWarnings("deprecation")
	public PlateAccountAllSearchForm() {
		setWidth100();
		setHeight100();
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setChangeOnKeypress(false);
//		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	
		//如果拥有查看所有的权限
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_ALL_DATA)){
			plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		//如果只拥有查看自己管理部门的权限
		}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_MYPLATE_DATA)){
			String plateIds = PomPlatformClientUtil.getRolePlateId();
			RoleDefinition.setPlateItemValueMap(plateIdItem,plateIds);
		}
		startDateItem = new DateItem("startDate", "开始年月份");
		startDateItem.setWidth("*");
		startDateItem.setDefaultValue(new Date("2016-01-01"));
		startDateItem.setShowIcons(false);
		startDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		Date endDate = new Date();
		endDate.setMonth(11);
		endDateItem = new DateItem("endDate", "结束年月份");
		endDateItem.setWidth("*");
		endDateItem.setDefaultValue(endDate);
		endDateItem.setShowIcons(false);
		endDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);

		setItems(plateIdItem, startDateItem, endDateItem);

		setNumCols(7);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
