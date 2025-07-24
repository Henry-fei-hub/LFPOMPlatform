package com.pomplatform.client.settlement.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.employeerole.datasource.DSGetRole93Employees;
import com.pomplatform.client.project.datasource.DSOnLoadProjectOverview;
import com.pomplatform.client.settlement.datasource.DSMprojectppor;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.IsFloatValidator;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;
import com.smartgwt.client.widgets.grid.ListGridField;

public class MprojectpporUpdateForm extends AbstractWizadPage {

	private final TextItem settlementIdItem;
    public final TextItem projectIntegralItem;
    public final TextItem totalAmountItem;
    private final TextItem totalcountItem;
    public final TextItem sureAmountItem;
    public final TextItem leftAmountItem;
    public final TextItem totalCostItem;
    public final TextItem finalAmountItem;
    public final TextItem reserveAmountItem;
    public final DateItem settlementDateItem;
    public final  TextAreaItem settlementRemarkItem;
//    public  SelectItem ourEmployeesItem;

    public MprojectpporUpdateForm() {
        DSMprojectppor ds = DSMprojectppor.getInstance();
        __form.setWidth100();
        __form.setHeight100();
        
        settlementIdItem = new TextItem("settlementId", "id");
        settlementIdItem.setDisabled(true);
        settlementIdItem.setWidth("*");
        settlementIdItem.setHidden(true);
        __formItems.add(settlementIdItem);
        
        projectIntegralItem = new TextItem("projectAmount", "可确认积分");
        projectIntegralItem.setDisabled(true);
        projectIntegralItem.setWidth("*");
        __formItems.add(projectIntegralItem);
        
        sureAmountItem = new TextItem("sureAmount", "已结算积分");
        sureAmountItem.setDisabled(true);
        sureAmountItem.setWidth("*");
        sureAmountItem.setRequired(true);
        __formItems.add(sureAmountItem);
        
        totalAmountItem = new TextItem("totalAmount", "本次结算");
        totalAmountItem.setDisabled(true);
        totalAmountItem.setWidth("*");
        totalAmountItem.setRequired(true);
        IsFloatValidator totalAmountValidator = new IsFloatValidator();
        totalAmountItem.setValidators(totalAmountValidator);
        __formItems.add(totalAmountItem);
        
        leftAmountItem = new TextItem("leftAmount", "项目结余积分");
        leftAmountItem.setDisabled(true);
        leftAmountItem.setWidth("*");
        leftAmountItem.setRequired(true);
        IsFloatValidator  leftAmountValidator = new IsFloatValidator ();
        leftAmountItem.setValidators(leftAmountValidator);
        __formItems.add(leftAmountItem);
        
        finalAmountItem = new TextItem("finalAmount", "未结算项目成本");
        finalAmountItem.setDisabled(true);
        finalAmountItem.setWidth("*");
        finalAmountItem.setRequired(true);
        finalAmountItem.setDefaultValue(0);
        IsIntegerValidator finalAmountValidator = new IsIntegerValidator();
        finalAmountItem.setValidators(finalAmountValidator);
        __formItems.add(finalAmountItem);
        
        totalCostItem = new TextItem("totalCost", "已结算项目成本");
        totalCostItem.setDisabled(true);
        totalCostItem.setWidth("*");
        totalCostItem.setRequired(true);
        IsIntegerValidator totalcostValidator = new IsIntegerValidator();
        totalCostItem.setValidators(totalcostValidator);
        __formItems.add(totalCostItem);
        
        totalcountItem = new TextItem("totalCount", "已结算次数");
        totalcountItem.setDisabled(true);
        totalcountItem.setWidth("*");
        totalcountItem.setRequired(true);
        IsIntegerValidator totalcountValidator = new IsIntegerValidator();
        totalcountItem.setValidators(totalcountValidator);
        __formItems.add(totalcountItem);
        
        reserveAmountItem = new TextItem("reserveAmount", "预留积分");
        reserveAmountItem.setDisabled(true);
        reserveAmountItem.setWidth("*");
        reserveAmountItem.setRequired(true);
        reserveAmountItem.setHidden(true);
        __formItems.add(reserveAmountItem);
        
        settlementDateItem = new DateItem("settlementDate", "结算日期");
        settlementDateItem.setWidth("*");
        settlementDateItem.setDisabled(true);
        settlementDateItem.setDefaultValue(new Date());
        settlementDateItem.setStartDate(new Date());
        settlementDateItem.setUseTextField(true);
        settlementDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
        __formItems.add(settlementDateItem);
        
//		ListGridField eNoField = new ListGridField("employeeNo");
//		ListGridField eNameField = new ListGridField("employeeName");
//		eNameField.setCanFilter(true);
//		ourEmployeesItem = new SelectItem("ourEmployees","审核人");
//		ourEmployeesItem.setWidth("*");
//		ourEmployeesItem.setMultiple(true);
//		ourEmployeesItem.setRequired(true);
//		ourEmployeesItem.setChangeOnKeypress(false);
//		ourEmployeesItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
//		ourEmployeesItem.setOptionDataSource(DSGetRole93Employees.getInstance());
//		ourEmployeesItem.setDefaultToFirstOption(false);
//		ourEmployeesItem.setValueField("employeeId");
//		ourEmployeesItem.setDisplayField("employeeName");
//		ourEmployeesItem.setUseClientFiltering(true);
//		ourEmployeesItem.setPickListFields(eNoField, eNameField);
//        __formItems.add(ourEmployeesItem);
        
        settlementRemarkItem = new TextAreaItem("remark", "结算备注");
        settlementRemarkItem.setWidth("*");
        settlementRemarkItem.setColSpan(6);
        settlementRemarkItem.setRowSpan(3);
        settlementRemarkItem.setRequired(true);
        __formItems.add(settlementRemarkItem);

        __form.setItems(getFormItemArray());
        __form.setDataSource(ds);
        __form.setNumCols(8);
        ClientUtil.DynamicFormProcessAccordingToDevice(__form);
        setPageMode(PAGE_MODE_UPDATE);
        addMember(__form);
    }

