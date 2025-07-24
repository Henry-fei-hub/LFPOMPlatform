package com.pomplatform.client.workflow.companyCommonNormalReimbursement.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.pomplatform.client.workflow.commonNormalReimbursement.datasource.DSNormalReimbursementWithDepartment;
import com.pomplatform.client.workflow.companyCommonNormalReimbursement.datasource.DSCompanyNormalReimbursement;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.LinkItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class CompanyNormalReimbursementNewForm extends AbstractWizadPage
{


	private final TextItem codeItem;
	private final TextItem processInstanceIdItem;
	private final TextItem applyEmployeeIdItem;
	private final SelectItem employeeIdItem;
	private final SelectItem departmentIdItem;
	private final TextItem reimbursementNameItem;
	private final DateTimeItem reimbursementTimeItem;
	private final TextItem statusItem;
	private final TextItem amountItem;
	private final DateTimeItem applyTimeItem;
	private final DateTimeItem completeTimeItem;
	private final TextAreaItem remarkItem;
	private final CheckboxItem strikeABalanceItem;
	private final LinkItem attachmentItem;
	private final TextItem attachmentIdItem;
	private final TextItem attachmentNameItem;
	private final TextItem attachmentNumberItem;
	private final SelectItem companyIdItem;
	private final CheckboxItem isProjectItem;
	private final ComboBoxItem receiveUnitManageIdItem;
	private VLayout vLayout;//表单+上传附件按钮
	private VLayout formLayout;//存放表单数据
	private HLayout warnLayout;//欠款的2个label
	private Label label1;//欠款Label
	private final Label label2;//欠款金额Label
	private int processId;

	public CompanyNormalReimbursementNewForm() {
		String employeeId = ClientUtil.getUserId();
		Map<String,String> map = new HashMap<>();
		map.put("employeeId", employeeId);
		
		DSCompanyNormalReimbursement ds = DSCompanyNormalReimbursement.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		codeItem = new TextItem("code", "报销编号");
		codeItem.setHidden(true);
		__formItems.add(codeItem);
		
		processInstanceIdItem = new TextItem("processInstanceId", "流程编码");
		processInstanceIdItem.setHidden(true);
		__formItems.add(processInstanceIdItem);
		
		reimbursementNameItem = new TextItem("reimbursementName", "主题");
		reimbursementNameItem.setWidth("*");
		__formItems.add(reimbursementNameItem);
		
		applyEmployeeIdItem = new TextItem("applyEmployeeId", "起草人");
		applyEmployeeIdItem.setDefaultValue(employeeId);
		applyEmployeeIdItem.setWidth("*");
		applyEmployeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		applyEmployeeIdItem.setDisabled(true);
		__formItems.add(applyEmployeeIdItem);
		
		employeeIdItem = new SelectItem("employeeId", "报销人");
		employeeIdItem.setDefaultValue(employeeId);
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setWidth("*");
		employeeIdItem.setDisabled(true);
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		__formItems.add(employeeIdItem);
		
		departmentIdItem = new SelectItem("departmentId", "报销人所在部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		map.put("optType", "departmentId");
		DBDataSource.callOperation("EP_GetUserInfoById", map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] record = dsResponse.getData();
					if(null != record && record.length > 0){
						departmentIdItem.setValue(record[0].getAttribute("departmentId"));
					}
				}
			}
		});
		departmentIdItem.setWidth("*");
		departmentIdItem.setDisabled(true);
		__formItems.add(departmentIdItem);
		
		employeeIdItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				if(null==event.getValue()&&ClientUtil.checkAndGetIntValue(event.getOldValue())!=ClientUtil.checkAndGetIntValue(event.getValue())){
					departmentIdItem.clearValue();
				}else if(null!=event.getValue()&&ClientUtil.checkAndGetIntValue(event.getOldValue())!=ClientUtil.checkAndGetIntValue(event.getValue())){
					Map<String,Object> map = new HashMap<>();
					map.put("optType", "departmentId");
					map.put("employeeId", event.getValue());
					DBDataSource.callOperation("EP_GetUserInfoById", map, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
								Record[] record = dsResponse.getData();
								if(null != record && record.length > 0){
									departmentIdItem.setValue(record[0].getAttribute("departmentId"));
								}
							}
						}
					});
				}
			}
		});
		
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setWidth("*");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		__formItems.add(companyIdItem);
		
		reimbursementTimeItem = new DateTimeItem("reimbursementTime", "报销时间");
		reimbursementTimeItem.setWidth("*");
		reimbursementTimeItem.setDefaultValue(new Date());
		__formItems.add(reimbursementTimeItem);
		
		statusItem = new TextItem("status", "状态");
		statusItem.setHidden(true);
		__formItems.add(statusItem);
		
		applyTimeItem = new DateTimeItem("applyTime", "申请时间");
		applyTimeItem.setDefaultValue(new Date());
		applyTimeItem.setWidth("*");
		applyTimeItem.setDisabled(true);
		applyTimeItem.setHidden(true);
		__formItems.add(applyTimeItem);
		
		attachmentNumberItem = new IntegerItem("attachmentNumber", "附件(张)");
		attachmentNumberItem.setWidth("*");
		attachmentNumberItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				attachmentNumberItem.setValue(ClientUtil.checkAndGetIntValue(event.getValue()));
			}
		});
		__formItems.add(attachmentNumberItem);

		attachmentItem = new LinkItem("attachment");
		attachmentItem.setWidth("*");
		attachmentItem.setCanEdit(false);
		__formItems.add(attachmentItem);
		
		attachmentIdItem = new TextItem("attachmentId", "附件ID");
		attachmentIdItem.setHidden(true);
		__formItems.add(attachmentIdItem);
		
		attachmentNameItem = new TextItem("attachmentName", "附件名称");
		attachmentNameItem.setHidden(true);
		__formItems.add(attachmentNameItem);
		
		completeTimeItem = new DateTimeItem("completeTime", "完成时间");
		completeTimeItem.setHidden(true);
		__formItems.add(completeTimeItem);
		
		amountItem = new TextItem("amount", "报销金额");
		amountItem.setWidth("*");
		amountItem.setDisabled(true);
		__formItems.add(amountItem);
		
		receiveUnitManageIdItem = new ComboBoxItem("receiveUnitManageId", "收款单位");
		receiveUnitManageIdItem.setWidth("*");
