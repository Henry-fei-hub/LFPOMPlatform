package com.pomplatform.client.workflow.commonTravelReimbursement.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.management.datasource.DSSelectGridEmployeeValue;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.financialtransactionaccount.panel.TransDetailPanel;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridReceiveUnitValue;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.pomplatform.client.workflow.commonTravelReimbursement.datasource.DSTravelReimbursementWithDepartment;
import com.pomplatform.client.workflow.panel.ProcessBillListApplyPanel;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.TitleOrientation;
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
import com.smartgwt.client.widgets.form.fields.FloatItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.LinkItem;
import com.smartgwt.client.widgets.form.fields.PickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;

public class TravelReimbursementWithDepartmentNewForm extends AbstractWizadPage
{


	private final TextItem codeItem;
	private final TextItem processInstanceIdItem;
	private final TextItem titleItem;
	private final ComboBoxItem applicantItem;
	private final SelectItem drafterItem;
	private final SelectItem departmentIdItem;
	private final DateTimeItem reimbursementTimeItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final TextItem amountItem;
	private final CheckboxItem strikeABalanceItem;
	private final TextAreaItem remarkItem;
	private final DateTimeItem applyTimeItem;
	private final DateTimeItem completeTimeItem;
	private final LinkItem attachmentItem;
	private final TextItem attachmentIdItem;
	private final TextItem attachmentNameItem;
	private final TextItem attachmentNumberItem;
	private final TextItem statusItem;
	private final SelectItem companyIdItem;
	private final CheckboxItem isProjectItem;
	private final SelectItem currencyItem;
	private VLayout vLayout;//表单+上传附件按钮
	private VLayout formLayout;//存放表单数据
	private HLayout warnLayout;//欠款的2个label
	private Label label1;//欠款Label
	private final Label label2;//欠款金额Label
	private int processId;
	private final FloatItem whiteStripItem;
	private final CheckboxItem relatedToContractItem;
	private final TextItem contractAmountItem;
	private final ComboBoxItem receiveUnitIdItem;
	private final PickTreeItem purchaserDepartmentItem;
	private final ComboBoxItem purchaserItem;
	private final TextItem purchasingCategoryItem;
	private Integer accountId = null;

	private ProcessBillListApplyPanel pblPanel;
	
	private Tree tree = KeyValueManager.getTree("departments");

