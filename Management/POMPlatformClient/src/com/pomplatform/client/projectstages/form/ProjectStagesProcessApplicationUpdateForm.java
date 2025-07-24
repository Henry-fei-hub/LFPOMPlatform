package com.pomplatform.client.projectstages.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.projectstages.datasource.DSProjectStagesProcessApplication;

public class ProjectStagesProcessApplicationUpdateForm extends AbstractWizadPage
{


	private final TextItem projectStageProcessRecordIdItem;
	private final TextItem contractIdItem;
	private final TextItem mainProjectIdItem;
	private final TextItem projectNameItem;
	private final TextItem projectCodeItem;
	private final TextItem projectAmountSumItem;
	private final TextItem applyAmountItem;
	private final TextItem fileIdItem;
	private final TextItem fileUrlItem;
	private final TextItem remarkItem;

	public ProjectStagesProcessApplicationUpdateForm() {
		DSProjectStagesProcessApplication ds = DSProjectStagesProcessApplication.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		projectStageProcessRecordIdItem = new TextItem("projectStageProcessRecordId", "id");
		projectStageProcessRecordIdItem.setDisabled(true);
		projectStageProcessRecordIdItem.setRequired(true);
		IsIntegerValidator projectStageProcessRecordIdValidator = new IsIntegerValidator();
		projectStageProcessRecordIdItem.setValidators(projectStageProcessRecordIdValidator);
		__formItems.add(projectStageProcessRecordIdItem);
		contractIdItem = new TextItem("contractId", "contract_id");
		__formItems.add(contractIdItem);
		mainProjectIdItem = new TextItem("mainProjectId", "main_project_id");
		__formItems.add(mainProjectIdItem);
		projectNameItem = new TextItem("projectName", "项目名称");
		__formItems.add(projectNameItem);
		projectCodeItem = new TextItem("projectCode", "项目编号");
		__formItems.add(projectCodeItem);
		projectAmountSumItem = new TextItem("projectAmountSum", "订单积分");
		__formItems.add(projectAmountSumItem);
		applyAmountItem = new TextItem("applyAmount", "本次申请的积分");
		__formItems.add(applyAmountItem);
		fileIdItem = new TextItem("fileId", "file_id");
		__formItems.add(fileIdItem);
		fileUrlItem = new TextItem("fileUrl", "file_url");
		__formItems.add(fileUrlItem);
		remarkItem = new TextItem("remark", "备注");
		__formItems.add(remarkItem);

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
		manager.setDataSource(DSProjectStagesProcessApplication.getInstance());
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
