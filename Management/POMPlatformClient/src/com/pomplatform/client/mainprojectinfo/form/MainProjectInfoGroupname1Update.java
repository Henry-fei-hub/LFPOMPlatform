package com.pomplatform.client.mainprojectinfo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.mainprojectinfo.datasource.DSMainProjectInfo;

public class MainProjectInfoGroupname1Update extends AbstractWizadPage {

    private final TextItem mainProjectIdItem;
    private final TextItem infoCodeItem;
    private final TextItem projectCodeItem;
    private final TextItem projectNameItem;
    private final TextItem projectEnglishNameItem;
    private final TextItem projectStatusItem;
    private final TextItem designStatusItem;
    private final SelectItem signCompanyItem;
    private final CheckboxItem isHighRiseBuildingItem;
    private final TextItem projectTotalInvestmentItem;
    private final TextItem decorateMoneyControlItem;
    private final TextItem totalBuildingAreasItem;
    private final TextItem estimateTheDesignAreasItem;
    private final TextItem actualDesignAreasItem;
    private final TextItem buildingFloorsItem;
    private final TextItem buildingHeightItem;
    private final TextItem fireResistanceRatingItem;
    private final SelectItem projectLevelItem;
    private final DateItem projectEndTimeItem;

    public MainProjectInfoGroupname1Update() {
        DSMainProjectInfo ds = DSMainProjectInfo.getInstance();
        __form.setWidth100();
        __form.setHeight100();
        mainProjectIdItem = new TextItem("mainProjectId", "主键编码");
        mainProjectIdItem.setWidth("*");
        mainProjectIdItem.setDisabled(true);
        mainProjectIdItem.setRequired(true);
        mainProjectIdItem.hide();
        IsIntegerValidator mainProjectIdValidator = new IsIntegerValidator();
        mainProjectIdItem.setValidators(mainProjectIdValidator);
        __formItems.add(mainProjectIdItem);
        infoCodeItem = new TextItem("infoCode", "信息编号");
        infoCodeItem.setWidth("*");
        __formItems.add(infoCodeItem);
        projectCodeItem = new TextItem("projectCode", "项目编号");
        projectCodeItem.setWidth("*");
        __formItems.add(projectCodeItem);
        projectNameItem = new TextItem("projectName", "项目名称");
        projectNameItem.setWidth("*");
        __formItems.add(projectNameItem);
        projectEnglishNameItem = new TextItem("projectEnglishName", "项目英文名称");
        projectEnglishNameItem.setWidth("*");
        __formItems.add(projectEnglishNameItem);
        designStatusItem = new TextItem("designStatus", "设计状态");
        designStatusItem.setWidth("*");
        __formItems.add(designStatusItem);
        signCompanyItem = new SelectItem("signCompany", "拟签约公司");
        signCompanyItem.setWidth("*");
        signCompanyItem.setValueMap((LinkedHashMap) ds.getField("signCompany").getValueMap());
        __formItems.add(signCompanyItem);
        projectStatusItem = new TextItem("projectStatus", "项目状态");
        projectStatusItem.setWidth("*");
        __formItems.add(projectStatusItem);
        isHighRiseBuildingItem = new CheckboxItem("isHighRiseBuilding", "是否高层建筑");
        __formItems.add(isHighRiseBuildingItem);
        projectTotalInvestmentItem = new TextItem("projectTotalInvestment", "项目总投资额");
        projectTotalInvestmentItem.setWidth("*");
        __formItems.add(projectTotalInvestmentItem);
        decorateMoneyControlItem = new TextItem("decorateMoneyControl", "装修造价控制");
        decorateMoneyControlItem.setWidth("*");
        __formItems.add(decorateMoneyControlItem);
        totalBuildingAreasItem = new TextItem("totalBuildingAreas", "建筑总面积");
        totalBuildingAreasItem.setWidth("*");
        __formItems.add(totalBuildingAreasItem);
        estimateTheDesignAreasItem = new TextItem("estimateTheDesignAreas", "计容建筑面积(㎡)");
        estimateTheDesignAreasItem.setWidth("*");
        __formItems.add(estimateTheDesignAreasItem);
        actualDesignAreasItem = new TextItem("actualDesignAreas", "实际设计面积");
        actualDesignAreasItem.setWidth("*");
        __formItems.add(actualDesignAreasItem);
        buildingFloorsItem = new TextItem("buildingFloors", "建筑楼层");
        buildingFloorsItem.setWidth("*");
        __formItems.add(buildingFloorsItem);
        buildingHeightItem = new TextItem("buildingHeight", "建筑高度");
        buildingHeightItem.setWidth("*");
        __formItems.add(buildingHeightItem);
        fireResistanceRatingItem = new TextItem("fireResistanceRating", "耐火等级");
        fireResistanceRatingItem.setWidth("*");
        __formItems.add(fireResistanceRatingItem);
        projectLevelItem = new SelectItem("projectLevel", "项目等级");
        projectLevelItem.setValueMap((LinkedHashMap) ds.getField("projectLevel").getValueMap());
        __formItems.add(projectLevelItem);
        projectEndTimeItem = new DateItem("projectEndTime", "项目完成时间");
        __formItems.add(projectEndTimeItem);

        __form.setItems(getFormItemArray());
        __form.setDataSource(ds);
        __form.setNumCols(4);
        ClientUtil.DynamicFormProcessAccordingToDevice(__form);
        setPageMode(PAGE_MODE_UPDATE);
        setName("项目详情1");
        addMember(__form);
    }

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSMainProjectInfo.getInstance());
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
