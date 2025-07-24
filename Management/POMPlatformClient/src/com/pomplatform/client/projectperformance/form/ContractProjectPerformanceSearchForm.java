package com.pomplatform.client.projectperformance.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.data.RoleDefinition;
import com.pomplatform.client.projectperformance.datasource.CDContractProjectPerformance;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class ContractProjectPerformanceSearchForm extends SearchForm
{


	private final TextItem contractCodeItem;
	private final ComboBoxItem contractIdItem;
	private final ComboBoxItem projectManageIdItem;
	private final ComboBoxItem plateIdItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;

	public ContractProjectPerformanceSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDContractProjectPerformance.getInstance());
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		
		contractIdItem = new ComboBoxItem("contractId", "合同名称");
//		contractIdItem.setValueMap(KeyValueManager.getValueMap("contracts_1"));
		KeyValueManager.loadValueMap("contracts_1", contractIdItem);
		contractIdItem.setWidth("*");
		contractIdItem.setChangeOnKeypress(false);
		contractIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		
		projectManageIdItem = new ComboBoxItem("projectManageId", "项目经理");
		RoleDefinition.setProjectManagerItemValueMap(projectManageIdItem,0);
		projectManageIdItem.setWidth("*");
		projectManageIdItem.setChangeOnKeypress(false);
		projectManageIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.VIEW_ALL_DATA) && ClientUtil.checkIsHavePermission(ERPPermissionStatic.VIEW_SELF_DATA)){
			//只有查看自己的合同绩效数据
			projectManageIdItem.setValue(ClientUtil.getUserId());
			projectManageIdItem.setDisabled(true);
		}
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	
		
		startDateItem = new DateItem("startDate", "开始时间");
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);  
		endDateItem = new DateItem("endDate", "截止时间");
		endDateItem.setWidth("*");
		endDateItem.setUseTextField(true); 

		setItems(contractCodeItem, contractIdItem, projectManageIdItem, plateIdItem, startDateItem, endDateItem);

		setNumCols(7);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
