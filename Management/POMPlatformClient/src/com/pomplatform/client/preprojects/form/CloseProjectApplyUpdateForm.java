package com.pomplatform.client.preprojects.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.preprojects.datasource.DSCloseProjectApply;

public class CloseProjectApplyUpdateForm extends AbstractWizadPage
{


	private final TextItem preProjectIdItem;
	private final TextItem projectCodeItem;
	private final TextItem infoCodeItem;
	private final TextItem clientIdItem;
	private final TextItem customerNameItem;
	private final TextItem customerAddressItem;
	private final TextItem projectNameItem;
	private final TextItem provinceItem;
	private final TextItem cityItem;
	private final TextItem detailAddressItem;
	private final SelectItem projectTypeItem;
	private final TextItem totalBuildingAreasItem;
	private final TextItem projectOriginationItem;
	private final TextItem projectOriginationRemarkItem;
	private final TextItem customerContactIdItem;
	private final TextItem contactNameItem;
	private final TextItem contactPhoneItem;
	private final TextItem designStatusItem;
	private final TextItem projectSalesTeamItem;
	private final TextItem designTeamItem;
	private final SelectItem projectLevelItem;
	private final SelectItem signCompanyItem;
	private final TextItem designQualificationItem;
	private final SelectItem projectBaseOnItem;
	private final DateTimeItem projectApprovalTimeItem;
	private final CheckboxItem isHighRiseBuildingItem;
	private final TextItem designCooperationNameItem;
	private final TextItem architecturalDesignUnitsItem;
	private final TextItem projectTotalInvestmentItem;
	private final TextItem fireResistanceRatingItem;
	private final TextItem estimateTheDesignAreasItem;
	private final TextItem actualDesignAreasItem;
	private final TextItem buildingHeightItem;
	private final TextItem buildingFloorsItem;
	private final TextItem decorateMoneyControlItem;
	private final TextItem specialtyItem;
	private final SelectItem businessTypeItem;
	private final CheckboxItem hasContractItem;
	private final TextItem applyEmployeeIdItem;
	private final DateTimeItem createTimeItem;
	private final DateTimeItem infoRegisterTimeItem;
	private final TextItem projectStatusItem;

