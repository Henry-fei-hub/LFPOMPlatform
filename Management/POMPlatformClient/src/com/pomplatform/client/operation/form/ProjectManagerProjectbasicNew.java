package com.pomplatform.client.operation.form;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.data.RoleDefinition;
import com.pomplatform.client.operation.datasource.DSProjectManager;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class ProjectManagerProjectbasicNew extends AbstractWizadPage {
	private static final Logger __logger = Logger.getLogger("");
	private final TextItem contractCodeItem;
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final SelectItem projectTypeItem;
	private final SelectItem designTypeItem;
	private final SelectItem plateIdItem;
	private final SelectItem projectLevelItem;
	private final ComboBoxItem projectManageIdItem;
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
	private final SelectItem projectGradeTypeItem;
	private final TextItem complaintPercentageItem;
	private final TextItem sheetAmountItem;

	public ProjectManagerProjectbasicNew() {
		DSProjectManager ds = DSProjectManager.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		contractCodeItem = new TextItem("contractCode", "订单编号");
		contractCodeItem.setRequired(true);
		contractCodeItem.setChangeOnKeypress(false);
		contractCodeItem.setWidth("*");
//		contractCodeItem.setValueMap((LinkedHashMap) ds.getField("contractCode").getValueMap());
//		contractCodeItem.hide();
		__formItems.add(contractCodeItem);
//		contractCodeItem.addChangedHandler(new ChangedHandler() {
//			@Override
//			public void onChanged(ChangedEvent event) {
//				Object val = event.getValue();
//				if (ClientUtil.isNullOrEmpty(val)) {
//					return;
//				}
//				projectCodeItem.setValue(RoleDefinition.generateProjectID(val.toString()));
//				LinkedHashMap<String, String> keyValues = KeyValueManager.getValueMap("contracts");
//				String contractName = keyValues.get(val.toString());
//				String projectNameNew = contractName.replace("合同", "项目");
//				if (projectNameNew.equals(contractName)) {
//					projectNameNew = projectNameNew.concat("项目");
//				}
//				projectNameItem.setValue(projectNameNew);
//			}
//
//		});
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		__formItems.add(projectCodeItem);
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		__formItems.add(projectNameItem);
		parentIdItem = new ComboBoxItem("parentId", "父级项目");
		parentIdItem.hide();
		parentIdItem.setChangeOnKeypress(false);
		parentIdItem.setWidth("*");
//		parentIdItem.setValueMap(KeyValueManager.getValueMap("projects"));
		KeyValueManager.loadValueMap("projects", parentIdItem);
		__formItems.add(parentIdItem);
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setDefaultValue(ClientUtil.getPlateId());
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		__formItems.add(plateIdItem);
		projectTypeItem = new SelectItem("projectType", "项目类别");
		projectTypeItem.setWidth("*");
		projectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
		__formItems.add(projectTypeItem);
		designTypeItem = new SelectItem("designType", "设计类型");
		designTypeItem.setWidth("*");
		designTypeItem.setValueMap(
				KeyValueManager.getValueMap("system_dictionary_15", String.valueOf(ClientUtil.getPlateId())));
		__formItems.add(designTypeItem);
		projectLevelItem = new SelectItem("projectLevel", "项目等级");
		projectLevelItem.setWidth("*");
		projectLevelItem.setValueMap((LinkedHashMap) ds.getField("projectLevel").getValueMap());
		projectLevelItem.setDefaultValue(1);
		__formItems.add(projectLevelItem);
		plateManagerIdItem = new ComboBoxItem("plateManagerId", "事业部负责人");
		plateManagerIdItem.setWidth("*");
		plateManagerIdItem.setChangeOnKeypress(false);
		plateManagerIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateManagerIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		RoleDefinition.setEmployeeItemValueMapByRoleId(plateManagerIdItem, 2);
		__formItems.add(plateManagerIdItem);
		projectManageIdItem = new ComboBoxItem("projectManageId", "专业负责人");
		projectManageIdItem.setWidth("*");
		RoleDefinition.setEmployeeItemValueMapByRoleId(projectManageIdItem,4);
		projectManageIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		__formItems.add(projectManageIdItem);
		//当承接部门改变去加载对应的部门的专业负责人
		plateIdItem.addChangedHandler(new ChangedHandler() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void onChanged(ChangedEvent event) {
				LinkedHashMap<Integer, String> projectManageIdLinkHashMap=new LinkedHashMap<>();
				@SuppressWarnings("rawtypes")
				Map preparams = new HashMap<>();
				preparams.put("roleId", 4);
				preparams.put("plateId",BaseHelpUtils.getIntValue(event.getValue()));
				
				DBDataSource.callOperation("EP_SelectIntegrationManager", preparams, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							Record record[]=dsResponse.getData();
							for(Record obj:record){
								projectManageIdLinkHashMap.put(obj.getAttributeAsInt("employeeId"), obj.getAttributeAsString("employeeName"));
							}
							projectManageIdItem.setValueMap(projectManageIdLinkHashMap);
						}
					}
				});
			}
		});
		
		

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
		projectGradeTypeItem = new SelectItem("projectGradeType", "项目级别类型");
		projectGradeTypeItem.setWidth("*");
		projectGradeTypeItem.setValue(KeyValueManager.getValueMap("system_dictionary_25"));
		__formItems.add(projectGradeTypeItem);
		complaintPercentageItem = new TextItem("complaintPercentage", "投诉保证金比例");
		complaintPercentageItem.setWidth("*");
		complaintPercentageItem.setDefaultValue(5);
		__formItems.add(complaintPercentageItem);
		
		sheetAmountItem = new TextItem("sheetAmount", "订单合同金额");
		sheetAmountItem.setWidth("*");
		sheetAmountItem.setDefaultValue(0);
		__formItems.add(sheetAmountItem);

		bimAreaItem.setDefaultValue(0);
		cadAreaItem.setDefaultValue(0);

		__form.setItems(getFormItemArray());

		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setName("基本信息");
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if (getRecord() != null) {
			__form.editRecord(getRecord());
		} else {
			__form.editNewRecord();
		}
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSProjectManager.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}

}
