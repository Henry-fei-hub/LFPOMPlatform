package com.pomplatform.client.operation.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.data.RoleDefinition;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.*;

public class ProjectManagerSearchForm extends SearchForm {

	private final TextItem contractCodeItem;
	private final SelectItem designTypeItem;
	private final TextItem projectNameItem;
	private final SelectItem projectLevelItem;
	private final ComboBoxItem plateIdItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final SelectItem projectFlagItem;
	private final SelectItem statusItem;
	private final BooleanItem projectFinishPercentItem;

	public ProjectManagerSearchForm() {
		setWidth100();
		setHeight100();
		contractCodeItem = new TextItem("contractCode", "订单编号");
		contractCodeItem.setWidth("*");
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		designTypeItem = new SelectItem("designType", "设计类型");
		designTypeItem.setWidth("*");
		designTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_15", String.valueOf(ClientUtil.getPlateId())));
		projectLevelItem = new SelectItem("projectLevel", "项目等级");
		projectLevelItem.setWidth("*");
		projectLevelItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
//		String plateIds = PomPlatformClientUtil.getRolePlateId();
//		if(!BaseHelpUtils.isNullOrEmpty(plateIds)){
//			String[] idsArr = plateIds.split(",");
//			plateIdItem.setDefaultValue(idsArr[0]);
//		}
//		RoleDefinition.setPlateItemValueMap(plateIdItem, plateIds);
		startDateItem = new DateItem("startDate","开始日期");
		startDateItem.setUseTextField(true);
		startDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		startDateItem.setWidth("*");
		
		endDateItem = new DateItem("endDate","截止日期");
		endDateItem.setUseTextField(true);
		endDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		endDateItem.setWidth("*");
		
		projectFlagItem = new SelectItem("projectFlag","订单类别");
		projectFlagItem.setWidth("*");
		projectFlagItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_71"));
		
		statusItem = new SelectItem("status","项目状态");
		statusItem.setWidth("*");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_4"));

		projectFinishPercentItem = new BooleanItem("projectFinishPercent", "显示进度100%的项目");
		projectFinishPercentItem.setWidth("*");


		setItems(plateIdItem, projectLevelItem, contractCodeItem, projectNameItem,startDateItem,endDateItem,projectFlagItem,statusItem,projectFinishPercentItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
