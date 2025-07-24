package com.pomplatform.client.workflow.commonNormalReimbursement.form;

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
import com.pomplatform.client.workflow.commonNormalReimbursement.datasource.DSNormalReimbursementWithDepartment;
import com.pomplatform.client.workflow.panel.ProcessBillListApplyPanel;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
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
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.FloatItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
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

public class NormalReimbursementWithDepartmentNewForm extends AbstractWizadPage {

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
	private final SelectItem currencyItem;
	private final SelectItem reimbursementTypeItem;
	private final SelectItem feeTypeItem;
	private VLayout vLayout;// 表单+上传附件按钮
	private VLayout formLayout;// 存放表单数据
	private HLayout warnLayout;// 欠款的2个label
	private Label label1;// 欠款Label
	private final Label label2;// 欠款金额Label
	private int processId;
	private Record initData;
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

	public NormalReimbursementWithDepartmentNewForm() {
		String employeeId = ClientUtil.getUserId();
		Map<String, String> map = new HashMap<>();
		map.put("employeeId", employeeId);

		DSNormalReimbursementWithDepartment ds = DSNormalReimbursementWithDepartment.getInstance();
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
					if (null != record && record.length > 0) {
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
				if (null == event.getValue() && ClientUtil.checkAndGetIntValue(event.getOldValue()) != ClientUtil
						.checkAndGetIntValue(event.getValue())) {
					departmentIdItem.clearValue();
				} else if (null != event.getValue() && ClientUtil.checkAndGetIntValue(event.getOldValue()) != ClientUtil
						.checkAndGetIntValue(event.getValue())) {
					Map<String, Object> map = new HashMap<>();
					map.put("optType", "departmentId");
					map.put("employeeId", event.getValue());
					DBDataSource.callOperation("EP_GetUserInfoById", map, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
								Record[] record = dsResponse.getData();
								if (null != record && record.length > 0) {
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
		companyIdItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				loadFinancialData();
			}
		});
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

		currencyItem = new SelectItem("currency", "货币种类");
		currencyItem.setWidth("*");
		currencyItem.setDefaultValue(0);
		currencyItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_40"));
		__formItems.add(currencyItem);

		feeTypeItem = new SelectItem("feeType", "报销费用类型");
		feeTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_86"));
		feeTypeItem.setWidth("*");
		feeTypeItem.setDefaultValue(0);
		__formItems.add(feeTypeItem);

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

		reimbursementTypeItem = new SelectItem("reimbursementType", "报销类型");
		reimbursementTypeItem.setWidth("*");
		reimbursementTypeItem.setRequired(true);
		reimbursementTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_246"));
		__formItems.add(reimbursementTypeItem);

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
		tt.setHeight(30);
		vLayout.addMember(tt);
		addMember(vLayout);
	}

	@Override
	public boolean checkData() {
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
			if(BaseHelpUtils.isNullOrEmpty(reimbursementTypeItem.getValue())) {
				SC.say("请选择报销类型");
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
	}

	@Override
	public void startEdit() {
		if (getRecord() != null) {
			Record record = getRecord();
			showItemByData(record);
			__form.editRecord(record);
		}else {
			__form.editNewRecord();
		}
		loadFinancialData();
		if(null != getInitData()){
			Integer optionType = initData.getAttributeAsInt("optionType");
			int budgetManagementId=BaseHelpUtils.getIntValue(initData.getAttribute("budgetManagementId"));
			if(optionType != null && optionType == 1){//进入复制发起流程
				Record record = getInitData();
				String businessId = record.getAttribute("businessId");
				Map params = new HashMap<>();
				params.put("projectNormalReimbursementId", businessId);
				DBDataSource.callOperation("ST_ProjectNormalReimbursement", "find", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						Record record1 = dsResponse.getData()[0];
						showItemByData(record1);
						Map map = record1.toMap();
						map.put("projectNormalReimbursementId", null);
						map.put("code" , null);
						map.put("processInstanceId" , null);
						map.put("completeTime" , null);
						map.put("attachment" , null);
						map.put("attachmentId" , null);
						map.put("attachmentName" , null);
						map.put("attachmentNumber" , null);
						map.put("applyTime", new Date());
						map.put("status", null);
						map.put("strikeABalance", null);
						map.put("isProject", null);
						map.put("deleteFlag", null);
						map.put("isCompleted", null);
						map.put("bePacked", null);
						map.put("feeType", null);
						__form.setValues(map);
					}
				});
			}else if(budgetManagementId>0) {
				
			}
			else{
				int compnayId = initData.getAttributeAsInt("companyId");
				int type = initData.getAttributeAsInt("type");
				Double amount = 0d;
				String typeStr = "";
				if(type == 1){
					typeStr = "工资";
					amount = initData.getAttributeAsDouble("shouldTotal");
				}else if(type == 2){
					typeStr = "项目奖金";
					amount = initData.getAttributeAsDouble("shouldBonus");
				}else if(type == 3){
					typeStr = "年终奖金";
					amount = initData.getAttributeAsDouble("shouldTotal");
				}
				int year = initData.getAttributeAsInt("year");
				String month = initData.getAttribute("month");
				
				amountItem.setValue(amount);
				companyIdItem.setValue(compnayId);
				
				String title = "";
				if(type == 1 || type == 2){
					title = year + "年" + month + "月" + typeStr + "发放(" + companyIdItem.getDisplayValue() + ")" ;
				}else{
					title = year + "年" + typeStr + "发放(" + companyIdItem.getDisplayValue() + ")" ;
				}
				reimbursementNameItem.setValue(title);
				remarkItem.setValue(title);
			}
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSNormalReimbursementWithDepartment.getInstance());
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

	public Record getInitData() {
		return initData;
	}

	public void setInitData(Record initData) {
		this.initData = initData;
	}

	public ProcessBillListApplyPanel getPblPanel() {
		return pblPanel;
	}

	public void setPblPanel(ProcessBillListApplyPanel pblPanel) {
		this.pblPanel = pblPanel;
	}
	
	public void showItemByData(Record record) {
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
	}
	
	private void loadFinancialData() {
		if(BaseHelpUtils.isNullOrEmpty(companyIdItem.getValue())) {
			return;
		}
		//加载当前申请人欠款数
		Map param = new HashMap();
		param.put("employeeId", employeeIdItem.getValue());
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
