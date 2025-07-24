package com.pomplatform.client.ja.ht.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.ja.ht.datasource.DSMainProject;

public class MainProjectNewForm extends AbstractWizadPage
{


	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final TextItem projectEnglishNameItem;
	private final TextItem projectStatusItem;
	private final TextItem designStatusItem;
	private final TextItem signCompanyItem;
	private final TextItem projectOriginationItem;
	private final TextItem projectOriginationRemarkItem;
	private final TextItem designCooperationNameItem;
	private final TextItem designCooperationEnglishNameItem;
	private final TextItem projectSalesTeamItem;
	private final TextItem designTeamItem;
	private final CheckboxItem isHighRiseBuildingItem;
	private final DateTimeItem infoRegisterTimeItem;
	private final DateTimeItem projectApprovalTimeItem;
	private final CheckboxItem hasContractItem;
	private final TextItem projectBaseOnItem;
	private final TextItem infoCodeItem;
	private final TextItem projectModelItem;
	private final TextItem designQualificationItem;
	private final TextItem businessTypeItem;
	private final TextItem fireResistanceRatingItem;
	private final TextItem estimateTheDesignAreasItem;
	private final TextItem projectTotalInvestmentItem;
	private final TextItem actualDesignAreasItem;
	private final TextItem totalBuildingAreasItem;
	private final TextItem buildingHeightItem;
	private final TextItem buildingFloorsItem;
	private final TextItem decorateMoneyControlItem;
	private final TextItem projectLevelItem;
	private final TextItem provinceItem;
	private final TextItem cityItem;
	private final TextItem detailAddressItem;
	private final DateItem projectEndTimeItem;
	private final TextItem projectTypeItem;
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

