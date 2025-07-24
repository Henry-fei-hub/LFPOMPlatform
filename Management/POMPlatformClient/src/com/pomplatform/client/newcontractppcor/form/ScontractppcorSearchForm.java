package com.pomplatform.client.newcontractppcor.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.data.RoleDefinition;
import com.pomplatform.client.newcontractppcor.datasource.CDScontractppcor;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class ScontractppcorSearchForm extends SearchForm
{


	private final SelectItem projectLevelItem;
	private final SelectItem projectTypeItem;
	private final SelectItem contractStatusItem;
	private final TextItem clientContractIdItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final ComboBoxItem customerIdItem;
	private final TextItem projectCodeItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final SelectItem plateIdItem;
	private final SelectItem contractSigningStatusItem;

	private final SelectItem preProjectTypeItem;
	private final SelectItem contractTypeItem;
	private final DateItem projectApprovalStartTimeItem;
	private final DateItem projectApprovalEndTimeItem;
	private final ComboBoxItem parentCustomerName;
	private final SelectItem signCompanyItem;
	private final SelectItem designTeamItem;
	private final ComboBoxItem projectSecretaryItem;
	private final ComboBoxItem projectManagerItem;
	private final ComboBoxItem projectLeaderItem;
	private final SelectItem mainProjectStageIdItem;

	public ScontractppcorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDScontractppcor.getInstance());
		projectLevelItem = new SelectItem("projectLevel", "项目等级");
		projectLevelItem.setWidth("*");
		projectLevelItem.setHidden(true);
		projectLevelItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));
		projectTypeItem = new SelectItem("projectType", "项目类别");
		projectTypeItem.setWidth("*");
		projectTypeItem.setHidden(true);
		projectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
		contractStatusItem = new SelectItem("contractStatus", "合同状态");
		contractStatusItem.setWidth("*");
		contractStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_35"));
		clientContractIdItem = new TextItem("clientContractId", "客户合同编号");
		clientContractIdItem.setWidth("*");
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		customerIdItem = new ComboBoxItem("customerId", "客户名称");
		customerIdItem.setChangeOnKeypress(false);
		customerIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		KeyValueManager.loadValueMap("customers", customerIdItem);
		customerIdItem.setWidth("*");
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		
		startDateItem = new DateItem("startDate", "合同签订开始日期");
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);  
		endDateItem = new DateItem("endDate", "合同签订截止日期");
		endDateItem.setWidth("*");
		endDateItem.setUseTextField(true); 
		
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		//如果拥有查查所有部门的权限
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.CONTRACT_MANAGEMENT_INFO_SHOW_ALL)) {
			plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.CONTRACT_MANAGEMENT_INFO_SHOW_PLATE)){
			String plateIds = PomPlatformClientUtil.getRolePlateId();
			String[] arr = plateIds.split(",");
			if(arr.length > 0){
				plateIdItem.setDefaultValue(arr[0]);
			}
			RoleDefinition.setPlateItemValueMap(plateIdItem,plateIds);
		}
		
		
		contractSigningStatusItem = new SelectItem("contractSigningStatus", "合同签订状态");
		contractSigningStatusItem.setWidth("*");
		contractSigningStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_139"));

		preProjectTypeItem = new SelectItem("preProjectType","项目类型");
		preProjectTypeItem.setWidth("*");
		preProjectTypeItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		preProjectTypeItem.setRequired(false);
		preProjectTypeItem.setChangeOnKeypress(false);
		KeyValueManager.loadValueMap("system_dictionary_244", preProjectTypeItem);

		contractTypeItem = new SelectItem("contractType", "合同类别");
		contractTypeItem.setWidth("*");
		contractTypeItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		contractTypeItem.setRequired(false);
		contractTypeItem.setChangeOnKeypress(false);
		contractTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_27"));

		projectApprovalStartTimeItem = new DateItem("projectApprovalTimeStartDate", "立项时间开始日期");
		projectApprovalStartTimeItem.setWidth("*");
		projectApprovalStartTimeItem.setUseTextField(true);

		projectApprovalEndTimeItem = new DateItem("projectApprovalTimeEndDate", "立项时间截止日期");
		projectApprovalEndTimeItem.setWidth("*");
		projectApprovalEndTimeItem.setUseTextField(true);

		parentCustomerName = new ComboBoxItem("groupId","集团名称");
		parentCustomerName.setWidth("*");
		parentCustomerName.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		KeyValueManager.loadValueMap("parent_customers_name",parentCustomerName);

		signCompanyItem = new SelectItem("signCompany", "签约公司");
		signCompanyItem.setWidth("*");
		signCompanyItem.setValueMap(KeyValueManager.getValueMap("company_records"));

		designTeamItem = new SelectItem("designTeam", "主办设计团队");
		designTeamItem.setWidth("*");
		designTeamItem.setValueMap(KeyValueManager.getValueMap("plate_records"));

		projectSecretaryItem = new ComboBoxItem("projectSecretaryId", "项目秘书");
		projectSecretaryItem.setWidth("*");
		projectSecretaryItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		projectSecretaryItem.setRequired(false);
		projectSecretaryItem.setChangeOnKeypress(false);
		projectSecretaryItem.setValueMap(KeyValueManager.getValueMap("employees"));

		projectManagerItem = new ComboBoxItem("projectManagerId", "项目负责人");
		projectManagerItem.setWidth("*");
		projectManagerItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		projectManagerItem.setRequired(false);
		projectManagerItem.setChangeOnKeypress(false);
		projectManagerItem.setValueMap(KeyValueManager.getValueMap("employees"));

		projectLeaderItem = new ComboBoxItem("projectLeaderId", "项目主管领导");
		projectLeaderItem.setWidth("*");
		projectLeaderItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		projectLeaderItem.setRequired(false);
		projectLeaderItem.setChangeOnKeypress(false);
		projectLeaderItem.setValueMap(KeyValueManager.getValueMap("employees"));

		mainProjectStageIdItem = new SelectItem("mainProjectStageId","立项类型");
		mainProjectStageIdItem.setWidth("*");
		mainProjectStageIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		mainProjectStageIdItem.setRequired(false);
		mainProjectStageIdItem.setChangeOnKeypress(false);
		KeyValueManager.loadValueMap("main_project_stages", mainProjectStageIdItem);

		setItems(contractCodeItem, contractNameItem, customerIdItem, projectCodeItem,projectLevelItem, projectTypeItem, contractStatusItem, clientContractIdItem,startDateItem,endDateItem,plateIdItem,contractSigningStatusItem,preProjectTypeItem,contractTypeItem,projectApprovalStartTimeItem,projectApprovalEndTimeItem,parentCustomerName,signCompanyItem,designTeamItem,projectSecretaryItem,projectManagerItem,projectLeaderItem,mainProjectStageIdItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
