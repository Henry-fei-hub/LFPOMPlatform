package com.pomplatform.client.operation.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.data.RoleDefinition;
import com.pomplatform.client.operation.datasource.DSProjectManager;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class ChangeIntegralProjectManagerProjectbasicUpdate extends AbstractWizadPage {

	private final SelectItem contractCodeItem;
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final SelectItem projectTypeItem;
	private final SelectItem designTypeItem;
	private final SelectItem projectLevelItem;
	private final SelectItem projectManageIdItem;
	private final TextItem commonAreaItem;
	private final TextItem logisticsAreaItem;
	private final TextItem totalAmountItem;
	private final TextItem percentageItem;
	private final TextItem oldProjectDiscountItem;
	private final TextItem bimAreaItem;
	private final TextItem cadAreaItem;
	private final TextItem humanAmountItem;
        private final ComboBoxItem parentIdItem;
        private final ComboBoxItem plateManagerIdItem;
        private final ComboBoxItem departmentManagerIdItem;
        private final SelectItem projectGradeTypeItem;

	public ChangeIntegralProjectManagerProjectbasicUpdate() {
		DSProjectManager ds = DSProjectManager.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		contractCodeItem = new SelectItem("contractCode", "合同");
		contractCodeItem.setWidth("*");
                contractCodeItem.hide();
		contractCodeItem.setValueMap((LinkedHashMap) ds.getField("contractCode").getValueMap());
		__formItems.add(contractCodeItem);
		contractCodeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Object val = event.getValue();
				if (ClientUtil.isNullOrEmpty(val)) {
					return;
				}
				projectCodeItem.setValue(RoleDefinition.generateProjectID(val.toString()));
//				LinkedHashMap<String, String> keyValues = KeyValueManager.getValueMap("contracts");
				String contractName = SyncDataUtil.getContractCode(BaseHelpUtils.getIntValue(val));
//				String contractName = keyValues.get(val.toString());
				String projectNameNew = contractName.replace("合同", "项目");
				if (projectNameNew.equals(contractName)) {
					projectNameNew = projectNameNew.concat("项目");
				}
				projectNameItem.setValue(projectNameNew);
			}

		});
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		__formItems.add(projectCodeItem);
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		__formItems.add(projectNameItem);
                parentIdItem = new ComboBoxItem("parentId", "父级项目");
                parentIdItem.hide();
                parentIdItem.setWidth("*");
//		parentIdItem.setValueMap(KeyValueManager.getValueMap("projects"));
		KeyValueManager.loadValueMap("projects",parentIdItem);
                __formItems.add(parentIdItem);
		projectTypeItem = new SelectItem("projectType", "业务部门");
                projectTypeItem.setWidth("*");
		projectTypeItem.setValueMap((LinkedHashMap) ds.getField("projectType").getValueMap());
		__formItems.add(projectTypeItem);
		designTypeItem = new SelectItem("designType", "设计类型");
                designTypeItem.setWidth("*");
		designTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_15", String.valueOf(ClientUtil.getPlateId())));
		__formItems.add(designTypeItem);
		projectLevelItem = new SelectItem("projectLevel", "项目等级");
                projectLevelItem.setWidth("*");
		projectLevelItem.setValueMap((LinkedHashMap) ds.getField("projectLevel").getValueMap());
		__formItems.add(projectLevelItem);
                plateManagerIdItem = new ComboBoxItem("plateManagerId","事业部负责人");
                plateManagerIdItem.setWidth("*");
                plateManagerIdItem.setChangeOnKeypress(false);
                plateManagerIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
                RoleDefinition.setEmployeeItemValueMapByRoleId(plateManagerIdItem, 2);
                __formItems.add(plateManagerIdItem);
                departmentManagerIdItem = new ComboBoxItem("departmentManagerId","部门经理");
                departmentManagerIdItem.setWidth("*");
                departmentManagerIdItem.setChangeOnKeypress(false);
                departmentManagerIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
                RoleDefinition.setEmployeeItemValueMapByRoleId(departmentManagerIdItem, 3);
                __formItems.add(departmentManagerIdItem);
		projectManageIdItem = new SelectItem("projectManageId", "专业负责人");
                projectManageIdItem.setWidth("*");
		RoleDefinition.setProjectManagerItemValueMap(projectManageIdItem, ClientUtil.getPlateId());
		__formItems.add(projectManageIdItem);
		
		humanAmountItem = new TextItem("humanAmount", "手工计算出的积分");
		humanAmountItem.setWidth("*");
		__formItems.add(humanAmountItem);
		
		commonAreaItem = new TextItem("commonArea", "公区面积");
		commonAreaItem.setWidth("*");
		__formItems.add(commonAreaItem);
		logisticsAreaItem = new TextItem("logisticsArea", "后勤面积");
		logisticsAreaItem.setWidth("*");
		__formItems.add(logisticsAreaItem);
		commonAreaItem.setDefaultValue(0);
		logisticsAreaItem.setDefaultValue(0);
		bimAreaItem = new TextItem("bimArea", "BIM面积");
		bimAreaItem.setWidth("*");
		__formItems.add(bimAreaItem);
		cadAreaItem = new TextItem("cadArea", "CAD面积");
		cadAreaItem.setWidth("*");
		__formItems.add(cadAreaItem);
		totalAmountItem = new TextItem("totalAmount", "项目总金额");
		totalAmountItem.setWidth("*");
		totalAmountItem.setDefaultValue(0);
		__formItems.add(totalAmountItem);
		percentageItem = new TextItem("percentage", "核算比例");
		percentageItem.setWidth("*");
		__formItems.add(percentageItem);
		oldProjectDiscountItem = new TextItem("oldProjectDiscount", "遗留项目折算");
		oldProjectDiscountItem.setWidth("*");
		percentageItem.setDefaultValue(30);
		oldProjectDiscountItem.setDefaultValue(50);
		__formItems.add(oldProjectDiscountItem);
		bimAreaItem.setDefaultValue(0);
		cadAreaItem.setDefaultValue(0);
                projectGradeTypeItem = new SelectItem("projectGradeType","项目级别类型");
                projectGradeTypeItem.setWidth("*");
                projectGradeTypeItem.setValue(KeyValueManager.getValueMap("system_dictionary_25"));
                __formItems.add(projectGradeTypeItem);

		__form.setItems(getFormItemArray());

		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setName("基本信息");
		addMember(__form);
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSProjectManager.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if (getRecord() != null) {
			__form.editRecord(getRecord());
		}
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}
}