	public CloseProjectApplyUpdateForm() {
		DSCloseProjectApply ds = DSCloseProjectApply.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		preProjectIdItem = new TextItem("preProjectId", "主键编码");
		preProjectIdItem.setDisabled(true);
		preProjectIdItem.setRequired(true);
		IsIntegerValidator preProjectIdValidator = new IsIntegerValidator();
		preProjectIdItem.setValidators(preProjectIdValidator);
		__formItems.add(preProjectIdItem);
		projectCodeItem = new TextItem("projectCode", "项目编号");
		__formItems.add(projectCodeItem);
		infoCodeItem = new TextItem("infoCode", "信息编号");
		__formItems.add(infoCodeItem);
		clientIdItem = new TextItem("clientId", "开发商id");
		__formItems.add(clientIdItem);
		customerNameItem = new TextItem("customerName", "开发商名称");
		__formItems.add(customerNameItem);
		customerAddressItem = new TextItem("customerAddress", "开发商地址");
		__formItems.add(customerAddressItem);
		projectNameItem = new TextItem("projectName", "项目名称");
		__formItems.add(projectNameItem);
		provinceItem = new TextItem("province", "项目地址（省）");
		__formItems.add(provinceItem);
		cityItem = new TextItem("city", "项目地址（市）");
		__formItems.add(cityItem);
		detailAddressItem = new TextItem("detailAddress", "详细地址");
		__formItems.add(detailAddressItem);
		projectTypeItem = new SelectItem("projectType", "项目类别");
		projectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
		__formItems.add(projectTypeItem);
		totalBuildingAreasItem = new TextItem("totalBuildingAreas", "项目面积");
		__formItems.add(totalBuildingAreasItem);
		projectOriginationItem = new TextItem("projectOrigination", "项目来源渠道");
		__formItems.add(projectOriginationItem);
		projectOriginationRemarkItem = new TextItem("projectOriginationRemark", "项目来源说明");
		__formItems.add(projectOriginationRemarkItem);
		customerContactIdItem = new TextItem("customerContactId", "联系人id");
		__formItems.add(customerContactIdItem);
		contactNameItem = new TextItem("contactName", "联系人");
		__formItems.add(contactNameItem);
		contactPhoneItem = new TextItem("contactPhone", "联系电话");
		__formItems.add(contactPhoneItem);
		designStatusItem = new TextItem("designStatus", "设计状态system_dictionary_155");
		__formItems.add(designStatusItem);
		projectSalesTeamItem = new TextItem("projectSalesTeam", "项目营销团队plate_str");
		__formItems.add(projectSalesTeamItem);
		designTeamItem = new TextItem("designTeam", "主办设计团队plate_records");
		__formItems.add(designTeamItem);
		projectLevelItem = new SelectItem("projectLevel", "项目等级system_dictionary_2");
		projectLevelItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));
		__formItems.add(projectLevelItem);
		signCompanyItem = new SelectItem("signCompany", "拟签约公司company_records");
		signCompanyItem.setValueMap(KeyValueManager.getValueMap(""));
		__formItems.add(signCompanyItem);
		designQualificationItem = new TextItem("designQualification", "设计资质章system_dictionary_157");
		__formItems.add(designQualificationItem);
		projectBaseOnItem = new SelectItem("projectBaseOn", "立项依据system_dictionary_28");
		projectBaseOnItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_28"));
		__formItems.add(projectBaseOnItem);
		projectApprovalTimeItem = new DateTimeItem("projectApprovalTime", "立项时间");
		__formItems.add(projectApprovalTimeItem);
		isHighRiseBuildingItem = new CheckboxItem("isHighRiseBuilding", "是否高层建筑");
		__formItems.add(isHighRiseBuildingItem);
		designCooperationNameItem = new TextItem("designCooperationName", "设计合作单位");
		__formItems.add(designCooperationNameItem);
		architecturalDesignUnitsItem = new TextItem("architecturalDesignUnits", "建筑设计单位");
		__formItems.add(architecturalDesignUnitsItem);
		projectTotalInvestmentItem = new TextItem("projectTotalInvestment", "项目总投资额");
		__formItems.add(projectTotalInvestmentItem);
		fireResistanceRatingItem = new TextItem("fireResistanceRating", "耐火等级");
		__formItems.add(fireResistanceRatingItem);
		estimateTheDesignAreasItem = new TextItem("estimateTheDesignAreas", "计容建筑面积(㎡)");
		__formItems.add(estimateTheDesignAreasItem);
		actualDesignAreasItem = new TextItem("actualDesignAreas", "实际设计面积");
		__formItems.add(actualDesignAreasItem);
		buildingHeightItem = new TextItem("buildingHeight", "建筑高度");
		__formItems.add(buildingHeightItem);
		buildingFloorsItem = new TextItem("buildingFloors", "建筑楼层");
		__formItems.add(buildingFloorsItem);
		decorateMoneyControlItem = new TextItem("decorateMoneyControl", "装修造价控制");
		__formItems.add(decorateMoneyControlItem);
		specialtyItem = new TextItem("specialty", "合同参与专业");
		__formItems.add(specialtyItem);
		businessTypeItem = new SelectItem("businessType", "业务类别");
		businessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		__formItems.add(businessTypeItem);
		hasContractItem = new CheckboxItem("hasContract", "是否有合同");
		__formItems.add(hasContractItem);
		applyEmployeeIdItem = new TextItem("applyEmployeeId", "报备人");
		__formItems.add(applyEmployeeIdItem);
		createTimeItem = new DateTimeItem("createTime", "报备时间");
		__formItems.add(createTimeItem);
		infoRegisterTimeItem = new DateTimeItem("infoRegisterTime", "修改时间");
		__formItems.add(infoRegisterTimeItem);
		projectStatusItem = new TextItem("projectStatus", "项目状态system_dictionary_154(1前期跟踪，2已立项，3关闭)");
		__formItems.add(projectStatusItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSCloseProjectApply.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
