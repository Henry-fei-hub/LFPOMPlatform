package com.pomplatform.client.ja.ht.panel;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.data.RoleDefinition;
import com.pomplatform.client.project.datasource.DSOnBidSheetProject;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.validator.IsStringValidator;
import com.smartgwt.client.widgets.form.validator.LengthRangeValidator;

public class BidSheetProjectNewForm extends AbstractWizadPage
{
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final ComboBoxItem plateIdItem;
	private final SelectItem businessTypeItem;
	private final SelectItem businessLineItem;
	private final SelectItem projectTypeItem;
	private final DoubleItem signingMoneySumItem;
	private final IPickTreeItem departmentIdItem;
	private final ComboBoxItem plateManagerIdItem;
	private final ComboBoxItem departmentManagerIdItem;
	private final ComboBoxItem projectManageIdItem;
	private final TextAreaItem remarkItem;

	public BidSheetProjectNewForm() {
		DSOnBidSheetProject ds = DSOnBidSheetProject.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		projectCodeItem = new TextItem("projectCode", "合同编号");
		projectCodeItem.setDisabled(true);
		projectCodeItem.setWidth("*");
		__formItems.add(projectCodeItem);
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setDisabled(true);
		contractNameItem.setWidth("*");
		__formItems.add(contractNameItem);
		contractCodeItem = new TextItem("contractCode", "订单编号");
		contractCodeItem.setDisabled(true);
		contractCodeItem.setWidth("*");
		__formItems.add(contractCodeItem);
		projectNameItem = new TextItem("projectName", "订单名称");
		projectNameItem.setWidth("*");
		projectNameItem.setDisabled(true);
		projectNameItem.setWidth("*");
		__formItems.add(projectNameItem);
		
		businessTypeItem = new SelectItem("businessType", "业务类别");
		businessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		businessTypeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				//获取变化后的值
				int businessType = BaseHelpUtils.getIntValue(event.getValue());
				//获取业务部门
				int plateId = BaseHelpUtils.getIntValue(plateIdItem.getValue());
				//获取项目类型
				int projectType = BaseHelpUtils.getIntValue(projectTypeItem.getValue());
				Map<String,Object> param = new HashMap<>();
				param.put("optType","onGetProjectCode");
				param.put("contractId", contractId);
				param.put("plateId", plateId);
				param.put("businessType", businessType);
				param.put("projectType", projectType);
				if(plateId == 0 || projectType == 0){
					return;
				}
				//加载项目编码
				DBDataSource.callOperation("EP_OnProjectCommonProcess", "load",param, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							//获取编码
							String sheetCode = (String)dsResponse.getAttributeAsMap("userData").get("sheetCode");
							contractCodeItem.setValue(sheetCode);
						}
					}
				});
			}
		});
		businessTypeItem.setWidth("*");
		__formItems.add(businessTypeItem);
		
		businessLineItem = new SelectItem("businessLine", "条线");
		businessLineItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_205"));
		businessLineItem.setWidth("*");
		__formItems.add(businessLineItem);
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		plateIdItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				//获取变化后的值
				int businessType = BaseHelpUtils.getIntValue(businessTypeItem.getValue());
				//获取业务部门
				int plateId = BaseHelpUtils.getIntValue(event.getValue());
				//获取项目类型
				int projectType = BaseHelpUtils.getIntValue(projectTypeItem.getValue());
				Map<String,Object> param = new HashMap<>();
				param.put("optType","onGetProjectCode");
				param.put("contractId", contractId);
				param.put("plateId", plateId);
				param.put("businessType", businessType);
				param.put("projectType", projectType);
				//加载项目编码
				DBDataSource.callOperation("EP_OnProjectCommonProcess", "load",param, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							//获取编码
							String sheetCode = (String)dsResponse.getAttributeAsMap("userData").get("sheetCode");
							contractCodeItem.setValue(sheetCode);
							RoleDefinition.setEmployeeByPlateIdAndRoleId(plateManagerIdItem,plateId, 2);
							RoleDefinition.setPlateOfDepartmentId(departmentIdItem,plateId);
							RoleDefinition.setEmployeeByPlateIdAndRoleId(departmentManagerIdItem,plateId, 3);
						}
					}
				});
			}
		});
		
		__formItems.add(plateIdItem);
		
		departmentIdItem = new IPickTreeItem("departmentId", "归属部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		__formItems.add(departmentIdItem);
		plateManagerIdItem = new ComboBoxItem("plateManagerId", "事业部负责人");
		plateManagerIdItem.setWidth("*");
		plateManagerIdItem.setDisabled(true);
		plateManagerIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		__formItems.add(plateManagerIdItem);
		departmentManagerIdItem = new ComboBoxItem("departmentManagerId", "部门经理");
		departmentManagerIdItem.setDisabled(true);
		departmentManagerIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		departmentManagerIdItem.setWidth("*");
//		departmentManagerIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees", departmentManagerIdItem);
		__formItems.add(departmentManagerIdItem);
		projectManageIdItem = new ComboBoxItem("projectManageId", "专业负责人");
		projectManageIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		projectManageIdItem.setWidth("*");
		RoleDefinition.setProjectManagerItemValueMap(projectManageIdItem,0);
		__formItems.add(projectManageIdItem);
		
		signingMoneySumItem = new DoubleItem("signingMoneySum", "投标金额");
		signingMoneySumItem.setWidth("*");
		__formItems.add(signingMoneySumItem);
		
		projectTypeItem = new SelectItem("projectType", "项目类别");
		projectTypeItem.setWidth("*");
		projectTypeItem.setColSpan(4);
		projectTypeItem.setDefaultValue(66);//默认为投标
		projectTypeItem.setDisabled(true);
		projectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
		__formItems.add(projectTypeItem);
		
		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setWidth("*");
		remarkItem.setRowSpan(3);
		remarkItem.setColSpan(4);
		remarkItem.setRequired(true);
		IsStringValidator remarkValidator = new IsStringValidator();
		LengthRangeValidator remarkLengthValidator = new LengthRangeValidator();
		remarkLengthValidator.setMax(512);
		remarkItem.setValidators(remarkValidator, remarkLengthValidator);
		__formItems.add(remarkItem);
		
		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		Record record = getRecord();
		if(getRecord() != null) {
			__form.editRecord(record);
			setContractId(BaseHelpUtils.getIntValue(record.getAttribute("contractId")));
		}
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSOnBidSheetProject.getInstance());
		manager.addMember(__form);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}

	private int contractId;

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

}
