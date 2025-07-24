package com.pomplatform.client.mainprojectinfo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.mainprojectinfo.datasource.DSMainProjectInfo;

public class MainProjectInfoGroupname2Update extends AbstractWizadPage {

    private final TextItem projectOriginationItem;
    private final TextItem projectOriginationRemarkItem;
    private final TextItem designCooperationNameItem;
    private final TextItem designCooperationEnglishNameItem;
    private final TextItem projectSalesTeamItem;
    private final ComboBoxItem projectSalesmanItem;
    private final ComboBoxItem projectSalesTeamManagerItem;
    private final ComboBoxItem designTeamItem;
    private final DateTimeItem infoRegisterTimeItem;
    private final DateTimeItem projectApprovalTimeItem;
    private final ComboBoxItem projectManagerItem;
    private final ComboBoxItem projectLeaderItem;
    private final CheckboxItem hasContractItem;
    private final SelectItem projectBaseOnItem;
    private final TextItem projectModelItem;
    private final TextItem designQualificationItem;
    private final TextItem businessTypeItem;
    private final TextItem provinceItem;
    private final TextItem cityItem;
    private final TextItem detailAddressItem;

    public MainProjectInfoGroupname2Update() {
        DSMainProjectInfo ds = DSMainProjectInfo.getInstance();
        __form.setWidth100();
        __form.setHeight100();
        projectOriginationItem = new TextItem("projectOrigination", "项目来源渠道");
        projectOriginationItem.setWidth("*");
        __formItems.add(projectOriginationItem);
        projectOriginationRemarkItem = new TextItem("projectOriginationRemark", "项目来源说明");
        projectOriginationRemarkItem.setWidth("*");
        __formItems.add(projectOriginationRemarkItem);
        designCooperationNameItem = new TextItem("designCooperationName", "设计合作单位");
        designCooperationNameItem.setWidth("*");
        __formItems.add(designCooperationNameItem);
        designCooperationEnglishNameItem = new TextItem("designCooperationEnglishName", "设计合作单位英文名称");
        designCooperationEnglishNameItem.setWidth("*");
        __formItems.add(designCooperationEnglishNameItem);
        projectSalesTeamItem = new TextItem("projectSalesTeam", "项目营销团队");
        projectSalesTeamItem.setWidth("*");
        __formItems.add(projectSalesTeamItem);
        projectSalesmanItem = new ComboBoxItem("projectSalesman", "项目营销员");
        projectSalesmanItem.setWidth("*");
        projectSalesmanItem.setChangeOnKeypress(false);
        projectSalesmanItem.setValueMap((LinkedHashMap) ds.getField("projectSalesman").getValueMap());
        __formItems.add(projectSalesmanItem);
        projectSalesTeamManagerItem = new ComboBoxItem("projectSalesTeamManager", "运营董事");
        projectSalesTeamManagerItem.setWidth("*");
        projectSalesTeamManagerItem.setChangeOnKeypress(false);
        projectSalesTeamManagerItem.setValueMap((LinkedHashMap) ds.getField("projectSalesTeamManager").getValueMap());
        __formItems.add(projectSalesTeamManagerItem);
        designTeamItem = new ComboBoxItem("designTeam", "主办设计团队");
        designTeamItem.setWidth("*");
        designTeamItem.setChangeOnKeypress(false);
        designTeamItem.setValueMap((LinkedHashMap) ds.getField("designTeam").getValueMap());
        __formItems.add(designTeamItem);
        infoRegisterTimeItem = new DateTimeItem("infoRegisterTime", "信息登记时间");
        infoRegisterTimeItem.setWidth("*");
        __formItems.add(infoRegisterTimeItem);
        projectApprovalTimeItem = new DateTimeItem("projectApprovalTime", "正式立项时间");
        projectApprovalTimeItem.setWidth("*");
        __formItems.add(projectApprovalTimeItem);
        projectManagerItem = new ComboBoxItem("projectManager", "项目经理");
        projectManagerItem.setChangeOnKeypress(false);
        projectManagerItem.setValueMap((LinkedHashMap) ds.getField("projectManager").getValueMap());
        projectManagerItem.setWidth("*");
        __formItems.add(projectManagerItem);
        projectLeaderItem = new ComboBoxItem("projectLeader", "项目主管领导");
        projectLeaderItem.setWidth("*");
        projectLeaderItem.setChangeOnKeypress(false);
        projectLeaderItem.setValueMap((LinkedHashMap) ds.getField("projectLeader").getValueMap());
        __formItems.add(projectLeaderItem);
        projectBaseOnItem = new SelectItem("projectBaseOn", "立项依据");
        projectBaseOnItem.setWidth("*");
        projectBaseOnItem.setValueMap((LinkedHashMap) ds.getField("projectBaseOn").getValueMap());
        __formItems.add(projectBaseOnItem);
        projectModelItem = new TextItem("projectModel", "立项模式");
        projectModelItem.setWidth("*");
        __formItems.add(projectModelItem);
        designQualificationItem = new TextItem("designQualification", "设计资质章");
        designQualificationItem.setWidth("*");
        __formItems.add(designQualificationItem);
        businessTypeItem = new TextItem("businessType", "业务类别");
        businessTypeItem.setWidth("*");
        __formItems.add(businessTypeItem);
        hasContractItem = new CheckboxItem("hasContract", "是否有合同");
        __formItems.add(hasContractItem);
        provinceItem = new TextItem("province", "省份");
        provinceItem.setWidth("*");
        __formItems.add(provinceItem);
        cityItem = new TextItem("city", "城市");
        cityItem.setWidth("*");
        __formItems.add(cityItem);
        detailAddressItem = new TextItem("detailAddress", "详细地址");
        detailAddressItem.setWidth("*");
        __formItems.add(detailAddressItem);

        __form.setItems(getFormItemArray());
        __form.setDataSource(ds);
        __form.setNumCols(4);
        ClientUtil.DynamicFormProcessAccordingToDevice(__form);
        setPageMode(PAGE_MODE_UPDATE);
        setName("项目详情2");
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
