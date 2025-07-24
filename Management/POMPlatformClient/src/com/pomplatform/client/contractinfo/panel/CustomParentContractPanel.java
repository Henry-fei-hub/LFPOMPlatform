package com.pomplatform.client.contractinfo.panel;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.contractinfo.datasource.DSContractInfo;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;
import com.smartgwt.client.widgets.form.validator.IsStringValidator;
import com.smartgwt.client.widgets.form.validator.LengthRangeValidator;

public class CustomParentContractPanel extends AbstractWizadPage {
    private final Logger __logger = Logger.getLogger("");
    private final TextItem contractIdItem;
    private final TextItem contractCodeItem;
    private final TextItem contractNameItem;
    private final TextItem customerNameItem;
    private final TextItem startDateItem;
    private final TextItem endDateItem;
    private final TextItem statusItem;
    private final TextItem projectCodeItem;
    private final TextItem contractTypeItem;
    private final TextItem businessTypeItem;
    private final TextItem projectLevelItem;
    private final TextItem totalProjectTimeItem;
    private final TextItem signingMoneySumItem;
    private final TextItem designAreasItem;
//    private final TextItem contractPriceItem;
    private final TextItem projectAddressItem;
    private final TextItem contractFollowerItem;
    private final TextItem remarkItem;
    private final TextItem contractDateItem;
    private final TextItem signingCompanyNameItem;
    private final TextItem flowStatusItem;
    private final TextItem createTimeItem;
    private final TextItem updateTimeItem;
    public static class Factory implements PanelFactory {
    	
        private String id;

        @Override
        public Canvas create() {
            CustomParentContractPanel cm = new CustomParentContractPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "CustomParentContract";
        }

    }
    
    public CustomParentContractPanel(){
    	DSContractInfo ds = DSContractInfo.getInstance();
        __form.setWidth100();
        __form.setHeight100();
        contractIdItem = new TextItem("contractId", "合同编码");
        contractIdItem.setWidth("*");
        contractIdItem.setDisabled(true);
        contractIdItem.setRequired(true);
        contractIdItem.hide();
        __formItems.add(contractIdItem);
        contractCodeItem = new TextItem("contractCode", "合同编号");
        contractCodeItem.setWidth("*");
        contractCodeItem.setDisabled(Boolean.TRUE);
        __formItems.add(contractCodeItem);
        contractNameItem = new TextItem("contractName", "合同名称");
        contractNameItem.setWidth("*");
        contractNameItem.setDisabled(Boolean.TRUE);
        __formItems.add(contractNameItem);
        customerNameItem = new TextItem("customerName", "客户名称");
        customerNameItem.setWidth("*");
        customerNameItem.setValueMap(KeyValueManager.getValueMap("customers_name"));
        customerNameItem.setDisabled(Boolean.TRUE);
        __formItems.add(customerNameItem);
        signingCompanyNameItem = new TextItem("signingCompanyName", "我方签约公司名称");
        signingCompanyNameItem.setWidth("*");
        signingCompanyNameItem.setDisabled(Boolean.TRUE);
        __formItems.add(signingCompanyNameItem);
        projectCodeItem = new TextItem("projectCode", "项目编号");
        projectCodeItem.setWidth("*");
        projectCodeItem.setDisabled(Boolean.TRUE);
        __formItems.add(projectCodeItem);
        contractFollowerItem = new TextItem("contractFollower", "合同跟进人");
        contractFollowerItem.setWidth("*");
        contractFollowerItem.setDisabled(Boolean.TRUE);
        __formItems.add(contractFollowerItem);
        statusItem = new TextItem("status", "结算状态");
        statusItem.setWidth("*");
        statusItem.setHidden(Boolean.TRUE);
        __formItems.add(statusItem);
        contractTypeItem = new TextItem("contractType", "合同类别");
        contractTypeItem.setWidth("*");
        contractTypeItem.setDisabled(Boolean.TRUE);
//        __formItems.add(contractTypeItem);
        businessTypeItem = new TextItem("businessType", "业务类别");
        businessTypeItem.setWidth("*");
        businessTypeItem.setDisabled(true);
//        __formItems.add(businessTypeItem);
        projectLevelItem = new TextItem("projectLevel", "项目等级");
        projectLevelItem.setWidth("*");
        projectLevelItem.setDisabled(Boolean.TRUE);
        __formItems.add(projectLevelItem);
        contractDateItem = new TextItem("contractDate", "合同签订日期");
        contractDateItem.setWidth("*");
        contractDateItem.setDisabled(Boolean.TRUE);
        __formItems.add(contractDateItem);
        startDateItem = new TextItem("startDate", "开始日期");
        startDateItem.setWidth("*");
        startDateItem.setHidden(Boolean.TRUE);
        __formItems.add(startDateItem);
        endDateItem = new TextItem("endDate", "结束日期");
        endDateItem.setWidth("*");
        endDateItem.setHidden(Boolean.TRUE);
        __formItems.add(endDateItem);
        totalProjectTimeItem = new TextItem("totalProjectTime", "项目总工期");
        totalProjectTimeItem.setWidth("*");
        totalProjectTimeItem.setDisabled(Boolean.TRUE);
        __formItems.add(totalProjectTimeItem);
        designAreasItem = new TextItem("designAreas", "总设计面积");
        designAreasItem.setWidth("*");
        designAreasItem.setDisabled(Boolean.TRUE);
        __formItems.add(designAreasItem);
//        contractPriceItem = new TextItem("contractPrice", "合同单价");
//        contractPriceItem.setWidth("*");
//        contractPriceItem.setDisabled(Boolean.TRUE);
//        __formItems.add(contractPriceItem);
        signingMoneySumItem = new TextItem("signingMoneySum", "签约总金额");
        signingMoneySumItem.setWidth("*");
        signingMoneySumItem.setDisabled(Boolean.TRUE);
        __formItems.add(signingMoneySumItem);
        projectAddressItem = new TextItem("projectAddress", "项目地点");
        projectAddressItem.setWidth("*");
        projectAddressItem.setDisabled(Boolean.TRUE);
        __formItems.add(projectAddressItem);
        remarkItem = new TextItem("remark", "备注");
        remarkItem.setWidth("*");
        remarkItem.setDisabled(Boolean.TRUE);
        __formItems.add(remarkItem);
        flowStatusItem = new TextItem("flowStatus", "审核状态");
        flowStatusItem.setWidth("*");
        flowStatusItem.setHidden(Boolean.TRUE);
        __formItems.add(flowStatusItem);
        createTimeItem = new TextItem("createTime", "创建时间");
        createTimeItem.setWidth("*");
        createTimeItem.setDisabled(Boolean.TRUE);
        __formItems.add(createTimeItem);
        updateTimeItem = new TextItem("updateTime", "修改时间");
        updateTimeItem.setWidth("*");
        updateTimeItem.setHidden(Boolean.TRUE);
        __formItems.add(updateTimeItem);
        
        __form.setItems(getFormItemArray());
        __form.setDataSource(ds);
        __form.setNumCols(1);
        ClientUtil.DynamicFormProcessAccordingToDevice(__form);
        setPageMode(PAGE_TYPE_DETAIL);
        setBorder("1px solid #ABABAB");
        setPadding(0);
        setName("合同详情");
        addMember(__form);
    }

	@Override
	public Map getValuesAsMap() {
		return null;
	}

	@Override
	public boolean checkData() {
		return false;
	}

	@Override
	public void startEdit() {
		if(null != getRecord()){
			__form.editRecord(getRecord());
		}
	}


}
