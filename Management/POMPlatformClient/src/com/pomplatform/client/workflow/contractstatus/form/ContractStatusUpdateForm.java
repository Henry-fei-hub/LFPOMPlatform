package com.pomplatform.client.workflow.contractstatus.form;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.pomplatform.client.workflow.contractstatus.datasource.DSChangeContractStatus;
import com.pomplatform.client.workflow.contractstatus.datasource.DSContractStatus;
import com.pomplatform.client.workflow.contractstatus.panel.ContractStatusWorkflowViewProjectPanel;
import com.pomplatform.client.workflow.panel.MyCostAllocationDesignPanel;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.FloatItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.LinkItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;
import com.smartgwt.client.widgets.grid.ListGridField;

public class ContractStatusUpdateForm extends AbstractWizadPage
{


	private final TextItem contractLogIdItem;
	private final ComboBoxItem contractIdItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final FloatItem signingMoneySumItem;
	private final FloatItem revenueAmountItem;
	private final FloatItem invoiceAmountItem;
	private final FloatItem borrowMoneyItem;
	private final SelectItem originalStatusItem;
	private final SelectItem newStatusItem;
	private final TextAreaItem contentItem;
	private final TextAreaItem remarkItem;
	private final SelectItem operatorItem;
	private final DateTimeItem operateTimeItem;
	private final TextItem deleteFlagItem;
	private final ButtonItem viewProjectsItem;
	private final ButtonItem attachmentItem;
	private final TextItem attachmentIdItem;
	private final TextItem fileNameItem;
	private final LinkItem fileUrlItem;
	private String processName;
	private int contractId;
	private boolean canApply = true;

