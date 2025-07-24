package com.pomplatform.client.ja.ht.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.ja.ht.datasource.DSMainProject;

public class MainProjectUpdateForm extends AbstractWizadPage
{


	private final TextItem mainProjectIdItem;
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final TextItem projectEnglishNameItem;
	private final SelectItem projectStatusItem;
	private final SelectItem designStatusItem;
	private final SelectItem signCompanyItem;
	private final TextItem projectOriginationItem;
	private final TextItem projectOriginationRemarkItem;
	private final TextItem designCooperationNameItem;
	private final TextItem designCooperationEnglishNameItem;
	private final TextItem projectSalesTeamItem;
	private final SelectItem designTeamItem;
	private final CheckboxItem isHighRiseBuildingItem;
	private final DateTimeItem infoRegisterTimeItem;
	private final DateTimeItem projectApprovalTimeItem;
	private final CheckboxItem hasContractItem;
	private final SelectItem projectBaseOnItem;
	private final TextItem infoCodeItem;
	private final TextItem projectModelItem;
	private final TextItem designQualificationItem;
	private final TextItem fireResistanceRatingItem;
	private final TextItem estimateTheDesignAreasItem;
	private final TextItem projectTotalInvestmentItem;
	private final TextItem actualDesignAreasItem;
	private final TextItem totalBuildingAreasItem;
	private final TextItem buildingHeightItem;
	private final TextItem buildingFloorsItem;
	private final TextItem decorateMoneyControlItem;
	private final SelectItem projectLevelItem;
	private final TextItem provinceItem;
	private final TextItem cityItem;
	private final TextItem detailAddressItem;
	private final DateItem projectEndTimeItem;
	private final ComboBoxItem clientIdItem;
	private final TextItem customerNameItem;
	private final TextItem customerAddressItem;
	private final TextItem bidProjectItem;
	private final TextItem constructionUnitItem;
	private final TextItem architecturalDesignUnitsItem;
	private final TextItem rateOfBidWinningItem;
	private final DateTimeItem followUpDateItem;
	private final TextItem equityedgeRemarkItem;
	private final DateTimeItem orderSignUpTimeItem;
	private final TextItem designServiceBookItem;
	private final TextItem serviceSuggestBookItem;
	private final TextItem totalMoneyItem;
	private final TextItem coveredAreaItem;
	private final TextItem designAreaItem;
	private final SelectItem businessTypeItem;
	private final SelectItem projectTypeItem;

	
	public MainProjectUpdateForm() {
		DSMainProject ds = DSMainProject.getInstance();
		
		__form.setGroupTitle("基本信息");
		
		__form.setIsGroup(true);
		__form.setWidth100();
		__form.setHeight100();
		
		
		mainProjectIdItem = new TextItem("mainProjectId", "主键编码");
		mainProjectIdItem.setHidden(true);
		mainProjectIdItem.setDisabled(true);
		mainProjectIdItem.setRequired(true);
		IsIntegerValidator mainProjectIdValidator = new IsIntegerValidator();
		mainProjectIdItem.setValidators(mainProjectIdValidator);
		__formItems.add(mainProjectIdItem);
		
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setDisabled(true);
		projectCodeItem.setWidth("*");
		projectCodeItem.setLength(64);
		__formItems.add(projectCodeItem);
		
		infoCodeItem = new TextItem("infoCode", "信息编号");
		infoCodeItem.setDisabled(true);
		infoCodeItem.setWidth("*");
		__formItems.add(infoCodeItem);
		
		infoRegisterTimeItem = new DateTimeItem("infoRegisterTime", "信息登记时间");
		infoRegisterTimeItem.setDisabled(true);
		infoRegisterTimeItem.setWidth("*");
		__formItems.add(infoRegisterTimeItem);
		
		projectApprovalTimeItem = new DateTimeItem("projectApprovalTime", "正式立项时间");
		projectApprovalTimeItem.setDisabled(true);
		projectApprovalTimeItem.setWidth("*");
		__formItems.add(projectApprovalTimeItem);
		
		hasContractItem = new CheckboxItem("hasContract", "是否有合同");
		hasContractItem.setDisabled(true);
		hasContractItem.setWidth("*");
		__formItems.add(hasContractItem);
		
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		__formItems.add(projectNameItem);
		
		projectEnglishNameItem = new TextItem("projectEnglishName", "项目英文名称");
		projectEnglishNameItem.setWidth("*");
//		__formItems.add(projectEnglishNameItem);
		
		projectStatusItem = new SelectItem("projectStatus", "项目状态");
		projectStatusItem.setWidth("*");
		projectStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_4"));
//		__formItems.add(projectStatusItem);
		
		designStatusItem = new SelectItem("designStatus", "设计状态");
		designStatusItem.setWidth("*");
		designStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_5"));
		designStatusItem.setWidth("*");
//		__formItems.add(designStatusItem);
		
		signCompanyItem = new SelectItem("signCompany", "拟签约公司");
		signCompanyItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		signCompanyItem.setWidth("*");
		__formItems.add(signCompanyItem);
		
		projectOriginationItem = new TextItem("projectOrigination", "项目来源渠道");
		projectOriginationItem.setWidth("*");
		projectOriginationItem.setCanEdit(false);
		projectOriginationItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_156"));
		__formItems.add(projectOriginationItem);
		
		projectOriginationRemarkItem = new TextItem("projectOriginationRemark", "项目来源说明");
		projectOriginationRemarkItem.setWidth("*");
//		__formItems.add(projectOriginationRemarkItem);
		
		designCooperationNameItem = new TextItem("designCooperationName", "设计合作单位");
		designCooperationNameItem.setWidth("*");
		__formItems.add(designCooperationNameItem);
		
		designCooperationEnglishNameItem = new TextItem("designCooperationEnglishName", "设计合作单位英文名称");
		designCooperationEnglishNameItem.setWidth("*");
//		__formItems.add(designCooperationEnglishNameItem);
		
		projectSalesTeamItem = new TextItem("projectSalesTeam", "项目营销团队");
		projectSalesTeamItem.setWidth("*");
		projectSalesTeamItem.setDisabled(true);
		__formItems.add(projectSalesTeamItem);
		
		designTeamItem = new SelectItem("designTeam", "主办设计团队");
		designTeamItem.setWidth("*");
//		designTeamItem.setDisabled(true);
		designTeamItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		__formItems.add(designTeamItem);
		
		isHighRiseBuildingItem = new CheckboxItem("isHighRiseBuilding", "是否高层建筑");
		isHighRiseBuildingItem.setWidth("*");
		__formItems.add(isHighRiseBuildingItem);
		
		projectBaseOnItem = new SelectItem("projectBaseOn", "立项依据");
		projectBaseOnItem.setWidth("*");
		projectBaseOnItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_28"));
		__formItems.add(projectBaseOnItem);
		
		projectModelItem = new TextItem("projectModel", "立项模式");
		projectModelItem.setWidth("*");
//		__formItems.add(projectModelItem);
		
		designQualificationItem = new TextItem("designQualification", "设计资质章");
		designQualificationItem.setWidth("*");
//		__formItems.add(designQualificationItem);
		
		businessTypeItem = new SelectItem("businessType", "业务类型");
		businessTypeItem.setWidth("*");
		businessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		__formItems.add(businessTypeItem);
		
		projectTypeItem = new SelectItem("projectType", "项目类型");
		projectTypeItem.setWidth("*");
		projectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_244"));
		__formItems.add(projectTypeItem);
		
		fireResistanceRatingItem = new TextItem("fireResistanceRating", "耐火等级");
		fireResistanceRatingItem.setWidth("*");
		__formItems.add(fireResistanceRatingItem);
		
		estimateTheDesignAreasItem = new TextItem("estimateTheDesignAreas", "计容建筑面积(㎡)");
		estimateTheDesignAreasItem.setWidth("*");
		__formItems.add(estimateTheDesignAreasItem);
		
		projectTotalInvestmentItem = new TextItem("projectTotalInvestment", "项目总投资额");
		projectTotalInvestmentItem.setWidth("*");
		__formItems.add(projectTotalInvestmentItem);
		
		actualDesignAreasItem = new TextItem("actualDesignAreas", "实际设计面积");
		actualDesignAreasItem.setWidth("*");
		__formItems.add(actualDesignAreasItem);
		
		totalBuildingAreasItem = new TextItem("totalBuildingAreas", "建筑总面积");
		totalBuildingAreasItem.setWidth("*");
		__formItems.add(totalBuildingAreasItem);
		
		buildingHeightItem = new TextItem("buildingHeight", "建筑高度");
		buildingHeightItem.setWidth("*");
		__formItems.add(buildingHeightItem);
		
		buildingFloorsItem = new TextItem("buildingFloors", "建筑楼层");
		buildingFloorsItem.setWidth("*");
		__formItems.add(buildingFloorsItem);
		
		decorateMoneyControlItem = new TextItem("decorateMoneyControl", "装修造价控制");
		decorateMoneyControlItem.setWidth("*");
		__formItems.add(decorateMoneyControlItem);
		
		projectLevelItem = new SelectItem("projectLevel", "项目等级");
		projectLevelItem.setWidth("*");
		projectLevelItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));
		projectLevelItem.setWidth("*");
		__formItems.add(projectLevelItem);
		
		provinceItem = new TextItem("province", "省份");
		provinceItem.setWidth("*");
		__formItems.add(provinceItem);
		
		cityItem = new TextItem("city", "城市");
		cityItem.setWidth("*");
		__formItems.add(cityItem);
		
		detailAddressItem = new TextItem("detailAddress", "详细地址");
		detailAddressItem.setWidth("*");
		__formItems.add(detailAddressItem);
		
		projectEndTimeItem = new DateItem("projectEndTime", "项目完成时间");
		projectEndTimeItem.setWidth("*");
		__formItems.add(projectEndTimeItem);
		
		clientIdItem = new ComboBoxItem("clientId", "客户名称");
		clientIdItem.setWidth("*");
		clientIdItem.setValueMap(KeyValueManager.getValueMap("customers_name")); 
		__formItems.add(clientIdItem);
		
		customerNameItem = new TextItem("customerName", "客户名称");
		customerNameItem.setWidth("*");
		customerNameItem.hide();
		__formItems.add(customerNameItem);
		
		customerAddressItem = new TextItem("customerAddress", "客户地址");
		customerAddressItem.setWidth("*");
		__formItems.add(customerAddressItem);
		
		bidProjectItem = new TextItem("bidProject", "投标项目");
		bidProjectItem.setWidth("*");
		__formItems.add(bidProjectItem);
		
		constructionUnitItem = new TextItem("constructionUnit", "建设单位");
		constructionUnitItem.setWidth("*");
		__formItems.add(constructionUnitItem);
		
		architecturalDesignUnitsItem = new TextItem("architecturalDesignUnits", "建筑设计单位");
		architecturalDesignUnitsItem.setWidth("*");
		__formItems.add(architecturalDesignUnitsItem);
		
		rateOfBidWinningItem = new TextItem("rateOfBidWinning", "赢率百分比(%)");
		rateOfBidWinningItem.setWidth("*");