	public MainProjectNewForm() {
		DSMainProject ds = DSMainProject.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		projectCodeItem = new TextItem("projectCode", "项目编号");
		__formItems.add(projectCodeItem);
		projectNameItem = new TextItem("projectName", "项目名称");
		__formItems.add(projectNameItem);
		projectEnglishNameItem = new TextItem("projectEnglishName", "项目英文名称");
		__formItems.add(projectEnglishNameItem);
		projectStatusItem = new TextItem("projectStatus", "项目状态");
		__formItems.add(projectStatusItem);
		designStatusItem = new TextItem("designStatus", "设计状态");
		__formItems.add(designStatusItem);
		signCompanyItem = new TextItem("signCompany", "拟签约公司");
		__formItems.add(signCompanyItem);
		projectOriginationItem = new TextItem("projectOrigination", "项目来源渠道");
		__formItems.add(projectOriginationItem);
		projectOriginationRemarkItem = new TextItem("projectOriginationRemark", "项目来源说明");
		__formItems.add(projectOriginationRemarkItem);
		designCooperationNameItem = new TextItem("designCooperationName", "设计合作单位");
		__formItems.add(designCooperationNameItem);
		designCooperationEnglishNameItem = new TextItem("designCooperationEnglishName", "设计合作单位英文名称");
		__formItems.add(designCooperationEnglishNameItem);
		projectSalesTeamItem = new TextItem("projectSalesTeam", "项目营销团队");
		__formItems.add(projectSalesTeamItem);
		designTeamItem = new TextItem("designTeam", "主办设计团队");
		__formItems.add(designTeamItem);
		isHighRiseBuildingItem = new CheckboxItem("isHighRiseBuilding", "是否高层建筑");
		__formItems.add(isHighRiseBuildingItem);
		infoRegisterTimeItem = new DateTimeItem("infoRegisterTime", "信息登记时间");
		__formItems.add(infoRegisterTimeItem);
		projectApprovalTimeItem = new DateTimeItem("projectApprovalTime", "正式立项时间");
		__formItems.add(projectApprovalTimeItem);
		hasContractItem = new CheckboxItem("hasContract", "是否有合同");
		__formItems.add(hasContractItem);
		projectBaseOnItem = new TextItem("projectBaseOn", "立项依据0未知、  1投标立项、 2合同立项、  3委托函立项");
		__formItems.add(projectBaseOnItem);
		infoCodeItem = new TextItem("infoCode", "信息编号");
		__formItems.add(infoCodeItem);
		projectModelItem = new TextItem("projectModel", "立项模式");
		__formItems.add(projectModelItem);
		designQualificationItem = new TextItem("designQualification", "设计资质章");
		__formItems.add(designQualificationItem);
		businessTypeItem = new TextItem("businessType", "业务类别");
		__formItems.add(businessTypeItem);
		fireResistanceRatingItem = new TextItem("fireResistanceRating", "耐火等级");
		__formItems.add(fireResistanceRatingItem);
		estimateTheDesignAreasItem = new TextItem("estimateTheDesignAreas", "计容建筑面积(㎡)");
		__formItems.add(estimateTheDesignAreasItem);
		projectTotalInvestmentItem = new TextItem("projectTotalInvestment", "项目总投资额");
		__formItems.add(projectTotalInvestmentItem);
		actualDesignAreasItem = new TextItem("actualDesignAreas", "实际设计面积");
		__formItems.add(actualDesignAreasItem);
		totalBuildingAreasItem = new TextItem("totalBuildingAreas", "建筑总面积");
		__formItems.add(totalBuildingAreasItem);
		buildingHeightItem = new TextItem("buildingHeight", "建筑高度");
		__formItems.add(buildingHeightItem);
		buildingFloorsItem = new TextItem("buildingFloors", "建筑楼层");
		__formItems.add(buildingFloorsItem);
		decorateMoneyControlItem = new TextItem("decorateMoneyControl", "装修造价控制");
		__formItems.add(decorateMoneyControlItem);
		projectLevelItem = new TextItem("projectLevel", "项目等级");
		__formItems.add(projectLevelItem);
		provinceItem = new TextItem("province", "省份");
		__formItems.add(provinceItem);
		cityItem = new TextItem("city", "城市");
		__formItems.add(cityItem);
		detailAddressItem = new TextItem("detailAddress", "详细地址");
		__formItems.add(detailAddressItem);
		projectEndTimeItem = new DateItem("projectEndTime", "项目完成时间");
		__formItems.add(projectEndTimeItem);
		projectTypeItem = new TextItem("projectType", "项目类别");
		__formItems.add(projectTypeItem);
		customerNameItem = new TextItem("customerName", "客户名称");
		__formItems.add(customerNameItem);
		customerAddressItem = new TextItem("customerAddress", "客户地址");
		__formItems.add(customerAddressItem);
		bidProjectItem = new TextItem("bidProject", "投标项目");
		__formItems.add(bidProjectItem);
		constructionUnitItem = new TextItem("constructionUnit", "建设单位");
		__formItems.add(constructionUnitItem);
		architecturalDesignUnitsItem = new TextItem("architecturalDesignUnits", "建筑设计单位");
		__formItems.add(architecturalDesignUnitsItem);
		rateOfBidWinningItem = new TextItem("rateOfBidWinning", "百分比");
		__formItems.add(rateOfBidWinningItem);
		followUpDateItem = new DateTimeItem("followUpDate", "跟进日期");
		__formItems.add(followUpDateItem);
		equityedgeRemarkItem = new TextItem("equityedgeRemark", "说明");
		__formItems.add(equityedgeRemarkItem);
		orderSignUpTimeItem = new DateTimeItem("orderSignUpTime", "预计签约时间");
		__formItems.add(orderSignUpTimeItem);
		designServiceBookItem = new TextItem("designServiceBook", "设计服务书");
		__formItems.add(designServiceBookItem);
		serviceSuggestBookItem = new TextItem("serviceSuggestBook", "服务建议书");
		__formItems.add(serviceSuggestBookItem);
		totalMoneyItem = new TextItem("totalMoney", "报价总金额");
		__formItems.add(totalMoneyItem);
		coveredAreaItem = new TextItem("coveredArea", "建筑面积");
		__formItems.add(coveredAreaItem);
		designAreaItem = new TextItem("designArea", "设计面积");
		__formItems.add(designAreaItem);

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
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSMainProject.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
