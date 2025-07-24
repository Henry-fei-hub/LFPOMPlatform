package com.pomplatform.client.stagemodel.form;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.stagemodel.datasource.DSContractStageAuditManager;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;

public class ContractStageAuditDesignerUpdateForm extends AbstractWizadPage
{


	private final TextItem contractStageModelIdItem;
	private final TextItem contractIdItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem stageModelNameItem;
	private final CheckboxItem lockedItem;
	private final TextItem auditStatusItem;
	private final TextAreaItem remarkItem;
	private final TextAreaItem designDirectorCommentItem;
	private final TextItem businessTypeItem;
	private final TextItem parentStageNameItem;

	public ContractStageAuditDesignerUpdateForm() {
		DSContractStageAuditManager ds = DSContractStageAuditManager.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		contractStageModelIdItem = new TextItem("contractStageModelId", "主键编码");
		contractStageModelIdItem.setDisabled(true);
		contractStageModelIdItem.setRequired(true);
		contractStageModelIdItem.hide();
		IsIntegerValidator contractStageModelIdValidator = new IsIntegerValidator();
		contractStageModelIdItem.setValidators(contractStageModelIdValidator);
		__formItems.add(contractStageModelIdItem);
		
		contractIdItem = new TextItem("contractId", "合同");
		contractIdItem.hide();
		__formItems.add(contractIdItem);
		
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		__formItems.add(contractCodeItem);
		
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		__formItems.add(contractNameItem);
		
		businessTypeItem = new TextItem("businessType", "项目类别");
		businessTypeItem.setWidth("*");
		__formItems.add(businessTypeItem);
		
		parentStageNameItem = new TextItem("parentStageName", "设计阶段");
		parentStageNameItem.setWidth("*");
		__formItems.add(parentStageNameItem);
		
		stageModelNameItem = new TextItem("stageModelName", "节点名称");
		stageModelNameItem.setWidth("*");
		__formItems.add(stageModelNameItem);
		
		lockedItem = new CheckboxItem("locked", "是否锁定");
		lockedItem.hide();
		__formItems.add(lockedItem);
		
		auditStatusItem = new TextItem("auditStatus", "审批状态");
		auditStatusItem.hide();
		__formItems.add(auditStatusItem);
		
		remarkItem = new TextAreaItem("remark");
		remarkItem.setWidth("*");
		remarkItem.setHeight(250);
		__formItems.add(remarkItem);
		
		designDirectorCommentItem = new TextAreaItem("designDirectorComment", "审批意见");
		designDirectorCommentItem.setWidth("*");
		designDirectorCommentItem.setHeight(150);
		designDirectorCommentItem.hide();
		__formItems.add(designDirectorCommentItem);
		
		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		remarkItem.setColSpan(4);
		remarkItem.setRowSpan(4);

		designDirectorCommentItem.setColSpan(4);
		designDirectorCommentItem.setRowSpan(4);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null){
			Record originalRecord = getRecord();
			int contractStageModelId = BaseHelpUtils.getIntValue(originalRecord.getAttributeAsObject("contractStageModelId"));
			Map<String, Object> params = new HashMap<>();
			params.put("optType", "loadAuditData");
			params.put("contractStageModelId", contractStageModelId);
			DBDataSource.callOperation("EP_StageModelProcessor", "find", params, new DSCallback() {
				
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0){
						Record record = dsResponse.getData()[0];
						record.setAttribute("contractCode", originalRecord.getAttribute("contractCode"));
						record.setAttribute("contractName", originalRecord.getAttribute("contractName"));
						__form.editRecord(record);
						String stageName = record.getAttribute("stageModelName");
						if(stageName.indexOf("评审") >= 0){
							remarkItem.setTitle("评审结论<font style='color:red'>（根据实际情况对文字做调整）</font>");
							designDirectorCommentItem.show();
						}else if(stageName.indexOf("输出") >= 0){
							remarkItem.setTitle("设计输出信息<font style='color:red'>（根据实际情况对文字做调整）</font>");
						}else if(stageName.indexOf("输入") >= 0){
							remarkItem.setTitle("设计输入信息<font style='color:red'>（根据实际情况对文字做调整）</font>");
						}
						setRecord(record);
					}
				}
			});
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSContractStageAuditManager.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		if(null != getRecord()){
			String stageName = record.getAttribute("stageModelName");
			if(BaseHelpUtils.isNullOrEmpty(remarkItem.getValue())){
				if(stageName.indexOf("评审") >= 0){
					SC.say("评审结论不能为空");
				}else if(stageName.indexOf("输出") >= 0){
					SC.say("设计输出信息不能为空");
				}else if(stageName.indexOf("输入") >= 0){
					SC.say("设计输入信息不能为空");
				}
				return false;
			}
			if(stageName.indexOf("评审") >= 0 && BaseHelpUtils.isNullOrEmpty(designDirectorCommentItem.getValue())){
				SC.say(designDirectorCommentItem.getTitle()+"不能为空");
				return false;
			}
		}
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map map = __form.getValues(); 
		map.put("optType", "designDirectorAudit");
		return map;
	}


}
