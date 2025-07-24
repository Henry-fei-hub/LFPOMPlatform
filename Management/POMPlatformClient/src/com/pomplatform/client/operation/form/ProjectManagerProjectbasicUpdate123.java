package com.pomplatform.client.operation.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.data.RoleDefinition;
import com.pomplatform.client.operation.datasource.DSProjectManager;

public class ProjectManagerProjectbasicUpdate123 extends AbstractWizadPage {

	private final TextItem contractCodeItem;
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

	public ProjectManagerProjectbasicUpdate123() {
		DSProjectManager ds = DSProjectManager.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		contractCodeItem = new TextItem("contractCode", "合同");
		contractCodeItem.setWidth("*");
                __formItems.add(contractCodeItem);
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		__formItems.add(projectCodeItem);
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		__formItems.add(projectNameItem);
                parentIdItem = new ComboBoxItem("parentId", "父级项目");
                parentIdItem.hide();
                parentIdItem.setWidth("*");
                parentIdItem.setDisabled(true);
//		parentIdItem.setValueMap(KeyValueManager.getValueMap("projects"));
		KeyValueManager.loadValueMap("projects",parentIdItem);
                __formItems.add(parentIdItem);
		projectTypeItem = new SelectItem("projectType", "项目类型");
                projectTypeItem.setWidth("*");
                projectTypeItem.setDisabled(true);
		projectTypeItem.setValueMap((LinkedHashMap) ds.getField("projectType").getValueMap());
		__formItems.add(projectTypeItem);
		designTypeItem = new SelectItem("designType", "设计类型");
                designTypeItem.setWidth("*");
                designTypeItem.setDisabled(true);
		designTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_15", String.valueOf(ClientUtil.getPlateId())));
		__formItems.add(designTypeItem);
		projectLevelItem = new SelectItem("projectLevel", "项目等级");
                projectLevelItem.setWidth("*");
                projectLevelItem.setDisabled(true);
		projectLevelItem.setValueMap((LinkedHashMap) ds.getField("projectLevel").getValueMap());
		__formItems.add(projectLevelItem);
                plateManagerIdItem = new ComboBoxItem("plateManagerId","事业部负责人");
                plateManagerIdItem.setWidth("*");
                plateManagerIdItem.setChangeOnKeypress(false);
//                plateManagerIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
				KeyValueManager.loadValueMap("employees",plateManagerIdItem);
                RoleDefinition.setEmployeeItemValueMapByRoleId(plateManagerIdItem, 2);
                __formItems.add(plateManagerIdItem);
                plateManagerIdItem.setDisabled(true);
                departmentManagerIdItem = new ComboBoxItem("departmentManagerId","部门经理");
                departmentManagerIdItem.setWidth("*");
                departmentManagerIdItem.setChangeOnKeypress(false);
                departmentManagerIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
                __formItems.add(departmentManagerIdItem);
                departmentManagerIdItem.setDisabled(true);
		projectManageIdItem = new SelectItem("projectManageId", "专业负责人");
                projectManageIdItem.setWidth("*");
                projectManageIdItem.setDisabled(true);
		RoleDefinition.setProjectManagerItemValueMap(projectManageIdItem, ClientUtil.getPlateId());
		__formItems.add(projectManageIdItem);
		
		humanAmountItem = new TextItem("humanAmount", "手工计算出的积分");
		humanAmountItem.setWidth("*");
		__formItems.add(humanAmountItem);
                humanAmountItem.setDisabled(true);
		
		commonAreaItem = new TextItem("commonArea", "公区面积");
		commonAreaItem.setWidth("*");
		__formItems.add(commonAreaItem);
                commonAreaItem.setDisabled(true);
		logisticsAreaItem = new TextItem("logisticsArea", "后勤面积");
		logisticsAreaItem.setWidth("*");
		__formItems.add(logisticsAreaItem);
		commonAreaItem.setDefaultValue(0);
		logisticsAreaItem.setDefaultValue(0);
                logisticsAreaItem.setDisabled(true);
		bimAreaItem = new TextItem("bimArea", "BIM面积");
		bimAreaItem.setWidth("*");
		__formItems.add(bimAreaItem);
                bimAreaItem.setDisabled(true);
		cadAreaItem = new TextItem("cadArea", "CAD面积");
		cadAreaItem.setWidth("*");
		__formItems.add(cadAreaItem);
                cadAreaItem.setDisabled(true);
		totalAmountItem = new TextItem("totalAmount", "项目总金额");
		totalAmountItem.setWidth("*");
		totalAmountItem.setDefaultValue(0);
		__formItems.add(totalAmountItem);
                totalAmountItem.setDisabled(true);
		percentageItem = new TextItem("percentage", "核算比例");
		percentageItem.setWidth("*");
		__formItems.add(percentageItem);
                percentageItem.setDisabled(true);
		oldProjectDiscountItem = new TextItem("oldProjectDiscount", "遗留项目折算");
		oldProjectDiscountItem.setWidth("*");
                oldProjectDiscountItem.setDisabled(true);
		percentageItem.setDefaultValue(30);
		oldProjectDiscountItem.setDefaultValue(50);
		__formItems.add(oldProjectDiscountItem);
		bimAreaItem.setDefaultValue(0);
		cadAreaItem.setDefaultValue(0);
                projectGradeTypeItem = new SelectItem("projectGradeType","项目级别类型");
                projectGradeTypeItem.setWidth("*");
                projectGradeTypeItem.setValue(KeyValueManager.getValueMap("system_dictionary_25"));
                projectGradeTypeItem.setDisabled(true);
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
