package com.pomplatform.client.contract.form;

import java.util.Date;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.contract.datasource.CDContractAmountAnalyze;
import com.pomplatform.client.data.RoleDefinition;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class ContractAmountAnalyzeSearchForm extends SearchForm
{


	private final TextItem contractSigningStatusItem;
	private final SelectItem yearItem;
	private final ComboBoxItem plateIdItem;

	@SuppressWarnings("deprecation")
	public ContractAmountAnalyzeSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDContractAmountAnalyze.getInstance());
		
		contractSigningStatusItem = new TextItem("contractSigningStatus", "合同签订状态");
		contractSigningStatusItem.setWidth("*");
		
		yearItem = new SelectItem("year", "年份");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		yearItem.setWidth("*");
		Date currentDate = new Date();
		yearItem.setDefaultValue(currentDate.getYear()+1900);
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		//如果拥有查查所有部门的权限
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.CONTRACT_AMOUNT_ANALYZE_CHECK_ALLDATA)) {
			plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		}else{
			String plateIds = PomPlatformClientUtil.getRolePlateId();
			if(!BaseHelpUtils.isNullOrEmpty(plateIds)) {
				RoleDefinition.setPlateItemValueMap(plateIdItem,plateIds);
			}
		}

		setItems(yearItem, plateIdItem);

		setNumCols(5);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
