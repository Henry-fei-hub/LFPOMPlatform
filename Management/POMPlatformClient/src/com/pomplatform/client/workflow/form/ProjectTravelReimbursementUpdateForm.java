package com.pomplatform.client.workflow.form;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.common.UploadReimbursementAttachments;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.panel.PersonnalMoneyManagePanel;
import com.pomplatform.client.workflow.datasource.DSProjectTravelReimbursement;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
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
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ProjectTravelReimbursementUpdateForm extends AbstractWizadPage
{


	private final TextItem travelReimbursementIdItem;
	private final TextItem travelReimbursementNoItem;
	private final TextItem processInstanceIdItem;
	private final TextItem titleItem;
	private final ComboBoxItem applicantItem;
	private final ComboBoxItem drafterItem;
	private final SelectItem departmentIdItem;
	private final ComboBoxItem projectIdItem;
	private final DateTimeItem reimbursementTimeItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final TextItem amountItem;
	private final CheckboxItem strikeABalanceItem;
	private final TextAreaItem remarkItem;
	private final DateTimeItem applyTimeItem;
	private final DateTimeItem completeTimeItem;
	private final TextItem attachmentItem;
	private final IntegerItem attachmentNumberItem;
	private final TextItem statusItem;
	private final TextItem codeItem;
	private final SelectItem companyIdItem;
	private final LinkedHashMap<Integer, String> projectMap = new LinkedHashMap<>();
	private VLayout vLayout;//表单+上传附件按钮
	private VLayout formLayout;//存放表单数据
	private HLayout warnLayout;//欠款的2个label
	private Label label1;//欠款Label
	private final Label label2;//欠款金额Label
	private int processId;

	public ProjectTravelReimbursementUpdateForm() {
		String employeeId = ClientUtil.getUserId();
		Map<String,String> map = new HashMap<>();
		map.put("employeeId", employeeId);
		
		DSProjectTravelReimbursement ds = DSProjectTravelReimbursement.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		travelReimbursementIdItem = new TextItem("travelReimbursementId", "差旅报销编码");
		travelReimbursementIdItem.setDisabled(true);
		travelReimbursementIdItem.setRequired(true);
		travelReimbursementIdItem.setHidden(true);
		IsIntegerValidator travelReimbursementIdValidator = new IsIntegerValidator();
		travelReimbursementIdItem.setValidators(travelReimbursementIdValidator);
		__formItems.add(travelReimbursementIdItem);
		
		travelReimbursementNoItem = new TextItem("travelReimbursementNo", "报销编号");
		travelReimbursementNoItem.setHidden(true);
		__formItems.add(travelReimbursementNoItem);
		
		processInstanceIdItem = new TextItem("processInstanceId", "流程编码");
		processInstanceIdItem.setHidden(true);
		__formItems.add(processInstanceIdItem);
		
		titleItem = new TextItem("title", "主题");
		titleItem.setLength(19);
		titleItem.setWidth("*");
		__formItems.add(titleItem);
		
		applicantItem = new ComboBoxItem("applicant", "申请人");
		applicantItem.setChangeOnKeypress(false);
		applicantItem.setValueMap(KeyValueManager.getValueMap("employees"));
		applicantItem.setWidth("*");
		applicantItem.setDisabled(true);
		applicantItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		__formItems.add(applicantItem);
		
		departmentIdItem = new SelectItem("departmentId", "报销部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setWidth("*");
		departmentIdItem.setDisabled(true);
		__formItems.add(departmentIdItem);
		
		//选择申请人的时候，联动关联其所在的部门
		applicantItem.addChangeHandler(new ChangeHandler() {
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
		KeyValueManager.loadValueMap("projects",projectIdItem);
		projectIdItem.setChangeOnKeypress(false);
		projectIdItem.setWidth("*");
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
		
		companyIdItem = new SelectItem("companyId", "归属部门");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.setWidth("*");
		__formItems.add(companyIdItem);
		
		codeItem = new TextItem("code", "编号");
		codeItem.setWidth("*");
		codeItem.setDisabled(true);
		__formItems.add(codeItem);
		
		drafterItem = new ComboBoxItem("drafter", "起草人");
		drafterItem.setChangeOnKeypress(false);
		drafterItem.setDisabled(true);
		drafterItem.setWidth("*");
		drafterItem.setHidden(true);
		drafterItem.setValueMap(KeyValueManager.getValueMap("employees"));
		__formItems.add(drafterItem);
		
		reimbursementTimeItem = new DateTimeItem("reimbursementTime", "报销时间");
		reimbursementTimeItem.setWidth("*");
		reimbursementTimeItem.setHidden(true);
		__formItems.add(reimbursementTimeItem);
		
		applyTimeItem = new DateTimeItem("applyTime", "申请时间");
		applyTimeItem.setWidth("*");
		applyTimeItem.setDisabled(true);
		applyTimeItem.setHidden(true);
		__formItems.add(applyTimeItem);
		
		startDateItem = new DateItem("startDate", "出差开始日期");
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);
		startDateItem.setUseMask(true);
		__formItems.add(startDateItem);
		
		attachmentNumberItem = new IntegerItem("attachmentNumber", "附件数量");
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
		
		endDateItem = new DateItem("endDate", "出差结束日期");
		endDateItem.setWidth("*");
		endDateItem.setUseTextField(true);
		endDateItem.setUseMask(true);
		__formItems.add(endDateItem);
		
		strikeABalanceItem = new CheckboxItem("strikeABalance", "冲账");
		__formItems.add(strikeABalanceItem);
		
		amountItem = new TextItem("amount", "报销金额");
		amountItem.setWidth("*");
		amountItem.setDisabled(true);
		__formItems.add(amountItem);
		
		remarkItem = new TextAreaItem("remark", "报销事由");
		remarkItem.setRowSpan(2);
		remarkItem.setColSpan(6);
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);
		
		completeTimeItem = new DateTimeItem("completeTime", "完成时间");
		completeTimeItem.setHidden(true);
		__formItems.add(completeTimeItem);
		
		statusItem = new TextItem("status", "状态");
		statusItem.setHidden(true);
		__formItems.add(statusItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(6);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		
		formLayout = new VLayout();
		formLayout.addMember(__form);
		warnLayout = new HLayout();
		warnLayout.setHeight(17);
		warnLayout.setWidth(150);
		warnLayout.setLayoutTopMargin(5);
		label1 = new Label("欠款：");
		label1.setWidth(40);
		label1.setHeight(15);
		
		warnLayout.addMember(label1);
		label2 = new Label();
		Map<String, Object> workflowMap = new HashMap<>();
		workflowMap.put("optType", "onGetEmployeeBorrowMoney");
		workflowMap.put("employeeId", applicantItem.getValue());
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
				panel.setEmployeeId(ClientUtil.checkAndGetIntValue(applicantItem.getValue()));
				panel.commonQuery();
				window.addMember(panel);
				window.centerInPage();
				window.show();
			}
		});
		formLayout.setWidth100();
		formLayout.setHeight("90%");
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
		HLayout tt = new HLayout();
		tt.addMember(warnLayout);
		tt.addMember(button);
		tt.addMember(uploadButton);
		tt.setMembersMargin(20);
		tt.setAlign(Alignment.RIGHT);
		vLayout.addMember(tt);
		addMember(vLayout);
	}

	@Override
	public void startEdit() {
		if (getRecord() != null) {
			__form.editRecord(getRecord());
			projectIdItem.setValue(getRecord().getAttribute("projectId"));
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSProjectTravelReimbursement.getInstance());
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