	public TravelReimbursementWithDepartmentNewForm() {
		String employeeId = ClientUtil.getUserId();
		Map<String,String> map = new HashMap<>();
		map.put("employeeId", employeeId);
		
		DSTravelReimbursementWithDepartment ds = DSTravelReimbursementWithDepartment.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		

		codeItem = new TextItem("code", "报销编号");
		codeItem.setHidden(true);
		__formItems.add(codeItem);
		
		processInstanceIdItem = new TextItem("processInstanceId", "流程编码");
		processInstanceIdItem.setHidden(true);
		__formItems.add(processInstanceIdItem);
		
		titleItem = new TextItem("title", "主题");
		titleItem.setRequired(true);
		titleItem.setWidth("*");
		__formItems.add(titleItem);
		
		drafterItem = new SelectItem("drafter", "起草人");
		drafterItem.setWidth("*");
		drafterItem.setDefaultValue(employeeId);
		drafterItem.setDisabled(true);
		drafterItem.setValueMap(KeyValueManager.getValueMap("employees"));
		__formItems.add(drafterItem);
		
		applicantItem = new ComboBoxItem("applicant", "报销人");
		applicantItem.setChangeOnKeypress(false);
		applicantItem.setValueMap(KeyValueManager.getValueMap("employees"));
		applicantItem.setDefaultValue(employeeId);
		applicantItem.setWidth("*");
		applicantItem.setDisabled(true);
		applicantItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		__formItems.add(applicantItem);
		
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
		
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setRequired(true);
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.setWidth("*");
		companyIdItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				loadFinancialData();
			}
		});
		__formItems.add(companyIdItem);
		
		applyTimeItem = new DateTimeItem("applyTime", "申请时间");
		applyTimeItem.setDefaultValue(new Date());
		applyTimeItem.setWidth("*");
		applyTimeItem.setDisabled(true);
		applyTimeItem.setHidden(false);
		__formItems.add(applyTimeItem);
		
		startDateItem = new DateItem("startDate", "出差开始日期");
		startDateItem.setRequired(true);
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);
		startDateItem.setUseMask(true);
		__formItems.add(startDateItem);
		
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if (null != startDateItem.getValue() && null != endDateItem.getValue()) {
					Date startDate = startDateItem.getValueAsDate();
					Date endDate = endDateItem.getValueAsDate();
					if (endDate.getTime() - startDate.getTime() < 0) {
						SC.warn("提示", "开始日期不能大于结束日期");
					}
				}
			}
		});
		
		reimbursementTimeItem = new DateTimeItem("reimbursementTime", "报销时间");
		reimbursementTimeItem.setHidden(true);
		__formItems.add(reimbursementTimeItem);
		
		endDateItem = new DateItem("endDate", "出差结束日期");
		endDateItem.setRequired(true);
		endDateItem.setWidth("*");
		endDateItem.setUseTextField(true);
		endDateItem.setUseMask(true);
		__formItems.add(endDateItem);
		
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if (null != startDateItem.getValue() && null != endDateItem.getValue()) {
					Date startDate = startDateItem.getValueAsDate();
					Date endDate = endDateItem.getValueAsDate();
					if (endDate.getTime() - startDate.getTime() < 0) {
						SC.warn("提示", "开始日期不能大于结束日期");
					}
				}
			}
		});
		
		attachmentNumberItem = new TextItem("attachmentNumber", "附件数量");
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
		
		amountItem = new TextItem("amount", "报销金额");
		amountItem.setWidth("*");
		amountItem.setDisabled(true);
		__formItems.add(amountItem);

		whiteStripItem = new FloatItem("whiteStrip", "白条金额");
		whiteStripItem.setLength(18);
		whiteStripItem.setDecimalPad(3);
		whiteStripItem.setWidth("*");
		whiteStripItem.setDefaultValue(0);
		whiteStripItem.setFormat("##,###,###,###,##0.00");
		whiteStripItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if (null != event.getValue()) {
					FormItem item = event.getItem();
					item.setValue(BaseHelpUtils.format(item.getValue(), 2));
				}
			}
		});
		__formItems.add(whiteStripItem);
		int departmentId = BaseHelpUtils.getIntValue(ClientUtil.getDepartmentId());
		if (departmentId == 10){
			whiteStripItem.setCanEdit(true);
		}else{
			whiteStripItem.setCanEdit(false);
		}

		currencyItem = new SelectItem("currency", "货币种类");
		currencyItem.setWidth("*");
		currencyItem.setDefaultValue(0);
		currencyItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_40"));
		__formItems.add(currencyItem);
		
		strikeABalanceItem = new CheckboxItem("strikeABalance", "冲账");
		__formItems.add(strikeABalanceItem);
		
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
		
		isProjectItem = new CheckboxItem("isProject", "是否是项目上的报销，默认false");
		isProjectItem.setHidden(true);
		__formItems.add(isProjectItem);
		
		relatedToContractItem = new CheckboxItem("relatedToContract", "本报销与合同或协议有关");
		relatedToContractItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(BaseHelpUtils.getBoolean(event.getValue())) {
					contractAmountItem.show();
					receiveUnitIdItem.show();
					purchaserDepartmentItem.show();
					purchaserItem.show();
					purchasingCategoryItem.show();
				}else {
					contractAmountItem.hide();
					contractAmountItem.clearValue();
					receiveUnitIdItem.hide();
					receiveUnitIdItem.clearValue();
					purchaserDepartmentItem.hide();
					purchaserDepartmentItem.clearValue();
					purchaserItem.hide();
					purchaserItem.clearValue();
					purchasingCategoryItem.hide();
					purchasingCategoryItem.clearValue();
				}
			}
		});
		__formItems.add(relatedToContractItem);
		
		contractAmountItem = new FloatItem("contractAmount", "合同金额");
		contractAmountItem.setLength(18);
		contractAmountItem.setDecimalPad(3);
		contractAmountItem.setWidth("*");
		contractAmountItem.setFormat("#,###,###,###,###,##0.00");
		contractAmountItem.hide();
		contractAmountItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if (null != event.getValue()) {
					FormItem item = event.getItem();
					item.setValue(BaseHelpUtils.format(item.getValue(), 2));
				}
			}
		});
		__formItems.add(contractAmountItem);
		
		ListGridField receiveUnitField = new ListGridField("receiveUnit");
		ListGridField bankAccountField = new ListGridField("bankAccount");
		ListGridField bankNameField = new ListGridField("bankName");
		receiveUnitIdItem= new ComboBoxItem("receiveUnitId", "供应商");
		receiveUnitIdItem.setChangeOnKeypress(false);
		receiveUnitIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		receiveUnitIdItem.setWidth("*");
		receiveUnitIdItem.hide();
		receiveUnitIdItem.setValueField("receiveUnitManageId");
		receiveUnitIdItem.setDisplayField("receiveUnit");
		receiveUnitIdItem.setPickListFields(receiveUnitField, bankNameField, bankAccountField);
		receiveUnitIdItem.setOptionDataSource(DSSelectGridReceiveUnitValue.getInstance());
		receiveUnitIdItem.setPickListWidth(700);
		__formItems.add(receiveUnitIdItem);
		
		purchaserDepartmentItem = new PickTreeItem("departmentTree", "采购人归属部门");
		purchaserDepartmentItem.setWidth("*");
		purchaserDepartmentItem.setCanSelectParentItems(true);
		purchaserDepartmentItem.setValueTree(KeyValueManager.getTree("departments"));	
		purchaserDepartmentItem.hide();
		purchaserDepartmentItem.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				if (null != event.getValue()) {
					String[] arr = BaseHelpUtils.getString(event.getValue()).split("/");
					if (arr.length <= 2) {
						event.cancel();
					}else if(arr.length > 4) {
						event.cancel();
						TreeNode[] nodes = tree.getAllNodes();
						for (TreeNode node : nodes) {
							if (node.getName().equals(arr[3])) {
								purchaserDepartmentItem.setValue(tree.getPath(node));
								break;
							}
						}
					}
				}
			}
		});
		__formItems.add(purchaserDepartmentItem);
		
		ListGridField employeeIdField = new ListGridField("employeeId");
		ListGridField employeeNoField = new ListGridField("employeeNo");
		ListGridField employeeNameField = new ListGridField("employeeName");
		ListGridField departmentIdField = new ListGridField("departmentId");
		KeyValueManager.loadValueMap("all_departments",departmentIdField);
		
        purchaserItem = new ComboBoxItem("purchaser", "采购人");
        purchaserItem.setTitleOrientation(TitleOrientation.TOP);
        purchaserItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
        purchaserItem.setChangeOnKeypress(false);
        purchaserItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
        purchaserItem.setValueField(employeeIdField.getName());
        purchaserItem.setDisplayField(employeeNameField.getName());
        purchaserItem.setPickListFields(departmentIdField, employeeNoField, employeeNameField);
        purchaserItem.setPickListWidth(500);
        //只查询出在职的员工
        Criteria employeeCondition = new Criteria();
        employeeCondition.addCriteria("status", 0);
        purchaserItem.setPickListCriteria(employeeCondition);
        purchaserItem.setWidth("*");
        purchaserItem.hide();
		__formItems.add(purchaserItem);
		
		purchasingCategoryItem = new TextItem("purchasingCategory", "采购类别");
		purchasingCategoryItem.setWidth("*");
		purchasingCategoryItem.hide();
		__formItems.add(purchasingCategoryItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		
		formLayout = new VLayout();
		formLayout.addMember(__form);
		warnLayout = new HLayout();
		warnLayout.setHeight(17);
		warnLayout.setWidth(150);
		warnLayout.setLayoutTopMargin(5);
		label1 = new Label("欠款：");
		label1.setWidth(45);
		label1.setHeight(15);
		
		warnLayout.addMember(label1);
		label2 = new Label();
		label2.setWidth100();
		label2.setHeight(15);
		label2.addStyleName("colorRed");
		warnLayout.addMember(label2);
		IButton button = new IButton("查看明细", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(null == accountId || null == companyIdItem.getValue()) {
					return;
				}
				PopupWindow window = new PopupWindow("账单明细");
				window.setWidth100();
				window.setHeight100();
				window.centerInPage();
				TransDetailPanel panel = new TransDetailPanel();
				panel.setAccountId(accountId.toString());
				panel.setCompanyId(companyIdItem.getValue().toString());
				panel.commonQuery();
				window.addMember(panel);
				window.show();
			}
		});
		formLayout.setWidth100();
		formLayout.setHeight100();
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
		HLayout tt = new HLayout();
		tt.addMember(warnLayout);
		tt.addMember(button);
		tt.addMember(uploadButton);
		tt.setMembersMargin(20);
		tt.setAlign(Alignment.RIGHT);
		tt.setHeight(30);
		vLayout.addMember(tt);
		addMember(vLayout);
	}

	@Override
	public boolean checkData() {
		if(__form.validate()){

			if(BaseHelpUtils.getBoolean(relatedToContractItem.getValue())) {
				if(BaseHelpUtils.isNullOrEmpty(contractAmountItem.getValue())) {
					SC.say("请填写合同金额");
					return false;
				}
				if(!(contractAmountItem.getValue() instanceof Number)) {
					SC.say("合同金额填写有误");
					return false;
				}
				if(BaseHelpUtils.isNullOrEmpty(receiveUnitIdItem.getValue())) {
					SC.say("请选择供应商");
					return false;
				}
				Record[] receiveUnitArr = pblPanel.getValuesAsRecords();
				if(null == receiveUnitArr || receiveUnitArr.length != 1 || BaseHelpUtils.getIntValue(receiveUnitArr[0].getAttribute("payFor")) != ClientStaticUtils.PAY_FOR_COMPANY || BaseHelpUtils.getIntValue(receiveUnitArr[0].getAttribute("employeeOrCompanyId")) != BaseHelpUtils.getIntValue(receiveUnitIdItem.getValue())) {
					SC.say("选择供应商与收款信息的供应商不一致");
					return false;
				}
				if(BaseHelpUtils.isNullOrEmpty(purchaserDepartmentItem.getValue())) {
					SC.say("请选择采购人归属部门");
					return false;
				}
				if(BaseHelpUtils.isNullOrEmpty(purchaserItem.getValue())) {
					SC.say("请选择采购人");
					return false;
				}
				if(BaseHelpUtils.isNullOrEmpty(purchasingCategoryItem.getValue())) {
					SC.say("请填写采购类别");
					return false;
				}
			}
			return true;
		}else{
			SC.say("请按系统填好对应信息");
			return false;
		}
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) { 
			Record record = getRecord();
			if(BaseHelpUtils.getBoolean(record.getAttribute("relatedToContract"))) {
				contractAmountItem.show();
				receiveUnitIdItem.show();
				purchaserDepartmentItem.show();
				purchaserItem.show();
				purchasingCategoryItem.show();
				if (!BaseHelpUtils.isNullOrEmpty(record.getAttribute("purchaserDepartment"))) {
					TreeNode[] nodes = tree.getAllNodes();
					String value = record.getAttribute("purchaserDepartment");
					for (TreeNode node : nodes) {
						if (node.getName().equals(value)) {
							record.setAttribute("departmentTree", tree.getPath(node));
							break;
						}
					}
				}
			}
			__form.editRecord(record);
		}else {
			__form.editNewRecord();
		}
		loadFinancialData();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSTravelReimbursementWithDepartment.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map map = __form.getValues();
		if (null != map && !map.isEmpty()) {
			for (Object key : map.keySet()) {
				if (key.toString().equals("departmentTree") && null != map.get(key)) {
					// 如果是部门的选择结果，则根据选择结果得到>=第三级部门的结果
					String[] paths = map.get(key).toString().split("/");
					int idx = paths.length - 1;
					if(paths.length > 4) {
						idx = 3;
					}
					map.put("purchaserDepartment", paths[idx]);
					break;
				}
			}
		}
		return map;
	}

	public void setProcessId(int processId) {
		this.processId = processId;
	}

	public ProcessBillListApplyPanel getPblPanel() {
		return pblPanel;
	}

	public void setPblPanel(ProcessBillListApplyPanel pblPanel) {
		this.pblPanel = pblPanel;
	}

	private void loadFinancialData() {
		if(BaseHelpUtils.isNullOrEmpty(companyIdItem.getValue())) {
			return;
		}
		//加载当前申请人欠款数
		Map param = new HashMap();
		param.put("employeeId", applicantItem.getValue());
		param.put("companyId", companyIdItem.getValue());
		param.put("optType", "onGetEmployeeBorrowMoney");
		DBDataSource.callOperation("EP_OnWrokflowProcess", param, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					if(null == records || records.length == 0) {
						return;
					}
					Record r = records[0];
					//获取人员借款当前欠款金额
					label2.setContents(r.getAttribute("standardDebit"));
					int id = BaseHelpUtils.getIntValue(r.getAttribute("financialTransactionAccountId"));
					if(id == 0) {
						accountId = null;
					}else {
						accountId = id;
					}
				} else {
					label2.setContents("");
					accountId = null;
					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
	}
}
