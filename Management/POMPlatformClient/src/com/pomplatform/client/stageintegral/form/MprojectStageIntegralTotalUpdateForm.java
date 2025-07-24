package com.pomplatform.client.stageintegral.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.stageintegral.datasource.DSMprojectStageIntegralTotal;

public class MprojectStageIntegralTotalUpdateForm extends AbstractWizadPage
{
	private final TextItem projectStageRecordIdItem;
	private final SelectItem projectIdItem;
	private final SelectItem stageIdItem;
	private final TextItem stageIntegralItem;
	private final TextItem stageSureIntegralItem;
	private final TextItem projectIntegralItem;
	private final TextItem projectSureIntegralItem;
	public final TextItem stageFinalIntegralItem;
	private final TextItem projectFinalIntegralItem;
        public final DateItem settlementDateItem;

	public MprojectStageIntegralTotalUpdateForm() {
		DSMprojectStageIntegralTotal ds = DSMprojectStageIntegralTotal.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		projectStageRecordIdItem = new TextItem("projectStageRecordId", "主键编码");
		projectStageRecordIdItem.setWidth("*");
		projectStageRecordIdItem.setDisabled(true);
		projectStageRecordIdItem.setRequired(true);
                projectStageRecordIdItem.hide();
		IsIntegerValidator projectStageRecordIdValidator = new IsIntegerValidator();
		projectStageRecordIdItem.setValidators(projectStageRecordIdValidator);
		__formItems.add(projectStageRecordIdItem);
		projectIdItem = new SelectItem("projectId", "项目");
                projectIdItem.hide();
		projectIdItem.setValueMap((LinkedHashMap)ds.getField("projectId").getValueMap());
		__formItems.add(projectIdItem);
		stageIdItem = new SelectItem("stageId", "项目阶段");
		stageIdItem.setWidth("*");
                stageIdItem.setDisabled(true);
                stageIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));
		__formItems.add(stageIdItem);
		stageIntegralItem = new TextItem("stageIntegral", "阶段积分");
		stageIntegralItem.setWidth("*");
                stageIntegralItem.setDisabled(true);
		stageIntegralItem.setRequired(true);
		IsFloatValidator stageIntegralValidator = new IsFloatValidator();
		stageIntegralItem.setValidators(stageIntegralValidator);
		__formItems.add(stageIntegralItem);
		stageSureIntegralItem = new TextItem("stageSureIntegral", "已确认阶段积分");
		stageSureIntegralItem.setWidth("*");
                stageSureIntegralItem.setDisabled(true);
		stageSureIntegralItem.setRequired(true);
		IsFloatValidator stageSureIntegralValidator = new IsFloatValidator();
		stageSureIntegralItem.setValidators(stageSureIntegralValidator);
		__formItems.add(stageSureIntegralItem);
                
                stageFinalIntegralItem = new TextItem("stageFinalIntegral", "未确认阶段积分");
		stageFinalIntegralItem.setWidth("*");
                stageFinalIntegralItem.setDisabled(true);
		stageFinalIntegralItem.setRequired(true);
		IsFloatValidator stageFinalIntegralValidator = new IsFloatValidator();
		stageFinalIntegralItem.setValidators(stageFinalIntegralValidator);
		__formItems.add(stageFinalIntegralItem);
                
		projectIntegralItem = new TextItem("projectIntegral", "项目积分");
                projectIntegralItem.setDisabled(true);
		projectIntegralItem.setWidth("*");
		__formItems.add(projectIntegralItem);
		projectSureIntegralItem = new TextItem("projectSureIntegral", "已确认项目积分");
		projectSureIntegralItem.setWidth("*");
                projectSureIntegralItem.setDisabled(true);
		projectSureIntegralItem.setRequired(true);
		IsFloatValidator projectSureIntegralValidator = new IsFloatValidator();
		projectSureIntegralItem.setValidators(projectSureIntegralValidator);
		__formItems.add(projectSureIntegralItem);
		
		projectFinalIntegralItem = new TextItem("projectFinalIntegral", "未确认项目积分");
		projectFinalIntegralItem.setWidth("*");
                projectFinalIntegralItem.setDisabled(true);
		projectFinalIntegralItem.setRequired(true);
		IsFloatValidator projectFinalIntegralValidator = new IsFloatValidator();
		projectFinalIntegralItem.setValidators(projectFinalIntegralValidator);
		__formItems.add(projectFinalIntegralItem);
                
                settlementDateItem = new DateItem("settlementDate", "结算日期");
                settlementDateItem.setDefaultValue(new Date());
                settlementDateItem.setWidth("*");
                __formItems.add(settlementDateItem);

                TextAreaItem settlementRemark = new TextAreaItem("settlementRemark", "结算备注");
                settlementRemark.setWidth("*");
                settlementRemark.setColSpan(6);
                settlementRemark.setRowSpan(4);
                settlementRemark.setRequired(true);
                __formItems.add(settlementRemark);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(8);
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
		manager.setDataSource(DSMprojectStageIntegralTotal.getInstance());
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
