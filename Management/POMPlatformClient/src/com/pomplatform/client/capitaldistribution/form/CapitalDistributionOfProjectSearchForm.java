package com.pomplatform.client.capitaldistribution.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.capitaldistribution.datasource.CDCapitalDistributionOfProject;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;

public class CapitalDistributionOfProjectSearchForm extends SearchForm
{


	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem projectContractCodeItem;
	private final TextItem projectNameItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final ComboBoxItem plateIdItem;

	public CapitalDistributionOfProjectSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDCapitalDistributionOfProject.getInstance());
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		projectContractCodeItem = new TextItem("projectContractCode", "订单编号");
		projectContractCodeItem.setWidth("*");
		projectNameItem = new TextItem("projectName", "订单名称");
		projectNameItem.setWidth("*");
		startDateItem = new DateItem("startDate", "开始日期");
		startDateItem.setWidth("*");
		endDateItem = new DateItem("endDate", "截止日期");
		endDateItem.setWidth("*");
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setChangeOnKeypress(false);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	
		final String plateIds = PomPlatformClientUtil.getRolePlateId();
		if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.CAPITAL_DISTRIBUTION_CHECK_ALL)
				&& ClientUtil.checkIsHavePermission(ERPPermissionStatic.CAPITAL_DISTRIBUTION_CHECK_PLATE)) {
			String[] plateIdArr = plateIds.split(",");
			plateIdItem.addChangeHandler(new ChangeHandler() {
				
				@Override
				public void onChange(ChangeEvent event) {
					if(!BaseHelpUtils.isNullOrEmpty(event.getValue())){
						String value = BaseHelpUtils.getString(event.getValue());
						if(!BaseHelpUtils.isNullOrEmpty(plateIds)){
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
		
		setItems(contractCodeItem, contractNameItem, projectContractCodeItem, projectNameItem, plateIdItem, startDateItem, endDateItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