//		__formItems.add(rateOfBidWinningItem);
		
		followUpDateItem = new DateTimeItem("followUpDate", "跟进日期");
		followUpDateItem.setWidth("*");
		__formItems.add(followUpDateItem);
		
		orderSignUpTimeItem = new DateTimeItem("orderSignUpTime", "预计签约时间");
		orderSignUpTimeItem.setWidth("*");
		__formItems.add(orderSignUpTimeItem);
		
		designServiceBookItem = new TextItem("designServiceBook", "设计服务书");
		designServiceBookItem.setHidden(true);
		designServiceBookItem.setWidth("*");
//		__formItems.add(designServiceBookItem);
		
		serviceSuggestBookItem = new TextItem("serviceSuggestBook", "服务建议书");
		serviceSuggestBookItem.setHidden(true);
		serviceSuggestBookItem.setWidth("*");
//		__formItems.add(serviceSuggestBookItem);
		
		totalMoneyItem = new TextItem("totalMoney", "报价总金额");
		totalMoneyItem.setHidden(true);
		totalMoneyItem.setWidth("*");
		__formItems.add(totalMoneyItem);
		
		coveredAreaItem = new TextItem("coveredArea", "建筑面积");
		coveredAreaItem.setHidden(true);
		coveredAreaItem.setWidth("*");
		__formItems.add(coveredAreaItem);
		
		designAreaItem = new TextItem("designArea", "设计面积");
		designAreaItem.setHidden(true);
		designAreaItem.setWidth("*");
		__formItems.add(designAreaItem);
		
		equityedgeRemarkItem = new TextItem("equityedgeRemark", "说明");
		equityedgeRemarkItem.setWidth("*");
		__formItems.add(equityedgeRemarkItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(6);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) 
			__form.editRecord(getRecord());
		
			
			
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSMainProject.getInstance());
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