    @Override
    public void startEdit() {
        if (getRecord() != null) {
            __form.editRecord(getRecord());
        }
    }

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSOnLoadProjectOverview.getInstance());
        manager.addMember(__form);
    }

    @Override
    public boolean checkData() {
//    	if(BaseHelpUtils.isNullOrEmpty(ourEmployeesItem.getValue())) {
//    		SC.say("请选择审核人");
//    		return false;
//    	}
    	
//    	if(BaseHelpUtils.isNullOrEmpty(settlementRemarkItem.getValue())) {
//    		SC.say("请填写结算备注");
//    		return false;
//    	}
    	
    	//获取剩余积分为负数
    	BigDecimal leftAmount = BaseHelpUtils.getBigDecimalValue(leftAmountItem.getValue());//剩余积分
        if (leftAmount.compareTo(BigDecimal.ZERO) < 0) {
            SC.say("结算积分超过了可分配积分，请重新分配积分");
            return false;
        } 
        if (leftAmount.compareTo(BigDecimal.ZERO) > 0) {
        	SC.say("结算积分比例未达100%，请重新分配积分");
        	return false;
        } 
    	
    	//获取未结算的项目成本
//        BigDecimal finalAmount = BaseHelpUtils.getBigDecimalValue(finalAmountItem.getValue());
//        if(finalAmount.compareTo(BigDecimal.ZERO) > 0){
//            SC.say("提示","您还有未结算的项目成本("+finalAmount+"),请分摊到项目成员");
//            return false;
//        }
        return true;
    }

    @Override
    public java.util.Map getValuesAsMap() {
        return __form.getValues();
    }
    
    private int projectId;
    private int contractId;

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}
    
    
    

}