	public ContractStatusUpdateForm() {
		DSContractStatus ds = DSContractStatus.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		contractLogIdItem = new TextItem("contractLogId", "主键编码");
		contractLogIdItem.setDisabled(true);
		contractLogIdItem.setRequired(true);
		IsIntegerValidator contractLogIdValidator = new IsIntegerValidator();
		contractLogIdItem.setValidators(contractLogIdValidator);
		contractLogIdItem.hide();
		__formItems.add(contractLogIdItem);
		
		ListGridField contractIdField = new ListGridField("contractId");
		ListGridField contractCodeField = new ListGridField("contractCode");
		ListGridField contractNameField = new ListGridField("contractName");
		
		contractIdItem = new ComboBoxItem("contractId", "合同名称");
		contractIdItem.setChangeOnKeypress(false);
        contractIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
        contractIdItem.setOptionDataSource(DSChangeContractStatus.getInstance());
        contractIdItem.setValueField(contractIdField.getName());
        contractIdItem.setDisplayField(contractNameField.getName());
        contractIdItem.setPickListFields(contractCodeField, contractNameField);
        contractIdItem.setPickListWidth(700);
        contractIdItem.setCanEdit(false);
        __formItems.add(contractIdItem);
        contractIdItem.addChangedHandler(new ChangedHandler() {
        	
        	@Override
        	public void onChanged(ChangedEvent event) {
        		contractCodeItem.clearValue();
        		contractNameItem.clearValue();
        		if(null == event.getValue()) {
        			return;
        		}
        		Record r = contractIdItem.getSelectedRecord();
        		int id = BaseHelpUtils.getIntValue(event.getValue());
        		if(id == contractId) {
        			canApply = true;
        		}else if(BaseHelpUtils.getIntValue(r.getAttribute("workflowNum")) > 0) {
        			SC.say("该合同已有正在进行中的合同状态变更流程，无法再次发起合同状态变更流程");
        			canApply = false;
        		}else {
        			canApply = true;
        		}
        		contractCodeItem.setValue(r.getAttribute("contractCode"));
        		contractNameItem.setValue(r.getAttribute("contractName"));
        		originalStatusItem.setValue(r.getAttribute("contractStatus"));
        		signingMoneySumItem.setValue(new BigDecimal(r.getAttribute("signingMoneySum")));
        		revenueAmountItem.setValue(new BigDecimal(r.getAttribute("revenueAmount")));
        		invoiceAmountItem.setValue(new BigDecimal(r.getAttribute("invoiceAmount")));
        		borrowMoneyItem.setValue(new BigDecimal(r.getAttribute("borrowMoney")));
        		setNewContractStatus(event.getValue());
        	}
        });
		
		contractCodeItem = new TextItem("contractCode", "合同编号");
		__formItems.add(contractCodeItem);
		
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.hide();
		__formItems.add(contractNameItem);
		

		signingMoneySumItem = new FloatItem("signingMoneySum", "签约总金额");
		signingMoneySumItem.setCanEdit(false);
		signingMoneySumItem.setLength(18);
		signingMoneySumItem.setDecimalPad(2);
		signingMoneySumItem.setFormat("##,###,###,###,##0.00");
		__formItems.add(signingMoneySumItem);
		
		revenueAmountItem = new FloatItem("revenueAmount", "累积含税营收");
		revenueAmountItem.setCanEdit(false);
		revenueAmountItem.setLength(18);
		revenueAmountItem.setDecimalPad(2);
		revenueAmountItem.setFormat("##,###,###,###,##0.00");
		__formItems.add(revenueAmountItem);
		
		invoiceAmountItem = new FloatItem("invoiceAmount", "开票金额");
		invoiceAmountItem.setCanEdit(false);
		invoiceAmountItem.setLength(18);
		invoiceAmountItem.setDecimalPad(2);
		invoiceAmountItem.setFormat("##,###,###,###,##0.00");
		__formItems.add(invoiceAmountItem);
		
		borrowMoneyItem = new FloatItem("borrowMoney", "总回款金额");
		borrowMoneyItem.setCanEdit(false);
		borrowMoneyItem.setLength(18);
		borrowMoneyItem.setDecimalPad(2);
		borrowMoneyItem.setFormat("##,###,###,###,##0.00");
		__formItems.add(borrowMoneyItem);
		
		originalStatusItem = new SelectItem("originalStatus", "原始合同状态");
		originalStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_35"));
		__formItems.add(originalStatusItem);
		
		newStatusItem = new SelectItem("newStatus", "新合同状态");
		__formItems.add(newStatusItem);
		newStatusItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				int value = BaseHelpUtils.getIntValue(event.getValue());
				if(value == ClientStaticUtils.CONTRACT_STATUS_5 || value == ClientStaticUtils.CONTRACT_STATUS_8) {
					remarkItem.show();
				}else {
					remarkItem.hide();
				}
			}
		});
		
		contentItem = new TextAreaItem("content", "原因");
		contentItem.setRowSpan(3);
		__formItems.add(contentItem);
		
		remarkItem = new TextAreaItem("remark", "下一步计划");
		remarkItem.setRowSpan(3);
		remarkItem.hide();
		__formItems.add(remarkItem);
		
		operatorItem = new SelectItem("operator", "操作人");
		operatorItem.hide();
		__formItems.add(operatorItem);
		
		operateTimeItem = new DateTimeItem("operateTime", "操作时间");
		operateTimeItem.hide();
		__formItems.add(operateTimeItem);
		
		deleteFlagItem = new TextItem("deleteFlag", "删除状态");
		deleteFlagItem.hide();
		__formItems.add(deleteFlagItem);
		
		attachmentItem = new ButtonItem("attachment", "上传附件");
		attachmentItem.hide();
		attachmentItem.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				new CommonUploadWindow("上传附件", false, 500, null, 1, new UploadCallBack() {
					
					@Override
					public void execute(Map<String, Record> data) {
						for(String key : data.keySet()) {
							Record record = data.get(key);
							fileNameItem.setValue(record.getAttribute("fileName"));
							fileUrlItem.setValue(record.getAttribute("fileUrl"));
							attachmentIdItem.setValue(record.getAttribute("fileId"));
						}
					}
				});
			}
		});
		__formItems.add(attachmentItem);
		
		attachmentIdItem = new TextItem("attachmentId", "上传附件");
		attachmentIdItem.hide();
		__formItems.add(attachmentIdItem);
		
		fileNameItem = new TextItem("fileName", "附件名称");
		__formItems.add(fileNameItem);
		
		fileUrlItem = new LinkItem("附件路径");
		__formItems.add(fileUrlItem);
		
		viewProjectsItem = new ButtonItem("viewProjects", "查看该合同的所有订单信息");
		viewProjectsItem.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				int contractId = BaseHelpUtils.getIntValue(contractIdItem.getValue());
				if(contractId == 0) {
					SC.say("请先选择合同");
					return;
				}
				PopupWindow window = new PopupWindow();
				window.setWidth100();
				window.setHeight100();
				ContractStatusWorkflowViewProjectPanel panel = new ContractStatusWorkflowViewProjectPanel();
				panel.setContractId(contractId);
				panel.commonQuery();
				window.addMember(panel);
				window.centerInPage();
				window.show();
			}
		});
		__formItems.add(viewProjectsItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		contentItem.setColSpan(4);
		remarkItem.setColSpan(4);
		FormItem[] items = __form.getFields();
		for(FormItem item : items) {
			item.setWidth("*");
			item.setCanEdit(false);
		}
		addMember(__form);
	}

	@Override
	public void startEdit() {
		Record r = getRecord();
		if (r != null) {
			__form.editRecord(r);
			Criteria c = new Criteria();
			c.addCriteria("processType", MyCostAllocationDesignPanel.PROCESS_TYPE_64);
			if(ClientUtil.getPlateId() != ClientStaticUtils.PLATE_ID_17) {
				//运营中心的人员可以看到所有符合条件的合同，其他人只有大项目经理能看到自己的合同
				c.addCriteria("projectManager", ClientUtil.getUserId());
			}
	        contractIdItem.setPickListCriteria(c);
			contractId = BaseHelpUtils.getIntValue(r.getAttribute("contractId"));
			setNewContractStatus(contractId);
			Map<String, Object> params = new HashMap<>();
			params.put("contractId", contractId);
			DBDataSource.callOperation("NQ_ChangeContractStatus", params, new DSCallback() {
				
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0) {
						Record[] records = dsResponse.getData();
						if(records.length > 0) {
							Record r = records[0];
							signingMoneySumItem.setValue(new BigDecimal(r.getAttribute("signingMoneySum")));
			        		revenueAmountItem.setValue(new BigDecimal(r.getAttribute("revenueAmount")));
			        		invoiceAmountItem.setValue(new BigDecimal(r.getAttribute("invoiceAmount")));
			        		borrowMoneyItem.setValue(new BigDecimal(r.getAttribute("borrowMoney")));
						}
					}
				}
			});
			fileUrlItem.setValue(BaseHelpUtils.getString(r.getAttribute("fileUrl")));
			String operator = BaseHelpUtils.getString(r.getAttribute("operator"));
			String loginUser = ClientUtil.getUserId();
			if (BaseHelpUtils.isNullOrEmpty(processName) && operator.equals(loginUser)) {
				// 只允许发起者撤销修改数据
				contractIdItem.setCanEdit(true);
				contentItem.setCanEdit(true);
				remarkItem.setCanEdit(true);
				attachmentItem.setCanEdit(true);
				newStatusItem.setCanEdit(true);
				viewProjectsItem.setCanEdit(true);
				attachmentItem.show();
			}
			int newContractStatus = BaseHelpUtils.getIntValue(newStatusItem.getValue());
			if(newContractStatus == ClientStaticUtils.CONTRACT_STATUS_5 || newContractStatus == ClientStaticUtils.CONTRACT_STATUS_8) {
				remarkItem.show();
			}
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSContractStatus.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		if(!canApply) {
			SC.say("该合同已有正在进行中的合同状态变更流程，无法再次发起合同状态变更流程");
			return false;
		}
		if(BaseHelpUtils.isNullOrEmpty(newStatusItem.getValue())) {
			SC.say("新合同状态不能为空");
			return false;
		}
		if (BaseHelpUtils.isNullOrEmpty(contentItem.getValue())) {
			SC.say("原因不能为空");
			return false;
		}
		int newContractStatus = BaseHelpUtils.getIntValue(newStatusItem.getValue());
		if((newContractStatus == ClientStaticUtils.CONTRACT_STATUS_5 || newContractStatus == ClientStaticUtils.CONTRACT_STATUS_8) && BaseHelpUtils.isNullOrEmpty(remarkItem.getValue())) {
			SC.say("下一步计划不能为空");
			return false;
		}
		if(newContractStatus != ClientStaticUtils.CONTRACT_STATUS_14 && BaseHelpUtils.isNullOrEmpty(attachmentIdItem.getValue())) {
			SC.say("请上传附件依据");
			return false;
		}
		return true;
	}

	@Override
	public Map getValuesAsMap() {
		return __form.getValues();
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}
	
	public void setNewContractStatus(Object contractId) {
		int id = BaseHelpUtils.getIntValue(contractId);
		if(id == 0) {
			return;
		}
		Map<String, Object> params = new HashMap<>();
		params.put("optType", "getNewContractStatus");
		params.put("contractId", id);
		DBDataSource.callOperation("EP_ContractStatusProcessor", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					LinkedHashMap<String, String> map = new LinkedHashMap<>();
					if(records.length > 0) {
						for(Record r : records) {
							map.put(r.getAttribute("dicTypeValueId"), r.getAttribute("dicTypeValue"));
						}
					}
					newStatusItem.setValueMap(map);
				}else {
					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
	}

	public ButtonItem getAttachmentItem() {
		return attachmentItem;
	}

}