//		receiveUnitManageIdItem.setValue(KeyValueManager.getValueMap("receive_unit_manages_company"));
		KeyValueManager.loadValueMap("receive_unit_manages_company",receiveUnitManageIdItem);
		receiveUnitManageIdItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				int receiveUnitManageId = ClientUtil.checkAndGetIntValue(event.getValue());
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("receiveUnitManageId", receiveUnitManageId);
				params.put("opt_type", "getPayMoneySumMoney");
				DBDataSource.callOperation("EP_PayMoneyHistoryRecordProcessor", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						label2.setContents(data.toString());
					}
				});
				
			}
		});
		__formItems.add(receiveUnitManageIdItem);
		
		strikeABalanceItem = new CheckboxItem("strikeABalance", "冲账");
		__formItems.add(strikeABalanceItem);
		
		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setRowSpan(3);
		remarkItem.setColSpan(6);
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);
		
		isProjectItem = new CheckboxItem("isProject", "是否是项目上的报销，默认false");
		isProjectItem.setHidden(true);
		__formItems.add(isProjectItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		

		formLayout = new VLayout();
		formLayout.addMember(__form);
		warnLayout = new HLayout();
		warnLayout.setHeight(17);
		label1 = new Label("预付款：");
		label1.setWidth(60);
		label1.setHeight(15);
		
		warnLayout.addMember(label1);
		label2 = new Label("0");
//		Map<String, Object> workflowMap = new HashMap<>();
//		workflowMap.put("optType", "onGetEmployeeBorrowMoney");
//		workflowMap.put("employeeId", employeeIdItem.getValue());
//		workflowMap.put("employeeMoneyManageId", 0);
//		DBDataSource.callOperation("EP_OnWrokflowProcess", workflowMap, new DSCallback() {
//			@Override
//			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//				if (dsResponse.getStatus() >= 0) {
//					Record[] records = dsResponse.getData();
//					if(null != records && records.length > 0){
//						Record record = records[0];
//						label2.setContents(record.getAttribute("borrowMoney"));
//					}
//				}
//			}
//		});
		label2.setWidth100();
		label2.setHeight(15);
		label2.addStyleName("colorRed");
		warnLayout.addMember(label2);
		IButton button = new IButton("查看明细", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow window = new PopupWindow();
				window.setWidth("50%");
				window.setHeight("80%");
				window.setTitle("预付款明细");
				PayMoneyHistoryRecordPanel panel = new PayMoneyHistoryRecordPanel();
				panel.setReceiveUnitManageId(ClientUtil.checkAndGetIntValue(receiveUnitManageIdItem.getValue()));
				panel.load();
				window.addMember(panel);
				window.centerInPage();
				window.show();
			}
		});
		formLayout.setWidth100();
		formLayout.setHeight("80%");
		IButton uploadButton = new IButton("上传附件", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				new CommonUploadWindow("上传附件", false, 100, null, 1, new UploadCallBack() {
					
					@Override
					public void execute(Map<String, Record> data) {
						for(String key : data.keySet()) {
							String fileId = data.get(key).getAttribute("fileId");
							attachmentItem.setValue(data.get(key).getAttribute("fileUrl"));
							attachmentIdItem.setValue(fileId);
							String fileName = data.get(key).getAttribute("fileName");
							attachmentItem.setLinkTitle(fileName);
							attachmentNameItem.setValue(fileName);
						}
					}
				});
			}
		});
		vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		vLayout.addMember(formLayout);
		VLayout tt = new VLayout();
		tt.addMember(warnLayout);
		tt.addMember(button);
		tt.addMember(uploadButton);
		tt.setMembersMargin(20);
		vLayout.addMember(tt);
		addMember(vLayout);
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
		manager.setDataSource(DSNormalReimbursementWithDepartment.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}

	public void setProcessId(int processId) {
		this.processId = processId;
	}
}
