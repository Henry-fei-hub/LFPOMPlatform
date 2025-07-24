package com.pomplatform.client.workflow.form;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.common.UploadReimbursementAttachments;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.panel.PersonnalMoneyManagePanel;
import com.pomplatform.client.workflow.datasource.DSProjectNormalReimbursementOfWorkflow;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.fields.events.KeyPressEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyPressHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ProjectNormalReimbursementOfWorkflowUpdateForm extends AbstractWizadPage
{
private static final Logger logger = Logger.getLogger("");

	private final TextItem projectNormalReimbursementIdItem;
	private final TextItem projectNormalReimbursementNoItem;
	private final TextItem processInstanceIdItem;
	private final TextItem applyEmployeeIdItem;
	private final ComboBoxItem employeeIdItem;
	private final SelectItem departmentIdItem;
	private final TextItem reimbursementNameItem;
	private final ComboBoxItem projectIdItem;
	private final TextItem contractCodeItem;
	private final DateTimeItem reimbursementTimeItem;
	private final SelectItem statusItem;
	private final TextItem amountItem;
	private final DateTimeItem applyTimeItem;
	private final DateTimeItem completeTimeItem;
	private final TextAreaItem remarkItem;
	private final CheckboxItem strikeABalanceItem;
	private final TextItem attachmentItem;
	private final IntegerItem attachmentNumberItem;
	private final TextItem codeItem;
	private final SelectItem companyIdItem;
	private VLayout vLayout;//表单+上传附件按钮
	private VLayout formLayout;//存放表单数据
	private HLayout warnLayout;//欠款的2个label
	private Label label1;//欠款Label
	private final Label label2;//欠款金额Label
	private final LinkedHashMap<Integer, String> projectMap = new LinkedHashMap<>();
	private int processId;

	public ProjectNormalReimbursementOfWorkflowUpdateForm() {
		String employeeId = ClientUtil.getUserId();
		Map<String,String> map = new HashMap<>();
		map.put("employeeId", employeeId);
		DSProjectNormalReimbursementOfWorkflow ds = DSProjectNormalReimbursementOfWorkflow.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		projectNormalReimbursementIdItem = new TextItem("projectNormalReimbursementId", "项目报销编码");
		projectNormalReimbursementIdItem.setHidden(true);
		__formItems.add(projectNormalReimbursementIdItem);
		
		projectNormalReimbursementNoItem = new TextItem("projectNormalReimbursementNo", "报销编号");
		projectNormalReimbursementNoItem.setHidden(true);
		__formItems.add(projectNormalReimbursementNoItem);
		
		processInstanceIdItem = new TextItem("processInstanceId", "流程编码");
		processInstanceIdItem.setHidden(true);
		__formItems.add(processInstanceIdItem);

		reimbursementNameItem = new TextItem("reimbursementName", "主题");
		reimbursementNameItem.setLength(19);
		reimbursementNameItem.setWidth("*");
		__formItems.add(reimbursementNameItem);
		
		codeItem = new TextItem("code", "编号");
		codeItem.setWidth("*");
		codeItem.setDisabled(true);
		__formItems.add(codeItem);

		employeeIdItem = new ComboBoxItem("employeeId", "报销人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setWidth("*");
		employeeIdItem.setDisabled(true);
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		__formItems.add(employeeIdItem);
		
		departmentIdItem = new SelectItem("departmentId", "报销部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setWidth("*");
		departmentIdItem.setDisabled(true);
		__formItems.add(departmentIdItem);
		
		//选择报销人之后，自动关联报销人所在的部门
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
		
		projectIdItem = new ComboBoxItem("project", "所属项目");
		projectIdItem.setChangeOnKeypress(false);
		projectIdItem.setWidth("*");
		KeyValueManager.loadValueMap("projects",projectIdItem);
		projectIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		projectIdItem.addKeyPressHandler( new KeyPressHandler() {
			@Override
			public void onKeyPress(final KeyPressEvent event) {
				if(event.getKeyName().equals("Enter")){
					final String value = projectIdItem.getValueAsString();
					Map<String, Object> map = new HashMap<>();
					map.put("projectName", value);
					DBDataSource.callOperation("EP_GetProjectByProjectName", map, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
								Record[] record = dsResponse.getData();
								projectMap.clear();
								for(Record obj : record){
									projectMap.put(obj.getAttributeAsInt("projectId"), obj.getAttribute("projectName"));
								}
								projectIdItem.setValueMap(projectMap);
							} else {
								SC.say("没有找到与关键字：【"+value+"】相匹配的项目");
							}
							event.cancel();
						}
					});
				}
				
			}
		});
		__formItems.add(projectIdItem);

		contractCodeItem = new TextItem("contractCode", "订单编号");
		contractCodeItem.setWidth("*");
		contractCodeItem.setDisabled(true);
//		contractCodeItem.setValueMap(KeyValueManager.getValueMap("project_contract_codes"));
		KeyValueManager.loadValueMap("project_contract_codes", contractCodeItem);
		__formItems.add(contractCodeItem);

		//选择项目之后，关联出项目的订单编号
		projectIdItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					contractCodeItem.setValue(event.getValue());
				}
			}
		});

		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setWidth("*");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		__formItems.add(companyIdItem);
		
		reimbursementTimeItem = new DateTimeItem("reimbursementTime", "报销时间");
		reimbursementTimeItem.setWidth("*");
		__formItems.add(reimbursementTimeItem);
		

		applyEmployeeIdItem = new TextItem("applyEmployeeId", "起草人");
		applyEmployeeIdItem.setWidth("*");
		applyEmployeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		applyEmployeeIdItem.setDisabled(true);
		applyEmployeeIdItem.setHidden(true);
		__formItems.add(applyEmployeeIdItem);
		
		applyTimeItem = new DateTimeItem("applyTime", "申请时间");
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
		
		attachmentItem = new TextItem("attachment", "附件");
		attachmentItem.setWidth("*");
		attachmentItem.setDisabled(true);
		__formItems.add(attachmentItem);
		
		strikeABalanceItem = new CheckboxItem("strikeABalance", "冲账");
		__formItems.add(strikeABalanceItem);
		
		statusItem = new SelectItem("status", "状态");
		statusItem.setHidden(true);
		__formItems.add(statusItem);
		
		amountItem = new TextItem("amount", "报销金额");
		amountItem.setWidth("*");
		amountItem.setDisabled(true);
		__formItems.add(amountItem);
		
		completeTimeItem = new DateTimeItem("completeTime", "完成时间");
		completeTimeItem.setHidden(true);
		__formItems.add(completeTimeItem);

		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setRowSpan(3);
		remarkItem.setColSpan(6);
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);
		
		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		
		formLayout = new VLayout();
		formLayout.addMember(__form);
		warnLayout = new HLayout();
		warnLayout.setHeight(17);
		label1 = new Label("欠款：");
		label1.setWidth(40);
		label1.setHeight(15);
		
		warnLayout.addMember(label1);
		label2 = new Label();
		Map<String, Object> workflowMap = new HashMap<>();
		workflowMap.put("optType", "onGetEmployeeBorrowMoney");
		workflowMap.put("employeeId", employeeIdItem.getValue());
		workflowMap.put("employeeMoneyManageId", 0);
		DBDataSource.callOperation("EP_OnWrokflowProcess", workflowMap, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					if(null != records && records.length > 0){
						Record record = records[0];
						label2.setContents(record.getAttribute("borrowMoney"));
					}
				}
			}
		});
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
				window.setTitle("账单明细");
				PersonnalMoneyManagePanel panel = new PersonnalMoneyManagePanel();
				panel.setEmployeeId(ClientUtil.checkAndGetIntValue(employeeIdItem.getValue()));
				panel.commonQuery();
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
				UploadReimbursementAttachments uploadPanel = new UploadReimbursementAttachments(null, DBDataSource.getServerURL("UP_UploadReimbursementAttachments"));
                uploadPanel.addDataEditedHandler(new DataEditedHandler() {
                    @Override
                    public void onDataEdited(DataEditEvent event) {
                        //上传附件确认函成功
                        attachmentItem.setValue(event.getData().getAttribute("attachmentUrl"));
                    }
                });
                uploadPanel.show();
			}
		});
		vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		vLayout.addMember(formLayout);
		vLayout.addMember(warnLayout);
		vLayout.addMember(button);
		vLayout.addMember(uploadButton);
		vLayout.setMembersMargin(20);
		addMember(vLayout);
	}

	@Override
	public void startEdit() {
		if (getRecord() != null) {
			__form.editRecord(getRecord());
			projectIdItem.setValue(getRecord().getAttribute("projectId"));
			contractCodeItem.setValue(getRecord().getAttribute("projectId"));
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSProjectNormalReimbursementOfWorkflow.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public Map getValuesAsMap() {
		Map map = __form.getValues();
		map.put("projectId", projectIdItem.getValue());
		map.remove("project");
		return map;
	}

	public void setProcessId(int processId) {
		this.processId = processId;
	}

}
